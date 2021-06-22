package d.a.m0.a.a0.a.j;

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
    public static final boolean f44400d = d.a.m0.a.k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f44401a;

    /* renamed from: b  reason: collision with root package name */
    public String f44402b;

    /* renamed from: c  reason: collision with root package name */
    public Matrix f44403c;

    public j(String str) {
        this.f44402b = str;
    }

    @Override // d.a.m0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Matrix matrix;
        Bitmap bitmap = this.f44401a;
        if (bitmap == null || (matrix = this.f44403c) == null) {
            return;
        }
        canvas.drawBitmap(bitmap, matrix, bVar.f44373h);
    }

    @Override // d.a.m0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
    }

    public int c() {
        try {
            JSONObject jSONObject = new JSONObject(this.f44402b);
            int g2 = d.a.m0.a.v2.n0.g((float) jSONObject.optDouble("x"));
            int g3 = d.a.m0.a.v2.n0.g((float) jSONObject.optDouble("y"));
            int optInt = jSONObject.optInt("width");
            int optInt2 = jSONObject.optInt("height");
            if (optInt <= 0 || optInt2 <= 0) {
                return 2002;
            }
            float g4 = d.a.m0.a.v2.n0.g(optInt);
            float g5 = d.a.m0.a.v2.n0.g(optInt2);
            String optString = jSONObject.optString("data");
            if (TextUtils.isEmpty(optString)) {
                return 2001;
            }
            try {
                byte[] decode = Base64.decode(optString, 2);
                int i2 = optInt * optInt2 * 4;
                if (decode != null && decode.length == i2) {
                    this.f44401a = e(d(decode, optInt, optInt2), g4, g5);
                    Matrix matrix = new Matrix();
                    this.f44403c = matrix;
                    matrix.postTranslate(g2, g3);
                    return 0;
                }
                return 2001;
            } catch (Exception e2) {
                if (f44400d) {
                    e2.printStackTrace();
                }
                d.a.m0.a.e0.d.b("canvasPutImageData", "canvasGetImageData meets exception in decoding bitmap");
                return 1001;
            }
        } catch (JSONException e3) {
            if (f44400d) {
                e3.printStackTrace();
            }
            return 1001;
        }
    }

    @NonNull
    public final Bitmap d(@NonNull byte[] bArr, int i2, int i3) {
        int i4 = i2 * i3;
        int[] iArr = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i5 * 4;
            iArr[i5] = Color.argb(bArr[i6 + 3] & 255, bArr[i6] & 255, bArr[i6 + 1] & 255, bArr[i6 + 2] & 255);
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_4444);
        createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        return createBitmap;
    }

    @NonNull
    public final Bitmap e(@NonNull Bitmap bitmap, float f2, float f3) {
        Matrix matrix = new Matrix();
        matrix.postScale(f2 / bitmap.getWidth(), f3 / bitmap.getHeight());
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
