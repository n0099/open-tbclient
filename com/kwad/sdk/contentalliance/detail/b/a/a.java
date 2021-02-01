package com.kwad.sdk.contentalliance.detail.b.a;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.TouchHandleFrameLayout;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    private TouchHandleFrameLayout f8396b;
    private GestureDetector.OnGestureListener c;
    private AdTemplate d;
    private int e;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f8396b = (TouchHandleFrameLayout) l();
        this.e = this.f8395a.i;
        this.d = this.f8395a.j;
        this.c = new GestureDetector.OnGestureListener() { // from class: com.kwad.sdk.contentalliance.detail.b.a.a.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                e.h(a.this.d);
                return false;
            }
        };
        this.f8396b.setOnGestureListener(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8396b.setOnGestureListener(null);
    }
}
