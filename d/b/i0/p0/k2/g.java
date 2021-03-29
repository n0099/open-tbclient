package d.b.i0.p0.k2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import d.b.i0.p0.e1;
import d.b.i0.p0.k2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class g implements d.b.i0.p0.k2.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f57765a;

    /* renamed from: b  reason: collision with root package name */
    public e.InterfaceC1393e f57766b;

    /* renamed from: c  reason: collision with root package name */
    public List<e1> f57767c;

    /* renamed from: d  reason: collision with root package name */
    public View f57768d;

    /* renamed from: e  reason: collision with root package name */
    public View f57769e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f57770f;

    /* renamed from: g  reason: collision with root package name */
    public e f57771g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f57772h = new a();

    /* loaded from: classes4.dex */
    public class a implements TabMenuPopView.c {
        public a() {
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, e1 e1Var) {
            if (g.this.f57771g != null) {
                g.this.f57771g.c();
            }
            g.this.f57766b.a(e1Var.f57403b);
        }
    }

    @Override // d.b.i0.p0.k2.a
    public void a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return;
        }
        this.f57765a = context;
        this.f57771g = eVar;
        this.f57766b = eVar.d();
        View inflate = LayoutInflater.from(this.f57765a).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
        this.f57768d = inflate;
        this.f57769e = inflate.findViewById(R.id.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f57768d.findViewById(R.id.categorycontainer);
        this.f57770f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f57772h);
    }

    @Override // d.b.i0.p0.k2.a
    public int b() {
        this.f57768d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.f57768d.getMeasuredHeight();
    }

    @Override // d.b.i0.p0.k2.a
    public View getView() {
        return this.f57768d;
    }

    @Override // d.b.i0.p0.k2.a
    public void setData(List<e1> list) {
        if (list == null) {
            return;
        }
        this.f57767c = list;
        e1 e1Var = new e1();
        e1Var.f57403b = 0;
        e1Var.f57402a = this.f57765a.getResources().getString(R.string.all);
        e1Var.f57404c = false;
        SkinManager.setBackgroundColor(this.f57768d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f57769e, R.color.CAM_X0204);
        this.f57770f.setData(this.f57767c, e1Var);
    }
}
