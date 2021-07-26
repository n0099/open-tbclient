package d.a.q0.s1.i;

import android.content.Context;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.QuickWebView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
import d.a.d.e.p.l;
import tbclient.SearchSug.DataRes;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f62810a;

    /* renamed from: b  reason: collision with root package name */
    public View f62811b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62812c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f62813d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f62814e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62815f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f62816g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f62817h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f62818i;
    public boolean j;
    public LinearLayoutDetectsSoftKeyboard k;
    public FrameLayout l;
    public NoDataView m;
    public QuickWebView n;
    public QuickWebView o;
    public View p;
    public boolean q;
    public BdTypeRecyclerView r;
    public d.a.q0.s1.h.b s;
    public final RecyclerView.OnScrollListener t;
    public View u;

    /* loaded from: classes8.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f62819a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62819a = dVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 2 || i2 == 1) {
                    l.x(this.f62819a.f62810a, recyclerView);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62820e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62820e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f62820e.k.setFocusable(true);
                    this.f62820e.k.setFocusableInTouchMode(true);
                    if (this.f62820e.f62813d.hasFocus()) {
                        l.x(this.f62820e.f62810a, this.f62820e.f62813d);
                        return false;
                    }
                    return false;
                }
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
        public final /* synthetic */ d f62821e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62821e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62821e.f62813d.setText("");
            }
        }
    }

    public d(View view, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = true;
        this.q = true;
        this.t = new a(this);
        this.f62811b = view;
        this.f62810a = context;
        m();
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f62813d.setText(str);
        this.f62813d.setSelection(str.length());
    }

    public void B(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textWatcher) == null) {
            this.f62813d.addTextChangedListener(textWatcher);
        }
    }

    public void C(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) == null) || dataRes == null) {
            return;
        }
        D();
        d.a.q0.s1.h.b bVar = this.s;
        if (bVar != null) {
            bVar.c(dataRes, str);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.r.setVisibility(0);
            this.o.setVisibility(8);
            this.n.setVisibility(8);
            this.m.setVisibility(8);
            this.f62818i.setBackgroundResource(0);
        }
    }

    public void E(BaseWebView.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.n.setOnLoadUrlListener(dVar);
        }
    }

    public void F(BaseWebView.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.n.setOnPageFinishedListener(eVar);
        }
    }

    public void G(BaseWebView.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iVar) == null) {
            this.n.setOnReceivedSslErrorListener(iVar);
        }
    }

    public void H(BaseWebView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) {
            this.n.setOnReceivedErrorListener(hVar);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.q = z;
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 0 && this.q) {
                this.p.setVisibility(0);
                this.p.setBackgroundColor(SkinManager.getColor(skinType == 4 ? R.color.CAM_X0606 : R.color.CAM_X0605));
                return;
            }
            this.p.setVisibility(8);
        }
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f62815f : (TextView) invokeV.objValue;
    }

    public QuickWebView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : (QuickWebView) invokeV.objValue;
    }

    public QuickWebView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.n : (QuickWebView) invokeV.objValue;
    }

    public EditText g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f62813d : (EditText) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f62811b.findViewById(R.id.view_navigation_bar);
            this.f62812c = navigationBar;
            navigationBar.showBottomLine();
            View addCustomView = this.f62812c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
            this.u = addCustomView;
            this.f62816g = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
            this.f62813d = (EditText) this.u.findViewById(R.id.home_et_search);
            this.f62814e = (ImageView) this.u.findViewById(R.id.home_bt_search_del);
            this.f62815f = (TextView) this.u.findViewById(R.id.home_bt_search_cancel_s);
            this.f62817h = (LinearLayout) this.u.findViewById(R.id.ll_home_bt_search_left);
            this.f62818i = (RelativeLayout) this.u.findViewById(R.id.root_home_bt_search);
            this.f62814e.setOnClickListener(new c(this));
            r(false);
            this.f62815f.setText(this.f62810a.getString(R.string.cancel));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            QuickWebView quickWebView = (QuickWebView) this.f62811b.findViewById(R.id.search_history_webview);
            this.o = quickWebView;
            quickWebView.l(true);
            this.p = this.f62811b.findViewById(R.id.search_webview_mask);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            QuickWebView quickWebView = (QuickWebView) this.f62811b.findViewById(R.id.search_result_webview);
            this.n = quickWebView;
            quickWebView.l(true);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f62811b.findViewById(R.id.home_lv_search_suggest);
            this.r = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f62810a));
            this.r.setOnScrollListener(this.t);
            this.s = new d.a.q0.s1.h.b(this.f62810a, this.r);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f62813d.setText("");
            this.f62813d.requestFocus();
            this.f62815f.setText(this.f62810a.getString(R.string.cancel));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            h();
            LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard = (LinearLayoutDetectsSoftKeyboard) this.f62811b.findViewById(R.id.search_container);
            this.k = linearLayoutDetectsSoftKeyboard;
            linearLayoutDetectsSoftKeyboard.setOnTouchListener(new b(this));
            this.l = (FrameLayout) this.f62811b.findViewById(R.id.frame_layout);
            NoDataView a2 = NoDataViewFactory.a(this.f62810a, null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) this.f62810a.getResources().getDimension(R.dimen.ds200)), null, null);
            this.m = a2;
            this.l.addView(a2, 0);
            i();
            k();
            j();
            l();
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.r.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void o(f<?> fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, fVar, i2) == null) {
            NoDataView noDataView = this.m;
            if (noDataView != null) {
                noDataView.f(fVar, i2);
            }
            d.a.q0.s1.h.b bVar = this.s;
            if (bVar != null) {
                bVar.b();
            }
            SkinManager.setBgColor(this.k, i2);
            if (i2 == 2) {
                this.f62813d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
            } else {
                this.f62813d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            }
            this.f62812c.onChangeSkinType(fVar, i2);
            WebPManager.setPureDrawable(this.f62814e, R.drawable.icon_search_empty, R.color.CAM_X0109, null);
            SkinManager.setNavbarTitleColor(this.f62813d, R.color.CAM_X0105, R.color.s_navbar_title_color);
            WebPManager.setPureDrawable(this.f62816g, R.drawable.icon_search_scan, R.color.CAM_X0109, null);
            SkinManager.setBackgroundResource(this.l, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f62815f, R.color.CAM_X0107, 1);
            I(this.q);
            QuickWebView quickWebView = this.o;
            if (quickWebView != null) {
                quickWebView.onChangeSkinType();
            }
            QuickWebView quickWebView2 = this.n;
            if (quickWebView2 != null) {
                quickWebView2.onChangeSkinType();
            }
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.f62817h);
            d2.t(R.color.CAM_X0109);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0210);
            BdTypeRecyclerView bdTypeRecyclerView = this.r;
            if (bdTypeRecyclerView != null) {
                if (bdTypeRecyclerView.getVisibility() == 0) {
                    this.f62818i.setBackgroundResource(0);
                } else {
                    d.a.p0.s.u.c.d(this.f62818i).o(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
                }
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            try {
                if (this.l != null) {
                    this.l.removeView(this.o);
                    this.l.removeView(this.n);
                }
                this.o.removeAllViews();
                this.n.removeAllViews();
                if (this.o != null) {
                    this.o.destroy();
                    this.o = null;
                }
                if (this.n != null) {
                    this.n.destroy();
                    this.n = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (!StringUtils.isNull(this.f62813d.getText().toString())) {
                this.u.setFocusable(true);
                this.u.setFocusableInTouchMode(true);
                this.u.requestFocus();
            }
            if (CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.WEB && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NONE && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NATIVE_WEB && !this.j) {
                QuickWebView quickWebView = this.n;
                if (quickWebView != null && quickWebView.getVisibility() == 0) {
                    this.n.sendNotification(CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
                }
                QuickWebView quickWebView2 = this.o;
                if (quickWebView2 != null && quickWebView2.getVisibility() == 0) {
                    this.o.sendNotification(CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
                }
            }
            this.j = false;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f62814e.setVisibility(z ? 0 : 8);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.o.setVisibility(0);
            this.r.setVisibility(8);
            this.n.setVisibility(8);
            this.m.setVisibility(8);
            d.a.p0.s.u.c.d(this.f62818i).o(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
        }
    }

    public void t(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, eVar) == null) {
            this.m.setTextOption(eVar);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.r.setVisibility(8);
            this.o.setVisibility(8);
            this.n.setVisibility(8);
            this.m.setVisibility(0);
            d.a.p0.s.u.c.d(this.f62818i).o(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
        }
    }

    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
            this.f62813d.setOnClickListener(onClickListener);
            this.f62815f.setOnClickListener(onClickListener);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.r.setVisibility(8);
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            this.m.setVisibility(8);
            d.a.p0.s.u.c.d(this.f62818i).o(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
        }
    }

    public void x(TextView.OnEditorActionListener onEditorActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onEditorActionListener) == null) {
            this.f62813d.setOnEditorActionListener(onEditorActionListener);
        }
    }

    public void y(View.OnFocusChangeListener onFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onFocusChangeListener) == null) {
            this.f62813d.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f62813d.setHint(str);
    }
}
