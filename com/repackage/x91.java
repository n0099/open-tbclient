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
import com.repackage.fo0;
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
/* loaded from: classes7.dex */
public class x91 {
    public static /* synthetic */ Interceptable $ic;
    public static d a;
    public static List<z91> b;
    public static z91 c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ File d;

        /* renamed from: com.repackage.x91$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0557a implements fo0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0557a(a aVar) {
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

            @Override // com.repackage.fo0.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (y91.k() && !TextUtils.isEmpty(this.a.c) && !TextUtils.equals(c01.a(this.a.a), this.a.c)) {
                        this.a.a.delete();
                        return;
                    }
                    a aVar = this.a;
                    x91.y(aVar.a, aVar.d);
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
                    fo0.a(this.a, this.b, new C0557a(this));
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z91 a;

        public b(z91 z91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z91Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                x91.A(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
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
            z91 z91Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.a) == null || list.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(3);
            Iterator it = this.a.iterator();
            while (it.hasNext() && (z91Var = (z91) it.next()) != null) {
                if (x91.u(z91Var.w)) {
                    x91.i(z91Var);
                } else {
                    arrayList.add(z91Var);
                }
            }
            if (arrayList.size() > 0) {
                if (x91.a == null) {
                    d unused = x91.a = new d(arrayList, null);
                    xg0.b().registerReceiver(x91.a, x91.a.getIntentFilter());
                    return;
                }
                x91.a.setNeedDownloadList(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<z91> mNeedDownloadList;

        public /* synthetic */ d(List list, a aVar) {
            this(list);
        }

