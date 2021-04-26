package d.a.h0.a.y.a.j;

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
    public static final boolean f45152d = d.a.h0.a.k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f45153a;

    /* renamed from: b  reason: collision with root package name */
    public String f45154b;

    /* renamed from: c  reason: collision with root package name */
    public Matrix f45155c;

    public j(String str) {
        this.f45154b = str;
    }

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        Matrix matrix;
        Bitmap bitmap = this.f45153a;
        if (bitmap == null || (matrix = this.f45155c) == null) {
            return;
        }
        canvas.drawBitmap(bitmap, matrix, bVar.f45125h);
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
    }

    public int c() {
        try {
            JSONObject jSONObject = new JSONObject(this.f45154b);
            int f2 = d.a.h0.a.i2.h0.f((float) jSONObject.optDouble("x"));
            int f3 = d.a.h0.a.i2.h0.f((float) jSONObject.optDouble("y"));
            int optInt = jSONObject.optInt("width");
            int optInt2 = jSONObject.optInt("height");
            if (optInt <= 0 || optInt2 <= 0) {
                return 2002;
            }
            float f4 = d.a.h0.a.i2.h0.f(optInt);
            float f5 = d.a.h0.a.i2.h0.f(optInt2);
            String optString = jSONObject.optString("data");
            if (TextUtils.isEmpty(optString)) {
                return 2001;
            }
            try {
                byte[] decode = Base64.decode(optString, 2);
                int i2 = optInt * optInt2 * 4;
                if (decode != null && decode.length == i2) {
                    this.f45153a = e(d(decode, optInt, optInt2), f4, f5);
                    Matrix matrix = new Matrix();
                    this.f45155c = matrix;
                    matrix.postTranslate(f2, f3);
                    return 0;
                }
                return 2001;
            } catch (Exception e2) {
                if (f45152d) {
                    e2.printStackTrace();
                }
                d.a.h0.a.c0.c.b("canvasPutImageData", "canvasGetImageData meets exception in decoding bitmap");
                return 1001;
            }
        } catch (JSONException e3) {
            if (f45152d) {
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
