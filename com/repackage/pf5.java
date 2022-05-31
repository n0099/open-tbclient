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
public class pf5 extends of5 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rf5 q;

    /* loaded from: classes6.dex */
    public class a implements gf5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pf5 a;

        public a(pf5 pf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pf5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pf5Var;
        }

        @Override // com.repackage.gf5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.e.b.a(rf5.y.parse(this.a.q.o()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pf5(ef5 ef5Var) {
        super(ef5Var.A);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ef5Var};
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
        this.e = ef5Var;
        z(ef5Var.A);
    }

    public final void A(LinearLayout linearLayout) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, linearLayout) == null) {
            ef5 ef5Var = this.e;
            rf5 rf5Var = new rf5(linearLayout, ef5Var.d, ef5Var.z, ef5Var.L);
            this.q = rf5Var;
            if (this.e.b != null) {
                rf5Var.G(new a(this));
            }
            this.q.C(this.e.k);
            ef5 ef5Var2 = this.e;
            int i2 = ef5Var2.h;
            if (i2 != 0 && (i = ef5Var2.i) != 0 && i2 <= i) {
                D();
            }
            ef5 ef5Var3 = this.e;
            Calendar calendar = ef5Var3.f;
            if (calendar != null && ef5Var3.g != null) {
                if (calendar.getTimeInMillis() <= this.e.g.getTimeInMillis()) {
                    C();
                } else {
                    throw new IllegalArgumentException("startDate can't be later than endDate");
                }
            } else {
                ef5 ef5Var4 = this.e;
                Calendar calendar2 = ef5Var4.f;
                if (calendar2 != null) {
                    if (calendar2.get(1) >= 1900) {
                        C();
                    } else {
                        throw new IllegalArgumentException("The startDate can not as early as 1900");
                    }
                } else {
                    Calendar calendar3 = ef5Var4.g;
                    if (calendar3 != null) {
                        if (calendar3.get(1) <= 2100) {
                            C();
                        } else {
                            throw new IllegalArgumentException("The endDate should not be later than 2100");
                        }
                    } else {
                        C();
                    }
                }
            }
            E();
            rf5 rf5Var2 = this.q;
            ef5 ef5Var5 = this.e;
            rf5Var2.y(ef5Var5.l, ef5Var5.m, ef5Var5.n, ef5Var5.o, ef5Var5.p, ef5Var5.q);
            rf5 rf5Var3 = this.q;
            ef5 ef5Var6 = this.e;
            rf5Var3.N(ef5Var6.r, ef5Var6.s, ef5Var6.t, ef5Var6.u, ef5Var6.v, ef5Var6.w);
            u(this.e.S);
            this.q.s(this.e.j);
            this.q.u(this.e.O);
            this.q.w(this.e.U);
            this.q.A(this.e.Q);
            this.q.M(this.e.M);
            this.q.K(this.e.N);
            this.q.p(this.e.T);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.e.a == null) {
            return;
        }
        try {
            this.e.a.a(rf5.y.parse(this.q.o()), this.m);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            rf5 rf5Var = this.q;
            ef5 ef5Var = this.e;
            rf5Var.E(ef5Var.f, ef5Var.g);
            y();
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.q.I(this.e.h);
            this.q.x(this.e.i);
        }
    }

    public final void E() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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
            rf5 rf5Var = this.q;
            rf5Var.D(i, i9, i8, i7, i5, i6);
        }
    }

    @Override // com.repackage.of5
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e.R : invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            if (((String) view2.getTag()).equals("submit")) {
                B();
            }
            f();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ef5 ef5Var = this.e;
            if (ef5Var.f != null && ef5Var.g != null) {
                Calendar calendar = ef5Var.e;
                if (calendar == null || calendar.getTimeInMillis() < this.e.f.getTimeInMillis() || this.e.e.getTimeInMillis() > this.e.g.getTimeInMillis()) {
                    ef5 ef5Var2 = this.e;
                    ef5Var2.e = ef5Var2.f;
                    return;
                }
                return;
            }
            ef5 ef5Var3 = this.e;
            Calendar calendar2 = ef5Var3.f;
            if (calendar2 != null) {
                ef5Var3.e = calendar2;
                return;
            }
            Calendar calendar3 = ef5Var3.g;
            if (calendar3 != null) {
                ef5Var3.e = calendar3;
            }
        }
    }

    public final void z(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            s();
            n();
            m();
            ff5 ff5Var = this.e.c;
            if (ff5Var == null) {
                LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d06d3, this.b);
                TextView textView = (TextView) i(R.id.obfuscated_res_0x7f092159);
                RelativeLayout relativeLayout = (RelativeLayout) i(R.id.obfuscated_res_0x7f091af8);
                Button button = (Button) i(R.id.obfuscated_res_0x7f0903fe);
                Button button2 = (Button) i(R.id.obfuscated_res_0x7f0903fa);
                button.setTag("submit");
                button2.setTag("cancel");
                button.setOnClickListener(this);
                button2.setOnClickListener(this);
                button.setText(TextUtils.isEmpty(this.e.B) ? context.getResources().getString(R.string.obfuscated_res_0x7f0f0e6a) : this.e.B);
                button2.setText(TextUtils.isEmpty(this.e.C) ? context.getResources().getString(R.string.obfuscated_res_0x7f0f0e64) : this.e.C);
                textView.setText(TextUtils.isEmpty(this.e.D) ? "" : this.e.D);
                button.setTextColor(this.e.E);
                button2.setTextColor(this.e.F);
                textView.setTextColor(this.e.G);
                relativeLayout.setBackgroundColor(this.e.I);
                button.setTextSize(this.e.J);
                button2.setTextSize(this.e.J);
                textView.setTextSize(this.e.K);
            } else {
                ff5Var.a(LayoutInflater.from(context).inflate(this.e.x, this.b));
            }
            LinearLayout linearLayout = (LinearLayout) i(R.id.obfuscated_res_0x7f091ff0);
            linearLayout.setBackgroundColor(this.e.H);
            A(linearLayout);
        }
    }
}
