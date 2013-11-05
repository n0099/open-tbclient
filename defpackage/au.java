package defpackage;

import com.baidu.cloudsdk.social.core.MediaType;
/* renamed from: au  reason: default package */
/* loaded from: classes.dex */
/* synthetic */ class au {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f366a = new int[MediaType.values().length];

    static {
        try {
            f366a[MediaType.SINAWEIBO.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f366a[MediaType.QQWEIBO.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f366a[MediaType.RENREN.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f366a[MediaType.KAIXIN.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f366a[MediaType.QZONE.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
