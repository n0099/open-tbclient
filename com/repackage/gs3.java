package com.repackage;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gs3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65536, null, context, i) == null) {
            ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).cancel(i);
        }
    }

    public static final Bitmap b(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, drawable)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static void c(Context context, int i, String str, String str2, Bitmap bitmap, long j, PendingIntent pendingIntent, String str3, String str4) {
        NotificationCompat.Builder builder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i), str, str2, bitmap, Long.valueOf(j), pendingIntent, str3, str4}) == null) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.createNotificationChannel(new NotificationChannel(String.valueOf(i), "swan_game_center", 4));
                builder = new NotificationCompat.Builder(context, String.valueOf(i));
            } else {
                builder = new NotificationCompat.Builder(context);
            }
            if (!TextUtils.isEmpty(str3)) {
                js3.c("notifyShow", str3, str4);
            }
            if (pendingIntent != null) {
                builder.setContentIntent(pendingIntent);
            }
            NotificationCompat.Builder smallIcon = builder.setContentTitle(str).setContentText(str2).setWhen(j).setSmallIcon(R.drawable.obfuscated_res_0x7f080169);
            if (bitmap == null) {
                bitmap = b(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080169));
            }
            notificationManager.notify(i, smallIcon.setLargeIcon(bitmap).setAutoCancel(true).build());
        }
    }
}
