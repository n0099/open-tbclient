package d.a.n0.r0.k2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import d.a.n0.r0.e1;
import d.a.n0.r0.k2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class g implements d.a.n0.r0.k2.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f62531a;

    /* renamed from: b  reason: collision with root package name */
    public e.InterfaceC1560e f62532b;

    /* renamed from: c  reason: collision with root package name */
    public List<e1> f62533c;

    /* renamed from: d  reason: collision with root package name */
    public View f62534d;

    /* renamed from: e  reason: collision with root package name */
    public View f62535e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f62536f;

    /* renamed from: g  reason: collision with root package name */
    public e f62537g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f62538h = new a();

    /* loaded from: classes4.dex */
    public class a implements TabMenuPopView.c {
        public a() {
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, e1 e1Var) {
            if (g.this.f62537g != null) {
                g.this.f62537g.c();
            }
            g.this.f62532b.a(e1Var.f62140b);
        }
    }

    @Override // d.a.n0.r0.k2.a
    public void a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return;
        }
        this.f62531a = context;
        this.f62537g = eVar;
        this.f62532b = eVar.d();
        View inflate = LayoutInflater.from(this.f62531a).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
        this.f62534d = inflate;
        this.f62535e = inflate.findViewById(R.id.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f62534d.findViewById(R.id.categorycontainer);
        this.f62536f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f62538h);
    }

    @Override // d.a.n0.r0.k2.a
    public int b() {
        this.f62534d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.f62534d.getMeasuredHeight();
    }

    @Override // d.a.n0.r0.k2.a
    public View getView() {
        return this.f62534d;
    }

    @Override // d.a.n0.r0.k2.a
    public void setData(List<e1> list) {
        if (list == null) {
            return;
        }
        this.f62533c = list;
        e1 e1Var = new e1();
        e1Var.f62140b = 0;
        e1Var.f62139a = this.f62531a.getResources().getString(R.string.all);
        e1Var.f62141c = false;
        SkinManager.setBackgroundColor(this.f62534d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f62535e, R.color.CAM_X0204);
        this.f62536f.setData(this.f62533c, e1Var);
    }
}
