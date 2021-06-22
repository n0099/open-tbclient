package d.a.o0.o2;

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
    public PostSearchActivity f61645a;

    /* renamed from: b  reason: collision with root package name */
    public View f61646b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61647c;

    /* renamed from: d  reason: collision with root package name */
    public View f61648d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f61649e = null;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f61650f = null;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f61651g = null;

    /* renamed from: d.a.o0.o2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1515a implements View.OnClickListener {
        public View$OnClickListenerC1515a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f61649e.hasFocus()) {
                l.x(a.this.f61645a.getPageContext().getPageActivity(), a.this.f61649e);
            }
            a.this.f61645a.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                l.x(a.this.f61645a.getPageContext().getPageActivity(), view);
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
                a.this.f61645a.startSearch(charSequence);
                PostSearchActivity unused = a.this.f61645a;
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", charSequence).param("obj_source", "1").param("obj_type", "2").param("fid", a.this.f61645a.mForumId));
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
            a.this.f61649e.setText("");
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
            a.this.f61645a.mSearchKey = obj;
            if (obj.trim().length() == 0) {
                a.this.n();
                a.this.f61650f.setVisibility(8);
                return;
            }
            a.this.f61650f.setVisibility(0);
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
            l.K(a.this.f61645a.getPageContext().getPageActivity(), a.this.f61649e);
        }
    }

    public a(PostSearchActivity postSearchActivity, View view) {
        this.f61646b = view;
        this.f61645a = postSearchActivity;
        i();
    }

    public void f() {
        this.f61650f.setVisibility(8);
    }

    public void g() {
        this.f61646b.setFocusable(true);
        this.f61646b.setFocusableInTouchMode(true);
        this.f61646b.requestFocus();
    }

    public void h() {
        l.x(this.f61645a.getPageContext().getPageActivity(), this.f61649e);
    }

    public final void i() {
        NavigationBar navigationBar = (NavigationBar) this.f61646b.findViewById(R.id.view_navigation_bar);
        this.f61647c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1515a());
        View addCustomView = this.f61647c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.f61648d = addCustomView;
        this.f61649e = (EditText) addCustomView.findViewById(R.id.search_text);
        ImageView imageView = (ImageView) this.f61648d.findViewById(R.id.search_del);
        this.f61650f = imageView;
        imageView.setVisibility(8);
        this.f61649e.requestFocus();
        this.f61649e.setOnFocusChangeListener(new b());
        this.f61649e.setOnClickListener(new c());
        this.f61649e.setOnEditorActionListener(new d());
        this.f61650f.setOnClickListener(new e());
        this.f61649e.addTextChangedListener(new f());
        this.f61651g = new g();
        d.a.c.e.m.e.a().postDelayed(this.f61651g, 500L);
    }

    public void j(int i2) {
        this.f61647c.onChangeSkinType(this.f61645a.getPageContext(), i2);
        d.a.n0.s0.a.a(this.f61645a.getPageContext(), this.f61648d);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f61650f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void k() {
        if (this.f61651g != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f61651g);
        }
    }

    public void l(String str) {
        this.f61649e.setText(str);
    }

    public final void m() {
        if (StringUtils.isNull(this.f61649e.getText().toString())) {
            return;
        }
        this.f61650f.setVisibility(0);
    }

    public final void n() {
        if (this.f61645a.isHistoryVisible()) {
            return;
        }
        this.f61645a.refreshHistoryList();
        if (this.f61649e.hasFocus()) {
            return;
        }
        this.f61649e.requestFocus();
        l.K(this.f61645a.getPageContext().getPageActivity(), this.f61649e);
    }
}
