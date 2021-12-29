package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.f;
import com.ss.android.downloadlib.g.c;
import com.ss.android.downloadlib.g.l;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public SoftReference<Activity> a;

    /* loaded from: classes3.dex */
    public static class a {
        public static b a = new b();
    }

    public void b(long j2) {
        com.ss.android.downloadlib.addownload.e a2 = f.a().a(com.ss.android.downloadlib.addownload.b.f.a().e(j2).f61804b.getDownloadUrl());
        if (a2 != null) {
            a2.a(true, true);
            return;
        }
        e.a(11, j2);
        com.ss.android.downloadlib.e.c.a().b("startDownload handler null");
    }

    public b() {
    }

    public static b a() {
        return a.a;
    }

    public void a(long j2) {
        TTDelegateActivity.a(j2);
    }

    public boolean a(DownloadModel downloadModel) {
        if (downloadModel.isAd() && j.i().optInt("ad_lp_show_app_dialog") != 0) {
            String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
            return (TextUtils.isEmpty(webUrl) || Pattern.compile(j.i().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
        }
        return false;
    }

    public Activity b() {
        Activity activity = this.a.get();
        this.a = null;
        return activity;
    }

    public boolean a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar) {
        long j2;
        long j3;
        if (!TextUtils.isEmpty(eVar.f61804b.getLogExtra())) {
            try {
                j2 = l.a(new JSONObject(eVar.f61804b.getLogExtra()), "convert_id");
            } catch (Exception e2) {
                e2.printStackTrace();
                j2 = 0;
            }
            if (j2 <= 0) {
                e.a(3, eVar);
            }
            j3 = j2;
        } else {
            e.a(9, eVar);
            com.ss.android.downloadlib.e.c.a().a("requestAppInfo getLogExtra null");
            j3 = 0;
        }
        final long j4 = eVar.a;
        com.ss.android.downloadlib.addownload.b.b a2 = c.a().a(j3, j4);
        if (a2 != null) {
            d.a().a(a2.a(), j4, a2.f61783d);
            a(a2.a());
            e.a("lp_app_dialog_try_show", eVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j3 > 0) {
            sb.append("convert_id=");
            sb.append(j3);
        }
        if (!TextUtils.isEmpty(eVar.f61804b.getPackageName())) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("package_name=");
            sb.append(eVar.f61804b.getPackageName());
        }
        if (sb.length() <= 0) {
            e.a(6, eVar);
            return false;
        }
        final long j5 = j3;
        com.ss.android.downloadlib.g.c.a((c.a<String, R>) new c.a<String, Boolean>() { // from class: com.ss.android.downloadlib.addownload.compliance.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ss.android.downloadlib.g.c.a
            public Boolean a(String str) {
                final boolean[] zArr = {false};
                j.d().a("GET", str, new HashMap(), new q() { // from class: com.ss.android.downloadlib.addownload.compliance.b.2.1
                    @Override // com.ss.android.download.api.config.q
                    public void a(String str2) {
                        boolean[] zArr2 = zArr;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        zArr2[0] = b.this.a(j5, j4, str2);
                    }

                    @Override // com.ss.android.download.api.config.q
                    public void a(Throwable th) {
                        e.a(2, j4);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).a(new c.a<Boolean, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ss.android.downloadlib.g.c.a
            public Object a(Boolean bool) {
                if (bool.booleanValue()) {
                    b.this.a(com.ss.android.downloadlib.addownload.b.b.a(j5, j4));
                    e.b("lp_app_dialog_try_show", j4);
                    return null;
                }
                b.this.b(j4);
                return null;
            }
        }).a();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(long j2, long j3, String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("package");
            if (optJSONObject != null && optJSONObject.length() != 0) {
                com.ss.android.downloadlib.addownload.b.b bVar = new com.ss.android.downloadlib.addownload.b.b();
                bVar.a = j2;
                bVar.f61781b = j3;
                bVar.f61783d = optJSONObject.optString("icon_url");
                bVar.f61784e = optJSONObject.optString("app_name");
                bVar.f61782c = optJSONObject.optString("package_name");
                bVar.f61785f = optJSONObject.optString("version_name");
                bVar.f61786g = optJSONObject.optString("developer_name");
                bVar.f61788i = optJSONObject.optString("policy_url");
                JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject = (JSONObject) optJSONArray.get(i2);
                        bVar.f61787h.add(new Pair<>(jSONObject.optString(IdCardActivity.RESULT_PERMISSION_KEY), jSONObject.optString("permission_desc")));
                    }
                }
                c.a().a(bVar);
                d.a().a(bVar.a(), j3, bVar.f61783d);
                return true;
            }
            e.a(7, j3);
            return false;
        } catch (Exception e2) {
            com.ss.android.downloadlib.e.c.a().a(e2, "AdLpComplianceManager parseResponse");
            e.a(7, j3);
            return false;
        }
    }

    public void a(Activity activity) {
        this.a = new SoftReference<>(activity);
    }
}
