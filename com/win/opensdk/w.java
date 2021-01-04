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
    private static final String[] qcl = {"as", "ac", "ao", "scb", "wdin", "asr", "wbas", "wbao"};
    private static final String[] qcw = {"ins", Config.DEVICE_BRAND, "wdtr", "witr"};

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f14064a = {"be", "bce", "bpe", "ps", "scbe", "wdst", "wde", "wie", "dplop", "wbe"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f14065b = {"Ld", "wdin", "wiin", "wdre", "wiop", "wii"};

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONStringer eJR() {
        return new JSONStringer().object();
    }

    public static a iM(Context context) {
        w wVar = new w();
        wVar.getClass();
        return new a(context);
    }

    /* loaded from: classes4.dex */
    public class a {
        Context qbB;
        JSONStringer qcx = new JSONStringer();
        String java = "";

        public a(Context context) {
            this.qbB = context;
        }

        public final a a(x xVar) {
            try {
                this.qcx = w.a("as", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i, int i2) {
            try {
                this.qcx = w.a("asr", xVar);
                Q("width", i);
                Q("height", i2);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, String str) {
            try {
                this.qcx = w.a("ac", xVar);
                hu("msg", w.abN(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar, String str) {
            try {
                this.qcx = w.a("wdst", xVar);
                hu("msg", w.abN(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a c(x xVar, String str) {
            try {
                this.qcx = w.a("wist", xVar);
                hu("msg", w.abN(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, String str, int i) {
            try {
                this.qcx = w.a("dplop", xVar);
                hu("msg", w.abN(str));
                Q(BdStatsConstant.StatsKey.COUNT, i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a d(x xVar, String str) {
            try {
                this.qcx = w.a("wdtr", xVar);
                hu("msg", w.abN(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a e(x xVar, String str) {
            try {
                this.qcx = w.a("wii", xVar);
                hu("msg", w.abN(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a f(x xVar, String str) {
            try {
                this.qcx = w.a("wiop", xVar);
                hu("msg", w.abN(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, String str, int i, int i2) {
            try {
                this.qcx = w.a("wdre", xVar);
                hu(Config.INPUT_DEF_PKG, w.abN(str));
                Q("vsc", i);
                Q(BdStatsConstant.StatsKey.COUNT, i2);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a g(x xVar, String str) {
            try {
                this.qcx = w.a("witr", xVar);
                hu("msg", w.abN(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a h(x xVar, String str) {
            try {
                this.qcx = w.a("wiin", xVar);
                hu("msg", w.abN(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i) {
            try {
                this.qcx = w.a("wdin", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar) {
            try {
                this.qcx = w.a("wie", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, 200L);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar, int i) {
            try {
                this.qcx = w.a("wde", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a c(x xVar) {
            try {
                this.qcx = w.a("ao", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a d(x xVar) {
            try {
                this.qcx = w.a("wbao", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i, String str) {
            try {
                this.qcx = w.a("wbe", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, i).hu("msg", w.abN(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a e(x xVar) {
            try {
                this.qcx = w.a("wbas", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a i(x xVar, String str) {
            try {
                this.qcx = w.a("vvsf", xVar);
                hu("desc", str);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a c(x xVar, int i) {
            try {
                this.qcx = w.a("vvst", xVar);
                Q("desc", i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, long j) {
            try {
                this.qcx = w.a("vvss", xVar);
                Q("desc", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a F(int i, long j) {
            try {
                this.qcx = w.eJR();
                hu("e", "bce").hu("timeis", w.eJS()).Q(BdStatsConstant.StatsKey.COUNT, i).Q("dr", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a jp(long j) {
            try {
                this.qcx = w.eJR();
                hu("e", "hbt").Q("dr", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, long j, int i, int i2) {
            try {
                this.qcx = w.a("be", xVar);
                Q("dr", j).Q(BdStatsConstant.StatsKey.COUNT, i).Q("num", i2);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i, long j) {
            try {
                this.qcx = w.a("bpe", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, i).Q("dr", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar, int i, String str) {
            try {
                this.qcx = w.a("ps", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, i);
                hu("msg", str);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a abP(String str) {
            try {
                this.qcx = w.eJR();
                hu("e", "Ld").hu("pid", str).hu("timeis", w.eJS());
            } catch (JSONException e) {
            }
            return this;
        }

        public final a hu(String str, String str2) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    this.qcx.key(str).value(str2);
                }
            } catch (JSONException e) {
            }
            return this;
        }

        private a Q(String str, long j) {
            try {
                this.qcx.key(str).value(j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final void eJL() {
            JSONArray jSONArray = new JSONArray();
            try {
                if (!TextUtils.isEmpty(this.qcx.toString())) {
                    this.qcx.endObject();
                    this.java = this.qcx.toString();
                }
                JSONObject jSONObject = new JSONObject(this.java);
                String optString = jSONObject.optString("e");
                if (!abJ(optString)) {
                    boolean z = !bc.c(w.qcl, optString);
                    jSONArray.put(jSONObject);
                    L(z, jSONArray.toString());
                }
            } catch (JSONException e) {
            }
        }

        private boolean abJ(String str) {
            if (az.c(this.qbB) < 0) {
                return false;
            }
            return bc.c(w.qcl, str) ? az.c(this.qbB) <= 0 : bc.c(w.qcw, str) ? az.c(this.qbB) < 2 : bc.c(w.f14064a, str) ? az.c(this.qbB) < 3 : bc.c(w.f14065b, str) && az.c(this.qbB) < 4;
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
                        str2 = al.f21case;
                    }
                    try {
                        str2 = str2 + ak.R(ak.iO(a.this.qbB));
                    } catch (UnsupportedEncodingException e) {
                    }
                    String str3 = str;
                    r<am> rVar = new r<am>() { // from class: com.win.opensdk.w.a.1.1
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.win.opensdk.r
                        public final /* bridge */ /* synthetic */ void bG(am amVar) {
                        }

                        @Override // com.win.opensdk.r
                        public final void eJL() {
                        }

                        @Override // com.win.opensdk.r
                        public final void cc(int i, String str4) {
                        }
                    };
                    try {
                        rVar.eJL();
                        s sVar = new s(str2, "POST", ai.eJY());
                        if (str3 == null || str3.length() == 0) {
                            bArr = new byte[0];
                        } else {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(str3.getBytes("UTF-8"));
                            gZIPOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        }
                        sVar.qcr = bArr;
                        t eJP = sVar.eJP();
                        am amVar = new am();
                        int a2 = ai.a(eJP, amVar);
                        if (a2 == 200) {
                            rVar.bG(amVar);
                        } else {
                            rVar.cc(a2, amVar.f23java);
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

    public static String abN(String str) {
        try {
            return bc.abO(str);
        } catch (Exception e) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String eJS() {
        return abN(String.valueOf(System.currentTimeMillis()));
    }

    static /* synthetic */ JSONStringer a(String str, x xVar) {
        JSONStringer eJR = eJR();
        eJR.key("e").value(str).key("timeis").value(eJS());
        if (xVar != null) {
            eJR.key("pid").value(xVar.java);
            if (xVar.qbW != null) {
                eJR.key("traceid").value(abN(xVar.qbW.getTraceid())).key(IXAdRequestInfo.CELL_ID).value(abN(xVar.qbW.getId())).key("type").value(xVar.qbW.getType());
            }
        }
        return eJR;
    }
}
