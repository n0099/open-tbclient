package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public interface am {
    void M(String str, String str2, boolean z);

    boolean Yt(String str);

    void a(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar, Throwable th, @Nullable Map<String, String> map);

    void a(String str, String str2, Throwable th, @Nullable Map<String, String> map);

    void aV(String str, String str2, String str3);

    void b(String str, String str2, @Nullable Map<String, String> map);

    void c(String str, String str2, @Nullable Map<String, String> map);

    void hm(String str, String str2);
}
