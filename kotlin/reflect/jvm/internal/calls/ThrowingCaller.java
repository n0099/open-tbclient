package kotlin.reflect.jvm.internal.calls;

import androidx.core.app.NotificationCompat;
import com.baidu.webkit.sdk.WebChromeClient;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/ThrowingCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", WebChromeClient.KEY_ARG_ARRAY, "", NotificationCompat.CATEGORY_CALL, "([Ljava/lang/Object;)Ljava/lang/Object;", "", "getMember", "()Ljava/lang/Void;", "member", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "parameterTypes", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ThrowingCaller implements Caller {
    public static final ThrowingCaller INSTANCE = new ThrowingCaller();

    /* JADX DEBUG: Possible override for method kotlin.reflect.jvm.internal.calls.Caller.getMember()Ljava/lang/reflect/Member; */
    public Void getMember() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* renamed from: getMember */
    public /* bridge */ /* synthetic */ Member mo2097getMember() {
        return (Member) getMember();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public List<Type> getParameterTypes() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Type getReturnType() {
        Class cls = Void.TYPE;
        Intrinsics.checkExpressionValueIsNotNull(cls, "Void.TYPE");
        return cls;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] objArr) {
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }
}
