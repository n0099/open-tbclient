package kotlin.reflect.jvm.internal.calls;

import androidx.core.app.NotificationCompat;
import com.baidu.webkit.sdk.WebChromeClient;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b`\u0018\u0000*\f\b\u0000\u0010\u0002 \u0001*\u0004\u0018\u00010\u00012\u00020\u0003J\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\t2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00028\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Member;", "M", "Lkotlin/Any;", "", WebChromeClient.KEY_ARG_ARRAY, "", NotificationCompat.CATEGORY_CALL, "([Ljava/lang/Object;)Ljava/lang/Object;", "", "checkArguments", "([Ljava/lang/Object;)V", "getMember", "()Ljava/lang/reflect/Member;", "member", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "parameterTypes", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public interface Caller<M extends Member> {
    Object call(Object[] objArr);

    /* renamed from: getMember */
    M mo2093getMember();

    List<Type> getParameterTypes();

    Type getReturnType();

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public static final class DefaultImpls {
        public static <M extends Member> void checkArguments(Caller<? extends M> caller, Object[] objArr) {
            if (CallerKt.getArity(caller) == objArr.length) {
                return;
            }
            throw new IllegalArgumentException("Callable expects " + CallerKt.getArity(caller) + " arguments, but " + objArr.length + " were provided.");
        }
    }
}
