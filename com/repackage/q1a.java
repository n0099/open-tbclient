package com.repackage;

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
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUIEventType;
import tv.athena.revenue.payui.model.PayFlowModel;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes7.dex */
public class q1a implements q0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public Context d;
    public t1a e;
    public PayUIKitConfig f;
    public g0a g;
    public n0a h;
    public k0a i;
    public SparseArray<Integer> j;
    public SparseArray<l0a> k;
    public SparseArray<PayFlowModel> l;

    public q1a(Context context, int i, int i2, t1a t1aVar, g0a g0aVar, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), t1aVar, g0aVar, payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "YYPayController";
        this.j = new SparseArray<>(2);
        this.k = new SparseArray<>();
        this.l = new SparseArray<>();
        this.a += "@" + hashCode();
        this.b = i;
        this.d = context;
        this.e = t1aVar;
        this.c = i2;
        this.g = g0aVar;
        this.f = payUIKitConfig;
        this.h = new m1a(i, i2, t1aVar, payUIKitConfig);
        this.i = new j1a(this.b, this.c, this.f, this.e);
        this.j.put(PayFlowType.DIOALOG_PAY_FLOW.getTypeId(), 0);
        this.j.put(PayFlowType.WALLET_PAY_FLOW.getTypeId(), 0);
        RLog.info(this.a, "create YYPayController:" + this + " appId:" + i + " userChannel:" + i2);
    }

    @Override // com.repackage.i0a
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

    @Override // com.repackage.q0a
    public synchronized boolean b(PayFlowType payFlowType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payFlowType)) == null) {
            synchronized (this) {
                l0a l0aVar = this.k.get(payFlowType.getTypeId());
                boolean z = true;
                if (l0aVar == null) {
                    String str = this.a;
                    RLog.info(str, "isReleasePayFlow payFlowHandler null return true payFlowType:" + payFlowType);
                    return true;
                } else if (payFlowType == PayFlowType.DIOALOG_PAY_FLOW) {
                    if (l0aVar.p() != PayDialogType.PAY_NONE_DIALOG) {
                        z = false;
                    }
                    int intValue = this.j.get(payFlowType.getTypeId()).intValue();
                    String str2 = this.a;
                    RLog.info(str2, "isReleasePayFlow  payFlowType:" + payFlowType + " activityCount:" + intValue + " payDialogType:" + l0aVar.p() + " release:" + z);
                    return z;
                } else {
                    int intValue2 = this.j.get(payFlowType.getTypeId()).intValue();
                    if (intValue2 != 0 || l0aVar.p() != PayDialogType.PAY_NONE_DIALOG) {
                        z = false;
                    }
                    String str3 = this.a;
                    RLog.info(str3, "isReleasePayFlow payFlowType:" + payFlowType + " activityCount:" + intValue2 + " PayDialogType:" + l0aVar.p() + " release:" + z);
                    return z;
                }
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.q0a
    public synchronized void c(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            synchronized (this) {
                RLog.info(this.a, "startWalletActivity");
                i(activity, null);
            }
        }
    }

    @Override // com.repackage.q0a
    public synchronized void d(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, bVar, iPayCallback) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "startPayChannelDialog viewParams:" + bVar);
                if (bVar == null) {
                    bVar = new IYYPayWayView.b();
                }
                PayFlowModel payFlowModel = this.l.get(PayFlowType.WALLET_PAY_FLOW.getTypeId());
                if (payFlowModel != null) {
                    bVar.d = payFlowModel.appCustomExpand;
                    bVar.g = payFlowModel.viewEventListener;
                    bVar.e = payFlowModel.clientInfoExpand;
                }
                String str2 = this.a;
                RLog.info(str2, "startPayChannelDialog payFlowModel:" + payFlowModel);
                l0a l0aVar = this.k.get(PayFlowType.WALLET_PAY_FLOW.getTypeId());
                if (l0aVar == null) {
                    RLog.error(this.a, "startPayChannelDialog error walletPayFlowHandler null", new Object[0]);
                } else {
                    l0aVar.a(activity, bVar, iPayCallback);
                }
            }
        }
    }

    @Override // com.repackage.q0a
    public synchronized void e(PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, payFlowType) == null) {
            synchronized (this) {
                l0a l0aVar = this.k.get(payFlowType.getTypeId());
                if (l0aVar != null) {
                    l0aVar.release();
                }
                this.k.remove(payFlowType.getTypeId());
                this.l.remove(payFlowType.getTypeId());
                n("releasePayFlow payFlowType:" + payFlowType + " payFlowHandler:" + l0aVar);
            }
        }
    }

    @Override // com.repackage.q0a
    public synchronized void f(String str, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, payFlowType) == null) {
            synchronized (this) {
                int intValue = this.j.get(payFlowType.getTypeId()).intValue();
                int i = intValue + 1;
                String str2 = this.a;
                RLog.info(str2, "payActivityVisitRecord name:" + str + " payFlowType:" + payFlowType.name() + " oldActivityCount:" + intValue + " newAcitivityCount:" + i);
                this.j.put(payFlowType.getTypeId(), Integer.valueOf(i));
            }
        }
    }

    @Override // com.repackage.q0a
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? b(PayFlowType.WALLET_PAY_FLOW) && b(PayFlowType.DIOALOG_PAY_FLOW) : invokeV.booleanValue;
    }

    @Override // com.repackage.q0a
    public synchronized void h(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, activity, viewParams, iPayCallback) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "startPayDialog viewParams:" + viewParams);
                l(PayFlowType.DIOALOG_PAY_FLOW);
                o(PayFlowType.DIOALOG_PAY_FLOW, viewParams);
                o1a.d(this.b, this.c, PayFlowType.DIOALOG_PAY_FLOW);
                l1a l1aVar = new l1a(this.d, this.b, this.c, this.g, this.h, this.i, new i1a(PayFlowType.DIOALOG_PAY_FLOW, this.h), PayFlowType.DIOALOG_PAY_FLOW, this.f);
                this.k.put(PayFlowType.DIOALOG_PAY_FLOW.getTypeId(), l1aVar);
                n("startPayDialog showPayAmountDialog");
                l1aVar.e(activity, iPayCallback, viewParams);
                b2a.b(this.b, this.c, PayUIEventType.purchaseshow);
            }
        }
    }

    @Override // com.repackage.q0a
    public synchronized void i(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, viewParams) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "startWalletActivity viewParams:" + viewParams);
                l(PayFlowType.WALLET_PAY_FLOW);
                o(PayFlowType.WALLET_PAY_FLOW, viewParams);
                o1a.d(this.b, this.c, PayFlowType.WALLET_PAY_FLOW);
                this.k.put(PayFlowType.WALLET_PAY_FLOW.getTypeId(), new l1a(this.d, this.b, this.c, this.g, this.h, this.i, new i1a(PayFlowType.WALLET_PAY_FLOW, this.h), PayFlowType.WALLET_PAY_FLOW, this.f));
                String e = w1a.e(this.f);
                n("startWalletActivity walletUrl:" + t2a.a(e));
                i2a.a(PayFlowType.WALLET_PAY_FLOW, this.b, this.c, this.f, activity, e, "我的钱包");
                b2a.b(this.b, this.c, PayUIEventType.walletshow);
            }
        }
    }

    @Override // com.repackage.q0a
    public synchronized void j(String str, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, payFlowType) == null) {
            synchronized (this) {
                int intValue = this.j.get(payFlowType.getTypeId()).intValue();
                int i = intValue - 1;
                RLog.info(this.a, "payActivityDestroyRecord name:" + str + " payFlowType:" + payFlowType.name() + " oldActivityCount:" + intValue + " newAcitivityCountt:" + i);
                this.j.put(payFlowType.getTypeId(), Integer.valueOf(i));
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
                payFlowModel.clientInfoExpand = viewParams.clientInfoExpand;
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
            e(payFlowType);
            if (payFlowType == PayFlowType.WALLET_PAY_FLOW) {
                o2a.c(this.d);
            } else if (payFlowType == PayFlowType.DIOALOG_PAY_FLOW) {
                o2a.b(this.d);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            RLog.info(this.a, "releaseAllPayFlow");
            e(PayFlowType.WALLET_PAY_FLOW);
            e(PayFlowType.DIOALOG_PAY_FLOW);
        }
    }

    public final synchronized void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            synchronized (this) {
                int size = this.k.size();
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
            PayFlowModel k = k(viewParams);
            String str2 = this.a;
            RLog.info(str2, "updatePayFlowModel payFlowModel :" + k);
            if (k != null) {
                this.l.put(payFlowType.getTypeId(), k);
            }
        }
    }

    @Override // com.repackage.q0a
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, windowParams) == null) {
            l0a l0aVar = this.k.get(PayFlowType.DIOALOG_PAY_FLOW.getTypeId());
            if (l0aVar != null && windowParams != null) {
                l0aVar.refreshWindow(windowParams);
            }
            String str = this.a;
            RLog.info(str, "refreshWindow windowParams:" + windowParams + " handler:" + l0aVar);
        }
    }

    @Override // com.repackage.q0a
    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                RLog.info(this.a, "release()");
                m();
                this.k.clear();
                this.l.clear();
            }
        }
    }
}
