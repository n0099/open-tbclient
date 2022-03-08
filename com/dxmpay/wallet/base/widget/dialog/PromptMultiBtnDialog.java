package com.dxmpay.wallet.base.widget.dialog;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.model.MultiBtnDialogModel;
import com.dxmpay.wallet.base.widget.dialog.view.MultiBtnDialogAdapter;
/* loaded from: classes7.dex */
public class PromptMultiBtnDialog extends WalletDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MultiBtnDialogModel f52596e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f52597f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PromptMultiBtnDialog f52598e;

        public a(PromptMultiBtnDialog promptMultiBtnDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {promptMultiBtnDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52598e = promptMultiBtnDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f52598e.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromptMultiBtnDialog(Context context) {
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
        this.f52596e = new MultiBtnDialogModel();
        this.f52597f = new a(this);
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MultiBtnDialogModel multiBtnDialogModel = this.f52596e;
            multiBtnDialogModel.defaultClickListener = this.f52597f;
            setAdapter(new MultiBtnDialogAdapter(multiBtnDialogModel));
        }
    }

    public void setFirstBtn(int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, onClickListener) == null) {
            MultiBtnDialogModel multiBtnDialogModel = this.f52596e;
            multiBtnDialogModel.firstBtnTextId = i2;
            multiBtnDialogModel.firstBtnClickListener = onClickListener;
        }
    }

    public void setFirstBtnTextBold() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f52596e.firstBtnTextBold = true;
        }
    }

    public void setMessage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f52596e.messageId = i2;
        }
    }

    public void setSecondBtn(int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, onClickListener) == null) {
            MultiBtnDialogModel multiBtnDialogModel = this.f52596e;
            multiBtnDialogModel.secondBtnTextId = i2;
            multiBtnDialogModel.secondBtnClickListener = onClickListener;
        }
    }

    public void setSecondBtnTextBold() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f52596e.secondBtnTextBold = true;
        }
    }

    public void setThirdBtn(int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, onClickListener) == null) {
            MultiBtnDialogModel multiBtnDialogModel = this.f52596e;
            multiBtnDialogModel.thirdBtnTextId = i2;
            multiBtnDialogModel.thirdBtnClickListener = onClickListener;
        }
    }

    public void setThirdBtnTextBold() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f52596e.thirdBtnTextBold = true;
        }
    }

    public void setTitleMessage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f52596e.titleId = i2;
        }
    }

    public void setMessage(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
            this.f52596e.message = charSequence;
        }
    }

    public void setTitleMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f52596e.titleText = str;
        }
    }

    public void setFirstBtn(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener) == null) {
            MultiBtnDialogModel multiBtnDialogModel = this.f52596e;
            multiBtnDialogModel.firstBtnText = str;
            multiBtnDialogModel.firstBtnClickListener = onClickListener;
        }
    }

    public void setSecondBtn(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, onClickListener) == null) {
            MultiBtnDialogModel multiBtnDialogModel = this.f52596e;
            multiBtnDialogModel.secondBtnText = str;
            multiBtnDialogModel.secondBtnClickListener = onClickListener;
        }
    }

    public void setThirdBtn(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, onClickListener) == null) {
            MultiBtnDialogModel multiBtnDialogModel = this.f52596e;
            multiBtnDialogModel.thirdBtnText = str;
            multiBtnDialogModel.thirdBtnClickListener = onClickListener;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromptMultiBtnDialog(Context context, int i2) {
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
        this.f52596e = new MultiBtnDialogModel();
        this.f52597f = new a(this);
        a();
    }
}
