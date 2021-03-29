package d.b.g0.a.x;

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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.webkit.sdk.PermissionRequest;
import d.b.g0.a.i2.g0;
import d.b.g0.a.k;
import d.b.g0.a.z0.f;
import d.b.g0.p.d;
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
    public static final boolean f46877c = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public Timer f46878a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.a.x.c.b f46879b;

    /* renamed from: d.b.g0.a.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0875a extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.x.c.b f46880e;

        public C0875a(d.b.g0.a.x.c.b bVar) {
            this.f46880e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.b.g0.a.x.c.b bVar = this.f46880e;
            if (bVar != null) {
                bVar.a();
            }
            a.this.j();
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f46882a = new a(null);
    }

    public /* synthetic */ a(C0875a c0875a) {
        this();
    }

    public static a b() {
        return b.f46882a;
    }

    public void a() {
        d.b.g0.a.x.c.b bVar = this.f46879b;
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
        if (g0.b("1.13.0")) {
            HashMap hashMap = new HashMap();
            hashMap.put("wvID", str);
            hashMap.put("cameraId", str2);
            hashMap.put("eType", z ? "error" : IntentConfig.STOP);
            f.V().N(new d.b.g0.a.k0.b.b(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA, hashMap));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str);
            jSONObject.put("cameraId", str2);
            if (!z) {
                str3 = IntentConfig.STOP;
            }
            jSONObject.put("eType", str3);
        } catch (JSONException e2) {
            if (f46877c) {
                e2.printStackTrace();
            }
        }
        d.b.g0.a.j2.f.c.a.d(str, str2, BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA, jSONObject.optString("eType"), jSONObject);
    }

    public void f() {
        try {
            CameraPreview.j();
        } catch (Exception e2) {
            if (f46877c) {
                e2.printStackTrace();
            }
        }
    }

    public void g(boolean z) {
        if (z) {
            a();
        }
    }

    public boolean h(byte[] bArr, String str, int i, int i2, boolean z) {
        if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                boolean delete = file.delete();
                if (f46877c) {
                    Log.d("SwanAppCameraManager", "delete = " + delete);
                }
            }
            if (file.getParentFile() != null) {
                boolean mkdirs = file.getParentFile().mkdirs();
                if (f46877c) {
                    Log.d("SwanAppCameraManager", "mkdirs = " + mkdirs);
                }
            }
            boolean createNewFile = file.createNewFile();
            if (f46877c) {
                Log.d("SwanAppCameraManager", "createNewFile = " + createNewFile);
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (i2 != 0 || z) {
                Matrix matrix = new Matrix();
                matrix.reset();
                if (i2 != 0) {
                    matrix.postRotate(i2);
                }
                if (z) {
                    matrix.postScale(-1.0f, 1.0f);
                }
                decodeByteArray = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            decodeByteArray.compress(Bitmap.CompressFormat.JPEG, i, bufferedOutputStream);
            bufferedOutputStream.flush();
            d.a(bufferedOutputStream);
            return true;
        } catch (Exception e2) {
            if (f46877c) {
                e2.printStackTrace();
                return false;
            }
            return false;
        } catch (OutOfMemoryError e3) {
            if (f46877c) {
                e3.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public void i(int i, d.b.g0.a.x.c.b bVar) {
        this.f46879b = bVar;
        Timer timer = new Timer();
        this.f46878a = timer;
        timer.schedule(new C0875a(bVar), i);
    }

    public void j() {
        this.f46879b = null;
        Timer timer = this.f46878a;
        if (timer != null) {
            timer.cancel();
        }
    }

    public a() {
    }
}
