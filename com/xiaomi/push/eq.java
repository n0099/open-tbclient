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
import com.baidu.searchbox.crius.constants.NativeConstants;
import java.util.Map;
/* loaded from: classes10.dex */
public class eq extends er {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public PendingIntent f312a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public Bitmap f313b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public CharSequence f314c;

    public eq(Context context, int i, String str) {
        super(context, i, str);
        this.a = 16777216;
        this.b = 16777216;
        this.c = 16777216;
    }

    private Drawable a(int i, int i2, int i3, float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i2);
        shapeDrawable.setIntrinsicHeight(i3);
        return shapeDrawable;
    }

    private void a(RemoteViews remoteViews, int i, int i2, int i3, boolean z) {
        int a = a(6.0f);
        remoteViews.setViewPadding(i, a, 0, a, 0);
        int i4 = z ? -1 : -16777216;
        remoteViews.setTextColor(i2, i4);
        remoteViews.setTextColor(i3, i4);
    }

    @Override // com.xiaomi.push.er
    public eq a(Bitmap bitmap) {
        if (m475b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || bitmap.getHeight() < 177 || bitmap.getHeight() > 207) {
                com.xiaomi.channel.commonutils.logger.b.m190a("colorful notification bg image resolution error, must [984*177, 984*207]");
            } else {
                this.f313b = bitmap;
            }
        }
        return this;
    }

    public eq a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (m475b()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f314c = charSequence;
            this.f312a = pendingIntent;
        }
        return this;
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.ep.a(Ljava/lang/String;)I */
    @Override // com.xiaomi.push.ep
    /* renamed from: a */
    public eq mo467a(String str) {
        if (m475b() && !TextUtils.isEmpty(str)) {
            try {
                this.b = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m190a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.er
    /* renamed from: a */
    public String mo472a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.er, com.xiaomi.push.ep
    /* renamed from: a */
    public void mo465a() {
        RemoteViews m471a;
        Bitmap bitmap;
        boolean z;
        RemoteViews m471a2;
        RemoteViews m471a3;
        Drawable a;
        if (!m475b()) {
            m474b();
            return;
        }
        super.mo465a();
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        int a2 = a(resources, "icon", "id", packageName);
        if (((er) this).f315a == null) {
            a(a2);
        } else {
            m471a().setImageViewBitmap(a2, ((er) this).f315a);
        }
        int a3 = a(resources, "title", "id", packageName);
        int a4 = a(resources, "content", "id", packageName);
        m471a().setTextViewText(a3, ((er) this).f317a);
        m471a().setTextViewText(a4, ((er) this).f322b);
        if (!TextUtils.isEmpty(this.f314c)) {
            int a5 = a(resources, "buttonContainer", "id", packageName);
            int a6 = a(resources, NativeConstants.ID_BUTTON, "id", packageName);
            int a7 = a(resources, "buttonBg", "id", packageName);
            m471a().setViewVisibility(a5, 0);
            m471a().setTextViewText(a6, this.f314c);
            m471a().setOnClickPendingIntent(a5, this.f312a);
            if (this.b != 16777216) {
                int a8 = a(70.0f);
                int a9 = a(29.0f);
                m471a().setImageViewBitmap(a7, com.xiaomi.push.service.ak.a(a(this.b, a8, a9, a9 / 2.0f)));
                m471a().setTextColor(a6, m473a(this.b) ? -1 : -16777216);
            }
        }
        int a10 = a(resources, "bg", "id", packageName);
        int a11 = a(resources, "container", "id", packageName);
        if (this.a != 16777216) {
            if (j.a(a()) >= 10) {
                m471a3 = m471a();
                a = a(this.a, 984, 192, 30.0f);
            } else {
                m471a3 = m471a();
                a = a(this.a, 984, 192, 0.0f);
            }
            m471a3.setImageViewBitmap(a10, com.xiaomi.push.service.ak.a(a));
            m471a2 = m471a();
            z = m473a(this.a);
        } else if (this.f313b == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                m471a().setViewVisibility(a2, 8);
                m471a().setViewVisibility(a10, 8);
                try {
                    bj.a((Object) this, "setStyle", s.a(a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m190a("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(m471a());
        } else {
            if (j.a(a()) >= 10) {
                m471a = m471a();
                bitmap = a(this.f313b, 30.0f);
            } else {
                m471a = m471a();
                bitmap = this.f313b;
            }
            m471a.setImageViewBitmap(a10, bitmap);
            Map<String, String> map = ((er) this).f320a;
            if (map != null && this.c == 16777216) {
                c(map.get("notification_image_text_color"));
            }
            int i = this.c;
            z = i == 16777216 || !m473a(i);
            m471a2 = m471a();
        }
        a(m471a2, a11, a3, a4, z);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("miui.customHeight", true);
        addExtras(bundle2);
        setCustomContentView(m471a());
    }

    @Override // com.xiaomi.push.er
    /* renamed from: a */
    public boolean mo466a() {
        if (j.m720a()) {
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            return (a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || a(resources, "content", "id", packageName) == 0) ? false : true;
        }
        return false;
    }

    public eq b(String str) {
        if (m475b() && !TextUtils.isEmpty(str)) {
            try {
                this.a = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m190a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.er
    public String b() {
        return "notification_colorful_copy";
    }

    public eq c(String str) {
        if (m475b() && !TextUtils.isEmpty(str)) {
            try {
                this.c = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m190a("parse colorful notification image text color error");
            }
        }
        return this;
    }
}
