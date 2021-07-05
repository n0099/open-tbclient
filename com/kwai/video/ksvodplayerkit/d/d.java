package com.kwai.video.ksvodplayerkit.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f39940a;

    /* renamed from: b  reason: collision with root package name */
    public long f39941b;

    /* renamed from: c  reason: collision with root package name */
    public int f39942c;

    /* renamed from: d  reason: collision with root package name */
    public long f39943d;

    /* renamed from: e  reason: collision with root package name */
    public long f39944e;

    /* renamed from: f  reason: collision with root package name */
    public int f39945f;

    /* renamed from: g  reason: collision with root package name */
    public int f39946g;

    /* renamed from: h  reason: collision with root package name */
    public double f39947h;

    /* renamed from: i  reason: collision with root package name */
    public int f39948i;
    public int j;
    public int k;

    public d() {
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
        this.f39940a = 1;
        this.f39941b = 614400L;
        this.f39942c = -1;
        this.f39943d = 1048576L;
        this.f39944e = 819200L;
        this.f39945f = 3000;
        this.f39946g = 3000;
        this.f39947h = 0.5d;
        this.f39948i = 3;
        this.j = -1;
        this.k = 200;
    }
}
