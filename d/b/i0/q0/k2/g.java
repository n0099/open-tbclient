package d.b.i0.q0.k2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import d.b.i0.q0.e1;
import d.b.i0.q0.k2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class g implements d.b.i0.q0.k2.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f59464a;

    /* renamed from: b  reason: collision with root package name */
    public e.InterfaceC1455e f59465b;

    /* renamed from: c  reason: collision with root package name */
    public List<e1> f59466c;

    /* renamed from: d  reason: collision with root package name */
    public View f59467d;

    /* renamed from: e  reason: collision with root package name */
    public View f59468e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f59469f;

    /* renamed from: g  reason: collision with root package name */
    public e f59470g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f59471h = new a();

    /* loaded from: classes4.dex */
    public class a implements TabMenuPopView.c {
        public a() {
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, e1 e1Var) {
            if (g.this.f59470g != null) {
                g.this.f59470g.c();
            }
            g.this.f59465b.a(e1Var.f59102b);
        }
    }

    @Override // d.b.i0.q0.k2.a
    public void a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return;
        }
        this.f59464a = context;
        this.f59470g = eVar;
        this.f59465b = eVar.d();
        View inflate = LayoutInflater.from(this.f59464a).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
        this.f59467d = inflate;
        this.f59468e = inflate.findViewById(R.id.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f59467d.findViewById(R.id.categorycontainer);
        this.f59469f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f59471h);
    }

    @Override // d.b.i0.q0.k2.a
    public int b() {
        this.f59467d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.f59467d.getMeasuredHeight();
    }

    @Override // d.b.i0.q0.k2.a
    public View getView() {
        return this.f59467d;
    }

    @Override // d.b.i0.q0.k2.a
    public void setData(List<e1> list) {
        if (list == null) {
            return;
        }
        this.f59466c = list;
        e1 e1Var = new e1();
        e1Var.f59102b = 0;
        e1Var.f59101a = this.f59464a.getResources().getString(R.string.all);
        e1Var.f59103c = false;
        SkinManager.setBackgroundColor(this.f59467d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f59468e, R.color.CAM_X0204);
        this.f59469f.setData(this.f59466c, e1Var);
    }
}
