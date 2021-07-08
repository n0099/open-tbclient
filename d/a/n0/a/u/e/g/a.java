package d.a.n0.a.u.e.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.v2.n0;
import d.a.n0.a.v2.q0;
import d.a.n0.a.z1.b.c.a;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.u.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0908a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.z1.b.c.a f47539e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f47540f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47541g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f47542h;

        public RunnableC0908a(a aVar, d.a.n0.a.z1.b.c.a aVar2, Context context, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, context, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47539e = aVar2;
            this.f47540f = context;
            this.f47541g = str;
            this.f47542h = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadingView loadingView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View e2 = this.f47539e.e();
                if (e2 instanceof LoadingView) {
                    loadingView = (LoadingView) e2;
                } else {
                    loadingView = new LoadingView(this.f47540f);
                    FrameLayout frameLayout = new FrameLayout(this.f47540f);
                    frameLayout.setPadding(0, 0, 0, n0.g(160.0f));
                    frameLayout.addView(loadingView);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    this.f47539e.l(frameLayout, layoutParams);
                }
                if (!TextUtils.isEmpty(this.f47541g)) {
                    loadingView.setMsg(this.f47541g);
                }
                this.f47539e.i(this.f47542h);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.g.d f47543e;

        public b(a aVar, d.a.n0.a.h0.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47543e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.n0.a.z1.b.c.a floatLayer;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (floatLayer = ((a.InterfaceC1003a) this.f47543e).getFloatLayer()) != null && (floatLayer.e() instanceof FrameLayout) && (((FrameLayout) floatLayer.e()).getChildAt(0) instanceof LoadingView)) {
                floatLayer.g();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.n0.a.u.c.b bVar) {
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
                super((d.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void r(@NonNull d.a.n0.a.z1.b.c.a aVar, @NonNull Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{aVar, context, str, Boolean.valueOf(z)}) == null) {
            q0.b0(new RunnableC0908a(this, aVar, context, str, z));
        }
    }

    public d.a.n0.a.u.h.b s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Context i2 = i();
            if (!(i2 instanceof SwanAppActivity)) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-LoadingView", "context not support");
                }
                return new d.a.n0.a.u.h.b(1001, "context not support");
            }
            d.a.n0.a.h0.g.g swanAppFragmentManager = ((SwanAppActivity) i2).getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-LoadingView", "none fragmentManger");
                }
                return new d.a.n0.a.u.h.b(1001, "none fragmentManger");
            }
            d.a.n0.a.h0.g.d m = swanAppFragmentManager.m();
            if (!(m instanceof a.InterfaceC1003a)) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-LoadingView", "fragment not support");
                }
                return new d.a.n0.a.u.h.b(1001, "fragment not support");
            } else if (m.q() == null) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-LoadingView", "fragment has detached");
                }
                return new d.a.n0.a.u.h.b(1001, "fragment has detached");
            } else {
                q0.b0(new b(this, m));
                d.a.n0.a.e0.d.g("Api-LoadingView", "hide loading success");
                return new d.a.n0.a.u.h.b(0);
            }
        }
        return (d.a.n0.a.u.h.b) invokeV.objValue;
    }

    public d.a.n0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-LoadingView", "start show loading");
            }
            if (l()) {
                d.a.n0.a.e0.d.b("Api-LoadingView", "Api-LoadingView does not supported when app is invisible.");
                return new d.a.n0.a.u.h.b(1001, "Api-LoadingView does not supported when app is invisible.");
            }
            Pair<d.a.n0.a.u.h.b, JSONObject> b2 = d.a.n0.a.u.i.b.b("Api-LoadingView", str);
            d.a.n0.a.u.h.b bVar = (d.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-LoadingView", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            d.a.n0.a.e0.d.g("Api-LoadingView", "handleShowLoading : joParams = \n" + jSONObject);
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-LoadingView", "none title");
                }
                return new d.a.n0.a.u.h.b(202, "none title");
            }
            boolean optBoolean = jSONObject.optBoolean("mask", false);
            Context i2 = i();
            if (!(i2 instanceof SwanAppActivity)) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-LoadingView", "context not support");
                }
                return new d.a.n0.a.u.h.b(1001, "context not support");
            }
            d.a.n0.a.h0.g.g swanAppFragmentManager = ((SwanAppActivity) i2).getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-LoadingView", "none fragment");
                }
                return new d.a.n0.a.u.h.b(1001, "none fragment");
            }
            d.a.n0.a.h0.g.d m = swanAppFragmentManager.m();
            if (!(m instanceof a.InterfaceC1003a)) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-LoadingView", "fragment not support");
                }
                return new d.a.n0.a.u.h.b(1001, "fragment not support");
            }
            d.a.n0.a.z1.b.c.a floatLayer = ((a.InterfaceC1003a) m).getFloatLayer();
            if (floatLayer == null) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-LoadingView", "can't get floatLayer");
                }
                return new d.a.n0.a.u.h.b(1001, "can't get floatLayer");
            }
            r(floatLayer, i2, optString, optBoolean);
            d.a.n0.a.e0.d.g("Api-LoadingView", "show loading success");
            return new d.a.n0.a.u.h.b(0);
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }
}
