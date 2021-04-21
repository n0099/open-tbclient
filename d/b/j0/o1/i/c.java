package d.b.j0.o1.i;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import d.b.c.a.f;
import d.b.c.e.p.l;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f59249a;

    /* renamed from: b  reason: collision with root package name */
    public View f59250b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f59251c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f59252d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f59253e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59254f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f59255g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutDetectsSoftKeyboard f59256h;
    public FrameLayout i;
    public NoDataView j;
    public QuickWebView k;
    public QuickWebView l;
    public View m;
    public boolean n = true;
    public BdListView o;
    public d.b.j0.o1.h.a p;
    public d.b.j0.o1.h.b q;
    public View r;

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                c.this.f59256h.setFocusable(true);
                c.this.f59256h.setFocusableInTouchMode(true);
                if (c.this.f59252d.hasFocus()) {
                    l.w(c.this.f59249a, c.this.f59252d);
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
            c.this.f59252d.setText("");
        }
    }

    public c(View view, Context context) {
        this.f59250b = view;
        this.f59249a = context;
        m();
    }

    public void A(View.OnFocusChangeListener onFocusChangeListener) {
        this.f59252d.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void B(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f59252d.setHint(str);
    }

    public void C(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f59252d.setText(str);
        this.f59252d.setSelection(str.length());
    }

    public void D(TextWatcher textWatcher) {
        this.f59252d.addTextChangedListener(textWatcher);
    }

    public void E(List<String> list, String str) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        G();
        this.q.d(str);
        this.q.c(list);
        this.o.setAdapter((ListAdapter) this.q);
    }

    public void F(List<ForumInfo> list, String str) {
        if (ListUtils.isEmpty(list) || TextUtils.isEmpty(str)) {
            return;
        }
        G();
        this.p.e(str);
        this.p.d(list);
        this.o.setAdapter((ListAdapter) this.p);
    }

    public void G() {
        this.o.setVisibility(0);
        this.l.setVisibility(8);
        this.k.setVisibility(8);
        this.j.setVisibility(8);
    }

    public void H(BaseWebView.d dVar) {
        this.k.setOnLoadUrlListener(dVar);
    }

    public void I(BaseWebView.e eVar) {
        this.k.setOnPageFinishedListener(eVar);
    }

    public void J(BaseWebView.i iVar) {
        this.k.setOnReceivedSslErrorListener(iVar);
    }

    public void K(BaseWebView.h hVar) {
        this.k.setOnReceivedErrorListener(hVar);
    }

    public void L(boolean z) {
        this.n = z;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 0 && this.n) {
            this.m.setVisibility(0);
            this.m.setBackgroundColor(SkinManager.getColor(skinType == 4 ? R.color.CAM_X0606 : R.color.CAM_X0605));
            return;
        }
        this.m.setVisibility(8);
    }

    public TextView d() {
        return this.f59254f;
    }

    public QuickWebView e() {
        return this.l;
    }

    public QuickWebView f() {
        return this.k;
    }

    public EditText g() {
        return this.f59252d;
    }

    public final void h() {
        NavigationBar navigationBar = (NavigationBar) this.f59250b.findViewById(R.id.view_navigation_bar);
        this.f59251c = navigationBar;
        navigationBar.showBottomLine();
        View addCustomView = this.f59251c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.square_search_navigation_view, (View.OnClickListener) null);
        this.r = addCustomView;
        this.f59255g = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
        this.f59252d = (EditText) this.r.findViewById(R.id.home_et_search);
        this.f59253e = (ImageView) this.r.findViewById(R.id.home_bt_search_del);
        this.f59254f = (TextView) this.r.findViewById(R.id.home_bt_search_cancel_s);
        this.f59253e.setOnClickListener(new b());
        r(false);
        this.f59254f.setText(this.f59249a.getString(R.string.cancel));
    }

    public final void i() {
        QuickWebView quickWebView = (QuickWebView) this.f59250b.findViewById(R.id.search_history_webview);
        this.l = quickWebView;
        quickWebView.l(true);
        this.m = this.f59250b.findViewById(R.id.search_webview_mask);
    }

    public final void j() {
        QuickWebView quickWebView = (QuickWebView) this.f59250b.findViewById(R.id.search_result_webview);
        this.k = quickWebView;
        quickWebView.l(true);
    }

    public final void k() {
        this.o = (BdListView) this.f59250b.findViewById(R.id.home_lv_search_suggest);
        this.q = new d.b.j0.o1.h.b(this.f59249a, null);
        this.p = new d.b.j0.o1.h.a(this.f59249a, null);
    }

    public final void l() {
        this.f59252d.setText("");
        this.f59252d.requestFocus();
        this.f59254f.setText(this.f59249a.getString(R.string.cancel));
    }

    public final void m() {
        h();
        LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard = (LinearLayoutDetectsSoftKeyboard) this.f59250b.findViewById(R.id.search_container);
        this.f59256h = linearLayoutDetectsSoftKeyboard;
        linearLayoutDetectsSoftKeyboard.setOnTouchListener(new a());
        this.i = (FrameLayout) this.f59250b.findViewById(R.id.frame_layout);
        NoDataView a2 = NoDataViewFactory.a(this.f59249a, null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) this.f59249a.getResources().getDimension(R.dimen.ds200)), null, null);
        this.j = a2;
        this.i.addView(a2, 0);
        i();
        k();
        j();
        l();
    }

    public boolean n() {
        return this.o.getVisibility() == 0;
    }

    public void o(f<?> fVar, int i) {
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.f(fVar, i);
        }
        SkinManager.setBgColor(this.f59256h, i);
        if (i == 2) {
            this.f59252d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
        } else {
            this.f59252d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        this.f59251c.onChangeSkinType(fVar, i);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59253e, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setNavbarTitleColor(this.f59252d, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59255g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setBackgroundResource(this.i, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f59254f, R.color.CAM_X0302, 1);
        L(this.n);
        QuickWebView quickWebView = this.l;
        if (quickWebView != null) {
            quickWebView.onChangeSkinType();
        }
        QuickWebView quickWebView2 = this.k;
        if (quickWebView2 != null) {
            quickWebView2.onChangeSkinType();
        }
    }

    public void p() {
        try {
            if (this.i != null) {
                this.i.removeView(this.l);
                this.i.removeView(this.k);
            }
            this.l.removeAllViews();
            this.k.removeAllViews();
            if (this.l != null) {
                this.l.destroy();
                this.l = null;
            }
            if (this.k != null) {
                this.k.destroy();
                this.k = null;
            }
        } catch (Exception unused) {
        }
    }

    public void q() {
        if (StringUtils.isNull(this.f59252d.getText().toString())) {
            return;
        }
        this.r.setFocusable(true);
        this.r.setFocusableInTouchMode(true);
        this.r.requestFocus();
    }

    public void r(boolean z) {
        this.f59253e.setVisibility(z ? 0 : 8);
    }

    public void s() {
        this.l.setVisibility(0);
        this.o.setVisibility(8);
        this.k.setVisibility(8);
        this.j.setVisibility(8);
    }

    public void t(AdapterView.OnItemClickListener onItemClickListener) {
        this.o.setOnItemClickListener(onItemClickListener);
    }

    public void u(AbsListView.OnScrollListener onScrollListener) {
        this.o.setOnScrollListener(onScrollListener);
    }

    public void v(NoDataViewFactory.e eVar) {
        this.j.setTextOption(eVar);
    }

    public void w() {
        this.o.setVisibility(8);
        this.l.setVisibility(8);
        this.k.setVisibility(8);
        this.j.setVisibility(0);
    }

    public void x(View.OnClickListener onClickListener) {
        this.f59252d.setOnClickListener(onClickListener);
        this.f59254f.setOnClickListener(onClickListener);
    }

    public void y() {
        this.o.setVisibility(8);
        this.l.setVisibility(8);
        this.k.setVisibility(0);
        this.j.setVisibility(8);
    }

    public void z(TextView.OnEditorActionListener onEditorActionListener) {
        this.f59252d.setOnEditorActionListener(onEditorActionListener);
    }
}
