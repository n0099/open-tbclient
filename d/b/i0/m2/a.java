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
    public PostSearchActivity f56876a;

    /* renamed from: b  reason: collision with root package name */
    public View f56877b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f56878c;

    /* renamed from: d  reason: collision with root package name */
    public View f56879d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f56880e = null;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f56881f = null;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f56882g = null;

    /* renamed from: d.b.i0.m2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1347a implements View.OnClickListener {
        public View$OnClickListenerC1347a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f56880e.hasFocus()) {
                l.w(a.this.f56876a.getPageContext().getPageActivity(), a.this.f56880e);
            }
            a.this.f56876a.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                l.w(a.this.f56876a.getPageContext().getPageActivity(), view);
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
                a.this.f56876a.startSearch(charSequence);
                PostSearchActivity unused = a.this.f56876a;
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", charSequence).param("obj_source", "1").param("obj_type", "2").param("fid", a.this.f56876a.mForumId));
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
            a.this.f56880e.setText("");
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
            a.this.f56876a.mSearchKey = obj;
            if (obj.trim().length() == 0) {
                a.this.n();
                a.this.f56881f.setVisibility(8);
                return;
            }
            a.this.f56881f.setVisibility(0);
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
            l.J(a.this.f56876a.getPageContext().getPageActivity(), a.this.f56880e);
        }
    }

    public a(PostSearchActivity postSearchActivity, View view) {
        this.f56877b = view;
        this.f56876a = postSearchActivity;
        i();
    }

    public void f() {
        this.f56881f.setVisibility(8);
    }

    public void g() {
        this.f56877b.setFocusable(true);
        this.f56877b.setFocusableInTouchMode(true);
        this.f56877b.requestFocus();
    }

    public void h() {
        l.w(this.f56876a.getPageContext().getPageActivity(), this.f56880e);
    }

    public final void i() {
        NavigationBar navigationBar = (NavigationBar) this.f56877b.findViewById(R.id.view_navigation_bar);
        this.f56878c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1347a());
        View addCustomView = this.f56878c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.f56879d = addCustomView;
        this.f56880e = (EditText) addCustomView.findViewById(R.id.search_text);
        ImageView imageView = (ImageView) this.f56879d.findViewById(R.id.search_del);
        this.f56881f = imageView;
        imageView.setVisibility(8);
        this.f56880e.requestFocus();
        this.f56880e.setOnFocusChangeListener(new b());
        this.f56880e.setOnClickListener(new c());
        this.f56880e.setOnEditorActionListener(new d());
        this.f56881f.setOnClickListener(new e());
        this.f56880e.addTextChangedListener(new f());
        this.f56882g = new g();
        d.b.b.e.m.e.a().postDelayed(this.f56882g, 500L);
    }

    public void j(int i) {
        this.f56878c.onChangeSkinType(this.f56876a.getPageContext(), i);
        d.b.h0.s0.a.a(this.f56876a.getPageContext(), this.f56879d);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56881f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void k() {
        if (this.f56882g != null) {
            d.b.b.e.m.e.a().removeCallbacks(this.f56882g);
        }
    }

    public void l(String str) {
        this.f56880e.setText(str);
    }

    public final void m() {
        if (StringUtils.isNull(this.f56880e.getText().toString())) {
            return;
        }
        this.f56881f.setVisibility(0);
    }

    public final void n() {
        if (this.f56876a.isHistoryVisible()) {
            return;
        }
        this.f56876a.refreshHistoryList();
        if (this.f56880e.hasFocus()) {
            return;
        }
        this.f56880e.requestFocus();
        l.J(this.f56876a.getPageContext().getPageActivity(), this.f56880e);
    }
}
