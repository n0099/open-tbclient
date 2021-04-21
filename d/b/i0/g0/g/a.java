package d.b.i0.g0.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.c.j.e.b;
import d.b.j0.d3.t;
/* loaded from: classes3.dex */
public class a extends b implements t {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContextSupport f50963f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50964g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f50965h;
    public View.OnClickListener i;
    public View j;
    public View k;
    public int l;
    public ViewGroup m;
    public int n;

    public a(TbPageContextSupport tbPageContextSupport) {
        this.f50963f = null;
        this.f50964g = null;
        this.f50965h = null;
        this.i = null;
        this.j = null;
        this.f50963f = tbPageContextSupport;
        this.l = tbPageContextSupport.getPageContext().getResources().getDimensionPixelSize(R.dimen.ds16);
    }

    @Override // d.b.c.j.e.b
    public View a() {
        if (this.m == null) {
            this.j = LayoutInflater.from(this.f50963f.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        } else {
            this.j = LayoutInflater.from(this.f50963f.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, this.m, false);
        }
        View view = this.j;
        int i = this.l;
        view.setPadding(0, i, 0, i);
        if (this.n != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.j.getLayoutParams());
            layoutParams.height = this.n;
            this.j.setLayoutParams(layoutParams);
        }
        this.f50964g = (TextView) this.j.findViewById(R.id.pb_more_text);
        View findViewById = this.j.findViewById(R.id.pb_more_view);
        this.k = findViewById;
        findViewById.setVisibility(8);
        this.f50965h = (ProgressBar) this.j.findViewById(R.id.progress);
        onChangeSkinType(this.f50963f.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.k.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.j;
    }

    @Override // d.b.c.j.e.b
    public void c() {
        View.OnClickListener onClickListener = this.i;
        if (onClickListener != null) {
            onClickListener.onClick(this.j);
        }
    }

    public void d() {
        this.k.setVisibility(0);
        View view = this.j;
        int i = this.l;
        view.setPadding(0, i, 0, i);
    }

    public void e() {
        this.k.setVisibility(8);
        this.j.setPadding(0, 0, 0, 0);
    }

    public void f(int i) {
        this.f50965h.setVisibility(0);
        this.f50964g.setText(i);
        this.k.setVisibility(0);
    }

    public void g(int i) {
        this.f50965h.setVisibility(8);
        this.f50964g.setText(i);
    }

    public void h(int i) {
        this.n = i;
    }

    @Override // d.b.j0.d3.t
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.f50963f.getPageContext().getLayoutMode().j(this.k);
        return true;
    }

    public a(TbPageContextSupport tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.m = viewGroup;
    }
}
