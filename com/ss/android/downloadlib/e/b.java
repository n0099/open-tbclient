package com.ss.android.downloadlib.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface a<T> {
        T b();
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static <T> T a(boolean z, String str, @NonNull a<T> aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Boolean.valueOf(z), str, aVar})) == null) {
            try {
                return aVar.b();
            } catch (Throwable th) {
                if (!(th instanceof com.ss.android.downloadlib.e.a)) {
                    c.a().a(z, th, str);
                    if (TextUtils.isEmpty(str)) {
                        throw th;
                    }
                    return null;
                }
                throw th;
            }
        }
        return (T) invokeCommon.objValue;
    }

    public static <T> T a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) ? (T) a(true, null, aVar) : (T) invokeL.objValue;
    }

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, runnable) == null) {
            a(new a<Void>(runnable) { // from class: com.ss.android.downloadlib.e.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Runnable f68773a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnable};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68773a = runnable;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.ss.android.downloadlib.e.b.a
                /* renamed from: a */
                public Void b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        this.f68773a.run();
                        return null;
                    }
                    return (Void) invokeV.objValue;
                }
            });
        }
    }
}
