package d.a.p0.q.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.w2.x;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f61452a;

    /* renamed from: b  reason: collision with root package name */
    public AdDownloadData f61453b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.q.d.c f61454c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61455d;

    /* renamed from: e  reason: collision with root package name */
    public int f61456e;

    /* renamed from: f  reason: collision with root package name */
    public long f61457f;

    /* renamed from: g  reason: collision with root package name */
    public e f61458g;

    /* loaded from: classes8.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f61459a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61459a = fVar;
        }

        @Override // d.a.p0.q.d.f.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f61459a.f61453b != null && this.f61459a.h()) {
                this.f61459a.j(BdBaseApplication.getInst().getApp().getApplicationContext(), this.f61459a.f61453b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements h.n.b<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdDownloadData f61460e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f61461f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f61462g;

        public b(f fVar, AdDownloadData adDownloadData, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, adDownloadData, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61462g = fVar;
            this.f61460e = adDownloadData;
            this.f61461f = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l) == null) {
                if (this.f61462g.f61452a.a()) {
                    this.f61462g.i(this.f61461f, this.f61460e);
                    return;
                }
                this.f61462g.f61453b = this.f61460e;
                this.f61462g.f61457f = System.currentTimeMillis();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f61466a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1166700024, "Ld/a/p0/q/d/f$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1166700024, "Ld/a/p0/q/d/f$d;");
                    return;
                }
            }
            f61466a = new f(null);
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a();
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    public static f g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? d.f61466a : (f) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f61456e == 0 || d.a.p0.w2.e.e(System.currentTimeMillis(), this.f61457f, this.f61456e)) ? false : true : invokeV.booleanValue;
    }

    public final void i(Context context, AdDownloadData adDownloadData) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, adDownloadData) == null) {
            if (!TextUtils.isEmpty(adDownloadData.getDeeplink())) {
                i2 = x.d(context, adDownloadData.getDeeplink(), adDownloadData.adId(), adDownloadData.getExtInfo());
            } else {
                x.x(adDownloadData.getPkgName());
                i2 = -1;
            }
            this.f61454c.a(i2, adDownloadData.pkgName(), adDownloadData.getExtInfo());
            this.f61453b = null;
        }
    }

    public void j(Context context, AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, adDownloadData) == null) || context == null || adDownloadData == null || !this.f61455d) {
            return;
        }
        h.d.G(1000L, TimeUnit.MILLISECONDS).o(h.l.b.a.b()).B(new b(this, adDownloadData, context));
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f61455d) {
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.f61452a);
            this.f61452a.b(this.f61458g);
        }
    }

    public f() {
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
        this.f61452a = new c(null);
        this.f61453b = null;
        this.f61454c = new d.a.p0.q.d.c();
        this.f61455d = d.a.p0.a.h().t();
        this.f61456e = d.a.p0.a.h().i();
        this.f61458g = new a(this);
    }

    /* loaded from: classes8.dex */
    public static class c implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<Activity> f61463e;

        /* renamed from: f  reason: collision with root package name */
        public e f61464f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f61465g;

        public c() {
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
            this.f61463e = null;
            this.f61464f = null;
            this.f61465g = true;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                WeakReference<Activity> weakReference = this.f61463e;
                return (weakReference == null || weakReference.get() == null || !this.f61465g) ? false : true;
            }
            return invokeV.booleanValue;
        }

        public void b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                this.f61464f = eVar;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            WeakReference<Activity> weakReference;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, activity) == null) && (weakReference = this.f61463e) != null && weakReference.get() == activity) {
                this.f61463e = null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
                this.f61463e = new WeakReference<>(activity);
                if (!this.f61465g && (eVar = this.f61464f) != null) {
                    eVar.a();
                }
                this.f61465g = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            WeakReference<Activity> weakReference;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) && (weakReference = this.f61463e) != null && weakReference.get() == activity) {
                this.f61465g = false;
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
