package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.tencent.open.SocialConstants;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0010\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0018\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\b\u0001\u0010\u0005\u001a:\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a4\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001aM\u0010\u0015\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\r2\u0006\u0010\u0013\u001a\u00028\u00002\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0002\b\u0014H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a>\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0012*\u00028\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0017\u0010\u0016\u001aC\u0010\u0018\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0012*\u00028\u00002\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\u0014H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0018\u0010\u0016\u001aD\u0010\u0019\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\r*\u00028\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0019\u0010\u0016\u001aI\u0010\u0010\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\r*\u00028\u00002\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0002\b\u0014H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0010\u0010\u0016\u001a@\u0010\u001c\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0012*\u00028\u00002\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001a0\bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u001c\u0010\u0016\u001a@\u0010\u001d\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0012*\u00028\u00002\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001a0\bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u001d\u0010\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001e"}, d2 = {"", "TODO", "()Ljava/lang/Void;", "", "reason", "(Ljava/lang/String;)Ljava/lang/Void;", "", "times", "Lkotlin/Function1;", "", "action", MediaAEffect.AE_ANIM_REPEAT, "(ILkotlin/Function1;)V", "R", "Lkotlin/Function0;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "run", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, SocialConstants.PARAM_RECEIVER, "Lkotlin/ExtensionFunctionType;", "with", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "also", "apply", "let", "", "predicate", "takeIf", "takeUnless", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/StandardKt")
/* loaded from: classes3.dex */
public class StandardKt__StandardKt {
    @InlineOnly
    public static final Void TODO() {
        throw new NotImplementedError(null, 1, null);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <T> T also(T t, Function1<? super T, Unit> function1) {
        function1.invoke(t);
        return t;
    }

    @InlineOnly
    public static final <T> T apply(T t, Function1<? super T, Unit> function1) {
        function1.invoke(t);
        return t;
    }

    @InlineOnly
    public static final <T, R> R let(T t, Function1<? super T, ? extends R> function1) {
        return function1.invoke(t);
    }

    @InlineOnly
    public static final void repeat(int i2, Function1<? super Integer, Unit> function1) {
        for (int i3 = 0; i3 < i2; i3++) {
            function1.invoke(Integer.valueOf(i3));
        }
    }

    @InlineOnly
    public static final <R> R run(Function0<? extends R> function0) {
        return function0.invoke();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <T> T takeIf(T t, Function1<? super T, Boolean> function1) {
        if (function1.invoke(t).booleanValue()) {
            return t;
        }
        return null;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <T> T takeUnless(T t, Function1<? super T, Boolean> function1) {
        if (function1.invoke(t).booleanValue()) {
            return null;
        }
        return t;
    }

    @InlineOnly
    public static final <T, R> R with(T t, Function1<? super T, ? extends R> function1) {
        return function1.invoke(t);
    }

    @InlineOnly
    public static final Void TODO(String str) {
        throw new NotImplementedError("An operation is not implemented: " + str);
    }

    @InlineOnly
    public static final <T, R> R run(T t, Function1<? super T, ? extends R> function1) {
        return function1.invoke(t);
    }
}
