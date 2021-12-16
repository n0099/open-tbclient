package com.tachikoma.core.component.recyclerview.export;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.IFactory;
import java.util.List;
/* loaded from: classes3.dex */
public class TKRefreshAnimatableViewFactory implements IFactory<TKRefreshAnimatableView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TKRefreshAnimatableViewFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tachikoma.core.component.IFactory
    public TKRefreshAnimatableView newInstance(Context context, List<Object> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, list)) == null) ? new TKRefreshAnimatableView(context, list) : (TKRefreshAnimatableView) invokeLL.objValue;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tachikoma.core.component.IFactory
    public /* bridge */ /* synthetic */ TKRefreshAnimatableView newInstance(Context context, List list) {
        return newInstance(context, (List<Object>) list);
    }
}
