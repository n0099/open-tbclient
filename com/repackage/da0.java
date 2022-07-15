package com.repackage;

import com.baidu.searchbox.live.interfaces.net.NetResponse;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public interface da0<T> {
    void a(NetResponse netResponse, T t, Map<String, String> map, List<String> list);

    T onParseResponseInBackground(NetResponse netResponse);
}
