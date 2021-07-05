package com.kwad.sdk.contentalliance.detail.photo.newui.d;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static volatile c f34892i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f34893a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f34894b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34895c;

    /* renamed from: d  reason: collision with root package name */
    public int f34896d;

    /* renamed from: e  reason: collision with root package name */
    public int f34897e;

    /* renamed from: f  reason: collision with root package name */
    public int f34898f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f34899g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f34900h;

    /* loaded from: classes7.dex */
    public interface a {
        void a(AdTemplate adTemplate, int i2);
    }

    public c() {
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
        this.f34894b = true;
        this.f34895c = true;
        this.f34897e = -1;
        this.f34899g = false;
        this.f34900h = false;
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f34892i == null) {
                synchronized (c.class) {
                    if (f34892i == null) {
                        f34892i = new c();
                    }
                }
            }
            return f34892i;
        }
        return (c) invokeV.objValue;
    }

    private boolean a(boolean z, @NonNull AdTemplate adTemplate, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Boolean.valueOf(z), adTemplate, Integer.valueOf(i2)})) == null) {
            com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "apply mNeedShowSlideUpGuide");
            if (this.f34894b) {
                return false;
            }
            com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "apply enablePageSlideLeft=" + z + " mNeedShowSlideLeftGuide=" + this.f34895c);
            if ((this.f34895c && z) || com.kwad.sdk.core.response.b.c.c(adTemplate)) {
                return false;
            }
            int e2 = c.a.ac.e();
            int i3 = this.f34897e;
            return i3 == -1 || i2 - i3 > e2;
        }
        return invokeCommon.booleanValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f34897e = i2;
            int i3 = this.f34896d + 1;
            this.f34896d = i3;
            if (i3 >= this.f34898f) {
                this.f34899g = true;
            }
            ae.b(this.f34893a, this.f34896d);
            com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "realShow mAlreadyShowTimes = " + this.f34896d + " mLastShowPosition=" + this.f34897e);
        }
    }

    @WorkerThread
    public void a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || this.f34900h) {
            return;
        }
        this.f34893a = context;
        this.f34896d = ae.a(context, 0);
        this.f34894b = ae.c(context);
        this.f34895c = ae.a(context);
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "init mNeedShowSlideLeftGuide=" + this.f34895c);
        this.f34900h = true;
    }

    public void a(@NonNull AdTemplate adTemplate, int i2, boolean z, @NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{adTemplate, Integer.valueOf(i2), Boolean.valueOf(z), aVar}) == null) {
            if (!this.f34900h || this.f34899g) {
                com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "apply !mInited || mNoLongerNeeded");
                return;
            }
            this.f34898f = c.a.ac.f();
            if (!com.kwad.sdk.core.config.c.B() || !com.kwad.sdk.core.config.c.Y() || this.f34896d >= this.f34898f) {
                this.f34899g = true;
            } else if (a(z, adTemplate, i2)) {
                aVar.a(adTemplate, i2);
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f34894b = z;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f34899g = true;
            this.f34896d = Integer.MAX_VALUE;
            ae.b(this.f34893a, Integer.MAX_VALUE);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f34895c = z;
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.f34896d;
            if (i2 == Integer.MAX_VALUE) {
                return 0;
            }
            return i2;
        }
        return invokeV.intValue;
    }
}
