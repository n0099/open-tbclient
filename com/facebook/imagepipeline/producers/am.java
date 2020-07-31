package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public interface am {
    void G(String str, String str2, boolean z);

    boolean RB(String str);

    void a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, Throwable th, @Nullable Map<String, String> map);

    void a(String str, String str2, Throwable th, @Nullable Map<String, String> map);

    void a(String str, String str2, @Nullable Map<String, String> map);

    void aA(String str, String str2, String str3);

    void b(String str, String str2, @Nullable Map<String, String> map);

    void fW(String str, String str2);
}
