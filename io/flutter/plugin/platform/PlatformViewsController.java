package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class PlatformViewsController implements PlatformViewsAccessibilityDelegate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MINIMAL_SDK = 20;
    public static final String TAG = "PlatformViewsController";
    public transient /* synthetic */ FieldHolder $fh;
    public final AccessibilityEventsDelegate accessibilityEventsDelegate;
    public final PlatformViewsChannel.PlatformViewsHandler channelHandler;
    public Context context;
    public final HashMap<Context, View> contextToPlatformView;
    public View flutterView;
    public PlatformViewsChannel platformViewsChannel;
    public final PlatformViewRegistryImpl registry;
    public TextInputPlugin textInputPlugin;
    public TextureRegistry textureRegistry;
    @VisibleForTesting
    public final HashMap<Integer, VirtualDisplayController> vdControllers;

    /* renamed from: io.flutter.plugin.platform.PlatformViewsController$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass1 implements PlatformViewsChannel.PlatformViewsHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlatformViewsController this$0;

        public AnonymousClass1(PlatformViewsController platformViewsController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {platformViewsController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = platformViewsController;
        }

        private void ensureValidAndroidVersion() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || Build.VERSION.SDK_INT >= 20) {
                return;
            }
            throw new IllegalStateException("Trying to use platform views with API " + Build.VERSION.SDK_INT + ", required API level is: 20");
        }

        public /* synthetic */ void a(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest, View view, boolean z) {
            if (z) {
                this.this$0.platformViewsChannel.invokeViewFocused(platformViewCreationRequest.viewId);
            }
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void clearFocus(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.this$0.vdControllers.get(Integer.valueOf(i2)).getView().clearFocus();
            }
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        @TargetApi(17)
        public long createPlatformView(@NonNull final PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, platformViewCreationRequest)) == null) {
                ensureValidAndroidVersion();
                if (PlatformViewsController.validateDirection(platformViewCreationRequest.direction)) {
                    if (!this.this$0.vdControllers.containsKey(Integer.valueOf(platformViewCreationRequest.viewId))) {
                        PlatformViewFactory factory = this.this$0.registry.getFactory(platformViewCreationRequest.viewType);
                        if (factory != null) {
                            Object decodeMessage = platformViewCreationRequest.params != null ? factory.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params) : null;
                            int physicalPixels = this.this$0.toPhysicalPixels(platformViewCreationRequest.logicalWidth);
                            int physicalPixels2 = this.this$0.toPhysicalPixels(platformViewCreationRequest.logicalHeight);
                            this.this$0.validateVirtualDisplayDimensions(physicalPixels, physicalPixels2);
                            TextureRegistry.SurfaceTextureEntry createSurfaceTexture = this.this$0.textureRegistry.createSurfaceTexture();
                            VirtualDisplayController create = VirtualDisplayController.create(this.this$0.context, this.this$0.accessibilityEventsDelegate, factory, createSurfaceTexture, physicalPixels, physicalPixels2, platformViewCreationRequest.viewId, decodeMessage, new View.OnFocusChangeListener() { // from class: f.a.b.a.a
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                @Override // android.view.View.OnFocusChangeListener
                                public final void onFocusChange(View view, boolean z) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, view, z) == null) {
                                        PlatformViewsController.AnonymousClass1.this.a(platformViewCreationRequest, view, z);
                                    }
                                }
                            });
                            if (create != null) {
                                if (this.this$0.flutterView != null) {
                                    create.onFlutterViewAttached(this.this$0.flutterView);
                                }
                                this.this$0.vdControllers.put(Integer.valueOf(platformViewCreationRequest.viewId), create);
                                View view = create.getView();
                                view.setLayoutDirection(platformViewCreationRequest.direction);
                                this.this$0.contextToPlatformView.put(view.getContext(), view);
                                return createSurfaceTexture.id();
                            }
                            throw new IllegalStateException("Failed creating virtual display for a " + platformViewCreationRequest.viewType + " with id: " + platformViewCreationRequest.viewId);
                        }
                        throw new IllegalStateException("Trying to create a platform view of unregistered type: " + platformViewCreationRequest.viewType);
                    }
                    throw new IllegalStateException("Trying to create an already created platform view, view id: " + platformViewCreationRequest.viewId);
                }
                throw new IllegalStateException("Trying to create a view with unknown direction value: " + platformViewCreationRequest.direction + "(view id: " + platformViewCreationRequest.viewId + SmallTailInfo.EMOTION_SUFFIX);
            }
            return invokeL.longValue;
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void disposePlatformView(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                ensureValidAndroidVersion();
                VirtualDisplayController virtualDisplayController = this.this$0.vdControllers.get(Integer.valueOf(i2));
                if (virtualDisplayController != null) {
                    if (this.this$0.textInputPlugin != null) {
                        this.this$0.textInputPlugin.clearPlatformViewClient(i2);
                    }
                    this.this$0.contextToPlatformView.remove(virtualDisplayController.getView().getContext());
                    virtualDisplayController.dispose();
                    this.this$0.vdControllers.remove(Integer.valueOf(i2));
                    return;
                }
                throw new IllegalStateException("Trying to dispose a platform view with unknown id: " + i2);
            }
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void onTouch(@NonNull PlatformViewsChannel.PlatformViewTouch platformViewTouch) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, platformViewTouch) == null) {
                ensureValidAndroidVersion();
                float f2 = this.this$0.context.getResources().getDisplayMetrics().density;
                MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) PlatformViewsController.parsePointerPropertiesList(platformViewTouch.rawPointerPropertiesList).toArray(new MotionEvent.PointerProperties[platformViewTouch.pointerCount]);
                MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) PlatformViewsController.parsePointerCoordsList(platformViewTouch.rawPointerCoords, f2).toArray(new MotionEvent.PointerCoords[platformViewTouch.pointerCount]);
                if (this.this$0.vdControllers.containsKey(Integer.valueOf(platformViewTouch.viewId))) {
                    this.this$0.vdControllers.get(Integer.valueOf(platformViewTouch.viewId)).getView().dispatchTouchEvent(MotionEvent.obtain(platformViewTouch.downTime.longValue(), platformViewTouch.eventTime.longValue(), platformViewTouch.action, platformViewTouch.pointerCount, pointerPropertiesArr, pointerCoordsArr, platformViewTouch.metaState, platformViewTouch.buttonState, platformViewTouch.xPrecision, platformViewTouch.yPrecision, platformViewTouch.deviceId, platformViewTouch.edgeFlags, platformViewTouch.source, platformViewTouch.flags));
                    return;
                }
                throw new IllegalStateException("Sending touch to an unknown view with id: " + platformViewTouch.viewId);
            }
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void resizePlatformView(@NonNull PlatformViewsChannel.PlatformViewResizeRequest platformViewResizeRequest, @NonNull Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, platformViewResizeRequest, runnable) == null) {
                ensureValidAndroidVersion();
                VirtualDisplayController virtualDisplayController = this.this$0.vdControllers.get(Integer.valueOf(platformViewResizeRequest.viewId));
                if (virtualDisplayController != null) {
                    int physicalPixels = this.this$0.toPhysicalPixels(platformViewResizeRequest.newLogicalWidth);
                    int physicalPixels2 = this.this$0.toPhysicalPixels(platformViewResizeRequest.newLogicalHeight);
                    this.this$0.validateVirtualDisplayDimensions(physicalPixels, physicalPixels2);
                    this.this$0.lockInputConnection(virtualDisplayController);
                    virtualDisplayController.resize(physicalPixels, physicalPixels2, new Runnable(this, virtualDisplayController, runnable) { // from class: io.flutter.plugin.platform.PlatformViewsController.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;
                        public final /* synthetic */ Runnable val$onComplete;
                        public final /* synthetic */ VirtualDisplayController val$vdController;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, virtualDisplayController, runnable};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$vdController = virtualDisplayController;
                            this.val$onComplete = runnable;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$1.this$0.unlockInputConnection(this.val$vdController);
                                this.val$onComplete.run();
                            }
                        }
                    });
                    return;
                }
                throw new IllegalStateException("Trying to resize a platform view with unknown id: " + platformViewResizeRequest.viewId);
            }
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        @TargetApi(17)
        public void setDirection(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
                ensureValidAndroidVersion();
                if (PlatformViewsController.validateDirection(i3)) {
                    View view = this.this$0.vdControllers.get(Integer.valueOf(i2)).getView();
                    if (view != null) {
                        view.setLayoutDirection(i3);
                        return;
                    }
                    throw new IllegalStateException("Sending touch to an unknown view with id: " + i3);
                }
                throw new IllegalStateException("Trying to set unknown direction value: " + i3 + "(view id: " + i2 + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
    }

    public PlatformViewsController() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.channelHandler = new AnonymousClass1(this);
        this.registry = new PlatformViewRegistryImpl();
        this.vdControllers = new HashMap<>();
        this.accessibilityEventsDelegate = new AccessibilityEventsDelegate();
        this.contextToPlatformView = new HashMap<>();
    }

    private void flushAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            for (VirtualDisplayController virtualDisplayController : this.vdControllers.values()) {
                virtualDisplayController.dispose();
            }
            this.vdControllers.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lockInputConnection(@NonNull VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, this, virtualDisplayController) == null) || (textInputPlugin = this.textInputPlugin) == null) {
            return;
        }
        textInputPlugin.lockPlatformViewInputConnection();
        virtualDisplayController.onInputConnectionLocked();
    }

    public static MotionEvent.PointerCoords parsePointerCoords(Object obj, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65554, null, obj, f2)) == null) {
            List list = (List) obj;
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
            pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
            pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
            pointerCoords.toolMajor = ((float) ((Double) list.get(3)).doubleValue()) * f2;
            pointerCoords.toolMinor = ((float) ((Double) list.get(4)).doubleValue()) * f2;
            pointerCoords.touchMajor = ((float) ((Double) list.get(5)).doubleValue()) * f2;
            pointerCoords.touchMinor = ((float) ((Double) list.get(6)).doubleValue()) * f2;
            pointerCoords.x = ((float) ((Double) list.get(7)).doubleValue()) * f2;
            pointerCoords.y = ((float) ((Double) list.get(8)).doubleValue()) * f2;
            return pointerCoords;
        }
        return (MotionEvent.PointerCoords) invokeLF.objValue;
    }

    public static List<MotionEvent.PointerCoords> parsePointerCoordsList(Object obj, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65555, null, obj, f2)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (List) obj) {
                arrayList.add(parsePointerCoords(obj2, f2));
            }
            return arrayList;
        }
        return (List) invokeLF.objValue;
    }

    public static MotionEvent.PointerProperties parsePointerProperties(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, obj)) == null) {
            List list = (List) obj;
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerProperties.id = ((Integer) list.get(0)).intValue();
            pointerProperties.toolType = ((Integer) list.get(1)).intValue();
            return pointerProperties;
        }
        return (MotionEvent.PointerProperties) invokeL.objValue;
    }

    public static List<MotionEvent.PointerProperties> parsePointerPropertiesList(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, obj)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (List) obj) {
                arrayList.add(parsePointerProperties(obj2));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int toPhysicalPixels(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, this, new Object[]{Double.valueOf(d2)})) == null) ? (int) Math.round(d2 * this.context.getResources().getDisplayMetrics().density) : invokeCommon.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unlockInputConnection(@NonNull VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, this, virtualDisplayController) == null) || (textInputPlugin = this.textInputPlugin) == null) {
            return;
        }
        textInputPlugin.unlockPlatformViewInputConnection();
        virtualDisplayController.onInputConnectionUnlocked();
    }

    public static boolean validateDirection(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65560, null, i2)) == null) ? i2 == 0 || i2 == 1 : invokeI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateVirtualDisplayDimensions(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65561, this, i2, i3) == null) {
            DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
            if (i3 > displayMetrics.heightPixels || i2 > displayMetrics.widthPixels) {
                Log.w("PlatformViewsController", "Creating a virtual display of size: [" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + "] may result in problems(https://github.com/flutter/flutter/issues/2897).It is larger than the device screen size: [" + displayMetrics.widthPixels + StringUtil.ARRAY_ELEMENT_SEPARATOR + displayMetrics.heightPixels + "].");
            }
        }
    }

    public void attach(Context context, TextureRegistry textureRegistry, @NonNull DartExecutor dartExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, textureRegistry, dartExecutor) == null) {
            if (this.context == null) {
                this.context = context;
                this.textureRegistry = textureRegistry;
                PlatformViewsChannel platformViewsChannel = new PlatformViewsChannel(dartExecutor);
                this.platformViewsChannel = platformViewsChannel;
                platformViewsChannel.setPlatformViewsHandler(this.channelHandler);
                return;
            }
            throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
        }
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public void attachAccessibilityBridge(AccessibilityBridge accessibilityBridge) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accessibilityBridge) == null) {
            this.accessibilityEventsDelegate.setAccessibilityBridge(accessibilityBridge);
        }
    }

    public void attachTextInputPlugin(TextInputPlugin textInputPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, textInputPlugin) == null) {
            this.textInputPlugin = textInputPlugin;
        }
    }

    public void attachToView(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.flutterView = view;
            for (VirtualDisplayController virtualDisplayController : this.vdControllers.values()) {
                virtualDisplayController.onFlutterViewAttached(view);
            }
        }
    }

    public boolean checkInputConnectionProxy(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            if (this.contextToPlatformView.containsKey(view.getContext())) {
                View view2 = this.contextToPlatformView.get(view.getContext());
                if (view2 == view) {
                    return true;
                }
                return view2.checkInputConnectionProxy(view);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public void detach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.platformViewsChannel.setPlatformViewsHandler(null);
            this.platformViewsChannel = null;
            this.context = null;
            this.textureRegistry = null;
        }
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public void detachAccessibiltyBridge() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.accessibilityEventsDelegate.setAccessibilityBridge(null);
        }
    }

    public void detachFromView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.flutterView = null;
            for (VirtualDisplayController virtualDisplayController : this.vdControllers.values()) {
                virtualDisplayController.onFlutterViewDetached();
            }
        }
    }

    public void detachTextInputPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.textInputPlugin = null;
        }
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public View getPlatformViewById(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, num)) == null) {
            VirtualDisplayController virtualDisplayController = this.vdControllers.get(num);
            if (virtualDisplayController == null) {
                return null;
            }
            return virtualDisplayController.getView();
        }
        return (View) invokeL.objValue;
    }

    public PlatformViewRegistry getRegistry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.registry : (PlatformViewRegistry) invokeV.objValue;
    }

    public void onFlutterViewDestroyed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            flushAllViews();
        }
    }

    public void onPreEngineRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            flushAllViews();
        }
    }
}
