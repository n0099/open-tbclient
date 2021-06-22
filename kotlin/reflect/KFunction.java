package kotlin.reflect;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.SinceKotlin;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u00022\u00020\u00032\u00020\u0004R\u001c\u0010\u0006\u001a\u00020\u00058&@'X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\n\u001a\u00020\u00058&@'X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\t\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\f\u001a\u00020\u00058&@'X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\f\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00058&@'X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007R\u001c\u0010\u0010\u001a\u00020\u00058&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkotlin/reflect/KFunction;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/Function;", "Lkotlin/Any;", "", "isExternal", "()Z", "isExternal$annotations", "()V", "isInfix", "isInfix$annotations", "isInline", "isInline$annotations", "isOperator", "isOperator$annotations", "isSuspend", "isSuspend$annotations", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public interface KFunction<R> extends KCallable<R>, Function<R> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static final class DefaultImpls {
        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isExternal$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isInfix$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isInline$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isOperator$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isSuspend$annotations() {
        }
    }

    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    @Override // kotlin.reflect.KCallable
    boolean isSuspend();
}
