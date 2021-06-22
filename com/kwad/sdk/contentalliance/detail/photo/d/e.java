package com.kwad.sdk.contentalliance.detail.photo.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.contentalliance.detail.photo.d.b;
/* loaded from: classes6.dex */
public class e extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public b.a f32944a;

    /* renamed from: b  reason: collision with root package name */
    public b f32945b;

    /* renamed from: c  reason: collision with root package name */
    public d f32946c;

    /* renamed from: d  reason: collision with root package name */
    public a f32947d;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public e(Context context, d dVar) {
        super(context);
        this.f32944a = new b.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.e.1
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
        this.f32946c = dVar;
    }

    public void a(a aVar) {
        this.f32947d = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        a aVar = this.f32947d;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        b bVar = new b(getContext());
        this.f32945b = bVar;
        bVar.a(this.f32946c);
        setContentView(this.f32945b);
        this.f32945b.a(this.f32944a);
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f32945b.b(this.f32944a);
        this.f32945b.a();
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        a aVar = this.f32947d;
        if (aVar != null) {
            aVar.a();
        }
    }
}
