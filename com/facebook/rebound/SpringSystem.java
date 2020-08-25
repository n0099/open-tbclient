package com.facebook.rebound;
/* loaded from: classes4.dex */
public class SpringSystem extends BaseSpringSystem {
    public static SpringSystem create() {
        return new SpringSystem(AndroidSpringLooperFactory.createSpringLooper());
    }

    private SpringSystem(SpringLooper springLooper) {
        super(springLooper);
    }
}
