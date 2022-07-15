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
/* loaded from: classes6.dex */
public class pj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oj4 a;
    public kr4 b;

    public pj4() {
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
        kr4 kr4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (kr4Var = this.b) == null) {
            return;
        }
        kr4Var.f();
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

    public void d(oj4 oj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, oj4Var) == null) {
            this.a = oj4Var;
        }
    }

    public void e() {
        oj4 oj4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (oj4Var = this.a) == null) {
            return;
        }
        int i = oj4Var.c;
        if (i == oj4.y) {
            kr4 h = kr4.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == oj4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            ln4 ln4Var = new ln4(currentActivity);
            ln4Var.d(currentActivity, this.a);
            ln4Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            kn4 b = kn4.b();
            kn4 b2 = kn4.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == oj4.A) {
            int i2 = oj4Var.d;
            if (i2 == oj4.D) {
                if (UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) || oi.isEmpty(this.a.k)) {
                    return;
                }
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            } else if (i2 != oj4.E || oi.isEmpty(oj4Var.k)) {
            } else {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i != oj4.B || TextUtils.isEmpty(oj4Var.e)) {
        } else {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            oj4 oj4Var2 = this.a;
            completeTaskToastData.activityId = oj4Var2.a;
            completeTaskToastData.missionId = oj4Var2.b;
            completeTaskToastData.duration = oj4Var2.i;
            completeTaskToastData.message = oj4Var2.e;
            completeTaskToastData.url = oj4Var2.k;
            completeTaskToastData.pageId = li4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            r65.i(competeTaskEvent);
            oj4 oj4Var3 = this.a;
            qj4.c(oj4Var3.a, oj4Var3.b);
        }
    }
}
