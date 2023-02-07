package rx.internal.operators;

import com.baidu.tieba.ada;
import com.baidu.tieba.hda;
import com.baidu.tieba.rga;
import com.baidu.tieba.tca;
import com.baidu.tieba.xga;
import com.baidu.tieba.zca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements tca.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final hda<? super ada> connection;
    public final int numberOfSubscribers;
    public final rga<? extends T> source;

    public OnSubscribeAutoConnect(rga<? extends T> rgaVar, int i, hda<? super ada> hdaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rgaVar, Integer.valueOf(i), hdaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i > 0) {
            this.source = rgaVar;
            this.numberOfSubscribers = i;
            this.connection = hdaVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(zca<? super T> zcaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zcaVar) == null) {
            this.source.B(xga.c(zcaVar));
            if (incrementAndGet() == this.numberOfSubscribers) {
                this.source.C(this.connection);
            }
        }
    }

    @Override // com.baidu.tieba.tca.a, com.baidu.tieba.hda
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((zca) ((zca) obj));
    }
}
