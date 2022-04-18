package com.repackage;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class vt4 {
    public static /* synthetic */ Interceptable $ic;
    public static vt4 f;
    public static ContentResolver g;
    public static HashMap<String, String> h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public SharedPreferences b;
    public String c;
    public ConcurrentHashMap<String, Object> d;
    public String e;

    /* loaded from: classes7.dex */
    public class a implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vt4 a;

        public a(vt4 vt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vt4Var;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.e();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Uri a;
        public final /* synthetic */ ContentValues b;
        public final /* synthetic */ vt4 c;

        public b(vt4 vt4Var, Uri uri, ContentValues contentValues) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt4Var, uri, contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vt4Var;
            this.a = uri;
            this.b = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.c.G(this.a, this.b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Uri a;
        public final /* synthetic */ vt4 b;

        public c(vt4 vt4Var, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt4Var, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vt4Var;
            this.a = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.b.g(this.a);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public vt4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = null;
        this.d = new ConcurrentHashMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
        h = hashMap;
        hashMap.put(ut4.a, "settings");
        h.put(ut4.b, "remote_settings");
        h.put(ut4.c, "bdservice_settings");
        h.put(ut4.d, ut4.g);
        h.put(ut4.e, ut4.h);
        h.put(ut4.f, ut4.i);
        g = TbadkCoreApplication.getInst().getContentResolver();
    }

    public static synchronized vt4 k() {
        InterceptResult invokeV;
        vt4 vt4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (vt4.class) {
                if (f == null) {
                    f = new vt4();
                }
                vt4Var = f;
            }
            return vt4Var;
        }
        return (vt4) invokeV.objValue;
    }

    public static String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return str + "_" + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeL.objValue;
    }

    public final void A(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            Uri parse = Uri.parse(i() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(j));
            F(parse, contentValues);
        }
    }

    public final void B(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            Uri parse = Uri.parse(i() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, str2);
            F(parse, contentValues);
        }
    }

    public final void C(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            Uri parse = Uri.parse(i() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(z));
            F(parse, contentValues);
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (c(str)) {
                E(str);
            } else if (this.d.containsKey(str)) {
                this.d.remove(str);
            } else {
                SharedPreferences p = p();
                this.b = p;
                EditorHelper.remove(p, str);
            }
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            f(Uri.parse(i() + str));
        }
    }

    public void F(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, uri, contentValues) == null) {
            if (oi.B()) {
                new b(this, uri, contentValues).execute(new Void[0]);
            } else {
                G(uri, contentValues);
            }
        }
    }

    public final void G(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, uri, contentValues) == null) {
            try {
                g.insert(uri, contentValues);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void H() {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.d.isEmpty()) {
            return;
        }
        SharedPreferences p = p();
        this.b = p;
        if (p == null || (edit = p.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.d.entrySet()) {
            if (entry != null) {
                String valueOf = String.valueOf(entry.getKey());
                Object value = entry.getValue();
                if (value instanceof String) {
                    edit.putString(valueOf, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(valueOf, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(valueOf, ((Long) value).longValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(valueOf, ((Boolean) value).booleanValue());
                } else if (value instanceof Float) {
                    edit.putFloat(valueOf, ((Float) value).floatValue());
                }
            }
        }
        edit.commit();
        this.d.clear();
    }

    public final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (str != null && str.length() != 0) {
                int length = ut4.j.length;
                for (int i = 0; i < length; i++) {
                    if (str.equals(ut4.j[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SharedPreferences p = p();
            this.b = p;
            SharedPreferences.Editor edit = p.edit();
            if (edit != null) {
                edit.clear();
                edit.commit();
            }
        }
    }

    public void e() {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.d.isEmpty()) {
            return;
        }
        SharedPreferences p = p();
        this.b = p;
        if (p == null || (edit = p.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.d.entrySet()) {
            if (entry != null) {
                String valueOf = String.valueOf(entry.getKey());
                Object value = entry.getValue();
                if (value instanceof String) {
                    edit.putString(valueOf, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(valueOf, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(valueOf, ((Long) value).longValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(valueOf, ((Boolean) value).booleanValue());
                } else if (value instanceof Float) {
                    edit.putFloat(valueOf, ((Float) value).floatValue());
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
        this.d.clear();
    }

    public void f(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, uri) == null) {
            if (oi.B()) {
                new c(this, uri).execute(new Void[0]);
            } else {
                g(uri);
            }
        }
    }

    public final void g(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, uri) == null) {
            try {
                g.delete(uri, null, null);
            } catch (SecurityException e) {
                BdLog.detailException(e);
            }
        }
    }

    public boolean h(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048589, this, str, z)) == null) {
            if (c(str)) {
                String s = s(str);
                if (s == null) {
                    return z;
                }
                try {
                    return Boolean.parseBoolean(s);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return z;
                }
            }
            Object obj = this.d.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            SharedPreferences p = p();
            this.b = p;
            return p.getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.e == null) {
                String packageName = AppRuntime.getAppContext().getPackageName();
                if ("com.baidu.tieba".equals(packageName)) {
                    this.e = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
                } else {
                    this.e = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
                }
            }
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public ContentResolver j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? g : (ContentResolver) invokeV.objValue;
    }

    public int l(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, str, i)) == null) {
            if (c(str)) {
                String s = s(str);
                if (s == null) {
                    return i;
                }
                try {
                    return Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return i;
                }
            }
            Object obj = this.d.get(str);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            SharedPreferences p = p();
            this.b = p;
            return p.getInt(str, i);
        }
        return invokeLI.intValue;
    }

    public long m(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048593, this, str, j)) == null) {
            if (c(str)) {
                String s = s(str);
                if (s == null) {
                    return j;
                }
                try {
                    return Long.parseLong(s);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return j;
                }
            }
            Object obj = this.d.get(str);
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            SharedPreferences p = p();
            this.b = p;
            try {
                return p.getLong(str, j);
            } catch (ClassCastException e2) {
                BdLog.e(e2);
                return j;
            }
        }
        return invokeLJ.longValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            String str = ut4.a;
            ActivityManager activityManager = (ActivityManager) TbadkCoreApplication.getInst().getSystemService("activity");
            if (activityManager != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                int myPid = Process.myPid();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                            return runningAppProcessInfo.processName;
                        }
                    }
                    return str;
                }
                return str;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public synchronized SharedPreferences p() {
        InterceptResult invokeV;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (this) {
                if (this.c == null || this.c.length() == 0) {
                    if (this.a == null || this.a.length() == 0) {
                        this.a = n();
                    }
                    if (h.containsKey(this.a)) {
                        this.c = h.get(this.a);
                    } else {
                        this.c = "settings";
                    }
                }
                sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences(this.c, 0);
            }
            return sharedPreferences;
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public String q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) {
            if (c(str)) {
                String s = s(str);
                return s != null ? s : str2;
            }
            Object obj = this.d.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            SharedPreferences p = p();
            this.b = p;
            return p.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public String r(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, uri)) == null) {
            try {
                return g.getType(uri);
            } catch (SecurityException e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public final String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            return r(Uri.parse(i() + str));
        }
        return (String) invokeL.objValue;
    }

    public boolean t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            if (c(str)) {
                return false;
            }
            return this.d.containsKey(str) || p().contains(str);
        }
        return invokeL.booleanValue;
    }

    public void u(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048600, this, str, z) == null) {
            if (c(str)) {
                C(str, z);
            } else if (oi.B()) {
                v(str, Boolean.valueOf(z));
            } else {
                SharedPreferences p = p();
                this.b = p;
                SharedPreferences.Editor edit = p.edit();
                edit.putBoolean(str, z);
                edit.commit();
            }
        }
    }

    public final void v(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048601, this, str, obj) == null) || str == null || obj == null) {
            return;
        }
        this.d.put(str, obj);
        Looper.myQueue().addIdleHandler(new a(this));
    }

    public void w(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, str, i) == null) {
            if (c(str)) {
                z(str, i);
            } else if (oi.B()) {
                v(str, Integer.valueOf(i));
            } else {
                SharedPreferences p = p();
                this.b = p;
                SharedPreferences.Editor edit = p.edit();
                edit.putInt(str, i);
                edit.commit();
            }
        }
    }

    public void x(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048603, this, str, j) == null) {
            if (c(str)) {
                A(str, j);
            } else if (oi.B()) {
                v(str, Long.valueOf(j));
            } else {
                SharedPreferences p = p();
                this.b = p;
                SharedPreferences.Editor edit = p.edit();
                edit.putLong(str, j);
                edit.commit();
            }
        }
    }

    public void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, str2) == null) {
            if (c(str)) {
                B(str, str2);
            } else if (StringUtil.NULL_STRING.equals(str2)) {
                D(str);
            } else if (oi.B()) {
                v(str, str2);
            } else {
                SharedPreferences p = p();
                this.b = p;
                SharedPreferences.Editor edit = p.edit();
                edit.putString(str, str2);
                edit.commit();
            }
        }
    }

    public final void z(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048605, this, str, i) == null) {
            Uri parse = Uri.parse(i() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(i));
            F(parse, contentValues);
        }
    }
}
