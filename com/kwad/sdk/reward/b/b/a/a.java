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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1927a f66061a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public b f66062b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f66063c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f66064d;

    /* renamed from: e  reason: collision with root package name */
    public int f66065e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f66066f;

    /* renamed from: g  reason: collision with root package name */
    public final long f66067g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66068h;

    /* renamed from: com.kwad.sdk.reward.b.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1927a {
        void a(boolean z);
    }

    /* loaded from: classes2.dex */
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
        this.f66063c = adTemplate;
        this.f66064d = com.kwad.sdk.core.response.b.c.i(adTemplate);
        this.f66065e = i2;
        this.f66066f = new Handler(Looper.getMainLooper());
        this.f66068h = false;
        long g2 = com.kwad.sdk.core.response.b.b.g(adTemplate);
        this.f66067g = g2 == 0 ? 1000L : g2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65538, this, z) == null) || this.f66061a == null) {
            return;
        }
        com.kwad.sdk.core.d.a.a("ActionBarControl", "showNativeActionBar");
        this.f66061a.a(z);
    }

    private boolean c(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65543, this, i2, i3)) == null) {
            if (com.kwad.sdk.core.response.b.a.K(this.f66064d)) {
                return this.f66065e == 1 ? i2 <= i3 : i2 >= i3;
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
        if (!com.kwad.sdk.core.response.b.b.i(this.f66063c) || (bVar = this.f66062b) == null) {
            a(false);
        } else if (bVar.a()) {
        } else {
            this.f66066f.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.reward.b.b.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66069a;

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
                    this.f66069a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f66069a.f66068h = true;
                        com.kwad.sdk.core.d.a.a("ActionBarControl", "mHasOutTime");
                        if (this.f66069a.f66062b != null && this.f66069a.f66062b.a()) {
                            com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success on " + this.f66069a.f66067g);
                            return;
                        }
                        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar out " + this.f66069a.f66067g);
                        d.c(this.f66069a.f66063c, this.f66069a.f66067g);
                        this.f66069a.a(true);
                    }
                }
            }, this.f66067g);
        }
    }

    @MainThread
    public void a(InterfaceC1927a interfaceC1927a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1927a) == null) {
            this.f66061a = interfaceC1927a;
        }
    }

    @MainThread
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f66062b = bVar;
        }
    }

    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            if (this.f66068h) {
                com.kwad.sdk.core.d.a.c("ActionBarControl", "showWebActionBar time out on pageStatus");
                return;
            }
            this.f66066f.removeCallbacksAndMessages(null);
            if (c(i2, i3)) {
                return;
            }
            if (!com.kwad.sdk.core.response.b.b.i(this.f66063c) || this.f66062b == null) {
                a(true);
                return;
            }
            com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success in " + this.f66067g);
            this.f66062b.a();
        }
    }
}
