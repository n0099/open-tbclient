package com.heytap.openid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes9.dex */
public interface m_a extends IInterface {

    @Keep
    /* renamed from: com.heytap.openid.m_a$m_a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static abstract class AbstractBinderC0578m_a extends Binder implements m_a {
        public static /* synthetic */ Interceptable $ic;
        @Keep
        public static final String m_a;
        public transient /* synthetic */ FieldHolder $fh;

        @Keep
        /* renamed from: com.heytap.openid.m_a$m_a$m_a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static class C0579m_a implements m_a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @Keep
            public IBinder m_a;

            public C0579m_a(IBinder iBinder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iBinder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.m_a = iBinder;
            }

            @Override // android.os.IInterface
            @Keep
            public native IBinder asBinder();

            @Override // com.heytap.openid.m_a
            @Keep
            public native String m_a(String str, String str2, String str3);
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-589983747, "Lcom/heytap/openid/m_a$m_a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-589983747, "Lcom/heytap/openid/m_a$m_a;");
                    return;
                }
            }
            m_a = com.heytap.openid.sdk.m_a.m_a("Y29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA==");
        }

        @Keep
        public static native m_a m_a(IBinder iBinder);
    }

    @Keep
    String m_a(String str, String str2, String str3);
}
