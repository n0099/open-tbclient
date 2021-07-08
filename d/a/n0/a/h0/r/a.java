package d.a.n0.a.h0.r;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import d.a.n0.a.v2.h;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45173b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f45174c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(318496744, "Ld/a/n0/a/h0/r/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(318496744, "Ld/a/n0/a/h0/r/a;");
                return;
            }
        }
        f45173b = k.f45831a;
        f45174c = "swan_preset" + File.separator + "preset_list.json";
    }

    public a() {
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

    @Override // d.a.n0.a.h0.r.b
    public boolean e(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            Context appContext = AppRuntime.getAppContext();
            String str = "swan_preset" + File.separator + cVar.f50636g + File.separator + cVar.q;
            try {
                File j = j(cVar.f50637h, cVar.f50636g, cVar.f50638i);
                if (j == null) {
                    if (f45173b) {
                        Log.e("AssetPresetController", "获取解压路径失败");
                    }
                    return false;
                }
                return n(new BufferedInputStream(appContext.getAssets().open(str)), j);
            } catch (IOException e2) {
                if (f45173b) {
                    e2.printStackTrace();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.n0.a.h0.r.b
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Application b2 = d.a.n0.a.c1.a.b();
            return h.b(b2, "swan_preset" + File.separator + str + File.separator + "app_info.json");
        }
        return (String) invokeL.objValue;
    }

    @Override // d.a.n0.a.h0.r.b
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? h.b(d.a.n0.a.c1.a.b(), f45174c) : (String) invokeV.objValue;
    }
}
