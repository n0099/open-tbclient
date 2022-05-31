package com.repackage;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface z99 {
    public static final ServiceReference a = new ServiceReference("voyager", StatConstants.VALUE_TYPE_UPLOAD);

    void a(String str, String str2, int i, y99 y99Var);

    void b(List<String> list, String str, long j, JSONObject jSONObject);

    void c(String str, String str2, JSONObject jSONObject);

    void d(String str, String str2, y99 y99Var);

    void e(List<String> list, String str, long j, y99 y99Var);
}
