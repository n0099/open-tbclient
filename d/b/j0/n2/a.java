package d.b.j0.n2;

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
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f58934a;

    /* renamed from: b  reason: collision with root package name */
    public View f58935b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f58936c;

    /* renamed from: d  reason: collision with root package name */
    public View f58937d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f58938e = null;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f58939f = null;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f58940g = null;

    /* renamed from: d.b.j0.n2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1428a implements View.OnClickListener {
        public View$OnClickListenerC1428a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f58938e.hasFocus()) {
                l.w(a.this.f58934a.getPageContext().getPageActivity(), a.this.f58938e);
            }
            a.this.f58934a.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                l.w(a.this.f58934a.getPageContext().getPageActivity(), view);
                return;
            }
            a.this.n();
            a.this.m();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.n();
            a.this.m();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements TextView.OnEditorActionListener {
        public d() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 2 || i == 6 || i == 4 || i == 3) {
                String charSequence = textView.getText().toString();
                if (StringUtils.isNull(charSequence)) {
                    return true;
                }
                a.this.f58934a.startSearch(charSequence);
                PostSearchActivity unused = a.this.f58934a;
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", charSequence).param("obj_source", "1").param("obj_type", "2").param("fid", a.this.f58934a.mForumId));
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f58938e.setText("");
            a.this.n();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements TextWatcher {
        public f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            a.this.f58934a.mSearchKey = obj;
            if (obj.trim().length() == 0) {
                a.this.n();
                a.this.f58939f.setVisibility(8);
                return;
            }
            a.this.f58939f.setVisibility(0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.J(a.this.f58934a.getPageContext().getPageActivity(), a.this.f58938e);
        }
    }

    public a(PostSearchActivity postSearchActivity, View view) {
        this.f58935b = view;
        this.f58934a = postSearchActivity;
        i();
    }

    public void f() {
        this.f58939f.setVisibility(8);
    }

    public void g() {
        this.f58935b.setFocusable(true);
        this.f58935b.setFocusableInTouchMode(true);
        this.f58935b.requestFocus();
    }

    public void h() {
        l.w(this.f58934a.getPageContext().getPageActivity(), this.f58938e);
    }

    public final void i() {
        NavigationBar navigationBar = (NavigationBar) this.f58935b.findViewById(R.id.view_navigation_bar);
        this.f58936c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1428a());
        View addCustomView = this.f58936c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.f58937d = addCustomView;
        this.f58938e = (EditText) addCustomView.findViewById(R.id.search_text);
        ImageView imageView = (ImageView) this.f58937d.findViewById(R.id.search_del);
        this.f58939f = imageView;
        imageView.setVisibility(8);
        this.f58938e.requestFocus();
        this.f58938e.setOnFocusChangeListener(new b());
        this.f58938e.setOnClickListener(new c());
        this.f58938e.setOnEditorActionListener(new d());
        this.f58939f.setOnClickListener(new e());
        this.f58938e.addTextChangedListener(new f());
        this.f58940g = new g();
        d.b.c.e.m.e.a().postDelayed(this.f58940g, 500L);
    }

    public void j(int i) {
        this.f58936c.onChangeSkinType(this.f58934a.getPageContext(), i);
        d.b.i0.s0.a.a(this.f58934a.getPageContext(), this.f58937d);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58939f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void k() {
        if (this.f58940g != null) {
            d.b.c.e.m.e.a().removeCallbacks(this.f58940g);
        }
    }

    public void l(String str) {
        this.f58938e.setText(str);
    }

    public final void m() {
        if (StringUtils.isNull(this.f58938e.getText().toString())) {
            return;
        }
        this.f58939f.setVisibility(0);
    }

    public final void n() {
        if (this.f58934a.isHistoryVisible()) {
            return;
        }
        this.f58934a.refreshHistoryList();
        if (this.f58938e.hasFocus()) {
            return;
        }
        this.f58938e.requestFocus();
        l.J(this.f58934a.getPageContext().getPageActivity(), this.f58938e);
    }
}
