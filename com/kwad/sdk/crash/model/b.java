package com.kwad.sdk.crash.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f36971a;

    /* renamed from: b  reason: collision with root package name */
    public String f36972b;

    /* renamed from: c  reason: collision with root package name */
    public int f36973c;

    /* renamed from: d  reason: collision with root package name */
    public String f36974d;

    /* renamed from: e  reason: collision with root package name */
    public int f36975e;

    /* renamed from: f  reason: collision with root package name */
    public int f36976f;

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
