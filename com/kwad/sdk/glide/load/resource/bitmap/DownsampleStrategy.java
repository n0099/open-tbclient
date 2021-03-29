package com.kwad.sdk.glide.load.resource.bitmap;
/* loaded from: classes6.dex */
public abstract class DownsampleStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final DownsampleStrategy f35636a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static final DownsampleStrategy f35637b = new d();

    /* renamed from: c  reason: collision with root package name */
    public static final DownsampleStrategy f35638c = new a();

    /* renamed from: d  reason: collision with root package name */
    public static final DownsampleStrategy f35639d = new b();

    /* renamed from: e  reason: collision with root package name */
    public static final DownsampleStrategy f35640e = new c();

    /* renamed from: f  reason: collision with root package name */
    public static final DownsampleStrategy f35641f = new f();

    /* renamed from: g  reason: collision with root package name */
    public static final DownsampleStrategy f35642g;

    /* renamed from: h  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<DownsampleStrategy> f35643h;

    /* loaded from: classes6.dex */
    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    /* loaded from: classes6.dex */
    public static class a extends DownsampleStrategy {
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

    /* loaded from: classes6.dex */
    public static class b extends DownsampleStrategy {
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

    /* loaded from: classes6.dex */
    public static class c extends DownsampleStrategy {
        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, DownsampleStrategy.f35636a.a(i, i2, i3, i4));
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends DownsampleStrategy {
        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends DownsampleStrategy {
        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i, int i2, int i3, int i4) {
            return Math.min(i3 / i, i4 / i2);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends DownsampleStrategy {
        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i, int i2, int i3, int i4) {
            return 1.0f;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    static {
        DownsampleStrategy downsampleStrategy = f35637b;
        f35642g = downsampleStrategy;
        f35643h = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", downsampleStrategy);
    }

    public abstract float a(int i, int i2, int i3, int i4);

    public abstract SampleSizeRounding b(int i, int i2, int i3, int i4);
}
