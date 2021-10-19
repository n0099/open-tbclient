package com.kwad.sdk.reward.b.b.a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC2017a f73656a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public b f73657b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f73658c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f73659d;

    /* renamed from: e  reason: collision with root package name */
    public int f73660e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f73661f;

    /* renamed from: g  reason: collision with root package name */
    public final long f73662g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f73663h;

    /* renamed from: com.kwad.sdk.reward.b.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC2017a {
        void a(boolean z);
    }

    /* loaded from: classes10.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73658c = adTemplate;
        this.f73659d = com.kwad.sdk.core.response.b.c.i(adTemplate);
        this.f73660e = i2;
        this.f73661f = new Handler(Looper.getMainLooper());
        this.f73663h = false;
        long g2 = com.kwad.sdk.core.response.b.b.g(adTemplate);
        this.f73662g = g2 == 0 ? 1000L : g2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65538, this, z) == null) || this.f73656a == null) {
            return;
        }
        com.kwad.sdk.core.d.a.a("ActionBarControl", "showNativeActionBar");
        this.f73656a.a(z);
    }

    private boolean c(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65543, this, i2, i3)) == null) {
            if (com.kwad.sdk.core.response.b.a.K(this.f73659d)) {
                return this.f73660e == 1 ? i2 <= i3 : i2 >= i3;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public void a(int i2, int i3) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || c(i2, i3)) {
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.i(this.f73658c) || (bVar = this.f73657b) == null) {
            a(false);
        } else if (bVar.a()) {
        } else {
            this.f73661f.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.reward.b.b.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f73664a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73664a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f73664a.f73663h = true;
                        com.kwad.sdk.core.d.a.a("ActionBarControl", "mHasOutTime");
                        if (this.f73664a.f73657b != null && this.f73664a.f73657b.a()) {
                            com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success on " + this.f73664a.f73662g);
                            return;
                        }
                        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar out " + this.f73664a.f73662g);
                        d.c(this.f73664a.f73658c, this.f73664a.f73662g);
                        this.f73664a.a(true);
                    }
                }
            }, this.f73662g);
        }
    }

    @MainThread
    public void a(InterfaceC2017a interfaceC2017a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC2017a) == null) {
            this.f73656a = interfaceC2017a;
        }
    }

    @MainThread
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f73657b = bVar;
        }
    }

    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            if (this.f73663h) {
                com.kwad.sdk.core.d.a.c("ActionBarControl", "showWebActionBar time out on pageStatus");
                return;
            }
            this.f73661f.removeCallbacksAndMessages(null);
            if (c(i2, i3)) {
                return;
            }
            if (!com.kwad.sdk.core.response.b.b.i(this.f73658c) || this.f73657b == null) {
                a(true);
                return;
            }
            com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success in " + this.f73662g);
            this.f73657b.a();
        }
    }
}
