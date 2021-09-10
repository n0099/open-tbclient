package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.b;
import i.c;
import i.j;
import i.k;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends j<b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final SequentialSubscription f79377e;

    /* loaded from: classes2.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements c {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7233503139645205620L;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CompletableOnSubscribeConcat$CompletableConcatSubscriber this$0;

        public ConcatInnerSubscriber(CompletableOnSubscribeConcat$CompletableConcatSubscriber completableOnSubscribeConcat$CompletableConcatSubscriber) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {completableOnSubscribeConcat$CompletableConcatSubscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = completableOnSubscribeConcat$CompletableConcatSubscriber;
        }

        @Override // i.c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.b();
            }
        }

        @Override // i.c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.this$0.c(th);
            }
        }

        @Override // i.c
        public void onSubscribe(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kVar) == null) {
                this.this$0.f79377e.set(kVar);
            }
        }
    }

    public abstract void b();

    public abstract void c(Throwable th);
}
