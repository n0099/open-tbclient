package d.a.k0.q0.k2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import d.a.k0.q0.e1;
import d.a.k0.q0.k2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class g implements d.a.k0.q0.k2.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f58699a;

    /* renamed from: b  reason: collision with root package name */
    public e.InterfaceC1491e f58700b;

    /* renamed from: c  reason: collision with root package name */
    public List<e1> f58701c;

    /* renamed from: d  reason: collision with root package name */
    public View f58702d;

    /* renamed from: e  reason: collision with root package name */
    public View f58703e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f58704f;

    /* renamed from: g  reason: collision with root package name */
    public e f58705g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f58706h = new a();

    /* loaded from: classes4.dex */
    public class a implements TabMenuPopView.c {
        public a() {
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, e1 e1Var) {
            if (g.this.f58705g != null) {
                g.this.f58705g.c();
            }
            g.this.f58700b.a(e1Var.f58308b);
        }
    }

    @Override // d.a.k0.q0.k2.a
    public void a(Context context, e eVar) {
        if (context == null || eVar == null) {
            return;
        }
        this.f58699a = context;
        this.f58705g = eVar;
        this.f58700b = eVar.d();
        View inflate = LayoutInflater.from(this.f58699a).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
        this.f58702d = inflate;
        this.f58703e = inflate.findViewById(R.id.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f58702d.findViewById(R.id.categorycontainer);
        this.f58704f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f58706h);
    }

    @Override // d.a.k0.q0.k2.a
    public int b() {
        this.f58702d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.f58702d.getMeasuredHeight();
    }

    @Override // d.a.k0.q0.k2.a
    public View getView() {
        return this.f58702d;
    }

    @Override // d.a.k0.q0.k2.a
    public void setData(List<e1> list) {
        if (list == null) {
            return;
        }
        this.f58701c = list;
        e1 e1Var = new e1();
        e1Var.f58308b = 0;
        e1Var.f58307a = this.f58699a.getResources().getString(R.string.all);
        e1Var.f58309c = false;
        SkinManager.setBackgroundColor(this.f58702d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f58703e, R.color.CAM_X0204);
        this.f58704f.setData(this.f58701c, e1Var);
    }
}
