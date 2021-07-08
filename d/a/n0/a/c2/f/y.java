package d.a.n0.a.c2.f;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.n0.a.e2.c.j.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class y extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.n0.a.v2.e1.b<d.a.n0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43909e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43910f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43911g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f43912h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43913i;
        public final /* synthetic */ y j;

        /* renamed from: d.a.n0.a.c2.f.y$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0660a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f43914e;

            public RunnableC0660a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43914e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f43914e;
                    aVar.j.p(aVar.f43911g, aVar.f43912h, aVar.f43913i, aVar.f43909e, aVar.f43910f);
                }
            }
        }

        public a(y yVar, CallbackHandler callbackHandler, String str, Context context, File file, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar, callbackHandler, str, context, file, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = yVar;
            this.f43909e = callbackHandler;
            this.f43910f = str;
            this.f43911g = context;
            this.f43912h = file;
            this.f43913i = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.a.n0.a.e2.c.d.h(iVar)) {
                    d.a.n0.a.e0.d.g("SaveImage", "Permission denied");
                    d.a.n0.a.e2.c.d.p(iVar, this.f43909e, this.f43910f);
                    return;
                }
                d.a.n0.a.v2.q.j(new RunnableC0660a(this), "SaveImageAction");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.n0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f43915a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f43916b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43917c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f43918d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43919e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ y f43920f;

        public b(y yVar, Context context, File file, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar, context, file, callbackHandler, str, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43920f = yVar;
            this.f43915a = context;
            this.f43916b = file;
            this.f43917c = callbackHandler;
            this.f43918d = str;
            this.f43919e = unitedSchemeEntity;
        }

        @Override // d.a.n0.a.s1.f
        public void a(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                boolean q = d.a.n0.a.v2.d.a() ? this.f43920f.q(this.f43915a, this.f43916b) : this.f43920f.r(this.f43915a, this.f43916b);
                int i2 = q ? 0 : 1001;
                if (q) {
                    str2 = "save success";
                } else {
                    str2 = "can not save to album : " + this.f43916b;
                }
                d.a.n0.a.e0.d.g("SaveImage", str2);
                this.f43917c.handleSchemeDispatchCallback(this.f43918d, UnitedSchemeUtility.wrapCallbackParams(i2, str2).toString());
            }
        }

        @Override // d.a.n0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                d.a.n0.a.e0.d.g("SaveImage", str + "");
                UnitedSchemeUtility.safeCallback(this.f43917c, this.f43919e, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f43918d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(d.a.n0.a.c2.e eVar) {
        super(eVar, "/swanAPI/saveImageToPhotosAlbum");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static String o(Uri uri, Context context) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri, context)) == null) {
            Cursor cursor2 = null;
            r7 = null;
            r7 = null;
            String str = null;
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                if (cursor != null) {
                    try {
                        try {
                            int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
                            cursor.moveToFirst();
                            str = cursor.getString(columnIndexOrThrow);
                        } catch (SQLException e2) {
                            e = e2;
                            if (a0.f43581b) {
                                e.printStackTrace();
                            }
                            d.a.n0.t.d.d(cursor);
                            return str;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        d.a.n0.t.d.d(cursor2);
                        throw th;
                    }
                }
            } catch (SQLException e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                d.a.n0.t.d.d(cursor2);
                throw th;
            }
            d.a.n0.t.d.d(cursor);
            return str;
        }
        return (String) invokeLL.objValue;
    }

    @Override // d.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                d.a.n0.a.e0.d.b("SaveImage", "illegal swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            }
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d.a.n0.a.e0.d.b("SaveImage", "illegal params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params");
                return false;
            }
            String optString = a2.optString("filePath");
            try {
                File n = n(eVar, optString, URI.create(optString));
                if (n != null && n.exists() && n.isFile()) {
                    String optString2 = a2.optString("cb");
                    if (TextUtils.isEmpty(optString2)) {
                        d.a.n0.a.e0.d.b("SaveImage", "empty cb");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                        return false;
                    }
                    eVar.T().g(context, "mapp_images", new a(this, callbackHandler, optString2, context, n, unitedSchemeEntity));
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                d.a.n0.a.e0.d.b("SaveImage", "can not find such file");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not find such file : " + n);
                return false;
            } catch (Exception e2) {
                if (a0.f43581b) {
                    e2.printStackTrace();
                }
                d.a.n0.a.e0.d.b("SaveImage", "Illegal file_path");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "Illegal file_path : " + optString);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final String m(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) {
            String s = d.a.n0.t.d.s(file.getPath());
            String valueOf = String.valueOf(System.currentTimeMillis());
            if (TextUtils.isEmpty(s)) {
                return valueOf;
            }
            return valueOf + "." + s;
        }
        return (String) invokeL.objValue;
    }

    public final File n(d.a.n0.a.a2.e eVar, String str, URI uri) {
        InterceptResult invokeLLL;
        String e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, str, uri)) == null) {
            d.a.n0.a.k2.f.d I = d.a.n0.a.g1.f.V().I();
            if ("bdfile".equalsIgnoreCase(uri.getScheme())) {
                e2 = I.i(str);
            } else if (d.a.n0.a.u1.a.a.A(eVar.N())) {
                e2 = I.m(str);
            } else {
                e2 = I.e(str);
            }
            if (TextUtils.isEmpty(e2)) {
                return null;
            }
            return new File(e2);
        }
        return (File) invokeLLL.objValue;
    }

    public final void p(@NonNull Context context, File file, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, file, unitedSchemeEntity, callbackHandler, str) == null) {
            d.a.n0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(this, context, file, callbackHandler, str, unitedSchemeEntity));
        }
    }

    public final boolean q(Context context, File file) {
        String str;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, file)) == null) {
            try {
                str = MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getPath(), file.getName(), "by aiapp");
            } catch (FileNotFoundException e2) {
                if (a0.f43581b) {
                    e2.printStackTrace();
                }
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                String o = o(Uri.parse(str), context);
                if (!TextUtils.isEmpty(o)) {
                    d.a.n0.a.v2.u.q(context, o);
                }
            }
            if (a0.f43581b) {
                Log.i("SaveImageAction", "saveToAlbum : file = " + file);
                Log.i("SaveImageAction", "saveToAlbum : image = " + str);
            }
            d.a.n0.a.e0.d.g("SaveImage", "save success");
            return !TextUtils.isEmpty(str);
        }
        return invokeLL.booleanValue;
    }

    public final boolean r(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, context, file)) == null) {
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getPath());
            if (decodeFile == null) {
                return false;
            }
            decodeFile.recycle();
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            d.a.n0.t.d.k(externalStoragePublicDirectory);
            File file2 = new File(externalStoragePublicDirectory, m(file));
            if (d.a.n0.t.d.f(file, file2) != 0) {
                d.a.n0.a.v2.u.q(context, file2.getAbsolutePath());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
