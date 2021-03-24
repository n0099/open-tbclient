package kotlin.reflect;

import com.heytap.mcssdk.mode.MessageStat;
import kotlin.Metadata;
import kotlin.SinceKotlin;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u00022\u00020\u0003:\u0002\u000f\u0010R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u00020\b8&@'X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\u00020\b8&@'X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\f\u001a\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/KProperty;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/Any;", "Lkotlin/reflect/KProperty$Getter;", "getGetter", "()Lkotlin/reflect/KProperty$Getter;", "getter", "", "isConst", "()Z", "isConst$annotations", "()V", "isLateinit", "isLateinit$annotations", "Accessor", "Getter", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public interface KProperty<R> extends KCallable<R> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/KProperty$Accessor;", "R", "Lkotlin/Any;", "Lkotlin/reflect/KProperty;", "getProperty", "()Lkotlin/reflect/KProperty;", MessageStat.PROPERTY, "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public interface Accessor<R> {
        KProperty<R> getProperty();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class DefaultImpls {
        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isConst$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isLateinit$annotations() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u00022\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/KProperty$Getter;", "R", "kotlin/reflect/KProperty$Accessor", "Lkotlin/reflect/KFunction;", "Lkotlin/Any;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public interface Getter<R> extends Accessor<R>, KFunction<R> {
    }

    Getter<R> getGetter();

    boolean isConst();

    boolean isLateinit();
}
