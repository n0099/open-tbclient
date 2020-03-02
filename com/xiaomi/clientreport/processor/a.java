package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.push.ac;
import com.xiaomi.push.ay;
import com.xiaomi.push.be;
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
    protected Context a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f16a;

    public a(Context context) {
        a(context);
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        return String.valueOf(aVar.production);
    }

    private List<String> a(String str) {
        FileInputStream fileInputStream;
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        try {
            try {
                fileInputStream = new FileInputStream(new File(str));
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else if (read != 4) {
                            com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because magicNumber error");
                            break;
                        } else if (ac.a(bArr) != -573785174) {
                            com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because magicNumber error");
                            break;
                        } else {
                            int read2 = fileInputStream.read(bArr2);
                            if (read2 == -1) {
                                break;
                            } else if (read2 != 4) {
                                com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed cause lengthBuffer error");
                                break;
                            } else {
                                int a = ac.a(bArr2);
                                if (a < 1 || a > 4096) {
                                    break;
                                }
                                byte[] bArr3 = new byte[a];
                                if (fileInputStream.read(bArr3) != a) {
                                    com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed cause buffer size not equal length");
                                    break;
                                }
                                arrayList.add(bytesToString(bArr3));
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        y.a(fileInputStream);
                        return arrayList;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K");
                y.a(fileInputStream);
            } catch (Throwable th) {
                th = th;
                y.a((Closeable) null);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            y.a((Closeable) null);
            throw th;
        }
        return arrayList;
    }

    private void a(com.xiaomi.clientreport.data.a[] aVarArr, String str) {
        BufferedOutputStream bufferedOutputStream;
        if (aVarArr == null || aVarArr.length <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str), true));
                try {
                    for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                        if (aVar != null) {
                            byte[] stringToBytes = stringToBytes(aVar.toJsonString());
                            if (stringToBytes == null || stringToBytes.length < 1 || stringToBytes.length > 4096) {
                                com.xiaomi.channel.commonutils.logger.b.d("event data throw a invalid item ");
                            } else {
                                bufferedOutputStream.write(ac.a(-573785174));
                                bufferedOutputStream.write(ac.a(stringToBytes.length));
                                bufferedOutputStream.write(stringToBytes);
                                bufferedOutputStream.flush();
                            }
                        }
                    }
                    y.a(bufferedOutputStream);
                } catch (Exception e) {
                    e = e;
                    com.xiaomi.channel.commonutils.logger.b.a("event data write to cache file failed cause exception", e);
                    y.a(bufferedOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                y.a((Closeable) null);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            y.a((Closeable) null);
            throw th;
        }
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        String str;
        File externalFilesDir = this.a.getExternalFilesDir(NotificationCompat.CATEGORY_EVENT);
        String a = a(aVar);
        if (externalFilesDir == null) {
            return null;
        }
        String str2 = externalFilesDir.getAbsolutePath() + File.separator + a;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                str = null;
                break;
            }
            str = str2 + i2;
            if (be.m159a(this.a, str)) {
                break;
            }
            i = i2 + 1;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00d5  */
    @Override // com.xiaomi.clientreport.processor.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        File file;
        Throwable th;
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        Exception exc;
        be.a(this.a, NotificationCompat.CATEGORY_EVENT, "eventUploading");
        File[] m160a = be.m160a(this.a, "eventUploading");
        if (m160a == null || m160a.length <= 0) {
            return;
        }
        int length = m160a.length;
        int i = 0;
        FileLock fileLock2 = null;
        RandomAccessFile randomAccessFile2 = null;
        File file2 = null;
        while (i < length) {
            File file3 = m160a[i];
            if (file3 == null) {
                if (fileLock2 != null && fileLock2.isValid()) {
                    try {
                        fileLock2.release();
                    } catch (IOException e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
                y.a(randomAccessFile2);
                if (file2 != null) {
                    file2.delete();
                    fileLock = fileLock2;
                    randomAccessFile = randomAccessFile2;
                } else {
                    fileLock = fileLock2;
                    randomAccessFile = randomAccessFile2;
                }
            } else {
                try {
                    String absolutePath = file3.getAbsolutePath();
                    file = new File(absolutePath + ".lock");
                    try {
                        y.m568a(file);
                        RandomAccessFile randomAccessFile3 = new RandomAccessFile(file, "rw");
                        try {
                            FileLock lock = randomAccessFile3.getChannel().lock();
                            try {
                                a(a(absolutePath));
                                file3.delete();
                                if (lock != null && lock.isValid()) {
                                    try {
                                        lock.release();
                                    } catch (IOException e2) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                                    }
                                }
                                y.a(randomAccessFile3);
                                if (file != null) {
                                    file.delete();
                                    randomAccessFile = randomAccessFile3;
                                    file2 = file;
                                    fileLock = lock;
                                } else {
                                    randomAccessFile = randomAccessFile3;
                                    file2 = file;
                                    fileLock = lock;
                                }
                            } catch (Exception e3) {
                                exc = e3;
                                randomAccessFile = randomAccessFile3;
                                file2 = file;
                                fileLock = lock;
                                try {
                                    com.xiaomi.channel.commonutils.logger.b.a(exc);
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e4) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                                        }
                                    }
                                    y.a(randomAccessFile);
                                    if (file2 != null) {
                                        file2.delete();
                                    }
                                    i++;
                                    randomAccessFile2 = randomAccessFile;
                                    fileLock2 = fileLock;
                                } catch (Throwable th2) {
                                    randomAccessFile2 = randomAccessFile;
                                    fileLock2 = fileLock;
                                    file = file2;
                                    th = th2;
                                    if (fileLock2 != null && fileLock2.isValid()) {
                                        try {
                                            fileLock2.release();
                                        } catch (IOException e5) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e5);
                                        }
                                    }
                                    y.a(randomAccessFile2);
                                    if (file != null) {
                                        file.delete();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                randomAccessFile2 = randomAccessFile3;
                                th = th3;
                                fileLock2 = lock;
                                if (fileLock2 != null) {
                                    fileLock2.release();
                                }
                                y.a(randomAccessFile2);
                                if (file != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e6) {
                            exc = e6;
                            file2 = file;
                            fileLock = fileLock2;
                            randomAccessFile = randomAccessFile3;
                        } catch (Throwable th4) {
                            th = th4;
                            randomAccessFile2 = randomAccessFile3;
                        }
                    } catch (Exception e7) {
                        file2 = file;
                        fileLock = fileLock2;
                        randomAccessFile = randomAccessFile2;
                        exc = e7;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Exception e8) {
                    fileLock = fileLock2;
                    randomAccessFile = randomAccessFile2;
                    exc = e8;
                } catch (Throwable th6) {
                    file = file2;
                    th = th6;
                }
            }
            i++;
            randomAccessFile2 = randomAccessFile;
            fileLock2 = fileLock;
        }
    }

    public void a(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a  reason: collision with other method in class */
    public void mo52a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof EventClientReport) && this.f16a != null) {
            EventClientReport eventClientReport = (EventClientReport) aVar;
            String a = a((com.xiaomi.clientreport.data.a) eventClientReport);
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f16a.get(a);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(eventClientReport);
            this.f16a.put(a, arrayList);
        }
    }

    public void a(List<String> list) {
        be.a(this.a, list);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x0094 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public void a(com.xiaomi.clientreport.data.a[] aVarArr) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock = null;
        if (aVarArr == null || aVarArr.length <= 0 || aVarArr[0] == null) {
            return;
        }
        String b = b(aVarArr[0]);
        ?? isEmpty = TextUtils.isEmpty(b);
        try {
            if (isEmpty != 0) {
                return;
            }
            try {
                File file = new File(b + ".lock");
                y.m568a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                        if (aVar != null) {
                            a(aVarArr, b);
                        }
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e) {
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                        }
                    }
                    y.a(randomAccessFile);
                } catch (Exception e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            com.xiaomi.channel.commonutils.logger.b.a(e3);
                        }
                    }
                    y.a(randomAccessFile);
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile = null;
            } catch (Throwable th) {
                th = th;
                isEmpty = 0;
                if (0 != 0 && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e5) {
                        com.xiaomi.channel.commonutils.logger.b.a(e5);
                    }
                }
                y.a((Closeable) isEmpty);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        if (this.f16a == null) {
            return;
        }
        if (this.f16a.size() > 0) {
            for (String str : this.f16a.keySet()) {
                ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f16a.get(str);
                if (arrayList != null && arrayList.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[arrayList.size()];
                    arrayList.toArray(aVarArr);
                    a(aVarArr);
                }
            }
        }
        this.f16a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public String bytesToString(byte[] bArr) {
        byte[] a;
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        if (com.xiaomi.clientreport.manager.a.a(this.a).a().isEventEncrypted()) {
            String a2 = be.a(this.a);
            if (TextUtils.isEmpty(a2) || (a = be.a(a2)) == null || a.length <= 0) {
                return null;
            }
            try {
                return ay.a(Base64.decode(h.a(a, bArr), 2));
            } catch (InvalidAlgorithmParameterException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return null;
            } catch (InvalidKeyException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                return null;
            } catch (NoSuchAlgorithmException e3) {
                com.xiaomi.channel.commonutils.logger.b.a(e3);
                return null;
            } catch (BadPaddingException e4) {
                com.xiaomi.channel.commonutils.logger.b.a(e4);
                return null;
            } catch (IllegalBlockSizeException e5) {
                com.xiaomi.channel.commonutils.logger.b.a(e5);
                return null;
            } catch (NoSuchPaddingException e6) {
                com.xiaomi.channel.commonutils.logger.b.a(e6);
                return null;
            }
        }
        return ay.a(bArr);
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap) {
        this.f16a = hashMap;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public byte[] stringToBytes(String str) {
        byte[] a;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.xiaomi.clientreport.manager.a.a(this.a).a().isEventEncrypted()) {
            String a2 = be.a(this.a);
            byte[] m141a = ay.m141a(str);
            if (TextUtils.isEmpty(a2) || m141a == null || m141a.length <= 1 || (a = be.a(a2)) == null) {
                return null;
            }
            try {
                if (a.length > 1) {
                    return h.b(a, Base64.encode(m141a, 2));
                }
                return null;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return null;
            }
        }
        return ay.m141a(str);
    }
}
