package com.kwad.sdk.glide.request.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes7.dex */
public final class g<Z> extends h<Z> {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f36475a = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.kwad.sdk.glide.request.a.g.1
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
    public final com.kwad.sdk.glide.g f36476b;

    public g(com.kwad.sdk.glide.g gVar, int i2, int i3) {
        super(i2, i3);
        this.f36476b = gVar;
    }

    public static <Z> g<Z> a(com.kwad.sdk.glide.g gVar, int i2, int i3) {
        return new g<>(gVar, i2, i3);
    }

    public void a() {
        this.f36476b.a(this);
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void a(@NonNull Z z, @Nullable com.kwad.sdk.glide.request.b.b<? super Z> bVar) {
        f36475a.obtainMessage(1, this).sendToTarget();
    }
}
