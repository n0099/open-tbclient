package com.repackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jo0;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ia1 {
    public static /* synthetic */ Interceptable $ic;
    public static d a;
    public static List<ka1> b;
    public static ka1 c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ File d;

        /* renamed from: com.repackage.ia1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0447a implements jo0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0447a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.repackage.jo0.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (ja1.k() && !TextUtils.isEmpty(this.a.c) && !TextUtils.equals(g01.a(this.a.a), this.a.c)) {
                        this.a.a.delete();
                        return;
                    }
                    a aVar = this.a;
                    ia1.y(aVar.a, aVar.d);
                }
            }
        }

        public a(File file, String str, String str2, File file2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str, str2, file2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = file;
            this.b = str;
            this.c = str2;
            this.d = file2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    jo0.a(this.a, this.b, new C0447a(this));
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ka1 a;

        public b(ka1 ka1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ka1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ka1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ia1.A(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public c(List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            List list;
            ka1 ka1Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.a) == null || list.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(3);
            Iterator it = this.a.iterator();
            while (it.hasNext() && (ka1Var = (ka1) it.next()) != null) {
                if (ia1.u(ka1Var.w)) {
                    ia1.i(ka1Var);
                } else {
                    arrayList.add(ka1Var);
                }
            }
            if (arrayList.size() > 0) {
                if (ia1.a == null) {
                    d unused = ia1.a = new d(arrayList, null);
                    bh0.b().registerReceiver(ia1.a, ia1.a.getIntentFilter());
                    return;
                }
                ia1.a.setNeedDownloadList(arrayList);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<ka1> mNeedDownloadList;

        public /* synthetic */ d(List list, a aVar) {
            this(list);
        }

        public IntentFilter getIntentFilter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE") : (IntentFilter) invokeV.objValue;
        }

        public List<ka1> getNeedDownloadList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mNeedDownloadList : (List) invokeV.objValue;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) {
                Log.d("SourceManager", "onReceive: receiver");
                if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
                    ArrayList arrayList = new ArrayList();
                    for (ka1 ka1Var : this.mNeedDownloadList) {
                        if (ia1.u(ka1Var.w)) {
                            Log.d("SourceManager", "onReceive: " + ka1Var);
                            ia1.i(ka1Var);
                        } else {
                            arrayList.add(ka1Var);
                        }
                    }
                    this.mNeedDownloadList = arrayList;
                }
            }
        }

        public void setNeedDownloadList(List<ka1> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.mNeedDownloadList = list;
            }
        }

        public d(List<ka1> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mNeedDownloadList = list;
        }
    }

    public static void A(ka1 ka1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, ka1Var) == null) {
            ArrayList arrayList = new ArrayList();
            File p = p();
            List<ka1> r = r();
            if (r == null || r.size() == 0) {
                return;
            }
            for (int i = 0; i < r.size(); i++) {
                ka1 ka1Var2 = r.get(i);
                if (TextUtils.equals(ka1Var.b, ka1Var2.b)) {
                    ka1.l(ka1Var2, ka1Var);
                    arrayList.add(ka1Var2);
                } else {
                    arrayList.add(ka1Var2);
                }
            }
            x(arrayList, p);
        }
    }

    public static void B(ka1 ka1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, ka1Var) == null) || ka1Var.v < 1) {
            return;
        }
        int i = ka1Var.x;
        if (i < Integer.MAX_VALUE) {
            ka1Var.x = i + 1;
        }
        ty0.d(new b(ka1Var), "updateSplashDataItemRate");
    }

    public static void C(List<ka1> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || list == null || list.size() == 0) {
            return;
        }
        b = Collections.synchronizedList(list);
        x(list, p());
    }

    public static int e(ka1 ka1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, ka1Var)) == null) ? g(ka1Var, false, 0) : invokeL.intValue;
    }

    public static int f(ka1 ka1Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, ka1Var, i)) == null) ? g(ka1Var, false, i) : invokeLI.intValue;
    }

    public static int g(ka1 ka1Var, boolean z, int i) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{ka1Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (ka1Var.f()) {
                i2 = !ja1.a(da1.a()) ? 1024 : 0;
                if (ma1.a() >= ja1.d()) {
                    i2 |= 2048;
                }
                if (!ja1.c(true)) {
                    i2 |= 4096;
                }
                if (i2 != 0) {
                    return i2;
                }
            } else {
                i2 = 0;
            }
            if (ka1Var.y) {
                return i2;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long c2 = ma1.c();
            if (currentTimeMillis < ka1Var.s || currentTimeMillis > ka1Var.t) {
                i2 |= 2;
            }
            if (z) {
                int i3 = ka1Var.x;
                int i4 = ka1Var.v;
                if (i3 >= i4 || i4 == 0) {
                    i2 |= 8;
                }
            }
            if (currentTimeMillis - c2 < ka1Var.u * 60000) {
                i2 |= 16;
            }
            File q = q(ka1Var.g);
            if (q == null || !q.exists()) {
                i2 |= 4;
            }
            return (i == 1 && x91.a().d() != null && x91.a().d().optInt("hot_launch_splash_policy", 0) == 2 && TextUtils.equals(ka1Var.e, "splash_video")) ? i2 | 256 : i2;
        }
        return invokeCommon.intValue;
    }

    public static void h(@Nullable List<ka1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, list) == null) {
            if (list != null && !list.isEmpty()) {
                File[] listFiles = o().listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (ka1 ka1Var : list) {
                    if (ka1Var != null) {
                        arrayList.add(l(ka1Var.g));
                        arrayList.add(l(ka1Var.z));
                        arrayList.add(l(ka1Var.H));
                    }
                }
                ka1 ka1Var2 = c;
                if (ka1Var2 != null) {
                    arrayList.add(l(ka1Var2.g));
                    arrayList.add(l(c.z));
                    arrayList.add(l(c.H));
                }
                for (File file : listFiles) {
                    if (!arrayList.contains(file.getName())) {
                        file.delete();
                    }
                }
                return;
            }
            f01.c(o());
        }
    }

    public static void i(ka1 ka1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, ka1Var) == null) && URLUtil.isNetworkUrl(ka1Var.g)) {
            j(ka1Var.g, ka1Var.j);
            if (!TextUtils.isEmpty(ka1Var.z)) {
                j(ka1Var.z, "");
            }
            if (TextUtils.isEmpty(ka1Var.H)) {
                return;
            }
            j(ka1Var.H, "");
        }
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            File q = q(str);
            if (q == null || !q.exists()) {
                File t = t(g01.c(str, false));
                if (t.exists()) {
                    t.delete();
                }
                ty0.d(new a(t, str, str2, q), "download splash resource");
            }
        }
    }

    public static String k(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, file)) == null) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (Exception unused) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                } catch (Exception unused3) {
                }
            } catch (Exception unused4) {
            } catch (Throwable th2) {
                th = th2;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(g01.c(str, false));
            int lastIndexOf = str.lastIndexOf(".");
            int lastIndexOf2 = str.lastIndexOf("/");
            if (lastIndexOf < lastIndexOf2 || lastIndexOf == -1 || lastIndexOf2 == -1) {
                return null;
            }
            sb.append(str.substring(lastIndexOf));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static ka1 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? n(0) : (ka1) invokeV.objValue;
    }

    @Nullable
    public static ka1 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) {
            List<ka1> w = w(true, i);
            if (w == null || w.size() <= 0) {
                return null;
            }
            for (int i2 = 0; i2 < w.size(); i2++) {
                ka1 ka1Var = w.get(i2);
                if (ka1Var != null && ka1Var.h()) {
                    return ka1Var;
                }
            }
            return null;
        }
        return (ka1) invokeI.objValue;
    }

    public static File o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            File file = new File(bh0.b().getFilesDir(), SpeedStatsUtils.UBC_VALUE_SPLASH);
            file.mkdirs();
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static File p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? new File(o(), "splash.dat") : (File) invokeV.objValue;
    }

    public static File q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            String l = l(str);
            if (TextUtils.isEmpty(l)) {
                return null;
            }
            return new File(o(), l);
        }
        return (File) invokeL.objValue;
    }

    public static List<ka1> r() {
        InterceptResult invokeV;
        String k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            List<ka1> list = b;
            if (list != null) {
                return list;
            }
            b = new CopyOnWriteArrayList();
            File p = p();
            if (p.exists() && (k = k(p)) != null) {
                try {
                    JSONArray jSONArray = new JSONArray(k);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        b.add(ka1.b(jSONArray.optJSONObject(i)));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return b;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public static HashMap<String, ka1> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            HashMap<String, ka1> hashMap = new HashMap<>();
            File p = p();
            if (p.exists()) {
                try {
                    JSONArray jSONArray = new JSONArray(k(p));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        ka1 b2 = ka1.b((JSONObject) jSONArray.get(i));
                        hashMap.put(b2.b, b2);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return hashMap;
            }
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    public static File t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".tmp");
            return new File(o(), stringBuffer.toString());
        }
        return (File) invokeL.objValue;
    }

    public static boolean u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65559, null, i)) == null) ? new wn0(bh0.b()).a() || i == 0 : invokeI.booleanValue;
    }

    public static List<ka1> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? w(false, 0) : (List) invokeV.objValue;
    }

    public static List<ka1> w(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            List<ka1> r = r();
            if (r != null && r.size() != 0) {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                int i2 = 0;
                for (int i3 = 0; i3 < r.size(); i3++) {
                    ka1 ka1Var = r.get(i3);
                    int g = g(ka1Var, z, i);
                    if (g == 0) {
                        arrayList.add(ka1Var);
                    } else {
                        i2 |= g;
                        try {
                            jSONObject.put(ka1Var.c, g);
                        } catch (JSONException unused) {
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    BaseVM.i(i2, jSONObject.toString());
                    return null;
                }
                return arrayList;
            }
            BaseVM.h(1);
            return null;
        }
        return (List) invokeCommon.objValue;
    }

    public static boolean x(List<ka1> list, File file) {
        InterceptResult invokeLL;
        StringBuffer stringBuffer;
        int i;
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, list, file)) == null) {
            int i2 = 0;
            if (list.size() <= 0) {
                return false;
            }
            FileWriter fileWriter2 = null;
            try {
                ka1[] ka1VarArr = (ka1[]) list.toArray(new ka1[list.size() - 1]);
                stringBuffer = new StringBuffer();
                stringBuffer.append(PreferencesUtil.LEFT_MOUNT);
                int length = ka1VarArr.length;
                while (true) {
                    i = length - 1;
                    if (i2 >= i) {
                        break;
                    }
                    stringBuffer.append(ka1VarArr[i2].k());
                    stringBuffer.append(",");
                    i2++;
                }
                stringBuffer.append(ka1VarArr[i].k());
                stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
                fileWriter = new FileWriter(file);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileWriter.write(stringBuffer.toString());
                try {
                    fileWriter.close();
                } catch (Exception unused2) {
                }
                return true;
            } catch (IOException unused3) {
                fileWriter2 = fileWriter;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (Exception unused4) {
                    }
                }
                return true;
            } catch (Throwable th2) {
                fileWriter2 = fileWriter;
                th = th2;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean y(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, file, file2)) == null) {
            if (file == null || file2 == null) {
                return false;
            }
            return file.renameTo(file2);
        }
        return invokeLL.booleanValue;
    }

    public static void z(List<ka1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, list) == null) {
            ty0.d(new c(list), "ScheduleDownloadSplashSourceThread");
        }
    }
}
