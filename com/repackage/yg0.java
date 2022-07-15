package com.repackage;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes7.dex */
public interface yg0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final yg0 b = new xg0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable zg0 zg0Var);

    void b(String str, String str2, bh0 bh0Var);

    String[] c();

    boolean d(Context context, String str);
}
