package com.win.opensdk;

import android.content.Context;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ab {
    private static ab qek;
    public long qdF;
    private Context qdj;
    private long qel;
    private static String java = ab.class.getSimpleName();

    /* renamed from: case  reason: not valid java name */
    private static String f8case = al.eKw();

    private ab(Context context) {
        this.qdj = context;
    }

    public static ab iN(Context context) {
        if (qek == null) {
            synchronized (ab.class) {
                if (qek == null) {
                    qek = new ab(context);
                }
            }
        }
        return qek;
    }

    private void eKp() {
        az.l(this.qdj, new Date().getTime());
    }

    /* renamed from: java  reason: collision with other method in class */
    public final boolean m63java() {
        boolean z = true;
        long iV = az.iV(this.qdj);
        if (iV > 0) {
            try {
                long time = (new Date().getTime() - iV) / 1000;
                if (time < 0) {
                    eKp();
                    z = false;
                } else {
                    if ((time / 60) / 60 < az.a(this.qdj)) {
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
        if (amVar == null || amVar.qez == null || amVar.qez.length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = amVar.qez;
            az.a(abVar.qdj, jSONObject.optString("bt", ""));
            az.Y(abVar.qdj, jSONObject.optInt("time", 12));
            az.W(abVar.qdj, jSONObject.optInt("wt", 5));
            az.b(abVar.qdj, jSONObject.optJSONArray("ids").toString());
            az.c(abVar.qdj, jSONObject.optString("psdid"));
            az.X(abVar.qdj, jSONObject.optInt("psdopt"));
            az.a(abVar.qdj, jSONObject.optInt("psdt"));
            az.b(abVar.qdj, jSONObject.optInt("psd"));
            az.c(abVar.qdj, jSONObject.optInt("hbsw"));
            az.d(abVar.qdj, jSONObject.optJSONArray("bp").toString());
            az.Z(abVar.qdj, jSONObject.optInt("bs", 0));
            az.aa(abVar.qdj, jSONObject.optInt("pro", 4));
            az.ac(abVar.qdj, jSONObject.optInt("scbsw", 0));
            az.ad(abVar.qdj, jSONObject.optInt("pclsw", 0));
            az.ae(abVar.qdj, jSONObject.optInt("scbtsi", 300));
            az.b(abVar.qdj, jSONObject.optInt("bdtsi", 24));
            az.c(abVar.qdj, jSONObject.optInt("las", 12));
            az.ab(abVar.qdj, jSONObject.optInt("jumpsw", 0));
            abVar.eKp();
        } catch (Exception e) {
            w.iM(abVar.qdj).F(101, abVar.qel).eKp();
            e.printStackTrace();
        }
    }
}
