package d.a.n0.g0.g;

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
import d.a.c.k.e.b;
import d.a.o0.e3.t;
/* loaded from: classes3.dex */
public class a extends b implements t {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContextSupport f53197f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53198g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f53199h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f53200i;
    public View j;
    public View k;
    public int l;
    public ViewGroup m;
    public int n;

    public a(TbPageContextSupport tbPageContextSupport) {
        this.f53197f = null;
        this.f53198g = null;
        this.f53199h = null;
        this.f53200i = null;
        this.j = null;
        this.f53197f = tbPageContextSupport;
        this.l = tbPageContextSupport.getPageContext().getResources().getDimensionPixelSize(R.dimen.ds16);
    }

    @Override // d.a.c.k.e.b
    public View a() {
        if (this.m == null) {
            this.j = LayoutInflater.from(this.f53197f.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        } else {
            this.j = LayoutInflater.from(this.f53197f.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, this.m, false);
        }
        View view = this.j;
        int i2 = this.l;
        view.setPadding(0, i2, 0, i2);
        if (this.n != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.j.getLayoutParams());
            layoutParams.height = this.n;
            this.j.setLayoutParams(layoutParams);
        }
        this.f53198g = (TextView) this.j.findViewById(R.id.pb_more_text);
        View findViewById = this.j.findViewById(R.id.pb_more_view);
        this.k = findViewById;
        findViewById.setVisibility(8);
        this.f53199h = (ProgressBar) this.j.findViewById(R.id.progress);
        onChangeSkinType(this.f53197f.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.k.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.j;
    }

    @Override // d.a.c.k.e.b
    public void c() {
        View.OnClickListener onClickListener = this.f53200i;
        if (onClickListener != null) {
            onClickListener.onClick(this.j);
        }
    }

    public void d() {
        this.k.setVisibility(0);
        View view = this.j;
        int i2 = this.l;
        view.setPadding(0, i2, 0, i2);
    }

    public void e() {
        this.k.setVisibility(8);
        this.j.setPadding(0, 0, 0, 0);
    }

    public void f(int i2) {
        this.f53199h.setVisibility(0);
        this.f53198g.setText(i2);
        this.k.setVisibility(0);
    }

    public void g(int i2) {
        this.f53199h.setVisibility(8);
        this.f53198g.setText(i2);
    }

    public void h(int i2) {
        this.n = i2;
    }

    @Override // d.a.o0.e3.t
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        this.f53197f.getPageContext().getLayoutMode().j(this.k);
        return true;
    }

    public a(TbPageContextSupport tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.m = viewGroup;
    }
}
