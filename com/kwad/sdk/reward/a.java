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
/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<com.kwad.sdk.reward.a.a> f66010a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f66011b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public KsVideoPlayConfig f66012c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f66013d;

    /* renamed from: e  reason: collision with root package name */
    public int f66014e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f66015f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f66016g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public AdBaseFrameLayout f66017h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f66018i;
    @Nullable
    public com.kwad.sdk.core.download.b.b j;
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
        this.f66010a = new ArrayList();
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
            this.f66010a.clear();
            this.v.clear();
            this.f66018i.i();
            com.kwad.sdk.core.download.b.b bVar = this.j;
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

    public void a(long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            for (com.kwad.sdk.reward.a.d dVar : this.p) {
                dVar.a(j, j2, i2);
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
            Activity activity = this.f66016g;
            if (activity != null) {
                activity.runOnUiThread(new Runnable(this) { // from class: com.kwad.sdk.reward.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f66019a;

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
                        this.f66019a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f66019a.b();
                        }
                    }
                });
            } else {
                this.w.post(new Runnable(this) { // from class: com.kwad.sdk.reward.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f66020a;

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
                        this.f66020a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f66020a.b();
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
