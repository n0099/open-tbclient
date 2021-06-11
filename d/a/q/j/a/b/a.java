package d.a.q.j.a.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.trusts.zone.TrustSubject;
import d.a.q.g.c.a.c;
import d.a.q.g.c.a.d;
import d.a.q.g.c.a.f;
import d.a.q.g.d.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f68046f = {"f0fb772cce0da4ed791213b800defea286494ab98d00e1101cbf78a35e70ec4b"};

    /* renamed from: a  reason: collision with root package name */
    public String f68047a;

    /* renamed from: b  reason: collision with root package name */
    public Context f68048b;

    /* renamed from: c  reason: collision with root package name */
    public a.C1846a f68049c;

    /* renamed from: d  reason: collision with root package name */
    public ZipFile f68050d;

    /* renamed from: e  reason: collision with root package name */
    public PackageManager f68051e;

    /* renamed from: d.a.q.j.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1856a implements FilenameFilter {
        public C1856a(a aVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".cfgtmp");
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f68052a;

        public static b a(a aVar) {
            try {
                String b2 = aVar.b("info");
                if (TextUtils.isEmpty(b2)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(b2);
                b bVar = new b();
                bVar.f68052a = jSONObject.getLong("version");
                return bVar;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public long a() {
        try {
            Bundle bundle = this.f68051e.getPackageInfo(this.f68047a, 128).applicationInfo.metaData;
            if (bundle != null) {
                String string = bundle.getString("com.baidu.helios.tc.qver");
                if (TextUtils.isEmpty(string) || !string.startsWith("v")) {
                    return -1L;
                }
                return Long.valueOf(string.substring(1)).longValue();
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public String b(String str) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = e(str);
                return d.b(inputStream, "UTF-8");
            } catch (IOException e2) {
                throw new TrustSubject.ConfigNotFoundException(e2);
            }
        } finally {
            c.b(inputStream);
        }
    }

    public void c(String str, Context context, a.C1846a c1846a) {
        this.f68047a = str;
        this.f68048b = context;
        this.f68049c = c1846a;
        this.f68051e = context.getPackageManager();
    }

    public int d() {
        File file;
        FileOutputStream fileOutputStream;
        try {
            AssetManager assets = this.f68048b.createPackageContext(this.f68047a, 0).getAssets();
            this.f68049c.a();
            File k = k();
            InputStream inputStream = null;
            try {
                k.delete();
                file = File.createTempFile("cfg", ".cfgtmp", k.getParentFile());
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        try {
                            inputStream = assets.open("com.baidu.helios/c.dat");
                            d.a(inputStream, fileOutputStream, 16384);
                            try {
                                X509Certificate[][] s = com.baidu.helios.trusts.zone.verifier.b.s(file);
                                if (s.length == 0) {
                                    c.b(inputStream);
                                    c.b(fileOutputStream);
                                    if (file != null) {
                                        try {
                                            file.delete();
                                        } catch (Exception unused) {
                                        }
                                    }
                                    return 3;
                                }
                                HashSet hashSet = new HashSet();
                                for (X509Certificate[] x509CertificateArr : s) {
                                    if (x509CertificateArr != null) {
                                        for (X509Certificate x509Certificate : x509CertificateArr) {
                                            if (x509Certificate != null) {
                                                hashSet.add(f.c(x509Certificate.getSignature()));
                                            }
                                        }
                                    }
                                }
                                HashSet hashSet2 = new HashSet();
                                Collections.addAll(hashSet2, f68046f);
                                if (!hashSet2.equals(hashSet)) {
                                    c.b(inputStream);
                                    c.b(fileOutputStream);
                                    if (file != null) {
                                        try {
                                            file.delete();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    return 3;
                                }
                                file.renameTo(k);
                                c.b(inputStream);
                                c.b(fileOutputStream);
                                if (file != null) {
                                    try {
                                        file.delete();
                                    } catch (Exception unused3) {
                                    }
                                }
                                return 0;
                            } catch (Exception unused4) {
                                c.b(inputStream);
                                c.b(fileOutputStream);
                                if (file != null) {
                                    try {
                                        file.delete();
                                    } catch (Exception unused5) {
                                    }
                                }
                                return 3;
                            }
                        } catch (Throwable th) {
                            th = th;
                            c.b(inputStream);
                            c.b(fileOutputStream);
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Exception unused6) {
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException unused7) {
                        c.b(inputStream);
                        c.b(fileOutputStream);
                        if (file != null) {
                            try {
                                file.delete();
                            } catch (Exception unused8) {
                            }
                        }
                        return 5;
                    } catch (IOException unused9) {
                        c.b(inputStream);
                        c.b(fileOutputStream);
                        if (file != null) {
                            try {
                                file.delete();
                            } catch (Exception unused10) {
                            }
                        }
                        return 2;
                    } catch (Exception unused11) {
                        c.b(inputStream);
                        c.b(fileOutputStream);
                        if (file != null) {
                            try {
                                file.delete();
                            } catch (Exception unused12) {
                            }
                        }
                        return 4;
                    }
                } catch (FileNotFoundException unused13) {
                    fileOutputStream = null;
                } catch (IOException unused14) {
                    fileOutputStream = null;
                } catch (Exception unused15) {
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (FileNotFoundException unused16) {
                file = null;
                fileOutputStream = null;
            } catch (IOException unused17) {
                file = null;
                fileOutputStream = null;
            } catch (Exception unused18) {
                file = null;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                file = null;
                fileOutputStream = null;
            }
        } catch (Exception unused19) {
            return 1;
        }
    }

    public final InputStream e(String str) {
        try {
            return this.f68050d.getInputStream(new ZipEntry(str));
        } catch (Exception e2) {
            throw new TrustSubject.ConfigNotFoundException(e2);
        }
    }

    public boolean f() {
        return k().delete();
    }

    public boolean g() {
        File[] listFiles = this.f68049c.b().listFiles(new C1856a(this));
        int i2 = 0;
        if (listFiles != null) {
            int length = listFiles.length;
            boolean z = false;
            while (i2 < length) {
                listFiles[i2].delete();
                i2++;
                z = true;
            }
            return z;
        }
        return false;
    }

    public boolean h() {
        if (this.f68050d != null) {
            return true;
        }
        File k = k();
        if (k.exists()) {
            try {
                this.f68050d = new ZipFile(k);
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean i() {
        ZipFile zipFile = this.f68050d;
        if (zipFile != null) {
            c.d(zipFile);
            this.f68050d = null;
            return true;
        }
        return false;
    }

    public long j() {
        b a2 = b.a(this);
        if (a2 != null) {
            return a2.f68052a;
        }
        return 0L;
    }

    public final File k() {
        return this.f68049c.d("c.dat");
    }
}
