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
    public int lNS = 90;
    private int lNT = 8;
    private Shader lNU = null;
    private Matrix matrix = new Matrix();
    private float lNV = 0.0f;

    /* loaded from: classes5.dex */
    public static class a {
        private int lNS;
        private int lNT;
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
                        this.mColors[i2] = Color.parseColor(Pa(arrayList.get(i2)));
                    } catch (Exception e) {
                    }
                    i = i2 + 1;
                }
            }
            return this;
        }

        public a HR(int i) {
            this.lNT = i;
            return this;
        }

        private String Pa(String str) {
            if (str.indexOf("#") == -1) {
                return null;
            }
            return str.replace("#", "#FF");
        }

        public c dnj() {
            c cVar = new c();
            if (this.mColors != null) {
                cVar.colors = this.mColors;
            }
            if (this.lNS != 0) {
                cVar.lNS = this.lNS;
            }
            if (this.lNT != 0) {
                cVar.lNT = this.lNT;
            }
            return cVar;
        }
    }

    public void br(float f) {
        this.lNV = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setStyle(Paint.Style.FILL);
        float textSize = textPaint.getTextSize() * this.lNT;
        if (this.lNU == null) {
            this.lNU = new LinearGradient(0.0f, 0.0f, 0.0f, textSize, this.colors, (float[]) null, Shader.TileMode.MIRROR);
        }
        this.matrix.reset();
        this.matrix.setRotate(this.lNS);
        this.matrix.postTranslate(this.lNV * textSize, 0.0f);
        this.lNU.setLocalMatrix(this.matrix);
        textPaint.setShader(this.lNU);
    }
}
