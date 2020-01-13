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

    public boolean dxf() {
        return this.mxO == Float.MIN_VALUE && this.mxR == Float.MIN_VALUE;
    }

    /* loaded from: classes5.dex */
    public static final class a {
        private long endTime;
        private SpannableStringBuilder mBq;
        private Layout.Alignment mxN;
        private float mxO;
        private int mxP;
        private int mxQ;
        private float mxR;
        private int mxS;
        private long startTime;
        private float width;

        public a() {
            reset();
        }

        public void reset() {
            this.startTime = 0L;
            this.endTime = 0L;
            this.mBq = null;
            this.mxN = null;
            this.mxO = Float.MIN_VALUE;
            this.mxP = Integer.MIN_VALUE;
            this.mxQ = Integer.MIN_VALUE;
            this.mxR = Float.MIN_VALUE;
            this.mxS = Integer.MIN_VALUE;
            this.width = Float.MIN_VALUE;
        }

        public e dxg() {
            if (this.mxR != Float.MIN_VALUE && this.mxS == Integer.MIN_VALUE) {
                dxh();
            }
            return new e(this.startTime, this.endTime, this.mBq, this.mxN, this.mxO, this.mxP, this.mxQ, this.mxR, this.mxS, this.width);
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
            this.mBq = spannableStringBuilder;
            return this;
        }

        public a b(Layout.Alignment alignment) {
            this.mxN = alignment;
            return this;
        }

        public a bA(float f) {
            this.mxO = f;
            return this;
        }

        public a Ly(int i) {
            this.mxP = i;
            return this;
        }

        public a Lz(int i) {
            this.mxQ = i;
            return this;
        }

        public a bB(float f) {
            this.mxR = f;
            return this;
        }

        public a LA(int i) {
            this.mxS = i;
            return this;
        }

        public a bC(float f) {
            this.width = f;
            return this;
        }

        private a dxh() {
            if (this.mxN == null) {
                this.mxS = Integer.MIN_VALUE;
            } else {
                switch (AnonymousClass1.mBp[this.mxN.ordinal()]) {
                    case 1:
                        this.mxS = 0;
                        break;
                    case 2:
                        this.mxS = 1;
                        break;
                    case 3:
                        this.mxS = 2;
                        break;
                    default:
                        Log.w("WebvttCueBuilder", "Unrecognized alignment: " + this.mxN);
                        this.mxS = 0;
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
        static final /* synthetic */ int[] mBp = new int[Layout.Alignment.values().length];

        static {
            try {
                mBp[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                mBp[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mBp[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
