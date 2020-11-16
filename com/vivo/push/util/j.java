package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.view.ViewCompat;
/* loaded from: classes11.dex */
public final class j implements BaseNotifyLayoutAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Resources f4702a;
    private String b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.b = context.getPackageName();
        this.f4702a = context.getResources();
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.f4702a.getIdentifier("push_notify", "layout", this.b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        return k.g ? this.f4702a.getIdentifier("notify_icon_rom30", "id", this.b) : k.f ? this.f4702a.getIdentifier("notify_icon_rom20", "id", this.b) : this.f4702a.getIdentifier("notify_icon", "id", this.b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int i;
        try {
            i = ((Integer) z.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i > 0) {
            return this.f4702a.getColor(i);
        }
        if (k.g) {
            return -1;
        }
        if (k.f) {
            if (k.g) {
                return Color.parseColor("#ff999999");
            }
            return -1;
        }
        return ViewCompat.MEASURED_STATE_MASK;
    }
}
