package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.ResUtils;
/* loaded from: classes12.dex */
public class SixNumberPwdView extends LinearLayout implements TextWatcher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PWD_LEN = 6;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditText f55426e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView[] f55427f;

    /* renamed from: g  reason: collision with root package name */
    public View[] f55428g;

    /* renamed from: h  reason: collision with root package name */
    public View[] f55429h;

    /* renamed from: i  reason: collision with root package name */
    public OnPwdChangedListener f55430i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f55431j;

    /* renamed from: k  reason: collision with root package name */
    public Animation f55432k;
    public Animation l;
    public Drawable m;
    public Drawable n;
    public int o;

    /* loaded from: classes12.dex */
    public interface OnPwdChangedListener {
        void onPwdChanged(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SixNumberPwdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55427f = new ImageView[6];
        this.f55428g = new View[6];
        this.f55429h = new View[6];
        this.f55431j = true;
        this.f55432k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.f55426e = (EditText) LayoutInflater.from(context).inflate(ResUtils.layout(context, "dxm_wallet_base_new_view_six_pwd"), this).findViewById(ResUtils.id(context, "pwd_input"));
        this.f55427f[0] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_1"));
        this.f55428g[0] = findViewById(ResUtils.id(context, "pwd_iv_1_line"));
        this.f55429h[0] = findViewById(ResUtils.id(context, "pwd_iv_1_line_view"));
        this.f55427f[1] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_2"));
        this.f55428g[1] = findViewById(ResUtils.id(context, "pwd_iv_2_line"));
        this.f55429h[1] = findViewById(ResUtils.id(context, "pwd_iv_2_line_view"));
        this.f55427f[2] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_3"));
        this.f55428g[2] = findViewById(ResUtils.id(context, "pwd_iv_3_line"));
        this.f55429h[2] = findViewById(ResUtils.id(context, "pwd_iv_3_line_view"));
        this.f55427f[3] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_4"));
        this.f55428g[3] = findViewById(ResUtils.id(context, "pwd_iv_4_line"));
        this.f55429h[3] = findViewById(ResUtils.id(context, "pwd_iv_4_line_view"));
        this.f55427f[4] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_5"));
        this.f55428g[4] = findViewById(ResUtils.id(context, "pwd_iv_5_line"));
        this.f55429h[4] = findViewById(ResUtils.id(context, "pwd_iv_5_line_view"));
        this.f55427f[5] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_6"));
        this.f55428g[5] = findViewById(ResUtils.id(context, "pwd_iv_6_line"));
        this.f55429h[5] = findViewById(ResUtils.id(context, "pwd_iv_6_line_view"));
        this.f55426e.addTextChangedListener(this);
        this.f55432k = AnimationUtils.loadAnimation(context, ResUtils.anim(context, "dxm_wallet_base_six_number_pwd_view_circle"));
        this.l = AnimationUtils.loadAnimation(context, ResUtils.anim(context, "dxm_wallet_base_new_six_number_pwd_view_line"));
        this.m = ResUtils.getDrawable(context, "dxm_wallet_base_new_six_number_pwd_view_circle");
        this.n = ResUtils.getDrawable(context, "dxm_wallet_base_safekeyboard_six_number_circle_black");
        this.o = ResUtils.getColor(context, "dxm_ebpay_new_six_number_pwd_line_d0d3d9");
        a();
        b(-1);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int length = this.f55426e.getText().length();
            for (int i2 = 0; i2 < 6; i2++) {
                if (i2 < length) {
                    this.f55427f[i2].setVisibility(0);
                    if (i2 == length - 1) {
                        this.f55427f[i2].setImageDrawable(this.m);
                        if (this.f55431j) {
                            this.f55427f[i2].startAnimation(this.f55432k);
                        }
                    } else {
                        this.f55427f[i2].setImageDrawable(this.n);
                    }
                } else {
                    this.f55427f[i2].setVisibility(8);
                }
            }
        }
    }

    public void addSixNumberPwdChangedListenter(OnPwdChangedListener onPwdChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onPwdChangedListener) == null) {
            this.f55430i = onPwdChangedListener;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editable) == null) {
            a();
            b(editable.length() - 1);
            OnPwdChangedListener onPwdChangedListener = this.f55430i;
            if (onPwdChangedListener != null) {
                onPwdChangedListener.onPwdChanged(editable.length());
            }
        }
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || i2 > 5) {
            return;
        }
        for (int i3 = 0; i3 < 6; i3++) {
            this.f55429h[i3].setBackgroundColor(this.o);
            if (i3 == i2) {
                this.f55428g[i3].setVisibility(0);
                this.f55428g[i3].startAnimation(this.l);
            } else {
                this.f55428g[i3].setVisibility(8);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048580, this, charSequence, i2, i3, i4) == null) {
        }
    }

    public String getPwd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TextUtils.isEmpty(this.f55426e.getText().toString()) ? "" : SecurePay.getInstance().localEncrypt1(this.f55426e.getText().toString()) : (String) invokeV.objValue;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            int mode = View.MeasureSpec.getMode(i3);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode2 == 1073741824 || i2 == Integer.MIN_VALUE) {
                size = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                i3 = View.MeasureSpec.makeMeasureSpec((size - (DisplayUtils.dip2px(getContext(), 0.5f) * 5)) / 6, 1073741824);
            } else if (mode == 1073741824) {
                size = View.MeasureSpec.makeMeasureSpec((size2 * 6) + (DisplayUtils.dip2px(getContext(), 0.5f) * 5), 1073741824);
            } else {
                i3 = size2;
            }
            super.onMeasure(size, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048583, this, charSequence, i2, i3, i4) == null) {
            if (i4 < i3) {
                this.f55431j = false;
            } else {
                this.f55431j = true;
            }
        }
    }

    public void resetPwd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f55426e.setText("");
        }
    }

    public void setShowInputMethod(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            ((SafeKeyBoardEditText) this.f55426e).setShowInputMethod(z);
        }
    }
}
