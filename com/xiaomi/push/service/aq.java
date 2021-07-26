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
import com.xiaomi.push.hk;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class aq {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile aq f40868a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f898a;

    /* renamed from: a  reason: collision with other field name */
    public HashSet<a> f899a;

    /* loaded from: classes6.dex */
    public static abstract class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mDescription;
        public int mId;

        public a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mId = i2;
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

    public aq(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f899a = new HashSet<>();
        this.f898a = context.getSharedPreferences("mipush_oc", 0);
    }

    public static aq a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f40868a == null) {
                synchronized (aq.class) {
                    if (f40868a == null) {
                        f40868a = new aq(context);
                    }
                }
            }
            return f40868a;
        }
        return (aq) invokeL.objValue;
    }

    private String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            return "normal_oc_" + i2;
        }
        return (String) invokeI.objValue;
    }

    private void a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, editor, pair, str) == null) {
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
                if (str.equals(a(hk.aQ.a()))) {
                    str2 = com.xiaomi.push.bj.a(str2);
                }
                editor.putString(str, str2);
            }
        }
    }

    private String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) {
            return "custom_oc_" + i2;
        }
        return (String) invokeI.objValue;
    }

    public int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            try {
                String b2 = b(i2);
                if (this.f898a.contains(b2)) {
                    return this.f898a.getInt(b2, 0);
                }
                String a2 = a(i2);
                return this.f898a.contains(a2) ? this.f898a.getInt(a2, 0) : i3;
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m70a(i2 + " oc int error " + e2);
                return i3;
            }
        }
        return invokeII.intValue;
    }

    public String a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str)) == null) {
            try {
                String b2 = b(i2);
                if (this.f898a.contains(b2)) {
                    return this.f898a.getString(b2, null);
                }
                String a2 = a(i2);
                return this.f898a.contains(a2) ? this.f898a.getString(a2, null) : str;
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m70a(i2 + " oc string error " + e2);
                return str;
            }
        }
        return (String) invokeIL.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f899a.clear();
            }
        }
    }

    public synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this) {
                if (!this.f899a.contains(aVar)) {
                    this.f899a.add(aVar);
                }
            }
        }
    }

    public void a(List<Pair<Integer, Object>> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || com.xiaomi.push.ad.a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.f898a.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null && pair.second != null) {
                a(edit, pair, a(((Integer) obj).intValue()));
            }
        }
        edit.commit();
    }

    public boolean a(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            try {
                String b2 = b(i2);
                if (this.f898a.contains(b2)) {
                    return this.f898a.getBoolean(b2, false);
                }
                String a2 = a(i2);
                return this.f898a.contains(a2) ? this.f898a.getBoolean(a2, false) : z;
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m70a(i2 + " oc boolean error " + e2);
                return z;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("OC_Callback : receive new oc data");
            HashSet hashSet = new HashSet();
            synchronized (this) {
                hashSet.addAll(this.f899a);
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

    public void b(List<Pair<Integer, Object>> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, list) == null) || com.xiaomi.push.ad.a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.f898a.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null) {
                String b2 = b(((Integer) obj).intValue());
                if (pair.second == null) {
                    edit.remove(b2);
                } else {
                    a(edit, pair, b2);
                }
            }
        }
        edit.commit();
    }
}
