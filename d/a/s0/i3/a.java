package d.a.s0.i3;

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
import d.a.s0.g3.c;
import d.a.s0.i3.c.a;
import d.a.s0.i3.d.a;
/* loaded from: classes9.dex */
public class a implements d.a.r0.w0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f62022a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.s0.i3.d.a f62023b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.r0.w0.b f62024c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.s0.i3.c.a f62025d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f62026e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62027f;

    /* renamed from: g  reason: collision with root package name */
    public a.c f62028g;

    /* renamed from: h  reason: collision with root package name */
    public a.d f62029h;

    /* renamed from: d.a.s0.i3.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1528a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f62030a;

        /* renamed from: d.a.s0.i3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1529a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1528a f62031e;

            public RunnableC1529a(C1528a c1528a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1528a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f62031e = c1528a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j.z() && j.H()) {
                    this.f62031e.f62030a.f62025d.g();
                }
            }
        }

        public C1528a(a aVar) {
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
            this.f62030a = aVar;
        }

        @Override // d.a.s0.i3.c.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f62030a.f62027f && this.f62030a.f62024c != null) {
                this.f62030a.f62024c.a();
            }
        }

        @Override // d.a.s0.i3.c.a.c
        public void b(d.a.s0.i3.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (j.z()) {
                    this.f62030a.f62025d.e();
                } else if (this.f62030a.f62024c != null) {
                    this.f62030a.f62024c.a();
                }
                if (this.f62030a.f62027f) {
                    this.f62030a.f62026e.postDelayed(new RunnableC1529a(this), 800L);
                } else if (j.z() && j.H()) {
                    this.f62030a.f62025d.g();
                }
            }
        }

        @Override // d.a.s0.i3.c.a.c
        public void c(Object obj) {
            d.a.s0.i3.b.b c2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && this.f62030a.f62027f && (c2 = this.f62030a.f62025d.c()) != null) {
                StatisticItem h2 = d.a.s0.g3.a.h("a064", "common_fill", true, 1);
                if (d.a.c.a.j.a(this.f62030a.f62022a) != null) {
                    c.g().c(d.a.c.a.j.a(this.f62030a.f62022a).getUniqueId(), h2);
                }
                this.f62030a.f62023b.f(obj, ((int) c2.f62038c) / 1000);
                if (this.f62030a.f62024c != null) {
                    this.f62030a.f62024c.c(String.valueOf(c2.f62036a), c2.c(), c2.a());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f62032a;

        /* renamed from: d.a.s0.i3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1530a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f62033e;

            public RunnableC1530a(b bVar, String str) {
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
                this.f62033e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(d.a.c.a.b.f().b()), new String[]{this.f62033e}, true);
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
            this.f62032a = aVar;
        }

        @Override // d.a.s0.i3.d.a.d
        public void a() {
            d.a.s0.i3.b.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = this.f62032a.f62025d.c()) == null) {
                return;
            }
            if (this.f62032a.f62024c != null) {
                this.f62032a.f62024c.b(String.valueOf(c2.f62036a), c2.c());
            }
            if (TextUtils.isEmpty(c2.f62041f)) {
                return;
            }
            if (!this.f62032a.j(c2.f62041f)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(this.f62032a.f62022a), new String[]{c2.f62041f}, true);
            } else {
                e.a().postDelayed(new RunnableC1530a(this, c2.f62041f), 500L);
            }
        }

        @Override // d.a.s0.i3.d.a.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = false;
                if (this.f62032a.getView() != null) {
                    if (this.f62032a.getView().getHeight() == l.i(this.f62032a.getView().getContext())) {
                        z = true;
                    }
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
                if (this.f62032a.f62024c != null) {
                    this.f62032a.f62024c.onAdDismiss();
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
        this.f62026e = new Handler();
        this.f62027f = true;
        this.f62028g = new C1528a(this);
        this.f62029h = new b(this);
        this.f62022a = context;
        d.a.s0.i3.c.a aVar = new d.a.s0.i3.c.a();
        this.f62025d = aVar;
        aVar.h(this.f62028g);
        this.f62023b = new d.a.s0.i3.d.a(context, this.f62029h);
    }

    @Override // d.a.r0.w0.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f62025d.d();
        }
    }

    @Override // d.a.r0.w0.a
    public void b(d.a.r0.w0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f62024c = bVar;
        }
    }

    @Override // d.a.r0.w0.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f62023b.b() : (View) invokeV.objValue;
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

    @Override // d.a.r0.w0.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f62027f = false;
            this.f62026e.removeCallbacksAndMessages(null);
        }
    }
}
