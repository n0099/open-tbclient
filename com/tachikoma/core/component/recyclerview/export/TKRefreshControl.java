package com.tachikoma.core.component.recyclerview.export;

import android.content.Context;
import android.view.View;
import com.alipay.sdk.widget.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Object;
import com.kwai.library.widget.refresh.RefreshLayout;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.bridge.JSContext;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.component.view.TKView;
import com.tachikoma.core.utility.V8Proxy;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes2.dex */
public class TKRefreshControl extends TKBase<View> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TKView animatedView;
    public JSContext.V8AssociateReference animatedViewAsoRef;
    public V8Object mAssociateObject;
    public RefreshLayout mRefreshLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKRefreshControl(Context context, List<Object> list) {
        super(context, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void beginRefreshing() {
        RefreshLayout refreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (refreshLayout = this.mRefreshLayout) == null) {
            return;
        }
        refreshLayout.setRefreshing(true);
    }

    @Override // com.tachikoma.core.component.TKBase
    public View createViewInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return null;
        }
        return (View) invokeL.objValue;
    }

    public void endRefreshing() {
        RefreshLayout refreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (refreshLayout = this.mRefreshLayout) == null) {
            return;
        }
        refreshLayout.setRefreshing(false);
    }

    @Override // com.tachikoma.core.component.TKBase, com.tachikoma.core.common.ILifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            JSContext.V8AssociateReference v8AssociateReference = this.animatedViewAsoRef;
            if (v8AssociateReference != null) {
                v8AssociateReference.close();
                this.animatedViewAsoRef = null;
            }
            V8Object v8Object = this.mAssociateObject;
            if (v8Object != null) {
                v8Object.close();
                this.mAssociateObject = null;
            }
        }
    }

    public void onRefresh() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && V8Proxy.isV8Valid(this.mAssociateObject)) {
            try {
                z = this.mAssociateObject.executeBooleanFunction("shouldBeginRefreshing", null);
            } catch (Exception unused) {
                z = false;
            }
            if (z) {
                V8Object v8Object = this.mAssociateObject;
                if (v8Object != null) {
                    v8Object.executeVoidFunction(d.p, null);
                    return;
                }
                return;
            }
            RefreshLayout refreshLayout = this.mRefreshLayout;
            if (refreshLayout != null) {
                refreshLayout.setRefreshing(false);
            }
        }
    }

    public void setAnimatedView(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, v8Object) == null) {
            JSContext.V8AssociateReference associateReference = this.mTKJSContext.context().getAssociateReference(v8Object);
            this.animatedView = (TKView) associateReference.nativeObject;
            JSContext.V8AssociateReference v8AssociateReference = this.animatedViewAsoRef;
            if (v8AssociateReference != null) {
                v8AssociateReference.close();
            }
            this.animatedViewAsoRef = associateReference;
        }
    }

    public void setAssociateObject(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, v8Object) == null) {
            this.mAssociateObject = v8Object.twin();
        }
    }

    public void setRefreshLayout(RefreshLayout refreshLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, refreshLayout) == null) {
            this.mRefreshLayout = refreshLayout;
        }
    }
}
