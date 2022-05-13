package com.repackage;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class tu3 implements su3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, uu3> a;
    public HashMap<String, ArrayList<su3>> b;
    public String c;
    public az3 d;
    public final Object e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755278305, "Lcom/repackage/tu3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755278305, "Lcom/repackage/tu3;");
                return;
            }
        }
        f = eh1.a;
    }

    public tu3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.b = new HashMap<>();
        this.e = new Object();
        this.c = str;
    }

    @Override // com.repackage.su3
    public void a(String str, String str2) {
        ArrayList<su3> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            synchronized (this.e) {
                if (d(str) && (arrayList = this.b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        arrayList.get(i).a(str, str2);
                        if (f) {
                            Log.e("AudioDownloadManager", i + " load success url = " + str + " path = " + str2);
                        }
                    }
                    this.a.remove(str);
                }
            }
        }
    }

    public final void b(String str, su3 su3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, su3Var) == null) {
            if (this.b.containsKey(str)) {
                this.b.get(str).add(su3Var);
                return;
            }
            ArrayList<su3> arrayList = new ArrayList<>();
            arrayList.add(su3Var);
            this.b.put(str, arrayList);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (f) {
                Log.d("AudioDownloadManager", "AudioDownloader SwanGamePreloadManager url:" + str);
            }
            if (this.d == null) {
                this.d = az3.b();
            }
            uu3 uu3Var = new uu3(this.d, this.c, str, this);
            this.a.put(str, uu3Var);
            uu3Var.e();
        }
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.a.containsKey(str) : invokeL.booleanValue;
    }

    public void e(String str, su3 su3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, su3Var) == null) {
            synchronized (this.e) {
                if (!d(str)) {
                    if (f) {
                        Log.e("AudioDownloadManager", "start load url = " + str);
                    }
                    c(str);
                } else if (f) {
                    Log.e("AudioDownloadManager", "re load url = " + str);
                }
                b(str, su3Var);
            }
        }
    }

    @Override // com.repackage.su3
    public void fail(int i, String str) {
        ArrayList<su3> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
            synchronized (this.e) {
                if (d(str) && (arrayList = this.b.get(str)) != null) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.get(i2).fail(i, str);
                    }
                    this.a.remove(str);
                }
            }
        }
    }
}
