package com.xiaomi.push.service;

import com.xiaomi.push.hu;
import java.util.Map;
/* loaded from: classes10.dex */
public class br {
    public static hu a(hu huVar) {
        Map<String, String> map;
        if (huVar != null && (map = huVar.f543b) != null) {
            map.remove("score_info");
        }
        return huVar;
    }
}
