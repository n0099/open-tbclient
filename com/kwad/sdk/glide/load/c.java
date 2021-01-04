package com.kwad.sdk.glide.load;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;
/* loaded from: classes5.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f10431a = Charset.forName("UTF-8");

    void a(@NonNull MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
