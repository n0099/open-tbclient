package com.kwad.sdk.core.response.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f57810b;

    /* renamed from: c  reason: collision with root package name */
    public int f57811c;

    /* renamed from: d  reason: collision with root package name */
    public int f57812d;

    /* renamed from: e  reason: collision with root package name */
    public String f57813e;

    /* renamed from: f  reason: collision with root package name */
    public String f57814f;

    /* renamed from: g  reason: collision with root package name */
    public int f57815g;

    /* renamed from: h  reason: collision with root package name */
    public int f57816h;

    /* renamed from: i  reason: collision with root package name */
    public int f57817i;

    /* renamed from: j  reason: collision with root package name */
    public int f57818j;

    /* renamed from: k  reason: collision with root package name */
    public transient List<AdTemplate> f57819k;

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
                return;
            }
        }
        this.f57811c = 1;
        this.f57815g = 1;
        this.f57816h = 1;
        this.f57817i = 1;
        this.f57818j = 1;
    }
}
