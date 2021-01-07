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
/* loaded from: classes4.dex */
public final class w {
    private static final String[] qdT = {"as", "ac", "ao", "scb", "wdin", "asr", "wbas", "wbao"};
    private static final String[] qee = {"ins", Config.DEVICE_BRAND, "wdtr", "witr"};

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f14065a = {"be", "bce", "bpe", "ps", "scbe", "wdst", "wde", "wie", "dplop", "wbe"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f14066b = {"Ld", "wdin", "wiin", "wdre", "wiop", "wii"};

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONStringer eKv() {
        return new JSONStringer().object();
    }

    public static a iM(Context context) {
        w wVar = new w();
        wVar.getClass();
        return new a(context);
    }

    /* loaded from: classes4.dex */
    public class a {
        Context qdj;
        JSONStringer qef = new JSONStringer();
        String java = "";

        public a(Context context) {
            this.qdj = context;
        }

        public final a a(x xVar) {
            try {
                this.qef = w.a("as", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i, int i2) {
            try {
                this.qef = w.a("asr", xVar);
                Q("width", i);
                Q("height", i2);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, String str) {
            try {
                this.qef = w.a("ac", xVar);
                hv("msg", w.abO(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar, String str) {
            try {
                this.qef = w.a("wdst", xVar);
                hv("msg", w.abO(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a c(x xVar, String str) {
            try {
                this.qef = w.a("wist", xVar);
                hv("msg", w.abO(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, String str, int i) {
            try {
                this.qef = w.a("dplop", xVar);
                hv("msg", w.abO(str));
                Q(BdStatsConstant.StatsKey.COUNT, i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a d(x xVar, String str) {
            try {
                this.qef = w.a("wdtr", xVar);
                hv("msg", w.abO(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a e(x xVar, String str) {
            try {
                this.qef = w.a("wii", xVar);
                hv("msg", w.abO(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a f(x xVar, String str) {
            try {
                this.qef = w.a("wiop", xVar);
                hv("msg", w.abO(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, String str, int i, int i2) {
            try {
                this.qef = w.a("wdre", xVar);
                hv(Config.INPUT_DEF_PKG, w.abO(str));
                Q("vsc", i);
                Q(BdStatsConstant.StatsKey.COUNT, i2);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a g(x xVar, String str) {
            try {
                this.qef = w.a("witr", xVar);
                hv("msg", w.abO(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a h(x xVar, String str) {
            try {
                this.qef = w.a("wiin", xVar);
                hv("msg", w.abO(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i) {
            try {
                this.qef = w.a("wdin", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar) {
            try {
                this.qef = w.a("wie", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, 200L);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar, int i) {
            try {
                this.qef = w.a("wde", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a c(x xVar) {
            try {
                this.qef = w.a("ao", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a d(x xVar) {
            try {
                this.qef = w.a("wbao", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i, String str) {
            try {
                this.qef = w.a("wbe", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, i).hv("msg", w.abO(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a e(x xVar) {
            try {
                this.qef = w.a("wbas", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a i(x xVar, String str) {
            try {
                this.qef = w.a("vvsf", xVar);
                hv("desc", str);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a c(x xVar, int i) {
            try {
                this.qef = w.a("vvst", xVar);
                Q("desc", i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, long j) {
            try {
                this.qef = w.a("vvss", xVar);
                Q("desc", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a F(int i, long j) {
            try {
                this.qef = w.eKv();
                hv("e", "bce").hv("timeis", w.eKw()).Q(BdStatsConstant.StatsKey.COUNT, i).Q("dr", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a js(long j) {
            try {
                this.qef = w.eKv();
                hv("e", "hbt").Q("dr", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, long j, int i, int i2) {
            try {
                this.qef = w.a("be", xVar);
                Q("dr", j).Q(BdStatsConstant.StatsKey.COUNT, i).Q("num", i2);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i, long j) {
            try {
                this.qef = w.a("bpe", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, i).Q("dr", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar, int i, String str) {
            try {
                this.qef = w.a("ps", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, i);
                hv("msg", str);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a abQ(String str) {
            try {
                this.qef = w.eKv();
                hv("e", "Ld").hv("pid", str).hv("timeis", w.eKw());
            } catch (JSONException e) {
            }
            return this;
        }

        public final a hv(String str, String str2) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    this.qef.key(str).value(str2);
                }
            } catch (JSONException e) {
            }
            return this;
        }

        private a Q(String str, long j) {
            try {
                this.qef.key(str).value(j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final void eKp() {
            JSONArray jSONArray = new JSONArray();
            try {
                if (!TextUtils.isEmpty(this.qef.toString())) {
                    this.qef.endObject();
                    this.java = this.qef.toString();
                }
                JSONObject jSONObject = new JSONObject(this.java);
                String optString = jSONObject.optString("e");
                if (!abK(optString)) {
                    boolean z = !bc.c(w.qdT, optString);
                    jSONArray.put(jSONObject);
                    L(z, jSONArray.toString());
                }
            } catch (JSONException e) {
            }
        }

        private boolean abK(String str) {
            if (az.c(this.qdj) < 0) {
                return false;
            }
            return bc.c(w.qdT, str) ? az.c(this.qdj) <= 0 : bc.c(w.qee, str) ? az.c(this.qdj) < 2 : bc.c(w.f14065a, str) ? az.c(this.qdj) < 3 : bc.c(w.f14066b, str) && az.c(this.qdj) < 4;
        }

        private void L(final boolean z, final String str) {
            ba.D(new Runnable() { // from class: com.win.opensdk.w.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    String str2;
                    byte[] bArr;
                    if (z) {
                        str2 = al.java;
                    } else {
                        str2 = al.f22case;
                    }
                    try {
                        str2 = str2 + ak.R(ak.iO(a.this.qdj));
                    } catch (UnsupportedEncodingException e) {
                    }
                    String str3 = str;
                    r<am> rVar = new r<am>() { // from class: com.win.opensdk.w.a.1.1
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.win.opensdk.r
                        public final /* bridge */ /* synthetic */ void bH(am amVar) {
                        }

                        @Override // com.win.opensdk.r
                        public final void eKp() {
                        }

                        @Override // com.win.opensdk.r
                        public final void cc(int i, String str4) {
                        }
                    };
                    try {
                        rVar.eKp();
                        s sVar = new s(str2, "POST", ai.eKC());
                        if (str3 == null || str3.length() == 0) {
                            bArr = new byte[0];
                        } else {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(str3.getBytes("UTF-8"));
                            gZIPOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        }
                        sVar.qdZ = bArr;
                        t eKt = sVar.eKt();
                        am amVar = new am();
                        int a2 = ai.a(eKt, amVar);
                        if (a2 == 200) {
                            rVar.bH(amVar);
                        } else {
                            rVar.cc(a2, amVar.f24java);
                        }
                    } catch (JSONException e2) {
                        rVar.cc(101, e2.getMessage());
                    } catch (Exception e3) {
                        rVar.cc(100, e3.getMessage());
                    }
                }
            });
        }
    }

    public static String abO(String str) {
        try {
            return bc.abP(str);
        } catch (Exception e) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String eKw() {
        return abO(String.valueOf(System.currentTimeMillis()));
    }

    static /* synthetic */ JSONStringer a(String str, x xVar) {
        JSONStringer eKv = eKv();
        eKv.key("e").value(str).key("timeis").value(eKw());
        if (xVar != null) {
            eKv.key("pid").value(xVar.java);
            if (xVar.qdE != null) {
                eKv.key("traceid").value(abO(xVar.qdE.getTraceid())).key(IXAdRequestInfo.CELL_ID).value(abO(xVar.qdE.getId())).key("type").value(xVar.qdE.getType());
            }
        }
        return eKv;
    }
}
