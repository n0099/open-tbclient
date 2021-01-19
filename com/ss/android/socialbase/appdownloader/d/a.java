package com.ss.android.socialbase.appdownloader.d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.k;
/* loaded from: classes4.dex */
public class a extends com.ss.android.socialbase.appdownloader.c.b {

    /* renamed from: a  reason: collision with root package name */
    private AlertDialog.Builder f13021a;

    public a(Context context) {
        this.f13021a = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k QA(int i) {
        if (this.f13021a != null) {
            this.f13021a.setTitle(i);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k ZI(String str) {
        if (this.f13021a != null) {
            this.f13021a.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k h(int i, DialogInterface.OnClickListener onClickListener) {
        if (this.f13021a != null) {
            this.f13021a.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k i(int i, DialogInterface.OnClickListener onClickListener) {
        if (this.f13021a != null) {
            this.f13021a.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public k h(DialogInterface.OnCancelListener onCancelListener) {
        if (this.f13021a != null) {
            this.f13021a.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.k
    public j eCH() {
        return new C1225a(this.f13021a);
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C1225a implements j {

        /* renamed from: a  reason: collision with root package name */
        private AlertDialog f13022a;

        public C1225a(AlertDialog.Builder builder) {
            if (builder != null) {
                this.f13022a = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public void a() {
            if (this.f13022a != null) {
                this.f13022a.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public boolean b() {
            if (this.f13022a != null) {
                return this.f13022a.isShowing();
            }
            return false;
        }
    }
}
