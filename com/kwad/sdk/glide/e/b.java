package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f10266a = new ArrayList();

    @NonNull
    public synchronized List<ImageHeaderParser> a() {
        return this.f10266a;
    }

    public synchronized void a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f10266a.add(imageHeaderParser);
    }
}
