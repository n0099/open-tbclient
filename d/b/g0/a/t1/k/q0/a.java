package d.b.g0.a.t1.k.q0;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import d.b.g0.a.a2.b;
import d.b.g0.a.c0.c;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.p;
import d.b.g0.a.i2.v;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public String f46543c;

    /* renamed from: d.b.g0.a.t1.k.q0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0844a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46544e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46545f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f46546g;

        /* renamed from: d.b.g0.a.t1.k.q0.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0845a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f46548e;

            public RunnableC0845a(Bitmap bitmap) {
                this.f46548e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC0844a runnableC0844a = RunnableC0844a.this;
                a.this.o(this.f46548e, runnableC0844a.f46544e, runnableC0844a.f46545f, runnableC0844a.f46546g);
            }
        }

        public RunnableC0844a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
            this.f46544e = unitedSchemeEntity;
            this.f46545f = callbackHandler;
            this.f46546g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap x = h0.x();
            if (x == null) {
                a.this.n(this.f46544e, this.f46545f, "can't get screenshot");
            } else {
                p.k(new RunnableC0845a(x), "savescreenshot");
            }
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/getScreenshot");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.b("Screenshot", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        String optString = v.b(unitedSchemeEntity.getParam("params")).optString("name");
        this.f46543c = optString;
        if (TextUtils.isEmpty(optString)) {
            c.b("Screenshot", "invalid params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        m(unitedSchemeEntity, callbackHandler, eVar);
        return true;
    }

    public final JSONObject l(boolean z, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f46543c);
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
        k0.X(new RunnableC0844a(unitedSchemeEntity, callbackHandler, eVar));
    }

    public final void n(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        c.b("Screenshot", str);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(l(false, null, str), 0));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x00b0 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x00b2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x006f */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00c0 -> B:37:0x00d5). Please submit an issue!!! */
    public final void o(@NonNull Bitmap bitmap, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, @NonNull e eVar) {
        FileOutputStream fileOutputStream;
        String h2 = b.h(eVar.f45739f);
        if (h2 != null) {
            String str = h2 + File.separator + "screenshot";
            File file = new File(str);
            if (!file.exists() || !file.isDirectory()) {
                file.delete();
                if (!file.mkdir()) {
                    n(unitedSchemeEntity, callbackHandler, "mkdir fail");
                    return;
                }
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String str2 = str + File.separator + simpleDateFormat.format(new Date()) + this.f46543c + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
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
                c.g("Screenshot", str3);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(l(true, b.r(str2, eVar.f45739f), "success"), 0));
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
