package d.b.i0.m2;

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
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f56875a;

    /* renamed from: b  reason: collision with root package name */
    public View f56876b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f56877c;

    /* renamed from: d  reason: collision with root package name */
    public View f56878d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f56879e = null;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f56880f = null;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f56881g = null;

    /* renamed from: d.b.i0.m2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1346a implements View.OnClickListener {
        public View$OnClickListenerC1346a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f56879e.hasFocus()) {
                l.w(a.this.f56875a.getPageContext().getPageActivity(), a.this.f56879e);
            }
            a.this.f56875a.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                l.w(a.this.f56875a.getPageContext().getPageActivity(), view);
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
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 2 || i == 6 || i == 4 || i == 3) {
                String charSequence = textView.getText().toString();
                if (StringUtils.isNull(charSequence)) {
                    return true;
                }
                a.this.f56875a.startSearch(charSequence);
                PostSearchActivity unused = a.this.f56875a;
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", charSequence).param("obj_source", "1").param("obj_type", "2").param("fid", a.this.f56875a.mForumId));
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
            a.this.f56879e.setText("");
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
            a.this.f56875a.mSearchKey = obj;
            if (obj.trim().length() == 0) {
                a.this.n();
                a.this.f56880f.setVisibility(8);
                return;
            }
            a.this.f56880f.setVisibility(0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.J(a.this.f56875a.getPageContext().getPageActivity(), a.this.f56879e);
        }
    }

    public a(PostSearchActivity postSearchActivity, View view) {
        this.f56876b = view;
        this.f56875a = postSearchActivity;
        i();
    }

    public void f() {
        this.f56880f.setVisibility(8);
    }

    public void g() {
        this.f56876b.setFocusable(true);
        this.f56876b.setFocusableInTouchMode(true);
        this.f56876b.requestFocus();
    }

    public void h() {
        l.w(this.f56875a.getPageContext().getPageActivity(), this.f56879e);
    }

    public final void i() {
        NavigationBar navigationBar = (NavigationBar) this.f56876b.findViewById(R.id.view_navigation_bar);
        this.f56877c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1346a());
        View addCustomView = this.f56877c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.f56878d = addCustomView;
        this.f56879e = (EditText) addCustomView.findViewById(R.id.search_text);
        ImageView imageView = (ImageView) this.f56878d.findViewById(R.id.search_del);
        this.f56880f = imageView;
        imageView.setVisibility(8);
        this.f56879e.requestFocus();
        this.f56879e.setOnFocusChangeListener(new b());
        this.f56879e.setOnClickListener(new c());
        this.f56879e.setOnEditorActionListener(new d());
        this.f56880f.setOnClickListener(new e());
        this.f56879e.addTextChangedListener(new f());
        this.f56881g = new g();
        d.b.b.e.m.e.a().postDelayed(this.f56881g, 500L);
    }

    public void j(int i) {
        this.f56877c.onChangeSkinType(this.f56875a.getPageContext(), i);
        d.b.h0.s0.a.a(this.f56875a.getPageContext(), this.f56878d);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56880f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void k() {
        if (this.f56881g != null) {
            d.b.b.e.m.e.a().removeCallbacks(this.f56881g);
        }
    }

    public void l(String str) {
        this.f56879e.setText(str);
    }

    public final void m() {
        if (StringUtils.isNull(this.f56879e.getText().toString())) {
            return;
        }
        this.f56880f.setVisibility(0);
    }

    public final void n() {
        if (this.f56875a.isHistoryVisible()) {
            return;
        }
        this.f56875a.refreshHistoryList();
        if (this.f56879e.hasFocus()) {
            return;
        }
        this.f56879e.requestFocus();
        l.J(this.f56875a.getPageContext().getPageActivity(), this.f56879e);
    }
}
