package f.b.x.e.a;

import io.reactivex.BackpressureOverflowStrategy;
/* loaded from: classes7.dex */
public /* synthetic */ class h {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f68492a;

    static {
        int[] iArr = new int[BackpressureOverflowStrategy.values().length];
        f68492a = iArr;
        try {
            iArr[BackpressureOverflowStrategy.DROP_LATEST.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f68492a[BackpressureOverflowStrategy.DROP_OLDEST.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
