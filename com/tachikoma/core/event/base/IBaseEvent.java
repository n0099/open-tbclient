package com.tachikoma.core.event.base;

import java.util.HashMap;
/* loaded from: classes7.dex */
public interface IBaseEvent {
    void configWithData(HashMap<String, Object> hashMap);

    void setState(int i);

    void setType(String str);
}
