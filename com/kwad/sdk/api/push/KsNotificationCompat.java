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
import com.kwad.sdk.api.core.KsAdSdkApi;
@KsAdSdkApi
@Keep
/* loaded from: classes7.dex */
public class KsNotificationCompat {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes7.dex */
    public static final class Builder {
        public NotificationCompat.Builder mBuilder;

        @KsAdSdkApi
        @Keep
        public Builder(Context context) {
            this(context, null);
        }

        public Builder(@NonNull Context context, @NonNull String str) {
            try {
                this.mBuilder = new NotificationCompat.Builder(context, str);
            } catch (Throwable unused) {
                this.mBuilder = new NotificationCompat.Builder(context);
            }
        }

        @KsAdSdkApi
        @Keep
        public Builder addAction(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mBuilder.addAction(i2, charSequence, pendingIntent);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder addExtras(Bundle bundle) {
            this.mBuilder.addExtras(bundle);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder addPerson(String str) {
            this.mBuilder.addPerson(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Notification build() {
            return this.mBuilder.build();
        }

        @KsAdSdkApi
        @Keep
        public Bundle getExtras() {
            return this.mBuilder.getExtras();
        }

        @KsAdSdkApi
        @Keep
        public Notification getNotification() {
            return build();
        }

        @KsAdSdkApi
        @Keep
        public Builder setAutoCancel(boolean z) {
            this.mBuilder.setAutoCancel(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setBadgeIconType(int i2) {
            this.mBuilder.setBadgeIconType(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setCategory(String str) {
            this.mBuilder.setCategory(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setChannelId(@NonNull String str) {
            this.mBuilder.setChannelId(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setColor(@ColorInt int i2) {
            this.mBuilder.setColor(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setColorized(boolean z) {
            this.mBuilder.setColorized(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setContent(RemoteViews remoteViews) {
            this.mBuilder.setContent(remoteViews);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setContentInfo(CharSequence charSequence) {
            this.mBuilder.setContentInfo(charSequence);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setContentIntent(PendingIntent pendingIntent) {
            this.mBuilder.setContentIntent(pendingIntent);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setContentText(CharSequence charSequence) {
            this.mBuilder.setContentText(charSequence);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setContentTitle(CharSequence charSequence) {
            this.mBuilder.setContentTitle(charSequence);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setCustomBigContentView(RemoteViews remoteViews) {
            this.mBuilder.setCustomBigContentView(remoteViews);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setCustomContentView(RemoteViews remoteViews) {
            this.mBuilder.setCustomContentView(remoteViews);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
            this.mBuilder.setCustomHeadsUpContentView(remoteViews);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setDefaults(int i2) {
            this.mBuilder.setDefaults(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.mBuilder.setDeleteIntent(pendingIntent);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setExtras(Bundle bundle) {
            this.mBuilder.setExtras(bundle);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            this.mBuilder.setFullScreenIntent(pendingIntent, z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setGroup(String str) {
            this.mBuilder.setGroup(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setGroupAlertBehavior(int i2) {
            this.mBuilder.setGroupAlertBehavior(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setGroupSummary(boolean z) {
            this.mBuilder.setGroupSummary(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setLargeIcon(Bitmap bitmap) {
            this.mBuilder.setLargeIcon(bitmap);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setLights(@ColorInt int i2, int i3, int i4) {
            this.mBuilder.setLights(i2, i3, i4);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setLocalOnly(boolean z) {
            this.mBuilder.setLocalOnly(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setNumber(int i2) {
            this.mBuilder.setNumber(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setOngoing(boolean z) {
            this.mBuilder.setOngoing(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setOnlyAlertOnce(boolean z) {
            this.mBuilder.setOnlyAlertOnce(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setPriority(int i2) {
            this.mBuilder.setPriority(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setProgress(int i2, int i3, boolean z) {
            this.mBuilder.setProgress(i2, i3, z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setPublicVersion(Notification notification) {
            this.mBuilder.setPublicVersion(notification);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setRemoteInputHistory(CharSequence[] charSequenceArr) {
            this.mBuilder.setRemoteInputHistory(charSequenceArr);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setShortcutId(String str) {
            this.mBuilder.setShortcutId(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setShowWhen(boolean z) {
            this.mBuilder.setShowWhen(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setSmallIcon(int i2) {
            this.mBuilder.setSmallIcon(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setSmallIcon(int i2, int i3) {
            this.mBuilder.setSmallIcon(i2, i3);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setSortKey(String str) {
            this.mBuilder.setSortKey(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setSound(Uri uri) {
            this.mBuilder.setSound(uri);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setSound(Uri uri, int i2) {
            this.mBuilder.setSound(uri, i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setSubText(CharSequence charSequence) {
            this.mBuilder.setSubText(charSequence);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setTicker(CharSequence charSequence) {
            this.mBuilder.setTicker(charSequence);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            this.mBuilder.setTicker(charSequence, remoteViews);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setTimeoutAfter(long j2) {
            this.mBuilder.setTimeoutAfter(j2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setUsesChronometer(boolean z) {
            this.mBuilder.setUsesChronometer(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setVibrate(long[] jArr) {
            this.mBuilder.setVibrate(jArr);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setVisibility(int i2) {
            this.mBuilder.setVisibility(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setWhen(long j2) {
            this.mBuilder.setWhen(j2);
            return this;
        }
    }
}
