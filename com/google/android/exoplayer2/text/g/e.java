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

    public boolean dyR() {
        return this.mAt == Float.MIN_VALUE && this.mAw == Float.MIN_VALUE;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        private long endTime;
        private Layout.Alignment mAs;
        private float mAt;
        private int mAu;
        private int mAv;
        private float mAw;
        private int mAx;
        private SpannableStringBuilder mDY;
        private long startTime;
        private float width;

        public a() {
            reset();
        }

        public void reset() {
            this.startTime = 0L;
            this.endTime = 0L;
            this.mDY = null;
            this.mAs = null;
            this.mAt = Float.MIN_VALUE;
            this.mAu = Integer.MIN_VALUE;
            this.mAv = Integer.MIN_VALUE;
            this.mAw = Float.MIN_VALUE;
            this.mAx = Integer.MIN_VALUE;
            this.width = Float.MIN_VALUE;
        }

        public e dyS() {
            if (this.mAw != Float.MIN_VALUE && this.mAx == Integer.MIN_VALUE) {
                dyT();
            }
            return new e(this.startTime, this.endTime, this.mDY, this.mAs, this.mAt, this.mAu, this.mAv, this.mAw, this.mAx, this.width);
        }

        public a gA(long j) {
            this.startTime = j;
            return this;
        }

        public a gB(long j) {
            this.endTime = j;
            return this;
        }

        public a f(SpannableStringBuilder spannableStringBuilder) {
            this.mDY = spannableStringBuilder;
            return this;
        }

        public a b(Layout.Alignment alignment) {
            this.mAs = alignment;
            return this;
        }

        public a bz(float f) {
            this.mAt = f;
            return this;
        }

        public a LJ(int i) {
            this.mAu = i;
            return this;
        }

        public a LK(int i) {
            this.mAv = i;
            return this;
        }

        public a bA(float f) {
            this.mAw = f;
            return this;
        }

        public a LL(int i) {
            this.mAx = i;
            return this;
        }

        public a bB(float f) {
            this.width = f;
            return this;
        }

        private a dyT() {
            if (this.mAs == null) {
                this.mAx = Integer.MIN_VALUE;
            } else {
                switch (AnonymousClass1.mDX[this.mAs.ordinal()]) {
                    case 1:
                        this.mAx = 0;
                        break;
                    case 2:
                        this.mAx = 1;
                        break;
                    case 3:
                        this.mAx = 2;
                        break;
                    default:
                        Log.w("WebvttCueBuilder", "Unrecognized alignment: " + this.mAs);
                        this.mAx = 0;
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
        static final /* synthetic */ int[] mDX = new int[Layout.Alignment.values().length];

        static {
            try {
                mDX[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                mDX[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mDX[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
