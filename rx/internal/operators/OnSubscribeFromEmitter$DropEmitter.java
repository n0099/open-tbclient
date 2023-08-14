package rx.internal.operators;

import com.baidu.tieba.e1c;
/* loaded from: classes2.dex */
public final class OnSubscribeFromEmitter$DropEmitter<T> extends OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> {
    public static final long serialVersionUID = 8360058422307496563L;

    @Override // rx.internal.operators.OnSubscribeFromEmitter$NoOverflowBaseEmitter
    public void onOverflow() {
    }

    public OnSubscribeFromEmitter$DropEmitter(e1c<? super T> e1cVar) {
        super(e1cVar);
    }
}
