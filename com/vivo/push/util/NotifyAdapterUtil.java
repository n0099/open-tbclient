package com.vivo.push.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.vivo.push.d.r;
import com.vivo.push.model.InsideNotificationItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes8.dex */
public class NotifyAdapterUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HIDE_TITLE = 1;
    public static final int NOTIFY_MULTITERM_STYLE = 1;
    public static final int NOTIFY_SINGLE_STYLE = 0;
    public static final String PRIMARY_CHANNEL = "vivo_push_channel";
    public static final String PUSH_EN = "PUSH";
    public static final String PUSH_ID = "pushId";
    public static final String PUSH_ZH = "推送通知";
    public static final String TAG = "NotifyManager";
    public static NotificationManager sNotificationManager = null;
    public static int sNotifyId = 20000000;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(328895572, "Lcom/vivo/push/util/NotifyAdapterUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(328895572, "Lcom/vivo/push/util/NotifyAdapterUtil;");
        }
    }

    public NotifyAdapterUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean cancelNotify(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, context, i)) == null) {
            initAdapter(context);
            NotificationManager notificationManager = sNotificationManager;
            if (notificationManager != null) {
                notificationManager.cancel(i);
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static synchronized void initAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            synchronized (NotifyAdapterUtil.class) {
                if (sNotificationManager == null) {
                    sNotificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
                }
                if (Build.VERSION.SDK_INT >= 26 && sNotificationManager != null) {
                    NotificationChannel notificationChannel = sNotificationManager.getNotificationChannel("default");
                    if (notificationChannel != null) {
                        CharSequence name = notificationChannel.getName();
                        if (PUSH_ZH.equals(name) || PUSH_EN.equals(name)) {
                            sNotificationManager.deleteNotificationChannel("default");
                        }
                    }
                    NotificationChannel notificationChannel2 = new NotificationChannel(PRIMARY_CHANNEL, isZh(context) ? PUSH_ZH : PUSH_EN, 4);
                    notificationChannel2.setLightColor(DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK);
                    notificationChannel2.enableVibration(true);
                    notificationChannel2.setLockscreenVisibility(1);
                    sNotificationManager.createNotificationChannel(notificationChannel2);
                }
            }
        }
    }

    public static boolean isZh(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? context.getResources().getConfiguration().locale.getLanguage().endsWith("zh") : invokeL.booleanValue;
    }

    public static void pushNotification(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, int i, r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, list, insideNotificationItem, Long.valueOf(j), Integer.valueOf(i), aVar}) == null) {
            p.d(TAG, "pushNotification");
            initAdapter(context);
            int notifyMode = NotifyUtil.getNotifyDataAdapter(context).getNotifyMode(insideNotificationItem);
            if (!TextUtils.isEmpty(insideNotificationItem.getPurePicUrl()) && list != null && list.size() > 1 && list.get(1) != null) {
                notifyMode = 1;
            }
            if (notifyMode == 2) {
                pushNotificationBySystem(context, list, insideNotificationItem, j, i, aVar);
            } else if (notifyMode == 1) {
                pushNotificationByCustom(context, list, insideNotificationItem, j, aVar);
            }
        }
    }

    public static void pushNotificationByCustom(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, r.a aVar) {
        Notification notification;
        int i;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, list, insideNotificationItem, Long.valueOf(j), aVar}) == null) {
            Resources resources = context.getResources();
            String packageName = context.getPackageName();
            String title = insideNotificationItem.getTitle();
            int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
            int i2 = context.getApplicationInfo().icon;
            Bundle bundle = new Bundle();
            bundle.putLong("pushId", j);
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 26) {
                Notification.Builder builder = new Notification.Builder(context, PRIMARY_CHANNEL);
                if (defaultNotifyIcon > 0) {
                    bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
                }
                builder.setExtras(bundle);
                notification = builder.build();
            } else if (i3 >= 19) {
                Notification.Builder builder2 = new Notification.Builder(context);
                builder2.setExtras(bundle);
                notification = builder2.build();
            } else {
                notification = new Notification();
            }
            notification.priority = 2;
            notification.flags = 16;
            notification.tickerText = title;
            int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
            if (defaultSmallIconId <= 0) {
                defaultSmallIconId = i2;
            }
            notification.icon = defaultSmallIconId;
            RemoteViews remoteViews = new RemoteViews(packageName, NotifyUtil.getNotifyLayoutAdapter(context).getNotificationLayout());
            remoteViews.setTextViewText(resources.getIdentifier("notify_title", "id", packageName), title);
            remoteViews.setTextColor(resources.getIdentifier("notify_title", "id", packageName), NotifyUtil.getNotifyLayoutAdapter(context).getTitleColor());
            remoteViews.setTextViewText(resources.getIdentifier("notify_msg", "id", packageName), insideNotificationItem.getContent());
            if (insideNotificationItem.isShowTime()) {
                remoteViews.setTextViewText(resources.getIdentifier("notify_when", "id", packageName), new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date()));
                i = 0;
                remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 0);
            } else {
                i = 0;
                remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 8);
            }
            int suitIconId = NotifyUtil.getNotifyLayoutAdapter(context).getSuitIconId();
            remoteViews.setViewVisibility(suitIconId, i);
            if (list != null && !list.isEmpty() && (bitmap = list.get(i)) != null) {
                remoteViews.setImageViewBitmap(suitIconId, bitmap);
            } else {
                if (defaultNotifyIcon <= 0) {
                    defaultNotifyIcon = i2;
                }
                remoteViews.setImageViewResource(suitIconId, defaultNotifyIcon);
            }
            Bitmap bitmap2 = null;
            if (list != null && list.size() > 1) {
                bitmap2 = list.get(1);
            }
            if (bitmap2 != null) {
                if (!TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
                    remoteViews.setViewVisibility(resources.getIdentifier("notify_content", "id", packageName), 8);
                    remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
                    remoteViews.setViewVisibility(resources.getIdentifier("notify_pure_cover", "id", packageName), 0);
                    remoteViews.setImageViewBitmap(resources.getIdentifier("notify_pure_cover", "id", packageName), bitmap2);
                } else {
                    remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 0);
                    remoteViews.setImageViewBitmap(resources.getIdentifier("notify_cover", "id", packageName), bitmap2);
                }
            } else {
                remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
            }
            notification.contentView = remoteViews;
            if (Build.VERSION.SDK_INT >= 16 && TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
                notification.bigContentView = remoteViews;
            }
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            int ringerMode = audioManager.getRingerMode();
            int vibrateSetting = audioManager.getVibrateSetting(0);
            p.d(TAG, "ringMode=" + ringerMode + " callVibrateSetting=" + vibrateSetting);
            int notifyType = insideNotificationItem.getNotifyType();
            if (notifyType != 2) {
                if (notifyType != 3) {
                    if (notifyType == 4) {
                        if (ringerMode == 2) {
                            notification.defaults = 1;
                        }
                        if (vibrateSetting == 1) {
                            notification.defaults |= 2;
                            notification.vibrate = new long[]{0, 100, 200, 300};
                        }
                    }
                } else if (vibrateSetting == 1) {
                    notification.defaults = 2;
                    notification.vibrate = new long[]{0, 100, 200, 300};
                }
            } else if (ringerMode == 2) {
                notification.defaults = 1;
            }
            Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
            intent.setPackage(context.getPackageName());
            intent.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
            intent.putExtra("command_type", "reflect_receiver");
            try {
                intent.putExtra("security_avoid_pull", a.a(context).a("com.vivo.pushservice"));
                if (Build.VERSION.SDK_INT >= 18) {
                    intent.putExtra("security_avoid_pull_rsa", com.vivo.push.c.d.a(context).a().a("com.vivo.pushservice"));
                    intent.putExtra("security_avoid_rsa_public_key", u.a(com.vivo.push.c.d.a(context).a().a()));
                }
            } catch (Exception e) {
                p.a(TAG, "pushNotificationByCustom encrypt ：" + e.getMessage());
            }
            new com.vivo.push.b.p(packageName, j, insideNotificationItem).b(intent);
            notification.contentIntent = PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), intent, LaunchTaskConstants.OTHER_PROCESS);
            if (sNotificationManager != null) {
                int k = com.vivo.push.e.a().k();
                try {
                    if (k == 0) {
                        sNotificationManager.notify(sNotifyId, notification);
                        if (aVar != null) {
                            aVar.a();
                        }
                    } else if (k == 1) {
                        sNotificationManager.notify((int) j, notification);
                        if (aVar != null) {
                            aVar.a();
                        }
                    } else {
                        p.a(TAG, "unknow notify style ".concat(String.valueOf(k)));
                    }
                } catch (Exception e2) {
                    p.a(TAG, e2);
                    if (aVar != null) {
                        aVar.b();
                    }
                }
            }
        }
    }

    public static void pushNotificationBySystem(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, int i, r.a aVar) {
        String str;
        Bitmap bitmap;
        Notification.Builder builder;
        int i2;
        Bitmap bitmap2;
        Bitmap decodeResource;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, list, insideNotificationItem, Long.valueOf(j), Integer.valueOf(i), aVar}) == null) {
            String packageName = context.getPackageName();
            String title = insideNotificationItem.getTitle();
            String content = insideNotificationItem.getContent();
            int i3 = context.getApplicationInfo().icon;
            boolean isShowTime = insideNotificationItem.isShowTime();
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
            if (list == null || list.isEmpty()) {
                str = packageName;
                bitmap = null;
            } else {
                bitmap = list.get(0);
                if (bitmap == null || defaultNotifyIcon <= 0 || (decodeResource = BitmapFactory.decodeResource(context.getResources(), defaultNotifyIcon)) == null) {
                    str = packageName;
                } else {
                    int width = decodeResource.getWidth();
                    str = packageName;
                    int height = decodeResource.getHeight();
                    decodeResource.recycle();
                    bitmap = c.a(bitmap, width, height);
                }
            }
            Bundle bundle = new Bundle();
            if (Build.VERSION.SDK_INT >= 26) {
                builder = new Notification.Builder(context, PRIMARY_CHANNEL);
                if (defaultNotifyIcon > 0) {
                    bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
                }
                if (bitmap != null) {
                    builder.setLargeIcon(bitmap);
                }
            } else {
                builder = new Notification.Builder(context);
                if (bitmap != null) {
                    builder.setLargeIcon(bitmap);
                } else if (Build.VERSION.SDK_INT <= 22) {
                    builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), i3));
                }
            }
            if (Build.VERSION.SDK_INT >= 19) {
                bundle.putLong("pushId", j);
                builder.setExtras(bundle);
            }
            int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
            if (defaultSmallIconId > 0) {
                i3 = defaultSmallIconId;
            }
            builder.setSmallIcon(i3);
            if (insideNotificationItem.getCompatibleType() != 1) {
                builder.setContentTitle(title);
            }
            builder.setPriority(2);
            builder.setContentText(content);
            builder.setWhen(isShowTime ? System.currentTimeMillis() : 0L);
            builder.setShowWhen(isShowTime);
            builder.setTicker(title);
            int ringerMode = audioManager.getRingerMode();
            int notifyType = insideNotificationItem.getNotifyType();
            if (notifyType != 2) {
                if (notifyType != 3) {
                    if (notifyType == 4) {
                        if (ringerMode == 2) {
                            builder.setDefaults(3);
                            builder.setVibrate(new long[]{0, 100, 200, 300});
                        } else if (ringerMode == 1) {
                            builder.setDefaults(2);
                            builder.setVibrate(new long[]{0, 100, 200, 300});
                        }
                    }
                } else if (ringerMode == 2) {
                    builder.setDefaults(2);
                    builder.setVibrate(new long[]{0, 100, 200, 300});
                }
            } else if (ringerMode == 2) {
                builder.setDefaults(1);
            }
            if (list == null || list.size() <= 1) {
                i2 = i;
                bitmap2 = null;
            } else {
                bitmap2 = list.get(1);
                i2 = i;
            }
            if (i2 != 1) {
                Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
                bigTextStyle.setBigContentTitle(title);
                bigTextStyle.bigText(content);
                builder.setStyle(bigTextStyle);
            }
            if (bitmap2 != null) {
                Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
                bigPictureStyle.setBigContentTitle(title);
                bigPictureStyle.setSummaryText(content);
                bigPictureStyle.bigPicture(bitmap2);
                builder.setStyle(bigPictureStyle);
            }
            builder.setAutoCancel(true);
            Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
            intent.setPackage(context.getPackageName());
            intent.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
            intent.putExtra("command_type", "reflect_receiver");
            try {
                intent.putExtra("security_avoid_pull", a.a(context).a("com.vivo.pushservice"));
                if (Build.VERSION.SDK_INT >= 18) {
                    intent.putExtra("security_avoid_pull_rsa", com.vivo.push.c.d.a(context).a().a("com.vivo.pushservice"));
                    intent.putExtra("security_avoid_rsa_public_key", u.a(com.vivo.push.c.d.a(context).a().a()));
                }
            } catch (Exception e) {
                p.a(TAG, "pushNotificationBySystem encrypt ：" + e.getMessage());
            }
            new com.vivo.push.b.p(str, j, insideNotificationItem).b(intent);
            builder.setContentIntent(PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), intent, LaunchTaskConstants.OTHER_PROCESS));
            Notification build = builder.build();
            int k = com.vivo.push.e.a().k();
            NotificationManager notificationManager = sNotificationManager;
            if (notificationManager != null) {
                try {
                    if (k == 0) {
                        notificationManager.notify(sNotifyId, build);
                        if (aVar != null) {
                            aVar.a();
                        }
                    } else if (k == 1) {
                        notificationManager.notify((int) j, build);
                        if (aVar != null) {
                            aVar.a();
                        }
                    } else {
                        p.a(TAG, "unknow notify style ".concat(String.valueOf(k)));
                    }
                } catch (Exception e2) {
                    p.a(TAG, e2);
                    if (aVar != null) {
                        aVar.b();
                    }
                }
            }
        }
    }

    public static boolean repealNotifyById(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65545, null, context, j)) == null) {
            int k = com.vivo.push.e.a().k();
            if (k != 0) {
                if (k == 1) {
                    return cancelNotify(context, (int) j);
                }
                p.a(TAG, "unknow cancle notify style ".concat(String.valueOf(k)));
                return false;
            }
            long b = w.b().b("com.vivo.push.notify_key", -1L);
            if (b == j) {
                p.d(TAG, "undo showed message ".concat(String.valueOf(j)));
                p.a(context, "回收已展示的通知： ".concat(String.valueOf(j)));
                return cancelNotify(context, sNotifyId);
            }
            p.d(TAG, "current showing message id " + b + " not match " + j);
            p.a(context, "与已展示的通知" + b + "与待回收的通知" + j + "不匹配");
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static void setNotifyId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65546, null, i) == null) {
            sNotifyId = i;
        }
    }

    public static void cancelNotify(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            cancelNotify(context, sNotifyId);
        }
    }
}
