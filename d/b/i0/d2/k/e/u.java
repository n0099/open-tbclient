package d.b.i0.d2.k.e;

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
    public d.b.h0.w.w.h f54317a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f54318b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f54319c;

    /* renamed from: d  reason: collision with root package name */
    public PbFakeFloorModel f54320d;

    /* renamed from: e  reason: collision with root package name */
    public String f54321e;

    /* renamed from: f  reason: collision with root package name */
    public String f54322f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f54323g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.d2.h.e f54324h;
    public View.OnClickListener i;

    public u(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        this.f54318b = tbPageContext;
        this.f54319c = relativeLayout;
        this.f54320d = pbFakeFloorModel;
    }

    public final void a() {
        d.b.h0.w.w.h hVar;
        if (this.f54319c == null || (hVar = this.f54317a) == null || hVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f54319c.addView(this.f54317a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public d.b.h0.w.w.h b() {
        return this.f54317a;
    }

    public void c() {
        d.b.h0.w.w.h hVar = this.f54317a;
        if (hVar != null) {
            hVar.w();
            if (StringUtils.isNull(this.f54321e)) {
                this.f54317a.B();
            }
            this.f54317a.a().y();
        }
    }

    public void d() {
        d.b.h0.w.w.h hVar = this.f54317a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f54317a.a().q();
    }

    public final void e(String str, boolean z) {
        if (this.f54319c == null || this.f54317a != null) {
            return;
        }
        d.b.h0.w.w.i iVar = new d.b.h0.w.w.i(z);
        iVar.i(str);
        d.b.h0.w.w.h hVar = (d.b.h0.w.w.h) iVar.a(this.f54318b.getPageActivity());
        this.f54317a = hVar;
        hVar.L(this.f54318b);
        this.f54317a.W(this.f54320d);
        this.f54317a.M(1);
        d.b.i0.d2.h.e eVar = this.f54324h;
        if (eVar != null) {
            this.f54317a.X(eVar.L());
        }
        this.f54317a.a().C(true);
        this.f54317a.a().setOnCancelClickListener(this.i);
        this.f54317a.x(this.f54318b);
        a();
        this.f54317a.N(this.f54323g);
    }

    public boolean f() {
        d.b.h0.w.w.h hVar = this.f54317a;
        if (hVar == null || hVar.a() == null) {
            return false;
        }
        return this.f54317a.a().u();
    }

    public void g(int i, int i2, Intent intent) {
        d.b.h0.w.w.h hVar = this.f54317a;
        if (hVar != null) {
            hVar.A(i, i2, intent);
        }
    }

    public void h(int i) {
        d.b.h0.w.w.h hVar = this.f54317a;
        if (hVar == null || hVar.a() == null) {
            return;
        }
        this.f54317a.a().w(i);
    }

    public void i() {
        d.b.h0.w.w.h hVar = this.f54317a;
        if (hVar != null) {
            hVar.C();
        }
    }

    public void j(String str) {
        this.f54322f = str;
    }

    public void k(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void l(d.b.i0.d2.h.e eVar) {
        this.f54324h = eVar;
    }

    public void m(NewWriteModel.g gVar) {
        this.f54323g = gVar;
        d.b.h0.w.w.h hVar = this.f54317a;
        if (hVar != null) {
            hVar.N(gVar);
        }
    }

    public void n(String str, String str2, String str3, boolean z) {
        this.f54321e = str2;
        d.b.h0.w.w.h hVar = this.f54317a;
        if (hVar == null) {
            e(str3, z);
        } else {
            hVar.W(this.f54320d);
            if (StringUtils.isNull(this.f54321e)) {
                this.f54317a.x(this.f54318b);
            }
        }
        this.f54317a.S(str);
        this.f54317a.R(str2);
        this.f54317a.o(this.f54322f);
        if (this.f54317a.v()) {
            this.f54317a.t(null);
        }
    }
}
