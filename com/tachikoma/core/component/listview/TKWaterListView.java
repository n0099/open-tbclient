package com.tachikoma.core.component.listview;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Object;
import com.kwad.v8.V8Value;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.utility.V8Proxy;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes7.dex */
public class TKWaterListView extends TKRecyclerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKWaterListView(Context context, List<Object> list) {
        super(context, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLayoutType = TKRecyclerView.TYPE_STAGGER;
    }

    private void initSpanCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            Object obj = this.mV8AssociatedObject.get("dataSource");
            if (obj instanceof V8Object) {
                V8Object v8Object = (V8Object) obj;
                if (V8Proxy.isV8Valid(v8Object)) {
                    this.mSpanCount = ((Number) v8Object.executeJSFunction("numberOfColumns", this.mV8AssociatedObject)).intValue();
                    V8Proxy.release((V8Value) obj);
                }
            }
        }
    }

    @Override // com.tachikoma.core.component.listview.TKRecyclerView
    public RecyclerView.LayoutManager createLayoutManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            initSpanCount();
            return super.createLayoutManager();
        }
        return (RecyclerView.LayoutManager) invokeV.objValue;
    }
}
