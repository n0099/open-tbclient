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
/* loaded from: classes8.dex */
public class aq {
    public static /* synthetic */ Interceptable $ic;
    public static volatile aq a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f879a;

    /* renamed from: a  reason: collision with other field name */
    public HashSet<a> f880a;

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

    public aq(Context context) {
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
        this.f880a = new HashSet<>();
        this.f879a = context.getSharedPreferences("mipush_oc", 0);
    }

    public static aq a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a == null) {
                synchronized (aq.class) {
                    if (a == null) {
                        a = new aq(context);
                    }
                }
            }
            return a;
        }
        return (aq) invokeL.objValue;
    }

    private String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            return "normal_oc_" + i;
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

    private String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) == null) {
            return "custom_oc_" + i;
        }
        return (String) invokeI.objValue;
    }

    public int a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            try {
                String b = b(i);
                if (this.f879a.contains(b)) {
                    return this.f879a.getInt(b, 0);
                }
                String a2 = a(i);
                return this.f879a.contains(a2) ? this.f879a.getInt(a2, 0) : i2;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m109a(i + " oc int error " + e);
                return i2;
            }
        }
        return invokeII.intValue;
    }

    public String a(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str)) == null) {
            try {
                String b = b(i);
                if (this.f879a.contains(b)) {
                    return this.f879a.getString(b, null);
                }
                String a2 = a(i);
                return this.f879a.contains(a2) ? this.f879a.getString(a2, null) : str;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m109a(i + " oc string error " + e);
                return str;
            }
        }
        return (String) invokeIL.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f880a.clear();
            }
        }
    }

    public synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this) {
                if (!this.f880a.contains(aVar)) {
                    this.f880a.add(aVar);
                }
            }
        }
    }

    public void a(List<Pair<Integer, Object>> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || com.xiaomi.push.ad.a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.f879a.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null && pair.second != null) {
                a(edit, pair, a(((Integer) obj).intValue()));
            }
        }
        edit.commit();
    }

    public boolean a(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            try {
                String b = b(i);
                if (this.f879a.contains(b)) {
                    return this.f879a.getBoolean(b, false);
                }
                String a2 = a(i);
                return this.f879a.contains(a2) ? this.f879a.getBoolean(a2, false) : z;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m109a(i + " oc boolean error " + e);
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
                hashSet.addAll(this.f880a);
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
        SharedPreferences.Editor edit = this.f879a.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null) {
                String b = b(((Integer) obj).intValue());
                if (pair.second == null) {
                    edit.remove(b);
                } else {
                    a(edit, pair, b);
                }
            }
        }
        edit.commit();
    }
}
