package d.a.n0.q1;

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
    public SearchMajorActivity f61990a;

    /* renamed from: b  reason: collision with root package name */
    public View f61991b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61992c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f61993d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f61994e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f61995f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f61996g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f61997h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f61998i;
    public SearchMajorResultItemAdapter j;
    public LinearLayout k;

    /* renamed from: d.a.n0.q1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC1538a implements View.OnTouchListener {
        public View$OnTouchListenerC1538a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.f61993d.setFocusable(true);
                a.this.f61993d.setFocusableInTouchMode(true);
                if (a.this.f61994e.hasFocus()) {
                    l.x(a.this.f61990a, a.this.f61994e);
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
            a.this.f61994e.setText("");
        }
    }

    public a(View view, SearchMajorActivity searchMajorActivity) {
        this.f61991b = view;
        this.f61990a = searchMajorActivity;
        h();
    }

    public LinearLayout d() {
        return this.k;
    }

    public final void e() {
        NavigationBar navigationBar = (NavigationBar) this.f61991b.findViewById(R.id.navigation_bar);
        this.f61992c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61992c.setCenterTextTitle(this.f61990a.getResources().getString(R.string.search_major));
    }

    public final void f() {
        RelativeLayout relativeLayout = (RelativeLayout) this.f61991b.findViewById(R.id.search_container);
        this.f61993d = relativeLayout;
        relativeLayout.setOnTouchListener(new View$OnTouchListenerC1538a());
        this.f61996g = (ImageView) this.f61991b.findViewById(R.id.search_icon);
        this.f61994e = (EditText) this.f61991b.findViewById(R.id.search_box);
        ImageView imageView = (ImageView) this.f61991b.findViewById(R.id.search_del);
        this.f61995f = imageView;
        imageView.setOnClickListener(new b());
        k(false);
        this.f61994e.setText("");
        this.f61994e.requestFocus();
    }

    public final void g() {
        this.k = (LinearLayout) this.f61991b.findViewById(R.id.layout_container);
        this.f61997h = (RecyclerView) this.f61991b.findViewById(R.id.rv_major_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f61990a);
        this.f61998i = linearLayoutManager;
        this.f61997h.setLayoutManager(linearLayoutManager);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = new SearchMajorResultItemAdapter(this.f61990a);
        this.j = searchMajorResultItemAdapter;
        this.f61997h.setAdapter(searchMajorResultItemAdapter);
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
        this.f61992c.onChangeSkinType(this.f61990a.getPageContext(), i2);
        this.f61994e.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
        this.f61994e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f61996g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setBackgroundResource(this.f61993d, R.drawable.search_major_bg);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f61995f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void j() {
        if (StringUtils.isNull(this.f61994e.getText().toString())) {
            return;
        }
        this.f61993d.setFocusable(true);
        this.f61993d.setFocusableInTouchMode(true);
        this.f61993d.requestFocus();
    }

    public void k(boolean z) {
        this.f61995f.setVisibility(z ? 0 : 8);
    }

    public void l(List<String> list, String str) {
        this.f61997h.setVisibility(0);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
        if (searchMajorResultItemAdapter != null) {
            searchMajorResultItemAdapter.g(str);
            this.j.setData(list);
            this.f61997h.setAdapter(this.j);
        }
    }

    public void m(ErrorData errorData) {
        this.f61997h.setVisibility(8);
        SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
        if (searchMajorResultItemAdapter != null) {
            searchMajorResultItemAdapter.m();
        }
    }

    public void n(SearchMajorResultItemAdapter.b bVar) {
        this.j.n(bVar);
    }

    public void o(RecyclerView.OnScrollListener onScrollListener) {
        this.f61997h.addOnScrollListener(onScrollListener);
    }

    public void p(TextView.OnEditorActionListener onEditorActionListener) {
        this.f61994e.setOnEditorActionListener(onEditorActionListener);
    }

    public void q(View.OnFocusChangeListener onFocusChangeListener) {
        this.f61994e.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void r(TextWatcher textWatcher) {
        this.f61994e.addTextChangedListener(textWatcher);
    }
}
