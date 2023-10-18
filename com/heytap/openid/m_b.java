package com.heytap.openid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes9.dex */
public interface m_b extends IInterface {

    @Keep
    /* loaded from: classes9.dex */
    public static abstract class m_a extends Binder implements m_b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Keep
        /* renamed from: com.heytap.openid.m_b$m_a$m_a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static class C0563m_a implements m_b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @Keep
            public IBinder m_a;

            public C0563m_a(IBinder iBinder) {
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

            @Override // com.heytap.openid.m_b
            @Keep
            public native String m_b(String str, String str2, String str3);
        }

        @Keep
        public static native m_b m_a(IBinder iBinder);
    }

    @Keep
    String m_b(String str, String str2, String str3);
}
