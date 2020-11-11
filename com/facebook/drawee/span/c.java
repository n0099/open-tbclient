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
    public int oQL = 90;
    private int oHo = 8;
    private Shader oQM = null;
    private Matrix matrix = new Matrix();
    private float oQN = 0.0f;

    /* loaded from: classes6.dex */
    public static class a {
        private int[] mColors;
        private int oHo;
        private int oQL;

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
                        this.mColors[i2] = Color.parseColor(Yj(arrayList.get(i2)));
                    } catch (Exception e) {
                    }
                    i = i2 + 1;
                }
            }
            return this;
        }

        public a OP(int i) {
            this.oHo = i;
            return this;
        }

        private String Yj(String str) {
            if (str.indexOf("#") == -1) {
                return null;
            }
            return str.replace("#", "#FF");
        }

        public c emD() {
            c cVar = new c();
            if (this.mColors != null) {
                cVar.colors = this.mColors;
            }
            if (this.oQL != 0) {
                cVar.oQL = this.oQL;
            }
            if (this.oHo != 0) {
                cVar.oHo = this.oHo;
            }
            return cVar;
        }
    }

    public void bq(float f) {
        this.oQN = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setStyle(Paint.Style.FILL);
        float textSize = textPaint.getTextSize() * this.oHo;
        if (this.oQM == null) {
            this.oQM = new LinearGradient(0.0f, 0.0f, 0.0f, textSize, this.colors, (float[]) null, Shader.TileMode.MIRROR);
        }
        this.matrix.reset();
        this.matrix.setRotate(this.oQL);
        this.matrix.postTranslate(this.oQN * textSize, 0.0f);
        this.oQM.setLocalMatrix(this.matrix);
        textPaint.setShader(this.oQM);
    }
}
