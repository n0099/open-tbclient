package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.push.ac;
import com.xiaomi.push.bo;
import com.xiaomi.push.bs;
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
/* loaded from: classes10.dex */
public class a implements IEventProcessor {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f31a;

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
        char c;
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
                com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because magicNumber error");
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

    private void a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        y.a(randomAccessFile);
    }

    private void a(String str, String str2) {
        com.xiaomi.clientreport.manager.a a = com.xiaomi.clientreport.manager.a.a(this.a);
        EventClientReport a2 = a.a(5001, "24:" + str + "," + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2.toJsonString());
        a(arrayList);
    }

    private com.xiaomi.clientreport.data.a[] a(com.xiaomi.clientreport.data.a[] aVarArr) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        String b = b(aVarArr[0]);
        BufferedOutputStream bufferedOutputStream2 = null;
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        try {
            File file = new File(b + ".lock");
            y.m849a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
            } catch (Exception e) {
                e = e;
                fileLock = null;
                bufferedOutputStream = null;
            } catch (Throwable th) {
                th = th;
                fileLock = null;
            }
        } catch (Exception e2) {
            e = e2;
            fileLock = null;
            randomAccessFile = null;
            bufferedOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileLock = null;
            randomAccessFile = null;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(b), true));
            try {
                try {
                    int i = 0;
                    for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                        if (aVar != null) {
                            byte[] stringToBytes = stringToBytes(aVar.toJsonString());
                            if (stringToBytes != null && stringToBytes.length >= 1 && stringToBytes.length <= 4096) {
                                if (!bs.m308a(this.a, b)) {
                                    int length = aVarArr.length - i;
                                    com.xiaomi.clientreport.data.a[] aVarArr2 = new com.xiaomi.clientreport.data.a[length];
                                    System.arraycopy(aVarArr, i, aVarArr2, 0, length);
                                    y.a(bufferedOutputStream);
                                    a(randomAccessFile, fileLock);
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
                } catch (Exception e3) {
                    e = e3;
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
        } catch (Exception e4) {
            e = e4;
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
        File externalFilesDir = this.a.getExternalFilesDir("event");
        String a = a(aVar);
        if (externalFilesDir == null) {
            return null;
        }
        String str = externalFilesDir.getAbsolutePath() + File.separator + a;
        for (int i = 0; i < 100; i++) {
            String str2 = str + i;
            if (bs.m308a(this.a, str2)) {
                return str2;
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        int i;
        bs.a(this.a, "event", "eventUploading");
        File[] m309a = bs.m309a(this.a, "eventUploading");
        if (m309a == null || m309a.length <= 0) {
            return;
        }
        int length = m309a.length;
        FileLock fileLock = null;
        RandomAccessFile randomAccessFile = null;
        File file = null;
        while (i < length) {
            File file2 = m309a[i];
            if (file2 == null) {
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
                y.a(randomAccessFile);
                i = file == null ? i + 1 : 0;
                file.delete();
            } else {
                try {
                    try {
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
                        y.a(randomAccessFile);
                        if (file == null) {
                        }
                        file.delete();
                    } else {
                        String absolutePath = file2.getAbsolutePath();
                        File file3 = new File(absolutePath + ".lock");
                        try {
                            y.m849a(file3);
                            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file3, "rw");
                            try {
                                fileLock = randomAccessFile2.getChannel().lock();
                                a(a(absolutePath));
                                file2.delete();
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e4) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e4);
                                    }
                                }
                                y.a(randomAccessFile2);
                                file3.delete();
                                randomAccessFile = randomAccessFile2;
                                file = file3;
                            } catch (Exception e5) {
                                e = e5;
                                randomAccessFile = randomAccessFile2;
                                file = file3;
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e6) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e6);
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
                                    } catch (IOException e7) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e7);
                                    }
                                }
                                y.a(randomAccessFile);
                                if (file != null) {
                                    file.delete();
                                }
                                throw th;
                            }
                        } catch (Exception e8) {
                            e = e8;
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
        this.a = context;
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a  reason: collision with other method in class */
    public void mo194a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof EventClientReport) && this.f31a != null) {
            EventClientReport eventClientReport = (EventClientReport) aVar;
            String a = a((com.xiaomi.clientreport.data.a) eventClientReport);
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f31a.get(a);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(eventClientReport);
            this.f31a.put(a, arrayList);
        }
    }

    public void a(List<String> list) {
        bs.a(this.a, list);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m195a(com.xiaomi.clientreport.data.a[] aVarArr) {
        if (aVarArr == null || aVarArr.length == 0 || aVarArr[0] == null) {
            com.xiaomi.channel.commonutils.logger.b.m186a("event data write to cache file failed because data null");
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
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap = this.f31a;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            for (String str : this.f31a.keySet()) {
                ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f31a.get(str);
                if (arrayList != null && arrayList.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[arrayList.size()];
                    arrayList.toArray(aVarArr);
                    m195a(aVarArr);
                }
            }
        }
        this.f31a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public String bytesToString(byte[] bArr) {
        byte[] a;
        if (bArr != null && bArr.length >= 1) {
            if (!com.xiaomi.clientreport.manager.a.a(this.a).m191a().isEventEncrypted()) {
                return bo.b(bArr);
            }
            String a2 = bs.a(this.a);
            if (!TextUtils.isEmpty(a2) && (a = bs.a(a2)) != null && a.length > 0) {
                try {
                    return bo.b(Base64.decode(h.a(a, bArr), 2));
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap) {
        this.f31a = hashMap;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public byte[] stringToBytes(String str) {
        byte[] a;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.xiaomi.clientreport.manager.a.a(this.a).m191a().isEventEncrypted()) {
            String a2 = bs.a(this.a);
            byte[] m305a = bo.m305a(str);
            if (!TextUtils.isEmpty(a2) && m305a != null && m305a.length > 1 && (a = bs.a(a2)) != null) {
                try {
                    if (a.length > 1) {
                        return h.b(a, Base64.encode(m305a, 2));
                    }
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            return null;
        }
        return bo.m305a(str);
    }
}
