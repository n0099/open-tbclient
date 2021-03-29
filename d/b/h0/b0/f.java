package d.b.h0.b0;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import d.b.b.e.p.q;
import d.b.h0.r.k;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public int f49793b;

    /* renamed from: c  reason: collision with root package name */
    public int f49794c;

    /* renamed from: d  reason: collision with root package name */
    public int f49795d;

    /* renamed from: e  reason: collision with root package name */
    public int f49796e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49797f;
    public a i;
    public b j;
    public Object k;
    public e l;
    public boolean m;
    public int n;

    /* renamed from: a  reason: collision with root package name */
    public int f49792a = 512000;

    /* renamed from: g  reason: collision with root package name */
    public String f49798g = "1";

    /* renamed from: h  reason: collision with root package name */
    public NetWork f49799h = null;

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, Object obj, long j, long j2);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str, Object obj, long j, long j2, int i, int i2);
    }

    public f(String str) {
    }

    public void a() {
        this.f49797f = true;
        NetWork netWork = this.f49799h;
        if (netWork != null) {
            netWork.cancelNetConnect();
        }
    }

    public void b(String str) {
        this.f49798g = str;
    }

    public void c(a aVar, Object obj) {
        this.i = aVar;
        this.k = obj;
        if (aVar != null) {
            this.f49792a = 10240;
        }
    }

    public void d(b bVar, Object obj) {
        this.j = bVar;
        this.k = obj;
    }

    public void e(int i, int i2, int i3, int i4) {
        this.f49793b = i;
        this.f49794c = i2;
        this.f49795d = i3;
        this.f49796e = i4;
    }

    public void f(int i) {
        this.n = i;
    }

    public ImageUploadResult g(ImageFileInfo imageFileInfo, boolean z) {
        return h(imageFileInfo, false, z);
    }

    public ImageUploadResult h(ImageFileInfo imageFileInfo, boolean z, boolean z2) {
        return i(imageFileInfo, z, z2, 1, 1);
    }

    public final ImageUploadResult i(ImageFileInfo imageFileInfo, boolean z, boolean z2, int i, int i2) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.l == null) {
            this.l = new e();
        }
        return l(this.l.j(imageFileInfo, z), z, z2, i, i2);
    }

    public ImageUploadResult j(String str, boolean z) {
        return k(str, false, z);
    }

    public ImageUploadResult k(String str, boolean z, boolean z2) {
        return l(str, z, z2, 1, 1);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:46|(17:50|51|(1:53)(1:249)|54|55|56|57|(2:58|(16:60|61|62|(1:235)(25:(1:65)(5:(1:224)(1:(1:233)(3:234|(1:231)(1:229)|230))|225|(1:227)|231|230)|66|67|(2:219|220)(1:69)|70|71|(2:73|74)(1:218)|75|(1:79)|80|(1:84)|85|(1:87)|88|(1:90)(1:217)|91|92|(1:94)|(6:96|(1:98)|99|(1:103)|104|(7:106|(2:108|109)|113|114|(1:116)|117|(8:120|121|(3:193|194|(1:196))|123|(2:125|(2:129|130)(0))(10:152|(3:154|155|156)(1:192)|157|158|159|(5:175|176|177|178|179)(1:161)|162|163|(3:165|166|167)(1:169)|168)|131|132|(2:135|136)(1:134))(2:211|210)))|216|113|114|(0)|117|(1:211)(8:120|121|(0)|123|(0)(0)|131|132|(0)(0)))|221|222|22|23|24|(1:26)(1:42)|(1:28)(1:41)|(1:30)(1:40)|31|32|33|34)(1:242))|197|(1:199)(1:203)|200|(1:202)(0)|137|138|139|33|34)|250|251|252|253|254|255|139|33|34) */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0348, code lost:
        r15.append("|startChunk=");
        r15.append(r4);
        d.b.i0.c3.q0.b.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = pic = null    p = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0362, code lost:
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0365, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0366, code lost:
        r3 = r0;
        r27 = r12;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x04a2, code lost:
        r28 = r6;
        r2 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x04fe, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x04ff, code lost:
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0501, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x050e, code lost:
        r3 = r0;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0510, code lost:
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0161, code lost:
        r15.append("|startChunk=");
        r15.append(r14);
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02d7 A[Catch: Exception -> 0x02df, all -> 0x0591, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x02df, blocks: (B:111:0x02c0, B:116:0x02d7), top: B:246:0x02c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x030e A[Catch: Exception -> 0x0301, all -> 0x0591, TRY_ENTER, TryCatch #15 {all -> 0x0591, blocks: (B:221:0x0511, B:223:0x0515, B:226:0x0524, B:229:0x052b, B:231:0x0532, B:230:0x052e, B:224:0x051b, B:46:0x0161, B:67:0x01ce, B:73:0x01e9, B:78:0x0203, B:80:0x0207, B:83:0x0225, B:85:0x0229, B:88:0x025b, B:91:0x0266, B:97:0x027b, B:99:0x0288, B:101:0x0292, B:102:0x029b, B:106:0x02a8, B:107:0x02af, B:111:0x02c0, B:116:0x02d7, B:125:0x02f9, B:132:0x030e, B:134:0x0330, B:137:0x0335, B:139:0x0348, B:146:0x0378, B:52:0x017c, B:58:0x0199, B:55:0x0185), top: B:243:0x01ce }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0422 A[LOOP:0: B:41:0x0156->B:173:0x0422, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0515 A[Catch: all -> 0x0591, TryCatch #15 {all -> 0x0591, blocks: (B:221:0x0511, B:223:0x0515, B:226:0x0524, B:229:0x052b, B:231:0x0532, B:230:0x052e, B:224:0x051b, B:46:0x0161, B:67:0x01ce, B:73:0x01e9, B:78:0x0203, B:80:0x0207, B:83:0x0225, B:85:0x0229, B:88:0x025b, B:91:0x0266, B:97:0x027b, B:99:0x0288, B:101:0x0292, B:102:0x029b, B:106:0x02a8, B:107:0x02af, B:111:0x02c0, B:116:0x02d7, B:125:0x02f9, B:132:0x030e, B:134:0x0330, B:137:0x0335, B:139:0x0348, B:146:0x0378, B:52:0x017c, B:58:0x0199, B:55:0x0185), top: B:243:0x01ce }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x051b A[Catch: all -> 0x0591, TryCatch #15 {all -> 0x0591, blocks: (B:221:0x0511, B:223:0x0515, B:226:0x0524, B:229:0x052b, B:231:0x0532, B:230:0x052e, B:224:0x051b, B:46:0x0161, B:67:0x01ce, B:73:0x01e9, B:78:0x0203, B:80:0x0207, B:83:0x0225, B:85:0x0229, B:88:0x025b, B:91:0x0266, B:97:0x027b, B:99:0x0288, B:101:0x0292, B:102:0x029b, B:106:0x02a8, B:107:0x02af, B:111:0x02c0, B:116:0x02d7, B:125:0x02f9, B:132:0x030e, B:134:0x0330, B:137:0x0335, B:139:0x0348, B:146:0x0378, B:52:0x017c, B:58:0x0199, B:55:0x0185), top: B:243:0x01ce }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0524 A[Catch: all -> 0x0591, TryCatch #15 {all -> 0x0591, blocks: (B:221:0x0511, B:223:0x0515, B:226:0x0524, B:229:0x052b, B:231:0x0532, B:230:0x052e, B:224:0x051b, B:46:0x0161, B:67:0x01ce, B:73:0x01e9, B:78:0x0203, B:80:0x0207, B:83:0x0225, B:85:0x0229, B:88:0x025b, B:91:0x0266, B:97:0x027b, B:99:0x0288, B:101:0x0292, B:102:0x029b, B:106:0x02a8, B:107:0x02af, B:111:0x02c0, B:116:0x02d7, B:125:0x02f9, B:132:0x030e, B:134:0x0330, B:137:0x0335, B:139:0x0348, B:146:0x0378, B:52:0x017c, B:58:0x0199, B:55:0x0185), top: B:243:0x01ce }] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x052b A[Catch: all -> 0x0591, TryCatch #15 {all -> 0x0591, blocks: (B:221:0x0511, B:223:0x0515, B:226:0x0524, B:229:0x052b, B:231:0x0532, B:230:0x052e, B:224:0x051b, B:46:0x0161, B:67:0x01ce, B:73:0x01e9, B:78:0x0203, B:80:0x0207, B:83:0x0225, B:85:0x0229, B:88:0x025b, B:91:0x0266, B:97:0x027b, B:99:0x0288, B:101:0x0292, B:102:0x029b, B:106:0x02a8, B:107:0x02af, B:111:0x02c0, B:116:0x02d7, B:125:0x02f9, B:132:0x030e, B:134:0x0330, B:137:0x0335, B:139:0x0348, B:146:0x0378, B:52:0x017c, B:58:0x0199, B:55:0x0185), top: B:243:0x01ce }] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x052e A[Catch: all -> 0x0591, TryCatch #15 {all -> 0x0591, blocks: (B:221:0x0511, B:223:0x0515, B:226:0x0524, B:229:0x052b, B:231:0x0532, B:230:0x052e, B:224:0x051b, B:46:0x0161, B:67:0x01ce, B:73:0x01e9, B:78:0x0203, B:80:0x0207, B:83:0x0225, B:85:0x0229, B:88:0x025b, B:91:0x0266, B:97:0x027b, B:99:0x0288, B:101:0x0292, B:102:0x029b, B:106:0x02a8, B:107:0x02af, B:111:0x02c0, B:116:0x02d7, B:125:0x02f9, B:132:0x030e, B:134:0x0330, B:137:0x0335, B:139:0x0348, B:146:0x0378, B:52:0x017c, B:58:0x0199, B:55:0x0185), top: B:243:0x01ce }] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x02f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0410 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult l(String str, boolean z, boolean z2, int i, int i2) {
        String str2;
        int i3;
        char c2;
        Throwable th;
        RandomAccessFile randomAccessFile;
        Exception exc;
        ImageUploadResult imageUploadResult;
        Throwable th2;
        String str3;
        File file;
        long length;
        long j;
        byte[] bArr;
        ImageUploadResult imageUploadResult2;
        int i4;
        int i5;
        RandomAccessFile randomAccessFile2;
        int i6;
        byte[] bArr2;
        int i7;
        byte[] bArr3;
        long j2;
        String a2;
        String postMultiNetData;
        ImageUploadResult parser;
        ImageUploadResult imageUploadResult3;
        ImageUploadResult imageUploadResult4;
        long j3;
        String str4;
        int i8;
        long j4;
        byte[] bArr4;
        long j5;
        int i9;
        int i10;
        String str5 = str;
        String str6 = "    p = ";
        d.b.i0.c3.q0.b.a("发帖：正在上传图片 = " + str5);
        BitmapFactory.Options options = new BitmapFactory.Options();
        boolean z3 = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str5, options);
        RandomAccessFile randomAccessFile3 = null;
        if (options.outWidth != 0 && options.outHeight != 0) {
            StringBuilder sb = new StringBuilder();
            try {
                try {
                    file = new File(str5);
                    length = file.length();
                    try {
                        try {
                        } catch (Exception e2) {
                            exc = e2;
                            str2 = "    p = ";
                            imageUploadResult = null;
                            randomAccessFile = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFile = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    randomAccessFile = null;
                }
            } catch (Exception e3) {
                e = e3;
                str2 = "    p = ";
                i3 = 2;
                c2 = 0;
            }
            if ((!z && length > 5242880) || (z && length > Config.FULL_TRACE_LOG_LIMIT)) {
                imageUploadResult = new ImageUploadResult();
                try {
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_size_over);
                    d.b.i0.c3.q0.b.a("发帖：正在上传图片 失败 限制大小 = " + length + "    p = " + str5);
                    d.b.b.e.m.a.b(null);
                    this.f49799h = null;
                    return imageUploadResult;
                } catch (Exception e4) {
                    exc = e4;
                    str2 = "    p = ";
                }
            } else {
                d.b.i0.c3.q0.b.a("发帖：正在上传图片 进行中 限制大小 = " + length + "    p = " + str5);
                String b2 = q.b(FileHelper.GetStreamFromFile(file));
                sb.append("path=");
                sb.append(str5);
                sb.append("|length=");
                sb.append(length);
                sb.append("|md5=");
                sb.append(b2);
                if (length != 0 && b2 != null) {
                    String str7 = b2 + this.f49792a;
                    long j6 = length % ((long) this.f49792a) == 0 ? length / this.f49792a : (length / this.f49792a) + 1;
                    sb.append("|chunkNo=");
                    sb.append(j6);
                    randomAccessFile = new RandomAccessFile(str5, r.f7664a);
                    try {
                        try {
                            sb.append("|width=");
                            sb.append(this.f49793b);
                            sb.append("|height=");
                            sb.append(this.f49794c);
                            sb.append("|smallWidth=");
                            sb.append(this.f49795d);
                            sb.append("|smallHeight=");
                            sb.append(this.f49796e);
                            sb.append("|groupId=");
                            sb.append(this.f49798g);
                            j = 0;
                            bArr = null;
                            imageUploadResult2 = null;
                            i4 = 1;
                            i5 = 0;
                        } catch (Exception e5) {
                            str2 = "    p = ";
                            i3 = 2;
                            c2 = 0;
                            exc = e5;
                            imageUploadResult = null;
                        }
                        while (true) {
                            int i11 = (i4 > j6 ? 1 : (i4 == j6 ? 0 : -1));
                            if (i11 > 0) {
                                break;
                            }
                            try {
                                if (this.f49797f == z3) {
                                    break;
                                }
                                if (i11 > 0) {
                                    j2 = length;
                                    i6 = i4;
                                    i7 = 0;
                                    bArr3 = null;
                                } else {
                                    if (i11 < 0) {
                                        i7 = this.f49792a;
                                        i6 = i4;
                                    } else if (i11 == 0) {
                                        i6 = i4;
                                        i7 = (int) (length - (this.f49792a * (j6 - 1)));
                                    } else {
                                        i6 = i4;
                                        bArr2 = bArr;
                                        i7 = 0;
                                        bArr3 = (bArr2 == null && bArr2.length == i7) ? bArr2 : new byte[i7];
                                        j2 = length;
                                        randomAccessFile.seek(this.f49792a * (i6 - 1));
                                        randomAccessFile.read(bArr3, 0, i7);
                                    }
                                    bArr2 = bArr;
                                    if (bArr2 == null) {
                                    }
                                    j2 = length;
                                    randomAccessFile.seek(this.f49792a * (i6 - 1));
                                    randomAccessFile.read(bArr3, 0, i7);
                                }
                                NetWork netWork = new NetWork(TbConfig.UPLOAD_IMG_URL);
                                this.f49799h = netWork;
                                netWork.addPostData("resourceId", str7);
                                this.f49799h.addPostData("chunkNo", String.valueOf(i6));
                                if (i11 >= 0) {
                                    try {
                                        try {
                                            this.f49799h.addPostData("isFinish", String.valueOf(1));
                                        } catch (Exception e6) {
                                            exc = e6;
                                            str2 = str6;
                                            imageUploadResult = imageUploadResult2;
                                        }
                                    } catch (Throwable th5) {
                                        th2 = th5;
                                        th = th2;
                                        d.b.b.e.m.a.b(randomAccessFile);
                                        this.f49799h = null;
                                        throw th;
                                    }
                                } else {
                                    this.f49799h.addPostData("isFinish", String.valueOf(0));
                                }
                                if (this.m) {
                                    this.f49799h.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(1));
                                } else {
                                    this.f49799h.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(0));
                                }
                                if (this.f49793b > 0 && this.f49794c > 0) {
                                    this.f49799h.addPostData("width", String.valueOf(this.f49793b));
                                    this.f49799h.addPostData("height", String.valueOf(this.f49794c));
                                }
                                if (this.f49795d > 0 && this.f49796e > 0) {
                                    this.f49799h.addPostData("smallWidth", String.valueOf(this.f49795d));
                                    this.f49799h.addPostData("smallHeight", String.valueOf(this.f49796e));
                                }
                                this.f49799h.addPostData(TbEnum.SystemMessage.KEY_GROUP_ID, String.valueOf(this.f49798g));
                                this.f49799h.addPostData("alt", "json");
                                if (bArr3 != null) {
                                    this.f49799h.addPostData("chunk", bArr3);
                                }
                                if (z) {
                                    this.f49799h.addPostData("saveOrigin", "1");
                                } else {
                                    this.f49799h.addPostData("saveOrigin", "0");
                                }
                                if (this.n != 0) {
                                    this.f49799h.addPostData("pic_water_type", String.valueOf(this.n));
                                }
                                try {
                                    if (z2) {
                                        int b3 = k.c().b();
                                        if (b3 != 0) {
                                            this.f49799h.addPostData("pic_water_type", String.valueOf(b3));
                                        }
                                        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                        if (!StringUtils.isNull(currentAccountName) && b3 == 1) {
                                            this.f49799h.addPostData("user_name", currentAccountName);
                                        }
                                        String a3 = k.c().a();
                                        if (!StringUtils.isNull(a3)) {
                                            i3 = 2;
                                            if (b3 == 2) {
                                                try {
                                                    this.f49799h.addPostData("forum_name", a3);
                                                } catch (Exception e7) {
                                                    exc = e7;
                                                    str2 = str6;
                                                    imageUploadResult = imageUploadResult2;
                                                }
                                            }
                                            a2 = k.c().a();
                                            if (!StringUtils.isNull(a2)) {
                                                this.f49799h.addPostData("small_flow_fname", a2);
                                            }
                                            postMultiNetData = this.f49799h.postMultiNetData();
                                            parser = ImageUploadResult.parser(postMultiNetData);
                                            if (postMultiNetData != null || parser == null) {
                                                break;
                                                break;
                                            }
                                            try {
                                                if (parser.error_code != 0) {
                                                    try {
                                                        if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                            break;
                                                        }
                                                    } catch (Exception e8) {
                                                        exc = e8;
                                                        imageUploadResult = parser;
                                                        str2 = str6;
                                                    }
                                                }
                                                if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                    d.b.i0.c3.q0.b.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = " + parser.error_code + str6 + str5);
                                                    int i12 = i6;
                                                    if (i12 != parser.chunkNo && parser.chunkNo > 0) {
                                                        i9 = parser.chunkNo;
                                                        str4 = str7;
                                                        randomAccessFile2 = randomAccessFile;
                                                        str2 = str6;
                                                        j4 = j2;
                                                        c2 = 0;
                                                        j5 = j6;
                                                        bArr4 = bArr3;
                                                        imageUploadResult3 = parser;
                                                    }
                                                } else {
                                                    int i13 = i6 + 1;
                                                    j += i7;
                                                    long j7 = i13 > 1 ? j + ((i13 - 1) * this.f49792a) : j;
                                                    StringBuilder sb2 = new StringBuilder();
                                                    try {
                                                        sb2.append("发帖：正在上传图片 已上传 = ");
                                                        sb2.append(j7);
                                                        sb2.append(str6);
                                                        sb2.append(str5);
                                                        d.b.i0.c3.q0.b.a(sb2.toString());
                                                        if (this.i != null) {
                                                            try {
                                                                j3 = j7;
                                                                str4 = str7;
                                                                randomAccessFile3 = randomAccessFile;
                                                                i8 = i13;
                                                                j4 = j2;
                                                                bArr4 = bArr3;
                                                                imageUploadResult3 = parser;
                                                                try {
                                                                    this.i.a(str, this.k, j3, j4);
                                                                } catch (Exception e9) {
                                                                    exc = e9;
                                                                    str2 = str6;
                                                                    imageUploadResult = imageUploadResult3;
                                                                }
                                                            } catch (Exception e10) {
                                                                exc = e10;
                                                                str2 = str6;
                                                                imageUploadResult = parser;
                                                            } catch (Throwable th6) {
                                                                th2 = th6;
                                                                th = th2;
                                                                d.b.b.e.m.a.b(randomAccessFile);
                                                                this.f49799h = null;
                                                                throw th;
                                                            }
                                                        } else {
                                                            j3 = j7;
                                                            str4 = str7;
                                                            randomAccessFile3 = randomAccessFile;
                                                            i8 = i13;
                                                            j4 = j2;
                                                            bArr4 = bArr3;
                                                            imageUploadResult3 = parser;
                                                        }
                                                    } catch (Exception e11) {
                                                        e = e11;
                                                        imageUploadResult4 = parser;
                                                        str2 = str6;
                                                        i3 = 2;
                                                        c2 = 0;
                                                        exc = e;
                                                        imageUploadResult = imageUploadResult4;
                                                        if (!this.f49797f) {
                                                        }
                                                        if (imageUploadResult == null) {
                                                        }
                                                        if (imageUploadResult == null) {
                                                        }
                                                        Object[] objArr = new Object[i3];
                                                        objArr[c2] = "comment";
                                                        objArr[1] = sb.toString();
                                                        d.b.h0.r.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr);
                                                        StringBuilder sb3 = new StringBuilder();
                                                        sb3.append("发帖：正在上传图片 上传失败 = ");
                                                        sb3.append(r4);
                                                        sb3.append(" ");
                                                        sb3.append(r3);
                                                        sb3.append(str2);
                                                        str3 = str;
                                                        sb3.append(str3);
                                                        d.b.i0.c3.q0.b.a(sb3.toString());
                                                        d.b.b.e.m.a.b(randomAccessFile);
                                                        this.f49799h = null;
                                                        d.b.i0.c3.q0.b.a("发帖：上传图片 结束      p = " + str3);
                                                        return imageUploadResult;
                                                    }
                                                    try {
                                                        if (this.j != null) {
                                                            long j8 = j3;
                                                            str2 = str6;
                                                            c2 = 0;
                                                            j5 = j6;
                                                            randomAccessFile2 = randomAccessFile3;
                                                            i3 = 2;
                                                            this.j.a(str, this.k, j8, j4, i, i2);
                                                        } else {
                                                            str2 = str6;
                                                            randomAccessFile2 = randomAccessFile3;
                                                            i3 = 2;
                                                            c2 = 0;
                                                            j5 = j6;
                                                        }
                                                        i9 = i8;
                                                    } catch (Exception e12) {
                                                        e = e12;
                                                        str2 = str6;
                                                        randomAccessFile2 = randomAccessFile3;
                                                        i3 = 2;
                                                        c2 = 0;
                                                        exc = e;
                                                        imageUploadResult = imageUploadResult3;
                                                        randomAccessFile = randomAccessFile2;
                                                        if (!this.f49797f) {
                                                        }
                                                        if (imageUploadResult == null) {
                                                        }
                                                        if (imageUploadResult == null) {
                                                        }
                                                        Object[] objArr2 = new Object[i3];
                                                        objArr2[c2] = "comment";
                                                        objArr2[1] = sb.toString();
                                                        d.b.h0.r.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr2);
                                                        StringBuilder sb32 = new StringBuilder();
                                                        sb32.append("发帖：正在上传图片 上传失败 = ");
                                                        sb32.append(r4);
                                                        sb32.append(" ");
                                                        sb32.append(r3);
                                                        sb32.append(str2);
                                                        str3 = str;
                                                        sb32.append(str3);
                                                        d.b.i0.c3.q0.b.a(sb32.toString());
                                                        d.b.b.e.m.a.b(randomAccessFile);
                                                        this.f49799h = null;
                                                        d.b.i0.c3.q0.b.a("发帖：上传图片 结束      p = " + str3);
                                                        return imageUploadResult;
                                                    } catch (Throwable th7) {
                                                        th = th7;
                                                        randomAccessFile2 = randomAccessFile3;
                                                        th = th;
                                                        randomAccessFile = randomAccessFile2;
                                                        d.b.b.e.m.a.b(randomAccessFile);
                                                        this.f49799h = null;
                                                        throw th;
                                                    }
                                                }
                                            } catch (Exception e13) {
                                                e = e13;
                                                imageUploadResult4 = parser;
                                                str2 = str6;
                                            }
                                            try {
                                                i10 = i5 + 1;
                                                if (i10 <= j5 * 2) {
                                                    sb.append("|possbile dead loop found. tryCount=");
                                                    sb.append(i10);
                                                    sb.append(", chunkNo=");
                                                    sb.append(j5);
                                                    break;
                                                }
                                                i4 = i9;
                                                i5 = i10;
                                                j6 = j5;
                                                imageUploadResult2 = imageUploadResult3;
                                                str7 = str4;
                                                length = j4;
                                                bArr = bArr4;
                                                str6 = str2;
                                                randomAccessFile = randomAccessFile2;
                                                z3 = true;
                                                str5 = str;
                                            } catch (Exception e14) {
                                                e = e14;
                                                exc = e;
                                                imageUploadResult = imageUploadResult3;
                                                randomAccessFile = randomAccessFile2;
                                                if (!this.f49797f) {
                                                }
                                                if (imageUploadResult == null) {
                                                }
                                                if (imageUploadResult == null) {
                                                }
                                                Object[] objArr22 = new Object[i3];
                                                objArr22[c2] = "comment";
                                                objArr22[1] = sb.toString();
                                                d.b.h0.r.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr22);
                                                StringBuilder sb322 = new StringBuilder();
                                                sb322.append("发帖：正在上传图片 上传失败 = ");
                                                sb322.append(r4);
                                                sb322.append(" ");
                                                sb322.append(r3);
                                                sb322.append(str2);
                                                str3 = str;
                                                sb322.append(str3);
                                                d.b.i0.c3.q0.b.a(sb322.toString());
                                                d.b.b.e.m.a.b(randomAccessFile);
                                                this.f49799h = null;
                                                d.b.i0.c3.q0.b.a("发帖：上传图片 结束      p = " + str3);
                                                return imageUploadResult;
                                            } catch (Throwable th8) {
                                                th = th8;
                                                th = th;
                                                randomAccessFile = randomAccessFile2;
                                                d.b.b.e.m.a.b(randomAccessFile);
                                                this.f49799h = null;
                                                throw th;
                                            }
                                        }
                                    }
                                    a2 = k.c().a();
                                    if (!StringUtils.isNull(a2)) {
                                    }
                                    postMultiNetData = this.f49799h.postMultiNetData();
                                    parser = ImageUploadResult.parser(postMultiNetData);
                                    if (postMultiNetData != null) {
                                        break;
                                    }
                                    if (parser.error_code != 0) {
                                    }
                                    if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                    }
                                    i10 = i5 + 1;
                                    if (i10 <= j5 * 2) {
                                    }
                                } catch (Exception e15) {
                                    e = e15;
                                    str2 = str6;
                                    c2 = 0;
                                    exc = e;
                                    imageUploadResult = imageUploadResult2;
                                    if (!this.f49797f) {
                                    }
                                    if (imageUploadResult == null) {
                                    }
                                    if (imageUploadResult == null) {
                                    }
                                    Object[] objArr222 = new Object[i3];
                                    objArr222[c2] = "comment";
                                    objArr222[1] = sb.toString();
                                    d.b.h0.r.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr222);
                                    StringBuilder sb3222 = new StringBuilder();
                                    sb3222.append("发帖：正在上传图片 上传失败 = ");
                                    sb3222.append(r4);
                                    sb3222.append(" ");
                                    sb3222.append(r3);
                                    sb3222.append(str2);
                                    str3 = str;
                                    sb3222.append(str3);
                                    d.b.i0.c3.q0.b.a(sb3222.toString());
                                    d.b.b.e.m.a.b(randomAccessFile);
                                    this.f49799h = null;
                                    d.b.i0.c3.q0.b.a("发帖：上传图片 结束      p = " + str3);
                                    return imageUploadResult;
                                }
                                i3 = 2;
                                exc = e6;
                                str2 = str6;
                                imageUploadResult = imageUploadResult2;
                            } catch (Exception e16) {
                                e = e16;
                                str2 = str6;
                                i3 = 2;
                            }
                            i3 = 2;
                            c2 = 0;
                            if (!this.f49797f) {
                                sb.append("|request cancelled.");
                            } else {
                                BdLog.e(exc.getMessage());
                            }
                            int i14 = imageUploadResult == null ? imageUploadResult.error_code : -1002;
                            String message = imageUploadResult == null ? imageUploadResult.error_msg : exc.getMessage();
                            Object[] objArr2222 = new Object[i3];
                            objArr2222[c2] = "comment";
                            objArr2222[1] = sb.toString();
                            d.b.h0.r.z.a.a("img", -1L, -1, "imageUpload", i14, message, objArr2222);
                            StringBuilder sb32222 = new StringBuilder();
                            sb32222.append("发帖：正在上传图片 上传失败 = ");
                            sb32222.append(i14);
                            sb32222.append(" ");
                            sb32222.append(message);
                            sb32222.append(str2);
                            str3 = str;
                            sb32222.append(str3);
                            d.b.i0.c3.q0.b.a(sb32222.toString());
                            d.b.b.e.m.a.b(randomAccessFile);
                            this.f49799h = null;
                            d.b.i0.c3.q0.b.a("发帖：上传图片 结束      p = " + str3);
                            return imageUploadResult;
                        }
                        randomAccessFile2 = randomAccessFile;
                        imageUploadResult3 = parser;
                        sb.append("|startChunk=");
                        sb.append(i6);
                        sb.append("|picNull=");
                        sb.append(imageUploadResult3 == null);
                        sb.append("|picErrNo=");
                        if (imageUploadResult3 != null) {
                            sb.append(imageUploadResult3.error_code);
                        }
                        imageUploadResult = imageUploadResult3;
                        randomAccessFile = randomAccessFile2;
                        d.b.b.e.m.a.b(randomAccessFile);
                        this.f49799h = null;
                        str3 = str;
                        d.b.i0.c3.q0.b.a("发帖：上传图片 结束      p = " + str3);
                        return imageUploadResult;
                    } catch (Throwable th9) {
                        th2 = th9;
                    }
                }
                str2 = "    p = ";
                i3 = 2;
                c2 = 0;
                imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_not_exist);
                TiebaStatic.imgError(-1007, "file error: " + imageUploadResult.error_msg, sb.toString());
                randomAccessFile = null;
                d.b.b.e.m.a.b(randomAccessFile);
                this.f49799h = null;
                str3 = str;
                d.b.i0.c3.q0.b.a("发帖：上传图片 结束      p = " + str3);
                return imageUploadResult;
            }
            randomAccessFile = randomAccessFile3;
            i3 = 2;
            c2 = 0;
            if (!this.f49797f) {
            }
            if (imageUploadResult == null) {
            }
            if (imageUploadResult == null) {
            }
            Object[] objArr22222 = new Object[i3];
            objArr22222[c2] = "comment";
            objArr22222[1] = sb.toString();
            d.b.h0.r.z.a.a("img", -1L, -1, "imageUpload", i14, message, objArr22222);
            StringBuilder sb322222 = new StringBuilder();
            sb322222.append("发帖：正在上传图片 上传失败 = ");
            sb322222.append(i14);
            sb322222.append(" ");
            sb322222.append(message);
            sb322222.append(str2);
            str3 = str;
            sb322222.append(str3);
            d.b.i0.c3.q0.b.a(sb322222.toString());
            d.b.b.e.m.a.b(randomAccessFile);
            this.f49799h = null;
            d.b.i0.c3.q0.b.a("发帖：上传图片 结束      p = " + str3);
            return imageUploadResult;
        }
        d.b.i0.c3.q0.b.a("发帖：正在上传图片 失败 = " + str5);
        return null;
    }

    public void m(WriteImagesInfo writeImagesInfo, boolean z) {
        UploadedImageInfo uploadedPicInfo;
        if (writeImagesInfo == null || writeImagesInfo.size() == 0) {
            return;
        }
        LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
        for (int i = 0; i < chosedFiles.size(); i++) {
            ImageFileInfo imageFileInfo = chosedFiles.get(i);
            if (imageFileInfo != null && !imageFileInfo.isAlreadyUploadedToServer()) {
                if (this.f49797f) {
                    return;
                }
                ImageUploadResult h2 = h(imageFileInfo, writeImagesInfo.isOriginalImg() || imageFileInfo.isGif(), z);
                if (h2 != null && (uploadedPicInfo = h2.getUploadedPicInfo()) != null) {
                    imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                    imageFileInfo.serverPicInfo = h2.picInfo;
                }
            }
        }
    }

    public ErrorData n(WriteImagesInfo writeImagesInfo, boolean z) {
        d.b.i0.c3.q0.b.a("发帖： 上传批量图片到server");
        ErrorData errorData = new ErrorData();
        if (writeImagesInfo != null && writeImagesInfo.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < chosedFiles.size(); i++) {
                ImageFileInfo imageFileInfo = chosedFiles.get(i);
                if (!imageFileInfo.isAlreadyUploadedToServer()) {
                    linkedList.add(imageFileInfo);
                }
            }
            int i2 = 0;
            while (i2 < linkedList.size()) {
                ImageFileInfo imageFileInfo2 = (ImageFileInfo) linkedList.get(i2);
                d.b.i0.c3.q0.b.a("发帖：发送图片 上传图片 = " + i2 + " = " + imageFileInfo2.toJson().toString());
                if (this.f49797f) {
                    break;
                }
                int i3 = i2 + 1;
                ImageUploadResult i4 = i(imageFileInfo2, imageFileInfo2.getImageType() == 1 ? false : writeImagesInfo.isOriginalImg(), z, i3, linkedList.size());
                if (i4 != null) {
                    UploadedImageInfo uploadedPicInfo = i4.getUploadedPicInfo();
                    if (uploadedPicInfo != null && !TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                        uploadedPicInfo.isGif = imageFileInfo2.isGif();
                        uploadedPicInfo.isBJH = this.m;
                        imageFileInfo2.setServerImageCode(uploadedPicInfo.toPostString());
                        i2 = i3;
                    } else {
                        errorData.setError_code(-53);
                        errorData.setError_msg(i4.error_msg);
                        d.b.i0.c3.q0.b.a("发帖：发送图片 上传图片 错误 1= " + i2 + " = " + imageFileInfo2.toJson().toString());
                        return errorData;
                    }
                } else {
                    errorData.setError_code(-53);
                    errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                    d.b.i0.c3.q0.b.a("发帖：发送图片 上传图片 错误 2= " + i2 + " = " + imageFileInfo2.toJson().toString());
                    return errorData;
                }
            }
            d.b.i0.c3.q0.b.a("发帖：发送图片 上传图片 成功返回");
            return null;
        }
        errorData.setError_code(-53);
        errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
        d.b.i0.c3.q0.b.a("发帖：发送图片 上传图片 错误 无图");
        return errorData;
    }
}
