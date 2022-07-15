package com.repackage;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ox9;
import com.repackage.sz9;
import com.repackage.tz9;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes7.dex */
public class wx9 implements ox9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tx9 a;
    public PayFlowType b;
    public oy9 c;
    public oy9 d;

    /* loaded from: classes7.dex */
    public class a implements sz9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Dialog a;

        public a(wx9 wx9Var, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wx9Var, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dialog;
        }

        @Override // com.repackage.sz9.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gz9.a(this.a, PayDialogType.PAY_CONFIRM_FINISH_DIALOG);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements tz9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ox9.b a;
        public final /* synthetic */ Dialog b;

        public b(wx9 wx9Var, ox9.b bVar, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wx9Var, bVar, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.b = dialog;
        }

        @Override // com.repackage.tz9.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ox9.b bVar = this.a;
                if (bVar != null) {
                    bVar.b();
                }
                gz9.a(this.b, PayDialogType.PAY_SHOW_GIFT_DIALOG);
            }
        }
    }

    public wx9(PayFlowType payFlowType, tx9 tx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payFlowType, tx9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayCampaignManager", "create PayCampaignManager:" + this);
        this.b = payFlowType;
        this.a = tx9Var;
    }

    @Override // com.repackage.ox9
    public GiftBagsInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            oy9 oy9Var = this.c;
            if (oy9Var != null) {
                return oy9Var.a();
            }
            return null;
        }
        return (GiftBagsInfo) invokeV.objValue;
    }

    @Override // com.repackage.ox9
    public boolean b(Activity activity, ox9.b bVar, qx9 qx9Var, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bVar, qx9Var, absViewEventHandler)) == null) {
            RLog.info("PayCampaignManager", "showPayGiftDialog mGiftPackageData:" + this.d + " mPayFlowType:" + this.b);
            if (this.b != PayFlowType.DIOALOG_PAY_FLOW) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but not DIOALOG_PAY_FLOW ");
                return false;
            } else if (oy9.b(this.d)) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but giftbag empty");
                return false;
            } else if (this.d.c()) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but hasShow");
                return false;
            } else {
                tx9 tx9Var = this.a;
                if (tx9Var == null) {
                    RLog.error("PayCampaignManager", "showPayGiftDialog error mPayView null", new Object[0]);
                    return false;
                }
                tz9 d = tx9Var.d(activity);
                d.setGiftBagsInfo(this.d.a());
                d.refreshView();
                this.d.d(true);
                d.setCallback(new b(this, bVar, h(activity, "", d, bVar, qx9Var, absViewEventHandler)));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ox9
    public void c(ViewGroup viewGroup, Activity activity) {
        rz9 c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, activity) == null) || viewGroup == null) {
            return;
        }
        if (oy9.b(this.c)) {
            viewGroup.removeAllViews();
            return;
        }
        tx9 tx9Var = this.a;
        if (tx9Var == null || (c = tx9Var.c(activity)) == null) {
            return;
        }
        viewGroup.removeAllViews();
        c.setGiftBagsInfo(this.c.a());
        viewGroup.addView(c.getContentView());
        c.refreshView();
    }

    @Override // com.repackage.ox9
    public void d(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, giftBagsInfo) == null) {
            RLog.info("PayCampaignManager", "updateConfirmLeaveData- confirmLeaveData:" + giftBagsInfo + " mPayFlowType:" + this.b);
            this.c = new oy9(giftBagsInfo, false);
        }
    }

    @Override // com.repackage.ox9
    public boolean e(Activity activity, ox9.a aVar, qx9 qx9Var, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, aVar, qx9Var, absViewEventHandler)) == null) {
            RLog.info("PayCampaignManager", "showConfirmLeaveDialog mConfirmLeaveData:" + this.c + " mPayFlowType:" + this.b);
            if (this.b != PayFlowType.DIOALOG_PAY_FLOW) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but not DIOALOG_PAY_FLOW ");
                return false;
            } else if (oy9.b(this.c)) {
                RLog.info("PayCampaignManager", "showConfirmLeaveDialog but giftbag empty");
                return false;
            } else if (this.c.c()) {
                RLog.info("PayCampaignManager", "showConfirmFinishDialog but hasShow");
                return false;
            } else {
                tx9 tx9Var = this.a;
                if (tx9Var == null) {
                    RLog.error("PayCampaignManager", "showConfirmFinishDialog error mPayView null", new Object[0]);
                    return false;
                }
                sz9 b2 = tx9Var.b(activity);
                b2.setGiftBagsInfo(this.c.a());
                b2.refreshView();
                this.c.d(true);
                b2.setCallback(new a(this, g(activity, "", b2, aVar, qx9Var, absViewEventHandler)));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ox9
    public void f(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, giftBagsInfo) == null) {
            RLog.info("PayCampaignManager", "updateGiftPackageData packageData:" + giftBagsInfo + " mPayFlowType:" + this.b);
            this.d = new oy9(giftBagsInfo, false);
        }
    }

    public final Dialog g(Activity activity, String str, sz9 sz9Var, ox9.a aVar, qx9 qx9Var, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{activity, str, sz9Var, aVar, qx9Var, absViewEventHandler})) == null) {
            RLog.info("PayCampaignManager", "createConfirmFinishDialog");
            qx9Var.h(absViewEventHandler, PayDialogType.PAY_CONFIRM_FINISH_DIALOG);
            return b0a.b.e(activity, str, sz9Var.getContentView(), new gy9(aVar), absViewEventHandler, PayDialogType.PAY_CONFIRM_FINISH_DIALOG, this.b);
        }
        return (Dialog) invokeCommon.objValue;
    }

    public final Dialog h(Activity activity, String str, tz9 tz9Var, ox9.b bVar, qx9 qx9Var, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{activity, str, tz9Var, bVar, qx9Var, absViewEventHandler})) == null) {
            RLog.info("PayCampaignManager", "createPayGiftDialog");
            qx9Var.h(absViewEventHandler, PayDialogType.PAY_SHOW_GIFT_DIALOG);
            return b0a.b.e(activity, str, tz9Var.getContentView(), new iy9(bVar), absViewEventHandler, PayDialogType.PAY_SHOW_GIFT_DIALOG, this.b);
        }
        return (Dialog) invokeCommon.objValue;
    }
}
