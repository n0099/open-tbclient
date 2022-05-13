package com.repackage;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes5.dex */
public interface bi0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final bi0 b = new ai0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable ci0 ci0Var);

    void b(String str, String str2, ei0 ei0Var);

    String[] c();

    boolean d(Context context, String str);
}
