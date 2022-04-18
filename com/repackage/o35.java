package com.repackage;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/* loaded from: classes6.dex */
public class o35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public String g;
    public NetWork h;
    public a i;
    public b j;
    public Object k;
    public n35 l;
    public boolean m;
    public WriteData n;
    public WriteImagesInfo o;
    public int p;
    public int q;

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, Object obj, long j, long j2);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(String str, Object obj, long j, long j2, int i, int i2);
    }

    public o35(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 512000;
        this.g = "1";
        this.h = null;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            NetWork netWork = this.h;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.a = i;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.g = str;
        }
    }

    public void d(a aVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, aVar, obj) == null) {
            this.i = aVar;
            this.k = obj;
            if (aVar != null) {
                this.a = 10240;
            }
        }
    }

    public void e(b bVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, obj) == null) {
            this.j = bVar;
            this.k = obj;
        }
    }

    public void f(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) {
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.q = i;
        }
    }

    public void h(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, writeData) == null) {
            this.n = writeData;
        }
    }

    public ImageUploadResult i(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, imageFileInfo, z)) == null) ? j(imageFileInfo, false, z) : (ImageUploadResult) invokeLZ.objValue;
    }

    public ImageUploadResult j(ImageFileInfo imageFileInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{imageFileInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? k(imageFileInfo, z, z2, 1, 1) : (ImageUploadResult) invokeCommon.objValue;
    }

    public final ImageUploadResult k(ImageFileInfo imageFileInfo, boolean z, boolean z2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{imageFileInfo, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            if (this.l == null) {
                this.l = new n35();
            }
            return n(this.l.j(this.n, imageFileInfo, z), z, z2, i, i2);
        }
        return (ImageUploadResult) invokeCommon.objValue;
    }

    public ImageUploadResult l(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048587, this, str, z)) == null) ? m(str, false, z) : (ImageUploadResult) invokeLZ.objValue;
    }

    public ImageUploadResult m(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? n(str, z, z2, 1, 1) : (ImageUploadResult) invokeCommon.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v10, resolved type: com.baidu.tbadk.core.util.NetWork */
    /* JADX DEBUG: Multi-variable search result rejected for r12v13, resolved type: com.baidu.tbadk.core.util.NetWork */
    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: com.baidu.tbadk.img.ImageUploadResult */
    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: com.baidu.tbadk.img.ImageUploadResult */
    /* JADX DEBUG: Multi-variable search result rejected for r4v6, resolved type: com.baidu.tbadk.img.ImageUploadResult */
    /* JADX WARN: Can't wrap try/catch for region: R(9:(15:48|49|(1:51)(1:311)|52|54|55|56|57|58|(2:59|(4:61|62|63|(1:283)(23:(1:66)(5:(2:276|277)(1:(2:261|262)(1:275))|(3:264|265|266)|273|274|268)|67|68|(5:242|243|244|245|246)(2:70|71)|72|73|(2:75|76)(1:240)|77|(1:81)|82|83|(1:85)|86|(1:88)(1:233)|89|90|(1:92)|(6:94|(1:96)|97|(1:101)|102|(6:104|(1:106)|107|(1:109)|110|(9:113|114|(3:204|205|(1:207))|116|(2:118|(2:122|123)(1:154))(4:155|156|157|(1:159)(13:160|(3:162|163|164)(1:199)|165|(1:167)|168|(5:184|185|186|187|188)(1:170)|171|172|(3:174|175|176)(1:178)|177|125|126|(2:129|130)(1:128)))|124|125|126|(0)(0))(2:231|230)))|232|107|(0)|110|(1:231)(9:113|114|(0)|116|(0)(0)|124|125|126|(0)(0))))(2:296|297))|131|132|133|36|37)|313|314|315|316|317|133|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0397, code lost:
        r3 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0399, code lost:
        r3.append("|startChunk=");
        r3.append(r7);
        com.repackage.zm8.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = pic = null    p = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x03b3, code lost:
        r15 = r4;
        r29 = r25;
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x03b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x03ba, code lost:
        r2 = r0;
        r11 = r3;
        r7 = r4;
        r29 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x04fa, code lost:
        r15 = r4;
        r29 = r25;
        r11 = r27;
        r24 = 0;
        r25 = r12;
        r12 = null;
        r11.append("|startChunk=");
        r11.append(r7);
        r11.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x050f, code lost:
        if (r15 != null) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0511, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0513, code lost:
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0514, code lost:
        r11.append(r9);
        r11.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x051c, code lost:
        if (r15 == null) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x051e, code lost:
        r11.append(r15.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0523, code lost:
        if (r15 != null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0525, code lost:
        r7 = new com.baidu.tbadk.img.ImageUploadResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x052b, code lost:
        r7.error_code = -7;
        r7.error_msg = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x052f, code lost:
        r23 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0532, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x05ca, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x05cb, code lost:
        r2 = r0;
        r29 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x05d4, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0171, code lost:
        r15.append("|startChunk=");
        r15.append(r7);
        r3 = new com.baidu.tbadk.img.ImageUploadResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x017e, code lost:
        r3.error_code = -54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0180, code lost:
        r7 = r2;
        r23 = r3;
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0186, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0187, code lost:
        r29 = r2;
        r7 = r3;
        r25 = r12;
        r11 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01c7, code lost:
        if (r14.length != r9) goto L273;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0331 A[Catch: all -> 0x0210, Exception -> 0x0212, TRY_ENTER, TRY_LEAVE, TryCatch #24 {Exception -> 0x0212, blocks: (B:80:0x0208, B:100:0x0240, B:105:0x027f, B:107:0x0283, B:110:0x02b5, B:113:0x02c0, B:119:0x02d5, B:121:0x02e2, B:123:0x02ec, B:124:0x02f5, B:128:0x0302, B:129:0x0309, B:133:0x031a, B:138:0x0331), top: B:323:0x0208 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0360 A[Catch: all -> 0x0210, Exception -> 0x0355, TRY_ENTER, TryCatch #18 {Exception -> 0x0355, blocks: (B:144:0x034b, B:151:0x0360, B:153:0x0380, B:156:0x0385, B:171:0x03f4, B:176:0x0402), top: B:316:0x034b }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x04c6 A[LOOP:0: B:42:0x0166->B:202:0x04c6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x05eb A[Catch: all -> 0x0679, TryCatch #8 {all -> 0x0679, blocks: (B:267:0x05e7, B:269:0x05eb, B:273:0x05fc, B:276:0x060d, B:278:0x0611, B:280:0x0618, B:279:0x0614, B:270:0x05f1, B:199:0x04b0, B:201:0x04b4, B:196:0x04a1, B:212:0x04fa, B:216:0x0514, B:218:0x051e, B:220:0x0525, B:222:0x052b), top: B:299:0x04b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x05f1 A[Catch: all -> 0x0679, TryCatch #8 {all -> 0x0679, blocks: (B:267:0x05e7, B:269:0x05eb, B:273:0x05fc, B:276:0x060d, B:278:0x0611, B:280:0x0618, B:279:0x0614, B:270:0x05f1, B:199:0x04b0, B:201:0x04b4, B:196:0x04a1, B:212:0x04fa, B:216:0x0514, B:218:0x051e, B:220:0x0525, B:222:0x052b), top: B:299:0x04b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x05fc A[Catch: all -> 0x0679, TryCatch #8 {all -> 0x0679, blocks: (B:267:0x05e7, B:269:0x05eb, B:273:0x05fc, B:276:0x060d, B:278:0x0611, B:280:0x0618, B:279:0x0614, B:270:0x05f1, B:199:0x04b0, B:201:0x04b4, B:196:0x04a1, B:212:0x04fa, B:216:0x0514, B:218:0x051e, B:220:0x0525, B:222:0x052b), top: B:299:0x04b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x060a  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x060d A[Catch: all -> 0x0679, TryCatch #8 {all -> 0x0679, blocks: (B:267:0x05e7, B:269:0x05eb, B:273:0x05fc, B:276:0x060d, B:278:0x0611, B:280:0x0618, B:279:0x0614, B:270:0x05f1, B:199:0x04b0, B:201:0x04b4, B:196:0x04a1, B:212:0x04fa, B:216:0x0514, B:218:0x051e, B:220:0x0525, B:222:0x052b), top: B:299:0x04b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0611 A[Catch: all -> 0x0679, TryCatch #8 {all -> 0x0679, blocks: (B:267:0x05e7, B:269:0x05eb, B:273:0x05fc, B:276:0x060d, B:278:0x0611, B:280:0x0618, B:279:0x0614, B:270:0x05f1, B:199:0x04b0, B:201:0x04b4, B:196:0x04a1, B:212:0x04fa, B:216:0x0514, B:218:0x051e, B:220:0x0525, B:222:0x052b), top: B:299:0x04b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0614 A[Catch: all -> 0x0679, TryCatch #8 {all -> 0x0679, blocks: (B:267:0x05e7, B:269:0x05eb, B:273:0x05fc, B:276:0x060d, B:278:0x0611, B:280:0x0618, B:279:0x0614, B:270:0x05f1, B:199:0x04b0, B:201:0x04b4, B:196:0x04a1, B:212:0x04fa, B:216:0x0514, B:218:0x051e, B:220:0x0525, B:222:0x052b), top: B:299:0x04b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x034b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x04b4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult n(String str, boolean z, boolean z2, int i, int i2) {
        InterceptResult invokeCommon;
        NetWork netWork;
        String str2;
        StringBuilder sb;
        char c;
        Exception exc;
        RandomAccessFile randomAccessFile;
        Throwable th;
        ImageUploadResult imageUploadResult;
        String str3;
        ImageUploadResult imageUploadResult2;
        File file;
        long length;
        RandomAccessFile randomAccessFile2;
        ImageUploadResult imageUploadResult3;
        int i3;
        StringBuilder sb2;
        byte[] bArr;
        long j;
        RandomAccessFile randomAccessFile3;
        ImageUploadResult imageUploadResult4;
        RandomAccessFile randomAccessFile4;
        String a2;
        String postMultiNetData;
        ImageUploadResult parser;
        ImageUploadResult imageUploadResult5;
        long j2;
        BitmapFactory.Options options;
        byte[] bArr2;
        long j3;
        long j4;
        String str4;
        NetWork netWork2;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            String str5 = str;
            String str6 = "    p = ";
            zm8.a("发帖：正在上传图片 = " + str5);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            boolean z3 = true;
            options2.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str5, options2);
            if (options2.outWidth != 0 && options2.outHeight != 0) {
                StringBuilder sb3 = new StringBuilder();
                RandomAccessFile randomAccessFile5 = null;
                ImageUploadResult imageUploadResult6 = null;
                RandomAccessFile randomAccessFile6 = null;
                NetWork netWork3 = null;
                try {
                    file = new File(str5);
                    length = file.length();
                    try {
                        try {
                        } catch (Exception e) {
                            exc = e;
                            randomAccessFile = null;
                            str2 = "    p = ";
                            sb = sb3;
                            c = 0;
                            netWork = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        netWork = null;
                    }
                } catch (Exception e2) {
                    str2 = "    p = ";
                    sb = sb3;
                    c = 0;
                    netWork = null;
                    exc = e2;
                } catch (Throwable th3) {
                    th = th3;
                    netWork = null;
                }
                if ((!z && length > 5242880) || (z && length > Config.FULL_TRACE_LOG_LIMIT)) {
                    ImageUploadResult imageUploadResult7 = new ImageUploadResult();
                    try {
                        imageUploadResult7.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult7.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0600);
                        zm8.a("发帖：正在上传图片 失败 限制大小 = " + length + "    p = " + str5);
                        lg.b(null);
                        this.h = null;
                        return imageUploadResult7;
                    } catch (Exception e3) {
                        e = e3;
                        randomAccessFile = null;
                        str2 = "    p = ";
                        sb = sb3;
                        c = 0;
                        imageUploadResult3 = imageUploadResult7;
                        netWork = null;
                    }
                } else {
                    zm8.a("发帖：正在上传图片 进行中 限制大小 = " + length + "    p = " + str5);
                    String b2 = ui.b(FileHelper.GetStreamFromFile(file));
                    sb3.append("path=");
                    sb3.append(str5);
                    sb3.append("|length=");
                    sb3.append(length);
                    sb3.append("|md5=");
                    sb3.append(b2);
                    long j5 = 0;
                    try {
                        if (length != 0 && b2 != null) {
                            String str7 = b2 + this.a;
                            long j6 = length % ((long) this.a) == 0 ? length / this.a : (length / this.a) + 1;
                            sb3.append("|chunkNo=");
                            sb3.append(j6);
                            try {
                                RandomAccessFile randomAccessFile7 = new RandomAccessFile(str5, "r");
                                try {
                                    try {
                                        sb3.append("|width=");
                                        sb3.append(this.b);
                                        sb3.append("|height=");
                                        sb3.append(this.c);
                                        sb3.append("|smallWidth=");
                                        sb3.append(this.d);
                                        sb3.append("|smallHeight=");
                                        sb3.append(this.e);
                                        sb3.append("|groupId=");
                                        sb3.append(this.g);
                                        int i6 = 1;
                                        int i7 = 0;
                                        imageUploadResult = null;
                                        byte[] bArr3 = null;
                                        while (true) {
                                            int i8 = (i6 > j6 ? 1 : (i6 == j6 ? 0 : -1));
                                            if (i8 > 0) {
                                                randomAccessFile = randomAccessFile7;
                                                netWork = null;
                                                break;
                                            }
                                            try {
                                                if (this.f == z3) {
                                                    break;
                                                }
                                                if (i8 > 0) {
                                                    j = j6;
                                                    sb2 = sb3;
                                                    i3 = 0;
                                                    bArr = null;
                                                } else {
                                                    if (i8 < 0) {
                                                        try {
                                                            try {
                                                                i3 = this.a;
                                                                sb2 = sb3;
                                                            } catch (Exception e4) {
                                                                e = e4;
                                                                randomAccessFile = randomAccessFile7;
                                                                str2 = str6;
                                                                sb = sb3;
                                                                imageUploadResult3 = imageUploadResult;
                                                                netWork = null;
                                                                c = 0;
                                                                exc = e;
                                                                imageUploadResult6 = imageUploadResult3;
                                                                if (!this.f) {
                                                                }
                                                                if (imageUploadResult6 != null) {
                                                                }
                                                                if (imageUploadResult2 != null) {
                                                                }
                                                                if (imageUploadResult2 == null) {
                                                                }
                                                                Object[] objArr = new Object[2];
                                                                objArr[c] = "comment";
                                                                objArr[1] = sb.toString();
                                                                kt4.a("img", -1L, -1, "imageUpload", r3, r2, objArr);
                                                                StringBuilder sb4 = new StringBuilder();
                                                                sb4.append("发帖：正在上传图片 上传失败 = ");
                                                                sb4.append(r3);
                                                                sb4.append(" ");
                                                                sb4.append(r2);
                                                                sb4.append(str2);
                                                                str3 = str;
                                                                sb4.append(str3);
                                                                zm8.a(sb4.toString());
                                                                lg.b(randomAccessFile);
                                                                this.h = netWork;
                                                                imageUploadResult = imageUploadResult2;
                                                                zm8.a("发帖：上传图片 结束      p = " + str3);
                                                                return imageUploadResult;
                                                            }
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            randomAccessFile5 = randomAccessFile7;
                                                            netWork = null;
                                                            th = th;
                                                            randomAccessFile6 = randomAccessFile5;
                                                            lg.b(randomAccessFile6);
                                                            this.h = netWork;
                                                            throw th;
                                                        }
                                                    } else if (i8 == 0) {
                                                        sb2 = sb3;
                                                        i3 = (int) (length - (this.a * (j6 - 1)));
                                                    } else {
                                                        sb2 = sb3;
                                                        i3 = 0;
                                                    }
                                                    if (bArr3 != null) {
                                                        bArr = bArr3;
                                                        try {
                                                        } catch (Exception e5) {
                                                            e = e5;
                                                            randomAccessFile = randomAccessFile7;
                                                            str2 = str6;
                                                            imageUploadResult3 = imageUploadResult;
                                                            sb = sb2;
                                                            netWork = null;
                                                            c = 0;
                                                            exc = e;
                                                            imageUploadResult6 = imageUploadResult3;
                                                            if (!this.f) {
                                                            }
                                                            if (imageUploadResult6 != null) {
                                                            }
                                                            if (imageUploadResult2 != null) {
                                                            }
                                                            if (imageUploadResult2 == null) {
                                                            }
                                                            Object[] objArr2 = new Object[2];
                                                            objArr2[c] = "comment";
                                                            objArr2[1] = sb.toString();
                                                            kt4.a("img", -1L, -1, "imageUpload", r3, r2, objArr2);
                                                            StringBuilder sb42 = new StringBuilder();
                                                            sb42.append("发帖：正在上传图片 上传失败 = ");
                                                            sb42.append(r3);
                                                            sb42.append(" ");
                                                            sb42.append(r2);
                                                            sb42.append(str2);
                                                            str3 = str;
                                                            sb42.append(str3);
                                                            zm8.a(sb42.toString());
                                                            lg.b(randomAccessFile);
                                                            this.h = netWork;
                                                            imageUploadResult = imageUploadResult2;
                                                            zm8.a("发帖：上传图片 结束      p = " + str3);
                                                            return imageUploadResult;
                                                        }
                                                    }
                                                    try {
                                                        bArr = new byte[i3];
                                                        j = j6;
                                                        randomAccessFile7.seek(this.a * (i6 - 1));
                                                        randomAccessFile7.read(bArr, 0, i3);
                                                    } catch (Exception e6) {
                                                        e = e6;
                                                        randomAccessFile = randomAccessFile7;
                                                        str2 = str6;
                                                        sb = sb2;
                                                        netWork = null;
                                                        c = 0;
                                                        exc = e;
                                                        imageUploadResult6 = imageUploadResult;
                                                        if (!this.f) {
                                                        }
                                                        if (imageUploadResult6 != null) {
                                                        }
                                                        if (imageUploadResult2 != null) {
                                                        }
                                                        if (imageUploadResult2 == null) {
                                                        }
                                                        Object[] objArr22 = new Object[2];
                                                        objArr22[c] = "comment";
                                                        objArr22[1] = sb.toString();
                                                        kt4.a("img", -1L, -1, "imageUpload", r3, r2, objArr22);
                                                        StringBuilder sb422 = new StringBuilder();
                                                        sb422.append("发帖：正在上传图片 上传失败 = ");
                                                        sb422.append(r3);
                                                        sb422.append(" ");
                                                        sb422.append(r2);
                                                        sb422.append(str2);
                                                        str3 = str;
                                                        sb422.append(str3);
                                                        zm8.a(sb422.toString());
                                                        lg.b(randomAccessFile);
                                                        this.h = netWork;
                                                        imageUploadResult = imageUploadResult2;
                                                        zm8.a("发帖：上传图片 结束      p = " + str3);
                                                        return imageUploadResult;
                                                    }
                                                }
                                                NetWork netWork4 = new NetWork(TbConfig.UPLOAD_IMG_URL);
                                                this.h = netWork4;
                                                netWork4.addPostData("resourceId", str7);
                                                this.h.addPostData("chunkNo", String.valueOf(i6));
                                                if (i8 >= 0) {
                                                    try {
                                                        randomAccessFile3 = randomAccessFile7;
                                                        try {
                                                            try {
                                                                this.h.addPostData("isFinish", String.valueOf(1));
                                                            } catch (Exception e7) {
                                                                e = e7;
                                                                exc = e;
                                                                imageUploadResult4 = imageUploadResult;
                                                                randomAccessFile = randomAccessFile3;
                                                                sb = sb2;
                                                                ImageUploadResult imageUploadResult8 = imageUploadResult4;
                                                                c = 0;
                                                                str2 = str6;
                                                                netWork = null;
                                                                imageUploadResult6 = imageUploadResult8;
                                                                if (!this.f) {
                                                                }
                                                                if (imageUploadResult6 != null) {
                                                                }
                                                                if (imageUploadResult2 != null) {
                                                                }
                                                                if (imageUploadResult2 == null) {
                                                                }
                                                                Object[] objArr222 = new Object[2];
                                                                objArr222[c] = "comment";
                                                                objArr222[1] = sb.toString();
                                                                kt4.a("img", -1L, -1, "imageUpload", r3, r2, objArr222);
                                                                StringBuilder sb4222 = new StringBuilder();
                                                                sb4222.append("发帖：正在上传图片 上传失败 = ");
                                                                sb4222.append(r3);
                                                                sb4222.append(" ");
                                                                sb4222.append(r2);
                                                                sb4222.append(str2);
                                                                str3 = str;
                                                                sb4222.append(str3);
                                                                zm8.a(sb4222.toString());
                                                                lg.b(randomAccessFile);
                                                                this.h = netWork;
                                                                imageUploadResult = imageUploadResult2;
                                                                zm8.a("发帖：上传图片 结束      p = " + str3);
                                                                return imageUploadResult;
                                                            }
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            th = th;
                                                            randomAccessFile4 = randomAccessFile3;
                                                            netWork = null;
                                                            randomAccessFile6 = randomAccessFile4;
                                                            lg.b(randomAccessFile6);
                                                            this.h = netWork;
                                                            throw th;
                                                        }
                                                    } catch (Exception e8) {
                                                        e = e8;
                                                        randomAccessFile3 = randomAccessFile7;
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        randomAccessFile3 = randomAccessFile7;
                                                        th = th;
                                                        randomAccessFile4 = randomAccessFile3;
                                                        netWork = null;
                                                        randomAccessFile6 = randomAccessFile4;
                                                        lg.b(randomAccessFile6);
                                                        this.h = netWork;
                                                        throw th;
                                                    }
                                                } else {
                                                    randomAccessFile3 = randomAccessFile7;
                                                    this.h.addPostData("isFinish", String.valueOf(0));
                                                }
                                                if (this.m) {
                                                    this.h.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(1));
                                                } else {
                                                    this.h.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(0));
                                                }
                                                this.h.addPostData("size", String.valueOf(length));
                                                this.h.addPostData("width", String.valueOf(options2.outWidth));
                                                this.h.addPostData("height", String.valueOf(options2.outHeight));
                                                if (this.d > 0 && this.e > 0) {
                                                    this.h.addPostData("smallWidth", String.valueOf(this.d));
                                                    this.h.addPostData("smallHeight", String.valueOf(this.e));
                                                }
                                                try {
                                                    try {
                                                        this.h.addPostData(TbEnum.SystemMessage.KEY_GROUP_ID, String.valueOf(this.g));
                                                        this.h.addPostData("alt", "json");
                                                        if (bArr != null) {
                                                            this.h.addPostData("chunk", bArr);
                                                        }
                                                        if (z) {
                                                            this.h.addPostData("saveOrigin", "1");
                                                        } else {
                                                            this.h.addPostData("saveOrigin", "0");
                                                        }
                                                        if (this.q != 0) {
                                                            this.h.addPostData("pic_water_type", String.valueOf(this.q));
                                                        }
                                                        if (z2) {
                                                            int b3 = bn4.c().b();
                                                            if (b3 != 0) {
                                                                this.h.addPostData("pic_water_type", String.valueOf(b3));
                                                            }
                                                            String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                                            if (!StringUtils.isNull(currentAccountName) && b3 == 1) {
                                                                this.h.addPostData("user_name", currentAccountName);
                                                            }
                                                            String a3 = bn4.c().a();
                                                            if (!StringUtils.isNull(a3)) {
                                                                if (b3 == 2) {
                                                                    this.h.addPostData("forum_name", a3);
                                                                }
                                                                a2 = bn4.c().a();
                                                                if (!StringUtils.isNull(a2)) {
                                                                    this.h.addPostData("small_flow_fname", a2);
                                                                }
                                                                postMultiNetData = this.h.postMultiNetData(true);
                                                                parser = ImageUploadResult.parser(postMultiNetData);
                                                                if (postMultiNetData != null || parser == null) {
                                                                    break;
                                                                    break;
                                                                }
                                                                try {
                                                                    if (parser.error_code != 0) {
                                                                        try {
                                                                            if (!ImageUploadResult.shouldReply(parser.error_code)) {
                                                                                break;
                                                                            }
                                                                        } catch (Exception e9) {
                                                                            exc = e9;
                                                                            imageUploadResult4 = parser;
                                                                            randomAccessFile = randomAccessFile3;
                                                                            sb = sb2;
                                                                            ImageUploadResult imageUploadResult82 = imageUploadResult4;
                                                                            c = 0;
                                                                            str2 = str6;
                                                                            netWork = null;
                                                                            imageUploadResult6 = imageUploadResult82;
                                                                            if (!this.f) {
                                                                            }
                                                                            if (imageUploadResult6 != null) {
                                                                            }
                                                                            if (imageUploadResult2 != null) {
                                                                            }
                                                                            if (imageUploadResult2 == null) {
                                                                            }
                                                                            Object[] objArr2222 = new Object[2];
                                                                            objArr2222[c] = "comment";
                                                                            objArr2222[1] = sb.toString();
                                                                            kt4.a("img", -1L, -1, "imageUpload", r3, r2, objArr2222);
                                                                            StringBuilder sb42222 = new StringBuilder();
                                                                            sb42222.append("发帖：正在上传图片 上传失败 = ");
                                                                            sb42222.append(r3);
                                                                            sb42222.append(" ");
                                                                            sb42222.append(r2);
                                                                            sb42222.append(str2);
                                                                            str3 = str;
                                                                            sb42222.append(str3);
                                                                            zm8.a(sb42222.toString());
                                                                            lg.b(randomAccessFile);
                                                                            this.h = netWork;
                                                                            imageUploadResult = imageUploadResult2;
                                                                            zm8.a("发帖：上传图片 结束      p = " + str3);
                                                                            return imageUploadResult;
                                                                        }
                                                                    }
                                                                    try {
                                                                        try {
                                                                            if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                                                zm8.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = " + parser.error_code + str6 + str5);
                                                                                if (i6 == parser.chunkNo || parser.chunkNo <= 0) {
                                                                                    break;
                                                                                }
                                                                                i6 = parser.chunkNo;
                                                                                imageUploadResult5 = parser;
                                                                                j4 = length;
                                                                                str4 = str7;
                                                                                i5 = i7 + 1;
                                                                                sb = sb2;
                                                                                c = 0;
                                                                                options = options2;
                                                                            } else {
                                                                                StringBuilder sb5 = sb2;
                                                                                try {
                                                                                    if (ImageUploadResult.shouldReply(parser.error_code)) {
                                                                                        sb = sb5;
                                                                                        imageUploadResult5 = parser;
                                                                                        j4 = length;
                                                                                        str4 = str7;
                                                                                        options = options2;
                                                                                        i5 = i7 + 1;
                                                                                        c = 0;
                                                                                    } else {
                                                                                        int i9 = i6 + 1;
                                                                                        j5 += i3;
                                                                                        long j7 = i9 > 1 ? j5 + ((i9 - 1) * this.a) : j5;
                                                                                        if (this.o != null) {
                                                                                            this.o.hasUploadFileSize += i3;
                                                                                        }
                                                                                        zm8.a("发帖：正在上传图片 已上传 = " + j7 + str6 + str5);
                                                                                        if (this.i != null) {
                                                                                            try {
                                                                                                RandomAccessFile randomAccessFile8 = randomAccessFile3;
                                                                                                j2 = j7;
                                                                                                options = options2;
                                                                                                long j8 = j;
                                                                                                bArr2 = bArr;
                                                                                                j3 = j8;
                                                                                                randomAccessFile = randomAccessFile8;
                                                                                                imageUploadResult5 = parser;
                                                                                                j4 = length;
                                                                                                sb = sb5;
                                                                                                str4 = str7;
                                                                                                netWork2 = null;
                                                                                            } catch (Exception e10) {
                                                                                                randomAccessFile = randomAccessFile3;
                                                                                                sb = sb5;
                                                                                                exc = e10;
                                                                                                str2 = str6;
                                                                                                imageUploadResult6 = parser;
                                                                                                netWork = null;
                                                                                                c = 0;
                                                                                            } catch (Throwable th7) {
                                                                                                th = th7;
                                                                                                randomAccessFile4 = randomAccessFile3;
                                                                                                netWork = null;
                                                                                                randomAccessFile6 = randomAccessFile4;
                                                                                                lg.b(randomAccessFile6);
                                                                                                this.h = netWork;
                                                                                                throw th;
                                                                                            }
                                                                                            try {
                                                                                                this.i.a(str, this.k, j2, j4);
                                                                                            } catch (Exception e11) {
                                                                                                exc = e11;
                                                                                                str2 = str6;
                                                                                                imageUploadResult6 = imageUploadResult5;
                                                                                                c = 0;
                                                                                                netWork = null;
                                                                                            } catch (Throwable th8) {
                                                                                                th = th8;
                                                                                                netWork = null;
                                                                                                randomAccessFile6 = randomAccessFile;
                                                                                                lg.b(randomAccessFile6);
                                                                                                this.h = netWork;
                                                                                                throw th;
                                                                                            }
                                                                                        } else {
                                                                                            imageUploadResult5 = parser;
                                                                                            j4 = length;
                                                                                            str4 = str7;
                                                                                            sb = sb5;
                                                                                            netWork2 = null;
                                                                                            options = options2;
                                                                                            long j9 = j;
                                                                                            bArr2 = bArr;
                                                                                            randomAccessFile = randomAccessFile3;
                                                                                            j3 = j9;
                                                                                            j2 = j7;
                                                                                        }
                                                                                        try {
                                                                                            if (this.j != null) {
                                                                                                long j10 = j2;
                                                                                                str2 = str6;
                                                                                                c = 0;
                                                                                                netWork = netWork2;
                                                                                                i4 = i9;
                                                                                                this.j.a(str, this.k, j10, j4, i, i2);
                                                                                            } else {
                                                                                                i4 = i9;
                                                                                                str2 = str6;
                                                                                                c = 0;
                                                                                                netWork = netWork2;
                                                                                            }
                                                                                            i6 = i4;
                                                                                            i5 = i7;
                                                                                            if (i5 > this.p) {
                                                                                                sb.append("|possbile dead loop found. tryCount=");
                                                                                                sb.append(i5);
                                                                                                sb.append(", chunkNo=");
                                                                                                sb.append(j3);
                                                                                                break;
                                                                                            }
                                                                                            i7 = i5;
                                                                                            j6 = j3;
                                                                                            imageUploadResult = imageUploadResult5;
                                                                                            str7 = str4;
                                                                                            str6 = str2;
                                                                                            options2 = options;
                                                                                            bArr3 = bArr2;
                                                                                            randomAccessFile7 = randomAccessFile;
                                                                                            length = j4;
                                                                                            z3 = true;
                                                                                            sb3 = sb;
                                                                                            str5 = str;
                                                                                        } catch (Exception e12) {
                                                                                            e = e12;
                                                                                            str2 = str6;
                                                                                            c = 0;
                                                                                            netWork = netWork2;
                                                                                            exc = e;
                                                                                            imageUploadResult6 = imageUploadResult5;
                                                                                            if (!this.f) {
                                                                                            }
                                                                                            if (imageUploadResult6 != null) {
                                                                                            }
                                                                                            if (imageUploadResult2 != null) {
                                                                                            }
                                                                                            if (imageUploadResult2 == null) {
                                                                                            }
                                                                                            Object[] objArr22222 = new Object[2];
                                                                                            objArr22222[c] = "comment";
                                                                                            objArr22222[1] = sb.toString();
                                                                                            kt4.a("img", -1L, -1, "imageUpload", r3, r2, objArr22222);
                                                                                            StringBuilder sb422222 = new StringBuilder();
                                                                                            sb422222.append("发帖：正在上传图片 上传失败 = ");
                                                                                            sb422222.append(r3);
                                                                                            sb422222.append(" ");
                                                                                            sb422222.append(r2);
                                                                                            sb422222.append(str2);
                                                                                            str3 = str;
                                                                                            sb422222.append(str3);
                                                                                            zm8.a(sb422222.toString());
                                                                                            lg.b(randomAccessFile);
                                                                                            this.h = netWork;
                                                                                            imageUploadResult = imageUploadResult2;
                                                                                            zm8.a("发帖：上传图片 结束      p = " + str3);
                                                                                            return imageUploadResult;
                                                                                        } catch (Throwable th9) {
                                                                                            th = th9;
                                                                                            netWork = netWork2;
                                                                                            th = th;
                                                                                            randomAccessFile6 = randomAccessFile;
                                                                                            lg.b(randomAccessFile6);
                                                                                            this.h = netWork;
                                                                                            throw th;
                                                                                        }
                                                                                    }
                                                                                } catch (Exception e13) {
                                                                                    e = e13;
                                                                                    sb = sb5;
                                                                                    imageUploadResult5 = parser;
                                                                                    randomAccessFile = randomAccessFile3;
                                                                                    c = 0;
                                                                                    str2 = str6;
                                                                                    netWork = null;
                                                                                    exc = e;
                                                                                    imageUploadResult6 = imageUploadResult5;
                                                                                    if (!this.f) {
                                                                                    }
                                                                                    if (imageUploadResult6 != null) {
                                                                                    }
                                                                                    if (imageUploadResult2 != null) {
                                                                                    }
                                                                                    if (imageUploadResult2 == null) {
                                                                                    }
                                                                                    Object[] objArr222222 = new Object[2];
                                                                                    objArr222222[c] = "comment";
                                                                                    objArr222222[1] = sb.toString();
                                                                                    kt4.a("img", -1L, -1, "imageUpload", r3, r2, objArr222222);
                                                                                    StringBuilder sb4222222 = new StringBuilder();
                                                                                    sb4222222.append("发帖：正在上传图片 上传失败 = ");
                                                                                    sb4222222.append(r3);
                                                                                    sb4222222.append(" ");
                                                                                    sb4222222.append(r2);
                                                                                    sb4222222.append(str2);
                                                                                    str3 = str;
                                                                                    sb4222222.append(str3);
                                                                                    zm8.a(sb4222222.toString());
                                                                                    lg.b(randomAccessFile);
                                                                                    this.h = netWork;
                                                                                    imageUploadResult = imageUploadResult2;
                                                                                    zm8.a("发帖：上传图片 结束      p = " + str3);
                                                                                    return imageUploadResult;
                                                                                }
                                                                            }
                                                                            if (i5 > this.p) {
                                                                            }
                                                                        } catch (Exception e14) {
                                                                            e = e14;
                                                                            exc = e;
                                                                            imageUploadResult6 = imageUploadResult5;
                                                                            if (!this.f) {
                                                                            }
                                                                            if (imageUploadResult6 != null) {
                                                                            }
                                                                            if (imageUploadResult2 != null) {
                                                                            }
                                                                            if (imageUploadResult2 == null) {
                                                                            }
                                                                            Object[] objArr2222222 = new Object[2];
                                                                            objArr2222222[c] = "comment";
                                                                            objArr2222222[1] = sb.toString();
                                                                            kt4.a("img", -1L, -1, "imageUpload", r3, r2, objArr2222222);
                                                                            StringBuilder sb42222222 = new StringBuilder();
                                                                            sb42222222.append("发帖：正在上传图片 上传失败 = ");
                                                                            sb42222222.append(r3);
                                                                            sb42222222.append(" ");
                                                                            sb42222222.append(r2);
                                                                            sb42222222.append(str2);
                                                                            str3 = str;
                                                                            sb42222222.append(str3);
                                                                            zm8.a(sb42222222.toString());
                                                                            lg.b(randomAccessFile);
                                                                            this.h = netWork;
                                                                            imageUploadResult = imageUploadResult2;
                                                                            zm8.a("发帖：上传图片 结束      p = " + str3);
                                                                            return imageUploadResult;
                                                                        }
                                                                    } catch (Throwable th10) {
                                                                        th = th10;
                                                                        th = th;
                                                                        randomAccessFile6 = randomAccessFile;
                                                                        lg.b(randomAccessFile6);
                                                                        this.h = netWork;
                                                                        throw th;
                                                                    }
                                                                    RandomAccessFile randomAccessFile9 = randomAccessFile3;
                                                                    str2 = str6;
                                                                    netWork = null;
                                                                    long j11 = j;
                                                                    bArr2 = bArr;
                                                                    randomAccessFile = randomAccessFile9;
                                                                    j3 = j11;
                                                                } catch (Exception e15) {
                                                                    e = e15;
                                                                    imageUploadResult5 = parser;
                                                                    randomAccessFile = randomAccessFile3;
                                                                    sb = sb2;
                                                                }
                                                            }
                                                        }
                                                        a2 = bn4.c().a();
                                                        if (!StringUtils.isNull(a2)) {
                                                        }
                                                        postMultiNetData = this.h.postMultiNetData(true);
                                                        parser = ImageUploadResult.parser(postMultiNetData);
                                                        if (postMultiNetData != null) {
                                                            break;
                                                        }
                                                        if (parser.error_code != 0) {
                                                        }
                                                        if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                        }
                                                        RandomAccessFile randomAccessFile92 = randomAccessFile3;
                                                        str2 = str6;
                                                        netWork = null;
                                                        long j112 = j;
                                                        bArr2 = bArr;
                                                        randomAccessFile = randomAccessFile92;
                                                        j3 = j112;
                                                        if (i5 > this.p) {
                                                        }
                                                    } catch (Throwable th11) {
                                                        th = th11;
                                                        randomAccessFile = randomAccessFile3;
                                                        netWork = null;
                                                        th = th;
                                                        randomAccessFile6 = randomAccessFile;
                                                        lg.b(randomAccessFile6);
                                                        this.h = netWork;
                                                        throw th;
                                                    }
                                                } catch (Exception e16) {
                                                    e = e16;
                                                    randomAccessFile = randomAccessFile3;
                                                    sb = sb2;
                                                    c = 0;
                                                    str2 = str6;
                                                    netWork = null;
                                                    exc = e;
                                                    imageUploadResult6 = imageUploadResult;
                                                    if (!this.f) {
                                                    }
                                                    if (imageUploadResult6 != null) {
                                                    }
                                                    if (imageUploadResult2 != null) {
                                                    }
                                                    if (imageUploadResult2 == null) {
                                                    }
                                                    Object[] objArr22222222 = new Object[2];
                                                    objArr22222222[c] = "comment";
                                                    objArr22222222[1] = sb.toString();
                                                    kt4.a("img", -1L, -1, "imageUpload", r3, r2, objArr22222222);
                                                    StringBuilder sb422222222 = new StringBuilder();
                                                    sb422222222.append("发帖：正在上传图片 上传失败 = ");
                                                    sb422222222.append(r3);
                                                    sb422222222.append(" ");
                                                    sb422222222.append(r2);
                                                    sb422222222.append(str2);
                                                    str3 = str;
                                                    sb422222222.append(str3);
                                                    zm8.a(sb422222222.toString());
                                                    lg.b(randomAccessFile);
                                                    this.h = netWork;
                                                    imageUploadResult = imageUploadResult2;
                                                    zm8.a("发帖：上传图片 结束      p = " + str3);
                                                    return imageUploadResult;
                                                }
                                            } catch (Exception e17) {
                                                e = e17;
                                                randomAccessFile = randomAccessFile7;
                                                str2 = str6;
                                                sb = sb3;
                                            }
                                        }
                                        imageUploadResult = imageUploadResult5;
                                        randomAccessFile2 = randomAccessFile;
                                        lg.b(randomAccessFile2);
                                        this.h = netWork;
                                        str3 = str;
                                    } catch (Exception e18) {
                                        randomAccessFile = randomAccessFile7;
                                        str2 = "    p = ";
                                        sb = sb3;
                                        netWork = null;
                                        c = 0;
                                        exc = e18;
                                        imageUploadResult6 = null;
                                    }
                                } catch (Throwable th12) {
                                    th = th12;
                                    randomAccessFile = randomAccessFile7;
                                }
                            } catch (Exception e19) {
                                e = e19;
                                str2 = "    p = ";
                                sb = sb3;
                                netWork = null;
                                c = 0;
                                exc = e;
                                netWork3 = netWork;
                                randomAccessFile = netWork3;
                                imageUploadResult6 = netWork3;
                                if (!this.f) {
                                }
                                if (imageUploadResult6 != null) {
                                }
                                if (imageUploadResult2 != null) {
                                }
                                if (imageUploadResult2 == null) {
                                }
                                Object[] objArr222222222 = new Object[2];
                                objArr222222222[c] = "comment";
                                objArr222222222[1] = sb.toString();
                                kt4.a("img", -1L, -1, "imageUpload", r3, r2, objArr222222222);
                                StringBuilder sb4222222222 = new StringBuilder();
                                sb4222222222.append("发帖：正在上传图片 上传失败 = ");
                                sb4222222222.append(r3);
                                sb4222222222.append(" ");
                                sb4222222222.append(r2);
                                sb4222222222.append(str2);
                                str3 = str;
                                sb4222222222.append(str3);
                                zm8.a(sb4222222222.toString());
                                lg.b(randomAccessFile);
                                this.h = netWork;
                                imageUploadResult = imageUploadResult2;
                                zm8.a("发帖：上传图片 结束      p = " + str3);
                                return imageUploadResult;
                            } catch (Throwable th13) {
                                th = th13;
                                netWork = null;
                                th = th;
                                randomAccessFile6 = netWork;
                                lg.b(randomAccessFile6);
                                this.h = netWork;
                                throw th;
                            }
                            zm8.a("发帖：上传图片 结束      p = " + str3);
                            return imageUploadResult;
                        }
                        ImageUploadResult imageUploadResult9 = new ImageUploadResult();
                        imageUploadResult9.error_code = -1007;
                        imageUploadResult9.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f05fe);
                        TiebaStatic.imgError(-1007, "file error: " + imageUploadResult9.error_msg, sb.toString());
                        imageUploadResult = imageUploadResult9;
                        randomAccessFile2 = null;
                        lg.b(randomAccessFile2);
                        this.h = netWork;
                        str3 = str;
                        zm8.a("发帖：上传图片 结束      p = " + str3);
                        return imageUploadResult;
                    } catch (Throwable th14) {
                        th = th14;
                        th = th;
                        randomAccessFile6 = netWork;
                        lg.b(randomAccessFile6);
                        this.h = netWork;
                        throw th;
                    }
                    str2 = "    p = ";
                    sb = sb3;
                    c = 0;
                    netWork = null;
                }
                exc = e;
                imageUploadResult6 = imageUploadResult3;
                if (!this.f) {
                    sb.append("|request cancelled.");
                } else {
                    BdLog.e(exc.getMessage());
                }
                if (imageUploadResult6 != null) {
                    imageUploadResult2 = new ImageUploadResult();
                    imageUploadResult2.error_code = -1002;
                    imageUploadResult2.error_msg = exc.getMessage();
                } else {
                    imageUploadResult2 = imageUploadResult6;
                }
                int i10 = imageUploadResult2 != null ? imageUploadResult2.error_code : -1002;
                String message = imageUploadResult2 == null ? imageUploadResult2.error_msg : exc.getMessage();
                Object[] objArr2222222222 = new Object[2];
                objArr2222222222[c] = "comment";
                objArr2222222222[1] = sb.toString();
                kt4.a("img", -1L, -1, "imageUpload", i10, message, objArr2222222222);
                StringBuilder sb42222222222 = new StringBuilder();
                sb42222222222.append("发帖：正在上传图片 上传失败 = ");
                sb42222222222.append(i10);
                sb42222222222.append(" ");
                sb42222222222.append(message);
                sb42222222222.append(str2);
                str3 = str;
                sb42222222222.append(str3);
                zm8.a(sb42222222222.toString());
                lg.b(randomAccessFile);
                this.h = netWork;
                imageUploadResult = imageUploadResult2;
                zm8.a("发帖：上传图片 结束      p = " + str3);
                return imageUploadResult;
            }
            zm8.a("发帖：正在上传图片 失败 = " + str5);
            ImageUploadResult imageUploadResult10 = new ImageUploadResult();
            imageUploadResult10.error_code = -1007;
            imageUploadResult10.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0600);
            return imageUploadResult10;
        }
        return (ImageUploadResult) invokeCommon.objValue;
    }

    public void o(WriteImagesInfo writeImagesInfo, boolean z) {
        UploadedImageInfo uploadedPicInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048590, this, writeImagesInfo, z) == null) || writeImagesInfo == null || writeImagesInfo.size() == 0) {
            return;
        }
        LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
        for (int i = 0; i < chosedFiles.size(); i++) {
            ImageFileInfo imageFileInfo = chosedFiles.get(i);
            if (imageFileInfo != null && !imageFileInfo.isAlreadyUploadedToServer()) {
                if (this.f) {
                    return;
                }
                ImageUploadResult j = j(imageFileInfo, writeImagesInfo.isOriginalImg() || imageFileInfo.isGif(), z);
                if (j != null && (uploadedPicInfo = j.getUploadedPicInfo()) != null) {
                    imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                    imageFileInfo.serverPicInfo = j.picInfo;
                }
            }
        }
    }

    public ErrorData p(WriteImagesInfo writeImagesInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, writeImagesInfo, z)) == null) {
            o35 o35Var = this;
            zm8.a("发帖： 上传批量图片到server");
            ErrorData errorData = new ErrorData();
            if (writeImagesInfo != null && writeImagesInfo.size() != 0) {
                LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
                o35Var.o = writeImagesInfo;
                int i = 0;
                writeImagesInfo.allImageFileSize = 0;
                writeImagesInfo.hasUploadFileSize = 0;
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < chosedFiles.size(); i2++) {
                    ImageFileInfo imageFileInfo = chosedFiles.get(i2);
                    if (!imageFileInfo.isAlreadyUploadedToServer()) {
                        File file = new File(imageFileInfo.getFilePath());
                        if (imageFileInfo.getImageType() == 1) {
                            linkedList.add(imageFileInfo);
                        } else if (file.exists()) {
                            writeImagesInfo.allImageFileSize = (int) (writeImagesInfo.allImageFileSize + file.length());
                            linkedList.add(imageFileInfo);
                        }
                    }
                }
                o35Var.p = writeImagesInfo.imageChunkRetry;
                if (o35Var.n.getAsyncPublishStatData() != null && o35Var.n.startPublishTime() > 0 && writeImagesInfo.needImageParallel) {
                    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(writeImagesInfo.imageUploadConcurrency);
                    q35 q35Var = new q35();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    while (i < linkedList.size()) {
                        p35 p35Var = new p35(q35Var, linkedList, writeImagesInfo, z, i);
                        p35Var.c(o35Var.n);
                        ArrayList arrayList3 = arrayList;
                        p35Var.b(o35Var.a, o35Var.b, o35Var.c, o35Var.d, o35Var.e, o35Var.f, o35Var.q, o35Var.g, o35Var.i, o35Var.j, o35Var.k, o35Var.m, o35Var.p);
                        arrayList2.add(p35Var);
                        arrayList3.add(new FutureTask<>(p35Var));
                        i++;
                        o35Var = this;
                        arrayList = arrayList3;
                        linkedList = linkedList;
                        newFixedThreadPool = newFixedThreadPool;
                        q35Var = q35Var;
                    }
                    ExecutorService executorService = newFixedThreadPool;
                    q35 q35Var2 = q35Var;
                    ArrayList<FutureTask<Boolean>> arrayList4 = arrayList;
                    q35Var2.c(arrayList4);
                    q35Var2.b(arrayList2);
                    for (FutureTask<Boolean> futureTask : arrayList4) {
                        executorService.submit(futureTask);
                    }
                    for (FutureTask<Boolean> futureTask2 : arrayList4) {
                        try {
                            futureTask2.get();
                        } catch (Exception unused) {
                        }
                    }
                    executorService.shutdown();
                    return q35Var2.c;
                }
                LinkedList linkedList2 = linkedList;
                int i3 = 0;
                while (i3 < linkedList2.size()) {
                    LinkedList linkedList3 = linkedList2;
                    ImageFileInfo imageFileInfo2 = (ImageFileInfo) linkedList3.get(i3);
                    imageFileInfo2.setTempUploadFileName(null);
                    zm8.a("发帖：发送图片 上传图片 = " + i3 + " = " + imageFileInfo2.toJson().toString());
                    if (this.f) {
                        break;
                    }
                    boolean isOriginalImg = imageFileInfo2.getImageType() == 1 ? false : writeImagesInfo.isOriginalImg();
                    xm8.m(this.n, imageFileInfo2);
                    int i4 = i3 + 1;
                    ImageUploadResult k = k(imageFileInfo2, isOriginalImg, z, i4, linkedList3.size());
                    xm8.d(this.n, imageFileInfo2, k);
                    if (k != null) {
                        UploadedImageInfo uploadedPicInfo = k.getUploadedPicInfo();
                        if (uploadedPicInfo != null && !TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                            uploadedPicInfo.isGif = imageFileInfo2.isGif();
                            uploadedPicInfo.isBJH = this.m;
                            imageFileInfo2.setServerImageCode(uploadedPicInfo.toPostString());
                            linkedList2 = linkedList3;
                            i3 = i4;
                        } else {
                            errorData.setError_code(k.error_code);
                            errorData.setError_msg(k.error_msg);
                            zm8.a("发帖：发送图片 上传图片 错误 1= " + i3 + " = " + imageFileInfo2.toJson().toString());
                            return errorData;
                        }
                    } else {
                        errorData.setError_code(-52);
                        errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1498));
                        zm8.a("发帖：发送图片 上传图片 错误 2= " + i3 + " = " + imageFileInfo2.toJson().toString());
                        return errorData;
                    }
                }
                zm8.a("发帖：发送图片 上传图片 成功返回");
                return null;
            }
            errorData.setError_code(-1002);
            errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1498));
            zm8.a("发帖：发送图片 上传图片 错误 无图");
            return errorData;
        }
        return (ErrorData) invokeLZ.objValue;
    }
}
