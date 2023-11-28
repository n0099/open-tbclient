package com.kwad.components.core.video;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes10.dex */
public final class VideoAdapters {

    /* loaded from: classes10.dex */
    public enum AdaptType {
        PORTRAIT_VERTICAL,
        PORTRAIT_HORIZONTAL,
        LANDSCAPE_VERTICAL,
        LANDSCAPE_HORIZONTAL
    }

    /* renamed from: com.kwad.components.core.video.VideoAdapters$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] UD;

        static {
            int[] iArr = new int[AdaptType.values().length];
            UD = iArr;
            try {
                iArr[AdaptType.PORTRAIT_VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                UD[AdaptType.LANDSCAPE_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                UD[AdaptType.PORTRAIT_HORIZONTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                UD[AdaptType.LANDSCAPE_VERTICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class d {
        public float UH;
        public float height;
        public float width;

        public d(float f, float f2) {
            this.UH = -1.0f;
            this.width = f;
            this.height = f2;
            if (f > 0.0f && f2 > 0.0f) {
                this.UH = f2 / f;
            }
        }

        private boolean isValid() {
            if (this.width > 0.0f && this.height > 0.0f) {
                return true;
            }
            return false;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getRatio() {
            return this.UH;
        }

        public final float getWidth() {
            return this.width;
        }

        public final float rB() {
            if (!isValid()) {
                return -1.0f;
            }
            return Math.max(this.width, this.height);
        }

        public final float rC() {
            if (!isValid()) {
                return -1.0f;
            }
            return Math.min(this.width, this.height);
        }

        public final float rD() {
            if (!isValid()) {
                return -1.0f;
            }
            float f = this.height;
            float f2 = this.width;
            if (f > f2) {
                return f / f2;
            }
            return f2 / f;
        }

        public final String toString() {
            return "ViewSize{width=" + this.width + ", height=" + this.height + ", ratio=" + this.UH + '}';
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class a implements com.kwad.components.core.video.c {
        public abstract void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2);

        public static boolean b(View view2, View view3, int i, int i2) {
            if (view2 == null || i == 0 || i2 == 0 || view3 == null) {
                return false;
            }
            int width = view3.getWidth();
            int height = view3.getHeight();
            if (width == 0 || height == 0) {
                return false;
            }
            return true;
        }

        @Override // com.kwad.components.core.video.c
        public final void a(View view2, View view3, int i, int i2) {
            boolean z;
            AdaptType adaptType;
            if (!b(view2, view3, i, i2)) {
                com.kwad.sdk.core.e.c.d("AbstractVideoViewAdapter", "adaptVideo checkArguments invalid");
                return;
            }
            d dVar = new d(view3.getWidth(), view3.getHeight());
            d dVar2 = new d(i, i2);
            boolean z2 = true;
            if (dVar2.getRatio() >= 1.0f) {
                z = true;
            } else {
                z = false;
            }
            if (dVar.getRatio() < 1.0f) {
                z2 = false;
            }
            if (z2 && z) {
                adaptType = AdaptType.PORTRAIT_VERTICAL;
            } else if (z2) {
                adaptType = AdaptType.PORTRAIT_HORIZONTAL;
            } else if (z) {
                adaptType = AdaptType.LANDSCAPE_VERTICAL;
            } else {
                adaptType = AdaptType.LANDSCAPE_HORIZONTAL;
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            a(adaptType, layoutParams, dVar, dVar2);
            view2.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends a {
        public float UE = 0.8f;
        public float UF = 0.9375f;
        public float UG = 1.1046f;

        @Override // com.kwad.components.core.video.VideoAdapters.a
        public final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float rC;
            float f;
            float rD = dVar.rD();
            float rD2 = dVar2.rD();
            float rC2 = dVar.rC();
            float rB = dVar.rB();
            com.kwad.sdk.core.e.c.d("FullHeightAdapter", "onAdaptVideo containerSize: " + rB + StringUtil.ARRAY_ELEMENT_SEPARATOR + rC2);
            int i = AnonymousClass1.UD[adaptType.ordinal()];
            if (i != 1 && i != 2) {
                if (i != 3 && i != 4) {
                    rC = -2.1474836E9f;
                    f = -2.1474836E9f;
                } else {
                    f = rC2 * this.UG;
                    rC = f / rD2;
                }
            } else if (rD > rD2) {
                float rB2 = dVar.rB();
                float f2 = rB2 / rD2;
                float f3 = this.UE;
                if (rC2 / f2 >= f3) {
                    f = rB2;
                    rC = f2;
                } else {
                    rC = rC2 / f3;
                    f = rC * rD2;
                }
            } else {
                rC = dVar.rC();
                f = rD2 * rC;
                float f4 = this.UF;
                if (rB / f < f4) {
                    f = rB / f4;
                    rC = f / rD2;
                }
            }
            com.kwad.sdk.core.e.c.d("FullHeightAdapter", "onAdaptVideo result: " + f + StringUtil.ARRAY_ELEMENT_SEPARATOR + rC);
            if (f != -2.1474836E9f && rC != -2.1474836E9f) {
                if (dVar2.getHeight() >= dVar2.getWidth()) {
                    layoutParams.width = (int) rC;
                    layoutParams.height = (int) f;
                    return;
                }
                layoutParams.height = (int) rC;
                layoutParams.width = (int) f;
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class c extends a {
        @Override // com.kwad.components.core.video.VideoAdapters.a
        public final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float rB;
            float rC;
            float rD = dVar.rD();
            float rD2 = dVar2.rD();
            int i = AnonymousClass1.UD[adaptType.ordinal()];
            if (i != 1 && i != 2) {
                if (i != 3 && i != 4) {
                    rB = 0.0f;
                    rC = -2.1474836E9f;
                } else {
                    rB = dVar.rC();
                    rC = rB / rD2;
                }
            } else if (rD >= rD2) {
                rC = dVar.rC();
                rB = rC * rD2;
            } else {
                rB = dVar.rB();
                rC = rB / rD2;
            }
            if (rC != -2.1474836E9f && rB != -2.1474836E9f) {
                if (dVar2.getHeight() > dVar2.getWidth()) {
                    layoutParams.width = (int) rC;
                    layoutParams.height = (int) rB;
                    return;
                }
                layoutParams.height = (int) rC;
                layoutParams.width = (int) rB;
            }
        }
    }
}
