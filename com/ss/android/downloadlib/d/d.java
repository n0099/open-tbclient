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
            private c.a qcR;
            private DialogInterface.OnClickListener qcS;
            private DialogInterface.OnClickListener qcT;
            private DialogInterface.OnCancelListener qcU;

            {
                this.qcR = new c.a(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k QW(int i) {
                this.qcR.aar(context.getResources().getString(i));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k aaV(String str) {
                this.qcR.aas(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k h(int i, DialogInterface.OnClickListener onClickListener) {
                this.qcR.aat(context.getResources().getString(i));
                this.qcS = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k i(int i, DialogInterface.OnClickListener onClickListener) {
                this.qcR.aau(context.getResources().getString(i));
                this.qcT = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k h(DialogInterface.OnCancelListener onCancelListener) {
                this.qcU = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k BY(boolean z) {
                this.qcR.BJ(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public j eFg() {
                this.qcR.a(new c.b() { // from class: com.ss.android.downloadlib.d.d.1.1
                    @Override // com.ss.android.a.a.d.c.b
                    public void a(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.qcS != null) {
                            AnonymousClass1.this.qcS.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.a.a.d.c.b
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.qcT != null) {
                            AnonymousClass1.this.qcT.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.a.a.d.c.b
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.qcU != null && dialogInterface != null) {
                            AnonymousClass1.this.qcU.onCancel(dialogInterface);
                        }
                    }
                });
                h.i(d.f12981a, "getThemedAlertDlgBuilder", null);
                this.qcR.QM(3);
                return new a(com.ss.android.downloadlib.a.j.eEN().b(this.qcR.eEk()));
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
