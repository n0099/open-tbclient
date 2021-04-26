package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import com.kwad.sdk.utils.q;
/* loaded from: classes6.dex */
public class KsAdContainer extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public q.a f33599a;

    public KsAdContainer(Context context) {
        super(context);
        this.f33599a = new q.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33599a = new q.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f33599a = new q.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            q.a aVar = new q.a(getWidth(), getHeight());
            this.f33599a = aVar;
            aVar.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.f33599a.b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public q.a getTouchCoords() {
        return this.f33599a;
    }
}
