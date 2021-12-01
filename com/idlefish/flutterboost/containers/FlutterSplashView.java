package com.idlefish.flutterboost.containers;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.Debuger;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostPlugin;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import java.util.Map;
/* loaded from: classes2.dex */
public class FlutterSplashView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "FlutterSplashView";
    public static boolean isNeedCustomDartInitFinish;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public FlutterView flutterView;
    public boolean forceShowSplash;
    public Handler handler;
    public FlutterEngine mFlutterEngine;
    @NonNull
    public final FlutterUiDisplayListener onFirstFrameRenderedListener;
    @NonNull
    public final Runnable onTransitionComplete;
    @Nullable
    public String previousCompletedSplashIsolate;
    public long removeDelay;
    @NonNull
    public final FlutterUiDisplayListener removeSplashListener;
    public final FlutterBoostPlugin.EventListener splashEventListener;
    @Nullable
    public SplashScreen splashScreen;
    @Nullable
    public Bundle splashScreenState;
    @Nullable
    public View splashScreenView;
    @NonNull
    public final Runnable transitionToFlutter;
    @Nullable
    public String transitioningIsolateId;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(953872113, "Lcom/idlefish/flutterboost/containers/FlutterSplashView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(953872113, "Lcom/idlefish/flutterboost/containers/FlutterSplashView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterSplashView(@NonNull Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void displayFlutterViewWithSplash(@NonNull FlutterView flutterView, @Nullable SplashScreen splashScreen) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, flutterView, splashScreen) == null) {
            FlutterView flutterView2 = this.flutterView;
            if (flutterView2 != null) {
                flutterView2.removeOnFirstFrameRenderedListener(this.onFirstFrameRenderedListener);
                removeView(this.flutterView);
            }
            View view = this.splashScreenView;
            if (view != null) {
                removeView(view);
            }
            this.flutterView = flutterView;
            addView(flutterView);
            this.splashScreen = splashScreen;
            if (splashScreen != null) {
                View createSplashView = splashScreen.createSplashView(getContext(), this.splashScreenState);
                this.splashScreenView = createSplashView;
                addView(createSplashView);
                flutterView.addOnFirstFrameRenderedListener(this.onFirstFrameRenderedListener);
            }
        }
    }

    public boolean isAttachedToFlutterEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean isAttachedToFlutterEngine = this.flutterView.isAttachedToFlutterEngine();
            Debuger.log("BoostFlutterView isAttachedToFlutterEngine:" + isAttachedToFlutterEngine);
            return isAttachedToFlutterEngine;
        }
        return invokeV.booleanValue;
    }

    @RequiresApi(api = 19)
    public void onAttach() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Debuger.log("BoostFlutterView onAttach");
            this.flutterView.attachToFlutterEngine(this.mFlutterEngine);
            if (this.forceShowSplash && (view = this.splashScreenView) != null && view.isAttachedToWindow()) {
                this.forceShowSplash = false;
                this.flutterView.addOnFirstFrameRenderedListener(this.removeSplashListener);
                this.handler.postDelayed(this.onTransitionComplete, 5000L);
            }
        }
    }

    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Debuger.log("BoostFlutterView onDetach");
            this.flutterView.detachFromFlutterEngine();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            this.handler.removeCallbacksAndMessages(null);
            FlutterBoostPlugin.singleton().removeEventListener(this.splashEventListener);
        }
    }

    public void removeSplashDelay(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.removeDelay = j2;
        }
    }

    @RequiresApi(api = 19)
    public void showSplash(SplashScreen splashScreen) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, splashScreen) == null) || splashScreen == null || isAttachedToFlutterEngine()) {
            return;
        }
        if (this.splashScreenView.isAttachedToWindow()) {
            removeView(this.splashScreenView);
        }
        View createSplashView = splashScreen.createSplashView(getContext(), this.splashScreenState);
        this.splashScreenView = createSplashView;
        addView(createSplashView);
        this.forceShowSplash = true;
    }

    public final void transitionToFlutter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.flutterView.getAttachedFlutterEngine() != null) {
                this.transitioningIsolateId = this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
                String str = TAG;
                Log.v(str, "Transitioning splash screen to a Flutter UI. Isolate: " + this.transitioningIsolateId);
            }
            SplashScreen splashScreen = this.splashScreen;
            if (splashScreen != null) {
                splashScreen.transitionToFlutter(this.onTransitionComplete);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterSplashView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlutterSplashView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.handler = new Handler();
        this.forceShowSplash = false;
        this.removeDelay = 0L;
        this.onFirstFrameRenderedListener = new FlutterUiDisplayListener(this) { // from class: com.idlefish.flutterboost.containers.FlutterSplashView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterSplashView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.splashScreen == null || FlutterSplashView.isNeedCustomDartInitFinish) {
                    return;
                }
                this.this$0.transitionToFlutter();
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.transitionToFlutter = new Runnable(this) { // from class: com.idlefish.flutterboost.containers.FlutterSplashView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterSplashView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.removeDelay = 0L;
                    this.this$0.transitionToFlutter();
                }
            }
        };
        this.onTransitionComplete = new Runnable(this) { // from class: com.idlefish.flutterboost.containers.FlutterSplashView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterSplashView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    FlutterSplashView flutterSplashView = this.this$0;
                    flutterSplashView.removeView(flutterSplashView.splashScreenView);
                    FlutterSplashView flutterSplashView2 = this.this$0;
                    flutterSplashView2.previousCompletedSplashIsolate = flutterSplashView2.transitioningIsolateId;
                }
            }
        };
        this.splashEventListener = new FlutterBoostPlugin.EventListener(this) { // from class: com.idlefish.flutterboost.containers.FlutterSplashView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterSplashView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.idlefish.flutterboost.FlutterBoostPlugin.EventListener
            public void onEvent(String str, Map map) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, str, map) == null) && "flutterPostFrame".equals(str)) {
                    this.this$0.handler.postDelayed(this.this$0.transitionToFlutter, this.this$0.removeDelay);
                }
            }
        };
        this.removeSplashListener = new FlutterUiDisplayListener(this) { // from class: com.idlefish.flutterboost.containers.FlutterSplashView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterSplashView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.splashScreen == null) {
                    return;
                }
                this.this$0.handler.removeCallbacks(this.this$0.onTransitionComplete);
                this.this$0.handler.postDelayed(this.this$0.onTransitionComplete, 100L);
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        setSaveEnabled(true);
        if (this.mFlutterEngine == null) {
            this.mFlutterEngine = FlutterBoost.instance().engineProvider();
        }
        FlutterBoostPlugin.singleton().addEventListener("flutterPostFrame", this.splashEventListener);
    }
}
