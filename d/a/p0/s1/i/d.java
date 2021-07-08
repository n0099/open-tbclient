package d.a.p0.s1.i;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
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
import d.a.c.a.f;
import d.a.c.e.p.l;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f62166a;

    /* renamed from: b  reason: collision with root package name */
    public View f62167b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62168c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f62169d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f62170e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62171f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f62172g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62173h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutDetectsSoftKeyboard f62174i;
    public FrameLayout j;
    public NoDataView k;
    public QuickWebView l;
    public QuickWebView m;
    public View n;
    public boolean o;
    public BdListView p;
    public d.a.p0.s1.h.a q;
    public d.a.p0.s1.h.b r;
    public View s;

    /* loaded from: classes8.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62175e;

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
            this.f62175e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f62175e.f62174i.setFocusable(true);
                    this.f62175e.f62174i.setFocusableInTouchMode(true);
                    if (this.f62175e.f62169d.hasFocus()) {
                        l.x(this.f62175e.f62166a, this.f62175e.f62169d);
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
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62176e;

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
            this.f62176e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62176e.f62169d.setText("");
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
        this.f62173h = true;
        this.o = true;
        this.f62167b = view;
        this.f62166a = context;
        m();
    }

    public void A(View.OnFocusChangeListener onFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onFocusChangeListener) == null) {
            this.f62169d.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f62169d.setHint(str);
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f62169d.setText(str);
        this.f62169d.setSelection(str.length());
    }

    public void D(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, textWatcher) == null) {
            this.f62169d.addTextChangedListener(textWatcher);
        }
    }

    public void E(List<String> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, list, str) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        G();
        this.r.d(str);
        this.r.c(list);
        this.p.setAdapter((ListAdapter) this.r);
    }

    public void F(List<ForumInfo> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, list, str) == null) || ListUtils.isEmpty(list) || TextUtils.isEmpty(str)) {
            return;
        }
        G();
        this.q.e(str);
        this.q.d(list);
        this.p.setAdapter((ListAdapter) this.q);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.p.setVisibility(0);
            this.m.setVisibility(8);
            this.l.setVisibility(8);
            this.k.setVisibility(8);
        }
    }

    public void H(BaseWebView.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.l.setOnLoadUrlListener(dVar);
        }
    }

    public void I(BaseWebView.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.l.setOnPageFinishedListener(eVar);
        }
    }

    public void J(BaseWebView.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iVar) == null) {
            this.l.setOnReceivedSslErrorListener(iVar);
        }
    }

    public void K(BaseWebView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hVar) == null) {
            this.l.setOnReceivedErrorListener(hVar);
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.o = z;
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 0 && this.o) {
                this.n.setVisibility(0);
                this.n.setBackgroundColor(SkinManager.getColor(skinType == 4 ? R.color.CAM_X0606 : R.color.CAM_X0605));
                return;
            }
            this.n.setVisibility(8);
        }
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f62171f : (TextView) invokeV.objValue;
    }

    public QuickWebView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.m : (QuickWebView) invokeV.objValue;
    }

    public QuickWebView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.l : (QuickWebView) invokeV.objValue;
    }

    public EditText g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f62169d : (EditText) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f62167b.findViewById(R.id.view_navigation_bar);
            this.f62168c = navigationBar;
            navigationBar.showBottomLine();
            View addCustomView = this.f62168c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
            this.s = addCustomView;
            this.f62172g = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
            this.f62169d = (EditText) this.s.findViewById(R.id.home_et_search);
            this.f62170e = (ImageView) this.s.findViewById(R.id.home_bt_search_del);
            this.f62171f = (TextView) this.s.findViewById(R.id.home_bt_search_cancel_s);
            this.f62170e.setOnClickListener(new b(this));
            r(false);
            this.f62171f.setText(this.f62166a.getString(R.string.cancel));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            QuickWebView quickWebView = (QuickWebView) this.f62167b.findViewById(R.id.search_history_webview);
            this.m = quickWebView;
            quickWebView.l(true);
            this.n = this.f62167b.findViewById(R.id.search_webview_mask);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            QuickWebView quickWebView = (QuickWebView) this.f62167b.findViewById(R.id.search_result_webview);
            this.l = quickWebView;
            quickWebView.l(true);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.p = (BdListView) this.f62167b.findViewById(R.id.home_lv_search_suggest);
            this.r = new d.a.p0.s1.h.b(this.f62166a, null);
            this.q = new d.a.p0.s1.h.a(this.f62166a, null);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f62169d.setText("");
            this.f62169d.requestFocus();
            this.f62171f.setText(this.f62166a.getString(R.string.cancel));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            h();
            LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard = (LinearLayoutDetectsSoftKeyboard) this.f62167b.findViewById(R.id.search_container);
            this.f62174i = linearLayoutDetectsSoftKeyboard;
            linearLayoutDetectsSoftKeyboard.setOnTouchListener(new a(this));
            this.j = (FrameLayout) this.f62167b.findViewById(R.id.frame_layout);
            NoDataView a2 = NoDataViewFactory.a(this.f62166a, null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) this.f62166a.getResources().getDimension(R.dimen.ds200)), null, null);
            this.k = a2;
            this.j.addView(a2, 0);
            i();
            k();
            j();
            l();
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.p.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void o(f<?> fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, fVar, i2) == null) {
            NoDataView noDataView = this.k;
            if (noDataView != null) {
                noDataView.f(fVar, i2);
            }
            SkinManager.setBgColor(this.f62174i, i2);
            if (i2 == 2) {
                this.f62169d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
            } else {
                this.f62169d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            }
            this.f62168c.onChangeSkinType(fVar, i2);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62170e, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.f62169d, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62172g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            SkinManager.setBackgroundResource(this.j, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f62171f, R.color.CAM_X0302, 1);
            L(this.o);
            QuickWebView quickWebView = this.m;
            if (quickWebView != null) {
                quickWebView.onChangeSkinType();
            }
            QuickWebView quickWebView2 = this.l;
            if (quickWebView2 != null) {
                quickWebView2.onChangeSkinType();
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            try {
                if (this.j != null) {
                    this.j.removeView(this.m);
                    this.j.removeView(this.l);
                }
                this.m.removeAllViews();
                this.l.removeAllViews();
                if (this.m != null) {
                    this.m.destroy();
                    this.m = null;
                }
                if (this.l != null) {
                    this.l.destroy();
                    this.l = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (!StringUtils.isNull(this.f62169d.getText().toString())) {
                this.s.setFocusable(true);
                this.s.setFocusableInTouchMode(true);
                this.s.requestFocus();
            }
            if (CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.WEB && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NONE && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NATIVE_WEB && !this.f62173h) {
                QuickWebView quickWebView = this.l;
                if (quickWebView != null && quickWebView.getVisibility() == 0) {
                    this.l.sendNotification(CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
                }
                QuickWebView quickWebView2 = this.m;
                if (quickWebView2 != null && quickWebView2.getVisibility() == 0) {
                    this.m.sendNotification(CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
                }
            }
            this.f62173h = false;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.f62170e.setVisibility(z ? 0 : 8);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.m.setVisibility(0);
            this.p.setVisibility(8);
            this.l.setVisibility(8);
            this.k.setVisibility(8);
        }
    }

    public void t(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onItemClickListener) == null) {
            this.p.setOnItemClickListener(onItemClickListener);
        }
    }

    public void u(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onScrollListener) == null) {
            this.p.setOnScrollListener(onScrollListener);
        }
    }

    public void v(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, eVar) == null) {
            this.k.setTextOption(eVar);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.p.setVisibility(8);
            this.m.setVisibility(8);
            this.l.setVisibility(8);
            this.k.setVisibility(0);
        }
    }

    public void x(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onClickListener) == null) {
            this.f62169d.setOnClickListener(onClickListener);
            this.f62171f.setOnClickListener(onClickListener);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.p.setVisibility(8);
            this.m.setVisibility(8);
            this.l.setVisibility(0);
            this.k.setVisibility(8);
        }
    }

    public void z(TextView.OnEditorActionListener onEditorActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onEditorActionListener) == null) {
            this.f62169d.setOnEditorActionListener(onEditorActionListener);
        }
    }
}
