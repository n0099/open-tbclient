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
/* loaded from: classes5.dex */
public final class e {
    private static final String TAG = e.class.getSimpleName();
    private static e nWK = new e();
    private static String nWL = "";
    private ExecutorService nWJ = Executors.newCachedThreadPool();

    private e() {
    }

    public static e dQj() {
        return nWK;
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
    private String SI(String str) {
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

    public void x(Context context, String str, String str2) {
        String SI = SI(getCpuName());
        nWL = str2;
        tv.chushou.a.a.c.a.dQG().d(TAG, "cpuArchitect: " + SI);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory()) {
                    String name = nextElement.getName();
                    if (name.endsWith(PluginInstallerService.APK_LIB_SUFFIX) && name.contains(SI)) {
                        long time = nextElement.getTime();
                        if (time == tv.chushou.basis.a.a.bD(context, name)) {
                            tv.chushou.a.a.c.a.dQG().d(TAG, "skip copying, the so lib is exist and not change: " + name);
                        } else {
                            this.nWJ.execute(new a(context, zipFile, nextElement, time));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv.chushou.a.a.c.a.dQG().d(TAG, "### copy so time : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    /* loaded from: classes5.dex */
    private class a implements Runnable {
        private Context mContext;
        private String nWM;
        private ZipFile nWN;
        private ZipEntry nWO;
        private long nWP;

        a(Context context, ZipFile zipFile, ZipEntry zipEntry, long j) {
            this.nWN = zipFile;
            this.mContext = context;
            this.nWO = zipEntry;
            this.nWM = SJ(zipEntry.getName());
            this.nWP = j;
        }

        private final String SJ(String str) {
            return str.substring(str.lastIndexOf("/") + 1);
        }

        private void dQk() throws IOException {
            copy(this.nWN.getInputStream(this.nWO), new FileOutputStream(new File(e.nWL, this.nWM)));
            this.nWN.close();
        }

        public void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
            if (inputStream != null && outputStream != null) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                int M = M(bufferedInputStream);
                byte[] bArr = new byte[M];
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, M);
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

        private int M(InputStream inputStream) throws IOException {
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
                dQk();
                tv.chushou.basis.a.a.d(this.mContext, this.nWO.getName(), this.nWP);
                tv.chushou.a.a.c.a.dQG().d(e.TAG, "copy so lib success: " + this.nWO.getName());
            } catch (IOException e) {
                tv.chushou.a.a.c.a.dQG().e(e.TAG, "copy so lib failed: " + e.toString());
                e.printStackTrace();
            }
        }
    }
}
