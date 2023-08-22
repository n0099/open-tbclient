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
    public PendingIntent f317a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public Bitmap f318b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public CharSequence f319c;

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
        if (m465b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || bitmap.getHeight() < 177 || bitmap.getHeight() > 207) {
                com.xiaomi.channel.commonutils.logger.b.m180a("colorful notification bg image resolution error, must [984*177, 984*207]");
            } else {
                this.f318b = bitmap;
            }
        }
        return this;
    }

    public eq a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (m465b()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f319c = charSequence;
            this.f317a = pendingIntent;
        }
        return this;
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.ep.a(Ljava/lang/String;)I */
    @Override // com.xiaomi.push.ep
    /* renamed from: a */
    public eq mo457a(String str) {
        if (m465b() && !TextUtils.isEmpty(str)) {
            try {
                this.b = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m180a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.er
    /* renamed from: a */
    public String mo462a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.er, com.xiaomi.push.ep
    /* renamed from: a */
    public void mo455a() {
        RemoteViews m461a;
        Bitmap bitmap;
        boolean z;
        RemoteViews m461a2;
        RemoteViews m461a3;
        Drawable a;
        if (!m465b()) {
            m464b();
            return;
        }
        super.mo455a();
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        int a2 = a(resources, "icon", "id", packageName);
        if (((er) this).f320a == null) {
            a(a2);
        } else {
            m461a().setImageViewBitmap(a2, ((er) this).f320a);
        }
        int a3 = a(resources, "title", "id", packageName);
        int a4 = a(resources, "content", "id", packageName);
        m461a().setTextViewText(a3, ((er) this).f322a);
        m461a().setTextViewText(a4, ((er) this).f327b);
        if (!TextUtils.isEmpty(this.f319c)) {
            int a5 = a(resources, "buttonContainer", "id", packageName);
            int a6 = a(resources, NativeConstants.ID_BUTTON, "id", packageName);
            int a7 = a(resources, "buttonBg", "id", packageName);
            m461a().setViewVisibility(a5, 0);
            m461a().setTextViewText(a6, this.f319c);
            m461a().setOnClickPendingIntent(a5, this.f317a);
            if (this.b != 16777216) {
                int a8 = a(70.0f);
                int a9 = a(29.0f);
                m461a().setImageViewBitmap(a7, com.xiaomi.push.service.ak.a(a(this.b, a8, a9, a9 / 2.0f)));
                m461a().setTextColor(a6, m463a(this.b) ? -1 : -16777216);
            }
        }
        int a10 = a(resources, "bg", "id", packageName);
        int a11 = a(resources, "container", "id", packageName);
        if (this.a != 16777216) {
            if (j.a(a()) >= 10) {
                m461a3 = m461a();
                a = a(this.a, 984, 192, 30.0f);
            } else {
                m461a3 = m461a();
                a = a(this.a, 984, 192, 0.0f);
            }
            m461a3.setImageViewBitmap(a10, com.xiaomi.push.service.ak.a(a));
            m461a2 = m461a();
            z = m463a(this.a);
        } else if (this.f318b == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                m461a().setViewVisibility(a2, 8);
                m461a().setViewVisibility(a10, 8);
                try {
                    bj.a((Object) this, "setStyle", s.a(a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m180a("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(m461a());
        } else {
            if (j.a(a()) >= 10) {
                m461a = m461a();
                bitmap = a(this.f318b, 30.0f);
            } else {
                m461a = m461a();
                bitmap = this.f318b;
            }
            m461a.setImageViewBitmap(a10, bitmap);
            Map<String, String> map = ((er) this).f325a;
            if (map != null && this.c == 16777216) {
                c(map.get("notification_image_text_color"));
            }
            int i = this.c;
            z = i == 16777216 || !m463a(i);
            m461a2 = m461a();
        }
        a(m461a2, a11, a3, a4, z);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("miui.customHeight", true);
        addExtras(bundle2);
        setCustomContentView(m461a());
    }

    @Override // com.xiaomi.push.er
    /* renamed from: a */
    public boolean mo456a() {
        if (j.m710a()) {
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            return (a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || a(resources, "content", "id", packageName) == 0) ? false : true;
        }
        return false;
    }

    public eq b(String str) {
        if (m465b() && !TextUtils.isEmpty(str)) {
            try {
                this.a = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m180a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.er
    public String b() {
        return "notification_colorful_copy";
    }

    public eq c(String str) {
        if (m465b() && !TextUtils.isEmpty(str)) {
            try {
                this.c = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m180a("parse colorful notification image text color error");
            }
        }
        return this;
    }
}
