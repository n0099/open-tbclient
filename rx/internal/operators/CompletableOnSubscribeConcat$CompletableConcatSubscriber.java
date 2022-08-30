package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gv9;
import com.baidu.tieba.hv9;
import com.baidu.tieba.yu9;
import com.baidu.tieba.zu9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes8.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends gv9<yu9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SequentialSubscription e;

    /* loaded from: classes8.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements zu9 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = completableOnSubscribeConcat$CompletableConcatSubscriber;
        }

        @Override // com.baidu.tieba.zu9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.g();
            }
        }

        @Override // com.baidu.tieba.zu9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.this$0.h(th);
            }
        }

        @Override // com.baidu.tieba.zu9
        public void onSubscribe(hv9 hv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hv9Var) == null) {
                this.this$0.e.set(hv9Var);
            }
        }
    }

    public abstract void g();

    public abstract void h(Throwable th);
}
