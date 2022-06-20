package com.repackage;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes7.dex */
public interface sg0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final sg0 b = new rg0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable tg0 tg0Var);

    void b(String str, String str2, vg0 vg0Var);

    String[] c();

    boolean d(Context context, String str);
}
