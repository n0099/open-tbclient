package com.repackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.uo0;
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
public class ob1 {
    public static /* synthetic */ Interceptable $ic;
    public static d a;
    public static List<qb1> b;
    public static qb1 c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ String d;

        /* renamed from: com.repackage.ob1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0544a implements uo0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0544a(a aVar) {
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

            @Override // com.repackage.uo0.b
            public void a(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                    ClogBuilder.LogType logType = ClogBuilder.LogType.DOWNLOAD_FAILED;
                    a aVar = this.a;
                    hy0.b(new jy0(logType, aVar.b, aVar.d, true).b(i, str, "download"));
                }
            }

            @Override // com.repackage.uo0.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    a aVar = this.a;
                    ob1.A(aVar.a, aVar.c);
                    nb1.m().g();
                }
            }
        }

        public a(File file, String str, File file2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str, file2, str2};
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
            this.c = file2;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    uo0.a(this.a, this.b, new C0544a(this));
                } catch (Exception e) {
                    hy0.b(new jy0(ClogBuilder.LogType.DOWNLOAD_FAILED, this.b, this.d, true).b(-1, e.getMessage(), "download"));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qb1 a;

        public b(qb1 qb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qb1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ob1.C(this.a);
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
            qb1 qb1Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.a) == null || list.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(3);
            Iterator it = this.a.iterator();
            while (it.hasNext() && (qb1Var = (qb1) it.next()) != null) {
                if (ob1.w(qb1Var.w)) {
                    ob1.k(qb1Var);
                } else {
                    arrayList.add(qb1Var);
                }
            }
            if (arrayList.size() > 0) {
                if (ob1.a == null) {
                    d unused = ob1.a = new d(arrayList, null);
                    dh0.b().registerReceiver(ob1.a, ob1.a.getIntentFilter());
                    return;
                }
                ob1.a.setNeedDownloadList(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<qb1> mNeedDownloadList;

        public /* synthetic */ d(List list, a aVar) {
            this(list);
        }

