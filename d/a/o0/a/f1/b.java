package d.a.o0.a.f1;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.f1.a;
import d.a.o0.a.k;
import java.util.Map;
/* loaded from: classes7.dex */
public class b extends d.a.o0.a.v1.a.a.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static Map<String, d.a.o0.a.v2.e1.b<Bundle>> f44954h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f44955f;

    /* renamed from: g  reason: collision with root package name */
    public String f44956g;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.v2.e1.b<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44957e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f44958f;

        public a(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44958f = bVar;
            this.f44957e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                this.f44958f.f44956g = bundle.getString("key_launch_app_id");
                this.f44958f.f44955f = bundle.getInt("key_launch_status");
                if (TextUtils.equals(this.f44957e, this.f44958f.f44956g)) {
                    b bVar = this.f44958f;
                    bVar.f48402d.putInt("ok", bVar.f44955f);
                    this.f44958f.c();
                }
                b.f44954h.remove(this.f44957e);
            }
        }
    }

    /* renamed from: d.a.o0.a.f1.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0705b implements d.a.o0.a.v2.e1.b<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44959e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f44960f;

        public C0705b(String str, a.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44959e = str;
            this.f44960f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                String string = bundle.getString("key_launch_app_id");
                int i2 = bundle.getInt("key_launch_status");
                if (TextUtils.equals(this.f44959e, string)) {
                    if (i2 == 0) {
                        this.f44960f.b();
                    } else {
                        this.f44960f.a();
                    }
                }
                b.f44954h.remove(this.f44959e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(508144646, "Ld/a/o0/a/f1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(508144646, "Ld/a/o0/a/f1/b;");
                return;
            }
        }
        boolean z = k.f46335a;
        f44954h = new d.a.o0.o.a.c.a();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f44955f = -1;
        this.f44956g = "";
    }

    public static void j(String str, a.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, str, dVar) == null) || TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        f44954h.put(str, new C0705b(str, dVar));
    }

    public static void k(String str) {
        d.a.o0.a.v2.e1.b<Bundle> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, str) == null) || (bVar = f44954h.get(str)) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_launch_app_id", str);
        bundle.putInt("key_launch_status", 1);
        bVar.onCallback(bundle);
    }

    public static void l(String str) {
        d.a.o0.a.v2.e1.b<Bundle> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, str) == null) || (bVar = f44954h.get(str)) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_launch_app_id", str);
        bundle.putInt("key_launch_status", 0);
        bVar.onCallback(bundle);
    }

    @Override // d.a.o0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            String string = bundle.getString("desAppId");
            f44954h.put(string, new a(this, string));
        }
    }
}
