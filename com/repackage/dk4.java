package com.repackage;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ck4 a;
    public vr4 b;

    public dk4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a() {
        vr4 vr4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (vr4Var = this.b) == null) {
            return;
        }
        vr4Var.f();
        this.b = null;
    }

    public final void b(String str) {
        Activity currentActivity;
        TbPageContext c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || li.isEmpty(str) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (c = c(currentActivity)) == null || StringUtils.isNull(str)) {
            return;
        }
        c.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", str, true)));
    }

    public final TbPageContext c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public void d(ck4 ck4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ck4Var) == null) {
            this.a = ck4Var;
        }
    }

    public void e() {
        ck4 ck4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (ck4Var = this.a) == null) {
            return;
        }
        int i = ck4Var.c;
        if (i == ck4.y) {
            vr4 h = vr4.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == ck4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            xn4 xn4Var = new xn4(currentActivity);
            xn4Var.d(currentActivity, this.a);
            xn4Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            wn4 b = wn4.b();
            wn4 b2 = wn4.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == ck4.A) {
            int i2 = ck4Var.d;
            if (i2 == ck4.D) {
                if (UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) || li.isEmpty(this.a.k)) {
                    return;
                }
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            } else if (i2 != ck4.E || li.isEmpty(ck4Var.k)) {
            } else {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i != ck4.B || TextUtils.isEmpty(ck4Var.e)) {
        } else {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            ck4 ck4Var2 = this.a;
            completeTaskToastData.activityId = ck4Var2.a;
            completeTaskToastData.missionId = ck4Var2.b;
            completeTaskToastData.duration = ck4Var2.i;
            completeTaskToastData.message = ck4Var2.e;
            completeTaskToastData.url = ck4Var2.k;
            completeTaskToastData.pageId = zi4.y().x();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            e65.i(competeTaskEvent);
            ck4 ck4Var3 = this.a;
            ek4.c(ck4Var3.a, ck4Var3.b);
        }
    }
}
