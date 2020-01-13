package kotlin.reflect;
/* loaded from: classes5.dex */
public interface e<R> extends kotlin.c<R>, b<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    @Override // kotlin.reflect.b
    boolean isSuspend();
}
