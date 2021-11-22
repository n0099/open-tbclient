package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.loader.a;
import java.io.File;
/* loaded from: classes2.dex */
public class SecurityChecker {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile State f64831a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final State DATA_VALID;
        public static final State INIT;
        public static final State MD5;
        public static final State SUCCESS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1020222981, "Lcom/kwad/sdk/api/loader/SecurityChecker$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1020222981, "Lcom/kwad/sdk/api/loader/SecurityChecker$State;");
                    return;
                }
            }
            INIT = new State("INIT", 0);
            DATA_VALID = new State("DATA_VALID", 1);
            MD5 = new State("MD5", 2);
            State state = new State(com.alipay.security.mobile.module.http.model.c.p, 3);
            SUCCESS = state;
            $VALUES = new State[]{INIT, DATA_VALID, MD5, state};
        }

        public State(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static State valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (State) Enum.valueOf(State.class, str) : (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (State[]) $VALUES.clone() : (State[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface a {
        void a(Exception exc);

        void a(boolean z, State state);
    }

    public static void a(File file, a.C1927a c1927a, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, file, c1927a, aVar) == null) {
            i.a(new Runnable(c1927a, file, aVar) { // from class: com.kwad.sdk.api.loader.SecurityChecker.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a.C1927a f64832a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ File f64833b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f64834c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1927a, file, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f64832a = c1927a;
                    this.f64833b = file;
                    this.f64834c = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        State unused = SecurityChecker.f64831a = State.INIT;
                        try {
                            boolean z = this.f64832a != null && SecurityChecker.b(this.f64833b) && SecurityChecker.b(this.f64833b, this.f64832a.f64837c);
                            if (z) {
                                State unused2 = SecurityChecker.f64831a = State.SUCCESS;
                            }
                            a aVar2 = this.f64834c;
                            if (aVar2 != null) {
                                aVar2.a(z, SecurityChecker.f64831a);
                            }
                        } catch (Exception e2) {
                            a aVar3 = this.f64834c;
                            if (aVar3 != null) {
                                aVar3.a(e2);
                            }
                        }
                    }
                }
            });
        }
    }

    public static boolean b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, file)) == null) {
            f64831a = State.DATA_VALID;
            return file != null && file.exists() && file.getName().endsWith(".apk") && file.length() > 0;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, file, str)) == null) {
            f64831a = State.MD5;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.toLowerCase().equals(p.a(file).toLowerCase());
        }
        return invokeLL.booleanValue;
    }
}
