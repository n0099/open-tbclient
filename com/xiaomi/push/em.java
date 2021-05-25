package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.Map;
/* loaded from: classes7.dex */
public class em extends ep {

    /* renamed from: a  reason: collision with root package name */
    public int f37523a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f37524b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f37525c;

    public em(Context context, String str) {
        super(context, str);
        this.f37523a = 16777216;
    }

    @Override // com.xiaomi.push.ep
    public em a(Bitmap bitmap) {
        if (m282b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || 184 > bitmap.getHeight() || bitmap.getHeight() > 1678) {
                com.xiaomi.channel.commonutils.logger.b.m57a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            } else {
                this.f37524b = bitmap;
            }
        }
        return this;
    }

    public em a(String str) {
        if (m282b() && !TextUtils.isEmpty(str)) {
            try {
                this.f37523a = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m57a("parse banner notification image text color error");
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.xiaomi.push.ep, android.app.Notification.Builder
    /* renamed from: a */
    public ep setLargeIcon(Bitmap bitmap) {
        return this;
    }

    @Override // com.xiaomi.push.en
    public String a() {
        return "notification_banner";
    }

    @Override // com.xiaomi.push.en
    public void a() {
        RemoteViews a2;
        Bitmap bitmap;
        if (!m282b() || this.f37524b == null) {
            m281b();
            return;
        }
        super.a();
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        int a3 = a(resources, "bg", "id", packageName);
        if (l.a(a()) >= 10) {
            a2 = a();
            bitmap = a(this.f37524b, 30.0f);
        } else {
            a2 = a();
            bitmap = this.f37524b;
        }
        a2.setImageViewBitmap(a3, bitmap);
        int a4 = a(resources, "icon", "id", packageName);
        if (this.f37525c != null) {
            a().setImageViewBitmap(a4, this.f37525c);
        } else {
            a(a4);
        }
        int a5 = a(resources, "title", "id", packageName);
        a().setTextViewText(a5, ((ep) this).f324a);
        Map<String, String> map = ((ep) this).f326a;
        if (map != null && this.f37523a == 16777216) {
            a(map.get("notification_image_text_color"));
        }
        RemoteViews a6 = a();
        int i2 = this.f37523a;
        a6.setTextColor(a5, (i2 == 16777216 || !m280a(i2)) ? -1 : -16777216);
        setCustomContentView(a());
        Bundle bundle = new Bundle();
        bundle.putBoolean("miui.customHeight", true);
        addExtras(bundle);
    }

    @Override // com.xiaomi.push.en
    public boolean a() {
        if (l.m523a(a())) {
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            return (a(a().getResources(), "bg", "id", a().getPackageName()) == 0 || a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || l.a(a()) < 9) ? false : true;
        }
        return false;
    }

    public em b(Bitmap bitmap) {
        if (m282b() && bitmap != null) {
            this.f37525c = bitmap;
        }
        return this;
    }

    @Override // com.xiaomi.push.ep
    public String b() {
        return null;
    }
}
