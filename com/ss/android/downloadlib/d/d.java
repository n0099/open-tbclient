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
    private static String f12979a = d.class.getSimpleName();

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public boolean a() {
        return true;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public k iw(final Context context) {
        return new k() { // from class: com.ss.android.downloadlib.d.d.1
            private c.a pSm;
            private DialogInterface.OnClickListener pSn;
            private DialogInterface.OnClickListener pSo;
            private DialogInterface.OnCancelListener pSp;

            {
                this.pSm = new c.a(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k QA(int i) {
                this.pSm.Zd(context.getResources().getString(i));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k ZH(String str) {
                this.pSm.Ze(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k h(int i, DialogInterface.OnClickListener onClickListener) {
                this.pSm.Zf(context.getResources().getString(i));
                this.pSn = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k i(int i, DialogInterface.OnClickListener onClickListener) {
                this.pSm.Zg(context.getResources().getString(i));
                this.pSo = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k h(DialogInterface.OnCancelListener onCancelListener) {
                this.pSp = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k BE(boolean z) {
                this.pSm.Bp(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public j eCH() {
                this.pSm.a(new c.b() { // from class: com.ss.android.downloadlib.d.d.1.1
                    @Override // com.ss.android.a.a.d.c.b
                    public void a(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.pSn != null) {
                            AnonymousClass1.this.pSn.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.a.a.d.c.b
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.pSo != null) {
                            AnonymousClass1.this.pSo.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.a.a.d.c.b
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.pSp != null && dialogInterface != null) {
                            AnonymousClass1.this.pSp.onCancel(dialogInterface);
                        }
                    }
                });
                h.i(d.f12979a, "getThemedAlertDlgBuilder", null);
                this.pSm.Qq(3);
                return new a(com.ss.android.downloadlib.a.j.eCo().b(this.pSm.eBL()));
            }
        };
    }

    /* loaded from: classes4.dex */
    private static class a implements j {

        /* renamed from: a  reason: collision with root package name */
        private Dialog f12981a;

        public a(Dialog dialog) {
            if (dialog != null) {
                this.f12981a = dialog;
                a();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public void a() {
            if (this.f12981a != null) {
                this.f12981a.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public boolean b() {
            if (this.f12981a != null) {
                return this.f12981a.isShowing();
            }
            return false;
        }
    }
}
