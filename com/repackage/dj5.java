package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.ParseException;
import java.util.Calendar;
/* loaded from: classes6.dex */
public class dj5 extends cj5 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fj5 q;

    /* loaded from: classes6.dex */
    public class a implements ui5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dj5 a;

        public a(dj5 dj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dj5Var;
        }

        @Override // com.repackage.ui5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.e.b.a(fj5.y.parse(this.a.q.o()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj5(si5 si5Var) {
        super(si5Var.A);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {si5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = si5Var;
        y(si5Var.A);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.e.a == null) {
            return;
        }
        try {
            this.e.a.a(fj5.y.parse(this.q.o()), this.m);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            fj5 fj5Var = this.q;
            si5 si5Var = this.e;
            fj5Var.E(si5Var.f, si5Var.g);
            x();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.q.I(this.e.h);
            this.q.x(this.e.i);
        }
    }

    public final void D() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = this.e.e;
            if (calendar2 == null) {
                calendar.setTimeInMillis(System.currentTimeMillis());
                i = calendar.get(1);
                i2 = calendar.get(2);
                i3 = calendar.get(5);
                i4 = calendar.get(11);
                i5 = calendar.get(12);
                i6 = calendar.get(13);
            } else {
                i = calendar2.get(1);
                i2 = this.e.e.get(2);
                i3 = this.e.e.get(5);
                i4 = this.e.e.get(11);
                i5 = this.e.e.get(12);
                i6 = this.e.e.get(13);
            }
            int i7 = i4;
            int i8 = i3;
            int i9 = i2;
            fj5 fj5Var = this.q;
            fj5Var.D(i, i9, i8, i7, i5, i6);
        }
    }

    @Override // com.repackage.cj5
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e.R : invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (((String) view2.getTag()).equals("submit")) {
                A();
            }
            f();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            si5 si5Var = this.e;
            if (si5Var.f != null && si5Var.g != null) {
                Calendar calendar = si5Var.e;
                if (calendar == null || calendar.getTimeInMillis() < this.e.f.getTimeInMillis() || this.e.e.getTimeInMillis() > this.e.g.getTimeInMillis()) {
                    si5 si5Var2 = this.e;
                    si5Var2.e = si5Var2.f;
                    return;
                }
                return;
            }
            si5 si5Var3 = this.e;
            Calendar calendar2 = si5Var3.f;
            if (calendar2 != null) {
                si5Var3.e = calendar2;
                return;
            }
            Calendar calendar3 = si5Var3.g;
            if (calendar3 != null) {
                si5Var3.e = calendar3;
            }
        }
    }

    public final void y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            r();
            n();
            m();
            ti5 ti5Var = this.e.c;
            if (ti5Var == null) {
                LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d071e, this.b);
                TextView textView = (TextView) i(R.id.obfuscated_res_0x7f0922fe);
                RelativeLayout relativeLayout = (RelativeLayout) i(R.id.obfuscated_res_0x7f091c4f);
                Button button = (Button) i(R.id.obfuscated_res_0x7f090414);
                Button button2 = (Button) i(R.id.obfuscated_res_0x7f090410);
                button.setTag("submit");
                button2.setTag("cancel");
                button.setOnClickListener(this);
                button2.setOnClickListener(this);
                button.setText(TextUtils.isEmpty(this.e.B) ? context.getResources().getString(R.string.obfuscated_res_0x7f0f0e82) : this.e.B);
                button2.setText(TextUtils.isEmpty(this.e.C) ? context.getResources().getString(R.string.obfuscated_res_0x7f0f0e7c) : this.e.C);
                textView.setText(TextUtils.isEmpty(this.e.D) ? "" : this.e.D);
                button.setTextColor(this.e.E);
                button2.setTextColor(this.e.F);
                textView.setTextColor(this.e.G);
                relativeLayout.setBackgroundColor(this.e.I);
                button.setTextSize(this.e.J);
                button2.setTextSize(this.e.J);
                textView.setTextSize(this.e.K);
            } else {
                ti5Var.a(LayoutInflater.from(context).inflate(this.e.x, this.b));
            }
            LinearLayout linearLayout = (LinearLayout) i(R.id.obfuscated_res_0x7f092194);
            linearLayout.setBackgroundColor(this.e.H);
            z(linearLayout);
        }
    }

    public final void z(LinearLayout linearLayout) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, linearLayout) == null) {
            si5 si5Var = this.e;
            fj5 fj5Var = new fj5(linearLayout, si5Var.d, si5Var.z, si5Var.L);
            this.q = fj5Var;
            if (this.e.b != null) {
                fj5Var.G(new a(this));
            }
            this.q.C(this.e.k);
            si5 si5Var2 = this.e;
            int i2 = si5Var2.h;
            if (i2 != 0 && (i = si5Var2.i) != 0 && i2 <= i) {
                C();
            }
            si5 si5Var3 = this.e;
            Calendar calendar = si5Var3.f;
            if (calendar != null && si5Var3.g != null) {
                if (calendar.getTimeInMillis() <= this.e.g.getTimeInMillis()) {
                    B();
                } else {
                    throw new IllegalArgumentException("startDate can't be later than endDate");
                }
            } else {
                si5 si5Var4 = this.e;
                Calendar calendar2 = si5Var4.f;
                if (calendar2 != null) {
                    if (calendar2.get(1) >= 1900) {
                        B();
                    } else {
                        throw new IllegalArgumentException("The startDate can not as early as 1900");
                    }
                } else {
                    Calendar calendar3 = si5Var4.g;
                    if (calendar3 != null) {
                        if (calendar3.get(1) <= 2100) {
                            B();
                        } else {
                            throw new IllegalArgumentException("The endDate should not be later than 2100");
                        }
                    } else {
                        B();
                    }
                }
            }
            D();
            fj5 fj5Var2 = this.q;
            si5 si5Var5 = this.e;
            fj5Var2.y(si5Var5.l, si5Var5.m, si5Var5.n, si5Var5.o, si5Var5.p, si5Var5.q);
            fj5 fj5Var3 = this.q;
            si5 si5Var6 = this.e;
            fj5Var3.N(si5Var6.r, si5Var6.s, si5Var6.t, si5Var6.u, si5Var6.v, si5Var6.w);
            t(this.e.S);
            this.q.s(this.e.j);
            this.q.u(this.e.O);
            this.q.w(this.e.U);
            this.q.A(this.e.Q);
            this.q.M(this.e.M);
            this.q.K(this.e.N);
            this.q.p(this.e.T);
        }
    }
}
