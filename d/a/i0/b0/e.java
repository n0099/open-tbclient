package d.a.i0.b0;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import d.a.c.e.p.q;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: h  reason: collision with root package name */
    public static final String f48064h = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/dynamicimgtmp";

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.b0.b f48065a;

    /* renamed from: c  reason: collision with root package name */
    public ImageFileInfo f48067c;

    /* renamed from: e  reason: collision with root package name */
    public d f48069e;

    /* renamed from: f  reason: collision with root package name */
    public d f48070f;

    /* renamed from: g  reason: collision with root package name */
    public d f48071g;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48066b = false;

    /* renamed from: d  reason: collision with root package name */
    public d f48068d = new a();

    /* loaded from: classes3.dex */
    public class a implements d {
        public a() {
        }

        @Override // d.a.i0.b0.d
        public String a(ImageFileInfo imageFileInfo) {
            String n;
            if (imageFileInfo == null) {
                return null;
            }
            if (e.this.f48065a == null) {
                e.this.f48065a = new d.a.i0.b0.b();
            }
            String filePath = imageFileInfo.getFilePath();
            LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
            imageFileInfo.setPageActionsList(null);
            d.a.c.j.d.a c2 = e.this.f48065a.c(imageFileInfo, true);
            if (c2 == null) {
                Bitmap l = e.this.l(imageFileInfo);
                if (l == null) {
                    return null;
                }
                int readPictureDegree = BitmapHelper.readPictureDegree(filePath);
                if (readPictureDegree != 0) {
                    l = BitmapHelper.rotateBitmapBydegree(l, readPictureDegree);
                }
                n = e.this.n(l, 5242880L, 100);
            } else {
                n = e.this.n(c2.p(), 5242880L, 100);
            }
            imageFileInfo.setPageActionsList(pageActionsList);
            return n;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d {
        public b() {
        }

        @Override // d.a.i0.b0.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.g(imageFileInfo.getFilePath());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d {
        public c() {
        }

        @Override // d.a.i0.b0.d
        public String a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return e.this.n(e.this.i(imageFileInfo.getFilePath()), 5242880L, 100);
        }
    }

    public e() {
        b bVar = new b();
        this.f48069e = bVar;
        this.f48070f = bVar;
        this.f48071g = new c();
    }

    public static boolean k() {
        if (BdBaseApplication.getInst() == null) {
            return false;
        }
        return BdBaseApplication.getInst().isDebugMode();
    }

    public final String g(String str) {
        long fileSize = FileHelper.getFileSize(str);
        int i2 = fileSize >= 31457280 ? 80 : fileSize >= DownloadManager.MIN_LEFT_SIZE ? 85 : fileSize >= 15728640 ? 90 : fileSize >= Config.FULL_TRACE_LOG_LIMIT ? 95 : 100;
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree == 0 && i2 == 100) {
                return str;
            }
            Bitmap i3 = i(str);
            if (readPictureDegree != 0 && i3 != null) {
                return n(BitmapHelper.rotateBitmapBydegree(i3, readPictureDegree), Config.FULL_TRACE_LOG_LIMIT, i2);
            }
            return n(i3, Config.FULL_TRACE_LOG_LIMIT, i2);
        } catch (Throwable unused) {
            return str;
        }
    }

    public final String h(String str) {
        String substring;
        if (TextUtils.isEmpty(str)) {
            return ".jpg";
        }
        try {
            substring = str.substring(str.lastIndexOf("."));
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(substring) ? substring : ".jpg";
    }

    public final Bitmap i(String str) {
        BitmapFactory.Options m = m(str);
        int i2 = m.outWidth;
        int i3 = m.outHeight;
        if (i2 != 0 && i3 != 0) {
            Bitmap loadBitmap = BitmapHelper.loadBitmap(str);
            if (loadBitmap != null && !loadBitmap.isRecycled()) {
                return loadBitmap;
            }
            int i4 = 2;
            for (int i5 = 0; i5 < 3; i5++) {
                m.inSampleSize = i4;
                Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, m);
                if (loadBitmap2 != null && !loadBitmap2.isRecycled()) {
                    return loadBitmap2;
                }
                i4 *= 2;
            }
        }
        return null;
    }

    public String j(ImageFileInfo imageFileInfo, boolean z) {
        d dVar;
        String str;
        String str2;
        if (imageFileInfo == null) {
            return null;
        }
        this.f48067c = imageFileInfo;
        String filePath = imageFileInfo.getFilePath();
        boolean checkIsLongImage = FileHelper.checkIsLongImage(filePath);
        boolean checkIsHeifImage = FileHelper.checkIsHeifImage(filePath);
        if (imageFileInfo.isGif() || !(!z || imageFileInfo.hasActionsWithoutResize() || checkIsHeifImage)) {
            if (checkIsLongImage) {
                dVar = this.f48070f;
                str = "原始·长图";
            } else {
                dVar = this.f48069e;
                str = "原始·图";
            }
        } else if (checkIsLongImage) {
            dVar = this.f48071g;
            str = "正常·长图";
        } else {
            dVar = this.f48068d;
            str = "正常·图";
        }
        if (k()) {
            int[] imageFileWH = FileHelper.getImageFileWH(filePath);
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(filePath);
            sb.append("\n   w =");
            sb.append(imageFileWH[0]);
            sb.append(" h =");
            sb.append(imageFileWH[1]);
            sb.append("  size =");
            str2 = "\n   w =";
            sb.append(((float) FileHelper.getFileSize(filePath)) / 1048576.0f);
            sb.append("MB");
            sb.append("\n   isLongImage =");
            sb.append(checkIsLongImage);
            sb.append("  isHeifImage =");
            sb.append(checkIsHeifImage);
            sb.append(" resize =");
            sb.append(imageFileInfo.hasActionsWithoutResize());
            sb.append(" uploadStrategy =");
            sb.append(str);
            Log.d("UPLOAD_IMG", sb.toString());
        } else {
            str2 = "\n   w =";
        }
        String a2 = dVar.a(imageFileInfo);
        if (k()) {
            int[] imageFileWH2 = FileHelper.getImageFileWH(a2);
            Log.d("UPLOAD_IMG", "temp =" + a2 + str2 + imageFileWH2[0] + " h =" + imageFileWH2[1] + "  size =" + (((float) FileHelper.getFileSize(a2)) / 1048576.0f) + "MB");
        }
        return a2;
    }

    public final Bitmap l(ImageFileInfo imageFileInfo) {
        d.a.c.e.l.e i2;
        if (imageFileInfo == null) {
            return null;
        }
        if (this.f48065a == null) {
            this.f48065a = new d.a.i0.b0.b();
        }
        if (imageFileInfo.getImageType() == 0) {
            return this.f48065a.f(imageFileInfo, true);
        }
        if (imageFileInfo.getImageType() == 1 && (i2 = d.a.c.e.l.d.h().i(20)) != null) {
            try {
                Object fromLocal = i2.getFromLocal(imageFileInfo.getFilePath(), imageFileInfo.toCachedKey(false), 0, 0, null, null, imageFileInfo.getFilePath(), Boolean.FALSE, null);
                if (fromLocal instanceof d.a.c.j.d.a) {
                    return ((d.a.c.j.d.a) fromLocal).p();
                }
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
        return null;
    }

    public final BitmapFactory.Options m(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options;
    }

    public final String n(Bitmap bitmap, long j, int i2) {
        if (this.f48066b) {
            ImageFileInfo imageFileInfo = this.f48067c;
            if (imageFileInfo == null || TextUtils.isEmpty(imageFileInfo.getFilePath())) {
                return "";
            }
            return FileHelper.compressBitmapToFile(f48064h, q.c(this.f48067c.toCachedKey(false)) + h(this.f48067c.getFilePath()), bitmap, (float) j, i2);
        }
        return FileHelper.compressBitmapToFile("img_upload_temp_file.temp", bitmap, (float) j, i2);
    }
}
