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
import com.baidu.android.util.io.ActionJsonData;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public class ak {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f41328a = Log.isLoggable("NCHelper", 3);

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
    public static String a(ao aoVar) {
        String b2 = aoVar.b();
        try {
            NotificationChannel notificationChannel = new NotificationChannel(b2, com.xiaomi.push.g.m326b(aoVar.m577a(), aoVar.m578a()), 3);
            if (f41328a) {
                a("create default channel:" + notificationChannel);
            }
            a(aoVar, notificationChannel);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m56a("NCHelper", "create default channel error " + e2);
        }
        return b2;
    }

    @TargetApi(26)
    public static String a(ao aoVar, String str, CharSequence charSequence, String str2, int i, int i2, String str3) {
        String m579a = aoVar.m579a(str);
        try {
            if (f41328a) {
                a("createChannel: appChannelId:" + m579a + " serverChannelId:" + str + " serverChannelName:" + ((Object) charSequence) + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i + " serverChannelName:" + ((Object) charSequence) + " serverChannelImportance:" + i2 + " channelSoundStr:" + str3);
            }
            NotificationChannel notificationChannel = new NotificationChannel(m579a, charSequence, i2);
            notificationChannel.setDescription(str2);
            notificationChannel.enableVibration((i & 2) != 0);
            notificationChannel.enableLights((i & 4) != 0);
            if ((i & 1) == 0) {
                notificationChannel.setSound(null, null);
            } else if (!TextUtils.isEmpty(str3)) {
                if (str3.startsWith("android.resource://" + aoVar.m578a())) {
                    notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
            if (f41328a) {
                a("create channel:" + notificationChannel);
            }
            a(aoVar, notificationChannel);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m56a("NCHelper", "create channel error " + e2);
        }
        return m579a;
    }

    public static void a(Context context, String str) {
        if (!com.xiaomi.push.l.m521a(context) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ao a2 = ao.a(context, str);
            Set<String> keySet = a(context).getAll().keySet();
            ArrayList arrayList = new ArrayList();
            for (String str2 : keySet) {
                if (a2.m581a(str2)) {
                    arrayList.add(str2);
                    if (f41328a) {
                        a("delete channel copy record:" + str2);
                    }
                }
            }
            a(context, arrayList);
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, List<String> list) {
        if (f41328a) {
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

    @TargetApi(26)
    public static void a(ao aoVar, NotificationChannel notificationChannel) {
        if (aoVar == null || notificationChannel == null) {
            throw new Exception("params cannot be null");
        }
        if (TextUtils.isEmpty(notificationChannel.getId())) {
            throw new Exception("serverChannel id cannot be empty");
        }
        Context m577a = aoVar.m577a();
        String id = notificationChannel.getId();
        String a2 = ao.a(id, aoVar.m578a());
        if (f41328a) {
            a("appChannelId:" + id + " oldChannelId:" + a2);
        }
        if (!com.xiaomi.push.l.m521a(m577a) || TextUtils.equals(id, a2)) {
            NotificationChannel m576a = aoVar.m576a(id);
            if (f41328a) {
                a("elseLogic getNotificationChannel:" + m576a);
            }
            if (m576a != null) {
                return;
            }
        } else {
            NotificationManager notificationManager = (NotificationManager) m577a.getSystemService(ActionJsonData.TAG_NOTIFICATION);
            NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(a2);
            NotificationChannel m576a2 = aoVar.m576a(id);
            if (f41328a) {
                a("xmsfChannel:" + notificationChannel2);
                a("appChannel:" + m576a2);
            }
            if (notificationChannel2 != null) {
                NotificationChannel a3 = a(id, notificationChannel2);
                if (f41328a) {
                    a("copyXmsf copyXmsfChannel:" + a3);
                }
                if (m576a2 != null) {
                    aoVar.a(a3, !a(m576a2));
                } else {
                    aoVar.a(a3);
                }
                b(m577a, id);
                notificationManager.deleteNotificationChannel(a2);
                return;
            } else if (m576a2 != null) {
                if (m569a(m577a, id) || !a(notificationChannel, m576a2)) {
                    return;
                }
                if (f41328a) {
                    a("appHack updateNotificationChannel:" + notificationChannel);
                }
                aoVar.a(notificationChannel, !a(m576a2));
                return;
            } else if (f41328a) {
                a("appHack createNotificationChannel:" + notificationChannel);
            }
        }
        aoVar.a(notificationChannel);
    }

    public static void a(String str) {
        com.xiaomi.channel.commonutils.logger.b.m56a("NCHelper", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(NotificationChannel notificationChannel) {
        int i;
        try {
            i = ((Integer) com.xiaomi.push.bh.b((Object) notificationChannel, "getUserLockedFields", new Object[0])).intValue();
            try {
                if (f41328a) {
                    a("isUserLockedChannel:" + i + " " + notificationChannel);
                }
            } catch (Exception e2) {
                e = e2;
                com.xiaomi.channel.commonutils.logger.b.m56a("NCHelper", "is user locked error" + e);
                if (i <= 0) {
                }
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
        }
        return i <= 0;
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
            if (f41328a) {
                a("appHack channelConfigLowerCompare:getName");
            }
            z = true;
        }
        if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
            if (f41328a) {
                a("appHack channelConfigLowerCompare:getDescription");
            }
            z = true;
        }
        if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
            notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
            if (f41328a) {
                a("appHack channelConfigLowerCompare:getImportance  " + notificationChannel.getImportance() + " " + notificationChannel2.getImportance());
            }
            z = true;
        }
        if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
            notificationChannel.enableVibration(false);
            if (f41328a) {
                a("appHack channelConfigLowerCompare:enableVibration");
            }
            z = true;
        }
        if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
            notificationChannel.enableLights(false);
            if (f41328a) {
                a("appHack channelConfigLowerCompare:enableLights");
            }
            z = true;
        }
        if ((notificationChannel.getSound() != null) != (notificationChannel2.getSound() != null)) {
            notificationChannel.setSound(null, null);
            if (f41328a) {
                a("appHack channelConfigLowerCompare:setSound");
            }
        } else {
            z2 = z;
        }
        if (f41328a) {
            a("appHack channelConfigLowerCompare:isDifferent:" + z2);
        }
        return z2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m569a(Context context, String str) {
        if (f41328a) {
            a("checkCopeidChannel:newFullChannelId:" + str + GlideException.IndentedAppendable.INDENT + a(context).getBoolean(str, false));
        }
        return a(context).getBoolean(str, false);
    }

    public static void b(Context context, String str) {
        if (f41328a) {
            a("recordCopiedChannel:" + str);
        }
        a(context).edit().putBoolean(str, true).apply();
    }
}
