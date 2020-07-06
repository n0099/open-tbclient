package com.qiniu.android.collect;

import com.qiniu.android.http.UserAgent;
import com.qiniu.android.storage.UpToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes5.dex */
public final class UploadInfoCollector {
    private static UploadInfoCollector nCs;
    private final String nCt;
    private final String nCu;
    private File nCv = null;
    private long nCw;
    private static ExecutorService nCr = null;
    private static OkHttpClient httpClient = null;

    /* loaded from: classes5.dex */
    public static abstract class RecordMsg {
        public abstract String dMF();
    }

    private UploadInfoCollector(String str, String str2) {
        this.nCu = str;
        this.nCt = str2;
        try {
            dME();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static UploadInfoCollector dMD() {
        if (nCs == null) {
            nCs = new UploadInfoCollector("_qiniu_record_file_hs5z9lo7anx03", "https://uplog.qbox.me/log/3");
        }
        return nCs;
    }

    public static void a(UpToken upToken, RecordMsg recordMsg) {
        try {
            if (Config.nCn) {
                dMD().c(upToken, recordMsg);
            }
        } catch (Throwable th) {
        }
    }

    public static void b(UpToken upToken, RecordMsg recordMsg) {
        a(upToken, recordMsg);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=5, 118=4] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b(File file, String str, boolean z) {
        FileOutputStream fileOutputStream;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, z);
                try {
                    fileOutputStream.write(str.getBytes(Charset.forName("UTF-8")));
                    fileOutputStream.flush();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            fileOutputStream = null;
        } catch (IOException e8) {
            e = e8;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    private static OkHttpClient alD() {
        if (httpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(10L, TimeUnit.SECONDS);
            builder.readTimeout(15L, TimeUnit.SECONDS);
            builder.writeTimeout((((Config.ayh / 2) + 1) * 60) - 10, TimeUnit.SECONDS);
            httpClient = builder.build();
        }
        return httpClient;
    }

    private void dME() throws IOException {
        if (Config.nCn) {
            am(RA(Config.nCo));
        }
        if (!Config.nCn && nCr != null) {
            nCr.shutdown();
        }
        if (Config.nCn) {
            if (nCr == null || nCr.isShutdown()) {
                nCr = Executors.newSingleThreadExecutor();
            }
        }
    }

    private File RA(String str) {
        return new File(str);
    }

    private void am(File file) throws IOException {
        if (file == null) {
            throw new IOException("record's dir is not setted");
        }
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new IOException("mkdir failed: " + file.getAbsolutePath());
            }
        } else if (!file.isDirectory()) {
            throw new IOException(file.getAbsolutePath() + " is not a dir");
        } else {
            this.nCv = new File(file, this.nCu);
        }
    }

    private void c(final UpToken upToken, final RecordMsg recordMsg) {
        if (nCr != null && !nCr.isShutdown()) {
            nCr.submit(new Runnable() { // from class: com.qiniu.android.collect.UploadInfoCollector.1
                @Override // java.lang.Runnable
                public void run() {
                    if (Config.nCn) {
                        try {
                            UploadInfoCollector.this.o(recordMsg.dMF(), UploadInfoCollector.this.nCv);
                        } catch (Throwable th) {
                        }
                    }
                }
            });
            if (Config.isUpload && upToken != UpToken.nEe) {
                nCr.submit(new Runnable() { // from class: com.qiniu.android.collect.UploadInfoCollector.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Config.nCn && Config.isUpload) {
                            try {
                                UploadInfoCollector.this.a(upToken, UploadInfoCollector.this.nCv);
                            } catch (Throwable th) {
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, File file) {
        if (Config.nCn && file.length() < Config.nCp) {
            b(file, str + "\n", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpToken upToken, File file) {
        if (Config.isUpload && file.length() > Config.nCq) {
            long time = new Date().getTime();
            if (time > this.nCw + (Config.ayh * 60 * 1000)) {
                this.nCw = time;
                if (b(upToken, file)) {
                    b(file, "", false);
                    b(file, "", false);
                }
            }
        }
    }

    private boolean b(UpToken upToken, File file) {
        try {
            Response execute = alD().newCall(new Request.Builder().url(this.nCt).addHeader("Authorization", "UpToken " + upToken.token).addHeader("User-Agent", UserAgent.dMN().RH(upToken.nCH)).post(RequestBody.create(MediaType.parse("text/plain"), file)).build()).execute();
            boolean g = g(execute);
            try {
                execute.body().close();
                return g;
            } catch (Exception e) {
                return g;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private boolean g(Response response) {
        return response.isSuccessful() && response.header("X-Reqid") != null;
    }
}
