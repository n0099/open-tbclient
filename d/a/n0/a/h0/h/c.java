package d.a.n0.a.h0.h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.SelectorTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.f;
import d.a.n0.a.g;
import d.a.n0.a.v2.b0;
import d.a.n0.a.v2.n0;
import d.a.n0.a.z1.b.b.b;
import d.a.n0.a.z1.b.b.h;
/* loaded from: classes7.dex */
public class c extends d.a.n0.a.z1.b.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View o;
    public TextView p;
    public SelectorTextView q;
    public C0733c r;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f44775e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44775e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f44775e.r.k == null) {
                return;
            }
            this.f44775e.r.k.a(view);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f44776e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44776e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f44776e.r.j == null) {
                return;
            }
            this.f44776e.r.j.a(view);
        }
    }

    /* renamed from: d.a.n0.a.h0.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0733c extends b.C0999b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public int f44777g;

        /* renamed from: h  reason: collision with root package name */
        public int f44778h;

        /* renamed from: i  reason: collision with root package name */
        public int f44779i;
        public b.c j;
        public b.c k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0733c(Context context) {
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
        }

        @Override // d.a.n0.a.z1.b.b.h.a
        public /* bridge */ /* synthetic */ h.a U(int i2) {
            g0(i2);
            return this;
        }

        @Override // d.a.n0.a.z1.b.b.b.C0999b, d.a.n0.a.z1.b.b.h.a
        public h c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c cVar = (c) super.c();
                cVar.r(this);
                return cVar;
            }
            return (h) invokeV.objValue;
        }

        public C0733c e0(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f44777g = i2;
                return this;
            }
            return (C0733c) invokeI.objValue;
        }

        public C0733c f0(int i2, b.c cVar) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, cVar)) == null) {
                this.f44777g = i2;
                this.k = cVar;
                return this;
            }
            return (C0733c) invokeIL.objValue;
        }

        public C0733c g0(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                super.U(i2);
                return this;
            }
            return (C0733c) invokeI.objValue;
        }

        @Override // d.a.n0.a.z1.b.b.h.a
        public h h(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? new c(context) : (h) invokeL.objValue;
        }

        @Override // d.a.n0.a.z1.b.b.h.a
        public /* bridge */ /* synthetic */ h.a v(int i2) {
            e0(i2);
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
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
    }

    @Override // d.a.n0.a.z1.b.b.b
    public View k(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.k).inflate(g.aiapps_safe_dialog, viewGroup, false);
            this.o = inflate;
            TextView textView = (TextView) inflate.findViewById(f.safe_dialog_content);
            this.p = textView;
            textView.setTextColor(getContext().getResources().getColor(d.a.n0.a.c.aiapps_safe_dialog_message));
            SelectorTextView selectorTextView = (SelectorTextView) this.o.findViewById(f.safe_dialog_sub_content);
            this.q = selectorTextView;
            selectorTextView.setTextColor(getContext().getResources().getColor(d.a.n0.a.c.aiapps_safe_dialog_btn_blue));
            q();
            return this.o;
        }
        return (View) invokeL.objValue;
    }

    public final void q() {
        C0733c c0733c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (c0733c = this.r) == null) {
            return;
        }
        this.p.setText(this.k.getText(c0733c.f44777g));
        this.p.setOnClickListener(new a(this));
        if (this.r.f44778h > 0) {
            this.q.setVisibility(0);
            this.q.setText(this.k.getText(this.r.f44778h));
            this.q.setOnClickListener(new b(this));
        } else {
            this.q.setVisibility(8);
        }
        if (this.r.f44779i > 0) {
            Drawable drawable = this.k.getResources().getDrawable(this.r.f44779i);
            b0.b(getContext(), drawable);
            drawable.setBounds(0, 0, n0.f(this.k, 12.0f), n0.f(this.k, 12.0f));
            this.q.setCompoundDrawables(drawable, null, null, null);
        }
    }

    public void r(C0733c c0733c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c0733c) == null) {
            this.r = c0733c;
        }
    }
}
