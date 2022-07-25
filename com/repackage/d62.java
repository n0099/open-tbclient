package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ej2;
import com.repackage.hj2;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class d62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ e62 b;
        public final /* synthetic */ f62 c;
        public final /* synthetic */ d62 d;

        public a(d62 d62Var, HybridUbcFlow hybridUbcFlow, e62 e62Var, f62 f62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d62Var, hybridUbcFlow, e62Var, f62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = d62Var;
            this.a = hybridUbcFlow;
            this.b = e62Var;
            this.c = f62Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow hybridUbcFlow = this.a;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("loadPresetApp#run-start");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                String f = this.d.f(this.b.g);
                if (TextUtils.isEmpty(f)) {
                    this.c.onFailed(0);
                    return;
                }
                JSONObject d = id3.d(f);
                HybridUbcFlow hybridUbcFlow2 = this.a;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("loadPresetApp#run-appInfoJson");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
                PMSAppInfo l = this.d.l(this.b, d);
                if (l == null) {
                    this.c.onFailed(1);
                    return;
                }
                HybridUbcFlow hybridUbcFlow3 = this.a;
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("loadPresetApp#run-PMSAppInfo");
                ubcFlowEvent3.a(true);
                hybridUbcFlow3.F(ubcFlowEvent3);
                this.c.a(l);
                long currentTimeMillis = System.currentTimeMillis();
                boolean e = this.d.e(this.b);
                if (d62.a) {
                    Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                }
                HybridUbcFlow hybridUbcFlow4 = this.a;
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("loadPresetApp#run-doUnzipBundle");
                ubcFlowEvent4.a(true);
                hybridUbcFlow4.F(ubcFlowEvent4);
                if (e) {
                    d62 d62Var = this.d;
                    e62 e62Var = this.b;
                    l.setOrientation(d62Var.g(e62Var.h, e62Var.g, e62Var.i));
                    l.updateInstallSrc(3);
                    d84.i().a(this.b, l);
                    HybridUbcFlow hybridUbcFlow5 = this.a;
                    UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("loadPresetApp#run-bulkInsert");
                    ubcFlowEvent5.a(true);
                    hybridUbcFlow5.F(ubcFlowEvent5);
                    this.c.b(l);
                } else {
                    this.c.onFailed(2);
                }
                HybridUbcFlow hybridUbcFlow6 = this.a;
                UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("loadPresetApp#run-return");
                ubcFlowEvent6.a(true);
                hybridUbcFlow6.F(ubcFlowEvent6);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755815535, "Lcom/repackage/d62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755815535, "Lcom/repackage/d62;");
                return;
            }
        }
        a = sg1.a;
    }

    public d62() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean d(ReadableByteChannel readableByteChannel, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, readableByteChannel, str)) == null) {
            if (readableByteChannel != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        boolean c = vd3.c(readableByteChannel, str);
                        if (a) {
                            Log.d("PresetController", "签名校验结果：" + c + " ,耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                        }
                        return c;
                    }
                } catch (IOException e) {
                    if (a) {
                        e.printStackTrace();
                    }
                    return false;
                } finally {
                    kg4.d(readableByteChannel);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public abstract boolean e(e62 e62Var);

    public abstract String f(String str);

    public final int g(int i, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j)})) == null) {
            if (i == 1) {
                return qj2.i().u(str, j);
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public HashMap<String, e62> h() {
        InterceptResult invokeV;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String i = i();
            if (TextUtils.isEmpty(i) || (optJSONArray = id3.d(i).optJSONArray("list")) == null) {
                return null;
            }
            HashMap<String, e62> hashMap = new HashMap<>();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                e62 m = m(optJSONArray.optJSONObject(i2));
                if (m != null) {
                    hashMap.put(m.g, m);
                }
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public abstract String i();

    public File j(int i, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j)})) == null) {
            if (i == 0) {
                return ej2.e.i(str, String.valueOf(j));
            }
            if (i == 1) {
                return qj2.g().a(str, String.valueOf(j));
            }
            return null;
        }
        return (File) invokeCommon.objValue;
    }

    public void k(e62 e62Var, f62 f62Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, e62Var, f62Var) == null) {
            HybridUbcFlow p = nt2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("loadPresetApp-start");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (f62Var == null) {
                return;
            }
            if (e62Var == null) {
                f62Var.onFailed(0);
                return;
            }
            cd3.k(new a(this, p, e62Var, f62Var), "加载小程序预置包");
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("loadPresetApp-return");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public final PMSAppInfo l(e62 e62Var, JSONObject jSONObject) {
        InterceptResult invokeLL;
        PMSAppInfo a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e62Var, jSONObject)) == null) {
            if (jSONObject == null || e62Var == null || (a2 = nd4.a(jSONObject)) == null) {
                return null;
            }
            a2.copyMainPkgInfo(e62Var);
            a2.createTime = System.currentTimeMillis();
            return a2;
        }
        return (PMSAppInfo) invokeLL.objValue;
    }

    public final e62 m(JSONObject jSONObject) {
        InterceptResult invokeL;
        e62 e62Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jSONObject)) == null) {
            if (jSONObject == null || (e62Var = (e62) nd4.j(jSONObject, new e62())) == null) {
                return null;
            }
            e62Var.o = jSONObject.optInt("pkg_type");
            e62Var.q = jSONObject.optString("bundle_name");
            if (e62Var.a()) {
                return e62Var;
            }
            return null;
        }
        return (e62) invokeL.objValue;
    }

    public boolean n(BufferedInputStream bufferedInputStream, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bufferedInputStream, file)) == null) {
            if (bufferedInputStream != null) {
                try {
                    if (file != null) {
                        hj2.c i = hj2.i(bufferedInputStream);
                        if ((i == null || i.b == -1) ? false : true) {
                            return hj2.d(bufferedInputStream, file, i.b).a;
                        }
                        return ng4.d(bufferedInputStream, file.getPath());
                    }
                } catch (IOException e) {
                    if (a) {
                        e.printStackTrace();
                    }
                    return false;
                } finally {
                    kg4.d(bufferedInputStream);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
