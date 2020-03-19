package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public interface am {
    void D(String str, String str2, boolean z);

    boolean Pe(String str);

    void a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, Throwable th, @Nullable Map<String, String> map);

    void a(String str, String str2, Throwable th, @Nullable Map<String, String> map);

    void a(String str, String str2, @Nullable Map<String, String> map);

    void az(String str, String str2, String str3);

    void b(String str, String str2, @Nullable Map<String, String> map);

    void fk(String str, String str2);
}
