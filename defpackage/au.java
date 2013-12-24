package defpackage;

import com.baidu.cloudsdk.social.core.MediaType;
/* renamed from: au  reason: default package */
/* loaded from: classes.dex */
/* synthetic */ class au {
    static final /* synthetic */ int[] a = new int[MediaType.values().length];

    static {
        try {
            a[MediaType.SINAWEIBO.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[MediaType.QQWEIBO.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[MediaType.RENREN.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[MediaType.KAIXIN.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[MediaType.QZONE.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
