package com.win.opensdk;

import android.content.Context;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ab {
    private static ab qjO;
    private Context qiN;
    private long qjP;
    public long qjj;
    private static String java = ab.class.getSimpleName();

    /* renamed from: case  reason: not valid java name */
    private static String f7case = al.eIW();

    private ab(Context context) {
        this.qiN = context;
    }

    public static ab iO(Context context) {
        if (qjO == null) {
            synchronized (ab.class) {
                if (qjO == null) {
                    qjO = new ab(context);
                }
            }
        }
        return qjO;
    }

    private void eIP() {
        az.l(this.qiN, new Date().getTime());
    }

    /* renamed from: java  reason: collision with other method in class */
    public final boolean m59java() {
        boolean z = true;
        long iW = az.iW(this.qiN);
        if (iW > 0) {
            try {
                long time = (new Date().getTime() - iW) / 1000;
                if (time < 0) {
                    eIP();
                    z = false;
                } else {
                    if ((time / 60) / 60 < az.a(this.qiN)) {
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
        if (amVar == null || amVar.qkd == null || amVar.qkd.length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = amVar.qkd;
            az.a(abVar.qiN, jSONObject.optString("bt", ""));
            az.Y(abVar.qiN, jSONObject.optInt("time", 12));
            az.W(abVar.qiN, jSONObject.optInt("wt", 5));
            az.b(abVar.qiN, jSONObject.optJSONArray("ids").toString());
            az.c(abVar.qiN, jSONObject.optString("psdid"));
            az.X(abVar.qiN, jSONObject.optInt("psdopt"));
            az.a(abVar.qiN, jSONObject.optInt("psdt"));
            az.b(abVar.qiN, jSONObject.optInt("psd"));
            az.c(abVar.qiN, jSONObject.optInt("hbsw"));
            az.d(abVar.qiN, jSONObject.optJSONArray("bp").toString());
            az.Z(abVar.qiN, jSONObject.optInt("bs", 0));
            az.aa(abVar.qiN, jSONObject.optInt("pro", 4));
            az.ac(abVar.qiN, jSONObject.optInt("scbsw", 0));
            az.ad(abVar.qiN, jSONObject.optInt("pclsw", 0));
            az.ae(abVar.qiN, jSONObject.optInt("scbtsi", 300));
            az.b(abVar.qiN, jSONObject.optInt("bdtsi", 24));
            az.c(abVar.qiN, jSONObject.optInt("las", 12));
            az.ab(abVar.qiN, jSONObject.optInt("jumpsw", 0));
            abVar.eIP();
        } catch (Exception e) {
            w.iN(abVar.qiN).H(101, abVar.qjP).eIP();
            e.printStackTrace();
        }
    }
}
