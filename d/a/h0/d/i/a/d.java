package d.a.h0.d.i.a;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.h0.a.k;
import d.a.h0.a.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45675a = k.f43101a;

    @Override // d.a.h0.d.i.a.a
    @Nullable
    public Cursor c(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        String f2 = f();
        if (f45675a) {
            Log.i("ParamsProcessor", "params: " + f2);
        }
        String g2 = g(f2);
        if (f45675a) {
            Log.i("ParamsProcessor", "encryption params: " + g2);
        }
        return e(g2);
    }

    public final Cursor e(String str) {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"params"}, 1);
        matrixCursor.newRow().add("params", str);
        return matrixCursor;
    }

    public final String f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swan_sdk_version", l.a());
            jSONObject.put("swan_core_version", d.a.h0.a.b2.b.f(0));
            jSONObject.put("game_core_version", d.a.h0.a.b2.b.f(1));
            jSONObject.put("uid", d.a.h0.a.w0.a.O().f(AppRuntime.getAppContext()));
            jSONObject.put("puid", d.a.h0.a.w0.a.O().e(AppRuntime.getAppContext()));
            jSONObject.put("ua", d.a.h0.a.b0.c.r());
            jSONObject.put("ut", d.a.h0.a.b0.c.e());
            jSONObject.put("timestamp", System.currentTimeMillis());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public final String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Base64.encodeToString(d.a.h0.d.i.b.b.b(str.getBytes(), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDI4nl5QCs/mwaPjm2H4cHaxTBya7F1S1f2IXBwfEB6QD16esL+37EX+SeGR3NQ+0Xxs32Bpl/E70xlII24e/E6GJnU1vks/d1+h4rBjv987X2eppIBrT8f6COjczYcUm0OBa7IGmAMnqMCnOt/U1Wx3Mn7zniQKueT5DjQBOuxyQIDAQAB", 117), 10);
    }
}
