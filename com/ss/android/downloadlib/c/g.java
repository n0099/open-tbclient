package com.ss.android.downloadlib.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;
/* loaded from: classes3.dex */
public class g extends com.ss.android.socialbase.appdownloader.c.a {
    public static String a = "g";

    /* loaded from: classes3.dex */
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
            public b.a f59607c;

            /* renamed from: d  reason: collision with root package name */
            public DialogInterface.OnClickListener f59608d;

            /* renamed from: e  reason: collision with root package name */
            public DialogInterface.OnClickListener f59609e;

            /* renamed from: f  reason: collision with root package name */
            public DialogInterface.OnCancelListener f59610f;

            {
                this.f59607c = new b.a(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i2) {
                this.f59607c.a(context.getResources().getString(i2));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l b(int i2, DialogInterface.OnClickListener onClickListener) {
                this.f59607c.d(context.getResources().getString(i2));
                this.f59609e = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(String str) {
                this.f59607c.b(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i2, DialogInterface.OnClickListener onClickListener) {
                this.f59607c.c(context.getResources().getString(i2));
                this.f59608d = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(DialogInterface.OnCancelListener onCancelListener) {
                this.f59610f = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(boolean z) {
                this.f59607c.a(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public k a() {
                this.f59607c.a(new b.InterfaceC2179b() { // from class: com.ss.android.downloadlib.c.g.1.1
                    @Override // com.ss.android.download.api.model.b.InterfaceC2179b
                    public void a(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f59608d != null) {
                            AnonymousClass1.this.f59608d.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC2179b
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f59609e != null) {
                            AnonymousClass1.this.f59609e.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC2179b
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f59610f == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.f59610f.onCancel(dialogInterface);
                    }
                });
                com.ss.android.downloadlib.g.k.a(g.a, "getThemedAlertDlgBuilder", null);
                this.f59607c.a(3);
                return new a(j.c().b(this.f59607c.a()));
            }
        };
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public boolean a() {
        return true;
    }
}
