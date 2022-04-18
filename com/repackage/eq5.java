package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.RouterService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class eq5 implements ma0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AccountManagerService a;
    public AppInfoService b;
    public ToastService c;
    public RouterService d;

    public eq5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = (AccountManagerService) ServiceManager.getService(AccountManagerService.Companion.getSERVICE_REFERENCE());
        this.b = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.c = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
        this.d = (RouterService) ServiceManager.getService(RouterService.Companion.getSERVICE_REFERENCE());
    }

    @Override // com.repackage.ma0
    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) || this.c == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.c.showNormal(context, str, 0);
    }

    @Override // com.repackage.ma0
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AccountManagerService accountManagerService = this.a;
            return accountManagerService != null ? accountManagerService.getAccount().getUk() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.ma0
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            return skinType == 1 ? SkinManager.SKIN_TYPE_STR_NIGHT : skinType == 4 ? "dark" : Config.TRACE_VISIT_RECENT_DAY;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.ma0
    public String getCuid() {
        InterceptResult invokeV;
        AppInfoService appInfoService;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.a == null || (appInfoService = this.b) == null) ? "" : this.a.getSocialEncryption(appInfoService.getCuid(), "baiduuid_") : (String) invokeV.objValue;
    }

    @Override // com.repackage.ma0
    public String getIID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.repackage.ma0
    public void invokeScheme(Context context, String str) {
        RouterService routerService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) || context == null || TextUtils.isEmpty(str) || (routerService = this.d) == null) {
            return;
        }
        routerService.invokeScheme(context, str);
    }
}
