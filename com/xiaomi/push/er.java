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
    public Bitmap f315a;

    /* renamed from: a  reason: collision with other field name */
    public RemoteViews f316a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f317a;

    /* renamed from: a  reason: collision with other field name */
    public String f318a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<Notification.Action> f319a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f320a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f321a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public CharSequence f322b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f323b;

    public er(Context context, int i, String str) {
        super(context);
        this.f319a = new ArrayList<>();
        this.b = 0;
        this.f318a = str;
        this.a = i;
        m468c();
    }

    public er(Context context, String str) {
        this(context, 0, str);
    }

    private Bitmap a() {
        return com.xiaomi.push.service.ak.a(g.m524a(a(), this.f318a));
    }

    private String c() {
        boolean e = e();
        this.f323b = e;
        return e ? b() : mo472a();
    }

    /* renamed from: c  reason: collision with other method in class */
    private void m468c() {
        int a = a(a().getResources(), c(), TtmlNode.TAG_LAYOUT, a().getPackageName());
        if (a == 0) {
            com.xiaomi.channel.commonutils.logger.b.m190a("create RemoteViews failed, no such layout resource was found");
            return;
        }
        this.f316a = new RemoteViews(a().getPackageName(), a);
        this.f321a = mo466a();
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m469c() {
        Map<String, String> map = this.f320a;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    private void d() {
        super.setContentTitle(this.f317a);
        super.setContentText(this.f322b);
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m470d() {
        return (TextUtils.isEmpty(b()) || TextUtils.isEmpty(this.f318a)) ? false : true;
    }

    private boolean e() {
        return m470d() && f();
    }

    private boolean f() {
        List<StatusBarNotification> m797b;
        if (Build.VERSION.SDK_INT >= 20 && (m797b = com.xiaomi.push.service.ax.a(a(), this.f318a).m797b()) != null && !m797b.isEmpty()) {
            for (StatusBarNotification statusBarNotification : m797b) {
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
    public final RemoteViews m471a() {
        return this.f316a;
    }

    @Override // com.xiaomi.push.ep
    public ep a(Map<String, String> map) {
        this.f320a = map;
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
            this.f319a.add(action);
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
        this.f315a = bitmap;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public er setContentTitle(CharSequence charSequence) {
        this.f317a = charSequence;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract String mo472a();

    @Override // com.xiaomi.push.ep
    /* renamed from: a */
    public void mo465a() {
        super.mo465a();
        Bundle bundle = new Bundle();
        if (m470d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f323b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", a(NotificationCompat.CarExtender.EXTRA_LARGE_ICON));
        if (this.f319a.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.f319a.size()];
            this.f319a.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (m469c() || !com.xiaomi.push.service.ay.m799a(a().getContentResolver())) {
            d();
        } else {
            bundle.putCharSequence("mipush.customTitle", this.f317a);
            bundle.putCharSequence("mipush.customContent", this.f322b);
        }
        addExtras(bundle);
    }

    public void a(int i) {
        Bitmap a = a();
        if (a != null) {
            m471a().setImageViewBitmap(i, a);
            return;
        }
        int b = g.b(a(), this.f318a);
        if (b != 0) {
            m471a().setImageViewResource(i, b);
        }
    }

    public void a(int i, Notification.Action action) {
    }

    /* renamed from: a */
    public abstract boolean mo466a();

    /* renamed from: a  reason: collision with other method in class */
    public final boolean m473a(int i) {
        return ((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d) < 192.0d;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: b */
    public er setContentText(CharSequence charSequence) {
        this.f322b = charSequence;
        return this;
    }

    public abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    public final void m474b() {
        super.setContentTitle(this.f317a);
        super.setContentText(this.f322b);
        Bitmap bitmap = this.f315a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public final boolean m475b() {
        return this.f321a;
    }
}
