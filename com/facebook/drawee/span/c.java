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
    public int mOm = 90;
    private int mOn = 8;
    private Shader mOo = null;
    private Matrix matrix = new Matrix();
    private float mOp = 0.0f;

    /* loaded from: classes5.dex */
    public static class a {
        private int[] mColors;
        private int mOm;
        private int mOn;

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
                        this.mColors[i2] = Color.parseColor(QM(arrayList.get(i2)));
                    } catch (Exception e) {
                    }
                    i = i2 + 1;
                }
            }
            return this;
        }

        public a It(int i) {
            this.mOn = i;
            return this;
        }

        private String QM(String str) {
            if (str.indexOf("#") == -1) {
                return null;
            }
            return str.replace("#", "#FF");
        }

        public c dBI() {
            c cVar = new c();
            if (this.mColors != null) {
                cVar.colors = this.mColors;
            }
            if (this.mOm != 0) {
                cVar.mOm = this.mOm;
            }
            if (this.mOn != 0) {
                cVar.mOn = this.mOn;
            }
            return cVar;
        }
    }

    public void aM(float f) {
        this.mOp = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setStyle(Paint.Style.FILL);
        float textSize = textPaint.getTextSize() * this.mOn;
        if (this.mOo == null) {
            this.mOo = new LinearGradient(0.0f, 0.0f, 0.0f, textSize, this.colors, (float[]) null, Shader.TileMode.MIRROR);
        }
        this.matrix.reset();
        this.matrix.setRotate(this.mOm);
        this.matrix.postTranslate(this.mOp * textSize, 0.0f);
        this.mOo.setLocalMatrix(this.matrix);
        textPaint.setShader(this.mOo);
    }
}
