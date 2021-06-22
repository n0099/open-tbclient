package d.a.o0.e2.k.e;

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
    public d.a.n0.w.w.h f57321a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f57322b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f57323c;

    /* renamed from: d  reason: collision with root package name */
    public PbFakeFloorModel f57324d;

    /* renamed from: e  reason: collision with root package name */
    public String f57325e;

    /* renamed from: f  reason: collision with root package name */
    public String f57326f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f57327g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.e2.h.e f57328h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f57329i;

    public u(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.f57322b = tbPageContext;
        this.f57323c = relativeLayout;
        this.f57324d = pbFakeFloorModel;
    }

    public final void a() {
        d.a.n0.w.w.h hVar;
        if (this.f57323c == null || (hVar = this.f57321a) == null || hVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f57323c.addView(this.f57321a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public d.a.n0.w.w.h b() {
        return this.f57321a;
    }

    public void c() {
        d.a.n0.w.w.h hVar = this.f57321a;
        if (hVar != null) {
            hVar.w();
            if (StringUtils.isNull(this.f57325e)) {
                this.f57321a.B();
            }
            this.f57321a.a().y();
        }
    }

    public void d() {
        d.a.n0.w.w.h hVar = this.f57321a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f57321a.a().q();
    }

    public final void e(String str, boolean z) {
        if (this.f57323c == null || this.f57321a != null) {
            return;
        }
        d.a.n0.w.w.i iVar = new d.a.n0.w.w.i(z);
        iVar.i(str);
        d.a.n0.w.w.h hVar = (d.a.n0.w.w.h) iVar.a(this.f57322b.getPageActivity());
        this.f57321a = hVar;
        hVar.L(this.f57322b);
        this.f57321a.W(this.f57324d);
        this.f57321a.M(1);
        d.a.o0.e2.h.e eVar = this.f57328h;
        if (eVar != null) {
            this.f57321a.X(eVar.L());
        }
        this.f57321a.a().C(true);
        this.f57321a.a().setOnCancelClickListener(this.f57329i);
        this.f57321a.x(this.f57322b);
        a();
        this.f57321a.N(this.f57327g);
    }

    public boolean f() {
        d.a.n0.w.w.h hVar = this.f57321a;
        if (hVar == null || hVar.a() == null) {
            return false;
        }
        return this.f57321a.a().u();
    }

    public void g(int i2, int i3, Intent intent) {
        d.a.n0.w.w.h hVar = this.f57321a;
        if (hVar != null) {
            hVar.A(i2, i3, intent);
        }
    }

    public void h(int i2) {
        d.a.n0.w.w.h hVar = this.f57321a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f57321a.a().w(i2);
    }

    public void i() {
        d.a.n0.w.w.h hVar = this.f57321a;
        if (hVar != null) {
            hVar.C();
        }
    }

    public void j(String str) {
        this.f57326f = str;
    }

    public void k(View.OnClickListener onClickListener) {
        this.f57329i = onClickListener;
    }

    public void l(d.a.o0.e2.h.e eVar) {
        this.f57328h = eVar;
    }

    public void m(NewWriteModel.g gVar) {
        this.f57327g = gVar;
        d.a.n0.w.w.h hVar = this.f57321a;
        if (hVar != null) {
            hVar.N(gVar);
        }
    }

    public void n(String str, String str2, String str3, boolean z) {
        this.f57325e = str2;
        d.a.n0.w.w.h hVar = this.f57321a;
        if (hVar == null) {
            e(str3, z);
        } else {
            hVar.W(this.f57324d);
            if (StringUtils.isNull(this.f57325e)) {
                this.f57321a.x(this.f57322b);
            }
        }
        this.f57321a.S(str);
        this.f57321a.R(str2);
        this.f57321a.o(this.f57326f);
        if (this.f57321a.v()) {
            this.f57321a.t(null);
        }
    }
}
