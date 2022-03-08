package com.ss.android.downloadlib.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;
/* loaded from: classes8.dex */
public class g extends com.ss.android.socialbase.appdownloader.c.a {
    public static String a = "g";

    /* loaded from: classes8.dex */
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
            public b.a f58169c;

            /* renamed from: d  reason: collision with root package name */
            public DialogInterface.OnClickListener f58170d;

            /* renamed from: e  reason: collision with root package name */
            public DialogInterface.OnClickListener f58171e;

            /* renamed from: f  reason: collision with root package name */
            public DialogInterface.OnCancelListener f58172f;

            {
                this.f58169c = new b.a(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i2) {
                this.f58169c.a(context.getResources().getString(i2));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l b(int i2, DialogInterface.OnClickListener onClickListener) {
                this.f58169c.d(context.getResources().getString(i2));
                this.f58171e = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(String str) {
                this.f58169c.b(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i2, DialogInterface.OnClickListener onClickListener) {
                this.f58169c.c(context.getResources().getString(i2));
                this.f58170d = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(DialogInterface.OnCancelListener onCancelListener) {
                this.f58172f = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(boolean z) {
                this.f58169c.a(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public k a() {
                this.f58169c.a(new b.InterfaceC2174b() { // from class: com.ss.android.downloadlib.c.g.1.1
                    @Override // com.ss.android.download.api.model.b.InterfaceC2174b
                    public void a(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f58170d != null) {
                            AnonymousClass1.this.f58170d.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC2174b
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f58171e != null) {
                            AnonymousClass1.this.f58171e.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC2174b
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f58172f == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.f58172f.onCancel(dialogInterface);
                    }
                });
                com.ss.android.downloadlib.g.k.a(g.a, "getThemedAlertDlgBuilder", null);
                this.f58169c.a(3);
                return new a(j.c().b(this.f58169c.a()));
            }
        };
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public boolean a() {
        return true;
    }
}
