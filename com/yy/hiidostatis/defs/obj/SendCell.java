package com.yy.hiidostatis.defs.obj;

import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.yy.hiidostatis.inner.util.NumberUtil;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.cipher.AesCipher;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes9.dex */
public class SendCell {
    public static final String AES_KEY = "*&Hjkfa{{07";
    public static final int RANDOM_LEN = 10000;
    public String content;
    public long expire;
    public long id;
    public int retry;
    public long timestamp;

    public SendCell(long j, String str, long j2, int i, long j3) {
        this.content = str;
        this.retry = i;
        this.expire = j2;
        this.timestamp = j3;
        this.id = j == 0 ? createId() : j;
    }

    public SendCell(String str, long j) {
        this(0L, str, j, 0, System.currentTimeMillis());
    }

    private long createId() {
        return ((this.timestamp + (this.expire * 1000)) * 10000) + ((long) (Math.random() * 10000.0d));
    }

    public String getContent() {
        return this.content;
    }

    public long getExpire() {
        return this.expire;
    }

    public long getId() {
        return this.id;
    }

    public int getRetry() {
        return this.retry;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int retryIncrease() {
        int i = this.retry + 1;
        this.retry = i;
        return i;
    }

    public static SendCell loadFromFile(File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] readInputStream = Util.readInputStream(fileInputStream);
                long parseId = parseId(file.getName());
                long j = NumberUtil.getLong(readInputStream, 0);
                SendCell sendCell = new SendCell(parseId, new String(new AesCipher((file.getName() + AES_KEY).getBytes()).decrypt(readInputStream, 20, readInputStream.length - 20), IMAudioTransRequest.CHARSET).trim(), NumberUtil.getInt(readInputStream, 8), NumberUtil.getInt(readInputStream, 16), j);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return sendCell;
            } catch (Throwable th) {
                th = th;
                try {
                    L.debug("SendCell", th.getMessage(), new Object[0]);
                    return null;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public boolean saveToFile(File file) {
        File randomFile = randomFile(file);
        if (randomFile.exists()) {
            return true;
        }
        FileOutputStream fileOutputStream = null;
        try {
            byte[] encrypt = new AesCipher((randomFile.getName() + AES_KEY).getBytes()).encrypt(this.content.getBytes(IMAudioTransRequest.CHARSET));
            FileOutputStream fileOutputStream2 = new FileOutputStream(randomFile);
            try {
                fileOutputStream2.write(NumberUtil.getBytes(this.timestamp));
                fileOutputStream2.write(NumberUtil.getBytes(this.expire));
                fileOutputStream2.write(NumberUtil.getBytes(this.retry));
                fileOutputStream2.write(encrypt);
                fileOutputStream2.flush();
                try {
                    fileOutputStream2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    th.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static long parseId(String str) {
        try {
            if (str.endsWith(".sec")) {
                return Long.parseLong(str.substring(0, str.length() - 4));
            }
            return 0L;
        } catch (Throwable th) {
            L.debug("SendCell", th.getMessage(), new Object[0]);
            return 0L;
        }
    }

    private File randomFile(File file) {
        String absolutePath = file.getAbsolutePath();
        StringBuilder sb = new StringBuilder(absolutePath.length() + 25);
        sb.append(absolutePath);
        sb.append("/");
        sb.append(this.id);
        sb.append(".sec");
        return new File(sb.toString());
    }

    public void deleteFile(File file) {
        if (this.id == 0) {
            return;
        }
        String absolutePath = file.getAbsolutePath();
        StringBuilder sb = new StringBuilder(absolutePath.length() + 25);
        sb.append(absolutePath);
        sb.append("/");
        sb.append(this.id);
        sb.append(".sec");
        new File(sb.toString()).delete();
    }
}
