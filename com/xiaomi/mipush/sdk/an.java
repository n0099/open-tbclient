package com.xiaomi.mipush.sdk;

import com.xiaomi.push.hh;
/* loaded from: classes8.dex */
public /* synthetic */ class an {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[hh.values().length];
        a = iArr;
        try {
            iArr[hh.SendMessage.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[hh.Registration.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[hh.UnRegistration.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[hh.Subscription.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[hh.UnSubscription.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[hh.Command.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[hh.Notification.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
