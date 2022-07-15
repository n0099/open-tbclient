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
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UiEventType;
import tv.athena.revenue.payui.model.PayFlowModel;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes5.dex */
public class by9 implements ux9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public Context d;
    public py9 e;
    public PayUIKitConfig f;
    public vx9 g;
    public tx9 h;
    public px9 i;
    public SparseArray<Integer> j;
    public SparseArray<qx9> k;
    public SparseArray<PayFlowModel> l;

    public by9(Context context, int i, int i2, py9 py9Var, vx9 vx9Var, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), py9Var, vx9Var, payUIKitConfig};
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
        this.e = py9Var;
        this.c = i2;
        this.g = vx9Var;
        this.f = payUIKitConfig;
        this.h = new ay9(i, i2, py9Var, payUIKitConfig);
        this.i = new xx9(this.b, this.c, this.f, this.e);
        this.j.put(PayFlowType.DIOALOG_PAY_FLOW.getTypeId(), 0);
        this.j.put(PayFlowType.WALLET_PAY_FLOW.getTypeId(), 0);
        RLog.info(this.a, "create YYPayController:" + this + " appId:" + i + " userChannel:" + i2);
    }

    @Override // com.repackage.nx9
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

    @Override // com.repackage.ux9
    public synchronized void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            synchronized (this) {
                RLog.info(this.a, "startWalletActivity");
                i(activity, null);
            }
        }
    }

    @Override // com.repackage.ux9
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
                    bVar.c = payFlowModel.appCustomExpand;
                    bVar.e = payFlowModel.viewEventListener;
                }
                String str2 = this.a;
                RLog.info(str2, "startPayChannelDialog payFlowModel:" + payFlowModel);
                qx9 qx9Var = this.k.get(PayFlowType.WALLET_PAY_FLOW.getTypeId());
                if (qx9Var == null) {
                    RLog.error(this.a, "startPayChannelDialog error walletPayFlowHandler null", new Object[0]);
                } else {
                    qx9Var.a(activity, bVar, iPayCallback);
                }
            }
        }
    }

    @Override // com.repackage.ux9
    public synchronized void d(PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, payFlowType) == null) {
            synchronized (this) {
                qx9 qx9Var = this.k.get(payFlowType.getTypeId());
                if (qx9Var != null) {
                    qx9Var.release();
                }
                this.k.remove(payFlowType.getTypeId());
                this.l.remove(payFlowType.getTypeId());
                n("releasePayFlow payFlowType:" + payFlowType + " payFlowHandler:" + qx9Var);
            }
        }
    }

    @Override // com.repackage.ux9
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? g(PayFlowType.WALLET_PAY_FLOW) && g(PayFlowType.DIOALOG_PAY_FLOW) : invokeV.booleanValue;
    }

    @Override // com.repackage.ux9
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

    @Override // com.repackage.ux9
    public synchronized boolean g(PayFlowType payFlowType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, payFlowType)) == null) {
            synchronized (this) {
                qx9 qx9Var = this.k.get(payFlowType.getTypeId());
                boolean z = true;
                if (qx9Var == null) {
                    String str = this.a;
                    RLog.info(str, "shouldReleasePayFlow payFlowHandler null return true payFlowType:" + payFlowType);
                    return true;
                } else if (payFlowType == PayFlowType.DIOALOG_PAY_FLOW) {
                    if (qx9Var.n() != PayDialogType.PAY_NONE_DIALOG) {
                        z = false;
                    }
                    int intValue = this.j.get(payFlowType.getTypeId()).intValue();
                    String str2 = this.a;
                    RLog.info(str2, "shouldReleasePayFlow  payFlowType:" + payFlowType + " activityCount:" + intValue + " payDialogType:" + qx9Var.n() + " shouldRelease" + z);
                    return z;
                } else {
                    int intValue2 = this.j.get(payFlowType.getTypeId()).intValue();
                    if (intValue2 != 0 || qx9Var.n() != PayDialogType.PAY_NONE_DIALOG) {
                        z = false;
                    }
                    String str3 = this.a;
                    RLog.info(str3, "shouldReleasePayFlow payFlowType:" + payFlowType + " activityCount:" + intValue2 + " PayDialogType:" + qx9Var.n() + " shouldRelease:" + z);
                    return z;
                }
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.ux9
    public synchronized void h(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, activity, viewParams, iPayCallback) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "startPayDialog viewParams:" + viewParams);
                l(PayFlowType.DIOALOG_PAY_FLOW);
                o(PayFlowType.DIOALOG_PAY_FLOW, viewParams);
                bx9.d(this.b, this.c, PayFlowType.DIOALOG_PAY_FLOW);
                zx9 zx9Var = new zx9(this.d, this.b, this.c, this.g, this.h, this.i, new wx9(PayFlowType.DIOALOG_PAY_FLOW, this.h), PayFlowType.DIOALOG_PAY_FLOW, this.f);
                this.k.put(PayFlowType.DIOALOG_PAY_FLOW.getTypeId(), zx9Var);
                n("startPayDialog showPayAmountDialog");
                zx9Var.e(activity, iPayCallback, viewParams);
                yy9.b(this.b, this.c, UiEventType.purchaseshow);
            }
        }
    }

    @Override // com.repackage.ux9
    public synchronized void i(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, viewParams) == null) {
            synchronized (this) {
                String str = this.a;
                RLog.info(str, "startWalletActivity viewParams:" + viewParams);
                l(PayFlowType.WALLET_PAY_FLOW);
                o(PayFlowType.WALLET_PAY_FLOW, viewParams);
                bx9.d(this.b, this.c, PayFlowType.WALLET_PAY_FLOW);
                this.k.put(PayFlowType.WALLET_PAY_FLOW.getTypeId(), new zx9(this.d, this.b, this.c, this.g, this.h, this.i, new wx9(PayFlowType.WALLET_PAY_FLOW, this.h), PayFlowType.WALLET_PAY_FLOW, this.f));
                String c = sy9.c(this.f);
                n("startWalletActivity walletUrl:" + oz9.a(c));
                ez9.a(PayFlowType.WALLET_PAY_FLOW, this.b, this.c, this.f, activity, c, "我的钱包");
                yy9.b(this.b, this.c, UiEventType.walletshow);
            }
        }
    }

    @Override // com.repackage.ux9
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
                jz9.c(this.d);
            } else if (payFlowType == PayFlowType.DIOALOG_PAY_FLOW) {
                jz9.b(this.d);
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

    @Override // com.repackage.ux9
    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                RLog.info(this.a, "release()");
                m();
                this.k.clear();
                this.l.clear();
            }
        }
    }
}
