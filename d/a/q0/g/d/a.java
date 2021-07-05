package d.a.q0.g.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.e;
import d.a.q0.a.e2.c.f;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.q0.g.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1120a implements d.a.q0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.u0.b f52999e;

        public C1120a(a aVar, d.a.q0.a.u0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52999e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                boolean z = true;
                if ((fVar == null || fVar.f47631d || fVar.j != 1) ? false : false) {
                    this.f52999e.a(null);
                } else {
                    this.f52999e.onFail(10001, "authorize fail.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super("authorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.g.f.a
    public d.a.q0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.q0.a.u0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            if (d.a.q0.g.f.a.f53004b && jSONObject.optBoolean("debug", false)) {
                Log.i("authorize", "debug mode: true.");
                bVar.a(null);
                return null;
            }
            e Q = e.Q();
            if (Q == null) {
                bVar.onFail(10001, "authorize fail.");
                return null;
            }
            Q.T().e("mapp_gamecenter_private_api", new C1120a(this, bVar));
            return null;
        }
        return (d.a.q0.a.u.h.b) invokeLL.objValue;
    }
}
