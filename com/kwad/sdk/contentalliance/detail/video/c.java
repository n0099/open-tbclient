package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f71778a;

    /* renamed from: b  reason: collision with root package name */
    public String f71779b;

    /* renamed from: c  reason: collision with root package name */
    public VideoPlayerStatus f71780c;

    /* renamed from: d  reason: collision with root package name */
    public b f71781d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f71782e;

    /* renamed from: com.kwad.sdk.contentalliance.detail.video.c$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f71783a;

        /* renamed from: b  reason: collision with root package name */
        public String f71784b;

        /* renamed from: c  reason: collision with root package name */
        public VideoPlayerStatus f71785c;

        /* renamed from: d  reason: collision with root package name */
        public b f71786d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f71787e;

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
            this.f71787e = false;
        }

        public a a(@NonNull b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                this.f71786d = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoPlayerStatus)) == null) {
                this.f71785c = videoPlayerStatus;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f71783a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f71787e = z;
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
                this.f71784b = str;
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
        this.f71781d = new b();
        this.f71782e = false;
        this.f71778a = aVar.f71783a;
        this.f71779b = aVar.f71784b;
        this.f71780c = aVar.f71785c;
        if (aVar.f71786d != null) {
            this.f71781d.f71774a = aVar.f71786d.f71774a;
            this.f71781d.f71775b = aVar.f71786d.f71775b;
            this.f71781d.f71776c = aVar.f71786d.f71776c;
            this.f71781d.f71777d = aVar.f71786d.f71777d;
        }
        this.f71782e = aVar.f71787e;
    }

    public /* synthetic */ c(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }
}
