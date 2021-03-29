package d.b.i0.o1;

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
import d.b.b.e.p.l;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SearchMajorActivity f57258a;

    /* renamed from: b  reason: collision with root package name */
    public View f57259b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f57260c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f57261d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f57262e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f57263f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f57264g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f57265h;
    public LinearLayoutManager i;
    public SearchMajorResultItemAdapter j;
    public LinearLayout k;

    /* renamed from: d.b.i0.o1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC1371a implements View.OnTouchListener {
        public View$OnTouchListenerC1371a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.f57261d.setFocusable(true);
                a.this.f57261d.setFocusableInTouchMode(true);
                if (a.this.f57262e.hasFocus()) {
                    l.w(a.this.f57258a, a.this.f57262e);
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
            a.this.f57262e.setText("");
        }
    }

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.f57259b = view;
        this.f57258a = searchMajorActivity;
        h();
    }

    public LinearLayout d() {
        return this.k;
    }

    public final void e() {
        NavigationBar navigationBar = (NavigationBar) this.f57259b.findViewById(R.id.navigation_bar);
        this.f57260c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57260c.setCenterTextTitle(this.f57258a.getResources().getString(R.string.search_major));
    }

    public final void f() {
        RelativeLayout relativeLayout = (RelativeLayout) this.f57259b.findViewById(R.id.search_container);
        this.f57261d = relativeLayout;
        relativeLayout.setOnTouchListener(new View$OnTouchListenerC1371a());
        this.f57264g = (ImageView) this.f57259b.findViewById(R.id.search_icon);
        this.f57262e = (EditText) this.f57259b.findViewById(R.id.search_box);
        ImageView imageView = (ImageView) this.f57259b.findViewById(R.id.search_del);
        this.f57263f = imageView;
        imageView.setOnClickListener(new b());
        k(false);
        this.f57262e.setText("");
        this.f57262e.requestFocus();
    }

    public final void g() {
        this.k = (LinearLayout) this.f57259b.findViewById(R.id.layout_container);
        this.f57265h = (RecyclerView) this.f57259b.findViewById(R.id.rv_major_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f57258a);
        this.i = linearLayoutManager;
        this.f57265h.setLayoutManager(linearLayoutManager);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = new SearchMajorResultItemAdapter(this.f57258a);
        this.j = searchMajorResultItemAdapter;
        this.f57265h.setAdapter(searchMajorResultItemAdapter);
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
        this.f57260c.onChangeSkinType(this.f57258a.getPageContext(), i);
        this.f57262e.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
        this.f57262e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57264g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setBackgroundResource(this.f57261d, R.drawable.search_major_bg);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57263f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void j() {
        if (StringUtils.isNull(this.f57262e.getText().toString())) {
            return;
        }
        this.f57261d.setFocusable(true);
        this.f57261d.setFocusableInTouchMode(true);
        this.f57261d.requestFocus();
    }

    public void k(boolean z) {
        this.f57263f.setVisibility(z ? 0 : 8);
    }

    public void l(List<String> list, String str) {
        this.f57265h.setVisibility(0);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
        if (searchMajorResultItemAdapter != null) {
            searchMajorResultItemAdapter.g(str);
            this.j.setData(list);
            this.f57265h.setAdapter(this.j);
        }
    }

    public void m(ErrorData errorData) {
        this.f57265h.setVisibility(8);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
        if (searchMajorResultItemAdapter != null) {
            searchMajorResultItemAdapter.m();
        }
    }

    public void n(SearchMajorResultItemAdapter.b bVar) {
        this.j.n(bVar);
    }

    public void o(RecyclerView.OnScrollListener onScrollListener) {
        this.f57265h.addOnScrollListener(onScrollListener);
    }

    public void p(TextView.OnEditorActionListener onEditorActionListener) {
        this.f57262e.setOnEditorActionListener(onEditorActionListener);
    }

    public void q(View.OnFocusChangeListener onFocusChangeListener) {
        this.f57262e.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void r(TextWatcher textWatcher) {
        this.f57262e.addTextChangedListener(textWatcher);
    }
}
