package com.facebook.rebound;
/* loaded from: classes11.dex */
public interface SpringListener {
    void onSpringActivate(Spring spring);

    void onSpringAtRest(Spring spring);

    void onSpringEndStateChange(Spring spring);

    void onSpringUpdate(Spring spring);
}
