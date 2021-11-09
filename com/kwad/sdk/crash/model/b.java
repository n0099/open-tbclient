package com.kwad.sdk.crash.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f65468a;

    /* renamed from: b  reason: collision with root package name */
    public String f65469b;

    /* renamed from: c  reason: collision with root package name */
    public int f65470c;

    /* renamed from: d  reason: collision with root package name */
    public String f65471d;

    /* renamed from: e  reason: collision with root package name */
    public int f65472e;

    /* renamed from: f  reason: collision with root package name */
    public int f65473f;

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