        public IntentFilter getIntentFilter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE") : (IntentFilter) invokeV.objValue;
        }

        public List<qb1> getNeedDownloadList() {
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
                    for (qb1 qb1Var : this.mNeedDownloadList) {
                        if (ob1.w(qb1Var.w)) {
                            Log.d("SourceManager", "onReceive: " + qb1Var);
                            ob1.k(qb1Var);
                        } else {
                            arrayList.add(qb1Var);
                        }
                    }
                    this.mNeedDownloadList = arrayList;
                }
            }
        }

        public void setNeedDownloadList(List<qb1> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.mNeedDownloadList = list;
            }
        }

        public d(List<qb1> list) {
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

    public static boolean A(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, file, file2)) == null) {
            if (file == null || file2 == null) {
                return false;
            }
            return file.renameTo(file2);
        }
        return invokeLL.booleanValue;
    }

    public static void B(List<qb1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, list) == null) {
            fz0.d(new c(list), "ScheduleDownloadSplashSourceThread");
        }
    }

    public static void C(qb1 qb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, qb1Var) == null) {
            ArrayList arrayList = new ArrayList();
            File r = r();
            List<qb1> t = t();
            if (t == null || t.size() == 0) {
                return;
            }
            for (int i = 0; i < t.size(); i++) {
                qb1 qb1Var2 = t.get(i);
                if (TextUtils.equals(qb1Var.b, qb1Var2.b)) {
                    qb1.l(qb1Var2, qb1Var);
                    arrayList.add(qb1Var2);
                } else {
                    arrayList.add(qb1Var2);
                }
            }
            z(arrayList, r);
        }
    }

    public static void D(qb1 qb1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, qb1Var) == null) || qb1Var.v < 1) {
            return;
        }
        int i = qb1Var.x;
        if (i < Integer.MAX_VALUE) {
            qb1Var.x = i + 1;
        }
        fz0.d(new b(qb1Var), "updateSplashDataItemRate");
    }

    public static void E(List<qb1> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list) == null) || list == null || list.size() == 0) {
            return;
        }
        b = Collections.synchronizedList(list);
        z(list, r());
    }

    public static int e(qb1 qb1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, qb1Var)) == null) ? h(qb1Var, false, 0) : invokeL.intValue;
    }

    public static int f(qb1 qb1Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, qb1Var, i)) == null) ? h(qb1Var, false, i) : invokeLI.intValue;
    }

    public static int g(qb1 qb1Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65547, null, qb1Var, j)) == null) ? i(qb1Var, false, 0, j) : invokeLJ.intValue;
    }

    public static int h(qb1 qb1Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{qb1Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) ? i(qb1Var, z, i, System.currentTimeMillis()) : invokeCommon.intValue;
    }

    public static int i(qb1 qb1Var, boolean z, int i, long j) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{qb1Var, Boolean.valueOf(z), Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (qb1Var.f()) {
                i2 = !pb1.a(ib1.a()) ? 1024 : 0;
                if (sb1.a() >= pb1.d()) {
                    i2 |= 2048;
                }
                if (!pb1.c(true)) {
                    i2 |= 4096;
                }
                if (i2 != 0) {
                    return i2;
                }
            } else {
                i2 = 0;
            }
            if (qb1Var.y) {
                return i2;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j2 = j / 1000;
            long c2 = sb1.c();
            if ((o01.a(System.currentTimeMillis(), j) < 2 && j2 < qb1Var.s) || j2 > qb1Var.t) {
                i2 |= 2;
            }
            if (z) {
                int i3 = qb1Var.x;
                int i4 = qb1Var.v;
                if (i3 >= i4 || i4 == 0) {
                    i2 |= 8;
                }
            }
            if (currentTimeMillis - c2 < qb1Var.u * 60000) {
                i2 |= 16;
            }
            File s = s(qb1Var.g);
            if (s == null || !s.exists()) {
                i2 |= 4;
            }
            return (i == 1 && cb1.a().d() != null && cb1.a().d().optInt("hot_launch_splash_policy", 0) == 2 && TextUtils.equals(qb1Var.e, "splash_video")) ? i2 | 256 : i2;
        }
        return invokeCommon.intValue;
    }

    public static void j(@Nullable List<qb1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            if (list != null && !list.isEmpty()) {
                File[] listFiles = q().listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList(list.size());
                for (qb1 qb1Var : list) {
                    if (qb1Var != null) {
                        arrayList.add(n(qb1Var.g));
                        arrayList.add(n(qb1Var.z));
                        arrayList.add(n(qb1Var.H));
                    }
                }
                qb1 qb1Var2 = c;
                if (qb1Var2 != null) {
                    arrayList.add(n(qb1Var2.g));
                    arrayList.add(n(c.z));
                    arrayList.add(n(c.H));
                }
                for (File file : listFiles) {
                    if (!arrayList.contains(file.getName())) {
                        file.delete();
                    }
                }
                return;
            }
            r01.c(q());
        }
    }

    public static void k(qb1 qb1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65551, null, qb1Var) == null) && URLUtil.isNetworkUrl(qb1Var.g)) {
            l(qb1Var.g, qb1Var.d);
            if (!TextUtils.isEmpty(qb1Var.z)) {
                l(qb1Var.z, qb1Var.d);
            }
            if (TextUtils.isEmpty(qb1Var.H)) {
                return;
            }
            l(qb1Var.H, qb1Var.d);
        }
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, str, str2) == null) {
            File s = s(str);
            if (s == null || !s.exists()) {
                File v = v(s01.b(str, false));
                if (v.exists()) {
                    v.delete();
                }
                fz0.d(new a(v, str, s, str2), "download splash resource");
            }
        }
    }

    public static String m(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, file)) == null) {
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

    public static String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(s01.b(str, false));
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
    public static qb1 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? p(0) : (qb1) invokeV.objValue;
    }

    @Nullable
    public static qb1 p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i)) == null) {
            List<qb1> y = y(true, i);
            if (y == null || y.size() <= 0) {
                return null;
            }
            for (int i2 = 0; i2 < y.size(); i2++) {
                qb1 qb1Var = y.get(i2);
                if (qb1Var != null && qb1Var.h()) {
                    return qb1Var;
                }
            }
            return null;
        }
        return (qb1) invokeI.objValue;
    }

    public static File q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            File file = new File(dh0.b().getFilesDir(), SpeedStatsUtils.UBC_VALUE_SPLASH);
            file.mkdirs();
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static File r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? new File(q(), "splash.dat") : (File) invokeV.objValue;
    }

    public static File s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            String n = n(str);
            if (TextUtils.isEmpty(n)) {
                return null;
            }
            return new File(q(), n);
        }
        return (File) invokeL.objValue;
    }

    public static List<qb1> t() {
        InterceptResult invokeV;
        String m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            List<qb1> list = b;
            if (list != null) {
                return list;
            }
            b = new CopyOnWriteArrayList();
            File r = r();
            if (r.exists() && (m = m(r)) != null) {
                try {
                    JSONArray jSONArray = new JSONArray(m);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        b.add(qb1.b(jSONArray.optJSONObject(i)));
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

    public static HashMap<String, qb1> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            HashMap<String, qb1> hashMap = new HashMap<>();
            File r = r();
            if (r.exists()) {
                try {
                    JSONArray jSONArray = new JSONArray(m(r));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        qb1 b2 = qb1.b((JSONObject) jSONArray.get(i));
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

    public static File v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".tmp");
            return new File(q(), stringBuffer.toString());
        }
        return (File) invokeL.objValue;
    }

    public static boolean w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65563, null, i)) == null) ? new ho0(dh0.b()).a() || i == 0 : invokeI.booleanValue;
    }

    public static List<qb1> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? y(false, 0) : (List) invokeV.objValue;
    }

    public static List<qb1> y(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            List<qb1> t = t();
            if (t != null && t.size() != 0) {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                int i2 = 0;
                for (int i3 = 0; i3 < t.size(); i3++) {
                    qb1 qb1Var = t.get(i3);
                    int h = h(qb1Var, z, i);
                    if (h == 0) {
                        arrayList.add(qb1Var);
                    } else {
                        i2 |= h;
                        try {
                            jSONObject.put(qb1Var.c, h);
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

    public static boolean z(List<qb1> list, File file) {
        InterceptResult invokeLL;
        StringBuffer stringBuffer;
        int i;
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, list, file)) == null) {
            int i2 = 0;
            if (list.size() <= 0) {
                return false;
            }
            FileWriter fileWriter2 = null;
            try {
                qb1[] qb1VarArr = (qb1[]) list.toArray(new qb1[list.size() - 1]);
                stringBuffer = new StringBuffer();
                stringBuffer.append(PreferencesUtil.LEFT_MOUNT);
                int length = qb1VarArr.length;
                while (true) {
                    i = length - 1;
                    if (i2 >= i) {
                        break;
                    }
                    stringBuffer.append(qb1VarArr[i2].k());
                    stringBuffer.append(",");
                    i2++;
                }
                stringBuffer.append(qb1VarArr[i].k());
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
}
