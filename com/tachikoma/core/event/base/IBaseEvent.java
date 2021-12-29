package com.tachikoma.core.event.base;

import java.util.HashMap;
/* loaded from: classes4.dex */
public interface IBaseEvent {
    void configWithData(HashMap<String, Object> hashMap);

    void setState(int i2);

    void setType(String str);
}
