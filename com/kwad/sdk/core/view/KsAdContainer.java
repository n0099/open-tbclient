package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import com.kwad.sdk.utils.s;
/* loaded from: classes3.dex */
public class KsAdContainer extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    protected s.a f6307a;

    public KsAdContainer(Context context) {
        super(context);
        this.f6307a = new s.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6307a = new s.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6307a = new s.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f6307a = new s.a(getWidth(), getHeight());
                this.f6307a.a(motionEvent.getX(), motionEvent.getY());
                break;
            case 1:
                this.f6307a.b(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public s.a getTouchCoords() {
        return this.f6307a;
    }
}
