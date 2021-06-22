package com.kwad.sdk.contentalliance.detail.b.a;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.kwad.sdk.contentalliance.detail.c;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.TouchHandleFrameLayout;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public TouchHandleFrameLayout f32793b;

    /* renamed from: c  reason: collision with root package name */
    public GestureDetector.OnGestureListener f32794c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f32795d;

    /* renamed from: e  reason: collision with root package name */
    public int f32796e;

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32793b = (TouchHandleFrameLayout) l();
        c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a;
        this.f32796e = cVar.f32819i;
        this.f32795d = cVar.j;
        GestureDetector.OnGestureListener onGestureListener = new GestureDetector.OnGestureListener() { // from class: com.kwad.sdk.contentalliance.detail.b.a.a.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                e.h(a.this.f32795d);
                return false;
            }
        };
        this.f32794c = onGestureListener;
        this.f32793b.setOnGestureListener(onGestureListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32793b.setOnGestureListener(null);
    }
}
