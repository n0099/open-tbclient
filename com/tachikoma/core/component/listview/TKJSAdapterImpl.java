package com.tachikoma.core.component.listview;

import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Object;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.component.listview.TKRecyclerAdapter;
import com.tachikoma.core.component.recyclerview.export.ITKListDataSource;
import com.tachikoma.core.component.view.TKView;
import com.tachikoma.core.utility.SizeUtil;
import com.tachikoma.core.utility.V8Proxy;
import com.tachikoma.core.yoga.layout.YogaLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class TKJSAdapterImpl implements ITKRecyclerAdapter, ITKListDataSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HEIGHT_INVALID = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsSupportForSetFullSpan;
    public final V8Object mJSAdapter;
    public boolean mNeedFixHeight;
    public final TKJSContext mTKJSContext;
    public final List<V8Object> mV8Cache;

    public TKJSAdapterImpl(V8Object v8Object, TKJSContext tKJSContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8Object, tKJSContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mV8Cache = new ArrayList();
        this.mJSAdapter = v8Object.twin();
        this.mTKJSContext = tKJSContext;
    }

    private int getItemHeight(V8Object v8Object, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, this, v8Object, i)) == null) {
            V8Object v8Object2 = null;
            try {
                v8Object2 = sizeForItemView(v8Object, i);
                int dp2Px = SizeUtil.dp2Px(((Number) v8Object2.get("height")).intValue());
                V8Proxy.release(v8Object2);
                return dp2Px;
            } catch (Exception unused) {
                V8Proxy.release(v8Object2);
                return -1;
            } catch (Throwable th) {
                V8Proxy.release(v8Object2);
                throw th;
            }
        }
        return invokeLI.intValue;
    }

    @Override // com.tachikoma.core.component.recyclerview.export.ITKListDataSource
    public int countOfItems(V8Object v8Object, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, v8Object, i)) == null) ? ((Integer) this.mJSAdapter.executeJSFunction("countOfItems", v8Object)).intValue() : invokeLI.intValue;
    }

    @Override // com.tachikoma.core.component.recyclerview.export.ITKListDataSource
    public int countOfSections(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v8Object)) == null) {
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // com.tachikoma.core.component.recyclerview.export.ITKListDataSource
    public V8Object createItemView(V8Object v8Object, V8Object v8Object2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, v8Object, v8Object2, str)) == null) ? (V8Object) this.mJSAdapter.executeJSFunction("createItemView", v8Object, v8Object2, str) : (V8Object) invokeLLL.objValue;
    }

    @Override // com.tachikoma.core.component.recyclerview.export.ITKListDataSource
    public V8Object createSectionFooter(V8Object v8Object, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, v8Object, i, str)) == null) {
            return null;
        }
        return (V8Object) invokeLIL.objValue;
    }

    @Override // com.tachikoma.core.component.recyclerview.export.ITKListDataSource
    public V8Object createSectionHeader(V8Object v8Object, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, v8Object, i, str)) == null) {
            return null;
        }
        return (V8Object) invokeLIL.objValue;
    }

    @Override // com.tachikoma.core.component.listview.ITKRecyclerAdapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? countOfItems(this.mJSAdapter, 0) : invokeV.intValue;
    }

    @Override // com.tachikoma.core.component.listview.ITKRecyclerAdapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? itemType(0, i) : invokeI.intValue;
    }

    @Override // com.tachikoma.core.component.listview.ITKRecyclerAdapter
    public boolean isFullWidgetForView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (this.mIsSupportForSetFullSpan) {
                try {
                    return ((Boolean) this.mJSAdapter.executeJSFunction("isFullWidgetForView", Integer.valueOf(i))).booleanValue();
                } catch (Throwable unused) {
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public int itemType(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2)) == null) ? reusableKeyForItemView(this.mJSAdapter, i2) : invokeII.intValue;
    }

    @Override // com.tachikoma.core.component.listview.ITKRecyclerAdapter
    public void onBindViewHolder(TKRecyclerAdapter.TKViewHolder tKViewHolder, int i) {
        int itemHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, tKViewHolder, i) == null) {
            if (this.mNeedFixHeight && (itemHeight = getItemHeight(this.mJSAdapter, i)) != -1) {
                if (tKViewHolder.itemView.getLayoutParams() != null) {
                    tKViewHolder.itemView.getLayoutParams().height = itemHeight;
                } else {
                    tKViewHolder.itemView.setLayoutParams(new YogaLayout.LayoutParams(-1, itemHeight));
                }
            }
            reuseItemView(this.mJSAdapter, tKViewHolder.mJSObject, i);
        }
    }

    @Override // com.tachikoma.core.component.listview.ITKRecyclerAdapter
    public TKRecyclerAdapter.TKViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, viewGroup, i)) == null) {
            V8Object createItemView = createItemView(this.mJSAdapter, null, String.valueOf(i));
            TKView tKView = new TKView(viewGroup.getContext(), new ArrayList());
            tKView.setTKJSContext(this.mTKJSContext);
            tKView.add(createItemView);
            TKRecyclerAdapter.TKViewHolder tKViewHolder = new TKRecyclerAdapter.TKViewHolder(tKView.getView());
            V8Object twin = createItemView.twin();
            tKViewHolder.mJSObject = twin;
            tKViewHolder.mBase = tKView;
            this.mV8Cache.add(twin);
            V8Proxy.release(createItemView);
            return tKViewHolder;
        }
        return (TKRecyclerAdapter.TKViewHolder) invokeLI.objValue;
    }

    @Override // com.tachikoma.core.component.listview.ITKRecyclerAdapter
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            for (V8Object v8Object : this.mV8Cache) {
                V8Proxy.release(v8Object);
            }
            this.mV8Cache.clear();
            V8Proxy.release(this.mJSAdapter);
        }
    }

    @Override // com.tachikoma.core.component.recyclerview.export.ITKListDataSource
    public int reusableKeyForItemView(V8Object v8Object, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, v8Object, i)) == null) ? ((Number) this.mJSAdapter.executeJSFunction("reusableKeyForItemView", v8Object, Integer.valueOf(i))).intValue() : invokeLI.intValue;
    }

    @Override // com.tachikoma.core.component.recyclerview.export.ITKListDataSource
    public String reusableKeyForSectionHeader(V8Object v8Object, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, v8Object, i)) == null) {
            return null;
        }
        return (String) invokeLI.objValue;
    }

    @Override // com.tachikoma.core.component.recyclerview.export.ITKListDataSource
    public String reusableKeyForSetionFooter(V8Object v8Object, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, v8Object, i)) == null) {
            return null;
        }
        return (String) invokeLI.objValue;
    }

    @Override // com.tachikoma.core.component.recyclerview.export.ITKListDataSource
    public void reuseItemView(V8Object v8Object, V8Object v8Object2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048591, this, v8Object, v8Object2, i) == null) {
            this.mJSAdapter.executeJSFunction("reuseItemView", v8Object, v8Object2, Integer.valueOf(i));
        }
    }

    @Override // com.tachikoma.core.component.recyclerview.export.ITKListDataSource
    public void reuseSectionFooter(V8Object v8Object, V8Object v8Object2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048592, this, v8Object, v8Object2, i) == null) {
        }
    }

    @Override // com.tachikoma.core.component.recyclerview.export.ITKListDataSource
    public void reuseSectionHeader(V8Object v8Object, V8Object v8Object2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048593, this, v8Object, v8Object2, i) == null) {
        }
    }

    @Override // com.tachikoma.core.component.listview.ITKRecyclerAdapter
    public void setNeedFixHeight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.mNeedFixHeight = z;
        }
    }

    @Override // com.tachikoma.core.component.listview.ITKRecyclerAdapter
    public void setSupportForFullSpan(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mIsSupportForSetFullSpan = z;
        }
    }

    @Override // com.tachikoma.core.component.recyclerview.export.ITKListDataSource
    public V8Object sizeForItemView(V8Object v8Object, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, v8Object, i)) == null) ? (V8Object) this.mJSAdapter.executeJSFunction("sizeForItemView", v8Object, Integer.valueOf(i)) : (V8Object) invokeLI.objValue;
    }
}
