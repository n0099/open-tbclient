package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.win.opensdk.bd;
import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
import org.json.JSONException;
/* loaded from: classes14.dex */
public class ao {
    public final /* synthetic */ WDownLoadService qkN;
    public final /* synthetic */ Info qkd;

    public ao(WDownLoadService wDownLoadService, Info info) {
        this.qkN = wDownLoadService;
        this.qkd = info;
    }

    public void a() {
        new Handler(Looper.getMainLooper()).post(new al(this));
        z.qkE.c = false;
        ca.iT(this.qkN.getApplicationContext()).b(new cd(this.qkd), 2).a();
        Info info = this.qkd;
        if (info != null) {
            this.qkN.a(info, info.getDl_name(), this.qkN.getString(bd.e.wdownload_failed_msg), 0);
        } else {
            WDownLoadService wDownLoadService = this.qkN;
            wDownLoadService.a(info, wDownLoadService.getString(bd.e.wdownload_failed), this.qkN.getString(bd.e.wdownload_failed_msg), 0);
        }
        try {
            WDownLoadService.a(this.qkN);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.qkN.stopSelf();
    }

    public void b() {
        z.qkE.c = false;
        ca.iT(this.qkN.getApplicationContext()).b(new cd(this.qkd), 200).a();
        Info info = this.qkd;
        try {
            v.a(info, 301, "");
            if (info != null && !TextUtils.isEmpty(info.getVv_downf_urls())) {
                v.i(info.getVv_downf_urls());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        WDownLoadService.a(this.qkN, this.qkd);
        this.qkN.stopSelf();
        bx iT = ca.iT(this.qkN.getApplicationContext());
        cd cdVar = new cd(this.qkd);
        String str = this.qkN.f8155a;
        try {
            iT.qlo = ca.a("witr", cdVar);
            iT.hD("msg", ca.a(str));
        } catch (JSONException e2) {
        }
        iT.a();
        v.a(this.qkd, this.qkN.getApplicationContext(), this.qkN.f8155a);
    }

    public void c() {
        z.qkE.c = false;
        Info info = this.qkd;
        if (info != null) {
            this.qkN.a(info, info.getDl_name(), this.qkN.getString(bd.e.wdownload_failed_msg), 0);
        } else {
            WDownLoadService wDownLoadService = this.qkN;
            wDownLoadService.a(info, wDownLoadService.getString(bd.e.wdownload_failed), this.qkN.getString(bd.e.wdownload_failed_msg), 0);
        }
        WDownLoadService.a(this.qkN);
        this.qkN.stopSelf();
        ca.iT(this.qkN.getApplicationContext()).b(new cd(this.qkd), 1).a();
    }

    public void a(int i) {
        z.qkE.c = true;
        Info info = this.qkd;
        if (info != null) {
            this.qkN.a(info, info.getDl_name(), this.qkN.getString(bd.e.wdownload_processing), i);
            return;
        }
        WDownLoadService wDownLoadService = this.qkN;
        wDownLoadService.a(info, wDownLoadService.getString(bd.e.wdownload_processing), this.qkN.getString(bd.e.wdownload_processing), i);
    }
}
