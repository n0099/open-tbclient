package com.xiaomi.miui.pushads.sdk;

import android.app.PendingIntent;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RemoteViews;
/* loaded from: classes3.dex */
class NotificationBaseRemoteView extends RemoteViews {
    protected Context a;

    public NotificationBaseRemoteView(Context context) {
        super(context.getPackageName(), context.getResources().getIdentifier("notification_base_layout", "layout", context.getPackageName()));
        this.a = context;
    }

    public NotificationBaseRemoteView(String str, int i) {
        super(str, i);
    }

    public void a(int i) {
        setImageViewResource(16908294, i);
    }

    public void a(String str, PendingIntent pendingIntent) {
        if (str != null) {
            str = str.trim();
        }
        int identifier = this.a.getResources().getIdentifier("action_button", "id", this.a.getPackageName());
        if (TextUtils.isEmpty(str)) {
            setViewVisibility(identifier, 8);
            return;
        }
        setTextViewText(identifier, str);
        if (pendingIntent != null) {
            setOnClickPendingIntent(identifier, pendingIntent);
        }
        setViewVisibility(identifier, 0);
    }

    public void a(String str, String str2) {
        String trim = str != null ? str.trim() : str;
        if (str2 != null) {
            str2 = str2.trim();
        }
        if (TextUtils.isEmpty(trim) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (TextUtils.isEmpty(trim)) {
            trim = str2;
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            int identifier = this.a.getResources().getIdentifier("sub_title", "id", this.a.getPackageName());
            setTextViewText(identifier, str2);
            setViewVisibility(identifier, 0);
        }
        setTextViewText(this.a.getResources().getIdentifier("title", "id", this.a.getPackageName()), trim);
    }
}
