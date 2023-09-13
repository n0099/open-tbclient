package rx.internal.operators;

import com.baidu.tieba.yac;
/* loaded from: classes2.dex */
public final class OnSubscribeFromEmitter$DropEmitter<T> extends OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> {
    public static final long serialVersionUID = 8360058422307496563L;

    @Override // rx.internal.operators.OnSubscribeFromEmitter$NoOverflowBaseEmitter
    public void onOverflow() {
    }

    public OnSubscribeFromEmitter$DropEmitter(yac<? super T> yacVar) {
        super(yacVar);
    }
}
