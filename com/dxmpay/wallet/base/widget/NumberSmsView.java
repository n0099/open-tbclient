package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.f.c.a.a;
import c.f.c.a.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.ResUtils;
/* loaded from: classes2.dex */
public class NumberSmsView extends LinearLayout implements TextWatcher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SMS_LEN = 6;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditText f55953e;

    /* renamed from: f  reason: collision with root package name */
    public TextView[] f55954f;

    /* renamed from: g  reason: collision with root package name */
    public View[] f55955g;

    /* renamed from: h  reason: collision with root package name */
    public View[] f55956h;

    /* renamed from: i  reason: collision with root package name */
    public OnSmsChangedListener f55957i;

    /* renamed from: j  reason: collision with root package name */
    public Animation f55958j;

    /* renamed from: k  reason: collision with root package name */
    public int f55959k;
    public Context l;
    public int m;
    public View n;
    public LinearLayout o;

    /* loaded from: classes2.dex */
    public interface OnSmsChangedListener {
        void onSmsChanged(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumberSmsView(Context context, AttributeSet attributeSet) {
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
        this.f55958j = null;
        this.l = context;
        View inflate = LayoutInflater.from(context).inflate(ResUtils.layout(context, "dxm_wallet_base_new_view_sms"), this);
        this.n = inflate;
        this.f55953e = (EditText) inflate.findViewById(ResUtils.id(context, "sms_input"));
        this.o = (LinearLayout) this.n.findViewById(ResUtils.id(context, "six_circle"));
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int length = this.f55953e.getText().length();
            for (int i2 = 0; i2 < this.m; i2++) {
                if (i2 < length) {
                    this.f55954f[i2].setVisibility(0);
                } else {
                    this.f55954f[i2].setVisibility(8);
                }
            }
        }
    }

    public void addNumberSmsChangedListenter(OnSmsChangedListener onSmsChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onSmsChangedListener) == null) {
            this.f55957i = onSmsChangedListener;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editable) == null) {
            a();
            b(editable.length() - 1);
            OnSmsChangedListener onSmsChangedListener = this.f55957i;
            if (onSmsChangedListener != null) {
                onSmsChangedListener.onSmsChanged(editable.length());
            }
        }
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || i2 > this.m - 1) {
            return;
        }
        String obj = this.f55953e.getText().toString();
        for (int i3 = 0; i3 < this.m; i3++) {
            this.f55956h[i3].setBackgroundColor(this.f55959k);
            this.f55955g[i3].setBackgroundColor(ResUtils.getColor(this.l, "dxm_ebpay_new_six_number_pwd_line_54576a"));
            if (i3 == i2) {
                this.f55954f[i3].setText(obj.substring(i2));
                this.f55955g[i3].setVisibility(0);
                this.f55955g[i3].startAnimation(this.f55958j);
            } else {
                this.f55955g[i3].setVisibility(8);
            }
        }
        if (i2 == -1) {
            this.f55955g[0].setVisibility(0);
            this.f55955g[0].startAnimation(this.f55958j);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048580, this, charSequence, i2, i3, i4) == null) {
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i2 = this.m;
            this.f55954f = new TextView[i2];
            this.f55955g = new View[i2];
            this.f55956h = new View[i2];
            for (int i3 = 0; i3 < this.m; i3++) {
                View inflate = LayoutInflater.from(this.l).inflate(b.dxm_wallet_base_new_view_sms_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.lin_sms);
                this.f55954f[i3] = (TextView) inflate.findViewById(ResUtils.id(this.l, "pwd_iv"));
                this.f55955g[i3] = inflate.findViewById(ResUtils.id(this.l, "pwd_iv_line"));
                this.f55956h[i3] = inflate.findViewById(ResUtils.id(this.l, "pwd_iv_line_view"));
                View findViewById = inflate.findViewById(a.view_sms_blank);
                if (i3 == this.m - 1) {
                    findViewById.setVisibility(4);
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    inflate.setLayoutParams(layoutParams);
                }
                this.o.addView(inflate);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f55954f = new TextView[6];
            this.f55955g = new View[6];
            this.f55956h = new View[6];
            for (int i2 = 0; i2 < 6; i2++) {
                View inflate = LayoutInflater.from(this.l).inflate(b.dxm_wallet_base_new_view_sms_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.lin_sms);
                this.f55954f[i2] = (TextView) inflate.findViewById(ResUtils.id(this.l, "pwd_iv"));
                this.f55955g[i2] = inflate.findViewById(ResUtils.id(this.l, "pwd_iv_line"));
                this.f55956h[i2] = inflate.findViewById(ResUtils.id(this.l, "pwd_iv_line_view"));
                View findViewById = inflate.findViewById(a.view_sms_blank);
                if (i2 == 5) {
                    findViewById.setVisibility(4);
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    inflate.setLayoutParams(layoutParams);
                }
                this.o.addView(inflate);
                if (i2 >= this.m) {
                    inflate.setVisibility(4);
                } else {
                    inflate.setVisibility(0);
                }
            }
        }
    }

    public String getSms() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f55953e.getText() != null ? this.f55953e.getText().toString() : "" : (String) invokeV.objValue;
    }

    public void initView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            if (i2 < 1) {
                i2 = 6;
            }
            this.m = i2;
            this.f55953e.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.m)});
            this.o.removeAllViews();
            if (this.m >= 6) {
                c();
            } else {
                d();
            }
            this.f55953e.addTextChangedListener(this);
            Context context = this.l;
            this.f55958j = AnimationUtils.loadAnimation(context, ResUtils.anim(context, "dxm_wallet_base_new_six_number_pwd_view_line"));
            this.f55959k = ResUtils.getColor(this.l, "dxm_ebpay_new_six_number_pwd_line_d0d3d9");
            a();
            b(-1);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
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
        if (interceptable == null || interceptable.invokeLIII(1048586, this, charSequence, i2, i3, i4) == null) {
        }
    }

    public void resetSms() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f55953e.setText("");
        }
    }

    public void setShowInputMethod(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            ((SafeKeyBoardEditText) this.f55953e).setShowInputMethod(z);
        }
    }

    public void smsError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            for (int i2 = 0; i2 < this.m; i2++) {
                this.f55956h[i2].setBackgroundColor(ResUtils.getColor(this.l, "wallet_cashdesk_new_bind_card_5050"));
                this.f55955g[i2].setBackgroundColor(ResUtils.getColor(this.l, "wallet_cashdesk_new_bind_card_5050"));
                this.f55955g[i2].setVisibility(0);
            }
        }
    }

    public void smsNomal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (int i2 = 0; i2 < this.m; i2++) {
                this.f55956h[i2].setBackgroundColor(this.f55959k);
                this.f55955g[i2].setBackgroundColor(ResUtils.getColor(this.l, "dxm_ebpay_new_six_number_pwd_line_54576a"));
                this.f55955g[i2].setVisibility(8);
            }
            this.f55955g[0].startAnimation(this.f55958j);
            this.f55955g[0].setVisibility(0);
        }
    }
}
