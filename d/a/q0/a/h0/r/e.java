package d.a.q0.a.h0.r;

import android.os.Environment;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
/* loaded from: classes8.dex */
public class e extends b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48482c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public File f48483b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705745025, "Ld/a/q0/a/h0/r/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705745025, "Ld/a/q0/a/h0/r/e;");
                return;
            }
        }
        f48482c = k.f49133a;
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
                return;
            }
        }
        this.f48483b = o();
    }

    @Override // d.a.q0.a.h0.r.b
    public boolean e(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            if (cVar != null && this.f48483b.exists()) {
                File file = this.f48483b;
                File file2 = new File(file, cVar.f53938g + File.separator + cVar.q);
                if (file2.exists()) {
                    try {
                        if (!d(Channels.newChannel(new FileInputStream(file2)), cVar.m)) {
                            if (f48482c) {
                                Log.e("SdCardPresetController", "校验签名失败");
                            }
                            return false;
                        }
                        File j = j(cVar.f53939h, cVar.f53938g, cVar.f53940i);
                        if (j == null) {
                            if (f48482c) {
                                Log.e("SdCardPresetController", "获取解压路径失败");
                            }
                            return false;
                        }
                        return n(new BufferedInputStream(new FileInputStream(file2)), j);
                    } catch (IOException e2) {
                        if (f48482c) {
                            e2.printStackTrace();
                        }
                        return false;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.a.h0.r.b
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f48483b.exists()) {
                File file = this.f48483b;
                File file2 = new File(file, str + File.separator + "app_info.json");
                if (file2.exists()) {
                    return d.a.q0.t.d.D(file2);
                }
                return null;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // d.a.q0.a.h0.r.b
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f48483b.exists()) {
                File file = new File(this.f48483b, "preset_list.json");
                if (file.exists()) {
                    return d.a.q0.t.d.D(file);
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final File o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new File(Environment.getExternalStorageDirectory().getPath(), "baidu/swan_preset/") : (File) invokeV.objValue;
    }
}
