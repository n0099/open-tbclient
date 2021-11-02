package io.reactivex.disposables;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.internal.util.ExceptionHelper;
/* loaded from: classes3.dex */
public final class ActionDisposable extends ReferenceDisposable<Action> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -8219729196779211169L;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionDisposable(Action action) {
        super(action);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {action};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(@NonNull Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, action) == null) {
            try {
                action.run();
            } catch (Throwable th) {
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
    }
}
