package com.facebook.drawee.d;

import android.view.MotionEvent;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public interface a {
    void cDX();

    @Nullable
    b getHierarchy();

    void onDetach();

    boolean onTouchEvent(MotionEvent motionEvent);

    void setHierarchy(@Nullable b bVar);
}
