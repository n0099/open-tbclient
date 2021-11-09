package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f64253a;

    /* renamed from: b  reason: collision with root package name */
    public String f64254b;

    /* renamed from: c  reason: collision with root package name */
    public VideoPlayerStatus f64255c;

    /* renamed from: d  reason: collision with root package name */
    public b f64256d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64257e;

    /* renamed from: com.kwad.sdk.contentalliance.detail.video.c$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f64258a;

        /* renamed from: b  reason: collision with root package name */
        public String f64259b;

        /* renamed from: c  reason: collision with root package name */
        public VideoPlayerStatus f64260c;

        /* renamed from: d  reason: collision with root package name */
        public b f64261d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f64262e;

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
            this.f64262e = false;
        }

        public a a(@NonNull b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                this.f64261d = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoPlayerStatus)) == null) {
                this.f64260c = videoPlayerStatus;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f64258a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f64262e = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new c(this, null) : (c) invokeV.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f64259b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64256d = new b();
        this.f64257e = false;
        this.f64253a = aVar.f64258a;
        this.f64254b = aVar.f64259b;
        this.f64255c = aVar.f64260c;
        if (aVar.f64261d != null) {
            this.f64256d.f64249a = aVar.f64261d.f64249a;
            this.f64256d.f64250b = aVar.f64261d.f64250b;
            this.f64256d.f64251c = aVar.f64261d.f64251c;
            this.f64256d.f64252d = aVar.f64261d.f64252d;
        }
        this.f64257e = aVar.f64262e;
    }

    public /* synthetic */ c(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }
}
