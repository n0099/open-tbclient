package com.win.opensdk;

import android.content.Context;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ab {
    private static ab qko;
    public long qjJ;
    private Context qjn;
    private long qkp;
    private static String java = ab.class.getSimpleName();

    /* renamed from: case  reason: not valid java name */
    private static String f7case = al.eJe();

    private ab(Context context) {
        this.qjn = context;
    }

    public static ab iO(Context context) {
        if (qko == null) {
            synchronized (ab.class) {
                if (qko == null) {
                    qko = new ab(context);
                }
            }
        }
        return qko;
    }

    private void eIX() {
        az.l(this.qjn, new Date().getTime());
    }

    /* renamed from: java  reason: collision with other method in class */
    public final boolean m58java() {
        boolean z = true;
        long iW = az.iW(this.qjn);
        if (iW > 0) {
            try {
                long time = (new Date().getTime() - iW) / 1000;
                if (time < 0) {
                    eIX();
                    z = false;
                } else {
                    if ((time / 60) / 60 < az.a(this.qjn)) {
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
        if (amVar == null || amVar.qkD == null || amVar.qkD.length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = amVar.qkD;
            az.a(abVar.qjn, jSONObject.optString("bt", ""));
            az.Y(abVar.qjn, jSONObject.optInt("time", 12));
            az.W(abVar.qjn, jSONObject.optInt("wt", 5));
            az.b(abVar.qjn, jSONObject.optJSONArray("ids").toString());
            az.c(abVar.qjn, jSONObject.optString("psdid"));
            az.X(abVar.qjn, jSONObject.optInt("psdopt"));
            az.a(abVar.qjn, jSONObject.optInt("psdt"));
            az.b(abVar.qjn, jSONObject.optInt("psd"));
            az.c(abVar.qjn, jSONObject.optInt("hbsw"));
            az.d(abVar.qjn, jSONObject.optJSONArray("bp").toString());
            az.Z(abVar.qjn, jSONObject.optInt("bs", 0));
            az.aa(abVar.qjn, jSONObject.optInt("pro", 4));
            az.ac(abVar.qjn, jSONObject.optInt("scbsw", 0));
            az.ad(abVar.qjn, jSONObject.optInt("pclsw", 0));
            az.ae(abVar.qjn, jSONObject.optInt("scbtsi", 300));
            az.b(abVar.qjn, jSONObject.optInt("bdtsi", 24));
            az.c(abVar.qjn, jSONObject.optInt("las", 12));
            az.ab(abVar.qjn, jSONObject.optInt("jumpsw", 0));
            abVar.eIX();
        } catch (Exception e) {
            w.iN(abVar.qjn).H(101, abVar.qkp).eIX();
            e.printStackTrace();
        }
    }
}
