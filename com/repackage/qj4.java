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
/* loaded from: classes7.dex */
public class qj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pj4 a;
    public lr4 b;

    public qj4() {
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
        lr4 lr4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (lr4Var = this.b) == null) {
            return;
        }
        lr4Var.f();
        this.b = null;
    }

    public final void b(String str) {
        Activity currentActivity;
        TbPageContext c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || oi.isEmpty(str) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (c = c(currentActivity)) == null || StringUtils.isNull(str)) {
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

    public void d(pj4 pj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pj4Var) == null) {
            this.a = pj4Var;
        }
    }

    public void e() {
        pj4 pj4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (pj4Var = this.a) == null) {
            return;
        }
        int i = pj4Var.c;
        if (i == pj4.y) {
            lr4 h = lr4.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == pj4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            mn4 mn4Var = new mn4(currentActivity);
            mn4Var.d(currentActivity, this.a);
            mn4Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            ln4 b = ln4.b();
            ln4 b2 = ln4.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == pj4.A) {
            int i2 = pj4Var.d;
            if (i2 == pj4.D) {
                if (UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) || oi.isEmpty(this.a.k)) {
                    return;
                }
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            } else if (i2 != pj4.E || oi.isEmpty(pj4Var.k)) {
            } else {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i != pj4.B || TextUtils.isEmpty(pj4Var.e)) {
        } else {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            pj4 pj4Var2 = this.a;
            completeTaskToastData.activityId = pj4Var2.a;
            completeTaskToastData.missionId = pj4Var2.b;
            completeTaskToastData.duration = pj4Var2.i;
            completeTaskToastData.message = pj4Var2.e;
            completeTaskToastData.url = pj4Var2.k;
            completeTaskToastData.pageId = mi4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            s65.i(competeTaskEvent);
            pj4 pj4Var3 = this.a;
            rj4.c(pj4Var3.a, pj4Var3.b);
        }
    }
}
