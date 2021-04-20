package d.b.g0.a.t1.k;

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
import d.b.g0.a.v1.c.i.b;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class y extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46960e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46961f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46962g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f46963h;
        public final /* synthetic */ UnitedSchemeEntity i;

        /* renamed from: d.b.g0.a.t1.k.y$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0860a implements Runnable {
            public RunnableC0860a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                y.this.p(aVar.f46962g, aVar.f46963h, aVar.i, aVar.f46960e, aVar.f46961f);
            }
        }

        public a(CallbackHandler callbackHandler, String str, Context context, File file, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46960e = callbackHandler;
            this.f46961f = str;
            this.f46962g = context;
            this.f46963h = file;
            this.i = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (!d.b.g0.a.v1.c.c.h(hVar)) {
                d.b.g0.a.c0.c.g("SaveImage", "Permission denied");
                d.b.g0.a.v1.c.c.o(hVar, this.f46960e, this.f46961f);
                return;
            }
            d.b.g0.a.i2.p.k(new RunnableC0860a(), "SaveImageAction");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f46965a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f46966b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46967c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f46968d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46969e;

        public b(Context context, File file, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46965a = context;
            this.f46966b = file;
            this.f46967c = callbackHandler;
            this.f46968d = str;
            this.f46969e = unitedSchemeEntity;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            String str2;
            boolean q = d.b.g0.a.i2.c.a() ? y.this.q(this.f46965a, this.f46966b) : y.this.r(this.f46965a, this.f46966b);
            int i = q ? 0 : 1001;
            if (q) {
                str2 = "save success";
            } else {
                str2 = "can not save to album : " + this.f46966b;
            }
            d.b.g0.a.c0.c.g("SaveImage", str2);
            this.f46967c.handleSchemeDispatchCallback(this.f46968d, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString());
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            d.b.g0.a.c0.c.g("SaveImage", str + "");
            UnitedSchemeUtility.safeCallback(this.f46967c, this.f46969e, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f46968d);
        }
    }

    public y(d.b.g0.a.t1.j jVar) {
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
                d.b.g0.p.d.a(closeable);
                throw th;
            }
        } catch (SQLException e2) {
            e = e2;
            uri = 0;
        } catch (Throwable th2) {
            th = th2;
            d.b.g0.p.d.a(closeable);
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
                if (a0.f46680b) {
                    e.printStackTrace();
                    uri = uri;
                }
                d.b.g0.p.d.a(uri);
                return str;
            }
        }
        d.b.g0.p.d.a(uri);
        return str;
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar == null) {
            d.b.g0.a.c0.c.b("SaveImage", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.b.g0.a.c0.c.b("SaveImage", "illegal params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params");
            return false;
        }
        String optString = a2.optString("filePath");
        try {
            File n = n(eVar, optString, URI.create(optString));
            if (n != null && n.exists() && n.isFile()) {
                String optString2 = a2.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    d.b.g0.a.c0.c.b("SaveImage", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                eVar.R().g(context, "mapp_images", new a(callbackHandler, optString2, context, n, unitedSchemeEntity));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            d.b.g0.a.c0.c.b("SaveImage", "can not find such file");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not find such file : " + n);
            return false;
        } catch (Exception e2) {
            if (a0.f46680b) {
                e2.printStackTrace();
            }
            d.b.g0.a.c0.c.b("SaveImage", "Illegal file_path");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "Illegal file_path : " + optString);
            return false;
        }
    }

    public final String m(File file) {
        String l = d.b.g0.p.d.l(file.getPath());
        String valueOf = String.valueOf(System.currentTimeMillis());
        if (TextUtils.isEmpty(l)) {
            return valueOf;
        }
        return valueOf + "." + l;
    }

    public final File n(d.b.g0.a.r1.e eVar, String str, URI uri) {
        String i;
        d.b.g0.a.a2.f.c y = d.b.g0.a.z0.f.V().y();
        if ("bdfile".equalsIgnoreCase(uri.getScheme())) {
            i = y.d(str);
        } else if (d.b.g0.a.m1.a.a.y(eVar.L())) {
            i = y.l(str);
        } else {
            i = y.i(str);
        }
        if (TextUtils.isEmpty(i)) {
            return null;
        }
        return new File(i);
    }

    public final void p(@NonNull Context context, File file, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, String str) {
        d.b.g0.a.k1.a.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(context, file, callbackHandler, str, unitedSchemeEntity));
    }

    public final boolean q(Context context, File file) {
        String str;
        try {
            str = MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getPath(), file.getName(), "by aiapp");
        } catch (FileNotFoundException e2) {
            if (a0.f46680b) {
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
        if (a0.f46680b) {
            Log.i("SaveImageAction", "saveToAlbum : file = " + file);
            Log.i("SaveImageAction", "saveToAlbum : image = " + str);
        }
        d.b.g0.a.c0.c.g("SaveImage", "save success");
        return !TextUtils.isEmpty(str);
    }

    public final boolean r(Context context, File file) {
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getPath());
        if (decodeFile == null) {
            return false;
        }
        decodeFile.recycle();
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        d.b.g0.p.d.h(externalStoragePublicDirectory);
        File file2 = new File(externalStoragePublicDirectory, m(file));
        if (d.b.g0.p.d.c(file, file2) != 0) {
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
