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

    public boolean dyu() {
        return this.myM == Float.MIN_VALUE && this.myP == Float.MIN_VALUE;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        private long endTime;
        private SpannableStringBuilder mCo;
        private Layout.Alignment myL;
        private float myM;
        private int myN;
        private int myO;
        private float myP;
        private int myQ;
        private long startTime;
        private float width;

        public a() {
            reset();
        }

        public void reset() {
            this.startTime = 0L;
            this.endTime = 0L;
            this.mCo = null;
            this.myL = null;
            this.myM = Float.MIN_VALUE;
            this.myN = Integer.MIN_VALUE;
            this.myO = Integer.MIN_VALUE;
            this.myP = Float.MIN_VALUE;
            this.myQ = Integer.MIN_VALUE;
            this.width = Float.MIN_VALUE;
        }

        public e dyv() {
            if (this.myP != Float.MIN_VALUE && this.myQ == Integer.MIN_VALUE) {
                dyw();
            }
            return new e(this.startTime, this.endTime, this.mCo, this.myL, this.myM, this.myN, this.myO, this.myP, this.myQ, this.width);
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
            this.mCo = spannableStringBuilder;
            return this;
        }

        public a b(Layout.Alignment alignment) {
            this.myL = alignment;
            return this;
        }

        public a bz(float f) {
            this.myM = f;
            return this;
        }

        public a LD(int i) {
            this.myN = i;
            return this;
        }

        public a LE(int i) {
            this.myO = i;
            return this;
        }

        public a bA(float f) {
            this.myP = f;
            return this;
        }

        public a LF(int i) {
            this.myQ = i;
            return this;
        }

        public a bB(float f) {
            this.width = f;
            return this;
        }

        private a dyw() {
            if (this.myL == null) {
                this.myQ = Integer.MIN_VALUE;
            } else {
                switch (AnonymousClass1.mCn[this.myL.ordinal()]) {
                    case 1:
                        this.myQ = 0;
                        break;
                    case 2:
                        this.myQ = 1;
                        break;
                    case 3:
                        this.myQ = 2;
                        break;
                    default:
                        Log.w("WebvttCueBuilder", "Unrecognized alignment: " + this.myL);
                        this.myQ = 0;
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
        static final /* synthetic */ int[] mCn = new int[Layout.Alignment.values().length];

        static {
            try {
                mCn[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                mCn[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mCn[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
