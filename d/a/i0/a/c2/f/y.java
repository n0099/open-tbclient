package d.a.i0.a.c2.f;

import android.content.Context;
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
import d.a.i0.a.e2.c.j.b;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class y extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41103e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41104f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f41105g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f41106h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41107i;

        /* renamed from: d.a.i0.a.c2.f.y$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0581a implements Runnable {
            public RunnableC0581a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                y.this.p(aVar.f41105g, aVar.f41106h, aVar.f41107i, aVar.f41103e, aVar.f41104f);
            }
        }

        public a(CallbackHandler callbackHandler, String str, Context context, File file, UnitedSchemeEntity unitedSchemeEntity) {
            this.f41103e = callbackHandler;
            this.f41104f = str;
            this.f41105g = context;
            this.f41106h = file;
            this.f41107i = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.i<b.e> iVar) {
            if (!d.a.i0.a.e2.c.d.h(iVar)) {
                d.a.i0.a.e0.d.g("SaveImage", "Permission denied");
                d.a.i0.a.e2.c.d.p(iVar, this.f41103e, this.f41104f);
                return;
            }
            d.a.i0.a.v2.q.j(new RunnableC0581a(), "SaveImageAction");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.i0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f41109a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f41110b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41111c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f41112d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f41113e;

        public b(Context context, File file, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity) {
            this.f41109a = context;
            this.f41110b = file;
            this.f41111c = callbackHandler;
            this.f41112d = str;
            this.f41113e = unitedSchemeEntity;
        }

        @Override // d.a.i0.a.s1.f
        public void a(String str) {
            String str2;
            boolean q = d.a.i0.a.v2.d.a() ? y.this.q(this.f41109a, this.f41110b) : y.this.r(this.f41109a, this.f41110b);
            int i2 = q ? 0 : 1001;
            if (q) {
                str2 = "save success";
            } else {
                str2 = "can not save to album : " + this.f41110b;
            }
            d.a.i0.a.e0.d.g("SaveImage", str2);
            this.f41111c.handleSchemeDispatchCallback(this.f41112d, UnitedSchemeUtility.wrapCallbackParams(i2, str2).toString());
        }

        @Override // d.a.i0.a.s1.f
        public void b(int i2, String str) {
            d.a.i0.a.e0.d.g("SaveImage", str + "");
            UnitedSchemeUtility.safeCallback(this.f41111c, this.f41113e, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f41112d);
        }
    }

    public y(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/saveImageToPhotosAlbum");
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
                d.a.i0.t.d.d(closeable);
                throw th;
            }
        } catch (SQLException e2) {
            e = e2;
            uri = 0;
        } catch (Throwable th2) {
            th = th2;
            d.a.i0.t.d.d(closeable);
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
                if (a0.f40775b) {
                    e.printStackTrace();
                    uri = uri;
                }
                d.a.i0.t.d.d(uri);
                return str;
            }
        }
        d.a.i0.t.d.d(uri);
        return str;
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (eVar == null) {
            d.a.i0.a.e0.d.b("SaveImage", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.i0.a.e0.d.b("SaveImage", "illegal params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params");
            return false;
        }
        String optString = a2.optString("filePath");
        try {
            File n = n(eVar, optString, URI.create(optString));
            if (n != null && n.exists() && n.isFile()) {
                String optString2 = a2.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    d.a.i0.a.e0.d.b("SaveImage", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                eVar.T().g(context, "mapp_images", new a(callbackHandler, optString2, context, n, unitedSchemeEntity));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            d.a.i0.a.e0.d.b("SaveImage", "can not find such file");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not find such file : " + n);
            return false;
        } catch (Exception e2) {
            if (a0.f40775b) {
                e2.printStackTrace();
            }
            d.a.i0.a.e0.d.b("SaveImage", "Illegal file_path");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "Illegal file_path : " + optString);
            return false;
        }
    }

    public final String m(File file) {
        String s = d.a.i0.t.d.s(file.getPath());
        String valueOf = String.valueOf(System.currentTimeMillis());
        if (TextUtils.isEmpty(s)) {
            return valueOf;
        }
        return valueOf + "." + s;
    }

    public final File n(d.a.i0.a.a2.e eVar, String str, URI uri) {
        String e2;
        d.a.i0.a.k2.f.d I = d.a.i0.a.g1.f.V().I();
        if ("bdfile".equalsIgnoreCase(uri.getScheme())) {
            e2 = I.i(str);
        } else if (d.a.i0.a.u1.a.a.A(eVar.N())) {
            e2 = I.m(str);
        } else {
            e2 = I.e(str);
        }
        if (TextUtils.isEmpty(e2)) {
            return null;
        }
        return new File(e2);
    }

    public final void p(@NonNull Context context, File file, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, String str) {
        d.a.i0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(context, file, callbackHandler, str, unitedSchemeEntity));
    }

    public final boolean q(Context context, File file) {
        String str;
        try {
            str = MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getPath(), file.getName(), "by aiapp");
        } catch (FileNotFoundException e2) {
            if (a0.f40775b) {
                e2.printStackTrace();
            }
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            String o = o(Uri.parse(str), context);
            if (!TextUtils.isEmpty(o)) {
                d.a.i0.a.v2.u.q(context, o);
            }
        }
        if (a0.f40775b) {
            Log.i("SaveImageAction", "saveToAlbum : file = " + file);
            Log.i("SaveImageAction", "saveToAlbum : image = " + str);
        }
        d.a.i0.a.e0.d.g("SaveImage", "save success");
        return !TextUtils.isEmpty(str);
    }

    public final boolean r(Context context, File file) {
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getPath());
        if (decodeFile == null) {
            return false;
        }
        decodeFile.recycle();
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        d.a.i0.t.d.k(externalStoragePublicDirectory);
        File file2 = new File(externalStoragePublicDirectory, m(file));
        if (d.a.i0.t.d.f(file, file2) != 0) {
            d.a.i0.a.v2.u.q(context, file2.getAbsolutePath());
            return true;
        }
        return false;
    }
}
