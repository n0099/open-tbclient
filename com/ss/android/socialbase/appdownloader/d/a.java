package com.ss.android.socialbase.appdownloader.d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.k;
/* loaded from: classes6.dex */
public class a extends com.ss.android.socialbase.appdownloader.c.b {
    private AlertDialog.Builder qeK;

    public a(Context context) {
        this.qeK = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k Ra(int i) {
        if (this.qeK != null) {
            this.qeK.setTitle(i);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k aba(String str) {
        if (this.qeK != null) {
            this.qeK.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k h(int i, DialogInterface.OnClickListener onClickListener) {
        if (this.qeK != null) {
            this.qeK.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k i(int i, DialogInterface.OnClickListener onClickListener) {
        if (this.qeK != null) {
            this.qeK.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k h(DialogInterface.OnCancelListener onCancelListener) {
        if (this.qeK != null) {
            this.qeK.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public j eFk() {
        return new C1221a(this.qeK);
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C1221a implements j {

        /* renamed from: a  reason: collision with root package name */
        private AlertDialog f7751a;

        public C1221a(AlertDialog.Builder builder) {
            if (builder != null) {
                this.f7751a = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public void a() {
            if (this.f7751a != null) {
                this.f7751a.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public boolean b() {
            if (this.f7751a != null) {
                return this.f7751a.isShowing();
            }
            return false;
        }
    }
}
