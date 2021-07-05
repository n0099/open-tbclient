package d.a.r0.b1.o.a.f;

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
/* loaded from: classes9.dex */
public class b extends d.a.r0.b1.o.a.f.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c u;

    /* loaded from: classes9.dex */
    public class a implements d.a.r0.b1.o.a.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f55089a;

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
            this.f55089a = bVar;
        }

        @Override // d.a.r0.b1.o.a.d.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f55089a.f55082i.f55062b.a(c.y.parse(this.f55089a.u.o()));
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d.a.r0.b1.o.a.c.a aVar) {
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
        this.f55082i = aVar;
        z(aVar.A);
    }

    public final void A(LinearLayout linearLayout) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, linearLayout) == null) {
            d.a.r0.b1.o.a.c.a aVar = this.f55082i;
            c cVar = new c(linearLayout, aVar.f55064d, aVar.z, aVar.L);
            this.u = cVar;
            if (this.f55082i.f55062b != null) {
                cVar.G(new a(this));
            }
            this.u.C(this.f55082i.k);
            d.a.r0.b1.o.a.c.a aVar2 = this.f55082i;
            int i3 = aVar2.f55068h;
            if (i3 != 0 && (i2 = aVar2.f55069i) != 0 && i3 <= i2) {
                G();
            }
            d.a.r0.b1.o.a.c.a aVar3 = this.f55082i;
            Calendar calendar = aVar3.f55066f;
            if (calendar != null && aVar3.f55067g != null) {
                if (calendar.getTimeInMillis() <= this.f55082i.f55067g.getTimeInMillis()) {
                    F();
                } else {
                    throw new IllegalArgumentException("startDate can't be later than endDate");
                }
            } else {
                d.a.r0.b1.o.a.c.a aVar4 = this.f55082i;
                Calendar calendar2 = aVar4.f55066f;
                if (calendar2 != null) {
                    if (calendar2.get(1) >= 1900) {
                        F();
                    } else {
                        throw new IllegalArgumentException("The startDate can not as early as 1900");
                    }
                } else {
                    Calendar calendar3 = aVar4.f55067g;
                    if (calendar3 != null) {
                        if (calendar3.get(1) <= 2100) {
                            F();
                        } else {
                            throw new IllegalArgumentException("The endDate should not be later than 2100");
                        }
                    } else {
                        F();
                    }
                }
            }
            H();
            c cVar2 = this.u;
            d.a.r0.b1.o.a.c.a aVar5 = this.f55082i;
            cVar2.y(aVar5.l, aVar5.m, aVar5.n, aVar5.o, aVar5.p, aVar5.q);
            c cVar3 = this.u;
            d.a.r0.b1.o.a.c.a aVar6 = this.f55082i;
            cVar3.N(aVar6.r, aVar6.s, aVar6.t, aVar6.u, aVar6.v, aVar6.w);
            u(this.f55082i.S);
            this.u.s(this.f55082i.j);
            this.u.u(this.f55082i.O);
            this.u.w(this.f55082i.U);
            this.u.A(this.f55082i.Q);
            this.u.M(this.f55082i.M);
            this.u.K(this.f55082i.N);
            this.u.p(this.f55082i.T);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f55082i.f55061a == null) {
            return;
        }
        try {
            this.f55082i.f55061a.a(c.y.parse(this.u.o()), this.q);
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c cVar = this.u;
            d.a.r0.b1.o.a.c.a aVar = this.f55082i;
            cVar.E(aVar.f55066f, aVar.f55067g);
            y();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.u.I(this.f55082i.f55068h);
            this.u.x(this.f55082i.f55069i);
        }
    }

    public final void H() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = this.f55082i.f55065e;
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
                i3 = this.f55082i.f55065e.get(2);
                i4 = this.f55082i.f55065e.get(5);
                i5 = this.f55082i.f55065e.get(11);
                i6 = this.f55082i.f55065e.get(12);
                i7 = this.f55082i.f55065e.get(13);
            }
            int i8 = i5;
            int i9 = i4;
            int i10 = i3;
            c cVar = this.u;
            cVar.D(i2, i10, i9, i8, i6, i7);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (((String) view.getTag()).equals("submit")) {
                B();
            }
            f();
        }
    }

    @Override // d.a.r0.b1.o.a.f.a
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f55082i.R : invokeV.booleanValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.r0.b1.o.a.c.a aVar = this.f55082i;
            if (aVar.f55066f != null && aVar.f55067g != null) {
                Calendar calendar = aVar.f55065e;
                if (calendar == null || calendar.getTimeInMillis() < this.f55082i.f55066f.getTimeInMillis() || this.f55082i.f55065e.getTimeInMillis() > this.f55082i.f55067g.getTimeInMillis()) {
                    d.a.r0.b1.o.a.c.a aVar2 = this.f55082i;
                    aVar2.f55065e = aVar2.f55066f;
                    return;
                }
                return;
            }
            d.a.r0.b1.o.a.c.a aVar3 = this.f55082i;
            Calendar calendar2 = aVar3.f55066f;
            if (calendar2 != null) {
                aVar3.f55065e = calendar2;
                return;
            }
            Calendar calendar3 = aVar3.f55067g;
            if (calendar3 != null) {
                aVar3.f55065e = calendar3;
            }
        }
    }

    public final void z(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            s();
            o();
            n();
            d.a.r0.b1.o.a.d.a aVar = this.f55082i.f55063c;
            if (aVar == null) {
                LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.f55079f);
                TextView textView = (TextView) j(R.id.tvTitle);
                RelativeLayout relativeLayout = (RelativeLayout) j(R.id.rv_topbar);
                Button button = (Button) j(R.id.btnSubmit);
                Button button2 = (Button) j(R.id.btnCancel);
                button.setTag("submit");
                button2.setTag(QueryResponse.Options.CANCEL);
                button.setOnClickListener(this);
                button2.setOnClickListener(this);
                button.setText(TextUtils.isEmpty(this.f55082i.B) ? context.getResources().getString(R.string.pickerview_submit) : this.f55082i.B);
                button2.setText(TextUtils.isEmpty(this.f55082i.C) ? context.getResources().getString(R.string.pickerview_cancel) : this.f55082i.C);
                textView.setText(TextUtils.isEmpty(this.f55082i.D) ? "" : this.f55082i.D);
                button.setTextColor(this.f55082i.E);
                button2.setTextColor(this.f55082i.F);
                textView.setTextColor(this.f55082i.G);
                relativeLayout.setBackgroundColor(this.f55082i.I);
                button.setTextSize(this.f55082i.J);
                button2.setTextSize(this.f55082i.J);
                textView.setTextSize(this.f55082i.K);
            } else {
                aVar.a(LayoutInflater.from(context).inflate(this.f55082i.x, this.f55079f));
            }
            LinearLayout linearLayout = (LinearLayout) j(R.id.timepicker);
            linearLayout.setBackgroundColor(this.f55082i.H);
            A(linearLayout);
        }
    }
}
