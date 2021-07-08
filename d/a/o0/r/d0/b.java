package d.a.o0.r.d0;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static b f52303f;

    /* renamed from: g  reason: collision with root package name */
    public static ContentResolver f52304g;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<String, String> f52305h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f52306a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f52307b;

    /* renamed from: c  reason: collision with root package name */
    public String f52308c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f52309d;

    /* renamed from: e  reason: collision with root package name */
    public String f52310e;

    /* loaded from: classes7.dex */
    public class a implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f52311a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52311a = bVar;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f52311a.d();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: d.a.o0.r.d0.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1200b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f52312a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContentValues f52313b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f52314c;

        public C1200b(b bVar, Uri uri, ContentValues contentValues) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, uri, contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52314c = bVar;
            this.f52312a = uri;
            this.f52313b = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.f52314c.F(this.f52312a, this.f52313b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f52315a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f52316b;

        public c(b bVar, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52316b = bVar;
            this.f52315a = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.f52316b.f(this.f52315a);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52310e = null;
        this.f52309d = new ConcurrentHashMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
        f52305h = hashMap;
        hashMap.put(d.a.o0.r.d0.a.f52294a, "settings");
        f52305h.put(d.a.o0.r.d0.a.f52295b, "remote_settings");
        f52305h.put(d.a.o0.r.d0.a.f52296c, "bdservice_settings");
        f52305h.put(d.a.o0.r.d0.a.f52297d, d.a.o0.r.d0.a.f52300g);
        f52305h.put(d.a.o0.r.d0.a.f52298e, d.a.o0.r.d0.a.f52301h);
        f52305h.put(d.a.o0.r.d0.a.f52299f, d.a.o0.r.d0.a.f52302i);
        f52304g = TbadkCoreApplication.getInst().getContentResolver();
    }

    public static synchronized b j() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (b.class) {
                if (f52303f == null) {
                    f52303f = new b();
                }
                bVar = f52303f;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public static String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return str + "_" + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeL.objValue;
    }

    public final void A(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            Uri parse = Uri.parse(h() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, str2);
            E(parse, contentValues);
        }
    }

    public final void B(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            Uri parse = Uri.parse(h() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(z));
            E(parse, contentValues);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (c(str)) {
                D(str);
            } else if (this.f52309d.containsKey(str)) {
                this.f52309d.remove(str);
            } else {
                SharedPreferences o = o();
                this.f52307b = o;
                EditorHelper.remove(o, str);
            }
        }
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            e(Uri.parse(h() + str));
        }
    }

    public void E(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, uri, contentValues) == null) {
            if (l.C()) {
                new C1200b(this, uri, contentValues).execute(new Void[0]);
            } else {
                F(uri, contentValues);
            }
        }
    }

    public final void F(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, uri, contentValues) == null) {
            try {
                f52304g.insert(uri, contentValues);
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (str != null && str.length() != 0) {
                int length = d.a.o0.r.d0.a.j.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (str.equals(d.a.o0.r.d0.a.j[i2])) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f52309d.isEmpty()) {
            return;
        }
        SharedPreferences o = o();
        this.f52307b = o;
        if (o == null || (edit = o.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.f52309d.entrySet()) {
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
        this.f52309d.clear();
    }

    public void e(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uri) == null) {
            if (l.C()) {
                new c(this, uri).execute(new Void[0]);
            } else {
                f(uri);
            }
        }
    }

    public final void f(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, uri) == null) {
            try {
                f52304g.delete(uri, null, null);
            } catch (SecurityException e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public boolean g(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, str, z)) == null) {
            if (c(str)) {
                String r = r(str);
                if (r == null) {
                    return z;
                }
                try {
                    return Boolean.parseBoolean(r);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return z;
                }
            }
            Object obj = this.f52309d.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            SharedPreferences o = o();
            this.f52307b = o;
            return o.getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f52310e == null) {
                String packageName = TbadkCoreApplication.getInst().getContext().getPackageName();
                if ("com.baidu.tieba".equals(packageName)) {
                    this.f52310e = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
                } else {
                    this.f52310e = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
                }
            }
            return this.f52310e;
        }
        return (String) invokeV.objValue;
    }

    public ContentResolver i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? f52304g : (ContentResolver) invokeV.objValue;
    }

    public int k(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, str, i2)) == null) {
            if (c(str)) {
                String r = r(str);
                if (r == null) {
                    return i2;
                }
                try {
                    return Integer.parseInt(r);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return i2;
                }
            }
            Object obj = this.f52309d.get(str);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            SharedPreferences o = o();
            this.f52307b = o;
            return o.getInt(str, i2);
        }
        return invokeLI.intValue;
    }

    public long l(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048590, this, str, j)) == null) {
            if (c(str)) {
                String r = r(str);
                if (r == null) {
                    return j;
                }
                try {
                    return Long.parseLong(r);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return j;
                }
            }
            Object obj = this.f52309d.get(str);
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            SharedPreferences o = o();
            this.f52307b = o;
            try {
                return o.getLong(str, j);
            } catch (ClassCastException e3) {
                BdLog.e(e3);
                return j;
            }
        }
        return invokeLJ.longValue;
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            String str = d.a.o0.r.d0.a.f52294a;
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

    public synchronized SharedPreferences o() {
        InterceptResult invokeV;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            synchronized (this) {
                if (this.f52308c == null || this.f52308c.length() == 0) {
                    if (this.f52306a == null || this.f52306a.length() == 0) {
                        this.f52306a = m();
                    }
                    if (f52305h.containsKey(this.f52306a)) {
                        this.f52308c = f52305h.get(this.f52306a);
                    } else {
                        this.f52308c = "settings";
                    }
                }
                sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences(this.f52308c, 0);
            }
            return sharedPreferences;
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public String p(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (c(str)) {
                String r = r(str);
                return r != null ? r : str2;
            }
            Object obj = this.f52309d.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            SharedPreferences o = o();
            this.f52307b = o;
            return o.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public String q(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, uri)) == null) {
            try {
                return f52304g.getType(uri);
            } catch (SecurityException e2) {
                BdLog.detailException(e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public final String r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            return q(Uri.parse(h() + str));
        }
        return (String) invokeL.objValue;
    }

    public boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (c(str)) {
                return false;
            }
            return this.f52309d.containsKey(str) || o().contains(str);
        }
        return invokeL.booleanValue;
    }

    public void t(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, str, z) == null) {
            if (c(str)) {
                B(str, z);
            } else if (l.C()) {
                u(str, Boolean.valueOf(z));
            } else {
                SharedPreferences o = o();
                this.f52307b = o;
                SharedPreferences.Editor edit = o.edit();
                edit.putBoolean(str, z);
                edit.commit();
            }
        }
    }

    public final void u(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, str, obj) == null) || str == null || obj == null) {
            return;
        }
        this.f52309d.put(str, obj);
        Looper.myQueue().addIdleHandler(new a(this));
    }

    public void v(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, str, i2) == null) {
            if (c(str)) {
                y(str, i2);
            } else if (l.C()) {
                u(str, Integer.valueOf(i2));
            } else {
                SharedPreferences o = o();
                this.f52307b = o;
                SharedPreferences.Editor edit = o.edit();
                edit.putInt(str, i2);
                edit.commit();
            }
        }
    }

    public void w(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, str, j) == null) {
            if (c(str)) {
                z(str, j);
            } else if (l.C()) {
                u(str, Long.valueOf(j));
            } else {
                SharedPreferences o = o();
                this.f52307b = o;
                SharedPreferences.Editor edit = o.edit();
                edit.putLong(str, j);
                edit.commit();
            }
        }
    }

    public void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, str2) == null) {
            if (c(str)) {
                A(str, str2);
            } else if (StringUtil.NULL_STRING.equals(str2)) {
                C(str);
            } else if (l.C()) {
                u(str, str2);
            } else {
                SharedPreferences o = o();
                this.f52307b = o;
                SharedPreferences.Editor edit = o.edit();
                edit.putString(str, str2);
                edit.commit();
            }
        }
    }

    public final void y(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, str, i2) == null) {
            Uri parse = Uri.parse(h() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(i2));
            E(parse, contentValues);
        }
    }

    public final void z(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048603, this, str, j) == null) {
            Uri parse = Uri.parse(h() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(j));
            E(parse, contentValues);
        }
    }
}
