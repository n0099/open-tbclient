package d.b.h0.r.q;

import android.content.Intent;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class k1 {

    /* renamed from: a  reason: collision with root package name */
    public String f50827a;

    /* renamed from: b  reason: collision with root package name */
    public String f50828b;

    /* renamed from: c  reason: collision with root package name */
    public String f50829c;

    /* renamed from: d  reason: collision with root package name */
    public String f50830d;

    public void a(Intent intent) {
        if (intent == null) {
            return;
        }
        this.f50827a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.f50828b = intent.getStringExtra("recom_source");
        this.f50829c = intent.getStringExtra("recom_abtag");
        this.f50830d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        this.f50827a = a2Var.S0;
        this.f50828b = a2Var.R0;
        this.f50829c = a2Var.T0;
        this.f50830d = a2Var.U0;
    }

    public void c(Intent intent) {
        if (intent != null) {
            intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.f50827a);
            intent.putExtra("recom_source", this.f50828b);
            intent.putExtra("recom_abtag", this.f50829c);
            intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f50830d);
        }
    }

    public void d(d.b.i0.i2.o oVar) {
        if (oVar == null) {
            return;
        }
        oVar.f56169g = this.f50827a;
        oVar.f56168f = this.f50828b;
        oVar.l = this.f50829c;
        oVar.o = this.f50830d;
    }
}
