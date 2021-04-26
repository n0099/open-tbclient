package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class G {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f37648a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WDownLoadService f37649b;

    public G(WDownLoadService wDownLoadService, Info info) {
        this.f37649b = wDownLoadService;
        this.f37648a = info;
    }

    public void a() {
        new Handler(Looper.getMainLooper()).post(new F(this));
        A.f37602d.f37605c = false;
        x0.a(this.f37649b.getApplicationContext()).a(new y0(this.f37648a), 2).a();
        Info info = this.f37648a;
        WDownLoadService wDownLoadService = this.f37649b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_failed), this.f37649b.getString(R.string.win_wdownload_failed_msg), 0);
        try {
            WDownLoadService.a(this.f37649b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f37649b.stopSelf();
    }

    public void b() {
        A.f37602d.f37605c = false;
        x0.a(this.f37649b.getApplicationContext()).a(new y0(this.f37648a), 200).a();
        Info info = this.f37648a;
        try {
            z.a(info, 301, "");
            if (info != null && !TextUtils.isEmpty(info.getVv_downf_urls())) {
                z.g(info.getVv_downf_urls());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        WDownLoadService.a(this.f37649b, this.f37648a);
        this.f37649b.stopSelf();
        w0 a2 = x0.a(this.f37649b.getApplicationContext());
        y0 y0Var = new y0(this.f37648a);
        String str = this.f37649b.f37854a;
        try {
            a2.f37984b = x0.a("witr", y0Var);
            a2.a("msg", x0.a(str));
        } catch (JSONException unused) {
        }
        a2.a();
        z.b(this.f37648a, this.f37649b.getApplicationContext(), this.f37649b.f37854a);
    }

    public void c() {
        A.f37602d.f37605c = false;
        Info info = this.f37648a;
        WDownLoadService wDownLoadService = this.f37649b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_failed), this.f37649b.getString(R.string.win_wdownload_failed_msg), 0);
        WDownLoadService.a(this.f37649b);
        this.f37649b.stopSelf();
        x0.a(this.f37649b.getApplicationContext()).a(new y0(this.f37648a), 1).a();
    }

    public void a(int i2) {
        A.f37602d.f37605c = true;
        Info info = this.f37648a;
        WDownLoadService wDownLoadService = this.f37649b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_processing), this.f37649b.getString(R.string.win_wdownload_processing), i2);
    }
}
