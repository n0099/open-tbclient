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
    public int mre = 90;
    private int mrf = 8;
    private Shader mrg = null;
    private Matrix matrix = new Matrix();
    private float mrh = 0.0f;

    /* loaded from: classes5.dex */
    public static class a {
        private int[] mColors;
        private int mre;
        private int mrf;

        public a aZ(ArrayList<String> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                this.mColors = new int[arrayList.size()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    try {
                        this.mColors[i2] = Color.parseColor(PZ(arrayList.get(i2)));
                    } catch (Exception e) {
                    }
                    i = i2 + 1;
                }
            }
            return this;
        }

        public a Hk(int i) {
            this.mrf = i;
            return this;
        }

        private String PZ(String str) {
            if (str.indexOf("#") == -1) {
                return null;
            }
            return str.replace("#", "#FF");
        }

        public c dwS() {
            c cVar = new c();
            if (this.mColors != null) {
                cVar.colors = this.mColors;
            }
            if (this.mre != 0) {
                cVar.mre = this.mre;
            }
            if (this.mrf != 0) {
                cVar.mrf = this.mrf;
            }
            return cVar;
        }
    }

    public void aG(float f) {
        this.mrh = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setStyle(Paint.Style.FILL);
        float textSize = textPaint.getTextSize() * this.mrf;
        if (this.mrg == null) {
            this.mrg = new LinearGradient(0.0f, 0.0f, 0.0f, textSize, this.colors, (float[]) null, Shader.TileMode.MIRROR);
        }
        this.matrix.reset();
        this.matrix.setRotate(this.mre);
        this.matrix.postTranslate(this.mrh * textSize, 0.0f);
        this.mrg.setLocalMatrix(this.matrix);
        textPaint.setShader(this.mrg);
    }
}
