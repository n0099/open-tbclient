package com.fun.openid.sdk;

import android.content.Context;
import android.content.ServiceConnection;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f32988a;

    /* renamed from: b  reason: collision with root package name */
    public s f32989b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f32990c;

    /* renamed from: d  reason: collision with root package name */
    public a f32991d;

    /* loaded from: classes5.dex */
    public interface a<T> {
    }

    public u() {
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
        this.f32988a = null;
        this.f32991d = null;
    }
}
