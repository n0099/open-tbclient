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
    public final /* synthetic */ Info f36822a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WDownLoadService f36823b;

    public G(WDownLoadService wDownLoadService, Info info) {
        this.f36823b = wDownLoadService;
        this.f36822a = info;
    }

    public void a() {
        new Handler(Looper.getMainLooper()).post(new F(this));
        A.f36776d.f36779c = false;
        x0.a(this.f36823b.getApplicationContext()).a(new y0(this.f36822a), 2).a();
        Info info = this.f36822a;
        WDownLoadService wDownLoadService = this.f36823b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_failed), this.f36823b.getString(R.string.win_wdownload_failed_msg), 0);
        try {
            WDownLoadService.a(this.f36823b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f36823b.stopSelf();
    }

    public void b() {
        A.f36776d.f36779c = false;
        x0.a(this.f36823b.getApplicationContext()).a(new y0(this.f36822a), 200).a();
        Info info = this.f36822a;
        try {
            z.a(info, 301, "");
            if (info != null && !TextUtils.isEmpty(info.getVv_downf_urls())) {
                z.g(info.getVv_downf_urls());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        WDownLoadService.a(this.f36823b, this.f36822a);
        this.f36823b.stopSelf();
        w0 a2 = x0.a(this.f36823b.getApplicationContext());
        y0 y0Var = new y0(this.f36822a);
        String str = this.f36823b.f37028a;
        try {
            a2.f37158b = x0.a("witr", y0Var);
            a2.a("msg", x0.a(str));
        } catch (JSONException unused) {
        }
        a2.a();
        z.b(this.f36822a, this.f36823b.getApplicationContext(), this.f36823b.f37028a);
    }

    public void c() {
        A.f36776d.f36779c = false;
        Info info = this.f36822a;
        WDownLoadService wDownLoadService = this.f36823b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_failed), this.f36823b.getString(R.string.win_wdownload_failed_msg), 0);
        WDownLoadService.a(this.f36823b);
        this.f36823b.stopSelf();
        x0.a(this.f36823b.getApplicationContext()).a(new y0(this.f36822a), 1).a();
    }

    public void a(int i2) {
        A.f36776d.f36779c = true;
        Info info = this.f36822a;
        WDownLoadService wDownLoadService = this.f36823b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_processing), this.f36823b.getString(R.string.win_wdownload_processing), i2);
    }
}
