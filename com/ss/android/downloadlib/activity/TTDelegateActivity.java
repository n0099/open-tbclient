package com.ss.android.downloadlib.activity;

import android.app.Activity;
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
import com.baidu.live.tbadk.pay.PayHelper;
import com.ss.android.a.a.a.k;
import com.ss.android.a.a.a.q;
import com.ss.android.a.a.d.c;
import com.ss.android.b.a.b.a;
import com.ss.android.downloadlib.a.a.e;
import com.ss.android.downloadlib.a.b.d;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.a.l;
import com.ss.android.downloadlib.f.g;
import com.ss.android.downloadlib.f.i;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.g.c;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {

    /* renamed from: a  reason: collision with root package name */
    protected Intent f13264a = null;

    public static void a(String str, String[] strArr) {
        Intent intent = new Intent(j.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (j.a() != null) {
            j.a().startActivity(intent);
        }
    }

    public static void a(String str) {
        Intent intent = new Intent(j.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 2);
        intent.putExtra("open_url", str);
        if (j.a() != null) {
            j.a().startActivity(intent);
        }
    }

    public static void a(long j) {
        Intent intent = new Intent(j.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 4);
        intent.putExtra("model_id", j);
        if (j.a() != null) {
            j.a().startActivity(intent);
        }
    }

    public static void b(long j) {
        Intent intent = new Intent(j.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 5);
        intent.putExtra("model_id", j);
        if (j.a() != null) {
            j.a().startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        b();
        this.f13264a = getIntent();
        j.b(this);
        a();
    }

    private void b() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f13264a = intent;
        j.b(this);
        a();
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        j.eGh().a(this, i, strArr, iArr);
    }

    protected void a() {
        if (this.f13264a != null) {
            switch (this.f13264a.getIntExtra("type", 0)) {
                case 1:
                    b(this.f13264a.getStringExtra("permission_id_key"), this.f13264a.getStringArrayExtra("permission_content_key"));
                    break;
                case 2:
                    b(this.f13264a.getStringExtra("open_url"));
                    break;
                case 3:
                default:
                    i.a((Activity) this);
                    break;
                case 4:
                    d(this.f13264a.getLongExtra("model_id", 0L));
                    break;
                case 5:
                    c(this.f13264a.getLongExtra("model_id", 0L));
                    break;
            }
            this.f13264a = null;
        }
    }

    private void c(long j) {
        if (l.eGu() != null) {
            a jb = d.eFT().jb(j);
            if (jb != null) {
                c h = f.iA(j.a()).h(jb.t());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - jb.eFI()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(jb.eFJ()));
                    if (h != null) {
                        jSONObject.putOpt("download_length", Long.valueOf(h.eIz()));
                        jSONObject.putOpt("download_percent", Long.valueOf(h.eIz() / h.ejL()));
                        jSONObject.putOpt("download_apk_size", Long.valueOf(h.ejL()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                com.ss.android.downloadlib.e.a.eGB().a("pause_reserve_wifi_dialog_show", jSONObject, jb);
            }
            new e(this, l.eGu()).show();
        }
    }

    private void b(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            i.a((Activity) this);
            return;
        }
        q qVar = new q() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1
            private WeakReference<Activity> c;

            {
                this.c = new WeakReference<>(TTDelegateActivity.this);
            }

            @Override // com.ss.android.a.a.a.q
            public void a() {
                g.a(str);
                i.a(this.c.get());
            }

            @Override // com.ss.android.a.a.a.q
            public void a(String str2) {
                g.a(str, str2);
                i.a(this.c.get());
            }
        };
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                j.eGh().a(this, strArr, qVar);
                return;
            } catch (Exception e) {
                qVar.a();
                return;
            }
        }
        qVar.a();
    }

    private void b(String str) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            i.a((Activity) this);
        }
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.putExtra("open_url", str);
            intent.addFlags(268435456);
            startActivity(intent);
        }
    }

    private void d(long j) {
        final a jb = d.eFT().jb(j);
        if (jb == null) {
            i.b();
            i.a((Activity) this);
            return;
        }
        k eGf = j.eGf();
        c.a aal = new c.a(this).aal("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(jb.C()) ? "刚刚下载的应用" : jb.C();
        eGf.b(aal.aam(String.format("%1$s已安装完成，是否立即打开？", objArr)).aan("打开").aao(PayHelper.STATUS_CANCEL_DESC).Bt(false).I(i.c(this, jb.m())).a(new c.b() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
            @Override // com.ss.android.a.a.d.c.b
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.b.a.a(jb);
                dialogInterface.dismiss();
                i.a((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.a.a.d.c.b
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.e.a.eGB().a("market_openapp_cancel", jb);
                dialogInterface.dismiss();
                i.a((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.a.a.d.c.b
            public void c(DialogInterface dialogInterface) {
                i.a((Activity) TTDelegateActivity.this);
            }
        }).RX(2).eFC());
        com.ss.android.downloadlib.e.a.eGB().a("market_openapp_window_show", jb);
    }
}
