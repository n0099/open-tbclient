package d.b.i0.r.q;

import android.content.Intent;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class k1 {

    /* renamed from: a  reason: collision with root package name */
    public String f51571a;

    /* renamed from: b  reason: collision with root package name */
    public String f51572b;

    /* renamed from: c  reason: collision with root package name */
    public String f51573c;

    /* renamed from: d  reason: collision with root package name */
    public String f51574d;

    public void a(Intent intent) {
        if (intent == null) {
            return;
        }
        this.f51571a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.f51572b = intent.getStringExtra("recom_source");
        this.f51573c = intent.getStringExtra("recom_abtag");
        this.f51574d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        this.f51571a = a2Var.S0;
        this.f51572b = a2Var.R0;
        this.f51573c = a2Var.T0;
        this.f51574d = a2Var.U0;
    }

    public void c(Intent intent) {
        if (intent != null) {
            intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.f51571a);
            intent.putExtra("recom_source", this.f51572b);
            intent.putExtra("recom_abtag", this.f51573c);
            intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f51574d);
        }
    }

    public void d(d.b.j0.j2.o oVar) {
        if (oVar == null) {
            return;
        }
        oVar.f58038g = this.f51571a;
        oVar.f58037f = this.f51572b;
        oVar.l = this.f51573c;
        oVar.o = this.f51574d;
    }
}
