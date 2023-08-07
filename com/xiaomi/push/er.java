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
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public abstract class er extends ep {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public Bitmap f319a;

    /* renamed from: a  reason: collision with other field name */
    public RemoteViews f320a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f321a;

    /* renamed from: a  reason: collision with other field name */
    public String f322a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<Notification.Action> f323a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f324a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f325a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public CharSequence f326b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f327b;

    public er(Context context, int i, String str) {
        super(context);
        this.f323a = new ArrayList<>();
        this.b = 0;
        this.f322a = str;
        this.a = i;
        m456c();
    }

    public er(Context context, String str) {
        this(context, 0, str);
    }

    private Bitmap a() {
        return com.xiaomi.push.service.ak.a(g.m512a(a(), this.f322a));
    }

    private String c() {
        boolean e = e();
        this.f327b = e;
        return e ? b() : mo460a();
    }

    /* renamed from: c  reason: collision with other method in class */
    private void m456c() {
        int a = a(a().getResources(), c(), TtmlNode.TAG_LAYOUT, a().getPackageName());
        if (a == 0) {
            com.xiaomi.channel.commonutils.logger.b.m178a("create RemoteViews failed, no such layout resource was found");
            return;
        }
        this.f320a = new RemoteViews(a().getPackageName(), a);
        this.f325a = mo454a();
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m457c() {
        Map<String, String> map = this.f324a;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    private void d() {
        super.setContentTitle(this.f321a);
        super.setContentText(this.f326b);
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m458d() {
        return (TextUtils.isEmpty(b()) || TextUtils.isEmpty(this.f322a)) ? false : true;
    }

    private boolean e() {
        return m458d() && f();
    }

    private boolean f() {
        List<StatusBarNotification> m785b;
        if (Build.VERSION.SDK_INT >= 20 && (m785b = com.xiaomi.push.service.ax.a(a(), this.f322a).m785b()) != null && !m785b.isEmpty()) {
            for (StatusBarNotification statusBarNotification : m785b) {
                if (statusBarNotification.getId() == this.a) {
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

    public int a(float f) {
        return (int) ((f * a().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public Bitmap a(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.ep.a()Landroid/content/Context; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.ep.a()V */
    /* renamed from: a  reason: collision with other method in class */
    public final RemoteViews m459a() {
        return this.f320a;
    }

    @Override // com.xiaomi.push.ep
    public ep a(Map<String, String> map) {
        this.f324a = map;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public er addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        addAction(new Notification.Action(i, charSequence, pendingIntent));
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public er addAction(Notification.Action action) {
        if (action != null) {
            this.f323a.add(action);
        }
        int i = this.b;
        this.b = i + 1;
        a(i, action);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public er setLargeIcon(Bitmap bitmap) {
        this.f319a = bitmap;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public er setContentTitle(CharSequence charSequence) {
        this.f321a = charSequence;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract String mo460a();

    @Override // com.xiaomi.push.ep
    /* renamed from: a */
    public void mo453a() {
        super.mo453a();
        Bundle bundle = new Bundle();
        if (m458d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f327b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", a(NotificationCompat.CarExtender.EXTRA_LARGE_ICON));
        if (this.f323a.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.f323a.size()];
            this.f323a.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (m457c() || !com.xiaomi.push.service.ay.m787a(a().getContentResolver())) {
            d();
        } else {
            bundle.putCharSequence("mipush.customTitle", this.f321a);
            bundle.putCharSequence("mipush.customContent", this.f326b);
        }
        addExtras(bundle);
    }

    public void a(int i) {
        Bitmap a = a();
        if (a != null) {
            m459a().setImageViewBitmap(i, a);
            return;
        }
        int b = g.b(a(), this.f322a);
        if (b != 0) {
            m459a().setImageViewResource(i, b);
        }
    }

    public void a(int i, Notification.Action action) {
    }

    /* renamed from: a */
    public abstract boolean mo454a();

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m461a(int i) {
        return ((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d) < 192.0d;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: b */
    public er setContentText(CharSequence charSequence) {
        this.f326b = charSequence;
        return this;
    }

    public abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    public final void m462b() {
        super.setContentTitle(this.f321a);
        super.setContentText(this.f326b);
        Bitmap bitmap = this.f319a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m463b() {
        return this.f325a;
    }
}
