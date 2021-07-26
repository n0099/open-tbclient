package d.a.q0.v.d.g.d;

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
import d.a.d.e.i.a;
import d.a.d.k.e.n;
import d.a.p0.f0.h;
import d.a.p0.s.f0.f;
import d.a.p0.s.f0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65263a;

    /* renamed from: b  reason: collision with root package name */
    public int f65264b;

    /* renamed from: c  reason: collision with root package name */
    public f f65265c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f65266d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f65267e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f65268f;

    /* renamed from: g  reason: collision with root package name */
    public View f65269g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f65270h;

    /* renamed from: i  reason: collision with root package name */
    public g f65271i;
    public NavigationBar j;
    public LinearLayout k;
    public d.a.p0.f0.g l;
    public PbListView m;
    public h n;
    public final List<d.a.d.k.e.a> o;
    public d.a.q0.v.d.g.a.a p;
    public d.a.q0.v.d.g.a.b q;
    public b r;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f65272e;

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
            this.f65272e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f65272e.f65263a.getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public PopupWindow f65273e;

        /* renamed from: f  reason: collision with root package name */
        public View f65274f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f65275g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f65276h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f65277i;
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
            public final /* synthetic */ b f65278a;

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
                this.f65278a = bVar;
            }

            @Override // d.a.d.e.i.a.c
            public void onLocationGeted(int i2, String str, Address address) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, address) == null) {
                    if (address != null) {
                        double latitude = address.getLatitude();
                        double longitude = address.getLongitude();
                        if (latitude == 0.0d || longitude == 0.0d) {
                            return;
                        }
                        d.a.q0.v.d.g.b.c cVar = new d.a.q0.v.d.g.b.c();
                        cVar.f65234a = this.f65278a.l;
                        cVar.f65235b = String.valueOf(latitude);
                        cVar.f65236c = String.valueOf(longitude);
                        cVar.f65237d = true;
                        this.f65278a.n.f65265c.b(cVar);
                        this.f65278a.f65276h.setText(this.f65278a.l);
                    } else if (StringUtils.isNull(str)) {
                    } else {
                        this.f65278a.n.f65263a.showToast(str);
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
            this.f65274f = view;
            this.f65275g = (TextView) view.findViewById(R.id.live_num);
            TextView textView = (TextView) this.f65274f.findViewById(R.id.live_sort);
            this.f65276h = textView;
            textView.setVisibility(8);
            this.f65276h.setOnClickListener(this);
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
                    this.f65276h.setText(str);
                    this.f65276h.setVisibility(0);
                }
                this.f65277i = new LinearLayout(this.n.f65263a.getPageActivity());
                this.f65277i.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                SkinManager.setBackgroundResource(this.f65277i, R.drawable.bg_ala_sub_list_sort_panel);
                this.f65277i.setClipChildren(true);
                this.f65277i.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.n.f65263a.getResources().getDimensionPixelOffset(R.dimen.ds176), this.n.f65263a.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i2 = 0; i2 < this.j.size(); i2++) {
                    this.f65277i.addView(e(this.j.get(i2)), layoutParams);
                    if (i2 != this.j.size() - 1) {
                        View view = new View(this.n.f65263a.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.n.f65263a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        SkinManager.setBackgroundResource(view, R.color.CAM_X0204);
                        this.f65277i.addView(view);
                    }
                }
                if (this.f65273e == null) {
                    PopupWindow popupWindow = new PopupWindow(this.n.f65263a.getPageActivity());
                    this.f65273e = popupWindow;
                    popupWindow.setContentView(this.f65277i);
                    this.f65273e.setWidth(-2);
                    this.f65273e.setHeight(-2);
                    this.f65273e.setAnimationStyle(16973826);
                    this.f65273e.setBackgroundDrawable(this.n.f65263a.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.f65273e.setOutsideTouchable(true);
                    this.f65273e.setFocusable(true);
                    this.f65273e.setTouchable(true);
                }
            }
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.isSystemLocationProviderEnabled(this.n.f65263a.getPageActivity()) : invokeV.booleanValue;
        }

        public final TextView e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                TextView textView = new TextView(this.n.f65263a.getPageActivity());
                textView.setTextSize(0, this.n.f65263a.getResources().getDimension(R.dimen.ds28));
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
                SkinManager.setViewTextColor(this.f65275g, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.f65276h, R.color.CAM_X0109);
                this.f65276h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
            }
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                this.f65274f.setVisibility(i2);
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f65273e == null) {
                return;
            }
            int[] iArr = new int[2];
            this.f65276h.getLocationOnScreen(iArr);
            int height = ((View) this.f65276h.getParent()).getHeight() - this.f65276h.getHeight();
            if (iArr[1] - this.f65273e.getHeight() <= 50) {
                d.a.d.e.m.g.d(this.f65273e, this.n.f65263a.getPageActivity());
                return;
            }
            d.a.d.e.m.g.m(this.f65273e, this.n.f65267e, 0, (iArr[0] - (this.f65276h.getWidth() / 2)) - this.n.f65263a.getResources().getDimensionPixelSize(R.dimen.ds24), iArr[1] + this.f65276h.getHeight() + height);
            PopupWindow popupWindow = this.f65273e;
            if (popupWindow != null) {
                popupWindow.update();
            }
        }

        public void i(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f65275g == null) {
                return;
            }
            this.f65275g.setText(this.n.f65263a.getPageActivity().getResources().getString(R.string.square_sub_live_num, StringHelper.numberUniformFormatExtra(i2)));
            this.f65274f.setVisibility(0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
                if (view == this.f65276h) {
                    h();
                } else if (!(view instanceof TextView) || view.getTag() == null || !(view.getTag() instanceof String) || StringUtils.isNull((String) view.getTag())) {
                } else {
                    PopupWindow popupWindow = this.f65273e;
                    if (popupWindow != null) {
                        d.a.d.e.m.g.d(popupWindow, this.n.f65263a.getPageActivity());
                    }
                    if (this.n.f65265c != null) {
                        String str = (String) view.getTag();
                        this.l = str;
                        if (str.contains("距离")) {
                            if (!d()) {
                                this.n.f65263a.showToast(R.string.square_sub_list_no_shared_location);
                                return;
                            } else {
                                d.a.d.e.i.a.l().i(false, this.m);
                                return;
                            }
                        }
                        d.a.q0.v.d.g.b.c cVar = new d.a.q0.v.d.g.b.c();
                        cVar.f65234a = this.l;
                        cVar.f65237d = false;
                        this.n.f65265c.b(cVar);
                        this.f65276h.setText(this.l);
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
        this.f65264b = -1;
        this.f65266d = BdUniqueId.gen();
        this.o = new ArrayList();
        this.f65263a = tbPageContext;
        this.f65267e = (LinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.k = (LinearLayout) LayoutInflater.from(this.f65263a.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.f65268f = (LinearLayout) this.f65267e.findViewById(R.id.liveListLinearLayout);
        View findViewById = this.f65267e.findViewById(R.id.sub_list_top_info);
        this.f65269g = findViewById;
        b bVar = new b(this, findViewById);
        this.r = bVar;
        bVar.g(8);
        this.f65270h = (BdTypeListView) this.f65267e.findViewById(R.id.listView);
        g gVar = new g(this.f65263a);
        this.f65271i = gVar;
        gVar.a0(this.f65266d);
        this.f65270h.setPullRefresh(this.f65271i);
        PbListView pbListView = new PbListView(this.f65263a.getPageActivity());
        this.m = pbListView;
        pbListView.a();
        d.a.q0.v.d.g.a.a aVar = new d.a.q0.v.d.g.a.a(this.f65263a);
        this.p = aVar;
        aVar.i0(2);
        d.a.q0.v.d.g.a.b bVar2 = new d.a.q0.v.d.g.a.b(this.f65263a);
        this.q = bVar2;
        bVar2.i0(2);
        this.o.add(this.p);
        this.o.add(this.q);
        this.f65270h.a(this.o);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f65270h.z();
        }
    }

    public BdTypeListView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65270h : (BdTypeListView) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f65267e : (View) invokeV.objValue;
    }

    public void g() {
        d.a.p0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.l) == null) {
            return;
        }
        gVar.dettachView(this.f65267e);
        this.l = null;
    }

    public void h() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.dettachView(this.f65267e);
        this.n = null;
    }

    public void i() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (pbListView = this.m) == null || pbListView.b().getParent() == null) {
            return;
        }
        this.f65270h.removeFooterView(this.m.b());
    }

    public void j(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i2) == null) {
            if (this.f65264b != i2) {
                this.f65264b = i2;
            }
            b bVar = this.r;
            if (bVar != null) {
                bVar.f();
            }
            d.a.p0.f0.g gVar = this.l;
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
            SkinManager.setBackgroundResource(this.f65267e, R.color.CAM_X0201);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.p0.f0.g gVar = this.l;
            if (gVar != null) {
                if (gVar.i() != null) {
                    this.l.dettachView(this.f65267e);
                }
                this.l.m();
                this.l = null;
            }
            g gVar2 = this.f65271i;
            if (gVar2 != null) {
                gVar2.a(null);
                this.f65271i.b(null);
                this.f65271i.l(null);
                this.f65271i.Y();
                this.f65271i = null;
            }
            BdTypeListView bdTypeListView = this.f65270h;
            if (bdTypeListView != null) {
                bdTypeListView.setOnSrollToBottomListener(null);
                this.f65270h.setOnScrollListener(null);
                this.f65270h.setRecyclerListener(null);
                this.f65270h = null;
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
            this.f65265c = fVar;
            d.a.q0.v.d.g.a.a aVar = this.p;
            if (aVar != null) {
                aVar.k0(fVar);
            }
            d.a.q0.v.d.g.a.b bVar = this.q;
            if (bVar != null) {
                bVar.k0(this.f65265c);
            }
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f65268f.setVisibility(i2);
        }
    }

    public void p(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || list == null || ListUtils.isEmpty(list) || (bdTypeListView = this.f65270h) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void q(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f65271i.a(gVar);
        }
    }

    public void r(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f65270h.setOnSrollToBottomListener(pVar);
        }
    }

    public void s(boolean z, List<String> list, String str, String str2, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), list, str, str2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                NavigationBar navigationBar = new NavigationBar(this.f65263a.getPageActivity());
                this.j = navigationBar;
                navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a(this));
                if (!StringUtils.isNull(str2)) {
                    this.j.setCenterTextTitle(str2);
                } else if (!StringUtils.isNull(str)) {
                    this.j.setCenterTextTitle(str);
                }
                this.f65267e.addView(this.j, 0, new LinearLayout.LayoutParams(-1, -2));
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
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.f65263a) == null || this.f65267e == null) {
            return;
        }
        if (this.l == null) {
            this.l = new d.a.p0.f0.g(tbPageContext.getPageActivity(), this.f65263a.getResources().getDimensionPixelSize(R.dimen.ds360));
        }
        d.a.p0.f0.g gVar = this.l;
        if (gVar != null) {
            gVar.attachView(this.f65267e, true);
        }
    }

    public void u(String str, View.OnClickListener onClickListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048593, this, str, onClickListener, z) == null) {
            if (this.n == null) {
                this.n = new h(this.f65263a.getPageActivity(), onClickListener);
            }
            this.n.j(this.f65263a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds180));
            this.n.l(str);
            this.n.attachView(this.f65267e, false);
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
            this.f65270h.setNextPage(this.m);
        }
        this.m.A(this.f65263a.getResources().getString(R.string.live_sub_tab_no_more_data));
        this.m.f();
    }
}
