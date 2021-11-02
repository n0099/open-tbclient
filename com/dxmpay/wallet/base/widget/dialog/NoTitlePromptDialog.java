package com.dxmpay.wallet.base.widget.dialog;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.model.ContentDialogModel;
import com.dxmpay.wallet.base.widget.dialog.view.NoTitleContentDialogAdapter;
/* loaded from: classes11.dex */
public class NoTitlePromptDialog extends WalletDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f62485e;

    /* renamed from: f  reason: collision with root package name */
    public final ContentDialogModel f62486f;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NoTitlePromptDialog f62487e;

        public a(NoTitlePromptDialog noTitlePromptDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {noTitlePromptDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62487e = noTitlePromptDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62487e.dismiss();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoTitlePromptDialog(Context context) {
        this(context, ResUtils.style(context, "DxmEbpayPromptDialog"));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ContentDialogModel contentDialogModel = this.f62486f;
            contentDialogModel.defaultListener = this.f62485e;
            setAdapter(new NoTitleContentDialogAdapter(contentDialogModel));
        }
    }

    public void hideButtons() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f62486f.hideButtons = true;
        }
    }

    public void hideNegativeButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f62486f.hideNegativeBtn = true;
        }
    }

    public void hidePositiveButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f62486f.hidePositiveBtn = true;
        }
    }

    public void setDialogBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f62486f.dialogBackgound = i2;
        }
    }

    public void setMessage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f62486f.messageId = i2;
        }
    }

    public void setMessageBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f62486f.backgroundColor = i2;
        }
    }

    public void setMessageTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f62486f.messageSize = i2;
        }
    }

    public void setNegativeBtn(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.f62486f.negativeBtnClickListener = onClickListener;
        }
    }

    public void setNegativeBtnTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f62486f.negativeBtnTextColor = i2;
        }
    }

    public void setNegativeBtnTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f62486f.negativeBtnTextSize = i2;
        }
    }

    public void setPositiveBtn(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            this.f62486f.positiveBtnClickListener = onClickListener;
        }
    }

    public void setPositiveBtnTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f62486f.positiveBtnTextColor = i2;
        }
    }

    public void setPositiveBtnTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f62486f.positiveBtnTextSize = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoTitlePromptDialog(Context context, int i2) {
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
        this.f62485e = new a(this);
        this.f62486f = new ContentDialogModel();
        a();
    }

    public void setMessage(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, charSequence) == null) {
            this.f62486f.message = charSequence;
        }
    }

    public void setNegativeBtn(int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f62486f;
            contentDialogModel.negativeBtnClickListener = onClickListener;
            contentDialogModel.negativeBtnTextId = i2;
        }
    }

    public void setPositiveBtn(int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f62486f;
            contentDialogModel.positiveBtnClickListener = onClickListener;
            contentDialogModel.positiveBtnTextId = i2;
        }
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f62486f;
            contentDialogModel.negativeBtnClickListener = onClickListener;
            contentDialogModel.negativeBtnText = str;
        }
    }

    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, spannableString, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f62486f;
            contentDialogModel.positiveBtnClickListener = onClickListener;
            contentDialogModel.positiveBtnText = spannableString;
        }
    }

    public void setNegativeBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, spannableString, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f62486f;
            contentDialogModel.negativeBtnClickListener = onClickListener;
            contentDialogModel.negativeBtnText = spannableString;
        }
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f62486f;
            contentDialogModel.positiveBtnText = str;
            contentDialogModel.positiveBtnClickListener = onClickListener;
        }
    }
}
