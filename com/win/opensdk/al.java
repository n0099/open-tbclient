package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.win.opensdk.core.Info;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    private static String f14023a = al.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static String f14024b = "https://pp.xdplt.com/";
    public static final String java = f14024b + "behavior?";

    /* renamed from: case  reason: not valid java name */
    public static final String f22case = f14024b + "report?";
    private static String c = "https://cd.xdplt.com/";
    private static String d = "jy/da?";
    private static String e = "?";
    private static String f = "jy/da?";
    private static String g = "jy/da?";
    private static String h = "jy/da?";

    public static String java() {
        return c;
    }

    public static String eKw() {
        return c + "jy/cf?";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: case  reason: not valid java name */
        String f23case;
        String java;
        Context qdj;
        protected r<bh> qey;

        public a(Context context) {
            this.qdj = context;
        }

        public final a a(r<bh> rVar) {
            this.qey = rVar;
            return this;
        }

        public final void eKp() {
            this.f23case = al.java() + al.d;
            al.a(this);
        }

        public final void eKq() {
            this.f23case = al.java() + al.e;
            al.a(this);
        }

        public final void a() {
            this.f23case = al.java() + al.f;
            al.a(this);
        }

        public final void b() {
            this.f23case = al.java() + al.g;
            al.a(this);
        }

        public final void c() {
            this.f23case = al.java() + al.h;
            al.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static bh fm(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    bh bhVar = new bh();
                    bhVar.f14026a = jSONObject.optString("traceid", "");
                    bhVar.java = jSONObject.optString("pid", "");
                    bhVar.f26case = jSONObject.optString("bt", "");
                    JSONArray optJSONArray = jSONObject.optJSONArray("list");
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null && optJSONObject.length() > 0) {
                                Info info = new Info();
                                info.setTraceid(bhVar.f14026a);
                                info.setPid(bhVar.java);
                                info.setId(optJSONObject.optString("id", ""));
                                info.setLoad(optJSONObject.optString(TrackLoadSettingsAtom.TYPE, ""));
                                info.setLoad_type(optJSONObject.optString("load_type", ""));
                                info.setXn(optJSONObject.optInt("xn", 1));
                                info.setType(optJSONObject.optInt("type", 0));
                                info.setCache(optJSONObject.optInt("cache", SdkConfigData.DEFAULT_REQUEST_INTERVAL));
                                info.setCb(optJSONObject.optInt("cb", 0));
                                int optInt = optJSONObject.optInt("cdt", 0);
                                if (optInt > 30) {
                                    optInt = 30;
                                }
                                info.setCdt(optInt);
                                int optInt2 = optJSONObject.optInt("wt", 10);
                                if (optInt2 < 5) {
                                    optInt2 = 5;
                                }
                                info.setWt(optInt2);
                                int optInt3 = optJSONObject.optInt("tsi", 8);
                                if (optInt3 < 5) {
                                    optInt3 = 5;
                                }
                                info.setTsi(optInt3);
                                info.setPs(optJSONObject.optInt("ps", 0));
                                info.setVertical(optJSONObject.optBoolean(VerticalTranslateLayout.VERTICAL, true));
                                info.setNat(optJSONObject.optBoolean("nat", true));
                                info.setOpen(optJSONObject.optString("open", ""));
                                info.setTitle(optJSONObject.optString("title", ""));
                                info.setDesc(optJSONObject.optString("desc", ""));
                                info.setIcon(optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, ""));
                                info.setBtndesc(optJSONObject.optString("btndesc", ""));
                                info.setOpent(optJSONObject.optInt("opent", 0));
                                info.setDl_pkg(optJSONObject.optString("dl_pkg", ""));
                                info.setDl_name(optJSONObject.optString("dl_name", ""));
                                info.setDpl(optJSONObject.optString("dpl", ""));
                                info.setDl_vsc(optJSONObject.optInt("dl_vsc", 0));
                                info.setVvamount(optJSONObject.optLong("vvamount", 0L));
                                info.setSpet(optJSONObject.optLong("spet", 1100L));
                                info.setCountdown(optJSONObject.optLong("countdown", 5000L));
                                info.setLo_timeout(optJSONObject.optLong("lo_timeout", 1000L));
                                info.setVvt(optJSONObject.optInt("vvt", 0));
                                info.setSper(optJSONObject.optDouble("sper", 0.5d));
                                info.setImp_urls(optJSONObject.optString("imp_urls"));
                                info.setClick_urls(optJSONObject.optString("click_urls"));
                                info.setVv_click_urls(optJSONObject.optString("vv_click_urls"));
                                info.setVv_downf_urls(optJSONObject.optString("vv_downf_urls"));
                                info.setVv_downs_urls(optJSONObject.optString("vv_downs_urls"));
                                info.setVv_finish_urls(optJSONObject.optString("vv_finish_urls"));
                                info.setVv_ins_urls(optJSONObject.optString("vv_ins_urls"));
                                info.setVv_show_urls(optJSONObject.optString("vv_show_urls"));
                                info.setVv_start_urls(optJSONObject.optString("vv_start_urls"));
                                info.setW(optJSONObject.optInt("w", 0));
                                info.setH(optJSONObject.optInt("h", 0));
                                info.setEvents(optJSONObject.optString("events"));
                                arrayList.add(info);
                            }
                        }
                    }
                    bhVar.qen = arrayList;
                    return bhVar;
                }
            } catch (Exception e2) {
                return null;
            }
        }
        return null;
    }

    static /* synthetic */ void a(final a aVar) {
        if (TextUtils.isEmpty(aVar.f23case) || aVar.qdj == null || TextUtils.isEmpty(aVar.java)) {
            return;
        }
        ba.D(new Runnable() { // from class: com.win.opensdk.al.1
            @Override // java.lang.Runnable
            public final void run() {
                HashMap<String, String> iO = ak.iO(a.this.qdj);
                iO.put("pid", a.this.java);
                al.a(a.this, iO);
                al.b(a.this, iO);
                al.c(a.this, iO);
                String str = "";
                try {
                    str = a.this.f23case + ak.R(iO);
                } catch (UnsupportedEncodingException e2) {
                }
                ai.a(str, new r<am>() { // from class: com.win.opensdk.al.1.1
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.win.opensdk.r
                    public final /* synthetic */ void bH(am amVar) {
                        bh fm = al.fm(amVar.qez);
                        if (a.this.qey != null) {
                            if (fm == null) {
                                a.this.qey.cc(101, "");
                            } else if (!TextUtils.isEmpty(a.this.java) && a.this.java.equalsIgnoreCase(fm.java)) {
                                a.this.qey.bH(fm);
                            } else {
                                a.this.qey.cc(2003, "");
                            }
                        }
                    }

                    @Override // com.win.opensdk.r
                    public final void eKp() {
                        if (a.this.qey != null) {
                            a.this.qey.eKp();
                        }
                    }

                    @Override // com.win.opensdk.r
                    public final void cc(int i, String str2) {
                        if (a.this.qey != null) {
                            a.this.qey.cc(i, str2);
                        }
                    }
                });
            }
        });
    }

    static /* synthetic */ void a(a aVar, HashMap hashMap) {
        if (!aVar.java.startsWith("602")) {
            return;
        }
        hashMap.put("lo_timeout", String.valueOf(az.m64a(aVar.qdj)));
    }

    static /* synthetic */ void b(a aVar, HashMap hashMap) {
        try {
            String[] split = az.f(aVar.qdj).split(",");
            ArrayList<aa> arrayList = new ArrayList();
            arrayList.clear();
            for (String str : split) {
                String[] split2 = str.split(":");
                String str2 = split2[0];
                String str3 = split2[1];
                if (System.currentTimeMillis() - Long.parseLong(str3) < az.m72e(aVar.qdj)) {
                    aa aaVar = new aa();
                    aaVar.java = str2;
                    aaVar.qdF = Long.parseLong(str3);
                    arrayList.add(aaVar);
                }
            }
            if (!arrayList.isEmpty()) {
                String str4 = "";
                String str5 = "";
                for (aa aaVar2 : arrayList) {
                    str4 = str4 + aaVar2.java + ",";
                    str5 = str5 + aaVar2.java + ":" + aaVar2.qdF + ",";
                }
                if (!TextUtils.isEmpty(str4)) {
                    hashMap.put("a605", str4.substring(0, str4.length() - 1));
                }
                if (!TextUtils.isEmpty(str5)) {
                    az.k(aVar.qdj, str5.substring(0, str5.length() - 1), true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void c(a aVar, HashMap hashMap) {
        try {
            String[] split = az.g(aVar.qdj).split(",");
            ArrayList<aa> arrayList = new ArrayList();
            arrayList.clear();
            for (String str : split) {
                String[] split2 = str.split(":");
                String str2 = split2[0];
                String str3 = split2[1];
                if (System.currentTimeMillis() - Long.parseLong(str3) <= az.m72e(aVar.qdj)) {
                    aa aaVar = new aa();
                    aaVar.java = str2;
                    aaVar.qdF = Long.parseLong(str3);
                    arrayList.add(aaVar);
                }
            }
            if (!arrayList.isEmpty()) {
                String str4 = "";
                String str5 = "";
                for (aa aaVar2 : arrayList) {
                    str4 = str4 + aaVar2.java + ",";
                    str5 = str5 + aaVar2.java + ":" + aaVar2.qdF + ",";
                }
                if (!TextUtils.isEmpty(str4)) {
                    hashMap.put("a601", str4.substring(0, str4.length() - 1));
                }
                if (!TextUtils.isEmpty(str5)) {
                    az.l(aVar.qdj, str5.substring(0, str5.length() - 1), true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
