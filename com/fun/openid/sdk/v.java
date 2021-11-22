package com.fun.openid.sdk;

import android.content.Context;
import android.content.ServiceConnection;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f63825a;

    /* renamed from: b  reason: collision with root package name */
    public t f63826b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f63827c;

    /* renamed from: d  reason: collision with root package name */
    public a f63828d;

    /* loaded from: classes11.dex */
    public interface a<T> {
        void a(T t, v vVar);
    }

    public v() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63825a = null;
        this.f63828d = null;
    }
}
