package com.facebook.rebound;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class SpringChain implements SpringListener {
    private static final int DEFAULT_ATTACHMENT_FRICTION = 10;
    private static final int DEFAULT_ATTACHMENT_TENSION = 70;
    private static final int DEFAULT_MAIN_FRICTION = 6;
    private static final int DEFAULT_MAIN_TENSION = 40;
    private final SpringConfig mAttachmentSpringConfig;
    private int mControlSpringIndex;
    private final CopyOnWriteArrayList<SpringListener> mListeners;
    private final SpringConfig mMainSpringConfig;
    private final SpringSystem mSpringSystem;
    private final CopyOnWriteArrayList<Spring> mSprings;
    private static final SpringConfigRegistry registry = SpringConfigRegistry.getInstance();
    private static int id = 0;

    public static SpringChain create() {
        return new SpringChain();
    }

    public static SpringChain create(int i, int i2, int i3, int i4) {
        return new SpringChain(i, i2, i3, i4);
    }

    private SpringChain() {
        this(40, 6, 70, 10);
    }

    private SpringChain(int i, int i2, int i3, int i4) {
        this.mSpringSystem = SpringSystem.create();
        this.mListeners = new CopyOnWriteArrayList<>();
        this.mSprings = new CopyOnWriteArrayList<>();
        this.mControlSpringIndex = -1;
        this.mMainSpringConfig = SpringConfig.fromOrigamiTensionAndFriction(i, i2);
        this.mAttachmentSpringConfig = SpringConfig.fromOrigamiTensionAndFriction(i3, i4);
        SpringConfigRegistry springConfigRegistry = registry;
        SpringConfig springConfig = this.mMainSpringConfig;
        StringBuilder append = new StringBuilder().append("main spring ");
        int i5 = id;
        id = i5 + 1;
        springConfigRegistry.addSpringConfig(springConfig, append.append(i5).toString());
        SpringConfigRegistry springConfigRegistry2 = registry;
        SpringConfig springConfig2 = this.mAttachmentSpringConfig;
        StringBuilder append2 = new StringBuilder().append("attachment spring ");
        int i6 = id;
        id = i6 + 1;
        springConfigRegistry2.addSpringConfig(springConfig2, append2.append(i6).toString());
    }

    public SpringConfig getMainSpringConfig() {
        return this.mMainSpringConfig;
    }

    public SpringConfig getAttachmentSpringConfig() {
        return this.mAttachmentSpringConfig;
    }

    public SpringChain addSpring(SpringListener springListener) {
        this.mSprings.add(this.mSpringSystem.createSpring().addListener(this).setSpringConfig(this.mAttachmentSpringConfig));
        this.mListeners.add(springListener);
        return this;
    }

    public SpringChain setControlSpringIndex(int i) {
        this.mControlSpringIndex = i;
        if (this.mSprings.get(this.mControlSpringIndex) == null) {
            return null;
        }
        for (Spring spring : this.mSpringSystem.getAllSprings()) {
            spring.setSpringConfig(this.mAttachmentSpringConfig);
        }
        getControlSpring().setSpringConfig(this.mMainSpringConfig);
        return this;
    }

    public Spring getControlSpring() {
        return this.mSprings.get(this.mControlSpringIndex);
    }

    public List<Spring> getAllSprings() {
        return this.mSprings;
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringUpdate(Spring spring) {
        int i;
        int i2;
        int indexOf = this.mSprings.indexOf(spring);
        SpringListener springListener = this.mListeners.get(indexOf);
        if (indexOf == this.mControlSpringIndex) {
            i2 = indexOf + 1;
            i = indexOf - 1;
        } else if (indexOf < this.mControlSpringIndex) {
            i = indexOf - 1;
            i2 = -1;
        } else if (indexOf > this.mControlSpringIndex) {
            i2 = indexOf + 1;
            i = -1;
        } else {
            i = -1;
            i2 = -1;
        }
        if (i2 > -1 && i2 < this.mSprings.size()) {
            this.mSprings.get(i2).setEndValue(spring.getCurrentValue());
        }
        if (i > -1 && i < this.mSprings.size()) {
            this.mSprings.get(i).setEndValue(spring.getCurrentValue());
        }
        springListener.onSpringUpdate(spring);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringAtRest(Spring spring) {
        this.mListeners.get(this.mSprings.indexOf(spring)).onSpringAtRest(spring);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringActivate(Spring spring) {
        this.mListeners.get(this.mSprings.indexOf(spring)).onSpringActivate(spring);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringEndStateChange(Spring spring) {
        this.mListeners.get(this.mSprings.indexOf(spring)).onSpringEndStateChange(spring);
    }
}
