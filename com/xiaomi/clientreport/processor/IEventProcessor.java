package com.xiaomi.clientreport.processor;

import java.util.HashMap;
/* loaded from: classes8.dex */
public interface IEventProcessor extends c, d {
    String bytesToString(byte[] bArr);

    void setEventMap(HashMap hashMap);

    byte[] stringToBytes(String str);
}
