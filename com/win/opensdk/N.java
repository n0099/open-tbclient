package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class N {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f40013a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WDownLoadService f40014b;

    public N(WDownLoadService wDownLoadService, Info info) {
        this.f40014b = wDownLoadService;
        this.f40013a = info;
    }

    public void a() {
        new Handler(Looper.getMainLooper()).post(new M(this));
        H.f39963d.f39966c = false;
        a1.a(this.f40014b.getApplicationContext()).a(new b1(this.f40013a), 2).a();
        Info info = this.f40013a;
        WDownLoadService wDownLoadService = this.f40014b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.wdownload_failed), this.f40014b.getString(R.string.wdownload_failed_msg), 0);
        try {
            WDownLoadService.a(this.f40014b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f40014b.stopSelf();
    }

    public void b() {
        H.f39963d.f39966c = false;
        a1.a(this.f40014b.getApplicationContext()).a(new b1(this.f40013a), 200).a();
        Info info = this.f40013a;
        try {
            G.a(info, 301, "");
            if (info != null && !TextUtils.isEmpty(info.getVv_downf_urls())) {
                G.i(info.getVv_downf_urls());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        WDownLoadService.a(this.f40014b, this.f40013a);
        this.f40014b.stopSelf();
        Z0 a2 = a1.a(this.f40014b.getApplicationContext());
        b1 b1Var = new b1(this.f40013a);
        String str = this.f40014b.f40210a;
        try {
            a2.f40139b = a1.a("witr", b1Var);
            a2.a("msg", a1.a(str));
        } catch (JSONException unused) {
        }
        a2.a();
        G.b(this.f40013a, this.f40014b.getApplicationContext(), this.f40014b.f40210a);
    }

    public void c() {
        H.f39963d.f39966c = false;
        Info info = this.f40013a;
        WDownLoadService wDownLoadService = this.f40014b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.wdownload_failed), this.f40014b.getString(R.string.wdownload_failed_msg), 0);
        WDownLoadService.a(this.f40014b);
        this.f40014b.stopSelf();
        a1.a(this.f40014b.getApplicationContext()).a(new b1(this.f40013a), 1).a();
    }

    public void a(int i) {
        H.f39963d.f39966c = true;
        Info info = this.f40013a;
        WDownLoadService wDownLoadService = this.f40014b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.wdownload_processing), this.f40014b.getString(R.string.wdownload_processing), i);
    }
}
