package d.a.o0.e;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f51942a;

    /* renamed from: b  reason: collision with root package name */
    public c f51943b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f51944c;

    /* renamed from: d  reason: collision with root package name */
    public int f51945d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f51946e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f51947f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, d.a.o0.e.a> f51948g;

    /* loaded from: classes7.dex */
    public class a implements Comparator<MediaFileInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                int i2 = ((mediaFileInfo2.getSortTime() - mediaFileInfo.getSortTime()) > 0L ? 1 : ((mediaFileInfo2.getSortTime() - mediaFileInfo.getSortTime()) == 0L ? 0 : -1));
                if (i2 == 0) {
                    return 0;
                }
                return i2 > 0 ? 1 : -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Comparator<d.a.o0.e.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f51949e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51949e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d.a.o0.e.a aVar, d.a.o0.e.a aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, aVar2)) == null) {
                if (this.f51949e.f51942a.equals(aVar.g())) {
                    return -1;
                }
                if (this.f51949e.f51942a.equals(aVar2.g())) {
                    return 1;
                }
                int i2 = ((aVar2.e().getSortTime() - aVar.e().getSortTime()) > 0L ? 1 : ((aVar2.e().getSortTime() - aVar.e().getSortTime()) == 0L ? 0 : -1));
                if (i2 == 0) {
                    return 0;
                }
                return i2 > 0 ? 1 : -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<Object, Integer, g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final e f51950a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f51951b;

        public c(f fVar, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51951b = fVar;
            this.f51950a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public g doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) ? this.f51951b.d() : (g) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
                super.onPostExecute(gVar);
                e eVar = this.f51950a;
                if (eVar != null) {
                    eVar.a(gVar);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onPreExecute();
                e eVar = this.f51950a;
                if (eVar != null) {
                    eVar.onPreLoad();
                }
            }
        }
    }

    public f(Context context) {
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
        this.f51942a = TbConfig.getTempDirName();
        this.f51945d = 0;
        this.f51946e = new String[]{"_id", "bucket_id", "bucket_display_name", "_data", "mime_type", "date_added", "_size", "date_modified"};
        this.f51947f = new String[]{"_id", "_data", "title", "mime_type", "_display_name", "duration", "datetaken", "date_modified", "date_added"};
        this.f51948g = new HashMap<>();
        this.f51944c = context;
    }

    public void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f51943b) == null) {
            return;
        }
        cVar.cancel();
        this.f51943b = null;
    }

    public final g d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f51948g.clear();
            g gVar = new g();
            List<VideoFileInfo> list = null;
            List<ImageFileInfo> e2 = this.f51945d != 1 ? e() : null;
            int i2 = this.f51945d;
            if (i2 != 2 && i2 != 3) {
                list = g();
            }
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(e2)) {
                arrayList.addAll(e2);
            }
            if (!ListUtils.isEmpty(list)) {
                arrayList.addAll(list);
            }
            if (!ListUtils.isEmpty(arrayList)) {
                Collections.sort(arrayList, new a(this));
            }
            ArrayList arrayList2 = new ArrayList(this.f51948g.values());
            if (!ListUtils.isEmpty(arrayList2)) {
                Collections.sort(arrayList2, new b(this));
            }
            gVar.f51952a = arrayList2;
            gVar.f51954c = list;
            gVar.f51953b = arrayList;
            return gVar;
        }
        return (g) invokeV.objValue;
    }

    public List<ImageFileInfo> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<ImageFileInfo> f2 = f(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (f2 != null) {
                arrayList.addAll(f2);
            }
            List<ImageFileInfo> f3 = f(MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            if (f3 != null) {
                arrayList.addAll(f3);
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
            f fVar = this;
            String str = null;
            if (fVar.f51944c == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                Cursor query = fVar.f51944c.getContentResolver().query(uri, fVar.f51946e, "mime_type like 'image/%'", null, "date_added DESC");
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
                                int i2 = query.getInt(query.getColumnIndex("_size"));
                                long j2 = query.getLong(query.getColumnIndex("date_modified"));
                                boolean endsWith = string4.endsWith("gif");
                                if (endsWith) {
                                    try {
                                        if (fVar.f51945d == 3 || i2 > 3145728) {
                                            fVar = this;
                                            if (query.moveToNext()) {
                                                break;
                                            }
                                            str = null;
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        cursor = query;
                                        try {
                                            BdLog.detailException(e);
                                            d.a.c.e.m.a.a(cursor);
                                            return arrayList;
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
                                }
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                imageFileInfo.setAlbumnId(string);
                                imageFileInfo.setContentUriStr(uri2);
                                imageFileInfo.setFilePath(string3);
                                imageFileInfo.setIsGif(endsWith);
                                imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(j2));
                                imageFileInfo.setSortTime(j);
                                arrayList.add(imageFileInfo);
                                fVar = this;
                                d.a.o0.e.a aVar = fVar.f51948g.get(string);
                                if (aVar == null) {
                                    aVar = new d.a.o0.e.a();
                                    fVar.f51948g.put(string, aVar);
                                }
                                aVar.h(string);
                                aVar.l(string2);
                                aVar.a();
                                if (aVar.e() == null) {
                                    aVar.k(imageFileInfo);
                                }
                                List<MediaFileInfo> d2 = aVar.d();
                                if (aVar.d() == null) {
                                    d2 = new ArrayList<>();
                                    aVar.j(d2);
                                }
                                d2.add(imageFileInfo);
                                if (query.moveToNext()) {
                                }
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                d.a.c.e.m.a.a(query);
            } catch (Exception e4) {
                e = e4;
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
            Context context = this.f51944c;
            if (context == null) {
                return arrayList;
            }
            ContentResolver contentResolver = context.getContentResolver();
            HashSet hashSet = new HashSet();
            try {
                Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                Cursor query = contentResolver.query(uri, this.f51947f, null, null, "date_added DESC");
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            while (true) {
                                int i2 = query.getInt(query.getColumnIndex("_id"));
                                Uri withAppendedId = ContentUris.withAppendedId(uri, i2);
                                String uri2 = withAppendedId != null ? withAppendedId.toString() : null;
                                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                                String string2 = query.getString(query.getColumnIndexOrThrow("title"));
                                String string3 = query.getString(query.getColumnIndexOrThrow("_display_name"));
                                String string4 = query.getString(query.getColumnIndexOrThrow("mime_type"));
                                int i3 = query.getInt(query.getColumnIndexOrThrow("duration"));
                                long j = query.getLong(query.getColumnIndexOrThrow("date_modified"));
                                Uri uri3 = uri;
                                long j2 = query.getLong(query.getColumnIndexOrThrow("date_added"));
                                if (!hashSet.contains(string)) {
                                    hashSet.add(string);
                                    File file = new File(string);
                                    if (file.exists() && file.isFile() && d.a.c.e.p.f.w(file) > 0) {
                                        VideoFileInfo videoFileInfo = new VideoFileInfo();
                                        videoFileInfo.videoId = i2;
                                        videoFileInfo.contentUriStr = uri2;
                                        videoFileInfo.videoPath = string;
                                        videoFileInfo.displayName = string3;
                                        videoFileInfo.title = string2;
                                        videoFileInfo.mimeType = string4;
                                        videoFileInfo.videoDuration = i3;
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
                        d.a.c.e.m.a.a(cursor2);
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        d.a.c.e.m.a.a(cursor);
                        throw th;
                    }
                }
                d.a.c.e.m.a.a(query);
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

    public boolean h(int i2, e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, eVar)) == null) {
            if (eVar == null) {
                return false;
            }
            c();
            this.f51945d = i2;
            c cVar = new c(this, eVar);
            this.f51943b = cVar;
            cVar.setPriority(3);
            this.f51943b.execute(new Object[0]);
            return true;
        }
        return invokeIL.booleanValue;
    }
}
