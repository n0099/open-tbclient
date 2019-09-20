package com.facebook.datasource;
/* loaded from: classes2.dex */
public class g<T> extends AbstractDataSource<T> {
    private g() {
    }

    public static <T> g<T> cGy() {
        return new g<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.facebook.datasource.g<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.datasource.AbstractDataSource
    public boolean a(T t, boolean z) {
        return super.a((g<T>) com.facebook.common.internal.g.checkNotNull(t), z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.datasource.g<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aH(T t) {
        return super.a((g<T>) com.facebook.common.internal.g.checkNotNull(t), true);
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean t(Throwable th) {
        return super.t((Throwable) com.facebook.common.internal.g.checkNotNull(th));
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean aY(float f) {
        return super.aY(f);
    }
}
