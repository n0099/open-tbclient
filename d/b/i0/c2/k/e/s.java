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
    public d.b.h0.w.w.h f52821a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f52822b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f52823c;

    /* renamed from: d  reason: collision with root package name */
    public PbFakeFloorModel f52824d;

    /* renamed from: e  reason: collision with root package name */
    public String f52825e;

    /* renamed from: f  reason: collision with root package name */
    public String f52826f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f52827g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.c2.h.e f52828h;
    public View.OnClickListener i;

    public s(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.f52822b = tbPageContext;
        this.f52823c = relativeLayout;
        this.f52824d = pbFakeFloorModel;
    }

    public final void a() {
        d.b.h0.w.w.h hVar;
        if (this.f52823c == null || (hVar = this.f52821a) == null || hVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f52823c.addView(this.f52821a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public d.b.h0.w.w.h b() {
        return this.f52821a;
    }

    public void c() {
        d.b.h0.w.w.h hVar = this.f52821a;
        if (hVar != null) {
            hVar.w();
            if (StringUtils.isNull(this.f52825e)) {
                this.f52821a.B();
            }
            this.f52821a.a().y();
        }
    }

    public void d() {
        d.b.h0.w.w.h hVar = this.f52821a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f52821a.a().q();
    }

    public final void e(String str, boolean z) {
        if (this.f52823c == null || this.f52821a != null) {
            return;
        }
        d.b.h0.w.w.i iVar = new d.b.h0.w.w.i(z);
        iVar.i(str);
        d.b.h0.w.w.h hVar = (d.b.h0.w.w.h) iVar.a(this.f52822b.getPageActivity());
        this.f52821a = hVar;
        hVar.L(this.f52822b);
        this.f52821a.W(this.f52824d);
        this.f52821a.M(1);
        d.b.i0.c2.h.e eVar = this.f52828h;
        if (eVar != null) {
            this.f52821a.X(eVar.L());
        }
        this.f52821a.a().C(true);
        this.f52821a.a().setOnCancelClickListener(this.i);
        this.f52821a.x(this.f52822b);
        a();
        this.f52821a.N(this.f52827g);
    }

    public boolean f() {
        d.b.h0.w.w.h hVar = this.f52821a;
        if (hVar == null || hVar.a() == null) {
            return false;
        }
        return this.f52821a.a().u();
    }

    public void g(int i, int i2, Intent intent) {
        d.b.h0.w.w.h hVar = this.f52821a;
        if (hVar != null) {
            hVar.A(i, i2, intent);
        }
    }

    public void h(int i) {
        d.b.h0.w.w.h hVar = this.f52821a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f52821a.a().w(i);
    }

    public void i() {
        d.b.h0.w.w.h hVar = this.f52821a;
        if (hVar != null) {
            hVar.C();
        }
    }

    public void j(String str) {
        this.f52826f = str;
    }

    public void k(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void l(d.b.i0.c2.h.e eVar) {
        this.f52828h = eVar;
    }

    public void m(NewWriteModel.g gVar) {
        this.f52827g = gVar;
        d.b.h0.w.w.h hVar = this.f52821a;
        if (hVar != null) {
            hVar.N(gVar);
        }
    }

    public void n(String str, String str2, String str3, boolean z) {
        this.f52825e = str2;
        d.b.h0.w.w.h hVar = this.f52821a;
        if (hVar == null) {
            e(str3, z);
        } else {
            hVar.W(this.f52824d);
            if (StringUtils.isNull(this.f52825e)) {
                this.f52821a.x(this.f52822b);
            }
        }
        this.f52821a.S(str);
        this.f52821a.R(str2);
        this.f52821a.o(this.f52826f);
        if (this.f52821a.v()) {
            this.f52821a.t(null);
        }
    }
}
