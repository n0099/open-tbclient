package com.xiaomi.push.service.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.misc.k;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.service.ah;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class d {
    private static d a = null;
    private Map<String, c> b = new HashMap();
    private List<b> c = new ArrayList();
    private Context d;
    private SharedPreferences e;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private String a;
        private String b;
        private String c;
        private boolean d;
        private Context e;
        private boolean f = false;

        public a(Context context, String str, String str2, String str3, boolean z) {
            this.a = null;
            this.b = null;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = context.getApplicationContext();
        }

        @Override // java.lang.Runnable
        public void run() {
            File file;
            FileOutputStream fileOutputStream;
            FileOutputStream fileOutputStream2 = null;
            if (com.xiaomi.channel.commonutils.network.d.f(this.e)) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 200) {
                        byte[] b = com.xiaomi.channel.commonutils.file.a.b(httpURLConnection.getInputStream());
                        if (!TextUtils.isEmpty(this.b)) {
                            if (!this.b.equalsIgnoreCase(com.xiaomi.channel.commonutils.string.d.a(b))) {
                                b = null;
                            }
                        }
                        if (b != null) {
                            com.xiaomi.channel.commonutils.logger.b.b("download apk success.");
                            try {
                                try {
                                    file = new File(this.c + ".tmp");
                                    file.delete();
                                    fileOutputStream = new FileOutputStream(file);
                                } catch (Throwable th) {
                                    th = th;
                                }
                            } catch (Exception e) {
                                e = e;
                            }
                            try {
                                fileOutputStream.write(b);
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                if (com.xiaomi.channel.commonutils.android.d.a(com.xiaomi.channel.commonutils.android.b.e(this.e, file.getPath()))) {
                                    com.xiaomi.channel.commonutils.logger.b.b("verify signature success");
                                    file.renameTo(new File(this.c));
                                    this.f = true;
                                    if (this.d && !com.xiaomi.channel.commonutils.android.b.b(this.e)) {
                                        Process.killProcess(Process.myPid());
                                    }
                                } else {
                                    com.xiaomi.channel.commonutils.logger.b.d("verify signature failed");
                                    file.delete();
                                }
                                com.xiaomi.channel.commonutils.file.a.a((OutputStream) null);
                            } catch (Exception e2) {
                                e = e2;
                                fileOutputStream2 = fileOutputStream;
                                e.printStackTrace();
                                com.xiaomi.channel.commonutils.file.a.a(fileOutputStream2);
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream2 = fileOutputStream;
                                com.xiaomi.channel.commonutils.file.a.a(fileOutputStream2);
                                throw th;
                            }
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(f fVar);
    }

    private d(Context context) {
        this.d = context.getApplicationContext();
        this.e = this.d.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
    }

    private c a(com.xiaomi.push.service.module.a aVar, DexClassLoader dexClassLoader) {
        if (dexClassLoader != null) {
            return new c(aVar.e(), aVar.f(), dexClassLoader, aVar.b(), aVar.a());
        }
        return null;
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d(context);
            }
            dVar = a;
        }
        return dVar;
    }

    private void a(e eVar, int i) {
        this.e.edit().putInt("plugin_version_" + eVar.b, i).commit();
    }

    private synchronized void a(f fVar) {
        for (b bVar : this.c) {
            bVar.a(fVar);
        }
    }

    private int b(e eVar) {
        return this.e.getInt("plugin_version_" + eVar.b, 0);
    }

    private List<f> b() {
        ArrayList arrayList = new ArrayList();
        ah a2 = ah.a(this.d);
        f fVar = new f();
        fVar.a = e.MODULE_CDATA;
        fVar.b = a2.a(com.xiaomi.xmpush.thrift.e.CollectionDataPluginVersion.a(), 0);
        fVar.c = a2.a(com.xiaomi.xmpush.thrift.e.CollectionPluginDownloadUrl.a(), "");
        fVar.d = a2.a(com.xiaomi.xmpush.thrift.e.CollectionPluginMd5.a(), "");
        fVar.e = a2.a(com.xiaomi.xmpush.thrift.e.CollectionPluginForceStop.a(), false);
        arrayList.add(fVar);
        return arrayList;
    }

    public c a(e eVar) {
        k.a();
        if (eVar == null) {
            return null;
        }
        a();
        com.xiaomi.channel.commonutils.logger.b.b("loadModule " + eVar.b);
        String str = eVar.b;
        if (this.b.containsKey(str)) {
            return this.b.get(str);
        }
        com.xiaomi.push.service.module.a aVar = new com.xiaomi.push.service.module.a(this.d, str);
        DexClassLoader c = aVar.c();
        if (c != null) {
            c a2 = a(aVar, c);
            a2.a(this.d);
            this.b.put(str, a2);
            com.xiaomi.channel.commonutils.logger.b.b("module load success.");
            return a2;
        }
        return null;
    }

    public synchronized void a() {
        if (!this.f) {
            this.f = true;
            for (f fVar : b()) {
                if (b(fVar.a) < fVar.b && !TextUtils.isEmpty(fVar.c)) {
                    a aVar = new a(this.d, fVar.c, fVar.d, com.xiaomi.push.service.module.a.a(this.d, fVar.a.b), fVar.e);
                    aVar.run();
                    if (aVar.f) {
                        a(fVar.a, fVar.b);
                        a(fVar);
                    }
                }
            }
            this.f = false;
        }
    }
}
