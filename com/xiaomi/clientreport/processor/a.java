package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.live.tbadk.img.ImageUploadStrategy;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ac;
import com.xiaomi.push.bf;
import com.xiaomi.push.bj;
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
/* loaded from: classes9.dex */
public class a implements IEventProcessor {
    protected Context a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f24a;

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
                                String bytesToString = bytesToString(bArr3);
                                if (!TextUtils.isEmpty(bytesToString)) {
                                    arrayList.add(bytesToString);
                                }
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
        EventClientReport a = com.xiaomi.clientreport.manager.a.a(this.a).a(ARPMessageType.MSG_TYPE_RES_REQUEST, "24:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a.toJsonString());
        a(arrayList);
    }

    private com.xiaomi.clientreport.data.a[] a(com.xiaomi.clientreport.data.a[] aVarArr) {
        BufferedOutputStream bufferedOutputStream;
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream2;
        FileLock fileLock2;
        RandomAccessFile randomAccessFile2;
        int i = 0;
        String b = b(aVarArr[0]);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        try {
            File file = new File(b + ".lock");
            y.m585a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(b), true));
                    try {
                        for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                            if (aVar != null) {
                                byte[] stringToBytes = stringToBytes(aVar.toJsonString());
                                if (stringToBytes == null || stringToBytes.length < 1 || stringToBytes.length > 4096) {
                                    com.xiaomi.channel.commonutils.logger.b.d("event data throw a invalid item ");
                                } else if (!bj.m163a(this.a, b)) {
                                    int length = aVarArr.length - i;
                                    com.xiaomi.clientreport.data.a[] aVarArr2 = new com.xiaomi.clientreport.data.a[length];
                                    System.arraycopy(aVarArr, i, aVarArr2, 0, length);
                                    y.a(bufferedOutputStream);
                                    a(randomAccessFile, fileLock);
                                    return aVarArr2;
                                } else {
                                    bufferedOutputStream.write(ac.a(-573785174));
                                    bufferedOutputStream.write(ac.a(stringToBytes.length));
                                    bufferedOutputStream.write(stringToBytes);
                                    bufferedOutputStream.flush();
                                    i++;
                                }
                            }
                        }
                        y.a(bufferedOutputStream);
                        a(randomAccessFile, fileLock);
                    } catch (Exception e) {
                        e = e;
                        bufferedOutputStream2 = bufferedOutputStream;
                        fileLock2 = fileLock;
                        randomAccessFile2 = randomAccessFile;
                        try {
                            com.xiaomi.channel.commonutils.logger.b.a("event data write to cache file failed cause exception", e);
                            y.a(bufferedOutputStream2);
                            a(randomAccessFile2, fileLock2);
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            randomAccessFile = randomAccessFile2;
                            fileLock = fileLock2;
                            bufferedOutputStream = bufferedOutputStream2;
                            y.a(bufferedOutputStream);
                            a(randomAccessFile, fileLock);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        y.a(bufferedOutputStream);
                        a(randomAccessFile, fileLock);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream2 = null;
                    fileLock2 = fileLock;
                    randomAccessFile2 = randomAccessFile;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedOutputStream2 = null;
                fileLock2 = null;
                randomAccessFile2 = randomAccessFile;
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                fileLock = null;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedOutputStream2 = null;
            fileLock2 = null;
            randomAccessFile2 = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = null;
            fileLock = null;
            randomAccessFile = null;
        }
        return null;
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
            if (bj.m163a(this.a, str)) {
                break;
            }
            i = i2 + 1;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x013b  */
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
        bj.a(this.a, NotificationCompat.CATEGORY_EVENT, "eventUploading");
        File[] m164a = bj.m164a(this.a, "eventUploading");
        if (m164a == null || m164a.length <= 0) {
            return;
        }
        int length = m164a.length;
        int i = 0;
        FileLock fileLock2 = null;
        RandomAccessFile randomAccessFile2 = null;
        File file2 = null;
        while (i < length) {
            File file3 = m164a[i];
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
                }
                fileLock = fileLock2;
                randomAccessFile = randomAccessFile2;
            } else {
                try {
                    if (file3.length() > ImageUploadStrategy.FILE_SIZE_5M) {
                        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because " + file3.getName() + " is too big, length " + file3.length());
                        a(file3.getName(), Formatter.formatFileSize(this.a, file3.length()));
                        file3.delete();
                        if (fileLock2 != null && fileLock2.isValid()) {
                            try {
                                fileLock2.release();
                            } catch (IOException e2) {
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                            }
                        }
                        y.a(randomAccessFile2);
                        if (file2 != null) {
                            file2.delete();
                            fileLock = fileLock2;
                            randomAccessFile = randomAccessFile2;
                        }
                        fileLock = fileLock2;
                        randomAccessFile = randomAccessFile2;
                    } else {
                        String absolutePath = file3.getAbsolutePath();
                        file = new File(absolutePath + ".lock");
                        try {
                            y.m585a(file);
                            RandomAccessFile randomAccessFile3 = new RandomAccessFile(file, "rw");
                            try {
                                FileLock lock = randomAccessFile3.getChannel().lock();
                                try {
                                    a(a(absolutePath));
                                    file3.delete();
                                    if (lock != null && lock.isValid()) {
                                        try {
                                            lock.release();
                                        } catch (IOException e3) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e3);
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
                                } catch (Exception e4) {
                                    exc = e4;
                                    randomAccessFile = randomAccessFile3;
                                    file2 = file;
                                    fileLock = lock;
                                    try {
                                        com.xiaomi.channel.commonutils.logger.b.a(exc);
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException e5) {
                                                com.xiaomi.channel.commonutils.logger.b.a(e5);
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
                                            } catch (IOException e6) {
                                                com.xiaomi.channel.commonutils.logger.b.a(e6);
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
                            } catch (Exception e7) {
                                exc = e7;
                                file2 = file;
                                fileLock = fileLock2;
                                randomAccessFile = randomAccessFile3;
                            } catch (Throwable th4) {
                                th = th4;
                                randomAccessFile2 = randomAccessFile3;
                            }
                        } catch (Exception e8) {
                            file2 = file;
                            fileLock = fileLock2;
                            randomAccessFile = randomAccessFile2;
                            exc = e8;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                } catch (Exception e9) {
                    fileLock = fileLock2;
                    randomAccessFile = randomAccessFile2;
                    exc = e9;
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
    public void mo56a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof EventClientReport) && this.f24a != null) {
            EventClientReport eventClientReport = (EventClientReport) aVar;
            String a = a((com.xiaomi.clientreport.data.a) eventClientReport);
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f24a.get(a);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(eventClientReport);
            this.f24a.put(a, arrayList);
        }
    }

    public void a(List<String> list) {
        bj.a(this.a, list);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m57a(com.xiaomi.clientreport.data.a[] aVarArr) {
        if (aVarArr == null || aVarArr.length == 0 || aVarArr[0] == null) {
            com.xiaomi.channel.commonutils.logger.b.m49a("event data write to cache file failed because data null");
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
        if (this.f24a == null) {
            return;
        }
        if (this.f24a.size() > 0) {
            for (String str : this.f24a.keySet()) {
                ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f24a.get(str);
                if (arrayList != null && arrayList.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[arrayList.size()];
                    arrayList.toArray(aVarArr);
                    m57a(aVarArr);
                }
            }
        }
        this.f24a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public String bytesToString(byte[] bArr) {
        byte[] a;
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        if (com.xiaomi.clientreport.manager.a.a(this.a).m53a().isEventEncrypted()) {
            String a2 = bj.a(this.a);
            if (TextUtils.isEmpty(a2) || (a = bj.a(a2)) == null || a.length <= 0) {
                return null;
            }
            try {
                return bf.a(Base64.decode(h.a(a, bArr), 2));
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
        return bf.a(bArr);
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap) {
        this.f24a = hashMap;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public byte[] stringToBytes(String str) {
        byte[] a;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.xiaomi.clientreport.manager.a.a(this.a).m53a().isEventEncrypted()) {
            String a2 = bj.a(this.a);
            byte[] m159a = bf.m159a(str);
            if (TextUtils.isEmpty(a2) || m159a == null || m159a.length <= 1 || (a = bj.a(a2)) == null) {
                return null;
            }
            try {
                if (a.length > 1) {
                    return h.b(a, Base64.encode(m159a, 2));
                }
                return null;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return null;
            }
        }
        return bf.m159a(str);
    }
}
