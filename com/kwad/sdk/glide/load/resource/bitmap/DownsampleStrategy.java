package com.kwad.sdk.glide.load.resource.bitmap;
/* loaded from: classes5.dex */
public abstract class DownsampleStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final DownsampleStrategy f10562a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static final DownsampleStrategy f10563b = new d();
    public static final DownsampleStrategy c = new a();
    public static final DownsampleStrategy d = new b();
    public static final DownsampleStrategy e = new c();
    public static final DownsampleStrategy f = new f();
    public static final DownsampleStrategy g = f10563b;
    public static final com.kwad.sdk.glide.load.d<DownsampleStrategy> h = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", g);

    /* loaded from: classes5.dex */
    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    /* loaded from: classes5.dex */
    private static class a extends DownsampleStrategy {
        a() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i, int i2, int i3, int i4) {
            int min = Math.min(i2 / i4, i / i3);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(min);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: classes5.dex */
    private static class b extends DownsampleStrategy {
        b() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i, int i2, int i3, int i4) {
            int ceil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            return 1.0f / (max << (max >= ceil ? 0 : 1));
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.MEMORY;
        }
    }

    /* loaded from: classes5.dex */
    private static class c extends DownsampleStrategy {
        c() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, f10562a.a(i, i2, i3, i4));
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: classes5.dex */
    private static class d extends DownsampleStrategy {
        d() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: classes5.dex */
    private static class e extends DownsampleStrategy {
        e() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i, int i2, int i3, int i4) {
            return Math.min(i3 / i, i4 / i2);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: classes5.dex */
    private static class f extends DownsampleStrategy {
        f() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i, int i2, int i3, int i4) {
            return 1.0f;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    public abstract float a(int i, int i2, int i3, int i4);

    public abstract SampleSizeRounding b(int i, int i2, int i3, int i4);
}
