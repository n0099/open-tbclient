package com.tachikoma.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.manager.IProvider;
import com.tachikoma.core.module.TKBusinessSchoolBridge;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class ExportClassProvider implements IProvider<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, String> classMap;

    public ExportClassProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.classMap = new HashMap<>(59);
    }

    @Override // com.tachikoma.core.manager.IProvider
    public void apply(String str, Object obj, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, obj, hashMap) == null) {
        }
    }

    @Override // com.tachikoma.core.manager.IProvider
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.classMap.clear();
        }
    }

    @Override // com.tachikoma.core.manager.IProvider
    public HashMap<String, String> get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.classMap : (HashMap) invokeV.objValue;
    }

    @Override // com.tachikoma.core.manager.IProvider
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.classMap.put("TKAndroidLifeCycle", "com.tachikoma.core.module.handler.TKLifeCycle");
            this.classMap.put("TKSwitchEvent", "com.tachikoma.core.event.view.TKSwitchEvent");
            this.classMap.put("TKAndroid_RefreshControl", "com.tachikoma.core.component.recyclerview.export.TKRefreshControl");
            this.classMap.put("TKTextArea", "com.tachikoma.core.component.input.TKTextArea");
            this.classMap.put("TKMarqueeText", "com.tachikoma.core.component.text.TKMarqueeText");
            this.classMap.put("TKUpEvent", "com.tachikoma.core.event.guesture.TKUpEvent");
            this.classMap.put("TKImage", "com.tachikoma.core.component.imageview.TKImage");
            this.classMap.put("TKSpan", "com.tachikoma.core.component.text.TKSpan");
            this.classMap.put("TKPanEvent", "com.tachikoma.core.event.guesture.TKPanEvent");
            this.classMap.put("TKInput", "com.tachikoma.core.component.input.TKInput");
            this.classMap.put("TKListView", "com.tachikoma.core.component.listview.TKListView");
            this.classMap.put("TKToast", "com.tachikoma.core.component.toast.TKToast");
            this.classMap.put("TKButton", "com.tachikoma.core.component.button.TKButton");
            this.classMap.put("TKAndroid_WaterListView", "com.tachikoma.core.component.listview.TKWaterListView");
            this.classMap.put("TKKeyframeAnimation", "com.tachikoma.core.component.anim.TKKeyframeAnimation");
            this.classMap.put("TKTapEvent", "com.tachikoma.core.event.guesture.TKTapEvent");
            this.classMap.put("TKSpringAnimation", "com.tachikoma.core.component.anim.TKSpringAnimation");
            this.classMap.put("TKInputEvent", "com.tachikoma.core.event.view.TKInputEvent");
            this.classMap.put("TKBaseAdapter", "com.tachikoma.core.component.listview.TKBaseAdapter");
            this.classMap.put("TKProgressBar", "com.tachikoma.core.component.progressbar.KTProgressBarView");
            this.classMap.put("TKLongPressEvent", "com.tachikoma.core.event.guesture.TKLongPressEvent");
            this.classMap.put("TKDispatchEvent", "com.tachikoma.core.event.guesture.TKDispatchEvent");
            this.classMap.put("TKBasicAnimation", "com.tachikoma.core.component.anim.TKBasicAnimation");
            this.classMap.put("TKAndroid_RefreshAnimatableView", "com.tachikoma.core.component.recyclerview.export.TKRefreshAnimatableView");
            this.classMap.put("TKRequest", "com.tachikoma.core.component.network.Network");
            this.classMap.put("TKRouter", "com.tachikoma.core.router.TKRouter");
            this.classMap.put("TKNetworkError", "com.tachikoma.core.component.network.NetworkError");
            this.classMap.put("TKCardBridge", "com.tachikoma.core.module.TKWebCardBridgeImpl");
            this.classMap.put("TKPinchEvent", "com.tachikoma.core.event.guesture.TKPinchEvent");
            this.classMap.put("TKText", "com.tachikoma.core.component.text.TKText");
            this.classMap.put("TKBaseBridge", "com.tachikoma.core.module.TKBaseBridge");
            this.classMap.put("TKListDataSource", "com.tachikoma.core.component.listview.TKCollectionAdapter");
            this.classMap.put("TKViewPager", "com.tachikoma.core.component.listview.TKViewPager");
            this.classMap.put("TKView", "com.tachikoma.core.component.view.TKView");
            this.classMap.put("TKSpanItem", "com.tachikoma.core.component.text.SpanItem");
            this.classMap.put("TKSwipeEvent", "com.tachikoma.core.event.guesture.TKSwipeEvent");
            this.classMap.put(TKBusinessSchoolBridge.TAG, "com.tachikoma.core.module.TKBusinessSchoolBridge");
            this.classMap.put("TKAndroid_Indicator", "com.tachikoma.core.component.listview.TKIndicator");
            this.classMap.put("TKSwitch", "com.tachikoma.core.component.switchview.TKSwitch");
            this.classMap.put("TKScrollEvent", "com.tachikoma.core.event.view.TKScrollEvent");
            this.classMap.put("TKAndroid_ListView", "com.tachikoma.core.component.listview.TKRecyclerView");
            this.classMap.put("TKDownEvent", "com.tachikoma.core.event.guesture.TKDownEvent");
            this.classMap.put("TKEvent", "com.tachikoma.core.event.base.TKBaseEvent");
            this.classMap.put("TKViewPagerAdapter", "com.tachikoma.core.component.listview.TKViewPagerAdapter");
        }
    }

    @Override // com.tachikoma.core.manager.IProvider
    public Object of(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return null;
        }
        return invokeL.objValue;
    }

    @Override // com.tachikoma.core.manager.IProvider
    public HashMap<String, Object> retrieveEvent(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, obj)) == null) {
            return null;
        }
        return (HashMap) invokeLL.objValue;
    }
}
