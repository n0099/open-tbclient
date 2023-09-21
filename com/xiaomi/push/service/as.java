package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.ep;
import com.xiaomi.push.id;
import java.util.Map;
/* loaded from: classes10.dex */
public abstract class as {
    public abstract ep a(Context context, int i, String str, Map<String, String> map);

    public abstract void a(id idVar, Map<String, String> map, int i, Notification notification);

    public abstract void a(String str);

    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m775a(Context context, int i, String str, Map<String, String> map);

    public abstract boolean a(Map<String, String> map, int i, Notification notification);
}
