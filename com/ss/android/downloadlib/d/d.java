package com.ss.android.downloadlib.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.a.a.d.c;
import com.ss.android.downloadlib.f.h;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.k;
/* loaded from: classes4.dex */
public class d extends com.ss.android.socialbase.appdownloader.c.a {

    /* renamed from: a  reason: collision with root package name */
    private static String f13278a = d.class.getSimpleName();

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public boolean a() {
        return true;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public k iy(final Context context) {
        return new k() { // from class: com.ss.android.downloadlib.d.d.1
            private c.a pVf;
            private DialogInterface.OnClickListener pVg;
            private DialogInterface.OnClickListener pVh;
            private DialogInterface.OnCancelListener pVi;

            {
                this.pVf = new c.a(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k RR(int i) {
                this.pVf.aak(context.getResources().getString(i));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k aaO(String str) {
                this.pVf.aal(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k h(int i, DialogInterface.OnClickListener onClickListener) {
                this.pVf.aam(context.getResources().getString(i));
                this.pVg = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k i(int i, DialogInterface.OnClickListener onClickListener) {
                this.pVf.aan(context.getResources().getString(i));
                this.pVh = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k h(DialogInterface.OnCancelListener onCancelListener) {
                this.pVi = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k BI(boolean z) {
                this.pVf.Bt(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public j eFU() {
                this.pVf.a(new c.b() { // from class: com.ss.android.downloadlib.d.d.1.1
                    @Override // com.ss.android.a.a.d.c.b
                    public void a(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.pVg != null) {
                            AnonymousClass1.this.pVg.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.a.a.d.c.b
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.pVh != null) {
                            AnonymousClass1.this.pVh.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.a.a.d.c.b
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.pVi != null && dialogInterface != null) {
                            AnonymousClass1.this.pVi.onCancel(dialogInterface);
                        }
                    }
                });
                h.i(d.f13278a, "getThemedAlertDlgBuilder", null);
                this.pVf.RH(3);
                return new a(com.ss.android.downloadlib.a.j.eFB().b(this.pVf.eEY()));
            }
        };
    }

    /* loaded from: classes4.dex */
    private static class a implements j {

        /* renamed from: a  reason: collision with root package name */
        private Dialog f13280a;

        public a(Dialog dialog) {
            if (dialog != null) {
                this.f13280a = dialog;
                a();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public void a() {
            if (this.f13280a != null) {
                this.f13280a.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public boolean b() {
            if (this.f13280a != null) {
                return this.f13280a.isShowing();
            }
            return false;
        }
    }
}
