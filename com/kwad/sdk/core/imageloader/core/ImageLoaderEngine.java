package com.kwad.sdk.core.imageloader.core;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class ImageLoaderEngine {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Integer, String> cacheKeysForImageAwares;
    public final ImageLoaderConfiguration configuration;
    public final AtomicBoolean networkDenied;
    public final Object pauseLock;
    public final AtomicBoolean paused;
    public final AtomicBoolean slowNetwork;
    public Executor taskDistributor;
    public Executor taskExecutor;
    public Executor taskExecutorForCachedImages;
    public final Map<String, ReentrantLock> uriLocks;

    public ImageLoaderEngine(ImageLoaderConfiguration imageLoaderConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageLoaderConfiguration};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cacheKeysForImageAwares = Collections.synchronizedMap(new HashMap());
        this.uriLocks = new WeakHashMap();
        this.paused = new AtomicBoolean(false);
        this.networkDenied = new AtomicBoolean(false);
        this.slowNetwork = new AtomicBoolean(false);
        this.pauseLock = new Object();
        this.configuration = imageLoaderConfiguration;
        this.taskExecutor = imageLoaderConfiguration.taskExecutor;
        this.taskExecutorForCachedImages = imageLoaderConfiguration.taskExecutorForCachedImages;
        this.taskDistributor = imageLoaderConfiguration.taskDistributor;
    }

    private Executor createTaskExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            ImageLoaderConfiguration imageLoaderConfiguration = this.configuration;
            return DefaultConfigurationFactory.createExecutor(imageLoaderConfiguration.threadPoolSize, imageLoaderConfiguration.threadPriority, imageLoaderConfiguration.tasksProcessingType);
        }
        return (Executor) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initExecutorsIfNeed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            if (!this.configuration.customExecutor && ((ExecutorService) this.taskExecutor).isShutdown()) {
                this.taskExecutor = createTaskExecutor();
            }
            if (this.configuration.customExecutorForCachedImages || !((ExecutorService) this.taskExecutorForCachedImages).isShutdown()) {
                return;
            }
            this.taskExecutorForCachedImages = createTaskExecutor();
        }
    }

    public void cancelDisplayTaskFor(ImageAware imageAware) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, imageAware) == null) {
            this.cacheKeysForImageAwares.remove(Integer.valueOf(imageAware.getId()));
        }
    }

    public void denyNetworkDownloads(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.networkDenied.set(z);
        }
    }

    public void fireCallback(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
            this.taskDistributor.execute(runnable);
        }
    }

    public String getLoadingUriForView(ImageAware imageAware) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, imageAware)) == null) ? this.cacheKeysForImageAwares.get(Integer.valueOf(imageAware.getId())) : (String) invokeL.objValue;
    }

    public ReentrantLock getLockForUri(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            ReentrantLock reentrantLock = this.uriLocks.get(str);
            if (reentrantLock == null) {
                ReentrantLock reentrantLock2 = new ReentrantLock();
                this.uriLocks.put(str, reentrantLock2);
                return reentrantLock2;
            }
            return reentrantLock;
        }
        return (ReentrantLock) invokeL.objValue;
    }

    public AtomicBoolean getPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.paused : (AtomicBoolean) invokeV.objValue;
    }

    public Object getPauseLock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.pauseLock : invokeV.objValue;
    }

    public void handleSlowNetwork(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.slowNetwork.set(z);
        }
    }

    public boolean isNetworkDenied() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.networkDenied.get() : invokeV.booleanValue;
    }

    public boolean isSlowNetwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.slowNetwork.get() : invokeV.booleanValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.paused.set(true);
        }
    }

    public void prepareDisplayTaskFor(ImageAware imageAware, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, imageAware, str) == null) {
            this.cacheKeysForImageAwares.put(Integer.valueOf(imageAware.getId()), str);
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.paused.set(false);
            synchronized (this.pauseLock) {
                this.pauseLock.notifyAll();
            }
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (!this.configuration.customExecutor) {
                ((ExecutorService) this.taskExecutor).shutdownNow();
            }
            if (!this.configuration.customExecutorForCachedImages) {
                ((ExecutorService) this.taskExecutorForCachedImages).shutdownNow();
            }
            this.cacheKeysForImageAwares.clear();
            this.uriLocks.clear();
        }
    }

    public void submit(LoadAndDisplayImageTask loadAndDisplayImageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, loadAndDisplayImageTask) == null) {
            this.taskDistributor.execute(new Runnable(this, loadAndDisplayImageTask) { // from class: com.kwad.sdk.core.imageloader.core.ImageLoaderEngine.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImageLoaderEngine this$0;
                public final /* synthetic */ LoadAndDisplayImageTask val$task;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, loadAndDisplayImageTask};
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
                    this.val$task = loadAndDisplayImageTask;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        File file = this.this$0.configuration.diskCache.get(this.val$task.getLoadingUri());
                        boolean z = file != null && file.exists();
                        this.this$0.initExecutorsIfNeed();
                        (z ? this.this$0.taskExecutorForCachedImages : this.this$0.taskExecutor).execute(this.val$task);
                    }
                }
            });
        }
    }

    public void submit(ProcessAndDisplayImageTask processAndDisplayImageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, processAndDisplayImageTask) == null) {
            initExecutorsIfNeed();
            this.taskExecutorForCachedImages.execute(processAndDisplayImageTask);
        }
    }
}
