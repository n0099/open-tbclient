package com.win.opensdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class T {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f42468a;

    /* renamed from: b  reason: collision with root package name */
    public int f42469b;

    /* renamed from: c  reason: collision with root package name */
    public int f42470c;

    /* renamed from: d  reason: collision with root package name */
    public int f42471d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42472e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42473f;

    /* renamed from: g  reason: collision with root package name */
    public int f42474g;

    /* renamed from: h  reason: collision with root package name */
    public int f42475h;

    /* renamed from: i  reason: collision with root package name */
    public int f42476i;
    public int j;
    public int[] k;

    public T() {
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
