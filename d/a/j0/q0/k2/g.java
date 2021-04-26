package d.a.j0.q0.k2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import d.a.j0.q0.e1;
import d.a.j0.q0.k2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class g implements d.a.j0.q0.k2.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f57957a;

    /* renamed from: b  reason: collision with root package name */
    public e.InterfaceC1417e f57958b;

    /* renamed from: c  reason: collision with root package name */
    public List<e1> f57959c;

    /* renamed from: d  reason: collision with root package name */
    public View f57960d;

    /* renamed from: e  reason: collision with root package name */
    public View f57961e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f57962f;

    /* renamed from: g  reason: collision with root package name */
    public e f57963g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f57964h = new a();

    /* loaded from: classes4.dex */
    public class a implements TabMenuPopView.c {
        public a() {
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, e1 e1Var) {
            if (g.this.f57963g != null) {
                g.this.f57963g.c();
            }
            g.this.f57958b.a(e1Var.f57566b);
        }
    }

    @Override // d.a.j0.q0.k2.a
    public void a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return;
        }
        this.f57957a = context;
        this.f57963g = eVar;
        this.f57958b = eVar.d();
        View inflate = LayoutInflater.from(this.f57957a).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
        this.f57960d = inflate;
        this.f57961e = inflate.findViewById(R.id.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f57960d.findViewById(R.id.categorycontainer);
        this.f57962f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f57964h);
    }

    @Override // d.a.j0.q0.k2.a
    public int b() {
        this.f57960d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.f57960d.getMeasuredHeight();
    }

    @Override // d.a.j0.q0.k2.a
    public View getView() {
        return this.f57960d;
    }

    @Override // d.a.j0.q0.k2.a
    public void setData(List<e1> list) {
        if (list == null) {
            return;
        }
        this.f57959c = list;
        e1 e1Var = new e1();
        e1Var.f57566b = 0;
        e1Var.f57565a = this.f57957a.getResources().getString(R.string.all);
        e1Var.f57567c = false;
        SkinManager.setBackgroundColor(this.f57960d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f57961e, R.color.CAM_X0204);
        this.f57962f.setData(this.f57959c, e1Var);
    }
}
