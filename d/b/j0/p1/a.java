package d.b.j0.p1;

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
    public SearchMajorActivity f59325a;

    /* renamed from: b  reason: collision with root package name */
    public View f59326b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f59327c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f59328d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f59329e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f59330f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f59331g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f59332h;
    public LinearLayoutManager i;
    public SearchMajorResultItemAdapter j;
    public LinearLayout k;

    /* renamed from: d.b.j0.p1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC1452a implements View.OnTouchListener {
        public View$OnTouchListenerC1452a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.f59328d.setFocusable(true);
                a.this.f59328d.setFocusableInTouchMode(true);
                if (a.this.f59329e.hasFocus()) {
                    l.w(a.this.f59325a, a.this.f59329e);
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
            a.this.f59329e.setText("");
        }
    }

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.f59326b = view;
        this.f59325a = searchMajorActivity;
        h();
    }

    public LinearLayout d() {
        return this.k;
    }

    public final void e() {
        NavigationBar navigationBar = (NavigationBar) this.f59326b.findViewById(R.id.navigation_bar);
        this.f59327c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f59327c.setCenterTextTitle(this.f59325a.getResources().getString(R.string.search_major));
    }

    public final void f() {
        RelativeLayout relativeLayout = (RelativeLayout) this.f59326b.findViewById(R.id.search_container);
        this.f59328d = relativeLayout;
        relativeLayout.setOnTouchListener(new View$OnTouchListenerC1452a());
        this.f59331g = (ImageView) this.f59326b.findViewById(R.id.search_icon);
        this.f59329e = (EditText) this.f59326b.findViewById(R.id.search_box);
        ImageView imageView = (ImageView) this.f59326b.findViewById(R.id.search_del);
        this.f59330f = imageView;
        imageView.setOnClickListener(new b());
        k(false);
        this.f59329e.setText("");
        this.f59329e.requestFocus();
    }

    public final void g() {
        this.k = (LinearLayout) this.f59326b.findViewById(R.id.layout_container);
        this.f59332h = (RecyclerView) this.f59326b.findViewById(R.id.rv_major_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f59325a);
        this.i = linearLayoutManager;
        this.f59332h.setLayoutManager(linearLayoutManager);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = new SearchMajorResultItemAdapter(this.f59325a);
        this.j = searchMajorResultItemAdapter;
        this.f59332h.setAdapter(searchMajorResultItemAdapter);
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
        this.f59327c.onChangeSkinType(this.f59325a.getPageContext(), i);
        this.f59329e.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
        this.f59329e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59331g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setBackgroundResource(this.f59328d, R.drawable.search_major_bg);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59330f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void j() {
        if (StringUtils.isNull(this.f59329e.getText().toString())) {
            return;
        }
        this.f59328d.setFocusable(true);
        this.f59328d.setFocusableInTouchMode(true);
        this.f59328d.requestFocus();
    }

    public void k(boolean z) {
        this.f59330f.setVisibility(z ? 0 : 8);
    }

    public void l(List<String> list, String str) {
        this.f59332h.setVisibility(0);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
        if (searchMajorResultItemAdapter != null) {
            searchMajorResultItemAdapter.g(str);
            this.j.setData(list);
            this.f59332h.setAdapter(this.j);
        }
    }

    public void m(ErrorData errorData) {
        this.f59332h.setVisibility(8);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
        if (searchMajorResultItemAdapter != null) {
            searchMajorResultItemAdapter.m();
        }
    }

    public void n(SearchMajorResultItemAdapter.b bVar) {
        this.j.n(bVar);
    }

    public void o(RecyclerView.OnScrollListener onScrollListener) {
        this.f59332h.addOnScrollListener(onScrollListener);
    }

    public void p(TextView.OnEditorActionListener onEditorActionListener) {
        this.f59329e.setOnEditorActionListener(onEditorActionListener);
    }

    public void q(View.OnFocusChangeListener onFocusChangeListener) {
        this.f59329e.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void r(TextWatcher textWatcher) {
        this.f59329e.addTextChangedListener(textWatcher);
    }
}
