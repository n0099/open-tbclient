package com.ss.android.downloadlib.a.a;

import android.app.Activity;
import android.app.Dialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.a;
/* loaded from: classes6.dex */
public class e extends Dialog implements c {

    /* renamed from: a  reason: collision with root package name */
    private View f12927a;

    /* renamed from: b  reason: collision with root package name */
    private View f12928b;
    private boolean e;
    private Activity f;
    private d qbt;
    private c qbu;

    public e(@NonNull Activity activity, @NonNull d dVar) {
        this(activity, dVar, null);
    }

    public e(@NonNull Activity activity, @NonNull d dVar, c cVar) {
        super(activity, a.d.ttdownloader_translucent_dialog);
        this.f = activity;
        this.qbt = dVar;
        this.qbu = cVar;
        setCancelable(false);
        d();
    }

    private void d() {
        setContentView(LayoutInflater.from(this.f.getApplicationContext()).inflate(a(), (ViewGroup) null));
        this.f12927a = findViewById(b());
        this.f12928b = findViewById(c());
        this.f12927a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.a.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.e();
            }
        });
        this.f12928b.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.a.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.f();
            }
        });
    }

    @Override // com.ss.android.downloadlib.a.a.c
    public int a() {
        return this.qbu != null ? this.qbu.a() : a.c.ttdownloader_dialog_reserve_wifi;
    }

    @Override // com.ss.android.downloadlib.a.a.c
    public int b() {
        return this.qbu != null ? this.qbu.b() : a.b.confirm_tv;
    }

    @Override // com.ss.android.downloadlib.a.a.c
    public int c() {
        return this.qbu != null ? this.qbu.c() : a.b.cancel_tv;
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
            this.qbt.a();
        } else {
            this.qbt.b();
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
