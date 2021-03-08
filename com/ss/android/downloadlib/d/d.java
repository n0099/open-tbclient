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
    private static String f7727a = d.class.getSimpleName();

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public boolean a() {
        return true;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public k iA(final Context context) {
        return new k() { // from class: com.ss.android.downloadlib.d.d.1
            private c.a qdE;
            private DialogInterface.OnClickListener qdF;
            private DialogInterface.OnClickListener qdG;
            private DialogInterface.OnCancelListener qdH;

            {
                this.qdE = new c.a(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k Ra(int i) {
                this.qdE.aaw(context.getResources().getString(i));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k aba(String str) {
                this.qdE.aax(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k h(int i, DialogInterface.OnClickListener onClickListener) {
                this.qdE.aay(context.getResources().getString(i));
                this.qdF = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k i(int i, DialogInterface.OnClickListener onClickListener) {
                this.qdE.aaz(context.getResources().getString(i));
                this.qdG = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k h(DialogInterface.OnCancelListener onCancelListener) {
                this.qdH = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public k BW(boolean z) {
                this.qdE.BH(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.k
            public j eFk() {
                this.qdE.a(new c.b() { // from class: com.ss.android.downloadlib.d.d.1.1
                    @Override // com.ss.android.a.a.d.c.b
                    public void a(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.qdF != null) {
                            AnonymousClass1.this.qdF.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.a.a.d.c.b
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.qdG != null) {
                            AnonymousClass1.this.qdG.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.a.a.d.c.b
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.qdH != null && dialogInterface != null) {
                            AnonymousClass1.this.qdH.onCancel(dialogInterface);
                        }
                    }
                });
                h.i(d.f7727a, "getThemedAlertDlgBuilder", null);
                this.qdE.QQ(3);
                return new a(com.ss.android.downloadlib.a.j.eER().b(this.qdE.eEo()));
            }
        };
    }

    /* loaded from: classes6.dex */
    private static class a implements j {

        /* renamed from: a  reason: collision with root package name */
        private Dialog f7729a;

        public a(Dialog dialog) {
            if (dialog != null) {
                this.f7729a = dialog;
                a();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public void a() {
            if (this.f7729a != null) {
                this.f7729a.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.j
        public boolean b() {
            if (this.f7729a != null) {
                return this.f7729a.isShowing();
            }
            return false;
        }
    }
}
