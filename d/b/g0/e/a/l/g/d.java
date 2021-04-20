package d.b.g0.e.a.l.g;

import android.os.Process;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import com.baidu.swan.game.ad.downloader.exception.DownloadPauseException;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
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
    public final d.b.g0.e.a.l.i.d f47999e;

    /* renamed from: f  reason: collision with root package name */
    public final DownloadInfo f48000f;

    /* renamed from: g  reason: collision with root package name */
    public final a f48001g;

    /* renamed from: h  reason: collision with root package name */
    public long f48002h;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();
    }

    public d(d.b.g0.e.a.l.i.d dVar, DownloadInfo downloadInfo, a aVar) {
        this.f47999e = dVar;
        this.f48000f = downloadInfo;
        this.f48002h = downloadInfo.getProgress();
        this.f48001g = aVar;
    }

    public final void a() {
        if (this.f48000f.isPause()) {
            throw new DownloadPauseException(7);
        }
    }

    public final void b() {
        InputStream inputStream;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        Exception e2;
        IOException e3;
        ProtocolException e4;
        InputStream inputStream2 = null;
        try {
            try {
                try {
                    URL url = new URL(this.f48000f.getUri());
                    long j = this.f48002h;
                    Response execute = new OkHttpClient().newCall(new Request.Builder().addHeader("RANGE", "bytes=" + j + "-").url(url).build()).execute();
                    if (execute != null) {
                        inputStream = execute.body().byteStream();
                        try {
                            randomAccessFile2 = new RandomAccessFile(this.f48000f.getPath(), "rw");
                            try {
                                randomAccessFile2.seek(j);
                                byte[] bArr = new byte[1024];
                                int i = 0;
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    a();
                                    i += read;
                                    randomAccessFile2.write(bArr, 0, read);
                                    this.f48000f.setProgress(this.f48002h + i);
                                    this.f48001g.b();
                                }
                                execute.body().close();
                                this.f48001g.a();
                                inputStream2 = inputStream;
                            } catch (DownloadPauseException unused) {
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (randomAccessFile2 != null) {
                                    randomAccessFile2.close();
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
                            randomAccessFile2 = null;
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
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                    throw th;
                                }
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            throw th;
                        }
                    } else {
                        randomAccessFile2 = null;
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            } catch (DownloadPauseException unused3) {
                randomAccessFile2 = null;
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
            if (execute == null || !execute.isSuccessful()) {
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
            if (this.f48000f.getSize() <= 0) {
                long c2 = c(this.f48000f.getUri());
                if (c2 > 0) {
                    this.f48000f.setSize(c2);
                } else {
                    throw new DownloadException(6, "length <= 0");
                }
            }
            this.f48000f.setStatus(SwanAdDownloadState.DOWNLOADING.value());
            this.f47999e.b(this.f48000f);
            b();
        } catch (DownloadException e2) {
            this.f48000f.setStatus(SwanAdDownloadState.DOWNLOAD_FAILED.value());
            this.f48000f.setException(e2);
            this.f47999e.b(this.f48000f);
            this.f47999e.a(e2);
        }
    }
}
