package com.kwad.sdk.contentalliance.detail.photo.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.contentalliance.detail.photo.d.b;
/* loaded from: classes4.dex */
public class e extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    b.a f8468a;

    /* renamed from: b  reason: collision with root package name */
    private b f8469b;
    private d c;
    private a d;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();
    }

    public e(Context context, d dVar) {
        super(context);
        this.f8468a = new b.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.e.1
            @Override // com.kwad.sdk.contentalliance.detail.photo.d.b.a
            public void a() {
                e.this.dismiss();
            }

            @Override // com.kwad.sdk.contentalliance.detail.photo.d.b.a
            public void b() {
                e.this.dismiss();
            }
        };
        setOwnerActivity((Activity) (context instanceof ResContext ? ((ResContext) context).getDelegatedContext() : context));
        this.c = dVar;
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (this.d != null) {
            this.d.b();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.f8469b = new b(getContext());
        this.f8469b.a(this.c);
        setContentView(this.f8469b);
        this.f8469b.a(this.f8468a);
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8469b.b(this.f8468a);
        this.f8469b.a();
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        if (this.d != null) {
            this.d.a();
        }
    }
}
