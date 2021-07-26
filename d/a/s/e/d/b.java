package d.a.s.e.d;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.taskmanager.DatabaseMng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s.e.a;
import d.a.s.g.d.a;
import java.io.OutputStream;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends d.a.s.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a.C1904a f67791f;

    /* renamed from: g  reason: collision with root package name */
    public C1900b f67792g;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f67793a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                JSONObject jSONObject = new JSONObject(new String(new d.a.s.g.b.b().a(Base64.decode(str, 3))));
                a aVar = new a();
                aVar.c(jSONObject.getString("id"));
                aVar.b(jSONObject.getInt("d_form_ver"));
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67793a : (String) invokeV.objValue;
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f67793a = str;
            }
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f67793a == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                d.a.s.g.b.b bVar = new d.a.s.g.b.b();
                jSONObject.put("id", this.f67793a);
                jSONObject.put("d_form_ver", 1);
                return Base64.encodeToString(bVar.b(jSONObject.toString().getBytes()), 3);
            }
            return (String) invokeV.objValue;
        }
    }

    /* renamed from: d.a.s.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1900b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f67794a;

        /* renamed from: b  reason: collision with root package name */
        public String f67795b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f67796c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f67797d;

        public C1900b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67797d = bVar;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67795b : (String) invokeV.objValue;
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.f67794a == j) {
                return;
            }
            this.f67794a = j;
            this.f67796c = true;
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str.equals(this.f67795b)) {
                return;
            }
            this.f67795b = str;
            this.f67796c = true;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? e(this.f67797d.f67791f.g("pub.dat", true)) : invokeV.booleanValue;
        }

        public final boolean e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        this.f67794a = jSONObject.getLong("pub_lst_ts");
                        this.f67795b = jSONObject.getString("pub_id");
                        jSONObject.getInt("d_form_ver");
                        this.f67796c = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.f67796c) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f67795b);
                        jSONObject.put("pub_lst_ts", this.f67794a);
                        jSONObject.put("d_form_ver", 1);
                        this.f67797d.f67791f.i("pub.dat", jSONObject.toString(), true);
                        this.f67796c = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f67798d;

        /* renamed from: e  reason: collision with root package name */
        public long f67799e;

        /* renamed from: f  reason: collision with root package name */
        public long f67800f;

        /* renamed from: g  reason: collision with root package name */
        public String f67801g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, String str) {
            super(bVar.f67791f, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a.C1904a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // d.a.s.e.a.c
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f67798d = jSONObject.getString("pkg");
                this.f67799e = jSONObject.getLong("last_fe_ts");
                this.f67801g = jSONObject.getString("id");
                this.f67800f = jSONObject.getLong("tar_pkg_lst_up_ts");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // d.a.s.e.a.c
        public void e(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f67798d);
                jSONObject.put("last_fe_ts", this.f67799e);
                jSONObject.put("id", this.f67801g);
                jSONObject.put("tar_pkg_lst_up_ts", this.f67800f);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67798d : (String) invokeV.objValue;
        }

        public boolean g(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                if (this.f67799e != j) {
                    this.f67799e = j;
                    a(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                if (str.equals(this.f67798d)) {
                    return false;
                }
                this.f67798d = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f67801g : (String) invokeV.objValue;
        }

        public boolean j(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                if (this.f67800f != j) {
                    this.f67800f = j;
                    a(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                if (str.equals(this.f67801g)) {
                    return false;
                }
                this.f67801g = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f67800f : invokeV.longValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("esc-ms", 7500000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], ((Long) objArr[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67792g = new C1900b(this);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, IF, IF] complete} */
    @Override // d.a.s.e.a
    public a.h b(String str, a.g gVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        c cVar;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, gVar)) == null) {
            if (Build.VERSION.SDK_INT < 29) {
                i2 = -101;
            } else {
                Context context = this.f67763a.f67767a;
                Cursor cursor = null;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                if (packageInfo == null) {
                    i2 = -1;
                } else {
                    if (gVar.f67773a) {
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
                                                    if (gVar.f67773a && cVar != null) {
                                                        cVar.k(a2);
                                                        cVar.g(System.currentTimeMillis());
                                                        cVar.j(packageInfo.lastUpdateTime);
                                                        cVar.h(str);
                                                    }
                                                    a.h e2 = a.h.e(a2);
                                                    d.a.s.g.c.a.c.a(cursor);
                                                    if (gVar.f67773a && cVar != null) {
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
                                d.a.s.g.c.a.c.a(cursor);
                                if (gVar.f67773a && cVar != null) {
                                    cVar.b();
                                }
                                i2 = -2;
                            } catch (Exception e3) {
                                a.h c2 = a.h.c(e3);
                                d.a.s.g.c.a.c.a(cursor);
                                if (gVar.f67773a && cVar != null) {
                                    cVar.b();
                                }
                                return c2;
                            }
                        } catch (Throwable th) {
                            d.a.s.g.c.a.c.a(cursor);
                            if (gVar.f67773a && cVar != null) {
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
        return (a.h) invokeLL.objValue;
    }

    @Override // d.a.s.e.a
    public void e(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.f67791f = this.f67764b.f("esc-ms");
        }
    }

    @Override // d.a.s.e.a
    public a.f f(a.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            if (Build.VERSION.SDK_INT < 29) {
                return a.f.a();
            }
            this.f67792g.d();
            try {
                return i(eVar);
            } finally {
                this.f67792g.f();
            }
        }
        return (a.f) invokeL.objValue;
    }

    public final Uri h(String str, ContentResolver contentResolver, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048579, this, str, contentResolver, str2)) != null) {
            return (Uri) invokeLLL.objValue;
        }
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
        InterceptResult invokeL;
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) {
            Context context = this.f67763a.f67767a;
            String packageName = context.getPackageName();
            ContentResolver contentResolver = this.f67763a.f67767a.getContentResolver();
            String c2 = this.f67763a.f67769c.a("aid").c();
            String a2 = this.f67792g.a();
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
                    this.f67792g.c(c2);
                    this.f67792g.b(System.currentTimeMillis());
                    a.f d2 = a.f.d();
                    d.a.s.g.c.a.c.b(autoCloseOutputStream);
                    return d2;
                } catch (Exception e3) {
                    e = e3;
                    autoCloseOutputStream2 = autoCloseOutputStream;
                    a.f c3 = a.f.c(e);
                    d.a.s.g.c.a.c.b(autoCloseOutputStream2);
                    return c3;
                } catch (Throwable th2) {
                    th = th2;
                    autoCloseOutputStream2 = autoCloseOutputStream;
                    d.a.s.g.c.a.c.b(autoCloseOutputStream2);
                    throw th;
                }
            }
            return a.f.d();
        }
        return (a.f) invokeL.objValue;
    }

    public final void j(OutputStream outputStream, Context context) {
        float min;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, outputStream, context) == null) {
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
}
