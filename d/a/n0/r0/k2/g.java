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
    public Context f58840a;

    /* renamed from: b  reason: collision with root package name */
    public e.InterfaceC1504e f58841b;

    /* renamed from: c  reason: collision with root package name */
    public List<e1> f58842c;

    /* renamed from: d  reason: collision with root package name */
    public View f58843d;

    /* renamed from: e  reason: collision with root package name */
    public View f58844e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f58845f;

    /* renamed from: g  reason: collision with root package name */
    public e f58846g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f58847h = new a();

    /* loaded from: classes4.dex */
    public class a implements TabMenuPopView.c {
        public a() {
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, e1 e1Var) {
            if (g.this.f58846g != null) {
                g.this.f58846g.c();
            }
            g.this.f58841b.a(e1Var.f58449b);
        }
    }

    @Override // d.a.n0.r0.k2.a
    public void a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return;
        }
        this.f58840a = context;
        this.f58846g = eVar;
        this.f58841b = eVar.d();
        View inflate = LayoutInflater.from(this.f58840a).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
        this.f58843d = inflate;
        this.f58844e = inflate.findViewById(R.id.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f58843d.findViewById(R.id.categorycontainer);
        this.f58845f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f58847h);
    }

    @Override // d.a.n0.r0.k2.a
    public int b() {
        this.f58843d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.f58843d.getMeasuredHeight();
    }

    @Override // d.a.n0.r0.k2.a
    public View getView() {
        return this.f58843d;
    }

    @Override // d.a.n0.r0.k2.a
    public void setData(List<e1> list) {
        if (list == null) {
            return;
        }
        this.f58842c = list;
        e1 e1Var = new e1();
        e1Var.f58449b = 0;
        e1Var.f58448a = this.f58840a.getResources().getString(R.string.all);
        e1Var.f58450c = false;
        SkinManager.setBackgroundColor(this.f58843d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f58844e, R.color.CAM_X0204);
        this.f58845f.setData(this.f58842c, e1Var);
    }
}
