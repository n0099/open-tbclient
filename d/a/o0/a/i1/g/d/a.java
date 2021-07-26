package d.a.o0.a.i1.g.d;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.FileUtils;
import com.baidu.android.util.io.PathUtils;
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
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.e2.c.j.b;
import java.io.File;
import java.net.URI;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.i1.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0794a implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46115e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46116f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46117g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f46118h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46119i;
        public final /* synthetic */ a j;

        public C0794a(a aVar, CallbackHandler callbackHandler, String str, Context context, File file, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, str, context, file, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = aVar;
            this.f46115e = callbackHandler;
            this.f46116f = str;
            this.f46117g = context;
            this.f46118h = file;
            this.f46119i = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.o0.a.e2.c.d.h(iVar)) {
                    this.j.u(this.f46117g, this.f46118h, this.f46119i, this.f46115e, this.f46116f);
                } else {
                    d.a.o0.a.e2.c.d.p(iVar, this.f46115e, this.f46116f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.o0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f46120a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f46121b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46122c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f46123d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46124e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f46125f;

        public b(a aVar, Context context, File file, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, file, callbackHandler, str, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46125f = aVar;
            this.f46120a = context;
            this.f46121b = file;
            this.f46122c = callbackHandler;
            this.f46123d = str;
            this.f46124e = unitedSchemeEntity;
        }

        @Override // d.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f44085b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f46125f.x(this.f46120a, this.f46121b, this.f46122c, this.f46123d);
            }
        }

        @Override // d.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f46122c, this.f46124e, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f46123d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements h.n.b<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46126e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46127f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46128g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f46129h;

        public c(a aVar, CallbackHandler callbackHandler, String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46129h = aVar;
            this.f46126e = callbackHandler;
            this.f46127f = str;
            this.f46128g = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                if (file == null) {
                    this.f46126e.handleSchemeDispatchCallback(this.f46127f, UnitedSchemeUtility.wrapCallbackParams(1001, "output file create fail").toString());
                    return;
                }
                Uri fromFile = Uri.fromFile(file);
                this.f46129h.w(this.f46128g, file.getPath(), -1L);
                this.f46128g.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", fromFile));
                if (a0.f44085b) {
                    Log.i("SaveVideoAction", "saveToAlbum : file = " + file);
                }
                this.f46126e.handleSchemeDispatchCallback(this.f46127f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements h.n.f<File, File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46130e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f46131f;

        public d(a aVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46131f = aVar;
            this.f46130e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public File call(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                String x = d.a.o0.a.k2.b.x(d.a.o0.a.a2.e.V());
                if (TextUtils.isEmpty(x) || !file.getPath().startsWith(x)) {
                    return null;
                }
                return this.f46131f.q(this.f46130e, file);
            }
            return (File) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/saveVideoToPhotosAlbum");
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

    public static File t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
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
        return (File) invokeL.objValue;
    }

    @Override // d.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            } else if (eVar.d0()) {
                if (a0.f44085b) {
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
                        String M = d.a.o0.a.k2.b.M(optString, eVar.f43885f);
                        if (!TextUtils.isEmpty(M)) {
                            file = new File(M);
                        }
                    } else {
                        String L = d.a.o0.a.k2.b.L(optString, eVar, eVar.Z());
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
                        eVar.T().g(context, "mapp_images", new C0794a(this, callbackHandler, optString2, context, file, unitedSchemeEntity));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                        return true;
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not find such file : " + file);
                    return false;
                } catch (Exception e2) {
                    if (a0.f44085b) {
                        e2.printStackTrace();
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "Illegal file_path : " + optString);
                    return false;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return new File(str).exists();
        }
        return invokeL.booleanValue;
    }

    public final File q(Context context, @NonNull File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, file)) == null) {
            File t = t(context);
            if (t == null) {
                return null;
            }
            File file2 = new File(t, file.getName());
            if (d.a.o0.t.d.f(file, file2) > 0) {
                return file2;
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public final long r(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) ? j <= 0 ? System.currentTimeMillis() : j : invokeJ.longValue;
    }

    public final String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            String lowerCase = str.toLowerCase();
            return (lowerCase.endsWith("mp4") || lowerCase.endsWith("mpeg4") || !lowerCase.endsWith("3gp")) ? "video/mp4" : "video/3gp";
        }
        return (String) invokeL.objValue;
    }

    public final void u(@NonNull Context context, @NonNull File file, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, context, file, unitedSchemeEntity, callbackHandler, str) == null) {
            d.a.o0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new b(this, context, file, callbackHandler, str, unitedSchemeEntity));
        }
    }

    public final ContentValues v(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j)) == null) {
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
        return (ContentValues) invokeLJ.objValue;
    }

    public final void w(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, str, Long.valueOf(j)}) == null) && p(str)) {
            long r = r(j);
            ContentValues v = v(str, r);
            v.put("datetaken", Long.valueOf(r));
            v.put("mime_type", s(str));
            context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, v);
        }
    }

    public final void x(@NonNull Context context, @NonNull File file, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, file, callbackHandler, str) == null) {
            if (file == null) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "can not save to album : " + file).toString());
                return;
            }
            h.d.i(file).k(new d(this, context)).D(Schedulers.io()).o(h.l.b.a.b()).B(new c(this, callbackHandler, str, context));
        }
    }
}
