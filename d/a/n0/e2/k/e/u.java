package d.a.n0.e2.k.e;

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
    public d.a.m0.w.w.h f57196a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f57197b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f57198c;

    /* renamed from: d  reason: collision with root package name */
    public PbFakeFloorModel f57199d;

    /* renamed from: e  reason: collision with root package name */
    public String f57200e;

    /* renamed from: f  reason: collision with root package name */
    public String f57201f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f57202g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.e2.h.e f57203h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f57204i;

    public u(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.f57197b = tbPageContext;
        this.f57198c = relativeLayout;
        this.f57199d = pbFakeFloorModel;
    }

    public final void a() {
        d.a.m0.w.w.h hVar;
        if (this.f57198c == null || (hVar = this.f57196a) == null || hVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f57198c.addView(this.f57196a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public d.a.m0.w.w.h b() {
        return this.f57196a;
    }

    public void c() {
        d.a.m0.w.w.h hVar = this.f57196a;
        if (hVar != null) {
            hVar.w();
            if (StringUtils.isNull(this.f57200e)) {
                this.f57196a.B();
            }
            this.f57196a.a().y();
        }
    }

    public void d() {
        d.a.m0.w.w.h hVar = this.f57196a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f57196a.a().q();
    }

    public final void e(String str, boolean z) {
        if (this.f57198c == null || this.f57196a != null) {
            return;
        }
        d.a.m0.w.w.i iVar = new d.a.m0.w.w.i(z);
        iVar.i(str);
        d.a.m0.w.w.h hVar = (d.a.m0.w.w.h) iVar.a(this.f57197b.getPageActivity());
        this.f57196a = hVar;
        hVar.L(this.f57197b);
        this.f57196a.W(this.f57199d);
        this.f57196a.M(1);
        d.a.n0.e2.h.e eVar = this.f57203h;
        if (eVar != null) {
            this.f57196a.X(eVar.L());
        }
        this.f57196a.a().C(true);
        this.f57196a.a().setOnCancelClickListener(this.f57204i);
        this.f57196a.x(this.f57197b);
        a();
        this.f57196a.N(this.f57202g);
    }

    public boolean f() {
        d.a.m0.w.w.h hVar = this.f57196a;
        if (hVar == null || hVar.a() == null) {
            return false;
        }
        return this.f57196a.a().u();
    }

    public void g(int i2, int i3, Intent intent) {
        d.a.m0.w.w.h hVar = this.f57196a;
        if (hVar != null) {
            hVar.A(i2, i3, intent);
        }
    }

    public void h(int i2) {
        d.a.m0.w.w.h hVar = this.f57196a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f57196a.a().w(i2);
    }

    public void i() {
        d.a.m0.w.w.h hVar = this.f57196a;
        if (hVar != null) {
            hVar.C();
        }
    }

    public void j(String str) {
        this.f57201f = str;
    }

    public void k(View.OnClickListener onClickListener) {
        this.f57204i = onClickListener;
    }

    public void l(d.a.n0.e2.h.e eVar) {
        this.f57203h = eVar;
    }

    public void m(NewWriteModel.g gVar) {
        this.f57202g = gVar;
        d.a.m0.w.w.h hVar = this.f57196a;
        if (hVar != null) {
            hVar.N(gVar);
        }
    }

    public void n(String str, String str2, String str3, boolean z) {
        this.f57200e = str2;
        d.a.m0.w.w.h hVar = this.f57196a;
        if (hVar == null) {
            e(str3, z);
        } else {
            hVar.W(this.f57199d);
            if (StringUtils.isNull(this.f57200e)) {
                this.f57196a.x(this.f57197b);
            }
        }
        this.f57196a.S(str);
        this.f57196a.R(str2);
        this.f57196a.o(this.f57201f);
        if (this.f57196a.v()) {
            this.f57196a.t(null);
        }
    }
}
