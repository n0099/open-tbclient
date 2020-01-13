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
/* loaded from: classes4.dex */
public class c extends CharacterStyle implements UpdateAppearance {
    private int[] colors = {-17920, -6748254};
    public int lNe = 90;
    private int lNf = 8;
    private Shader lNg = null;
    private Matrix matrix = new Matrix();
    private float lNh = 0.0f;

    /* loaded from: classes4.dex */
    public static class a {
        private int lNe;
        private int lNf;
        private int[] mColors;

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
                        this.mColors[i2] = Color.parseColor(ON(arrayList.get(i2)));
                    } catch (Exception e) {
                    }
                    i = i2 + 1;
                }
            }
            return this;
        }

        public a HM(int i) {
            this.lNf = i;
            return this;
        }

        private String ON(String str) {
            if (str.indexOf("#") == -1) {
                return null;
            }
            return str.replace("#", "#FF");
        }

        public c dlT() {
            c cVar = new c();
            if (this.mColors != null) {
                cVar.colors = this.mColors;
            }
            if (this.lNe != 0) {
                cVar.lNe = this.lNe;
            }
            if (this.lNf != 0) {
                cVar.lNf = this.lNf;
            }
            return cVar;
        }
    }

    public void bs(float f) {
        this.lNh = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setStyle(Paint.Style.FILL);
        float textSize = textPaint.getTextSize() * this.lNf;
        if (this.lNg == null) {
            this.lNg = new LinearGradient(0.0f, 0.0f, 0.0f, textSize, this.colors, (float[]) null, Shader.TileMode.MIRROR);
        }
        this.matrix.reset();
        this.matrix.setRotate(this.lNe);
        this.matrix.postTranslate(this.lNh * textSize, 0.0f);
        this.lNg.setLocalMatrix(this.matrix);
        textPaint.setShader(this.lNg);
    }
}
