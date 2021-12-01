package io.flutter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.loader.FlutterLoader;
/* loaded from: classes3.dex */
public final class FlutterInjector {
    public static /* synthetic */ Interceptable $ic;
    public static boolean accessed;
    public static FlutterInjector instance;
    public transient /* synthetic */ FieldHolder $fh;
    public DeferredComponentManager deferredComponentManager;
    public FlutterJNI.Factory flutterJniFactory;
    public FlutterLoader flutterLoader;

    /* renamed from: io.flutter.FlutterInjector$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public DeferredComponentManager deferredComponentManager;
        public FlutterJNI.Factory flutterJniFactory;
        public FlutterLoader flutterLoader;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        private void fillDefaults() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                if (this.flutterJniFactory == null) {
                    this.flutterJniFactory = new FlutterJNI.Factory();
                }
                if (this.flutterLoader == null) {
                    this.flutterLoader = new FlutterLoader(this.flutterJniFactory.provideFlutterJNI());
                }
            }
        }

        public FlutterInjector build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                fillDefaults();
                return new FlutterInjector(this.flutterLoader, this.deferredComponentManager, this.flutterJniFactory, null);
            }
            return (FlutterInjector) invokeV.objValue;
        }

        public Builder setDeferredComponentManager(@Nullable DeferredComponentManager deferredComponentManager) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, deferredComponentManager)) == null) {
                this.deferredComponentManager = deferredComponentManager;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setFlutterJNIFactory(@NonNull FlutterJNI.Factory factory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, factory)) == null) {
                this.flutterJniFactory = factory;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setFlutterLoader(@NonNull FlutterLoader flutterLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, flutterLoader)) == null) {
                this.flutterLoader = flutterLoader;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    public /* synthetic */ FlutterInjector(FlutterLoader flutterLoader, DeferredComponentManager deferredComponentManager, FlutterJNI.Factory factory, AnonymousClass1 anonymousClass1) {
        this(flutterLoader, deferredComponentManager, factory);
    }

    public static FlutterInjector instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            accessed = true;
            if (instance == null) {
                instance = new Builder().build();
            }
            return instance;
        }
        return (FlutterInjector) invokeV.objValue;
    }

    @VisibleForTesting
    public static void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            accessed = false;
            instance = null;
        }
    }

    @VisibleForTesting
    public static void setInstance(@NonNull FlutterInjector flutterInjector) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, flutterInjector) == null) {
            if (!accessed) {
                instance = flutterInjector;
                return;
            }
            throw new IllegalStateException("Cannot change the FlutterInjector instance once it's been read. If you're trying to dependency inject, be sure to do so at the beginning of the program");
        }
    }

    @Nullable
    public DeferredComponentManager deferredComponentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.deferredComponentManager : (DeferredComponentManager) invokeV.objValue;
    }

    @NonNull
    public FlutterLoader flutterLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.flutterLoader : (FlutterLoader) invokeV.objValue;
    }

    @NonNull
    public FlutterJNI.Factory getFlutterJNIFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.flutterJniFactory : (FlutterJNI.Factory) invokeV.objValue;
    }

    public FlutterInjector(@NonNull FlutterLoader flutterLoader, @Nullable DeferredComponentManager deferredComponentManager, @NonNull FlutterJNI.Factory factory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flutterLoader, deferredComponentManager, factory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.flutterLoader = flutterLoader;
        this.deferredComponentManager = deferredComponentManager;
        this.flutterJniFactory = factory;
    }
}
