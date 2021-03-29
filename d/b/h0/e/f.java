package d.b.h0.e;

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
    public c f50142b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f50143c;

    /* renamed from: a  reason: collision with root package name */
    public final String f50141a = TbConfig.getTempDirName();

    /* renamed from: d  reason: collision with root package name */
    public int f50144d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String[] f50145e = {"_id", "bucket_id", "bucket_display_name", "_data", "mime_type", "date_added", "_size", "date_modified"};

    /* renamed from: f  reason: collision with root package name */
    public String[] f50146f = {"_id", "_data", "title", "mime_type", "_display_name", "duration", "datetaken", "date_modified", "date_added"};

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, d.b.h0.e.a> f50147g = new HashMap<>();

    /* loaded from: classes3.dex */
    public class a implements Comparator<MediaFileInfo> {
        public a(f fVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(MediaFileInfo mediaFileInfo, MediaFileInfo mediaFileInfo2) {
            int i = ((mediaFileInfo2.getSortTime() - mediaFileInfo.getSortTime()) > 0L ? 1 : ((mediaFileInfo2.getSortTime() - mediaFileInfo.getSortTime()) == 0L ? 0 : -1));
            if (i == 0) {
                return 0;
            }
            return i > 0 ? 1 : -1;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Comparator<d.b.h0.e.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d.b.h0.e.a aVar, d.b.h0.e.a aVar2) {
            if (f.this.f50141a.equals(aVar.g())) {
                return -1;
            }
            if (f.this.f50141a.equals(aVar2.g())) {
                return 1;
            }
            int i = ((aVar2.e().getSortTime() - aVar.e().getSortTime()) > 0L ? 1 : ((aVar2.e().getSortTime() - aVar.e().getSortTime()) == 0L ? 0 : -1));
            if (i == 0) {
                return 0;
            }
            return i > 0 ? 1 : -1;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Object, Integer, g> {

        /* renamed from: a  reason: collision with root package name */
        public final e f50149a;

        public c(e eVar) {
            this.f50149a = eVar;
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
            e eVar = this.f50149a;
            if (eVar != null) {
                eVar.a(gVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            e eVar = this.f50149a;
            if (eVar != null) {
                eVar.onPreLoad();
            }
        }
    }

    public f(Context context) {
        this.f50143c = context;
    }

    public void c() {
        c cVar = this.f50142b;
        if (cVar != null) {
            cVar.cancel();
            this.f50142b = null;
        }
    }

    public final g d() {
        this.f50147g.clear();
        g gVar = new g();
        List<ImageFileInfo> e2 = e();
        List<VideoFileInfo> g2 = this.f50144d != 2 ? g() : null;
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
        ArrayList arrayList2 = new ArrayList(this.f50147g.values());
        if (!ListUtils.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new b());
        }
        gVar.f50151a = arrayList2;
        gVar.f50153c = g2;
        gVar.f50152b = arrayList;
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
        if (this.f50143c == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Cursor query = this.f50143c.getContentResolver().query(uri, this.f50145e, "mime_type like 'image/%'", null, "date_added DESC");
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
                                int i = query.getInt(query.getColumnIndex("_size"));
                                long j2 = query.getLong(query.getColumnIndex("date_modified"));
                                boolean endsWith = string4.endsWith("gif");
                                ArrayList arrayList2 = arrayList;
                                if (!endsWith || i <= 3145728) {
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
                                        d.b.h0.e.a aVar = this.f50147g.get(string);
                                        if (aVar == null) {
                                            aVar = new d.b.h0.e.a();
                                            this.f50147g.put(string, aVar);
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
                                            d.b.b.e.m.a.a(cursor);
                                            return arrayList;
                                        } catch (Throwable th) {
                                            th = th;
                                            d.b.b.e.m.a.a(cursor);
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
                        d.b.b.e.m.a.a(cursor);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            d.b.b.e.m.a.a(query);
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
        Context context = this.f50143c;
        if (context == null) {
            return arrayList;
        }
        ContentResolver contentResolver = context.getContentResolver();
        HashSet hashSet = new HashSet();
        try {
            Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            Cursor query = contentResolver.query(uri, this.f50146f, null, null, "date_added DESC");
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
                            if (!hashSet.contains(string)) {
                                hashSet.add(string);
                                File file = new File(string);
                                if (file.exists() && file.isFile() && d.b.b.e.p.f.w(file) > 0) {
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
                    d.b.b.e.m.a.a(cursor2);
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    d.b.b.e.m.a.a(cursor);
                    throw th;
                }
            }
            d.b.b.e.m.a.a(query);
        } catch (Exception unused2) {
            cursor2 = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return arrayList;
    }

    public boolean h(int i, e eVar) {
        if (eVar == null) {
            return false;
        }
        c();
        this.f50144d = i;
        c cVar = new c(eVar);
        this.f50142b = cVar;
        cVar.setPriority(3);
        this.f50142b.execute(new Object[0]);
        return true;
    }
}
