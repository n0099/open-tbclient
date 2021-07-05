package d.a.q0.a.u.e.g;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f extends d.a.q0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50902e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f50903f;

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
            this.f50903f = fVar;
            this.f50902e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.h0.g.g W = d.a.q0.a.g1.f.V().W();
                if (W == null) {
                    d.a.q0.a.e0.d.b("Api-PullDownRefresh", "manager is null");
                    this.f50903f.d(this.f50902e, new d.a.q0.a.u.h.b(1001));
                } else if (!(W.m() instanceof d.a.q0.a.h0.g.f)) {
                    d.a.q0.a.e0.d.b("Api-PullDownRefresh", "top fragment error");
                    this.f50903f.d(this.f50902e, new d.a.q0.a.u.h.b(1001));
                } else {
                    d.a.q0.a.h0.g.f fVar = (d.a.q0.a.h0.g.f) W.m();
                    if (fVar.h0() == null) {
                        d.a.q0.a.e0.d.b("Api-PullDownRefresh", "view is null");
                        this.f50903f.d(this.f50902e, new d.a.q0.a.u.h.b(1001));
                        return;
                    }
                    fVar.h0().w(false);
                    d.a.q0.a.e0.d.g("Api-PullDownRefresh", "refresh complete");
                    this.f50903f.d(this.f50902e, new d.a.q0.a.u.h.b(0));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NonNull d.a.q0.a.u.c.b bVar) {
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
                super((d.a.q0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d.a.q0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.a.q0.a.u.c.d.f50740c) {
                Log.d("Api-PullDownRefresh", "stop pull down refresh");
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-PullDownRefresh", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.q0.a.u.c.d.f50740c) {
                    d.a.q0.a.e0.d.b("Api-PullDownRefresh", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.q0.a.e0.d.b("Api-PullDownRefresh", "callback is null");
                return new d.a.q0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new a(this, optString));
            return new d.a.q0.a.u.h.b(0);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }
}
