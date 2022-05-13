package com.repackage;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.FileUtils;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes6.dex */
public class nc5 {
    public static /* synthetic */ Interceptable $ic;
    public static JSONObject a;
    public static ArrayList<Long> b;
    public static final Hashtable<String, ArrayList<c<Integer, Integer>>> c;
    public static boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements ky9<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ky9
        public void call(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                String q = iu4.k().q("old_sniff_url", "");
                if (TextUtils.isEmpty(this.a) || this.a.equals(q)) {
                    nc5.p(false);
                    return;
                }
                File file = new File(BdBaseApplication.getInst().getApp().getApplicationContext().getFilesDir(), "sniff");
                if (!file.exists()) {
                    file.mkdir();
                }
                if (lc5.j().b(new File(file, "sniff.json"), this.a) > 0) {
                    iu4.k().y("old_sniff_url", "");
                }
                nc5.p(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements ky9<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        public b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ky9
        public void call(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (nc5.a == null || this.a) {
                    nc5.g();
                }
                nc5.o();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c<X, Y> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final X a;
        public final Y b;

        public c(X x, Y y) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x, y};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x;
            this.b = y;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755474287, "Lcom/repackage/nc5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755474287, "Lcom/repackage/nc5;");
                return;
            }
        }
        b = new ArrayList<>();
        c = new Hashtable<>();
        d = true;
    }

    public nc5() {
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

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? pg0.e() : (String) invokeV.objValue;
    }

    public static void f(PackageManager packageManager, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65543, null, packageManager, str, i, i2) == null) {
            try {
                packageManager.getApplicationInfo(str, 0);
                j(i, i2);
            } catch (PackageManager.NameNotFoundException unused) {
                k(i, i2);
            }
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            File file = new File(BdBaseApplication.getInst().getApp().getApplicationContext().getFilesDir(), "sniff");
            if (file.exists()) {
                File file2 = new File(file, "sniff.json");
                if (file2.exists()) {
                    String readFileData = FileUtils.readFileData(file2);
                    if (TextUtils.isEmpty(readFileData)) {
                        return;
                    }
                    synchronized (nc5.class) {
                        try {
                            a = new JSONObject(readFileData);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            wx9.f("").k(Schedulers.io()).w(new a(str));
        }
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            ArrayList<Long> arrayList = b;
            if (arrayList == null || arrayList.size() == 0) {
                return "";
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<Long> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(String.valueOf(it.next()));
            }
            return TextUtils.join(",", arrayList2);
        }
        return (String) invokeV.objValue;
    }

    public static void j(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65547, null, i, i2) == null) {
            ArrayList<Long> arrayList = b;
            if (i < arrayList.size()) {
                arrayList.set(i, Long.valueOf(arrayList.get(i).longValue() | (1 << i2)));
            }
        }
    }

    public static void k(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65548, null, i, i2) == null) {
            ArrayList<Long> arrayList = b;
            if (i < arrayList.size()) {
                arrayList.set(i, Long.valueOf(arrayList.get(i).longValue() & (~(1 << i2))));
            }
        }
    }

    public static void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, null, i) == null) {
            k(i, 0);
        }
    }

    public static void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, null, i) == null) {
            j(i, 0);
        }
    }

    public static void n(int i, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65551, null, i, jSONArray) == null) {
            if (i >= b.size()) {
                Log.e("AD_SNIFF_RESULT_KEY", "group index should NOT greater or equal group size!!!");
                return;
            }
            PackageManager packageManager = BdBaseApplication.getInst().getApp().getApplicationContext().getPackageManager();
            l(i);
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                String optString = jSONArray.optString(i2);
                i2++;
                c<Integer, Integer> cVar = new c<>(Integer.valueOf(i), Integer.valueOf(i2));
                ArrayList<c<Integer, Integer>> arrayList = c.get(optString);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(cVar);
                c.put(optString, arrayList);
                f(packageManager, optString, i, i2);
            }
            m(i);
            iu4.k().y("AD_SNIFF_RESULT_KEY", i());
        }
    }

    public static void o() {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, null) == null) || (jSONObject = a) == null || (optJSONArray = jSONObject.optJSONArray("data")) == null) {
            return;
        }
        int length = optJSONArray.length();
        int size = b.size();
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i < size) {
                arrayList.add(b.get(i));
            } else {
                arrayList.add(0L);
            }
        }
        b = arrayList;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject == null) {
                return;
            }
            q(i2, optJSONObject.optString("name"), optJSONObject.optInt("interval"), optJSONObject.optJSONArray("list"), d);
        }
        if (d) {
            d = false;
        }
    }

    public static void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, null, z) == null) {
            wx9.f("").k(Schedulers.io()).w(new b(z));
        }
    }

    public static void q(int i, String str, int i2, JSONArray jSONArray, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), jSONArray, Boolean.valueOf(z)}) == null) || i < 0 || TextUtils.isEmpty(str) || i2 < 0 || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        long time = new Date().getTime();
        String str2 = "AD_SNIFF_RESULT_KEY_" + str + "_TS";
        long m = iu4.k().m(str2, 0L);
        long millis = TimeUnit.MINUTES.toMillis(i2);
        boolean z2 = true;
        int i3 = (m > 0L ? 1 : (m == 0L ? 0 : -1));
        boolean z3 = i3 == 0;
        z2 = (i3 <= 0 || time - m <= millis) ? false : false;
        if (z || z3 || z2) {
            iu4.k().x(str2, time);
            n(i, jSONArray);
        }
    }

    public static void r(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, null, intent) == null) || TextUtils.isEmpty(intent.getDataString())) {
            return;
        }
        String substring = intent.getDataString().length() > 8 ? intent.getDataString().substring(8) : "";
        String action = intent.getAction();
        ArrayList<c<Integer, Integer>> arrayList = c.get(substring);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<c<Integer, Integer>> it = arrayList.iterator();
        while (it.hasNext()) {
            c<Integer, Integer> next = it.next();
            if (next != null) {
                int intValue = next.a.intValue();
                int intValue2 = next.b.intValue();
                if (PackageChangedReceiver.ACTION_INSTALL.equals(action)) {
                    j(intValue, intValue2);
                } else {
                    k(intValue, intValue2);
                }
            }
        }
    }
}
