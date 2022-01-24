package com.dxm.credit.marketdialog.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.dxm.credit.marketdialog.data.MarketDialogResponse;
import java.util.Arrays;
/* loaded from: classes3.dex */
public abstract class MarketBaseDialog extends Dialog implements c.e.b.a.c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View close;

    /* renamed from: e  reason: collision with root package name */
    public c.e.b.a.c.a f53550e;

    /* renamed from: f  reason: collision with root package name */
    public int f53551f;

    /* renamed from: g  reason: collision with root package name */
    public b f53552g;

    /* renamed from: h  reason: collision with root package name */
    public SharedPreferences f53553h;

    /* renamed from: i  reason: collision with root package name */
    public Context f53554i;
    public MarketDialogResponse.Dialog mData;
    public View mRootView;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarketBaseDialog f53555e;

        public a(MarketBaseDialog marketBaseDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marketBaseDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53555e = marketBaseDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || CheckUtils.isFastDoubleClick()) {
                return;
            }
            MarketDialogResponse.Dialog dialog = this.f53555e.mData;
            DXMSdkSAUtils.onEventWithValues("sdk_market_dialog_click_cancle", Arrays.asList(dialog.group_name, dialog.group_limit));
            this.f53555e.close();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        boolean a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketBaseDialog(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketBaseDialog(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketBaseDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), onCancelListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (DialogInterface.OnCancelListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || context == null) {
            return;
        }
        this.f53554i = context;
        this.f53553h = context.getSharedPreferences("pop_window_sign_record", 0);
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            dismiss();
        }
    }

    public void dealCloseButton() {
        MarketDialogResponse.Dialog dialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.close == null || (dialog = this.mData) == null) {
            return;
        }
        if ("1".equals(dialog.group_type)) {
            this.close.setVisibility(8);
            return;
        }
        this.close.setAlpha(0.5f);
        this.close.setVisibility(0);
        this.close.setOnClickListener(new a(this));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.dismiss();
            showNext();
        }
    }

    public void dismissOnly() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.dismiss();
            c.e.b.a.c.a aVar = this.f53550e;
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    @Override // c.e.b.a.c.b
    public final int getIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f53551f : invokeV.intValue;
    }

    public abstract boolean initViews();

    public boolean isInQueue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f53550e.e(this) : invokeV.booleanValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f53553h == null || this.mData == null) {
                return false;
            }
            b bVar = this.f53552g;
            return bVar == null || bVar.a();
        }
        return invokeV.booleanValue;
    }

    public void setData(MarketDialogResponse.Dialog dialog) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, dialog) == null) && this.mData == null) {
            this.mData = dialog;
        }
    }

    @Override // c.e.b.a.c.b
    public final void setHostQuene(c.e.b.a.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f53550e = aVar;
        }
    }

    public final void setIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f53551f = i2;
        }
    }

    public void setRule(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.f53552g = bVar;
        }
    }

    @Override // android.app.Dialog, c.e.b.a.c.b
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (isValid()) {
                if (isShowing()) {
                    return;
                }
                if (initViews()) {
                    dealCloseButton();
                    super.show();
                    return;
                }
            }
            dismiss();
        }
    }

    public final void showNext() {
        c.e.b.a.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (aVar = this.f53550e) == null) {
            return;
        }
        aVar.f();
    }

    public void showOnly() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (context = this.f53554i) == null || !(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        super.show();
    }
}
