package d.a.c.j;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.titan.TitanDownloadService;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.db.PackageTable;
import d.a.c.j.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42973a = d.a.c.j.a.f42956a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f42974b = false;

    /* loaded from: classes.dex */
    public static class a extends d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f42975a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f42976b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f42977c;

        public a(f fVar, String str, Context context) {
            this.f42975a = fVar;
            this.f42976b = str;
            this.f42977c = context;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.j.d.b
        /* renamed from: d */
        public void b(int i2, String str, JSONObject jSONObject) {
            this.f42975a.a(this.f42976b, -1, null);
            try {
                try {
                    if (jSONObject != null) {
                        if (i.f42973a) {
                            Log.d(TitanDownloadService.TAG, "onResponse " + jSONObject);
                        }
                        PackageInfo k = i.k(this.f42977c, jSONObject);
                        if (k.errNo != 0) {
                            if (i.f42973a) {
                                Log.d(TitanDownloadService.TAG, "return fail result");
                            }
                            if (k.errNo != -2) {
                                Log.d(TitanDownloadService.TAG, "patch data errno = " + k.errNo);
                            }
                            this.f42975a.a(this.f42976b, -1, null);
                            synchronized (i.class) {
                                boolean unused = i.f42974b = false;
                            }
                            return;
                        }
                        Log.d(TitanDownloadService.TAG, "start install patch");
                        j.b(this.f42977c, this.f42975a, k, true);
                        synchronized (i.class) {
                            boolean unused2 = i.f42974b = false;
                        }
                        return;
                    }
                    Log.d(TitanDownloadService.TAG, "response parse fail");
                    this.f42975a.a(this.f42976b, -1, null);
                    synchronized (i.class) {
                        boolean unused3 = i.f42974b = false;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f42975a.a(this.f42976b, -1, null);
                    synchronized (i.class) {
                        boolean unused4 = i.f42974b = false;
                    }
                }
            } catch (Throwable th) {
                synchronized (i.class) {
                    boolean unused5 = i.f42974b = false;
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements d.b<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f42978a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f42979b;

        public b(File file, String str) {
            this.f42978a = file;
            this.f42979b = str;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.j.d.b
        public /* bridge */ /* synthetic */ InputStream a(int i2, String str, InputStream inputStream) throws IOException {
            d(i2, str, inputStream);
            return inputStream;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.j.d.b
        /* renamed from: c */
        public void b(int i2, String str, InputStream inputStream) {
            MessageDigest messageDigest;
            FileOutputStream fileOutputStream;
            if (inputStream == null) {
                if (i.f42973a) {
                    Log.d(TitanDownloadService.TAG, "download patch inputstream is null");
                    return;
                }
                return;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                    fileOutputStream = new FileOutputStream(this.f42978a);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    messageDigest.update(bArr, 0, read);
                }
                String e3 = i.e(messageDigest.digest());
                if (i.f42973a) {
                    Log.d(TitanDownloadService.TAG, "download file md5 = " + e3);
                }
                if (!TextUtils.equals(this.f42979b, e3)) {
                    Log.d(TitanDownloadService.TAG, "patch md5 not match");
                    fileOutputStream.close();
                    this.f42978a.delete();
                }
                Closeables.closeSafely(inputStream);
                Closeables.closeSafely(fileOutputStream);
            } catch (Exception e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                this.f42978a.delete();
                e.printStackTrace();
                Closeables.closeSafely(inputStream);
                Closeables.closeSafely(fileOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                Closeables.closeSafely(inputStream);
                Closeables.closeSafely(fileOutputStream2);
                throw th;
            }
        }

        public InputStream d(int i2, String str, InputStream inputStream) {
            return inputStream;
        }
    }

    public static String e(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static void f(Context context, String str, f fVar) {
        synchronized (i.class) {
            if (f42974b) {
                if (f42973a) {
                    Log.d(TitanDownloadService.TAG, "doInstall is installing");
                }
                return;
            }
            f42974b = true;
            String z = e.p().z(i());
            if (f42973a) {
                Log.d(TitanDownloadService.TAG, "url = " + z);
            }
            Log.d(TitanDownloadService.TAG, "start require patch data");
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            d.d(context, z, "POST", h(), hashMap, new a(fVar, str, context));
        }
    }

    public static String g(Context context, String str, String str2, String str3) {
        File[] listFiles;
        File j = j(context);
        for (File file : j.listFiles()) {
            if (file.isFile()) {
                file.delete();
            }
        }
        File file2 = new File(j, str3);
        Log.d(TitanDownloadService.TAG, "start download patch");
        d.d(context, str, "GET", null, null, new b(file2, str2));
        if (file2.exists()) {
            return file2.getAbsolutePath();
        }
        return null;
    }

    public static byte[] h() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        h d2 = h.d();
        d2.g();
        JSONObject jSONObject5 = new JSONObject();
        try {
            jSONObject4.put("com.baidu.titan.patch", String.valueOf(d2.b()));
            jSONObject3.put("126", jSONObject4);
            jSONObject2.put("aps", jSONObject3);
            jSONObject.put("versions", jSONObject2);
            jSONObject5.put("bd_version", AppConfig.AppInfo.getVersionName());
            jSONObject5.put("device_ua", "android");
            jSONObject.put("pubparam", jSONObject5);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        try {
            String jSONObject6 = jSONObject.toString();
            if (d.a.c.j.a.f42956a) {
                Log.d(TitanDownloadService.TAG, "getCcsContent = " + jSONObject6);
            }
            return jSONObject6.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static String i() {
        return d.a.c.j.b.a() + "?runtype=aps_126&appname=tieba";
    }

    public static File j(Context context) {
        File file = new File(new File(context.getCacheDir(), "titan_sandbox_cache"), "patch_cache");
        file.mkdirs();
        return file;
    }

    public static PackageInfo k(Context context, JSONObject jSONObject) throws JSONException {
        PackageInfo packageInfo = new PackageInfo();
        int optInt = jSONObject.optInt("errno", -1);
        packageInfo.errNo = optInt;
        if (optInt != 0) {
            if (f42973a) {
                Log.d(TitanDownloadService.TAG, "response errno = " + optInt);
            }
            return packageInfo;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        if (!jSONObject2.has("service")) {
            packageInfo.errNo = -2;
            return packageInfo;
        }
        JSONObject jSONObject3 = jSONObject2.getJSONObject("service");
        if (!jSONObject3.has("aps")) {
            packageInfo.errNo = -2;
            return packageInfo;
        }
        JSONObject jSONObject4 = jSONObject3.getJSONObject("aps");
        if (!jSONObject4.has("126")) {
            packageInfo.errNo = -2;
            return packageInfo;
        }
        JSONObject jSONObject5 = jSONObject4.getJSONObject("126");
        if (!jSONObject5.has("com.baidu.titan.patch")) {
            packageInfo.errNo = -2;
            return packageInfo;
        }
        JSONObject jSONObject6 = jSONObject5.getJSONObject("com.baidu.titan.patch");
        String string = jSONObject6.getString("version");
        JSONObject jSONObject7 = jSONObject6.getJSONObject("data").getJSONObject("pkg_info");
        String string2 = jSONObject7.getString("version");
        String string3 = jSONObject7.getString("name");
        String string4 = jSONObject7.getString(PackageTable.MD5);
        String string5 = jSONObject7.getString("maxv");
        String string6 = jSONObject7.getString("minv");
        String string7 = jSONObject7.getString("download_url");
        if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string4) && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string7)) {
            String g2 = g(context, string7, string4, "com.baidu.titan.patch_" + string4 + ".apk");
            if (g2 == null) {
                packageInfo.errNo = -4;
                return packageInfo;
            }
            packageInfo.filePath = g2;
            packageInfo.packageName = "com.baidu.titan.patch";
            packageInfo.version = Long.valueOf(string2).longValue();
            packageInfo.maxHostVersion = string5;
            packageInfo.minHostVersion = string6;
            packageInfo.updateVersion = Long.valueOf(string).longValue();
            return packageInfo;
        }
        packageInfo.errNo = -3;
        return packageInfo;
    }
}
