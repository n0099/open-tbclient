package d.a.p0.i3;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.context.ContextCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.m.e;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.p0.g3.c;
import d.a.p0.i3.c.a;
import d.a.p0.i3.d.a;
/* loaded from: classes8.dex */
public class a implements d.a.o0.w0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f58787a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.p0.i3.d.a f58788b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.w0.b f58789c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.p0.i3.c.a f58790d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f58791e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58792f;

    /* renamed from: g  reason: collision with root package name */
    public a.c f58793g;

    /* renamed from: h  reason: collision with root package name */
    public a.d f58794h;

    /* renamed from: d.a.p0.i3.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1484a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f58795a;

        /* renamed from: d.a.p0.i3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1485a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1484a f58796e;

            public RunnableC1485a(C1484a c1484a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1484a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58796e = c1484a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j.z() && j.H()) {
                    this.f58796e.f58795a.f58790d.g();
                }
            }
        }

        public C1484a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58795a = aVar;
        }

        @Override // d.a.p0.i3.c.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f58795a.f58792f && this.f58795a.f58789c != null) {
                this.f58795a.f58789c.a();
            }
        }

        @Override // d.a.p0.i3.c.a.c
        public void b(d.a.p0.i3.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (j.z()) {
                    this.f58795a.f58790d.e();
                } else if (this.f58795a.f58789c != null) {
                    this.f58795a.f58789c.a();
                }
                if (this.f58795a.f58792f) {
                    this.f58795a.f58791e.postDelayed(new RunnableC1485a(this), 800L);
                } else if (j.z() && j.H()) {
                    this.f58795a.f58790d.g();
                }
            }
        }

        @Override // d.a.p0.i3.c.a.c
        public void c(Object obj) {
            d.a.p0.i3.b.b c2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && this.f58795a.f58792f && (c2 = this.f58795a.f58790d.c()) != null) {
                StatisticItem h2 = d.a.p0.g3.a.h("a064", "common_fill", true, 1);
                if (d.a.c.a.j.a(this.f58795a.f58787a) != null) {
                    c.g().c(d.a.c.a.j.a(this.f58795a.f58787a).getUniqueId(), h2);
                }
                this.f58795a.f58788b.f(obj, ((int) c2.f58803c) / 1000);
                if (this.f58795a.f58789c != null) {
                    this.f58795a.f58789c.c(String.valueOf(c2.f58801a), c2.c(), c2.a());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f58797a;

        /* renamed from: d.a.p0.i3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1486a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f58798e;

            public RunnableC1486a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58798e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(d.a.c.a.b.f().b()), new String[]{this.f58798e}, true);
                }
            }
        }

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58797a = aVar;
        }

        @Override // d.a.p0.i3.d.a.d
        public void a() {
            d.a.p0.i3.b.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = this.f58797a.f58790d.c()) == null) {
                return;
            }
            if (this.f58797a.f58789c != null) {
                this.f58797a.f58789c.b(String.valueOf(c2.f58801a), c2.c());
            }
            if (TextUtils.isEmpty(c2.f58806f)) {
                return;
            }
            if (!this.f58797a.j(c2.f58806f)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(this.f58797a.f58787a), new String[]{c2.f58806f}, true);
            } else {
                e.a().postDelayed(new RunnableC1486a(this, c2.f58806f), 500L);
            }
        }

        @Override // d.a.p0.i3.d.a.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = false;
                if (this.f58797a.getView() != null) {
                    if (this.f58797a.getView().getHeight() == l.i(this.f58797a.getView().getContext())) {
                        z = true;
                    }
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
                if (this.f58797a.f58789c != null) {
                    this.f58797a.f58789c.onAdDismiss();
                }
            }
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58791e = new Handler();
        this.f58792f = true;
        this.f58793g = new C1484a(this);
        this.f58794h = new b(this);
        this.f58787a = context;
        d.a.p0.i3.c.a aVar = new d.a.p0.i3.c.a();
        this.f58790d = aVar;
        aVar.h(this.f58793g);
        this.f58788b = new d.a.p0.i3.d.a(context, this.f58794h);
    }

    @Override // d.a.o0.w0.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f58790d.d();
        }
    }

    @Override // d.a.o0.w0.a
    public void b(d.a.o0.w0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f58789c = bVar;
        }
    }

    @Override // d.a.o0.w0.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f58788b.b() : (View) invokeV.objValue;
    }

    public final boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.contains("/swan/") || str.contains("/swangame/")) {
                return !ContextCompat.checkPermissionGranted(d.a.c.a.b.f().b(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.o0.w0.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f58792f = false;
            this.f58791e.removeCallbacksAndMessages(null);
        }
    }
}
