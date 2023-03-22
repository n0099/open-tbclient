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
/* loaded from: classes8.dex */
public class eq extends er {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public PendingIntent f316a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public Bitmap f317b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public CharSequence f318c;

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
        if (m384b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || bitmap.getHeight() < 177 || bitmap.getHeight() > 207) {
                com.xiaomi.channel.commonutils.logger.b.m99a("colorful notification bg image resolution error, must [984*177, 984*207]");
            } else {
                this.f317b = bitmap;
            }
        }
        return this;
    }

    public eq a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (m384b()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f318c = charSequence;
            this.f316a = pendingIntent;
        }
        return this;
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.ep.a(Ljava/lang/String;)I */
    @Override // com.xiaomi.push.ep
    /* renamed from: a */
    public eq mo376a(String str) {
        if (m384b() && !TextUtils.isEmpty(str)) {
            try {
                this.b = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m99a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.er
    /* renamed from: a */
    public String mo381a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.er, com.xiaomi.push.ep
    /* renamed from: a */
    public void mo374a() {
        RemoteViews m380a;
        Bitmap bitmap;
        boolean z;
        RemoteViews m380a2;
        RemoteViews m380a3;
        Drawable a;
        if (!m384b()) {
            m383b();
            return;
        }
        super.mo374a();
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        int a2 = a(resources, "icon", "id", packageName);
        if (((er) this).f319a == null) {
            a(a2);
        } else {
            m380a().setImageViewBitmap(a2, ((er) this).f319a);
        }
        int a3 = a(resources, "title", "id", packageName);
        int a4 = a(resources, "content", "id", packageName);
        m380a().setTextViewText(a3, ((er) this).f321a);
        m380a().setTextViewText(a4, ((er) this).f326b);
        if (!TextUtils.isEmpty(this.f318c)) {
            int a5 = a(resources, "buttonContainer", "id", packageName);
            int a6 = a(resources, NativeConstants.ID_BUTTON, "id", packageName);
            int a7 = a(resources, "buttonBg", "id", packageName);
            m380a().setViewVisibility(a5, 0);
            m380a().setTextViewText(a6, this.f318c);
            m380a().setOnClickPendingIntent(a5, this.f316a);
            if (this.b != 16777216) {
                int a8 = a(70.0f);
                int a9 = a(29.0f);
                m380a().setImageViewBitmap(a7, com.xiaomi.push.service.ak.a(a(this.b, a8, a9, a9 / 2.0f)));
                m380a().setTextColor(a6, m382a(this.b) ? -1 : -16777216);
            }
        }
        int a10 = a(resources, "bg", "id", packageName);
        int a11 = a(resources, "container", "id", packageName);
        if (this.a != 16777216) {
            if (j.a(a()) >= 10) {
                m380a3 = m380a();
                a = a(this.a, 984, 192, 30.0f);
            } else {
                m380a3 = m380a();
                a = a(this.a, 984, 192, 0.0f);
            }
            m380a3.setImageViewBitmap(a10, com.xiaomi.push.service.ak.a(a));
            m380a2 = m380a();
            z = m382a(this.a);
        } else if (this.f317b == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                m380a().setViewVisibility(a2, 8);
                m380a().setViewVisibility(a10, 8);
                try {
                    bj.a((Object) this, "setStyle", s.a(a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m99a("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(m380a());
        } else {
            if (j.a(a()) >= 10) {
                m380a = m380a();
                bitmap = a(this.f317b, 30.0f);
            } else {
                m380a = m380a();
                bitmap = this.f317b;
            }
            m380a.setImageViewBitmap(a10, bitmap);
            Map<String, String> map = ((er) this).f324a;
            if (map != null && this.c == 16777216) {
                c(map.get("notification_image_text_color"));
            }
            int i = this.c;
            z = i == 16777216 || !m382a(i);
            m380a2 = m380a();
        }
        a(m380a2, a11, a3, a4, z);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("miui.customHeight", true);
        addExtras(bundle2);
        setCustomContentView(m380a());
    }

    @Override // com.xiaomi.push.er
    /* renamed from: a */
    public boolean mo375a() {
        if (j.m629a()) {
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            return (a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || a(resources, "content", "id", packageName) == 0) ? false : true;
        }
        return false;
    }

    public eq b(String str) {
        if (m384b() && !TextUtils.isEmpty(str)) {
            try {
                this.a = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m99a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.er
    public String b() {
        return "notification_colorful_copy";
    }

    public eq c(String str) {
        if (m384b() && !TextUtils.isEmpty(str)) {
            try {
                this.c = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m99a("parse colorful notification image text color error");
            }
        }
        return this;
    }
}
