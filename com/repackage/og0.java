package com.repackage;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes6.dex */
public interface og0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final og0 b = new ng0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable pg0 pg0Var);

    void b(String str, String str2, rg0 rg0Var);

    String[] c();

    boolean d(Context context, String str);
}
