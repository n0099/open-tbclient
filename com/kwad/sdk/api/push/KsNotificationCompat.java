package com.kwad.sdk.api.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.KsAdSdkApi;
@KsAdSdkApi
@Keep
/* loaded from: classes10.dex */
public class KsNotificationCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @KsAdSdkApi
    @Keep
    /* loaded from: classes10.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final NotificationCompat.Builder mBuilder;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @KsAdSdkApi
        @Keep
        public Builder(Context context) {
            this(context, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Context) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public Builder(@NonNull Context context, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mBuilder = new NotificationCompat.Builder(context, str);
        }

        @KsAdSdkApi
        @Keep
        public Builder addAction(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, charSequence, pendingIntent)) == null) {
                this.mBuilder.addAction(i2, charSequence, pendingIntent);
                return this;
            }
            return (Builder) invokeILL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder addExtras(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
                this.mBuilder.addExtras(bundle);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder addPerson(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.mBuilder.addPerson(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Notification build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mBuilder.build() : (Notification) invokeV.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Bundle getExtras() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBuilder.getExtras() : (Bundle) invokeV.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Notification getNotification() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? build() : (Notification) invokeV.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setAutoCancel(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.mBuilder.setAutoCancel(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setBadgeIconType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.mBuilder.setBadgeIconType(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setCategory(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.mBuilder.setCategory(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setChannelId(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.mBuilder.setChannelId(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setColor(@ColorInt int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.mBuilder.setColor(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setColorized(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.mBuilder.setColorized(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setContent(RemoteViews remoteViews) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, remoteViews)) == null) {
                this.mBuilder.setContent(remoteViews);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setContentInfo(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, charSequence)) == null) {
                this.mBuilder.setContentInfo(charSequence);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setContentIntent(PendingIntent pendingIntent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, pendingIntent)) == null) {
                this.mBuilder.setContentIntent(pendingIntent);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setContentText(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, charSequence)) == null) {
                this.mBuilder.setContentText(charSequence);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setContentTitle(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, charSequence)) == null) {
                this.mBuilder.setContentTitle(charSequence);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setCustomBigContentView(RemoteViews remoteViews) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, remoteViews)) == null) {
                this.mBuilder.setCustomBigContentView(remoteViews);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setCustomContentView(RemoteViews remoteViews) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, remoteViews)) == null) {
                this.mBuilder.setCustomContentView(remoteViews);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, remoteViews)) == null) {
                this.mBuilder.setCustomHeadsUpContentView(remoteViews);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setDefaults(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
                this.mBuilder.setDefaults(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, pendingIntent)) == null) {
                this.mBuilder.setDeleteIntent(pendingIntent);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setExtras(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, bundle)) == null) {
                this.mBuilder.setExtras(bundle);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048599, this, pendingIntent, z)) == null) {
                this.mBuilder.setFullScreenIntent(pendingIntent, z);
                return this;
            }
            return (Builder) invokeLZ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setGroup(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
                this.mBuilder.setGroup(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setGroupAlertBehavior(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
                this.mBuilder.setGroupAlertBehavior(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setGroupSummary(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048602, this, z)) == null) {
                this.mBuilder.setGroupSummary(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setLargeIcon(Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, bitmap)) == null) {
                this.mBuilder.setLargeIcon(bitmap);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setLights(@ColorInt int i2, int i3, int i4) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIII = interceptable.invokeIII(1048604, this, i2, i3, i4)) == null) {
                this.mBuilder.setLights(i2, i3, i4);
                return this;
            }
            return (Builder) invokeIII.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setLocalOnly(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048605, this, z)) == null) {
                this.mBuilder.setLocalOnly(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setNumber(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
                this.mBuilder.setNumber(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setOngoing(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048607, this, z)) == null) {
                this.mBuilder.setOngoing(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setOnlyAlertOnce(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048608, this, z)) == null) {
                this.mBuilder.setOnlyAlertOnce(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setPriority(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
                this.mBuilder.setPriority(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setProgress(int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                this.mBuilder.setProgress(i2, i3, z);
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setPublicVersion(Notification notification) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, notification)) == null) {
                this.mBuilder.setPublicVersion(notification);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setRemoteInputHistory(CharSequence[] charSequenceArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, charSequenceArr)) == null) {
                this.mBuilder.setRemoteInputHistory(charSequenceArr);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setShortcutId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
                this.mBuilder.setShortcutId(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setShowWhen(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048614, this, z)) == null) {
                this.mBuilder.setShowWhen(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setSmallIcon(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) {
                this.mBuilder.setSmallIcon(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setSmallIcon(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048616, this, i2, i3)) == null) {
                this.mBuilder.setSmallIcon(i2, i3);
                return this;
            }
            return (Builder) invokeII.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setSortKey(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) {
                this.mBuilder.setSortKey(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setSound(Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, uri)) == null) {
                this.mBuilder.setSound(uri);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setSound(Uri uri, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048619, this, uri, i2)) == null) {
                this.mBuilder.setSound(uri, i2);
                return this;
            }
            return (Builder) invokeLI.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setSubText(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, charSequence)) == null) {
                this.mBuilder.setSubText(charSequence);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setTicker(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, charSequence)) == null) {
                this.mBuilder.setTicker(charSequence);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048622, this, charSequence, remoteViews)) == null) {
                this.mBuilder.setTicker(charSequence, remoteViews);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setTimeoutAfter(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048623, this, j2)) == null) {
                this.mBuilder.setTimeoutAfter(j2);
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setUsesChronometer(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048624, this, z)) == null) {
                this.mBuilder.setUsesChronometer(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setVibrate(long[] jArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, jArr)) == null) {
                this.mBuilder.setVibrate(jArr);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setVisibility(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i2)) == null) {
                this.mBuilder.setVisibility(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @KsAdSdkApi
        @Keep
        public Builder setWhen(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048627, this, j2)) == null) {
                this.mBuilder.setWhen(j2);
                return this;
            }
            return (Builder) invokeJ.objValue;
        }
    }

    public KsNotificationCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
