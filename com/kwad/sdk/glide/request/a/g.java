package com.kwad.sdk.glide.request.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public final class g<Z> extends h<Z> {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f36066a = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.kwad.sdk.glide.request.a.g.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((g) message.obj).a();
                return true;
            }
            return false;
        }
    });

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.g f36067b;

    public g(com.kwad.sdk.glide.g gVar, int i, int i2) {
        super(i, i2);
        this.f36067b = gVar;
    }

    public static <Z> g<Z> a(com.kwad.sdk.glide.g gVar, int i, int i2) {
        return new g<>(gVar, i, i2);
    }

    public void a() {
        this.f36067b.a(this);
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void a(@NonNull Z z, @Nullable com.kwad.sdk.glide.request.b.b<? super Z> bVar) {
        f36066a.obtainMessage(1, this).sendToTarget();
    }
}
