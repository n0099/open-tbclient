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
import com.xiaomi.push.et;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.gp;
import com.xiaomi.push.gy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
/* loaded from: classes8.dex */
public class ServiceClient {
    public static /* synthetic */ Interceptable $ic;
    public static long a;

    /* renamed from: a  reason: collision with other field name */
    public static ServiceClient f854a;

    /* renamed from: a  reason: collision with other field name */
    public static String f855a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f856a;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f857a;

    /* renamed from: a  reason: collision with other field name */
    public List<Message> f858a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f859a;

    /* renamed from: b  reason: collision with other field name */
    public Messenger f860b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f861b;

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
        b = gy.a(5) + "-";
        a = 0L;
    }

    public ServiceClient(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f857a = null;
        this.f859a = false;
        this.f858a = new ArrayList();
        this.f861b = false;
        this.f856a = context.getApplicationContext();
        if (m648a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.f859a = true;
        }
    }

    private Intent a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (!isMiuiPushServiceEnabled()) {
                Intent intent = new Intent(this.f856a, XMPushService.class);
                intent.putExtra(bk.B, this.f856a.getPackageName());
                b();
                return intent;
            }
            Intent intent2 = new Intent();
            intent2.setPackage("com.xiaomi.xmsf");
            intent2.setClassName("com.xiaomi.xmsf", m644a());
            intent2.putExtra(bk.B, this.f856a.getPackageName());
            m646a();
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
    private String m644a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            try {
                return this.f856a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
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
            int i = 1;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":");
                sb.append(entry.getValue());
                if (i < map.size()) {
                    sb.append(",");
                }
                i++;
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
    private void m646a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f856a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f856a, XMPushService.class), 2, 1);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private synchronized void m647a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, intent) == null) {
            synchronized (this) {
                if (this.f861b) {
                    Message a2 = a(intent);
                    if (this.f858a.size() >= 50) {
                        this.f858a.remove(0);
                    }
                    this.f858a.add(a2);
                    return;
                }
                if (this.f860b == null) {
                    this.f856a.bindService(intent, new bu(this), 1);
                    this.f861b = true;
                    this.f858a.clear();
                    this.f858a.add(a(intent));
                } else {
                    try {
                        this.f860b.send(a(intent));
                    } catch (RemoteException unused) {
                        this.f860b = null;
                        this.f861b = false;
                    }
                }
            }
        }
    }

    private void a(Intent intent, String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{intent, str, str2, str3, str4, str5, Boolean.valueOf(z), map, map2}) == null) {
            intent.putExtra(bk.q, str);
            intent.putExtra(bk.t, str2);
            intent.putExtra(bk.v, str3);
            intent.putExtra(bk.x, str5);
            intent.putExtra(bk.w, str4);
            intent.putExtra(bk.y, z);
            intent.putExtra(bk.F, f855a);
            intent.putExtra(bk.J, this.f857a);
            if (map != null && map.size() > 0) {
                String a2 = a(map);
                if (!TextUtils.isEmpty(a2)) {
                    intent.putExtra(bk.z, a2);
                }
            }
            if (map2 == null || map2.size() <= 0) {
                return;
            }
            String a3 = a(map2);
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            intent.putExtra(bk.A, a3);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m648a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            if (com.xiaomi.push.ae.e) {
                return false;
            }
            try {
                PackageInfo packageInfo = this.f856a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
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
            this.f856a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f856a, XMPushService.class), 1, 1);
        }
    }

    public static ServiceClient getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            if (f854a == null) {
                f854a = new ServiceClient(context);
            }
            return f854a;
        }
        return (ServiceClient) invokeL.objValue;
    }

    public static String getSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? f855a : (String) invokeV.objValue;
    }

    public static void setSession(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, str) == null) {
            f855a = str;
        }
    }

    public boolean batchSendMessage(gm[] gmVarArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, gmVarArr, z)) == null) {
            if (com.xiaomi.push.bj.b(this.f856a)) {
                Intent a2 = a();
                int length = gmVarArr.length;
                Bundle[] bundleArr = new Bundle[length];
                for (int i = 0; i < gmVarArr.length; i++) {
                    String a3 = et.a();
                    if (!TextUtils.isEmpty(a3)) {
                        gk gkVar = new gk("pf", null, null, null);
                        gk gkVar2 = new gk("sent", null, null, null);
                        gkVar2.m440a(a3);
                        gkVar.a(gkVar2);
                        gmVarArr[i].a(gkVar);
                    }
                    com.xiaomi.channel.commonutils.logger.b.c("SEND:" + gmVarArr[i].mo442a());
                    bundleArr[i] = gmVarArr[i].a();
                }
                if (length > 0) {
                    a2.setAction(bk.g);
                    a2.putExtra(bk.F, f855a);
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
            a2.setAction(bk.i);
            return startServiceSafely(a2);
        }
        return invokeV.booleanValue;
    }

    public boolean closeChannel(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Intent a2 = a();
            a2.setAction(bk.i);
            a2.putExtra(bk.t, str);
            return startServiceSafely(a2);
        }
        return invokeL.booleanValue;
    }

    public boolean closeChannel(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            Intent a2 = a();
            a2.setAction(bk.i);
            a2.putExtra(bk.t, str);
            a2.putExtra(bk.q, str2);
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
            a2.setAction(bk.j);
            a(a2, str, str2, str3, str4, str5, z, map, map2);
            return startServiceSafely(a2);
        }
        return invokeCommon.booleanValue;
    }

    public boolean isMiuiPushServiceEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f859a : invokeV.booleanValue;
    }

    public int openChannel(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, String> map2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, str3, str4, str5, map, map2, Boolean.valueOf(z)})) == null) {
            Intent a2 = a();
            a2.setAction(bk.d);
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
            a2.setAction(bk.k);
            a(a2, str, str2, str3, str4, str5, z, map, map2);
            startServiceSafely(a2);
        }
    }

    public boolean sendIQ(gl glVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, glVar)) == null) {
            if (com.xiaomi.push.bj.b(this.f856a)) {
                Intent a2 = a();
                Bundle a3 = glVar.a();
                if (a3 != null) {
                    com.xiaomi.channel.commonutils.logger.b.c("SEND:" + glVar.mo442a());
                    a2.setAction(bk.f);
                    a2.putExtra(bk.F, f855a);
                    a2.putExtra("ext_packet", a3);
                    return startServiceSafely(a2);
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean sendMessage(gm gmVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048589, this, gmVar, z)) == null) {
            if (com.xiaomi.push.bj.b(this.f856a)) {
                Intent a2 = a();
                String a3 = et.a();
                if (!TextUtils.isEmpty(a3)) {
                    gk gkVar = new gk("pf", null, null, null);
                    gk gkVar2 = new gk("sent", null, null, null);
                    gkVar2.m440a(a3);
                    gkVar.a(gkVar2);
                    gmVar.a(gkVar);
                }
                Bundle a4 = gmVar.a();
                if (a4 != null) {
                    com.xiaomi.channel.commonutils.logger.b.c("SEND:" + gmVar.mo442a());
                    a2.setAction(bk.e);
                    a2.putExtra(bk.F, f855a);
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
            if (!com.xiaomi.push.bj.b(this.f856a) || bArr == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                com.xiaomi.channel.commonutils.logger.b.m103a("Failed to send message: message|userId|chid may be empty, or the network is unavailable.");
                return false;
            }
            Intent a2 = a();
            if (bArr != null) {
                a2.setAction(bk.e);
                a2.putExtra(bk.F, f855a);
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
                a2.putExtra(bk.q, substring);
                a2.putExtra(bk.r, str4);
                a2.putExtra(bk.s, str3);
                StringBuilder sb = new StringBuilder();
                sb.append(b);
                long j = a;
                a = 1 + j;
                sb.append(j);
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

    public boolean sendPresence(gp gpVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, gpVar)) == null) {
            if (com.xiaomi.push.bj.b(this.f856a)) {
                Intent a2 = a();
                Bundle a3 = gpVar.a();
                if (a3 != null) {
                    com.xiaomi.channel.commonutils.logger.b.c("SEND:" + gpVar.mo442a());
                    a2.setAction(bk.h);
                    a2.putExtra(bk.F, f855a);
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
            this.f857a = messenger;
        }
    }

    public boolean startServiceSafely(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, intent)) == null) {
            try {
                if (com.xiaomi.push.m.m634a() || Build.VERSION.SDK_INT < 26) {
                    this.f856a.startService(intent);
                    return true;
                }
                m647a(intent);
                return true;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
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
            a2.setAction(bk.l);
            if (map != null) {
                String a3 = a(map);
                if (!TextUtils.isEmpty(a3)) {
                    a2.putExtra(bk.z, a3);
                }
            }
            if (map2 != null) {
                String a4 = a(map2);
                if (!TextUtils.isEmpty(a4)) {
                    a2.putExtra(bk.A, a4);
                }
            }
            a2.putExtra(bk.t, str);
            startServiceSafely(a2);
        }
    }
}
