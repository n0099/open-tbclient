package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class DeferredReleaser {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static DeferredReleaser sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<Releasable> mPendingReleasables;
    public final Handler mUiHandler;
    public final Runnable releaseRunnable;

    /* loaded from: classes7.dex */
    public interface Releasable {
        void release();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1803749620, "Lcom/facebook/drawee/components/DeferredReleaser;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1803749620, "Lcom/facebook/drawee/components/DeferredReleaser;");
        }
    }

    public DeferredReleaser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.releaseRunnable = new Runnable(this) { // from class: com.facebook.drawee.components.DeferredReleaser.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DeferredReleaser this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                    DeferredReleaser.ensureOnUiThread();
                    for (Releasable releasable : this.this$0.mPendingReleasables) {
                        releasable.release();
                    }
                    this.this$0.mPendingReleasables.clear();
                }
            }
        };
        this.mPendingReleasables = new HashSet();
        this.mUiHandler = new Handler(Looper.getMainLooper());
    }

    public static void ensureOnUiThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            Preconditions.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
        }
    }

    public static synchronized DeferredReleaser getInstance() {
        InterceptResult invokeV;
        DeferredReleaser deferredReleaser;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            synchronized (DeferredReleaser.class) {
                if (sInstance == null) {
                    sInstance = new DeferredReleaser();
                }
                deferredReleaser = sInstance;
            }
            return deferredReleaser;
        }
        return (DeferredReleaser) invokeV.objValue;
    }

    public void cancelDeferredRelease(Releasable releasable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, releasable) == null) {
            ensureOnUiThread();
            this.mPendingReleasables.remove(releasable);
        }
    }

    public void scheduleDeferredRelease(Releasable releasable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, releasable) == null) {
            ensureOnUiThread();
            if (this.mPendingReleasables.add(releasable) && this.mPendingReleasables.size() == 1) {
                this.mUiHandler.post(this.releaseRunnable);
            }
        }
    }
}
