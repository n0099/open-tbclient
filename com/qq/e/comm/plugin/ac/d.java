package com.qq.e.comm.plugin.ac;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.live.tbadk.pay.PayHelper;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.plugin.util.w;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f12142a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12143b;
    private final com.qq.e.comm.plugin.c.a.b c;
    private AlertDialog d;

    public d(Activity activity, int i, com.qq.e.comm.plugin.c.a.b bVar) {
        this.f12142a = activity;
        this.f12143b = i;
        this.c = bVar;
        c();
    }

    private void c() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f12142a, Build.VERSION.SDK_INT >= 21 ? 16974394 : 0);
        builder.setTitle("温馨提示").setMessage(d()).setPositiveButton("确认", new DialogInterface.OnClickListener() { // from class: com.qq.e.comm.plugin.ac.d.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (d.this.c != null) {
                    d.this.c.b();
                }
            }
        }).setNegativeButton(PayHelper.STATUS_CANCEL_DESC, new DialogInterface.OnClickListener() { // from class: com.qq.e.comm.plugin.ac.d.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (d.this.c != null) {
                    d.this.c.a();
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.qq.e.comm.plugin.ac.d.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (d.this.c != null) {
                    d.this.c.a();
                }
            }
        });
        this.d = builder.create();
    }

    private String d() {
        if (com.qq.e.comm.plugin.a.d.d.c(this.f12143b)) {
            return "开始安装应用?";
        }
        NetworkType networkType = GDTADManager.getInstance().getDeviceStatus().getNetworkType();
        return networkType == NetworkType.WIFI ? "当前为wifi网络，开始下载应用？" : networkType == NetworkType.NET_2G ? "当前为2G网络，开始下载应用？" : networkType == NetworkType.NET_3G ? "当前为3G网络，开始下载应用？" : networkType == NetworkType.NET_4G ? "当前为4G网络，开始下载应用？" : "当前为非wifi网络，开始下载应用？";
    }

    public void a() {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.ac.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.b();
                if (d.this.d != null) {
                    d.this.d.show();
                }
            }
        });
    }

    public void b() {
        if (this.d == null || !this.d.isShowing()) {
            return;
        }
        this.d.dismiss();
    }
}
