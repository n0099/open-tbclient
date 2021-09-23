package com.kwad.sdk.reward;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<com.kwad.sdk.reward.a.a> f73567a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f73568b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public KsVideoPlayConfig f73569c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f73570d;

    /* renamed from: e  reason: collision with root package name */
    public int f73571e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f73572f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f73573g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public AdBaseFrameLayout f73574h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f73575i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f73576j;
    @NonNull
    public com.kwad.sdk.reward.b.b.a.a k;
    @Nullable
    public com.kwad.sdk.d.c l;
    @Nullable
    public com.kwad.sdk.d.a m;
    @Nullable
    public com.kwad.sdk.d.b n;
    public Set<com.kwad.sdk.reward.a.e> o;
    public Set<com.kwad.sdk.reward.a.d> p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public Set<com.kwad.sdk.reward.a.f> v;
    public Handler w;

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
        this.f73567a = new ArrayList();
        this.v = new HashSet();
        this.o = new HashSet();
        this.p = new HashSet();
        this.s = false;
        this.t = false;
        this.w = new Handler(Looper.getMainLooper());
        this.u = false;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? Looper.getMainLooper() == Looper.myLooper() : invokeV.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            for (com.kwad.sdk.reward.a.f fVar : this.v) {
                fVar.a();
            }
        }
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f73567a.clear();
            this.v.clear();
            this.f73575i.i();
            com.kwad.sdk.core.download.b.b bVar = this.f73576j;
            if (bVar != null) {
                bVar.f();
            }
            com.kwad.sdk.d.c cVar = this.l;
            if (cVar != null) {
                cVar.f();
            }
            com.kwad.sdk.d.b bVar2 = this.n;
            if (bVar2 != null) {
                bVar2.f();
            }
            Set<com.kwad.sdk.reward.a.d> set = this.p;
            if (set != null) {
                set.clear();
            }
        }
    }

    public void a(long j2, long j3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
            for (com.kwad.sdk.reward.a.d dVar : this.p) {
                dVar.a(j2, j3, i2);
            }
        }
    }

    @MainThread
    public void a(com.kwad.sdk.reward.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.v.add(fVar);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c()) {
                d();
                return;
            }
            Activity activity = this.f73573g;
            if (activity != null) {
                activity.runOnUiThread(new Runnable(this) { // from class: com.kwad.sdk.reward.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f73577a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f73577a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f73577a.b();
                        }
                    }
                });
            } else {
                this.w.post(new Runnable(this) { // from class: com.kwad.sdk.reward.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f73578a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f73578a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f73578a.b();
                        }
                    }
                });
            }
        }
    }

    @MainThread
    public void b(com.kwad.sdk.reward.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.v.remove(fVar);
        }
    }
}
