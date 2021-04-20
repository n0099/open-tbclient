package d.b.g0.a.b1.g.d;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.FileUtils;
import com.baidu.android.util.io.PathUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.i.b;
import java.io.File;
import java.net.URI;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.b.g0.a.b1.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0624a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43921e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43922f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43923g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f43924h;
        public final /* synthetic */ UnitedSchemeEntity i;

        public C0624a(CallbackHandler callbackHandler, String str, Context context, File file, UnitedSchemeEntity unitedSchemeEntity) {
            this.f43921e = callbackHandler;
            this.f43922f = str;
            this.f43923g = context;
            this.f43924h = file;
            this.i = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                a.this.u(this.f43923g, this.f43924h, this.i, this.f43921e, this.f43922f);
            } else {
                d.b.g0.a.v1.c.c.o(hVar, this.f43921e, this.f43922f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f43925a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f43926b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43927c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f43928d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43929e;

        public b(Context context, File file, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity) {
            this.f43925a = context;
            this.f43926b = file;
            this.f43927c = callbackHandler;
            this.f43928d = str;
            this.f43929e = unitedSchemeEntity;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            if (a0.f46680b) {
                Log.d("SwanAppAction", str + "");
            }
            a.this.x(this.f43925a, this.f43926b, this.f43927c, this.f43928d);
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.safeCallback(this.f43927c, this.f43929e, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f43928d);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements h.n.b<File> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43931e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43932f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43933g;

        public c(CallbackHandler callbackHandler, String str, Context context) {
            this.f43931e = callbackHandler;
            this.f43932f = str;
            this.f43933g = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(File file) {
            if (file == null) {
                this.f43931e.handleSchemeDispatchCallback(this.f43932f, UnitedSchemeUtility.wrapCallbackParams(1001, "output file create fail").toString());
                return;
            }
            Uri fromFile = Uri.fromFile(file);
            a.this.w(this.f43933g, file.getPath(), -1L);
            this.f43933g.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", fromFile));
            if (a0.f46680b) {
                Log.i("SaveVideoAction", "saveToAlbum : file = " + file);
            }
            this.f43931e.handleSchemeDispatchCallback(this.f43932f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    /* loaded from: classes2.dex */
    public class d implements h.n.f<File, File> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43935e;

        public d(Context context) {
            this.f43935e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public File call(File file) {
            String h2 = d.b.g0.a.a2.b.h(d.b.g0.a.r1.e.T());
            if (TextUtils.isEmpty(h2) || !file.getPath().startsWith(h2)) {
                return null;
            }
            return a.this.q(this.f43935e, file);
        }
    }

    public a(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/saveVideoToPhotosAlbum");
    }

    public static File t(Context context) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath());
        if (file.exists()) {
            String str = "video";
            File file2 = new File(file, (new File(file, "Video").exists() || !new File(file, "video").exists()) ? "Video" : "Video");
            if ((file2.exists() || file2.mkdirs()) && file2.canWrite()) {
                return file2;
            }
        }
        File file3 = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + PathUtils.DIRCTORY_BAIDU + File.separator + FileUtils.SEARCHBOX_FOLDER + File.separator + "Video");
        if (file3.exists() || file3.mkdirs()) {
            return file3;
        }
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            File file4 = new File(externalFilesDir.getPath() + File.separator + "Video");
            if (file4.exists() || file4.mkdirs()) {
                return file4;
            }
        }
        File file5 = new File(context.getFilesDir().getPath() + File.separator + "Video");
        if (file5.exists() || file5.mkdirs()) {
            return file5;
        }
        return null;
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        } else if (eVar.Z()) {
            if (a0.f46680b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params");
                return false;
            }
            String optString = a2.optString("filePath");
            try {
                File file = null;
                if ("bdfile".equalsIgnoreCase(URI.create(optString).getScheme())) {
                    String u = d.b.g0.a.a2.b.u(optString, eVar.f46132f);
                    if (!TextUtils.isEmpty(u)) {
                        file = new File(u);
                    }
                } else {
                    String t = d.b.g0.a.a2.b.t(optString, eVar, eVar.W());
                    if (!TextUtils.isEmpty(t)) {
                        file = new File(t);
                    }
                }
                if (file != null && file.exists() && file.isFile()) {
                    String optString2 = a2.optString("cb");
                    if (TextUtils.isEmpty(optString2)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                        return false;
                    }
                    eVar.R().g(context, "mapp_images", new C0624a(callbackHandler, optString2, context, file, unitedSchemeEntity));
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not find such file : " + file);
                return false;
            } catch (Exception e2) {
                if (a0.f46680b) {
                    e2.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "Illegal file_path : " + optString);
                return false;
            }
        }
    }

    public final boolean p(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public final File q(Context context, @NonNull File file) {
        File t = t(context);
        if (t == null) {
            return null;
        }
        File file2 = new File(t, file.getName());
        if (d.b.g0.p.d.c(file, file2) > 0) {
            return file2;
        }
        return null;
    }

    public final long r(long j) {
        return j <= 0 ? System.currentTimeMillis() : j;
    }

    public final String s(String str) {
        String lowerCase = str.toLowerCase();
        return (lowerCase.endsWith("mp4") || lowerCase.endsWith("mpeg4") || !lowerCase.endsWith("3gp")) ? "video/mp4" : "video/3gp";
    }

    public final void u(@NonNull Context context, @NonNull File file, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.b.g0.a.k1.a.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(context, file, callbackHandler, str, unitedSchemeEntity));
    }

    public final ContentValues v(String str, long j) {
        ContentValues contentValues = new ContentValues();
        File file = new File(str);
        long r = r(j);
        contentValues.put("title", file.getName());
        contentValues.put("_display_name", file.getName());
        contentValues.put("date_modified", Long.valueOf(r));
        contentValues.put("date_added", Long.valueOf(r));
        contentValues.put("_data", file.getAbsolutePath());
        contentValues.put("_size", Long.valueOf(file.length()));
        return contentValues;
    }

    public final void w(Context context, String str, long j) {
        if (p(str)) {
            long r = r(j);
            ContentValues v = v(str, r);
            v.put("datetaken", Long.valueOf(r));
            v.put("mime_type", s(str));
            context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, v);
        }
    }

    public final void x(@NonNull Context context, @NonNull File file, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        if (file == null) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "can not save to album : " + file).toString());
            return;
        }
        h.d.j(file).l(new d(context)).F(Schedulers.io()).p(h.l.b.a.b()).D(new c(callbackHandler, str, context));
    }
}
