package com.win.opensdk;

import android.content.Context;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ab {
    private static ab pZJ;
    private Context pYI;
    private long pZK;
    public long pZe;
    private static String java = ab.class.getSimpleName();

    /* renamed from: case  reason: not valid java name */
    private static String f7case = al.eGG();

    private ab(Context context) {
        this.pYI = context;
    }

    public static ab iL(Context context) {
        if (pZJ == null) {
            synchronized (ab.class) {
                if (pZJ == null) {
                    pZJ = new ab(context);
                }
            }
        }
        return pZJ;
    }

    private void eGz() {
        az.l(this.pYI, new Date().getTime());
    }

    /* renamed from: java  reason: collision with other method in class */
    public final boolean m59java() {
        boolean z = true;
        long iT = az.iT(this.pYI);
        if (iT > 0) {
            try {
                long time = (new Date().getTime() - iT) / 1000;
                if (time < 0) {
                    eGz();
                    z = false;
                } else {
                    if ((time / 60) / 60 < az.a(this.pYI)) {
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
        if (amVar == null || amVar.pZY == null || amVar.pZY.length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = amVar.pZY;
            az.a(abVar.pYI, jSONObject.optString("bt", ""));
            az.Y(abVar.pYI, jSONObject.optInt("time", 12));
            az.W(abVar.pYI, jSONObject.optInt("wt", 5));
            az.b(abVar.pYI, jSONObject.optJSONArray("ids").toString());
            az.c(abVar.pYI, jSONObject.optString("psdid"));
            az.X(abVar.pYI, jSONObject.optInt("psdopt"));
            az.a(abVar.pYI, jSONObject.optInt("psdt"));
            az.b(abVar.pYI, jSONObject.optInt("psd"));
            az.c(abVar.pYI, jSONObject.optInt("hbsw"));
            az.d(abVar.pYI, jSONObject.optJSONArray("bp").toString());
            az.Z(abVar.pYI, jSONObject.optInt("bs", 0));
            az.aa(abVar.pYI, jSONObject.optInt("pro", 4));
            az.ac(abVar.pYI, jSONObject.optInt("scbsw", 0));
            az.ad(abVar.pYI, jSONObject.optInt("pclsw", 0));
            az.ae(abVar.pYI, jSONObject.optInt("scbtsi", 300));
            az.b(abVar.pYI, jSONObject.optInt("bdtsi", 24));
            az.c(abVar.pYI, jSONObject.optInt("las", 12));
            az.ab(abVar.pYI, jSONObject.optInt("jumpsw", 0));
            abVar.eGz();
        } catch (Exception e) {
            w.iK(abVar.pYI).F(101, abVar.pZK).eGz();
            e.printStackTrace();
        }
    }
}
