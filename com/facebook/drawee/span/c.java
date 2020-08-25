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
    public int nqq = 90;
    private int nqr = 8;
    private Shader nqs = null;
    private Matrix matrix = new Matrix();
    private float nqt = 0.0f;

    /* loaded from: classes6.dex */
    public static class a {
        private int[] mColors;
        private int nqq;
        private int nqr;

        public a bh(ArrayList<String> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                this.mColors = new int[arrayList.size()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    try {
                        this.mColors[i2] = Color.parseColor(UC(arrayList.get(i2)));
                    } catch (Exception e) {
                    }
                    i = i2 + 1;
                }
            }
            return this;
        }

        public a Ls(int i) {
            this.nqr = i;
            return this;
        }

        private String UC(String str) {
            if (str.indexOf("#") == -1) {
                return null;
            }
            return str.replace("#", "#FF");
        }

        public c dQY() {
            c cVar = new c();
            if (this.mColors != null) {
                cVar.colors = this.mColors;
            }
            if (this.nqq != 0) {
                cVar.nqq = this.nqq;
            }
            if (this.nqr != 0) {
                cVar.nqr = this.nqr;
            }
            return cVar;
        }
    }

    public void aR(float f) {
        this.nqt = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setStyle(Paint.Style.FILL);
        float textSize = textPaint.getTextSize() * this.nqr;
        if (this.nqs == null) {
            this.nqs = new LinearGradient(0.0f, 0.0f, 0.0f, textSize, this.colors, (float[]) null, Shader.TileMode.MIRROR);
        }
        this.matrix.reset();
        this.matrix.setRotate(this.nqq);
        this.matrix.postTranslate(this.nqt * textSize, 0.0f);
        this.nqs.setLocalMatrix(this.matrix);
        textPaint.setShader(this.nqs);
    }
}
