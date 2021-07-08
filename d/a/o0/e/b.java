package d.a.o0.e;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f51928a;

    /* renamed from: b  reason: collision with root package name */
    public a f51929b;

    /* renamed from: c  reason: collision with root package name */
    public c f51930c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f51931d;

    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<Object, Integer, List<d.a.o0.e.a>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.a.o0.e.c f51932a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f51933b;

        public a(b bVar, d.a.o0.e.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51933b = bVar;
            this.f51932a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<d.a.o0.e.a> doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) ? this.f51933b.f() : (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<d.a.o0.e.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                super.onPostExecute(list);
                d.a.o0.e.c cVar = this.f51932a;
                if (cVar != null) {
                    cVar.a(list);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onPreExecute();
                d.a.o0.e.c cVar = this.f51932a;
                if (cVar != null) {
                    cVar.onPreLoad();
                }
            }
        }
    }

    /* renamed from: d.a.o0.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1188b {
        void a(List<ImageFileInfo> list);
    }

    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<Void, List<ImageFileInfo>, List<ImageFileInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d f51934a;

        /* renamed from: b  reason: collision with root package name */
        public final String f51935b;

        /* renamed from: c  reason: collision with root package name */
        public String f51936c;

        /* renamed from: d  reason: collision with root package name */
        public List<d.a.o0.e.a> f51937d;

        /* renamed from: e  reason: collision with root package name */
        public int f51938e;

        /* renamed from: f  reason: collision with root package name */
        public InterfaceC1188b f51939f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f51940g;

        /* loaded from: classes7.dex */
        public class a implements InterfaceC1188b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f51941a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f51941a = cVar;
            }

            @Override // d.a.o0.e.b.InterfaceC1188b
            public void a(List<ImageFileInfo> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.f51941a.publishProgress(list);
                }
            }
        }

        public c(b bVar, String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51940g = bVar;
            this.f51938e = 1;
            this.f51939f = new a(this);
            this.f51934a = dVar;
            this.f51935b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public List<ImageFileInfo> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                if (TextUtils.isEmpty(this.f51935b)) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                if (this.f51935b.equals(d.a.o0.e.a.f51921f)) {
                    List<d.a.o0.e.a> f2 = this.f51940g.f();
                    this.f51937d = f2;
                    if (f2 != null) {
                        for (d.a.o0.e.a aVar : f2) {
                            String b2 = aVar.b();
                            if (!TextUtils.isEmpty(b2)) {
                                e(arrayList, this.f51939f, b2);
                            }
                        }
                    }
                    return arrayList;
                }
                e(arrayList, this.f51939f, this.f51935b);
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        public final void d(List<ImageFileInfo> list, InterfaceC1188b interfaceC1188b, String str, Context context, Uri uri) {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, interfaceC1188b, str, context, uri) == null) || list == null) {
                return;
            }
            Cursor cursor = null;
            cursor = null;
            try {
                Cursor query = context.getContentResolver().query(uri, new String[]{"_id", "bucket_id", "_data", "bucket_display_name"}, "bucket_id=?", new String[]{str}, "datetaken DESC");
                try {
                    if (query.moveToFirst()) {
                        int columnIndex = query.getColumnIndex("_data");
                        int columnIndex2 = query.getColumnIndex("bucket_display_name");
                        Uri withAppendedId = ContentUris.withAppendedId(uri, query.getLong(query.getColumnIndex("_id")));
                        String uri2 = withAppendedId != null ? withAppendedId.toString() : null;
                        do {
                            String string = query.getString(columnIndex);
                            try {
                                this.f51936c = query.getString(columnIndex2);
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                imageFileInfo.setAlbumnId(str);
                                imageFileInfo.setContentUriStr(uri2);
                                imageFileInfo.setFilePath(string);
                                File file = new File(string);
                                if (file.exists() && file.isFile() && file.length() > 0) {
                                    if (string.toLowerCase().endsWith(".gif") && FileHelper.isGifImage(string)) {
                                        if (d.a.c.e.p.f.w(file) <= 3145728) {
                                            z = true;
                                        }
                                    } else if (FileHelper.checkIsLongImage(string)) {
                                        z = false;
                                        z2 = true;
                                        imageFileInfo.setIsGif(z);
                                        imageFileInfo.setIsLong(z2);
                                        imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(file.lastModified()));
                                        list.add(imageFileInfo);
                                        f(list, interfaceC1188b);
                                    } else {
                                        z = false;
                                    }
                                    z2 = false;
                                    imageFileInfo.setIsGif(z);
                                    imageFileInfo.setIsLong(z2);
                                    imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(file.lastModified()));
                                    list.add(imageFileInfo);
                                    f(list, interfaceC1188b);
                                }
                            } catch (Exception e2) {
                                e = e2;
                                cursor = query;
                                try {
                                    BdLog.detailException(e);
                                    d.a.c.e.m.a.a(cursor);
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    d.a.c.e.m.a.a(cursor);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = query;
                                d.a.c.e.m.a.a(cursor);
                                throw th;
                            }
                        } while (query.moveToNext());
                    }
                    d.a.c.e.m.a.a(query);
                } catch (Exception e3) {
                    e = e3;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e4) {
                e = e4;
            } catch (Throwable th4) {
                th = th4;
            }
        }

        public final void e(List<ImageFileInfo> list, InterfaceC1188b interfaceC1188b, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048579, this, list, interfaceC1188b, str) == null) || list == null) {
                return;
            }
            d(list, interfaceC1188b, str, this.f51940g.f51931d, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (list == null || list.size() <= 0) {
                d(list, interfaceC1188b, str, this.f51940g.f51931d, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            }
        }

        public final void f(List<ImageFileInfo> list, InterfaceC1188b interfaceC1188b) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048580, this, list, interfaceC1188b) == null) || list == null || interfaceC1188b == null) {
                return;
            }
            int i2 = this.f51938e;
            if (i2 != 1 && i2 != 2) {
                if (list.size() / this.f51938e > 500) {
                    if (interfaceC1188b != null) {
                        interfaceC1188b.a(list);
                    }
                    this.f51938e++;
                }
            } else if (list.size() / this.f51938e > 50) {
                if (interfaceC1188b != null) {
                    interfaceC1188b.a(list);
                }
                this.f51938e++;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public void onPostExecute(List<ImageFileInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
                super.onPostExecute(list);
                d dVar = this.f51934a;
                if (dVar != null) {
                    dVar.a(this.f51937d, list, this.f51936c);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public void onProgressUpdate(List<ImageFileInfo>... listArr) {
            d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, listArr) == null) {
                super.onProgressUpdate(listArr);
                if (listArr.length <= 0 || (dVar = this.f51934a) == null) {
                    return;
                }
                dVar.a(this.f51937d, listArr[0], this.f51936c);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                super.onPreCancel();
                d dVar = this.f51934a;
                if (dVar != null) {
                    dVar.onPreLoad();
                }
            }
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51928a = TbConfig.getTempDirName();
        this.f51931d = context;
    }

    public void c() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f51929b) == null) {
            return;
        }
        aVar.cancel();
        this.f51929b = null;
    }

    public void d() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f51930c) == null) {
            return;
        }
        cVar.cancel();
        this.f51930c = null;
    }

    public final List<d.a.o0.e.a> e(Context context, List<d.a.o0.e.a> list, Uri uri, HashSet<String> hashSet) {
        InterceptResult invokeLLLL;
        int i2;
        File[] listFiles;
        Matcher matcher;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, list, uri, hashSet)) == null) {
            Cursor cursor = null;
            if (context == null) {
                return null;
            }
            Pattern compile = Pattern.compile("image\\/\\w+", 2);
            List<d.a.o0.e.a> arrayList = list == null ? new ArrayList<>() : list;
            try {
                try {
                    cursor = context.getContentResolver().query(uri, new String[]{"bucket_id", "bucket_display_name", "_data", "count(*)"}, "mime_type like 'image/%') GROUP BY 1,(2", null, "date_added DESC");
                    if (cursor.moveToFirst()) {
                        int columnIndex = cursor.getColumnIndex("bucket_id");
                        int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
                        int columnIndex3 = cursor.getColumnIndex("_data");
                        int columnIndex4 = cursor.getColumnIndex("count(*)");
                        do {
                            String string = cursor.getString(columnIndex);
                            String string2 = cursor.getString(columnIndex2);
                            String string3 = cursor.getString(columnIndex3);
                            cursor.getString(columnIndex4);
                            String substring = string3.substring(0, string3.lastIndexOf("/"));
                            if (hashSet != null) {
                                if (!hashSet.contains(substring)) {
                                    hashSet.add(substring);
                                }
                            }
                            File file = new File(substring);
                            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                                i2 = 0;
                                for (File file2 : listFiles) {
                                    String j = j(file2.getAbsolutePath());
                                    if (j != null && (matcher = compile.matcher(j)) != null && matcher.matches()) {
                                        i2++;
                                    }
                                }
                            } else {
                                i2 = 0;
                            }
                            if (i2 != 0) {
                                d.a.o0.e.a aVar = new d.a.o0.e.a();
                                aVar.h(string);
                                aVar.i(i2 + "");
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                File file3 = new File(string3);
                                if (file3.exists() && file3.isFile()) {
                                    imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(file3.lastModified()));
                                }
                                imageFileInfo.setFilePath(string3);
                                aVar.k(imageFileInfo);
                                aVar.l(string2);
                                if (string2 != null && string2.equals(this.f51928a)) {
                                    arrayList.add(0, aVar);
                                } else {
                                    arrayList.add(aVar);
                                }
                            }
                        } while (cursor.moveToNext());
                    }
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
                return arrayList;
            } finally {
                d.a.c.e.m.a.a(cursor);
            }
        }
        return (List) invokeLLLL.objValue;
    }

    public final List<d.a.o0.e.a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashSet<String> hashSet = new HashSet<>();
            return e(this.f51931d, e(this.f51931d, null, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, hashSet), MediaStore.Images.Media.INTERNAL_CONTENT_URI, hashSet);
        }
        return (List) invokeV.objValue;
    }

    public boolean g(d.a.o0.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            c();
            a aVar = new a(this, cVar);
            this.f51929b = aVar;
            aVar.setPriority(3);
            this.f51929b.execute(new Object[0]);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final String h(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            int lastIndexOf2 = str.lastIndexOf(35);
            if (lastIndexOf2 > 0) {
                str = str.substring(0, lastIndexOf2);
            }
            int lastIndexOf3 = str.lastIndexOf(63);
            if (lastIndexOf3 > 0) {
                str = str.substring(0, lastIndexOf3);
            }
            int lastIndexOf4 = str.lastIndexOf(47);
            if (lastIndexOf4 >= 0) {
                str = str.substring(lastIndexOf4 + 1);
            }
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) < 0 || lastIndexOf >= str.length() + (-1)) ? "" : str.substring(lastIndexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    public boolean i(String str, d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, dVar)) == null) {
            if (dVar == null) {
                return false;
            }
            d();
            c cVar = new c(this, str, dVar);
            this.f51930c = cVar;
            cVar.setPriority(3);
            this.f51930c.execute(new Void[0]);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            String h2 = h(str);
            if (h2 != null) {
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(h2.toLowerCase(Locale.getDefault()));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
