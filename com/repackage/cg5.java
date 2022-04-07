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
/* loaded from: classes5.dex */
public class cg5 extends bg5 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public eg5 q;

    /* loaded from: classes5.dex */
    public class a implements tf5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cg5 a;

        public a(cg5 cg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cg5Var;
        }

        @Override // com.repackage.tf5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.e.b.a(eg5.y.parse(this.a.q.o()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cg5(rf5 rf5Var) {
        super(rf5Var.A);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rf5Var};
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
        this.e = rf5Var;
        z(rf5Var.A);
    }

    public final void A(LinearLayout linearLayout) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, linearLayout) == null) {
            rf5 rf5Var = this.e;
            eg5 eg5Var = new eg5(linearLayout, rf5Var.d, rf5Var.z, rf5Var.L);
            this.q = eg5Var;
            if (this.e.b != null) {
                eg5Var.G(new a(this));
            }
            this.q.C(this.e.k);
            rf5 rf5Var2 = this.e;
            int i2 = rf5Var2.h;
            if (i2 != 0 && (i = rf5Var2.i) != 0 && i2 <= i) {
                D();
            }
            rf5 rf5Var3 = this.e;
            Calendar calendar = rf5Var3.f;
            if (calendar != null && rf5Var3.g != null) {
                if (calendar.getTimeInMillis() <= this.e.g.getTimeInMillis()) {
                    C();
                } else {
                    throw new IllegalArgumentException("startDate can't be later than endDate");
                }
            } else {
                rf5 rf5Var4 = this.e;
                Calendar calendar2 = rf5Var4.f;
                if (calendar2 != null) {
                    if (calendar2.get(1) >= 1900) {
                        C();
                    } else {
                        throw new IllegalArgumentException("The startDate can not as early as 1900");
                    }
                } else {
                    Calendar calendar3 = rf5Var4.g;
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
            eg5 eg5Var2 = this.q;
            rf5 rf5Var5 = this.e;
            eg5Var2.y(rf5Var5.l, rf5Var5.m, rf5Var5.n, rf5Var5.o, rf5Var5.p, rf5Var5.q);
            eg5 eg5Var3 = this.q;
            rf5 rf5Var6 = this.e;
            eg5Var3.N(rf5Var6.r, rf5Var6.s, rf5Var6.t, rf5Var6.u, rf5Var6.v, rf5Var6.w);
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
            this.e.a.a(eg5.y.parse(this.q.o()), this.m);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            eg5 eg5Var = this.q;
            rf5 rf5Var = this.e;
            eg5Var.E(rf5Var.f, rf5Var.g);
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
            eg5 eg5Var = this.q;
            eg5Var.D(i, i9, i8, i7, i5, i6);
        }
    }

    @Override // com.repackage.bg5
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
            rf5 rf5Var = this.e;
            if (rf5Var.f != null && rf5Var.g != null) {
                Calendar calendar = rf5Var.e;
                if (calendar == null || calendar.getTimeInMillis() < this.e.f.getTimeInMillis() || this.e.e.getTimeInMillis() > this.e.g.getTimeInMillis()) {
                    rf5 rf5Var2 = this.e;
                    rf5Var2.e = rf5Var2.f;
                    return;
                }
                return;
            }
            rf5 rf5Var3 = this.e;
            Calendar calendar2 = rf5Var3.f;
            if (calendar2 != null) {
                rf5Var3.e = calendar2;
                return;
            }
            Calendar calendar3 = rf5Var3.g;
            if (calendar3 != null) {
                rf5Var3.e = calendar3;
            }
        }
    }

    public final void z(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            s();
            n();
            m();
            sf5 sf5Var = this.e.c;
            if (sf5Var == null) {
                LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d06e6, this.b);
                TextView textView = (TextView) i(R.id.obfuscated_res_0x7f09215b);
                RelativeLayout relativeLayout = (RelativeLayout) i(R.id.obfuscated_res_0x7f091afb);
                Button button = (Button) i(R.id.obfuscated_res_0x7f090407);
                Button button2 = (Button) i(R.id.obfuscated_res_0x7f090403);
                button.setTag("submit");
                button2.setTag("cancel");
                button.setOnClickListener(this);
                button2.setOnClickListener(this);
                button.setText(TextUtils.isEmpty(this.e.B) ? context.getResources().getString(R.string.obfuscated_res_0x7f0f0e49) : this.e.B);
                button2.setText(TextUtils.isEmpty(this.e.C) ? context.getResources().getString(R.string.obfuscated_res_0x7f0f0e43) : this.e.C);
                textView.setText(TextUtils.isEmpty(this.e.D) ? "" : this.e.D);
                button.setTextColor(this.e.E);
                button2.setTextColor(this.e.F);
                textView.setTextColor(this.e.G);
                relativeLayout.setBackgroundColor(this.e.I);
                button.setTextSize(this.e.J);
                button2.setTextSize(this.e.J);
                textView.setTextSize(this.e.K);
            } else {
                sf5Var.a(LayoutInflater.from(context).inflate(this.e.x, this.b));
            }
            LinearLayout linearLayout = (LinearLayout) i(R.id.obfuscated_res_0x7f091feb);
            linearLayout.setBackgroundColor(this.e.H);
            A(linearLayout);
        }
    }
}
