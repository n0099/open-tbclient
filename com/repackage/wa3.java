package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c73;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Stack;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class wa3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static int b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject jSONObject = new JSONObject();
                File file = new File(this.a);
                try {
                    jSONObject.put("file_name", this.b);
                    jSONObject.put("file_tree", wa3.d(file));
                    jSONObject.put("file_stack_info", this.c);
                    jSONObject.put("file_free_space", file.getFreeSpace());
                    jSONObject.put("file_total_space", file.getTotalSpace());
                } catch (JSONException e) {
                    if (wa3.a) {
                        e.printStackTrace();
                    }
                }
                c73.b bVar = new c73.b(10018);
                bVar.j(this.b);
                bVar.h(t03.J().getAppId());
                bVar.i(jSONObject.toString());
                bVar.m();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.a);
                    jSONObject.put("pagePath", this.b);
                } catch (JSONException e) {
                    if (wa3.a) {
                        e.printStackTrace();
                    }
                }
                c73.b bVar = new c73.b(10018);
                bVar.i(jSONObject.toString());
                bVar.h(t03.J().getAppId());
                bVar.m();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755208152, "Lcom/repackage/wa3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755208152, "Lcom/repackage/wa3;");
                return;
            }
        }
        a = eh1.a;
        b = -1;
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) || c() <= 0) {
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String f = me3.f(str2);
            if (new File(str, f + ".swan.js").exists()) {
                return;
            }
            f(str, f);
            return;
        }
        e(str, str2);
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (b < 0) {
                bk2.g0().getSwitch("swan_app_file_analysis_switch", 0);
                b = 0;
            }
            return b;
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
                    for (int i = 0; i < arrayList.size(); i++) {
                        File file3 = (File) arrayList.get(i);
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
        if (interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) {
            od3.f().execute(new b(str, str2));
        }
    }

    public static void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) {
            od3.f().execute(new a(str, str2, Arrays.toString(new Exception().getStackTrace())));
        }
    }
}
