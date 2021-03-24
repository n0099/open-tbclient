package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class ep extends en {

    /* renamed from: a  reason: collision with root package name */
    public int f40452a;

    /* renamed from: a  reason: collision with other field name */
    public Bitmap f322a;

    /* renamed from: a  reason: collision with other field name */
    public RemoteViews f323a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f324a;

    /* renamed from: a  reason: collision with other field name */
    public String f325a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f326a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f327a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f40453b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f328b;

    public ep(Context context, int i, String str) {
        super(context);
        this.f325a = str;
        this.f40452a = i;
        m271c();
    }

    public ep(Context context, String str) {
        super(context);
        this.f325a = str;
        m271c();
    }

    private Bitmap a() {
        return com.xiaomi.push.service.ac.a(g.m318a(a(), this.f325a));
    }

    private String c() {
        boolean e2 = e();
        this.f328b = e2;
        return e2 ? b() : a();
    }

    /* renamed from: c  reason: collision with other method in class */
    private void m271c() {
        int a2 = a(a().getResources(), c(), "layout", a().getPackageName());
        if (a2 == 0) {
            com.xiaomi.channel.commonutils.logger.b.m51a("create RemoteViews failed, no such layout resource was found");
            return;
        }
        this.f323a = new RemoteViews(a().getPackageName(), a2);
        this.f327a = a();
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m272c() {
        Map<String, String> map = this.f326a;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    private void d() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.setContentTitle(this.f324a);
            super.setContentText(this.f40453b);
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m273d() {
        return (TextUtils.isEmpty(b()) || TextUtils.isEmpty(this.f325a)) ? false : true;
    }

    private boolean e() {
        return m273d() && f();
    }

    private boolean f() {
        List<StatusBarNotification> m578b;
        if (Build.VERSION.SDK_INT >= 20 && (m578b = com.xiaomi.push.service.ao.a(a(), this.f325a).m578b()) != null && !m578b.isEmpty()) {
            for (StatusBarNotification statusBarNotification : m578b) {
                if (statusBarNotification.getId() == this.f40452a) {
                    Notification notification = statusBarNotification.getNotification();
                    if (notification == null) {
                        return false;
                    }
                    return !notification.extras.getBoolean("mipush.customCopyLayout", true);
                }
            }
        }
        return false;
    }

    public int a(float f2) {
        return (int) ((f2 * a().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public Bitmap a(Bitmap bitmap, float f2) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    @Override // com.xiaomi.push.en
    public final RemoteViews a() {
        return this.f323a;
    }

    @Override // com.xiaomi.push.en
    public en a(Map<String, String> map) {
        this.f326a = map;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public ep addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public ep addAction(Notification.Action action) {
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public ep setLargeIcon(Bitmap bitmap) {
        this.f322a = bitmap;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public ep setContentTitle(CharSequence charSequence) {
        this.f324a = charSequence;
        return this;
    }

    @Override // com.xiaomi.push.en
    public abstract String a();

    @Override // com.xiaomi.push.en
    public void a() {
        super.m270a();
        Bundle bundle = new Bundle();
        if (m273d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f328b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        addExtras(bundle);
        if (m272c() || !com.xiaomi.push.service.ap.m579a(a().getContentResolver())) {
            d();
        }
    }

    public void a(int i) {
        Bitmap a2 = a();
        if (a2 != null) {
            a().setImageViewBitmap(i, a2);
            return;
        }
        int b2 = g.b(a(), this.f325a);
        if (b2 != 0) {
            a().setImageViewResource(i, b2);
        }
    }

    @Override // com.xiaomi.push.en
    public abstract boolean a();

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m274a(int i) {
        double red = Color.red(i);
        Double.isNaN(red);
        double green = Color.green(i);
        Double.isNaN(green);
        double d2 = (red * 0.299d) + (green * 0.587d);
        double blue = Color.blue(i);
        Double.isNaN(blue);
        return d2 + (blue * 0.114d) < 192.0d;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: b */
    public ep setContentText(CharSequence charSequence) {
        this.f40453b = charSequence;
        return this;
    }

    public abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    public final void m275b() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.setContentTitle(this.f324a);
            super.setContentText(this.f40453b);
            Bitmap bitmap = this.f322a;
            if (bitmap != null) {
                super.setLargeIcon(bitmap);
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m276b() {
        return this.f327a;
    }
}
