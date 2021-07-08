package d.a.n0.a.u.e.g;

import android.animation.ValueAnimator;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.u.c.d;
import d.a.n0.a.v2.n0;
import d.a.n0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends d.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f47565a;

        /* renamed from: d.a.n0.a.u.e.g.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0913a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f47566e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f47567f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f47568g;

            /* renamed from: d.a.n0.a.u.e.g.d$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0914a implements ValueAnimator.AnimatorUpdateListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ d.a.n0.a.p.e.c f47569e;

                public C0914a(RunnableC0913a runnableC0913a, d.a.n0.a.p.e.c cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0913a, cVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f47569e = cVar;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                        this.f47569e.webViewScrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }
            }

            public RunnableC0913a(a aVar, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47568g = aVar;
                this.f47566e = i2;
                this.f47567f = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.n0.a.p.e.c h2;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (h2 = d.a.n0.a.g1.f.V().h()) == null) {
                    return;
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(h2.getWebViewScrollY(), d.s(h2, n0.f(this.f47568g.f47565a.i(), this.f47566e)));
                ofInt.setDuration(this.f47567f);
                ofInt.addUpdateListener(new C0914a(this, h2));
                ofInt.start();
            }
        }

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
            this.f47565a = dVar;
        }

        @Override // d.a.n0.a.u.c.d.b
        public d.a.n0.a.u.h.b a(d.a.n0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                int optInt = jSONObject.optInt("scrollTop", -1);
                int optInt2 = jSONObject.optInt("duration", -1);
                if (optInt > -1 && optInt2 > -1) {
                    q0.b0(new RunnableC0913a(this, optInt, optInt2));
                    return new d.a.n0.a.u.h.b(0);
                }
                d.a.n0.a.e0.d.b("Api-PageScrollTo", "illegal scrollTop or duration");
                return new d.a.n0.a.u.h.b(1001, "illegal params");
            }
            return (d.a.n0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull d.a.n0.a.u.c.b bVar) {
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

    public static int s(@NonNull d.a.n0.a.p.e.c cVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, cVar, i2)) == null) {
            int contentHeight = ((int) (cVar.getContentHeight() * cVar.getScale())) - ((Integer) d.a.n0.a.g1.f.V().r().second).intValue();
            if (contentHeight <= 0) {
                return 0;
            }
            return i2 > contentHeight ? contentHeight : i2;
        }
        return invokeLI.intValue;
    }

    public d.a.n0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-PageScrollTo", "page scroll to");
            }
            return j(str, false, new a(this));
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }
}
