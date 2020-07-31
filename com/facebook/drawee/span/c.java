package com.facebook.drawee.span;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c extends CharacterStyle implements UpdateAppearance {
    private int[] colors = {-17920, -6748254};
    public int mWy = 90;
    private int mWz = 8;
    private Shader mWA = null;
    private Matrix matrix = new Matrix();
    private float mWB = 0.0f;

    /* loaded from: classes6.dex */
    public static class a {
        private int[] mColors;
        private int mWy;
        private int mWz;

        public a bb(ArrayList<String> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                this.mColors = new int[arrayList.size()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    try {
                        this.mColors[i2] = Color.parseColor(Ry(arrayList.get(i2)));
                    } catch (Exception e) {
                    }
                    i = i2 + 1;
                }
            }
            return this;
        }

        public a IO(int i) {
            this.mWz = i;
            return this;
        }

        private String Ry(String str) {
            if (str.indexOf("#") == -1) {
                return null;
            }
            return str.replace("#", "#FF");
        }

        public c dEY() {
            c cVar = new c();
            if (this.mColors != null) {
                cVar.colors = this.mColors;
            }
            if (this.mWy != 0) {
                cVar.mWy = this.mWy;
            }
            if (this.mWz != 0) {
                cVar.mWz = this.mWz;
            }
            return cVar;
        }
    }

    public void aL(float f) {
        this.mWB = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setStyle(Paint.Style.FILL);
        float textSize = textPaint.getTextSize() * this.mWz;
        if (this.mWA == null) {
            this.mWA = new LinearGradient(0.0f, 0.0f, 0.0f, textSize, this.colors, (float[]) null, Shader.TileMode.MIRROR);
        }
        this.matrix.reset();
        this.matrix.setRotate(this.mWy);
        this.matrix.postTranslate(this.mWB * textSize, 0.0f);
        this.mWA.setLocalMatrix(this.matrix);
        textPaint.setShader(this.mWA);
    }
}
