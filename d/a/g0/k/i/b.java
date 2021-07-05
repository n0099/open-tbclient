package d.a.g0.k.i;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.g0.k.h.d;
import d.a.g0.n.e;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f45468a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.g0.o.a.c f45469b;

    /* loaded from: classes8.dex */
    public class a extends d.a.g0.k.a.a<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f45470a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45471b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f45472c;

        public a(b bVar, m mVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, mVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45472c = bVar;
            this.f45470a = mVar;
            this.f45471b = str;
        }

        @Override // d.a.g0.k.a.a
        public void b(Throwable th, String str) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                if (str != null) {
                    message = str;
                } else {
                    message = th != null ? th.getMessage() : null;
                }
                m mVar = this.f45470a;
                mVar.m("pay_platform error msg is " + message, null);
                d.a.g0.k.h.b bVar = new d.a.g0.k.h.b("1");
                bVar.c(new com.baidu.poly.a.i.a("pay_platform error --> " + str, th).U());
                d.b(bVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.g0.k.a.a
        /* renamed from: c */
        public void a(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
                d.a.g0.k.h.a.g("8");
                this.f45470a.I();
                this.f45472c.c(map, this.f45471b, this.f45470a);
            }
        }
    }

    /* renamed from: d.a.g0.k.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0631b implements d.a.g0.o.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45473a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f45474b;

        public C0631b(b bVar, String str, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45473a = str;
            this.f45474b = mVar;
        }

        @Override // d.a.g0.o.a.a
        public void onResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                d.a.g0.n.d.e("WalletChannel->thirdPay onResult statusCode = " + i2 + " msg = " + str);
                this.f45474b.g(i2, d.a.g0.n.b.a(i2, this.f45473a, str));
            }
        }
    }

    public b(Activity activity, d.a.g0.o.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45468a = activity;
        this.f45469b = cVar;
    }

    public void a(Bundle bundle, String str, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, bundle, str, mVar) == null) {
            bundle.putString("reqData", "{\"payChannel\": \"" + str + "\"}");
            d.a.g0.k.b.b.j().h(bundle, new a(this, mVar, str));
        }
    }

    public void b(Map<String, String> map, String str, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, str, mVar) == null) {
            try {
                a(e.b(map), str, mVar);
            } catch (Throwable th) {
                String message = th.getMessage();
                mVar.m("third pay error msg is " + message, null);
            }
        }
    }

    public void c(Map<String, String> map, String str, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, map, str, mVar) == null) {
            d.a.g0.o.a.b bVar = new d.a.g0.o.a.b();
            bVar.f45499b = d(map);
            bVar.f45498a = str;
            String str2 = map.get("payOrderNo");
            d.f45442d = str2;
            if (this.f45469b != null) {
                d.a.g0.k.h.a.a();
                this.f45469b.a(this.f45468a, bVar, new C0631b(this, str2, mVar));
                d.a.g0.n.d.e("WalletChannel->thirdPay setIsPreparePaying()");
                mVar.setIsPreparePaying(false);
            }
        }
    }

    public JSONObject d(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, map)) == null) {
            if (TextUtils.isEmpty(map.get("payInfo"))) {
                return null;
            }
            try {
                return new JSONObject(new String(Base64.decode(map.get("payInfo"), 0)));
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
