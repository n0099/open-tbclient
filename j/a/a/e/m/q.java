package j.a.a.e.m;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UiEventType;
import tv.athena.revenue.payui.model.PayFlowModel;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes4.dex */
public class q implements j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f64720b;

    /* renamed from: c  reason: collision with root package name */
    public int f64721c;

    /* renamed from: d  reason: collision with root package name */
    public Context f64722d;

    /* renamed from: e  reason: collision with root package name */
    public j.a.a.e.n.b f64723e;

    /* renamed from: f  reason: collision with root package name */
    public PayUIKitConfig f64724f;

    /* renamed from: g  reason: collision with root package name */
    public k f64725g;

    /* renamed from: h  reason: collision with root package name */
    public i f64726h;

    /* renamed from: i  reason: collision with root package name */
    public e f64727i;

    /* renamed from: j  reason: collision with root package name */
    public SparseArray<Integer> f64728j;

    /* renamed from: k  reason: collision with root package name */
    public SparseArray<f> f64729k;
    public SparseArray<PayFlowModel> l;

    public q(Context context, int i2, int i3, j.a.a.e.n.b bVar, k kVar, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), bVar, kVar, payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "YYPayController";
        this.f64728j = new SparseArray<>(2);
        this.f64729k = new SparseArray<>();
        this.l = new SparseArray<>();
        this.a += "@" + hashCode();
        this.f64720b = i2;
        this.f64722d = context;
        this.f64723e = bVar;
        this.f64721c = i3;
        this.f64725g = kVar;
        this.f64724f = payUIKitConfig;
        this.f64726h = new p(i2, i3, bVar, payUIKitConfig);
        this.f64727i = new m(this.f64720b, this.f64721c, this.f64724f, this.f64723e);
        this.f64728j.put(PayFlowType.DIOALOG_PAY_FLOW.getTypeId(), 0);
        this.f64728j.put(PayFlowType.WALLET_PAY_FLOW.getTypeId(), 0);
        RLog.info(this.a, "create YYPayController:" + this + " appId:" + i2 + " userChannel:" + i3);
    }

    @Override // j.a.a.e.m.c
    public synchronized PayFlowModel a(PayFlowType payFlowType) {
        InterceptResult invokeL;
        PayFlowModel payFlowModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, payFlowType)) == null) {
            synchronized (this) {
                payFlowModel = this.l.get(payFlowType.getTypeId());
            }
            return payFlowModel;
        }
        return (PayFlowModel) invokeL.objValue;
    }

    @Override // j.a.a.e.m.j
    public synchronized void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            synchronized (this) {
                RLog.info(this.a, "startWalletActivity");
                i(activity, null);
            }
        }
    }

    @Override // j.a.a.e.m.j
    public synchronized void c(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, bVar, iPayCallback) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "startPayChannelDialog viewParams:" + bVar);
                if (bVar == null) {
                    bVar = new IYYPayWayView.b();
                }
                PayFlowModel payFlowModel = this.l.get(PayFlowType.WALLET_PAY_FLOW.getTypeId());
                if (payFlowModel != null) {
                    bVar.f65381c = payFlowModel.appCustomExpand;
                    bVar.f65383e = payFlowModel.viewEventListener;
                }
                String str2 = this.a;
                RLog.info(str2, "startPayChannelDialog payFlowModel:" + payFlowModel);
                f fVar = this.f64729k.get(PayFlowType.WALLET_PAY_FLOW.getTypeId());
                if (fVar == null) {
                    RLog.error(this.a, "startPayChannelDialog error walletPayFlowHandler null", new Object[0]);
                } else {
                    fVar.a(activity, bVar, iPayCallback);
                }
            }
        }
    }

    @Override // j.a.a.e.m.j
    public synchronized void d(PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, payFlowType) == null) {
            synchronized (this) {
                f fVar = this.f64729k.get(payFlowType.getTypeId());
                if (fVar != null) {
                    fVar.release();
                }
                this.f64729k.remove(payFlowType.getTypeId());
                this.l.remove(payFlowType.getTypeId());
                n("releasePayFlow payFlowType:" + payFlowType + " payFlowHandler:" + fVar);
            }
        }
    }

    @Override // j.a.a.e.m.j
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? g(PayFlowType.WALLET_PAY_FLOW) && g(PayFlowType.DIOALOG_PAY_FLOW) : invokeV.booleanValue;
    }

    @Override // j.a.a.e.m.j
    public synchronized void f(String str, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, payFlowType) == null) {
            synchronized (this) {
                int intValue = this.f64728j.get(payFlowType.getTypeId()).intValue();
                int i2 = intValue + 1;
                String str2 = this.a;
                RLog.info(str2, "payActivityVisitRecord name:" + str + " payFlowType:" + payFlowType.name() + " oldActivityCount:" + intValue + " newAcitivityCount:" + i2);
                this.f64728j.put(payFlowType.getTypeId(), Integer.valueOf(i2));
            }
        }
    }

    @Override // j.a.a.e.m.j
    public synchronized boolean g(PayFlowType payFlowType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, payFlowType)) == null) {
            synchronized (this) {
                f fVar = this.f64729k.get(payFlowType.getTypeId());
                boolean z = true;
                if (fVar == null) {
                    String str = this.a;
                    RLog.info(str, "shouldReleasePayFlow payFlowHandler null return true payFlowType:" + payFlowType);
                    return true;
                } else if (payFlowType == PayFlowType.DIOALOG_PAY_FLOW) {
                    if (fVar.n() != PayDialogType.PAY_NONE_DIALOG) {
                        z = false;
                    }
                    int intValue = this.f64728j.get(payFlowType.getTypeId()).intValue();
                    String str2 = this.a;
                    RLog.info(str2, "shouldReleasePayFlow  payFlowType:" + payFlowType + " activityCount:" + intValue + " payDialogType:" + fVar.n() + " shouldRelease" + z);
                    return z;
                } else {
                    int intValue2 = this.f64728j.get(payFlowType.getTypeId()).intValue();
                    if (intValue2 != 0 || fVar.n() != PayDialogType.PAY_NONE_DIALOG) {
                        z = false;
                    }
                    String str3 = this.a;
                    RLog.info(str3, "shouldReleasePayFlow payFlowType:" + payFlowType + " activityCount:" + intValue2 + " PayDialogType:" + fVar.n() + " shouldRelease:" + z);
                    return z;
                }
            }
        }
        return invokeL.booleanValue;
    }

    @Override // j.a.a.e.m.j
    public synchronized void h(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, activity, viewParams, iPayCallback) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "startPayDialog viewParams:" + viewParams);
                l(PayFlowType.DIOALOG_PAY_FLOW);
                o(PayFlowType.DIOALOG_PAY_FLOW, viewParams);
                j.a.a.e.a.d(this.f64720b, this.f64721c, PayFlowType.DIOALOG_PAY_FLOW);
                o oVar = new o(this.f64722d, this.f64720b, this.f64721c, this.f64725g, this.f64726h, this.f64727i, new l(PayFlowType.DIOALOG_PAY_FLOW, this.f64726h), PayFlowType.DIOALOG_PAY_FLOW, this.f64724f);
                this.f64729k.put(PayFlowType.DIOALOG_PAY_FLOW.getTypeId(), oVar);
                n("startPayDialog showPayAmountDialog");
                oVar.e(activity, iPayCallback, viewParams);
                j.a.a.e.o.b.b(this.f64720b, this.f64721c, UiEventType.purchaseshow);
            }
        }
    }

    @Override // j.a.a.e.m.j
    public synchronized void i(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, viewParams) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "startWalletActivity viewParams:" + viewParams);
                l(PayFlowType.WALLET_PAY_FLOW);
                o(PayFlowType.WALLET_PAY_FLOW, viewParams);
                j.a.a.e.a.d(this.f64720b, this.f64721c, PayFlowType.WALLET_PAY_FLOW);
                this.f64729k.put(PayFlowType.WALLET_PAY_FLOW.getTypeId(), new o(this.f64722d, this.f64720b, this.f64721c, this.f64725g, this.f64726h, this.f64727i, new l(PayFlowType.WALLET_PAY_FLOW, this.f64726h), PayFlowType.WALLET_PAY_FLOW, this.f64724f));
                String c2 = j.a.a.e.n.e.c(this.f64724f);
                n("startWalletActivity walletUrl:" + j.a.a.e.p.p.a(c2));
                j.a.a.e.p.f.a(PayFlowType.WALLET_PAY_FLOW, this.f64720b, this.f64721c, this.f64724f, activity, c2, "我的钱包");
                j.a.a.e.o.b.b(this.f64720b, this.f64721c, UiEventType.walletshow);
            }
        }
    }

    @Override // j.a.a.e.m.j
    public synchronized void j(String str, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, payFlowType) == null) {
            synchronized (this) {
                int intValue = this.f64728j.get(payFlowType.getTypeId()).intValue();
                int i2 = intValue - 1;
                RLog.info(this.a, "payActivityDestroyRecord name:" + str + " payFlowType:" + payFlowType.name() + " oldActivityCount:" + intValue + " newAcitivityCountt:" + i2);
                this.f64728j.put(payFlowType.getTypeId(), Integer.valueOf(i2));
            }
        }
    }

    public final PayFlowModel k(IYYPayAmountView.ViewParams viewParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewParams)) == null) {
            if (viewParams != null) {
                PayFlowModel payFlowModel = new PayFlowModel();
                payFlowModel.appCustomExpand = viewParams.appCustomExpand;
                payFlowModel.viewEventListener = viewParams.viewEventListener;
                String str = this.a;
                RLog.info(str, "createPayFlowModel PayFlowModel:" + payFlowModel);
                return payFlowModel;
            }
            RLog.info(this.a, "createPayFlowModel but viewParams null");
            return null;
        }
        return (PayFlowModel) invokeL.objValue;
    }

    public void l(PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, payFlowType) == null) {
            String str = this.a;
            RLog.info(str, "innerReleasePayFlow payFlowType:" + payFlowType);
            d(payFlowType);
            if (payFlowType == PayFlowType.WALLET_PAY_FLOW) {
                j.a.a.e.p.k.c(this.f64722d);
            } else if (payFlowType == PayFlowType.DIOALOG_PAY_FLOW) {
                j.a.a.e.p.k.b(this.f64722d);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            RLog.info(this.a, "releaseAllPayFlow");
            d(PayFlowType.WALLET_PAY_FLOW);
            d(PayFlowType.DIOALOG_PAY_FLOW);
        }
    }

    public final synchronized void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            synchronized (this) {
                int size = this.f64729k.size();
                int size2 = this.l.size();
                String str2 = this.a;
                RLog.info(str2, ("reportPayFlowMapSize from: " + str) + " payFlowHanderMapSize:" + size + " payFlowModelMapSize:" + size2);
            }
        }
    }

    public final void o(PayFlowType payFlowType, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, payFlowType, viewParams) == null) {
            String str = this.a;
            RLog.info(str, "updatePayFlowModel payFlowType :" + payFlowType + " viewParams:" + viewParams);
            if (viewParams == null) {
                RLog.info(this.a, "updatePayFlowModel with value null");
                this.l.put(payFlowType.getTypeId(), null);
                return;
            }
            PayFlowModel k2 = k(viewParams);
            String str2 = this.a;
            RLog.info(str2, "updatePayFlowModel payFlowModel :" + k2);
            if (k2 != null) {
                this.l.put(payFlowType.getTypeId(), k2);
            }
        }
    }

    @Override // j.a.a.e.m.j
    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                RLog.info(this.a, "release()");
                m();
                this.f64729k.clear();
                this.l.clear();
            }
        }
    }
}
