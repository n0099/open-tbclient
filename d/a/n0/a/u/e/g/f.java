package d.a.n0.a.u.e.g;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends d.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47600e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f47601f;

        public a(f fVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47601f = fVar;
            this.f47600e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.h0.g.g W = d.a.n0.a.g1.f.V().W();
                if (W == null) {
                    d.a.n0.a.e0.d.b("Api-PullDownRefresh", "manager is null");
                    this.f47601f.d(this.f47600e, new d.a.n0.a.u.h.b(1001));
                } else if (!(W.m() instanceof d.a.n0.a.h0.g.f)) {
                    d.a.n0.a.e0.d.b("Api-PullDownRefresh", "top fragment error");
                    this.f47601f.d(this.f47600e, new d.a.n0.a.u.h.b(1001));
                } else {
                    d.a.n0.a.h0.g.f fVar = (d.a.n0.a.h0.g.f) W.m();
                    if (fVar.h0() == null) {
                        d.a.n0.a.e0.d.b("Api-PullDownRefresh", "view is null");
                        this.f47601f.d(this.f47600e, new d.a.n0.a.u.h.b(1001));
                        return;
                    }
                    fVar.h0().w(false);
                    d.a.n0.a.e0.d.g("Api-PullDownRefresh", "refresh complete");
                    this.f47601f.d(this.f47600e, new d.a.n0.a.u.h.b(0));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NonNull d.a.n0.a.u.c.b bVar) {
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

    public d.a.n0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-PullDownRefresh", "stop pull down refresh");
            }
            Pair<d.a.n0.a.u.h.b, JSONObject> b2 = d.a.n0.a.u.i.b.b("Api-PullDownRefresh", str);
            d.a.n0.a.u.h.b bVar = (d.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-PullDownRefresh", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.n0.a.e0.d.b("Api-PullDownRefresh", "callback is null");
                return new d.a.n0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new a(this, optString));
            return new d.a.n0.a.u.h.b(0);
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }
}
