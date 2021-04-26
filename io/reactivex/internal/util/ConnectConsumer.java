package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
/* loaded from: classes7.dex */
public final class ConnectConsumer implements Consumer<Disposable> {
    public Disposable disposable;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) throws Exception {
        this.disposable = disposable;
    }
}
