package com.qq.e.comm.plugin.ac;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.live.tbadk.pay.PayHelper;
import com.qq.e.comm.plugin.util.w;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Activity f12134a;

    /* renamed from: b  reason: collision with root package name */
    private String f12135b;
    private com.qq.e.comm.plugin.c.a.b c;
    private AlertDialog d;

    public c(Activity activity, String str, com.qq.e.comm.plugin.c.a.b bVar) {
        this.f12134a = activity;
        this.f12135b = str;
        this.c = bVar;
        c();
    }

    private void c() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f12134a, Build.VERSION.SDK_INT >= 21 ? 16974394 : 0);
        builder.setMessage(String.format("前往“%s”了解更多", this.f12135b == null ? "APP" : this.f12135b)).setCancelable(false).setPositiveButton("前往", new DialogInterface.OnClickListener() { // from class: com.qq.e.comm.plugin.ac.c.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                c.this.d.setOnDismissListener(null);
                c.this.c.b();
            }
        }).setNegativeButton(PayHelper.STATUS_CANCEL_DESC, new DialogInterface.OnClickListener() { // from class: com.qq.e.comm.plugin.ac.c.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                c.this.d.setOnDismissListener(null);
                c.this.c.a();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.qq.e.comm.plugin.ac.c.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                c.this.c.a();
            }
        });
        this.d = builder.create();
        this.d.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qq.e.comm.plugin.ac.c.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                c.this.c.c();
            }
        });
    }

    public void a() {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.ac.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.b();
                if (c.this.d == null || c.this.f12134a.isFinishing()) {
                    return;
                }
                c.this.d.show();
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
