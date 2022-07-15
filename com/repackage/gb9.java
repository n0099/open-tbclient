package com.repackage;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface gb9 {
    public static final ServiceReference a = new ServiceReference("voyager", StatConstants.VALUE_TYPE_UPLOAD);

    void a(String str, String str2, int i, fb9 fb9Var);

    void b(List<String> list, String str, long j, JSONObject jSONObject);

    void c(String str, String str2, JSONObject jSONObject);

    void d(String str, String str2, fb9 fb9Var);

    void e(List<String> list, String str, long j, fb9 fb9Var);
}
