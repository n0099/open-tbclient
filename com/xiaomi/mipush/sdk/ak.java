package com.xiaomi.mipush.sdk;

import com.xiaomi.push.hm;
/* loaded from: classes9.dex */
/* synthetic */ class ak {
    static final /* synthetic */ int[] a = new int[hm.values().length];

    static {
        try {
            a[hm.Registration.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[hm.UnRegistration.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[hm.Subscription.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[hm.UnSubscription.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[hm.SendMessage.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            a[hm.AckMessage.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            a[hm.SetConfig.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            a[hm.ReportFeedback.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        try {
            a[hm.Notification.ordinal()] = 9;
        } catch (NoSuchFieldError e9) {
        }
        try {
            a[hm.Command.ordinal()] = 10;
        } catch (NoSuchFieldError e10) {
        }
    }
}
