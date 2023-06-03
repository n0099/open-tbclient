package kotlinx.coroutines.reactive;

import com.baidu.android.imsdk.internal.Constants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.AwaitKt", f = "Await.kt", i = {0}, l = {Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID}, m = "awaitSingleOrElse", n = {"defaultValue"}, s = {"L$0"})
/* loaded from: classes10.dex */
public final class AwaitKt$awaitSingleOrElse$1<T> extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public AwaitKt$awaitSingleOrElse$1(Continuation<? super AwaitKt$awaitSingleOrElse$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AwaitKt.awaitSingleOrElse(null, null, this);
    }
}
