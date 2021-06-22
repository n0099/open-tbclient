package com.kwad.sdk.glide.load.resource.bitmap;
/* loaded from: classes7.dex */
public abstract class DownsampleStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final DownsampleStrategy f36427a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static final DownsampleStrategy f36428b = new d();

    /* renamed from: c  reason: collision with root package name */
    public static final DownsampleStrategy f36429c = new a();

    /* renamed from: d  reason: collision with root package name */
    public static final DownsampleStrategy f36430d = new b();

    /* renamed from: e  reason: collision with root package name */
    public static final DownsampleStrategy f36431e = new c();

    /* renamed from: f  reason: collision with root package name */
    public static final DownsampleStrategy f36432f = new f();

    /* renamed from: g  reason: collision with root package name */
    public static final DownsampleStrategy f36433g;

    /* renamed from: h  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<DownsampleStrategy> f36434h;

    /* loaded from: classes7.dex */
    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    /* loaded from: classes7.dex */
    public static class a extends DownsampleStrategy {
        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i2, int i3, int i4, int i5) {
            int min = Math.min(i3 / i5, i2 / i4);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(min);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends DownsampleStrategy {
        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i2, int i3, int i4, int i5) {
            int ceil = (int) Math.ceil(Math.max(i3 / i5, i2 / i4));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            return 1.0f / (max << (max >= ceil ? 0 : 1));
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.MEMORY;
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends DownsampleStrategy {
        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i2, int i3, int i4, int i5) {
            return Math.min(1.0f, DownsampleStrategy.f36427a.a(i2, i3, i4, i5));
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends DownsampleStrategy {
        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i2, int i3, int i4, int i5) {
            return Math.max(i4 / i2, i5 / i3);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends DownsampleStrategy {
        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i2, int i3, int i4, int i5) {
            return Math.min(i4 / i2, i5 / i3);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: classes7.dex */
    public static class f extends DownsampleStrategy {
        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }
    }

    static {
        DownsampleStrategy downsampleStrategy = f36428b;
        f36433g = downsampleStrategy;
        f36434h = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", downsampleStrategy);
    }

    public abstract float a(int i2, int i3, int i4, int i5);

    public abstract SampleSizeRounding b(int i2, int i3, int i4, int i5);
}
