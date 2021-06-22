package d.a.o0.q1;

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
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SearchMajorActivity f62115a;

    /* renamed from: b  reason: collision with root package name */
    public View f62116b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62117c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f62118d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f62119e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f62120f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f62121g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f62122h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f62123i;
    public SearchMajorResultItemAdapter j;
    public LinearLayout k;

    /* renamed from: d.a.o0.q1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC1542a implements View.OnTouchListener {
        public View$OnTouchListenerC1542a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.f62118d.setFocusable(true);
                a.this.f62118d.setFocusableInTouchMode(true);
                if (a.this.f62119e.hasFocus()) {
                    l.x(a.this.f62115a, a.this.f62119e);
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
            a.this.f62119e.setText("");
        }
    }

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.f62116b = view;
        this.f62115a = searchMajorActivity;
        h();
    }

    public LinearLayout d() {
        return this.k;
    }

    public final void e() {
        NavigationBar navigationBar = (NavigationBar) this.f62116b.findViewById(R.id.navigation_bar);
        this.f62117c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62117c.setCenterTextTitle(this.f62115a.getResources().getString(R.string.search_major));
    }

    public final void f() {
        RelativeLayout relativeLayout = (RelativeLayout) this.f62116b.findViewById(R.id.search_container);
        this.f62118d = relativeLayout;
        relativeLayout.setOnTouchListener(new View$OnTouchListenerC1542a());
        this.f62121g = (ImageView) this.f62116b.findViewById(R.id.search_icon);
        this.f62119e = (EditText) this.f62116b.findViewById(R.id.search_box);
        ImageView imageView = (ImageView) this.f62116b.findViewById(R.id.search_del);
        this.f62120f = imageView;
        imageView.setOnClickListener(new b());
        k(false);
        this.f62119e.setText("");
        this.f62119e.requestFocus();
    }

    public final void g() {
        this.k = (LinearLayout) this.f62116b.findViewById(R.id.layout_container);
        this.f62122h = (RecyclerView) this.f62116b.findViewById(R.id.rv_major_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f62115a);
        this.f62123i = linearLayoutManager;
        this.f62122h.setLayoutManager(linearLayoutManager);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = new SearchMajorResultItemAdapter(this.f62115a);
        this.j = searchMajorResultItemAdapter;
        this.f62122h.setAdapter(searchMajorResultItemAdapter);
    }

    public final void h() {
        e();
        f();
        g();
    }

    public void i(int i2) {
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
        if (searchMajorResultItemAdapter != null) {
            searchMajorResultItemAdapter.notifyDataSetChanged();
        }
        this.f62117c.onChangeSkinType(this.f62115a.getPageContext(), i2);
        this.f62119e.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
        this.f62119e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62121g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setBackgroundResource(this.f62118d, R.drawable.search_major_bg);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62120f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void j() {
        if (StringUtils.isNull(this.f62119e.getText().toString())) {
            return;
        }
        this.f62118d.setFocusable(true);
        this.f62118d.setFocusableInTouchMode(true);
        this.f62118d.requestFocus();
    }

    public void k(boolean z) {
        this.f62120f.setVisibility(z ? 0 : 8);
    }

    public void l(List<String> list, String str) {
        this.f62122h.setVisibility(0);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
        if (searchMajorResultItemAdapter != null) {
            searchMajorResultItemAdapter.g(str);
            this.j.setData(list);
            this.f62122h.setAdapter(this.j);
        }
    }

    public void m(ErrorData errorData) {
        this.f62122h.setVisibility(8);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
        if (searchMajorResultItemAdapter != null) {
            searchMajorResultItemAdapter.m();
        }
    }

    public void n(SearchMajorResultItemAdapter.b bVar) {
        this.j.n(bVar);
    }

    public void o(RecyclerView.OnScrollListener onScrollListener) {
        this.f62122h.addOnScrollListener(onScrollListener);
    }

    public void p(TextView.OnEditorActionListener onEditorActionListener) {
        this.f62119e.setOnEditorActionListener(onEditorActionListener);
    }

    public void q(View.OnFocusChangeListener onFocusChangeListener) {
        this.f62119e.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void r(TextWatcher textWatcher) {
        this.f62119e.addTextChangedListener(textWatcher);
    }
}
