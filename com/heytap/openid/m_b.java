package com.heytap.openid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public interface m_b extends IInterface {

    /* loaded from: classes7.dex */
    public abstract class m_a extends Binder implements m_b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.heytap.openid.m_b$m_a$m_a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0513m_a implements m_b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder m_a;

            public C0513m_a(IBinder iBinder) {
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
            public native IBinder asBinder();

            @Override // com.heytap.openid.m_b
            public native String m_b(String str, String str2, String str3);
        }

        public static native m_b m_a(IBinder iBinder);
    }

    String m_b(String str, String str2, String str3);
}
