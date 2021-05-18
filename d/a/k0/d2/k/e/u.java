package d.a.k0.d2.k.e;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes5.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public d.a.j0.w.w.h f53253a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f53254b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f53255c;

    /* renamed from: d  reason: collision with root package name */
    public PbFakeFloorModel f53256d;

    /* renamed from: e  reason: collision with root package name */
    public String f53257e;

    /* renamed from: f  reason: collision with root package name */
    public String f53258f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f53259g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.d2.h.e f53260h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f53261i;

    public u(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.f53254b = tbPageContext;
        this.f53255c = relativeLayout;
        this.f53256d = pbFakeFloorModel;
    }

    public final void a() {
        d.a.j0.w.w.h hVar;
        if (this.f53255c == null || (hVar = this.f53253a) == null || hVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f53255c.addView(this.f53253a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public d.a.j0.w.w.h b() {
        return this.f53253a;
    }

    public void c() {
        d.a.j0.w.w.h hVar = this.f53253a;
        if (hVar != null) {
            hVar.w();
            if (StringUtils.isNull(this.f53257e)) {
                this.f53253a.B();
            }
            this.f53253a.a().y();
        }
    }

    public void d() {
        d.a.j0.w.w.h hVar = this.f53253a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f53253a.a().q();
    }

    public final void e(String str, boolean z) {
        if (this.f53255c == null || this.f53253a != null) {
            return;
        }
        d.a.j0.w.w.i iVar = new d.a.j0.w.w.i(z);
        iVar.i(str);
        d.a.j0.w.w.h hVar = (d.a.j0.w.w.h) iVar.a(this.f53254b.getPageActivity());
        this.f53253a = hVar;
        hVar.L(this.f53254b);
        this.f53253a.W(this.f53256d);
        this.f53253a.M(1);
        d.a.k0.d2.h.e eVar = this.f53260h;
        if (eVar != null) {
            this.f53253a.X(eVar.L());
        }
        this.f53253a.a().C(true);
        this.f53253a.a().setOnCancelClickListener(this.f53261i);
        this.f53253a.x(this.f53254b);
        a();
        this.f53253a.N(this.f53259g);
    }

    public boolean f() {
        d.a.j0.w.w.h hVar = this.f53253a;
        if (hVar == null || hVar.a() == null) {
            return false;
        }
        return this.f53253a.a().u();
    }

    public void g(int i2, int i3, Intent intent) {
        d.a.j0.w.w.h hVar = this.f53253a;
        if (hVar != null) {
            hVar.A(i2, i3, intent);
        }
    }

    public void h(int i2) {
        d.a.j0.w.w.h hVar = this.f53253a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f53253a.a().w(i2);
    }

    public void i() {
        d.a.j0.w.w.h hVar = this.f53253a;
        if (hVar != null) {
            hVar.C();
        }
    }

    public void j(String str) {
        this.f53258f = str;
    }

    public void k(View.OnClickListener onClickListener) {
        this.f53261i = onClickListener;
    }

    public void l(d.a.k0.d2.h.e eVar) {
        this.f53260h = eVar;
    }

    public void m(NewWriteModel.g gVar) {
        this.f53259g = gVar;
        d.a.j0.w.w.h hVar = this.f53253a;
        if (hVar != null) {
            hVar.N(gVar);
        }
    }

    public void n(String str, String str2, String str3, boolean z) {
        this.f53257e = str2;
        d.a.j0.w.w.h hVar = this.f53253a;
        if (hVar == null) {
            e(str3, z);
        } else {
            hVar.W(this.f53256d);
            if (StringUtils.isNull(this.f53257e)) {
                this.f53253a.x(this.f53254b);
            }
        }
        this.f53253a.S(str);
        this.f53253a.R(str2);
        this.f53253a.o(this.f53258f);
        if (this.f53253a.v()) {
            this.f53253a.t(null);
        }
    }
}
