package com.kwad.sdk.emotion.a;

import com.kwad.sdk.emotion.model.EmotionPackage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, EmotionPackage> f6451a = Collections.synchronizedMap(new LinkedHashMap());

    public List<EmotionPackage> a() {
        return new ArrayList(this.f6451a.values());
    }

    public void a(String str, EmotionPackage emotionPackage) {
        this.f6451a.put(str, emotionPackage);
    }
}
