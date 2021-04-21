package d.b.h0.a.y.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.Base64;
import android.view.View;
import androidx.annotation.NonNull;
import d.b.h0.a.i2.h0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends a {
    public int o;
    public int p;
    public int q;
    public int r;

    public c(String str) {
        super(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.o = h0.f((float) jSONObject.optDouble("x"));
            this.p = h0.f((float) jSONObject.optDouble("y"));
            this.q = h0.f((float) jSONObject.optDouble("width"));
            this.r = h0.f((float) jSONObject.optDouble("height"));
        } catch (Exception e2) {
            d.b.h0.a.c0.c.c("canvasGetImageData", "CanvasGetImageData meets json exception", e2);
        }
    }

    public final byte[] h(@NonNull Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[i * 4];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            int i4 = i2 * 4;
            bArr[i4] = (byte) Color.red(i3);
            bArr[i4 + 1] = (byte) Color.green(i3);
            bArr[i4 + 2] = (byte) Color.blue(i3);
            bArr[i4 + 3] = (byte) Color.alpha(i3);
        }
        return bArr;
    }

    public JSONObject i(@NonNull View view) {
        String str;
        int i;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = 0;
        if (measuredWidth > 0 && measuredHeight > 0) {
            int i3 = this.o;
            this.o = (i3 < 0 || i3 >= measuredWidth) ? 0 : 0;
            int i4 = this.p;
            this.p = (i4 < 0 || i4 >= measuredHeight) ? 0 : 0;
            int i5 = this.q;
            if (i5 <= 0 || this.o + i5 > measuredWidth) {
                i5 = measuredWidth - this.o;
            }
            this.q = i5;
            int i6 = this.r;
            if (i6 <= 0 || this.p + i6 > measuredHeight) {
                i6 = measuredHeight - this.p;
            }
            this.r = i6;
            Bitmap createBitmap = Bitmap.createBitmap(this.q, i6, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.translate(-this.o, -this.p);
            view.draw(canvas);
            Bitmap j = j(createBitmap);
            str = Base64.encodeToString(h(j), 2);
            i2 = j.getWidth();
            i = j.getHeight();
        } else {
            d.b.h0.a.c0.c.a("canvasGetImageData", "canvas size is invalid.");
            str = "";
            i = 0;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", i2);
            jSONObject.put("height", i);
            jSONObject.put("data", str);
        } catch (Exception e2) {
            d.b.h0.a.c0.c.c("canvasGetImageData", "CanvasGetImageData meets json exception", e2);
        }
        return jSONObject;
    }

    @NonNull
    public final Bitmap j(@NonNull Bitmap bitmap) {
        float j = 1.0f / h0.j(d.b.h0.a.w0.a.c());
        Matrix matrix = new Matrix();
        matrix.postScale(j, j);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
