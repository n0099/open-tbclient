package com.github.anrwatchdog;

import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.github.anrwatchdog.ANRError$$;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes9.dex */
public class ANRError extends Error {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final long duration;
    public ANRError$$._Thread st;

    /* loaded from: classes9.dex */
    public static class a implements Comparator<Thread> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Thread a;

        public a(Thread thread) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {thread};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = thread;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Thread thread, Thread thread2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, thread, thread2)) == null) {
                if (thread == thread2) {
                    return 0;
                }
                Thread thread3 = this.a;
                if (thread == thread3) {
                    return 1;
                }
                if (thread2 == thread3) {
                    return -1;
                }
                return thread2.getName().compareTo(thread.getName());
            }
            return invokeLL.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ANRError(ANRError$$._Thread _thread, long j) {
        super("Application Not Responding for at least " + j + " ms.", _thread);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {_thread, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Throwable) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.duration = j;
        this.st = _thread;
    }

    public static ANRError New(long j, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), str, Boolean.valueOf(z)})) == null) {
            Thread thread = Looper.getMainLooper().getThread();
            TreeMap treeMap = new TreeMap(new a(thread));
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                if (entry.getKey() == thread || (entry.getKey().getName().startsWith(str) && (z || entry.getValue().length > 0))) {
                    treeMap.put(entry.getKey(), entry.getValue());
                }
            }
            if (!treeMap.containsKey(thread)) {
                treeMap.put(thread, thread.getStackTrace());
            }
            ANRError$$._Thread _thread = null;
            for (Map.Entry entry2 : treeMap.entrySet()) {
                ANRError$$ aNRError$$ = new ANRError$$(getThreadTitle((Thread) entry2.getKey()), (StackTraceElement[]) entry2.getValue(), (a) null);
                aNRError$$.getClass();
                _thread = new ANRError$$._Thread(aNRError$$, _thread, null);
            }
            return new ANRError(_thread, j);
        }
        return (ANRError) invokeCommon.objValue;
    }

    public static ANRError NewMainAllStackTrace(LinkedHashMap<Long, StackTraceElement[]> linkedHashMap, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, linkedHashMap, j)) == null) {
            if (linkedHashMap == null || linkedHashMap.size() <= 0) {
                return null;
            }
            ANRError$$ aNRError$$ = new ANRError$$(getThreadTitle(Looper.getMainLooper().getThread()), linkedHashMap, (a) null);
            aNRError$$.getClass();
            return new ANRError(new ANRError$$._Thread(aNRError$$, null, null), j);
        }
        return (ANRError) invokeLJ.objValue;
    }

    public static ANRError NewMainOnly(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) {
            Thread thread = Looper.getMainLooper().getThread();
            ANRError$$ aNRError$$ = new ANRError$$(getThreadTitle(thread), thread.getStackTrace(), (a) null);
            aNRError$$.getClass();
            return new ANRError(new ANRError$$._Thread(aNRError$$, null, null), j);
        }
        return (ANRError) invokeJ.objValue;
    }

    public static String getThreadTitle(Thread thread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, thread)) == null) {
            return thread.getName() + " (state = " + thread.getState() + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }
        return (Throwable) invokeV.objValue;
    }

    public LinkedHashMap<Long, StackTraceElement[]> getSTStackMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ANRError$$._Thread _thread = this.st;
            if (_thread != null) {
                return _thread.getStackMap();
            }
            return null;
        }
        return (LinkedHashMap) invokeV.objValue;
    }

    public StackTraceElement[] getSTStackTrace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ANRError$$._Thread _thread = this.st;
            if (_thread != null) {
                return _thread.getStackTrace();
            }
            return null;
        }
        return (StackTraceElement[]) invokeV.objValue;
    }
}
