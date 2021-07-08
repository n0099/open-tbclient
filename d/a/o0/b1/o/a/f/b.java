package d.a.o0.b1.o.a.f;

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
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import java.text.ParseException;
import java.util.Calendar;
/* loaded from: classes7.dex */
public class b extends d.a.o0.b1.o.a.f.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c u;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.b1.o.a.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f51794a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51794a = bVar;
        }

        @Override // d.a.o0.b1.o.a.d.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f51794a.f51787i.f51767b.a(c.y.parse(this.f51794a.u.o()));
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d.a.o0.b1.o.a.c.a aVar) {
        super(aVar.A);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
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
        this.f51787i = aVar;
        y(aVar.A);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51787i.f51766a == null) {
            return;
        }
        try {
            this.f51787i.f51766a.a(c.y.parse(this.u.o()), this.q);
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c cVar = this.u;
            d.a.o0.b1.o.a.c.a aVar = this.f51787i;
            cVar.E(aVar.f51771f, aVar.f51772g);
            x();
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.u.I(this.f51787i.f51773h);
            this.u.x(this.f51787i.f51774i);
        }
    }

    public final void G() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = this.f51787i.f51770e;
            if (calendar2 == null) {
                calendar.setTimeInMillis(System.currentTimeMillis());
                i2 = calendar.get(1);
                i3 = calendar.get(2);
                i4 = calendar.get(5);
                i5 = calendar.get(11);
                i6 = calendar.get(12);
                i7 = calendar.get(13);
            } else {
                i2 = calendar2.get(1);
                i3 = this.f51787i.f51770e.get(2);
                i4 = this.f51787i.f51770e.get(5);
                i5 = this.f51787i.f51770e.get(11);
                i6 = this.f51787i.f51770e.get(12);
                i7 = this.f51787i.f51770e.get(13);
            }
            int i8 = i5;
            int i9 = i4;
            int i10 = i3;
            c cVar = this.u;
            cVar.D(i2, i10, i9, i8, i6, i7);
        }
    }

    @Override // d.a.o0.b1.o.a.f.a
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f51787i.R : invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (((String) view.getTag()).equals("submit")) {
                A();
            }
            f();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.o0.b1.o.a.c.a aVar = this.f51787i;
            if (aVar.f51771f != null && aVar.f51772g != null) {
                Calendar calendar = aVar.f51770e;
                if (calendar == null || calendar.getTimeInMillis() < this.f51787i.f51771f.getTimeInMillis() || this.f51787i.f51770e.getTimeInMillis() > this.f51787i.f51772g.getTimeInMillis()) {
                    d.a.o0.b1.o.a.c.a aVar2 = this.f51787i;
                    aVar2.f51770e = aVar2.f51771f;
                    return;
                }
                return;
            }
            d.a.o0.b1.o.a.c.a aVar3 = this.f51787i;
            Calendar calendar2 = aVar3.f51771f;
            if (calendar2 != null) {
                aVar3.f51770e = calendar2;
                return;
            }
            Calendar calendar3 = aVar3.f51772g;
            if (calendar3 != null) {
                aVar3.f51770e = calendar3;
            }
        }
    }

    public final void y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            r();
            n();
            m();
            d.a.o0.b1.o.a.d.a aVar = this.f51787i.f51768c;
            if (aVar == null) {
                LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.f51784f);
                TextView textView = (TextView) i(R.id.tvTitle);
                RelativeLayout relativeLayout = (RelativeLayout) i(R.id.rv_topbar);
                Button button = (Button) i(R.id.btnSubmit);
                Button button2 = (Button) i(R.id.btnCancel);
                button.setTag("submit");
                button2.setTag(QueryResponse.Options.CANCEL);
                button.setOnClickListener(this);
                button2.setOnClickListener(this);
                button.setText(TextUtils.isEmpty(this.f51787i.B) ? context.getResources().getString(R.string.pickerview_submit) : this.f51787i.B);
                button2.setText(TextUtils.isEmpty(this.f51787i.C) ? context.getResources().getString(R.string.pickerview_cancel) : this.f51787i.C);
                textView.setText(TextUtils.isEmpty(this.f51787i.D) ? "" : this.f51787i.D);
                button.setTextColor(this.f51787i.E);
                button2.setTextColor(this.f51787i.F);
                textView.setTextColor(this.f51787i.G);
                relativeLayout.setBackgroundColor(this.f51787i.I);
                button.setTextSize(this.f51787i.J);
                button2.setTextSize(this.f51787i.J);
                textView.setTextSize(this.f51787i.K);
            } else {
                aVar.a(LayoutInflater.from(context).inflate(this.f51787i.x, this.f51784f));
            }
            LinearLayout linearLayout = (LinearLayout) i(R.id.timepicker);
            linearLayout.setBackgroundColor(this.f51787i.H);
            z(linearLayout);
        }
    }

    public final void z(LinearLayout linearLayout) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, linearLayout) == null) {
            d.a.o0.b1.o.a.c.a aVar = this.f51787i;
            c cVar = new c(linearLayout, aVar.f51769d, aVar.z, aVar.L);
            this.u = cVar;
            if (this.f51787i.f51767b != null) {
                cVar.G(new a(this));
            }
            this.u.C(this.f51787i.k);
            d.a.o0.b1.o.a.c.a aVar2 = this.f51787i;
            int i3 = aVar2.f51773h;
            if (i3 != 0 && (i2 = aVar2.f51774i) != 0 && i3 <= i2) {
                F();
            }
            d.a.o0.b1.o.a.c.a aVar3 = this.f51787i;
            Calendar calendar = aVar3.f51771f;
            if (calendar != null && aVar3.f51772g != null) {
                if (calendar.getTimeInMillis() <= this.f51787i.f51772g.getTimeInMillis()) {
                    B();
                } else {
                    throw new IllegalArgumentException("startDate can't be later than endDate");
                }
            } else {
                d.a.o0.b1.o.a.c.a aVar4 = this.f51787i;
                Calendar calendar2 = aVar4.f51771f;
                if (calendar2 != null) {
                    if (calendar2.get(1) >= 1900) {
                        B();
                    } else {
                        throw new IllegalArgumentException("The startDate can not as early as 1900");
                    }
                } else {
                    Calendar calendar3 = aVar4.f51772g;
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
            G();
            c cVar2 = this.u;
            d.a.o0.b1.o.a.c.a aVar5 = this.f51787i;
            cVar2.y(aVar5.l, aVar5.m, aVar5.n, aVar5.o, aVar5.p, aVar5.q);
            c cVar3 = this.u;
            d.a.o0.b1.o.a.c.a aVar6 = this.f51787i;
            cVar3.N(aVar6.r, aVar6.s, aVar6.t, aVar6.u, aVar6.v, aVar6.w);
            t(this.f51787i.S);
            this.u.s(this.f51787i.j);
            this.u.u(this.f51787i.O);
            this.u.w(this.f51787i.U);
            this.u.A(this.f51787i.Q);
            this.u.M(this.f51787i.M);
            this.u.K(this.f51787i.N);
            this.u.p(this.f51787i.T);
        }
    }
}
