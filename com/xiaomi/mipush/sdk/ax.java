package com.xiaomi.mipush.sdk;

import com.xiaomi.push.hg;
/* loaded from: classes3.dex */
/* synthetic */ class ax {
    static final /* synthetic */ int[] a = new int[hg.values().length];

    static {
        try {
            a[hg.SendMessage.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[hg.Registration.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[hg.UnRegistration.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[hg.Subscription.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[hg.UnSubscription.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            a[hg.Command.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            a[hg.Notification.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
    }
}
