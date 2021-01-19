package com.win.opensdk;

import android.text.TextUtils;
import com.win.opensdk.core.Info;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public final class z {
    public static void a(Info info) {
        try {
            a(info, 200);
            if (info != null && !TextUtils.isEmpty(info.getClick_urls())) {
                aaE(info.getClick_urls());
            } else if (info != null && !TextUtils.isEmpty(info.getVv_click_urls())) {
                aaE(info.getVv_click_urls());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(Info info) {
        try {
            a(info, 100);
            if (info != null && !TextUtils.isEmpty(info.getImp_urls())) {
                aaE(info.getImp_urls());
            } else if (info != null && !TextUtils.isEmpty(info.getVv_show_urls())) {
                aaE(info.getVv_show_urls());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Info info, int i) {
        if (info != null) {
            aaE(cn(info.getEvents().get(i, ""), i));
        }
    }

    private static String cn(String str, int i) {
        if (i == 200 || i == 100) {
            try {
                return str.replaceAll("__TIMESTAMP__", String.valueOf(System.currentTimeMillis()));
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }
        return str;
    }

    public static void aaE(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        final String optString = jSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString)) {
                            ba.D(new Runnable() { // from class: com.win.opensdk.z.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ai.a(optString, new r<am>() { // from class: com.win.opensdk.z.1.1
                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                        @Override // com.win.opensdk.r
                                        public final /* bridge */ /* synthetic */ void bH(am amVar) {
                                        }

                                        @Override // com.win.opensdk.r
                                        public final void eGz() {
                                        }

                                        @Override // com.win.opensdk.r
                                        public final void cd(int i2, String str2) {
                                        }
                                    });
                                }
                            });
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
