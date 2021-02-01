package com.kwad.sdk.glide.b;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public interface a {

    /* renamed from: com.kwad.sdk.glide.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1120a {
        @NonNull
        Bitmap a(int i, int i2, @NonNull Bitmap.Config config);

        void a(@NonNull Bitmap bitmap);

        void a(@NonNull byte[] bArr);

        void a(@NonNull int[] iArr);

        @NonNull
        byte[] a(int i);

        @NonNull
        int[] b(int i);
    }

    @NonNull
    ByteBuffer a();

    void a(@NonNull Bitmap.Config config);

    void b();

    int c();

    int d();

    int e();

    void f();

    int g();

    @Nullable
    Bitmap h();

    void i();
}
