package com.kwad.sdk.glide.load.resource.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.kwad.sdk.glide.b.a;
import com.kwad.sdk.glide.g.k;
import com.kwad.sdk.glide.load.DecodeFormat;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
/* loaded from: classes5.dex */
public class a implements com.kwad.sdk.glide.load.f<ByteBuffer, c> {

    /* renamed from: a  reason: collision with root package name */
    private static final C1146a f10605a = new C1146a();

    /* renamed from: b  reason: collision with root package name */
    private static final b f10606b = new b();
    private final Context c;
    private final List<ImageHeaderParser> d;
    private final b e;
    private final C1146a f;
    private final com.kwad.sdk.glide.load.resource.d.b g;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: com.kwad.sdk.glide.load.resource.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1146a {
        C1146a() {
        }

        com.kwad.sdk.glide.b.a a(a.InterfaceC1133a interfaceC1133a, com.kwad.sdk.glide.b.c cVar, ByteBuffer byteBuffer, int i) {
            return new com.kwad.sdk.glide.b.e(interfaceC1133a, cVar, byteBuffer, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<com.kwad.sdk.glide.b.d> f10607a = k.a(0);

        b() {
        }

        synchronized com.kwad.sdk.glide.b.d a(ByteBuffer byteBuffer) {
            com.kwad.sdk.glide.b.d poll;
            poll = this.f10607a.poll();
            if (poll == null) {
                poll = new com.kwad.sdk.glide.b.d();
            }
            return poll.a(byteBuffer);
        }

        synchronized void a(com.kwad.sdk.glide.b.d dVar) {
            dVar.a();
            this.f10607a.offer(dVar);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this(context, list, eVar, bVar, f10606b, f10605a);
    }

    @VisibleForTesting
    a(Context context, List<ImageHeaderParser> list, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, b bVar2, C1146a c1146a) {
        this.c = context.getApplicationContext();
        this.d = list;
        this.f = c1146a;
        this.g = new com.kwad.sdk.glide.load.resource.d.b(eVar, bVar);
        this.e = bVar2;
    }

    private static int a(com.kwad.sdk.glide.b.c cVar, int i, int i2) {
        int min = Math.min(cVar.a() / i2, cVar.b() / i);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + cVar.b() + "x" + cVar.a() + "]");
        }
        return max;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[CONST_STR, INVOKE]}, finally: {[CONST_STR, INVOKE, CONST_STR, CONSTRUCTOR, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IF] complete} */
    @Nullable
    private e a(ByteBuffer byteBuffer, int i, int i2, com.kwad.sdk.glide.b.d dVar, com.kwad.sdk.glide.load.e eVar) {
        long a2 = com.kwad.sdk.glide.g.f.a();
        try {
            com.kwad.sdk.glide.b.c b2 = dVar.b();
            if (b2.c() <= 0 || b2.d() != 0) {
            }
            Bitmap.Config config = eVar.a(i.f10620a) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
            com.kwad.sdk.glide.b.a a3 = this.f.a(this.g, b2, byteBuffer, a(b2, i, i2));
            a3.a(config);
            a3.b();
            Bitmap h = a3.h();
            if (h == null) {
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.kwad.sdk.glide.g.f.a(a2));
                    return null;
                }
                return null;
            }
            e eVar2 = new e(new c(this.c, a3, com.kwad.sdk.glide.load.resource.b.a(), i, i2, h));
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.kwad.sdk.glide.g.f.a(a2));
            }
            return eVar2;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.kwad.sdk.glide.g.f.a(a2));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public e a(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        com.kwad.sdk.glide.b.d a2 = this.e.a(byteBuffer);
        try {
            return a(byteBuffer, i, i2, a2, eVar);
        } finally {
            this.e.a(a2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return !((Boolean) eVar.a(i.f10621b)).booleanValue() && com.kwad.sdk.glide.load.b.a(this.d, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }
}
