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
    public int nAG = 90;
    private int nAH = 8;
    private Shader nAI = null;
    private Matrix matrix = new Matrix();
    private float nAJ = 0.0f;

    /* loaded from: classes6.dex */
    public static class a {
        private int[] mColors;
        private int nAG;
        private int nAH;

        public a bj(ArrayList<String> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                this.mColors = new int[arrayList.size()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    try {
                        this.mColors[i2] = Color.parseColor(Ve(arrayList.get(i2)));
                    } catch (Exception e) {
                    }
                    i = i2 + 1;
                }
            }
            return this;
        }

        public a LX(int i) {
            this.nAH = i;
            return this;
        }

        private String Ve(String str) {
            if (str.indexOf("#") == -1) {
                return null;
            }
            return str.replace("#", "#FF");
        }

        public c dVf() {
            c cVar = new c();
            if (this.mColors != null) {
                cVar.colors = this.mColors;
            }
            if (this.nAG != 0) {
                cVar.nAG = this.nAG;
            }
            if (this.nAH != 0) {
                cVar.nAH = this.nAH;
            }
            return cVar;
        }
    }

    public void aR(float f) {
        this.nAJ = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setStyle(Paint.Style.FILL);
        float textSize = textPaint.getTextSize() * this.nAH;
        if (this.nAI == null) {
            this.nAI = new LinearGradient(0.0f, 0.0f, 0.0f, textSize, this.colors, (float[]) null, Shader.TileMode.MIRROR);
        }
        this.matrix.reset();
        this.matrix.setRotate(this.nAG);
        this.matrix.postTranslate(this.nAJ * textSize, 0.0f);
        this.nAI.setLocalMatrix(this.matrix);
        textPaint.setShader(this.nAI);
    }
}
