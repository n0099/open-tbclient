package com.kwad.sdk.contentalliance.detail.photo.newui.c;

import android.view.MotionEvent;
import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.core.b.e;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.p;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public View f32802b;

    /* renamed from: c  reason: collision with root package name */
    public int f32803c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f32804d = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.c.a.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            a.this.f32803c = 0;
        }
    };

    public static /* synthetic */ int a(a aVar) {
        int i = aVar.f32803c;
        aVar.f32803c = i + 1;
        return i;
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.f32537b.add(this.f32804d);
        this.f32802b.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.c.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.a(a.this);
                    if (a.this.f32803c > 10) {
                        i.a(a.this.o(), "ksad_debug_deviceId_and_gid", "did:" + ah.m() + "——————egid:" + e.a());
                        p.a(a.this.o(), "hello");
                        a.this.f32803c = 0;
                    }
                }
                return false;
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.f32537b.remove(this.f32804d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        View b2 = b(R.id.ksad_photo_debug_view);
        this.f32802b = b2;
        b2.setVisibility(0);
    }
}
