package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.engine.GlideException;
import com.xiaomi.push.hw;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class at {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071162643, "Lcom/xiaomi/push/service/at;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071162643, "Lcom/xiaomi/push/service/at;");
                return;
            }
        }
        a = Log.isLoggable("NCHelper", 3);
    }

    public static int a(NotificationChannel notificationChannel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, notificationChannel)) == null) {
            int i = 0;
            try {
                i = ((Integer) com.xiaomi.push.bk.b((Object) notificationChannel, "getUserLockedFields", new Object[0])).intValue();
                if (a) {
                    a("isUserLockedChannel:" + i + " " + notificationChannel);
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m104a("NCHelper", "is user locked error" + e);
            }
            return i;
        }
        return invokeL.intValue;
    }

    @TargetApi(26)
    public static NotificationChannel a(String str, NotificationChannel notificationChannel) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, notificationChannel)) == null) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context.getSharedPreferences("mipush_channel_copy_sp", 0) : (SharedPreferences) invokeL.objValue;
    }

    @TargetApi(26)
    public static String a(ax axVar, String str, CharSequence charSequence, String str2, int i, int i2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{axVar, str, charSequence, str2, Integer.valueOf(i), Integer.valueOf(i2), str3, str4})) == null) {
            String m702a = axVar.m702a(str);
            if (a) {
                a("createChannel: appChannelId:" + m702a + " serverChannelId:" + str + " serverChannelName:" + ((Object) charSequence) + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i + " serverChannelName:" + ((Object) charSequence) + " serverChannelImportance:" + i2 + " channelSoundStr:" + str3 + " channelPermissions:" + str4);
            }
            NotificationChannel notificationChannel = new NotificationChannel(m702a, charSequence, i2);
            notificationChannel.setDescription(str2);
            notificationChannel.enableVibration((i & 2) != 0);
            notificationChannel.enableLights((i & 4) != 0);
            if ((i & 1) == 0) {
                notificationChannel.setSound(null, null);
            } else if (!TextUtils.isEmpty(str3)) {
                if (str3.startsWith("android.resource://" + axVar.m701a())) {
                    notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
            if (a) {
                a("create channel:" + notificationChannel);
            }
            a(axVar, notificationChannel, str4);
            return m702a;
        }
        return (String) invokeCommon.objValue;
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(26)
    public static void a(Context context, ax axVar, NotificationChannel notificationChannel, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, axVar, notificationChannel, Integer.valueOf(i), str}) == null) {
            if (i <= 0) {
                axVar.a(notificationChannel);
                return;
            }
            int a2 = com.xiaomi.push.h.a(context) >= 2 ? e.a(context.getPackageName(), str) : 0;
            NotificationChannel a3 = a(notificationChannel.getId(), notificationChannel);
            if ((i & 32) != 0) {
                if (notificationChannel.getSound() != null) {
                    a3.setSound(null, null);
                } else {
                    a3.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
            if ((i & 16) != 0) {
                if (notificationChannel.shouldVibrate()) {
                    a3.enableVibration(false);
                } else {
                    a3.enableVibration(true);
                }
            }
            if ((i & 8) != 0) {
                if (notificationChannel.shouldShowLights()) {
                    a3.enableLights(false);
                } else {
                    a3.enableLights(true);
                }
            }
            if ((i & 4) != 0) {
                int importance = notificationChannel.getImportance() - 1;
                if (importance <= 0) {
                    importance = 2;
                }
                a3.setImportance(importance);
            }
            if ((i & 2) != 0) {
                a3.setLockscreenVisibility(notificationChannel.getLockscreenVisibility() - 1);
            }
            axVar.a(a3);
            axVar.a(notificationChannel, true);
            e.a(axVar.m701a(), notificationChannel.getId(), a2, 0);
        }
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, context, str) == null) && com.xiaomi.push.m.m635a(context) && !TextUtils.isEmpty(str)) {
            c(context, str);
            e.a(context, str);
        }
    }

    public static void a(Context context, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, list) == null) {
            if (a) {
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

    public static void a(hw hwVar) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, hwVar) == null) || hwVar == null || (map = hwVar.f564a) == null || !map.containsKey("REMOVE_CHANNEL_MARK")) {
            return;
        }
        hwVar.f560a = 0;
        hwVar.f564a.remove("channel_id");
        hwVar.f564a.remove("channel_importance");
        hwVar.f564a.remove("channel_name");
        hwVar.f564a.remove("channel_description");
        hwVar.f564a.remove("channel_perm");
        com.xiaomi.channel.commonutils.logger.b.m103a("delete channel info by:" + hwVar.f564a.get("REMOVE_CHANNEL_MARK"));
        hwVar.f564a.remove("REMOVE_CHANNEL_MARK");
    }

    @TargetApi(26)
    public static void a(ax axVar, NotificationChannel notificationChannel, String str) {
        int i;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, axVar, notificationChannel, str) == null) {
            Context m700a = axVar.m700a();
            String id = notificationChannel.getId();
            String a2 = ax.a(id, axVar.m701a());
            if (a) {
                a("appChannelId:" + id + " oldChannelId:" + a2);
            }
            boolean z = true;
            if (com.xiaomi.push.m.m635a(m700a) && !TextUtils.equals(id, a2)) {
                NotificationManager notificationManager = (NotificationManager) m700a.getSystemService(ActionJsonData.TAG_NOTIFICATION);
                NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(a2);
                NotificationChannel m699a = axVar.m699a(id);
                if (a) {
                    a("xmsfChannel:" + notificationChannel2);
                    a("appChannel:" + m699a);
                }
                if (notificationChannel2 != null) {
                    NotificationChannel a3 = a(id, notificationChannel2);
                    if (a) {
                        a("copyXmsf copyXmsfChannel:" + a3);
                    }
                    if (m699a != null) {
                        i = a(m699a);
                        axVar.a(a3, i == 0);
                        c = 3;
                    } else {
                        int a4 = a(notificationChannel2);
                        a(m700a, axVar, a3, a4, notificationChannel2.getId());
                        i = a4;
                        c = 4;
                    }
                    b(m700a, id);
                    notificationManager.deleteNotificationChannel(a2);
                } else if (m699a == null) {
                    if (a) {
                        a("appHack createNotificationChannel:" + notificationChannel);
                    }
                    axVar.a(notificationChannel);
                    i = 0;
                    c = 1;
                } else if (!m691a(m700a, id) && a(notificationChannel, m699a)) {
                    if (a) {
                        a("appHack updateNotificationChannel:" + notificationChannel);
                    }
                    i = a(m699a);
                    axVar.a(notificationChannel, i == 0);
                    c = 2;
                }
                if (c != 1 && c != 4 && c != 3) {
                    z = false;
                }
                e.a(axVar.m700a(), axVar.m701a(), id, notificationChannel.getImportance(), str, z, i);
            }
            NotificationChannel m699a2 = axVar.m699a(id);
            if (a) {
                a("elseLogic getNotificationChannel:" + m699a2);
            }
            if (m699a2 == null) {
                axVar.a(notificationChannel);
            }
            i = 0;
            c = 0;
            if (c != 1) {
                z = false;
            }
            e.a(axVar.m700a(), axVar.m701a(), id, notificationChannel.getImportance(), str, z, i);
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            com.xiaomi.channel.commonutils.logger.b.m104a("NCHelper", str);
        }
    }

    @TargetApi(26)
    public static boolean a(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, notificationChannel, notificationChannel2)) == null) {
            if (notificationChannel == null || notificationChannel2 == null) {
                return false;
            }
            boolean z2 = true;
            if (TextUtils.equals(notificationChannel.getName(), notificationChannel2.getName())) {
                z = false;
            } else {
                if (a) {
                    a("appHack channelConfigLowerCompare:getName");
                }
                z = true;
            }
            if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
                if (a) {
                    a("appHack channelConfigLowerCompare:getDescription");
                }
                z = true;
            }
            if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
                notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
                if (a) {
                    a("appHack channelConfigLowerCompare:getImportance  " + notificationChannel.getImportance() + " " + notificationChannel2.getImportance());
                }
                z = true;
            }
            if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
                notificationChannel.enableVibration(false);
                if (a) {
                    a("appHack channelConfigLowerCompare:enableVibration");
                }
                z = true;
            }
            if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
                notificationChannel.enableLights(false);
                if (a) {
                    a("appHack channelConfigLowerCompare:enableLights");
                }
                z = true;
            }
            if ((notificationChannel.getSound() != null) != (notificationChannel2.getSound() != null)) {
                notificationChannel.setSound(null, null);
                if (a) {
                    a("appHack channelConfigLowerCompare:setSound");
                }
            } else {
                z2 = z;
            }
            if (a) {
                a("appHack channelConfigLowerCompare:isDifferent:" + z2);
            }
            return z2;
        }
        return invokeLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m691a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) {
            if (a) {
                a("checkCopeidChannel:newFullChannelId:" + str + GlideException.IndentedAppendable.INDENT + a(context).getBoolean(str, false));
            }
            return a(context).getBoolean(str, false);
        }
        return invokeLL.booleanValue;
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, str) == null) {
            if (a) {
                a("recordCopiedChannel:" + str);
            }
            a(context).edit().putBoolean(str, true).apply();
        }
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, str) == null) {
            try {
                ax a2 = ax.a(context, str);
                Set<String> keySet = a(context).getAll().keySet();
                ArrayList arrayList = new ArrayList();
                for (String str2 : keySet) {
                    if (a2.m704a(str2)) {
                        arrayList.add(str2);
                        if (a) {
                            a("delete channel copy record:" + str2);
                        }
                    }
                }
                a(context, arrayList);
            } catch (Exception unused) {
            }
        }
    }
}
