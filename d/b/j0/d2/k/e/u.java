package d.b.j0.d2.k.e;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.w.w.h f54738a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f54739b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f54740c;

    /* renamed from: d  reason: collision with root package name */
    public PbFakeFloorModel f54741d;

    /* renamed from: e  reason: collision with root package name */
    public String f54742e;

    /* renamed from: f  reason: collision with root package name */
    public String f54743f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f54744g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.j0.d2.h.e f54745h;
    public View.OnClickListener i;

    public u(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.f54739b = tbPageContext;
        this.f54740c = relativeLayout;
        this.f54741d = pbFakeFloorModel;
    }

    public final void a() {
        d.b.i0.w.w.h hVar;
        if (this.f54740c == null || (hVar = this.f54738a) == null || hVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f54740c.addView(this.f54738a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public d.b.i0.w.w.h b() {
        return this.f54738a;
    }

    public void c() {
        d.b.i0.w.w.h hVar = this.f54738a;
        if (hVar != null) {
            hVar.w();
            if (StringUtils.isNull(this.f54742e)) {
                this.f54738a.B();
            }
            this.f54738a.a().y();
        }
    }

    public void d() {
        d.b.i0.w.w.h hVar = this.f54738a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f54738a.a().q();
    }

    public final void e(String str, boolean z) {
        if (this.f54740c == null || this.f54738a != null) {
            return;
        }
        d.b.i0.w.w.i iVar = new d.b.i0.w.w.i(z);
        iVar.i(str);
        d.b.i0.w.w.h hVar = (d.b.i0.w.w.h) iVar.a(this.f54739b.getPageActivity());
        this.f54738a = hVar;
        hVar.L(this.f54739b);
        this.f54738a.W(this.f54741d);
        this.f54738a.M(1);
        d.b.j0.d2.h.e eVar = this.f54745h;
        if (eVar != null) {
            this.f54738a.X(eVar.L());
        }
        this.f54738a.a().C(true);
        this.f54738a.a().setOnCancelClickListener(this.i);
        this.f54738a.x(this.f54739b);
        a();
        this.f54738a.N(this.f54744g);
    }

    public boolean f() {
        d.b.i0.w.w.h hVar = this.f54738a;
        if (hVar == null || hVar.a() == null) {
            return false;
        }
        return this.f54738a.a().u();
    }

    public void g(int i, int i2, Intent intent) {
        d.b.i0.w.w.h hVar = this.f54738a;
        if (hVar != null) {
            hVar.A(i, i2, intent);
        }
    }

    public void h(int i) {
        d.b.i0.w.w.h hVar = this.f54738a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f54738a.a().w(i);
    }

    public void i() {
        d.b.i0.w.w.h hVar = this.f54738a;
        if (hVar != null) {
            hVar.C();
        }
    }

    public void j(String str) {
        this.f54743f = str;
    }

    public void k(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void l(d.b.j0.d2.h.e eVar) {
        this.f54745h = eVar;
    }

    public void m(NewWriteModel.g gVar) {
        this.f54744g = gVar;
        d.b.i0.w.w.h hVar = this.f54738a;
        if (hVar != null) {
            hVar.N(gVar);
        }
    }

    public void n(String str, String str2, String str3, boolean z) {
        this.f54742e = str2;
        d.b.i0.w.w.h hVar = this.f54738a;
        if (hVar == null) {
            e(str3, z);
        } else {
            hVar.W(this.f54741d);
            if (StringUtils.isNull(this.f54742e)) {
                this.f54738a.x(this.f54739b);
            }
        }
        this.f54738a.S(str);
        this.f54738a.R(str2);
        this.f54738a.o(this.f54743f);
        if (this.f54738a.v()) {
            this.f54738a.t(null);
        }
    }
}
