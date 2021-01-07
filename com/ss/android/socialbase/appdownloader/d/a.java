package com.ss.android.socialbase.appdownloader.d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.k;
/* loaded from: classes4.dex */
public class a extends com.ss.android.socialbase.appdownloader.c.b {

    /* renamed from: a  reason: collision with root package name */
    private AlertDialog.Builder f13321a;

    public a(Context context) {
        this.f13321a = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k Sh(int i) {
        if (this.f13321a != null) {
            this.f13321a.setTitle(i);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k aaP(String str) {
        if (this.f13321a != null) {
            this.f13321a.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k h(int i, DialogInterface.OnClickListener onClickListener) {
        if (this.f13321a != null) {
            this.f13321a.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k i(int i, DialogInterface.OnClickListener onClickListener) {
        if (this.f13321a != null) {
            this.f13321a.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k h(DialogInterface.OnCancelListener onCancelListener) {
        if (this.f13321a != null) {
            this.f13321a.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public j eGy() {
        return new C1242a(this.f13321a);
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C1242a implements j {

        /* renamed from: a  reason: collision with root package name */
        private AlertDialog f13322a;

        public C1242a(AlertDialog.Builder builder) {
            if (builder != null) {
                this.f13322a = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public void a() {
            if (this.f13322a != null) {
                this.f13322a.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public boolean b() {
            if (this.f13322a != null) {
                return this.f13322a.isShowing();
            }
            return false;
        }
    }
}
