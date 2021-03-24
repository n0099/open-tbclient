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
    public SearchMajorActivity f57257a;

    /* renamed from: b  reason: collision with root package name */
    public View f57258b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f57259c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f57260d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f57261e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f57262f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f57263g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f57264h;
    public LinearLayoutManager i;
    public SearchMajorResultItemAdapter j;
    public LinearLayout k;

    /* renamed from: d.b.i0.o1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC1370a implements View.OnTouchListener {
        public View$OnTouchListenerC1370a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.f57260d.setFocusable(true);
                a.this.f57260d.setFocusableInTouchMode(true);
                if (a.this.f57261e.hasFocus()) {
                    l.w(a.this.f57257a, a.this.f57261e);
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
            a.this.f57261e.setText("");
        }
    }

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.f57258b = view;
        this.f57257a = searchMajorActivity;
        h();
    }

    public LinearLayout d() {
        return this.k;
    }

    public final void e() {
        NavigationBar navigationBar = (NavigationBar) this.f57258b.findViewById(R.id.navigation_bar);
        this.f57259c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57259c.setCenterTextTitle(this.f57257a.getResources().getString(R.string.search_major));
    }

    public final void f() {
        RelativeLayout relativeLayout = (RelativeLayout) this.f57258b.findViewById(R.id.search_container);
        this.f57260d = relativeLayout;
        relativeLayout.setOnTouchListener(new View$OnTouchListenerC1370a());
        this.f57263g = (ImageView) this.f57258b.findViewById(R.id.search_icon);
        this.f57261e = (EditText) this.f57258b.findViewById(R.id.search_box);
        ImageView imageView = (ImageView) this.f57258b.findViewById(R.id.search_del);
        this.f57262f = imageView;
        imageView.setOnClickListener(new b());
        k(false);
        this.f57261e.setText("");
        this.f57261e.requestFocus();
    }

    public final void g() {
        this.k = (LinearLayout) this.f57258b.findViewById(R.id.layout_container);
        this.f57264h = (RecyclerView) this.f57258b.findViewById(R.id.rv_major_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f57257a);
        this.i = linearLayoutManager;
        this.f57264h.setLayoutManager(linearLayoutManager);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = new SearchMajorResultItemAdapter(this.f57257a);
        this.j = searchMajorResultItemAdapter;
        this.f57264h.setAdapter(searchMajorResultItemAdapter);
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
        this.f57259c.onChangeSkinType(this.f57257a.getPageContext(), i);
        this.f57261e.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
        this.f57261e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57263g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setBackgroundResource(this.f57260d, R.drawable.search_major_bg);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57262f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void j() {
        if (StringUtils.isNull(this.f57261e.getText().toString())) {
            return;
        }
        this.f57260d.setFocusable(true);
        this.f57260d.setFocusableInTouchMode(true);
        this.f57260d.requestFocus();
    }

    public void k(boolean z) {
        this.f57262f.setVisibility(z ? 0 : 8);
    }

    public void l(List<String> list, String str) {
        this.f57264h.setVisibility(0);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
        if (searchMajorResultItemAdapter != null) {
            searchMajorResultItemAdapter.g(str);
            this.j.setData(list);
            this.f57264h.setAdapter(this.j);
        }
    }

    public void m(ErrorData errorData) {
        this.f57264h.setVisibility(8);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
        if (searchMajorResultItemAdapter != null) {
            searchMajorResultItemAdapter.m();
        }
    }

    public void n(SearchMajorResultItemAdapter.b bVar) {
        this.j.n(bVar);
    }

    public void o(RecyclerView.OnScrollListener onScrollListener) {
        this.f57264h.addOnScrollListener(onScrollListener);
    }

    public void p(TextView.OnEditorActionListener onEditorActionListener) {
        this.f57261e.setOnEditorActionListener(onEditorActionListener);
    }

    public void q(View.OnFocusChangeListener onFocusChangeListener) {
        this.f57261e.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void r(TextWatcher textWatcher) {
        this.f57261e.addTextChangedListener(textWatcher);
    }
}
