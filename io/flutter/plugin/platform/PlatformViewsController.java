package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import io.flutter.Log;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.MotionEventTracker;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes8.dex */
public class PlatformViewsController implements PlatformViewsAccessibilityDelegate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PlatformViewsController";
    public transient /* synthetic */ FieldHolder $fh;
    public final AccessibilityEventsDelegate accessibilityEventsDelegate;
    public AndroidTouchProcessor androidTouchProcessor;
    public final PlatformViewsChannel.PlatformViewsHandler channelHandler;
    public Context context;
    public final HashMap<Context, View> contextToPlatformView;
    public HashSet<Integer> currentFrameUsedOverlayLayerIds;
    public HashSet<Integer> currentFrameUsedPlatformViewIds;
    public View flutterView;
    public boolean flutterViewConvertedToImageView;
    public final MotionEventTracker motionEventTracker;
    public int nextOverlayLayerId;
    public final SparseArray<FlutterImageView> overlayLayerViews;
    public final SparseArray<FlutterMutatorView> platformViewParent;
    public final SparseArray<PlatformView> platformViews;
    public PlatformViewsChannel platformViewsChannel;
    public final PlatformViewRegistryImpl registry;
    public boolean synchronizeToNativeViewHierarchy;
    @Nullable
    public TextInputPlugin textInputPlugin;
    public TextureRegistry textureRegistry;
    @VisibleForTesting
    public final HashMap<Integer, VirtualDisplayController> vdControllers;

    /* renamed from: io.flutter.plugin.platform.PlatformViewsController$1  reason: invalid class name */
    /* loaded from: classes8.dex */
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

        private void ensureValidAndroidVersion(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(65537, this, i2) == null) || Build.VERSION.SDK_INT >= i2) {
                return;
            }
            throw new IllegalStateException("Trying to use platform views with API " + Build.VERSION.SDK_INT + ", required API level is: " + i2);
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
                PlatformView platformView = (PlatformView) this.this$0.platformViews.get(i2);
                if (platformView != null) {
                    platformView.getView().clearFocus();
                    return;
                }
                ensureValidAndroidVersion(20);
                this.this$0.vdControllers.get(Integer.valueOf(i2)).getView().clearFocus();
            }
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void createAndroidViewForPlatformView(@NonNull PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, platformViewCreationRequest) == null) {
                ensureValidAndroidVersion(19);
                if (PlatformViewsController.validateDirection(platformViewCreationRequest.direction)) {
                    PlatformViewFactory factory = this.this$0.registry.getFactory(platformViewCreationRequest.viewType);
                    if (factory != null) {
                        this.this$0.platformViews.put(platformViewCreationRequest.viewId, factory.create(this.this$0.context, platformViewCreationRequest.viewId, platformViewCreationRequest.params != null ? factory.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params) : null));
                        return;
                    }
                    throw new IllegalStateException("Trying to create a platform view of unregistered type: " + platformViewCreationRequest.viewType);
                }
                throw new IllegalStateException("Trying to create a view with unknown direction value: " + platformViewCreationRequest.direction + "(view id: " + platformViewCreationRequest.viewId + SmallTailInfo.EMOTION_SUFFIX);
            }
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        @TargetApi(17)
        public long createVirtualDisplayForPlatformView(@NonNull final PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, platformViewCreationRequest)) == null) {
                ensureValidAndroidVersion(20);
                if (PlatformViewsController.validateDirection(platformViewCreationRequest.direction)) {
                    if (!this.this$0.vdControllers.containsKey(Integer.valueOf(platformViewCreationRequest.viewId))) {
                        PlatformViewFactory factory = this.this$0.registry.getFactory(platformViewCreationRequest.viewType);
                        if (factory != null) {
                            Object decodeMessage = platformViewCreationRequest.params != null ? factory.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params) : null;
                            int physicalPixels = this.this$0.toPhysicalPixels(platformViewCreationRequest.logicalWidth);
                            int physicalPixels2 = this.this$0.toPhysicalPixels(platformViewCreationRequest.logicalHeight);
                            this.this$0.validateVirtualDisplayDimensions(physicalPixels, physicalPixels2);
                            TextureRegistry.SurfaceTextureEntry createSurfaceTexture = this.this$0.textureRegistry.createSurfaceTexture();
                            VirtualDisplayController create = VirtualDisplayController.create(this.this$0.context, this.this$0.accessibilityEventsDelegate, factory, createSurfaceTexture, physicalPixels, physicalPixels2, platformViewCreationRequest.viewId, decodeMessage, new View.OnFocusChangeListener() { // from class: g.a.b.a.a
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
        public void disposeAndroidViewForPlatformView(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                PlatformView platformView = (PlatformView) this.this$0.platformViews.get(i2);
                FlutterMutatorView flutterMutatorView = (FlutterMutatorView) this.this$0.platformViewParent.get(i2);
                if (platformView != null) {
                    if (flutterMutatorView != null) {
                        flutterMutatorView.removeView(platformView.getView());
                    }
                    this.this$0.platformViews.remove(i2);
                    platformView.dispose();
                }
                if (flutterMutatorView != null) {
                    flutterMutatorView.unsetOnDescendantFocusChangeListener();
                    ((ViewGroup) flutterMutatorView.getParent()).removeView(flutterMutatorView);
                    this.this$0.platformViewParent.remove(i2);
                }
            }
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void disposeVirtualDisplayForPlatformView(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                ensureValidAndroidVersion(20);
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
            if (interceptable == null || interceptable.invokeL(1048582, this, platformViewTouch) == null) {
                int i2 = platformViewTouch.viewId;
                float f2 = this.this$0.context.getResources().getDisplayMetrics().density;
                ensureValidAndroidVersion(20);
                if (!this.this$0.vdControllers.containsKey(Integer.valueOf(i2))) {
                    if (this.this$0.platformViews.get(i2) != null) {
                        MotionEvent motionEvent = this.this$0.toMotionEvent(f2, platformViewTouch, false);
                        View view = ((PlatformView) this.this$0.platformViews.get(platformViewTouch.viewId)).getView();
                        if (view != null) {
                            view.dispatchTouchEvent(motionEvent);
                            return;
                        }
                        return;
                    }
                    throw new IllegalStateException("Sending touch to an unknown view with id: " + i2);
                }
                this.this$0.vdControllers.get(Integer.valueOf(platformViewTouch.viewId)).dispatchTouchEvent(this.this$0.toMotionEvent(f2, platformViewTouch, true));
            }
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void resizePlatformView(@NonNull PlatformViewsChannel.PlatformViewResizeRequest platformViewResizeRequest, @NonNull Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, platformViewResizeRequest, runnable) == null) {
                ensureValidAndroidVersion(20);
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
            if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
                if (PlatformViewsController.validateDirection(i3)) {
                    ensureValidAndroidVersion(20);
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

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void synchronizeToNativeViewHierarchy(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                this.this$0.synchronizeToNativeViewHierarchy = z;
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
        this.nextOverlayLayerId = 0;
        this.flutterViewConvertedToImageView = false;
        this.synchronizeToNativeViewHierarchy = true;
        this.channelHandler = new AnonymousClass1(this);
        this.registry = new PlatformViewRegistryImpl();
        this.vdControllers = new HashMap<>();
        this.accessibilityEventsDelegate = new AccessibilityEventsDelegate();
        this.contextToPlatformView = new HashMap<>();
        this.overlayLayerViews = new SparseArray<>();
        this.currentFrameUsedOverlayLayerIds = new HashSet<>();
        this.currentFrameUsedPlatformViewIds = new HashSet<>();
        this.platformViews = new SparseArray<>();
        this.platformViewParent = new SparseArray<>();
        this.motionEventTracker = MotionEventTracker.getInstance();
    }

    private void finishFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, this, z) == null) {
            for (int i2 = 0; i2 < this.overlayLayerViews.size(); i2++) {
                int keyAt = this.overlayLayerViews.keyAt(i2);
                FlutterImageView valueAt = this.overlayLayerViews.valueAt(i2);
                if (this.currentFrameUsedOverlayLayerIds.contains(Integer.valueOf(keyAt))) {
                    ((FlutterView) this.flutterView).attachOverlaySurfaceToRender(valueAt);
                    z &= valueAt.acquireLatestImage();
                } else {
                    if (!this.flutterViewConvertedToImageView) {
                        valueAt.detachFromRenderer();
                    }
                    valueAt.setVisibility(8);
                }
            }
            for (int i3 = 0; i3 < this.platformViewParent.size(); i3++) {
                int keyAt2 = this.platformViewParent.keyAt(i3);
                FlutterMutatorView flutterMutatorView = this.platformViewParent.get(keyAt2);
                if (this.currentFrameUsedPlatformViewIds.contains(Integer.valueOf(keyAt2)) && (z || !this.synchronizeToNativeViewHierarchy)) {
                    flutterMutatorView.setVisibility(0);
                } else {
                    flutterMutatorView.setVisibility(8);
                }
            }
        }
    }

    private void flushAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            for (VirtualDisplayController virtualDisplayController : this.vdControllers.values()) {
                virtualDisplayController.dispose();
            }
            this.vdControllers.clear();
            while (this.platformViews.size() > 0) {
                this.channelHandler.disposeAndroidViewForPlatformView(this.platformViews.keyAt(0));
            }
        }
    }

    private float getDisplayDensity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? this.context.getResources().getDisplayMetrics().density : invokeV.floatValue;
    }

    private void initializeRootImageViewIfNeeded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, this) == null) && this.synchronizeToNativeViewHierarchy && !this.flutterViewConvertedToImageView) {
            ((FlutterView) this.flutterView).convertToImageView();
            this.flutterViewConvertedToImageView = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lockInputConnection(@NonNull VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, this, virtualDisplayController) == null) || (textInputPlugin = this.textInputPlugin) == null) {
            return;
        }
        textInputPlugin.lockPlatformViewInputConnection();
        virtualDisplayController.onInputConnectionLocked();
    }

    public static MotionEvent.PointerCoords parsePointerCoords(Object obj, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65558, null, obj, f2)) == null) {
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
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65559, null, obj, f2)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, obj)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, obj)) == null) {
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65562, this, new Object[]{Double.valueOf(d2)})) == null) ? (int) Math.round(d2 * getDisplayDensity()) : invokeCommon.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unlockInputConnection(@NonNull VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65563, this, virtualDisplayController) == null) || (textInputPlugin = this.textInputPlugin) == null) {
            return;
        }
        textInputPlugin.unlockPlatformViewInputConnection();
        virtualDisplayController.onInputConnectionUnlocked();
    }

    public static boolean validateDirection(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65564, null, i2)) == null) ? i2 == 0 || i2 == 1 : invokeI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateVirtualDisplayDimensions(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65565, this, i2, i3) == null) {
            DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
            if (i3 > displayMetrics.heightPixels || i2 > displayMetrics.widthPixels) {
                Log.w("PlatformViewsController", "Creating a virtual display of size: [" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + "] may result in problems(https://github.com/flutter/flutter/issues/2897).It is larger than the device screen size: [" + displayMetrics.widthPixels + StringUtil.ARRAY_ELEMENT_SEPARATOR + displayMetrics.heightPixels + "].");
            }
        }
    }

    public /* synthetic */ void a(int i2, View view, boolean z) {
        if (z) {
            this.platformViewsChannel.invokeViewFocused(i2);
            return;
        }
        TextInputPlugin textInputPlugin = this.textInputPlugin;
        if (textInputPlugin != null) {
            textInputPlugin.clearPlatformViewClient(i2);
        }
    }

    public void attach(Context context, TextureRegistry textureRegistry, @NonNull DartExecutor dartExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, textureRegistry, dartExecutor) == null) {
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
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accessibilityBridge) == null) {
            this.accessibilityEventsDelegate.setAccessibilityBridge(accessibilityBridge);
        }
    }

    public void attachTextInputPlugin(TextInputPlugin textInputPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, textInputPlugin) == null) {
            this.textInputPlugin = textInputPlugin;
        }
    }

    public void attachToFlutterRenderer(FlutterRenderer flutterRenderer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, flutterRenderer) == null) {
            this.androidTouchProcessor = new AndroidTouchProcessor(flutterRenderer, true);
        }
    }

    public void attachToView(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.flutterView = view;
            for (VirtualDisplayController virtualDisplayController : this.vdControllers.values()) {
                virtualDisplayController.onFlutterViewAttached(view);
            }
        }
    }

    public /* synthetic */ void b() {
        finishFrame(false);
    }

    public boolean checkInputConnectionProxy(@Nullable View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
            if (view != null && this.contextToPlatformView.containsKey(view.getContext())) {
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

    @TargetApi(19)
    @VisibleForTesting
    public FlutterOverlaySurface createOverlaySurface(@NonNull FlutterImageView flutterImageView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, flutterImageView)) == null) {
            int i2 = this.nextOverlayLayerId;
            this.nextOverlayLayerId = i2 + 1;
            this.overlayLayerViews.put(i2, flutterImageView);
            return new FlutterOverlaySurface(i2, flutterImageView.getSurface());
        }
        return (FlutterOverlaySurface) invokeL.objValue;
    }

    public void destroyOverlaySurfaces() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            for (int i2 = 0; i2 < this.overlayLayerViews.size(); i2++) {
                this.overlayLayerViews.keyAt(i2);
                FlutterImageView valueAt = this.overlayLayerViews.valueAt(i2);
                valueAt.detachFromRenderer();
                View view = this.flutterView;
                if (view != null) {
                    ((FlutterView) view).removeView(valueAt);
                }
            }
            this.overlayLayerViews.clear();
        }
    }

    @UiThread
    public void detach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PlatformViewsChannel platformViewsChannel = this.platformViewsChannel;
            if (platformViewsChannel != null) {
                platformViewsChannel.setPlatformViewsHandler(null);
            }
            destroyOverlaySurfaces();
            this.platformViewsChannel = null;
            this.context = null;
            this.textureRegistry = null;
        }
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public void detachAccessibiltyBridge() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.accessibilityEventsDelegate.setAccessibilityBridge(null);
        }
    }

    public void detachFromView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            destroyOverlaySurfaces();
            this.flutterView = null;
            for (VirtualDisplayController virtualDisplayController : this.vdControllers.values()) {
                virtualDisplayController.onFlutterViewDetached();
            }
        }
    }

    public void detachTextInputPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.textInputPlugin = null;
        }
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public View getPlatformViewById(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, num)) == null) {
            if (this.platformViews.get(num.intValue()) != null) {
                return this.platformViews.get(num.intValue()).getView();
            }
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.registry : (PlatformViewRegistry) invokeV.objValue;
    }

    @VisibleForTesting
    public void initializePlatformViewIfNeeded(final int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            PlatformView platformView = this.platformViews.get(i2);
            if (platformView != null) {
                if (this.platformViewParent.get(i2) != null) {
                    return;
                }
                if (platformView.getView() != null) {
                    if (platformView.getView().getParent() == null) {
                        Context context = this.context;
                        FlutterMutatorView flutterMutatorView = new FlutterMutatorView(context, context.getResources().getDisplayMetrics().density, this.androidTouchProcessor);
                        flutterMutatorView.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: g.a.b.a.c
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnFocusChangeListener
                            public final void onFocusChange(View view, boolean z) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, view, z) == null) {
                                    PlatformViewsController.this.a(i2, view, z);
                                }
                            }
                        });
                        this.platformViewParent.put(i2, flutterMutatorView);
                        flutterMutatorView.addView(platformView.getView());
                        ((FlutterView) this.flutterView).addView(flutterMutatorView);
                        return;
                    }
                    throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
                }
                throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
            }
            throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
        }
    }

    public void onAttachedToJNI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public void onBeginFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.currentFrameUsedOverlayLayerIds.clear();
            this.currentFrameUsedPlatformViewIds.clear();
        }
    }

    public void onDetachedFromJNI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            flushAllViews();
        }
    }

    public void onDisplayOverlaySurface(int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            if (this.overlayLayerViews.get(i2) != null) {
                initializeRootImageViewIfNeeded();
                FlutterImageView flutterImageView = this.overlayLayerViews.get(i2);
                if (flutterImageView.getParent() == null) {
                    ((FlutterView) this.flutterView).addView(flutterImageView);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i6);
                layoutParams.leftMargin = i3;
                layoutParams.topMargin = i4;
                flutterImageView.setLayoutParams(layoutParams);
                flutterImageView.setVisibility(0);
                flutterImageView.bringToFront();
                this.currentFrameUsedOverlayLayerIds.add(Integer.valueOf(i2));
                return;
            }
            throw new IllegalStateException("The overlay surface (id:" + i2 + ") doesn't exist");
        }
    }

    public void onDisplayPlatformView(int i2, int i3, int i4, int i5, int i6, int i7, int i8, FlutterMutatorsStack flutterMutatorsStack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), flutterMutatorsStack}) == null) {
            initializeRootImageViewIfNeeded();
            initializePlatformViewIfNeeded(i2);
            FlutterMutatorView flutterMutatorView = this.platformViewParent.get(i2);
            flutterMutatorView.readyToDisplay(flutterMutatorsStack, i3, i4, i5, i6);
            flutterMutatorView.setVisibility(0);
            flutterMutatorView.bringToFront();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i7, i8);
            View view = this.platformViews.get(i2).getView();
            if (view != null) {
                view.setLayoutParams(layoutParams);
                view.bringToFront();
            }
            this.currentFrameUsedPlatformViewIds.add(Integer.valueOf(i2));
        }
    }

    public void onEndFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            FlutterView flutterView = (FlutterView) this.flutterView;
            boolean z = false;
            if (this.flutterViewConvertedToImageView && this.currentFrameUsedPlatformViewIds.isEmpty()) {
                this.flutterViewConvertedToImageView = false;
                flutterView.revertImageView(new Runnable() { // from class: g.a.b.a.b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            PlatformViewsController.this.b();
                        }
                    }
                });
                return;
            }
            if (this.flutterViewConvertedToImageView && flutterView.acquireLatestImageViewFrame()) {
                z = true;
            }
            finishFrame(z);
        }
    }

    public void onPreEngineRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            flushAllViews();
        }
    }

    @VisibleForTesting
    public MotionEvent toMotionEvent(float f2, PlatformViewsChannel.PlatformViewTouch platformViewTouch, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Float.valueOf(f2), platformViewTouch, Boolean.valueOf(z)})) == null) {
            MotionEvent pop = this.motionEventTracker.pop(MotionEventTracker.MotionEventId.from(platformViewTouch.motionEventId));
            MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) parsePointerPropertiesList(platformViewTouch.rawPointerPropertiesList).toArray(new MotionEvent.PointerProperties[platformViewTouch.pointerCount]);
            MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) parsePointerCoordsList(platformViewTouch.rawPointerCoords, f2).toArray(new MotionEvent.PointerCoords[platformViewTouch.pointerCount]);
            if (!z && pop != null) {
                return MotionEvent.obtain(pop.getDownTime(), pop.getEventTime(), pop.getAction(), platformViewTouch.pointerCount, pointerPropertiesArr, pointerCoordsArr, pop.getMetaState(), pop.getButtonState(), pop.getXPrecision(), pop.getYPrecision(), pop.getDeviceId(), pop.getEdgeFlags(), pop.getSource(), pop.getFlags());
            }
            return MotionEvent.obtain(platformViewTouch.downTime.longValue(), platformViewTouch.eventTime.longValue(), platformViewTouch.action, platformViewTouch.pointerCount, pointerPropertiesArr, pointerCoordsArr, platformViewTouch.metaState, platformViewTouch.buttonState, platformViewTouch.xPrecision, platformViewTouch.yPrecision, platformViewTouch.deviceId, platformViewTouch.edgeFlags, platformViewTouch.source, platformViewTouch.flags);
        }
        return (MotionEvent) invokeCommon.objValue;
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public boolean usesVirtualDisplay(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, num)) == null) ? this.vdControllers.containsKey(num) : invokeL.booleanValue;
    }

    @TargetApi(19)
    public FlutterOverlaySurface createOverlaySurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? createOverlaySurface(new FlutterImageView(this.flutterView.getContext(), this.flutterView.getWidth(), this.flutterView.getHeight(), FlutterImageView.SurfaceKind.overlay)) : (FlutterOverlaySurface) invokeV.objValue;
    }
}
