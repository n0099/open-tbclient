package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.Map;
/* loaded from: classes9.dex */
public class eo extends er {
    public int a;
    public Bitmap b;
    public Bitmap c;

    public eo(Context context, String str) {
        super(context, str);
        this.a = 16777216;
    }

    @Override // com.xiaomi.push.er
    public eo a(Bitmap bitmap) {
        if (m386b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || 184 > bitmap.getHeight() || bitmap.getHeight() > 1678) {
                com.xiaomi.channel.commonutils.logger.b.m101a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            } else {
                this.b = bitmap;
            }
        }
        return this;
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.ep.a(Ljava/lang/String;)I */
    @Override // com.xiaomi.push.ep
    /* renamed from: a */
    public eo mo378a(String str) {
        if (m386b() && !TextUtils.isEmpty(str)) {
            try {
                this.a = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m101a("parse banner notification image text color error");
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.xiaomi.push.er, android.app.Notification.Builder
    /* renamed from: a */
    public er setLargeIcon(Bitmap bitmap) {
        return this;
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.ep.a()Landroid/content/Context; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.ep.a()V */
    @Override // com.xiaomi.push.er
    /* renamed from: a */
    public String mo383a() {
        return "notification_banner";
    }

    @Override // com.xiaomi.push.er, com.xiaomi.push.ep
    /* renamed from: a  reason: collision with other method in class */
    public void mo376a() {
        RemoteViews m382a;
        Bitmap bitmap;
        if (!m386b() || this.b == null) {
            m385b();
            return;
        }
        super.mo376a();
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        int a = a(resources, "bg", "id", packageName);
        if (j.a(a()) >= 10) {
            m382a = m382a();
            bitmap = a(this.b, 30.0f);
        } else {
            m382a = m382a();
            bitmap = this.b;
        }
        m382a.setImageViewBitmap(a, bitmap);
        int a2 = a(resources, "icon", "id", packageName);
        if (this.c != null) {
            m382a().setImageViewBitmap(a2, this.c);
        } else {
            a(a2);
        }
        int a3 = a(resources, "title", "id", packageName);
        m382a().setTextViewText(a3, ((er) this).f321a);
        Map<String, String> map = ((er) this).f324a;
        if (map != null && this.a == 16777216) {
            mo378a(map.get("notification_image_text_color"));
        }
        RemoteViews m382a2 = m382a();
        int i = this.a;
        m382a2.setTextColor(a3, (i == 16777216 || !m384a(i)) ? -1 : -16777216);
        setCustomContentView(m382a());
        Bundle bundle = new Bundle();
        bundle.putBoolean("miui.customHeight", true);
        addExtras(bundle);
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.ep.a()Landroid/content/Context; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.ep.a()V */
    @Override // com.xiaomi.push.er
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo377a() {
        if (j.m631a()) {
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            return (a(a().getResources(), "bg", "id", a().getPackageName()) == 0 || a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || j.a(a()) < 9) ? false : true;
        }
        return false;
    }

    public eo b(Bitmap bitmap) {
        if (m386b() && bitmap != null) {
            this.c = bitmap;
        }
        return this;
    }

    @Override // com.xiaomi.push.er
    public String b() {
        return null;
    }
}
