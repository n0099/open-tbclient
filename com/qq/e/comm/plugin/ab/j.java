package com.qq.e.comm.plugin.ab;

import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.aa.a.b;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.az;
import com.qq.e.comm.plugin.y.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12117a = j.class.getSimpleName();
    private static volatile j f;

    /* renamed from: b  reason: collision with root package name */
    private File f12118b = g();
    private File c = ah.j();
    private Set<String> d;
    private Set<String> e;

    /* loaded from: classes4.dex */
    public interface a {
        void a(File file);

        void a(Exception exc);
    }

    private j() {
    }

    private File a(String str, File file) {
        File file2 = new File(file, ah.a(str));
        if (file2.exists()) {
            if (file2.length() > 0) {
                return file2;
            }
            file2.delete();
            return null;
        }
        return null;
    }

    private FileInputStream a(String str, az.a aVar) {
        File b2 = aVar == az.a.IMAGE ? b(str) : a(str);
        if (b2 == null) {
            if ((aVar != az.a.IMAGE || GDTADManager.getInstance().getSM().getInteger("web_proxy_img_cache", 0) != 1) && GDTADManager.getInstance().getSM().getInteger("web_proxy_res_cache", 0) != 1) {
                return null;
            }
            return b(str, aVar);
        }
        if (aVar == az.a.IMAGE) {
            u.a(new com.qq.e.comm.plugin.y.e(1110108));
        } else {
            u.a(new com.qq.e.comm.plugin.y.e(1110104));
        }
        try {
            ai.a(f12117a, "get response from cache: " + str);
            return new FileInputStream(b2);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void a(final String str, File file, final az.a aVar, final a aVar2) {
        com.qq.e.comm.plugin.aa.a.a.a().a(new b.a().a(file).a(ah.a(str)).a(false).b(str).a(), str, new com.qq.e.comm.plugin.j.a() { // from class: com.qq.e.comm.plugin.ab.j.2
            @Override // com.qq.e.comm.plugin.j.a
            public void a() {
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(long j, long j2, int i) {
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(long j, boolean z) {
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(com.qq.e.comm.plugin.j.c cVar) {
                ai.b(j.f12117a, "download fail, url = " + str + " ,errorCode:" + cVar.a() + ", errorMsg:" + cVar.b());
                com.qq.e.comm.plugin.y.e eVar = new com.qq.e.comm.plugin.y.e(1110106);
                com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
                dVar.a("url", str);
                eVar.a(dVar);
                u.a(eVar);
                if (aVar2 != null) {
                    aVar2.a(cVar);
                }
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(File file2, long j) {
                ai.a(j.f12117a, "download success, url=" + str + ", time = " + j);
                com.qq.e.comm.plugin.y.g gVar = new com.qq.e.comm.plugin.y.g(aVar == az.a.IMAGE ? 2060001 : 2060003);
                gVar.b(j);
                if (file2.exists()) {
                    gVar.b((int) (file2.length() >> 10));
                    if (aVar2 != null) {
                        aVar2.a(file2);
                    }
                } else {
                    gVar.b(-1);
                    if (aVar2 != null) {
                        aVar2.a(new Exception("文件不存在"));
                    }
                }
                u.a(gVar);
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void b() {
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void c() {
                if (aVar2 != null) {
                    aVar2.a(new Exception("下载被取消"));
                }
            }
        });
    }

    private File b(String str) {
        return a(str, this.f12118b);
    }

    private FileInputStream b(String str, az.a aVar) {
        final Exchanger exchanger = new Exchanger();
        a aVar2 = new a() { // from class: com.qq.e.comm.plugin.ab.j.1
            @Override // com.qq.e.comm.plugin.ab.j.a
            public void a(File file) {
                try {
                    exchanger.exchange(new FileInputStream(file));
                } catch (FileNotFoundException | InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.qq.e.comm.plugin.ab.j.a
            public void a(Exception exc) {
                ai.a(j.f12117a, exc.getMessage());
                try {
                    exchanger.exchange(null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        if (aVar == az.a.IMAGE) {
            a(str, aVar2);
        } else {
            a(str, aVar, aVar2);
        }
        try {
            return (FileInputStream) exchanger.exchange(null, 3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            ai.a(f12117a, "download InterruptedException, url = " + str, e);
            return null;
        } catch (TimeoutException e2) {
            e2.printStackTrace();
            ai.a(f12117a, "download TimeoutException, url = " + str, e2);
            u.a(new com.qq.e.comm.plugin.y.e(1110107));
            return null;
        }
    }

    public static j e() {
        if (f == null) {
            synchronized (j.class) {
                try {
                    if (f == null) {
                        f = new j();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    private File g() {
        if (this.f12118b == null) {
            this.f12118b = ah.l();
        }
        if (!this.f12118b.exists()) {
            this.f12118b.mkdirs();
        }
        return this.f12118b;
    }

    public File a(String str) {
        return a(str, this.c);
    }

    public FileInputStream a(Uri uri) {
        String uri2 = uri.toString();
        if (TextUtils.isEmpty(uri2)) {
            ai.a(f12117a, "url == null or empty");
            return null;
        }
        String a2 = az.a(uri);
        az.a c = az.c(a2);
        if (b().contains(a2)) {
            ai.a(f12117a, "proxy image: " + uri2);
            u.a(new com.qq.e.comm.plugin.y.e(1110101));
            return a(uri2, c);
        } else if (c().contains(a2)) {
            ai.a(f12117a, "proxy resource: " + uri2);
            u.a(new com.qq.e.comm.plugin.y.e(1110109));
            return a(uri2, c);
        } else {
            ai.a(f12117a, "proxy fail: " + uri2);
            if (GDTADManager.getInstance().getSM().getInteger("web_proxy_not_hit_event", 0) == 1) {
                com.qq.e.comm.plugin.y.e eVar = new com.qq.e.comm.plugin.y.e(1110105);
                eVar.a(new com.qq.e.comm.plugin.y.d().a("url", uri2));
                u.a(eVar);
                return null;
            }
            return null;
        }
    }

    public void a(String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            ai.a(f12117a, "downloadImage url is empty or null");
            return;
        }
        if (new File(g(), ah.a(str)).exists()) {
            ai.a(f12117a, str + ": 对应的文件本地已存在");
        } else {
            a(str, g(), az.a.IMAGE, aVar);
        }
    }

    public void a(String str, az.a aVar, a aVar2) {
        a(str, this.c, aVar, aVar2);
    }

    public boolean a() {
        return GDTADManager.getInstance().getSM().getInteger("web_proxy", 0) == 1;
    }

    public Set<String> b() {
        if (this.e == null) {
            String string = GDTADManager.getInstance().getSM().getString("web_proxy_img_suffix");
            if (TextUtils.isEmpty(string)) {
                string = "jpg,jpeg,png";
            }
            this.e = new HashSet(Arrays.asList(TextUtils.split(string, ",")));
        }
        return this.e;
    }

    public Set<String> c() {
        if (this.d == null) {
            String string = GDTADManager.getInstance().getSM().getString("web_proxy_res_suffix");
            if (TextUtils.isEmpty(string)) {
                string = "html,js,css";
            }
            this.d = new HashSet(Arrays.asList(TextUtils.split(string, ",")));
        }
        return this.d;
    }

    public void d() {
        this.d = null;
        this.e = null;
    }
}
