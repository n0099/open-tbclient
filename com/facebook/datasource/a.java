package com.facebook.datasource;
/* loaded from: classes2.dex */
public abstract class a<T> implements d<T> {
    protected abstract void onFailureImpl(b<T> bVar);

    protected abstract void onNewResultImpl(b<T> bVar);

    @Override // com.facebook.datasource.d
    public void onNewResult(b<T> bVar) {
        boolean isFinished = bVar.isFinished();
        try {
            onNewResultImpl(bVar);
        } finally {
            if (isFinished) {
                bVar.bTI();
            }
        }
    }

    @Override // com.facebook.datasource.d
    public void onFailure(b<T> bVar) {
        try {
            onFailureImpl(bVar);
        } finally {
            bVar.bTI();
        }
    }

    @Override // com.facebook.datasource.d
    public void onCancellation(b<T> bVar) {
    }

    @Override // com.facebook.datasource.d
    public void onProgressUpdate(b<T> bVar) {
    }
}
