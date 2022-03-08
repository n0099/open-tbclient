package com.kwad.sdk.reflux;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
/* loaded from: classes8.dex */
public class KsRefluxContentView extends FrameLayout implements GestureDetector.OnGestureListener {
    public GestureDetector a;

    /* renamed from: b  reason: collision with root package name */
    public a f55721b;

    /* loaded from: classes8.dex */
    public interface a {
        boolean a();

        boolean b();
    }

    public KsRefluxContentView(@NonNull Context context) {
        super(context);
        a(context, null, 0);
    }

    public KsRefluxContentView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public KsRefluxContentView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public KsRefluxContentView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2);
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this.a = new GestureDetector(context, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = this.f55721b;
        if (aVar == null || aVar.a()) {
            com.kwad.sdk.core.d.a.a("KsRefluxContentView", "dispatchTouchEvent consumed");
            return super.dispatchTouchEvent(motionEvent);
        }
        com.kwad.sdk.core.d.a.a("KsRefluxContentView", "dispatchTouchEvent mGestureDetector onTouchEvent");
        this.a.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        com.kwad.sdk.core.d.a.a("KsRefluxContentView", "onDown");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        com.kwad.sdk.core.d.a.a("KsRefluxContentView", "onFling");
        a aVar = this.f55721b;
        if (aVar != null) {
            return aVar.b();
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        com.kwad.sdk.core.d.a.a("KsRefluxContentView", "onLongPress");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        com.kwad.sdk.core.d.a.a("KsRefluxContentView", "onScroll");
        a aVar = this.f55721b;
        if (aVar != null) {
            return aVar.b();
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        com.kwad.sdk.core.d.a.a("KsRefluxContentView", "onShowPress");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        com.kwad.sdk.core.d.a.a("KsRefluxContentView", "onSingleTapUp");
        a aVar = this.f55721b;
        if (aVar != null) {
            return aVar.b();
        }
        return false;
    }

    public void setContentViewListener(a aVar) {
        this.f55721b = aVar;
    }
}
