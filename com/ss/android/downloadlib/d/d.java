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
    private static String f13279a = d.class.getSimpleName();

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public boolean a() {
        return true;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public k iy(final Context context) {
        return new k() { // from class: com.ss.android.downloadlib.d.d.1
            private c.a pWN;
            private DialogInterface.OnClickListener pWO;
            private DialogInterface.OnClickListener pWP;
            private DialogInterface.OnCancelListener pWQ;

            {
                this.pWN = new c.a(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k Sh(int i) {
                this.pWN.aal(context.getResources().getString(i));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k aaP(String str) {
                this.pWN.aam(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k h(int i, DialogInterface.OnClickListener onClickListener) {
                this.pWN.aan(context.getResources().getString(i));
                this.pWO = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k i(int i, DialogInterface.OnClickListener onClickListener) {
                this.pWN.aao(context.getResources().getString(i));
                this.pWP = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k h(DialogInterface.OnCancelListener onCancelListener) {
                this.pWQ = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k BI(boolean z) {
                this.pWN.Bt(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public j eGy() {
                this.pWN.a(new c.b() { // from class: com.ss.android.downloadlib.d.d.1.1
                    @Override // com.ss.android.a.a.d.c.b
                    public void a(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.pWO != null) {
                            AnonymousClass1.this.pWO.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.a.a.d.c.b
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.pWP != null) {
                            AnonymousClass1.this.pWP.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.a.a.d.c.b
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.pWQ != null && dialogInterface != null) {
                            AnonymousClass1.this.pWQ.onCancel(dialogInterface);
                        }
                    }
                });
                h.i(d.f13279a, "getThemedAlertDlgBuilder", null);
                this.pWN.RX(3);
                return new a(com.ss.android.downloadlib.a.j.eGf().b(this.pWN.eFC()));
            }
        };
    }

    /* loaded from: classes4.dex */
    private static class a implements j {

        /* renamed from: a  reason: collision with root package name */
        private Dialog f13281a;

        public a(Dialog dialog) {
            if (dialog != null) {
                this.f13281a = dialog;
                a();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public void a() {
            if (this.f13281a != null) {
                this.f13281a.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public boolean b() {
            if (this.f13281a != null) {
                return this.f13281a.isShowing();
            }
            return false;
        }
    }
}
