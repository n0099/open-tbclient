package d.a.m0.r.q;

import android.content.Intent;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class k1 {

    /* renamed from: a  reason: collision with root package name */
    public String f50063a;

    /* renamed from: b  reason: collision with root package name */
    public String f50064b;

    /* renamed from: c  reason: collision with root package name */
    public String f50065c;

    /* renamed from: d  reason: collision with root package name */
    public String f50066d;

    public void a(Intent intent) {
        if (intent == null) {
            return;
        }
        this.f50063a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.f50064b = intent.getStringExtra("recom_source");
        this.f50065c = intent.getStringExtra("recom_abtag");
        this.f50066d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        this.f50063a = a2Var.T0;
        this.f50064b = a2Var.S0;
        this.f50065c = a2Var.U0;
        this.f50066d = a2Var.V0;
    }

    public void c(Intent intent) {
        if (intent != null) {
            intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.f50063a);
            intent.putExtra("recom_source", this.f50064b);
            intent.putExtra("recom_abtag", this.f50065c);
            intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f50066d);
        }
    }

    public void d(d.a.n0.k2.o oVar) {
        if (oVar == null) {
            return;
        }
        oVar.f56904g = this.f50063a;
        oVar.f56903f = this.f50064b;
        oVar.l = this.f50065c;
        oVar.o = this.f50066d;
    }
}
