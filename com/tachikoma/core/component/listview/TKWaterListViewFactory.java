package com.tachikoma.core.component.listview;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.IFactory;
import java.util.List;
/* loaded from: classes7.dex */
public class TKWaterListViewFactory implements IFactory<TKWaterListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TKWaterListViewFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tachikoma.core.component.IFactory
    public TKWaterListView newInstance(Context context, List<Object> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, list)) == null) ? new TKWaterListView(context, list) : (TKWaterListView) invokeLL.objValue;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tachikoma.core.component.IFactory
    public /* bridge */ /* synthetic */ TKWaterListView newInstance(Context context, List list) {
        return newInstance(context, (List<Object>) list);
    }
}
