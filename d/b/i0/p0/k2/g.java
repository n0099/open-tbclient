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
    public Context f57764a;

    /* renamed from: b  reason: collision with root package name */
    public e.InterfaceC1392e f57765b;

    /* renamed from: c  reason: collision with root package name */
    public List<e1> f57766c;

    /* renamed from: d  reason: collision with root package name */
    public View f57767d;

    /* renamed from: e  reason: collision with root package name */
    public View f57768e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f57769f;

    /* renamed from: g  reason: collision with root package name */
    public e f57770g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f57771h = new a();

    /* loaded from: classes4.dex */
    public class a implements TabMenuPopView.c {
        public a() {
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, e1 e1Var) {
            if (g.this.f57770g != null) {
                g.this.f57770g.c();
            }
            g.this.f57765b.a(e1Var.f57402b);
        }
    }

    @Override // d.b.i0.p0.k2.a
    public void a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return;
        }
        this.f57764a = context;
        this.f57770g = eVar;
        this.f57765b = eVar.d();
        View inflate = LayoutInflater.from(this.f57764a).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
        this.f57767d = inflate;
        this.f57768e = inflate.findViewById(R.id.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f57767d.findViewById(R.id.categorycontainer);
        this.f57769f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f57771h);
    }

    @Override // d.b.i0.p0.k2.a
    public int b() {
        this.f57767d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.f57767d.getMeasuredHeight();
    }

    @Override // d.b.i0.p0.k2.a
    public View getView() {
        return this.f57767d;
    }

    @Override // d.b.i0.p0.k2.a
    public void setData(List<e1> list) {
        if (list == null) {
            return;
        }
        this.f57766c = list;
        e1 e1Var = new e1();
        e1Var.f57402b = 0;
        e1Var.f57401a = this.f57764a.getResources().getString(R.string.all);
        e1Var.f57403c = false;
        SkinManager.setBackgroundColor(this.f57767d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f57768e, R.color.CAM_X0204);
        this.f57769f.setData(this.f57766c, e1Var);
    }
}
