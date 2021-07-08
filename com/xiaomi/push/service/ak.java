package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public class ak {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f40585a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071162364, "Lcom/xiaomi/push/service/ak;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071162364, "Lcom/xiaomi/push/service/ak;");
                return;
            }
        }
        f40585a = Log.isLoggable("NCHelper", 3);
    }

    @TargetApi(26)
    public static NotificationChannel a(String str, NotificationChannel notificationChannel) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, notificationChannel)) == null) {
            NotificationChannel notificationChannel2 = new NotificationChannel(str, notificationChannel.getName(), notificationChannel.getImportance());
            notificationChannel2.setDescription(notificationChannel.getDescription());
            notificationChannel2.enableVibration(notificationChannel.shouldVibrate());
            notificationChannel2.enableLights(notificationChannel.shouldShowLights());
            notificationChannel2.setSound(notificationChannel.getSound(), notificationChannel.getAudioAttributes());
            notificationChannel2.setLockscreenVisibility(notificationChannel.getLockscreenVisibility());
            return notificationChannel2;
        }
        return (NotificationChannel) invokeLL.objValue;
    }

    public static SharedPreferences a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? context.getSharedPreferences("mipush_channel_copy_sp", 0) : (SharedPreferences) invokeL.objValue;
    }

    @TargetApi(26)
    public static String a(ao aoVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aoVar)) == null) {
            String b2 = aoVar.b();
            try {
                NotificationChannel notificationChannel = new NotificationChannel(b2, com.xiaomi.push.g.m341b(aoVar.m592a(), aoVar.m593a()), 3);
                if (f40585a) {
                    a("create default channel:" + notificationChannel);
                }
                a(aoVar, notificationChannel);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m71a("NCHelper", "create default channel error " + e2);
            }
            return b2;
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(26)
    public static String a(ao aoVar, String str, CharSequence charSequence, String str2, int i2, int i3, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{aoVar, str, charSequence, str2, Integer.valueOf(i2), Integer.valueOf(i3), str3})) == null) {
            String m594a = aoVar.m594a(str);
            try {
                if (f40585a) {
                    a("createChannel: appChannelId:" + m594a + " serverChannelId:" + str + " serverChannelName:" + ((Object) charSequence) + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i2 + " serverChannelName:" + ((Object) charSequence) + " serverChannelImportance:" + i3 + " channelSoundStr:" + str3);
                }
                NotificationChannel notificationChannel = new NotificationChannel(m594a, charSequence, i3);
                notificationChannel.setDescription(str2);
                notificationChannel.enableVibration((i2 & 2) != 0);
                notificationChannel.enableLights((i2 & 4) != 0);
                if ((i2 & 1) == 0) {
                    notificationChannel.setSound(null, null);
                } else if (!TextUtils.isEmpty(str3)) {
                    if (str3.startsWith("android.resource://" + aoVar.m593a())) {
                        notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
                    }
                }
                if (f40585a) {
                    a("create channel:" + notificationChannel);
                }
                a(aoVar, notificationChannel);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m71a("NCHelper", "create channel error " + e2);
            }
            return m594a;
        }
        return (String) invokeCommon.objValue;
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str) == null) && com.xiaomi.push.l.m536a(context) && !TextUtils.isEmpty(str)) {
            try {
                ao a2 = ao.a(context, str);
                Set<String> keySet = a(context).getAll().keySet();
                ArrayList arrayList = new ArrayList();
                for (String str2 : keySet) {
                    if (a2.m596a(str2)) {
                        arrayList.add(str2);
                        if (f40585a) {
                            a("delete channel copy record:" + str2);
                        }
                    }
                }
                a(context, arrayList);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, list) == null) {
            if (f40585a) {
                a("deleteCopiedChannelRecord:" + list);
            }
            if (list.isEmpty()) {
                return;
            }
            SharedPreferences.Editor edit = a(context).edit();
            for (String str : list) {
                edit.remove(str);
            }
            edit.apply();
        }
    }

    @TargetApi(26)
    public static void a(ao aoVar, NotificationChannel notificationChannel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, aoVar, notificationChannel) == null) {
            if (aoVar == null || notificationChannel == null) {
                throw new Exception("params cannot be null");
            }
            if (TextUtils.isEmpty(notificationChannel.getId())) {
                throw new Exception("serverChannel id cannot be empty");
            }
            Context m592a = aoVar.m592a();
            String id = notificationChannel.getId();
            String a2 = ao.a(id, aoVar.m593a());
            if (f40585a) {
                a("appChannelId:" + id + " oldChannelId:" + a2);
            }
            if (!com.xiaomi.push.l.m536a(m592a) || TextUtils.equals(id, a2)) {
                NotificationChannel m591a = aoVar.m591a(id);
                if (f40585a) {
                    a("elseLogic getNotificationChannel:" + m591a);
                }
                if (m591a != null) {
                    return;
                }
            } else {
                NotificationManager notificationManager = (NotificationManager) m592a.getSystemService(ActionJsonData.TAG_NOTIFICATION);
                NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(a2);
                NotificationChannel m591a2 = aoVar.m591a(id);
                if (f40585a) {
                    a("xmsfChannel:" + notificationChannel2);
                    a("appChannel:" + m591a2);
                }
                if (notificationChannel2 != null) {
                    NotificationChannel a3 = a(id, notificationChannel2);
                    if (f40585a) {
                        a("copyXmsf copyXmsfChannel:" + a3);
                    }
                    if (m591a2 != null) {
                        aoVar.a(a3, !a(m591a2));
                    } else {
                        aoVar.a(a3);
                    }
                    b(m592a, id);
                    notificationManager.deleteNotificationChannel(a2);
                    return;
                } else if (m591a2 != null) {
                    if (m584a(m592a, id) || !a(notificationChannel, m591a2)) {
                        return;
                    }
                    if (f40585a) {
                        a("appHack updateNotificationChannel:" + notificationChannel);
                    }
                    aoVar.a(notificationChannel, !a(m591a2));
                    return;
                } else if (f40585a) {
                    a("appHack createNotificationChannel:" + notificationChannel);
                }
            }
            aoVar.a(notificationChannel);
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            com.xiaomi.channel.commonutils.logger.b.m71a("NCHelper", str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(NotificationChannel notificationChannel) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, notificationChannel)) == null) {
            try {
                i2 = ((Integer) com.xiaomi.push.bh.b((Object) notificationChannel, "getUserLockedFields", new Object[0])).intValue();
            } catch (Exception e2) {
                e = e2;
                i2 = 0;
            }
            try {
                if (f40585a) {
                    a("isUserLockedChannel:" + i2 + " " + notificationChannel);
                }
            } catch (Exception e3) {
                e = e3;
                com.xiaomi.channel.commonutils.logger.b.m71a("NCHelper", "is user locked error" + e);
                if (i2 <= 0) {
                }
            }
            return i2 <= 0;
        }
        return invokeL.booleanValue;
    }

    @TargetApi(26)
    public static boolean a(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, notificationChannel, notificationChannel2)) == null) {
            if (notificationChannel == null || notificationChannel2 == null) {
                return false;
            }
            boolean z2 = true;
            if (TextUtils.equals(notificationChannel.getName(), notificationChannel2.getName())) {
                z = false;
            } else {
                if (f40585a) {
                    a("appHack channelConfigLowerCompare:getName");
                }
                z = true;
            }
            if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
                if (f40585a) {
                    a("appHack channelConfigLowerCompare:getDescription");
                }
                z = true;
            }
            if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
                notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
                if (f40585a) {
                    a("appHack channelConfigLowerCompare:getImportance  " + notificationChannel.getImportance() + " " + notificationChannel2.getImportance());
                }
                z = true;
            }
            if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
                notificationChannel.enableVibration(false);
                if (f40585a) {
                    a("appHack channelConfigLowerCompare:enableVibration");
                }
                z = true;
            }
            if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
                notificationChannel.enableLights(false);
                if (f40585a) {
                    a("appHack channelConfigLowerCompare:enableLights");
                }
                z = true;
            }
            if ((notificationChannel.getSound() != null) != (notificationChannel2.getSound() != null)) {
                notificationChannel.setSound(null, null);
                if (f40585a) {
                    a("appHack channelConfigLowerCompare:setSound");
                }
            } else {
                z2 = z;
            }
            if (f40585a) {
                a("appHack channelConfigLowerCompare:isDifferent:" + z2);
            }
            return z2;
        }
        return invokeLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m584a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            if (f40585a) {
                a("checkCopeidChannel:newFullChannelId:" + str + GlideException.IndentedAppendable.INDENT + a(context).getBoolean(str, false));
            }
            return a(context).getBoolean(str, false);
        }
        return invokeLL.booleanValue;
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, str) == null) {
            if (f40585a) {
                a("recordCopiedChannel:" + str);
            }
            a(context).edit().putBoolean(str, true).apply();
        }
    }
}
