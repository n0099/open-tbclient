package com.kwad.sdk.utils.kwai;
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: com.kwad.sdk.utils.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0646a extends j {
        public C0646a(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }

        @Override // com.kwad.sdk.utils.kwai.a.b
        public final byte AW() {
            return (byte) 7;
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class b {
        public int offset;

        public abstract byte AW();
    }

    /* loaded from: classes8.dex */
    public static class c extends b {
        public boolean value;

        public c(int i, boolean z) {
            this.offset = i;
            this.value = z;
        }

        @Override // com.kwad.sdk.utils.kwai.a.b
        public final byte AW() {
            return (byte) 1;
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends b {
        public double value;

        public d(int i, double d) {
            this.offset = i;
            this.value = d;
        }

        @Override // com.kwad.sdk.utils.kwai.a.b
        public final byte AW() {
            return (byte) 5;
        }
    }

    /* loaded from: classes8.dex */
    public static class e extends b {
        public float value;

        public e(int i, float f) {
            this.offset = i;
            this.value = f;
        }

        @Override // com.kwad.sdk.utils.kwai.a.b
        public final byte AW() {
            return (byte) 3;
        }
    }

    /* loaded from: classes8.dex */
    public static class f extends b {
        public int value;

        public f(int i, int i2) {
            this.offset = i;
            this.value = i2;
        }

        @Override // com.kwad.sdk.utils.kwai.a.b
        public final byte AW() {
            return (byte) 2;
        }
    }

    /* loaded from: classes8.dex */
    public static class g extends b {
        public long value;

        public g(int i, long j) {
            this.offset = i;
            this.value = j;
        }

        @Override // com.kwad.sdk.utils.kwai.a.b
        public final byte AW() {
            return (byte) 4;
        }
    }

    /* loaded from: classes8.dex */
    public static class h extends j {
        public h(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }

        @Override // com.kwad.sdk.utils.kwai.a.b
        public final byte AW() {
            return (byte) 8;
        }
    }

    /* loaded from: classes8.dex */
    public static class i extends j {
        public i(int i, int i2, String str, int i3, boolean z) {
            super(i, i2, str, i3, z);
        }

        @Override // com.kwad.sdk.utils.kwai.a.b
        public final byte AW() {
            return (byte) 6;
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class j extends b {
        public int apt;
        public boolean apu;
        public int start;
        public Object value;

        public j(int i, int i2, Object obj, int i3, boolean z) {
            this.start = i;
            this.offset = i2;
            this.value = obj;
            this.apt = i3;
            this.apu = z;
        }
    }
}
