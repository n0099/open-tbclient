package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.SubscriberMethod;
/* loaded from: classes7.dex */
public interface SubscriberInfo {
    Class<?> getSubscriberClass();

    SubscriberMethod[] getSubscriberMethods();

    SubscriberInfo getSuperSubscriberInfo();

    boolean shouldCheckSuperclass();
}
