package com.google.android.exoplayer2.text.g;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.util.Log;
/* loaded from: classes6.dex */
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

    public boolean dyt() {
        return this.myB == Float.MIN_VALUE && this.myE == Float.MIN_VALUE;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        private long endTime;
        private SpannableStringBuilder mCd;
        private Layout.Alignment myA;
        private float myB;
        private int myC;
        private int myD;
        private float myE;
        private int myF;
        private long startTime;
        private float width;

        public a() {
            reset();
        }

        public void reset() {
            this.startTime = 0L;
            this.endTime = 0L;
            this.mCd = null;
            this.myA = null;
            this.myB = Float.MIN_VALUE;
            this.myC = Integer.MIN_VALUE;
            this.myD = Integer.MIN_VALUE;
            this.myE = Float.MIN_VALUE;
            this.myF = Integer.MIN_VALUE;
            this.width = Float.MIN_VALUE;
        }

        public e dyu() {
            if (this.myE != Float.MIN_VALUE && this.myF == Integer.MIN_VALUE) {
                dyv();
            }
            return new e(this.startTime, this.endTime, this.mCd, this.myA, this.myB, this.myC, this.myD, this.myE, this.myF, this.width);
        }

        public a gz(long j) {
            this.startTime = j;
            return this;
        }

        public a gA(long j) {
            this.endTime = j;
            return this;
        }

        public a f(SpannableStringBuilder spannableStringBuilder) {
            this.mCd = spannableStringBuilder;
            return this;
        }

        public a b(Layout.Alignment alignment) {
            this.myA = alignment;
            return this;
        }

        public a bz(float f) {
            this.myB = f;
            return this;
        }

        public a LD(int i) {
            this.myC = i;
            return this;
        }

        public a LE(int i) {
            this.myD = i;
            return this;
        }

        public a bA(float f) {
            this.myE = f;
            return this;
        }

        public a LF(int i) {
            this.myF = i;
            return this;
        }

        public a bB(float f) {
            this.width = f;
            return this;
        }

        private a dyv() {
            if (this.myA == null) {
                this.myF = Integer.MIN_VALUE;
            } else {
                switch (AnonymousClass1.mCc[this.myA.ordinal()]) {
                    case 1:
                        this.myF = 0;
                        break;
                    case 2:
                        this.myF = 1;
                        break;
                    case 3:
                        this.myF = 2;
                        break;
                    default:
                        Log.w("WebvttCueBuilder", "Unrecognized alignment: " + this.myA);
                        this.myF = 0;
                        break;
                }
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.exoplayer2.text.g.e$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] mCc = new int[Layout.Alignment.values().length];

        static {
            try {
                mCc[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                mCc[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mCc[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
