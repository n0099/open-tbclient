package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
/* loaded from: classes7.dex */
public final class j implements BaseNotifyLayoutAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Resources f36708a;

    /* renamed from: b  reason: collision with root package name */
    public String f36709b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.f36708a.getIdentifier("push_notify", "layout", this.f36709b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        Resources resources;
        String str;
        String str2;
        if (k.f36716g) {
            resources = this.f36708a;
            str = this.f36709b;
            str2 = "notify_icon_rom30";
        } else if (k.f36715f) {
            resources = this.f36708a;
            str = this.f36709b;
            str2 = "notify_icon_rom20";
        } else {
            resources = this.f36708a;
            str = this.f36709b;
            str2 = "notify_icon";
        }
        return resources.getIdentifier(str2, "id", str);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int i2;
        try {
            i2 = ((Integer) z.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        if (i2 > 0) {
            return this.f36708a.getColor(i2);
        }
        if (k.f36716g) {
            return -1;
        }
        if (k.f36715f) {
            if (k.f36716g) {
                return Color.parseColor("#ff999999");
            }
            return -1;
        }
        return -16777216;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.f36709b = context.getPackageName();
        this.f36708a = context.getResources();
    }
}
