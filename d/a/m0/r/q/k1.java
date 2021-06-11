package d.a.m0.r.q;

import android.content.Intent;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class k1 {

    /* renamed from: a  reason: collision with root package name */
    public String f53739a;

    /* renamed from: b  reason: collision with root package name */
    public String f53740b;

    /* renamed from: c  reason: collision with root package name */
    public String f53741c;

    /* renamed from: d  reason: collision with root package name */
    public String f53742d;

    public void a(Intent intent) {
        if (intent == null) {
            return;
        }
        this.f53739a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.f53740b = intent.getStringExtra("recom_source");
        this.f53741c = intent.getStringExtra("recom_abtag");
        this.f53742d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        this.f53739a = a2Var.U0;
        this.f53740b = a2Var.T0;
        this.f53741c = a2Var.V0;
        this.f53742d = a2Var.W0;
    }

    public void c(Intent intent) {
        if (intent != null) {
            intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.f53739a);
            intent.putExtra("recom_source", this.f53740b);
            intent.putExtra("recom_abtag", this.f53741c);
            intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f53742d);
        }
    }

    public void d(d.a.n0.k2.o oVar) {
        if (oVar == null) {
            return;
        }
        oVar.f60593g = this.f53739a;
        oVar.f60592f = this.f53740b;
        oVar.l = this.f53741c;
        oVar.o = this.f53742d;
    }
}
