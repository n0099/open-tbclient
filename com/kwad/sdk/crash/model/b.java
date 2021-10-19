package com.kwad.sdk.crash.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f73024a;

    /* renamed from: b  reason: collision with root package name */
    public String f73025b;

    /* renamed from: c  reason: collision with root package name */
    public int f73026c;

    /* renamed from: d  reason: collision with root package name */
    public String f73027d;

    /* renamed from: e  reason: collision with root package name */
    public int f73028e;

    /* renamed from: f  reason: collision with root package name */
    public int f73029f;

    public b() {
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
