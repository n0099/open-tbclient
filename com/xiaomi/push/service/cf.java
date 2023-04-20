package com.xiaomi.push.service;

import com.xiaomi.push.hh;
/* loaded from: classes9.dex */
public /* synthetic */ class cf {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[hh.values().length];
        a = iArr;
        try {
            iArr[hh.Registration.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[hh.UnRegistration.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[hh.Subscription.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[hh.UnSubscription.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[hh.SendMessage.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[hh.AckMessage.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[hh.SetConfig.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[hh.ReportFeedback.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[hh.Notification.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[hh.Command.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
