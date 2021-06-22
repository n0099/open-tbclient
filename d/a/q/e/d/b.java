package d.a.q.e.d;

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
import d.a.q.e.a;
import d.a.q.g.d.a;
import java.io.OutputStream;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.q.e.a {

    /* renamed from: f  reason: collision with root package name */
    public a.C1848a f67793f;

    /* renamed from: g  reason: collision with root package name */
    public C1844b f67794g;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f67795a;

        public static a d(String str) {
            JSONObject jSONObject = new JSONObject(new String(new d.a.q.g.b.b().a(Base64.decode(str, 3))));
            a aVar = new a();
            aVar.c(jSONObject.getString("id"));
            aVar.b(jSONObject.getInt("d_form_ver"));
            return aVar;
        }

        public String a() {
            return this.f67795a;
        }

        public void b(int i2) {
        }

        public void c(String str) {
            this.f67795a = str;
        }

        public String e() {
            if (this.f67795a == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            d.a.q.g.b.b bVar = new d.a.q.g.b.b();
            jSONObject.put("id", this.f67795a);
            jSONObject.put("d_form_ver", 1);
            return Base64.encodeToString(bVar.b(jSONObject.toString().getBytes()), 3);
        }
    }

    /* renamed from: d.a.q.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1844b {

        /* renamed from: a  reason: collision with root package name */
        public long f67796a;

        /* renamed from: b  reason: collision with root package name */
        public String f67797b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f67798c;

        public C1844b() {
        }

        public String a() {
            return this.f67797b;
        }

        public void b(long j) {
            if (this.f67796a != j) {
                this.f67796a = j;
                this.f67798c = true;
            }
        }

        public void c(String str) {
            if (str.equals(this.f67797b)) {
                return;
            }
            this.f67797b = str;
            this.f67798c = true;
        }

        public boolean d() {
            return e(b.this.f67793f.g("pub.dat", true));
        }

        public final boolean e(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f67796a = jSONObject.getLong("pub_lst_ts");
                    this.f67797b = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f67798c = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean f() {
            if (this.f67798c) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pub_id", this.f67797b);
                    jSONObject.put("pub_lst_ts", this.f67796a);
                    jSONObject.put("d_form_ver", 1);
                    b.this.f67793f.i("pub.dat", jSONObject.toString(), true);
                    this.f67798c = false;
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
        public String f67800d;

        /* renamed from: e  reason: collision with root package name */
        public long f67801e;

        /* renamed from: f  reason: collision with root package name */
        public long f67802f;

        /* renamed from: g  reason: collision with root package name */
        public String f67803g;

        public c(b bVar, String str) {
            super(bVar.f67793f, str);
        }

        @Override // d.a.q.e.a.c
        public void c(JSONObject jSONObject) {
            this.f67800d = jSONObject.getString("pkg");
            this.f67801e = jSONObject.getLong("last_fe_ts");
            this.f67803g = jSONObject.getString("id");
            this.f67802f = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.a.q.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f67800d);
            jSONObject.put("last_fe_ts", this.f67801e);
            jSONObject.put("id", this.f67803g);
            jSONObject.put("tar_pkg_lst_up_ts", this.f67802f);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f67800d;
        }

        public boolean g(long j) {
            if (this.f67801e != j) {
                this.f67801e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean h(String str) {
            if (str.equals(this.f67800d)) {
                return false;
            }
            this.f67800d = str;
            a(true);
            return true;
        }

        public String i() {
            return this.f67803g;
        }

        public boolean j(long j) {
            if (this.f67802f != j) {
                this.f67802f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean k(String str) {
            if (str.equals(this.f67803g)) {
                return false;
            }
            this.f67803g = str;
            a(true);
            return true;
        }

        public long l() {
            return this.f67802f;
        }
    }

    public b() {
        super("esc-ms", 7500000L);
        this.f67794g = new C1844b();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, IF, IF] complete} */
    @Override // d.a.q.e.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        c cVar;
        int i2;
        if (Build.VERSION.SDK_INT < 29) {
            i2 = -101;
        } else {
            Context context = this.f67765a.f67769a;
            Cursor cursor = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                i2 = -1;
            } else {
                if (gVar.f67775a) {
                    cVar = new c(this, str);
                    cVar.d();
                    if (str.equals(cVar.f()) && packageInfo.lastUpdateTime == cVar.l()) {
                        String i3 = cVar.i();
                        if (!TextUtils.isEmpty(i3)) {
                            return a.h.e(i3);
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
                                                if (gVar.f67775a && cVar != null) {
                                                    cVar.k(a2);
                                                    cVar.g(System.currentTimeMillis());
                                                    cVar.j(packageInfo.lastUpdateTime);
                                                    cVar.h(str);
                                                }
                                                a.h e2 = a.h.e(a2);
                                                d.a.q.g.c.a.c.a(cursor);
                                                if (gVar.f67775a && cVar != null) {
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
                            d.a.q.g.c.a.c.a(cursor);
                            if (gVar.f67775a && cVar != null) {
                                cVar.b();
                            }
                            i2 = -2;
                        } catch (Exception e3) {
                            a.h c2 = a.h.c(e3);
                            d.a.q.g.c.a.c.a(cursor);
                            if (gVar.f67775a && cVar != null) {
                                cVar.b();
                            }
                            return c2;
                        }
                    } catch (Throwable th) {
                        d.a.q.g.c.a.c.a(cursor);
                        if (gVar.f67775a && cVar != null) {
                            cVar.b();
                        }
                        throw th;
                    }
                } else {
                    i2 = -100;
                }
            }
        }
        return a.h.a(i2);
    }

    @Override // d.a.q.e.a
    public void e(a.d dVar) {
        this.f67793f = this.f67766b.f("esc-ms");
    }

    @Override // d.a.q.e.a
    public a.f f(a.e eVar) {
        if (Build.VERSION.SDK_INT < 29) {
            return a.f.a();
        }
        this.f67794g.d();
        try {
            return i(eVar);
        } finally {
            this.f67794g.f();
        }
    }

    public final Uri h(String str, ContentResolver contentResolver, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", "helios-icon.JPG");
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put("is_pending", (Integer) 1);
        int i2 = 0;
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
                i2++;
                if (i2 > 5) {
                    throw new IllegalStateException("insert file retry count exceed", e2);
                }
                contentValues.put("_display_name", "helios-icon-" + i2 + ".JPG");
            }
        }
    }

    public final a.f i(a.e eVar) {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        Context context = this.f67765a.f67769a;
        String packageName = context.getPackageName();
        ContentResolver contentResolver = this.f67765a.f67769a.getContentResolver();
        String c2 = this.f67765a.f67771c.a("aid").c();
        String a2 = this.f67794g.a();
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
                this.f67794g.c(c2);
                this.f67794g.b(System.currentTimeMillis());
                a.f d2 = a.f.d();
                d.a.q.g.c.a.c.b(autoCloseOutputStream);
                return d2;
            } catch (Exception e3) {
                e = e3;
                autoCloseOutputStream2 = autoCloseOutputStream;
                a.f c3 = a.f.c(e);
                d.a.q.g.c.a.c.b(autoCloseOutputStream2);
                return c3;
            } catch (Throwable th2) {
                th = th2;
                autoCloseOutputStream2 = autoCloseOutputStream;
                d.a.q.g.c.a.c.b(autoCloseOutputStream2);
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
