package com.win.opensdk;

import android.content.Context;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ab {
    private static ab pZK;
    private Context pYJ;
    private long pZL;
    public long pZf;
    private static String java = ab.class.getSimpleName();

    /* renamed from: case  reason: not valid java name */
    private static String f7case = al.eGG();

    private ab(Context context) {
        this.pYJ = context;
    }

    public static ab iL(Context context) {
        if (pZK == null) {
            synchronized (ab.class) {
                if (pZK == null) {
                    pZK = new ab(context);
                }
            }
        }
        return pZK;
    }

    private void eGz() {
        az.l(this.pYJ, new Date().getTime());
    }

    /* renamed from: java  reason: collision with other method in class */
    public final boolean m59java() {
        boolean z = true;
        long iT = az.iT(this.pYJ);
        if (iT > 0) {
            try {
                long time = (new Date().getTime() - iT) / 1000;
                if (time < 0) {
                    eGz();
                    z = false;
                } else {
                    if ((time / 60) / 60 < az.a(this.pYJ)) {
                        z = false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    static /* synthetic */ void a(ab abVar, am amVar) {
        if (amVar == null || amVar.pZZ == null || amVar.pZZ.length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = amVar.pZZ;
            az.a(abVar.pYJ, jSONObject.optString("bt", ""));
            az.Y(abVar.pYJ, jSONObject.optInt("time", 12));
            az.W(abVar.pYJ, jSONObject.optInt("wt", 5));
            az.b(abVar.pYJ, jSONObject.optJSONArray("ids").toString());
            az.c(abVar.pYJ, jSONObject.optString("psdid"));
            az.X(abVar.pYJ, jSONObject.optInt("psdopt"));
            az.a(abVar.pYJ, jSONObject.optInt("psdt"));
            az.b(abVar.pYJ, jSONObject.optInt("psd"));
            az.c(abVar.pYJ, jSONObject.optInt("hbsw"));
            az.d(abVar.pYJ, jSONObject.optJSONArray("bp").toString());
            az.Z(abVar.pYJ, jSONObject.optInt("bs", 0));
            az.aa(abVar.pYJ, jSONObject.optInt("pro", 4));
            az.ac(abVar.pYJ, jSONObject.optInt("scbsw", 0));
            az.ad(abVar.pYJ, jSONObject.optInt("pclsw", 0));
            az.ae(abVar.pYJ, jSONObject.optInt("scbtsi", 300));
            az.b(abVar.pYJ, jSONObject.optInt("bdtsi", 24));
            az.c(abVar.pYJ, jSONObject.optInt("las", 12));
            az.ab(abVar.pYJ, jSONObject.optInt("jumpsw", 0));
            abVar.eGz();
        } catch (Exception e) {
            w.iK(abVar.pYJ).F(101, abVar.pZL).eGz();
            e.printStackTrace();
        }
    }
}
