package com.ss.android.downloadlib.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;
/* loaded from: classes7.dex */
public class g extends com.ss.android.socialbase.appdownloader.c.a {
    public static String a = "g";

    /* loaded from: classes7.dex */
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
            public b.a f42909c;

            /* renamed from: d  reason: collision with root package name */
            public DialogInterface.OnClickListener f42910d;

            /* renamed from: e  reason: collision with root package name */
            public DialogInterface.OnClickListener f42911e;

            /* renamed from: f  reason: collision with root package name */
            public DialogInterface.OnCancelListener f42912f;

            {
                this.f42909c = new b.a(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i) {
                this.f42909c.a(context.getResources().getString(i));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l b(int i, DialogInterface.OnClickListener onClickListener) {
                this.f42909c.d(context.getResources().getString(i));
                this.f42911e = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(String str) {
                this.f42909c.b(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i, DialogInterface.OnClickListener onClickListener) {
                this.f42909c.c(context.getResources().getString(i));
                this.f42910d = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(DialogInterface.OnCancelListener onCancelListener) {
                this.f42912f = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(boolean z) {
                this.f42909c.a(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public k a() {
                this.f42909c.a(new b.InterfaceC2035b() { // from class: com.ss.android.downloadlib.c.g.1.1
                    @Override // com.ss.android.download.api.model.b.InterfaceC2035b
                    public void a(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f42910d != null) {
                            AnonymousClass1.this.f42910d.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC2035b
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f42911e != null) {
                            AnonymousClass1.this.f42911e.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC2035b
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f42912f == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.f42912f.onCancel(dialogInterface);
                    }
                });
                com.ss.android.downloadlib.g.k.a(g.a, "getThemedAlertDlgBuilder", null);
                this.f42909c.a(3);
                return new a(j.c().b(this.f42909c.a()));
            }
        };
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public boolean a() {
        return true;
    }
}
