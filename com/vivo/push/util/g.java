package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.view.ViewCompat;
/* loaded from: classes3.dex */
public final class g implements BaseNotifyLayoutAdapter {
    private Resources a;
    private String b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.b = context.getPackageName();
        this.a = context.getResources();
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.a.getIdentifier("push_notify", "layout", this.b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        if (h.g) {
            return this.a.getIdentifier("notify_icon_rom30", "id", this.b);
        }
        if (h.f) {
            return this.a.getIdentifier("notify_icon_rom20", "id", this.b);
        }
        return this.a.getIdentifier("notify_icon", "id", this.b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int i;
        try {
            i = ((Integer) w.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i > 0) {
            return this.a.getColor(i);
        }
        if (h.g) {
            return -1;
        }
        if (h.f) {
            if (h.g) {
                return Color.parseColor("#ff999999");
            }
            return -1;
        }
        return ViewCompat.MEASURED_STATE_MASK;
    }
}
