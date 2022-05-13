package com.tachikoma.core.component.listview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Object;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.bridge.JSContext;
import com.tachikoma.core.common.ILifeCycle;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.component.view.TKView;
import com.tachikoma.core.utility.V8Proxy;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes7.dex */
public class TKListView extends TKBase<ListView> implements ILifeCycle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSContext.V8AssociateReference listViewAdapterAssociateRef;
    public ListView mList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKListView(Context context, List<Object> list) {
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
    }

    public void addFooterView(TKView tKView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tKView) == null) {
            this.mList.addFooterView(tKView.getView());
        }
    }

    public void addHeaderView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            this.mList.addHeaderView(view2);
        }
    }

    public void addHeaderView(View view2, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, view2, obj, z) == null) {
            this.mList.addHeaderView(view2, obj, z);
        }
    }

    @RequiresApi(api = 19)
    public boolean areFooterDividersEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mList.areFooterDividersEnabled() : invokeV.booleanValue;
    }

    @RequiresApi(api = 19)
    public boolean areHeaderDividersEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mList.areHeaderDividersEnabled() : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tachikoma.core.component.TKBase
    public ListView createViewInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) ? new ListView(context) : (ListView) invokeL.objValue;
    }

    public ListAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mList.getAdapter() : (ListAdapter) invokeV.objValue;
    }

    public int getDividerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mList.getDividerHeight() : invokeV.intValue;
    }

    public int getFooterViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mList.getFooterViewsCount() : invokeV.intValue;
    }

    public int getHeaderViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mList.getHeaderViewsCount() : invokeV.intValue;
    }

    public boolean isOpaque() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mList.isOpaque() : invokeV.booleanValue;
    }

    public boolean isSmoothScrollbarEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mList.isSmoothScrollbarEnabled() : invokeV.booleanValue;
    }

    @Override // com.tachikoma.core.component.TKBase, com.tachikoma.core.common.ILifeCycle
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onCreate();
            this.mList = getView();
        }
    }

    @Override // com.tachikoma.core.component.TKBase, com.tachikoma.core.common.ILifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (getAdapter() instanceof TKBaseAdapter) {
                for (V8Object v8Object : ((TKBaseAdapter) getAdapter()).getAssociatV8Objects()) {
                    V8Proxy.release(v8Object);
                }
            }
            JSContext.V8AssociateReference v8AssociateReference = this.listViewAdapterAssociateRef;
            if (v8AssociateReference != null) {
                v8AssociateReference.close();
                this.listViewAdapterAssociateRef = null;
            }
            super.onDestroy();
        }
    }

    public boolean removeFooterView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, view2)) == null) ? this.mList.removeFooterView(view2) : invokeL.booleanValue;
    }

    public boolean removeHeaderView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view2)) == null) ? this.mList.removeHeaderView(view2) : invokeL.booleanValue;
    }

    public boolean requestChildRectangleOnScreen(View view2, Rect rect, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048593, this, view2, rect, z)) == null) ? this.mList.requestChildRectangleOnScreen(view2, rect, z) : invokeLLZ.booleanValue;
    }

    public void setAdapter(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, v8Object) == null) {
            JSContext.V8AssociateReference associateReference = this.mTKJSContext.context().getAssociateReference(v8Object);
            this.mList.setAdapter((ListAdapter) associateReference.nativeObject);
            JSContext.V8AssociateReference v8AssociateReference = this.listViewAdapterAssociateRef;
            if (v8AssociateReference != null) {
                v8AssociateReference.close();
            }
            this.listViewAdapterAssociateRef = associateReference;
        }
    }

    public void setDivider(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, drawable) == null) {
            this.mList.setDivider(drawable);
        }
    }

    public void setFooterDividersEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.mList.setFooterDividersEnabled(z);
        }
    }

    public void setHeaderDividersEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.mList.setHeaderDividersEnabled(z);
        }
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.mList.setSmoothScrollbarEnabled(z);
        }
    }

    public void smoothScrollBy(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i, i2) == null) {
            this.mList.smoothScrollBy(i, i2);
        }
    }

    public void smoothScrollByOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.mList.smoothScrollByOffset(i);
        }
    }

    public void smoothScrollToPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.mList.smoothScrollToPosition(i);
        }
    }

    public void smoothScrollToPosition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048602, this, i, i2) == null) {
            this.mList.smoothScrollToPosition(i, i2);
        }
    }

    public void smoothScrollToPositionFromTop(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048603, this, i, i2) == null) {
            this.mList.smoothScrollToPositionFromTop(i, i2);
        }
    }

    public void smoothScrollToPositionFromTop(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048604, this, i, i2, i3) == null) {
            this.mList.smoothScrollToPositionFromTop(i, i2, i3);
        }
    }
}
