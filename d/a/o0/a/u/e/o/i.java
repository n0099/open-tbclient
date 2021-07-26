package d.a.o0.a.u.e.o;

import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i extends d.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f48297e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48298f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f48299g;

        public a(i iVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48299g = iVar;
            this.f48297e = i2;
            this.f48298f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View b2 = d.a.o0.a.z1.b.a.b();
                LinearLayout c2 = d.a.o0.a.z1.b.a.c();
                int i2 = this.f48297e;
                if (i2 == -90) {
                    if (b2 != null) {
                        b2.setVisibility(8);
                    }
                    if (c2 != null) {
                        c2.setVisibility(8);
                    }
                    d.a.o0.a.z1.b.a.f();
                    d.a.o0.a.z1.b.a.k(true);
                    i.v(8);
                } else if (i2 != 90) {
                    d.a.o0.a.z1.b.a.m();
                    if (b2 != null) {
                        b2.setVisibility(0);
                    }
                    if (c2 != null) {
                        c2.setVisibility(0);
                    }
                    i.w();
                } else {
                    if (b2 != null) {
                        b2.setVisibility(8);
                    }
                    if (c2 != null) {
                        c2.setVisibility(8);
                    }
                    d.a.o0.a.z1.b.a.f();
                    d.a.o0.a.z1.b.a.k(true);
                    i.v(0);
                }
                k.e().t(this.f48297e);
                this.f48299g.d(this.f48298f, new d.a.o0.a.u.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NonNull d.a.o0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
            SwanAppActivity activity = d.a.o0.a.g1.f.V().getActivity();
            activity.setRequestedOrientation(i2);
            activity.getWindow().setFlags(1024, 1024);
        }
    }

    public static void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            SwanAppActivity activity = d.a.o0.a.g1.f.V().getActivity();
            activity.setRequestedOrientation(1);
            if (!d.a.o0.a.z1.b.a.g(d.a.o0.a.z1.b.a.d(activity))) {
                d.a.o0.a.z1.b.a.k(false);
            }
            if (activity.getWindow() != null) {
                activity.getWindow().clearFlags(1024);
            }
            if (d.a.o0.a.g1.f.V().J() != null) {
                d.a.o0.a.g1.f.V().J().i2();
            }
        }
    }

    public final void t(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            q0.X(new a(this, i2, str));
        }
    }

    public final int u(boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (z) {
                return i2;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public d.a.o0.a.u.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-FullScreenApi", "start set full screen");
            }
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-FullScreenApi", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    d.a.o0.a.e0.d.b("Api-FullScreenApi", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            t(u(jSONObject.optBoolean("fullScreen"), jSONObject.optInt("direction")), jSONObject.optString("cb"));
            return new d.a.o0.a.u.h.b(0);
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }
}
