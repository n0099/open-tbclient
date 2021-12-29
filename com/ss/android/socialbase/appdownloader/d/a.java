package com.ss.android.socialbase.appdownloader.d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;
/* loaded from: classes3.dex */
public class a extends com.ss.android.socialbase.appdownloader.c.b {
    public AlertDialog.Builder a;

    /* renamed from: com.ss.android.socialbase.appdownloader.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2178a implements k {
        public AlertDialog a;

        public C2178a(AlertDialog.Builder builder) {
            if (builder != null) {
                this.a = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public void a() {
            AlertDialog alertDialog = this.a;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public boolean b() {
            AlertDialog alertDialog = this.a;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
    }

    public a(Context context) {
        this.a = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(int i2) {
        AlertDialog.Builder builder = this.a;
        if (builder != null) {
            builder.setTitle(i2);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l b(int i2, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.a;
        if (builder != null) {
            builder.setNegativeButton(i2, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(String str) {
        AlertDialog.Builder builder = this.a;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(int i2, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.a;
        if (builder != null) {
            builder.setPositiveButton(i2, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.a;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public k a() {
        return new C2178a(this.a);
    }
}
