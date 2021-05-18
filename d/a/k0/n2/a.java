package d.a.k0.n2;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f57659a;

    /* renamed from: b  reason: collision with root package name */
    public View f57660b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f57661c;

    /* renamed from: d  reason: collision with root package name */
    public View f57662d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f57663e = null;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f57664f = null;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f57665g = null;

    /* renamed from: d.a.k0.n2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1439a implements View.OnClickListener {
        public View$OnClickListenerC1439a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f57663e.hasFocus()) {
                l.x(a.this.f57659a.getPageContext().getPageActivity(), a.this.f57663e);
            }
            a.this.f57659a.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                l.x(a.this.f57659a.getPageContext().getPageActivity(), view);
                return;
            }
            a.this.n();
            a.this.m();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.n();
            a.this.m();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements TextView.OnEditorActionListener {
        public d() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 == 2 || i2 == 6 || i2 == 4 || i2 == 3) {
                String charSequence = textView.getText().toString();
                if (StringUtils.isNull(charSequence)) {
                    return true;
                }
                a.this.f57659a.startSearch(charSequence);
                PostSearchActivity unused = a.this.f57659a;
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", charSequence).param("obj_source", "1").param("obj_type", "2").param("fid", a.this.f57659a.mForumId));
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f57663e.setText("");
            a.this.n();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements TextWatcher {
        public f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            a.this.f57659a.mSearchKey = obj;
            if (obj.trim().length() == 0) {
                a.this.n();
                a.this.f57664f.setVisibility(8);
                return;
            }
            a.this.f57664f.setVisibility(0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.K(a.this.f57659a.getPageContext().getPageActivity(), a.this.f57663e);
        }
    }

    public a(PostSearchActivity postSearchActivity, View view) {
        this.f57660b = view;
        this.f57659a = postSearchActivity;
        i();
    }

    public void f() {
        this.f57664f.setVisibility(8);
    }

    public void g() {
        this.f57660b.setFocusable(true);
        this.f57660b.setFocusableInTouchMode(true);
        this.f57660b.requestFocus();
    }

    public void h() {
        l.x(this.f57659a.getPageContext().getPageActivity(), this.f57663e);
    }

    public final void i() {
        NavigationBar navigationBar = (NavigationBar) this.f57660b.findViewById(R.id.view_navigation_bar);
        this.f57661c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1439a());
        View addCustomView = this.f57661c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.f57662d = addCustomView;
        this.f57663e = (EditText) addCustomView.findViewById(R.id.search_text);
        ImageView imageView = (ImageView) this.f57662d.findViewById(R.id.search_del);
        this.f57664f = imageView;
        imageView.setVisibility(8);
        this.f57663e.requestFocus();
        this.f57663e.setOnFocusChangeListener(new b());
        this.f57663e.setOnClickListener(new c());
        this.f57663e.setOnEditorActionListener(new d());
        this.f57664f.setOnClickListener(new e());
        this.f57663e.addTextChangedListener(new f());
        this.f57665g = new g();
        d.a.c.e.m.e.a().postDelayed(this.f57665g, 500L);
    }

    public void j(int i2) {
        this.f57661c.onChangeSkinType(this.f57659a.getPageContext(), i2);
        d.a.j0.s0.a.a(this.f57659a.getPageContext(), this.f57662d);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57664f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void k() {
        if (this.f57665g != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f57665g);
        }
    }

    public void l(String str) {
        this.f57663e.setText(str);
    }

    public final void m() {
        if (StringUtils.isNull(this.f57663e.getText().toString())) {
            return;
        }
        this.f57664f.setVisibility(0);
    }

    public final void n() {
        if (this.f57659a.isHistoryVisible()) {
            return;
        }
        this.f57659a.refreshHistoryList();
        if (this.f57663e.hasFocus()) {
            return;
        }
        this.f57663e.requestFocus();
        l.K(this.f57659a.getPageContext().getPageActivity(), this.f57663e);
    }
}
