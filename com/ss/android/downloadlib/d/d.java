package com.ss.android.downloadlib.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.a.a.d.c;
import com.ss.android.downloadlib.f.h;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.k;
/* loaded from: classes6.dex */
public class d extends com.ss.android.socialbase.appdownloader.c.a {

    /* renamed from: a  reason: collision with root package name */
    private static String f12981a = d.class.getSimpleName();

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public boolean a() {
        return true;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public k iz(final Context context) {
        return new k() { // from class: com.ss.android.downloadlib.d.d.1
            private c.a qcr;
            private DialogInterface.OnClickListener qcs;
            private DialogInterface.OnClickListener qct;
            private DialogInterface.OnCancelListener qcu;

            {
                this.qcr = new c.a(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k QV(int i) {
                this.qcr.aaf(context.getResources().getString(i));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k aaJ(String str) {
                this.qcr.aag(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k h(int i, DialogInterface.OnClickListener onClickListener) {
                this.qcr.aah(context.getResources().getString(i));
                this.qcs = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k i(int i, DialogInterface.OnClickListener onClickListener) {
                this.qcr.aai(context.getResources().getString(i));
                this.qct = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k h(DialogInterface.OnCancelListener onCancelListener) {
                this.qcu = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k BY(boolean z) {
                this.qcr.BJ(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public j eEY() {
                this.qcr.a(new c.b() { // from class: com.ss.android.downloadlib.d.d.1.1
                    @Override // com.ss.android.a.a.d.c.b
                    public void a(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.qcs != null) {
                            AnonymousClass1.this.qcs.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.a.a.d.c.b
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.qct != null) {
                            AnonymousClass1.this.qct.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.a.a.d.c.b
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.qcu != null && dialogInterface != null) {
                            AnonymousClass1.this.qcu.onCancel(dialogInterface);
                        }
                    }
                });
                h.i(d.f12981a, "getThemedAlertDlgBuilder", null);
                this.qcr.QL(3);
                return new a(com.ss.android.downloadlib.a.j.eEF().b(this.qcr.eEc()));
            }
        };
    }

    /* loaded from: classes6.dex */
    private static class a implements j {

        /* renamed from: a  reason: collision with root package name */
        private Dialog f12983a;

        public a(Dialog dialog) {
            if (dialog != null) {
                this.f12983a = dialog;
                a();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public void a() {
            if (this.f12983a != null) {
                this.f12983a.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public boolean b() {
            if (this.f12983a != null) {
                return this.f12983a.isShowing();
            }
            return false;
        }
    }
}
