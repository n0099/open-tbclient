package d.b.i0.n2;

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
    public PostSearchActivity f58513a;

    /* renamed from: b  reason: collision with root package name */
    public View f58514b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f58515c;

    /* renamed from: d  reason: collision with root package name */
    public View f58516d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f58517e = null;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f58518f = null;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f58519g = null;

    /* renamed from: d.b.i0.n2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1405a implements View.OnClickListener {
        public View$OnClickListenerC1405a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f58517e.hasFocus()) {
                l.w(a.this.f58513a.getPageContext().getPageActivity(), a.this.f58517e);
            }
            a.this.f58513a.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                l.w(a.this.f58513a.getPageContext().getPageActivity(), view);
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
                a.this.f58513a.startSearch(charSequence);
                PostSearchActivity unused = a.this.f58513a;
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", charSequence).param("obj_source", "1").param("obj_type", "2").param("fid", a.this.f58513a.mForumId));
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
            a.this.f58517e.setText("");
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
            a.this.f58513a.mSearchKey = obj;
            if (obj.trim().length() == 0) {
                a.this.n();
                a.this.f58518f.setVisibility(8);
                return;
            }
            a.this.f58518f.setVisibility(0);
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
            l.J(a.this.f58513a.getPageContext().getPageActivity(), a.this.f58517e);
        }
    }

    public a(PostSearchActivity postSearchActivity, View view) {
        this.f58514b = view;
        this.f58513a = postSearchActivity;
        i();
    }

    public void f() {
        this.f58518f.setVisibility(8);
    }

    public void g() {
        this.f58514b.setFocusable(true);
        this.f58514b.setFocusableInTouchMode(true);
        this.f58514b.requestFocus();
    }

    public void h() {
        l.w(this.f58513a.getPageContext().getPageActivity(), this.f58517e);
    }

    public final void i() {
        NavigationBar navigationBar = (NavigationBar) this.f58514b.findViewById(R.id.view_navigation_bar);
        this.f58515c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1405a());
        View addCustomView = this.f58515c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.f58516d = addCustomView;
        this.f58517e = (EditText) addCustomView.findViewById(R.id.search_text);
        ImageView imageView = (ImageView) this.f58516d.findViewById(R.id.search_del);
        this.f58518f = imageView;
        imageView.setVisibility(8);
        this.f58517e.requestFocus();
        this.f58517e.setOnFocusChangeListener(new b());
        this.f58517e.setOnClickListener(new c());
        this.f58517e.setOnEditorActionListener(new d());
        this.f58518f.setOnClickListener(new e());
        this.f58517e.addTextChangedListener(new f());
        this.f58519g = new g();
        d.b.c.e.m.e.a().postDelayed(this.f58519g, 500L);
    }

    public void j(int i) {
        this.f58515c.onChangeSkinType(this.f58513a.getPageContext(), i);
        d.b.h0.s0.a.a(this.f58513a.getPageContext(), this.f58516d);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58518f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void k() {
        if (this.f58519g != null) {
            d.b.c.e.m.e.a().removeCallbacks(this.f58519g);
        }
    }

    public void l(String str) {
        this.f58517e.setText(str);
    }

    public final void m() {
        if (StringUtils.isNull(this.f58517e.getText().toString())) {
            return;
        }
        this.f58518f.setVisibility(0);
    }

    public final void n() {
        if (this.f58513a.isHistoryVisible()) {
            return;
        }
        this.f58513a.refreshHistoryList();
        if (this.f58517e.hasFocus()) {
            return;
        }
        this.f58517e.requestFocus();
        l.J(this.f58513a.getPageContext().getPageActivity(), this.f58517e);
    }
}
