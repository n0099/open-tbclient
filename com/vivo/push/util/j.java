package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
/* loaded from: classes7.dex */
public final class j implements BaseNotifyLayoutAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Resources f39835a;

    /* renamed from: b  reason: collision with root package name */
    public String f39836b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.f39835a.getIdentifier("push_notify", "layout", this.f39836b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        Resources resources;
        String str;
        String str2;
        if (k.f39843g) {
            resources = this.f39835a;
            str = this.f39836b;
            str2 = "notify_icon_rom30";
        } else if (k.f39842f) {
            resources = this.f39835a;
            str = this.f39836b;
            str2 = "notify_icon_rom20";
        } else {
            resources = this.f39835a;
            str = this.f39836b;
            str2 = "notify_icon";
        }
        return resources.getIdentifier(str2, "id", str);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int i;
        try {
            i = ((Integer) z.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            i = 0;
        }
        if (i > 0) {
            return this.f39835a.getColor(i);
        }
        if (k.f39843g) {
            return -1;
        }
        if (k.f39842f) {
            if (k.f39843g) {
                return Color.parseColor("#ff999999");
            }
            return -1;
        }
        return -16777216;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.f39836b = context.getPackageName();
        this.f39835a = context.getResources();
    }
}
