package defpackage;

import com.baidu.cloudsdk.social.core.MediaType;
/* renamed from: cd  reason: default package */
/* loaded from: classes.dex */
/* synthetic */ class cd {
    static final /* synthetic */ int[] a = new int[MediaType.values().length];

    static {
        try {
            a[MediaType.SINAWEIBO.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[MediaType.QZONE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
