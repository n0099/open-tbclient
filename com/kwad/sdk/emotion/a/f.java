package com.kwad.sdk.emotion.a;

import com.kwad.sdk.emotion.model.EmotionPackage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, EmotionPackage> f35328a = Collections.synchronizedMap(new LinkedHashMap());

    public List<EmotionPackage> a() {
        return new ArrayList(this.f35328a.values());
    }

    public void a(String str, EmotionPackage emotionPackage) {
        this.f35328a.put(str, emotionPackage);
    }
}
