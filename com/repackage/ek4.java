package com.repackage;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes5.dex */
public class ek4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public c b;
    public final Context c;
    public int d;
    public String[] e;
    public String[] f;
    public HashMap<String, zj4> g;

    /* loaded from: classes5.dex */
    public class a implements Comparator<MediaFileInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ek4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(MediaFileInfo mediaFileInfo, MediaFileInfo mediaFileInfo2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaFileInfo, mediaFileInfo2)) == null) {
                int i = ((mediaFileInfo2.getSortTime() - mediaFileInfo.getSortTime()) > 0L ? 1 : ((mediaFileInfo2.getSortTime() - mediaFileInfo.getSortTime()) == 0L ? 0 : -1));
                if (i == 0) {
                    return 0;
                }
                return i > 0 ? 1 : -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Comparator<zj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek4 a;

        public b(ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ek4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ek4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(zj4 zj4Var, zj4 zj4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, zj4Var, zj4Var2)) == null) {
                if (this.a.a.equals(zj4Var.g())) {
                    return -1;
                }
                if (this.a.a.equals(zj4Var2.g())) {
                    return 1;
                }
                int i = ((zj4Var2.e().getSortTime() - zj4Var.e().getSortTime()) > 0L ? 1 : ((zj4Var2.e().getSortTime() - zj4Var.e().getSortTime()) == 0L ? 0 : -1));
                if (i == 0) {
                    return 0;
                }
                return i > 0 ? 1 : -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Object, Integer, fk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final dk4 a;
        public final /* synthetic */ ek4 b;

        public c(ek4 ek4Var, dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ek4Var, dk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ek4Var;
            this.a = dk4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public fk4 doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) ? this.b.d() : (fk4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(fk4 fk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fk4Var) == null) {
                super.onPostExecute(fk4Var);
                dk4 dk4Var = this.a;
                if (dk4Var != null) {
                    dk4Var.a(fk4Var);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onPreExecute();
                dk4 dk4Var = this.a;
                if (dk4Var != null) {
                    dk4Var.onPreLoad();
                }
            }
        }
    }

    public ek4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = TbConfig.getTempDirName();
        this.d = 0;
        this.e = new String[]{"_id", "bucket_id", "bucket_display_name", "_data", "mime_type", "date_added", "_size", "date_modified"};
        this.f = new String[]{"_id", "_data", "title", "mime_type", "_display_name", "duration", "datetaken", "date_modified", "date_added"};
        this.g = new HashMap<>();
        this.c = context;
    }

    public void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.b) == null) {
            return;
        }
        cVar.cancel();
        this.b = null;
    }

    public final fk4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.g.clear();
            fk4 fk4Var = new fk4();
            List<VideoFileInfo> list = null;
            List<ImageFileInfo> e = this.d != 1 ? e() : null;
            int i = this.d;
            if (i != 2 && i != 3) {
                list = g();
            }
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(e)) {
                arrayList.addAll(e);
            }
            if (!ListUtils.isEmpty(list)) {
                arrayList.addAll(list);
            }
            if (!ListUtils.isEmpty(arrayList)) {
                Collections.sort(arrayList, new a(this));
            }
            ArrayList arrayList2 = new ArrayList(this.g.values());
            if (!ListUtils.isEmpty(arrayList2)) {
                Collections.sort(arrayList2, new b(this));
            }
            fk4Var.a = arrayList2;
            fk4Var.c = list;
            fk4Var.b = arrayList;
            return fk4Var;
        }
        return (fk4) invokeV.objValue;
    }

    public List<ImageFileInfo> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<ImageFileInfo> f = f(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (f != null) {
                arrayList.addAll(f);
            }
            List<ImageFileInfo> f2 = f(MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            if (f2 != null) {
                arrayList.addAll(f2);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0104 A[LOOP:0: B:12:0x002c->B:38:0x0104, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0115 A[EDGE_INSN: B:70:0x0115->B:47:0x0115 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ImageFileInfo> f(Uri uri) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uri)) == null) {
            ek4 ek4Var = this;
            String str = null;
            if (ek4Var.c == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                Cursor query = ek4Var.c.getContentResolver().query(uri, ek4Var.e, "mime_type like 'image/%'", null, "date_added DESC");
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            while (true) {
                                Uri withAppendedId = ContentUris.withAppendedId(uri, query.getLong(query.getColumnIndex("_id")));
                                String uri2 = withAppendedId != null ? withAppendedId.toString() : str;
                                String string = query.getString(query.getColumnIndex("bucket_id"));
                                String string2 = query.getString(query.getColumnIndex("bucket_display_name"));
                                String string3 = query.getString(query.getColumnIndex("_data"));
                                String string4 = query.getString(query.getColumnIndex("mime_type"));
                                long j = query.getLong(query.getColumnIndex("date_added"));
                                int i = query.getInt(query.getColumnIndex("_size"));
                                long j2 = query.getLong(query.getColumnIndex("date_modified"));
                                boolean endsWith = string4.endsWith(NativeConstants.TYPE_GIF);
                                if (endsWith) {
                                    try {
                                        if (ek4Var.d == 3 || i > 3145728) {
                                            ek4Var = this;
                                            if (query.moveToNext()) {
                                                break;
                                            }
                                            str = null;
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        cursor = query;
                                        try {
                                            BdLog.detailException(e);
                                            ig.a(cursor);
                                            return arrayList;
                                        } catch (Throwable th) {
                                            th = th;
                                            ig.a(cursor);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        cursor = query;
                                        ig.a(cursor);
                                        throw th;
                                    }
                                }
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                imageFileInfo.setAlbumnId(string);
                                imageFileInfo.setContentUriStr(uri2);
                                imageFileInfo.setFilePath(string3);
                                imageFileInfo.setIsGif(endsWith);
                                imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(j2));
                                imageFileInfo.setSortTime(j);
                                arrayList.add(imageFileInfo);
                                ek4Var = this;
                                zj4 zj4Var = ek4Var.g.get(string);
                                if (zj4Var == null) {
                                    zj4Var = new zj4();
                                    ek4Var.g.put(string, zj4Var);
                                }
                                zj4Var.h(string);
                                zj4Var.l(string2);
                                zj4Var.a();
                                if (zj4Var.e() == null) {
                                    zj4Var.k(imageFileInfo);
                                }
                                List<MediaFileInfo> d = zj4Var.d();
                                if (zj4Var.d() == null) {
                                    d = new ArrayList<>();
                                    zj4Var.j(d);
                                }
                                d.add(imageFileInfo);
                                if (query.moveToNext()) {
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                ig.a(query);
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th4) {
                th = th4;
                cursor = null;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final List<VideoFileInfo> g() {
        InterceptResult invokeV;
        Cursor cursor;
        Cursor cursor2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Context context = this.c;
            if (context == null) {
                return arrayList;
            }
            ContentResolver contentResolver = context.getContentResolver();
            HashSet hashSet = new HashSet();
            try {
                Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                Cursor query = contentResolver.query(uri, this.f, null, null, "date_added DESC");
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            while (true) {
                                int i = query.getInt(query.getColumnIndex("_id"));
                                Uri withAppendedId = ContentUris.withAppendedId(uri, i);
                                String uri2 = withAppendedId != null ? withAppendedId.toString() : null;
                                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                                String string2 = query.getString(query.getColumnIndexOrThrow("title"));
                                String string3 = query.getString(query.getColumnIndexOrThrow("_display_name"));
                                String string4 = query.getString(query.getColumnIndexOrThrow("mime_type"));
                                int i2 = query.getInt(query.getColumnIndexOrThrow("duration"));
                                long j = query.getLong(query.getColumnIndexOrThrow("date_modified"));
                                Uri uri3 = uri;
                                long j2 = query.getLong(query.getColumnIndexOrThrow("date_added"));
                                if (i2 > 1 && !hashSet.contains(string)) {
                                    hashSet.add(string);
                                    File file = new File(string);
                                    if (file.exists() && file.isFile() && fi.u(file) > 0) {
                                        VideoFileInfo videoFileInfo = new VideoFileInfo();
                                        videoFileInfo.videoId = i;
                                        videoFileInfo.contentUriStr = uri2;
                                        videoFileInfo.videoPath = string;
                                        videoFileInfo.displayName = string3;
                                        videoFileInfo.title = string2;
                                        videoFileInfo.mimeType = string4;
                                        videoFileInfo.videoDuration = i2;
                                        videoFileInfo.lastModified = j;
                                        videoFileInfo.setSortTime(j2);
                                        arrayList.add(videoFileInfo);
                                    }
                                }
                                if (!query.moveToNext()) {
                                    break;
                                }
                                uri = uri3;
                            }
                        }
                    } catch (Exception unused) {
                        cursor2 = query;
                        ig.a(cursor2);
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        ig.a(cursor);
                        throw th;
                    }
                }
                ig.a(query);
            } catch (Exception unused2) {
                cursor2 = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public boolean h(int i, dk4 dk4Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, dk4Var)) == null) {
            if (dk4Var == null) {
                return false;
            }
            c();
            this.d = i;
            c cVar = new c(this, dk4Var);
            this.b = cVar;
            cVar.setPriority(3);
            this.b.execute(new Object[0]);
            return true;
        }
        return invokeIL.booleanValue;
    }
}
