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
    private static final String[] pZs = {"as", "ac", "ao", "scb", "wdin", "asr", "wbas", "wbao"};
    private static final String[] pZD = {"ins", Config.DEVICE_BRAND, "wdtr", "witr"};

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f13765a = {"be", "bce", "bpe", "ps", "scbe", "wdst", "wde", "wie", "dplop", "wbe"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f13766b = {"Ld", "wdin", "wiin", "wdre", "wiop", "wii"};

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONStringer eGF() {
        return new JSONStringer().object();
    }

    public static a iK(Context context) {
        w wVar = new w();
        wVar.getClass();
        return new a(context);
    }

    /* loaded from: classes3.dex */
    public class a {
        Context pYI;
        JSONStringer pZE = new JSONStringer();
        String java = "";

        public a(Context context) {
            this.pYI = context;
        }

        public final a a(x xVar) {
            try {
                this.pZE = w.a("as", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i, int i2) {
            try {
                this.pZE = w.a("asr", xVar);
                Q("width", i);
                Q("height", i2);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, String str) {
            try {
                this.pZE = w.a("ac", xVar);
                hu("msg", w.aaG(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar, String str) {
            try {
                this.pZE = w.a("wdst", xVar);
                hu("msg", w.aaG(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a c(x xVar, String str) {
            try {
                this.pZE = w.a("wist", xVar);
                hu("msg", w.aaG(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, String str, int i) {
            try {
                this.pZE = w.a("dplop", xVar);
                hu("msg", w.aaG(str));
                Q(BdStatsConstant.StatsKey.COUNT, i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a d(x xVar, String str) {
            try {
                this.pZE = w.a("wdtr", xVar);
                hu("msg", w.aaG(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a e(x xVar, String str) {
            try {
                this.pZE = w.a("wii", xVar);
                hu("msg", w.aaG(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a f(x xVar, String str) {
            try {
                this.pZE = w.a("wiop", xVar);
                hu("msg", w.aaG(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, String str, int i, int i2) {
            try {
                this.pZE = w.a("wdre", xVar);
                hu(Config.INPUT_DEF_PKG, w.aaG(str));
                Q("vsc", i);
                Q(BdStatsConstant.StatsKey.COUNT, i2);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a g(x xVar, String str) {
            try {
                this.pZE = w.a("witr", xVar);
                hu("msg", w.aaG(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a h(x xVar, String str) {
            try {
                this.pZE = w.a("wiin", xVar);
                hu("msg", w.aaG(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i) {
            try {
                this.pZE = w.a("wdin", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar) {
            try {
                this.pZE = w.a("wie", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, 200L);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar, int i) {
            try {
                this.pZE = w.a("wde", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a c(x xVar) {
            try {
                this.pZE = w.a("ao", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a d(x xVar) {
            try {
                this.pZE = w.a("wbao", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i, String str) {
            try {
                this.pZE = w.a("wbe", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, i).hu("msg", w.aaG(str));
            } catch (JSONException e) {
            }
            return this;
        }

        public final a e(x xVar) {
            try {
                this.pZE = w.a("wbas", xVar);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a i(x xVar, String str) {
            try {
                this.pZE = w.a("vvsf", xVar);
                hu("desc", str);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a c(x xVar, int i) {
            try {
                this.pZE = w.a("vvst", xVar);
                Q("desc", i);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, long j) {
            try {
                this.pZE = w.a("vvss", xVar);
                Q("desc", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a F(int i, long j) {
            try {
                this.pZE = w.eGF();
                hu("e", "bce").hu("timeis", w.eGG()).Q(BdStatsConstant.StatsKey.COUNT, i).Q("dr", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a js(long j) {
            try {
                this.pZE = w.eGF();
                hu("e", "hbt").Q("dr", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, long j, int i, int i2) {
            try {
                this.pZE = w.a("be", xVar);
                Q("dr", j).Q(BdStatsConstant.StatsKey.COUNT, i).Q("num", i2);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a a(x xVar, int i, long j) {
            try {
                this.pZE = w.a("bpe", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, i).Q("dr", j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a b(x xVar, int i, String str) {
            try {
                this.pZE = w.a("ps", xVar);
                Q(BdStatsConstant.StatsKey.COUNT, i);
                hu("msg", str);
            } catch (JSONException e) {
            }
            return this;
        }

        public final a aaI(String str) {
            try {
                this.pZE = w.eGF();
                hu("e", "Ld").hu("pid", str).hu("timeis", w.eGG());
            } catch (JSONException e) {
            }
            return this;
        }

        public final a hu(String str, String str2) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    this.pZE.key(str).value(str2);
                }
            } catch (JSONException e) {
            }
            return this;
        }

        private a Q(String str, long j) {
            try {
                this.pZE.key(str).value(j);
            } catch (JSONException e) {
            }
            return this;
        }

        public final void eGz() {
            JSONArray jSONArray = new JSONArray();
            try {
                if (!TextUtils.isEmpty(this.pZE.toString())) {
                    this.pZE.endObject();
                    this.java = this.pZE.toString();
                }
                JSONObject jSONObject = new JSONObject(this.java);
                String optString = jSONObject.optString("e");
                if (!aaC(optString)) {
                    boolean z = !bc.c(w.pZs, optString);
                    jSONArray.put(jSONObject);
                    L(z, jSONArray.toString());
                }
            } catch (JSONException e) {
            }
        }

        private boolean aaC(String str) {
            if (az.c(this.pYI) < 0) {
                return false;
            }
            return bc.c(w.pZs, str) ? az.c(this.pYI) <= 0 : bc.c(w.pZD, str) ? az.c(this.pYI) < 2 : bc.c(w.f13765a, str) ? az.c(this.pYI) < 3 : bc.c(w.f13766b, str) && az.c(this.pYI) < 4;
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
                        str2 = str2 + ak.R(ak.iM(a.this.pYI));
                    } catch (UnsupportedEncodingException e) {
                    }
                    String str3 = str;
                    r<am> rVar = new r<am>() { // from class: com.win.opensdk.w.a.1.1
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.win.opensdk.r
                        public final /* bridge */ /* synthetic */ void bH(am amVar) {
                        }

                        @Override // com.win.opensdk.r
                        public final void eGz() {
                        }

                        @Override // com.win.opensdk.r
                        public final void cd(int i, String str4) {
                        }
                    };
                    try {
                        rVar.eGz();
                        s sVar = new s(str2, "POST", ai.eGM());
                        if (str3 == null || str3.length() == 0) {
                            bArr = new byte[0];
                        } else {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(str3.getBytes("UTF-8"));
                            gZIPOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        }
                        sVar.pZy = bArr;
                        t eGD = sVar.eGD();
                        am amVar = new am();
                        int a2 = ai.a(eGD, amVar);
                        if (a2 == 200) {
                            rVar.bH(amVar);
                        } else {
                            rVar.cd(a2, amVar.f23java);
                        }
                    } catch (JSONException e2) {
                        rVar.cd(101, e2.getMessage());
                    } catch (Exception e3) {
                        rVar.cd(100, e3.getMessage());
                    }
                }
            });
        }
    }

    public static String aaG(String str) {
        try {
            return bc.aaH(str);
        } catch (Exception e) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String eGG() {
        return aaG(String.valueOf(System.currentTimeMillis()));
    }

    static /* synthetic */ JSONStringer a(String str, x xVar) {
        JSONStringer eGF = eGF();
        eGF.key("e").value(str).key("timeis").value(eGG());
        if (xVar != null) {
            eGF.key("pid").value(xVar.java);
            if (xVar.pZd != null) {
                eGF.key("traceid").value(aaG(xVar.pZd.getTraceid())).key(IXAdRequestInfo.CELL_ID).value(aaG(xVar.pZd.getId())).key("type").value(xVar.pZd.getType());
            }
        }
        return eGF;
    }
}
