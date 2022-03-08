package com.kuaishou.tachikoma.api;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.tachikoma.api.page.IFunction;
import com.kwad.v8.JavaCallback;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Object;
import com.kwad.v8.utils.V8ObjectUtils;
import com.kwad.yoga.YogaAlign;
import com.kwad.yoga.YogaJustify;
import com.kwad.yoga.YogaNode;
import com.tachikoma.core.IV8Function;
import com.tachikoma.core.bridge.JSContext;
import com.tachikoma.core.component.TKBase;
import java.util.List;
/* loaded from: classes7.dex */
public class TKViewContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final JSContext.V8AssociateReference mAssociateReference;
    public IJS2NativeInvoker mInvoker;
    public TKBase tkView;

    /* loaded from: classes7.dex */
    public interface IJS2NativeInvoker {
        Object onJSInvokeNativeWithJSONString(String str, String str2, IFunction iFunction);
    }

    /* loaded from: classes7.dex */
    public interface INativeCallback {
        Object invoke(List<Object> list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKViewContainer(@NonNull JSContext.V8AssociateReference v8AssociateReference) {
        super(((TKBase) v8AssociateReference.nativeObject).getContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8AssociateReference};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAssociateReference = v8AssociateReference;
        bindTKView((TKBase) v8AssociateReference.nativeObject);
    }

    private void dfsDestroyChildren(@Nullable View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, view) == null) || view == null) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i2 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 >= viewGroup.getChildCount()) {
                    break;
                }
                dfsDestroyChildren(viewGroup.getChildAt(i2));
                i2++;
            }
        }
        TKBase tKBaseFromView = TKBase.getTKBaseFromView(view);
        if (tKBaseFromView != null) {
            tKBaseFromView.destroy();
        }
    }

    private void registerInvoker() {
        TKBase tKBase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (tKBase = this.tkView) == null) {
            return;
        }
        IJS2NativeInvoker iJS2NativeInvoker = this.mInvoker;
        if (iJS2NativeInvoker == null) {
            tKBase.setIJS2NativeInvoker(null);
        } else {
            tKBase.setIJS2NativeInvoker(new TKBase.IJS2NativeInvoker(this, iJS2NativeInvoker) { // from class: com.kuaishou.tachikoma.api.TKViewContainer.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKViewContainer this$0;
                public final /* synthetic */ IJS2NativeInvoker val$invoker;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iJS2NativeInvoker};
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
                    this.val$invoker = iJS2NativeInvoker;
                }

                @Override // com.tachikoma.core.component.TKBase.IJS2NativeInvoker
                public Object onJSInvokeNativeWithJSONString(String str, String str2, IV8Function iV8Function) {
                    InterceptResult invokeLLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, str, str2, iV8Function)) == null) ? this.val$invoker.onJSInvokeNativeWithJSONString(str, str2, new IFunction(this, iV8Function) { // from class: com.kuaishou.tachikoma.api.TKViewContainer.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass2 this$1;
                        public final /* synthetic */ IV8Function val$callback;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iV8Function};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$callback = iV8Function;
                        }

                        @Override // com.kuaishou.tachikoma.api.page.IFunction
                        @Nullable
                        public Object call(@Nullable Object... objArr) {
                            InterceptResult invokeL;
                            Interceptable interceptable3 = $ic;
                            return (interceptable3 == null || (invokeL = interceptable3.invokeL(1048576, this, objArr)) == null) ? this.val$callback.call(objArr) : invokeL.objValue;
                        }
                    }) : invokeLLL.objValue;
                }
            });
        }
    }

    public void bindTKView(TKBase tKBase) {
        TKBase tKBase2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tKBase) == null) || (tKBase2 = this.tkView) == tKBase) {
            return;
        }
        if (tKBase2 != null) {
            tKBase.setIJS2NativeInvoker(null);
            removeView(this.tkView.getView());
            this.tkView.destroy();
        }
        this.tkView = tKBase;
        registerInvoker();
        tKBase.bindV8This((V8Object) this.mAssociateReference.v8Value);
        ViewGroup viewGroup = (ViewGroup) tKBase.getView();
        if (viewGroup != null) {
            YogaNode yogaNode = tKBase.getDomNode().getYogaNode();
            yogaNode.setAlignContent(YogaAlign.CENTER);
            yogaNode.setAlignItems(YogaAlign.CENTER);
            yogaNode.setJustifyContent(YogaJustify.CENTER);
            yogaNode.calculateLayout(0.0f, 0.0f);
            addView(viewGroup);
        }
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mAssociateReference.close();
            dfsDestroyChildren(this.tkView.getView());
        }
    }

    public Object invokeJSFunctionWithJSONString(String str, @Nullable String str2, @Nullable IFunction iFunction) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, iFunction)) == null) {
            return this.tkView.invokeJSFunctionWithJSONString(str, str2, iFunction == null ? null : new JavaCallback(this, iFunction) { // from class: com.kuaishou.tachikoma.api.TKViewContainer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKViewContainer this$0;
                public final /* synthetic */ IFunction val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iFunction};
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
                    this.val$callback = iFunction;
                }

                @Override // com.kwad.v8.JavaCallback
                public Object invoke(V8Object v8Object, V8Array v8Array) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, v8Object, v8Array)) == null) ? this.val$callback.call(V8ObjectUtils.toList(v8Array).toArray()) : invokeLL.objValue;
                }
            });
        }
        return invokeLLL.objValue;
    }

    public void setData(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
            TKBase tKBase = this.tkView;
            if (tKBase == null) {
                throw new IllegalStateException("TKViewContainer 里没有 view，代码不应该执行到这里");
            }
            tKBase.setData(objArr);
        }
    }

    public void setIJS2NativeInvoker(IJS2NativeInvoker iJS2NativeInvoker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iJS2NativeInvoker) == null) {
            this.mInvoker = iJS2NativeInvoker;
            registerInvoker();
        }
    }
}
