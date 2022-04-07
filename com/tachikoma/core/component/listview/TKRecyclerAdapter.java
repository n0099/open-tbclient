package com.tachikoma.core.component.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Object;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.component.recyclerview.export.ITKListViewDelegate;
import com.tachikoma.core.utility.ObjectUtils;
import com.tachikoma.core.utility.V8Proxy;
import java.util.List;
/* loaded from: classes8.dex */
public class TKRecyclerAdapter extends RecyclerView.Adapter<TKViewHolder> implements ITKListViewDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ITKRecyclerAdapter mAdapter;
    public V8Object mDelegateV8;
    public TKJSContext mTKJSContext;
    public V8Object mV8AssociatedObject;

    /* loaded from: classes8.dex */
    public static class TKViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TKBase<?> mBase;
        public V8Object mJSObject;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TKViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public TKRecyclerAdapter(Context context, List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mTKJSContext = V8Proxy.getTKContext(list);
        V8Object twin = ((V8Object) ObjectUtils.requireNonNull(V8Proxy.getAssociateJsObject(list))).twin();
        this.mV8AssociatedObject = twin;
        this.mAdapter = new TKJSAdapterImpl(twin, V8Proxy.getTKContext(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void didSelectItemView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i) == null) {
            didSelectItemView(this.mV8AssociatedObject, i);
        }
    }

    private void willDisplayItemView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
            willDisplayItemView(this.mV8AssociatedObject, i);
        }
    }

    @Override // com.tachikoma.core.component.recyclerview.export.ITKListViewDelegate
    public void didSelectItemView(V8Object v8Object, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, v8Object, i) == null) && V8Proxy.isV8Valid(this.mDelegateV8)) {
            this.mDelegateV8.executeJSFunction("didSelectItemView", v8Object, Integer.valueOf(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAdapter.getItemCount() : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.mAdapter.getItemViewType(i) : invokeI.intValue;
    }

    public boolean isFullWidgetForView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? this.mAdapter.isFullWidgetForView(i) : invokeI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull TKViewHolder tKViewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tKViewHolder, i) == null) {
            this.mAdapter.onBindViewHolder(tKViewHolder, i);
            tKViewHolder.itemView.setOnClickListener(new View.OnClickListener(this, i) { // from class: com.tachikoma.core.component.listview.TKRecyclerAdapter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKRecyclerAdapter this$0;
                public final /* synthetic */ int val$position;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$position = i;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.this$0.didSelectItemView(this.val$position);
                    }
                }
            });
            willDisplayItemView(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TKViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i)) == null) ? this.mAdapter.onCreateViewHolder(viewGroup, i) : (TKViewHolder) invokeLI.objValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ITKRecyclerAdapter iTKRecyclerAdapter = this.mAdapter;
            if (iTKRecyclerAdapter != null) {
                iTKRecyclerAdapter.onDestroy();
            }
            V8Object v8Object = this.mDelegateV8;
            if (v8Object != null) {
                v8Object.close();
                this.mDelegateV8 = null;
            }
            V8Object v8Object2 = this.mV8AssociatedObject;
            if (v8Object2 != null) {
                v8Object2.close();
                this.mV8AssociatedObject = null;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, recyclerView) == null) {
            super.onDetachedFromRecyclerView(recyclerView);
            this.mAdapter.onDestroy();
        }
    }

    public void setNeedFixHeight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.mAdapter.setNeedFixHeight(z);
        }
    }

    public void setSupportForFullSpan(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mAdapter.setSupportForFullSpan(z);
        }
    }

    public void setV8Delegate(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, v8Object) == null) {
            this.mDelegateV8 = v8Object.twin();
        }
    }

    @Override // com.tachikoma.core.component.recyclerview.export.ITKListViewDelegate
    public void willDisplayItemView(V8Object v8Object, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048589, this, v8Object, i) == null) && V8Proxy.isV8Valid(this.mDelegateV8)) {
            this.mDelegateV8.executeJSFunction("willDisplayItemView", v8Object, Integer.valueOf(i));
        }
    }
}
