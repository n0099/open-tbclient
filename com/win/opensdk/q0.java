package com.win.opensdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class q0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int[] f76760a;

    /* renamed from: b  reason: collision with root package name */
    public int f76761b;

    /* renamed from: c  reason: collision with root package name */
    public int f76762c;

    /* renamed from: d  reason: collision with root package name */
    public p0 f76763d;

    /* renamed from: e  reason: collision with root package name */
    public List f76764e;

    /* renamed from: f  reason: collision with root package name */
    public int f76765f;

    /* renamed from: g  reason: collision with root package name */
    public int f76766g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f76767h;

    /* renamed from: i  reason: collision with root package name */
    public int f76768i;

    /* renamed from: j  reason: collision with root package name */
    public int f76769j;
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
        this.f76760a = null;
        this.f76761b = 0;
        this.f76762c = 0;
        this.f76764e = new ArrayList();
        this.m = 0;
    }
}
