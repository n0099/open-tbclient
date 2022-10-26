package com.facebook.imagepipeline.platform;

import android.os.Build;
import androidx.core.util.Pools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.core.NativeCodeSetup;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.PoolFactory;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes7.dex */
public class PlatformDecoderFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PlatformDecoderFactory() {
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

    public static PlatformDecoder buildPlatformDecoder(PoolFactory poolFactory, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, poolFactory, z)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                int flexByteArrayPoolMaxNumThreads = poolFactory.getFlexByteArrayPoolMaxNumThreads();
                return new OreoDecoder(poolFactory.getBitmapPool(), flexByteArrayPoolMaxNumThreads, new Pools.SynchronizedPool(flexByteArrayPoolMaxNumThreads));
            } else if (i < 21 && NativeCodeSetup.getUseNativeCode()) {
                if (z) {
                    try {
                        if (Build.VERSION.SDK_INT < 19) {
                            return (PlatformDecoder) Class.forName("com.facebook.imagepipeline.platform.GingerbreadPurgeableDecoder").getConstructor(new Class[0]).newInstance(new Object[0]);
                        }
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException("Wrong Native code setup, reflection failed.", e);
                    } catch (IllegalAccessException e2) {
                        throw new RuntimeException("Wrong Native code setup, reflection failed.", e2);
                    } catch (InstantiationException e3) {
                        throw new RuntimeException("Wrong Native code setup, reflection failed.", e3);
                    } catch (NoSuchMethodException e4) {
                        throw new RuntimeException("Wrong Native code setup, reflection failed.", e4);
                    } catch (InvocationTargetException e5) {
                        throw new RuntimeException("Wrong Native code setup, reflection failed.", e5);
                    }
                }
                return (PlatformDecoder) Class.forName("com.facebook.imagepipeline.platform.KitKatPurgeableDecoder").getConstructor(FlexByteArrayPool.class).newInstance(poolFactory.getFlexByteArrayPool());
            } else {
                int flexByteArrayPoolMaxNumThreads2 = poolFactory.getFlexByteArrayPoolMaxNumThreads();
                return new ArtDecoder(poolFactory.getBitmapPool(), flexByteArrayPoolMaxNumThreads2, new Pools.SynchronizedPool(flexByteArrayPoolMaxNumThreads2));
            }
        }
        return (PlatformDecoder) invokeLZ.objValue;
    }
}
