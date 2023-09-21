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
import com.bumptech.glide.load.engine.GlideException;
import com.xiaomi.push.hu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class at {
    public static final boolean a = Log.isLoggable("NCHelper", 3);

    public static int a(NotificationChannel notificationChannel) {
        int i = 0;
        try {
            i = ((Integer) com.xiaomi.push.bj.b((Object) notificationChannel, "getUserLockedFields", new Object[0])).intValue();
            if (a) {
                a("isUserLockedChannel:" + i + " " + notificationChannel);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m184a("NCHelper", "is user locked error" + e);
        }
        return i;
    }

    @TargetApi(26)
    public static NotificationChannel a(String str, NotificationChannel notificationChannel) {
        NotificationChannel notificationChannel2 = new NotificationChannel(str, notificationChannel.getName(), notificationChannel.getImportance());
        notificationChannel2.setDescription(notificationChannel.getDescription());
        notificationChannel2.enableVibration(notificationChannel.shouldVibrate());
        notificationChannel2.enableLights(notificationChannel.shouldShowLights());
        notificationChannel2.setSound(notificationChannel.getSound(), notificationChannel.getAudioAttributes());
        notificationChannel2.setLockscreenVisibility(notificationChannel.getLockscreenVisibility());
        return notificationChannel2;
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush_channel_copy_sp", 0);
    }

    @TargetApi(26)
    public static String a(ax axVar, String str, CharSequence charSequence, String str2, int i, int i2, String str3, String str4) {
        String m787a = axVar.m787a(str);
        if (a) {
            a("createChannel: appChannelId:" + m787a + " serverChannelId:" + str + " serverChannelName:" + ((Object) charSequence) + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i + " serverChannelName:" + ((Object) charSequence) + " serverChannelImportance:" + i2 + " channelSoundStr:" + str3 + " channelPermissions:" + str4);
        }
        NotificationChannel notificationChannel = new NotificationChannel(m787a, charSequence, i2);
        notificationChannel.setDescription(str2);
        notificationChannel.enableVibration((i & 2) != 0);
        notificationChannel.enableLights((i & 4) != 0);
        if ((i & 1) == 0) {
            notificationChannel.setSound(null, null);
        } else if (!TextUtils.isEmpty(str3)) {
            if (str3.startsWith("android.resource://" + axVar.m786a())) {
                notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        if (a) {
            a("create channel:" + notificationChannel);
        }
        a(axVar, notificationChannel, str4);
        return m787a;
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(26)
    public static void a(Context context, ax axVar, NotificationChannel notificationChannel, int i, String str) {
        if (i <= 0) {
            axVar.a(notificationChannel);
            return;
        }
        int a2 = com.xiaomi.push.g.a(context) >= 2 ? e.a(context.getPackageName(), str) : 0;
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
        e.a(axVar.m786a(), notificationChannel.getId(), a2, 0);
    }

    public static void a(Context context, String str) {
        if (!com.xiaomi.push.j.m714a(context) || TextUtils.isEmpty(str)) {
            return;
        }
        c(context, str);
        e.a(context, str);
    }

    public static void a(Context context, List<String> list) {
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

    public static void a(hu huVar) {
        Map<String, String> map;
        if (huVar == null || (map = huVar.f543a) == null || !map.containsKey("REMOVE_CHANNEL_MARK")) {
            return;
        }
        huVar.f539a = 0;
        huVar.f543a.remove("channel_id");
        huVar.f543a.remove("channel_importance");
        huVar.f543a.remove("channel_name");
        huVar.f543a.remove("channel_description");
        huVar.f543a.remove("channel_perm");
        com.xiaomi.channel.commonutils.logger.b.m183a("delete channel info by:" + huVar.f543a.get("REMOVE_CHANNEL_MARK"));
        huVar.f543a.remove("REMOVE_CHANNEL_MARK");
    }

    @TargetApi(26)
    public static void a(ax axVar, NotificationChannel notificationChannel, String str) {
        int i;
        char c;
        Context m785a = axVar.m785a();
        String id = notificationChannel.getId();
        String a2 = ax.a(id, axVar.m786a());
        if (a) {
            a("appChannelId:" + id + " oldChannelId:" + a2);
        }
        boolean z = true;
        if (com.xiaomi.push.j.m714a(m785a) && !TextUtils.equals(id, a2)) {
            NotificationManager notificationManager = (NotificationManager) m785a.getSystemService("notification");
            NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(a2);
            NotificationChannel m784a = axVar.m784a(id);
            if (a) {
                a("xmsfChannel:" + notificationChannel2);
                a("appChannel:" + m784a);
            }
            if (notificationChannel2 != null) {
                NotificationChannel a3 = a(id, notificationChannel2);
                if (a) {
                    a("copyXmsf copyXmsfChannel:" + a3);
                }
                if (m784a != null) {
                    i = a(m784a);
                    axVar.a(a3, i == 0);
                    c = 3;
                } else {
                    int a4 = a(notificationChannel2);
                    a(m785a, axVar, a3, a4, notificationChannel2.getId());
                    i = a4;
                    c = 4;
                }
                b(m785a, id);
                notificationManager.deleteNotificationChannel(a2);
            } else if (m784a == null) {
                if (a) {
                    a("appHack createNotificationChannel:" + notificationChannel);
                }
                axVar.a(notificationChannel);
                i = 0;
                c = 1;
            } else if (!m776a(m785a, id) && a(notificationChannel, m784a)) {
                if (a) {
                    a("appHack updateNotificationChannel:" + notificationChannel);
                }
                i = a(m784a);
                axVar.a(notificationChannel, i == 0);
                c = 2;
            }
            if (c != 1 && c != 4 && c != 3) {
                z = false;
            }
            e.a(axVar.m785a(), axVar.m786a(), id, notificationChannel.getImportance(), str, z, i);
        }
        NotificationChannel m784a2 = axVar.m784a(id);
        if (a) {
            a("elseLogic getNotificationChannel:" + m784a2);
        }
        if (m784a2 == null) {
            axVar.a(notificationChannel);
        }
        i = 0;
        c = 0;
        if (c != 1) {
            z = false;
        }
        e.a(axVar.m785a(), axVar.m786a(), id, notificationChannel.getImportance(), str, z, i);
    }

    public static void a(String str) {
        com.xiaomi.channel.commonutils.logger.b.m184a("NCHelper", str);
    }

    @TargetApi(26)
    public static boolean a(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        boolean z;
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

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m776a(Context context, String str) {
        if (a) {
            a("checkCopeidChannel:newFullChannelId:" + str + GlideException.IndentedAppendable.INDENT + a(context).getBoolean(str, false));
        }
        return a(context).getBoolean(str, false);
    }

    public static void b(Context context, String str) {
        if (a) {
            a("recordCopiedChannel:" + str);
        }
        a(context).edit().putBoolean(str, true).apply();
    }

    public static void c(Context context, String str) {
        try {
            ax a2 = ax.a(context, str);
            Set<String> keySet = a(context).getAll().keySet();
            ArrayList arrayList = new ArrayList();
            for (String str2 : keySet) {
                if (a2.m789a(str2)) {
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
