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
    public int oSo = 90;
    private int oIS = 8;
    private Shader oSp = null;
    private Matrix matrix = new Matrix();
    private float oSq = 0.0f;

    /* loaded from: classes6.dex */
    public static class a {
        private int[] mColors;
        private int oIS;
        private int oSo;

        public a bo(ArrayList<String> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                this.mColors = new int[arrayList.size()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    try {
                        this.mColors[i2] = Color.parseColor(XU(arrayList.get(i2)));
                    } catch (Exception e) {
                    }
                    i = i2 + 1;
                }
            }
            return this;
        }

        public a Ps(int i) {
            this.oIS = i;
            return this;
        }

        private String XU(String str) {
            if (str.indexOf("#") == -1) {
                return null;
            }
            return str.replace("#", "#FF");
        }

        public c emB() {
            c cVar = new c();
            if (this.mColors != null) {
                cVar.colors = this.mColors;
            }
            if (this.oSo != 0) {
                cVar.oSo = this.oSo;
            }
            if (this.oIS != 0) {
                cVar.oIS = this.oIS;
            }
            return cVar;
        }
    }

    public void bx(float f) {
        this.oSq = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setStyle(Paint.Style.FILL);
        float textSize = textPaint.getTextSize() * this.oIS;
        if (this.oSp == null) {
            this.oSp = new LinearGradient(0.0f, 0.0f, 0.0f, textSize, this.colors, (float[]) null, Shader.TileMode.MIRROR);
        }
        this.matrix.reset();
        this.matrix.setRotate(this.oSo);
        this.matrix.postTranslate(this.oSq * textSize, 0.0f);
        this.oSp.setLocalMatrix(this.matrix);
        textPaint.setShader(this.oSp);
    }
}
