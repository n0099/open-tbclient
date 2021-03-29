package com.win.opensdk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes7.dex */
public class U extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    public W f39813a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f39814b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f39815c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Y f39816d;

    public U(Y y, String str, boolean z) {
        this.f39816d = y;
        this.f39814b = str;
        this.f39815c = z;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IF] complete} */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a6 A[Catch: all -> 0x00cc, TRY_LEAVE, TryCatch #5 {all -> 0x00cc, blocks: (B:41:0x00a0, B:43:0x00a6), top: B:78:0x00a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bb A[Catch: Exception -> 0x00b7, TryCatch #2 {Exception -> 0x00b7, blocks: (B:45:0x00b3, B:49:0x00bb, B:51:0x00c3), top: B:73:0x00b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c3 A[Catch: Exception -> 0x00b7, TRY_LEAVE, TryCatch #2 {Exception -> 0x00b7, blocks: (B:45:0x00b3, B:49:0x00bb, B:51:0x00c3), top: B:73:0x00b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doInBackground(Object[] objArr) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Bitmap decodeStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        Void[] voidArr = (Void[]) objArr;
        int i = 1;
        try {
            httpURLConnection = (HttpURLConnection) new URL(this.f39814b).openConnection();
            try {
                try {
                    if (this.f39815c) {
                        httpURLConnection.connect();
                        int contentLength = httpURLConnection.getContentLength();
                        if (contentLength <= 0) {
                            this.f39813a = new W("Invalid content length. The URL is probably not pointing to a file");
                            cancel(true);
                        }
                        inputStream = new BufferedInputStream(httpURLConnection.getInputStream(), 8192);
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[8192];
                            long j = 0;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                j += read;
                                byteArrayOutputStream.write(bArr, 0, read);
                                Integer[] numArr = new Integer[i];
                                numArr[0] = Integer.valueOf((int) ((100 * j) / contentLength));
                                publishProgress(numArr);
                                i = 1;
                            }
                            decodeStream = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                            byteArrayOutputStream2 = byteArrayOutputStream;
                        } catch (Throwable th) {
                            th = th;
                            try {
                                if (!isCancelled()) {
                                    this.f39813a = new W(th);
                                    cancel(true);
                                }
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                        return null;
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.flush();
                                    byteArrayOutputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                return null;
                            } catch (Throwable th2) {
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                        throw th2;
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.flush();
                                    byteArrayOutputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th2;
                            }
                        }
                    } else {
                        inputStream = httpURLConnection.getInputStream();
                        decodeStream = BitmapFactory.decodeStream(inputStream);
                        byteArrayOutputStream2 = null;
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return decodeStream;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    if (!isCancelled()) {
                    }
                    if (httpURLConnection != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                byteArrayOutputStream = null;
                if (!isCancelled()) {
                }
                if (httpURLConnection != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                if (inputStream != null) {
                }
                return null;
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
        }
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        this.f39816d.f39836b.remove(this.f39814b);
        ((j) this.f39816d.f39835a).a(this.f39813a);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        File file;
        File file2;
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap == null) {
            ((j) this.f39816d.f39835a).a(new W("downloaded file could not be decoded as bitmap"));
        } else {
            j jVar = (j) this.f39816d.f39835a;
            PBSplash pBSplash = jVar.f39956b;
            if (pBSplash.j) {
                file = pBSplash.l;
                if (!file.exists()) {
                    file2 = jVar.f39956b.l;
                    i iVar = new i(jVar);
                    Bitmap.CompressFormat compressFormat = jVar.f39955a;
                    if (file2.isDirectory()) {
                        new W("the specified path points to a directory, should be a file");
                    } else if (file2.exists()) {
                        new W("file already exists, write operation cancelled");
                    } else {
                        File parentFile = file2.getParentFile();
                        if (parentFile.exists() || parentFile.mkdirs()) {
                            try {
                                if (file2.createNewFile()) {
                                    new V(file2, bitmap, compressFormat, iVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                } else {
                                    new W("could not create file");
                                }
                            } catch (IOException e2) {
                                new W(e2);
                            }
                        } else {
                            new W("could not create parent directory");
                        }
                    }
                }
            } else {
                PBSplashListener pBSplashListener = pBSplash.f39764e;
                if (pBSplashListener != null) {
                    pBSplash.f39762c = bitmap;
                    pBSplashListener.onLoaded();
                    jVar.f39956b.i = true;
                }
            }
        }
        this.f39816d.f39836b.remove(this.f39814b);
        System.gc();
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        this.f39816d.f39836b.add(this.f39814b);
    }

    @Override // android.os.AsyncTask
    public void onProgressUpdate(Object[] objArr) {
        ((j) this.f39816d.f39835a).a(((Integer[]) objArr)[0].intValue());
    }
}
