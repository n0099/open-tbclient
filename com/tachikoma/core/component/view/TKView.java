package com.tachikoma.core.component.view;

import android.content.Context;
import android.view.MotionEvent;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Function;
import com.kwad.v8.V8Object;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.api.IHostEnvInner;
import com.tachikoma.core.bridge.JSContext;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.component.TKYogaLayout;
import com.tachikoma.core.event.TKEventProcess;
import com.tachikoma.core.event.base.GestureUtils;
import com.tachikoma.core.event.base.IBaseEvent;
import com.tachikoma.core.event.guesture.TKDispatchEvent;
import com.tachikoma.core.manager.TKModuleManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@TK_EXPORT_CLASS
/* loaded from: classes7.dex */
public class TKView extends TKBase<TKYogaLayout> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<JSContext.V8AssociateReference> associateChildRefList;
    public Map<String, TKBase> children;
    public boolean clipChildren;
    public V8Function disPathEventListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKView(Context context, @Nullable List<Object> list) {
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
        this.children = new HashMap();
        this.clipChildren = true;
        this.associateChildRefList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dispatchTouchEvent(String str, TKEventProcess.EventInterface eventInterface) {
        InterceptResult invokeLL;
        Object processEventCallBack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, eventInterface)) == null) {
            V8Function v8Function = this.eventListener.get(str);
            if (v8Function == null || v8Function.isReleased() || (processEventCallBack = TKEventProcess.processEventCallBack(v8Function, str, this.mTKJSContext.context(), getContext(), eventInterface)) == null || !(processEventCallBack instanceof Boolean)) {
                return true;
            }
            return ((Boolean) processEventCallBack).booleanValue();
        }
        return invokeLL.booleanValue;
    }

    private void throwIfDebug(Throwable th) {
        IHostEnvInner iHostEnvInner;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, th) == null) && (iHostEnvInner = (IHostEnvInner) TKModuleManager.getInstance().getHandler(this.mTKJSContext, IHostEnvInner.class)) != null && iHostEnvInner.isDebug()) {
            throw new RuntimeException(th);
        }
    }

    public void add(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v8Object) == null) {
            JSContext.V8AssociateReference associateReference = this.mTKJSContext.context().getAssociateReference(v8Object);
            TKBase tKBase = (TKBase) associateReference.nativeObject;
            tKBase.onAttach();
            getDomNode().addSubview(tKBase);
            this.children.put(tKBase.getViewID(), tKBase);
            this.associateChildRefList.add(associateReference);
            getDomNode().layoutSubviews();
        }
    }

    @Override // com.tachikoma.core.component.TKBase
    @Keep
    public void addEventListener(String str, V8Function v8Function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, v8Function) == null) {
            if ("dispatch".equals(str)) {
                getView().registerDispatchListener(new TKYogaLayout.DisPatchEventListener(this) { // from class: com.tachikoma.core.component.view.TKView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TKView this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.tachikoma.core.component.TKYogaLayout.DisPatchEventListener
                    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, motionEvent)) == null) ? this.this$0.dispatchTouchEvent("dispatch", new TKEventProcess.EventInterface(this, motionEvent) { // from class: com.tachikoma.core.component.view.TKView.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 this$1;
                            public final /* synthetic */ MotionEvent val$ev;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, motionEvent};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$ev = motionEvent;
                            }

                            @Override // com.tachikoma.core.event.TKEventProcess.EventInterface
                            public void callBackEvent(IBaseEvent iBaseEvent) {
                                Interceptable interceptable3 = $ic;
                                if ((interceptable3 == null || interceptable3.invokeL(1048576, this, iBaseEvent) == null) && (iBaseEvent instanceof TKDispatchEvent)) {
                                    TKDispatchEvent tKDispatchEvent = (TKDispatchEvent) iBaseEvent;
                                    tKDispatchEvent.setType("dispatch");
                                    tKDispatchEvent.setPosition(new HashMap<String, Float>(this) { // from class: com.tachikoma.core.component.view.TKView.1.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ C06481 this$2;

                                        {
                                            Interceptable interceptable4 = $ic;
                                            if (interceptable4 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable4.invokeUnInit(65536, newInitContext);
                                                int i = newInitContext.flag;
                                                if ((i & 1) != 0) {
                                                    int i2 = i & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable4.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$2 = this;
                                            put("x", Float.valueOf(this.this$2.val$ev.getX()));
                                            put("y", Float.valueOf(this.this$2.val$ev.getY()));
                                        }
                                    });
                                    tKDispatchEvent.setState(GestureUtils.findStateInMotionEvent(this.val$ev));
                                }
                            }
                        }) : invokeL.booleanValue;
                    }
                });
            }
            super.addEventListener(str, v8Function);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tachikoma.core.component.TKBase
    public TKYogaLayout createViewInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? new TKYogaLayout(context) : (TKYogaLayout) invokeL.objValue;
    }

    public Map<String, TKBase> getChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.children : (Map) invokeV.objValue;
    }

    public TKBase getSubview(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.children.get(str) : (TKBase) invokeL.objValue;
    }

    public void insertBefore(V8Object v8Object, V8Object v8Object2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, v8Object, v8Object2) == null) {
            try {
                JSContext.V8AssociateReference associateReference = this.mTKJSContext.context().getAssociateReference(v8Object);
                JSContext.V8AssociateReference associateReference2 = this.mTKJSContext.context().getAssociateReference(v8Object2);
                TKBase tKBase = (TKBase) associateReference.nativeObject;
                getDomNode().insertBefore(tKBase, (TKBase) associateReference2.nativeObject);
                this.children.put(tKBase.getViewID(), tKBase);
                this.associateChildRefList.add(associateReference);
                getDomNode().layoutSubviews();
                associateReference.close();
                associateReference2.close();
            } catch (Exception e) {
                e.printStackTrace();
                throwIfDebug(e);
            }
        }
    }

    public void layout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            getDomNode().layoutSubviews();
        }
    }

    @Override // com.tachikoma.core.component.TKBase, com.tachikoma.core.common.ILifeCycle
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onCreate();
        }
    }

    @Override // com.tachikoma.core.component.TKBase, com.tachikoma.core.common.ILifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            TKYogaLayout view2 = getView();
            if (view2 != null) {
                view2.removeAllViews();
                view2.unRegisterListener();
            }
            JSContext.V8AssociateReference.closeAllReference(this.associateChildRefList.iterator());
            this.associateChildRefList.clear();
        }
    }

    public void onDisPath() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void remove(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, v8Object) == null) {
            try {
                JSContext.V8AssociateReference associateReference = this.mTKJSContext.context().getAssociateReference(v8Object);
                TKBase tKBase = (TKBase) associateReference.nativeObject;
                getDomNode().removeSubview(tKBase);
                tKBase.getDomNode().setYogaNode(null);
                this.children.remove(tKBase.getViewID());
                getDomNode().layoutSubviews();
                associateReference.close();
                JSContext.V8AssociateReference.closeByNative(tKBase, this.associateChildRefList.iterator());
            } catch (Exception e) {
                e.printStackTrace();
                throwIfDebug(e);
            }
        }
    }

    public void removeAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            try {
                getDomNode().removeAllSubviews();
                for (TKBase tKBase : this.children.values()) {
                    tKBase.getDomNode().setYogaNode(null);
                    tKBase.onDestroy();
                }
                this.children.clear();
                for (JSContext.V8AssociateReference v8AssociateReference : this.associateChildRefList) {
                    v8AssociateReference.close();
                }
                this.associateChildRefList.clear();
            } catch (Exception e) {
                e.printStackTrace();
                throwIfDebug(e);
            }
        }
    }

    public void replace(V8Object v8Object, V8Object v8Object2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, v8Object, v8Object2) == null) {
            try {
                JSContext.V8AssociateReference associateReference = this.mTKJSContext.context().getAssociateReference(v8Object);
                JSContext.V8AssociateReference associateReference2 = this.mTKJSContext.context().getAssociateReference(v8Object2);
                TKBase tKBase = (TKBase) associateReference.nativeObject;
                TKBase tKBase2 = (TKBase) associateReference2.nativeObject;
                getDomNode().replaceSubview(tKBase, tKBase2);
                this.children.remove(tKBase2.getViewID());
                this.children.put(tKBase.getViewID(), tKBase2);
                associateReference2.close();
                JSContext.V8AssociateReference.closeByNative(associateReference2, this.associateChildRefList.iterator());
                this.associateChildRefList.add(associateReference);
                getDomNode().layoutSubviews();
            } catch (Exception e) {
                e.printStackTrace();
                throwIfDebug(e);
            }
        }
    }

    public void setClipChildren(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.clipChildren = z;
            getView().setClipChildren(z);
        }
    }
}
