package d.a.j0.d2.k.e;

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
    public d.a.i0.w.w.h f52550a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f52551b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f52552c;

    /* renamed from: d  reason: collision with root package name */
    public PbFakeFloorModel f52553d;

    /* renamed from: e  reason: collision with root package name */
    public String f52554e;

    /* renamed from: f  reason: collision with root package name */
    public String f52555f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f52556g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.d2.h.e f52557h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f52558i;

    public u(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.f52551b = tbPageContext;
        this.f52552c = relativeLayout;
        this.f52553d = pbFakeFloorModel;
    }

    public final void a() {
        d.a.i0.w.w.h hVar;
        if (this.f52552c == null || (hVar = this.f52550a) == null || hVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f52552c.addView(this.f52550a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public d.a.i0.w.w.h b() {
        return this.f52550a;
    }

    public void c() {
        d.a.i0.w.w.h hVar = this.f52550a;
        if (hVar != null) {
            hVar.w();
            if (StringUtils.isNull(this.f52554e)) {
                this.f52550a.B();
            }
            this.f52550a.a().y();
        }
    }

    public void d() {
        d.a.i0.w.w.h hVar = this.f52550a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f52550a.a().q();
    }

    public final void e(String str, boolean z) {
        if (this.f52552c == null || this.f52550a != null) {
            return;
        }
        d.a.i0.w.w.i iVar = new d.a.i0.w.w.i(z);
        iVar.i(str);
        d.a.i0.w.w.h hVar = (d.a.i0.w.w.h) iVar.a(this.f52551b.getPageActivity());
        this.f52550a = hVar;
        hVar.L(this.f52551b);
        this.f52550a.W(this.f52553d);
        this.f52550a.M(1);
        d.a.j0.d2.h.e eVar = this.f52557h;
        if (eVar != null) {
            this.f52550a.X(eVar.L());
        }
        this.f52550a.a().C(true);
        this.f52550a.a().setOnCancelClickListener(this.f52558i);
        this.f52550a.x(this.f52551b);
        a();
        this.f52550a.N(this.f52556g);
    }

    public boolean f() {
        d.a.i0.w.w.h hVar = this.f52550a;
        if (hVar == null || hVar.a() == null) {
            return false;
        }
        return this.f52550a.a().u();
    }

    public void g(int i2, int i3, Intent intent) {
        d.a.i0.w.w.h hVar = this.f52550a;
        if (hVar != null) {
            hVar.A(i2, i3, intent);
        }
    }

    public void h(int i2) {
        d.a.i0.w.w.h hVar = this.f52550a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f52550a.a().w(i2);
    }

    public void i() {
        d.a.i0.w.w.h hVar = this.f52550a;
        if (hVar != null) {
            hVar.C();
        }
    }

    public void j(String str) {
        this.f52555f = str;
    }

    public void k(View.OnClickListener onClickListener) {
        this.f52558i = onClickListener;
    }

    public void l(d.a.j0.d2.h.e eVar) {
        this.f52557h = eVar;
    }

    public void m(NewWriteModel.g gVar) {
        this.f52556g = gVar;
        d.a.i0.w.w.h hVar = this.f52550a;
        if (hVar != null) {
            hVar.N(gVar);
        }
    }

    public void n(String str, String str2, String str3, boolean z) {
        this.f52554e = str2;
        d.a.i0.w.w.h hVar = this.f52550a;
        if (hVar == null) {
            e(str3, z);
        } else {
            hVar.W(this.f52553d);
            if (StringUtils.isNull(this.f52554e)) {
                this.f52550a.x(this.f52551b);
            }
        }
        this.f52550a.S(str);
        this.f52550a.R(str2);
        this.f52550a.o(this.f52555f);
        if (this.f52550a.v()) {
            this.f52550a.t(null);
        }
    }
}
