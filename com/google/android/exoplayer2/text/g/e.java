package com.google.android.exoplayer2.text.g;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.util.Log;
/* loaded from: classes5.dex */
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

    public boolean dxh() {
        return this.mxT == Float.MIN_VALUE && this.mxW == Float.MIN_VALUE;
    }

    /* loaded from: classes5.dex */
    public static final class a {
        private long endTime;
        private SpannableStringBuilder mBv;
        private Layout.Alignment mxS;
        private float mxT;
        private int mxU;
        private int mxV;
        private float mxW;
        private int mxX;
        private long startTime;
        private float width;

        public a() {
            reset();
        }

        public void reset() {
            this.startTime = 0L;
            this.endTime = 0L;
            this.mBv = null;
            this.mxS = null;
            this.mxT = Float.MIN_VALUE;
            this.mxU = Integer.MIN_VALUE;
            this.mxV = Integer.MIN_VALUE;
            this.mxW = Float.MIN_VALUE;
            this.mxX = Integer.MIN_VALUE;
            this.width = Float.MIN_VALUE;
        }

        public e dxi() {
            if (this.mxW != Float.MIN_VALUE && this.mxX == Integer.MIN_VALUE) {
                dxj();
            }
            return new e(this.startTime, this.endTime, this.mBv, this.mxS, this.mxT, this.mxU, this.mxV, this.mxW, this.mxX, this.width);
        }

        public a gB(long j) {
            this.startTime = j;
            return this;
        }

        public a gC(long j) {
            this.endTime = j;
            return this;
        }

        public a f(SpannableStringBuilder spannableStringBuilder) {
            this.mBv = spannableStringBuilder;
            return this;
        }

        public a b(Layout.Alignment alignment) {
            this.mxS = alignment;
            return this;
        }

        public a bA(float f) {
            this.mxT = f;
            return this;
        }

        public a Ly(int i) {
            this.mxU = i;
            return this;
        }

        public a Lz(int i) {
            this.mxV = i;
            return this;
        }

        public a bB(float f) {
            this.mxW = f;
            return this;
        }

        public a LA(int i) {
            this.mxX = i;
            return this;
        }

        public a bC(float f) {
            this.width = f;
            return this;
        }

        private a dxj() {
            if (this.mxS == null) {
                this.mxX = Integer.MIN_VALUE;
            } else {
                switch (AnonymousClass1.mBu[this.mxS.ordinal()]) {
                    case 1:
                        this.mxX = 0;
                        break;
                    case 2:
                        this.mxX = 1;
                        break;
                    case 3:
                        this.mxX = 2;
                        break;
                    default:
                        Log.w("WebvttCueBuilder", "Unrecognized alignment: " + this.mxS);
                        this.mxX = 0;
                        break;
                }
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.exoplayer2.text.g.e$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] mBu = new int[Layout.Alignment.values().length];

        static {
            try {
                mBu[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                mBu[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mBu[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
