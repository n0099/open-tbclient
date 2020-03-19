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
    public int lPJ = 90;
    private int lPK = 8;
    private Shader lPL = null;
    private Matrix matrix = new Matrix();
    private float lPM = 0.0f;

    /* loaded from: classes5.dex */
    public static class a {
        private int lPJ;
        private int lPK;
        private int[] mColors;

        public a ba(ArrayList<String> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                this.mColors = new int[arrayList.size()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    try {
                        this.mColors[i2] = Color.parseColor(Pb(arrayList.get(i2)));
                    } catch (Exception e) {
                    }
                    i = i2 + 1;
                }
            }
            return this;
        }

        public a HX(int i) {
            this.lPK = i;
            return this;
        }

        private String Pb(String str) {
            if (str.indexOf("#") == -1) {
                return null;
            }
            return str.replace("#", "#FF");
        }

        public c dnI() {
            c cVar = new c();
            if (this.mColors != null) {
                cVar.colors = this.mColors;
            }
            if (this.lPJ != 0) {
                cVar.lPJ = this.lPJ;
            }
            if (this.lPK != 0) {
                cVar.lPK = this.lPK;
            }
            return cVar;
        }
    }

    public void br(float f) {
        this.lPM = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setStyle(Paint.Style.FILL);
        float textSize = textPaint.getTextSize() * this.lPK;
        if (this.lPL == null) {
            this.lPL = new LinearGradient(0.0f, 0.0f, 0.0f, textSize, this.colors, (float[]) null, Shader.TileMode.MIRROR);
        }
        this.matrix.reset();
        this.matrix.setRotate(this.lPJ);
        this.matrix.postTranslate(this.lPM * textSize, 0.0f);
        this.lPL.setLocalMatrix(this.matrix);
        textPaint.setShader(this.lPL);
    }
}
