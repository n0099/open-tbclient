package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.qq.e.comm.constants.ErrorCode;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.push.ac;
import com.xiaomi.push.bm;
import com.xiaomi.push.bq;
import com.xiaomi.push.h;
import com.xiaomi.push.y;
import java.io.BufferedOutputStream;
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
/* loaded from: classes7.dex */
public class a implements IEventProcessor {

    /* renamed from: a  reason: collision with root package name */
    public Context f37278a;

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f39a;

    public a(Context context) {
        a(context);
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        return String.valueOf(aVar.production);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0070 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0072 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x000b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x0063 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x0066 */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        com.xiaomi.channel.commonutils.logger.b.d(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0063, code lost:
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
        char c2;
        String str2;
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
                        c2 = -1;
                        c2 = -1;
                        c2 = -1;
                        c2 = -1;
                        if (read == -1) {
                            break;
                        } else if (read != 4 || ac.a(bArr) != -573785174) {
                            break;
                        } else {
                            int read2 = fileInputStream3.read(bArr2);
                            if (read2 == -1) {
                                break;
                            } else if (read2 == 4) {
                                int a2 = ac.a(bArr2);
                                char c3 = 1;
                                if (a2 < 1) {
                                    break;
                                }
                                c3 = 4096;
                                if (a2 > 4096) {
                                    break;
                                }
                                byte[] bArr3 = new byte[a2];
                                if (fileInputStream3.read(bArr3) != a2) {
                                    str2 = "eventData read from cache file failed cause buffer size not equal length";
                                    c2 = bArr3;
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
                    } catch (Exception e2) {
                        e = e2;
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
                com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because magicNumber error");
                y.a(fileInputStream3);
                fileInputStream = c2;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        return arrayList;
    }

    private void a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
        y.a(randomAccessFile);
    }

    private void a(String str, String str2) {
        com.xiaomi.clientreport.manager.a a2 = com.xiaomi.clientreport.manager.a.a(this.f37278a);
        EventClientReport a3 = a2.a(ErrorCode.SERVER_JSON_PARSE_ERROR, "24:" + str + "," + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a3.toJsonString());
        a(arrayList);
    }

    private com.xiaomi.clientreport.data.a[] a(com.xiaomi.clientreport.data.a[] aVarArr) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        String b2 = b(aVarArr[0]);
        BufferedOutputStream bufferedOutputStream2 = null;
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        try {
            File file = new File(b2 + ".lock");
            y.m630a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
            } catch (Exception e2) {
                e = e2;
                fileLock = null;
                bufferedOutputStream = null;
            } catch (Throwable th) {
                th = th;
                fileLock = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileLock = null;
            randomAccessFile = null;
            bufferedOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileLock = null;
            randomAccessFile = null;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(b2), true));
            try {
                try {
                    int i2 = 0;
                    for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                        if (aVar != null) {
                            byte[] stringToBytes = stringToBytes(aVar.toJsonString());
                            if (stringToBytes != null && stringToBytes.length >= 1 && stringToBytes.length <= 4096) {
                                if (!bq.m173a(this.f37278a, b2)) {
                                    int length = aVarArr.length - i2;
                                    com.xiaomi.clientreport.data.a[] aVarArr2 = new com.xiaomi.clientreport.data.a[length];
                                    System.arraycopy(aVarArr, i2, aVarArr2, 0, length);
                                    y.a(bufferedOutputStream);
                                    a(randomAccessFile, fileLock);
                                    return aVarArr2;
                                }
                                bufferedOutputStream.write(ac.a(-573785174));
                                bufferedOutputStream.write(ac.a(stringToBytes.length));
                                bufferedOutputStream.write(stringToBytes);
                                bufferedOutputStream.flush();
                                i2++;
                            }
                            com.xiaomi.channel.commonutils.logger.b.d("event data throw a invalid item ");
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    com.xiaomi.channel.commonutils.logger.b.a("event data write to cache file failed cause exception", e);
                    y.a(bufferedOutputStream);
                    a(randomAccessFile, fileLock);
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream2 = bufferedOutputStream;
                y.a(bufferedOutputStream2);
                a(randomAccessFile, fileLock);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            y.a(bufferedOutputStream2);
            a(randomAccessFile, fileLock);
            throw th;
        }
        y.a(bufferedOutputStream);
        a(randomAccessFile, fileLock);
        return null;
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        File externalFilesDir = this.f37278a.getExternalFilesDir("event");
        String a2 = a(aVar);
        if (externalFilesDir == null) {
            return null;
        }
        String str = externalFilesDir.getAbsolutePath() + File.separator + a2;
        for (int i2 = 0; i2 < 100; i2++) {
            String str2 = str + i2;
            if (bq.m173a(this.f37278a, str2)) {
                return str2;
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        int i2;
        bq.a(this.f37278a, "event", "eventUploading");
        File[] m174a = bq.m174a(this.f37278a, "eventUploading");
        if (m174a == null || m174a.length <= 0) {
            return;
        }
        int length = m174a.length;
        FileLock fileLock = null;
        RandomAccessFile randomAccessFile = null;
        File file = null;
        while (i2 < length) {
            File file2 = m174a[i2];
            if (file2 == null) {
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                    }
                }
                y.a(randomAccessFile);
                i2 = file == null ? i2 + 1 : 0;
                file.delete();
            } else {
                try {
                    try {
                    } catch (Exception e3) {
                        e = e3;
                    }
                    if (file2.length() > 5242880) {
                        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                        a(file2.getName(), Formatter.formatFileSize(this.f37278a, file2.length()));
                        file2.delete();
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e4) {
                                com.xiaomi.channel.commonutils.logger.b.a(e4);
                            }
                        }
                        y.a(randomAccessFile);
                        if (file == null) {
                        }
                        file.delete();
                    } else {
                        String absolutePath = file2.getAbsolutePath();
                        File file3 = new File(absolutePath + ".lock");
                        try {
                            y.m630a(file3);
                            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file3, "rw");
                            try {
                                fileLock = randomAccessFile2.getChannel().lock();
                                a(a(absolutePath));
                                file2.delete();
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e5) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e5);
                                    }
                                }
                                y.a(randomAccessFile2);
                                file3.delete();
                                randomAccessFile = randomAccessFile2;
                                file = file3;
                            } catch (Exception e6) {
                                e = e6;
                                randomAccessFile = randomAccessFile2;
                                file = file3;
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e7) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e7);
                                    }
                                }
                                y.a(randomAccessFile);
                                if (file == null) {
                                }
                                file.delete();
                            } catch (Throwable th) {
                                th = th;
                                randomAccessFile = randomAccessFile2;
                                file = file3;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e8) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e8);
                                    }
                                }
                                y.a(randomAccessFile);
                                if (file != null) {
                                    file.delete();
                                }
                                throw th;
                            }
                        } catch (Exception e9) {
                            e = e9;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }
    }

    public void a(Context context) {
        this.f37278a = context;
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a  reason: collision with other method in class */
    public void mo65a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof EventClientReport) && this.f39a != null) {
            EventClientReport eventClientReport = (EventClientReport) aVar;
            String a2 = a((com.xiaomi.clientreport.data.a) eventClientReport);
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f39a.get(a2);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(eventClientReport);
            this.f39a.put(a2, arrayList);
        }
    }

    public void a(List<String> list) {
        bq.a(this.f37278a, list);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m66a(com.xiaomi.clientreport.data.a[] aVarArr) {
        if (aVarArr == null || aVarArr.length == 0 || aVarArr[0] == null) {
            com.xiaomi.channel.commonutils.logger.b.m57a("event data write to cache file failed because data null");
            return;
        }
        do {
            aVarArr = a(aVarArr);
            if (aVarArr == null || aVarArr.length <= 0) {
                return;
            }
        } while (aVarArr[0] != null);
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap = this.f39a;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            for (String str : this.f39a.keySet()) {
                ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f39a.get(str);
                if (arrayList != null && arrayList.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[arrayList.size()];
                    arrayList.toArray(aVarArr);
                    m66a(aVarArr);
                }
            }
        }
        this.f39a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public String bytesToString(byte[] bArr) {
        byte[] a2;
        if (bArr != null && bArr.length >= 1) {
            if (!com.xiaomi.clientreport.manager.a.a(this.f37278a).m62a().isEventEncrypted()) {
                return bm.a(bArr);
            }
            String a3 = bq.a(this.f37278a);
            if (!TextUtils.isEmpty(a3) && (a2 = bq.a(a3)) != null && a2.length > 0) {
                try {
                    return bm.a(Base64.decode(h.a(a2, bArr), 2));
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap) {
        this.f39a = hashMap;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public byte[] stringToBytes(String str) {
        byte[] a2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.xiaomi.clientreport.manager.a.a(this.f37278a).m62a().isEventEncrypted()) {
            String a3 = bq.a(this.f37278a);
            byte[] m169a = bm.m169a(str);
            if (!TextUtils.isEmpty(a3) && m169a != null && m169a.length > 1 && (a2 = bq.a(a3)) != null) {
                try {
                    if (a2.length > 1) {
                        return h.b(a2, Base64.encode(m169a, 2));
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
            return null;
        }
        return bm.m169a(str);
    }
}
