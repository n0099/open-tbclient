package com.kwad.sdk.contentalliance.detail.photo.e;

import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageButton;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.b;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.widget.KsAdFrameLayout;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f34764b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.trends.view.c f34765c;

    /* renamed from: d  reason: collision with root package name */
    public ImageButton f34766d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f34767e;

    /* renamed from: f  reason: collision with root package name */
    public b f34768f;

    /* renamed from: g  reason: collision with root package name */
    public KsAdFrameLayout f34769g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f34770h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f34771i;
    public Runnable j;
    public boolean k;
    public b.a l;
    public GestureDetector.SimpleOnGestureListener m;
    public GestureDetector n;
    public SlidePlayViewPager o;
    public com.kwad.sdk.contentalliance.home.swipe.c p;
    public com.kwad.sdk.contentalliance.home.swipe.a q;

    /* loaded from: classes7.dex */
    public abstract class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f34782a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34782a = dVar;
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void a(@NonNull b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f34782a.f34768f = bVar;
                bVar.c();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        @MainThread
        void a();

        @MainThread
        void a(@NonNull b bVar);

        @MainThread
        void b();

        @MainThread
        void c();
    }

    /* loaded from: classes7.dex */
    public class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f34783b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar) {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34783b = dVar;
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.a, com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34783b.a(0);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.a, com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f34783b.a(0);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f34783b.a(true);
            }
        }
    }

    /* renamed from: com.kwad.sdk.contentalliance.detail.photo.e.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0410d extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f34784b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0410d(d dVar) {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34784b = dVar;
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.a, com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34784b.a(1);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f34784b.a(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f34785b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d dVar) {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34785b = dVar;
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.a, com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f34785b.a(false);
            }
        }
    }

    public d() {
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
        this.f34765c = new com.kwad.sdk.contentalliance.trends.view.d(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34772a;

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
                this.f34772a = this;
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34772a.a(1);
                    this.f34772a.f34766d.setVisibility(4);
                }
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f34772a.a(0);
                }
            }
        };
        this.f34768f = new e();
        this.f34770h = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34773a;

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
                this.f34773a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void j() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34773a.f();
                }
            }
        };
        this.f34771i = new f(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34774a;

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
                this.f34774a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34774a.f();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, i5) == null) {
                    this.f34774a.f();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && com.kwad.sdk.core.response.b.c.B(((com.kwad.sdk.contentalliance.detail.b) this.f34774a).f34553a.j) && ((com.kwad.sdk.contentalliance.detail.b) this.f34774a).f34553a.f34574a != null && ((com.kwad.sdk.contentalliance.detail.b) this.f34774a).f34553a.f34574a.l) {
                    this.f34774a.a(1);
                    this.f34774a.f34766d.setVisibility(4);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f34774a.g();
                    this.f34774a.e().a(new C0410d());
                    this.f34774a.k = false;
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.f34774a.e().a(new c());
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    this.f34774a.e().a(new C0410d());
                }
            }
        };
        this.j = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34775a;

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
                this.f34775a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.core.d.a.a("PhotoVideoControlPresenter", "mAutoHidePauseButtonCallback run=" + this.f34775a.f34768f);
                    if (this.f34775a.f34768f != null) {
                        this.f34775a.f34768f.a(new C0410d());
                    }
                }
            }
        };
        this.f34764b = new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34776a;

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
                this.f34776a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f34776a.g();
                    if (this.f34776a.e() instanceof C0410d) {
                        this.f34776a.e().b();
                    } else {
                        this.f34776a.e().a();
                    }
                }
            }
        };
        this.k = false;
        this.l = new b.a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34777a;

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
                this.f34777a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.b.a
            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f34777a.k : invokeV.booleanValue;
            }
        };
        this.m = new GestureDetector.SimpleOnGestureListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public boolean f34778a;

            /* renamed from: b  reason: collision with root package name */
            public long f34779b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d f34780c;

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
                this.f34780c = this;
                this.f34778a = false;
                this.f34779b = 0L;
            }

            private boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) ? SystemClock.elapsedRealtime() - this.f34779b < ((long) ViewConfiguration.getJumpTapTimeout()) : invokeV.booleanValue;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, motionEvent)) == null) {
                    this.f34779b = SystemClock.elapsedRealtime();
                    return this.f34778a;
                }
                return invokeL.booleanValue;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                    if (a()) {
                        return false;
                    }
                    this.f34780c.g();
                    if (this.f34780c.p == null || (this.f34780c.o.getSourceType() == 0 && !this.f34780c.p.b())) {
                        this.f34780c.e().b();
                    } else {
                        this.f34780c.p.c();
                    }
                    this.f34778a = false;
                    this.f34779b = 0L;
                    return true;
                }
                return invokeL.booleanValue;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                    this.f34778a = false;
                    return true;
                }
                return invokeL.booleanValue;
            }
        };
        this.q = new com.kwad.sdk.contentalliance.home.swipe.b(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34781a;

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
                this.f34781a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.swipe.b, com.kwad.sdk.contentalliance.home.swipe.a
            public void a(float f2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeF(1048576, this, f2) == null) {
                    this.f34781a.a(f2);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65539, this, f2) == null) {
            this.f34766d.setAlpha(f2);
            this.f34766d.setClickable(f2 == 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        com.kwad.sdk.contentalliance.detail.video.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65540, this, i2) == null) || (bVar = this.f34767e) == null) {
            return;
        }
        if (i2 == 1) {
            this.k = true;
            bVar.g();
            return;
        }
        this.k = false;
        bVar.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, this, z) == null) {
            this.f34766d.setBackgroundResource(R.drawable.ksad_photo_video_play_icon_2);
            this.f34766d.setVisibility(z ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            g();
            this.f34768f = new e();
            a(false);
            this.k = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.f34766d.removeCallbacks(this.j);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.k = false;
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            this.o = cVar.l;
            this.p = cVar.f34574a.f35246g;
            com.kwad.sdk.contentalliance.detail.video.b bVar = cVar.m;
            this.f34767e = bVar;
            bVar.a(this.l);
            this.f34767e.a(this.f34771i);
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(this.f34770h);
            f();
            this.f34766d.setOnClickListener(this.f34764b);
            GestureDetector gestureDetector = new GestureDetector(o(), this.m);
            this.n = gestureDetector;
            this.f34769g.a(gestureDetector);
            if (com.kwad.sdk.core.response.b.c.B(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j)) {
                ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.a(this.f34765c);
            }
            a(this.o.getSourceType() == 0 ? 1.0f : 0.0f);
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34578e.add(this.q);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f34767e.b(this.l);
            this.f34767e.b(this.f34771i);
            this.f34766d.setOnClickListener(null);
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.remove(this.f34770h);
            this.f34769g.b(this.n);
            f();
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.b(this.f34765c);
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34578e.remove(this.q);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34766d = (ImageButton) b(R.id.ksad_video_control_button);
            KsAdFrameLayout ksAdFrameLayout = (KsAdFrameLayout) b(R.id.ksad_video_container);
            this.f34769g = ksAdFrameLayout;
            ksAdFrameLayout.setClickable(true);
        }
    }

    public b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f34768f == null) {
                this.f34768f = new C0410d();
            }
            return this.f34768f;
        }
        return (b) invokeV.objValue;
    }
}
