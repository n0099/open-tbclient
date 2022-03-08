package com.tachikoma.core.manager;

import java.util.HashMap;
/* loaded from: classes8.dex */
public interface IProvider<T> {
    void apply(String str, Object obj, HashMap<String, Object> hashMap);

    void clear();

    HashMap<String, String> get();

    void init();

    T of(String str);

    HashMap<String, Object> retrieveEvent(String str, Object obj);
}
