package com.ss.android.downloadlib.a.d;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.f;
import com.ss.android.downloadlib.f.i;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.g.e;
import com.tencent.open.SocialOperation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static void a(c cVar, long j, String str, String str2) {
        if (cVar != null && j.eES() != null) {
            String optString = j.i().optString("upload_secret_key");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    final HashMap hashMap = new HashMap();
                    String str3 = j.eEW().b;
                    hashMap.put("from", str3);
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    hashMap.put("timestamp", valueOf);
                    hashMap.put(SocialOperation.GAME_SIGNATURE, a(str3, valueOf, optString));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(LegoListActivityConfig.AD_ID, j);
                    jSONObject.put("log_extra", str);
                    jSONObject.put("download_url", cVar.j());
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("app_name", cVar.i());
                    jSONObject2.put("package_name", str2);
                    jSONObject2.put("package_size", cVar.am());
                    List<e> eHf = cVar.eHf();
                    if (eHf != null && !eHf.isEmpty()) {
                        Iterator<e> it = eHf.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            e next = it.next();
                            if (TextUtils.equals(next.a(), "User-Agent")) {
                                jSONObject2.put("User-Agent", next.b());
                                break;
                            }
                        }
                    }
                    jSONObject.put("request_info", jSONObject2.toString());
                    hashMap.put("info", jSONObject.toString());
                    f.eFl().b(new Runnable() { // from class: com.ss.android.downloadlib.a.d.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            j.eES().a("POST", "https://i.snssdk.com/inspect/aegis/client/app/resend/", hashMap, null);
                        }
                    });
                } catch (Exception e) {
                }
            }
        }
    }

    private static String a(String str, String str2, @NonNull String str3) {
        try {
            return Base64.encodeToString(i.a((str + "|" + str2).getBytes(), str3.getBytes(), "HmacSHA1"), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
