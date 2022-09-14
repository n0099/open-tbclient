package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.Cif;
import com.xiaomi.push.eq;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class as {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract eq a(Context context, int i, String str, Map<String, String> map);

    public abstract void a(Cif cif, Map<String, String> map, int i, Notification notification);

    public abstract void a(String str);

    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m617a(Context context, int i, String str, Map<String, String> map);

    public abstract boolean a(Map<String, String> map, int i, Notification notification);
}
