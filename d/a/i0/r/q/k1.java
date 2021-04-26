package d.a.i0.r.q;

import android.content.Intent;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class k1 {

    /* renamed from: a  reason: collision with root package name */
    public String f49200a;

    /* renamed from: b  reason: collision with root package name */
    public String f49201b;

    /* renamed from: c  reason: collision with root package name */
    public String f49202c;

    /* renamed from: d  reason: collision with root package name */
    public String f49203d;

    public void a(Intent intent) {
        if (intent == null) {
            return;
        }
        this.f49200a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.f49201b = intent.getStringExtra("recom_source");
        this.f49202c = intent.getStringExtra("recom_abtag");
        this.f49203d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        this.f49200a = a2Var.S0;
        this.f49201b = a2Var.R0;
        this.f49202c = a2Var.T0;
        this.f49203d = a2Var.U0;
    }

    public void c(Intent intent) {
        if (intent != null) {
            intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.f49200a);
            intent.putExtra("recom_source", this.f49201b);
            intent.putExtra("recom_abtag", this.f49202c);
            intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f49203d);
        }
    }

    public void d(d.a.j0.j2.o oVar) {
        if (oVar == null) {
            return;
        }
        oVar.f56017g = this.f49200a;
        oVar.f56016f = this.f49201b;
        oVar.l = this.f49202c;
        oVar.o = this.f49203d;
    }
}
