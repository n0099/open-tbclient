package rx.internal.operators;

import h.j;
/* loaded from: classes7.dex */
public final class OnSubscribeFromEmitter$DropEmitter<T> extends OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> {
    public static final long serialVersionUID = 8360058422307496563L;

    public OnSubscribeFromEmitter$DropEmitter(j<? super T> jVar) {
        super(jVar);
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$NoOverflowBaseEmitter
    public void onOverflow() {
    }
}
