package com.kwad.sdk.glide.load.resource.bitmap;
/* loaded from: classes6.dex */
public abstract class DownsampleStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final DownsampleStrategy f35635a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static final DownsampleStrategy f35636b = new d();

    /* renamed from: c  reason: collision with root package name */
    public static final DownsampleStrategy f35637c = new a();

    /* renamed from: d  reason: collision with root package name */
    public static final DownsampleStrategy f35638d = new b();

    /* renamed from: e  reason: collision with root package name */
    public static final DownsampleStrategy f35639e = new c();

    /* renamed from: f  reason: collision with root package name */
    public static final DownsampleStrategy f35640f = new f();

    /* renamed from: g  reason: collision with root package name */
    public static final DownsampleStrategy f35641g;

    /* renamed from: h  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<DownsampleStrategy> f35642h;

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
            return Math.min(1.0f, DownsampleStrategy.f35635a.a(i, i2, i3, i4));
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
        DownsampleStrategy downsampleStrategy = f35636b;
        f35641g = downsampleStrategy;
        f35642h = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", downsampleStrategy);
    }

    public abstract float a(int i, int i2, int i3, int i4);

    public abstract SampleSizeRounding b(int i, int i2, int i3, int i4);
}
