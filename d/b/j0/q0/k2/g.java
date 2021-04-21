package d.b.j0.q0.k2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import d.b.j0.q0.e1;
import d.b.j0.q0.k2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class g implements d.b.j0.q0.k2.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f59885a;

    /* renamed from: b  reason: collision with root package name */
    public e.InterfaceC1478e f59886b;

    /* renamed from: c  reason: collision with root package name */
    public List<e1> f59887c;

    /* renamed from: d  reason: collision with root package name */
    public View f59888d;

    /* renamed from: e  reason: collision with root package name */
    public View f59889e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f59890f;

    /* renamed from: g  reason: collision with root package name */
    public e f59891g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f59892h = new a();

    /* loaded from: classes4.dex */
    public class a implements TabMenuPopView.c {
        public a() {
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, e1 e1Var) {
            if (g.this.f59891g != null) {
                g.this.f59891g.c();
            }
            g.this.f59886b.a(e1Var.f59523b);
        }
    }

    @Override // d.b.j0.q0.k2.a
    public void a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return;
        }
        this.f59885a = context;
        this.f59891g = eVar;
        this.f59886b = eVar.d();
        View inflate = LayoutInflater.from(this.f59885a).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
        this.f59888d = inflate;
        this.f59889e = inflate.findViewById(R.id.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f59888d.findViewById(R.id.categorycontainer);
        this.f59890f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f59892h);
    }

    @Override // d.b.j0.q0.k2.a
    public int b() {
        this.f59888d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.f59888d.getMeasuredHeight();
    }

    @Override // d.b.j0.q0.k2.a
    public View getView() {
        return this.f59888d;
    }

    @Override // d.b.j0.q0.k2.a
    public void setData(List<e1> list) {
        if (list == null) {
            return;
        }
        this.f59887c = list;
        e1 e1Var = new e1();
        e1Var.f59523b = 0;
        e1Var.f59522a = this.f59885a.getResources().getString(R.string.all);
        e1Var.f59524c = false;
        SkinManager.setBackgroundColor(this.f59888d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f59889e, R.color.CAM_X0204);
        this.f59890f.setData(this.f59887c, e1Var);
    }
}
