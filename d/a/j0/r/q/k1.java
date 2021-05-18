package d.a.j0.r.q;

import android.content.Intent;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class k1 {

    /* renamed from: a  reason: collision with root package name */
    public String f50019a;

    /* renamed from: b  reason: collision with root package name */
    public String f50020b;

    /* renamed from: c  reason: collision with root package name */
    public String f50021c;

    /* renamed from: d  reason: collision with root package name */
    public String f50022d;

    public void a(Intent intent) {
        if (intent == null) {
            return;
        }
        this.f50019a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.f50020b = intent.getStringExtra("recom_source");
        this.f50021c = intent.getStringExtra("recom_abtag");
        this.f50022d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        this.f50019a = a2Var.S0;
        this.f50020b = a2Var.R0;
        this.f50021c = a2Var.T0;
        this.f50022d = a2Var.U0;
    }

    public void c(Intent intent) {
        if (intent != null) {
            intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.f50019a);
            intent.putExtra("recom_source", this.f50020b);
            intent.putExtra("recom_abtag", this.f50021c);
            intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f50022d);
        }
    }

    public void d(d.a.k0.j2.o oVar) {
        if (oVar == null) {
            return;
        }
        oVar.f56724g = this.f50019a;
        oVar.f56723f = this.f50020b;
        oVar.l = this.f50021c;
        oVar.o = this.f50022d;
    }
}
