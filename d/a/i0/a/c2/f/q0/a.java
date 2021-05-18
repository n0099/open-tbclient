package d.a.i0.a.c2.f.q0;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import d.a.i0.a.a2.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e0.d;
import d.a.i0.a.k2.b;
import d.a.i0.a.v2.n0;
import d.a.i0.a.v2.q;
import d.a.i0.a.v2.q0;
import d.a.i0.a.v2.w;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public String f41072c;

    /* renamed from: d.a.i0.a.c2.f.q0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0578a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41073e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41074f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f41075g;

        /* renamed from: d.a.i0.a.c2.f.q0.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0579a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f41077e;

            public RunnableC0579a(Bitmap bitmap) {
                this.f41077e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC0578a runnableC0578a = RunnableC0578a.this;
                a.this.o(this.f41077e, runnableC0578a.f41073e, runnableC0578a.f41074f, runnableC0578a.f41075g);
            }
        }

        public RunnableC0578a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
            this.f41073e = unitedSchemeEntity;
            this.f41074f = callbackHandler;
            this.f41075g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap z = n0.z();
            if (z == null) {
                a.this.n(this.f41073e, this.f41074f, "can't get screenshot");
            } else {
                q.j(new RunnableC0579a(z), "savescreenshot");
            }
        }
    }

    public a(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getScreenshot");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.b("Screenshot", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        String optString = w.d(unitedSchemeEntity.getParam("params")).optString("name");
        this.f41072c = optString;
        if (TextUtils.isEmpty(optString)) {
            d.b("Screenshot", "invalid params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        m(unitedSchemeEntity, callbackHandler, eVar);
        return true;
    }

    public final JSONObject l(boolean z, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f41072c);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("message", str2);
            }
            if (z) {
                jSONObject.put("path", str);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final void m(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, @NonNull e eVar) {
        q0.b0(new RunnableC0578a(unitedSchemeEntity, callbackHandler, eVar));
    }

    public final void n(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        d.b("Screenshot", str);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(l(false, null, str), 0));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x00b4 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x00b6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0073 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00c4 -> B:37:0x00d9). Please submit an issue!!! */
    public final void o(@NonNull Bitmap bitmap, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, @NonNull e eVar) {
        FileOutputStream fileOutputStream;
        String x = b.x(eVar.f40575f);
        if (x != null) {
            String str = x + File.separator + "screenshot";
            File file = new File(str);
            if (!file.exists() || !file.isDirectory()) {
                file.delete();
                if (!file.mkdir()) {
                    n(unitedSchemeEntity, callbackHandler, "mkdir fail");
                    return;
                }
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
            String str2 = str + File.separator + simpleDateFormat.format(new Date()) + this.f41072c + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
            FileOutputStream fileOutputStream2 = null;
            FileOutputStream fileOutputStream3 = null;
            fileOutputStream2 = null;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(str2);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                n(unitedSchemeEntity, callbackHandler, "save screenshot fail");
                fileOutputStream2 = fileOutputStream2;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                String str3 = "save screenshot to " + str2;
                d.g("Screenshot", str3);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(l(true, b.J(str2, eVar.f40575f), "success"), 0));
                fileOutputStream.close();
                fileOutputStream2 = str3;
            } catch (FileNotFoundException e4) {
                e = e4;
                fileOutputStream3 = fileOutputStream;
                e.printStackTrace();
                n(unitedSchemeEntity, callbackHandler, "save screenshot fail");
                fileOutputStream2 = fileOutputStream3;
                if (fileOutputStream3 != null) {
                    fileOutputStream3.close();
                    fileOutputStream2 = fileOutputStream3;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        n(unitedSchemeEntity, callbackHandler, "save screenshot fail");
                    }
                }
                throw th;
            }
        }
    }
}
