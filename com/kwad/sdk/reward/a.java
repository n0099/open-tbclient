package com.kwad.sdk.reward;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<com.kwad.sdk.reward.a.f> A;
    public Handler B;
    public List<com.kwad.sdk.reward.a.a> a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f59450b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.a.d f59451c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public KsVideoPlayConfig f59452d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f59453e;

    /* renamed from: f  reason: collision with root package name */
    public int f59454f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f59455g;
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    public Activity f59456h;

    /* renamed from: i  reason: collision with root package name */
    public Context f59457i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public AdBaseFrameLayout f59458j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f59459k;
    @Nullable
    public com.kwad.sdk.core.download.a.b l;
    @Nullable
    public com.kwad.sdk.widget.e m;
    @NonNull
    public RewardActionBarControl n;
    @Nullable
    public com.kwad.sdk.i.b o;
    @Nullable
    public com.kwad.sdk.i.a p;
    public Set<com.kwad.sdk.reward.a.e> q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public List<Integer> w;
    public boolean x;
    @Nullable
    public com.kwad.sdk.reward.b.a.a y;
    @Nullable
    public com.kwad.sdk.reward.b.kwai.a z;

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
        this.a = new ArrayList();
        this.A = new HashSet();
        this.q = new HashSet();
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = new ArrayList();
        this.x = false;
        this.B = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i2) == null) {
            com.kwad.sdk.core.report.a.a(this.f59455g, i2, this.f59458j.getTouchCoords(), this.f59453e);
            this.f59450b.a();
        }
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? Looper.getMainLooper() == Looper.myLooper() : invokeV.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            for (com.kwad.sdk.reward.a.f fVar : this.A) {
                fVar.a();
            }
        }
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            this.A.clear();
            com.kwad.sdk.reward.c.a aVar = this.f59459k;
            if (aVar != null) {
                aVar.e();
            }
            com.kwad.sdk.core.download.a.b bVar = this.l;
            if (bVar != null) {
                bVar.i();
            }
            com.kwad.sdk.i.b bVar2 = this.o;
            if (bVar2 != null) {
                bVar2.f();
            }
            Set<com.kwad.sdk.reward.a.e> set = this.q;
            if (set != null) {
                set.clear();
            }
        }
    }

    public void a(long j2, long j3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
            for (com.kwad.sdk.reward.a.e eVar : this.q) {
                eVar.a(j2, j3, i2);
            }
        }
    }

    public void a(Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, context, i2, i3) == null) {
            com.kwad.sdk.core.download.a.a.a(new a.C2076a(context).a(this.f59455g).a(this.l).a(false).a(i3).a(new a.b(this, i2) { // from class: com.kwad.sdk.reward.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f59460b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59460b = this;
                    this.a = i2;
                }

                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f59460b.a(this.a);
                    }
                }
            }));
        }
    }

    @MainThread
    public void a(com.kwad.sdk.reward.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.A.add(fVar);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (c()) {
                d();
            } else {
                this.B.post(new Runnable(this) { // from class: com.kwad.sdk.reward.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a a;

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
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.b();
                        }
                    }
                });
            }
        }
    }

    @MainThread
    public void b(com.kwad.sdk.reward.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.A.remove(fVar);
        }
    }
}
