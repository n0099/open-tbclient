package d.a.p0.v.d.g.d;

import android.graphics.drawable.Drawable;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.i.a;
import d.a.c.k.e.n;
import d.a.o0.d0.h;
import d.a.o0.r.f0.f;
import d.a.o0.r.f0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f64618a;

    /* renamed from: b  reason: collision with root package name */
    public int f64619b;

    /* renamed from: c  reason: collision with root package name */
    public f f64620c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f64621d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f64622e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f64623f;

    /* renamed from: g  reason: collision with root package name */
    public View f64624g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f64625h;

    /* renamed from: i  reason: collision with root package name */
    public g f64626i;
    public NavigationBar j;
    public LinearLayout k;
    public d.a.o0.d0.g l;
    public PbListView m;
    public h n;
    public final List<d.a.c.k.e.a> o;
    public d.a.p0.v.d.g.a.a p;
    public d.a.p0.v.d.g.a.b q;
    public b r;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f64627e;

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
            this.f64627e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f64627e.f64618a.getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public PopupWindow f64628e;

        /* renamed from: f  reason: collision with root package name */
        public View f64629f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f64630g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f64631h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f64632i;
        public List<String> j;
        public boolean k;
        public String l;
        public a.c m;
        public final /* synthetic */ c n;

        /* loaded from: classes8.dex */
        public class a implements a.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f64633a;

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
                this.f64633a = bVar;
            }

            @Override // d.a.c.e.i.a.c
            public void onLocationGeted(int i2, String str, Address address) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, address) == null) {
                    if (address != null) {
                        double latitude = address.getLatitude();
                        double longitude = address.getLongitude();
                        if (latitude == 0.0d || longitude == 0.0d) {
                            return;
                        }
                        d.a.p0.v.d.g.b.c cVar = new d.a.p0.v.d.g.b.c();
                        cVar.f64589a = this.f64633a.l;
                        cVar.f64590b = String.valueOf(latitude);
                        cVar.f64591c = String.valueOf(longitude);
                        cVar.f64592d = true;
                        this.f64633a.n.f64620c.b(cVar);
                        this.f64633a.f64631h.setText(this.f64633a.l);
                    } else if (StringUtils.isNull(str)) {
                    } else {
                        this.f64633a.n.f64618a.showToast(str);
                    }
                }
            }
        }

        public b(c cVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = cVar;
            this.k = false;
            this.m = new a(this);
            this.f64629f = view;
            this.f64630g = (TextView) view.findViewById(R.id.live_num);
            TextView textView = (TextView) this.f64629f.findViewById(R.id.live_sort);
            this.f64631h = textView;
            textView.setVisibility(8);
            this.f64631h.setOnClickListener(this);
            f();
        }

        public void c(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.j = list;
                if (ListUtils.isEmpty(list) || this.k) {
                    return;
                }
                this.k = true;
                String str = this.j.get(0);
                if (!StringUtils.isNull(str)) {
                    this.f64631h.setText(str);
                    this.f64631h.setVisibility(0);
                }
                this.f64632i = new LinearLayout(this.n.f64618a.getPageActivity());
                this.f64632i.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                SkinManager.setBackgroundResource(this.f64632i, R.drawable.bg_ala_sub_list_sort_panel);
                this.f64632i.setClipChildren(true);
                this.f64632i.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.n.f64618a.getResources().getDimensionPixelOffset(R.dimen.ds176), this.n.f64618a.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i2 = 0; i2 < this.j.size(); i2++) {
                    this.f64632i.addView(e(this.j.get(i2)), layoutParams);
                    if (i2 != this.j.size() - 1) {
                        View view = new View(this.n.f64618a.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.n.f64618a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        SkinManager.setBackgroundResource(view, R.color.CAM_X0204);
                        this.f64632i.addView(view);
                    }
                }
                if (this.f64628e == null) {
                    PopupWindow popupWindow = new PopupWindow(this.n.f64618a.getPageActivity());
                    this.f64628e = popupWindow;
                    popupWindow.setContentView(this.f64632i);
                    this.f64628e.setWidth(-2);
                    this.f64628e.setHeight(-2);
                    this.f64628e.setAnimationStyle(16973826);
                    this.f64628e.setBackgroundDrawable(this.n.f64618a.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.f64628e.setOutsideTouchable(true);
                    this.f64628e.setFocusable(true);
                    this.f64628e.setTouchable(true);
                }
            }
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.isSystemLocationProviderEnabled(this.n.f64618a.getPageActivity()) : invokeV.booleanValue;
        }

        public final TextView e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                TextView textView = new TextView(this.n.f64618a.getPageActivity());
                textView.setTextSize(0, this.n.f64618a.getResources().getDimension(R.dimen.ds28));
                textView.setText(str);
                textView.setTag(str);
                textView.setGravity(17);
                SkinManager.setBackgroundResource(textView, R.drawable.ala_sub_list_live_sort_text_selecor);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                textView.setOnClickListener(this);
                return textView;
            }
            return (TextView) invokeL.objValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setViewTextColor(this.f64630g, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.f64631h, R.color.CAM_X0109);
                this.f64631h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
            }
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                this.f64629f.setVisibility(i2);
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f64628e == null) {
                return;
            }
            int[] iArr = new int[2];
            this.f64631h.getLocationOnScreen(iArr);
            int height = ((View) this.f64631h.getParent()).getHeight() - this.f64631h.getHeight();
            if (iArr[1] - this.f64628e.getHeight() <= 50) {
                d.a.c.e.m.g.d(this.f64628e, this.n.f64618a.getPageActivity());
                return;
            }
            d.a.c.e.m.g.m(this.f64628e, this.n.f64622e, 0, (iArr[0] - (this.f64631h.getWidth() / 2)) - this.n.f64618a.getResources().getDimensionPixelSize(R.dimen.ds24), iArr[1] + this.f64631h.getHeight() + height);
            PopupWindow popupWindow = this.f64628e;
            if (popupWindow != null) {
                popupWindow.update();
            }
        }

        public void i(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f64630g == null) {
                return;
            }
            this.f64630g.setText(this.n.f64618a.getPageActivity().getResources().getString(R.string.square_sub_live_num, StringHelper.numberUniformFormatExtra(i2)));
            this.f64629f.setVisibility(0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
                if (view == this.f64631h) {
                    h();
                } else if (!(view instanceof TextView) || view.getTag() == null || !(view.getTag() instanceof String) || StringUtils.isNull((String) view.getTag())) {
                } else {
                    PopupWindow popupWindow = this.f64628e;
                    if (popupWindow != null) {
                        d.a.c.e.m.g.d(popupWindow, this.n.f64618a.getPageActivity());
                    }
                    if (this.n.f64620c != null) {
                        String str = (String) view.getTag();
                        this.l = str;
                        if (str.contains("距离")) {
                            if (!d()) {
                                this.n.f64618a.showToast(R.string.square_sub_list_no_shared_location);
                                return;
                            } else {
                                d.a.c.e.i.a.l().i(false, this.m);
                                return;
                            }
                        }
                        d.a.p0.v.d.g.b.c cVar = new d.a.p0.v.d.g.b.c();
                        cVar.f64589a = this.l;
                        cVar.f64592d = false;
                        this.n.f64620c.b(cVar);
                        this.f64631h.setText(this.l);
                    }
                }
            }
        }
    }

    public c(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64619b = -1;
        this.f64621d = BdUniqueId.gen();
        this.o = new ArrayList();
        this.f64618a = tbPageContext;
        this.f64622e = (LinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.k = (LinearLayout) LayoutInflater.from(this.f64618a.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.f64623f = (LinearLayout) this.f64622e.findViewById(R.id.liveListLinearLayout);
        View findViewById = this.f64622e.findViewById(R.id.sub_list_top_info);
        this.f64624g = findViewById;
        b bVar = new b(this, findViewById);
        this.r = bVar;
        bVar.g(8);
        this.f64625h = (BdTypeListView) this.f64622e.findViewById(R.id.listView);
        g gVar = new g(this.f64618a);
        this.f64626i = gVar;
        gVar.a0(this.f64621d);
        this.f64625h.setPullRefresh(this.f64626i);
        PbListView pbListView = new PbListView(this.f64618a.getPageActivity());
        this.m = pbListView;
        pbListView.a();
        d.a.p0.v.d.g.a.a aVar = new d.a.p0.v.d.g.a.a(this.f64618a);
        this.p = aVar;
        aVar.i0(2);
        d.a.p0.v.d.g.a.b bVar2 = new d.a.p0.v.d.g.a.b(this.f64618a);
        this.q = bVar2;
        bVar2.i0(2);
        this.o.add(this.p);
        this.o.add(this.q);
        this.f64625h.a(this.o);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f64625h.z();
        }
    }

    public BdTypeListView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64625h : (BdTypeListView) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64622e : (View) invokeV.objValue;
    }

    public void g() {
        d.a.o0.d0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.l) == null) {
            return;
        }
        gVar.dettachView(this.f64622e);
        this.l = null;
    }

    public void h() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.dettachView(this.f64622e);
        this.n = null;
    }

    public void i() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (pbListView = this.m) == null || pbListView.b().getParent() == null) {
            return;
        }
        this.f64625h.removeFooterView(this.m.b());
    }

    public void j(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i2) == null) {
            if (this.f64619b != i2) {
                this.f64619b = i2;
            }
            b bVar = this.r;
            if (bVar != null) {
                bVar.f();
            }
            d.a.o0.d0.g gVar = this.l;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            NavigationBar navigationBar = this.j;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(tbPageContext, i2);
            }
            PbListView pbListView = this.m;
            if (pbListView != null) {
                pbListView.d(i2);
            }
            h hVar = this.n;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            SkinManager.setBackgroundResource(this.f64622e, R.color.CAM_X0201);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.o0.d0.g gVar = this.l;
            if (gVar != null) {
                if (gVar.i() != null) {
                    this.l.dettachView(this.f64622e);
                }
                this.l.m();
                this.l = null;
            }
            g gVar2 = this.f64626i;
            if (gVar2 != null) {
                gVar2.a(null);
                this.f64626i.b(null);
                this.f64626i.l(null);
                this.f64626i.Y();
                this.f64626i = null;
            }
            BdTypeListView bdTypeListView = this.f64625h;
            if (bdTypeListView != null) {
                bdTypeListView.setOnSrollToBottomListener(null);
                this.f64625h.setOnScrollListener(null);
                this.f64625h.setRecyclerListener(null);
                this.f64625h = null;
            }
        }
    }

    public void l(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (bVar = this.r) == null) {
            return;
        }
        bVar.i(i2);
    }

    public void m(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.r.c(list);
    }

    public void n(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.f64620c = fVar;
            d.a.p0.v.d.g.a.a aVar = this.p;
            if (aVar != null) {
                aVar.k0(fVar);
            }
            d.a.p0.v.d.g.a.b bVar = this.q;
            if (bVar != null) {
                bVar.k0(this.f64620c);
            }
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f64623f.setVisibility(i2);
        }
    }

    public void p(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || list == null || ListUtils.isEmpty(list) || (bdTypeListView = this.f64625h) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void q(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f64626i.a(gVar);
        }
    }

    public void r(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f64625h.setOnSrollToBottomListener(pVar);
        }
    }

    public void s(boolean z, List<String> list, String str, String str2, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), list, str, str2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                NavigationBar navigationBar = new NavigationBar(this.f64618a.getPageActivity());
                this.j = navigationBar;
                navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a(this));
                if (!StringUtils.isNull(str2)) {
                    this.j.setCenterTextTitle(str2);
                } else if (!StringUtils.isNull(str)) {
                    this.j.setCenterTextTitle(str);
                }
                this.f64622e.addView(this.j, 0, new LinearLayout.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.j.getBottomLine(), R.color.CAM_X0204);
            }
            if (!ListUtils.isEmpty(list)) {
                this.r.c(list);
            }
            this.p.l0(z3);
            this.q.l0(z3);
        }
    }

    public void t() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.f64618a) == null || this.f64622e == null) {
            return;
        }
        if (this.l == null) {
            this.l = new d.a.o0.d0.g(tbPageContext.getPageActivity(), this.f64618a.getResources().getDimensionPixelSize(R.dimen.ds360));
        }
        d.a.o0.d0.g gVar = this.l;
        if (gVar != null) {
            gVar.attachView(this.f64622e, true);
        }
    }

    public void u(String str, View.OnClickListener onClickListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048593, this, str, onClickListener, z) == null) {
            if (this.n == null) {
                this.n = new h(this.f64618a.getPageActivity(), onClickListener);
            }
            this.n.j(this.f64618a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds180));
            this.n.l(str);
            this.n.attachView(this.f64622e, false);
            if (z) {
                this.n.o();
            } else {
                this.n.e();
            }
        }
    }

    public void v() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.m) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f64625h.setNextPage(this.m);
        }
        this.m.A(this.f64618a.getResources().getString(R.string.live_sub_tab_no_more_data));
        this.m.f();
    }
}
