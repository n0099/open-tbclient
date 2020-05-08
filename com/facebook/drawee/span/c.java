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
    public int lXk = 90;
    private int lXl = 8;
    private Shader lXm = null;
    private Matrix matrix = new Matrix();
    private float lXn = 0.0f;

    /* loaded from: classes5.dex */
    public static class a {
        private int lXk;
        private int lXl;
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
                        this.mColors[i2] = Color.parseColor(Ol(arrayList.get(i2)));
                    } catch (Exception e) {
                    }
                    i = i2 + 1;
                }
            }
            return this;
        }

        public a Gy(int i) {
            this.lXl = i;
            return this;
        }

        private String Ol(String str) {
            if (str.indexOf("#") == -1) {
                return null;
            }
            return str.replace("#", "#FF");
        }

        public c dpz() {
            c cVar = new c();
            if (this.mColors != null) {
                cVar.colors = this.mColors;
            }
            if (this.lXk != 0) {
                cVar.lXk = this.lXk;
            }
            if (this.lXl != 0) {
                cVar.lXl = this.lXl;
            }
            return cVar;
        }
    }

    public void aH(float f) {
        this.lXn = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setStyle(Paint.Style.FILL);
        float textSize = textPaint.getTextSize() * this.lXl;
        if (this.lXm == null) {
            this.lXm = new LinearGradient(0.0f, 0.0f, 0.0f, textSize, this.colors, (float[]) null, Shader.TileMode.MIRROR);
        }
        this.matrix.reset();
        this.matrix.setRotate(this.lXk);
        this.matrix.postTranslate(this.lXn * textSize, 0.0f);
        this.lXm.setLocalMatrix(this.matrix);
        textPaint.setShader(this.lXm);
    }
}
