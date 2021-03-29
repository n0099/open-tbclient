package d.b.i0.c2.k.e;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes4.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.w.w.h f52822a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f52823b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f52824c;

    /* renamed from: d  reason: collision with root package name */
    public PbFakeFloorModel f52825d;

    /* renamed from: e  reason: collision with root package name */
    public String f52826e;

    /* renamed from: f  reason: collision with root package name */
    public String f52827f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f52828g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.c2.h.e f52829h;
    public View.OnClickListener i;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.f52823b = tbPageContext;
        this.f52824c = relativeLayout;
        this.f52825d = pbFakeFloorModel;
    }

    public final void a() {
        d.b.h0.w.w.h hVar;
        if (this.f52824c == null || (hVar = this.f52822a) == null || hVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f52824c.addView(this.f52822a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public d.b.h0.w.w.h b() {
        return this.f52822a;
    }

    public void c() {
        d.b.h0.w.w.h hVar = this.f52822a;
        if (hVar != null) {
            hVar.w();
            if (StringUtils.isNull(this.f52826e)) {
                this.f52822a.B();
            }
            this.f52822a.a().y();
        }
    }

    public void d() {
        d.b.h0.w.w.h hVar = this.f52822a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f52822a.a().q();
    }

    public final void e(String str, boolean z) {
        if (this.f52824c == null || this.f52822a != null) {
            return;
        }
        d.b.h0.w.w.i iVar = new d.b.h0.w.w.i(z);
        iVar.i(str);
        d.b.h0.w.w.h hVar = (d.b.h0.w.w.h) iVar.a(this.f52823b.getPageActivity());
        this.f52822a = hVar;
        hVar.L(this.f52823b);
        this.f52822a.W(this.f52825d);
        this.f52822a.M(1);
        d.b.i0.c2.h.e eVar = this.f52829h;
        if (eVar != null) {
            this.f52822a.X(eVar.L());
        }
        this.f52822a.a().C(true);
        this.f52822a.a().setOnCancelClickListener(this.i);
        this.f52822a.x(this.f52823b);
        a();
        this.f52822a.N(this.f52828g);
    }

    public boolean f() {
        d.b.h0.w.w.h hVar = this.f52822a;
        if (hVar == null || hVar.a() == null) {
            return false;
        }
        return this.f52822a.a().u();
    }

    public void g(int i, int i2, Intent intent) {
        d.b.h0.w.w.h hVar = this.f52822a;
        if (hVar != null) {
            hVar.A(i, i2, intent);
        }
    }

    public void h(int i) {
        d.b.h0.w.w.h hVar = this.f52822a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f52822a.a().w(i);
    }

    public void i() {
        d.b.h0.w.w.h hVar = this.f52822a;
        if (hVar != null) {
            hVar.C();
        }
    }

    public void j(String str) {
        this.f52827f = str;
    }

    public void k(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void l(d.b.i0.c2.h.e eVar) {
        this.f52829h = eVar;
    }

    public void m(NewWriteModel.g gVar) {
        this.f52828g = gVar;
        d.b.h0.w.w.h hVar = this.f52822a;
        if (hVar != null) {
            hVar.N(gVar);
        }
    }

    public void n(String str, String str2, String str3, boolean z) {
        this.f52826e = str2;
        d.b.h0.w.w.h hVar = this.f52822a;
        if (hVar == null) {
            e(str3, z);
        } else {
            hVar.W(this.f52825d);
            if (StringUtils.isNull(this.f52826e)) {
                this.f52822a.x(this.f52823b);
            }
        }
        this.f52822a.S(str);
        this.f52822a.R(str2);
        this.f52822a.o(this.f52827f);
        if (this.f52822a.v()) {
            this.f52822a.t(null);
        }
    }
}
