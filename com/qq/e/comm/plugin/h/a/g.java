package com.qq.e.comm.plugin.h.a;

import android.os.Environment;
import com.baidu.down.utils.Constants;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.util.Md5Util;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile JSONObject f12080a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f12081a;

        /* renamed from: b  reason: collision with root package name */
        private final String f12082b;

        public a(int i, String str) {
            this.f12081a = i;
            this.f12082b = str;
        }

        public int a() {
            return this.f12081a;
        }

        public String b() {
            return this.f12082b;
        }
    }

    private static String a(a aVar, String str, long j) throws Exception {
        return Md5Util.encode(String.format("%s%d%d%s", str, Integer.valueOf(aVar.a()), Long.valueOf(j), aVar.b())).toUpperCase();
    }

    private static JSONObject a(a aVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        String uuid = UUID.randomUUID().toString();
        long currentTimeMillis = System.currentTimeMillis();
        jSONObject.put("v", aVar.f12081a);
        jSONObject.put("u", uuid);
        jSONObject.put("t", currentTimeMillis);
        jSONObject.put("m", a(aVar, uuid, currentTimeMillis));
        return jSONObject;
    }

    public static JSONObject a(String str) {
        JSONObject jSONObject;
        byte[] bArr = null;
        boolean z = false;
        synchronized (g.class) {
            try {
                if (f12080a != null) {
                    jSONObject = f12080a;
                } else {
                    File file = new File(Environment.getExternalStorageDirectory(), "Tencent/ams/cache");
                    File file2 = new File(Environment.getExternalStorageDirectory(), "Android/data/com.tencent.ams/cache");
                    try {
                        List<a> b2 = b(str);
                        try {
                            bArr = a(new File(file, "meta.dat"));
                            f12080a = a(bArr, b2);
                        } catch (Exception e) {
                            ai.a("uuid read main file failed.", e);
                        }
                        if (f12080a != null) {
                            ai.a("read uuid from main", new Object[0]);
                            z = true;
                        } else {
                            try {
                                bArr = a(new File(file2, "meta.dat"));
                                f12080a = a(bArr, b2);
                            } catch (Exception e2) {
                                ai.a("uuid read backup file failed.", e2);
                            }
                            if (f12080a != null) {
                                ai.a("read uuid from backup", new Object[0]);
                                z = true;
                            } else {
                                try {
                                    a aVar = b2.get(b2.size() - 1);
                                    f12080a = a(aVar);
                                    ai.a("read uuid from new generate uuid:" + f12080a + " use salt:" + aVar, new Object[0]);
                                    bArr = f12080a.toString().getBytes("UTF-8");
                                    z = true;
                                } catch (Exception e3) {
                                    ai.a("generate new uuid error", e3);
                                }
                            }
                        }
                    } catch (JSONException e4) {
                        ai.a("uuid parse slat error.", e4);
                    }
                    if (bArr != null && z) {
                        if (z & true) {
                            try {
                                a(file, "meta.dat", bArr);
                            } catch (Exception e5) {
                                if (z) {
                                    f12080a = new JSONObject();
                                }
                                ai.a("write uuid to file error", e5);
                            }
                        }
                        if (z & true) {
                            a(file2, "meta.dat", bArr);
                        }
                    }
                    jSONObject = f12080a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return jSONObject;
    }

    private static JSONObject a(byte[] bArr, List<a> list) throws Exception {
        JSONObject jSONObject = new JSONObject(new String(bArr, 0, bArr.length, "UTF-8"));
        int i = jSONObject.getInt("v");
        String string = jSONObject.getString("u");
        long j = jSONObject.getLong("t");
        String string2 = jSONObject.getString("m");
        for (a aVar : list) {
            if (aVar.f12081a == i) {
                String a2 = a(aVar, string, j);
                if (string2.equals(a2)) {
                    return jSONObject;
                }
                throw new Exception("file signature:" + string2 + " not match calculate signature:" + a2);
            }
        }
        throw new Exception("file version not exist:" + i);
    }

    private static void a(File file, String str, byte[] bArr) throws Exception {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        FileLock lock;
        if (!file.exists() && !file.mkdirs()) {
            ai.a("create dir error", new Object[0]);
        }
        try {
            randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
            try {
                lock = randomAccessFile.getChannel().lock();
            } catch (Throwable th) {
                th = th;
                fileLock = null;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            fileLock = null;
        }
        try {
            randomAccessFile.setLength(0L);
            randomAccessFile.write(bArr);
            if (lock != null) {
                try {
                    lock.release();
                } catch (IOException e) {
                }
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (Throwable th3) {
            th = th3;
            fileLock = lock;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException e2) {
                }
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    private static byte[] a(File file) throws Exception {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        FileLock lock;
        long j = Constants.TEST_SPEED_THRESHOLD_DEFAULT;
        try {
            randomAccessFile2 = new RandomAccessFile(file, "rwd");
            try {
                lock = randomAccessFile2.getChannel().lock();
            } catch (Throwable th) {
                th = th;
                fileLock = null;
                randomAccessFile = randomAccessFile2;
            }
        } catch (Throwable th2) {
            th = th2;
            fileLock = null;
            randomAccessFile = null;
        }
        try {
            long length = randomAccessFile2.length();
            if (length <= Constants.TEST_SPEED_THRESHOLD_DEFAULT) {
                j = length;
            }
            int i = (int) j;
            byte[] bArr = new byte[i];
            int read = randomAccessFile2.read(bArr, 0, i);
            if (read != i) {
                throw new Exception("read file length：" + read + "file length:" + i + " not match " + file.getAbsolutePath());
            }
            if (lock != null) {
                try {
                    lock.release();
                } catch (IOException e) {
                }
            }
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            return bArr;
        } catch (Throwable th3) {
            th = th3;
            fileLock = lock;
            randomAccessFile = randomAccessFile2;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException e2) {
                }
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    private static List<a> b(String str) throws JSONException {
        JSONArray jSONArray = new JSONArray(str);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            arrayList.add(new a(jSONObject.getInt("v"), jSONObject.getString("s")));
        }
        return arrayList;
    }
}
