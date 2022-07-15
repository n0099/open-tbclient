package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import com.kwad.sdk.utils.y;
/* loaded from: classes5.dex */
public class KsAdContainer extends RelativeLayout {
    public y.a a;

    public KsAdContainer(Context context) {
        super(context);
        this.a = new y.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new y.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new y.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            y.a aVar = new y.a(getWidth(), getHeight());
            this.a = aVar;
            aVar.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.a.b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public y.a getTouchCoords() {
        return this.a;
    }
}
