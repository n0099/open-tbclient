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
    public final /* synthetic */ Info f39723a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WDownLoadService f39724b;

    public N(WDownLoadService wDownLoadService, Info info) {
        this.f39724b = wDownLoadService;
        this.f39723a = info;
    }

    public void a() {
        new Handler(Looper.getMainLooper()).post(new M(this));
        H.f39673d.f39676c = false;
        a1.a(this.f39724b.getApplicationContext()).a(new b1(this.f39723a), 2).a();
        Info info = this.f39723a;
        WDownLoadService wDownLoadService = this.f39724b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.wdownload_failed), this.f39724b.getString(R.string.wdownload_failed_msg), 0);
        try {
            WDownLoadService.a(this.f39724b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f39724b.stopSelf();
    }

    public void b() {
        H.f39673d.f39676c = false;
        a1.a(this.f39724b.getApplicationContext()).a(new b1(this.f39723a), 200).a();
        Info info = this.f39723a;
        try {
            G.a(info, 301, "");
            if (info != null && !TextUtils.isEmpty(info.getVv_downf_urls())) {
                G.i(info.getVv_downf_urls());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        WDownLoadService.a(this.f39724b, this.f39723a);
        this.f39724b.stopSelf();
        Z0 a2 = a1.a(this.f39724b.getApplicationContext());
        b1 b1Var = new b1(this.f39723a);
        String str = this.f39724b.f39920a;
        try {
            a2.f39849b = a1.a("witr", b1Var);
            a2.a("msg", a1.a(str));
        } catch (JSONException unused) {
        }
        a2.a();
        G.b(this.f39723a, this.f39724b.getApplicationContext(), this.f39724b.f39920a);
    }

    public void c() {
        H.f39673d.f39676c = false;
        Info info = this.f39723a;
        WDownLoadService wDownLoadService = this.f39724b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.wdownload_failed), this.f39724b.getString(R.string.wdownload_failed_msg), 0);
        WDownLoadService.a(this.f39724b);
        this.f39724b.stopSelf();
        a1.a(this.f39724b.getApplicationContext()).a(new b1(this.f39723a), 1).a();
    }

    public void a(int i) {
        H.f39673d.f39676c = true;
        Info info = this.f39723a;
        WDownLoadService wDownLoadService = this.f39724b;
        wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.wdownload_processing), this.f39724b.getString(R.string.wdownload_processing), i);
    }
}
