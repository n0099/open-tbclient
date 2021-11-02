package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.en;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class aj {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract en a(Context context, int i2, String str, Map<String, String> map);

    public abstract void a(Map<String, String> map, int i2, Notification notification);

    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m585a(Context context, int i2, String str, Map<String, String> map);

    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m586a(Map<String, String> map, int i2, Notification notification);
}
