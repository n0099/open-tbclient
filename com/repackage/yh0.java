package com.repackage;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes7.dex */
public interface yh0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final yh0 b = new xh0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable zh0 zh0Var);

    void b(String str, String str2, bi0 bi0Var);

    String[] c();

    boolean d(Context context, String str);
}
