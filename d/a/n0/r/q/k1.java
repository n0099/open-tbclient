package d.a.n0.r.q;

import android.content.Intent;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class k1 {

    /* renamed from: a  reason: collision with root package name */
    public String f53846a;

    /* renamed from: b  reason: collision with root package name */
    public String f53847b;

    /* renamed from: c  reason: collision with root package name */
    public String f53848c;

    /* renamed from: d  reason: collision with root package name */
    public String f53849d;

    public void a(Intent intent) {
        if (intent == null) {
            return;
        }
        this.f53846a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.f53847b = intent.getStringExtra("recom_source");
        this.f53848c = intent.getStringExtra("recom_abtag");
        this.f53849d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        this.f53846a = a2Var.U0;
        this.f53847b = a2Var.T0;
        this.f53848c = a2Var.V0;
        this.f53849d = a2Var.W0;
    }

    public void c(Intent intent) {
        if (intent != null) {
            intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.f53846a);
            intent.putExtra("recom_source", this.f53847b);
            intent.putExtra("recom_abtag", this.f53848c);
            intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f53849d);
        }
    }

    public void d(d.a.o0.k2.o oVar) {
        if (oVar == null) {
            return;
        }
        oVar.f60718g = this.f53846a;
        oVar.f60717f = this.f53847b;
        oVar.l = this.f53848c;
        oVar.o = this.f53849d;
    }
}
