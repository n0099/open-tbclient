package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.live.tbadk.img.ImageUploadStrategy;
import com.xiaomi.clientreport.data.EventClientReport;
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
/* loaded from: classes6.dex */
public class a implements IEventProcessor {

    /* renamed from: a  reason: collision with root package name */
    protected Context f14081a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f101a;

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
                                int a2 = ac.a(bArr2);
                                if (a2 < 1 || a2 > 4096) {
                                    break;
                                }
                                byte[] bArr3 = new byte[a2];
                                if (fileInputStream.read(bArr3) != a2) {
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
        EventClientReport a2 = com.xiaomi.clientreport.manager.a.a(this.f14081a).a(ARPMessageType.MSG_TYPE_RES_REQUEST, "24:" + str + "," + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2.toJsonString());
        a(arrayList);
    }

    private com.xiaomi.clientreport.data.a[] a(com.xiaomi.clientreport.data.a[] aVarArr) {
        BufferedOutputStream bufferedOutputStream;
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream2;
        String b2 = b(aVarArr[0]);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        try {
            File file = new File(b2 + ".lock");
            y.m609a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(b2), true));
                    try {
                        int i = 0;
                        for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                            if (aVar != null) {
                                byte[] stringToBytes = stringToBytes(aVar.toJsonString());
                                if (stringToBytes == null || stringToBytes.length < 1 || stringToBytes.length > 4096) {
                                    com.xiaomi.channel.commonutils.logger.b.d("event data throw a invalid item ");
                                } else if (!bj.m187a(this.f14081a, b2)) {
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
                        try {
                            com.xiaomi.channel.commonutils.logger.b.a("event data write to cache file failed cause exception", e);
                            y.a(bufferedOutputStream2);
                            a(randomAccessFile, fileLock);
                            return null;
                        } catch (Throwable th) {
                            th = th;
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
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedOutputStream2 = null;
                fileLock = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                fileLock = null;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedOutputStream2 = null;
            fileLock = null;
            randomAccessFile = null;
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
        File externalFilesDir = this.f14081a.getExternalFilesDir("event");
        String a2 = a(aVar);
        if (externalFilesDir == null) {
            return null;
        }
        String str2 = externalFilesDir.getAbsolutePath() + File.separator + a2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                str = null;
                break;
            }
            str = str2 + i2;
            if (bj.m187a(this.f14081a, str)) {
                break;
            }
            i = i2 + 1;
        }
        return str;
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        Throwable th;
        File file;
        Exception e;
        bj.a(this.f14081a, "event", "eventUploading");
        File[] m188a = bj.m188a(this.f14081a, "eventUploading");
        if (m188a == null || m188a.length <= 0) {
            return;
        }
        File file2 = null;
        FileLock fileLock = null;
        RandomAccessFile randomAccessFile = null;
        for (File file3 : m188a) {
            if (file3 == null) {
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                    }
                }
                y.a(randomAccessFile);
                if (file2 != null) {
                    file2.delete();
                }
            } else {
                try {
                    try {
                        if (file3.length() > ImageUploadStrategy.FILE_SIZE_5M) {
                            com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because " + file3.getName() + " is too big, length " + file3.length());
                            a(file3.getName(), Formatter.formatFileSize(this.f14081a, file3.length()));
                            file3.delete();
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e3) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                                }
                            }
                            y.a(randomAccessFile);
                            if (file2 != null) {
                                file2.delete();
                            }
                        } else {
                            String absolutePath = file3.getAbsolutePath();
                            File file4 = new File(absolutePath + ".lock");
                            try {
                                y.m609a(file4);
                                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file4, "rw");
                                try {
                                    fileLock = randomAccessFile2.getChannel().lock();
                                    a(a(absolutePath));
                                    file3.delete();
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e4) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                                        }
                                    }
                                    y.a(randomAccessFile2);
                                    if (file4 != null) {
                                        file4.delete();
                                        file2 = file4;
                                        randomAccessFile = randomAccessFile2;
                                    } else {
                                        file2 = file4;
                                        randomAccessFile = randomAccessFile2;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    file2 = file4;
                                    randomAccessFile = randomAccessFile2;
                                    com.xiaomi.channel.commonutils.logger.b.a(e);
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e6) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e6);
                                        }
                                    }
                                    y.a(randomAccessFile);
                                    if (file2 != null) {
                                        file2.delete();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    file = file4;
                                    randomAccessFile = randomAccessFile2;
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
                                file2 = file4;
                            } catch (Throwable th3) {
                                th = th3;
                                file = file4;
                            }
                        }
                    } catch (Exception e9) {
                        e = e9;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    file = file2;
                }
            }
        }
    }

    public void a(Context context) {
        this.f14081a = context;
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a  reason: collision with other method in class */
    public void mo80a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof EventClientReport) && this.f101a != null) {
            EventClientReport eventClientReport = (EventClientReport) aVar;
            String a2 = a((com.xiaomi.clientreport.data.a) eventClientReport);
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f101a.get(a2);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(eventClientReport);
            this.f101a.put(a2, arrayList);
        }
    }

    public void a(List<String> list) {
        bj.a(this.f14081a, list);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m81a(com.xiaomi.clientreport.data.a[] aVarArr) {
        if (aVarArr == null || aVarArr.length == 0 || aVarArr[0] == null) {
            com.xiaomi.channel.commonutils.logger.b.m73a("event data write to cache file failed because data null");
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
        if (this.f101a == null) {
            return;
        }
        if (this.f101a.size() > 0) {
            for (String str : this.f101a.keySet()) {
                ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f101a.get(str);
                if (arrayList != null && arrayList.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[arrayList.size()];
                    arrayList.toArray(aVarArr);
                    m81a(aVarArr);
                }
            }
        }
        this.f101a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public String bytesToString(byte[] bArr) {
        byte[] a2;
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        if (com.xiaomi.clientreport.manager.a.a(this.f14081a).m77a().isEventEncrypted()) {
            String a3 = bj.a(this.f14081a);
            if (TextUtils.isEmpty(a3) || (a2 = bj.a(a3)) == null || a2.length <= 0) {
                return null;
            }
            try {
                return bf.a(Base64.decode(h.a(a2, bArr), 2));
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
        this.f101a = hashMap;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public byte[] stringToBytes(String str) {
        byte[] a2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.xiaomi.clientreport.manager.a.a(this.f14081a).m77a().isEventEncrypted()) {
            String a3 = bj.a(this.f14081a);
            byte[] m183a = bf.m183a(str);
            if (TextUtils.isEmpty(a3) || m183a == null || m183a.length <= 1 || (a2 = bj.a(a3)) == null) {
                return null;
            }
            try {
                if (a2.length > 1) {
                    return h.b(a2, Base64.encode(m183a, 2));
                }
                return null;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return null;
            }
        }
        return bf.m183a(str);
    }
}
