package com.repackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.view.AbsPayMessageReceiver;
/* loaded from: classes6.dex */
public class g3a extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public AbsPayMessageReceiver b;
    public PayFlowType c;
    public Context d;
    public n3a e;

    /* loaded from: classes6.dex */
    public class a extends AbsPayMessageReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g3a this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g3a g3aVar, PayFlowType payFlowType) {
            super(payFlowType);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g3aVar, payFlowType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((PayFlowType) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = g3aVar;
        }

        @Override // tv.athena.revenue.payui.view.AbsPayMessageReceiver
        public void onAllPayFlowViewRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RLog.info(this.this$0.a, "onAllPayFlowViewRelease");
                this.this$0.dismiss();
            }
        }

        @Override // tv.athena.revenue.payui.view.AbsPayMessageReceiver
        public void onDialogPayFlowViewRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                RLog.info(this.this$0.a, "onDialogPayFlowViewRelease");
                this.this$0.dismiss();
            }
        }

        @Override // tv.athena.revenue.payui.view.AbsPayMessageReceiver
        public void onWalletPayFlowViewRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                RLog.info(this.this$0.a, "onWalletPayFlowViewRelease");
                this.this$0.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g3a(Context context, int i, PayFlowType payFlowType) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), payFlowType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "AutoHideSoftInputDialog";
        this.a += "@" + hashCode();
        this.d = context;
        this.c = payFlowType;
    }

    public void b(n3a n3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, n3aVar) == null) {
            this.e = n3aVar;
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus instanceof EditText) {
                ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
            if (w2a.a.a(this.d)) {
                super.dismiss();
            }
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            RLog.info(this.a, "onCreate");
            this.b = new a(this, this.c);
            q2a.d(getContext(), this.b);
        }
    }

    @Override // android.app.Dialog
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onStop();
            RLog.info(this.a, MissionEvent.MESSAGE_STOP);
            if (this.b != null) {
                q2a.e(getContext(), this.b);
                this.b = null;
            }
            this.e = null;
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            super.onWindowFocusChanged(z);
            n3a n3aVar = this.e;
            if (n3aVar != null) {
                n3aVar.a(this, z);
            }
        }
    }
}
