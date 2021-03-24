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
    public b.a f32277a;

    /* renamed from: b  reason: collision with root package name */
    public b f32278b;

    /* renamed from: c  reason: collision with root package name */
    public d f32279c;

    /* renamed from: d  reason: collision with root package name */
    public a f32280d;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public e(Context context, d dVar) {
        super(context);
        this.f32277a = new b.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.d.e.1
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
        this.f32279c = dVar;
    }

    public void a(a aVar) {
        this.f32280d = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        a aVar = this.f32280d;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        b bVar = new b(getContext());
        this.f32278b = bVar;
        bVar.a(this.f32279c);
        setContentView(this.f32278b);
        this.f32278b.a(this.f32277a);
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f32278b.b(this.f32277a);
        this.f32278b.a();
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        a aVar = this.f32280d;
        if (aVar != null) {
            aVar.a();
        }
    }
}
