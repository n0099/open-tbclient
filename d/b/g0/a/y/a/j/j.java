package d.b.g0.a.y.a.j;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j extends a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f46998d = d.b.g0.a.k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f46999a;

    /* renamed from: b  reason: collision with root package name */
    public String f47000b;

    /* renamed from: c  reason: collision with root package name */
    public Matrix f47001c;

    public j(String str) {
        this.f47000b = str;
    }

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        Matrix matrix;
        Bitmap bitmap = this.f46999a;
        if (bitmap == null || (matrix = this.f47001c) == null) {
            return;
        }
        canvas.drawBitmap(bitmap, matrix, bVar.f46972h);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
    }

    public int c() {
        try {
            JSONObject jSONObject = new JSONObject(this.f47000b);
            int f2 = d.b.g0.a.i2.h0.f((float) jSONObject.optDouble("x"));
            int f3 = d.b.g0.a.i2.h0.f((float) jSONObject.optDouble("y"));
            int optInt = jSONObject.optInt("width");
            int optInt2 = jSONObject.optInt("height");
            if (optInt <= 0 || optInt2 <= 0) {
                return 2002;
            }
            float f4 = d.b.g0.a.i2.h0.f(optInt);
            float f5 = d.b.g0.a.i2.h0.f(optInt2);
            String optString = jSONObject.optString("data");
            if (TextUtils.isEmpty(optString)) {
                return 2001;
            }
            try {
                byte[] decode = Base64.decode(optString, 2);
                int i = optInt * optInt2 * 4;
                if (decode != null && decode.length == i) {
                    this.f46999a = e(d(decode, optInt, optInt2), f4, f5);
                    Matrix matrix = new Matrix();
                    this.f47001c = matrix;
                    matrix.postTranslate(f2, f3);
                    return 0;
                }
                return 2001;
            } catch (Exception e2) {
                if (f46998d) {
                    e2.printStackTrace();
                }
                d.b.g0.a.c0.c.b("canvasPutImageData", "canvasGetImageData meets exception in decoding bitmap");
                return 1001;
            }
        } catch (JSONException e3) {
            if (f46998d) {
                e3.printStackTrace();
            }
            return 1001;
        }
    }

    @NonNull
    public final Bitmap d(@NonNull byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 * 4;
            iArr[i4] = Color.argb(bArr[i5 + 3] & 255, bArr[i5] & 255, bArr[i5 + 1] & 255, bArr[i5 + 2] & 255);
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
        createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return createBitmap;
    }

    @NonNull
    public final Bitmap e(@NonNull Bitmap bitmap, float f2, float f3) {
        Matrix matrix = new Matrix();
        matrix.postScale(f2 / bitmap.getWidth(), f3 / bitmap.getHeight());
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
