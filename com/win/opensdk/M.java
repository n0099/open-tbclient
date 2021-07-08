package com.win.opensdk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes6.dex */
public class M extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public O f39415a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f39416b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f39417c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Q f39418d;

    public M(Q q, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39418d = q;
        this.f39416b = str;
        this.f39417c = z;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IF] complete} */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00aa A[Catch: all -> 0x00d0, TRY_LEAVE, TryCatch #0 {all -> 0x00d0, blocks: (B:43:0x00a4, B:45:0x00aa), top: B:75:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bf A[Catch: Exception -> 0x00bb, TryCatch #2 {Exception -> 0x00bb, blocks: (B:47:0x00b7, B:51:0x00bf, B:53:0x00c7), top: B:79:0x00b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c7 A[Catch: Exception -> 0x00bb, TRY_LEAVE, TryCatch #2 {Exception -> 0x00bb, blocks: (B:47:0x00b7, B:51:0x00bf, B:53:0x00c7), top: B:79:0x00b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doInBackground(Object[] objArr) {
        InterceptResult invokeL;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Bitmap decodeStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
            Void[] voidArr = (Void[]) objArr;
            int i2 = 1;
            try {
                httpURLConnection = (HttpURLConnection) new URL(this.f39416b).openConnection();
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
            }
            try {
                try {
                    if (this.f39417c) {
                        httpURLConnection.connect();
                        int contentLength = httpURLConnection.getContentLength();
                        if (contentLength <= 0) {
                            this.f39415a = new O("Invalid content length. The URL is probably not pointing to a file");
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
                                Integer[] numArr = new Integer[i2];
                                numArr[0] = Integer.valueOf((int) ((100 * j) / contentLength));
                                publishProgress(numArr);
                                i2 = 1;
                            }
                            decodeStream = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                            byteArrayOutputStream2 = byteArrayOutputStream;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                if (!isCancelled()) {
                                    this.f39415a = new O(th);
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
                            } catch (Throwable th3) {
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                        throw th3;
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.flush();
                                    byteArrayOutputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th3;
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
                } catch (Throwable th4) {
                    th = th4;
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
        }
        return invokeL.objValue;
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f39418d.f39455b.remove(this.f39416b);
            ((j) this.f39418d.f39454a).a(this.f39415a);
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        File file;
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            Bitmap bitmap = (Bitmap) obj;
            if (bitmap == null) {
                ((j) this.f39418d.f39454a).a(new O("downloaded file could not be decoded as bitmap"));
            } else {
                j jVar = (j) this.f39418d.f39454a;
                PBSplash pBSplash = jVar.f39612b;
                if (pBSplash.j) {
                    file = pBSplash.l;
                    if (!file.exists()) {
                        file2 = jVar.f39612b.l;
                        i iVar = new i(jVar);
                        Bitmap.CompressFormat compressFormat = jVar.f39611a;
                        if (file2.isDirectory()) {
                            new O("the specified path points to a directory, should be a file");
                        } else if (file2.exists()) {
                            new O("file already exists, write operation cancelled");
                        } else {
                            File parentFile = file2.getParentFile();
                            if (parentFile.exists() || parentFile.mkdirs()) {
                                try {
                                    if (file2.createNewFile()) {
                                        new N(file2, bitmap, compressFormat, iVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                    } else {
                                        new O("could not create file");
                                    }
                                } catch (IOException e2) {
                                    new O(e2);
                                }
                            } else {
                                new O("could not create parent directory");
                            }
                        }
                    }
                } else {
                    PBSplashListener pBSplashListener = pBSplash.f39446e;
                    if (pBSplashListener != null) {
                        pBSplash.f39444c = bitmap;
                        pBSplashListener.onLoaded();
                        jVar.f39612b.f39450i = true;
                    }
                }
            }
            this.f39418d.f39455b.remove(this.f39416b);
            System.gc();
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f39418d.f39455b.add(this.f39416b);
        }
    }

    @Override // android.os.AsyncTask
    public void onProgressUpdate(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, objArr) == null) {
            ((j) this.f39418d.f39454a).a(((Integer[]) objArr)[0].intValue());
        }
    }
}
