package com.facebook.datasource;
/* loaded from: classes6.dex */
public abstract class a<T> implements d<T> {
    protected abstract void a(b<T> bVar);

    protected abstract void g(b<T> bVar);

    @Override // com.facebook.datasource.d
    public void d(b<T> bVar) {
        boolean isFinished = bVar.isFinished();
        try {
            g(bVar);
        } finally {
            if (isFinished) {
                bVar.amP();
            }
        }
    }

    @Override // com.facebook.datasource.d
    public void e(b<T> bVar) {
        try {
            a(bVar);
        } finally {
            bVar.amP();
        }
    }

    @Override // com.facebook.datasource.d
    public void b(b<T> bVar) {
    }

    @Override // com.facebook.datasource.d
    public void f(b<T> bVar) {
    }
}
