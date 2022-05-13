package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.push.ac;
import com.xiaomi.push.bm;
import com.xiaomi.push.bq;
import com.xiaomi.push.h;
import com.xiaomi.push.y;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes8.dex */
public class a implements IEventProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f23a;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) ? String.valueOf(aVar.production) : (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0074 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0076 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x000f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x0067 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x006a */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because magicNumber error");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
        com.xiaomi.channel.commonutils.logger.b.d(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
        r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K";
        r4 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<String> a(String str) {
        InterceptResult invokeL;
        char c;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            byte[] bArr = new byte[4];
            byte[] bArr2 = new byte[4];
            FileInputStream fileInputStream = null;
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    FileInputStream fileInputStream3 = new FileInputStream(new File(str));
                    while (true) {
                        try {
                            int read = fileInputStream3.read(bArr);
                            c = -1;
                            c = -1;
                            c = -1;
                            c = -1;
                            if (read == -1) {
                                break;
                            } else if (read != 4 || ac.a(bArr) != -573785174) {
                                break;
                            } else {
                                int read2 = fileInputStream3.read(bArr2);
                                if (read2 == -1) {
                                    break;
                                } else if (read2 == 4) {
                                    int a = ac.a(bArr2);
                                    char c2 = 1;
                                    if (a < 1) {
                                        break;
                                    }
                                    c2 = 4096;
                                    if (a > 4096) {
                                        break;
                                    }
                                    byte[] bArr3 = new byte[a];
                                    if (fileInputStream3.read(bArr3) != a) {
                                        str2 = "eventData read from cache file failed cause buffer size not equal length";
                                        c = bArr3;
                                        break;
                                    }
                                    String bytesToString = bytesToString(bArr3);
                                    if (!TextUtils.isEmpty(bytesToString)) {
                                        arrayList.add(bytesToString);
                                    }
                                } else {
                                    str2 = "eventData read from cache file failed cause lengthBuffer error";
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            fileInputStream2 = fileInputStream3;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            y.a(fileInputStream2);
                            fileInputStream = fileInputStream2;
                            return arrayList;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream3;
                            y.a(fileInputStream);
                            throw th;
                        }
                    }
                    y.a(fileInputStream3);
                    fileInputStream = c;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private void a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, randomAccessFile, fileLock) == null) {
            if (fileLock != null && fileLock.isValid()) {
                try {
                    fileLock.release();
                } catch (IOException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            y.a(randomAccessFile);
        }
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2) == null) {
            com.xiaomi.clientreport.manager.a a = com.xiaomi.clientreport.manager.a.a(this.a);
            EventClientReport a2 = a.a(5001, "24:" + str + "," + str2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(a2.toJsonString());
            a(arrayList);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x00a1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x00a3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:65:0x00bc */
    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: com.xiaomi.clientreport.processor.a */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.nio.channels.FileLock */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.nio.channels.FileLock */
    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: java.nio.channels.FileLock */
    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.nio.channels.FileLock */
    /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: java.nio.channels.FileLock */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00c4: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:49:0x00c4 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v7 */
    private com.xiaomi.clientreport.data.a[] a(com.xiaomi.clientreport.data.a[] aVarArr) {
        InterceptResult invokeL;
        Closeable closeable;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65541, this, aVarArr)) != null) {
            return (com.xiaomi.clientreport.data.a[]) invokeL.objValue;
        }
        String b = b(aVarArr[0]);
        FileLock isEmpty = TextUtils.isEmpty(b);
        Closeable closeable2 = null;
        try {
            if (isEmpty != 0) {
                return null;
            }
            try {
                File file = new File(b + ".lock");
                y.m682a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    isEmpty = randomAccessFile.getChannel().lock();
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(b), true));
                        try {
                            int i = 0;
                            for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                                if (aVar != null) {
                                    byte[] stringToBytes = stringToBytes(aVar.toJsonString());
                                    if (stringToBytes != null && stringToBytes.length >= 1 && stringToBytes.length <= 4096) {
                                        if (!bq.m225a(this.a, b)) {
                                            int length = aVarArr.length - i;
                                            com.xiaomi.clientreport.data.a[] aVarArr2 = new com.xiaomi.clientreport.data.a[length];
                                            System.arraycopy(aVarArr, i, aVarArr2, 0, length);
                                            y.a(bufferedOutputStream);
                                            a(randomAccessFile, (FileLock) isEmpty);
                                            return aVarArr2;
                                        }
                                        bufferedOutputStream.write(ac.a(-573785174));
                                        bufferedOutputStream.write(ac.a(stringToBytes.length));
                                        bufferedOutputStream.write(stringToBytes);
                                        bufferedOutputStream.flush();
                                        i++;
                                    }
                                    com.xiaomi.channel.commonutils.logger.b.d("event data throw a invalid item ");
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            com.xiaomi.channel.commonutils.logger.b.a("event data write to cache file failed cause exception", e);
                            y.a(bufferedOutputStream);
                            a(randomAccessFile, isEmpty);
                            return null;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        y.a(closeable2);
                        a(randomAccessFile, isEmpty);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    isEmpty = 0;
                    bufferedOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    isEmpty = 0;
                }
            } catch (Exception e4) {
                e = e4;
                isEmpty = 0;
                randomAccessFile = null;
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                isEmpty = 0;
                randomAccessFile = null;
            }
            y.a(bufferedOutputStream);
            a(randomAccessFile, isEmpty);
            return null;
        } catch (Throwable th4) {
            th = th4;
            closeable2 = closeable;
        }
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, aVar)) == null) {
            File externalFilesDir = this.a.getExternalFilesDir("event");
            String a = a(aVar);
            if (externalFilesDir == null) {
                return null;
            }
            String str = externalFilesDir.getAbsolutePath() + File.separator + a;
            for (int i = 0; i < 100; i++) {
                String str2 = str + i;
                if (bq.m225a(this.a, str2)) {
                    return str2;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        int i;
        RandomAccessFile randomAccessFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            bq.a(this.a, "event", "eventUploading");
            File[] m226a = bq.m226a(this.a, "eventUploading");
            if (m226a == null || m226a.length <= 0) {
                return;
            }
            int length = m226a.length;
            FileLock fileLock = null;
            RandomAccessFile randomAccessFile2 = null;
            File file = null;
            while (i < length) {
                File file2 = m226a[i];
                if (file2 == null) {
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e) {
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                        }
                    }
                    y.a(randomAccessFile2);
                    i = file == null ? i + 1 : 0;
                    file.delete();
                } else {
                    try {
                        try {
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                    if (file2.length() > 5242880) {
                        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                        a(file2.getName(), Formatter.formatFileSize(this.a, file2.length()));
                        file2.delete();
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e3) {
                                com.xiaomi.channel.commonutils.logger.b.a(e3);
                            }
                        }
                        y.a(randomAccessFile2);
                        if (file == null) {
                        }
                        file.delete();
                    } else {
                        String absolutePath = file2.getAbsolutePath();
                        File file3 = new File(absolutePath + ".lock");
                        try {
                            y.m682a(file3);
                            randomAccessFile = new RandomAccessFile(file3, "rw");
                        } catch (Exception e4) {
                            e = e4;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            fileLock = randomAccessFile.getChannel().lock();
                            a(a(absolutePath));
                            file2.delete();
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e5) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e5);
                                }
                            }
                            y.a(randomAccessFile);
                            file3.delete();
                            randomAccessFile2 = randomAccessFile;
                            file = file3;
                        } catch (Exception e6) {
                            e = e6;
                            randomAccessFile2 = randomAccessFile;
                            file = file3;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e7) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e7);
                                }
                            }
                            y.a(randomAccessFile2);
                            if (file == null) {
                            }
                            file.delete();
                        } catch (Throwable th3) {
                            th = th3;
                            randomAccessFile2 = randomAccessFile;
                            file = file3;
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e8) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e8);
                                }
                            }
                            y.a(randomAccessFile2);
                            if (file != null) {
                                file.delete();
                            }
                            throw th;
                        }
                    }
                }
            }
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.a = context;
        }
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a  reason: collision with other method in class */
    public void mo117a(com.xiaomi.clientreport.data.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) && (aVar instanceof EventClientReport) && this.f23a != null) {
            EventClientReport eventClientReport = (EventClientReport) aVar;
            String a = a((com.xiaomi.clientreport.data.a) eventClientReport);
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f23a.get(a);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(eventClientReport);
            this.f23a.put(a, arrayList);
        }
    }

    public void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            bq.a(this.a, list);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m118a(com.xiaomi.clientreport.data.a[] aVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVarArr) == null) {
            if (aVarArr == null || aVarArr.length == 0 || aVarArr[0] == null) {
                com.xiaomi.channel.commonutils.logger.b.m109a("event data write to cache file failed because data null");
                return;
            }
            do {
                aVarArr = a(aVarArr);
                if (aVarArr == null || aVarArr.length <= 0) {
                    return;
                }
            } while (aVarArr[0] != null);
        }
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (hashMap = this.f23a) == null) {
            return;
        }
        if (hashMap.size() > 0) {
            for (String str : this.f23a.keySet()) {
                ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f23a.get(str);
                if (arrayList != null && arrayList.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[arrayList.size()];
                    arrayList.toArray(aVarArr);
                    m118a(aVarArr);
                }
            }
        }
        this.f23a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public String bytesToString(byte[] bArr) {
        InterceptResult invokeL;
        byte[] a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            if (bArr != null && bArr.length >= 1) {
                if (!com.xiaomi.clientreport.manager.a.a(this.a).m114a().isEventEncrypted()) {
                    return bm.a(bArr);
                }
                String a2 = bq.a(this.a);
                if (!TextUtils.isEmpty(a2) && (a = bq.a(a2)) != null && a.length > 0) {
                    try {
                        return bm.a(Base64.decode(h.a(a, bArr), 2));
                    } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hashMap) == null) {
            this.f23a = hashMap;
        }
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public byte[] stringToBytes(String str) {
        InterceptResult invokeL;
        byte[] a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (com.xiaomi.clientreport.manager.a.a(this.a).m114a().isEventEncrypted()) {
                String a2 = bq.a(this.a);
                byte[] m221a = bm.m221a(str);
                if (!TextUtils.isEmpty(a2) && m221a != null && m221a.length > 1 && (a = bq.a(a2)) != null) {
                    try {
                        if (a.length > 1) {
                            return h.b(a, Base64.encode(m221a, 2));
                        }
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
                return null;
            }
            return bm.m221a(str);
        }
        return (byte[]) invokeL.objValue;
    }
}
