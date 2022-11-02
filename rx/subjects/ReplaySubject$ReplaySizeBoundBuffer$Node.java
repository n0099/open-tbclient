package rx.subjects;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class ReplaySubject$ReplaySizeBoundBuffer$Node<T> extends AtomicReference<ReplaySubject$ReplaySizeBoundBuffer$Node<T>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 3713592843205853725L;
    public transient /* synthetic */ FieldHolder $fh;
    public final T value;

    public ReplaySubject$ReplaySizeBoundBuffer$Node(T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.value = t;
    }
}
