package d.b.c.b.h.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Application f69416a;

    /* renamed from: b  reason: collision with root package name */
    public Context f69417b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f69418c;

    /* renamed from: d  reason: collision with root package name */
    public List<Long> f69419d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f69420e;

    /* renamed from: f  reason: collision with root package name */
    public List<Long> f69421f;

    /* renamed from: g  reason: collision with root package name */
    public String f69422g;

    /* renamed from: h  reason: collision with root package name */
    public long f69423h;

    /* renamed from: i  reason: collision with root package name */
    public String f69424i;
    public long j;
    public String k;
    public long l;
    public String m;
    public long n;
    public String o;
    public long p;
    public int q;
    public final Application.ActivityLifecycleCallbacks r;

    /* loaded from: classes8.dex */
    public class a implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f69425e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69425e = bVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
                this.f69425e.f69422g = activity.getClass().getName();
                this.f69425e.f69423h = System.currentTimeMillis();
                this.f69425e.f69418c.add(this.f69425e.f69422g);
                this.f69425e.f69419d.add(Long.valueOf(this.f69425e.f69423h));
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                String name = activity.getClass().getName();
                int indexOf = this.f69425e.f69418c.indexOf(name);
                if (indexOf > -1 && indexOf < this.f69425e.f69418c.size()) {
                    this.f69425e.f69418c.remove(indexOf);
                    this.f69425e.f69419d.remove(indexOf);
                }
                this.f69425e.f69420e.add(name);
                this.f69425e.f69421f.add(Long.valueOf(System.currentTimeMillis()));
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                this.f69425e.m = activity.getClass().getName();
                this.f69425e.n = System.currentTimeMillis();
                b.v(this.f69425e);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
                this.f69425e.k = activity.getClass().getName();
                this.f69425e.l = System.currentTimeMillis();
                b.r(this.f69425e);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
                this.f69425e.f69424i = activity.getClass().getName();
                this.f69425e.j = System.currentTimeMillis();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
                this.f69425e.o = activity.getClass().getName();
                this.f69425e.p = System.currentTimeMillis();
            }
        }
    }

    public b(@NonNull Context context) {
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
        this.f69418c = new ArrayList();
        this.f69419d = new ArrayList();
        this.f69420e = new ArrayList();
        this.f69421f = new ArrayList();
        this.r = new a(this);
        this.f69417b = context;
        if (context instanceof Application) {
            this.f69416a = (Application) context;
        }
        m();
    }

    public static /* synthetic */ int r(b bVar) {
        int i2 = bVar.q;
        bVar.q = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int v(b bVar) {
        int i2 = bVar.q;
        bVar.q = i2 - 1;
        return i2;
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("last_create_activity", e(this.f69422g, this.f69423h));
                jSONObject.put("last_start_activity", e(this.f69424i, this.j));
                jSONObject.put("last_resume_activity", e(this.k, this.l));
                jSONObject.put("last_pause_activity", e(this.m, this.n));
                jSONObject.put("last_stop_activity", e(this.o, this.p));
                jSONObject.put("alive_activities", q());
                jSONObject.put("finish_activities", u());
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject e(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", str);
                jSONObject.put("time", j);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLJ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: Exception -> 0x007b, TryCatch #1 {Exception -> 0x007b, blocks: (B:5:0x0009, B:8:0x0016, B:11:0x001e, B:12:0x0022, B:14:0x0028, B:16:0x0030, B:19:0x0035), top: B:30:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONArray i() {
        InterceptResult invokeV;
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            try {
                activityManager = (ActivityManager) this.f69417b.getSystemService("activity");
            } catch (Exception unused) {
            }
            if (activityManager == null || (runningTasks = activityManager.getRunningTasks(5)) == null) {
                return jSONArray;
            }
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo != null) {
                    if (runningTaskInfo.baseActivity != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("id", runningTaskInfo.id);
                            jSONObject.put("package_name", runningTaskInfo.baseActivity.getPackageName());
                            jSONObject.put("description", runningTaskInfo.description);
                            jSONObject.put("number_of_activities", runningTaskInfo.numActivities);
                            jSONObject.put("number_of_running_activities", runningTaskInfo.numRunning);
                            jSONObject.put("topActivity", runningTaskInfo.topActivity.toString());
                            jSONObject.put("baseActivity", runningTaskInfo.baseActivity.toString());
                            jSONArray.put(jSONObject);
                        } catch (JSONException unused2) {
                        }
                    }
                    while (r1.hasNext()) {
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public final void m() {
        Application application;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || Build.VERSION.SDK_INT < 14 || (application = this.f69416a) == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this.r);
    }

    public final JSONArray q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            List<String> list = this.f69418c;
            if (list != null && !list.isEmpty()) {
                for (int i2 = 0; i2 < this.f69418c.size(); i2++) {
                    try {
                        jSONArray.put(e(this.f69418c.get(i2), this.f69419d.get(i2).longValue()));
                    } catch (Throwable unused) {
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public final JSONArray u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            List<String> list = this.f69420e;
            if (list != null && !list.isEmpty()) {
                for (int i2 = 0; i2 < this.f69420e.size(); i2++) {
                    try {
                        jSONArray.put(e(this.f69420e.get(i2), this.f69421f.get(i2).longValue()));
                    } catch (Throwable unused) {
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }
}
