package d.a.p0.v.e.c;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.o0.r.f0.f;
import d.a.o0.r.f0.g;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f64673a;

    /* renamed from: b  reason: collision with root package name */
    public int f64674b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.v.e.c.d f64675c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64676d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64677e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f64678f;

    /* renamed from: g  reason: collision with root package name */
    public View f64679g;

    /* renamed from: h  reason: collision with root package name */
    public View f64680h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f64681i;
    public TextView j;
    public BdTypeListView k;
    public PopupWindow l;
    public View m;
    public TextView n;
    public TextView o;
    public View p;
    public g q;
    public PbListView r;
    public NoNetworkView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public View w;
    public View x;
    public d.a.p0.v.e.a.g y;
    public d.a.p0.u0.w1.b z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64682e;

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
            this.f64682e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f64682e.m();
            }
        }
    }

    /* renamed from: d.a.p0.v.e.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnTouchListenerC1768b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64683e;

        public View$OnTouchListenerC1768b(b bVar) {
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
            this.f64683e = bVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f64683e.z.b(view, motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64684e;

        public c(b bVar) {
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
            this.f64684e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f64684e.n(1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64685e;

        public d(b bVar) {
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
            this.f64685e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f64685e.n(2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64686e;

        public e(b bVar) {
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
            this.f64686e = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64686e.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdListView.p f64687e;

        public f(b bVar, BdListView.p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64687e = pVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BdListView.p pVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (pVar = this.f64687e) == null) {
                return;
            }
            pVar.onScrollToBottom();
        }
    }

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z), Boolean.valueOf(z2), bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64674b = -1;
        this.f64673a = tbPageContext;
        this.f64676d = z;
        this.f64677e = z2;
        this.f64678f = bdUniqueId;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k.z();
        }
    }

    public BdTypeListView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (BdTypeListView) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64679g : (View) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.m == null) {
                View inflate = LayoutInflater.from(this.f64673a.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
                this.m = inflate;
                this.n = (TextView) inflate.findViewById(R.id.frs_game_live_hot);
                this.o = (TextView) this.m.findViewById(R.id.frs_game_live_new);
                this.p = this.m.findViewById(R.id.frs_game_live_sort_sepline);
                this.n.setOnClickListener(new c(this));
                this.o.setOnClickListener(new d(this));
            }
            if (this.l == null) {
                PopupWindow popupWindow = new PopupWindow(this.f64673a.getPageActivity());
                this.l = popupWindow;
                popupWindow.setContentView(this.m);
                this.l.setWidth(-2);
                this.l.setHeight(-2);
                this.l.setAnimationStyle(16973826);
                this.l.setBackgroundDrawable(this.f64673a.getResources().getDrawable(R.drawable.popup_window_transparent));
                this.l.setOutsideTouchable(true);
                this.l.setFocusable(true);
                this.l.setTouchable(true);
                this.l.setOnDismissListener(new e(this));
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.f64673a.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
            this.f64679g = inflate;
            this.f64680h = inflate.findViewById(R.id.frs_game_live_topinfo);
            this.f64681i = (TextView) this.f64679g.findViewById(R.id.frs_game_live_num);
            this.j = (TextView) this.f64679g.findViewById(R.id.frs_game_live_sort);
            this.k = (BdTypeListView) this.f64679g.findViewById(R.id.listView);
            this.s = (NoNetworkView) this.f64679g.findViewById(R.id.vNoNetwork);
            g gVar = new g(this.f64673a);
            this.q = gVar;
            gVar.a0(this.f64678f);
            this.k.setPullRefresh(this.q);
            PbListView pbListView = new PbListView(this.f64673a.getPageActivity());
            this.r = pbListView;
            pbListView.a();
            this.y = new d.a.p0.v.e.a.g(this.f64673a, this.k, this.f64676d);
            this.j.setOnClickListener(new a(this));
            if (this.f64677e) {
                this.z = new d.a.p0.u0.w1.b(this.f64673a.getPageActivity(), this.f64678f, this.f64677e);
                this.k.setOnTouchListener(new View$OnTouchListenerC1768b(this));
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.w, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.x, R.color.CAM_X0204);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            if (this.f64674b != i2) {
                this.f64674b = i2;
            }
            k();
            SkinManager.setViewTextColor(this.f64681i, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109);
            this.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            y();
        }
    }

    public final void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            p(i2);
            d.a.c.e.m.g.d(this.l, this.f64673a.getPageActivity());
            d.a.p0.v.e.c.d dVar = this.f64675c;
            if (dVar != null) {
                dVar.a(i2);
            }
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.f64681i == null) {
            return;
        }
        this.f64681i.setText(this.f64673a.getResources().getString(R.string.frs_game_live_num, StringHelper.numberUniformFormatExtra(i2)));
        if (i2 <= 1) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
    }

    public void p(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 1) {
                TextView textView2 = this.j;
                if (textView2 != null) {
                    textView2.setText(this.f64673a.getString(R.string.frs_game_live_sort_hot));
                }
            } else if (i2 != 2 || (textView = this.j) == null) {
            } else {
                textView.setText(this.f64673a.getString(R.string.frs_game_live_sort_new));
            }
        }
    }

    public void q(d.a.p0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.y.b(cVar);
        }
    }

    public void r(d.a.p0.v.e.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.f64675c = dVar;
        }
    }

    public void s(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, gVar) == null) {
            this.q.a(gVar);
        }
    }

    public void t(List<n> list, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || list == null || ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            this.f64680h.setVisibility(0);
        } else {
            this.f64680h.setVisibility(8);
        }
        this.y.c(list);
        if (z2) {
            v();
        } else {
            x();
        }
    }

    public void u(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, pVar) == null) {
            this.k.setOnSrollToBottomListener(pVar);
            this.r.z(new f(this, pVar));
        }
    }

    public void v() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (pbListView = this.r) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.k.setNextPage(this.r);
        }
        this.r.A(this.f64673a.getResources().getString(R.string.load_more));
        this.r.f();
    }

    public void w() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.r) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.k.setNextPage(this.r);
        }
        this.r.M();
        this.r.O();
    }

    public void x() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (pbListView = this.r) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.k.setNextPage(this.r);
        }
        this.r.A(this.f64673a.getResources().getString(R.string.list_no_more));
        this.r.f();
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            i();
            SkinManager.setBackgroundResource(this.m, R.drawable.bg_ala_frs_game_live_sort_panel);
            SkinManager.setBackgroundResource(this.n, R.drawable.ala_frs_game_live_sort_selecor);
            SkinManager.setBackgroundResource(this.o, R.drawable.ala_frs_game_live_sort_selecor);
            SkinManager.setBackgroundResource(this.p, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0106);
            int[] iArr = new int[2];
            this.j.getLocationOnScreen(iArr);
            int height = ((View) this.j.getParent()).getHeight() - this.j.getHeight();
            if (iArr[1] - this.l.getHeight() <= 50) {
                d.a.c.e.m.g.d(this.l, this.f64673a.getPageActivity());
                return;
            }
            d.a.c.e.m.g.m(this.l, this.f64679g, 0, (iArr[0] - (this.j.getWidth() / 2)) - this.f64673a.getResources().getDimensionPixelSize(R.dimen.ds24), iArr[1] + this.j.getHeight() + height);
            this.l.update();
        }
    }
}
