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
    public final /* synthetic */ Info f36893a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WDownLoadService f36894b;

    public G(WDownLoadService wDownLoadService, Info info) {
        this.f36894b = wDownLoadService;
        this.f36893a = info;
    }

    public void a() {
        new Handler(Looper.getMainLooper()).post(new F(this));
        A.f36847d.f36850c = false;
        x0.a(this.f36894b.getApplicationContext()).a(new y0(this.f36893a), 2).a();
        Info info = this.f36893a;
        WDownLoadService wDownLoadService = this.f36894b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_failed), this.f36894b.getString(R.string.win_wdownload_failed_msg), 0);
        try {
            WDownLoadService.a(this.f36894b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f36894b.stopSelf();
    }

    public void b() {
        A.f36847d.f36850c = false;
        x0.a(this.f36894b.getApplicationContext()).a(new y0(this.f36893a), 200).a();
        Info info = this.f36893a;
        try {
            z.a(info, 301, "");
            if (info != null && !TextUtils.isEmpty(info.getVv_downf_urls())) {
                z.g(info.getVv_downf_urls());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        WDownLoadService.a(this.f36894b, this.f36893a);
        this.f36894b.stopSelf();
        w0 a2 = x0.a(this.f36894b.getApplicationContext());
        y0 y0Var = new y0(this.f36893a);
        String str = this.f36894b.f37099a;
        try {
            a2.f37229b = x0.a("witr", y0Var);
            a2.a("msg", x0.a(str));
        } catch (JSONException unused) {
        }
        a2.a();
        z.b(this.f36893a, this.f36894b.getApplicationContext(), this.f36894b.f37099a);
    }

    public void c() {
        A.f36847d.f36850c = false;
        Info info = this.f36893a;
        WDownLoadService wDownLoadService = this.f36894b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_failed), this.f36894b.getString(R.string.win_wdownload_failed_msg), 0);
        WDownLoadService.a(this.f36894b);
        this.f36894b.stopSelf();
        x0.a(this.f36894b.getApplicationContext()).a(new y0(this.f36893a), 1).a();
    }

    public void a(int i2) {
        A.f36847d.f36850c = true;
        Info info = this.f36893a;
        WDownLoadService wDownLoadService = this.f36894b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_processing), this.f36894b.getString(R.string.win_wdownload_processing), i2);
    }
}
