package com.ss.android.socialbase.appdownloader.d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.k;
/* loaded from: classes4.dex */
public class a extends com.ss.android.socialbase.appdownloader.c.b {

    /* renamed from: a  reason: collision with root package name */
    private AlertDialog.Builder f13320a;

    public a(Context context) {
        this.f13320a = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k RR(int i) {
        if (this.f13320a != null) {
            this.f13320a.setTitle(i);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k aaO(String str) {
        if (this.f13320a != null) {
            this.f13320a.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k h(int i, DialogInterface.OnClickListener onClickListener) {
        if (this.f13320a != null) {
            this.f13320a.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k i(int i, DialogInterface.OnClickListener onClickListener) {
        if (this.f13320a != null) {
            this.f13320a.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k h(DialogInterface.OnCancelListener onCancelListener) {
        if (this.f13320a != null) {
            this.f13320a.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public j eFU() {
        return new C1201a(this.f13320a);
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C1201a implements j {

        /* renamed from: a  reason: collision with root package name */
        private AlertDialog f13321a;

        public C1201a(AlertDialog.Builder builder) {
            if (builder != null) {
                this.f13321a = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public void a() {
            if (this.f13321a != null) {
                this.f13321a.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public boolean b() {
            if (this.f13321a != null) {
                return this.f13321a.isShowing();
            }
            return false;
        }
    }
}
