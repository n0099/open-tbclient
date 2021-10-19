package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
/* loaded from: classes9.dex */
public class WalletBaseEmptyView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f70060e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f70061f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f70062g;

    /* renamed from: h  reason: collision with root package name */
    public Button f70063h;

    /* renamed from: i  reason: collision with root package name */
    public View f70064i;

    /* renamed from: j  reason: collision with root package name */
    public View f70065j;
    public EmptyBtnClickListener k;
    public boolean l;

    /* loaded from: classes9.dex */
    public interface EmptyBtnClickListener {
        void onBtnClick();
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WalletBaseEmptyView f70066e;

        public a(WalletBaseEmptyView walletBaseEmptyView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {walletBaseEmptyView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70066e = walletBaseEmptyView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f70066e.k == null) {
                return;
            }
            if (this.f70066e.l) {
                this.f70066e.showLoadingPage(true);
            }
            this.f70066e.k.onBtnClick();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletBaseEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(ResUtils.layout(context, "dxm_wallet_base_empty_layout"), this);
            this.f70060e = (ImageView) findViewById(ResUtils.id(context, "empty_image"));
            this.f70061f = (TextView) findViewById(ResUtils.id(context, "empty_tip_1"));
            this.f70062g = (TextView) findViewById(ResUtils.id(context, "empty_tip_2"));
            this.f70063h = (Button) findViewById(ResUtils.id(context, "reload_btn"));
            this.f70064i = findViewById(ResUtils.id(context, "progress_layout"));
            this.f70065j = findViewById(ResUtils.id(context, "reload_layout"));
            this.f70063h.setOnClickListener(new a(this));
        }
    }

    public void setRetryBtnVisiablity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f70063h.setVisibility(i2);
        }
    }

    public void setShowLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.l = z;
        }
    }

    public void setonEmptyListener(EmptyBtnClickListener emptyBtnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, emptyBtnClickListener) == null) {
            this.k = emptyBtnClickListener;
        }
    }

    public void showLoadingPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.f70064i.setVisibility(0);
                this.f70065j.setVisibility(8);
                return;
            }
            this.f70064i.setVisibility(8);
            this.f70065j.setVisibility(0);
        }
    }

    public void showOnlyTip1(int i2, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, charSequence) == null) {
            showLoadingPage(false);
            this.f70060e.setBackgroundResource(i2);
            this.f70061f.setText(charSequence);
            this.f70062g.setVisibility(4);
            this.f70063h.setVisibility(8);
        }
    }

    public void showTip1_NextBtn(int i2, CharSequence charSequence, CharSequence charSequence2, EmptyBtnClickListener emptyBtnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), charSequence, charSequence2, emptyBtnClickListener}) == null) {
            showLoadingPage(false);
            this.f70060e.setBackgroundResource(i2);
            this.f70061f.setText(charSequence);
            this.f70062g.setVisibility(4);
            this.f70063h.setVisibility(0);
            this.f70063h.setText(charSequence2);
            this.k = emptyBtnClickListener;
        }
    }

    public void showTip1_Tip2(int i2, CharSequence charSequence, CharSequence charSequence2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i2, charSequence, charSequence2) == null) {
            showLoadingPage(false);
            this.f70060e.setBackgroundResource(i2);
            this.f70061f.setText(charSequence);
            this.f70062g.setVisibility(0);
            this.f70062g.setText(charSequence2);
            this.f70063h.setVisibility(8);
        }
    }

    public void showTip1_Tip2_NextBtn(int i2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, EmptyBtnClickListener emptyBtnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), charSequence, charSequence2, charSequence3, emptyBtnClickListener}) == null) {
            showLoadingPage(false);
            this.f70060e.setBackgroundResource(i2);
            this.f70061f.setText(charSequence);
            this.f70062g.setVisibility(0);
            this.f70062g.setText(charSequence2);
            this.f70063h.setVisibility(0);
            this.f70063h.setText(charSequence3);
            this.k = emptyBtnClickListener;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletBaseEmptyView(Context context) {
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
        b(context);
    }
}
