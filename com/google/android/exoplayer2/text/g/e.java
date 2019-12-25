package com.google.android.exoplayer2.text.g;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.util.Log;
/* loaded from: classes4.dex */
final class e extends com.google.android.exoplayer2.text.b {
    public final long endTime;
    public final long startTime;

    public e(CharSequence charSequence) {
        this(0L, 0L, charSequence);
    }

    public e(long j, long j2, CharSequence charSequence) {
        this(j, j2, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public e(long j, long j2, CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3);
        this.startTime = j;
        this.endTime = j2;
    }

    public boolean dvU() {
        return this.mub == Float.MIN_VALUE && this.mue == Float.MIN_VALUE;
    }

    /* loaded from: classes4.dex */
    public static final class a {
        private long endTime;
        private Layout.Alignment mua;
        private float mub;
        private int muc;
        private int mud;
        private float mue;
        private int muf;
        private SpannableStringBuilder mxB;
        private long startTime;
        private float width;

        public a() {
            reset();
        }

        public void reset() {
            this.startTime = 0L;
            this.endTime = 0L;
            this.mxB = null;
            this.mua = null;
            this.mub = Float.MIN_VALUE;
            this.muc = Integer.MIN_VALUE;
            this.mud = Integer.MIN_VALUE;
            this.mue = Float.MIN_VALUE;
            this.muf = Integer.MIN_VALUE;
            this.width = Float.MIN_VALUE;
        }

        public e dvV() {
            if (this.mue != Float.MIN_VALUE && this.muf == Integer.MIN_VALUE) {
                dvW();
            }
            return new e(this.startTime, this.endTime, this.mxB, this.mua, this.mub, this.muc, this.mud, this.mue, this.muf, this.width);
        }

        public a gw(long j) {
            this.startTime = j;
            return this;
        }

        public a gx(long j) {
            this.endTime = j;
            return this;
        }

        public a f(SpannableStringBuilder spannableStringBuilder) {
            this.mxB = spannableStringBuilder;
            return this;
        }

        public a b(Layout.Alignment alignment) {
            this.mua = alignment;
            return this;
        }

        public a bA(float f) {
            this.mub = f;
            return this;
        }

        public a Lp(int i) {
            this.muc = i;
            return this;
        }

        public a Lq(int i) {
            this.mud = i;
            return this;
        }

        public a bB(float f) {
            this.mue = f;
            return this;
        }

        public a Lr(int i) {
            this.muf = i;
            return this;
        }

        public a bC(float f) {
            this.width = f;
            return this;
        }

        private a dvW() {
            if (this.mua == null) {
                this.muf = Integer.MIN_VALUE;
            } else {
                switch (AnonymousClass1.mxA[this.mua.ordinal()]) {
                    case 1:
                        this.muf = 0;
                        break;
                    case 2:
                        this.muf = 1;
                        break;
                    case 3:
                        this.muf = 2;
                        break;
                    default:
                        Log.w("WebvttCueBuilder", "Unrecognized alignment: " + this.mua);
                        this.muf = 0;
                        break;
                }
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.exoplayer2.text.g.e$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] mxA = new int[Layout.Alignment.values().length];

        static {
            try {
                mxA[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                mxA[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mxA[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
