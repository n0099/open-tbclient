package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ho;
import com.xiaomi.push.hp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class ba {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ba a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f921a;

    /* renamed from: a  reason: collision with other field name */
    public HashSet<a> f922a;
    public SharedPreferences b;

    /* loaded from: classes8.dex */
    public static abstract class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mDescription;
        public int mId;

        public a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mId = i;
            this.mDescription = str;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof a) && this.mId == ((a) obj).mId : invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mId : invokeV.intValue;
        }

        public abstract void onCallback();

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                onCallback();
            }
        }
    }

    public ba(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f922a = new HashSet<>();
        this.f921a = context.getSharedPreferences("mipush_oc_normal", 0);
        this.b = context.getSharedPreferences("mipush_oc_custom", 0);
    }

    public static ba a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a == null) {
                synchronized (ba.class) {
                    if (a == null) {
                        a = new ba(context);
                    }
                }
            }
            return a;
        }
        return (ba) invokeL.objValue;
    }

    private String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            return "oc_" + i;
        }
        return (String) invokeI.objValue;
    }

    private String a(hp hpVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, hpVar)) == null) {
            return "oc_version_" + hpVar.a();
        }
        return (String) invokeL.objValue;
    }

    private void a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, editor, pair, str) == null) {
            Object obj = pair.second;
            if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
            } else if (!(obj instanceof String)) {
                if (obj instanceof Boolean) {
                    editor.putBoolean(str, ((Boolean) obj).booleanValue());
                }
            } else {
                String str2 = (String) obj;
                if (str.equals(a(ho.aQ.a()))) {
                    str2 = com.xiaomi.push.bm.a(str2);
                }
                editor.putString(str, str2);
            }
        }
    }

    public int a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            try {
                String a2 = a(i);
                return this.b.contains(a2) ? this.b.getInt(a2, 0) : this.f921a.contains(a2) ? this.f921a.getInt(a2, 0) : i2;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m89a(i + " oc int error " + e);
                return i2;
            }
        }
        return invokeII.intValue;
    }

    public int a(hp hpVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hpVar, i)) == null) {
            try {
                return this.f921a.getInt(a(hpVar), i);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m89a(hpVar + " version error " + e);
                return i;
            }
        }
        return invokeLI.intValue;
    }

    public long a(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            try {
                String a2 = a(i);
                return this.b.contains(a2) ? this.b.getLong(a2, 0L) : this.f921a.contains(a2) ? this.f921a.getLong(a2, 0L) : j;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m89a(i + " oc long error " + e);
                return j;
            }
        }
        return invokeCommon.longValue;
    }

    public String a(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, str)) == null) {
            try {
                String a2 = a(i);
                return this.b.contains(a2) ? this.b.getString(a2, null) : this.f921a.contains(a2) ? this.f921a.getString(a2, null) : str;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m89a(i + " oc string error " + e);
                return str;
            }
        }
        return (String) invokeIL.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                this.f922a.clear();
            }
        }
    }

    public synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            synchronized (this) {
                if (!this.f922a.contains(aVar)) {
                    this.f922a.add(aVar);
                }
            }
        }
    }

    public void a(List<Pair<Integer, Object>> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || com.xiaomi.push.ag.a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.b.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null) {
                String a2 = a(((Integer) obj).intValue());
                if (pair.second == null) {
                    edit.remove(a2);
                } else {
                    a(edit, pair, a2);
                }
            }
        }
        edit.apply();
    }

    public void a(List<Pair<hp, Integer>> list, List<Pair<Integer, Object>> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, list, list2) == null) {
            if (com.xiaomi.push.ag.a(list) || com.xiaomi.push.ag.a(list2)) {
                com.xiaomi.channel.commonutils.logger.b.m89a("not update oc, because versions or configs are empty");
                return;
            }
            SharedPreferences.Editor edit = this.f921a.edit();
            edit.clear();
            for (Pair<hp, Integer> pair : list) {
                Object obj = pair.first;
                if (obj != null && pair.second != null) {
                    edit.putInt(a((hp) obj), ((Integer) pair.second).intValue());
                }
            }
            for (Pair<Integer, Object> pair2 : list2) {
                Object obj2 = pair2.first;
                if (obj2 != null && pair2.second != null) {
                    a(edit, pair2, a(((Integer) obj2).intValue()));
                }
            }
            edit.apply();
        }
    }

    public boolean a(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            try {
                String a2 = a(i);
                return this.b.contains(a2) ? this.b.getBoolean(a2, false) : this.f921a.contains(a2) ? this.f921a.getBoolean(a2, false) : z;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m89a(i + " oc boolean error " + e);
                return z;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("OC_Callback : receive new oc data");
            HashSet hashSet = new HashSet();
            synchronized (this) {
                hashSet.addAll(this.f922a);
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.run();
                }
            }
            hashSet.clear();
        }
    }
}
