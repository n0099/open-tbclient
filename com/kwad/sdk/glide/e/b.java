package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final List<ImageHeaderParser> f35432a = new ArrayList();

    @NonNull
    public synchronized List<ImageHeaderParser> a() {
        return this.f35432a;
    }

    public synchronized void a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f35432a.add(imageHeaderParser);
    }
}
