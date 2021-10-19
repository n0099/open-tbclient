package com.kwad.sdk.crash.utils;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.crash.utils.e$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        public abstract Object a();

        public abstract void a(Object obj);
    }

    /* loaded from: classes10.dex */
    public static class b extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final PrintWriter f73054a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PrintWriter printWriter) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {printWriter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73054a = printWriter;
        }

        @Override // com.kwad.sdk.crash.utils.e.a
        public Object a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f73054a : invokeV.objValue;
        }

        @Override // com.kwad.sdk.crash.utils.e.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                this.f73054a.println(obj);
            }
        }
    }

    public static void a(Throwable th, a aVar) {
        StackTraceElement[] stackTrace;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, th, aVar) == null) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            newSetFromMap.add(th);
            synchronized (aVar.a()) {
                aVar.a(th);
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    aVar.a("\tat " + stackTraceElement);
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    for (Throwable th2 : th.getSuppressed()) {
                        a(th2, aVar, "Suppressed: ", TrackUI.SEPERATOR, newSetFromMap);
                    }
                }
                Throwable cause = th.getCause();
                if (cause != null) {
                    a(cause, aVar, "Caused by: ", "", newSetFromMap);
                }
            }
        }
    }

    public static void a(Throwable th, a aVar, String str, String str2, Set<Throwable> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, th, aVar, str, str2, set) == null) {
            if (set.contains(th)) {
                aVar.a("\t[CIRCULAR REFERENCE:" + th + PreferencesUtil.RIGHT_MOUNT);
                return;
            }
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            aVar.a(str2 + str + th);
            for (StackTraceElement stackTraceElement : stackTrace) {
                aVar.a(str2 + "\tat " + stackTraceElement);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                for (Throwable th2 : th.getSuppressed()) {
                    a(th2, aVar, "Suppressed: ", str2 + TrackUI.SEPERATOR, set);
                }
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, aVar, "Caused by: ", str2, set);
            }
        }
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, th, printWriter) == null) {
            a(th, new b(printWriter));
        }
    }
}
