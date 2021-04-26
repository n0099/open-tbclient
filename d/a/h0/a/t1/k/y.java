package d.a.h0.a.t1.k;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.h0.a.v1.c.i.b;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class y extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44696e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44697f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f44698g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f44699h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44700i;

        /* renamed from: d.a.h0.a.t1.k.y$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0819a implements Runnable {
            public RunnableC0819a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                y.this.p(aVar.f44698g, aVar.f44699h, aVar.f44700i, aVar.f44696e, aVar.f44697f);
            }
        }

        public a(CallbackHandler callbackHandler, String str, Context context, File file, UnitedSchemeEntity unitedSchemeEntity) {
            this.f44696e = callbackHandler;
            this.f44697f = str;
            this.f44698g = context;
            this.f44699h = file;
            this.f44700i = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (!d.a.h0.a.v1.c.c.h(hVar)) {
                d.a.h0.a.c0.c.g("SaveImage", "Permission denied");
                d.a.h0.a.v1.c.c.o(hVar, this.f44696e, this.f44697f);
                return;
            }
            d.a.h0.a.i2.p.k(new RunnableC0819a(), "SaveImageAction");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f44702a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f44703b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44704c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f44705d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44706e;

        public b(Context context, File file, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity) {
            this.f44702a = context;
            this.f44703b = file;
            this.f44704c = callbackHandler;
            this.f44705d = str;
            this.f44706e = unitedSchemeEntity;
        }

        @Override // d.a.h0.a.k1.b
        public void a(String str) {
            String str2;
            boolean q = d.a.h0.a.i2.c.a() ? y.this.q(this.f44702a, this.f44703b) : y.this.r(this.f44702a, this.f44703b);
            int i2 = q ? 0 : 1001;
            if (q) {
                str2 = "save success";
            } else {
                str2 = "can not save to album : " + this.f44703b;
            }
            d.a.h0.a.c0.c.g("SaveImage", str2);
            this.f44704c.handleSchemeDispatchCallback(this.f44705d, UnitedSchemeUtility.wrapCallbackParams(i2, str2).toString());
        }

        @Override // d.a.h0.a.k1.b
        public void b(int i2, String str) {
            d.a.h0.a.c0.c.g("SaveImage", str + "");
            UnitedSchemeUtility.safeCallback(this.f44704c, this.f44706e, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f44705d);
        }
    }

    public y(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/saveImageToPhotosAlbum");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0024 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0007 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:7:0x0022 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static String o(Uri uri, Context context) {
        Closeable closeable = null;
        r7 = null;
        r7 = null;
        String str = null;
        try {
            try {
                uri = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            } catch (Throwable th) {
                th = th;
                closeable = uri;
                d.a.h0.p.d.a(closeable);
                throw th;
            }
        } catch (SQLException e2) {
            e = e2;
            uri = 0;
        } catch (Throwable th2) {
            th = th2;
            d.a.h0.p.d.a(closeable);
            throw th;
        }
        if (uri != 0) {
            try {
                int columnIndexOrThrow = uri.getColumnIndexOrThrow("_data");
                uri.moveToFirst();
                str = uri.getString(columnIndexOrThrow);
                uri = uri;
            } catch (SQLException e3) {
                e = e3;
                uri = uri;
                if (a0.f44398b) {
                    e.printStackTrace();
                    uri = uri;
                }
                d.a.h0.p.d.a(uri);
                return str;
            }
        }
        d.a.h0.p.d.a(uri);
        return str;
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar == null) {
            d.a.h0.a.c0.c.b("SaveImage", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.h0.a.c0.c.b("SaveImage", "illegal params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params");
            return false;
        }
        String optString = a2.optString("filePath");
        try {
            File n = n(eVar, optString, URI.create(optString));
            if (n != null && n.exists() && n.isFile()) {
                String optString2 = a2.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    d.a.h0.a.c0.c.b("SaveImage", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                eVar.R().g(context, "mapp_images", new a(callbackHandler, optString2, context, n, unitedSchemeEntity));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            d.a.h0.a.c0.c.b("SaveImage", "can not find such file");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not find such file : " + n);
            return false;
        } catch (Exception e2) {
            if (a0.f44398b) {
                e2.printStackTrace();
            }
            d.a.h0.a.c0.c.b("SaveImage", "Illegal file_path");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "Illegal file_path : " + optString);
            return false;
        }
    }

    public final String m(File file) {
        String l = d.a.h0.p.d.l(file.getPath());
        String valueOf = String.valueOf(System.currentTimeMillis());
        if (TextUtils.isEmpty(l)) {
            return valueOf;
        }
        return valueOf + "." + l;
    }

    public final File n(d.a.h0.a.r1.e eVar, String str, URI uri) {
        String d2;
        d.a.h0.a.a2.f.c I = d.a.h0.a.z0.f.V().I();
        if ("bdfile".equalsIgnoreCase(uri.getScheme())) {
            d2 = I.i(str);
        } else if (d.a.h0.a.m1.a.a.y(eVar.L())) {
            d2 = I.m(str);
        } else {
            d2 = I.d(str);
        }
        if (TextUtils.isEmpty(d2)) {
            return null;
        }
        return new File(d2);
    }

    public final void p(@NonNull Context context, File file, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, String str) {
        d.a.h0.a.k1.a.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(context, file, callbackHandler, str, unitedSchemeEntity));
    }

    public final boolean q(Context context, File file) {
        String str;
        try {
            str = MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getPath(), file.getName(), "by aiapp");
        } catch (FileNotFoundException e2) {
            if (a0.f44398b) {
                e2.printStackTrace();
            }
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            String o = o(Uri.parse(str), context);
            if (!TextUtils.isEmpty(o)) {
                s(context, new File(o));
            }
        }
        if (a0.f44398b) {
            Log.i("SaveImageAction", "saveToAlbum : file = " + file);
            Log.i("SaveImageAction", "saveToAlbum : image = " + str);
        }
        d.a.h0.a.c0.c.g("SaveImage", "save success");
        return !TextUtils.isEmpty(str);
    }

    public final boolean r(Context context, File file) {
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getPath());
        if (decodeFile == null) {
            return false;
        }
        decodeFile.recycle();
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        d.a.h0.p.d.h(externalStoragePublicDirectory);
        File file2 = new File(externalStoragePublicDirectory, m(file));
        if (d.a.h0.p.d.c(file, file2) != 0) {
            s(context, file2);
            return true;
        }
        return false;
    }

    public final void s(Context context, File file) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        context.sendBroadcast(intent);
    }
}
