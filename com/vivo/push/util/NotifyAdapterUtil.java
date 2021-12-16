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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.model.InsideNotificationItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes4.dex */
public class NotifyAdapterUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NOTIFY_MULTITERM_STYLE = 1;
    public static final int NOTIFY_SINGLE_STYLE = 0;
    public static final String PRIMARY_CHANNEL = "vivo_push_channel";
    public static final String PUSH_EN = "PUSH";
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean cancelNotify(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, context, i2)) == null) {
            initAdapter(context);
            NotificationManager notificationManager = sNotificationManager;
            if (notificationManager != null) {
                notificationManager.cancel(i2);
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
                    notificationChannel2.setLightColor(-16711936);
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

    public static void pushNotification(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, list, insideNotificationItem, Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            p.d(TAG, "pushNotification");
            initAdapter(context);
            int notifyMode = NotifyUtil.getNotifyDataAdapter(context).getNotifyMode(insideNotificationItem);
            if (!TextUtils.isEmpty(insideNotificationItem.getPurePicUrl()) && list != null && list.size() > 1 && list.get(1) != null) {
                notifyMode = 1;
            }
            if (notifyMode == 2) {
                pushNotificationBySystem(context, list, insideNotificationItem, j2, i2);
            } else if (notifyMode == 1) {
                pushNotificationByCustom(context, list, insideNotificationItem, j2);
            }
        }
    }

    public static void pushNotificationByCustom(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j2) {
        Notification notification;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, list, insideNotificationItem, Long.valueOf(j2)}) == null) {
            Resources resources = context.getResources();
            String packageName = context.getPackageName();
            String title = insideNotificationItem.getTitle();
            int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
            int intValue = Integer.valueOf(context.getApplicationInfo().icon).intValue();
            if (Build.VERSION.SDK_INT >= 26) {
                Notification.Builder builder = new Notification.Builder(context, PRIMARY_CHANNEL);
                if (defaultNotifyIcon > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
                    builder.setExtras(bundle);
                }
                notification = builder.build();
            } else {
                notification = new Notification();
            }
            notification.priority = 2;
            notification.flags = 16;
            notification.tickerText = title;
            int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
            if (defaultSmallIconId <= 0) {
                defaultSmallIconId = intValue;
            }
            notification.icon = defaultSmallIconId;
            RemoteViews remoteViews = new RemoteViews(packageName, NotifyUtil.getNotifyLayoutAdapter(context).getNotificationLayout());
            remoteViews.setTextViewText(resources.getIdentifier("notify_title", "id", packageName), title);
            remoteViews.setTextColor(resources.getIdentifier("notify_title", "id", packageName), NotifyUtil.getNotifyLayoutAdapter(context).getTitleColor());
            remoteViews.setTextViewText(resources.getIdentifier("notify_msg", "id", packageName), insideNotificationItem.getContent());
            if (insideNotificationItem.isShowTime()) {
                remoteViews.setTextViewText(resources.getIdentifier("notify_when", "id", packageName), new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date()));
                remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 0);
            } else {
                remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 8);
            }
            int suitIconId = NotifyUtil.getNotifyLayoutAdapter(context).getSuitIconId();
            remoteViews.setViewVisibility(suitIconId, 0);
            if (list != null && !list.isEmpty() && (bitmap = list.get(0)) != null) {
                remoteViews.setImageViewBitmap(suitIconId, bitmap);
            } else {
                if (defaultNotifyIcon <= 0) {
                    defaultNotifyIcon = intValue;
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
            AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
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
            new com.vivo.push.b.r(packageName, j2, insideNotificationItem).b(intent);
            notification.contentIntent = PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), intent, 268435456);
            if (sNotificationManager != null) {
                int r = com.vivo.push.p.a().r();
                if (r == 0) {
                    sNotificationManager.notify(sNotifyId, notification);
                } else if (r == 1) {
                    sNotificationManager.notify((int) j2, notification);
                } else {
                    p.a(TAG, "unknow notify style " + r);
                }
            }
        }
    }

    public static void pushNotificationBySystem(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j2, int i2) {
        Bitmap bitmap;
        Notification.Builder builder;
        Bitmap decodeResource;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, list, insideNotificationItem, Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            String packageName = context.getPackageName();
            String title = insideNotificationItem.getTitle();
            String content = insideNotificationItem.getContent();
            int intValue = Integer.valueOf(context.getApplicationInfo().icon).intValue();
            boolean isShowTime = insideNotificationItem.isShowTime();
            AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
            Bitmap bitmap2 = null;
            if (list == null || list.isEmpty()) {
                bitmap = null;
            } else {
                bitmap = list.get(0);
                if (bitmap != null && defaultNotifyIcon > 0 && (decodeResource = BitmapFactory.decodeResource(context.getResources(), defaultNotifyIcon)) != null) {
                    int width = decodeResource.getWidth();
                    int height = decodeResource.getHeight();
                    decodeResource.recycle();
                    bitmap = b.a(bitmap, width, height);
                }
            }
            if (Build.VERSION.SDK_INT >= 26) {
                builder = new Notification.Builder(context, PRIMARY_CHANNEL);
                if (defaultNotifyIcon > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
                    builder.setExtras(bundle);
                }
                if (bitmap != null) {
                    builder.setLargeIcon(bitmap);
                }
            } else {
                builder = new Notification.Builder(context);
                if (bitmap != null) {
                    builder.setLargeIcon(bitmap);
                } else if (Build.VERSION.SDK_INT <= 22) {
                    builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), intValue));
                }
            }
            int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
            if (defaultSmallIconId > 0) {
                intValue = defaultSmallIconId;
            }
            builder.setSmallIcon(intValue);
            builder.setContentTitle(title);
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
            if (list != null && list.size() > 1) {
                bitmap2 = list.get(1);
            }
            if (i2 != 1 && bitmap2 != null) {
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
            new com.vivo.push.b.r(packageName, j2, insideNotificationItem).b(intent);
            builder.setContentIntent(PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), intent, 268435456));
            Notification build = builder.build();
            int r = com.vivo.push.p.a().r();
            NotificationManager notificationManager = sNotificationManager;
            if (notificationManager != null) {
                if (r == 0) {
                    notificationManager.notify(sNotifyId, build);
                } else if (r == 1) {
                    notificationManager.notify((int) j2, build);
                } else {
                    p.a(TAG, "unknow notify style " + r);
                }
            }
        }
    }

    public static boolean repealNotifyById(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, context, i2)) == null) {
            int r = com.vivo.push.p.a().r();
            if (r != 0) {
                if (r == 1) {
                    return cancelNotify(context, i2);
                }
                p.a(TAG, "unknow cancle notify style " + r);
                return false;
            }
            long b2 = w.b().b("com.vivo.push.notify_key", -1L);
            if (b2 == i2) {
                p.d(TAG, "undo showed message " + i2);
                p.a(context, "回收已展示的通知： " + i2);
                return cancelNotify(context, sNotifyId);
            }
            p.d(TAG, "current showing message id " + b2 + " not match " + i2);
            p.a(context, "与已展示的通知" + b2 + "与待回收的通知" + i2 + "不匹配");
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static void setNotifyId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65546, null, i2) == null) {
            sNotifyId = i2;
        }
    }

    public static void cancelNotify(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            cancelNotify(context, sNotifyId);
        }
    }
}
