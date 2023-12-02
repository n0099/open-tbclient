package rx.internal.operators;

import com.baidu.tieba.joc;
/* loaded from: classes2.dex */
public final class OnSubscribeFromEmitter$DropEmitter<T> extends OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> {
    public static final long serialVersionUID = 8360058422307496563L;

    @Override // rx.internal.operators.OnSubscribeFromEmitter$NoOverflowBaseEmitter
    public void onOverflow() {
    }

    public OnSubscribeFromEmitter$DropEmitter(joc<? super T> jocVar) {
        super(jocVar);
    }
}
