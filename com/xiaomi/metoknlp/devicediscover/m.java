package com.xiaomi.metoknlp.devicediscover;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class m extends Thread {
    private WeakReference a;
    private WeakReference b;
    private final int c;

    public m(Handler handler, Context context, int i) {
        this.a = new WeakReference(handler);
        this.b = new WeakReference(context);
        this.c = i;
        start();
    }

    private Handler a() {
        if (this.a == null) {
            return null;
        }
        return (Handler) this.a.get();
    }

    public static void a(Context context, Handler handler, int i) {
        new m(handler, context, i);
    }

    private void a(String str, int i, int i2, HashMap hashMap) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/net/arp"));
            try {
                bufferedReader.readLine();
                String[] strArr = new String[(i2 - i) + 1];
                for (int i3 = 0; i3 < (i2 - i) + 1; i3++) {
                    strArr[i3] = str + "." + i3;
                }
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split("[ ]+");
                    if (split.length >= 6) {
                        String str2 = split[0];
                        String str3 = split[3];
                        for (String str4 : strArr) {
                            if (str4.equals(str2) && str3.matches("..:..:..:..:..:..") && !"00:00:00:00:00:00".equals(str3)) {
                                hashMap.put(str2, str3);
                            }
                        }
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                    }
                }
            } catch (FileNotFoundException e2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th) {
                bufferedReader2 = bufferedReader;
                th = th;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e6) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            bufferedReader = null;
        } catch (IOException e8) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void a(HashMap hashMap) {
        Handler a = a();
        Message obtainMessage = a.obtainMessage(this.c);
        obtainMessage.obj = hashMap;
        a.sendMessage(obtainMessage);
    }

    private Context b() {
        if (this.a == null) {
            return null;
        }
        return (Context) this.b.get();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, CONST]}, finally: {[INVOKE, CONST, MOVE_EXCEPTION, SGET, INVOKE, MOVE_EXCEPTION] complete} */
    private HashMap c() {
        HashMap hashMap = new HashMap();
        String b = j.b(b());
        if (b != null) {
            String substring = b.substring(0, b.lastIndexOf("."));
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(40);
            try {
                Runnable[] runnableArr = new Runnable[255];
                for (int i = 1; i < 255; i++) {
                    runnableArr[i] = new e(this, substring + "." + i);
                }
                for (int i2 = 1; i2 < 255; i2++) {
                    newFixedThreadPool.execute(runnableArr[i2]);
                }
                newFixedThreadPool.shutdown();
                try {
                    newFixedThreadPool.awaitTermination(10000L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                newFixedThreadPool.shutdown();
                try {
                    newFixedThreadPool.awaitTermination(10000L, TimeUnit.MILLISECONDS);
                } catch (Exception e3) {
                }
            } catch (Throwable th) {
                newFixedThreadPool.shutdown();
                try {
                    newFixedThreadPool.awaitTermination(10000L, TimeUnit.MILLISECONDS);
                } catch (Exception e4) {
                }
                throw th;
            }
            a(substring, 1, 255, hashMap);
        }
        return hashMap;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        a(c());
    }
}
