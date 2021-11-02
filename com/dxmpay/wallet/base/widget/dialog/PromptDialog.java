package com.dxmpay.wallet.base.widget.dialog;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.model.ContentDialogModel;
import com.dxmpay.wallet.base.widget.dialog.view.ContentDialogAdapter;
/* loaded from: classes11.dex */
public class PromptDialog extends WalletDialog implements BaseDialogInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View.OnClickListener f62488a;

    /* renamed from: b  reason: collision with root package name */
    public final ContentDialogModel f62489b;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PromptDialog f62490e;

        public a(PromptDialog promptDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {promptDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62490e = promptDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62490e.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromptDialog(Context context) {
        super(context, ResUtils.style(context, "DxmEbpayPromptDialog"));
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
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62488a = new a(this);
        this.f62489b = new ContentDialogModel();
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            ContentDialogModel contentDialogModel = this.f62489b;
            contentDialogModel.defaultListener = this.f62488a;
            setAdapter(new ContentDialogAdapter(contentDialogModel));
        }
    }

    public void cancelNegativeBtnTextBold() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f62489b.negativeBtnTextBold = false;
        }
    }

    public void cancelPositiveBtnTextBold() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f62489b.positiveBtnTextBold = false;
        }
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.BaseDialogInterface
    public void hideButtons() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f62489b.hideButtons = true;
        }
    }

    public void hideMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f62489b.hideMessage = true;
        }
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.BaseDialogInterface
    public void hideNegativeButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f62489b.hideNegativeBtn = true;
        }
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.BaseDialogInterface
    public void hidePositiveButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f62489b.hidePositiveBtn = true;
        }
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.BaseDialogInterface
    public void hideTitle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f62489b.hideTitle = true;
        }
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.BaseDialogInterface
    public void hideTitleLine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void setDialogBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f62489b.dialogBackgound = i2;
        }
    }

    public void setMessage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f62489b.messageId = i2;
        }
    }

    public void setMessageBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f62489b.backgroundColor = i2;
        }
    }

    public void setMessageColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f62489b.messageColor = i2;
        }
    }

    public void setMessageTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f62489b.messageSize = i2;
        }
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.BaseDialogInterface
    public void setNegativeBtn(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            this.f62489b.negativeBtnClickListener = onClickListener;
        }
    }

    public void setNegativeBtnTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f62489b.negativeBtnTextColor = i2;
        }
    }

    public void setNegativeBtnTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f62489b.negativeBtnTextSize = i2;
        }
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.BaseDialogInterface
    public void setPositiveBtn(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) {
            this.f62489b.positiveBtnClickListener = onClickListener;
        }
    }

    public void setPositiveBtnTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.f62489b.positiveBtnTextColor = i2;
        }
    }

    public void setPositiveBtnTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.f62489b.positiveBtnTextSize = i2;
        }
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.BaseDialogInterface
    public void setTitleText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.f62489b.titleId = i2;
        }
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.BaseDialogInterface
    @Deprecated
    public void setTitleTextBackgroud(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
        }
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.BaseDialogInterface
    public void showCloseBtn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
        }
    }

    public void setMessage(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, charSequence) == null) {
            this.f62489b.message = charSequence;
        }
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.BaseDialogInterface
    public void setNegativeBtn(int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f62489b;
            contentDialogModel.negativeBtnClickListener = onClickListener;
            contentDialogModel.negativeBtnTextId = i2;
        }
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.BaseDialogInterface
    public void setPositiveBtn(int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048596, this, i2, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f62489b;
            contentDialogModel.positiveBtnClickListener = onClickListener;
            contentDialogModel.positiveBtnTextId = i2;
        }
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.BaseDialogInterface
    public void setTitleText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = getContext().getString(ResUtils.string(getContext(), "dxm_ebpay_tip"));
            }
            this.f62489b.title = str;
        }
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.BaseDialogInterface
    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f62489b;
            contentDialogModel.negativeBtnClickListener = onClickListener;
            contentDialogModel.negativeBtnText = str;
        }
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.BaseDialogInterface
    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, spannableString, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f62489b;
            contentDialogModel.positiveBtnClickListener = onClickListener;
            contentDialogModel.positiveBtnText = spannableString;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromptDialog(Context context, int i2) {
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
        this.f62488a = new a(this);
        this.f62489b = new ContentDialogModel();
        a();
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.BaseDialogInterface
    public void setNegativeBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, spannableString, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f62489b;
            contentDialogModel.negativeBtnClickListener = onClickListener;
            contentDialogModel.negativeBtnText = spannableString;
        }
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.BaseDialogInterface
    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f62489b;
            contentDialogModel.positiveBtnText = str;
            contentDialogModel.positiveBtnClickListener = onClickListener;
        }
    }
}
