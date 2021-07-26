package com.win.opensdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class q0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int[] f39913a;

    /* renamed from: b  reason: collision with root package name */
    public int f39914b;

    /* renamed from: c  reason: collision with root package name */
    public int f39915c;

    /* renamed from: d  reason: collision with root package name */
    public p0 f39916d;

    /* renamed from: e  reason: collision with root package name */
    public List f39917e;

    /* renamed from: f  reason: collision with root package name */
    public int f39918f;

    /* renamed from: g  reason: collision with root package name */
    public int f39919g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39920h;

    /* renamed from: i  reason: collision with root package name */
    public int f39921i;
    public int j;
    public int k;
    public int l;
    public int m;

    public q0() {
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
        this.f39913a = null;
        this.f39914b = 0;
        this.f39915c = 0;
        this.f39917e = new ArrayList();
        this.m = 0;
    }
}
