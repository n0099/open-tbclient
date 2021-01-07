package com.kwad.sdk.contentalliance.detail.photo.newui.c;

import android.view.MotionEvent;
import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.core.b.e;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.p;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    private View f8841b;
    private int c;
    private com.kwad.sdk.contentalliance.a.a d = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.c.a.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            a.this.c = 0;
        }
    };

    static /* synthetic */ int a(a aVar) {
        int i = aVar.c;
        aVar.c = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f8693a.f8703b.add(this.d);
        this.f8841b.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.c.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.a(a.this);
                    if (a.this.c > 10) {
                        i.a(a.this.o(), "ksad_debug_deviceId_and_gid", "did:" + ah.m() + "——————egid:" + e.a());
                        p.a(a.this.o(), "hello");
                        a.this.c = 0;
                    }
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8693a.f8703b.remove(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8841b = b(R.id.ksad_photo_debug_view);
        this.f8841b.setVisibility(0);
    }
}
