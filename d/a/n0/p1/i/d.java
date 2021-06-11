package d.a.n0.p1.i;

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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
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
import d.a.c.a.f;
import d.a.c.e.p.l;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public Context f61802a;

    /* renamed from: b  reason: collision with root package name */
    public View f61803b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61804c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f61805d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f61806e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61807f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f61808g;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutDetectsSoftKeyboard f61810i;
    public FrameLayout j;
    public NoDataView k;
    public QuickWebView l;
    public QuickWebView m;
    public View n;
    public BdListView p;
    public d.a.n0.p1.h.a q;
    public d.a.n0.p1.h.b r;
    public View s;

    /* renamed from: h  reason: collision with root package name */
    public boolean f61809h = true;
    public boolean o = true;

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                d.this.f61810i.setFocusable(true);
                d.this.f61810i.setFocusableInTouchMode(true);
                if (d.this.f61805d.hasFocus()) {
                    l.x(d.this.f61802a, d.this.f61805d);
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.f61805d.setText("");
        }
    }

    public d(View view, Context context) {
        this.f61803b = view;
        this.f61802a = context;
        m();
    }

    public void A(View.OnFocusChangeListener onFocusChangeListener) {
        this.f61805d.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void B(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f61805d.setHint(str);
    }

    public void C(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f61805d.setText(str);
        this.f61805d.setSelection(str.length());
    }

    public void D(TextWatcher textWatcher) {
        this.f61805d.addTextChangedListener(textWatcher);
    }

    public void E(List<String> list, String str) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        G();
        this.r.d(str);
        this.r.c(list);
        this.p.setAdapter((ListAdapter) this.r);
    }

    public void F(List<ForumInfo> list, String str) {
        if (ListUtils.isEmpty(list) || TextUtils.isEmpty(str)) {
            return;
        }
        G();
        this.q.e(str);
        this.q.d(list);
        this.p.setAdapter((ListAdapter) this.q);
    }

    public void G() {
        this.p.setVisibility(0);
        this.m.setVisibility(8);
        this.l.setVisibility(8);
        this.k.setVisibility(8);
    }

    public void H(BaseWebView.d dVar) {
        this.l.setOnLoadUrlListener(dVar);
    }

    public void I(BaseWebView.e eVar) {
        this.l.setOnPageFinishedListener(eVar);
    }

    public void J(BaseWebView.i iVar) {
        this.l.setOnReceivedSslErrorListener(iVar);
    }

    public void K(BaseWebView.h hVar) {
        this.l.setOnReceivedErrorListener(hVar);
    }

    public void L(boolean z) {
        this.o = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.o) {
            this.n.setVisibility(0);
            this.n.setBackgroundColor(SkinManager.getColor(skinType == 4 ? R.color.CAM_X0606 : R.color.CAM_X0605));
            return;
        }
        this.n.setVisibility(8);
    }

    public TextView d() {
        return this.f61807f;
    }

    public QuickWebView e() {
        return this.m;
    }

    public QuickWebView f() {
        return this.l;
    }

    public EditText g() {
        return this.f61805d;
    }

    public final void h() {
        NavigationBar navigationBar = (NavigationBar) this.f61803b.findViewById(R.id.view_navigation_bar);
        this.f61804c = navigationBar;
        navigationBar.showBottomLine();
        View addCustomView = this.f61804c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.s = addCustomView;
        this.f61808g = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
        this.f61805d = (EditText) this.s.findViewById(R.id.home_et_search);
        this.f61806e = (ImageView) this.s.findViewById(R.id.home_bt_search_del);
        this.f61807f = (TextView) this.s.findViewById(R.id.home_bt_search_cancel_s);
        this.f61806e.setOnClickListener(new b());
        r(false);
        this.f61807f.setText(this.f61802a.getString(R.string.cancel));
    }

    public final void i() {
        QuickWebView quickWebView = (QuickWebView) this.f61803b.findViewById(R.id.search_history_webview);
        this.m = quickWebView;
        quickWebView.l(true);
        this.n = this.f61803b.findViewById(R.id.search_webview_mask);
    }

    public final void j() {
        QuickWebView quickWebView = (QuickWebView) this.f61803b.findViewById(R.id.search_result_webview);
        this.l = quickWebView;
        quickWebView.l(true);
    }

    public final void k() {
        this.p = (BdListView) this.f61803b.findViewById(R.id.home_lv_search_suggest);
        this.r = new d.a.n0.p1.h.b(this.f61802a, null);
        this.q = new d.a.n0.p1.h.a(this.f61802a, null);
    }

    public final void l() {
        this.f61805d.setText("");
        this.f61805d.requestFocus();
        this.f61807f.setText(this.f61802a.getString(R.string.cancel));
    }

    public final void m() {
        h();
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard = (LinearLayoutDetectsSoftKeyboard) this.f61803b.findViewById(R.id.search_container);
        this.f61810i = linearLayoutDetectsSoftKeyboard;
        linearLayoutDetectsSoftKeyboard.setOnTouchListener(new a());
        this.j = (FrameLayout) this.f61803b.findViewById(R.id.frame_layout);
        NoDataView a2 = NoDataViewFactory.a(this.f61802a, null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) this.f61802a.getResources().getDimension(R.dimen.ds200)), null, null);
        this.k = a2;
        this.j.addView(a2, 0);
        i();
        k();
        j();
        l();
    }

    public boolean n() {
        return this.p.getVisibility() == 0;
    }

    public void o(f<?> fVar, int i2) {
        NoDataView noDataView = this.k;
        if (noDataView != null) {
            noDataView.f(fVar, i2);
        }
        SkinManager.setBgColor(this.f61810i, i2);
        if (i2 == 2) {
            this.f61805d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
        } else {
            this.f61805d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        this.f61804c.onChangeSkinType(fVar, i2);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f61806e, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setNavbarTitleColor(this.f61805d, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f61808g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setBackgroundResource(this.j, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f61807f, R.color.CAM_X0302, 1);
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

    public void p() {
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

    public void q() {
        if (!StringUtils.isNull(this.f61805d.getText().toString())) {
            this.s.setFocusable(true);
            this.s.setFocusableInTouchMode(true);
            this.s.requestFocus();
        }
        if (CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.WEB && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NONE && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NATIVE_WEB && !this.f61809h) {
            QuickWebView quickWebView = this.l;
            if (quickWebView != null && quickWebView.getVisibility() == 0) {
                this.l.sendNotification(CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
            }
            QuickWebView quickWebView2 = this.m;
            if (quickWebView2 != null && quickWebView2.getVisibility() == 0) {
                this.m.sendNotification(CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
            }
        }
        this.f61809h = false;
    }

    public void r(boolean z) {
        this.f61806e.setVisibility(z ? 0 : 8);
    }

    public void s() {
        this.m.setVisibility(0);
        this.p.setVisibility(8);
        this.l.setVisibility(8);
        this.k.setVisibility(8);
    }

    public void t(AdapterView.OnItemClickListener onItemClickListener) {
        this.p.setOnItemClickListener(onItemClickListener);
    }

    public void u(AbsListView.OnScrollListener onScrollListener) {
        this.p.setOnScrollListener(onScrollListener);
    }

    public void v(NoDataViewFactory.e eVar) {
        this.k.setTextOption(eVar);
    }

    public void w() {
        this.p.setVisibility(8);
        this.m.setVisibility(8);
        this.l.setVisibility(8);
        this.k.setVisibility(0);
    }

    public void x(View.OnClickListener onClickListener) {
        this.f61805d.setOnClickListener(onClickListener);
        this.f61807f.setOnClickListener(onClickListener);
    }

    public void y() {
        this.p.setVisibility(8);
        this.m.setVisibility(8);
        this.l.setVisibility(0);
        this.k.setVisibility(8);
    }

    public void z(TextView.OnEditorActionListener onEditorActionListener) {
        this.f61805d.setOnEditorActionListener(onEditorActionListener);
    }
}
