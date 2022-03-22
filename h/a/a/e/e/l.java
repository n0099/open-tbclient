package h.a.a.e.e;

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
import h.a.a.e.e.d;
import h.a.a.e.i.c;
import h.a.a.e.i.d;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes7.dex */
public class l implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i a;

    /* renamed from: b  reason: collision with root package name */
    public PayFlowType f45117b;

    /* renamed from: c  reason: collision with root package name */
    public h.a.a.e.f.a f45118c;

    /* renamed from: d  reason: collision with root package name */
    public h.a.a.e.f.a f45119d;

    /* loaded from: classes7.dex */
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

        @Override // h.a.a.e.i.c.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.a.a.e.h.h.a(this.a, PayDialogType.PAY_CONFIRM_FINISH_DIALOG);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f45120b;

        public b(l lVar, d.b bVar, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, bVar, dialog};
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
            this.f45120b = dialog;
        }

        @Override // h.a.a.e.i.d.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.b bVar = this.a;
                if (bVar != null) {
                    bVar.b();
                }
                h.a.a.e.h.h.a(this.f45120b, PayDialogType.PAY_SHOW_GIFT_DIALOG);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayCampaignManager", "create PayCampaignManager:" + this);
        this.f45117b = payFlowType;
        this.a = iVar;
    }

    @Override // h.a.a.e.e.d
    public GiftBagsInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            h.a.a.e.f.a aVar = this.f45118c;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        }
        return (GiftBagsInfo) invokeV.objValue;
    }

    @Override // h.a.a.e.e.d
    public boolean b(Activity activity, d.b bVar, f fVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bVar, fVar, absViewEventHandler)) == null) {
            RLog.info("PayCampaignManager", "showPayGiftDialog mGiftPackageData:" + this.f45119d + " mPayFlowType:" + this.f45117b);
            if (this.f45117b != PayFlowType.DIOALOG_PAY_FLOW) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but not DIOALOG_PAY_FLOW ");
                return false;
            } else if (h.a.a.e.f.a.b(this.f45119d)) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but giftbag empty");
                return false;
            } else if (this.f45119d.c()) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but hasShow");
                return false;
            } else {
                i iVar = this.a;
                if (iVar == null) {
                    RLog.error("PayCampaignManager", "showPayGiftDialog error mPayView null", new Object[0]);
                    return false;
                }
                h.a.a.e.i.d d2 = iVar.d(activity);
                d2.setGiftBagsInfo(this.f45119d.a());
                d2.refreshView();
                this.f45119d.d(true);
                d2.setCallback(new b(this, bVar, h(activity, "", d2, bVar, fVar, absViewEventHandler)));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // h.a.a.e.e.d
    public void c(ViewGroup viewGroup, Activity activity) {
        h.a.a.e.i.b c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, activity) == null) || viewGroup == null) {
            return;
        }
        if (h.a.a.e.f.a.b(this.f45118c)) {
            viewGroup.removeAllViews();
            return;
        }
        i iVar = this.a;
        if (iVar == null || (c2 = iVar.c(activity)) == null) {
            return;
        }
        viewGroup.removeAllViews();
        c2.setGiftBagsInfo(this.f45118c.a());
        viewGroup.addView(c2.getContentView());
        c2.refreshView();
    }

    @Override // h.a.a.e.e.d
    public void d(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, giftBagsInfo) == null) {
            RLog.info("PayCampaignManager", "updateConfirmLeaveData- confirmLeaveData:" + giftBagsInfo + " mPayFlowType:" + this.f45117b);
            this.f45118c = new h.a.a.e.f.a(giftBagsInfo, false);
        }
    }

    @Override // h.a.a.e.e.d
    public boolean e(Activity activity, d.a aVar, f fVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, aVar, fVar, absViewEventHandler)) == null) {
            RLog.info("PayCampaignManager", "showConfirmLeaveDialog mConfirmLeaveData:" + this.f45118c + " mPayFlowType:" + this.f45117b);
            if (this.f45117b != PayFlowType.DIOALOG_PAY_FLOW) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but not DIOALOG_PAY_FLOW ");
                return false;
            } else if (h.a.a.e.f.a.b(this.f45118c)) {
                RLog.info("PayCampaignManager", "showConfirmLeaveDialog but giftbag empty");
                return false;
            } else if (this.f45118c.c()) {
                RLog.info("PayCampaignManager", "showConfirmFinishDialog but hasShow");
                return false;
            } else {
                i iVar = this.a;
                if (iVar == null) {
                    RLog.error("PayCampaignManager", "showConfirmFinishDialog error mPayView null", new Object[0]);
                    return false;
                }
                h.a.a.e.i.c b2 = iVar.b(activity);
                b2.setGiftBagsInfo(this.f45118c.a());
                b2.refreshView();
                this.f45118c.d(true);
                b2.setCallback(new a(this, g(activity, "", b2, aVar, fVar, absViewEventHandler)));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // h.a.a.e.e.d
    public void f(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, giftBagsInfo) == null) {
            RLog.info("PayCampaignManager", "updateGiftPackageData packageData:" + giftBagsInfo + " mPayFlowType:" + this.f45117b);
            this.f45119d = new h.a.a.e.f.a(giftBagsInfo, false);
        }
    }

    public final Dialog g(Activity activity, String str, h.a.a.e.i.c cVar, d.a aVar, f fVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{activity, str, cVar, aVar, fVar, absViewEventHandler})) == null) {
            RLog.info("PayCampaignManager", "createConfirmFinishDialog");
            fVar.h(absViewEventHandler, PayDialogType.PAY_CONFIRM_FINISH_DIALOG);
            return h.a.a.e.i.g.c.f45242b.e(activity, str, cVar.getContentView(), new h.a.a.e.e.r.e(aVar), absViewEventHandler, PayDialogType.PAY_CONFIRM_FINISH_DIALOG, this.f45117b);
        }
        return (Dialog) invokeCommon.objValue;
    }

    public final Dialog h(Activity activity, String str, h.a.a.e.i.d dVar, d.b bVar, f fVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{activity, str, dVar, bVar, fVar, absViewEventHandler})) == null) {
            RLog.info("PayCampaignManager", "createPayGiftDialog");
            fVar.h(absViewEventHandler, PayDialogType.PAY_SHOW_GIFT_DIALOG);
            return h.a.a.e.i.g.c.f45242b.e(activity, str, dVar.getContentView(), new h.a.a.e.e.r.g(bVar), absViewEventHandler, PayDialogType.PAY_SHOW_GIFT_DIALOG, this.f45117b);
        }
        return (Dialog) invokeCommon.objValue;
    }
}
