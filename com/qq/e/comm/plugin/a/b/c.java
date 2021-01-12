package com.qq.e.comm.plugin.a.b;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import com.qq.e.comm.util.GDTLogger;
/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public abstract class c {

    /* loaded from: classes3.dex */
    private static class a extends c {

        /* renamed from: a  reason: collision with root package name */
        private Notification.Builder f11602a;

        private a(Context context) {
            this.f11602a = new Notification.Builder(context);
            com.qq.e.comm.plugin.d.d.a(context, this.f11602a);
            this.f11602a.setSmallIcon(17301634);
        }

        @Override // com.qq.e.comm.plugin.a.b.c
        public Notification a() {
            try {
                return this.f11602a.build();
            } catch (Throwable th) {
                return this.f11602a.getNotification();
            }
        }

        @Override // com.qq.e.comm.plugin.a.b.c
        public c a(int i, int i2, boolean z) {
            this.f11602a.setProgress(i, i2, z);
            return this;
        }

        @Override // com.qq.e.comm.plugin.a.b.c
        public c a(PendingIntent pendingIntent) {
            this.f11602a.setContentIntent(pendingIntent);
            return this;
        }

        @Override // com.qq.e.comm.plugin.a.b.c
        public c a(Bitmap bitmap) {
            this.f11602a.setLargeIcon(bitmap);
            return this;
        }

        @Override // com.qq.e.comm.plugin.a.b.c
        public c a(String str) {
            this.f11602a.setContentTitle(str);
            return this;
        }

        @Override // com.qq.e.comm.plugin.a.b.c
        public c a(boolean z) {
            this.f11602a.setAutoCancel(z);
            return this;
        }

        @Override // com.qq.e.comm.plugin.a.b.c
        public c b(String str) {
            this.f11602a.setContentText(str);
            return this;
        }
    }

    c() {
    }

    public static c a(Context context) {
        a aVar;
        try {
            aVar = new a(context);
        } catch (Throwable th) {
            aVar = null;
        }
        if (aVar == null) {
            GDTLogger.report("Fail to init NotificationBuilder");
        }
        return aVar;
    }

    public abstract Notification a();

    public abstract c a(int i, int i2, boolean z);

    public abstract c a(PendingIntent pendingIntent);

    public abstract c a(Bitmap bitmap);

    public abstract c a(String str);

    public abstract c a(boolean z);

    public abstract c b(String str);
}
