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
    private static e orj = new e();
    private static String ork = "";
    private ExecutorService ori = Executors.newCachedThreadPool();

    private e() {
    }

    public static e dZv() {
        return orj;
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
    private String TF(String str) {
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
        String TF = TF(getCpuName());
        ork = str2;
        tv.chushou.a.a.c.a.dZR().d(TAG, "cpuArchitect: " + TF);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory()) {
                    String name = nextElement.getName();
                    if (name.endsWith(PluginInstallerService.APK_LIB_SUFFIX) && name.contains(TF)) {
                        long time = nextElement.getTime();
                        if (time == tv.chushou.basis.a.a.bg(context, name)) {
                            tv.chushou.a.a.c.a.dZR().d(TAG, "skip copying, the so lib is exist and not change: " + name);
                        } else {
                            this.ori.execute(new a(context, zipFile, nextElement, time));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv.chushou.a.a.c.a.dZR().d(TAG, "### copy so time : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    /* loaded from: classes6.dex */
    private class a implements Runnable {
        private Context mContext;
        private String orl;
        private ZipFile orm;
        private ZipEntry orn;
        private long oro;

        a(Context context, ZipFile zipFile, ZipEntry zipEntry, long j) {
            this.orm = zipFile;
            this.mContext = context;
            this.orn = zipEntry;
            this.orl = TG(zipEntry.getName());
            this.oro = j;
        }

        private final String TG(String str) {
            return str.substring(str.lastIndexOf("/") + 1);
        }

        private void dZw() throws IOException {
            copy(this.orm.getInputStream(this.orn), new FileOutputStream(new File(e.ork, this.orl)));
            this.orm.close();
        }

        public void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
            if (inputStream != null && outputStream != null) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                int K = K(bufferedInputStream);
                byte[] bArr = new byte[K];
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, K);
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

        private int K(InputStream inputStream) throws IOException {
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
                dZw();
                tv.chushou.basis.a.a.d(this.mContext, this.orn.getName(), this.oro);
                tv.chushou.a.a.c.a.dZR().d(e.TAG, "copy so lib success: " + this.orn.getName());
            } catch (IOException e) {
                tv.chushou.a.a.c.a.dZR().e(e.TAG, "copy so lib failed: " + e.toString());
                e.printStackTrace();
            }
        }
    }
}
