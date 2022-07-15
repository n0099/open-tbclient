package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
/* renamed from: com.kuaishou.weapon.p0.ʽˑ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0372 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static volatile C0372 f218;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f219;

    /* renamed from: com.kuaishou.weapon.p0.ʽˑ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public class RunnableC0373 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ C0372 f220;

        public RunnableC0373(C0372 c0372) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0372};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f220 = c0372;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    C0374 m389 = C0374.m389(this.f220.f219);
                    if (m389.m392(C0374.f221, 0) == 1) {
                        long m418 = m389.m418(C0374.f277);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - m418 >= m389.m392(C0374.f292, 2) * 3600000) {
                            try {
                                String m281 = new C0335(this.f220.f219).m281(C0331.f83);
                                int intValue = Integer.valueOf(C0331.f83).intValue();
                                if (m281 != null && m281.length() > 10) {
                                    new C0411(this.f220.f219, m281, intValue).m586(Constants.DEFAULT_UIN);
                                }
                            } catch (Throwable unused) {
                            }
                            m389.m412(C0374.f277, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public C0372(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f219 = context;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static C0372 m387(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f218 == null) {
                synchronized (C0372.class) {
                    if (f218 == null) {
                        f218 = new C0372(context);
                    }
                }
            }
            return f218;
        }
        return (C0372) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m388() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            C0358.m366().m367(new RunnableC0373(this));
        }
    }
}
