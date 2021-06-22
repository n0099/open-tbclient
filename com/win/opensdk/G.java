package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class G {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f40604a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WDownLoadService f40605b;

    public G(WDownLoadService wDownLoadService, Info info) {
        this.f40605b = wDownLoadService;
        this.f40604a = info;
    }

    public void a() {
        new Handler(Looper.getMainLooper()).post(new F(this));
        A.f40558d.f40561c = false;
        x0.a(this.f40605b.getApplicationContext()).a(new y0(this.f40604a), 2).a();
        Info info = this.f40604a;
        WDownLoadService wDownLoadService = this.f40605b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_failed), this.f40605b.getString(R.string.win_wdownload_failed_msg), 0);
        try {
            WDownLoadService.a(this.f40605b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f40605b.stopSelf();
    }

    public void b() {
        A.f40558d.f40561c = false;
        x0.a(this.f40605b.getApplicationContext()).a(new y0(this.f40604a), 200).a();
        Info info = this.f40604a;
        try {
            z.a(info, 301, "");
            if (info != null && !TextUtils.isEmpty(info.getVv_downf_urls())) {
                z.g(info.getVv_downf_urls());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        WDownLoadService.a(this.f40605b, this.f40604a);
        this.f40605b.stopSelf();
        w0 a2 = x0.a(this.f40605b.getApplicationContext());
        y0 y0Var = new y0(this.f40604a);
        String str = this.f40605b.f40810a;
        try {
            a2.f40940b = x0.a("witr", y0Var);
            a2.a("msg", x0.a(str));
        } catch (JSONException unused) {
        }
        a2.a();
        z.b(this.f40604a, this.f40605b.getApplicationContext(), this.f40605b.f40810a);
    }

    public void c() {
        A.f40558d.f40561c = false;
        Info info = this.f40604a;
        WDownLoadService wDownLoadService = this.f40605b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_failed), this.f40605b.getString(R.string.win_wdownload_failed_msg), 0);
        WDownLoadService.a(this.f40605b);
        this.f40605b.stopSelf();
        x0.a(this.f40605b.getApplicationContext()).a(new y0(this.f40604a), 1).a();
    }

    public void a(int i2) {
        A.f40558d.f40561c = true;
        Info info = this.f40604a;
        WDownLoadService wDownLoadService = this.f40605b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_processing), this.f40605b.getString(R.string.win_wdownload_processing), i2);
    }
}
