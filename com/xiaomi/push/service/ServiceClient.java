package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.eq;
import com.xiaomi.push.fz;
import com.xiaomi.push.ga;
import com.xiaomi.push.gb;
import com.xiaomi.push.ge;
import com.xiaomi.push.gn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
/* loaded from: classes4.dex */
public class ServiceClient {
    public static /* synthetic */ Interceptable $ic;
    public static long a;

    /* renamed from: a  reason: collision with other field name */
    public static ServiceClient f834a;

    /* renamed from: a  reason: collision with other field name */
    public static String f835a;

    /* renamed from: b  reason: collision with root package name */
    public static String f61617b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f836a;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f837a;

    /* renamed from: a  reason: collision with other field name */
    public List<Message> f838a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f839a;

    /* renamed from: b  reason: collision with other field name */
    public Messenger f840b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f841b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(178596336, "Lcom/xiaomi/push/service/ServiceClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(178596336, "Lcom/xiaomi/push/service/ServiceClient;");
                return;
            }
        }
        f61617b = gn.a(5) + "-";
        a = 0L;
    }

    public ServiceClient(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f837a = null;
        this.f839a = false;
        this.f838a = new ArrayList();
        this.f841b = false;
        this.f836a = context.getApplicationContext();
        if (m608a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.f839a = true;
        }
    }

    private Intent a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (!isMiuiPushServiceEnabled()) {
                Intent intent = new Intent(this.f836a, XMPushService.class);
                intent.putExtra(az.A, this.f836a.getPackageName());
                b();
                return intent;
            }
            Intent intent2 = new Intent();
            intent2.setPackage("com.xiaomi.xmsf");
            intent2.setClassName("com.xiaomi.xmsf", m604a());
            intent2.putExtra(az.A, this.f836a.getPackageName());
            m606a();
            return intent2;
        }
        return (Intent) invokeV.objValue;
    }

    private Message a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, intent)) == null) {
            Message obtain = Message.obtain();
            obtain.what = 17;
            obtain.obj = intent;
            return obtain;
        }
        return (Message) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m604a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            try {
                return this.f836a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
            } catch (Exception unused) {
                return "com.xiaomi.xmsf.push.service.XMPushService";
            }
        }
        return (String) invokeV.objValue;
    }

    private String a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, map)) == null) {
            StringBuilder sb = new StringBuilder();
            int i2 = 1;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":");
                sb.append(entry.getValue());
                if (i2 < map.size()) {
                    sb.append(",");
                }
                i2++;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private Map<String, String> a(List<NameValuePair> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, list)) == null) {
            HashMap hashMap = new HashMap();
            if (list != null && list.size() > 0) {
                for (NameValuePair nameValuePair : list) {
                    if (nameValuePair != null) {
                        hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m606a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f836a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f836a, XMPushService.class), 2, 1);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private synchronized void m607a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, intent) == null) {
            synchronized (this) {
                if (this.f841b) {
                    Message a2 = a(intent);
                    if (this.f838a.size() >= 50) {
                        this.f838a.remove(0);
                    }
                    this.f838a.add(a2);
                    return;
                }
                if (this.f840b == null) {
                    this.f836a.bindService(intent, new bh(this), 1);
                    this.f841b = true;
                    this.f838a.clear();
                    this.f838a.add(a(intent));
                } else {
                    try {
                        this.f840b.send(a(intent));
                    } catch (RemoteException unused) {
                        this.f840b = null;
                        this.f841b = false;
                    }
                }
            }
        }
    }

    private void a(Intent intent, String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{intent, str, str2, str3, str4, str5, Boolean.valueOf(z), map, map2}) == null) {
            intent.putExtra(az.p, str);
            intent.putExtra(az.s, str2);
            intent.putExtra(az.u, str3);
            intent.putExtra(az.w, str5);
            intent.putExtra(az.v, str4);
            intent.putExtra(az.x, z);
            intent.putExtra(az.D, f835a);
            intent.putExtra(az.H, this.f837a);
            if (map != null && map.size() > 0) {
                String a2 = a(map);
                if (!TextUtils.isEmpty(a2)) {
                    intent.putExtra(az.y, a2);
                }
            }
            if (map2 == null || map2.size() <= 0) {
                return;
            }
            String a3 = a(map2);
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            intent.putExtra(az.z, a3);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m608a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            if (com.xiaomi.push.ab.f61118e) {
                return false;
            }
            try {
                PackageInfo packageInfo = this.f836a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                if (packageInfo == null) {
                    return false;
                }
                return packageInfo.versionCode >= 104;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.f836a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f836a, XMPushService.class), 1, 1);
        }
    }

    public static ServiceClient getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            if (f834a == null) {
                f834a = new ServiceClient(context);
            }
            return f834a;
        }
        return (ServiceClient) invokeL.objValue;
    }

    public static String getSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? f835a : (String) invokeV.objValue;
    }

    public static void setSession(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, str) == null) {
            f835a = str;
        }
    }

    public boolean batchSendMessage(gb[] gbVarArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, gbVarArr, z)) == null) {
            if (com.xiaomi.push.bg.b(this.f836a)) {
                Intent a2 = a();
                int length = gbVarArr.length;
                Bundle[] bundleArr = new Bundle[length];
                for (int i2 = 0; i2 < gbVarArr.length; i2++) {
                    String a3 = eq.a();
                    if (!TextUtils.isEmpty(a3)) {
                        fz fzVar = new fz("pf", null, null, null);
                        fz fzVar2 = new fz("sent", null, null, null);
                        fzVar2.m398a(a3);
                        fzVar.a(fzVar2);
                        gbVarArr[i2].a(fzVar);
                    }
                    com.xiaomi.channel.commonutils.logger.b.c("SEND:" + gbVarArr[i2].a());
                    bundleArr[i2] = gbVarArr[i2].a();
                }
                if (length > 0) {
                    a2.setAction(az.f61648g);
                    a2.putExtra(az.D, f835a);
                    a2.putExtra("ext_packets", bundleArr);
                    a2.putExtra("ext_encrypt", z);
                    return startServiceSafely(a2);
                }
                return false;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void checkAlive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Intent a2 = a();
            a2.setAction("com.xiaomi.push.check_alive");
            startServiceSafely(a2);
        }
    }

    public boolean closeChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Intent a2 = a();
            a2.setAction(az.f61650i);
            return startServiceSafely(a2);
        }
        return invokeV.booleanValue;
    }

    public boolean closeChannel(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Intent a2 = a();
            a2.setAction(az.f61650i);
            a2.putExtra(az.s, str);
            return startServiceSafely(a2);
        }
        return invokeL.booleanValue;
    }

    public boolean closeChannel(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            Intent a2 = a();
            a2.setAction(az.f61650i);
            a2.putExtra(az.s, str);
            a2.putExtra(az.p, str2);
            return startServiceSafely(a2);
        }
        return invokeLL.booleanValue;
    }

    @Deprecated
    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z), list, list2})) == null) ? forceReconnection(str, str2, str3, str4, str5, z, a(list), a(list2)) : invokeCommon.booleanValue;
    }

    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z), map, map2})) == null) {
            Intent a2 = a();
            a2.setAction(az.f61651j);
            a(a2, str, str2, str3, str4, str5, z, map, map2);
            return startServiceSafely(a2);
        }
        return invokeCommon.booleanValue;
    }

    public boolean isMiuiPushServiceEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f839a : invokeV.booleanValue;
    }

    public int openChannel(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, String> map2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, str3, str4, str5, map, map2, Boolean.valueOf(z)})) == null) {
            Intent a2 = a();
            a2.setAction(az.f61645d);
            a(a2, str, str2, str3, str4, str5, z, map, map2);
            startServiceSafely(a2);
            return 0;
        }
        return invokeCommon.intValue;
    }

    @Deprecated
    public int openChannel(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z), list, list2})) == null) ? openChannel(str, str2, str3, str4, str5, a(list), a(list2), z) : invokeCommon.intValue;
    }

    @Deprecated
    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z), list, list2}) == null) {
            resetConnection(str, str2, str3, str4, str5, z, a(list), a(list2));
        }
    }

    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z), map, map2}) == null) {
            Intent a2 = a();
            a2.setAction(az.k);
            a(a2, str, str2, str3, str4, str5, z, map, map2);
            startServiceSafely(a2);
        }
    }

    public boolean sendIQ(ga gaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, gaVar)) == null) {
            if (com.xiaomi.push.bg.b(this.f836a)) {
                Intent a2 = a();
                Bundle a3 = gaVar.a();
                if (a3 != null) {
                    com.xiaomi.channel.commonutils.logger.b.c("SEND:" + gaVar.a());
                    a2.setAction(az.f61647f);
                    a2.putExtra(az.D, f835a);
                    a2.putExtra("ext_packet", a3);
                    return startServiceSafely(a2);
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean sendMessage(gb gbVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048589, this, gbVar, z)) == null) {
            if (com.xiaomi.push.bg.b(this.f836a)) {
                Intent a2 = a();
                String a3 = eq.a();
                if (!TextUtils.isEmpty(a3)) {
                    fz fzVar = new fz("pf", null, null, null);
                    fz fzVar2 = new fz("sent", null, null, null);
                    fzVar2.m398a(a3);
                    fzVar.a(fzVar2);
                    gbVar.a(fzVar);
                }
                Bundle a4 = gbVar.a();
                if (a4 != null) {
                    com.xiaomi.channel.commonutils.logger.b.c("SEND:" + gbVar.a());
                    a2.setAction(az.f61646e);
                    a2.putExtra(az.D, f835a);
                    a2.putExtra("ext_packet", a4);
                    a2.putExtra("ext_encrypt", z);
                    return startServiceSafely(a2);
                }
                return false;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public boolean sendMessage(byte[] bArr, String str, String str2) {
        InterceptResult invokeLLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, bArr, str, str2)) == null) {
            if (!com.xiaomi.push.bg.b(this.f836a) || bArr == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                com.xiaomi.channel.commonutils.logger.b.m133a("Failed to send message: message|userId|chid may be empty, or the network is unavailable.");
                return false;
            }
            Intent a2 = a();
            if (bArr != null) {
                a2.setAction(az.f61646e);
                a2.putExtra(az.D, f835a);
                a2.putExtra("ext_raw_packet", bArr);
                int indexOf = str.indexOf("@");
                String str4 = null;
                String substring = indexOf != -1 ? str.substring(0, indexOf) : null;
                int lastIndexOf = str.lastIndexOf("/");
                if (lastIndexOf != -1) {
                    str4 = str.substring(indexOf + 1, lastIndexOf);
                    str3 = str.substring(lastIndexOf + 1);
                } else {
                    str3 = null;
                }
                a2.putExtra(az.p, substring);
                a2.putExtra(az.q, str4);
                a2.putExtra(az.r, str3);
                StringBuilder sb = new StringBuilder();
                sb.append(f61617b);
                long j2 = a;
                a = 1 + j2;
                sb.append(j2);
                String sb2 = sb.toString();
                a2.putExtra("ext_pkt_id", sb2);
                a2.putExtra("ext_chid", str2);
                com.xiaomi.channel.commonutils.logger.b.e("SEND: chid=" + str2 + ", packetId=" + sb2);
                return startServiceSafely(a2);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public boolean sendPresence(ge geVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, geVar)) == null) {
            if (com.xiaomi.push.bg.b(this.f836a)) {
                Intent a2 = a();
                Bundle a3 = geVar.a();
                if (a3 != null) {
                    com.xiaomi.channel.commonutils.logger.b.c("SEND:" + geVar.a());
                    a2.setAction(az.f61649h);
                    a2.putExtra(az.D, f835a);
                    a2.putExtra("ext_packet", a3);
                    return startServiceSafely(a2);
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setMessenger(Messenger messenger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, messenger) == null) {
            this.f837a = messenger;
        }
    }

    public boolean startServiceSafely(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, intent)) == null) {
            try {
                if (com.xiaomi.push.l.m598a() || Build.VERSION.SDK_INT < 26) {
                    this.f836a.startService(intent);
                    return true;
                }
                m607a(intent);
                return true;
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public void updateChannelInfo(String str, List<NameValuePair> list, List<NameValuePair> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, str, list, list2) == null) {
            updateChannelInfo(str, a(list), a(list2));
        }
    }

    public void updateChannelInfo(String str, Map<String, String> map, Map<String, String> map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, str, map, map2) == null) {
            Intent a2 = a();
            a2.setAction(az.l);
            if (map != null) {
                String a3 = a(map);
                if (!TextUtils.isEmpty(a3)) {
                    a2.putExtra(az.y, a3);
                }
            }
            if (map2 != null) {
                String a4 = a(map2);
                if (!TextUtils.isEmpty(a4)) {
                    a2.putExtra(az.z, a4);
                }
            }
            a2.putExtra(az.s, str);
            startServiceSafely(a2);
        }
    }
}
