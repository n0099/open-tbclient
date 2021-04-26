package d.a.j0.n2;

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
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f56952a;

    /* renamed from: b  reason: collision with root package name */
    public View f56953b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f56954c;

    /* renamed from: d  reason: collision with root package name */
    public View f56955d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f56956e = null;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f56957f = null;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f56958g = null;

    /* renamed from: d.a.j0.n2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1367a implements View.OnClickListener {
        public View$OnClickListenerC1367a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f56956e.hasFocus()) {
                l.x(a.this.f56952a.getPageContext().getPageActivity(), a.this.f56956e);
            }
            a.this.f56952a.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                l.x(a.this.f56952a.getPageContext().getPageActivity(), view);
                return;
            }
            a.this.n();
            a.this.m();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.n();
            a.this.m();
        }
    }

    /* loaded from: classes4.dex */
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
                a.this.f56952a.startSearch(charSequence);
                PostSearchActivity unused = a.this.f56952a;
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", charSequence).param("obj_source", "1").param("obj_type", "2").param("fid", a.this.f56952a.mForumId));
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f56956e.setText("");
            a.this.n();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements TextWatcher {
        public f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            a.this.f56952a.mSearchKey = obj;
            if (obj.trim().length() == 0) {
                a.this.n();
                a.this.f56957f.setVisibility(8);
                return;
            }
            a.this.f56957f.setVisibility(0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.K(a.this.f56952a.getPageContext().getPageActivity(), a.this.f56956e);
        }
    }

    public a(PostSearchActivity postSearchActivity, View view) {
        this.f56953b = view;
        this.f56952a = postSearchActivity;
        i();
    }

    public void f() {
        this.f56957f.setVisibility(8);
    }

    public void g() {
        this.f56953b.setFocusable(true);
        this.f56953b.setFocusableInTouchMode(true);
        this.f56953b.requestFocus();
    }

    public void h() {
        l.x(this.f56952a.getPageContext().getPageActivity(), this.f56956e);
    }

    public final void i() {
        NavigationBar navigationBar = (NavigationBar) this.f56953b.findViewById(R.id.view_navigation_bar);
        this.f56954c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1367a());
        View addCustomView = this.f56954c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.f56955d = addCustomView;
        this.f56956e = (EditText) addCustomView.findViewById(R.id.search_text);
        ImageView imageView = (ImageView) this.f56955d.findViewById(R.id.search_del);
        this.f56957f = imageView;
        imageView.setVisibility(8);
        this.f56956e.requestFocus();
        this.f56956e.setOnFocusChangeListener(new b());
        this.f56956e.setOnClickListener(new c());
        this.f56956e.setOnEditorActionListener(new d());
        this.f56957f.setOnClickListener(new e());
        this.f56956e.addTextChangedListener(new f());
        this.f56958g = new g();
        d.a.c.e.m.e.a().postDelayed(this.f56958g, 500L);
    }

    public void j(int i2) {
        this.f56954c.onChangeSkinType(this.f56952a.getPageContext(), i2);
        d.a.i0.s0.a.a(this.f56952a.getPageContext(), this.f56955d);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56957f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void k() {
        if (this.f56958g != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f56958g);
        }
    }

    public void l(String str) {
        this.f56956e.setText(str);
    }

    public final void m() {
        if (StringUtils.isNull(this.f56956e.getText().toString())) {
            return;
        }
        this.f56957f.setVisibility(0);
    }

    public final void n() {
        if (this.f56952a.isHistoryVisible()) {
            return;
        }
        this.f56952a.refreshHistoryList();
        if (this.f56956e.hasFocus()) {
            return;
        }
        this.f56956e.requestFocus();
        l.K(this.f56952a.getPageContext().getPageActivity(), this.f56956e);
    }
}
