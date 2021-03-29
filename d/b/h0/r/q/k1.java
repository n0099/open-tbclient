package d.b.h0.r.q;

import android.content.Intent;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class k1 {

    /* renamed from: a  reason: collision with root package name */
    public String f50828a;

    /* renamed from: b  reason: collision with root package name */
    public String f50829b;

    /* renamed from: c  reason: collision with root package name */
    public String f50830c;

    /* renamed from: d  reason: collision with root package name */
    public String f50831d;

    public void a(Intent intent) {
        if (intent == null) {
            return;
        }
        this.f50828a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.f50829b = intent.getStringExtra("recom_source");
        this.f50830c = intent.getStringExtra("recom_abtag");
        this.f50831d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        this.f50828a = a2Var.S0;
        this.f50829b = a2Var.R0;
        this.f50830c = a2Var.T0;
        this.f50831d = a2Var.U0;
    }

    public void c(Intent intent) {
        if (intent != null) {
            intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.f50828a);
            intent.putExtra("recom_source", this.f50829b);
            intent.putExtra("recom_abtag", this.f50830c);
            intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f50831d);
        }
    }

    public void d(d.b.i0.i2.o oVar) {
        if (oVar == null) {
            return;
        }
        oVar.f56170g = this.f50828a;
        oVar.f56169f = this.f50829b;
        oVar.l = this.f50830c;
        oVar.o = this.f50831d;
    }
}
