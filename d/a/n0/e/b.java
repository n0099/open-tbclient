package d.a.n0.e;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f53087a = TbConfig.getTempDirName();

    /* renamed from: b  reason: collision with root package name */
    public a f53088b;

    /* renamed from: c  reason: collision with root package name */
    public c f53089c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f53090d;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, List<d.a.n0.e.a>> {

        /* renamed from: a  reason: collision with root package name */
        public final d.a.n0.e.c f53091a;

        public a(d.a.n0.e.c cVar) {
            this.f53091a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<d.a.n0.e.a> doInBackground(Object... objArr) {
            return b.this.f();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<d.a.n0.e.a> list) {
            super.onPostExecute(list);
            d.a.n0.e.c cVar = this.f53091a;
            if (cVar != null) {
                cVar.a(list);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            d.a.n0.e.c cVar = this.f53091a;
            if (cVar != null) {
                cVar.onPreLoad();
            }
        }
    }

    /* renamed from: d.a.n0.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1179b {
        void a(List<ImageFileInfo> list);
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, List<ImageFileInfo>, List<ImageFileInfo>> {

        /* renamed from: a  reason: collision with root package name */
        public final d f53093a;

        /* renamed from: b  reason: collision with root package name */
        public final String f53094b;

        /* renamed from: c  reason: collision with root package name */
        public String f53095c;

        /* renamed from: d  reason: collision with root package name */
        public List<d.a.n0.e.a> f53096d;

        /* renamed from: e  reason: collision with root package name */
        public int f53097e = 1;

        /* renamed from: f  reason: collision with root package name */
        public InterfaceC1179b f53098f = new a();

        /* loaded from: classes3.dex */
        public class a implements InterfaceC1179b {
            public a() {
            }

            @Override // d.a.n0.e.b.InterfaceC1179b
            public void a(List<ImageFileInfo> list) {
                c.this.publishProgress(list);
            }
        }

        public c(String str, d dVar) {
            this.f53093a = dVar;
            this.f53094b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public List<ImageFileInfo> doInBackground(Void... voidArr) {
            if (TextUtils.isEmpty(this.f53094b)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (this.f53094b.equals(d.a.n0.e.a.f53080f)) {
                List<d.a.n0.e.a> f2 = b.this.f();
                this.f53096d = f2;
                if (f2 != null) {
                    for (d.a.n0.e.a aVar : f2) {
                        String b2 = aVar.b();
                        if (!TextUtils.isEmpty(b2)) {
                            e(arrayList, this.f53098f, b2);
                        }
                    }
                }
                return arrayList;
            }
            e(arrayList, this.f53098f, this.f53094b);
            return arrayList;
        }

        public final void d(List<ImageFileInfo> list, InterfaceC1179b interfaceC1179b, String str, Context context, Uri uri) {
            boolean z;
            boolean z2;
            if (list == null) {
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
                                this.f53095c = query.getString(columnIndex2);
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
                                        f(list, interfaceC1179b);
                                    } else {
                                        z = false;
                                    }
                                    z2 = false;
                                    imageFileInfo.setIsGif(z);
                                    imageFileInfo.setIsLong(z2);
                                    imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(file.lastModified()));
                                    list.add(imageFileInfo);
                                    f(list, interfaceC1179b);
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

        public final void e(List<ImageFileInfo> list, InterfaceC1179b interfaceC1179b, String str) {
            if (list == null) {
                return;
            }
            d(list, interfaceC1179b, str, b.this.f53090d, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (list == null || list.size() <= 0) {
                d(list, interfaceC1179b, str, b.this.f53090d, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            }
        }

        public final void f(List<ImageFileInfo> list, InterfaceC1179b interfaceC1179b) {
            if (list == null || interfaceC1179b == null) {
                return;
            }
            int i2 = this.f53097e;
            if (i2 != 1 && i2 != 2) {
                if (list.size() / this.f53097e > 500) {
                    if (interfaceC1179b != null) {
                        interfaceC1179b.a(list);
                    }
                    this.f53097e++;
                }
            } else if (list.size() / this.f53097e > 50) {
                if (interfaceC1179b != null) {
                    interfaceC1179b.a(list);
                }
                this.f53097e++;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public void onPostExecute(List<ImageFileInfo> list) {
            super.onPostExecute(list);
            d dVar = this.f53093a;
            if (dVar != null) {
                dVar.a(this.f53096d, list, this.f53095c);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public void onProgressUpdate(List<ImageFileInfo>... listArr) {
            d dVar;
            super.onProgressUpdate(listArr);
            if (listArr.length <= 0 || (dVar = this.f53093a) == null) {
                return;
            }
            dVar.a(this.f53096d, listArr[0], this.f53095c);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            d dVar = this.f53093a;
            if (dVar != null) {
                dVar.onPreLoad();
            }
        }
    }

    public b(Context context) {
        this.f53090d = context;
    }

    public void c() {
        a aVar = this.f53088b;
        if (aVar != null) {
            aVar.cancel();
            this.f53088b = null;
        }
    }

    public void d() {
        c cVar = this.f53089c;
        if (cVar != null) {
            cVar.cancel();
            this.f53089c = null;
        }
    }

    public final List<d.a.n0.e.a> e(Context context, List<d.a.n0.e.a> list, Uri uri, HashSet<String> hashSet) {
        int i2;
        File[] listFiles;
        Matcher matcher;
        Cursor cursor = null;
        if (context == null) {
            return null;
        }
        Pattern compile = Pattern.compile("image\\/\\w+", 2);
        List<d.a.n0.e.a> arrayList = list == null ? new ArrayList<>() : list;
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
                            d.a.n0.e.a aVar = new d.a.n0.e.a();
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
                            if (string2 != null && string2.equals(this.f53087a)) {
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

    public final List<d.a.n0.e.a> f() {
        HashSet<String> hashSet = new HashSet<>();
        return e(this.f53090d, e(this.f53090d, null, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, hashSet), MediaStore.Images.Media.INTERNAL_CONTENT_URI, hashSet);
    }

    public boolean g(d.a.n0.e.c cVar) {
        if (cVar == null) {
            return false;
        }
        c();
        a aVar = new a(cVar);
        this.f53088b = aVar;
        aVar.setPriority(3);
        this.f53088b.execute(new Object[0]);
        return true;
    }

    public final String h(String str) {
        int lastIndexOf;
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

    public boolean i(String str, d dVar) {
        if (dVar == null) {
            return false;
        }
        d();
        c cVar = new c(str, dVar);
        this.f53089c = cVar;
        cVar.setPriority(3);
        this.f53089c.execute(new Void[0]);
        return true;
    }

    public String j(String str) {
        String h2 = h(str);
        if (h2 != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(h2.toLowerCase(Locale.getDefault()));
        }
        return null;
    }
}
