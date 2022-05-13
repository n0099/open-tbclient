package com.tachikoma.core.component.listview;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Object;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.layout.TKYogaConfig;
import com.tachikoma.core.utility.V8Proxy;
import java.util.ArrayList;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes7.dex */
public class TKBaseAdapter extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TKJSContext mTKJSContext;
    public final V8Object mV8Adapter;
    public final List<V8Object> v8Objects;

    /* loaded from: classes7.dex */
    public final class ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TKBase base;
        public V8Object jsObj;
        public final /* synthetic */ TKBaseAdapter this$0;

        public ViewHolder(TKBaseAdapter tKBaseAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tKBaseAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = tKBaseAdapter;
        }
    }

    public TKBaseAdapter(Context context, List<Object> list) {
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
        this.v8Objects = new ArrayList();
        this.mV8Adapter = ((V8Object) list.get(list.size() - 1)).twin();
        this.mTKJSContext = V8Proxy.getTKContext(list);
    }

    public View convertView(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, view2, i)) == null) {
            V8Proxy.executeJsFunction(this.mV8Adapter, this.mTKJSContext, "convertView", ((ViewHolder) view2.getTag(R.id.obfuscated_res_0x7f090d5a)).jsObj, Integer.valueOf(i));
            return view2;
        }
        return (View) invokeLI.objValue;
    }

    public List<V8Object> getAssociatV8Objects() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.v8Objects : (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? V8Proxy.executeIntegerFunction(this.mV8Adapter, this.mTKJSContext, "getCount", new int[0]) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? V8Proxy.executeIntegerFunction(this.mV8Adapter, this.mTKJSContext, "getItemId", i) : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? V8Proxy.executeIntegerFunction(this.mV8Adapter, this.mTKJSContext, "getItemViewType", i) : invokeI.intValue;
    }

    public View getView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Pair<V8Object, Object> executeJsFunction = V8Proxy.executeJsFunction(this.mV8Adapter, this.mTKJSContext, "getView", Integer.valueOf(i));
            if (executeJsFunction == null) {
                return null;
            }
            V8Object v8Object = executeJsFunction.first;
            TKBase tKBase = (TKBase) executeJsFunction.second;
            Object obj = tKBase.style.get("width");
            Object obj2 = tKBase.style.get("height");
            int formatNumber = obj != null ? (int) TKYogaConfig.formatNumber(0, obj) : -1;
            int formatNumber2 = obj2 != null ? (int) TKYogaConfig.formatNumber(0, obj2) : -2;
            View view2 = tKBase.getView();
            view2.setLayoutParams(new ViewGroup.LayoutParams(formatNumber, formatNumber2));
            V8Object twin = v8Object.twin();
            ViewHolder viewHolder = new ViewHolder(this);
            viewHolder.base = tKBase;
            viewHolder.jsObj = twin;
            this.v8Objects.add(twin);
            view2.setTag(R.id.obfuscated_res_0x7f090d5a, viewHolder);
            Log.e("test1", "consumer time :: " + (System.currentTimeMillis() - currentTimeMillis));
            return view2;
        }
        return (View) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) ? view2 == null ? getView(i) : convertView(view2, i) : (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? V8Proxy.executeIntegerFunction(this.mV8Adapter, this.mTKJSContext, "getViewTypeCount", new int[0]) : invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.notifyDataSetInvalidated();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dataSetObserver) == null) {
            super.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dataSetObserver) == null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