        public IntentFilter getIntentFilter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE") : (IntentFilter) invokeV.objValue;
        }

        public List<z91> getNeedDownloadList() {
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
                    for (z91 z91Var : this.mNeedDownloadList) {
                        if (x91.u(z91Var.w)) {
                            Log.d("SourceManager", "onReceive: " + z91Var);
                            x91.i(z91Var);
                        } else {
                            arrayList.add(z91Var);
                        }
                    }
                    this.mNeedDownloadList = arrayList;
                }
            }
        }

        public void setNeedDownloadList(List<z91> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.mNeedDownloadList = list;
            }
        }

        public d(List<z91> list) {
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

    public static void A(z91 z91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, z91Var) == null) {
            ArrayList arrayList = new ArrayList();
            File p = p();
            List<z91> r = r();
            if (r == null || r.size() == 0) {
                return;
            }
            for (int i = 0; i < r.size(); i++) {
                z91 z91Var2 = r.get(i);
                if (TextUtils.equals(z91Var.b, z91Var2.b)) {
                    z91.l(z91Var2, z91Var);
                    arrayList.add(z91Var2);
                } else {
                    arrayList.add(z91Var2);
                }
            }
            x(arrayList, p);
        }
    }

    public static void B(z91 z91Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, z91Var) == null) || z91Var.v < 1) {
            return;
        }
        int i = z91Var.x;
        if (i < Integer.MAX_VALUE) {
            z91Var.x = i + 1;
        }
        py0.d(new b(z91Var), "updateSplashDataItemRate");
    }

    public static void C(List<z91> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || list == null || list.size() == 0) {
            return;
        }
        b = Collections.synchronizedList(list);
        x(list, p());
    }

    public static int e(z91 z91Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, z91Var)) == null) ? g(z91Var, false, 0) : invokeL.intValue;
    }

    public static int f(z91 z91Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, z91Var, i)) == null) ? g(z91Var, false, i) : invokeLI.intValue;
    }

    public static int g(z91 z91Var, boolean z, int i) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{z91Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z91Var.f()) {
                i2 = !y91.a(s91.a()) ? 1024 : 0;
                if (ba1.a() >= y91.d()) {
                    i2 |= 2048;
                }
                if (!y91.c(true)) {
                    i2 |= 4096;
                }
                if (i2 != 0) {
                    return i2;
                }
            } else {
                i2 = 0;
            }
            if (z91Var.y) {
                return i2;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long c2 = ba1.c();
            if (currentTimeMillis < z91Var.s || currentTimeMillis > z91Var.t) {
                i2 |= 2;
            }
            if (z) {
                int i3 = z91Var.x;
                int i4 = z91Var.v;
                if (i3 >= i4 || i4 == 0) {
                    i2 |= 8;
                }
            }
            if (currentTimeMillis - c2 < z91Var.u * 60000) {
                i2 |= 16;
            }
            File q = q(z91Var.g);
            if (q == null || !q.exists()) {
                i2 |= 4;
            }
            return (i == 1 && m91.a().d() != null && m91.a().d().optInt("hot_launch_splash_policy", 0) == 2 && TextUtils.equals(z91Var.e, "splash_video")) ? i2 | 256 : i2;
        }
        return invokeCommon.intValue;
    }

    public static void h(@Nullable List<z91> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, list) == null) {
            if (list != null && !list.isEmpty()) {
                File[] listFiles = o().listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (z91 z91Var : list) {
                    if (z91Var != null) {
                        arrayList.add(l(z91Var.g));
                        arrayList.add(l(z91Var.z));
                        arrayList.add(l(z91Var.H));
                    }
                }
                z91 z91Var2 = c;
                if (z91Var2 != null) {
                    arrayList.add(l(z91Var2.g));
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
            b01.c(o());
        }
    }

    public static void i(z91 z91Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, z91Var) == null) && URLUtil.isNetworkUrl(z91Var.g)) {
            j(z91Var.g, z91Var.j);
            if (!TextUtils.isEmpty(z91Var.z)) {
                j(z91Var.z, "");
            }
            if (TextUtils.isEmpty(z91Var.H)) {
                return;
            }
            j(z91Var.H, "");
        }
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            File q = q(str);
            if (q == null || !q.exists()) {
                File t = t(c01.c(str, false));
                if (t.exists()) {
                    t.delete();
                }
                py0.d(new a(t, str, str2, q), "download splash resource");
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
            sb.append(c01.c(str, false));
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
    public static z91 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? n(0) : (z91) invokeV.objValue;
    }

    @Nullable
    public static z91 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) {
            List<z91> w = w(true, i);
            if (w == null || w.size() <= 0) {
                return null;
            }
            for (int i2 = 0; i2 < w.size(); i2++) {
                z91 z91Var = w.get(i2);
                if (z91Var != null && z91Var.h()) {
                    return z91Var;
                }
            }
            return null;
        }
        return (z91) invokeI.objValue;
    }

    public static File o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            File file = new File(xg0.b().getFilesDir(), SpeedStatsUtils.UBC_VALUE_SPLASH);
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

    public static List<z91> r() {
        InterceptResult invokeV;
        String k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            List<z91> list = b;
            if (list != null) {
                return list;
            }
            b = new CopyOnWriteArrayList();
            File p = p();
            if (p.exists() && (k = k(p)) != null) {
                try {
                    JSONArray jSONArray = new JSONArray(k);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        b.add(z91.b(jSONArray.optJSONObject(i)));
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

    public static HashMap<String, z91> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            HashMap<String, z91> hashMap = new HashMap<>();
            File p = p();
            if (p.exists()) {
                try {
                    JSONArray jSONArray = new JSONArray(k(p));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        z91 b2 = z91.b((JSONObject) jSONArray.get(i));
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
        return (interceptable == null || (invokeI = interceptable.invokeI(65559, null, i)) == null) ? new sn0(xg0.b()).a() || i == 0 : invokeI.booleanValue;
    }

    public static List<z91> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? w(false, 0) : (List) invokeV.objValue;
    }

    public static List<z91> w(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            List<z91> r = r();
            if (r != null && r.size() != 0) {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                int i2 = 0;
                for (int i3 = 0; i3 < r.size(); i3++) {
                    z91 z91Var = r.get(i3);
                    int g = g(z91Var, z, i);
                    if (g == 0) {
                        arrayList.add(z91Var);
                    } else {
                        i2 |= g;
                        try {
                            jSONObject.put(z91Var.c, g);
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

    public static boolean x(List<z91> list, File file) {
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
                z91[] z91VarArr = (z91[]) list.toArray(new z91[list.size() - 1]);
                stringBuffer = new StringBuffer();
                stringBuffer.append(PreferencesUtil.LEFT_MOUNT);
                int length = z91VarArr.length;
                while (true) {
                    i = length - 1;
                    if (i2 >= i) {
                        break;
                    }
                    stringBuffer.append(z91VarArr[i2].k());
                    stringBuffer.append(",");
                    i2++;
                }
                stringBuffer.append(z91VarArr[i].k());
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

    public static void z(List<z91> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, list) == null) {
            py0.d(new c(list), "ScheduleDownloadSplashSourceThread");
        }
    }
}
