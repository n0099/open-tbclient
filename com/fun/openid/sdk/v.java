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
    public Context f62925a;

    /* renamed from: b  reason: collision with root package name */
    public t f62926b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f62927c;

    /* renamed from: d  reason: collision with root package name */
    public a f62928d;

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
        this.f62925a = null;
        this.f62928d = null;
    }
}
