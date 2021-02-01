package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
/* loaded from: classes3.dex */
public final class w {
    private static final String[] qjx = {"as", "ac", "ao", "scb", "wdin", "asr", "wbas", "wbao"};
    private static final String[] qjI = {"ins", Config.DEVICE_BRAND, "wdtr", "witr"};

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f13767a = {"be", "bce", "bpe", "ps", "scbe", "wdst", "wde", "wie", "dplop", "wbe"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f13768b = {"Ld", "wdin", "wiin", "wdre", "wiop", "wii"};

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONStringer eIV() {
        return new JSONStringer().object();
    }

    public static a iN(Context context) {
        w wVar = new w();
        wVar.getClass();
        return new a(context);
    }

    /* loaded from: classes3.dex */
    public class a {
        Context qiN;
        JSONStringer qjJ = new JSONStringer();
        String java = "";

        public a(Context context) {
            this.qiN = context;
        }

        public final a a(x xVar) {
            try {
                this.qjJ = w.a("as", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i, int i2) {
            try {
                this.qjJ = w.a("asr", xVar);
                P("width", i);
                P("height", i2);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, String str) {
            try {
                this.qjJ = w.a("ac", xVar);
                hB("msg", w.abI(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar, String str) {
            try {
                this.qjJ = w.a("wdst", xVar);
                hB("msg", w.abI(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a c(x xVar, String str) {
            try {
                this.qjJ = w.a("wist", xVar);
                hB("msg", w.abI(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, String str, int i) {
            try {
                this.qjJ = w.a("dplop", xVar);
                hB("msg", w.abI(str));
                P(BdStatsConstant.StatsKey.COUNT, i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a d(x xVar, String str) {
            try {
                this.qjJ = w.a("wdtr", xVar);
                hB("msg", w.abI(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a e(x xVar, String str) {
            try {
                this.qjJ = w.a("wii", xVar);
                hB("msg", w.abI(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a f(x xVar, String str) {
            try {
                this.qjJ = w.a("wiop", xVar);
                hB("msg", w.abI(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, String str, int i, int i2) {
            try {
                this.qjJ = w.a("wdre", xVar);
                hB(Config.INPUT_DEF_PKG, w.abI(str));
                P("vsc", i);
                P(BdStatsConstant.StatsKey.COUNT, i2);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a g(x xVar, String str) {
            try {
                this.qjJ = w.a("witr", xVar);
                hB("msg", w.abI(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a h(x xVar, String str) {
            try {
                this.qjJ = w.a("wiin", xVar);
                hB("msg", w.abI(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i) {
            try {
                this.qjJ = w.a("wdin", xVar);
                P(BdStatsConstant.StatsKey.COUNT, i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar) {
            try {
                this.qjJ = w.a("wie", xVar);
                P(BdStatsConstant.StatsKey.COUNT, 200L);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar, int i) {
            try {
                this.qjJ = w.a("wde", xVar);
                P(BdStatsConstant.StatsKey.COUNT, i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a c(x xVar) {
            try {
                this.qjJ = w.a("ao", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a d(x xVar) {
            try {
                this.qjJ = w.a("wbao", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i, String str) {
            try {
                this.qjJ = w.a("wbe", xVar);
                P(BdStatsConstant.StatsKey.COUNT, i).hB("msg", w.abI(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a e(x xVar) {
            try {
                this.qjJ = w.a("wbas", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a i(x xVar, String str) {
            try {
                this.qjJ = w.a("vvsf", xVar);
                hB("desc", str);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a c(x xVar, int i) {
            try {
                this.qjJ = w.a("vvst", xVar);
                P("desc", i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, long j) {
            try {
                this.qjJ = w.a("vvss", xVar);
                P("desc", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a H(int i, long j) {
            try {
                this.qjJ = w.eIV();
                hB("e", "bce").hB("timeis", w.eIW()).P(BdStatsConstant.StatsKey.COUNT, i).P("dr", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a jv(long j) {
            try {
                this.qjJ = w.eIV();
                hB("e", "hbt").P("dr", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, long j, int i, int i2) {
            try {
                this.qjJ = w.a("be", xVar);
                P("dr", j).P(BdStatsConstant.StatsKey.COUNT, i).P("num", i2);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i, long j) {
            try {
                this.qjJ = w.a("bpe", xVar);
                P(BdStatsConstant.StatsKey.COUNT, i).P("dr", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar, int i, String str) {
            try {
                this.qjJ = w.a("ps", xVar);
                P(BdStatsConstant.StatsKey.COUNT, i);
                hB("msg", str);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a abK(String str) {
            try {
                this.qjJ = w.eIV();
                hB("e", "Ld").hB("pid", str).hB("timeis", w.eIW());
            } catch (JSONException e) {
            }
            return this;
        }

        public final a hB(String str, String str2) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    this.qjJ.key(str).value(str2);
                }
            } catch (JSONException e) {
            }
            return this;
        }

        private a P(String str, long j) {
            try {
                this.qjJ.key(str).value(j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final void eIP() {
            JSONArray jSONArray = new JSONArray();
            try {
                if (!TextUtils.isEmpty(this.qjJ.toString())) {
                    this.qjJ.endObject();
                    this.java = this.qjJ.toString();
                }
                JSONObject jSONObject = new JSONObject(this.java);
                String optString = jSONObject.optString("e");
                if (!abE(optString)) {
                    boolean z = !bc.c(w.qjx, optString);
                    jSONArray.put(jSONObject);
                    T(z, jSONArray.toString());
                }
            } catch (JSONException e) {
            }
        }

        private boolean abE(String str) {
            if (az.c(this.qiN) < 0) {
                return false;
            }
            return bc.c(w.qjx, str) ? az.c(this.qiN) <= 0 : bc.c(w.qjI, str) ? az.c(this.qiN) < 2 : bc.c(w.f13767a, str) ? az.c(this.qiN) < 3 : bc.c(w.f13768b, str) && az.c(this.qiN) < 4;
        }

        private void T(final boolean z, final String str) {
            ba.C(new Runnable() { // from class: com.win.opensdk.w.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    String str2;
                    byte[] bArr;
                    if (z) {
                        str2 = al.java;
                    } else {
                        str2 = al.f21case;
                    }
                    try {
                        str2 = str2 + ak.T(ak.iP(a.this.qiN));
                    } catch (UnsupportedEncodingException e) {
                    }
                    String str3 = str;
                    r<am> rVar = new r<am>() { // from class: com.win.opensdk.w.a.1.1
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.win.opensdk.r
                        public final /* bridge */ /* synthetic */ void bH(am amVar) {
                        }

                        @Override // com.win.opensdk.r
                        public final void eIP() {
                        }

                        @Override // com.win.opensdk.r
                        public final void ck(int i, String str4) {
                        }
                    };
                    try {
                        rVar.eIP();
                        s sVar = new s(str2, "POST", ai.eJc());
                        if (str3 == null || str3.length() == 0) {
                            bArr = new byte[0];
                        } else {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(str3.getBytes("UTF-8"));
                            gZIPOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        }
                        sVar.qjD = bArr;
                        t eIT = sVar.eIT();
                        am amVar = new am();
                        int a2 = ai.a(eIT, amVar);
                        if (a2 == 200) {
                            rVar.bH(amVar);
                        } else {
                            rVar.ck(a2, amVar.f23java);
                        }
                    } catch (JSONException e2) {
                        rVar.ck(101, e2.getMessage());
                    } catch (Exception e3) {
                        rVar.ck(100, e3.getMessage());
                    }
                }
            });
        }
    }

    public static String abI(String str) {
        try {
            return bc.abJ(str);
        } catch (Exception e) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String eIW() {
        return abI(String.valueOf(System.currentTimeMillis()));
    }

    static /* synthetic */ JSONStringer a(String str, x xVar) {
        JSONStringer eIV = eIV();
        eIV.key("e").value(str).key("timeis").value(eIW());
        if (xVar != null) {
            eIV.key("pid").value(xVar.java);
            if (xVar.qji != null) {
                eIV.key("traceid").value(abI(xVar.qji.getTraceid())).key(IXAdRequestInfo.CELL_ID).value(abI(xVar.qji.getId())).key("type").value(xVar.qji.getType());
            }
        }
        return eIV;
    }
}
