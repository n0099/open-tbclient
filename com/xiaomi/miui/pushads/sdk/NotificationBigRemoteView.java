package com.xiaomi.miui.pushads.sdk;

import android.content.Context;
import android.graphics.Bitmap;
/* loaded from: classes3.dex */
class NotificationBigRemoteView extends NotificationBaseRemoteView {
    public NotificationBigRemoteView(Context context) {
        super(context.getPackageName(), context.getResources().getIdentifier("notification_big_picture_layout", "layout", context.getPackageName()));
        this.a = context;
    }

    public void a(Bitmap bitmap) {
        setImageViewBitmap(this.a.getResources().getIdentifier("big_picture", "id", this.a.getPackageName()), bitmap);
    }
}
