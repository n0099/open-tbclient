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
/* loaded from: classes5.dex */
public class c extends CharacterStyle implements UpdateAppearance {
    private int[] colors = {-17920, -6748254};
    public int lXg = 90;
    private int lXh = 8;
    private Shader lXi = null;
    private Matrix matrix = new Matrix();
    private float lXj = 0.0f;

    /* loaded from: classes5.dex */
    public static class a {
        private int lXg;
        private int lXh;
        private int[] mColors;

        public a aY(ArrayList<String> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                this.mColors = new int[arrayList.size()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    try {
                        this.mColors[i2] = Color.parseColor(Oi(arrayList.get(i2)));
                    } catch (Exception e) {
                    }
                    i = i2 + 1;
                }
            }
            return this;
        }

        public a Gy(int i) {
            this.lXh = i;
            return this;
        }

        private String Oi(String str) {
            if (str.indexOf("#") == -1) {
                return null;
            }
            return str.replace("#", "#FF");
        }

        public c dpC() {
            c cVar = new c();
            if (this.mColors != null) {
                cVar.colors = this.mColors;
            }
            if (this.lXg != 0) {
                cVar.lXg = this.lXg;
            }
            if (this.lXh != 0) {
                cVar.lXh = this.lXh;
            }
            return cVar;
        }
    }

    public void aH(float f) {
        this.lXj = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setStyle(Paint.Style.FILL);
        float textSize = textPaint.getTextSize() * this.lXh;
        if (this.lXi == null) {
            this.lXi = new LinearGradient(0.0f, 0.0f, 0.0f, textSize, this.colors, (float[]) null, Shader.TileMode.MIRROR);
        }
        this.matrix.reset();
        this.matrix.setRotate(this.lXg);
        this.matrix.postTranslate(this.lXj * textSize, 0.0f);
        this.lXi.setLocalMatrix(this.matrix);
        textPaint.setShader(this.lXi);
    }
}
