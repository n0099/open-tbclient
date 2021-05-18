package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.en;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class aj {
    public abstract en a(Context context, int i2, String str, Map<String, String> map);

    public abstract void a(Map<String, String> map, int i2, Notification notification);

    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m569a(Context context, int i2, String str, Map<String, String> map);

    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m570a(Map<String, String> map, int i2, Notification notification);
}
