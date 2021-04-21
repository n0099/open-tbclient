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
    public final /* synthetic */ Info f40108a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WDownLoadService f40109b;

    public N(WDownLoadService wDownLoadService, Info info) {
        this.f40109b = wDownLoadService;
        this.f40108a = info;
    }

    public void a() {
        new Handler(Looper.getMainLooper()).post(new M(this));
        H.f40058d.f40061c = false;
        a1.a(this.f40109b.getApplicationContext()).a(new b1(this.f40108a), 2).a();
        Info info = this.f40108a;
        WDownLoadService wDownLoadService = this.f40109b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.wdownload_failed), this.f40109b.getString(R.string.wdownload_failed_msg), 0);
        try {
            WDownLoadService.a(this.f40109b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f40109b.stopSelf();
    }

    public void b() {
        H.f40058d.f40061c = false;
        a1.a(this.f40109b.getApplicationContext()).a(new b1(this.f40108a), 200).a();
        Info info = this.f40108a;
        try {
            G.a(info, 301, "");
            if (info != null && !TextUtils.isEmpty(info.getVv_downf_urls())) {
                G.i(info.getVv_downf_urls());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        WDownLoadService.a(this.f40109b, this.f40108a);
        this.f40109b.stopSelf();
        Z0 a2 = a1.a(this.f40109b.getApplicationContext());
        b1 b1Var = new b1(this.f40108a);
        String str = this.f40109b.f40305a;
        try {
            a2.f40234b = a1.a("witr", b1Var);
            a2.a("msg", a1.a(str));
        } catch (JSONException unused) {
        }
        a2.a();
        G.b(this.f40108a, this.f40109b.getApplicationContext(), this.f40109b.f40305a);
    }

    public void c() {
        H.f40058d.f40061c = false;
        Info info = this.f40108a;
        WDownLoadService wDownLoadService = this.f40109b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.wdownload_failed), this.f40109b.getString(R.string.wdownload_failed_msg), 0);
        WDownLoadService.a(this.f40109b);
        this.f40109b.stopSelf();
        a1.a(this.f40109b.getApplicationContext()).a(new b1(this.f40108a), 1).a();
    }

    public void a(int i) {
        H.f40058d.f40061c = true;
        Info info = this.f40108a;
        WDownLoadService wDownLoadService = this.f40109b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.wdownload_processing), this.f40109b.getString(R.string.wdownload_processing), i);
    }
}
