package d.a.o0.a.l0.m;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.smallgame.sdk.permission.PermissionListener;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.o0.a.e2.c.i;
import d.a.o0.a.e2.c.j.b;
import d.a.o0.a.k;
import d.a.o0.a.s1.f;
/* loaded from: classes7.dex */
public class e implements PermissionProxy {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46472a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46473e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46474f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PermissionListener f46475g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f46476h;

        public a(e eVar, String str, String str2, PermissionListener permissionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, permissionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46476h = eVar;
            this.f46473e = str;
            this.f46474f = str2;
            this.f46475g = permissionListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.o0.a.e2.c.d.h(iVar)) {
                    this.f46476h.b(this.f46473e, this.f46474f, this.f46475g);
                } else {
                    this.f46475g.onPermissionResult(this.f46473e, 2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PermissionListener f46477a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46478b;

        public b(e eVar, PermissionListener permissionListener, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, permissionListener, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46477a = permissionListener;
            this.f46478b = str;
        }

        @Override // d.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f46477a.onPermissionResult(this.f46478b, 0);
            }
        }

        @Override // d.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f46477a.onPermissionResult(this.f46478b, 1);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-297521940, "Ld/a/o0/a/l0/m/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-297521940, "Ld/a/o0/a/l0/m/e;");
                return;
            }
        }
        f46472a = k.f46335a;
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void b(@NonNull String str, @NonNull String str2, @NonNull PermissionListener permissionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, permissionListener) == null) {
            b bVar = new b(this, permissionListener, str);
            d.a.o0.a.s1.e.e(str2, new String[]{str2}, 2, d.a.o0.a.a2.d.g().x(), bVar);
        }
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str == null) {
                return null;
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1785599184) {
                if (hashCode == -1352756132 && str.equals(PermissionProxy.SCOPE_ID_RECORD)) {
                    c2 = 1;
                }
            } else if (str.equals(PermissionProxy.SCOPE_ID_CAMERA)) {
                c2 = 0;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    return null;
                }
                return PermissionRequest.RESOURCE_AUDIO_CAPTURE;
            }
            return PermissionRequest.RESOURCE_VIDEO_CAPTURE;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.smallgame.sdk.permission.PermissionProxy
    public void requestPermission(String str, PermissionListener permissionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, permissionListener) == null) {
            if (f46472a) {
                Log.d("V8PermissionDelegate", "requestPermission : " + str);
            }
            if (permissionListener == null) {
                if (f46472a) {
                    Log.e("V8PermissionDelegate", "PermissionListener can not be null.");
                    return;
                }
                return;
            }
            String c2 = c(str);
            d.a.o0.a.a2.e i2 = d.a.o0.a.a2.e.i();
            if (!TextUtils.isEmpty(c2) && i2 != null && i2.x() != null) {
                i2.T().g(i2.x(), str, new a(this, str, c2, permissionListener));
            } else {
                permissionListener.onPermissionResult(str, 2);
            }
        }
    }
}
