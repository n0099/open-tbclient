package d.a.i0.f.i.k.d;

import android.os.Process;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import com.baidu.swan.game.ad.downloader.exception.DownloadPauseException;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import d.a.i0.f.i.k.f.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final e f46563e;

    /* renamed from: f  reason: collision with root package name */
    public final DownloadInfo f46564f;

    /* renamed from: g  reason: collision with root package name */
    public final a f46565g;

    /* renamed from: h  reason: collision with root package name */
    public long f46566h;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();
    }

    public d(e eVar, DownloadInfo downloadInfo, a aVar) {
        this.f46563e = eVar;
        this.f46564f = downloadInfo;
        this.f46566h = downloadInfo.getProgress();
        this.f46565g = aVar;
    }

    public final void a() {
        if (this.f46564f.isPause()) {
            throw new DownloadPauseException(7);
        }
    }

    public final void b() {
        InputStream inputStream;
        RandomAccessFile randomAccessFile;
        Exception e2;
        IOException e3;
        ProtocolException e4;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                try {
                    URL url = new URL(this.f46564f.getUri());
                    long j = this.f46566h;
                    Response execute = new OkHttpClient().newCall(new Request.Builder().addHeader("RANGE", "bytes=" + j + "-").url(url).build()).execute();
                    if (execute == null || execute.body() == null) {
                        inputStream = null;
                    } else {
                        inputStream = execute.body().byteStream();
                        try {
                            RandomAccessFile randomAccessFile3 = new RandomAccessFile(this.f46564f.getPath(), "rw");
                            try {
                                randomAccessFile3.seek(j);
                                byte[] bArr = new byte[1024];
                                int i2 = 0;
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    a();
                                    i2 += read;
                                    randomAccessFile3.write(bArr, 0, read);
                                    this.f46564f.setProgress(this.f46566h + i2);
                                    this.f46565g.b();
                                }
                                execute.body().close();
                                this.f46565g.a();
                                randomAccessFile2 = randomAccessFile3;
                            } catch (DownloadPauseException unused) {
                                randomAccessFile2 = randomAccessFile3;
                                if (randomAccessFile2 != null) {
                                    randomAccessFile2.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    return;
                                }
                                return;
                            } catch (ProtocolException e5) {
                                e4 = e5;
                                throw new DownloadException(4, "Protocol error", e4);
                            } catch (IOException e6) {
                                e3 = e6;
                                throw new DownloadException(5, "IO error", e3);
                            } catch (Exception e7) {
                                e2 = e7;
                                throw new DownloadException(9, "other error", e2);
                            }
                        } catch (DownloadPauseException unused2) {
                        } catch (ProtocolException e8) {
                            e = e8;
                            e4 = e;
                            throw new DownloadException(4, "Protocol error", e4);
                        } catch (IOException e9) {
                            e = e9;
                            e3 = e;
                            throw new DownloadException(5, "IO error", e3);
                        } catch (Exception e10) {
                            e = e10;
                            e2 = e;
                            throw new DownloadException(9, "other error", e2);
                        } catch (Throwable th) {
                            th = th;
                            randomAccessFile = null;
                            th = th;
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                    throw th;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    }
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            } catch (DownloadPauseException unused3) {
                inputStream = null;
            } catch (ProtocolException e13) {
                e = e13;
            } catch (IOException e14) {
                e = e14;
            } catch (Exception e15) {
                e = e15;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
                randomAccessFile = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final long c(String str) {
        try {
            Response execute = new OkHttpClient().newCall(new Request.Builder().url(str).build()).execute();
            if (execute == null || !execute.isSuccessful() || execute.body() == null) {
                return 0L;
            }
            long contentLength = execute.body().contentLength();
            execute.body().close();
            return contentLength;
        } catch (MalformedURLException e2) {
            throw new DownloadException(2, "Bad url.", e2);
        } catch (ProtocolException e3) {
            throw new DownloadException(4, "Protocol error", e3);
        } catch (IOException e4) {
            throw new DownloadException(5, "IO error", e4);
        } catch (Exception e5) {
            throw new DownloadException(9, "Unknown error", e5);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        try {
            if (this.f46564f.getSize() <= 0) {
                long c2 = c(this.f46564f.getUri());
                if (c2 > 0) {
                    this.f46564f.setSize(c2);
                } else {
                    throw new DownloadException(6, "length <= 0");
                }
            }
            this.f46564f.setStatus(DownloadState.DOWNLOADING.value());
            this.f46563e.b(this.f46564f);
            b();
        } catch (DownloadException e2) {
            this.f46564f.setStatus(DownloadState.DOWNLOAD_FAILED.value());
            this.f46564f.setException(e2);
            this.f46563e.b(this.f46564f);
            this.f46563e.a(e2);
        }
    }
}
