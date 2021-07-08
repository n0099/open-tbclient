package d.a.n0.a.n2.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.d;
import d.a.n0.a.j2.c;
import d.a.n0.a.k;
import d.a.n0.a.v2.o0;
import d.a.n0.a.v2.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Stack;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46439a;

    /* renamed from: b  reason: collision with root package name */
    public static int f46440b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.n2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC0842a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46441e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46442f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46443g;

        public RunnableC0842a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46441e = str;
            this.f46442f = str2;
            this.f46443g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject jSONObject = new JSONObject();
                File file = new File(this.f46441e);
                try {
                    jSONObject.put("file_name", this.f46442f);
                    jSONObject.put("file_tree", a.d(file));
                    jSONObject.put("file_stack_info", this.f46443g);
                    jSONObject.put("file_free_space", file.getFreeSpace());
                    jSONObject.put("file_total_space", file.getTotalSpace());
                } catch (JSONException e2) {
                    if (a.f46439a) {
                        e2.printStackTrace();
                    }
                }
                c.b bVar = new c.b(10018);
                bVar.j(this.f46442f);
                bVar.h(d.g().getAppId());
                bVar.i(jSONObject.toString());
                bVar.m();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46444e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46445f;

        public b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46444e = str;
            this.f46445f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.f46444e);
                    jSONObject.put("pagePath", this.f46445f);
                } catch (JSONException e2) {
                    if (a.f46439a) {
                        e2.printStackTrace();
                    }
                }
                c.b bVar = new c.b(10018);
                bVar.i(jSONObject.toString());
                bVar.h(d.g().getAppId());
                bVar.m();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1405482135, "Ld/a/n0/a/n2/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1405482135, "Ld/a/n0/a/n2/g/a;");
                return;
            }
        }
        f46439a = k.f45831a;
        f46440b = -1;
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) || c() <= 0) {
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String f2 = o0.f(str2);
            if (new File(str, f2 + ".swan.js").exists()) {
                return;
            }
            f(str, f2);
            return;
        }
        e(str, str2);
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f46440b < 0) {
                d.a.n0.a.c1.a.Z().getSwitch("swan_app_file_analysis_switch", 0);
                f46440b = 0;
            }
            d.a.n0.a.e0.d.g("FileNotFoundReporter", "getSwitch:" + f46440b);
            return f46440b;
        }
        return invokeV.intValue;
    }

    public static String d(File file) {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            if (file != null && file.exists() && file.isDirectory()) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Stack stack = new Stack();
                stack.push(file);
                while (!stack.isEmpty()) {
                    File file2 = (File) stack.pop();
                    if (file2 != null) {
                        if (file2.isFile()) {
                            arrayList.add(file2);
                        } else if (file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length > 0) {
                            Collections.addAll(stack, listFiles);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        File file3 = (File) arrayList.get(i2);
                        arrayList2.add(file3.getAbsolutePath() + "|" + new Date(file3.lastModified()));
                    }
                }
                return Arrays.toString(arrayList2.toArray());
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) {
            q.e().execute(new b(str, str2));
        }
    }

    public static void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) {
            q.e().execute(new RunnableC0842a(str, str2, Arrays.toString(new Exception().getStackTrace())));
        }
    }
}
