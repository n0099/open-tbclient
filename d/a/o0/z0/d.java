package d.a.o0.z0;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.util.io.FileUtils;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static JSONObject f53636a;

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<Long> f53637b;

    /* renamed from: c  reason: collision with root package name */
    public static final Hashtable<String, ArrayList<c<Integer, Integer>>> f53638c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f53639d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements h.n.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f53640e;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53640e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                String p = d.a.o0.r.d0.b.j().p("old_sniff_url", "");
                if (TextUtils.isEmpty(this.f53640e) || this.f53640e.equals(p)) {
                    d.q(false);
                    return;
                }
                File file = new File(BdBaseApplication.getInst().getApp().getApplicationContext().getFilesDir(), "sniff");
                if (!file.exists()) {
                    file.mkdir();
                }
                if (d.a.o0.z0.b.c().a(new File(file, "sniff.json"), this.f53640e) > 0) {
                    d.a.o0.r.d0.b.j().x("old_sniff_url", "");
                }
                d.q(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements h.n.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f53641e;

        public b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53641e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (d.f53636a == null || this.f53641e) {
                    d.h();
                }
                d.p();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c<X, Y> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final X f53642a;

        /* renamed from: b  reason: collision with root package name */
        public final Y f53643b;

        public c(X x, Y y) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x, y};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53642a = x;
            this.f53643b = y;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(997895911, "Ld/a/o0/z0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(997895911, "Ld/a/o0/z0/d;");
                return;
            }
        }
        f53637b = new ArrayList<>();
        f53638c = new Hashtable<>();
        f53639d = true;
    }

    public d() {
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

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f53637b.size() > 0) {
                return j();
            }
            return g();
        }
        return (String) invokeV.objValue;
    }

    public static void f(PackageManager packageManager, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65543, null, packageManager, str, i2, i3) == null) {
            try {
                packageManager.getApplicationInfo(str, 0);
                k(i2, i3);
            } catch (PackageManager.NameNotFoundException unused) {
                l(i2, i3);
            }
        }
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String p = d.a.o0.r.d0.b.j().p("AD_SNIFF_RESULT_KEY", "");
            if (!TextUtils.isEmpty(p)) {
                ArrayList<Long> arrayList = new ArrayList<>();
                for (String str : p.split(",")) {
                    arrayList.add(Long.valueOf(str));
                }
                f53637b = arrayList;
            } else {
                q(false);
            }
            return p;
        }
        return (String) invokeV.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            File file = new File(BdBaseApplication.getInst().getApp().getApplicationContext().getFilesDir(), "sniff");
            if (file.exists()) {
                File file2 = new File(file, "sniff.json");
                if (file2.exists()) {
                    String readFileData = FileUtils.readFileData(file2);
                    if (TextUtils.isEmpty(readFileData)) {
                        return;
                    }
                    synchronized (d.class) {
                        try {
                            f53636a = new JSONObject(readFileData);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            h.d.i("").o(Schedulers.io()).B(new a(str));
        }
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            ArrayList<Long> arrayList = f53637b;
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

    public static void k(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65548, null, i2, i3) == null) {
            ArrayList<Long> arrayList = f53637b;
            if (i2 < arrayList.size()) {
                arrayList.set(i2, Long.valueOf(arrayList.get(i2).longValue() | (1 << i3)));
            }
        }
    }

    public static void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65549, null, i2, i3) == null) {
            ArrayList<Long> arrayList = f53637b;
            if (i2 < arrayList.size()) {
                arrayList.set(i2, Long.valueOf(arrayList.get(i2).longValue() & (~(1 << i3))));
            }
        }
    }

    public static void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, null, i2) == null) {
            l(i2, 0);
        }
    }

    public static void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65551, null, i2) == null) {
            k(i2, 0);
        }
    }

    public static void o(int i2, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65552, null, i2, jSONArray) == null) {
            if (i2 >= f53637b.size()) {
                Log.e("AD_SNIFF_RESULT_KEY", "group index should NOT greater or equal group size!!!");
                return;
            }
            PackageManager packageManager = BdBaseApplication.getInst().getApp().getApplicationContext().getPackageManager();
            m(i2);
            int i3 = 0;
            while (i3 < jSONArray.length()) {
                String optString = jSONArray.optString(i3);
                i3++;
                c<Integer, Integer> cVar = new c<>(Integer.valueOf(i2), Integer.valueOf(i3));
                ArrayList<c<Integer, Integer>> arrayList = f53638c.get(optString);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(cVar);
                f53638c.put(optString, arrayList);
                f(packageManager, optString, i2, i3);
            }
            n(i2);
            d.a.o0.r.d0.b.j().x("AD_SNIFF_RESULT_KEY", j());
        }
    }

    public static void p() {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, null) == null) || (jSONObject = f53636a) == null || (optJSONArray = jSONObject.optJSONArray("data")) == null) {
            return;
        }
        int length = optJSONArray.length();
        int size = f53637b.size();
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 < size) {
                arrayList.add(f53637b.get(i2));
            } else {
                arrayList.add(0L);
            }
        }
        f53637b = arrayList;
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject == null) {
                return;
            }
            r(i3, optJSONObject.optString("name"), optJSONObject.optInt("interval"), optJSONObject.optJSONArray("list"), f53639d);
        }
        if (f53639d) {
            f53639d = false;
        }
    }

    public static void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            h.d.i("").o(Schedulers.io()).B(new b(z));
        }
    }

    public static void r(int i2, String str, int i3, JSONArray jSONArray, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), jSONArray, Boolean.valueOf(z)}) == null) || i2 < 0 || TextUtils.isEmpty(str) || i3 < 0 || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        long time = new Date().getTime();
        String str2 = "AD_SNIFF_RESULT_KEY_" + str + "_TS";
        long l = d.a.o0.r.d0.b.j().l(str2, 0L);
        long millis = TimeUnit.MINUTES.toMillis(i3);
        boolean z2 = true;
        int i4 = (l > 0L ? 1 : (l == 0L ? 0 : -1));
        boolean z3 = i4 == 0;
        z2 = (i4 <= 0 || time - l <= millis) ? false : false;
        if (z || z3 || z2) {
            d.a.o0.r.d0.b.j().w(str2, time);
            o(i2, jSONArray);
        }
    }

    public static void s(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, null, intent) == null) || TextUtils.isEmpty(intent.getDataString())) {
            return;
        }
        String substring = intent.getDataString().length() > 8 ? intent.getDataString().substring(8) : "";
        String action = intent.getAction();
        ArrayList<c<Integer, Integer>> arrayList = f53638c.get(substring);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<c<Integer, Integer>> it = arrayList.iterator();
        while (it.hasNext()) {
            c<Integer, Integer> next = it.next();
            if (next != null) {
                int intValue = next.f53642a.intValue();
                int intValue2 = next.f53643b.intValue();
                if (PackageChangedReceiver.ACTION_INSTALL.equals(action)) {
                    k(intValue, intValue2);
                } else {
                    l(intValue, intValue2);
                }
            }
        }
    }
}
