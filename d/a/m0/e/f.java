package d.a.m0.e;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public c f49321b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f49322c;

    /* renamed from: a  reason: collision with root package name */
    public final String f49320a = TbConfig.getTempDirName();

    /* renamed from: d  reason: collision with root package name */
    public int f49323d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String[] f49324e = {"_id", "bucket_id", "bucket_display_name", "_data", "mime_type", "date_added", "_size", "date_modified"};

    /* renamed from: f  reason: collision with root package name */
    public String[] f49325f = {"_id", "_data", "title", "mime_type", "_display_name", "duration", "datetaken", "date_modified", "date_added"};

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, d.a.m0.e.a> f49326g = new HashMap<>();

    /* loaded from: classes3.dex */
    public class a implements Comparator<MediaFileInfo> {
        public a(f fVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(MediaFileInfo mediaFileInfo, MediaFileInfo mediaFileInfo2) {
            int i2 = ((mediaFileInfo2.getSortTime() - mediaFileInfo.getSortTime()) > 0L ? 1 : ((mediaFileInfo2.getSortTime() - mediaFileInfo.getSortTime()) == 0L ? 0 : -1));
            if (i2 == 0) {
                return 0;
            }
            return i2 > 0 ? 1 : -1;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Comparator<d.a.m0.e.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d.a.m0.e.a aVar, d.a.m0.e.a aVar2) {
            if (f.this.f49320a.equals(aVar.g())) {
                return -1;
            }
            if (f.this.f49320a.equals(aVar2.g())) {
                return 1;
            }
            int i2 = ((aVar2.e().getSortTime() - aVar.e().getSortTime()) > 0L ? 1 : ((aVar2.e().getSortTime() - aVar.e().getSortTime()) == 0L ? 0 : -1));
            if (i2 == 0) {
                return 0;
            }
            return i2 > 0 ? 1 : -1;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Object, Integer, g> {

        /* renamed from: a  reason: collision with root package name */
        public final e f49328a;

        public c(e eVar) {
            this.f49328a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public g doInBackground(Object... objArr) {
            return f.this.d();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            e eVar = this.f49328a;
            if (eVar != null) {
                eVar.a(gVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            e eVar = this.f49328a;
            if (eVar != null) {
                eVar.onPreLoad();
            }
        }
    }

    public f(Context context) {
        this.f49322c = context;
    }

    public void c() {
        c cVar = this.f49321b;
        if (cVar != null) {
            cVar.cancel();
            this.f49321b = null;
        }
    }

    public final g d() {
        this.f49326g.clear();
        g gVar = new g();
        List<ImageFileInfo> e2 = e();
        List<VideoFileInfo> g2 = this.f49323d != 2 ? g() : null;
        ArrayList arrayList = new ArrayList();
        if (!ListUtils.isEmpty(e2)) {
            arrayList.addAll(e2);
        }
        if (!ListUtils.isEmpty(g2)) {
            arrayList.addAll(g2);
        }
        if (!ListUtils.isEmpty(arrayList)) {
            Collections.sort(arrayList, new a(this));
        }
        ArrayList arrayList2 = new ArrayList(this.f49326g.values());
        if (!ListUtils.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new b());
        }
        gVar.f49330a = arrayList2;
        gVar.f49332c = g2;
        gVar.f49331b = arrayList;
        return gVar;
    }

    public List<ImageFileInfo> e() {
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

    public final List<ImageFileInfo> f(Uri uri) {
        Cursor cursor;
        String str = null;
        if (this.f49322c == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Cursor query = this.f49322c.getContentResolver().query(uri, this.f49324e, "mime_type like 'image/%'", null, "date_added DESC");
            if (query != null) {
                try {
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
                                ArrayList arrayList2 = arrayList;
                                if (!endsWith || i2 <= 3145728) {
                                    try {
                                        ImageFileInfo imageFileInfo = new ImageFileInfo();
                                        imageFileInfo.setAlbumnId(string);
                                        imageFileInfo.setContentUriStr(uri2);
                                        imageFileInfo.setFilePath(string3);
                                        imageFileInfo.setIsGif(endsWith);
                                        imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(j2));
                                        imageFileInfo.setSortTime(j);
                                        arrayList = arrayList2;
                                        arrayList.add(imageFileInfo);
                                        d.a.m0.e.a aVar = this.f49326g.get(string);
                                        if (aVar == null) {
                                            aVar = new d.a.m0.e.a();
                                            this.f49326g.put(string, aVar);
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
                                    } catch (Exception e2) {
                                        e = e2;
                                        arrayList = arrayList2;
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
                                    }
                                } else {
                                    arrayList = arrayList2;
                                }
                                if (!query.moveToNext()) {
                                    break;
                                }
                                str = null;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        d.a.c.e.m.a.a(cursor);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            d.a.c.e.m.a.a(query);
        } catch (Exception e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        return arrayList;
    }

    public final List<VideoFileInfo> g() {
        Cursor cursor;
        Cursor cursor2;
        ArrayList arrayList = new ArrayList();
        Context context = this.f49322c;
        if (context == null) {
            return arrayList;
        }
        ContentResolver contentResolver = context.getContentResolver();
        HashSet hashSet = new HashSet();
        try {
            Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            Cursor query = contentResolver.query(uri, this.f49325f, null, null, "date_added DESC");
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

    public boolean h(int i2, e eVar) {
        if (eVar == null) {
            return false;
        }
        c();
        this.f49323d = i2;
        c cVar = new c(eVar);
        this.f49321b = cVar;
        cVar.setPriority(3);
        this.f49321b.execute(new Object[0]);
        return true;
    }
}
