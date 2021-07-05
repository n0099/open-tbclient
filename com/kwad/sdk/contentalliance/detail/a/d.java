package com.kwad.sdk.contentalliance.detail.a;

import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.profile.home.ProfileHomeParam;
import com.kwad.sdk.contentalliance.profile.home.model.ProfileResultData;
import com.kwad.sdk.contentalliance.profile.home.model.UserProfile;
import com.kwad.sdk.core.g.q;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.p;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static AccelerateDecelerateInterpolator L;
    public transient /* synthetic */ FieldHolder $fh;
    public List<com.kwad.sdk.contentalliance.home.swipe.a> A;
    public com.kwad.sdk.contentalliance.home.swipe.c B;
    public com.kwad.sdk.contentalliance.detail.video.b C;
    public boolean D;
    public SlidePlayTouchViewPager.a E;
    public com.kwad.sdk.contentalliance.detail.video.e F;
    public com.kwad.sdk.contentalliance.a.a G;
    public final com.kwad.sdk.contentalliance.home.swipe.a H;
    public com.kwad.sdk.contentalliance.home.a.d I;
    public View J;
    public LottieAnimationView K;
    public Runnable M;
    public Runnable N;
    public RecyclerView.OnScrollListener O;
    public boolean P;
    public i<q, ProfileResultData> Q;
    public Handler R;

    /* renamed from: b  reason: collision with root package name */
    public View f34431b;

    /* renamed from: c  reason: collision with root package name */
    public View f34432c;

    /* renamed from: d  reason: collision with root package name */
    public View f34433d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f34434e;

    /* renamed from: f  reason: collision with root package name */
    public SlidePlayViewPager f34435f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f34436g;

    /* renamed from: h  reason: collision with root package name */
    public int f34437h;

    /* renamed from: i  reason: collision with root package name */
    public View f34438i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public float m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public Float t;
    public int u;
    public int v;
    @Nullable
    public View w;
    public boolean x;
    public com.kwad.sdk.contentalliance.home.a.i y;
    public AdTemplate z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(976751657, "Lcom/kwad/sdk/contentalliance/detail/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(976751657, "Lcom/kwad/sdk/contentalliance/detail/a/d;");
                return;
            }
        }
        L = new AccelerateDecelerateInterpolator();
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = 1.0f;
        this.E = new SlidePlayTouchViewPager.a(this) { // from class: com.kwad.sdk.contentalliance.detail.a.d.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34451a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34451a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f34451a.D = true;
                }
            }
        };
        this.F = new f(this) { // from class: com.kwad.sdk.contentalliance.detail.a.d.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34452a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34452a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.b();
                    this.f34452a.a(true);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.c();
                    this.f34452a.a(false);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    super.d();
                    this.f34452a.a(true);
                }
            }
        };
        this.G = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.detail.a.d.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34453a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34453a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void j() {
                String str;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34453a.x = true;
                    this.f34453a.s();
                    if (this.f34453a.B != null) {
                        this.f34453a.B.a(this.f34453a.H);
                    }
                    if (this.f34453a.f34435f.getSourceType() == 1) {
                        com.kwad.sdk.lib.widget.recycler.d dVar = (com.kwad.sdk.lib.widget.recycler.d) this.f34453a.f34434e.getAdapter();
                        if (dVar != null) {
                            com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) dVar.c();
                            com.kwad.sdk.contentalliance.home.c.c e2 = bVar.e();
                            this.f34453a.y.a(bVar.f(), this.f34453a.z);
                            bVar.a(this.f34453a.w);
                            bVar.a(this.f34453a.z, this.f34453a.C);
                            e2.b(this.f34453a.z);
                            com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "scrollVerticallyToPosition becomesAttachedOnPageSelected");
                            this.f34453a.f34434e.removeCallbacks(this.f34453a.M);
                            this.f34453a.f34434e.removeCallbacks(this.f34453a.N);
                            this.f34453a.f34434e.post(this.f34453a.M);
                            e2.a(this.f34453a.I);
                            this.f34453a.f34434e.addOnScrollListener(this.f34453a.O);
                        }
                        str = "becomesAttachedOnPageSelected mPosition" + ((com.kwad.sdk.contentalliance.detail.b) this.f34453a).f34553a.f34582i + "--mSourceType=PROFILE--headerFooterAdapter=" + dVar;
                    } else {
                        str = "becomesAttachedOnPageSelected mPosition" + ((com.kwad.sdk.contentalliance.detail.b) this.f34453a).f34553a.f34582i + "--mSourceType=FEED--headerFooterAdapter=" + this.f34453a.f34434e.getAdapter();
                    }
                    com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", str);
                    this.f34453a.D = false;
                    this.f34453a.f34435f.a(this.f34453a.E);
                }
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void k() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f34453a.x = false;
                    if (this.f34453a.B.a() == this.f34453a.H) {
                        this.f34453a.B.a((com.kwad.sdk.contentalliance.home.swipe.a) null);
                    }
                    this.f34453a.f34434e.removeCallbacks(this.f34453a.M);
                    com.kwad.sdk.lib.widget.recycler.d dVar = (com.kwad.sdk.lib.widget.recycler.d) this.f34453a.f34434e.getAdapter();
                    if (dVar != null) {
                        com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) dVar.c();
                        com.kwad.sdk.contentalliance.home.c.c e2 = bVar.e();
                        if (this.f34453a.f34435f.getSourceType() == 0) {
                            if (this.f34453a.J != null) {
                                dVar.a(this.f34453a.J);
                                this.f34453a.K.d();
                                this.f34453a.J = null;
                            }
                            e2.b(this.f34453a.I);
                            e2.d();
                            bVar.k();
                            this.f34453a.f34434e.removeOnScrollListener(this.f34453a.O);
                            this.f34453a.f34434e.setAdapter(null);
                            this.f34453a.R.removeCallbacksAndMessages(null);
                        } else {
                            e2.b(this.f34453a.I);
                            e2.d();
                        }
                    }
                    com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "becomesDetachedOnPageSelected mPosition" + ((com.kwad.sdk.contentalliance.detail.b) this.f34453a).f34553a.f34582i + "--mSourceType=" + this.f34453a.f34435f.getSourceType() + "--headerFooterAdapter=" + this.f34453a.f34434e.getAdapter());
                    this.f34453a.f34435f.b(this.f34453a.E);
                }
            }
        };
        this.H = new com.kwad.sdk.contentalliance.home.swipe.a(this) { // from class: com.kwad.sdk.contentalliance.detail.a.d.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34454a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34454a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.swipe.a
            public void a(float f2) {
                View view;
                int i4;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeF(1048576, this, f2) == null) && this.f34454a.x) {
                    if (this.f34454a.f34434e.getAdapter() == null) {
                        this.f34454a.f();
                    }
                    this.f34454a.m = f2;
                    this.f34454a.a(f2);
                    if (f2 == 1.0f) {
                        view = this.f34454a.f34438i;
                        i4 = 8;
                    } else {
                        view = this.f34454a.f34438i;
                        i4 = 0;
                    }
                    view.setVisibility(i4);
                    for (com.kwad.sdk.contentalliance.home.swipe.a aVar : this.f34454a.A) {
                        aVar.a(f2);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.home.swipe.a
            public float b(float f2) {
                InterceptResult invokeF;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeF = interceptable2.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
                    if (this.f34454a.t == null) {
                        d dVar = this.f34454a;
                        dVar.t = Float.valueOf(dVar.f34433d.getTranslationX());
                    }
                    if (this.f34454a.t.floatValue() == 0.0f) {
                        if (f2 < 0.0f) {
                            return 0.0f;
                        }
                        return Math.min(1.0f, (Math.abs(f2) * 1.0f) / this.f34454a.s);
                    } else if (f2 > 0.0f) {
                        return 1.0f;
                    } else {
                        return Math.max(0.0f, 1.0f - ((Math.abs(f2) * 1.0f) / this.f34454a.s));
                    }
                }
                return invokeF.floatValue;
            }

            @Override // com.kwad.sdk.contentalliance.home.swipe.a
            public void c(float f2) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) && this.f34454a.x) {
                    for (com.kwad.sdk.contentalliance.home.swipe.a aVar : this.f34454a.A) {
                        aVar.c(f2);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.home.swipe.a
            public void d(float f2) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeF(1048579, this, f2) == null) && this.f34454a.x) {
                    this.f34454a.r();
                    ae.b(this.f34454a.o());
                    this.f34454a.f34435f.setEnabled(false);
                    for (com.kwad.sdk.contentalliance.home.swipe.a aVar : this.f34454a.A) {
                        aVar.d(f2);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.home.swipe.a
            public void e(float f2) {
                View view;
                int i4;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeF(1048580, this, f2) == null) && this.f34454a.x) {
                    this.f34454a.t = null;
                    this.f34454a.m = f2;
                    com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "updateFeed onSwipeFinish mPosition" + ((com.kwad.sdk.contentalliance.detail.b) this.f34454a).f34553a.f34582i + "--mSourceType=" + this.f34454a.f34435f.getSourceType());
                    this.f34454a.q();
                    for (com.kwad.sdk.contentalliance.home.swipe.a aVar : this.f34454a.A) {
                        aVar.e(f2);
                    }
                    if (f2 == 0.0f) {
                        com.kwad.sdk.core.report.e.n(this.f34454a.z);
                    }
                    if (f2 == 1.0f) {
                        view = this.f34454a.f34438i;
                        i4 = 8;
                    } else {
                        view = this.f34454a.f34438i;
                        i4 = 0;
                    }
                    view.setVisibility(i4);
                }
            }
        };
        this.I = new com.kwad.sdk.contentalliance.home.a.d(this) { // from class: com.kwad.sdk.contentalliance.detail.a.d.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34440a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34440a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.a.d
            public void a(int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str) == null) {
                    this.f34440a.p();
                    com.kwad.sdk.contentalliance.home.c.c e2 = ((com.kwad.sdk.contentalliance.home.c.b) ((com.kwad.sdk.lib.widget.recycler.d) this.f34440a.f34434e.getAdapter()).c()).e();
                    if (this.f34440a.D || e2.c()) {
                        if (com.kwad.sdk.core.network.f.f36358a.k == i4) {
                            p.a(this.f34440a.o());
                        } else if (com.kwad.sdk.core.network.f.f36364g.k != i4) {
                            p.b(this.f34440a.o());
                        } else if (com.kwad.sdk.core.config.c.X()) {
                            p.c(this.f34440a.o());
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.home.a.d
            public void a(boolean z, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4)}) == null) {
                    com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "updateFeed onFinishLoading mPosition" + ((com.kwad.sdk.contentalliance.detail.b) this.f34440a).f34553a.f34582i + "--mSourceType=" + this.f34440a.f34435f.getSourceType());
                    if (z) {
                        this.f34440a.e();
                        this.f34440a.q();
                        this.f34440a.f34434e.removeCallbacks(this.f34440a.M);
                        this.f34440a.f34434e.removeCallbacks(this.f34440a.N);
                        this.f34440a.f34434e.post(this.f34440a.N);
                    } else {
                        this.f34440a.e();
                        this.f34440a.q();
                    }
                    this.f34440a.p();
                }
            }

            @Override // com.kwad.sdk.contentalliance.home.a.d
            public void a(boolean z, boolean z2, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) && z2) {
                    this.f34440a.h();
                }
            }
        };
        this.M = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.a.d.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34441a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34441a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34441a.b(true);
                }
            }
        };
        this.N = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.a.d.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34442a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34442a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34442a.b(false);
                }
            }
        };
        this.O = new RecyclerView.OnScrollListener(this) { // from class: com.kwad.sdk.contentalliance.detail.a.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34443a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34443a = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i4) == null) {
                    super.onScrollStateChanged(recyclerView, i4);
                    if (i4 == 1) {
                        this.f34443a.a(recyclerView);
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i4, i5) == null) {
                    super.onScrolled(recyclerView, i4, i5);
                    if (i4 > 0 || i5 > 0) {
                        this.f34443a.a(recyclerView);
                    }
                }
            }
        };
        this.R = new Handler();
    }

    private int a(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65559, this, view, i2)) == null) {
            if (view == null) {
                return 0;
            }
            return view.getTop() - ((i2 - (view.getBottom() - view.getTop())) / 2);
        }
        return invokeLI.intValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65564, this, str)) == null) ? "M".equalsIgnoreCase(str) ? "他的作品" : "F".equalsIgnoreCase(str) ? "她的作品" : "ta的作品" : (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65565, this, f2) == null) {
            this.f34433d.setTranslationX(this.s * f2);
            int i2 = this.p;
            this.f34432c.setPivotX(((i2 * 1.0f) / (i2 + this.s)) * this.n);
            float f3 = 1.0f - (((this.s + this.p) * (1.0f - f2)) / this.n);
            this.f34432c.setScaleX(f3);
            this.f34432c.setScaleY(f3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, recyclerView) == null) {
            com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) ((com.kwad.sdk.lib.widget.recycler.d) this.f34434e.getAdapter()).c();
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            com.kwad.sdk.contentalliance.home.c.c e2 = bVar.e();
            if (layoutManager.getChildCount() <= 0 || !a((com.kwad.sdk.contentalliance.home.a.b) e2)) {
                return;
            }
            if (((RecyclerView.LayoutParams) layoutManager.getChildAt(layoutManager.getChildCount() - 1).getLayoutParams()).getViewAdapterPosition() >= bVar.getItemCount() - 1) {
                e2.a();
            }
        }
    }

    private void a(KsFragment ksFragment, h hVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65567, this, ksFragment, hVar) == null) && this.f34431b == null) {
            View view = ksFragment.getParentFragment().getView();
            this.f34431b = view;
            this.f34432c = view.findViewById(R.id.ksad_home_content_layout);
            this.f34435f = (SlidePlayViewPager) this.f34431b.findViewById(R.id.ksad_slide_play_view_pager);
            this.f34437h = R.id.ksad_content_home_author_id;
            this.f34436g = (TextView) this.f34431b.findViewById(R.id.ksad_home_profile_title);
            this.f34438i = this.f34431b.findViewById(R.id.ksad_home_profile_bottom_layout);
            this.j = (ImageView) this.f34431b.findViewById(R.id.ksad_home_profile_author_icon);
            this.k = (TextView) this.f34431b.findViewById(R.id.ksad_home_profile_author_name);
            this.l = (TextView) this.f34431b.findViewById(R.id.ksad_home_profile_author_photo_count);
            this.f34433d = this.f34431b.findViewById(R.id.ksad_home_profile_layout);
            this.f34434e = (RecyclerView) this.f34431b.findViewById(R.id.ksad_home_profile_recycler_view);
            this.s = ao.a(o(), R.dimen.ksad_content_slide_profile_width);
            this.p = ao.a(o(), R.dimen.ksad_content_slide_profile_margin);
            this.q = this.s;
            this.u = ao.a(o(), 5.0f);
            this.v = ao.a(o(), R.dimen.ksad_content_slide_profile_item_height) + this.u;
            this.B = hVar.f35246g;
            this.y = hVar.f35247h;
            if (this.f34434e.getLayoutManager() == null) {
                this.f34434e.setLayoutManager(new LinearLayoutManager(this.f34434e.getContext()));
                this.f34434e.setItemAnimator(null);
                this.f34434e.addItemDecoration(new RecyclerView.ItemDecoration(this) { // from class: com.kwad.sdk.contentalliance.detail.a.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ d f34439a;

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
                        this.f34439a = this;
                    }

                    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                    public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
                            rect.set(0, recyclerView.getChildAdapterPosition(view2) == 0 ? 0 : this.f34439a.u, 0, 0);
                        }
                    }
                });
            }
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserProfile userProfile) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, this, userProfile) == null) {
            long o = com.kwad.sdk.core.response.b.d.o(this.z.photoInfo);
            if (o == userProfile.authorId) {
                this.f34436g.setText(a(userProfile.authorGender));
                this.k.setText(userProfile.authorName);
                TextView textView = this.l;
                textView.setText("作品 " + ag.a(userProfile.ownerCount.publicPhotoCount));
                this.l.setTag(this.f34437h, String.valueOf(o));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        com.kwad.sdk.lib.widget.recycler.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65571, this, z) == null) || (dVar = (com.kwad.sdk.lib.widget.recycler.d) this.f34434e.getAdapter()) == null) {
            return;
        }
        ((com.kwad.sdk.contentalliance.home.c.b) dVar.c()).a(this.z, this.w, z);
    }

    private boolean a(com.kwad.sdk.contentalliance.home.a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65573, this, bVar)) == null) ? (bVar == null || bVar.b() == null || bVar.b().isEmpty()) ? false : true : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        com.kwad.sdk.lib.widget.recycler.d dVar;
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65578, this, z) == null) || (dVar = (com.kwad.sdk.lib.widget.recycler.d) this.f34434e.getAdapter()) == null || (indexOf = ((com.kwad.sdk.contentalliance.home.c.b) dVar.c()).h().indexOf(this.z)) == -1) {
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f34434e.getLayoutManager();
        int height = this.f34434e.getHeight();
        if (!z) {
            int i2 = this.v;
            linearLayoutManager.scrollToPositionWithOffset(indexOf, ((height - i2) / 2) - (indexOf != 0 ? this.u + ((height % i2) / 2) : 0));
            return;
        }
        View findViewByPosition = linearLayoutManager.findViewByPosition(indexOf);
        if (findViewByPosition != null) {
            this.f34434e.smoothScrollBy(0, a(findViewByPosition, height), L);
            return;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (indexOf < findFirstVisibleItemPosition) {
            this.f34434e.smoothScrollBy(0, ((-(findFirstVisibleItemPosition - indexOf)) * this.v) + a(linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition), height), L);
        } else if (indexOf > findLastVisibleItemPosition) {
            this.f34434e.smoothScrollBy(0, ((indexOf - findLastVisibleItemPosition) * this.v) + a(linearLayoutManager.findViewByPosition(findLastVisibleItemPosition), height), L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65585, this) == null) {
            com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) ((com.kwad.sdk.lib.widget.recycler.d) this.f34434e.getAdapter()).c();
            bVar.a(bVar.e().b());
            bVar.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65588, this) == null) {
            com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "updateProfileFeed mPosition" + ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34582i + "--mSourceType=" + this.f34435f.getSourceType());
            com.kwad.sdk.contentalliance.home.c.c cVar = new com.kwad.sdk.contentalliance.home.c.c(this.z.mAdScene);
            cVar.b(this.z);
            com.kwad.sdk.contentalliance.home.c.b bVar = new com.kwad.sdk.contentalliance.home.c.b(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.k.getParentFragment(), this.f34434e, this.f34435f);
            bVar.a(this.w);
            bVar.a(this.z, this.C);
            bVar.a(cVar.b());
            bVar.a(cVar);
            com.kwad.sdk.lib.widget.recycler.d dVar = new com.kwad.sdk.lib.widget.recycler.d(bVar);
            View g2 = g();
            this.J = g2;
            if (!dVar.d(g2)) {
                dVar.c(this.J);
            }
            dVar.a(this.f34434e);
            this.f34434e.setAdapter(dVar);
            cVar.a(this.I);
            this.f34434e.addOnScrollListener(this.O);
            cVar.a(0);
        }
    }

    private View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65590, this)) == null) {
            View view = this.J;
            if (view != null) {
                return view;
            }
            View a2 = ao.a((ViewGroup) this.f34434e, R.layout.ksad_content_slide_home_profile_loading_more, false);
            this.J = a2;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) a2.findViewById(R.id.ksad_loading_lottie);
            this.K = lottieAnimationView;
            lottieAnimationView.setAnimation(R.raw.ksad_detail_loading_amin_new);
            this.K.setRepeatMode(1);
            this.K.setRepeatCount(-1);
            return this.J;
        }
        return (View) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65592, this) == null) || this.J == null) {
            return;
        }
        this.K.b();
        this.K.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65601, this) == null) || this.J == null) {
            return;
        }
        this.K.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65603, this) == null) {
            float f2 = this.m;
            if (f2 == 1.0f) {
                com.kwad.sdk.contentalliance.home.a.i iVar = this.y;
                if (iVar.a(iVar.c())) {
                    AdTemplate adTemplate = this.z;
                    adTemplate.mIsLeftSlipStatus = 0;
                    this.f34435f.a(adTemplate, 0);
                }
            } else if (f2 != 0.0f) {
                return;
            } else {
                com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) ((com.kwad.sdk.lib.widget.recycler.d) this.f34434e.getAdapter()).c();
                com.kwad.sdk.contentalliance.home.c.c e2 = bVar.e();
                if (e2.c()) {
                    return;
                }
                if (this.y.a(e2)) {
                    AdTemplate adTemplate2 = this.z;
                    adTemplate2.mIsLeftSlipStatus = 1;
                    bVar.b(this.y.a(adTemplate2));
                    this.f34435f.a(this.z, 1);
                } else {
                    com.kwad.sdk.contentalliance.home.viewpager.a adapter = this.f34435f.getAdapter();
                    List<AdTemplate> d2 = this.y.d();
                    AdTemplate adTemplate3 = this.z;
                    adapter.a(d2, adTemplate3, 1, this.y.a(adTemplate3), false);
                }
                if (e2.b().size() <= 1) {
                    this.f34435f.setEnabled(false);
                    return;
                }
            }
            this.f34435f.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        SceneImpl sceneImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65605, this) == null) {
            long o = com.kwad.sdk.core.response.b.d.o(this.z.photoInfo);
            String str = (String) this.l.getTag(this.f34437h);
            if ((TextUtils.isEmpty(str) || !str.equals(String.valueOf(o))) && !this.P && this.x && (sceneImpl = this.z.mAdScene) != null) {
                this.P = true;
                com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(sceneImpl);
                fVar.f36139b = sceneImpl.getPageScene();
                i<q, ProfileResultData> iVar = new i<q, ProfileResultData>(this, fVar, o) { // from class: com.kwad.sdk.contentalliance.detail.a.d.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ com.kwad.sdk.core.g.a.f f34444a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ long f34445b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f34446c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, fVar, Long.valueOf(o)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f34446c = this;
                        this.f34444a = fVar;
                        this.f34445b = o;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.core.network.i
                    @NonNull
                    /* renamed from: a */
                    public ProfileResultData b(String str2) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str2)) == null) {
                            JSONObject jSONObject = new JSONObject(str2);
                            ProfileResultData profileResultData = new ProfileResultData();
                            profileResultData.parseJson(jSONObject);
                            return profileResultData;
                        }
                        return (ProfileResultData) invokeL.objValue;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.core.network.a
                    @NonNull
                    /* renamed from: a */
                    public q b() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new q(this.f34444a, this.f34445b) : (q) invokeV.objValue;
                    }
                };
                this.Q = iVar;
                iVar.a(new j<q, ProfileResultData>(this) { // from class: com.kwad.sdk.contentalliance.detail.a.d.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ d f34447a;

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
                        this.f34447a = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                    public void a(@NonNull q qVar, int i2, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, qVar, i2, str2) == null) {
                            this.f34447a.P = false;
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                    public void a(@NonNull q qVar, @NonNull ProfileResultData profileResultData) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar, profileResultData) == null) {
                            this.f34447a.R.post(new Runnable(this, profileResultData) { // from class: com.kwad.sdk.contentalliance.detail.a.d.4.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ ProfileResultData f34448a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass4 f34449b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, profileResultData};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f34449b = this;
                                    this.f34448a = profileResultData;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f34449b.f34447a.a(this.f34448a.userProfile);
                                        this.f34449b.f34447a.P = false;
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65607, this) == null) {
            long o = com.kwad.sdk.core.response.b.d.o(this.z.photoInfo);
            String str = (String) this.f34438i.getTag(this.f34437h);
            if (TextUtils.isEmpty(str) || !str.equals(String.valueOf(o))) {
                KSImageLoader.loadCircleIconWithoutStroke(this.j, com.kwad.sdk.core.response.b.c.q(this.z), o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon_2));
                this.f34438i.setTag(this.f34437h, String.valueOf(o));
            }
        }
    }

    private void t() {
        i<q, ProfileResultData> iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65609, this) == null) || (iVar = this.Q) == null) {
            return;
        }
        iVar.e();
    }

    private void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65611, this) == null) {
            PhotoInfo k = com.kwad.sdk.core.response.b.c.k(this.z);
            SceneImpl sceneImpl = this.z.mAdScene;
            if (sceneImpl != null) {
                v();
                ProfileHomeParam profileHomeParam = new ProfileHomeParam();
                profileHomeParam.mEntryScene = sceneImpl.entryScene;
                profileHomeParam.mAuthorId = com.kwad.sdk.core.response.b.d.o(k);
                profileHomeParam.mAuthorIcon = com.kwad.sdk.core.response.b.d.r(k);
                profileHomeParam.mAuthorName = com.kwad.sdk.core.response.b.d.p(k);
                profileHomeParam.mCurrentPhotoId = com.kwad.sdk.core.response.b.d.k(k);
                com.kwad.sdk.contentalliance.profile.home.a.a(o(), profileHomeParam);
            }
        }
    }

    private void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65613, this) == null) {
            com.kwad.sdk.core.report.e.a(this.z, 5, 3, 0);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            a(cVar.k, cVar.f34574a);
            this.R.post(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.a.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f34450a;

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
                    this.f34450a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        d dVar = this.f34450a;
                        dVar.n = dVar.f34431b.getWidth();
                        d dVar2 = this.f34450a;
                        dVar2.o = dVar2.f34431b.getHeight();
                        d dVar3 = this.f34450a;
                        dVar3.r = (int) (((((dVar3.n - this.f34450a.p) - this.f34450a.q) * 1.0f) / this.f34450a.n) * this.f34450a.o);
                        com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "mScaledHeight=" + this.f34450a.r + "--mHomeFragmentWidth" + this.f34450a.n + "--mHomeFragmentHeight=" + this.f34450a.o);
                        if (this.f34450a.f34434e.getHeight() != this.f34450a.r) {
                            ViewGroup.LayoutParams layoutParams = this.f34450a.f34434e.getLayoutParams();
                            layoutParams.height = this.f34450a.r;
                            this.f34450a.f34434e.setLayoutParams(layoutParams);
                            ViewGroup.LayoutParams layoutParams2 = this.f34450a.f34438i.getLayoutParams();
                            layoutParams2.height = (this.f34450a.o - this.f34450a.r) / 2;
                            this.f34450a.f34438i.setLayoutParams(layoutParams2);
                        }
                    }
                }
            });
            com.kwad.sdk.contentalliance.detail.c cVar2 = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            this.z = cVar2.j;
            this.A = cVar2.f34578e;
            cVar2.f34575b.add(this.G);
            this.m = this.f34435f.getSourceType() == 1 ? 0.0f : 1.0f;
            com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.m;
            this.C = bVar;
            if (bVar != null) {
                bVar.a(this.F);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.remove(this.G);
            com.kwad.sdk.contentalliance.detail.video.b bVar = this.C;
            if (bVar != null) {
                bVar.b(this.F);
            }
            t();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.w = b(R.id.ksad_video_control_button);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d();
            this.f34434e.removeCallbacks(this.M);
            this.f34434e.removeCallbacks(this.N);
            this.R.removeCallbacksAndMessages(null);
            t();
            com.kwad.sdk.lib.widget.recycler.d dVar = (com.kwad.sdk.lib.widget.recycler.d) this.f34434e.getAdapter();
            if (dVar != null) {
                com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) dVar.c();
                com.kwad.sdk.contentalliance.home.c.c e2 = bVar.e();
                e2.b(this.I);
                e2.d();
                bVar.k();
                this.f34434e.removeOnScrollListener(this.O);
                this.f34434e.setAdapter(null);
                LottieAnimationView lottieAnimationView = this.K;
                if (lottieAnimationView != null) {
                    lottieAnimationView.d();
                }
            }
            try {
                a(1.0f);
            } catch (Exception e3) {
                com.kwad.sdk.core.d.a.b(e3);
            }
            com.kwad.sdk.contentalliance.home.a.i iVar = this.y;
            if (iVar.a(iVar.c())) {
                this.f34435f.a(this.z, 0);
            }
            this.f34435f.setEnabled(true);
            this.f34435f.b(this.E);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || ao.a()) {
            return;
        }
        if (view == this.j || view == this.k) {
            u();
        }
    }
}
