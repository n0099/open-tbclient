package com.repackage;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes7.dex */
public interface ug0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final ug0 b = new tg0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable vg0 vg0Var);

    void b(String str, String str2, xg0 xg0Var);

    String[] c();

    boolean d(Context context, String str);
}
