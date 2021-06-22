package d.a.o0.r0.k2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import d.a.o0.r0.e1;
import d.a.o0.r0.k2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class g implements d.a.o0.r0.k2.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f62656a;

    /* renamed from: b  reason: collision with root package name */
    public e.InterfaceC1564e f62657b;

    /* renamed from: c  reason: collision with root package name */
    public List<e1> f62658c;

    /* renamed from: d  reason: collision with root package name */
    public View f62659d;

    /* renamed from: e  reason: collision with root package name */
    public View f62660e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f62661f;

    /* renamed from: g  reason: collision with root package name */
    public e f62662g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f62663h = new a();

    /* loaded from: classes4.dex */
    public class a implements TabMenuPopView.c {
        public a() {
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, e1 e1Var) {
            if (g.this.f62662g != null) {
                g.this.f62662g.c();
            }
            g.this.f62657b.a(e1Var.f62265b);
        }
    }

    @Override // d.a.o0.r0.k2.a
    public void a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return;
        }
        this.f62656a = context;
        this.f62662g = eVar;
        this.f62657b = eVar.d();
        View inflate = LayoutInflater.from(this.f62656a).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
        this.f62659d = inflate;
        this.f62660e = inflate.findViewById(R.id.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f62659d.findViewById(R.id.categorycontainer);
        this.f62661f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f62663h);
    }

    @Override // d.a.o0.r0.k2.a
    public int b() {
        this.f62659d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.f62659d.getMeasuredHeight();
    }

    @Override // d.a.o0.r0.k2.a
    public View getView() {
        return this.f62659d;
    }

    @Override // d.a.o0.r0.k2.a
    public void setData(List<e1> list) {
        if (list == null) {
            return;
        }
        this.f62658c = list;
        e1 e1Var = new e1();
        e1Var.f62265b = 0;
        e1Var.f62264a = this.f62656a.getResources().getString(R.string.all);
        e1Var.f62266c = false;
        SkinManager.setBackgroundColor(this.f62659d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f62660e, R.color.CAM_X0204);
        this.f62661f.setData(this.f62658c, e1Var);
    }
}
