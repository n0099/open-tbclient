package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import com.kwad.sdk.utils.s;
/* loaded from: classes6.dex */
public class KsAdContainer extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public s.a f34623a;

    public KsAdContainer(Context context) {
        super(context);
        this.f34623a = new s.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34623a = new s.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f34623a = new s.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            s.a aVar = new s.a(getWidth(), getHeight());
            this.f34623a = aVar;
            aVar.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.f34623a.b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @MainThread
    public s.a getTouchCoords() {
        return this.f34623a;
    }
}
