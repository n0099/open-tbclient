package com.win.opensdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class p0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f39901a;

    /* renamed from: b  reason: collision with root package name */
    public int f39902b;

    /* renamed from: c  reason: collision with root package name */
    public int f39903c;

    /* renamed from: d  reason: collision with root package name */
    public int f39904d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39905e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39906f;

    /* renamed from: g  reason: collision with root package name */
    public int f39907g;

    /* renamed from: h  reason: collision with root package name */
    public int f39908h;

    /* renamed from: i  reason: collision with root package name */
    public int f39909i;
    public int j;
    public int[] k;

    public p0() {
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
