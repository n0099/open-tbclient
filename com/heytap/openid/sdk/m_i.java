package com.heytap.openid.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes10.dex */
public class m_i extends com.heytap.openid.base.m_c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    /* loaded from: classes10.dex */
    public class m_a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Keep
        public final /* synthetic */ m_i m_a;

        public m_a(m_i m_iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m_iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m_a = m_iVar;
        }

        @Override // android.content.ServiceConnection
        @Keep
        public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

        @Override // android.content.ServiceConnection
        @Keep
        public native void onServiceDisconnected(ComponentName componentName);
    }

    @Keep
    /* loaded from: classes10.dex */
    public static class m_b {
        public static /* synthetic */ Interceptable $ic;
        @Keep
        public static final m_i m_a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1684634953, "Lcom/heytap/openid/sdk/m_i$m_b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1684634953, "Lcom/heytap/openid/sdk/m_i$m_b;");
                    return;
                }
            }
            m_a = new m_i();
        }
    }

    public m_i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m_e = new m_a(this);
    }

    @Override // com.heytap.openid.base.m_c
    @Keep
    public native Intent m_a();

    @Override // com.heytap.openid.base.m_c
    @Keep
    public native void m_a(Context context, String str, String str2);

    @Override // com.heytap.openid.base.m_c
    @Keep
    public native boolean m_a(String str);

    @Override // com.heytap.openid.base.m_c
    @Keep
    public native boolean m_b(String str);

    @Override // com.heytap.openid.base.m_c
    @Keep
    public native String m_c(String str);
}
