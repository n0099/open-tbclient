package com.win.opensdk;

import android.content.Context;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ab {
    private static ab qcC;
    private Context qbB;
    public long qbX;
    private long qcD;
    private static String java = ab.class.getSimpleName();

    /* renamed from: case  reason: not valid java name */
    private static String f7case = al.eJS();

    private ab(Context context) {
        this.qbB = context;
    }

    public static ab iN(Context context) {
        if (qcC == null) {
            synchronized (ab.class) {
                if (qcC == null) {
                    qcC = new ab(context);
                }
            }
        }
        return qcC;
    }

    private void eJL() {
        az.l(this.qbB, new Date().getTime());
    }

    /* renamed from: java  reason: collision with other method in class */
    public final boolean m52java() {
        boolean z = true;
        long iV = az.iV(this.qbB);
        if (iV > 0) {
            try {
                long time = (new Date().getTime() - iV) / 1000;
                if (time < 0) {
                    eJL();
                    z = false;
                } else {
                    if ((time / 60) / 60 < az.a(this.qbB)) {
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
        if (amVar == null || amVar.qcR == null || amVar.qcR.length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = amVar.qcR;
            az.a(abVar.qbB, jSONObject.optString("bt", ""));
            az.Y(abVar.qbB, jSONObject.optInt("time", 12));
            az.W(abVar.qbB, jSONObject.optInt("wt", 5));
            az.b(abVar.qbB, jSONObject.optJSONArray("ids").toString());
            az.c(abVar.qbB, jSONObject.optString("psdid"));
            az.X(abVar.qbB, jSONObject.optInt("psdopt"));
            az.a(abVar.qbB, jSONObject.optInt("psdt"));
            az.b(abVar.qbB, jSONObject.optInt("psd"));
            az.c(abVar.qbB, jSONObject.optInt("hbsw"));
            az.d(abVar.qbB, jSONObject.optJSONArray("bp").toString());
            az.Z(abVar.qbB, jSONObject.optInt("bs", 0));
            az.aa(abVar.qbB, jSONObject.optInt("pro", 4));
            az.ac(abVar.qbB, jSONObject.optInt("scbsw", 0));
            az.ad(abVar.qbB, jSONObject.optInt("pclsw", 0));
            az.ae(abVar.qbB, jSONObject.optInt("scbtsi", 300));
            az.b(abVar.qbB, jSONObject.optInt("bdtsi", 24));
            az.c(abVar.qbB, jSONObject.optInt("las", 12));
            az.ab(abVar.qbB, jSONObject.optInt("jumpsw", 0));
            abVar.eJL();
        } catch (Exception e) {
            w.iM(abVar.qbB).F(101, abVar.qcD).eJL();
            e.printStackTrace();
        }
    }
}
