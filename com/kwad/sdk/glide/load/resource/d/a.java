package com.kwad.sdk.glide.load.resource.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.kwad.sdk.glide.b.a;
import com.kwad.sdk.glide.g.k;
import com.kwad.sdk.glide.load.DecodeFormat;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
/* loaded from: classes7.dex */
public class a implements com.kwad.sdk.glide.load.f<ByteBuffer, c> {

    /* renamed from: a  reason: collision with root package name */
    public static final C0420a f36400a = new C0420a();

    /* renamed from: b  reason: collision with root package name */
    public static final b f36401b = new b();

    /* renamed from: c  reason: collision with root package name */
    public final Context f36402c;

    /* renamed from: d  reason: collision with root package name */
    public final List<ImageHeaderParser> f36403d;

    /* renamed from: e  reason: collision with root package name */
    public final b f36404e;

    /* renamed from: f  reason: collision with root package name */
    public final C0420a f36405f;

    /* renamed from: g  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.resource.d.b f36406g;

    @VisibleForTesting
    /* renamed from: com.kwad.sdk.glide.load.resource.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0420a {
        public com.kwad.sdk.glide.b.a a(a.InterfaceC0407a interfaceC0407a, com.kwad.sdk.glide.b.c cVar, ByteBuffer byteBuffer, int i2) {
            return new com.kwad.sdk.glide.b.e(interfaceC0407a, cVar, byteBuffer, i2);
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<com.kwad.sdk.glide.b.d> f36407a = k.a(0);

        public synchronized com.kwad.sdk.glide.b.d a(ByteBuffer byteBuffer) {
            com.kwad.sdk.glide.b.d poll;
            poll = this.f36407a.poll();
            if (poll == null) {
                poll = new com.kwad.sdk.glide.b.d();
            }
            return poll.a(byteBuffer);
        }

        public synchronized void a(com.kwad.sdk.glide.b.d dVar) {
            dVar.a();
            this.f36407a.offer(dVar);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this(context, list, eVar, bVar, f36401b, f36400a);
    }

    @VisibleForTesting
    public a(Context context, List<ImageHeaderParser> list, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, b bVar2, C0420a c0420a) {
        this.f36402c = context.getApplicationContext();
        this.f36403d = list;
        this.f36405f = c0420a;
        this.f36406g = new com.kwad.sdk.glide.load.resource.d.b(eVar, bVar);
        this.f36404e = bVar2;
    }

    public static int a(com.kwad.sdk.glide.b.c cVar, int i2, int i3) {
        int min = Math.min(cVar.a() / i3, cVar.b() / i2);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable(ByteBufferGifDecoder.TAG, 2) && max > 1) {
            Log.v(ByteBufferGifDecoder.TAG, "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i2 + "x" + i3 + "], actual dimens: [" + cVar.b() + "x" + cVar.a() + "]");
        }
        return max;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IF] complete} */
    @Nullable
    private e a(ByteBuffer byteBuffer, int i2, int i3, com.kwad.sdk.glide.b.d dVar, com.kwad.sdk.glide.load.e eVar) {
        long a2 = com.kwad.sdk.glide.g.f.a();
        try {
            com.kwad.sdk.glide.b.c b2 = dVar.b();
            if (b2.c() > 0 && b2.d() == 0) {
                Bitmap.Config config = eVar.a(i.f36436a) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                com.kwad.sdk.glide.b.a a3 = this.f36405f.a(this.f36406g, b2, byteBuffer, a(b2, i2, i3));
                a3.a(config);
                a3.b();
                Bitmap h2 = a3.h();
                if (h2 == null) {
                    return null;
                }
                e eVar2 = new e(new c(this.f36402c, a3, com.kwad.sdk.glide.load.resource.b.a(), i2, i3, h2));
                if (Log.isLoggable(ByteBufferGifDecoder.TAG, 2)) {
                    Log.v(ByteBufferGifDecoder.TAG, "Decoded GIF from stream in " + com.kwad.sdk.glide.g.f.a(a2));
                }
                return eVar2;
            }
            if (Log.isLoggable(ByteBufferGifDecoder.TAG, 2)) {
                Log.v(ByteBufferGifDecoder.TAG, "Decoded GIF from stream in " + com.kwad.sdk.glide.g.f.a(a2));
            }
            return null;
        } finally {
            if (Log.isLoggable(ByteBufferGifDecoder.TAG, 2)) {
                Log.v(ByteBufferGifDecoder.TAG, "Decoded GIF from stream in " + com.kwad.sdk.glide.g.f.a(a2));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public e a(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        com.kwad.sdk.glide.b.d a2 = this.f36404e.a(byteBuffer);
        try {
            return a(byteBuffer, i2, i3, a2, eVar);
        } finally {
            this.f36404e.a(a2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return !((Boolean) eVar.a(i.f36437b)).booleanValue() && com.kwad.sdk.glide.load.b.a(this.f36403d, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }
}
