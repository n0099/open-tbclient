package com.xiaomi.mipush.sdk;

import com.xiaomi.push.hf;
/* loaded from: classes7.dex */
public /* synthetic */ class am {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f38062a;

    static {
        int[] iArr = new int[hf.values().length];
        f38062a = iArr;
        try {
            iArr[hf.SendMessage.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f38062a[hf.Registration.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f38062a[hf.UnRegistration.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f38062a[hf.Subscription.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f38062a[hf.UnSubscription.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f38062a[hf.Command.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f38062a[hf.Notification.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
