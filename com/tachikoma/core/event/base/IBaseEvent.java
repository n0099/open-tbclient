package com.tachikoma.core.event.base;

import java.util.HashMap;
/* loaded from: classes8.dex */
public interface IBaseEvent {
    void configWithData(HashMap<String, Object> hashMap);

    void setState(int i);

    void setType(String str);
}
