package defpackage;

import com.baidu.cloudsdk.social.core.MediaType;
/* renamed from: cd  reason: default package */
/* loaded from: classes.dex */
/* synthetic */ class cd {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f397a = new int[MediaType.values().length];

    static {
        try {
            f397a[MediaType.SINAWEIBO.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f397a[MediaType.QZONE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
