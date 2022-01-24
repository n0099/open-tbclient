package com.ss.android.downloadlib.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;
/* loaded from: classes4.dex */
public class g extends com.ss.android.socialbase.appdownloader.c.a {
    public static String a = "g";

    /* loaded from: classes4.dex */
    public static class a implements k {
        public Dialog a;

        public a(Dialog dialog) {
            if (dialog != null) {
                this.a = dialog;
                a();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public void a() {
            Dialog dialog = this.a;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public boolean b() {
            Dialog dialog = this.a;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public l a(final Context context) {
        return new l() { // from class: com.ss.android.downloadlib.c.g.1

            /* renamed from: c  reason: collision with root package name */
            public b.a f59652c;

            /* renamed from: d  reason: collision with root package name */
            public DialogInterface.OnClickListener f59653d;

            /* renamed from: e  reason: collision with root package name */
            public DialogInterface.OnClickListener f59654e;

            /* renamed from: f  reason: collision with root package name */
            public DialogInterface.OnCancelListener f59655f;

            {
                this.f59652c = new b.a(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i2) {
                this.f59652c.a(context.getResources().getString(i2));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l b(int i2, DialogInterface.OnClickListener onClickListener) {
                this.f59652c.d(context.getResources().getString(i2));
                this.f59654e = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(String str) {
                this.f59652c.b(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i2, DialogInterface.OnClickListener onClickListener) {
                this.f59652c.c(context.getResources().getString(i2));
                this.f59653d = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(DialogInterface.OnCancelListener onCancelListener) {
                this.f59655f = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(boolean z) {
                this.f59652c.a(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public k a() {
                this.f59652c.a(new b.InterfaceC2185b() { // from class: com.ss.android.downloadlib.c.g.1.1
                    @Override // com.ss.android.download.api.model.b.InterfaceC2185b
                    public void a(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f59653d != null) {
                            AnonymousClass1.this.f59653d.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC2185b
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f59654e != null) {
                            AnonymousClass1.this.f59654e.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC2185b
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f59655f == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.f59655f.onCancel(dialogInterface);
                    }
                });
                com.ss.android.downloadlib.g.k.a(g.a, "getThemedAlertDlgBuilder", null);
                this.f59652c.a(3);
                return new a(j.c().b(this.f59652c.a()));
            }
        };
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public boolean a() {
        return true;
    }
}
