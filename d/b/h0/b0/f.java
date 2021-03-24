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
    public int f49792b;

    /* renamed from: c  reason: collision with root package name */
    public int f49793c;

    /* renamed from: d  reason: collision with root package name */
    public int f49794d;

    /* renamed from: e  reason: collision with root package name */
    public int f49795e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49796f;
    public a i;
    public b j;
    public Object k;
    public e l;
    public boolean m;
    public int n;

    /* renamed from: a  reason: collision with root package name */
    public int f49791a = 512000;

    /* renamed from: g  reason: collision with root package name */
    public String f49797g = "1";

    /* renamed from: h  reason: collision with root package name */
    public NetWork f49798h = null;

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
        this.f49796f = true;
        NetWork netWork = this.f49798h;
        if (netWork != null) {
            netWork.cancelNetConnect();
        }
    }

    public void b(String str) {
        this.f49797g = str;
    }

    public void c(a aVar, Object obj) {
        this.i = aVar;
        this.k = obj;
        if (aVar != null) {
            this.f49791a = 10240;
        }
    }

    public void d(b bVar, Object obj) {
        this.j = bVar;
        this.k = obj;
    }

    public void e(int i, int i2, int i3, int i4) {
        this.f49792b = i;
        this.f49793c = i2;
        this.f49794d = i3;
        this.f49795e = i4;
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

    /* JADX WARN: Can't wrap try/catch for region: R(11:44|(17:48|49|(1:51)(1:246)|52|54|55|56|(2:57|(6:59|60|61|(1:233)(25:63|(1:65)(6:219|(1:221)(2:229|(1:231)(3:232|(1:228)(1:226)|227))|222|(1:224)|228|227)|66|67|(2:215|216)(1:69)|70|71|(2:73|74)(1:214)|75|(1:79)|80|(1:84)|85|(1:87)|88|(1:90)(1:213)|91|92|(1:94)|(6:96|(1:98)|99|(1:103)|104|(6:106|(1:108)|109|(1:111)|112|(8:115|116|(3:194|195|(1:197))|118|(5:173|174|175|176|(2:180|181)(0))(9:120|(4:122|123|124|125)(1:172)|126|127|(5:154|155|156|157|158)(1:129)|130|131|(3:133|134|135)(1:150)|136)|137|138|(2:141|142)(1:140))(2:211|210)))|212|109|(0)|112|(1:211)(8:115|116|(0)|118|(0)(0)|137|138|(0)(0)))|217|218)(1:240))|198|(1:200)(1:204)|201|(1:203)(0)|143|144|145|31|32)|247|248|249|251|252|253|145|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x034b, code lost:
        r15.append("|startChunk=");
        r15.append(r4);
        d.b.i0.c3.q0.b.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = pic = null    p = " + r37);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0365, code lost:
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0368, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0369, code lost:
        r3 = r0;
        r27 = r12;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x04ad, code lost:
        r25 = r6;
        r2 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0509, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x050a, code lost:
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x050c, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0519, code lost:
        r3 = r0;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x051b, code lost:
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0161, code lost:
        r15.append("|startChunk=");
        r15.append(r14);
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02df A[Catch: Exception -> 0x0169, all -> 0x059c, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0169, blocks: (B:44:0x0161, B:68:0x01d6, B:74:0x01f1, B:79:0x020b, B:81:0x020f, B:84:0x022d, B:86:0x0231, B:89:0x0263, B:92:0x026e, B:98:0x0283, B:100:0x0290, B:102:0x029a, B:103:0x02a3, B:107:0x02b0, B:108:0x02b7, B:112:0x02c8, B:117:0x02df, B:52:0x0180, B:59:0x019f, B:56:0x018b), top: B:249:0x01d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0436 A[LOOP:0: B:39:0x0156->B:174:0x0436, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0520 A[Catch: all -> 0x059c, TryCatch #22 {all -> 0x059c, blocks: (B:217:0x051c, B:219:0x0520, B:222:0x052f, B:225:0x0536, B:227:0x053d, B:226:0x0539, B:220:0x0526, B:44:0x0161, B:68:0x01d6, B:74:0x01f1, B:79:0x020b, B:81:0x020f, B:84:0x022d, B:86:0x0231, B:89:0x0263, B:92:0x026e, B:98:0x0283, B:100:0x0290, B:102:0x029a, B:103:0x02a3, B:107:0x02b0, B:108:0x02b7, B:112:0x02c8, B:117:0x02df, B:123:0x02f8, B:130:0x030d, B:132:0x0322, B:134:0x0332, B:137:0x0337, B:139:0x034b, B:148:0x0383, B:52:0x0180, B:59:0x019f, B:56:0x018b), top: B:249:0x01d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0526 A[Catch: all -> 0x059c, TryCatch #22 {all -> 0x059c, blocks: (B:217:0x051c, B:219:0x0520, B:222:0x052f, B:225:0x0536, B:227:0x053d, B:226:0x0539, B:220:0x0526, B:44:0x0161, B:68:0x01d6, B:74:0x01f1, B:79:0x020b, B:81:0x020f, B:84:0x022d, B:86:0x0231, B:89:0x0263, B:92:0x026e, B:98:0x0283, B:100:0x0290, B:102:0x029a, B:103:0x02a3, B:107:0x02b0, B:108:0x02b7, B:112:0x02c8, B:117:0x02df, B:123:0x02f8, B:130:0x030d, B:132:0x0322, B:134:0x0332, B:137:0x0337, B:139:0x034b, B:148:0x0383, B:52:0x0180, B:59:0x019f, B:56:0x018b), top: B:249:0x01d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x052f A[Catch: all -> 0x059c, TryCatch #22 {all -> 0x059c, blocks: (B:217:0x051c, B:219:0x0520, B:222:0x052f, B:225:0x0536, B:227:0x053d, B:226:0x0539, B:220:0x0526, B:44:0x0161, B:68:0x01d6, B:74:0x01f1, B:79:0x020b, B:81:0x020f, B:84:0x022d, B:86:0x0231, B:89:0x0263, B:92:0x026e, B:98:0x0283, B:100:0x0290, B:102:0x029a, B:103:0x02a3, B:107:0x02b0, B:108:0x02b7, B:112:0x02c8, B:117:0x02df, B:123:0x02f8, B:130:0x030d, B:132:0x0322, B:134:0x0332, B:137:0x0337, B:139:0x034b, B:148:0x0383, B:52:0x0180, B:59:0x019f, B:56:0x018b), top: B:249:0x01d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0536 A[Catch: all -> 0x059c, TryCatch #22 {all -> 0x059c, blocks: (B:217:0x051c, B:219:0x0520, B:222:0x052f, B:225:0x0536, B:227:0x053d, B:226:0x0539, B:220:0x0526, B:44:0x0161, B:68:0x01d6, B:74:0x01f1, B:79:0x020b, B:81:0x020f, B:84:0x022d, B:86:0x0231, B:89:0x0263, B:92:0x026e, B:98:0x0283, B:100:0x0290, B:102:0x029a, B:103:0x02a3, B:107:0x02b0, B:108:0x02b7, B:112:0x02c8, B:117:0x02df, B:123:0x02f8, B:130:0x030d, B:132:0x0322, B:134:0x0332, B:137:0x0337, B:139:0x034b, B:148:0x0383, B:52:0x0180, B:59:0x019f, B:56:0x018b), top: B:249:0x01d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0539 A[Catch: all -> 0x059c, TryCatch #22 {all -> 0x059c, blocks: (B:217:0x051c, B:219:0x0520, B:222:0x052f, B:225:0x0536, B:227:0x053d, B:226:0x0539, B:220:0x0526, B:44:0x0161, B:68:0x01d6, B:74:0x01f1, B:79:0x020b, B:81:0x020f, B:84:0x022d, B:86:0x0231, B:89:0x0263, B:92:0x026e, B:98:0x0283, B:100:0x0290, B:102:0x029a, B:103:0x02a3, B:107:0x02b0, B:108:0x02b7, B:112:0x02c8, B:117:0x02df, B:123:0x02f8, B:130:0x030d, B:132:0x0322, B:134:0x0332, B:137:0x0337, B:139:0x034b, B:148:0x0383, B:52:0x0180, B:59:0x019f, B:56:0x018b), top: B:249:0x01d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x030d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x02f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0424 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult l(String str, boolean z, boolean z2, int i, int i2) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        String str2;
        int i3;
        char c2;
        Exception exc;
        ImageUploadResult imageUploadResult;
        Throwable th2;
        String str3;
        File file;
        long length;
        RandomAccessFile randomAccessFile2;
        int i4;
        byte[] bArr;
        int i5;
        byte[] bArr2;
        long j;
        String a2;
        String postMultiNetData;
        ImageUploadResult parser;
        ImageUploadResult imageUploadResult2;
        ImageUploadResult imageUploadResult3;
        int i6;
        String str4;
        byte[] bArr3;
        long j2;
        long j3;
        Exception e2;
        int i7;
        long j4;
        int i8;
        long j5;
        String str5 = "    p = ";
        d.b.i0.c3.q0.b.a("发帖：正在上传图片 = " + str);
        BitmapFactory.Options options = new BitmapFactory.Options();
        boolean z3 = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        if (options.outWidth != 0 && options.outHeight != 0) {
            StringBuilder sb = new StringBuilder();
            try {
                try {
                    file = new File(str);
                    length = file.length();
                } catch (Exception e3) {
                    e = e3;
                    str2 = "    p = ";
                    i3 = 2;
                    c2 = 0;
                }
                try {
                    try {
                    } catch (Exception e4) {
                        exc = e4;
                        str2 = "    p = ";
                        imageUploadResult = null;
                        randomAccessFile = null;
                    }
                    if ((!z && length > 5242880) || (z && length > Config.FULL_TRACE_LOG_LIMIT)) {
                        imageUploadResult = new ImageUploadResult();
                        try {
                            imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                            imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_size_over);
                            d.b.i0.c3.q0.b.a("发帖：正在上传图片 失败 限制大小 = " + length + "    p = " + str);
                            d.b.b.e.m.a.b(null);
                            this.f49798h = null;
                            return imageUploadResult;
                        } catch (Exception e5) {
                            exc = e5;
                            str2 = "    p = ";
                            randomAccessFile = null;
                        }
                    } else {
                        d.b.i0.c3.q0.b.a("发帖：正在上传图片 进行中 限制大小 = " + length + "    p = " + str);
                        String b2 = q.b(FileHelper.GetStreamFromFile(file));
                        sb.append("path=");
                        sb.append(str);
                        sb.append("|length=");
                        sb.append(length);
                        sb.append("|md5=");
                        sb.append(b2);
                        if (length != 0 && b2 != null) {
                            String str6 = b2 + this.f49791a;
                            long j6 = length % ((long) this.f49791a) == 0 ? length / this.f49791a : (length / this.f49791a) + 1;
                            sb.append("|chunkNo=");
                            sb.append(j6);
                            randomAccessFile = new RandomAccessFile(str, r.f7663a);
                            try {
                                try {
                                    sb.append("|width=");
                                    sb.append(this.f49792b);
                                    sb.append("|height=");
                                    sb.append(this.f49793c);
                                    sb.append("|smallWidth=");
                                    sb.append(this.f49794d);
                                    sb.append("|smallHeight=");
                                    sb.append(this.f49795e);
                                    sb.append("|groupId=");
                                    sb.append(this.f49797g);
                                    long j7 = 0;
                                    byte[] bArr4 = null;
                                    ImageUploadResult imageUploadResult4 = null;
                                    int i9 = 1;
                                    int i10 = 0;
                                    while (true) {
                                        long j8 = i9;
                                        if (j8 > j6) {
                                            break;
                                        }
                                        try {
                                            if (this.f49796f == z3) {
                                                break;
                                            }
                                            if (j8 > j6) {
                                                j = length;
                                                i4 = i9;
                                                i5 = 0;
                                                bArr2 = null;
                                            } else {
                                                if (j8 < j6) {
                                                    i5 = this.f49791a;
                                                    i4 = i9;
                                                } else if (j8 == j6) {
                                                    i4 = i9;
                                                    i5 = (int) (length - (this.f49791a * (j6 - 1)));
                                                } else {
                                                    i4 = i9;
                                                    bArr = bArr4;
                                                    i5 = 0;
                                                    bArr2 = (bArr == null && bArr.length == i5) ? bArr : new byte[i5];
                                                    j = length;
                                                    randomAccessFile.seek(this.f49791a * (i4 - 1));
                                                    randomAccessFile.read(bArr2, 0, i5);
                                                }
                                                bArr = bArr4;
                                                if (bArr == null) {
                                                }
                                                j = length;
                                                randomAccessFile.seek(this.f49791a * (i4 - 1));
                                                randomAccessFile.read(bArr2, 0, i5);
                                            }
                                            NetWork netWork = new NetWork(TbConfig.UPLOAD_IMG_URL);
                                            this.f49798h = netWork;
                                            netWork.addPostData("resourceId", str6);
                                            this.f49798h.addPostData("chunkNo", String.valueOf(i4));
                                            if (j8 >= j6) {
                                                try {
                                                    try {
                                                        this.f49798h.addPostData("isFinish", String.valueOf(1));
                                                    } catch (Exception e6) {
                                                        exc = e6;
                                                        str2 = str5;
                                                        imageUploadResult = imageUploadResult4;
                                                    }
                                                } catch (Throwable th3) {
                                                    th2 = th3;
                                                    th = th2;
                                                    d.b.b.e.m.a.b(randomAccessFile);
                                                    this.f49798h = null;
                                                    throw th;
                                                }
                                            } else {
                                                this.f49798h.addPostData("isFinish", String.valueOf(0));
                                            }
                                            if (this.m) {
                                                this.f49798h.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(1));
                                            } else {
                                                this.f49798h.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(0));
                                            }
                                            if (this.f49792b > 0 && this.f49793c > 0) {
                                                this.f49798h.addPostData("width", String.valueOf(this.f49792b));
                                                this.f49798h.addPostData("height", String.valueOf(this.f49793c));
                                            }
                                            if (this.f49794d > 0 && this.f49795e > 0) {
                                                this.f49798h.addPostData("smallWidth", String.valueOf(this.f49794d));
                                                this.f49798h.addPostData("smallHeight", String.valueOf(this.f49795e));
                                            }
                                            this.f49798h.addPostData(TbEnum.SystemMessage.KEY_GROUP_ID, String.valueOf(this.f49797g));
                                            this.f49798h.addPostData("alt", "json");
                                            if (bArr2 != null) {
                                                this.f49798h.addPostData("chunk", bArr2);
                                            }
                                            if (z) {
                                                this.f49798h.addPostData("saveOrigin", "1");
                                            } else {
                                                this.f49798h.addPostData("saveOrigin", "0");
                                            }
                                            if (this.n != 0) {
                                                this.f49798h.addPostData("pic_water_type", String.valueOf(this.n));
                                            }
                                            if (z2) {
                                                int b3 = k.c().b();
                                                if (b3 != 0) {
                                                    this.f49798h.addPostData("pic_water_type", String.valueOf(b3));
                                                }
                                                String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                                if (!StringUtils.isNull(currentAccountName) && b3 == 1) {
                                                    this.f49798h.addPostData("user_name", currentAccountName);
                                                }
                                                String a3 = k.c().a();
                                                if (!StringUtils.isNull(a3)) {
                                                    if (b3 == 2) {
                                                        this.f49798h.addPostData("forum_name", a3);
                                                    }
                                                    a2 = k.c().a();
                                                    if (!StringUtils.isNull(a2)) {
                                                        this.f49798h.addPostData("small_flow_fname", a2);
                                                    }
                                                    postMultiNetData = this.f49798h.postMultiNetData();
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
                                                            } catch (Exception e7) {
                                                                e = e7;
                                                                exc = e;
                                                                imageUploadResult = parser;
                                                                str2 = str5;
                                                                i3 = 2;
                                                                c2 = 0;
                                                                if (!this.f49796f) {
                                                                }
                                                                if (imageUploadResult == null) {
                                                                }
                                                                if (imageUploadResult == null) {
                                                                }
                                                                Object[] objArr = new Object[i3];
                                                                objArr[c2] = "comment";
                                                                objArr[1] = sb.toString();
                                                                d.b.h0.r.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr);
                                                                StringBuilder sb2 = new StringBuilder();
                                                                sb2.append("发帖：正在上传图片 上传失败 = ");
                                                                sb2.append(r4);
                                                                sb2.append(" ");
                                                                sb2.append(r3);
                                                                sb2.append(str2);
                                                                str3 = str;
                                                                sb2.append(str3);
                                                                d.b.i0.c3.q0.b.a(sb2.toString());
                                                                d.b.b.e.m.a.b(randomAccessFile);
                                                                this.f49798h = null;
                                                                d.b.i0.c3.q0.b.a("发帖：上传图片 结束      p = " + str3);
                                                                return imageUploadResult;
                                                            }
                                                        }
                                                        if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                            try {
                                                                StringBuilder sb3 = new StringBuilder();
                                                                sb3.append("发帖：正在上传图片 上传失败 CHUNK_ERROR = ");
                                                                sb3.append(parser.error_code);
                                                                sb3.append(str5);
                                                                sb3.append(str);
                                                                d.b.i0.c3.q0.b.a(sb3.toString());
                                                                int i11 = i4;
                                                                if (i11 != parser.chunkNo && parser.chunkNo > 0) {
                                                                    i6 = parser.chunkNo;
                                                                    str4 = str6;
                                                                    randomAccessFile2 = randomAccessFile;
                                                                    imageUploadResult2 = parser;
                                                                    bArr3 = bArr2;
                                                                    j2 = j;
                                                                    i3 = 2;
                                                                    c2 = 0;
                                                                    str2 = str5;
                                                                    j3 = j6;
                                                                }
                                                            } catch (Exception e8) {
                                                                e = e8;
                                                                exc = e;
                                                                imageUploadResult = parser;
                                                                str2 = str5;
                                                                i3 = 2;
                                                                c2 = 0;
                                                                if (!this.f49796f) {
                                                                }
                                                                if (imageUploadResult == null) {
                                                                }
                                                                if (imageUploadResult == null) {
                                                                }
                                                                Object[] objArr2 = new Object[i3];
                                                                objArr2[c2] = "comment";
                                                                objArr2[1] = sb.toString();
                                                                d.b.h0.r.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr2);
                                                                StringBuilder sb22 = new StringBuilder();
                                                                sb22.append("发帖：正在上传图片 上传失败 = ");
                                                                sb22.append(r4);
                                                                sb22.append(" ");
                                                                sb22.append(r3);
                                                                sb22.append(str2);
                                                                str3 = str;
                                                                sb22.append(str3);
                                                                d.b.i0.c3.q0.b.a(sb22.toString());
                                                                d.b.b.e.m.a.b(randomAccessFile);
                                                                this.f49798h = null;
                                                                d.b.i0.c3.q0.b.a("发帖：上传图片 结束      p = " + str3);
                                                                return imageUploadResult;
                                                            }
                                                        } else {
                                                            int i12 = i4 + 1;
                                                            j7 += i5;
                                                            if (i12 > 1) {
                                                                try {
                                                                    j4 = j7 + ((i12 - 1) * this.f49791a);
                                                                } catch (Exception e9) {
                                                                    exc = e9;
                                                                    str2 = str5;
                                                                    imageUploadResult = parser;
                                                                }
                                                            } else {
                                                                j4 = j7;
                                                            }
                                                            try {
                                                                d.b.i0.c3.q0.b.a("发帖：正在上传图片 已上传 = " + j4 + str5 + str);
                                                                if (this.i != null) {
                                                                    try {
                                                                        i8 = i12;
                                                                        str4 = str6;
                                                                        randomAccessFile2 = randomAccessFile;
                                                                        imageUploadResult2 = parser;
                                                                        j2 = j;
                                                                        j5 = j4;
                                                                        try {
                                                                            this.i.a(str, this.k, j4, j2);
                                                                        } catch (Exception e10) {
                                                                            exc = e10;
                                                                            str2 = str5;
                                                                            imageUploadResult = imageUploadResult2;
                                                                            randomAccessFile = randomAccessFile2;
                                                                        }
                                                                    } catch (Exception e11) {
                                                                        exc = e11;
                                                                        str2 = str5;
                                                                        imageUploadResult = parser;
                                                                    }
                                                                } else {
                                                                    i8 = i12;
                                                                    str4 = str6;
                                                                    randomAccessFile2 = randomAccessFile;
                                                                    imageUploadResult2 = parser;
                                                                    j2 = j;
                                                                    j5 = j4;
                                                                }
                                                                try {
                                                                    if (this.j != null) {
                                                                        long j9 = j5;
                                                                        str2 = str5;
                                                                        c2 = 0;
                                                                        j3 = j6;
                                                                        bArr3 = bArr2;
                                                                        i3 = 2;
                                                                        this.j.a(str, this.k, j9, j2, i, i2);
                                                                    } else {
                                                                        str2 = str5;
                                                                        bArr3 = bArr2;
                                                                        i3 = 2;
                                                                        c2 = 0;
                                                                        j3 = j6;
                                                                    }
                                                                    i6 = i8;
                                                                } catch (Exception e12) {
                                                                    e2 = e12;
                                                                    str2 = str5;
                                                                    i3 = 2;
                                                                    c2 = 0;
                                                                    exc = e2;
                                                                    imageUploadResult = imageUploadResult2;
                                                                    randomAccessFile = randomAccessFile2;
                                                                    if (!this.f49796f) {
                                                                    }
                                                                    if (imageUploadResult == null) {
                                                                    }
                                                                    if (imageUploadResult == null) {
                                                                    }
                                                                    Object[] objArr22 = new Object[i3];
                                                                    objArr22[c2] = "comment";
                                                                    objArr22[1] = sb.toString();
                                                                    d.b.h0.r.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr22);
                                                                    StringBuilder sb222 = new StringBuilder();
                                                                    sb222.append("发帖：正在上传图片 上传失败 = ");
                                                                    sb222.append(r4);
                                                                    sb222.append(" ");
                                                                    sb222.append(r3);
                                                                    sb222.append(str2);
                                                                    str3 = str;
                                                                    sb222.append(str3);
                                                                    d.b.i0.c3.q0.b.a(sb222.toString());
                                                                    d.b.b.e.m.a.b(randomAccessFile);
                                                                    this.f49798h = null;
                                                                    d.b.i0.c3.q0.b.a("发帖：上传图片 结束      p = " + str3);
                                                                    return imageUploadResult;
                                                                }
                                                            } catch (Exception e13) {
                                                                e = e13;
                                                                str2 = str5;
                                                                imageUploadResult3 = parser;
                                                                i3 = 2;
                                                                c2 = 0;
                                                                exc = e;
                                                                imageUploadResult = imageUploadResult3;
                                                                if (!this.f49796f) {
                                                                }
                                                                if (imageUploadResult == null) {
                                                                }
                                                                if (imageUploadResult == null) {
                                                                }
                                                                Object[] objArr222 = new Object[i3];
                                                                objArr222[c2] = "comment";
                                                                objArr222[1] = sb.toString();
                                                                d.b.h0.r.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr222);
                                                                StringBuilder sb2222 = new StringBuilder();
                                                                sb2222.append("发帖：正在上传图片 上传失败 = ");
                                                                sb2222.append(r4);
                                                                sb2222.append(" ");
                                                                sb2222.append(r3);
                                                                sb2222.append(str2);
                                                                str3 = str;
                                                                sb2222.append(str3);
                                                                d.b.i0.c3.q0.b.a(sb2222.toString());
                                                                d.b.b.e.m.a.b(randomAccessFile);
                                                                this.f49798h = null;
                                                                d.b.i0.c3.q0.b.a("发帖：上传图片 结束      p = " + str3);
                                                                return imageUploadResult;
                                                            }
                                                        }
                                                    } catch (Exception e14) {
                                                        e = e14;
                                                        imageUploadResult3 = parser;
                                                        str2 = str5;
                                                    }
                                                    try {
                                                        try {
                                                            i7 = i10 + 1;
                                                            if (i7 <= j3 * 2) {
                                                                sb.append("|possbile dead loop found. tryCount=");
                                                                sb.append(i7);
                                                                sb.append(", chunkNo=");
                                                                sb.append(j3);
                                                                break;
                                                            }
                                                            i10 = i7;
                                                            j6 = j3;
                                                            length = j2;
                                                            str6 = str4;
                                                            randomAccessFile = randomAccessFile2;
                                                            str5 = str2;
                                                            bArr4 = bArr3;
                                                            z3 = true;
                                                            imageUploadResult4 = imageUploadResult2;
                                                            i9 = i6;
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            randomAccessFile = randomAccessFile2;
                                                            d.b.b.e.m.a.b(randomAccessFile);
                                                            this.f49798h = null;
                                                            throw th;
                                                        }
                                                    } catch (Exception e15) {
                                                        e2 = e15;
                                                        exc = e2;
                                                        imageUploadResult = imageUploadResult2;
                                                        randomAccessFile = randomAccessFile2;
                                                        if (!this.f49796f) {
                                                        }
                                                        if (imageUploadResult == null) {
                                                        }
                                                        if (imageUploadResult == null) {
                                                        }
                                                        Object[] objArr2222 = new Object[i3];
                                                        objArr2222[c2] = "comment";
                                                        objArr2222[1] = sb.toString();
                                                        d.b.h0.r.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr2222);
                                                        StringBuilder sb22222 = new StringBuilder();
                                                        sb22222.append("发帖：正在上传图片 上传失败 = ");
                                                        sb22222.append(r4);
                                                        sb22222.append(" ");
                                                        sb22222.append(r3);
                                                        sb22222.append(str2);
                                                        str3 = str;
                                                        sb22222.append(str3);
                                                        d.b.i0.c3.q0.b.a(sb22222.toString());
                                                        d.b.b.e.m.a.b(randomAccessFile);
                                                        this.f49798h = null;
                                                        d.b.i0.c3.q0.b.a("发帖：上传图片 结束      p = " + str3);
                                                        return imageUploadResult;
                                                    }
                                                }
                                            }
                                            a2 = k.c().a();
                                            if (!StringUtils.isNull(a2)) {
                                            }
                                            postMultiNetData = this.f49798h.postMultiNetData();
                                            parser = ImageUploadResult.parser(postMultiNetData);
                                            if (postMultiNetData != null) {
                                                break;
                                            }
                                            if (parser.error_code != 0) {
                                            }
                                            if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                            }
                                            i7 = i10 + 1;
                                            if (i7 <= j3 * 2) {
                                            }
                                            exc = e6;
                                            str2 = str5;
                                            imageUploadResult = imageUploadResult4;
                                        } catch (Exception e16) {
                                            str2 = str5;
                                            i3 = 2;
                                            c2 = 0;
                                            exc = e16;
                                            imageUploadResult = imageUploadResult4;
                                        }
                                    }
                                    imageUploadResult2 = parser;
                                    int i13 = i4;
                                    randomAccessFile2 = randomAccessFile;
                                    sb.append("|startChunk=");
                                    sb.append(i13);
                                    sb.append("|picNull=");
                                    sb.append(imageUploadResult2 == null);
                                    sb.append("|picErrNo=");
                                    if (imageUploadResult2 != null) {
                                        sb.append(imageUploadResult2.error_code);
                                    }
                                    imageUploadResult = imageUploadResult2;
                                    randomAccessFile = randomAccessFile2;
                                    d.b.b.e.m.a.b(randomAccessFile);
                                    this.f49798h = null;
                                    str3 = str;
                                } catch (Throwable th5) {
                                    th2 = th5;
                                    th = th2;
                                    d.b.b.e.m.a.b(randomAccessFile);
                                    this.f49798h = null;
                                    throw th;
                                }
                            } catch (Exception e17) {
                                str2 = "    p = ";
                                i3 = 2;
                                c2 = 0;
                                exc = e17;
                                imageUploadResult = null;
                            }
                            d.b.i0.c3.q0.b.a("发帖：上传图片 结束      p = " + str3);
                            return imageUploadResult;
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
                        this.f49798h = null;
                        str3 = str;
                        d.b.i0.c3.q0.b.a("发帖：上传图片 结束      p = " + str3);
                        return imageUploadResult;
                    }
                    i3 = 2;
                    c2 = 0;
                    d.b.i0.c3.q0.b.a("发帖：上传图片 结束      p = " + str3);
                    return imageUploadResult;
                } catch (Throwable th6) {
                    th = th6;
                    randomAccessFile = null;
                }
                if (!this.f49796f) {
                    sb.append("|request cancelled.");
                } else {
                    BdLog.e(exc.getMessage());
                }
                int i14 = imageUploadResult == null ? imageUploadResult.error_code : -1002;
                String message = imageUploadResult == null ? imageUploadResult.error_msg : exc.getMessage();
                Object[] objArr22222 = new Object[i3];
                objArr22222[c2] = "comment";
                objArr22222[1] = sb.toString();
                d.b.h0.r.z.a.a("img", -1L, -1, "imageUpload", i14, message, objArr22222);
                StringBuilder sb222222 = new StringBuilder();
                sb222222.append("发帖：正在上传图片 上传失败 = ");
                sb222222.append(i14);
                sb222222.append(" ");
                sb222222.append(message);
                sb222222.append(str2);
                str3 = str;
                sb222222.append(str3);
                d.b.i0.c3.q0.b.a(sb222222.toString());
                d.b.b.e.m.a.b(randomAccessFile);
                this.f49798h = null;
            } catch (Throwable th7) {
                th = th7;
                randomAccessFile = null;
            }
        } else {
            d.b.i0.c3.q0.b.a("发帖：正在上传图片 失败 = " + str);
            return null;
        }
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
                if (this.f49796f) {
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
                if (this.f49796f) {
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
