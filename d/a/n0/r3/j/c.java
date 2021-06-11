package d.a.n0.r3.j;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.provider.MediaStore;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.down.statistic.ConfigSpeedStat;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* loaded from: classes5.dex */
    public static final class a implements Comparator<b> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            int i2 = bVar.b() < bVar2.b() ? 1 : 0;
            if (bVar.b() > bVar2.b()) {
                return -1;
            }
            return i2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00cf, code lost:
        if (r2 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00d1, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e8, code lost:
        if (r2 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00eb, code lost:
        r15.moveToNext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f2, code lost:
        if (r8.d() == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00fc, code lost:
        if (r8.a() == 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0106, code lost:
        if (c(r8.c()) == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0110, code lost:
        if (r8.a() < 1000) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0112, code lost:
        r0 = r8.d();
        r2 = r0.substring(r9, r0.lastIndexOf("/"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0126, code lost:
        if (r0.contains("/DCIM/") != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0128, code lost:
        if (r2 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x012e, code lost:
        if (r2.equals("/sdcard") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x013a, code lost:
        if (new java.io.File(r0).exists() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x013c, code lost:
        r1.add(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x013f, code lost:
        r5 = r21 + 1;
        r7 = r17;
        r9 = r18;
        r8 = r22;
        r6 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<b> a(Context context) {
        Cursor cursor;
        Cursor cursor2;
        int i2;
        ContentResolver contentResolver;
        String str;
        int i3;
        b bVar;
        Cursor cursor3;
        ContentResolver contentResolver2;
        String string;
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver3 = context.getContentResolver();
        String str2 = "_id";
        try {
            Cursor query = contentResolver3.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "duration", "mime_type", "date_modified"}, null, null, "title");
            try {
                String[] strArr = {"video_id", "_data"};
                query.moveToFirst();
                int count = query.getCount();
                int i4 = 0;
                int i5 = 0;
                while (i5 < count) {
                    b bVar2 = new b();
                    String string2 = query.getString(query.getColumnIndex(str2));
                    bVar2.i(string2);
                    String string3 = query.getString(query.getColumnIndex("_data"));
                    if (string3 != null) {
                        bVar2.j(string3.replace("/storage/emulated/0", "/sdcard"));
                    }
                    int i6 = count;
                    bVar2.e(d.a.c.e.m.b.d(query.getString(query.getColumnIndex("duration")), i4));
                    bVar2.g(query.getString(query.getColumnIndex("mime_type")));
                    bVar2.f(Long.parseLong(query.getString(query.getColumnIndex("date_modified"))));
                    try {
                        try {
                            contentResolver2 = contentResolver3;
                            i2 = i5;
                            contentResolver = contentResolver3;
                            str = str2;
                            i3 = 0;
                            bVar = bVar2;
                        } catch (Exception e2) {
                            e = e2;
                            i2 = i5;
                            contentResolver = contentResolver3;
                            str = str2;
                            i3 = 0;
                            bVar = bVar2;
                        }
                        try {
                            cursor3 = contentResolver2.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, strArr, "video_id=" + string2, null, null);
                            if (cursor3 != null) {
                                try {
                                    try {
                                        if (cursor3.moveToFirst() && (string = cursor3.getString(cursor3.getColumnIndex("_data"))) != null) {
                                            bVar.h(string.replace("/storage/emulated/0", "/sdcard"));
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        e.printStackTrace();
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    cursor2 = cursor3;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            cursor3 = null;
                            e.printStackTrace();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = null;
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e5) {
                e = e5;
                cursor = query;
                try {
                    e.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Throwable th3) {
                    th = th3;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                cursor = query;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
        } catch (Throwable th5) {
            th = th5;
            cursor = null;
        }
        return arrayList;
    }

    public static b b(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            b bVar = new b();
            bVar.j(str);
            bVar.f(file.lastModified());
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    try {
                        mediaMetadataRetriever.setDataSource(str);
                        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                        if (extractMetadata != null) {
                            bVar.e(Integer.parseInt(extractMetadata));
                        }
                        bVar.g(mediaMetadataRetriever.extractMetadata(12));
                        mediaMetadataRetriever.release();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    mediaMetadataRetriever.release();
                }
                return bVar;
            } catch (Throwable th) {
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
        return null;
    }

    public static boolean c(String str) {
        return "video/mp4".equals(str) || "video/ext-mp4".equals(str);
    }

    public static void d(String str, List<b> list, boolean z) {
        File[] listFiles;
        b b2;
        if (list == null || StringUtils.isNull(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length == 0) {
            return;
        }
        for (File file : listFiles) {
            if (file != null && !StringUtils.isNull(file.getPath())) {
                String path = file.getPath();
                if (file.isFile()) {
                    if (path.contains("_tiebaconverting.mp4")) {
                        if (file.exists()) {
                            file.delete();
                        }
                    } else if (path.contains(".mp4") && ".mp4".equals(path.substring(path.lastIndexOf(".mp4"))) && (b2 = b(file.getPath())) != null && file.length() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT && b2.a() >= 1000 && c(b2.c())) {
                        list.add(b2);
                    }
                } else if (file.isDirectory() && !path.contains("/.") && z) {
                    d(path, list, z);
                }
            }
        }
    }

    public static void e(List<b> list) {
        Collections.sort(list, new a());
    }
}
