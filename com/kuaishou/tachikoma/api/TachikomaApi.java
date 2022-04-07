package com.kuaishou.tachikoma.api;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.tachikoma.api.app.IHostService;
import com.kuaishou.tachikoma.api.app.ITKLog;
import com.kuaishou.tachikoma.api.app.TkBundleInfo;
import com.kuaishou.tachikoma.api.exception.ITKExceptionHandler;
import com.kuaishou.tachikoma.api.exception.TKExceptionHandlerInnerImpl;
import com.kuaishou.tachikoma.api.model.TKCDNUrl;
import com.kwad.v8.V8;
import com.tachikoma.core.TKJSContextInitCallback;
import com.tachikoma.core.Tachikoma;
import com.tachikoma.core.api.IAnimatedImageInner;
import com.tachikoma.core.api.IHostEnvInner;
import com.tachikoma.core.api.ILogInner;
import com.tachikoma.core.api.IModuleInner;
import com.tachikoma.core.api.IWebImageHandlerInner;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.component.imageview.TKCDNUrlInner;
import com.tachikoma.core.exception.TKExceptionDispatcher;
import com.tachikoma.core.manager.TKModuleManager;
import com.tachikoma.core.manager.TKProviderCollection;
import com.tachikoma.core.module.TKBuilder;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class TachikomaApi {
    public static /* synthetic */ Interceptable $ic;
    public static final TachikomaApi instance;
    public transient /* synthetic */ FieldHolder $fh;
    public Application mApplication;

    /* loaded from: classes5.dex */
    public static class TKInitParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<String, Object> config;

        /* loaded from: classes5.dex */
        public static class Builder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Map<String, Object> config;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public TKInitParams build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new TKInitParams(this.config) : (TKInitParams) invokeV.objValue;
            }

            public Builder setConfig(Map<String, Object> map) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
                    this.config = map;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }
        }

        public TKInitParams(Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.config = map;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2075169235, "Lcom/kuaishou/tachikoma/api/TachikomaApi;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2075169235, "Lcom/kuaishou/tachikoma/api/TachikomaApi;");
                return;
            }
        }
        instance = new TachikomaApi();
    }

    public TachikomaApi() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        makeNativeLibraryLoadedToTrue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TKCDNUrl> convertToTKCDNUrl(List<TKCDNUrlInner> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (TKCDNUrlInner tKCDNUrlInner : list) {
                    arrayList.add(new TKCDNUrl(tKCDNUrlInner.mCdn, tKCDNUrlInner.mUrl, tKCDNUrlInner.getIp(), tKCDNUrlInner.getUrlPattern(), tKCDNUrlInner.mIsFreeTrafficCdn, tKCDNUrlInner.mFeature, tKCDNUrlInner.mUrlType, tKCDNUrlInner.mPushCdn, tKCDNUrlInner.mHeaders));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static TachikomaApi getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? instance : (TachikomaApi) invokeV.objValue;
    }

    private void makeNativeLibraryLoadedToTrue() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            try {
                Field declaredField = V8.class.getDeclaredField("nativeLibraryLoaded");
                declaredField.setAccessible(true);
                declaredField.setBoolean(null, true);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void registerExtraLib(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, strArr) == null) {
            TKProviderCollection.registerExtraLib(strArr);
        }
    }

    public static void unregisterExtraLib(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, strArr) == null) {
            TKProviderCollection.unregisterExtraLib(strArr);
        }
    }

    public void asyncNewJSContext(TKContextInitCallback tKContextInitCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tKContextInitCallback) == null) {
            if (isInitSuccess()) {
                Tachikoma.getInstance().asyncNewTKJSContext(new TKJSContextInitCallback(this, tKContextInitCallback) { // from class: com.kuaishou.tachikoma.api.TachikomaApi.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TachikomaApi this$0;
                    public final /* synthetic */ TKContextInitCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, tKContextInitCallback};
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
                        this.val$callback = tKContextInitCallback;
                    }

                    @Override // com.tachikoma.core.TKJSContextInitCallback
                    public void onError(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                            this.val$callback.onError(str);
                        }
                    }

                    @Override // com.tachikoma.core.TKJSContextInitCallback
                    public void onSuccess(TKJSContext tKJSContext) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tKJSContext) == null) {
                            this.val$callback.onSuccess(new TKContext(tKJSContext));
                        }
                    }
                });
            } else {
                tKContextInitCallback.onError("tk has been not inited");
            }
        }
    }

    public void clearBundleCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void clearHostService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TKModuleManager.getInstance().clear();
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Tachikoma.getInstance().destroy();
        }
    }

    @Deprecated
    public TkBundleInfo getTkBundleById(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, str)) == null) {
            return null;
        }
        return (TkBundleInfo) invokeLL.objValue;
    }

    @Deprecated
    public void init(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, application) == null) {
            init(application, (Map<String, Object>) null);
        }
    }

    public void init(Application application, TKInitParams tKInitParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, application, tKInitParams) == null) {
            this.mApplication = application;
            Tachikoma.getInstance().init(application);
            if (tKInitParams.config != null) {
                Tachikoma.getInstance().setConfig(tKInitParams.config);
            }
        }
    }

    @Deprecated
    public void init(Application application, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, application, map) == null) {
            init(application, new TKInitParams.Builder().setConfig(map).build());
        }
    }

    public boolean isInitSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Tachikoma.getInstance().isInitSuccess() : invokeV.booleanValue;
    }

    @Nullable
    public TKContext newTKJSContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (isInitSuccess()) {
                return new TKContext(Tachikoma.getInstance().newTKJSContext());
            }
            return null;
        }
        return (TKContext) invokeV.objValue;
    }

    @Nullable
    public TKContext newTKJSContext(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            if (isInitSuccess()) {
                return new TKContext(Tachikoma.getInstance().newTKJSContext(viewGroup));
            }
            return null;
        }
        return (TKContext) invokeL.objValue;
    }

    public void setExceptionHandler(ITKExceptionHandler iTKExceptionHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iTKExceptionHandler) == null) {
            TKExceptionDispatcher.setExceptionHandler(new TKExceptionHandlerInnerImpl(iTKExceptionHandler));
        }
    }

    public void setHostService(IHostService iHostService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iHostService) == null) {
            TKModuleManager.getInstance().register(new IModuleInner(this, iHostService) { // from class: com.kuaishou.tachikoma.api.TachikomaApi.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TachikomaApi this$0;
                public final /* synthetic */ IHostService val$hostService;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iHostService};
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
                    this.val$hostService = iHostService;
                }

                @Override // com.tachikoma.core.api.IModuleInner
                public void applyOptions(TKBuilder tKBuilder) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tKBuilder) == null) {
                        tKBuilder.setWebImageHandler(new IWebImageHandlerInner(this) { // from class: com.kuaishou.tachikoma.api.TachikomaApi.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass3 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
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
                            }

                            @Override // com.tachikoma.core.api.IWebImageHandlerInner
                            public void load(ImageView imageView, String str, Drawable drawable, int i) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeLLLI(1048576, this, imageView, str, drawable, i) == null) {
                                    this.this$1.val$hostService.obtainWebImageService().load(imageView, str, drawable, i);
                                }
                            }

                            @Override // com.tachikoma.core.api.IWebImageHandlerInner
                            public void load(ImageView imageView, List<TKCDNUrlInner> list, int i, int i2, int i3) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imageView, list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                                    this.this$1.val$hostService.obtainWebImageService().load(imageView, this.this$1.this$0.convertToTKCDNUrl(list), i, i2, i3);
                                }
                            }

                            @Override // com.tachikoma.core.api.IWebImageHandlerInner
                            public void load(ImageView imageView, List<TKCDNUrlInner> list, int i, int i2, Drawable drawable, int i3) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{imageView, list, Integer.valueOf(i), Integer.valueOf(i2), drawable, Integer.valueOf(i3)}) == null) {
                                    this.this$1.val$hostService.obtainWebImageService().load(imageView, this.this$1.this$0.convertToTKCDNUrl(list), i, i2, drawable, i3);
                                }
                            }

                            @Override // com.tachikoma.core.api.IWebImageHandlerInner
                            public void load(String str, ImageView imageView, int i) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeLLI(1048579, this, str, imageView, i) == null) {
                                    this.this$1.val$hostService.obtainWebImageService().load(str, imageView, i);
                                }
                            }
                        });
                        tKBuilder.setEnv(new IHostEnvInner(this) { // from class: com.kuaishou.tachikoma.api.TachikomaApi.3.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass3 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
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
                            }

                            @Override // com.tachikoma.core.api.IHostEnvInner
                            public boolean isDark() {
                                InterceptResult invokeV;
                                Interceptable interceptable3 = $ic;
                                return (interceptable3 == null || (invokeV = interceptable3.invokeV(1048576, this)) == null) ? this.this$1.val$hostService.obtainHostEnv().isDark() : invokeV.booleanValue;
                            }

                            @Override // com.tachikoma.core.api.IHostEnvInner
                            public boolean isDebug() {
                                InterceptResult invokeV;
                                Interceptable interceptable3 = $ic;
                                return (interceptable3 == null || (invokeV = interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$1.val$hostService.obtainHostEnv().isDebug() : invokeV.booleanValue;
                            }

                            @Override // com.tachikoma.core.api.IHostEnvInner
                            public boolean isShowLog() {
                                InterceptResult invokeV;
                                Interceptable interceptable3 = $ic;
                                return (interceptable3 == null || (invokeV = interceptable3.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$1.val$hostService.obtainHostEnv().isShowLog() : invokeV.booleanValue;
                            }
                        });
                        tKBuilder.setAnimatedImageInner(new IAnimatedImageInner(this) { // from class: com.kuaishou.tachikoma.api.TachikomaApi.3.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass3 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
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
                            }

                            @Override // com.tachikoma.core.api.IAnimatedImageInner
                            public ImageView getImageViewHost(Context context) {
                                InterceptResult invokeL;
                                Interceptable interceptable3 = $ic;
                                return (interceptable3 == null || (invokeL = interceptable3.invokeL(1048576, this, context)) == null) ? this.this$1.val$hostService.obtainAnimatedImage().getImageViewHost(context) : (ImageView) invokeL.objValue;
                            }

                            @Override // com.tachikoma.core.api.IAnimatedImageInner
                            public boolean getPlayNow(ImageView imageView) {
                                InterceptResult invokeL;
                                Interceptable interceptable3 = $ic;
                                return (interceptable3 == null || (invokeL = interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView)) == null) ? this.this$1.val$hostService.obtainAnimatedImage().getPlayNow(imageView) : invokeL.booleanValue;
                            }

                            @Override // com.tachikoma.core.api.IAnimatedImageInner
                            public void setBorderColor(ImageView imageView, String str) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imageView, str) == null) {
                                    this.this$1.val$hostService.obtainAnimatedImage().setBorderColor(imageView, str);
                                }
                            }

                            @Override // com.tachikoma.core.api.IAnimatedImageInner
                            public void setBorderRadius(ImageView imageView, int i) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeLI(1048579, this, imageView, i) == null) {
                                    this.this$1.val$hostService.obtainAnimatedImage().setBorderRadius(imageView, i);
                                }
                            }

                            @Override // com.tachikoma.core.api.IAnimatedImageInner
                            public void setBorderWidth(ImageView imageView, double d) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeCommon(1048580, this, new Object[]{imageView, Double.valueOf(d)}) == null) {
                                    this.this$1.val$hostService.obtainAnimatedImage().setBorderWidth(imageView, d);
                                }
                            }

                            @Override // com.tachikoma.core.api.IAnimatedImageInner
                            public void setCDNUrls(ImageView imageView, List<TKCDNUrlInner> list, int i, int i2, String str) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeCommon(1048581, this, new Object[]{imageView, list, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
                                    this.this$1.val$hostService.obtainAnimatedImage().setCDNUrls(imageView, this.this$1.this$0.convertToTKCDNUrl(list), i, i2, str);
                                }
                            }

                            @Override // com.tachikoma.core.api.IAnimatedImageInner
                            public void setSrc(ImageView imageView, String str, String str2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeLLL(1048582, this, imageView, str, str2) == null) {
                                    this.this$1.val$hostService.obtainAnimatedImage().setSrc(imageView, str, str2);
                                }
                            }

                            @Override // com.tachikoma.core.api.IAnimatedImageInner
                            public void setUri(ImageView imageView, String str, String str2, int i, int i2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeCommon(1048583, this, new Object[]{imageView, str, str2, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
                                    this.this$1.val$hostService.obtainAnimatedImage().setUri(imageView, str, str2, i, i2);
                                }
                            }

                            @Override // com.tachikoma.core.api.IAnimatedImageInner
                            public void setUrlAndPlaceHolder(ImageView imageView, String str, String str2, String str3, int i, int i2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{imageView, str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
                                    this.this$1.val$hostService.obtainAnimatedImage().setUrlAndPlaceHolder(imageView, str, str2, str3, i, i2);
                                }
                            }

                            @Override // com.tachikoma.core.api.IAnimatedImageInner
                            public void setUrls(ImageView imageView, List<TKCDNUrlInner> list, int i, int i2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeLLII(1048585, this, imageView, list, i, i2) == null) {
                                    this.this$1.val$hostService.obtainAnimatedImage().setUrls(imageView, this.this$1.this$0.convertToTKCDNUrl(list), i, i2);
                                }
                            }

                            @Override // com.tachikoma.core.api.IAnimatedImageInner
                            public void startGifAnimation(ImageView imageView) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048586, this, imageView) == null) {
                                    this.this$1.val$hostService.obtainAnimatedImage().startGifAnimation(imageView);
                                }
                            }

                            @Override // com.tachikoma.core.api.IAnimatedImageInner
                            public void stopGifAnimation(ImageView imageView) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048587, this, imageView) == null) {
                                    this.this$1.val$hostService.obtainAnimatedImage().stopGifAnimation(imageView);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void setInitResult(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            Tachikoma.getInstance().setInitResult(z);
        }
    }

    public void setLoggerDelegate(ITKLog iTKLog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iTKLog) == null) {
            Tachikoma.getInstance().setLoggerDelegate(new ILogInner(this, iTKLog) { // from class: com.kuaishou.tachikoma.api.TachikomaApi.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TachikomaApi this$0;
                public final /* synthetic */ ITKLog val$log;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iTKLog};
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
                    this.val$log = iTKLog;
                }

                @Override // com.tachikoma.core.api.ILogInner
                public void d(String str, String str2) {
                    ITKLog iTKLog2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, str, str2) == null) || (iTKLog2 = this.val$log) == null) {
                        return;
                    }
                    iTKLog2.d(str, str2);
                }

                @Override // com.tachikoma.core.api.ILogInner
                public void d(String str, String str2, Throwable th) {
                    ITKLog iTKLog2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, th) == null) || (iTKLog2 = this.val$log) == null) {
                        return;
                    }
                    iTKLog2.d(str, str2, th);
                }

                @Override // com.tachikoma.core.api.ILogInner
                public void e(String str, String str2) {
                    ITKLog iTKLog2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || (iTKLog2 = this.val$log) == null) {
                        return;
                    }
                    iTKLog2.e(str, str2);
                }

                @Override // com.tachikoma.core.api.ILogInner
                public void e(String str, String str2, Throwable th) {
                    ITKLog iTKLog2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLL(1048579, this, str, str2, th) == null) || (iTKLog2 = this.val$log) == null) {
                        return;
                    }
                    iTKLog2.e(str, str2, th);
                }

                @Override // com.tachikoma.core.api.ILogInner
                public String getStackTraceString(Throwable th) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048580, this, th)) == null) {
                        ITKLog iTKLog2 = this.val$log;
                        return iTKLog2 != null ? iTKLog2.getStackTraceString(th) : "";
                    }
                    return (String) invokeL.objValue;
                }

                @Override // com.tachikoma.core.api.ILogInner
                public void i(String str, String str2) {
                    ITKLog iTKLog2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048581, this, str, str2) == null) || (iTKLog2 = this.val$log) == null) {
                        return;
                    }
                    iTKLog2.i(str, str2);
                }

                @Override // com.tachikoma.core.api.ILogInner
                public void i(String str, String str2, Throwable th) {
                    ITKLog iTKLog2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLL(1048582, this, str, str2, th) == null) || (iTKLog2 = this.val$log) == null) {
                        return;
                    }
                    iTKLog2.i(str, str2, th);
                }

                @Override // com.tachikoma.core.api.ILogInner
                public void v(String str, String str2) {
                    ITKLog iTKLog2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048583, this, str, str2) == null) || (iTKLog2 = this.val$log) == null) {
                        return;
                    }
                    iTKLog2.v(str, str2);
                }

                @Override // com.tachikoma.core.api.ILogInner
                public void v(String str, String str2, Throwable th) {
                    ITKLog iTKLog2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, th) == null) || (iTKLog2 = this.val$log) == null) {
                        return;
                    }
                    iTKLog2.v(str, str2, th);
                }

                @Override // com.tachikoma.core.api.ILogInner
                public void w(String str, String str2) {
                    ITKLog iTKLog2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048585, this, str, str2) == null) || (iTKLog2 = this.val$log) == null) {
                        return;
                    }
                    iTKLog2.w(str, str2);
                }

                @Override // com.tachikoma.core.api.ILogInner
                public void w(String str, String str2, Throwable th) {
                    ITKLog iTKLog2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLL(1048586, this, str, str2, th) == null) || (iTKLog2 = this.val$log) == null) {
                        return;
                    }
                    iTKLog2.w(str, str2, th);
                }

                @Override // com.tachikoma.core.api.ILogInner
                public void w(String str, Throwable th) {
                    ITKLog iTKLog2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048587, this, str, th) == null) || (iTKLog2 = this.val$log) == null) {
                        return;
                    }
                    iTKLog2.w(str, th);
                }
            });
        }
    }
}
