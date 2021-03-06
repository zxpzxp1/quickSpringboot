/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.geekidea.springbootplus.system.controller;

import io.geekidea.springbootplus.config.properties.SpringBootPlusProperties;
import io.geekidea.springbootplus.framework.common.api.ApiResult;
import io.geekidea.springbootplus.framework.common.controller.BaseController;
import io.geekidea.springbootplus.framework.core.pagination.Paging;
import io.geekidea.springbootplus.framework.core.validator.groups.Add;
import io.geekidea.springbootplus.framework.core.validator.groups.Update;
import io.geekidea.springbootplus.framework.log.annotation.Module;
import io.geekidea.springbootplus.framework.log.annotation.OperationLog;
import io.geekidea.springbootplus.framework.log.enums.OperationLogType;
import io.geekidea.springbootplus.system.entity.SysUser;
import io.geekidea.springbootplus.system.param.sysuser.ResetPasswordParam;
import io.geekidea.springbootplus.system.param.sysuser.SysUserPageParam;
import io.geekidea.springbootplus.system.param.sysuser.UpdatePasswordParam;
import io.geekidea.springbootplus.system.param.sysuser.UploadHeadParam;
import io.geekidea.springbootplus.system.service.SysUserService;
import io.geekidea.springbootplus.system.vo.SysUserQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 * ???????????? ???????????????
 * </pre>
 *
 * @author geekidea
 * @since 2019-10-24
 */
@Slf4j
@RestController
@RequestMapping("/sysUser")
@Module("system")
@Api(value = "????????????API", tags = {"????????????"})
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SpringBootPlusProperties springBootPlusProperties;

    /**
     * ??????????????????
     */
    @PostMapping("/add")
    @RequiresPermissions("sys:user:add")
    @OperationLog(name = "??????????????????", type = OperationLogType.ADD)
    @ApiOperation(value = "??????????????????", response = ApiResult.class)
    public ApiResult<Boolean> addSysUser(@Validated(Add.class) @RequestBody SysUser sysUser) throws Exception {
        boolean flag = sysUserService.saveSysUser(sysUser);
        return ApiResult.result(flag);
    }

    /**
     * ??????????????????
     */
    @PostMapping("/update")
    @RequiresPermissions("sys:user:update")
    @OperationLog(name = "??????????????????", type = OperationLogType.UPDATE)
    @ApiOperation(value = "??????????????????", response = ApiResult.class)
    public ApiResult<Boolean> updateSysUser(@Validated(Update.class) @RequestBody SysUser sysUser) throws Exception {
        boolean flag = sysUserService.updateSysUser(sysUser);
        return ApiResult.result(flag);
    }

    /**
     * ??????????????????
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("sys:user:delete")
    @OperationLog(name = "??????????????????", type = OperationLogType.DELETE)
    @ApiOperation(value = "??????????????????", response = ApiResult.class)
    public ApiResult<Boolean> deleteSysUser(@PathVariable("id") Long id) throws Exception {
        boolean flag = sysUserService.deleteSysUser(id);
        return ApiResult.result(flag);
    }


    /**
     * ??????id??????????????????
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("sys:user:info:id")
    @OperationLog(name = "??????????????????", type = OperationLogType.INFO)
    @ApiOperation(value = "??????????????????", notes = "", response = SysUserQueryVo.class)
    public ApiResult<SysUserQueryVo> getSysUser(@PathVariable("id") Long id) throws Exception {
        SysUserQueryVo sysUserQueryVo = sysUserService.getSysUserById(id);
        return ApiResult.ok(sysUserQueryVo);
    }

    /**
     * ????????????????????????
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("sys:user:page")
    @OperationLog(name = "????????????????????????", type = OperationLogType.PAGE)
    @ApiOperation(value = "????????????????????????", response = SysUserQueryVo.class)
    public ApiResult<Paging<SysUserQueryVo>> getSysUserPageList(@Validated @RequestBody SysUserPageParam sysUserPageParam) throws Exception {
        Paging<SysUserQueryVo> paging = sysUserService.getSysUserPageList(sysUserPageParam);
        return ApiResult.ok(paging);
    }

    /**
     * ????????????
     */
    @PostMapping("/updatePassword")
    @RequiresPermissions("sys:user:update:password")
    @OperationLog(name = "????????????", type = OperationLogType.UPDATE)
    @ApiOperation(value = "????????????", response = ApiResult.class)
    public ApiResult<Boolean> updatePassword(@Validated @RequestBody UpdatePasswordParam updatePasswordParam) throws Exception {
        boolean flag = sysUserService.updatePassword(updatePasswordParam);
        return ApiResult.result(flag);
    }

    /**
     * ???????????????????????????
     */
    @PostMapping("/resetPassword")
    @RequiresPermissions("sys:user:reset:password")
    @OperationLog(name = "???????????????????????????", type = OperationLogType.UPDATE)
    @ApiOperation(value = "???????????????????????????", response = ApiResult.class)
    public ApiResult<Boolean> resetPassword(@Validated @RequestBody ResetPasswordParam resetPasswordParam) throws Exception {
        boolean flag = sysUserService.resetPassword(resetPasswordParam);
        return ApiResult.result(flag);
    }

    /**
     * ????????????
     */
    @PostMapping("/uploadHead")
    @RequiresPermissions("sys:user:update:head")
    @OperationLog(name = "????????????", type = OperationLogType.UPDATE)
    @ApiOperation(value = "????????????", response = ApiResult.class)
    public ApiResult<Boolean> uploadHead(@Validated @RequestBody UploadHeadParam uploadHeadParam) throws Exception {
        boolean flag = sysUserService.updateSysUserHead(uploadHeadParam.getId(), uploadHeadParam.getHead());
        return ApiResult.result(flag);
    }
}

