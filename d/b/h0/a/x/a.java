package d.b.h0.a.x;

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
import d.b.h0.a.i2.g0;
import d.b.h0.a.k;
import d.b.h0.a.z0.f;
import d.b.h0.p.d;
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
    public static final boolean f47598c = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public Timer f47599a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.a.x.c.b f47600b;

    /* renamed from: d.b.h0.a.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0907a extends TimerTask {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.x.c.b f47601e;

        public C0907a(d.b.h0.a.x.c.b bVar) {
            this.f47601e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.b.h0.a.x.c.b bVar = this.f47601e;
            if (bVar != null) {
                bVar.a();
            }
            a.this.j();
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f47603a = new a(null);
    }

    public /* synthetic */ a(C0907a c0907a) {
        this();
    }

    public static a b() {
        return b.f47603a;
    }

    public void a() {
        d.b.h0.a.x.c.b bVar = this.f47600b;
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
            f.V().N(new d.b.h0.a.k0.b.b(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA, hashMap));
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
            if (f47598c) {
                e2.printStackTrace();
            }
        }
        d.b.h0.a.j2.f.c.a.d(str, str2, BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA, jSONObject.optString("eType"), jSONObject);
    }

    public void f() {
        try {
            CameraPreview.j();
        } catch (Exception e2) {
            if (f47598c) {
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
                if (f47598c) {
                    Log.d("SwanAppCameraManager", "delete = " + delete);
                }
            }
            if (file.getParentFile() != null) {
                boolean mkdirs = file.getParentFile().mkdirs();
                if (f47598c) {
                    Log.d("SwanAppCameraManager", "mkdirs = " + mkdirs);
                }
            }
            boolean createNewFile = file.createNewFile();
            if (f47598c) {
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
            if (f47598c) {
                e2.printStackTrace();
                return false;
            }
            return false;
        } catch (OutOfMemoryError e3) {
            if (f47598c) {
                e3.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public void i(int i, d.b.h0.a.x.c.b bVar) {
        this.f47600b = bVar;
        Timer timer = new Timer();
        this.f47599a = timer;
        timer.schedule(new C0907a(bVar), i);
    }

    public void j() {
        this.f47600b = null;
        Timer timer = this.f47599a;
        if (timer != null) {
            timer.cancel();
        }
    }

    public a() {
    }
}
