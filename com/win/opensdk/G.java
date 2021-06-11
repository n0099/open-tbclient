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
    public final /* synthetic */ Info f40501a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WDownLoadService f40502b;

    public G(WDownLoadService wDownLoadService, Info info) {
        this.f40502b = wDownLoadService;
        this.f40501a = info;
    }

    public void a() {
        new Handler(Looper.getMainLooper()).post(new F(this));
        A.f40455d.f40458c = false;
        x0.a(this.f40502b.getApplicationContext()).a(new y0(this.f40501a), 2).a();
        Info info = this.f40501a;
        WDownLoadService wDownLoadService = this.f40502b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_failed), this.f40502b.getString(R.string.win_wdownload_failed_msg), 0);
        try {
            WDownLoadService.a(this.f40502b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f40502b.stopSelf();
    }

    public void b() {
        A.f40455d.f40458c = false;
        x0.a(this.f40502b.getApplicationContext()).a(new y0(this.f40501a), 200).a();
        Info info = this.f40501a;
        try {
            z.a(info, 301, "");
            if (info != null && !TextUtils.isEmpty(info.getVv_downf_urls())) {
                z.g(info.getVv_downf_urls());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        WDownLoadService.a(this.f40502b, this.f40501a);
        this.f40502b.stopSelf();
        w0 a2 = x0.a(this.f40502b.getApplicationContext());
        y0 y0Var = new y0(this.f40501a);
        String str = this.f40502b.f40707a;
        try {
            a2.f40837b = x0.a("witr", y0Var);
            a2.a("msg", x0.a(str));
        } catch (JSONException unused) {
        }
        a2.a();
        z.b(this.f40501a, this.f40502b.getApplicationContext(), this.f40502b.f40707a);
    }

    public void c() {
        A.f40455d.f40458c = false;
        Info info = this.f40501a;
        WDownLoadService wDownLoadService = this.f40502b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_failed), this.f40502b.getString(R.string.win_wdownload_failed_msg), 0);
        WDownLoadService.a(this.f40502b);
        this.f40502b.stopSelf();
        x0.a(this.f40502b.getApplicationContext()).a(new y0(this.f40501a), 1).a();
    }

    public void a(int i2) {
        A.f40455d.f40458c = true;
        Info info = this.f40501a;
        WDownLoadService wDownLoadService = this.f40502b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_processing), this.f40502b.getString(R.string.win_wdownload_processing), i2);
    }
}
