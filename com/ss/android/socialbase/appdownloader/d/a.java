package com.ss.android.socialbase.appdownloader.d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.k;
/* loaded from: classes6.dex */
public class a extends com.ss.android.socialbase.appdownloader.c.b {

    /* renamed from: a  reason: collision with root package name */
    private AlertDialog.Builder f13023a;

    public a(Context context) {
        this.f13023a = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k QW(int i) {
        if (this.f13023a != null) {
            this.f13023a.setTitle(i);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k aaV(String str) {
        if (this.f13023a != null) {
            this.f13023a.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k h(int i, DialogInterface.OnClickListener onClickListener) {
        if (this.f13023a != null) {
            this.f13023a.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k i(int i, DialogInterface.OnClickListener onClickListener) {
        if (this.f13023a != null) {
            this.f13023a.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k h(DialogInterface.OnCancelListener onCancelListener) {
        if (this.f13023a != null) {
            this.f13023a.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public j eFg() {
        return new C1231a(this.f13023a);
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C1231a implements j {

        /* renamed from: a  reason: collision with root package name */
        private AlertDialog f13024a;

        public C1231a(AlertDialog.Builder builder) {
            if (builder != null) {
                this.f13024a = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public void a() {
            if (this.f13024a != null) {
                this.f13024a.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public boolean b() {
            if (this.f13024a != null) {
                return this.f13024a.isShowing();
            }
            return false;
        }
    }
}
