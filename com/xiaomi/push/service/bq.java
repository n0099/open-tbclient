package com.xiaomi.push.service;

import com.xiaomi.push.hf;
/* loaded from: classes7.dex */
public /* synthetic */ class bq {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f41897a;

    static {
        int[] iArr = new int[hf.values().length];
        f41897a = iArr;
        try {
            iArr[hf.Registration.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f41897a[hf.UnRegistration.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f41897a[hf.Subscription.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f41897a[hf.UnSubscription.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f41897a[hf.SendMessage.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f41897a[hf.AckMessage.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f41897a[hf.SetConfig.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f41897a[hf.ReportFeedback.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f41897a[hf.Notification.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f41897a[hf.Command.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
