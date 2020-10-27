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
    public int oHs = 90;
    private int oxV = 8;
    private Shader oHt = null;
    private Matrix matrix = new Matrix();
    private float oHu = 0.0f;

    /* loaded from: classes6.dex */
    public static class a {
        private int[] mColors;
        private int oHs;
        private int oxV;

        public a bn(ArrayList<String> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                this.mColors = new int[arrayList.size()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    try {
                        this.mColors[i2] = Color.parseColor(XF(arrayList.get(i2)));
                    } catch (Exception e) {
                    }
                    i = i2 + 1;
                }
            }
            return this;
        }

        public a Ou(int i) {
            this.oxV = i;
            return this;
        }

        private String XF(String str) {
            if (str.indexOf("#") == -1) {
                return null;
            }
            return str.replace("#", "#FF");
        }

        public c eiO() {
            c cVar = new c();
            if (this.mColors != null) {
                cVar.colors = this.mColors;
            }
            if (this.oHs != 0) {
                cVar.oHs = this.oHs;
            }
            if (this.oxV != 0) {
                cVar.oxV = this.oxV;
            }
            return cVar;
        }
    }

    public void bo(float f) {
        this.oHu = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setStyle(Paint.Style.FILL);
        float textSize = textPaint.getTextSize() * this.oxV;
        if (this.oHt == null) {
            this.oHt = new LinearGradient(0.0f, 0.0f, 0.0f, textSize, this.colors, (float[]) null, Shader.TileMode.MIRROR);
        }
        this.matrix.reset();
        this.matrix.setRotate(this.oHs);
        this.matrix.postTranslate(this.oHu * textSize, 0.0f);
        this.oHt.setLocalMatrix(this.matrix);
        textPaint.setShader(this.oHt);
    }
}
