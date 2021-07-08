package com.kwad.sdk.core.response.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f34906a;

    /* renamed from: b  reason: collision with root package name */
    public String f34907b;

    /* renamed from: c  reason: collision with root package name */
    public int f34908c;

    /* renamed from: d  reason: collision with root package name */
    public int f34909d;

    /* renamed from: e  reason: collision with root package name */
    public String f34910e;

    /* renamed from: f  reason: collision with root package name */
    public String f34911f;

    /* renamed from: g  reason: collision with root package name */
    public int f34912g;

    /* renamed from: h  reason: collision with root package name */
    public int f34913h;

    /* renamed from: i  reason: collision with root package name */
    public int f34914i;
    public int j;
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
        this.f34908c = 1;
        this.f34912g = 1;
        this.f34913h = 1;
        this.f34914i = 1;
        this.j = 1;
    }
}
