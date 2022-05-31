package com.repackage;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public a(AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_USER_BAN_PAY_HINT_CLICK));
            }
        }
    }

    public static void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, activity) == null) {
            if (activity == null) {
                activity = TbadkCoreApplication.getInst().getCurrentActivity();
            }
            if (activity == null || activity.isFinishing()) {
                return;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04e6, TBAlertConfig.OperateBtnStyle.MAIN);
            rq4 rq4Var = new rq4(activity);
            rq4Var.u(R.string.obfuscated_res_0x7f0f0f69);
            rq4Var.l(R.string.obfuscated_res_0x7f0f0f68);
            rq4Var.r(aVar);
            rq4Var.n(true);
            rq4Var.i(false);
            rq4Var.m(3);
            AlertDialog x = rq4Var.x();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_USER_BAN_PAY_HINT_SHOW));
            aVar.a(new a(x));
        }
    }
}
