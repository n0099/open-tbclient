package d.a.q0.i3;

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
import d.a.d.e.m.e;
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.q0.g3.c;
import d.a.q0.i3.c.a;
import d.a.q0.i3.d.a;
/* loaded from: classes8.dex */
public class a implements d.a.p0.y0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f59401a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.q0.i3.d.a f59402b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.y0.b f59403c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.q0.i3.c.a f59404d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f59405e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59406f;

    /* renamed from: g  reason: collision with root package name */
    public a.c f59407g;

    /* renamed from: h  reason: collision with root package name */
    public a.d f59408h;

    /* renamed from: d.a.q0.i3.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1489a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59409a;

        /* renamed from: d.a.q0.i3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1490a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1489a f59410e;

            public RunnableC1490a(C1489a c1489a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1489a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59410e = c1489a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j.z() && j.H()) {
                    this.f59410e.f59409a.f59404d.g();
                }
            }
        }

        public C1489a(a aVar) {
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
            this.f59409a = aVar;
        }

        @Override // d.a.q0.i3.c.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f59409a.f59406f && this.f59409a.f59403c != null) {
                this.f59409a.f59403c.a();
            }
        }

        @Override // d.a.q0.i3.c.a.c
        public void b(d.a.q0.i3.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (j.z()) {
                    this.f59409a.f59404d.e();
                } else if (this.f59409a.f59403c != null) {
                    this.f59409a.f59403c.a();
                }
                if (this.f59409a.f59406f) {
                    this.f59409a.f59405e.postDelayed(new RunnableC1490a(this), 800L);
                } else if (j.z() && j.H()) {
                    this.f59409a.f59404d.g();
                }
            }
        }

        @Override // d.a.q0.i3.c.a.c
        public void c(Object obj) {
            d.a.q0.i3.b.b c2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && this.f59409a.f59406f && (c2 = this.f59409a.f59404d.c()) != null) {
                StatisticItem h2 = d.a.q0.g3.a.h("a064", "common_fill", true, 1);
                if (d.a.d.a.j.a(this.f59409a.f59401a) != null) {
                    c.g().c(d.a.d.a.j.a(this.f59409a.f59401a).getUniqueId(), h2);
                }
                this.f59409a.f59402b.f(obj, ((int) c2.f59417c) / 1000);
                if (this.f59409a.f59403c != null) {
                    this.f59409a.f59403c.c(String.valueOf(c2.f59415a), c2.c(), c2.a());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59411a;

        /* renamed from: d.a.q0.i3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1491a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f59412e;

            public RunnableC1491a(b bVar, String str) {
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
                this.f59412e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) d.a.d.a.j.a(d.a.d.a.b.f().b()), new String[]{this.f59412e}, true);
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
            this.f59411a = aVar;
        }

        @Override // d.a.q0.i3.d.a.d
        public void a() {
            d.a.q0.i3.b.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = this.f59411a.f59404d.c()) == null) {
                return;
            }
            if (this.f59411a.f59403c != null) {
                this.f59411a.f59403c.b(String.valueOf(c2.f59415a), c2.c());
            }
            if (TextUtils.isEmpty(c2.f59420f)) {
                return;
            }
            if (!this.f59411a.j(c2.f59420f)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) d.a.d.a.j.a(this.f59411a.f59401a), new String[]{c2.f59420f}, true);
            } else {
                e.a().postDelayed(new RunnableC1491a(this, c2.f59420f), 500L);
            }
        }

        @Override // d.a.q0.i3.d.a.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = false;
                if (this.f59411a.getView() != null) {
                    if (this.f59411a.getView().getHeight() == l.i(this.f59411a.getView().getContext())) {
                        z = true;
                    }
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
                if (this.f59411a.f59403c != null) {
                    this.f59411a.f59403c.onAdDismiss();
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
        this.f59405e = new Handler();
        this.f59406f = true;
        this.f59407g = new C1489a(this);
        this.f59408h = new b(this);
        this.f59401a = context;
        d.a.q0.i3.c.a aVar = new d.a.q0.i3.c.a();
        this.f59404d = aVar;
        aVar.h(this.f59407g);
        this.f59402b = new d.a.q0.i3.d.a(context, this.f59408h);
    }

    @Override // d.a.p0.y0.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59404d.d();
        }
    }

    @Override // d.a.p0.y0.a
    public void b(d.a.p0.y0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f59403c = bVar;
        }
    }

    @Override // d.a.p0.y0.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59402b.b() : (View) invokeV.objValue;
    }

    public final boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.contains("/swan/") || str.contains("/swangame/")) {
                return !ContextCompat.checkPermissionGranted(d.a.d.a.b.f().b(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.p0.y0.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f59406f = false;
            this.f59405e.removeCallbacksAndMessages(null);
        }
    }
}
