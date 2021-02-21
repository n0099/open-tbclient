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
/* loaded from: classes3.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    private static String f13725a = al.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static String f13726b = "https://pp.xdplt.com/";
    public static final String java = f13726b + "behavior?";

    /* renamed from: case  reason: not valid java name */
    public static final String f21case = f13726b + "report?";
    private static String c = "https://cd.xdplt.com/";
    private static String d = "jy/da?";
    private static String e = "?";
    private static String f = "jy/da?";
    private static String g = "jy/da?";
    private static String h = "jy/da?";

    public static String java() {
        return c;
    }

    public static String eJe() {
        return c + "jy/cf?";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: case  reason: not valid java name */
        String f22case;
        String java;
        Context qjn;
        protected r<bh> qkC;

        public a(Context context) {
            this.qjn = context;
        }

        public final a a(r<bh> rVar) {
            this.qkC = rVar;
            return this;
        }

        public final void eIX() {
            this.f22case = al.java() + al.d;
            al.a(this);
        }

        public final void eIY() {
            this.f22case = al.java() + al.e;
            al.a(this);
        }

        public final void a() {
            this.f22case = al.java() + al.f;
            al.a(this);
        }

        public final void b() {
            this.f22case = al.java() + al.g;
            al.a(this);
        }

        public final void c() {
            this.f22case = al.java() + al.h;
            al.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static bh fn(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    bh bhVar = new bh();
                    bhVar.f13728a = jSONObject.optString("traceid", "");
                    bhVar.java = jSONObject.optString("pid", "");
                    bhVar.f25case = jSONObject.optString("bt", "");
                    JSONArray optJSONArray = jSONObject.optJSONArray("list");
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null && optJSONObject.length() > 0) {
                                Info info = new Info();
                                info.setTraceid(bhVar.f13728a);
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
                    bhVar.qkr = arrayList;
                    return bhVar;
                }
            } catch (Exception e2) {
                return null;
            }
        }
        return null;
    }

    static /* synthetic */ void a(final a aVar) {
        if (TextUtils.isEmpty(aVar.f22case) || aVar.qjn == null || TextUtils.isEmpty(aVar.java)) {
            return;
        }
        ba.C(new Runnable() { // from class: com.win.opensdk.al.1
            @Override // java.lang.Runnable
            public final void run() {
                HashMap<String, String> iP = ak.iP(a.this.qjn);
                iP.put("pid", a.this.java);
                al.a(a.this, iP);
                al.b(a.this, iP);
                al.c(a.this, iP);
                String str = "";
                try {
                    str = a.this.f22case + ak.T(iP);
                } catch (UnsupportedEncodingException e2) {
                }
                ai.a(str, new r<am>() { // from class: com.win.opensdk.al.1.1
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.win.opensdk.r
                    public final /* synthetic */ void bH(am amVar) {
                        bh fn = al.fn(amVar.qkD);
                        if (a.this.qkC != null) {
                            if (fn == null) {
                                a.this.qkC.ck(101, "");
                            } else if (!TextUtils.isEmpty(a.this.java) && a.this.java.equalsIgnoreCase(fn.java)) {
                                a.this.qkC.bH(fn);
                            } else {
                                a.this.qkC.ck(2003, "");
                            }
                        }
                    }

                    @Override // com.win.opensdk.r
                    public final void eIX() {
                        if (a.this.qkC != null) {
                            a.this.qkC.eIX();
                        }
                    }

                    @Override // com.win.opensdk.r
                    public final void ck(int i, String str2) {
                        if (a.this.qkC != null) {
                            a.this.qkC.ck(i, str2);
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
        hashMap.put("lo_timeout", String.valueOf(az.m59a(aVar.qjn)));
    }

    static /* synthetic */ void b(a aVar, HashMap hashMap) {
        try {
            String[] split = az.f(aVar.qjn).split(",");
            ArrayList<aa> arrayList = new ArrayList();
            arrayList.clear();
            for (String str : split) {
                String[] split2 = str.split(":");
                String str2 = split2[0];
                String str3 = split2[1];
                if (System.currentTimeMillis() - Long.parseLong(str3) < az.m67e(aVar.qjn)) {
                    aa aaVar = new aa();
                    aaVar.java = str2;
                    aaVar.qjJ = Long.parseLong(str3);
                    arrayList.add(aaVar);
                }
            }
            if (!arrayList.isEmpty()) {
                String str4 = "";
                String str5 = "";
                for (aa aaVar2 : arrayList) {
                    str4 = str4 + aaVar2.java + ",";
                    str5 = str5 + aaVar2.java + ":" + aaVar2.qjJ + ",";
                }
                if (!TextUtils.isEmpty(str4)) {
                    hashMap.put("a605", str4.substring(0, str4.length() - 1));
                }
                if (!TextUtils.isEmpty(str5)) {
                    az.k(aVar.qjn, str5.substring(0, str5.length() - 1), true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void c(a aVar, HashMap hashMap) {
        try {
            String[] split = az.g(aVar.qjn).split(",");
            ArrayList<aa> arrayList = new ArrayList();
            arrayList.clear();
            for (String str : split) {
                String[] split2 = str.split(":");
                String str2 = split2[0];
                String str3 = split2[1];
                if (System.currentTimeMillis() - Long.parseLong(str3) <= az.m67e(aVar.qjn)) {
                    aa aaVar = new aa();
                    aaVar.java = str2;
                    aaVar.qjJ = Long.parseLong(str3);
                    arrayList.add(aaVar);
                }
            }
            if (!arrayList.isEmpty()) {
                String str4 = "";
                String str5 = "";
                for (aa aaVar2 : arrayList) {
                    str4 = str4 + aaVar2.java + ",";
                    str5 = str5 + aaVar2.java + ":" + aaVar2.qjJ + ",";
                }
                if (!TextUtils.isEmpty(str4)) {
                    hashMap.put("a601", str4.substring(0, str4.length() - 1));
                }
                if (!TextUtils.isEmpty(str5)) {
                    az.l(aVar.qjn, str5.substring(0, str5.length() - 1), true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
