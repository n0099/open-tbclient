package d.a.l0.a.c0.a.c;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import android.util.Log;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public class a implements LineHeightSpan {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f40827f = k.f43199a;

    /* renamed from: e  reason: collision with root package name */
    public final int f40828e;

    public a(int i2) {
        this.f40828e = i2;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i2, int i3, int i4, int i5, Paint.FontMetricsInt fontMetricsInt) {
        int i6;
        if (f40827f) {
            Log.i("AdjustLineHeightSpan", "chooseHeight :: in fm=" + fontMetricsInt);
            Log.i("AdjustLineHeightSpan", "chooseHeight :: in height=" + this.f40828e);
        }
        if (this.f40828e < 0 || (i6 = fontMetricsInt.descent - fontMetricsInt.ascent) < 0) {
            return;
        }
        if (f40827f) {
            Log.i("AdjustLineHeightSpan", "chooseHeight :: in originHeight=" + i6);
        }
        int i7 = (this.f40828e - i6) / 2;
        if (f40827f) {
            Log.i("AdjustLineHeightSpan", "chooseHeight :: in hafDiff=" + i7);
        }
        fontMetricsInt.descent += i7;
        fontMetricsInt.ascent -= i7;
        if (f40827f) {
            Log.i("AdjustLineHeightSpan", "chooseHeight :: out fm=" + fontMetricsInt);
        }
    }
}
