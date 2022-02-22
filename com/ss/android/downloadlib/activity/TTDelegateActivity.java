package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import com.google.protobuf.CodedInputStream;
import com.ss.android.download.api.config.k;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadad.api.a.b;
import com.ss.android.downloadlib.addownload.a.d;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.e.c;
import com.ss.android.downloadlib.g;
import com.ss.android.downloadlib.g.h;
import com.ss.android.downloadlib.guide.install.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {

    /* renamed from: d  reason: collision with root package name */
    public static a f59613d;
    public Intent a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59614b;

    /* renamed from: c  reason: collision with root package name */
    public b f59615c;

    public static void a(String str, String[] strArr) {
        Intent intent = new Intent(j.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (j.getContext() != null) {
            j.getContext().startActivity(intent);
        }
    }

    public static void b(String str, com.ss.android.downloadad.api.a.a aVar) {
        Intent c2 = c(aVar);
        c2.addFlags(268435456);
        c2.putExtra("type", 11);
        c2.putExtra("package_name", str);
        if (j.getContext() != null) {
            j.getContext().startActivity(c2);
        }
    }

    public static Intent c(@NonNull com.ss.android.downloadad.api.a.a aVar) {
        return new Intent(j.getContext(), TTDelegateActivity.class);
    }

    private void d(long j2) {
        new com.ss.android.downloadlib.addownload.compliance.a(this, j2).show();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        b();
        this.a = getIntent();
        j.b(this);
        a();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.a = intent;
        j.b(this);
        a();
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        j.e().a(this, i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onStop() {
        DownloadInfo a;
        super.onStop();
        if (!this.f59614b || this.f59615c == null || (a = g.a((Context) null).a(this.f59615c.a())) == null || a.getCurBytes() < a.getTotalBytes() || isFinishing()) {
            return;
        }
        finish();
    }

    private void c() {
        String str;
        long longExtra = this.a.getLongExtra("model_id", 0L);
        String stringExtra = this.a.getStringExtra("message_text");
        String stringExtra2 = this.a.getStringExtra("positive_button_text");
        String stringExtra3 = this.a.getStringExtra("negative_button_text");
        int intExtra = this.a.getIntExtra("type", 0);
        b d2 = f.a().d(longExtra);
        d.a c2 = new d.a(this).a(false).a(stringExtra).b(stringExtra2).c(stringExtra3);
        if (intExtra == 7) {
            if (com.ss.android.downloadlib.addownload.d.b.a() == null) {
                return;
            }
            c2.a(com.ss.android.downloadlib.addownload.d.b.a());
            c2.a().show();
            str = "download_percent";
        } else if (intExtra != 8) {
            str = "";
        } else if (com.ss.android.downloadlib.addownload.d.a.a() == null) {
            return;
        } else {
            c2.a(com.ss.android.downloadlib.addownload.d.a.a());
            c2.a().show();
            str = "apk_size";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f59614b = true;
        this.f59615c = d2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", "show_dialog");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, d2);
    }

    public static void b(@NonNull com.ss.android.downloadad.api.a.a aVar) {
        a(aVar, 5, "", "", "");
    }

    public static void a(String str, com.ss.android.downloadad.api.a.a aVar) {
        Intent c2 = c(aVar);
        c2.addFlags(268435456);
        c2.putExtra("type", 2);
        c2.putExtra("open_url", str);
        if (j.getContext() != null) {
            j.getContext().startActivity(c2);
        }
    }

    public static void b(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3) {
        a(aVar, 7, str, str2, str3);
    }

    private void b() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void b(long j2) {
        if (l.a() == null) {
            return;
        }
        b d2 = f.a().d(j2);
        if (d2 != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(d2.s());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - d2.T()));
                jSONObject.putOpt("click_download_size", Long.valueOf(d2.U()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_dialog_show", jSONObject, d2);
        }
        new d.a(this).a(false).a(l.a()).a().show();
        this.f59614b = true;
        this.f59615c = d2;
    }

    public static void a(com.ss.android.downloadad.api.a.a aVar) {
        Intent c2 = c(aVar);
        c2.addFlags(268435456);
        c2.putExtra("type", 4);
        c2.putExtra("model_id", aVar.b());
        if (j.getContext() != null) {
            j.getContext().startActivity(c2);
        }
    }

    public static void a(com.ss.android.downloadad.api.a.a aVar, a aVar2) {
        Intent c2 = c(aVar);
        c2.addFlags(268435456);
        c2.putExtra("type", 9);
        f59613d = aVar2;
        if (j.getContext() != null) {
            j.getContext().startActivity(c2);
        }
    }

    public static void a(long j2) {
        Intent intent = new Intent(j.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j2);
        if (j.getContext() != null) {
            j.getContext().startActivity(intent);
        }
    }

    private void c(long j2) {
        final b d2 = f.a().d(j2);
        if (d2 == null) {
            c.a().a("showOpenAppDialogInner nativeModel null");
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
            return;
        }
        k c2 = j.c();
        b.a a = new b.a(this).a("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(d2.N()) ? "刚刚下载的应用" : d2.N();
        c2.b(a.b(String.format("%1$s已安装完成，是否立即打开？", objArr)).c("打开").d("取消").a(false).a(com.ss.android.downloadlib.g.l.c(this, d2.e())).a(new b.InterfaceC2195b() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
            @Override // com.ss.android.download.api.model.b.InterfaceC2195b
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.b.a.b(d2);
                dialogInterface.dismiss();
                com.ss.android.socialbase.appdownloader.c.a((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC2195b
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().b("market_openapp_cancel", d2);
                dialogInterface.dismiss();
                com.ss.android.socialbase.appdownloader.c.a((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC2195b
            public void c(DialogInterface dialogInterface) {
                com.ss.android.socialbase.appdownloader.c.a((Activity) TTDelegateActivity.this);
            }
        }).a(2).a());
        com.ss.android.downloadlib.d.a.a().b("market_openapp_window_show", d2);
    }

    private void b(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            s sVar = new s() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1

                /* renamed from: c  reason: collision with root package name */
                public WeakReference<Activity> f59617c;

                {
                    this.f59617c = new WeakReference<>(TTDelegateActivity.this);
                }

                @Override // com.ss.android.download.api.config.s
                public void a() {
                    com.ss.android.downloadlib.g.j.a(str);
                    com.ss.android.socialbase.appdownloader.c.a(this.f59617c.get());
                }

                @Override // com.ss.android.download.api.config.s
                public void a(String str2) {
                    com.ss.android.downloadlib.g.j.a(str, str2);
                    com.ss.android.socialbase.appdownloader.c.a(this.f59617c.get());
                }
            };
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    j.e().a(this, strArr, sVar);
                    return;
                } catch (Exception e2) {
                    j.s().a(e2, "requestPermission");
                    sVar.a();
                    return;
                }
            }
            sVar.a();
            return;
        }
        com.ss.android.socialbase.appdownloader.c.a((Activity) this);
    }

    public static void a(String str, long j2, String str2, @NonNull JSONObject jSONObject) {
        Intent intent = new Intent(j.getContext(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 12);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j2);
        intent.putExtra("param", str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (j.getContext() != null) {
            j.getContext().startActivity(intent);
        }
    }

    private void b(String str) {
        Intent f2 = com.ss.android.downloadlib.g.l.f(this, str);
        if (f2 == null) {
            return;
        }
        try {
            try {
                f2.addFlags(268435456);
                f2.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                startActivity(f2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3) {
        a(aVar, 8, str, str2, str3);
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, int i2, String str, String str2, String str3) {
        Intent c2 = c(aVar);
        c2.addFlags(268435456);
        c2.putExtra("type", i2);
        if (!TextUtils.isEmpty(str2)) {
            c2.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            c2.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str)) {
            c2.putExtra("message_text", str);
        }
        c2.putExtra("model_id", aVar.b());
        if (j.getContext() != null) {
            j.getContext().startActivity(c2);
        }
    }

    public void a() {
        Intent intent = this.a;
        if (intent == null) {
            return;
        }
        switch (intent.getIntExtra("type", 0)) {
            case 1:
                b(this.a.getStringExtra("permission_id_key"), this.a.getStringArrayExtra("permission_content_key"));
                break;
            case 2:
                a(this.a.getStringExtra("open_url"));
                break;
            case 3:
            case 6:
            default:
                com.ss.android.socialbase.appdownloader.c.a((Activity) this);
                break;
            case 4:
                c(this.a.getLongExtra("model_id", 0L));
                break;
            case 5:
                b(this.a.getLongExtra("model_id", 0L));
                break;
            case 7:
            case 8:
                c();
                break;
            case 9:
                a aVar = f59613d;
                if (aVar != null) {
                    aVar.a();
                }
                com.ss.android.socialbase.appdownloader.c.a((Activity) this);
                break;
            case 10:
                d(this.a.getLongExtra("app_info_id", 0L));
                break;
            case 11:
                b(this.a.getStringExtra("package_name"));
                break;
            case 12:
                h.a(this, this.a.getStringExtra("package_name"), this.a.getLongExtra("model_id", 0L), this.a.getStringExtra("param"), this.a.getStringExtra("ext_json"));
                com.ss.android.socialbase.appdownloader.c.a((Activity) this);
                break;
        }
        this.a = null;
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                Uri parse = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.putExtra("open_url", str);
                intent.addFlags(268435456);
                if (com.ss.android.socialbase.downloader.g.a.c().a("fix_app_link_flag")) {
                    intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                }
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }
}
