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
    public int f72544a;

    /* renamed from: b  reason: collision with root package name */
    public String f72545b;

    /* renamed from: c  reason: collision with root package name */
    public int f72546c;

    /* renamed from: d  reason: collision with root package name */
    public int f72547d;

    /* renamed from: e  reason: collision with root package name */
    public String f72548e;

    /* renamed from: f  reason: collision with root package name */
    public String f72549f;

    /* renamed from: g  reason: collision with root package name */
    public int f72550g;

    /* renamed from: h  reason: collision with root package name */
    public int f72551h;

    /* renamed from: i  reason: collision with root package name */
    public int f72552i;

    /* renamed from: j  reason: collision with root package name */
    public int f72553j;
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
        this.f72546c = 1;
        this.f72550g = 1;
        this.f72551h = 1;
        this.f72552i = 1;
        this.f72553j = 1;
    }
}
