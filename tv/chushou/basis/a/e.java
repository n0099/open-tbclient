package tv.chushou.basis.a;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.android.util.devices.IDevices;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes6.dex */
public final class e {
    private static final String TAG = e.class.getSimpleName();
    private static e oUY = new e();
    private static String oUZ = "";
    private ExecutorService oUX = Executors.newCachedThreadPool();

    private e() {
    }

    public static e epG() {
        return oUY;
    }

    private String getCpuName() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            String[] split = readLine.split(":\\s+", 2);
            if (split.length >= 2) {
                return split[1];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    @SuppressLint({"DefaultLocale"})
    private String Xl(String str) {
        if (str.toLowerCase().contains("arm")) {
            return "armeabi";
        }
        if (str.toLowerCase().contains("x86")) {
            return "x86";
        }
        if (!str.toLowerCase().contains(IDevices.ABI_MIPS)) {
            return "armeabi";
        }
        return IDevices.ABI_MIPS;
    }

    public void v(Context context, String str, String str2) {
        String Xl = Xl(getCpuName());
        oUZ = str2;
        tv.chushou.a.a.c.a.eqb().d(TAG, "cpuArchitect: " + Xl);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory()) {
                    String name = nextElement.getName();
                    if (name.endsWith(PluginInstallerService.APK_LIB_SUFFIX) && name.contains(Xl)) {
                        long time = nextElement.getTime();
                        if (time == tv.chushou.basis.a.a.bs(context, name)) {
                            tv.chushou.a.a.c.a.eqb().d(TAG, "skip copying, the so lib is exist and not change: " + name);
                        } else {
                            this.oUX.execute(new a(context, zipFile, nextElement, time));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv.chushou.a.a.c.a.eqb().d(TAG, "### copy so time : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    /* loaded from: classes6.dex */
    private class a implements Runnable {
        private Context mContext;
        private String oVa;
        private ZipFile oVb;
        private ZipEntry oVc;
        private long oVd;

        a(Context context, ZipFile zipFile, ZipEntry zipEntry, long j) {
            this.oVb = zipFile;
            this.mContext = context;
            this.oVc = zipEntry;
            this.oVa = Xm(zipEntry.getName());
            this.oVd = j;
        }

        private final String Xm(String str) {
            return str.substring(str.lastIndexOf("/") + 1);
        }

        private void epH() throws IOException {
            copy(this.oVb.getInputStream(this.oVc), new FileOutputStream(new File(e.oUZ, this.oVa)));
            this.oVb.close();
        }

        public void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
            if (inputStream != null && outputStream != null) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                int L = L(bufferedInputStream);
                byte[] bArr = new byte[L];
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, L);
                    if (read != -1) {
                        bufferedOutputStream.write(bArr, 0, read);
                    } else {
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        bufferedInputStream.close();
                        return;
                    }
                }
            }
        }

        private int L(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return 0;
            }
            int available = inputStream.available();
            if (available <= 0) {
                return 1024;
            }
            return available;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                epH();
                tv.chushou.basis.a.a.d(this.mContext, this.oVc.getName(), this.oVd);
                tv.chushou.a.a.c.a.eqb().d(e.TAG, "copy so lib success: " + this.oVc.getName());
            } catch (IOException e) {
                tv.chushou.a.a.c.a.eqb().e(e.TAG, "copy so lib failed: " + e.toString());
                e.printStackTrace();
            }
        }
    }
}
