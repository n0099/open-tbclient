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
    public int lNj = 90;
    private int lNk = 8;
    private Shader lNl = null;
    private Matrix matrix = new Matrix();
    private float lNm = 0.0f;

    /* loaded from: classes4.dex */
    public static class a {
        private int lNj;
        private int lNk;
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
            this.lNk = i;
            return this;
        }

        private String ON(String str) {
            if (str.indexOf("#") == -1) {
                return null;
            }
            return str.replace("#", "#FF");
        }

        public c dlV() {
            c cVar = new c();
            if (this.mColors != null) {
                cVar.colors = this.mColors;
            }
            if (this.lNj != 0) {
                cVar.lNj = this.lNj;
            }
            if (this.lNk != 0) {
                cVar.lNk = this.lNk;
            }
            return cVar;
        }
    }

    public void bs(float f) {
        this.lNm = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setStyle(Paint.Style.FILL);
        float textSize = textPaint.getTextSize() * this.lNk;
        if (this.lNl == null) {
            this.lNl = new LinearGradient(0.0f, 0.0f, 0.0f, textSize, this.colors, (float[]) null, Shader.TileMode.MIRROR);
        }
        this.matrix.reset();
        this.matrix.setRotate(this.lNj);
        this.matrix.postTranslate(this.lNm * textSize, 0.0f);
        this.lNl.setLocalMatrix(this.matrix);
        textPaint.setShader(this.lNl);
    }
}
