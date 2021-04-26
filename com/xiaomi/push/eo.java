package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.Map;
/* loaded from: classes7.dex */
public class eo extends ep {

    /* renamed from: a  reason: collision with root package name */
    public int f38353a;

    /* renamed from: a  reason: collision with other field name */
    public PendingIntent f319a;

    /* renamed from: b  reason: collision with root package name */
    public int f38354b;

    /* renamed from: b  reason: collision with other field name */
    public Bitmap f320b;

    /* renamed from: c  reason: collision with root package name */
    public int f38355c;

    /* renamed from: c  reason: collision with other field name */
    public CharSequence f321c;

    public eo(Context context, int i2, String str) {
        super(context, i2, str);
        this.f38353a = 16777216;
        this.f38354b = 16777216;
        this.f38355c = 16777216;
    }

    private Drawable a(int i2, int i3, int i4, float f2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f2, f2, f2, f2, f2, f2, f2, f2}, null, null));
        shapeDrawable.getPaint().setColor(i2);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i3);
        shapeDrawable.setIntrinsicHeight(i4);
        return shapeDrawable;
    }

    private void a(RemoteViews remoteViews, int i2, int i3, int i4, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            int a2 = a(6.0f);
            remoteViews.setViewPadding(i2, a2, 0, a2, 0);
        }
        int i5 = z ? -1 : -16777216;
        remoteViews.setTextColor(i3, i5);
        remoteViews.setTextColor(i4, i5);
    }

    @Override // com.xiaomi.push.ep
    public eo a(Bitmap bitmap) {
        if (m283b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || bitmap.getHeight() < 177 || bitmap.getHeight() > 207) {
                com.xiaomi.channel.commonutils.logger.b.m58a("colorful notification bg image resolution error, must [984*177, 984*207]");
            } else {
                this.f320b = bitmap;
            }
        }
        return this;
    }

    public eo a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (m283b()) {
            this.f321c = charSequence;
            this.f319a = pendingIntent;
        }
        return this;
    }

    public eo a(String str) {
        if (m283b() && !TextUtils.isEmpty(str)) {
            try {
                this.f38354b = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m58a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.en
    public String a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.en
    public void a() {
        RemoteViews a2;
        Bitmap bitmap;
        boolean z;
        RemoteViews a3;
        RemoteViews a4;
        Drawable a5;
        if (!m283b()) {
            m282b();
            return;
        }
        super.a();
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        int a6 = a(resources, "icon", "id", packageName);
        if (((ep) this).f322a == null) {
            a(a6);
        } else {
            a().setImageViewBitmap(a6, ((ep) this).f322a);
        }
        int a7 = a(resources, "title", "id", packageName);
        int a8 = a(resources, "content", "id", packageName);
        a().setTextViewText(a7, ((ep) this).f324a);
        a().setTextViewText(a8, ((ep) this).f38357b);
        if (!TextUtils.isEmpty(this.f321c)) {
            int a9 = a(resources, "buttonContainer", "id", packageName);
            int a10 = a(resources, "button", "id", packageName);
            int a11 = a(resources, "buttonBg", "id", packageName);
            a().setViewVisibility(a9, 0);
            a().setTextViewText(a10, this.f321c);
            a().setOnClickPendingIntent(a9, this.f319a);
            if (this.f38354b != 16777216) {
                int a12 = a(70.0f);
                int a13 = a(29.0f);
                a().setImageViewBitmap(a11, com.xiaomi.push.service.ac.a(a(this.f38354b, a12, a13, a13 / 2.0f)));
                a().setTextColor(a10, m281a(this.f38354b) ? -1 : -16777216);
            }
        }
        int a14 = a(resources, "bg", "id", packageName);
        int a15 = a(resources, "container", "id", packageName);
        if (this.f38353a != 16777216) {
            if (l.a(a()) >= 10) {
                a4 = a();
                a5 = a(this.f38353a, 984, 192, 30.0f);
            } else {
                a4 = a();
                a5 = a(this.f38353a, 984, 192, 0.0f);
            }
            a4.setImageViewBitmap(a14, com.xiaomi.push.service.ac.a(a5));
            a3 = a();
            z = m281a(this.f38353a);
        } else if (this.f320b == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                a().setViewVisibility(a6, 8);
                a().setViewVisibility(a14, 8);
                try {
                    bh.a((Object) this, "setStyle", t.a(a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m58a("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(a());
        } else {
            if (l.a(a()) >= 10) {
                a2 = a();
                bitmap = a(this.f320b, 30.0f);
            } else {
                a2 = a();
                bitmap = this.f320b;
            }
            a2.setImageViewBitmap(a14, bitmap);
            Map<String, String> map = ((ep) this).f326a;
            if (map != null && this.f38355c == 16777216) {
                c(map.get("notification_image_text_color"));
            }
            int i2 = this.f38355c;
            z = i2 == 16777216 || !m281a(i2);
            a3 = a();
        }
        a(a3, a15, a7, a8, z);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("miui.customHeight", true);
        addExtras(bundle2);
        setCustomContentView(a());
    }

    @Override // com.xiaomi.push.en
    public boolean a() {
        if (l.m524a(a())) {
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            return (a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || a(resources, "content", "id", packageName) == 0) ? false : true;
        }
        return false;
    }

    public eo b(String str) {
        if (m283b() && !TextUtils.isEmpty(str)) {
            try {
                this.f38353a = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m58a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.ep
    public String b() {
        return "notification_colorful_copy";
    }

    public eo c(String str) {
        if (m283b() && !TextUtils.isEmpty(str)) {
            try {
                this.f38355c = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m58a("parse colorful notification image text color error");
            }
        }
        return this;
    }
}
