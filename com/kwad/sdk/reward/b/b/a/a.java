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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0440a f36123a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public b f36124b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f36125c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f36126d;

    /* renamed from: e  reason: collision with root package name */
    public int f36127e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f36128f;

    /* renamed from: g  reason: collision with root package name */
    public final long f36129g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36130h;

    /* renamed from: com.kwad.sdk.reward.b.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0440a {
        void a(boolean z);
    }

    /* loaded from: classes6.dex */
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
        this.f36125c = adTemplate;
        this.f36126d = com.kwad.sdk.core.response.b.c.i(adTemplate);
        this.f36127e = i2;
        this.f36128f = new Handler(Looper.getMainLooper());
        this.f36130h = false;
        long g2 = com.kwad.sdk.core.response.b.b.g(adTemplate);
        this.f36129g = g2 == 0 ? 1000L : g2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65538, this, z) == null) || this.f36123a == null) {
            return;
        }
        com.kwad.sdk.core.d.a.a("ActionBarControl", "showNativeActionBar");
        this.f36123a.a(z);
    }

    private boolean c(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65543, this, i2, i3)) == null) {
            if (com.kwad.sdk.core.response.b.a.K(this.f36126d)) {
                return this.f36127e == 1 ? i2 <= i3 : i2 >= i3;
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
        if (!com.kwad.sdk.core.response.b.b.i(this.f36125c) || (bVar = this.f36124b) == null) {
            a(false);
        } else if (bVar.a()) {
        } else {
            this.f36128f.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.reward.b.b.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f36131a;

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
                    this.f36131a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f36131a.f36130h = true;
                        com.kwad.sdk.core.d.a.a("ActionBarControl", "mHasOutTime");
                        if (this.f36131a.f36124b != null && this.f36131a.f36124b.a()) {
                            com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success on " + this.f36131a.f36129g);
                            return;
                        }
                        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar out " + this.f36131a.f36129g);
                        d.c(this.f36131a.f36125c, this.f36131a.f36129g);
                        this.f36131a.a(true);
                    }
                }
            }, this.f36129g);
        }
    }

    @MainThread
    public void a(InterfaceC0440a interfaceC0440a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0440a) == null) {
            this.f36123a = interfaceC0440a;
        }
    }

    @MainThread
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f36124b = bVar;
        }
    }

    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            if (this.f36130h) {
                com.kwad.sdk.core.d.a.c("ActionBarControl", "showWebActionBar time out on pageStatus");
                return;
            }
            this.f36128f.removeCallbacksAndMessages(null);
            if (c(i2, i3)) {
                return;
            }
            if (!com.kwad.sdk.core.response.b.b.i(this.f36125c) || this.f36124b == null) {
                a(true);
                return;
            }
            com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success in " + this.f36129g);
            this.f36124b.a();
        }
    }
}
