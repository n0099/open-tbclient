package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class h extends com.kwad.sdk.contentalliance.detail.photo.f.a<i> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public long f34803d;

    /* renamed from: e  reason: collision with root package name */
    public i f34804e;

    /* renamed from: f  reason: collision with root package name */
    public long f34805f;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Set<Long> f34806a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(81179552, "Lcom/kwad/sdk/contentalliance/detail/photo/f/h$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(81179552, "Lcom/kwad/sdk/contentalliance/detail/photo/f/h$a;");
                    return;
                }
            }
            f34806a = new HashSet();
        }

        public static void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(65537, null, j) == null) {
                f34806a.add(Long.valueOf(j));
            }
        }

        public static void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(65538, null, j) == null) {
                f34806a.remove(Long.valueOf(j));
            }
        }

        public static boolean c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) ? f34806a.contains(Long.valueOf(j)) : invokeJ.booleanValue;
        }
    }

    public h() {
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
        this.f34805f = 0L;
    }

    private long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            long s = com.kwad.sdk.core.response.b.c.s(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j);
            if (s < 0) {
                s = 0;
            }
            return a.c(this.f34803d) ? s + 1 : s;
        }
        return invokeV.longValue;
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f34803d = com.kwad.sdk.core.response.b.c.z(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j);
            this.f34805f = p();
            this.f34804e.a(a.c(this.f34803d) ? 2 : 1, this.f34805f);
            this.f34804e.setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f34804e.setOnClickListener(null);
            this.f34804e.b();
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34804e = f();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    /* renamed from: e */
    public i g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new i(o()) : (i) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f34804e.a()) {
                com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j, 2, 1);
                return;
            }
            this.f34804e.setLikeState(2);
            i iVar = this.f34804e;
            long j = this.f34805f + 1;
            this.f34805f = j;
            iVar.setLikeCount(j);
            a.a(this.f34803d);
            com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j, 1, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (this.f34804e.a()) {
                this.f34804e.setLikeState(1);
                i iVar = this.f34804e;
                long j = this.f34805f - 1;
                this.f34805f = j;
                iVar.setLikeCount(j);
                a.b(this.f34803d);
                com.kwad.sdk.core.report.e.d(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j);
                return;
            }
            this.f34804e.setLikeState(2);
            i iVar2 = this.f34804e;
            long j2 = this.f34805f + 1;
            this.f34805f = j2;
            iVar2.setLikeCount(j2);
            a.a(this.f34803d);
            com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j, 1, 2);
        }
    }
}
