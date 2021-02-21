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
    private static final String[] qjX = {"as", "ac", "ao", "scb", "wdin", "asr", "wbas", "wbao"};
    private static final String[] qki = {"ins", Config.DEVICE_BRAND, "wdtr", "witr"};

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f13767a = {"be", "bce", "bpe", "ps", "scbe", "wdst", "wde", "wie", "dplop", "wbe"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f13768b = {"Ld", "wdin", "wiin", "wdre", "wiop", "wii"};

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONStringer eJd() {
        return new JSONStringer().object();
    }

    public static a iN(Context context) {
        w wVar = new w();
        wVar.getClass();
        return new a(context);
    }

    /* loaded from: classes3.dex */
    public class a {
        Context qjn;
        JSONStringer qkj = new JSONStringer();
        String java = "";

        public a(Context context) {
            this.qjn = context;
        }

        public final a a(x xVar) {
            try {
                this.qkj = w.a("as", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i, int i2) {
            try {
                this.qkj = w.a("asr", xVar);
                P("width", i);
                P("height", i2);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, String str) {
            try {
                this.qkj = w.a("ac", xVar);
                hD("msg", w.abU(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar, String str) {
            try {
                this.qkj = w.a("wdst", xVar);
                hD("msg", w.abU(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a c(x xVar, String str) {
            try {
                this.qkj = w.a("wist", xVar);
                hD("msg", w.abU(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, String str, int i) {
            try {
                this.qkj = w.a("dplop", xVar);
                hD("msg", w.abU(str));
                P(BdStatsConstant.StatsKey.COUNT, i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a d(x xVar, String str) {
            try {
                this.qkj = w.a("wdtr", xVar);
                hD("msg", w.abU(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a e(x xVar, String str) {
            try {
                this.qkj = w.a("wii", xVar);
                hD("msg", w.abU(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a f(x xVar, String str) {
            try {
                this.qkj = w.a("wiop", xVar);
                hD("msg", w.abU(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, String str, int i, int i2) {
            try {
                this.qkj = w.a("wdre", xVar);
                hD(Config.INPUT_DEF_PKG, w.abU(str));
                P("vsc", i);
                P(BdStatsConstant.StatsKey.COUNT, i2);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a g(x xVar, String str) {
            try {
                this.qkj = w.a("witr", xVar);
                hD("msg", w.abU(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a h(x xVar, String str) {
            try {
                this.qkj = w.a("wiin", xVar);
                hD("msg", w.abU(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i) {
            try {
                this.qkj = w.a("wdin", xVar);
                P(BdStatsConstant.StatsKey.COUNT, i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar) {
            try {
                this.qkj = w.a("wie", xVar);
                P(BdStatsConstant.StatsKey.COUNT, 200L);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar, int i) {
            try {
                this.qkj = w.a("wde", xVar);
                P(BdStatsConstant.StatsKey.COUNT, i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a c(x xVar) {
            try {
                this.qkj = w.a("ao", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a d(x xVar) {
            try {
                this.qkj = w.a("wbao", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i, String str) {
            try {
                this.qkj = w.a("wbe", xVar);
                P(BdStatsConstant.StatsKey.COUNT, i).hD("msg", w.abU(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a e(x xVar) {
            try {
                this.qkj = w.a("wbas", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a i(x xVar, String str) {
            try {
                this.qkj = w.a("vvsf", xVar);
                hD("desc", str);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a c(x xVar, int i) {
            try {
                this.qkj = w.a("vvst", xVar);
                P("desc", i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, long j) {
            try {
                this.qkj = w.a("vvss", xVar);
                P("desc", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a H(int i, long j) {
            try {
                this.qkj = w.eJd();
                hD("e", "bce").hD("timeis", w.eJe()).P(BdStatsConstant.StatsKey.COUNT, i).P("dr", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a jv(long j) {
            try {
                this.qkj = w.eJd();
                hD("e", "hbt").P("dr", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, long j, int i, int i2) {
            try {
                this.qkj = w.a("be", xVar);
                P("dr", j).P(BdStatsConstant.StatsKey.COUNT, i).P("num", i2);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i, long j) {
            try {
                this.qkj = w.a("bpe", xVar);
                P(BdStatsConstant.StatsKey.COUNT, i).P("dr", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar, int i, String str) {
            try {
                this.qkj = w.a("ps", xVar);
                P(BdStatsConstant.StatsKey.COUNT, i);
                hD("msg", str);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a abW(String str) {
            try {
                this.qkj = w.eJd();
                hD("e", "Ld").hD("pid", str).hD("timeis", w.eJe());
            } catch (JSONException e) {
            }
            return this;
        }

        public final a hD(String str, String str2) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    this.qkj.key(str).value(str2);
                }
            } catch (JSONException e) {
            }
            return this;
        }

        private a P(String str, long j) {
            try {
                this.qkj.key(str).value(j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final void eIX() {
            JSONArray jSONArray = new JSONArray();
            try {
                if (!TextUtils.isEmpty(this.qkj.toString())) {
                    this.qkj.endObject();
                    this.java = this.qkj.toString();
                }
                JSONObject jSONObject = new JSONObject(this.java);
                String optString = jSONObject.optString("e");
                if (!abQ(optString)) {
                    boolean z = !bc.c(w.qjX, optString);
                    jSONArray.put(jSONObject);
                    T(z, jSONArray.toString());
                }
            } catch (JSONException e) {
            }
        }

        private boolean abQ(String str) {
            if (az.c(this.qjn) < 0) {
                return false;
            }
            return bc.c(w.qjX, str) ? az.c(this.qjn) <= 0 : bc.c(w.qki, str) ? az.c(this.qjn) < 2 : bc.c(w.f13767a, str) ? az.c(this.qjn) < 3 : bc.c(w.f13768b, str) && az.c(this.qjn) < 4;
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
                        str2 = str2 + ak.T(ak.iP(a.this.qjn));
                    } catch (UnsupportedEncodingException e) {
                    }
                    String str3 = str;
                    r<am> rVar = new r<am>() { // from class: com.win.opensdk.w.a.1.1
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.win.opensdk.r
                        public final /* bridge */ /* synthetic */ void bH(am amVar) {
                        }

                        @Override // com.win.opensdk.r
                        public final void eIX() {
                        }

                        @Override // com.win.opensdk.r
                        public final void ck(int i, String str4) {
                        }
                    };
                    try {
                        rVar.eIX();
                        s sVar = new s(str2, "POST", ai.eJk());
                        if (str3 == null || str3.length() == 0) {
                            bArr = new byte[0];
                        } else {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(str3.getBytes("UTF-8"));
                            gZIPOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        }
                        sVar.qkd = bArr;
                        t eJb = sVar.eJb();
                        am amVar = new am();
                        int a2 = ai.a(eJb, amVar);
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

    public static String abU(String str) {
        try {
            return bc.abV(str);
        } catch (Exception e) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String eJe() {
        return abU(String.valueOf(System.currentTimeMillis()));
    }

    static /* synthetic */ JSONStringer a(String str, x xVar) {
        JSONStringer eJd = eJd();
        eJd.key("e").value(str).key("timeis").value(eJe());
        if (xVar != null) {
            eJd.key("pid").value(xVar.java);
            if (xVar.qjI != null) {
                eJd.key("traceid").value(abU(xVar.qjI.getTraceid())).key(IXAdRequestInfo.CELL_ID).value(abU(xVar.qjI.getId())).key("type").value(xVar.qjI.getType());
            }
        }
        return eJd;
    }
}
