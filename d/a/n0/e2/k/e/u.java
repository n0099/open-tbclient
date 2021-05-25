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
    public d.a.m0.w.w.h f53507a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f53508b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f53509c;

    /* renamed from: d  reason: collision with root package name */
    public PbFakeFloorModel f53510d;

    /* renamed from: e  reason: collision with root package name */
    public String f53511e;

    /* renamed from: f  reason: collision with root package name */
    public String f53512f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f53513g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.e2.h.e f53514h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f53515i;

    public u(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.f53508b = tbPageContext;
        this.f53509c = relativeLayout;
        this.f53510d = pbFakeFloorModel;
    }

    public final void a() {
        d.a.m0.w.w.h hVar;
        if (this.f53509c == null || (hVar = this.f53507a) == null || hVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f53509c.addView(this.f53507a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public d.a.m0.w.w.h b() {
        return this.f53507a;
    }

    public void c() {
        d.a.m0.w.w.h hVar = this.f53507a;
        if (hVar != null) {
            hVar.w();
            if (StringUtils.isNull(this.f53511e)) {
                this.f53507a.B();
            }
            this.f53507a.a().y();
        }
    }

    public void d() {
        d.a.m0.w.w.h hVar = this.f53507a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f53507a.a().q();
    }

    public final void e(String str, boolean z) {
        if (this.f53509c == null || this.f53507a != null) {
            return;
        }
        d.a.m0.w.w.i iVar = new d.a.m0.w.w.i(z);
        iVar.i(str);
        d.a.m0.w.w.h hVar = (d.a.m0.w.w.h) iVar.a(this.f53508b.getPageActivity());
        this.f53507a = hVar;
        hVar.L(this.f53508b);
        this.f53507a.W(this.f53510d);
        this.f53507a.M(1);
        d.a.n0.e2.h.e eVar = this.f53514h;
        if (eVar != null) {
            this.f53507a.X(eVar.L());
        }
        this.f53507a.a().C(true);
        this.f53507a.a().setOnCancelClickListener(this.f53515i);
        this.f53507a.x(this.f53508b);
        a();
        this.f53507a.N(this.f53513g);
    }

    public boolean f() {
        d.a.m0.w.w.h hVar = this.f53507a;
        if (hVar == null || hVar.a() == null) {
            return false;
        }
        return this.f53507a.a().u();
    }

    public void g(int i2, int i3, Intent intent) {
        d.a.m0.w.w.h hVar = this.f53507a;
        if (hVar != null) {
            hVar.A(i2, i3, intent);
        }
    }

    public void h(int i2) {
        d.a.m0.w.w.h hVar = this.f53507a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f53507a.a().w(i2);
    }

    public void i() {
        d.a.m0.w.w.h hVar = this.f53507a;
        if (hVar != null) {
            hVar.C();
        }
    }

    public void j(String str) {
        this.f53512f = str;
    }

    public void k(View.OnClickListener onClickListener) {
        this.f53515i = onClickListener;
    }

    public void l(d.a.n0.e2.h.e eVar) {
        this.f53514h = eVar;
    }

    public void m(NewWriteModel.g gVar) {
        this.f53513g = gVar;
        d.a.m0.w.w.h hVar = this.f53507a;
        if (hVar != null) {
            hVar.N(gVar);
        }
    }

    public void n(String str, String str2, String str3, boolean z) {
        this.f53511e = str2;
        d.a.m0.w.w.h hVar = this.f53507a;
        if (hVar == null) {
            e(str3, z);
        } else {
            hVar.W(this.f53510d);
            if (StringUtils.isNull(this.f53511e)) {
                this.f53507a.x(this.f53508b);
            }
        }
        this.f53507a.S(str);
        this.f53507a.R(str2);
        this.f53507a.o(this.f53512f);
        if (this.f53507a.v()) {
            this.f53507a.t(null);
        }
    }
}
