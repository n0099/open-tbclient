package d.a.l0.a.i1.g.d;

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
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.j.b;
import java.io.File;
import java.net.URI;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.l0.a.i1.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0717a implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42979e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f42980f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f42981g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f42982h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42983i;

        public C0717a(CallbackHandler callbackHandler, String str, Context context, File file, UnitedSchemeEntity unitedSchemeEntity) {
            this.f42979e = callbackHandler;
            this.f42980f = str;
            this.f42981g = context;
            this.f42982h = file;
            this.f42983i = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                a.this.u(this.f42981g, this.f42982h, this.f42983i, this.f42979e, this.f42980f);
            } else {
                d.a.l0.a.e2.c.d.p(iVar, this.f42979e, this.f42980f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f42984a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f42985b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42986c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f42987d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f42988e;

        public b(Context context, File file, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity) {
            this.f42984a = context;
            this.f42985b = file;
            this.f42986c = callbackHandler;
            this.f42987d = str;
            this.f42988e = unitedSchemeEntity;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            if (a0.f40949b) {
                Log.d("SwanAppAction", str + "");
            }
            a.this.x(this.f42984a, this.f42985b, this.f42986c, this.f42987d);
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.safeCallback(this.f42986c, this.f42988e, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f42987d);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements h.n.b<File> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f42990e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f42991f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f42992g;

        public c(CallbackHandler callbackHandler, String str, Context context) {
            this.f42990e = callbackHandler;
            this.f42991f = str;
            this.f42992g = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(File file) {
            if (file == null) {
                this.f42990e.handleSchemeDispatchCallback(this.f42991f, UnitedSchemeUtility.wrapCallbackParams(1001, "output file create fail").toString());
                return;
            }
            Uri fromFile = Uri.fromFile(file);
            a.this.w(this.f42992g, file.getPath(), -1L);
            this.f42992g.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", fromFile));
            if (a0.f40949b) {
                Log.i("SaveVideoAction", "saveToAlbum : file = " + file);
            }
            this.f42990e.handleSchemeDispatchCallback(this.f42991f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements h.n.f<File, File> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f42994e;

        public d(Context context) {
            this.f42994e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public File call(File file) {
            String x = d.a.l0.a.k2.b.x(d.a.l0.a.a2.e.V());
            if (TextUtils.isEmpty(x) || !file.getPath().startsWith(x)) {
                return null;
            }
            return a.this.q(this.f42994e, file);
        }
    }

    public a(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/saveVideoToPhotosAlbum");
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

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        } else if (eVar.d0()) {
            if (a0.f40949b) {
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
                    String M = d.a.l0.a.k2.b.M(optString, eVar.f40749f);
                    if (!TextUtils.isEmpty(M)) {
                        file = new File(M);
                    }
                } else {
                    String L = d.a.l0.a.k2.b.L(optString, eVar, eVar.Z());
                    if (!TextUtils.isEmpty(L)) {
                        file = new File(L);
                    }
                }
                if (file != null && file.exists() && file.isFile()) {
                    String optString2 = a2.optString("cb");
                    if (TextUtils.isEmpty(optString2)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                        return false;
                    }
                    eVar.T().g(context, "mapp_images", new C0717a(callbackHandler, optString2, context, file, unitedSchemeEntity));
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not find such file : " + file);
                return false;
            } catch (Exception e2) {
                if (a0.f40949b) {
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
        if (d.a.l0.t.d.f(file, file2) > 0) {
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
        d.a.l0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(context, file, callbackHandler, str, unitedSchemeEntity));
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
        h.d.i(file).k(new d(context)).D(Schedulers.io()).o(h.l.b.a.b()).B(new c(callbackHandler, str, context));
    }
}
