package com.ss.android.downloadlib.a.a;

import android.app.Activity;
import android.app.Dialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.a;
/* loaded from: classes4.dex */
public class e extends Dialog implements c {

    /* renamed from: a  reason: collision with root package name */
    private View f13225a;

    /* renamed from: b  reason: collision with root package name */
    private View f13226b;
    private boolean e;
    private Activity f;
    private d pVp;
    private c pVq;

    public e(@NonNull Activity activity, @NonNull d dVar) {
        this(activity, dVar, null);
    }

    public e(@NonNull Activity activity, @NonNull d dVar, c cVar) {
        super(activity, a.d.ttdownloader_translucent_dialog);
        this.f = activity;
        this.pVp = dVar;
        this.pVq = cVar;
        setCancelable(false);
        d();
    }

    private void d() {
        setContentView(LayoutInflater.from(this.f.getApplicationContext()).inflate(a(), (ViewGroup) null));
        this.f13225a = findViewById(b());
        this.f13226b = findViewById(c());
        this.f13225a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.a.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.e();
            }
        });
        this.f13226b.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.a.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.f();
            }
        });
    }

    @Override // com.ss.android.downloadlib.a.a.c
    public int a() {
        return this.pVq != null ? this.pVq.a() : a.c.ttdownloader_dialog_reserve_wifi;
    }

    @Override // com.ss.android.downloadlib.a.a.c
    public int b() {
        return this.pVq != null ? this.pVq.b() : a.b.confirm_tv;
    }

    @Override // com.ss.android.downloadlib.a.a.c
    public int c() {
        return this.pVq != null ? this.pVq.c() : a.b.cancel_tv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.e = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.f.isFinishing()) {
            this.f.finish();
        }
        if (this.e) {
            this.pVp.a();
        } else {
            this.pVp.b();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
