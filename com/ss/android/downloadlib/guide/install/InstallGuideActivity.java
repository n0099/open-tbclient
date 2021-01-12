package com.ss.android.downloadlib.guide.install;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.appdownloader.c.m;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.m.g;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class InstallGuideActivity extends TTDelegateActivity {
    private static m pSG;

    public static void a(int i, @NonNull m mVar) {
        pSG = mVar;
        Intent intent = new Intent(j.a(), InstallGuideActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 6);
        intent.putExtra("download_info_id", i);
        j.a().startActivity(intent);
    }

    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    protected void a() {
        Drawable drawable = null;
        PackageInfo packageInfo = null;
        if (this.f12964a == null) {
            this.f12964a = getIntent();
        }
        if (this.f12964a.getIntExtra("type", 0) == 6) {
            int intExtra = this.f12964a.getIntExtra("download_info_id", 0);
            String b2 = b(intExtra);
            long QD = com.ss.android.downloadlib.f.d.QD(intExtra);
            com.ss.android.socialbase.downloader.g.c h = f.iy(j.a()).h(intExtra);
            if (h == null) {
                a(intExtra);
                return;
            }
            String h2 = h.h();
            File file = new File(h.k(), h.h());
            if (file.exists()) {
                PackageManager packageManager = j.a().getPackageManager();
                try {
                    packageInfo = packageManager.getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.c.a());
                } catch (Exception e) {
                }
                if (packageInfo != null && packageInfo.applicationInfo != null) {
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    applicationInfo.publicSourceDir = file.getAbsolutePath();
                    h2 = applicationInfo.loadLabel(packageManager).toString();
                    drawable = packageManager.getApplicationIcon(applicationInfo);
                } else {
                    a(intExtra);
                    return;
                }
            }
            c.b();
            j.eCA().a(this, intExtra, h2, drawable, b2, QD, pSG);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        j.eCA().a();
    }

    private void a(int i) {
        if (pSG != null) {
            pSG.a();
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_info_id", Integer.valueOf(i));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        j.eCr().a(null, new com.ss.android.socialbase.downloader.e.a(0, jSONObject.toString()), 6);
    }

    private String b(int i) {
        if (g.b()) {
            return com.ss.android.downloadlib.f.d.QB(i);
        }
        if (g.d()) {
            return com.ss.android.downloadlib.f.d.Oo(i);
        }
        if (g.c()) {
            return com.ss.android.downloadlib.f.d.Op(i);
        }
        if (!g.a()) {
            return "";
        }
        return com.ss.android.downloadlib.f.d.Oq(i);
    }
}
