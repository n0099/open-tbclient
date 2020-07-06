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
    public int mOp = 90;
    private int mOq = 8;
    private Shader mOr = null;
    private Matrix matrix = new Matrix();
    private float mOs = 0.0f;

    /* loaded from: classes5.dex */
    public static class a {
        private int[] mColors;
        private int mOp;
        private int mOq;

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
                        this.mColors[i2] = Color.parseColor(QN(arrayList.get(i2)));
                    } catch (Exception e) {
                    }
                    i = i2 + 1;
                }
            }
            return this;
        }

        public a It(int i) {
            this.mOq = i;
            return this;
        }

        private String QN(String str) {
            if (str.indexOf("#") == -1) {
                return null;
            }
            return str.replace("#", "#FF");
        }

        public c dBM() {
            c cVar = new c();
            if (this.mColors != null) {
                cVar.colors = this.mColors;
            }
            if (this.mOp != 0) {
                cVar.mOp = this.mOp;
            }
            if (this.mOq != 0) {
                cVar.mOq = this.mOq;
            }
            return cVar;
        }
    }

    public void aM(float f) {
        this.mOs = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setStyle(Paint.Style.FILL);
        float textSize = textPaint.getTextSize() * this.mOq;
        if (this.mOr == null) {
            this.mOr = new LinearGradient(0.0f, 0.0f, 0.0f, textSize, this.colors, (float[]) null, Shader.TileMode.MIRROR);
        }
        this.matrix.reset();
        this.matrix.setRotate(this.mOp);
        this.matrix.postTranslate(this.mOs * textSize, 0.0f);
        this.mOr.setLocalMatrix(this.matrix);
        textPaint.setShader(this.mOr);
    }
}
