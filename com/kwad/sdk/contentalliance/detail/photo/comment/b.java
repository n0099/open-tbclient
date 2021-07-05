package com.kwad.sdk.contentalliance.detail.photo.comment;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoComment;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PhotoComment f34669a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f34670b;

    /* renamed from: c  reason: collision with root package name */
    public long f34671c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34672d;

    /* renamed from: e  reason: collision with root package name */
    public int f34673e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34674f;

    /* renamed from: g  reason: collision with root package name */
    public String f34675g;

    public b() {
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
        this.f34672d = false;
    }
}
