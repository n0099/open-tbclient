package d.b.p.e.d;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.down.request.taskmanager.DatabaseMng;
import d.b.p.e.a;
import d.b.p.g.d.a;
import java.io.OutputStream;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.b.p.e.a {

    /* renamed from: f  reason: collision with root package name */
    public a.C1765a f65025f;

    /* renamed from: g  reason: collision with root package name */
    public C1761b f65026g;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f65027a;

        public static a d(String str) {
            JSONObject jSONObject = new JSONObject(new String(new d.b.p.g.b.b().a(Base64.decode(str, 3))));
            a aVar = new a();
            aVar.c(jSONObject.getString("id"));
            aVar.b(jSONObject.getInt("d_form_ver"));
            return aVar;
        }

        public String a() {
            return this.f65027a;
        }

        public void b(int i) {
        }

        public void c(String str) {
            this.f65027a = str;
        }

        public String e() {
            if (this.f65027a == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            d.b.p.g.b.b bVar = new d.b.p.g.b.b();
            jSONObject.put("id", this.f65027a);
            jSONObject.put("d_form_ver", 1);
            return Base64.encodeToString(bVar.b(jSONObject.toString().getBytes()), 3);
        }
    }

    /* renamed from: d.b.p.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1761b {

        /* renamed from: a  reason: collision with root package name */
        public long f65028a;

        /* renamed from: b  reason: collision with root package name */
        public String f65029b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f65030c;

        public C1761b() {
        }

        public String a() {
            return this.f65029b;
        }

        public void b(long j) {
            if (this.f65028a != j) {
                this.f65028a = j;
                this.f65030c = true;
            }
        }

        public void c(String str) {
            if (str.equals(this.f65029b)) {
                return;
            }
            this.f65029b = str;
            this.f65030c = true;
        }

        public boolean d() {
            return e(b.this.f65025f.g("pub.dat", true));
        }

        public final boolean e(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f65028a = jSONObject.getLong("pub_lst_ts");
                    this.f65029b = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f65030c = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean f() {
            if (this.f65030c) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pub_id", this.f65029b);
                    jSONObject.put("pub_lst_ts", this.f65028a);
                    jSONObject.put("d_form_ver", 1);
                    b.this.f65025f.i("pub.dat", jSONObject.toString(), true);
                    this.f65030c = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f65032d;

        /* renamed from: e  reason: collision with root package name */
        public long f65033e;

        /* renamed from: f  reason: collision with root package name */
        public long f65034f;

        /* renamed from: g  reason: collision with root package name */
        public String f65035g;

        public c(b bVar, String str) {
            super(bVar.f65025f, str);
        }

        @Override // d.b.p.e.a.c
        public void c(JSONObject jSONObject) {
            this.f65032d = jSONObject.getString("pkg");
            this.f65033e = jSONObject.getLong("last_fe_ts");
            this.f65035g = jSONObject.getString("id");
            this.f65034f = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.b.p.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f65032d);
            jSONObject.put("last_fe_ts", this.f65033e);
            jSONObject.put("id", this.f65035g);
            jSONObject.put("tar_pkg_lst_up_ts", this.f65034f);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f65032d;
        }

        public boolean g(long j) {
            if (this.f65033e != j) {
                this.f65033e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean h(String str) {
            if (str.equals(this.f65032d)) {
                return false;
            }
            this.f65032d = str;
            a(true);
            return true;
        }

        public String i() {
            return this.f65035g;
        }

        public boolean j(long j) {
            if (this.f65034f != j) {
                this.f65034f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean k(String str) {
            if (str.equals(this.f65035g)) {
                return false;
            }
            this.f65035g = str;
            a(true);
            return true;
        }

        public long l() {
            return this.f65034f;
        }
    }

    public b() {
        super("esc-ms", 7500000L);
        this.f65026g = new C1761b();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, IF, IF] complete} */
    @Override // d.b.p.e.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        c cVar;
        int i;
        if (Build.VERSION.SDK_INT < 29) {
            i = -101;
        } else {
            Context context = this.f64997a.f65001a;
            Cursor cursor = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                i = -1;
            } else {
                if (gVar.f65007a) {
                    cVar = new c(this, str);
                    cVar.d();
                    if (str.equals(cVar.f()) && packageInfo.lastUpdateTime == cVar.l()) {
                        String i2 = cVar.i();
                        if (!TextUtils.isEmpty(i2)) {
                            return a.h.e(i2);
                        }
                    }
                } else {
                    cVar = null;
                }
                if (context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0) {
                    try {
                        try {
                            cursor = context.getContentResolver().query(MediaStore.setIncludePending(MediaStore.Images.Media.EXTERNAL_CONTENT_URI), new String[]{"_id", "description"}, "owner_package_name = ? AND relative_path = ?", new String[]{str, "Pictures/" + str + "/helios/"}, DatabaseMng.DEFAULT_SORT_ORDER);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    String string = cursor.getString(cursor.getColumnIndexOrThrow("description"));
                                    if (string != null) {
                                        try {
                                            String a2 = a.d(string).a();
                                            if (!TextUtils.isEmpty(a2)) {
                                                if (gVar.f65007a && cVar != null) {
                                                    cVar.k(a2);
                                                    cVar.g(System.currentTimeMillis());
                                                    cVar.j(packageInfo.lastUpdateTime);
                                                    cVar.h(str);
                                                }
                                                a.h e2 = a.h.e(a2);
                                                d.b.p.g.c.a.c.a(cursor);
                                                if (gVar.f65007a && cVar != null) {
                                                    cVar.b();
                                                }
                                                return e2;
                                            }
                                            continue;
                                        } catch (Exception unused2) {
                                            continue;
                                        }
                                    }
                                }
                            }
                            d.b.p.g.c.a.c.a(cursor);
                            if (gVar.f65007a && cVar != null) {
                                cVar.b();
                            }
                            i = -2;
                        } catch (Exception e3) {
                            a.h c2 = a.h.c(e3);
                            d.b.p.g.c.a.c.a(cursor);
                            if (gVar.f65007a && cVar != null) {
                                cVar.b();
                            }
                            return c2;
                        }
                    } catch (Throwable th) {
                        d.b.p.g.c.a.c.a(cursor);
                        if (gVar.f65007a && cVar != null) {
                            cVar.b();
                        }
                        throw th;
                    }
                } else {
                    i = -100;
                }
            }
        }
        return a.h.a(i);
    }

    @Override // d.b.p.e.a
    public void e(a.d dVar) {
        this.f65025f = this.f64998b.f("esc-ms");
    }

    @Override // d.b.p.e.a
    public a.f f(a.e eVar) {
        if (Build.VERSION.SDK_INT < 29) {
            return a.f.a();
        }
        this.f65026g.d();
        try {
            return i(eVar);
        } finally {
            this.f65026g.f();
        }
    }

    public final Uri h(String str, ContentResolver contentResolver, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", "helios-icon.JPG");
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put("is_pending", (Integer) 1);
        int i = 0;
        contentValues.put("relative_path", String.format("Pictures/%s/helios", str));
        contentValues.put("description", str2);
        while (true) {
            try {
                Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                if (insert == null) {
                    throw new IllegalStateException("file path maybe duplicated");
                    break;
                }
                return insert;
            } catch (IllegalStateException e2) {
                i++;
                if (i > 5) {
                    throw new IllegalStateException("insert file retry count exceed", e2);
                }
                contentValues.put("_display_name", "helios-icon-" + i + ".JPG");
            }
        }
    }

    public final a.f i(a.e eVar) {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        Context context = this.f64997a.f65001a;
        String packageName = context.getPackageName();
        ContentResolver contentResolver = this.f64997a.f65001a.getContentResolver();
        String c2 = this.f64997a.f65003c.a("aid").c();
        String a2 = this.f65026g.a();
        if (a2 == null || !TextUtils.equals(a2, c2)) {
            if (Build.VERSION.SDK_INT < 29) {
                return a.f.a();
            }
            ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream2 = null;
            try {
                try {
                    a aVar = new a();
                    aVar.c(c2);
                    autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(contentResolver.openFileDescriptor(h(packageName, contentResolver, aVar.e()), "w", null));
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                j(autoCloseOutputStream, context);
                this.f65026g.c(c2);
                this.f65026g.b(System.currentTimeMillis());
                a.f d2 = a.f.d();
                d.b.p.g.c.a.c.b(autoCloseOutputStream);
                return d2;
            } catch (Exception e3) {
                e = e3;
                autoCloseOutputStream2 = autoCloseOutputStream;
                a.f c3 = a.f.c(e);
                d.b.p.g.c.a.c.b(autoCloseOutputStream2);
                return c3;
            } catch (Throwable th2) {
                th = th2;
                autoCloseOutputStream2 = autoCloseOutputStream;
                d.b.p.g.c.a.c.b(autoCloseOutputStream2);
                throw th;
            }
        }
        return a.f.d();
    }

    public final void j(OutputStream outputStream, Context context) {
        float min;
        Drawable loadIcon = context.getApplicationInfo().loadIcon(context.getPackageManager());
        int intrinsicWidth = loadIcon.getIntrinsicWidth();
        int intrinsicHeight = loadIcon.getIntrinsicHeight();
        Matrix matrix = new Matrix();
        Bitmap createBitmap = Bitmap.createBitmap(96, 96, Bitmap.Config.ARGB_8888);
        if (intrinsicWidth > 96 || intrinsicHeight > 96) {
            float f2 = 96;
            min = Math.min(f2 / intrinsicWidth, f2 / intrinsicHeight);
        } else {
            min = 1.0f;
        }
        float f3 = 96;
        matrix.setScale(min, min);
        matrix.postTranslate(Math.round((f3 - (intrinsicWidth * min)) * 0.5f), Math.round((f3 - (intrinsicHeight * min)) * 0.5f));
        Canvas canvas = new Canvas(createBitmap);
        canvas.concat(matrix);
        loadIcon.setBounds(0, 0, loadIcon.getIntrinsicWidth(), loadIcon.getIntrinsicHeight());
        loadIcon.draw(canvas);
        createBitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
        createBitmap.recycle();
    }
}
