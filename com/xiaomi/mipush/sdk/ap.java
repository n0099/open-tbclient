package com.xiaomi.mipush.sdk;

import com.xiaomi.push.hm;
/* loaded from: classes8.dex */
/* synthetic */ class ap {
    static final /* synthetic */ int[] a = new int[hm.values().length];

    static {
        try {
            a[hm.SendMessage.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[hm.Registration.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[hm.UnRegistration.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[hm.Subscription.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[hm.UnSubscription.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            a[hm.Command.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            a[hm.Notification.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
    }
}
