package j.a.a.e.m;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import j.a.a.e.m.d;
import j.a.a.e.q.c;
import j.a.a.e.q.d;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes4.dex */
public class l implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i a;

    /* renamed from: b  reason: collision with root package name */
    public PayFlowType f64677b;

    /* renamed from: c  reason: collision with root package name */
    public j.a.a.e.n.a f64678c;

    /* renamed from: d  reason: collision with root package name */
    public j.a.a.e.n.a f64679d;

    /* loaded from: classes4.dex */
    public class a implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Dialog a;

        public a(l lVar, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dialog;
        }

        @Override // j.a.a.e.q.c.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j.a.a.e.p.h.a(this.a, PayDialogType.PAY_CONFIRM_FINISH_DIALOG);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f64680b;

        public b(l lVar, d.b bVar, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, bVar, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.f64680b = dialog;
        }

        @Override // j.a.a.e.q.d.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.b bVar = this.a;
                if (bVar != null) {
                    bVar.b();
                }
                j.a.a.e.p.h.a(this.f64680b, PayDialogType.PAY_SHOW_GIFT_DIALOG);
            }
        }
    }

    public l(PayFlowType payFlowType, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payFlowType, iVar};
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
        this.f64677b = payFlowType;
        this.a = iVar;
    }

    @Override // j.a.a.e.m.d
    public GiftBagsInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            j.a.a.e.n.a aVar = this.f64678c;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        }
        return (GiftBagsInfo) invokeV.objValue;
    }

    @Override // j.a.a.e.m.d
    public boolean b(Activity activity, d.b bVar, f fVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bVar, fVar, absViewEventHandler)) == null) {
            RLog.info("PayCampaignManager", "showPayGiftDialog mGiftPackageData:" + this.f64679d + " mPayFlowType:" + this.f64677b);
            if (this.f64677b != PayFlowType.DIOALOG_PAY_FLOW) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but not DIOALOG_PAY_FLOW ");
                return false;
            } else if (j.a.a.e.n.a.b(this.f64679d)) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but giftbag empty");
                return false;
            } else if (this.f64679d.c()) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but hasShow");
                return false;
            } else {
                i iVar = this.a;
                if (iVar == null) {
                    RLog.error("PayCampaignManager", "showPayGiftDialog error mPayView null", new Object[0]);
                    return false;
                }
                j.a.a.e.q.d d2 = iVar.d(activity);
                d2.setGiftBagsInfo(this.f64679d.a());
                d2.refreshView();
                this.f64679d.d(true);
                d2.setCallback(new b(this, bVar, h(activity, "", d2, bVar, fVar, absViewEventHandler)));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // j.a.a.e.m.d
    public void c(ViewGroup viewGroup, Activity activity) {
        j.a.a.e.q.b c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, activity) == null) || viewGroup == null) {
            return;
        }
        if (j.a.a.e.n.a.b(this.f64678c)) {
            viewGroup.removeAllViews();
            return;
        }
        i iVar = this.a;
        if (iVar == null || (c2 = iVar.c(activity)) == null) {
            return;
        }
        viewGroup.removeAllViews();
        c2.setGiftBagsInfo(this.f64678c.a());
        viewGroup.addView(c2.getContentView());
        c2.refreshView();
    }

    @Override // j.a.a.e.m.d
    public void d(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, giftBagsInfo) == null) {
            RLog.info("PayCampaignManager", "updateConfirmLeaveData- confirmLeaveData:" + giftBagsInfo + " mPayFlowType:" + this.f64677b);
            this.f64678c = new j.a.a.e.n.a(giftBagsInfo, false);
        }
    }

    @Override // j.a.a.e.m.d
    public boolean e(Activity activity, d.a aVar, f fVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, aVar, fVar, absViewEventHandler)) == null) {
            RLog.info("PayCampaignManager", "showConfirmLeaveDialog mConfirmLeaveData:" + this.f64678c + " mPayFlowType:" + this.f64677b);
            if (this.f64677b != PayFlowType.DIOALOG_PAY_FLOW) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but not DIOALOG_PAY_FLOW ");
                return false;
            } else if (j.a.a.e.n.a.b(this.f64678c)) {
                RLog.info("PayCampaignManager", "showConfirmLeaveDialog but giftbag empty");
                return false;
            } else if (this.f64678c.c()) {
                RLog.info("PayCampaignManager", "showConfirmFinishDialog but hasShow");
                return false;
            } else {
                i iVar = this.a;
                if (iVar == null) {
                    RLog.error("PayCampaignManager", "showConfirmFinishDialog error mPayView null", new Object[0]);
                    return false;
                }
                j.a.a.e.q.c b2 = iVar.b(activity);
                b2.setGiftBagsInfo(this.f64678c.a());
                b2.refreshView();
                this.f64678c.d(true);
                b2.setCallback(new a(this, g(activity, "", b2, aVar, fVar, absViewEventHandler)));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // j.a.a.e.m.d
    public void f(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, giftBagsInfo) == null) {
            RLog.info("PayCampaignManager", "updateGiftPackageData packageData:" + giftBagsInfo + " mPayFlowType:" + this.f64677b);
            this.f64679d = new j.a.a.e.n.a(giftBagsInfo, false);
        }
    }

    public final Dialog g(Activity activity, String str, j.a.a.e.q.c cVar, d.a aVar, f fVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{activity, str, cVar, aVar, fVar, absViewEventHandler})) == null) {
            RLog.info("PayCampaignManager", "createConfirmFinishDialog");
            fVar.h(absViewEventHandler, PayDialogType.PAY_CONFIRM_FINISH_DIALOG);
            return j.a.a.e.q.g.b.f64820b.e(activity, str, cVar.getContentView(), new j.a.a.e.m.r.e(aVar), absViewEventHandler, PayDialogType.PAY_CONFIRM_FINISH_DIALOG, this.f64677b);
        }
        return (Dialog) invokeCommon.objValue;
    }

    public final Dialog h(Activity activity, String str, j.a.a.e.q.d dVar, d.b bVar, f fVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{activity, str, dVar, bVar, fVar, absViewEventHandler})) == null) {
            RLog.info("PayCampaignManager", "createPayGiftDialog");
            fVar.h(absViewEventHandler, PayDialogType.PAY_SHOW_GIFT_DIALOG);
            return j.a.a.e.q.g.b.f64820b.e(activity, str, dVar.getContentView(), new j.a.a.e.m.r.g(bVar), absViewEventHandler, PayDialogType.PAY_SHOW_GIFT_DIALOG, this.f64677b);
        }
        return (Dialog) invokeCommon.objValue;
    }
}
