package com.win.opensdk;

import android.text.TextUtils;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class el {

    /* renamed from: a */
    public static String f8163a = "https://pp.xdplt.com/";
    public static final String b = f8163a + "behavior?";
    public static final String c = f8163a + "report?";
    public static String d = "https://cd.xdplt.com/";
    public static String e = "jy/da?";
    public static String f = "?";
    public static String g = "jy/da?";
    public static String h = "jy/da?";
    public static String i = "jy/da?";

    public static /* synthetic */ void b(eh ehVar) {
        String str;
        if (ehVar != null) {
            str = ehVar.c;
            if (TextUtils.isEmpty(str) || ehVar.f8161a == null || TextUtils.isEmpty(ehVar.b)) {
                return;
            }
            bt.a(new ed(ehVar));
        }
    }

    public static /* synthetic */ n fq(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    n nVar = new n();
                    nVar.c = jSONObject.optString("traceid", "");
                    nVar.b = jSONObject.optString("pid", "");
                    jSONObject.optString("bt", "");
                    JSONArray optJSONArray = jSONObject.optJSONArray("list");
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                            if (optJSONObject != null && optJSONObject.length() > 0) {
                                Info info = new Info();
                                info.setTraceid(nVar.c);
                                info.setPid(nVar.a());
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
                                info.setHo_c_sw(optJSONObject.optBoolean("ho_c_sw", true));
                                info.setOpen(optJSONObject.optString("open", ""));
                                info.setTitle(optJSONObject.optString("title", ""));
                                info.setDesc(optJSONObject.optString("desc", ""));
                                info.setIcon(optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, ""));
                                info.setImage(optJSONObject.optString("image", ""));
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
                    nVar.f8169a = arrayList;
                    return nVar;
                }
            } catch (Exception e2) {
            }
        }
        return null;
    }

    public static /* synthetic */ void a(eh ehVar, HashMap hashMap) {
        if (ehVar.b.startsWith("602")) {
            hashMap.put("lo_timeout", String.valueOf(bp.iR(ehVar.f8161a)));
        }
    }
}
