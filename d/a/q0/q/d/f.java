package d.a.q0.q.d;

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
import d.a.q0.w2.x;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f62066a;

    /* renamed from: b  reason: collision with root package name */
    public AdDownloadData f62067b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.q.d.c f62068c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62069d;

    /* renamed from: e  reason: collision with root package name */
    public int f62070e;

    /* renamed from: f  reason: collision with root package name */
    public long f62071f;

    /* renamed from: g  reason: collision with root package name */
    public e f62072g;

    /* loaded from: classes8.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f62073a;

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
            this.f62073a = fVar;
        }

        @Override // d.a.q0.q.d.f.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f62073a.f62067b != null && this.f62073a.h()) {
                this.f62073a.j(BdBaseApplication.getInst().getApp().getApplicationContext(), this.f62073a.f62067b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements h.n.b<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdDownloadData f62074e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f62075f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f62076g;

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
            this.f62076g = fVar;
            this.f62074e = adDownloadData;
            this.f62075f = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l) == null) {
                if (this.f62076g.f62066a.a()) {
                    this.f62076g.i(this.f62075f, this.f62074e);
                    return;
                }
                this.f62076g.f62067b = this.f62074e;
                this.f62076g.f62071f = System.currentTimeMillis();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f62080a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1331315913, "Ld/a/q0/q/d/f$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1331315913, "Ld/a/q0/q/d/f$d;");
                    return;
                }
            }
            f62080a = new f(null);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? d.f62080a : (f) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f62070e == 0 || d.a.q0.w2.e.e(System.currentTimeMillis(), this.f62071f, this.f62070e)) ? false : true : invokeV.booleanValue;
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
            this.f62068c.a(i2, adDownloadData.pkgName(), adDownloadData.getExtInfo());
            this.f62067b = null;
        }
    }

    public void j(Context context, AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, adDownloadData) == null) || context == null || adDownloadData == null || !this.f62069d) {
            return;
        }
        h.d.G(1000L, TimeUnit.MILLISECONDS).o(h.l.b.a.b()).B(new b(this, adDownloadData, context));
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f62069d) {
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.f62066a);
            this.f62066a.b(this.f62072g);
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
        this.f62066a = new c(null);
        this.f62067b = null;
        this.f62068c = new d.a.q0.q.d.c();
        this.f62069d = d.a.q0.a.h().t();
        this.f62070e = d.a.q0.a.h().i();
        this.f62072g = new a(this);
    }

    /* loaded from: classes8.dex */
    public static class c implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<Activity> f62077e;

        /* renamed from: f  reason: collision with root package name */
        public e f62078f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f62079g;

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
            this.f62077e = null;
            this.f62078f = null;
            this.f62079g = true;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                WeakReference<Activity> weakReference = this.f62077e;
                return (weakReference == null || weakReference.get() == null || !this.f62079g) ? false : true;
            }
            return invokeV.booleanValue;
        }

        public void b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                this.f62078f = eVar;
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
            if ((interceptable == null || interceptable.invokeL(1048579, this, activity) == null) && (weakReference = this.f62077e) != null && weakReference.get() == activity) {
                this.f62077e = null;
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
                this.f62077e = new WeakReference<>(activity);
                if (!this.f62079g && (eVar = this.f62078f) != null) {
                    eVar.a();
                }
                this.f62079g = true;
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
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) && (weakReference = this.f62077e) != null && weakReference.get() == activity) {
                this.f62079g = false;
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
