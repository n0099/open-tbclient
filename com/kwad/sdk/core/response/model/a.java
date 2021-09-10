package com.kwad.sdk.core.response.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f72225a;

    /* renamed from: b  reason: collision with root package name */
    public String f72226b;

    /* renamed from: c  reason: collision with root package name */
    public int f72227c;

    /* renamed from: d  reason: collision with root package name */
    public int f72228d;

    /* renamed from: e  reason: collision with root package name */
    public String f72229e;

    /* renamed from: f  reason: collision with root package name */
    public String f72230f;

    /* renamed from: g  reason: collision with root package name */
    public int f72231g;

    /* renamed from: h  reason: collision with root package name */
    public int f72232h;

    /* renamed from: i  reason: collision with root package name */
    public int f72233i;

    /* renamed from: j  reason: collision with root package name */
    public int f72234j;
    public transient List<AdTemplate> k;

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
        this.f72227c = 1;
        this.f72231g = 1;
        this.f72232h = 1;
        this.f72233i = 1;
        this.f72234j = 1;
    }
}
