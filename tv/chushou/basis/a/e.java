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
    private static e nUM = new e();
    private static String nUN = "";
    private ExecutorService nUL = Executors.newCachedThreadPool();

    private e() {
    }

    public static e dPI() {
        return nUM;
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
    private String SH(String str) {
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
        String SH = SH(getCpuName());
        nUN = str2;
        tv.chushou.a.a.c.a.dQf().d(TAG, "cpuArchitect: " + SH);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory()) {
                    String name = nextElement.getName();
                    if (name.endsWith(PluginInstallerService.APK_LIB_SUFFIX) && name.contains(SH)) {
                        long time = nextElement.getTime();
                        if (time == tv.chushou.basis.a.a.bD(context, name)) {
                            tv.chushou.a.a.c.a.dQf().d(TAG, "skip copying, the so lib is exist and not change: " + name);
                        } else {
                            this.nUL.execute(new a(context, zipFile, nextElement, time));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv.chushou.a.a.c.a.dQf().d(TAG, "### copy so time : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    /* loaded from: classes5.dex */
    private class a implements Runnable {
        private Context mContext;
        private String nUO;
        private ZipFile nUP;
        private ZipEntry nUQ;
        private long nUR;

        a(Context context, ZipFile zipFile, ZipEntry zipEntry, long j) {
            this.nUP = zipFile;
            this.mContext = context;
            this.nUQ = zipEntry;
            this.nUO = SI(zipEntry.getName());
            this.nUR = j;
        }

        private final String SI(String str) {
            return str.substring(str.lastIndexOf("/") + 1);
        }

        private void dPJ() throws IOException {
            copy(this.nUP.getInputStream(this.nUQ), new FileOutputStream(new File(e.nUN, this.nUO)));
            this.nUP.close();
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
                dPJ();
                tv.chushou.basis.a.a.e(this.mContext, this.nUQ.getName(), this.nUR);
                tv.chushou.a.a.c.a.dQf().d(e.TAG, "copy so lib success: " + this.nUQ.getName());
            } catch (IOException e) {
                tv.chushou.a.a.c.a.dQf().e(e.TAG, "copy so lib failed: " + e.toString());
                e.printStackTrace();
            }
        }
    }
}
