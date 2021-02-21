package com.facebook.datasource;
/* loaded from: classes6.dex */
public class g<T> extends AbstractDataSource<T> {
    private g() {
    }

    public static <T> g<T> etr() {
        return new g<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.facebook.datasource.g<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.datasource.AbstractDataSource
    public boolean c(T t, boolean z) {
        return super.c(com.facebook.common.internal.g.checkNotNull(t), z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.datasource.g<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean bg(T t) {
        return super.c(com.facebook.common.internal.g.checkNotNull(t), true);
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean t(Throwable th) {
        return super.t((Throwable) com.facebook.common.internal.g.checkNotNull(th));
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean bF(float f) {
        return super.bF(f);
    }
}
