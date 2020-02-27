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

    public boolean dyr() {
        return this.myz == Float.MIN_VALUE && this.myC == Float.MIN_VALUE;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        private long endTime;
        private SpannableStringBuilder mCb;
        private int myA;
        private int myB;
        private float myC;
        private int myD;
        private Layout.Alignment myy;
        private float myz;
        private long startTime;
        private float width;

        public a() {
            reset();
        }

        public void reset() {
            this.startTime = 0L;
            this.endTime = 0L;
            this.mCb = null;
            this.myy = null;
            this.myz = Float.MIN_VALUE;
            this.myA = Integer.MIN_VALUE;
            this.myB = Integer.MIN_VALUE;
            this.myC = Float.MIN_VALUE;
            this.myD = Integer.MIN_VALUE;
            this.width = Float.MIN_VALUE;
        }

        public e dys() {
            if (this.myC != Float.MIN_VALUE && this.myD == Integer.MIN_VALUE) {
                dyt();
            }
            return new e(this.startTime, this.endTime, this.mCb, this.myy, this.myz, this.myA, this.myB, this.myC, this.myD, this.width);
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
            this.mCb = spannableStringBuilder;
            return this;
        }

        public a b(Layout.Alignment alignment) {
            this.myy = alignment;
            return this;
        }

        public a bz(float f) {
            this.myz = f;
            return this;
        }

        public a LD(int i) {
            this.myA = i;
            return this;
        }

        public a LE(int i) {
            this.myB = i;
            return this;
        }

        public a bA(float f) {
            this.myC = f;
            return this;
        }

        public a LF(int i) {
            this.myD = i;
            return this;
        }

        public a bB(float f) {
            this.width = f;
            return this;
        }

        private a dyt() {
            if (this.myy == null) {
                this.myD = Integer.MIN_VALUE;
            } else {
                switch (AnonymousClass1.mCa[this.myy.ordinal()]) {
                    case 1:
                        this.myD = 0;
                        break;
                    case 2:
                        this.myD = 1;
                        break;
                    case 3:
                        this.myD = 2;
                        break;
                    default:
                        Log.w("WebvttCueBuilder", "Unrecognized alignment: " + this.myy);
                        this.myD = 0;
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
        static final /* synthetic */ int[] mCa = new int[Layout.Alignment.values().length];

        static {
            try {
                mCa[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                mCa[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mCa[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
