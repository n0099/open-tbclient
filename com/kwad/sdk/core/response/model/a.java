package com.kwad.sdk.core.response.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f58391b;

    /* renamed from: c  reason: collision with root package name */
    public int f58392c;

    /* renamed from: d  reason: collision with root package name */
    public int f58393d;

    /* renamed from: e  reason: collision with root package name */
    public String f58394e;

    /* renamed from: f  reason: collision with root package name */
    public String f58395f;

    /* renamed from: g  reason: collision with root package name */
    public int f58396g;

    /* renamed from: h  reason: collision with root package name */
    public int f58397h;

    /* renamed from: i  reason: collision with root package name */
    public int f58398i;

    /* renamed from: j  reason: collision with root package name */
    public int f58399j;

    /* renamed from: k  reason: collision with root package name */
    public transient List<AdTemplate> f58400k;

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
        this.f58392c = 1;
        this.f58396g = 1;
        this.f58397h = 1;
        this.f58398i = 1;
        this.f58399j = 1;
    }
}
