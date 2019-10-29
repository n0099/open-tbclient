package com.facebook.datasource;
/* loaded from: classes2.dex */
public class g<T> extends AbstractDataSource<T> {
    private g() {
    }

    public static <T> g<T> cDw() {
        return new g<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.facebook.datasource.g<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.datasource.AbstractDataSource
    public boolean b(T t, boolean z) {
        return super.b(com.facebook.common.internal.g.checkNotNull(t), z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.facebook.datasource.g<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aC(T t) {
        return super.b(com.facebook.common.internal.g.checkNotNull(t), true);
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean s(Throwable th) {
        return super.s((Throwable) com.facebook.common.internal.g.checkNotNull(th));
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean aB(float f) {
        return super.aB(f);
    }
}
