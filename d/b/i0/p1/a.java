package d.b.i0.p1;

import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.SearchMajorActivity;
import com.baidu.tieba.majorsearch.adapter.SearchMajorResultItemAdapter;
import d.b.c.e.p.l;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SearchMajorActivity f58904a;

    /* renamed from: b  reason: collision with root package name */
    public View f58905b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f58906c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f58907d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f58908e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f58909f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f58910g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f58911h;
    public LinearLayoutManager i;
    public SearchMajorResultItemAdapter j;
    public LinearLayout k;

    /* renamed from: d.b.i0.p1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC1429a implements View.OnTouchListener {
        public View$OnTouchListenerC1429a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.f58907d.setFocusable(true);
                a.this.f58907d.setFocusableInTouchMode(true);
                if (a.this.f58908e.hasFocus()) {
                    l.w(a.this.f58904a, a.this.f58908e);
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
            a.this.f58908e.setText("");
        }
    }

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.f58905b = view;
        this.f58904a = searchMajorActivity;
        h();
    }

    public LinearLayout d() {
        return this.k;
    }

    public final void e() {
        NavigationBar navigationBar = (NavigationBar) this.f58905b.findViewById(R.id.navigation_bar);
        this.f58906c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58906c.setCenterTextTitle(this.f58904a.getResources().getString(R.string.search_major));
    }

    public final void f() {
        RelativeLayout relativeLayout = (RelativeLayout) this.f58905b.findViewById(R.id.search_container);
        this.f58907d = relativeLayout;
        relativeLayout.setOnTouchListener(new View$OnTouchListenerC1429a());
        this.f58910g = (ImageView) this.f58905b.findViewById(R.id.search_icon);
        this.f58908e = (EditText) this.f58905b.findViewById(R.id.search_box);
        ImageView imageView = (ImageView) this.f58905b.findViewById(R.id.search_del);
        this.f58909f = imageView;
        imageView.setOnClickListener(new b());
        k(false);
        this.f58908e.setText("");
        this.f58908e.requestFocus();
    }

    public final void g() {
        this.k = (LinearLayout) this.f58905b.findViewById(R.id.layout_container);
        this.f58911h = (RecyclerView) this.f58905b.findViewById(R.id.rv_major_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f58904a);
        this.i = linearLayoutManager;
        this.f58911h.setLayoutManager(linearLayoutManager);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = new SearchMajorResultItemAdapter(this.f58904a);
        this.j = searchMajorResultItemAdapter;
        this.f58911h.setAdapter(searchMajorResultItemAdapter);
    }

    public final void h() {
        e();
        f();
        g();
    }

    public void i(int i) {
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
        if (searchMajorResultItemAdapter != null) {
            searchMajorResultItemAdapter.notifyDataSetChanged();
        }
        this.f58906c.onChangeSkinType(this.f58904a.getPageContext(), i);
        this.f58908e.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
        this.f58908e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58910g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setBackgroundResource(this.f58907d, R.drawable.search_major_bg);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58909f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void j() {
        if (StringUtils.isNull(this.f58908e.getText().toString())) {
            return;
        }
        this.f58907d.setFocusable(true);
        this.f58907d.setFocusableInTouchMode(true);
        this.f58907d.requestFocus();
    }

    public void k(boolean z) {
        this.f58909f.setVisibility(z ? 0 : 8);
    }

    public void l(List<String> list, String str) {
        this.f58911h.setVisibility(0);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
        if (searchMajorResultItemAdapter != null) {
            searchMajorResultItemAdapter.g(str);
            this.j.setData(list);
            this.f58911h.setAdapter(this.j);
        }
    }

    public void m(ErrorData errorData) {
        this.f58911h.setVisibility(8);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
        if (searchMajorResultItemAdapter != null) {
            searchMajorResultItemAdapter.m();
        }
    }

    public void n(SearchMajorResultItemAdapter.b bVar) {
        this.j.n(bVar);
    }

    public void o(RecyclerView.OnScrollListener onScrollListener) {
        this.f58911h.addOnScrollListener(onScrollListener);
    }

    public void p(TextView.OnEditorActionListener onEditorActionListener) {
        this.f58908e.setOnEditorActionListener(onEditorActionListener);
    }

    public void q(View.OnFocusChangeListener onFocusChangeListener) {
        this.f58908e.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void r(TextWatcher textWatcher) {
        this.f58908e.addTextChangedListener(textWatcher);
    }
}
