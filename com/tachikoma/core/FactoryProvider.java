package com.tachikoma.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.IFactory;
import com.tachikoma.core.component.anim.TKBasicAnimationFactory;
import com.tachikoma.core.component.anim.TKKeyframeAnimationFactory;
import com.tachikoma.core.component.anim.TKSpringAnimationFactory;
import com.tachikoma.core.component.button.TKButtonFactory;
import com.tachikoma.core.component.imageview.TKImageFactory;
import com.tachikoma.core.component.input.TKInputFactory;
import com.tachikoma.core.component.input.TKTextAreaFactory;
import com.tachikoma.core.component.listview.TKBaseAdapterFactory;
import com.tachikoma.core.component.listview.TKCollectionAdapterFactory;
import com.tachikoma.core.component.listview.TKIndicatorFactory;
import com.tachikoma.core.component.listview.TKListViewFactory;
import com.tachikoma.core.component.listview.TKRecyclerViewFactory;
import com.tachikoma.core.component.listview.TKViewPagerAdapterFactory;
import com.tachikoma.core.component.listview.TKViewPagerFactory;
import com.tachikoma.core.component.listview.TKWaterListViewFactory;
import com.tachikoma.core.component.network.NetworkErrorFactory;
import com.tachikoma.core.component.network.NetworkFactory;
import com.tachikoma.core.component.progressbar.KTProgressBarViewFactory;
import com.tachikoma.core.component.recyclerview.export.TKRefreshAnimatableViewFactory;
import com.tachikoma.core.component.recyclerview.export.TKRefreshControlFactory;
import com.tachikoma.core.component.switchview.TKSwitchFactory;
import com.tachikoma.core.component.text.SpanItemFactory;
import com.tachikoma.core.component.text.TKMarqueeTextFactory;
import com.tachikoma.core.component.text.TKSpanFactory;
import com.tachikoma.core.component.text.TKTextFactory;
import com.tachikoma.core.component.toast.TKToastFactory;
import com.tachikoma.core.component.view.TKViewFactory;
import com.tachikoma.core.event.base.TKBaseEventFactory;
import com.tachikoma.core.event.guesture.TKDispatchEventFactory;
import com.tachikoma.core.event.guesture.TKDownEventFactory;
import com.tachikoma.core.event.guesture.TKLongPressEventFactory;
import com.tachikoma.core.event.guesture.TKPanEventFactory;
import com.tachikoma.core.event.guesture.TKPinchEventFactory;
import com.tachikoma.core.event.guesture.TKSwipeEventFactory;
import com.tachikoma.core.event.guesture.TKTapEventFactory;
import com.tachikoma.core.event.guesture.TKUpEventFactory;
import com.tachikoma.core.event.view.TKInputEventFactory;
import com.tachikoma.core.event.view.TKScrollEventFactory;
import com.tachikoma.core.event.view.TKSwitchEventFactory;
import com.tachikoma.core.manager.IProvider;
import com.tachikoma.core.module.TKBaseBridgeFactory;
import com.tachikoma.core.module.TKBusinessSchoolBridgeFactory;
import com.tachikoma.core.module.TKWebCardBridgeImplFactory;
import com.tachikoma.core.module.handler.TKLifeCycleFactory;
import com.tachikoma.core.router.TKRouterFactory;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class FactoryProvider implements IProvider<IFactory> {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, IFactory> factoryMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1985141302, "Lcom/tachikoma/core/FactoryProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1985141302, "Lcom/tachikoma/core/FactoryProvider;");
                return;
            }
        }
        factoryMap = new HashMap<>(59);
    }

    public FactoryProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void registerExternal(String str, IFactory iFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, iFactory) == null) {
            factoryMap.put(str, iFactory);
        }
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
            factoryMap.clear();
        }
    }

    @Override // com.tachikoma.core.manager.IProvider
    public HashMap<String, String> get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.tachikoma.core.manager.IProvider
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            factoryMap.put("com.tachikoma.core.event.guesture.TKDownEvent", new TKDownEventFactory());
            factoryMap.put("com.tachikoma.core.component.recyclerview.export.TKRefreshAnimatableView", new TKRefreshAnimatableViewFactory());
            factoryMap.put("com.tachikoma.core.event.guesture.TKSwipeEvent", new TKSwipeEventFactory());
            factoryMap.put("com.tachikoma.core.module.TKBaseBridge", new TKBaseBridgeFactory());
            factoryMap.put("com.tachikoma.core.component.network.NetworkError", new NetworkErrorFactory());
            factoryMap.put("com.tachikoma.core.module.TKWebCardBridgeImpl", new TKWebCardBridgeImplFactory());
            factoryMap.put("com.tachikoma.core.event.guesture.TKUpEvent", new TKUpEventFactory());
            factoryMap.put("com.tachikoma.core.event.guesture.TKPinchEvent", new TKPinchEventFactory());
            factoryMap.put("com.tachikoma.core.component.listview.TKCollectionAdapter", new TKCollectionAdapterFactory());
            factoryMap.put("com.tachikoma.core.component.input.TKTextArea", new TKTextAreaFactory());
            factoryMap.put("com.tachikoma.core.component.recyclerview.export.TKRefreshControl", new TKRefreshControlFactory());
            factoryMap.put("com.tachikoma.core.event.view.TKInputEvent", new TKInputEventFactory());
            factoryMap.put("com.tachikoma.core.component.anim.TKSpringAnimation", new TKSpringAnimationFactory());
            factoryMap.put("com.tachikoma.core.module.handler.TKLifeCycle", new TKLifeCycleFactory());
            factoryMap.put("com.tachikoma.core.component.anim.TKKeyframeAnimation", new TKKeyframeAnimationFactory());
            factoryMap.put("com.tachikoma.core.component.toast.TKToast", new TKToastFactory());
            factoryMap.put("com.tachikoma.core.component.input.TKInput", new TKInputFactory());
            factoryMap.put("com.tachikoma.core.component.listview.TKRecyclerView", new TKRecyclerViewFactory());
            factoryMap.put("com.tachikoma.core.component.imageview.TKImage", new TKImageFactory());
            factoryMap.put("com.tachikoma.core.router.TKRouter", new TKRouterFactory());
            factoryMap.put("com.tachikoma.core.component.listview.TKViewPager", new TKViewPagerFactory());
            factoryMap.put("com.tachikoma.core.component.text.TKMarqueeText", new TKMarqueeTextFactory());
            factoryMap.put("com.tachikoma.core.event.base.TKBaseEvent", new TKBaseEventFactory());
            factoryMap.put("com.tachikoma.core.event.guesture.TKPanEvent", new TKPanEventFactory());
            factoryMap.put("com.tachikoma.core.event.guesture.TKDispatchEvent", new TKDispatchEventFactory());
            factoryMap.put("com.tachikoma.core.component.text.TKText", new TKTextFactory());
            factoryMap.put("com.tachikoma.core.component.view.TKView", new TKViewFactory());
            factoryMap.put("com.tachikoma.core.component.button.TKButton", new TKButtonFactory());
            factoryMap.put("com.tachikoma.core.module.TKBusinessSchoolBridge", new TKBusinessSchoolBridgeFactory());
            factoryMap.put("com.tachikoma.core.event.guesture.TKTapEvent", new TKTapEventFactory());
            factoryMap.put("com.tachikoma.core.component.text.TKSpan", new TKSpanFactory());
            factoryMap.put("com.tachikoma.core.component.listview.TKBaseAdapter", new TKBaseAdapterFactory());
            factoryMap.put("com.tachikoma.core.component.switchview.TKSwitch", new TKSwitchFactory());
            factoryMap.put("com.tachikoma.core.component.listview.TKWaterListView", new TKWaterListViewFactory());
            factoryMap.put("com.tachikoma.core.component.anim.TKBasicAnimation", new TKBasicAnimationFactory());
            factoryMap.put("com.tachikoma.core.component.network.Network", new NetworkFactory());
            factoryMap.put("com.tachikoma.core.component.listview.TKListView", new TKListViewFactory());
            factoryMap.put("com.tachikoma.core.event.view.TKSwitchEvent", new TKSwitchEventFactory());
            factoryMap.put("com.tachikoma.core.event.guesture.TKLongPressEvent", new TKLongPressEventFactory());
            factoryMap.put("com.tachikoma.core.component.listview.TKIndicator", new TKIndicatorFactory());
            factoryMap.put("com.tachikoma.core.component.listview.TKViewPagerAdapter", new TKViewPagerAdapterFactory());
            factoryMap.put("com.tachikoma.core.component.progressbar.KTProgressBarView", new KTProgressBarViewFactory());
            factoryMap.put("com.tachikoma.core.event.view.TKScrollEvent", new TKScrollEventFactory());
            factoryMap.put("com.tachikoma.core.component.text.SpanItem", new SpanItemFactory());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tachikoma.core.manager.IProvider
    public IFactory of(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? factoryMap.get(str) : (IFactory) invokeL.objValue;
    }

    @Override // com.tachikoma.core.manager.IProvider
    public HashMap<String, Object> retrieveEvent(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, obj)) == null) {
            return null;
        }
        return (HashMap) invokeLL.objValue;
    }
}
