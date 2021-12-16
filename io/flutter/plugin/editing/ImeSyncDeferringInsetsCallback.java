package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@Keep
@SuppressLint({"NewApi", "Override"})
@VisibleForTesting
@RequiresApi(30)
@TargetApi(30)
/* loaded from: classes4.dex */
public class ImeSyncDeferringInsetsCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean animating;
    public AnimationCallback animationCallback;
    public int deferredInsetTypes;
    public InsetsListener insetsListener;
    public WindowInsets lastWindowInsets;
    public boolean needsSave;
    public int overlayInsetTypes;
    public View view;

    /* renamed from: io.flutter.plugin.editing.ImeSyncDeferringInsetsCallback$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Keep
    /* loaded from: classes4.dex */
    public class AnimationCallback extends WindowInsetsAnimation.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImeSyncDeferringInsetsCallback this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimationCallback(ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback) {
            super(1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imeSyncDeferringInsetsCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = imeSyncDeferringInsetsCallback;
        }

        @Override // android.view.WindowInsetsAnimation.Callback
        public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, windowInsetsAnimation) == null) && this.this$0.animating && (windowInsetsAnimation.getTypeMask() & this.this$0.deferredInsetTypes) != 0) {
                this.this$0.animating = false;
                if (this.this$0.lastWindowInsets == null || this.this$0.view == null) {
                    return;
                }
                this.this$0.view.dispatchApplyWindowInsets(this.this$0.lastWindowInsets);
            }
        }

        @Override // android.view.WindowInsetsAnimation.Callback
        public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, windowInsetsAnimation) == null) || (windowInsetsAnimation.getTypeMask() & this.this$0.deferredInsetTypes) == 0) {
                return;
            }
            this.this$0.animating = true;
            this.this$0.needsSave = true;
        }

        @Override // android.view.WindowInsetsAnimation.Callback
        public WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, windowInsets, list)) == null) {
                if (this.this$0.animating && !this.this$0.needsSave) {
                    boolean z = false;
                    for (WindowInsetsAnimation windowInsetsAnimation : list) {
                        if ((windowInsetsAnimation.getTypeMask() & this.this$0.deferredInsetTypes) != 0) {
                            z = true;
                        }
                    }
                    if (!z) {
                        return windowInsets;
                    }
                    WindowInsets.Builder builder = new WindowInsets.Builder(this.this$0.lastWindowInsets);
                    builder.setInsets(this.this$0.deferredInsetTypes, Insets.of(0, 0, 0, Math.max(windowInsets.getInsets(this.this$0.deferredInsetTypes).bottom - windowInsets.getInsets(this.this$0.overlayInsetTypes).bottom, 0)));
                    this.this$0.view.onApplyWindowInsets(builder.build());
                }
                return windowInsets;
            }
            return (WindowInsets) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class InsetsListener implements View.OnApplyWindowInsetsListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImeSyncDeferringInsetsCallback this$0;

        public InsetsListener(ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imeSyncDeferringInsetsCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = imeSyncDeferringInsetsCallback;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, windowInsets)) == null) {
                this.this$0.view = view;
                if (this.this$0.needsSave) {
                    this.this$0.lastWindowInsets = windowInsets;
                    this.this$0.needsSave = false;
                }
                if (this.this$0.animating) {
                    return WindowInsets.CONSUMED;
                }
                return view.onApplyWindowInsets(windowInsets);
            }
            return (WindowInsets) invokeLL.objValue;
        }

        public /* synthetic */ InsetsListener(ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback, AnonymousClass1 anonymousClass1) {
            this(imeSyncDeferringInsetsCallback);
        }
    }

    public ImeSyncDeferringInsetsCallback(@NonNull View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.animating = false;
        this.needsSave = false;
        this.overlayInsetTypes = i2;
        this.deferredInsetTypes = i3;
        this.view = view;
        this.animationCallback = new AnimationCallback(this);
        this.insetsListener = new InsetsListener(this, null);
    }

    @VisibleForTesting
    public WindowInsetsAnimation.Callback getAnimationCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.animationCallback : (WindowInsetsAnimation.Callback) invokeV.objValue;
    }

    @VisibleForTesting
    public View.OnApplyWindowInsetsListener getInsetsListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.insetsListener : (View.OnApplyWindowInsetsListener) invokeV.objValue;
    }

    public void install() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.view.setWindowInsetsAnimationCallback(this.animationCallback);
            this.view.setOnApplyWindowInsetsListener(this.insetsListener);
        }
    }

    public void remove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.view.setWindowInsetsAnimationCallback(null);
            this.view.setOnApplyWindowInsetsListener(null);
        }
    }
}
