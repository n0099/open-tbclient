package i.a.a.e.k;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import i.a.a.e.o.c;
import i.a.a.e.o.d;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes2.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i.a.a.e.k.f f73152a;

    /* renamed from: b  reason: collision with root package name */
    public PayFlowType f73153b;

    /* renamed from: c  reason: collision with root package name */
    public i.a.a.e.l.a f73154c;

    /* renamed from: d  reason: collision with root package name */
    public i.a.a.e.l.a f73155d;

    /* loaded from: classes2.dex */
    public class a implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f73156a;

        public a(i iVar, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73156a = dialog;
        }

        @Override // i.a.a.e.o.c.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i.a.a.e.n.h.a(this.f73156a, PayDialogType.PAY_CONFIRM_FINISH_DIALOG);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f73157a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f73158b;

        public b(i iVar, f fVar, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, fVar, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73157a = fVar;
            this.f73158b = dialog;
        }

        @Override // i.a.a.e.o.d.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f73157a;
                if (fVar != null) {
                    fVar.b();
                }
                i.a.a.e.n.h.a(this.f73158b, PayDialogType.PAY_SHOW_GIFT_DIALOG);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements i.a.a.e.o.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f73159a;

        public c(i iVar, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73159a = fVar;
        }

        @Override // i.a.a.e.o.g.c
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("PayCampaignManager", "createPayGiftDialog cancel clickArea:" + cancelType);
                f fVar = this.f73159a;
                if (fVar != null) {
                    fVar.a(cancelType);
                }
            }
        }

        @Override // i.a.a.e.o.g.c
        public boolean b(DialogInterface dialogInterface) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements i.a.a.e.o.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f73160a;

        public d(i iVar, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73160a = eVar;
        }

        @Override // i.a.a.e.o.g.c
        public void a(CancelType cancelType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
                RLog.info("PayCampaignManager", "createConfirmFinishDialog cancel clickArea:" + cancelType);
                e eVar = this.f73160a;
                if (eVar != null) {
                    eVar.a(cancelType);
                }
            }
        }

        @Override // i.a.a.e.o.g.c
        public boolean b(DialogInterface dialogInterface) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(CancelType cancelType);
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a(CancelType cancelType);

        void b();
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayCampaignManager", "create PayCampaignManager:" + this);
    }

    public final Dialog a(Activity activity, String str, i.a.a.e.o.c cVar, e eVar, i.a.a.e.k.c cVar2, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{activity, str, cVar, eVar, cVar2, absViewEventHandler})) == null) {
            RLog.info("PayCampaignManager", "createConfirmFinishDialog");
            cVar2.f(absViewEventHandler, PayDialogType.PAY_CONFIRM_FINISH_DIALOG);
            return i.a.a.e.o.g.b.f73336b.e(activity, str, cVar.getContentView(), new d(this, eVar), absViewEventHandler, PayDialogType.PAY_CONFIRM_FINISH_DIALOG);
        }
        return (Dialog) invokeCommon.objValue;
    }

    public final Dialog b(Activity activity, String str, i.a.a.e.o.d dVar, f fVar, i.a.a.e.k.c cVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, str, dVar, fVar, cVar, absViewEventHandler})) == null) {
            RLog.info("PayCampaignManager", "createPayGiftDialog");
            cVar.f(absViewEventHandler, PayDialogType.PAY_SHOW_GIFT_DIALOG);
            return i.a.a.e.o.g.b.f73336b.e(activity, str, dVar.getContentView(), new c(this, fVar), absViewEventHandler, PayDialogType.PAY_SHOW_GIFT_DIALOG);
        }
        return (Dialog) invokeCommon.objValue;
    }

    public void c(i.a.a.e.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            RLog.info("PayCampaignManager", "setPayView: " + this);
            this.f73152a = fVar;
        }
    }

    public boolean d(Activity activity, e eVar, i.a.a.e.k.c cVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, eVar, cVar, absViewEventHandler)) == null) {
            RLog.info("PayCampaignManager", "showConfirmLeaveDialog mConfirmLeaveData:" + this.f73154c + " mPayFlowType:" + this.f73153b);
            if (this.f73153b != PayFlowType.DIOALOG_PAY_FLOW) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but not DIOALOG_PAY_FLOW ");
                return false;
            } else if (i.a.a.e.l.a.b(this.f73154c)) {
                RLog.info("PayCampaignManager", "showConfirmLeaveDialog but giftbag empty");
                return false;
            } else if (this.f73154c.c()) {
                RLog.info("PayCampaignManager", "showConfirmFinishDialog but hasShow");
                return false;
            } else {
                i.a.a.e.k.f fVar = this.f73152a;
                if (fVar == null) {
                    RLog.error("PayCampaignManager", "showConfirmFinishDialog error mPayView null", new Object[0]);
                    return false;
                }
                i.a.a.e.o.c d2 = fVar.d(activity);
                d2.setGiftBagsInfo(this.f73154c.a());
                d2.refreshView();
                this.f73154c.d(true);
                d2.setCallback(new a(this, a(activity, "", d2, eVar, cVar, absViewEventHandler)));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public boolean e(Activity activity, f fVar, i.a.a.e.k.c cVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, fVar, cVar, absViewEventHandler)) == null) {
            RLog.info("PayCampaignManager", "showPayGiftDialog mGiftPackageData:" + this.f73155d + " mPayFlowType:" + this.f73153b);
            if (this.f73153b != PayFlowType.DIOALOG_PAY_FLOW) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but not DIOALOG_PAY_FLOW ");
                return false;
            } else if (i.a.a.e.l.a.b(this.f73155d)) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but giftbag empty");
                return false;
            } else if (this.f73155d.c()) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but hasShow");
                return false;
            } else {
                i.a.a.e.k.f fVar2 = this.f73152a;
                if (fVar2 == null) {
                    RLog.error("PayCampaignManager", "showPayGiftDialog error mPayView null", new Object[0]);
                    return false;
                }
                i.a.a.e.o.d e2 = fVar2.e(activity);
                e2.setGiftBagsInfo(this.f73155d.a());
                e2.refreshView();
                this.f73155d.d(true);
                e2.setCallback(new b(this, fVar, b(activity, "", e2, fVar, cVar, absViewEventHandler)));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public void f(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, giftBagsInfo) == null) {
            RLog.info("PayCampaignManager", "updateConfirmLeaveData->1 confirmLeaveData:" + giftBagsInfo + " mPayFlowType:" + this.f73153b);
            g(giftBagsInfo, null, null);
        }
    }

    public void g(GiftBagsInfo giftBagsInfo, Activity activity, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, giftBagsInfo, activity, dialog) == null) {
            RLog.info("PayCampaignManager", "updateConfirmLeaveData->2 confirmLeaveData:" + giftBagsInfo + " mPayFlowType:" + this.f73153b);
            this.f73154c = new i.a.a.e.l.a(giftBagsInfo, false);
            i(activity, dialog);
        }
    }

    public void h(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, giftBagsInfo) == null) {
            RLog.info("PayCampaignManager", "updateGiftPackageData packageData:" + giftBagsInfo + " mPayFlowType:" + this.f73153b);
            this.f73155d = new i.a.a.e.l.a(giftBagsInfo, false);
        }
    }

    public final void i(Activity activity, Dialog dialog) {
        i.a.a.e.o.b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, dialog) == null) || dialog == null || activity == null) {
            return;
        }
        RLog.info("PayCampaignManager", "updatePayAmountTopView");
        View decorView = dialog.getWindow().getDecorView();
        if (decorView == null) {
            RLog.info("PayCampaignManager", "updateConfirmLeaveData contentView null");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) decorView.findViewById(i.a.a.e.d.ll_top);
        if (viewGroup == null) {
            RLog.info("PayCampaignManager", "updateConfirmLeaveData llTopContainer null");
        } else if (i.a.a.e.l.a.b(this.f73154c)) {
            viewGroup.removeAllViews();
            viewGroup.setVisibility(8);
        } else {
            i.a.a.e.k.f fVar = this.f73152a;
            if (fVar == null || (a2 = fVar.a(activity)) == null) {
                return;
            }
            a2.setGiftBagsInfo(this.f73154c.a());
            viewGroup.setVisibility(0);
            viewGroup.addView(a2.getContentView());
            a2.refreshView();
        }
    }

    public void j(PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, payFlowType) == null) {
            RLog.info("PayCampaignManager", "updatePayFlowType payFlowType:" + payFlowType);
            this.f73155d = null;
            this.f73154c = null;
            this.f73153b = payFlowType;
        }
    }
}
