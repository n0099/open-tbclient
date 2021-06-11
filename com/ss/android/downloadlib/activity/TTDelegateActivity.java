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
import com.alibaba.fastjson.asm.Label;
import com.google.protobuf.CodedInputStream;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.a.a.a.q;
import d.o.a.a.a.d.c;
import d.o.a.d.f.a.d;
import d.o.a.d.f.c;
import d.o.a.d.f.g;
import d.o.a.d.f.n;
import d.o.a.d.f.p;
import d.o.a.d.g;
import d.o.a.d.j;
import d.o.a.d.l;
import d.o.a.d.n.i;
import d.o.a.d.n.k;
import d.o.a.e.a.d;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {

    /* renamed from: d  reason: collision with root package name */
    public static d.o.a.d.m.a.a f39458d;

    /* renamed from: a  reason: collision with root package name */
    public Intent f39459a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39460b;

    /* renamed from: c  reason: collision with root package name */
    public d.o.a.b.a.c.b f39461c;

    /* loaded from: classes7.dex */
    public class b implements c.InterfaceC1920c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.o.a.b.a.c.b f39465a;

        public b(d.o.a.b.a.c.b bVar) {
            this.f39465a = bVar;
        }

        @Override // d.o.a.a.a.d.c.InterfaceC1920c
        public void a(DialogInterface dialogInterface) {
            j.c.a().n("market_openapp_cancel", this.f39465a);
            dialogInterface.dismiss();
            d.q(TTDelegateActivity.this);
        }

        @Override // d.o.a.a.a.d.c.InterfaceC1920c
        public void b(DialogInterface dialogInterface) {
            g.b.j(this.f39465a);
            dialogInterface.dismiss();
            d.q(TTDelegateActivity.this);
        }

        @Override // d.o.a.a.a.d.c.InterfaceC1920c
        public void c(DialogInterface dialogInterface) {
            d.q(TTDelegateActivity.this);
        }
    }

    public static void a(String str, String[] strArr) {
        Intent intent = new Intent(n.a(), TTDelegateActivity.class);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (n.a() != null) {
            n.a().startActivity(intent);
        }
    }

    public static void b(String str, d.o.a.b.a.c.a aVar) {
        Intent c2 = c(aVar);
        c2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        c2.putExtra("type", 11);
        c2.putExtra("package_name", str);
        if (n.a() != null) {
            n.a().startActivity(c2);
        }
    }

    public static Intent c(@NonNull d.o.a.b.a.c.a aVar) {
        return new Intent(n.a(), TTDelegateActivity.class);
    }

    private void d(long j) {
        new d.o.a.d.f.f.a(this, j).show();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        b();
        this.f39459a = getIntent();
        n.l(this);
        a();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f39459a = intent;
        n.l(this);
        a();
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        n.p().a(this, i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onStop() {
        DownloadInfo c2;
        super.onStop();
        if (!this.f39460b || this.f39461c == null || (c2 = l.b(null).c(this.f39461c.a())) == null || c2.E() < c2.Q0() || isFinishing()) {
            return;
        }
        finish();
    }

    /* loaded from: classes7.dex */
    public class a implements q {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<Activity> f39462a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f39463b;

        public a(String str) {
            this.f39463b = str;
            this.f39462a = new WeakReference<>(TTDelegateActivity.this);
        }

        @Override // d.o.a.a.a.a.q
        public void a() {
            i.a(this.f39463b);
            d.q(this.f39462a.get());
        }

        @Override // d.o.a.a.a.a.q
        public void a(String str) {
            i.c(this.f39463b, str);
            d.q(this.f39462a.get());
        }
    }

    private void c() {
        String str;
        long longExtra = this.f39459a.getLongExtra("model_id", 0L);
        String stringExtra = this.f39459a.getStringExtra("message_text");
        String stringExtra2 = this.f39459a.getStringExtra("positive_button_text");
        String stringExtra3 = this.f39459a.getStringExtra("negative_button_text");
        int intExtra = this.f39459a.getIntExtra("type", 0);
        d.o.a.b.a.c.b u = c.g.e().u(longExtra);
        d.c cVar = new d.c(this);
        cVar.c(false);
        cVar.b(stringExtra);
        cVar.e(stringExtra2);
        cVar.f(stringExtra3);
        if (intExtra == 7) {
            if (g.f.c() == null) {
                return;
            }
            cVar.a(g.f.c());
            cVar.d().show();
            str = "download_percent";
        } else if (intExtra != 8) {
            str = "";
        } else if (g.e.c() == null) {
            return;
        } else {
            cVar.a(g.e.c());
            cVar.d().show();
            str = "apk_size";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f39460b = true;
        this.f39461c = u;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", "show_dialog");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        j.c.a().t("pause_optimise", jSONObject, u);
    }

    public static void b(@NonNull d.o.a.b.a.c.a aVar) {
        a(aVar, 5, "", "", "");
    }

    public static void a(String str, d.o.a.b.a.c.a aVar) {
        Intent c2 = c(aVar);
        c2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        c2.putExtra("type", 2);
        c2.putExtra("open_url", str);
        if (n.a() != null) {
            n.a().startActivity(c2);
        }
    }

    public static void b(@NonNull d.o.a.b.a.c.a aVar, String str, String str2, String str3) {
        a(aVar, 7, str, str2, str3);
    }

    private void b() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void b(long j) {
        if (p.a() == null) {
            return;
        }
        d.o.a.b.a.c.b u = c.g.e().u(j);
        if (u != null) {
            DownloadInfo f2 = d.o.a.e.b.g.a.l(n.a()).f(u.s());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - u.O()));
                jSONObject.putOpt("click_download_size", Long.valueOf(u.P()));
                if (f2 != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(f2.E()));
                    jSONObject.putOpt("download_percent", Long.valueOf(f2.E() / f2.Q0()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(f2.Q0()));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            j.c.a().t("pause_reserve_wifi_dialog_show", jSONObject, u);
        }
        d.c cVar = new d.c(this);
        cVar.c(false);
        cVar.a(p.a());
        cVar.d().show();
        this.f39460b = true;
        this.f39461c = u;
    }

    public static void a(d.o.a.b.a.c.a aVar) {
        Intent c2 = c(aVar);
        c2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        c2.putExtra("type", 4);
        c2.putExtra("model_id", aVar.b());
        if (n.a() != null) {
            n.a().startActivity(c2);
        }
    }

    public static void a(d.o.a.b.a.c.a aVar, d.o.a.d.m.a.a aVar2) {
        Intent c2 = c(aVar);
        c2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        c2.putExtra("type", 9);
        f39458d = aVar2;
        if (n.a() != null) {
            n.a().startActivity(c2);
        }
    }

    public static void a(long j) {
        Intent intent = new Intent(n.a(), TTDelegateActivity.class);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j);
        if (n.a() != null) {
            n.a().startActivity(intent);
        }
    }

    private void c(long j) {
        d.o.a.b.a.c.b u = c.g.e().u(j);
        if (u == null) {
            k.B();
            d.o.a.e.a.d.q(this);
            return;
        }
        d.o.a.a.a.a.k n = n.n();
        c.b bVar = new c.b(this);
        bVar.e("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(u.I()) ? "刚刚下载的应用" : u.I();
        bVar.h(String.format("%1$s已安装完成，是否立即打开？", objArr));
        bVar.j("打开");
        bVar.l("取消");
        bVar.f(false);
        bVar.c(k.F(this, u.e()));
        bVar.d(new b(u));
        bVar.b(2);
        n.b(bVar.g());
        j.c.a().n("market_openapp_window_show", u);
    }

    private void b(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            a aVar = new a(str);
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    n.p().a(this, strArr, aVar);
                    return;
                } catch (Exception unused) {
                    aVar.a();
                    return;
                }
            }
            aVar.a();
            return;
        }
        d.o.a.e.a.d.q(this);
    }

    public static void a(@NonNull d.o.a.b.a.c.a aVar, String str, String str2, String str3) {
        a(aVar, 8, str, str2, str3);
    }

    public static void a(@NonNull d.o.a.b.a.c.a aVar, int i2, String str, String str2, String str3) {
        Intent c2 = c(aVar);
        c2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
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
        if (n.a() != null) {
            n.a().startActivity(c2);
        }
    }

    private void b(String str) {
        Intent M = k.M(this, str);
        if (M == null) {
            return;
        }
        try {
            try {
                M.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                M.putExtra("start_only_for_android", true);
                startActivity(M);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            d.o.a.e.a.d.q(this);
        }
    }

    public void a() {
        Intent intent = this.f39459a;
        if (intent == null) {
            return;
        }
        switch (intent.getIntExtra("type", 0)) {
            case 1:
                b(this.f39459a.getStringExtra("permission_id_key"), this.f39459a.getStringArrayExtra("permission_content_key"));
                break;
            case 2:
                a(this.f39459a.getStringExtra("open_url"));
                break;
            case 3:
            case 6:
            default:
                d.o.a.e.a.d.q(this);
                break;
            case 4:
                c(this.f39459a.getLongExtra("model_id", 0L));
                break;
            case 5:
                b(this.f39459a.getLongExtra("model_id", 0L));
                break;
            case 7:
            case 8:
                c();
                break;
            case 9:
                d.o.a.d.m.a.a aVar = f39458d;
                if (aVar != null) {
                    aVar.a();
                }
                d.o.a.e.a.d.q(this);
                break;
            case 10:
                d(this.f39459a.getLongExtra("app_info_id", 0L));
                break;
            case 11:
                b(this.f39459a.getStringExtra("package_name"));
                break;
        }
        this.f39459a = null;
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
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                if (d.o.a.e.b.j.a.r().l("fix_app_link_flag")) {
                    intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                }
                intent.putExtra("start_only_for_android", true);
                startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            d.o.a.e.a.d.q(this);
        }
    }
}
