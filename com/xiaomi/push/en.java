package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.Map;
@SuppressLint({"NewApi"})
/* loaded from: classes7.dex */
public class en extends Notification.Builder {

    /* renamed from: a  reason: collision with root package name */
    public Context f40449a;

    public en(Context context) {
        super(context);
        this.f40449a = context;
    }

    public int a(Resources resources, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return resources.getIdentifier(str, str2, str3);
    }

    public Context a() {
        return this.f40449a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public en addExtras(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 20) {
            super.addExtras(bundle);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public en setCustomContentView(RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.setCustomContentView(remoteViews);
        } else {
            super.setContent(remoteViews);
        }
        return this;
    }

    public en a(Map<String, String> map) {
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m270a() {
    }

    @Override // android.app.Notification.Builder
    public Notification build() {
        m270a();
        return super.build();
    }
}
