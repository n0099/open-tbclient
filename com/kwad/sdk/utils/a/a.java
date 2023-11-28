package com.kwad.sdk.utils.a;
/* loaded from: classes10.dex */
public final class a {

    /* loaded from: classes10.dex */
    public static abstract class b {
        public int offset;

        public abstract byte LQ();
    }

    /* renamed from: com.kwad.sdk.utils.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0727a extends j {
        @Override // com.kwad.sdk.utils.a.a.b
        public final byte LQ() {
            return (byte) 7;
        }

        public C0727a(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }
    }

    /* loaded from: classes10.dex */
    public static class c extends b {
        public boolean value;

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte LQ() {
            return (byte) 1;
        }

        public c(int i, boolean z) {
            this.offset = i;
            this.value = z;
        }
    }

    /* loaded from: classes10.dex */
    public static class d extends b {
        public double value;

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte LQ() {
            return (byte) 5;
        }

        public d(int i, double d) {
            this.offset = i;
            this.value = d;
        }
    }

    /* loaded from: classes10.dex */
    public static class e extends b {
        public float value;

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte LQ() {
            return (byte) 3;
        }

        public e(int i, float f) {
            this.offset = i;
            this.value = f;
        }
    }

    /* loaded from: classes10.dex */
    public static class f extends b {
        public int value;

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte LQ() {
            return (byte) 2;
        }

        public f(int i, int i2) {
            this.offset = i;
            this.value = i2;
        }
    }

    /* loaded from: classes10.dex */
    public static class g extends b {
        public long value;

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte LQ() {
            return (byte) 4;
        }

        public g(int i, long j) {
            this.offset = i;
            this.value = j;
        }
    }

    /* loaded from: classes10.dex */
    public static class h extends j {
        @Override // com.kwad.sdk.utils.a.a.b
        public final byte LQ() {
            return (byte) 8;
        }

        public h(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }
    }

    /* loaded from: classes10.dex */
    public static class i extends j {
        @Override // com.kwad.sdk.utils.a.a.b
        public final byte LQ() {
            return (byte) 6;
        }

        public i(int i, int i2, String str, int i3, boolean z) {
            super(i, i2, str, i3, z);
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class j extends b {
        public int aPG;
        public boolean aPH;
        public int start;
        public Object value;

        public j(int i, int i2, Object obj, int i3, boolean z) {
            this.start = i;
            this.offset = i2;
            this.value = obj;
            this.aPG = i3;
            this.aPH = z;
        }
    }
}
