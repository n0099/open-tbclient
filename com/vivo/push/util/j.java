package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import androidx.core.view.ViewCompat;
/* loaded from: classes3.dex */
public final class j implements BaseNotifyLayoutAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Resources f13688a;

    /* renamed from: b  reason: collision with root package name */
    private String f13689b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.f13689b = context.getPackageName();
        this.f13688a = context.getResources();
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.f13688a.getIdentifier("push_notify", "layout", this.f13689b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        return k.g ? this.f13688a.getIdentifier("notify_icon_rom30", "id", this.f13689b) : k.f ? this.f13688a.getIdentifier("notify_icon_rom20", "id", this.f13689b) : this.f13688a.getIdentifier("notify_icon", "id", this.f13689b);
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
            return this.f13688a.getColor(i);
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
