package d.a.o0.a.p0.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.k2.g.h;
import d.a.o0.a.p0.g.c.a;
import d.a.o0.a.v2.j0;
import d.a.o0.t.d;
import java.io.File;
/* loaded from: classes7.dex */
public class a<T extends d.a.o0.a.p0.g.c.a> extends d.a.o0.a.p0.d.a<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47235b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.p0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0875a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f47236a;

        /* renamed from: b  reason: collision with root package name */
        public String f47237b;

        public C0875a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47236a = 0;
        }

        public static C0875a a(int i2, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, str)) == null) {
                C0875a c0875a = new C0875a();
                c0875a.f47236a = i2;
                c0875a.f47237b = str;
                return c0875a;
            }
            return (C0875a) invokeIL.objValue;
        }

        public static C0875a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? a(1, str) : (C0875a) invokeL.objValue;
        }

        public static C0875a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a(0, "") : (C0875a) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f47236a == 0 : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.f47236a + ", message='" + this.f47237b + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1042593800, "Ld/a/o0/a/p0/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1042593800, "Ld/a/o0/a/p0/i/a;");
                return;
            }
        }
        f47235b = k.f46335a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull T t) {
        super(t);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.o0.a.p0.g.c.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.a.p0.d.a
    public File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new File(super.a(), "remote") : (File) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k("0");
            j(0L);
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        d.j(str);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ld/a/o0/a/p0/g/a;>(TT;)Ljava/lang/Exception; */
    public Exception e(@NonNull d.a.o0.a.p0.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
            if (f47235b) {
                Log.d("ExtCore-RemoteControl", "doUpdate: remote");
            }
            if (TextUtils.isEmpty(aVar.f47220c)) {
                if (f47235b) {
                    Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
                }
                return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
            }
            C0875a i2 = i(aVar);
            if (f47235b) {
                Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + i2);
            }
            d(aVar.f47220c);
            if (i2.c()) {
                return null;
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by " + i2.toString());
        }
        return (Exception) invokeL.objValue;
    }

    @NonNull
    public ExtensionCore f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ExtensionCore extensionCore = new ExtensionCore();
            long g2 = g();
            extensionCore.extensionCoreVersionCode = g2;
            extensionCore.extensionCoreVersionName = h();
            extensionCore.extensionCorePath = b(g2).getPath();
            extensionCore.extensionCoreType = 1;
            return extensionCore;
        }
        return (ExtensionCore) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h.a().getLong(this.f47143a.b(), 0L) : invokeV.longValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? h.a().getString(this.f47143a.e(), "0") : (String) invokeV.objValue;
    }

    public final C0875a i(@NonNull d.a.o0.a.p0.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (f47235b) {
                Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
                Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + aVar.f47218a + " ,filePath: " + aVar.f47220c + " ,sign:" + aVar.f47221d);
            }
            long j = aVar.f47219b;
            if (j == 0) {
                return C0875a.b("invalid version code : " + aVar.f47218a);
            } else if (!j0.a(new File(aVar.f47220c), aVar.f47221d)) {
                return C0875a.b("sign failed.");
            } else {
                if (!d.T(aVar.f47220c, b(j).getPath())) {
                    return C0875a.b("unzip bundle failed.");
                }
                d.a.o0.a.p0.j.a.b(a(), g(), j);
                j(j);
                k(aVar.f47218a);
                if (f47235b) {
                    Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + j);
                }
                return C0875a.d();
            }
        }
        return (C0875a) invokeL.objValue;
    }

    public void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            h.a().putLong(this.f47143a.b(), j);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            h.a().putString(this.f47143a.e(), str);
        }
    }
}
