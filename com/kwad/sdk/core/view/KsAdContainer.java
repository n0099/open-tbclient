package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.kwad.sdk.utils.aa;
/* loaded from: classes7.dex */
public class KsAdContainer extends RelativeLayout {
    public aa.a afd;

    public KsAdContainer(Context context) {
        super(context);
        this.afd = new aa.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afd = new aa.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afd = new aa.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            aa.a aVar = new aa.a(getWidth(), getHeight());
            this.afd = aVar;
            aVar.e(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.afd.f(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public aa.a getTouchCoords() {
        return this.afd;
    }
}
