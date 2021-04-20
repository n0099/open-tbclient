package d.b.h0.r.q;

import android.content.Intent;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class k1 {

    /* renamed from: a  reason: collision with root package name */
    public String f51235a;

    /* renamed from: b  reason: collision with root package name */
    public String f51236b;

    /* renamed from: c  reason: collision with root package name */
    public String f51237c;

    /* renamed from: d  reason: collision with root package name */
    public String f51238d;

    public void a(Intent intent) {
        if (intent == null) {
            return;
        }
        this.f51235a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.f51236b = intent.getStringExtra("recom_source");
        this.f51237c = intent.getStringExtra("recom_abtag");
        this.f51238d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        this.f51235a = a2Var.S0;
        this.f51236b = a2Var.R0;
        this.f51237c = a2Var.T0;
        this.f51238d = a2Var.U0;
    }

    public void c(Intent intent) {
        if (intent != null) {
            intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.f51235a);
            intent.putExtra("recom_source", this.f51236b);
            intent.putExtra("recom_abtag", this.f51237c);
            intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f51238d);
        }
    }

    public void d(d.b.i0.j2.o oVar) {
        if (oVar == null) {
            return;
        }
        oVar.f57617g = this.f51235a;
        oVar.f57616f = this.f51236b;
        oVar.l = this.f51237c;
        oVar.o = this.f51238d;
    }
}
