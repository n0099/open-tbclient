package com.heytap.mcssdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f33568a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f33569b = "com.heytap.mcssdk";

    /* renamed from: c  reason: collision with root package name */
    public static final String f33570c = "release";

    /* renamed from: d  reason: collision with root package name */
    public static final String f33571d = "";

    /* renamed from: e  reason: collision with root package name */
    public static final int f33572e = 2002;

    /* renamed from: f  reason: collision with root package name */
    public static final String f33573f = "2.0.2";
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
