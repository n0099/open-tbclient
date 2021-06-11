package d.a.n0.o2;

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
    public PostSearchActivity f61520a;

    /* renamed from: b  reason: collision with root package name */
    public View f61521b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61522c;

    /* renamed from: d  reason: collision with root package name */
    public View f61523d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f61524e = null;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f61525f = null;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f61526g = null;

    /* renamed from: d.a.n0.o2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1511a implements View.OnClickListener {
        public View$OnClickListenerC1511a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f61524e.hasFocus()) {
                l.x(a.this.f61520a.getPageContext().getPageActivity(), a.this.f61524e);
            }
            a.this.f61520a.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                l.x(a.this.f61520a.getPageContext().getPageActivity(), view);
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
                a.this.f61520a.startSearch(charSequence);
                PostSearchActivity unused = a.this.f61520a;
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", charSequence).param("obj_source", "1").param("obj_type", "2").param("fid", a.this.f61520a.mForumId));
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
            a.this.f61524e.setText("");
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
            a.this.f61520a.mSearchKey = obj;
            if (obj.trim().length() == 0) {
                a.this.n();
                a.this.f61525f.setVisibility(8);
                return;
            }
            a.this.f61525f.setVisibility(0);
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
            l.K(a.this.f61520a.getPageContext().getPageActivity(), a.this.f61524e);
        }
    }

    public a(PostSearchActivity postSearchActivity, View view) {
        this.f61521b = view;
        this.f61520a = postSearchActivity;
        i();
    }

    public void f() {
        this.f61525f.setVisibility(8);
    }

    public void g() {
        this.f61521b.setFocusable(true);
        this.f61521b.setFocusableInTouchMode(true);
        this.f61521b.requestFocus();
    }

    public void h() {
        l.x(this.f61520a.getPageContext().getPageActivity(), this.f61524e);
    }

    public final void i() {
        NavigationBar navigationBar = (NavigationBar) this.f61521b.findViewById(R.id.view_navigation_bar);
        this.f61522c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View$OnClickListenerC1511a());
        View addCustomView = this.f61522c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.post_search_navigation_view, (View.OnClickListener) null);
        this.f61523d = addCustomView;
        this.f61524e = (EditText) addCustomView.findViewById(R.id.search_text);
        ImageView imageView = (ImageView) this.f61523d.findViewById(R.id.search_del);
        this.f61525f = imageView;
        imageView.setVisibility(8);
        this.f61524e.requestFocus();
        this.f61524e.setOnFocusChangeListener(new b());
        this.f61524e.setOnClickListener(new c());
        this.f61524e.setOnEditorActionListener(new d());
        this.f61525f.setOnClickListener(new e());
        this.f61524e.addTextChangedListener(new f());
        this.f61526g = new g();
        d.a.c.e.m.e.a().postDelayed(this.f61526g, 500L);
    }

    public void j(int i2) {
        this.f61522c.onChangeSkinType(this.f61520a.getPageContext(), i2);
        d.a.m0.s0.a.a(this.f61520a.getPageContext(), this.f61523d);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f61525f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void k() {
        if (this.f61526g != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f61526g);
        }
    }

    public void l(String str) {
        this.f61524e.setText(str);
    }

    public final void m() {
        if (StringUtils.isNull(this.f61524e.getText().toString())) {
            return;
        }
        this.f61525f.setVisibility(0);
    }

    public final void n() {
        if (this.f61520a.isHistoryVisible()) {
            return;
        }
        this.f61520a.refreshHistoryList();
        if (this.f61524e.hasFocus()) {
            return;
        }
        this.f61524e.requestFocus();
        l.K(this.f61520a.getPageContext().getPageActivity(), this.f61524e);
    }
}
