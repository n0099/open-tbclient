package com.google.android.gms.dynamite;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class zzb {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    @GuardedBy("DynamiteLoaderV2ClassLoader.class")
    public static volatile ClassLoader zza;
    @Nullable
    @GuardedBy("DynamiteLoaderV2ClassLoader.class")
    public static volatile Thread zzb;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(229947893, "Lcom/google/android/gms/dynamite/zzb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(229947893, "Lcom/google/android/gms/dynamite/zzb;");
        }
    }

    @Nullable
    public static synchronized ClassLoader zza() {
        InterceptResult invokeV;
        ClassLoader classLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (zzb.class) {
                if (zza == null) {
                    zza = zzb();
                }
                classLoader = zza;
            }
            return classLoader;
        }
        return (ClassLoader) invokeV.objValue;
    }

    @Nullable
    public static synchronized ClassLoader zzb() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (zzb.class) {
                ClassLoader classLoader = null;
                if (zzb == null) {
                    zzb = zzc();
                    if (zzb == null) {
                        return null;
                    }
                }
                synchronized (zzb) {
                    try {
                        classLoader = zzb.getContextClassLoader();
                    } catch (SecurityException e) {
                        String valueOf = String.valueOf(e.getMessage());
                        if (valueOf.length() != 0) {
                            str = "Failed to get thread context classloader ".concat(valueOf);
                        } else {
                            str = new String("Failed to get thread context classloader ");
                        }
                        Log.w("DynamiteLoaderV2CL", str);
                    }
                }
                return classLoader;
            }
        }
        return (ClassLoader) invokeV.objValue;
    }

    @Nullable
    public static synchronized Thread zzc() {
        InterceptResult invokeV;
        SecurityException e;
        zza zzaVar;
        String str;
        zza zzaVar2;
        ThreadGroup threadGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (zzb.class) {
                ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
                if (threadGroup2 == null) {
                    return null;
                }
                synchronized (Void.class) {
                    try {
                        int activeGroupCount = threadGroup2.activeGroupCount();
                        ThreadGroup[] threadGroupArr = new ThreadGroup[activeGroupCount];
                        threadGroup2.enumerate(threadGroupArr);
                        int i = 0;
                        int i2 = 0;
                        while (true) {
                            if (i2 < activeGroupCount) {
                                threadGroup = threadGroupArr[i2];
                                if ("dynamiteLoader".equals(threadGroup.getName())) {
                                    break;
                                }
                                i2++;
                            } else {
                                threadGroup = null;
                                break;
                            }
                        }
                        if (threadGroup == null) {
                            threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                        }
                        int activeCount = threadGroup.activeCount();
                        Thread[] threadArr = new Thread[activeCount];
                        threadGroup.enumerate(threadArr);
                        while (true) {
                            if (i < activeCount) {
                                zzaVar2 = threadArr[i];
                                if ("GmsDynamite".equals(zzaVar2.getName())) {
                                    break;
                                }
                                i++;
                            } else {
                                zzaVar2 = null;
                                break;
                            }
                        }
                    } catch (SecurityException e2) {
                        e = e2;
                        zzaVar = null;
                    }
                    if (zzaVar2 == null) {
                        try {
                            zzaVar = new zza(threadGroup, "GmsDynamite");
                        } catch (SecurityException e3) {
                            e = e3;
                            zzaVar = zzaVar2;
                        }
                        try {
                            zzaVar.setContextClassLoader(null);
                            zzaVar.start();
                        } catch (SecurityException e4) {
                            e = e4;
                            String valueOf = String.valueOf(e.getMessage());
                            if (valueOf.length() != 0) {
                                str = "Failed to enumerate thread/threadgroup ".concat(valueOf);
                            } else {
                                str = new String("Failed to enumerate thread/threadgroup ");
                            }
                            Log.w("DynamiteLoaderV2CL", str);
                            zzaVar2 = zzaVar;
                            return zzaVar2;
                        }
                        zzaVar2 = zzaVar;
                    }
                }
                return zzaVar2;
            }
        }
        return (Thread) invokeV.objValue;
    }
}
