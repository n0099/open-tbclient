package d.a.p0.c0;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.q;
import d.a.p0.s.k;
import d.a.q0.h3.q0.h;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f52198a;

    /* renamed from: b  reason: collision with root package name */
    public int f52199b;

    /* renamed from: c  reason: collision with root package name */
    public int f52200c;

    /* renamed from: d  reason: collision with root package name */
    public int f52201d;

    /* renamed from: e  reason: collision with root package name */
    public int f52202e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52203f;

    /* renamed from: g  reason: collision with root package name */
    public String f52204g;

    /* renamed from: h  reason: collision with root package name */
    public NetWork f52205h;

    /* renamed from: i  reason: collision with root package name */
    public a f52206i;
    public b j;
    public Object k;
    public e l;
    public boolean m;
    public WriteData n;
    public int o;

    /* loaded from: classes7.dex */
    public interface a {
        void a(String str, Object obj, long j, long j2);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(String str, Object obj, long j, long j2, int i2, int i3);
    }

    public f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52198a = 512000;
        this.f52204g = "1";
        this.f52205h = null;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f52203f = true;
            NetWork netWork = this.f52205h;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f52204g = str;
        }
    }

    public void c(a aVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, obj) == null) {
            this.f52206i = aVar;
            this.k = obj;
            if (aVar != null) {
                this.f52198a = 10240;
            }
        }
    }

    public void d(b bVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bVar, obj) == null) {
            this.j = bVar;
            this.k = obj;
        }
    }

    public void e(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.f52199b = i2;
            this.f52200c = i3;
            this.f52201d = i4;
            this.f52202e = i5;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.o = i2;
        }
    }

    public void g(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) {
            this.n = writeData;
        }
    }

    public ImageUploadResult h(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, imageFileInfo, z)) == null) ? i(imageFileInfo, false, z) : (ImageUploadResult) invokeLZ.objValue;
    }

    public ImageUploadResult i(ImageFileInfo imageFileInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{imageFileInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? j(imageFileInfo, z, z2, 1, 1) : (ImageUploadResult) invokeCommon.objValue;
    }

    public final ImageUploadResult j(ImageFileInfo imageFileInfo, boolean z, boolean z2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{imageFileInfo, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            if (this.l == null) {
                this.l = new e();
            }
            return m(this.l.j(this.n, imageFileInfo, z), z, z2, i2, i3);
        }
        return (ImageUploadResult) invokeCommon.objValue;
    }

    public ImageUploadResult k(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, str, z)) == null) ? l(str, false, z) : (ImageUploadResult) invokeLZ.objValue;
    }

    public ImageUploadResult l(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? m(str, z, z2, 1, 1) : (ImageUploadResult) invokeCommon.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:48|(17:52|53|(1:55)(1:251)|56|57|58|59|(2:60|(16:62|63|64|(1:237)(25:(1:67)(5:(1:226)(1:(1:235)(3:236|(1:233)(1:231)|232))|227|(1:229)|233|232)|68|69|(2:221|222)(1:71)|72|73|(2:75|76)(1:220)|77|(1:81)|82|(1:86)|87|(1:89)|90|(1:92)(1:219)|93|94|(1:96)|(6:98|(1:100)|101|(1:105)|106|(7:108|(2:110|111)|115|116|(1:118)|119|(8:122|123|(3:195|196|(1:198))|125|(2:127|(2:131|132)(0))(10:154|(3:156|157|158)(1:194)|159|160|161|(5:177|178|179|180|181)(1:163)|164|165|(3:167|168|169)(1:171)|170)|133|134|(2:137|138)(1:136))(2:213|212)))|218|115|116|(0)|119|(1:213)(8:122|123|(0)|125|(0)(0)|133|134|(0)(0)))|223|224|24|25|26|(1:28)(1:44)|(1:30)(1:43)|(1:32)(1:42)|33|34|35|36)(1:244))|199|(1:201)(1:205)|202|(1:204)(0)|139|140|141|35|36)|252|253|254|256|257|258|141|35|36) */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x034c, code lost:
        r15.append("|startChunk=");
        r15.append(r4);
        d.a.q0.h3.q0.h.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = pic = null    p = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0366, code lost:
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0369, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x036a, code lost:
        r3 = r0;
        r27 = r12;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x04a6, code lost:
        r28 = r6;
        r2 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0502, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0503, code lost:
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0505, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0512, code lost:
        r3 = r0;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0514, code lost:
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0165, code lost:
        r15.append("|startChunk=");
        r15.append(r14);
     */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02db A[Catch: Exception -> 0x02e3, all -> 0x0595, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x02e3, blocks: (B:113:0x02c4, B:118:0x02db), top: B:255:0x02c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0312 A[Catch: Exception -> 0x0305, all -> 0x0595, TRY_ENTER, TryCatch #20 {all -> 0x0595, blocks: (B:223:0x0515, B:225:0x0519, B:228:0x0528, B:231:0x052f, B:233:0x0536, B:232:0x0532, B:226:0x051f, B:48:0x0165, B:69:0x01d2, B:75:0x01ed, B:80:0x0207, B:82:0x020b, B:85:0x0229, B:87:0x022d, B:90:0x025f, B:93:0x026a, B:99:0x027f, B:101:0x028c, B:103:0x0296, B:104:0x029f, B:108:0x02ac, B:109:0x02b3, B:113:0x02c4, B:118:0x02db, B:127:0x02fd, B:134:0x0312, B:136:0x0334, B:139:0x0339, B:141:0x034c, B:148:0x037c, B:54:0x0180, B:60:0x019d, B:57:0x0189), top: B:247:0x01d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0426 A[LOOP:0: B:43:0x015a->B:175:0x0426, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0519 A[Catch: all -> 0x0595, TryCatch #20 {all -> 0x0595, blocks: (B:223:0x0515, B:225:0x0519, B:228:0x0528, B:231:0x052f, B:233:0x0536, B:232:0x0532, B:226:0x051f, B:48:0x0165, B:69:0x01d2, B:75:0x01ed, B:80:0x0207, B:82:0x020b, B:85:0x0229, B:87:0x022d, B:90:0x025f, B:93:0x026a, B:99:0x027f, B:101:0x028c, B:103:0x0296, B:104:0x029f, B:108:0x02ac, B:109:0x02b3, B:113:0x02c4, B:118:0x02db, B:127:0x02fd, B:134:0x0312, B:136:0x0334, B:139:0x0339, B:141:0x034c, B:148:0x037c, B:54:0x0180, B:60:0x019d, B:57:0x0189), top: B:247:0x01d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x051f A[Catch: all -> 0x0595, TryCatch #20 {all -> 0x0595, blocks: (B:223:0x0515, B:225:0x0519, B:228:0x0528, B:231:0x052f, B:233:0x0536, B:232:0x0532, B:226:0x051f, B:48:0x0165, B:69:0x01d2, B:75:0x01ed, B:80:0x0207, B:82:0x020b, B:85:0x0229, B:87:0x022d, B:90:0x025f, B:93:0x026a, B:99:0x027f, B:101:0x028c, B:103:0x0296, B:104:0x029f, B:108:0x02ac, B:109:0x02b3, B:113:0x02c4, B:118:0x02db, B:127:0x02fd, B:134:0x0312, B:136:0x0334, B:139:0x0339, B:141:0x034c, B:148:0x037c, B:54:0x0180, B:60:0x019d, B:57:0x0189), top: B:247:0x01d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0528 A[Catch: all -> 0x0595, TryCatch #20 {all -> 0x0595, blocks: (B:223:0x0515, B:225:0x0519, B:228:0x0528, B:231:0x052f, B:233:0x0536, B:232:0x0532, B:226:0x051f, B:48:0x0165, B:69:0x01d2, B:75:0x01ed, B:80:0x0207, B:82:0x020b, B:85:0x0229, B:87:0x022d, B:90:0x025f, B:93:0x026a, B:99:0x027f, B:101:0x028c, B:103:0x0296, B:104:0x029f, B:108:0x02ac, B:109:0x02b3, B:113:0x02c4, B:118:0x02db, B:127:0x02fd, B:134:0x0312, B:136:0x0334, B:139:0x0339, B:141:0x034c, B:148:0x037c, B:54:0x0180, B:60:0x019d, B:57:0x0189), top: B:247:0x01d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x052f A[Catch: all -> 0x0595, TryCatch #20 {all -> 0x0595, blocks: (B:223:0x0515, B:225:0x0519, B:228:0x0528, B:231:0x052f, B:233:0x0536, B:232:0x0532, B:226:0x051f, B:48:0x0165, B:69:0x01d2, B:75:0x01ed, B:80:0x0207, B:82:0x020b, B:85:0x0229, B:87:0x022d, B:90:0x025f, B:93:0x026a, B:99:0x027f, B:101:0x028c, B:103:0x0296, B:104:0x029f, B:108:0x02ac, B:109:0x02b3, B:113:0x02c4, B:118:0x02db, B:127:0x02fd, B:134:0x0312, B:136:0x0334, B:139:0x0339, B:141:0x034c, B:148:0x037c, B:54:0x0180, B:60:0x019d, B:57:0x0189), top: B:247:0x01d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0532 A[Catch: all -> 0x0595, TryCatch #20 {all -> 0x0595, blocks: (B:223:0x0515, B:225:0x0519, B:228:0x0528, B:231:0x052f, B:233:0x0536, B:232:0x0532, B:226:0x051f, B:48:0x0165, B:69:0x01d2, B:75:0x01ed, B:80:0x0207, B:82:0x020b, B:85:0x0229, B:87:0x022d, B:90:0x025f, B:93:0x026a, B:99:0x027f, B:101:0x028c, B:103:0x0296, B:104:0x029f, B:108:0x02ac, B:109:0x02b3, B:113:0x02c4, B:118:0x02db, B:127:0x02fd, B:134:0x0312, B:136:0x0334, B:139:0x0339, B:141:0x034c, B:148:0x037c, B:54:0x0180, B:60:0x019d, B:57:0x0189), top: B:247:0x01d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x02fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0414 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult m(String str, boolean z, boolean z2, int i2, int i3) {
        InterceptResult invokeCommon;
        Throwable th;
        RandomAccessFile randomAccessFile;
        String str2;
        int i4;
        char c2;
        Exception exc;
        ImageUploadResult imageUploadResult;
        Throwable th2;
        String str3;
        File file;
        long length;
        long j;
        byte[] bArr;
        ImageUploadResult imageUploadResult2;
        int i5;
        int i6;
        RandomAccessFile randomAccessFile2;
        int i7;
        byte[] bArr2;
        int i8;
        byte[] bArr3;
        long j2;
        String a2;
        String postMultiNetData;
        ImageUploadResult parser;
        ImageUploadResult imageUploadResult3;
        ImageUploadResult imageUploadResult4;
        long j3;
        String str4;
        int i9;
        long j4;
        byte[] bArr4;
        long j5;
        int i10;
        int i11;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)})) != null) {
            return (ImageUploadResult) invokeCommon.objValue;
        }
        String str5 = str;
        String str6 = "    p = ";
        h.a("发帖：正在上传图片 = " + str5);
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
                } catch (Exception e2) {
                    e = e2;
                    str2 = "    p = ";
                    i4 = 2;
                    c2 = 0;
                }
                try {
                    try {
                    } catch (Exception e3) {
                        exc = e3;
                        str2 = "    p = ";
                        imageUploadResult = null;
                        randomAccessFile = null;
                    }
                    if ((!z && length > 5242880) || (z && length > Config.FULL_TRACE_LOG_LIMIT)) {
                        imageUploadResult = new ImageUploadResult();
                        try {
                            imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                            imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_size_over);
                            h.a("发帖：正在上传图片 失败 限制大小 = " + length + "    p = " + str5);
                            d.a.d.e.m.a.b(null);
                            this.f52205h = null;
                            return imageUploadResult;
                        } catch (Exception e4) {
                            exc = e4;
                            str2 = "    p = ";
                        }
                    } else {
                        h.a("发帖：正在上传图片 进行中 限制大小 = " + length + "    p = " + str5);
                        String b2 = q.b(FileHelper.GetStreamFromFile(file));
                        sb.append("path=");
                        sb.append(str5);
                        sb.append("|length=");
                        sb.append(length);
                        sb.append("|md5=");
                        sb.append(b2);
                        if (length != 0 && b2 != null) {
                            String str7 = b2 + this.f52198a;
                            long j6 = length % ((long) this.f52198a) == 0 ? length / this.f52198a : (length / this.f52198a) + 1;
                            sb.append("|chunkNo=");
                            sb.append(j6);
                            randomAccessFile = new RandomAccessFile(str5, r.f7788a);
                            try {
                                try {
                                    sb.append("|width=");
                                    sb.append(this.f52199b);
                                    sb.append("|height=");
                                    sb.append(this.f52200c);
                                    sb.append("|smallWidth=");
                                    sb.append(this.f52201d);
                                    sb.append("|smallHeight=");
                                    sb.append(this.f52202e);
                                    sb.append("|groupId=");
                                    sb.append(this.f52204g);
                                    j = 0;
                                    bArr = null;
                                    imageUploadResult2 = null;
                                    i5 = 1;
                                    i6 = 0;
                                } catch (Throwable th3) {
                                    th2 = th3;
                                }
                            } catch (Exception e5) {
                                str2 = "    p = ";
                                i4 = 2;
                                c2 = 0;
                                exc = e5;
                                imageUploadResult = null;
                            }
                            while (true) {
                                int i12 = (i5 > j6 ? 1 : (i5 == j6 ? 0 : -1));
                                if (i12 > 0) {
                                    break;
                                }
                                try {
                                    if (this.f52203f == z3) {
                                        break;
                                    }
                                    if (i12 > 0) {
                                        j2 = length;
                                        i7 = i5;
                                        i8 = 0;
                                        bArr3 = null;
                                    } else {
                                        if (i12 < 0) {
                                            i8 = this.f52198a;
                                            i7 = i5;
                                        } else if (i12 == 0) {
                                            i7 = i5;
                                            i8 = (int) (length - (this.f52198a * (j6 - 1)));
                                        } else {
                                            i7 = i5;
                                            bArr2 = bArr;
                                            i8 = 0;
                                            bArr3 = (bArr2 == null && bArr2.length == i8) ? bArr2 : new byte[i8];
                                            j2 = length;
                                            randomAccessFile.seek(this.f52198a * (i7 - 1));
                                            randomAccessFile.read(bArr3, 0, i8);
                                        }
                                        bArr2 = bArr;
                                        if (bArr2 == null) {
                                        }
                                        j2 = length;
                                        randomAccessFile.seek(this.f52198a * (i7 - 1));
                                        randomAccessFile.read(bArr3, 0, i8);
                                    }
                                    NetWork netWork = new NetWork(TbConfig.UPLOAD_IMG_URL);
                                    this.f52205h = netWork;
                                    netWork.addPostData("resourceId", str7);
                                    this.f52205h.addPostData("chunkNo", String.valueOf(i7));
                                    if (i12 >= 0) {
                                        try {
                                            try {
                                                this.f52205h.addPostData("isFinish", String.valueOf(1));
                                            } catch (Exception e6) {
                                                exc = e6;
                                                str2 = str6;
                                                imageUploadResult = imageUploadResult2;
                                            }
                                        } catch (Throwable th4) {
                                            th2 = th4;
                                            th = th2;
                                            d.a.d.e.m.a.b(randomAccessFile);
                                            this.f52205h = null;
                                            throw th;
                                        }
                                    } else {
                                        this.f52205h.addPostData("isFinish", String.valueOf(0));
                                    }
                                    if (this.m) {
                                        this.f52205h.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(1));
                                    } else {
                                        this.f52205h.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(0));
                                    }
                                    if (this.f52199b > 0 && this.f52200c > 0) {
                                        this.f52205h.addPostData("width", String.valueOf(this.f52199b));
                                        this.f52205h.addPostData("height", String.valueOf(this.f52200c));
                                    }
                                    if (this.f52201d > 0 && this.f52202e > 0) {
                                        this.f52205h.addPostData("smallWidth", String.valueOf(this.f52201d));
                                        this.f52205h.addPostData("smallHeight", String.valueOf(this.f52202e));
                                    }
                                    this.f52205h.addPostData(TbEnum.SystemMessage.KEY_GROUP_ID, String.valueOf(this.f52204g));
                                    this.f52205h.addPostData("alt", "json");
                                    if (bArr3 != null) {
                                        this.f52205h.addPostData("chunk", bArr3);
                                    }
                                    if (z) {
                                        this.f52205h.addPostData("saveOrigin", "1");
                                    } else {
                                        this.f52205h.addPostData("saveOrigin", "0");
                                    }
                                    if (this.o != 0) {
                                        this.f52205h.addPostData("pic_water_type", String.valueOf(this.o));
                                    }
                                    try {
                                        if (z2) {
                                            int b3 = k.c().b();
                                            if (b3 != 0) {
                                                this.f52205h.addPostData("pic_water_type", String.valueOf(b3));
                                            }
                                            String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                            if (!StringUtils.isNull(currentAccountName) && b3 == 1) {
                                                this.f52205h.addPostData("user_name", currentAccountName);
                                            }
                                            String a3 = k.c().a();
                                            if (!StringUtils.isNull(a3)) {
                                                i4 = 2;
                                                if (b3 == 2) {
                                                    try {
                                                        this.f52205h.addPostData("forum_name", a3);
                                                    } catch (Exception e7) {
                                                        exc = e7;
                                                        str2 = str6;
                                                        imageUploadResult = imageUploadResult2;
                                                    }
                                                }
                                                a2 = k.c().a();
                                                if (!StringUtils.isNull(a2)) {
                                                    this.f52205h.addPostData("small_flow_fname", a2);
                                                }
                                                postMultiNetData = this.f52205h.postMultiNetData();
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
                                                        h.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = " + parser.error_code + str6 + str5);
                                                        int i13 = i7;
                                                        if (i13 != parser.chunkNo && parser.chunkNo > 0) {
                                                            i10 = parser.chunkNo;
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
                                                        int i14 = i7 + 1;
                                                        j += i8;
                                                        long j7 = i14 > 1 ? j + ((i14 - 1) * this.f52198a) : j;
                                                        StringBuilder sb2 = new StringBuilder();
                                                        try {
                                                            sb2.append("发帖：正在上传图片 已上传 = ");
                                                            sb2.append(j7);
                                                            sb2.append(str6);
                                                            sb2.append(str5);
                                                            h.a(sb2.toString());
                                                            if (this.f52206i != null) {
                                                                try {
                                                                    j3 = j7;
                                                                    str4 = str7;
                                                                    randomAccessFile3 = randomAccessFile;
                                                                    i9 = i14;
                                                                    j4 = j2;
                                                                    bArr4 = bArr3;
                                                                    imageUploadResult3 = parser;
                                                                    try {
                                                                        this.f52206i.a(str, this.k, j3, j4);
                                                                    } catch (Exception e9) {
                                                                        exc = e9;
                                                                        str2 = str6;
                                                                        imageUploadResult = imageUploadResult3;
                                                                    }
                                                                } catch (Exception e10) {
                                                                    exc = e10;
                                                                    str2 = str6;
                                                                    imageUploadResult = parser;
                                                                } catch (Throwable th5) {
                                                                    th2 = th5;
                                                                    th = th2;
                                                                    d.a.d.e.m.a.b(randomAccessFile);
                                                                    this.f52205h = null;
                                                                    throw th;
                                                                }
                                                            } else {
                                                                j3 = j7;
                                                                str4 = str7;
                                                                randomAccessFile3 = randomAccessFile;
                                                                i9 = i14;
                                                                j4 = j2;
                                                                bArr4 = bArr3;
                                                                imageUploadResult3 = parser;
                                                            }
                                                        } catch (Exception e11) {
                                                            e = e11;
                                                            imageUploadResult4 = parser;
                                                            str2 = str6;
                                                            i4 = 2;
                                                            c2 = 0;
                                                            exc = e;
                                                            imageUploadResult = imageUploadResult4;
                                                            if (!this.f52203f) {
                                                            }
                                                            if (imageUploadResult == null) {
                                                            }
                                                            if (imageUploadResult == null) {
                                                            }
                                                            Object[] objArr = new Object[i4];
                                                            objArr[c2] = "comment";
                                                            objArr[1] = sb.toString();
                                                            d.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr);
                                                            StringBuilder sb3 = new StringBuilder();
                                                            sb3.append("发帖：正在上传图片 上传失败 = ");
                                                            sb3.append(r4);
                                                            sb3.append(" ");
                                                            sb3.append(r3);
                                                            sb3.append(str2);
                                                            str3 = str;
                                                            sb3.append(str3);
                                                            h.a(sb3.toString());
                                                            d.a.d.e.m.a.b(randomAccessFile);
                                                            this.f52205h = null;
                                                            h.a("发帖：上传图片 结束      p = " + str3);
                                                            return imageUploadResult;
                                                        }
                                                        try {
                                                            if (this.j != null) {
                                                                long j8 = j3;
                                                                str2 = str6;
                                                                c2 = 0;
                                                                j5 = j6;
                                                                randomAccessFile2 = randomAccessFile3;
                                                                i4 = 2;
                                                                this.j.a(str, this.k, j8, j4, i2, i3);
                                                            } else {
                                                                str2 = str6;
                                                                randomAccessFile2 = randomAccessFile3;
                                                                i4 = 2;
                                                                c2 = 0;
                                                                j5 = j6;
                                                            }
                                                            i10 = i9;
                                                        } catch (Exception e12) {
                                                            e = e12;
                                                            str2 = str6;
                                                            randomAccessFile2 = randomAccessFile3;
                                                            i4 = 2;
                                                            c2 = 0;
                                                            exc = e;
                                                            imageUploadResult = imageUploadResult3;
                                                            randomAccessFile = randomAccessFile2;
                                                            if (!this.f52203f) {
                                                            }
                                                            if (imageUploadResult == null) {
                                                            }
                                                            if (imageUploadResult == null) {
                                                            }
                                                            Object[] objArr2 = new Object[i4];
                                                            objArr2[c2] = "comment";
                                                            objArr2[1] = sb.toString();
                                                            d.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr2);
                                                            StringBuilder sb32 = new StringBuilder();
                                                            sb32.append("发帖：正在上传图片 上传失败 = ");
                                                            sb32.append(r4);
                                                            sb32.append(" ");
                                                            sb32.append(r3);
                                                            sb32.append(str2);
                                                            str3 = str;
                                                            sb32.append(str3);
                                                            h.a(sb32.toString());
                                                            d.a.d.e.m.a.b(randomAccessFile);
                                                            this.f52205h = null;
                                                            h.a("发帖：上传图片 结束      p = " + str3);
                                                            return imageUploadResult;
                                                        } catch (Throwable th6) {
                                                            th = th6;
                                                            randomAccessFile2 = randomAccessFile3;
                                                            th = th;
                                                            randomAccessFile = randomAccessFile2;
                                                            d.a.d.e.m.a.b(randomAccessFile);
                                                            this.f52205h = null;
                                                            throw th;
                                                        }
                                                    }
                                                } catch (Exception e13) {
                                                    e = e13;
                                                    imageUploadResult4 = parser;
                                                    str2 = str6;
                                                }
                                                try {
                                                    i11 = i6 + 1;
                                                    if (i11 <= j5 * 2) {
                                                        sb.append("|possbile dead loop found. tryCount=");
                                                        sb.append(i11);
                                                        sb.append(", chunkNo=");
                                                        sb.append(j5);
                                                        break;
                                                    }
                                                    i5 = i10;
                                                    i6 = i11;
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
                                                    if (!this.f52203f) {
                                                    }
                                                    if (imageUploadResult == null) {
                                                    }
                                                    if (imageUploadResult == null) {
                                                    }
                                                    Object[] objArr22 = new Object[i4];
                                                    objArr22[c2] = "comment";
                                                    objArr22[1] = sb.toString();
                                                    d.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr22);
                                                    StringBuilder sb322 = new StringBuilder();
                                                    sb322.append("发帖：正在上传图片 上传失败 = ");
                                                    sb322.append(r4);
                                                    sb322.append(" ");
                                                    sb322.append(r3);
                                                    sb322.append(str2);
                                                    str3 = str;
                                                    sb322.append(str3);
                                                    h.a(sb322.toString());
                                                    d.a.d.e.m.a.b(randomAccessFile);
                                                    this.f52205h = null;
                                                    h.a("发帖：上传图片 结束      p = " + str3);
                                                    return imageUploadResult;
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    th = th;
                                                    randomAccessFile = randomAccessFile2;
                                                    d.a.d.e.m.a.b(randomAccessFile);
                                                    this.f52205h = null;
                                                    throw th;
                                                }
                                            }
                                        }
                                        a2 = k.c().a();
                                        if (!StringUtils.isNull(a2)) {
                                        }
                                        postMultiNetData = this.f52205h.postMultiNetData();
                                        parser = ImageUploadResult.parser(postMultiNetData);
                                        if (postMultiNetData != null) {
                                            break;
                                        }
                                        if (parser.error_code != 0) {
                                        }
                                        if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                        }
                                        i11 = i6 + 1;
                                        if (i11 <= j5 * 2) {
                                        }
                                    } catch (Exception e15) {
                                        e = e15;
                                        str2 = str6;
                                        c2 = 0;
                                        exc = e;
                                        imageUploadResult = imageUploadResult2;
                                        if (!this.f52203f) {
                                        }
                                        if (imageUploadResult == null) {
                                        }
                                        if (imageUploadResult == null) {
                                        }
                                        Object[] objArr222 = new Object[i4];
                                        objArr222[c2] = "comment";
                                        objArr222[1] = sb.toString();
                                        d.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr222);
                                        StringBuilder sb3222 = new StringBuilder();
                                        sb3222.append("发帖：正在上传图片 上传失败 = ");
                                        sb3222.append(r4);
                                        sb3222.append(" ");
                                        sb3222.append(r3);
                                        sb3222.append(str2);
                                        str3 = str;
                                        sb3222.append(str3);
                                        h.a(sb3222.toString());
                                        d.a.d.e.m.a.b(randomAccessFile);
                                        this.f52205h = null;
                                        h.a("发帖：上传图片 结束      p = " + str3);
                                        return imageUploadResult;
                                    }
                                    i4 = 2;
                                    exc = e6;
                                    str2 = str6;
                                    imageUploadResult = imageUploadResult2;
                                } catch (Exception e16) {
                                    e = e16;
                                    str2 = str6;
                                    i4 = 2;
                                }
                                i4 = 2;
                                c2 = 0;
                                if (!this.f52203f) {
                                    sb.append("|request cancelled.");
                                } else {
                                    BdLog.e(exc.getMessage());
                                }
                                int i15 = imageUploadResult == null ? imageUploadResult.error_code : -1002;
                                String message = imageUploadResult == null ? imageUploadResult.error_msg : exc.getMessage();
                                Object[] objArr2222 = new Object[i4];
                                objArr2222[c2] = "comment";
                                objArr2222[1] = sb.toString();
                                d.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", i15, message, objArr2222);
                                StringBuilder sb32222 = new StringBuilder();
                                sb32222.append("发帖：正在上传图片 上传失败 = ");
                                sb32222.append(i15);
                                sb32222.append(" ");
                                sb32222.append(message);
                                sb32222.append(str2);
                                str3 = str;
                                sb32222.append(str3);
                                h.a(sb32222.toString());
                                d.a.d.e.m.a.b(randomAccessFile);
                                this.f52205h = null;
                                h.a("发帖：上传图片 结束      p = " + str3);
                                return imageUploadResult;
                            }
                            randomAccessFile2 = randomAccessFile;
                            imageUploadResult3 = parser;
                            sb.append("|startChunk=");
                            sb.append(i7);
                            sb.append("|picNull=");
                            sb.append(imageUploadResult3 == null);
                            sb.append("|picErrNo=");
                            if (imageUploadResult3 != null) {
                                sb.append(imageUploadResult3.error_code);
                            }
                            imageUploadResult = imageUploadResult3;
                            randomAccessFile = randomAccessFile2;
                            d.a.d.e.m.a.b(randomAccessFile);
                            this.f52205h = null;
                            str3 = str;
                            h.a("发帖：上传图片 结束      p = " + str3);
                            return imageUploadResult;
                        }
                        str2 = "    p = ";
                        i4 = 2;
                        c2 = 0;
                        imageUploadResult = new ImageUploadResult();
                        imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_not_exist);
                        TiebaStatic.imgError(-1007, "file error: " + imageUploadResult.error_msg, sb.toString());
                        randomAccessFile = null;
                        d.a.d.e.m.a.b(randomAccessFile);
                        this.f52205h = null;
                        str3 = str;
                        h.a("发帖：上传图片 结束      p = " + str3);
                        return imageUploadResult;
                    }
                    randomAccessFile = randomAccessFile3;
                    i4 = 2;
                    c2 = 0;
                    h.a("发帖：上传图片 结束      p = " + str3);
                    return imageUploadResult;
                } catch (Throwable th8) {
                    th = th8;
                    randomAccessFile = null;
                }
                if (!this.f52203f) {
                }
                if (imageUploadResult == null) {
                }
                if (imageUploadResult == null) {
                }
                Object[] objArr22222 = new Object[i4];
                objArr22222[c2] = "comment";
                objArr22222[1] = sb.toString();
                d.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", i15, message, objArr22222);
                StringBuilder sb322222 = new StringBuilder();
                sb322222.append("发帖：正在上传图片 上传失败 = ");
                sb322222.append(i15);
                sb322222.append(" ");
                sb322222.append(message);
                sb322222.append(str2);
                str3 = str;
                sb322222.append(str3);
                h.a(sb322222.toString());
                d.a.d.e.m.a.b(randomAccessFile);
                this.f52205h = null;
            } catch (Throwable th9) {
                th = th9;
                randomAccessFile = null;
            }
        } else {
            h.a("发帖：正在上传图片 失败 = " + str5);
            return null;
        }
    }

    public void n(WriteImagesInfo writeImagesInfo, boolean z) {
        UploadedImageInfo uploadedPicInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, writeImagesInfo, z) == null) || writeImagesInfo == null || writeImagesInfo.size() == 0) {
            return;
        }
        LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
        for (int i2 = 0; i2 < chosedFiles.size(); i2++) {
            ImageFileInfo imageFileInfo = chosedFiles.get(i2);
            if (imageFileInfo != null && !imageFileInfo.isAlreadyUploadedToServer()) {
                if (this.f52203f) {
                    return;
                }
                ImageUploadResult i3 = i(imageFileInfo, writeImagesInfo.isOriginalImg() || imageFileInfo.isGif(), z);
                if (i3 != null && (uploadedPicInfo = i3.getUploadedPicInfo()) != null) {
                    imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                    imageFileInfo.serverPicInfo = i3.picInfo;
                }
            }
        }
    }

    public ErrorData o(WriteImagesInfo writeImagesInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, writeImagesInfo, z)) == null) {
            h.a("发帖： 上传批量图片到server");
            ErrorData errorData = new ErrorData();
            if (writeImagesInfo != null && writeImagesInfo.size() != 0) {
                LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < chosedFiles.size(); i2++) {
                    ImageFileInfo imageFileInfo = chosedFiles.get(i2);
                    if (!imageFileInfo.isAlreadyUploadedToServer()) {
                        linkedList.add(imageFileInfo);
                    }
                }
                int i3 = 0;
                while (i3 < linkedList.size()) {
                    ImageFileInfo imageFileInfo2 = (ImageFileInfo) linkedList.get(i3);
                    h.a("发帖：发送图片 上传图片 = " + i3 + " = " + imageFileInfo2.toJson().toString());
                    if (this.f52203f) {
                        break;
                    }
                    boolean isOriginalImg = imageFileInfo2.getImageType() == 1 ? false : writeImagesInfo.isOriginalImg();
                    d.a.q0.h3.q0.d.l(this.n, imageFileInfo2);
                    int i4 = i3 + 1;
                    ImageUploadResult j = j(imageFileInfo2, isOriginalImg, z, i4, linkedList.size());
                    d.a.q0.h3.q0.d.c(this.n, imageFileInfo2, j);
                    if (j != null) {
                        UploadedImageInfo uploadedPicInfo = j.getUploadedPicInfo();
                        if (uploadedPicInfo != null && !TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                            uploadedPicInfo.isGif = imageFileInfo2.isGif();
                            uploadedPicInfo.isBJH = this.m;
                            imageFileInfo2.setServerImageCode(uploadedPicInfo.toPostString());
                            i3 = i4;
                        } else {
                            errorData.setError_code(j.error_code);
                            errorData.setError_msg(j.error_msg);
                            h.a("发帖：发送图片 上传图片 错误 1= " + i3 + " = " + imageFileInfo2.toJson().toString());
                            return errorData;
                        }
                    } else {
                        errorData.setError_code(-53);
                        errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                        h.a("发帖：发送图片 上传图片 错误 2= " + i3 + " = " + imageFileInfo2.toJson().toString());
                        return errorData;
                    }
                }
                h.a("发帖：发送图片 上传图片 成功返回");
                return null;
            }
            errorData.setError_code(-53);
            errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
            h.a("发帖：发送图片 上传图片 错误 无图");
            return errorData;
        }
        return (ErrorData) invokeLZ.objValue;
    }
}
