package d.a.m0.a.z;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.m0.a.g1.f;
import d.a.m0.a.k;
import d.a.m0.a.v2.l0;
import d.a.m0.t.d;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f49688c = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public Timer f49689a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.a.z.c.b f49690b;

    /* renamed from: d.a.m0.a.z.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0982a extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.z.c.b f49691e;

        public C0982a(d.a.m0.a.z.c.b bVar) {
            this.f49691e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.a.m0.a.z.c.b bVar = this.f49691e;
            if (bVar != null) {
                bVar.a();
            }
            a.this.j();
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f49693a = new a(null);
    }

    public /* synthetic */ a(C0982a c0982a) {
        this();
    }

    public static a b() {
        return b.f49693a;
    }

    public void a() {
        d.a.m0.a.z.c.b bVar = this.f49690b;
        if (bVar != null) {
            bVar.cancel();
        }
        j();
    }

    public boolean c(Context context) {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0;
    }

    public boolean d(Context context) {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }

    public void e(String str, String str2, boolean z) {
        String str3;
        str3 = "error";
        if (l0.f("1.13.0")) {
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str);
            hashMap.put("cameraId", str2);
            hashMap.put("eType", z ? "error" : IntentConfig.STOP);
            f.V().v(new d.a.m0.a.o0.d.b(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA, hashMap));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str);
            jSONObject.put("cameraId", str2);
            if (!z) {
                str3 = IntentConfig.STOP;
            }
            jSONObject.put("eType", str3);
        } catch (JSONException e2) {
            if (f49688c) {
                e2.printStackTrace();
            }
        }
        d.a.m0.a.w2.g.c.a.d(str, str2, BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA, jSONObject.optString("eType"), jSONObject);
    }

    public void f() {
        try {
            CameraPreview.j();
        } catch (Exception e2) {
            if (f49688c) {
                e2.printStackTrace();
            }
        }
    }

    public void g(boolean z) {
        if (z) {
            a();
        }
    }

    public boolean h(byte[] bArr, String str, int i2, int i3, boolean z) {
        if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                boolean delete = file.delete();
                if (f49688c) {
                    Log.d("SwanAppCameraManager", "delete = " + delete);
                }
            }
            if (file.getParentFile() != null) {
                boolean mkdirs = file.getParentFile().mkdirs();
                if (f49688c) {
                    Log.d("SwanAppCameraManager", "mkdirs = " + mkdirs);
                }
            }
            boolean createNewFile = file.createNewFile();
            if (f49688c) {
                Log.d("SwanAppCameraManager", "createNewFile = " + createNewFile);
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (i3 != 0 || z) {
                Matrix matrix = new Matrix();
                matrix.reset();
                if (i3 != 0) {
                    matrix.postRotate(i3);
                }
                if (z) {
                    matrix.postScale(-1.0f, 1.0f);
                }
                decodeByteArray = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            decodeByteArray.compress(Bitmap.CompressFormat.JPEG, i2, bufferedOutputStream);
            bufferedOutputStream.flush();
            d.d(bufferedOutputStream);
            return true;
        } catch (Exception e2) {
            if (f49688c) {
                e2.printStackTrace();
                return false;
            }
            return false;
        } catch (OutOfMemoryError e3) {
            if (f49688c) {
                e3.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public void i(int i2, d.a.m0.a.z.c.b bVar) {
        this.f49690b = bVar;
        Timer timer = new Timer();
        this.f49689a = timer;
        timer.schedule(new C0982a(bVar), i2);
    }

    public void j() {
        this.f49690b = null;
        Timer timer = this.f49689a;
        if (timer != null) {
            timer.cancel();
        }
    }

    public a() {
    }
}
