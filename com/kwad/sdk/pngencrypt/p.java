package com.kwad.sdk.pngencrypt;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final k f73590a;

    /* renamed from: b  reason: collision with root package name */
    public final e f73591b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f73592c;

    /* renamed from: d  reason: collision with root package name */
    public int f73593d;

    /* renamed from: e  reason: collision with root package name */
    public int f73594e;

    /* renamed from: f  reason: collision with root package name */
    public int f73595f;

    /* renamed from: g  reason: collision with root package name */
    public int f73596g;

    /* renamed from: h  reason: collision with root package name */
    public int f73597h;

    /* renamed from: i  reason: collision with root package name */
    public int f73598i;

    /* renamed from: j  reason: collision with root package name */
    public int f73599j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;

    public p(k kVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73590a = kVar;
        this.f73591b = eVar;
        this.f73592c = eVar != null;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f73597h = i2;
            if (!this.f73592c) {
                this.n = 1;
                this.f73593d = 1;
                this.f73594e = 1;
                this.f73595f = 0;
                this.f73596g = 0;
                this.f73599j = i2;
                this.f73598i = i2;
                k kVar = this.f73590a;
                this.k = kVar.f73567b;
                this.l = kVar.f73566a;
                this.m = kVar.k;
                return;
            }
            this.n = this.f73591b.d();
            e eVar = this.f73591b;
            this.f73594e = eVar.f73553c;
            this.f73593d = eVar.f73552b;
            this.f73596g = eVar.f73555e;
            this.f73595f = eVar.f73554d;
            this.f73598i = eVar.c();
            this.f73599j = this.f73591b.b();
            this.k = this.f73591b.e();
            int f2 = this.f73591b.f();
            this.l = f2;
            this.m = ((this.f73590a.f73574i * f2) + 7) / 8;
        }
    }

    public void a(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2) == null) {
            this.o = bArr;
            this.p = i2;
        }
    }
}
