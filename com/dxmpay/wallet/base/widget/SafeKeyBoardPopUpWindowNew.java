package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.ResUtils;
/* loaded from: classes2.dex */
public class SafeKeyBoardPopUpWindowNew extends SafeKeyBoardPopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Button btConfirm;
    public ImageButton q;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(SafeKeyBoardPopUpWindowNew safeKeyBoardPopUpWindowNew) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeKeyBoardPopUpWindowNew};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                EventBus eventBus = EventBus.getInstance();
                eventBus.getClass();
                EventBus.getInstance().post(new EventBus.Event(eventBus, "hide_keyboard_listener", null));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SafeKeyBoardPopUpWindowNew f53845e;

        public b(SafeKeyBoardPopUpWindowNew safeKeyBoardPopUpWindowNew) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeKeyBoardPopUpWindowNew};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53845e = safeKeyBoardPopUpWindowNew;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (TextUtils.isEmpty(editable)) {
                    this.f53845e.btConfirm.setEnabled(false);
                    return;
                }
                String obj = editable.toString();
                SafeKeyBoardEditText safeKeyBoardEditText = this.f53845e.mySafeEditText;
                if (safeKeyBoardEditText == null || safeKeyBoardEditText.getCheckFunc() == null) {
                    return;
                }
                this.f53845e.btConfirm.setEnabled(this.f53845e.mySafeEditText.getCheckFunc().check(obj));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || TextUtils.isEmpty(charSequence)) {
                return;
            }
            String charSequence2 = charSequence.toString();
            SafeKeyBoardEditText safeKeyBoardEditText = this.f53845e.mySafeEditText;
            if (safeKeyBoardEditText == null || safeKeyBoardEditText.getCheckFunc() == null) {
                return;
            }
            this.f53845e.btConfirm.setEnabled(this.f53845e.mySafeEditText.getCheckFunc().check(charSequence2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeKeyBoardPopUpWindowNew(Context context) {
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
        this.btConfirm = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "wallet_base_safekeyboard_confirm"));
        ImageButton imageButton = (ImageButton) this.contentView.findViewById(ResUtils.id(this.mContext, "wallet_base_safekeyboard_hide"));
        this.q = imageButton;
        imageButton.setOnClickListener(new a(this));
    }

    @Override // com.dxmpay.wallet.base.widget.SafeKeyBoardPopupWindow
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ResUtils.layout(this.mContext, this.miniMode ? "dxm_wallet_base_safekeyboard_popupwindow_new_mini" : "dxm_wallet_base_safekeyboard_popupwindow_new");
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.wallet.base.widget.SafeKeyBoardPopupWindow
    public void initKeyNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            super.initKeyNum(z);
            SafeKeyBoardEditText safeKeyBoardEditText = this.mySafeEditText;
            if (safeKeyBoardEditText != null) {
                String obj = safeKeyBoardEditText.getEditableText().toString();
                SafeKeyBoardEditText safeKeyBoardEditText2 = this.mySafeEditText;
                if (safeKeyBoardEditText2 != null && safeKeyBoardEditText2.getCheckFunc() != null) {
                    this.btConfirm.setEnabled(this.mySafeEditText.getCheckFunc().check(obj));
                }
            }
            this.mySafeEditText.addTextChangedListener(new b(this));
            this.btConfirm.setOnClickListener(this.mySafeEditText.getOnConfirmListener());
            this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "dxm_wallet_base_safekeyboard_numkey_selector"));
        }
    }

    @Override // com.dxmpay.wallet.base.widget.SafeKeyBoardPopupWindow
    public void setSafeEditTet(SafeKeyBoardEditText safeKeyBoardEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, safeKeyBoardEditText) == null) {
            super.setSafeEditTet(safeKeyBoardEditText);
            if (this.mySafeEditText != null) {
                String obj = safeKeyBoardEditText.getEditableText().toString();
                if (safeKeyBoardEditText.getCheckFunc() != null) {
                    this.btConfirm.setEnabled(safeKeyBoardEditText.getCheckFunc().check(obj));
                }
            }
        }
    }
}
