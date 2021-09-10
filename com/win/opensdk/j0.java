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
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes10.dex */
public class j0 extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public l0 f77068a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f77069b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f77070c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ n0 f77071d;

    public j0(n0 n0Var, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n0Var, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77071d = n0Var;
        this.f77069b = str;
        this.f77070c = z;
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
                httpURLConnection = (HttpURLConnection) new URL(this.f77069b).openConnection();
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
            }
            try {
                try {
                    if (this.f77070c) {
                        httpURLConnection.connect();
                        int contentLength = httpURLConnection.getContentLength();
                        if (contentLength <= 0) {
                            this.f77068a = new l0("Invalid content length. The URL is probably not pointing to a file");
                            cancel(true);
                        }
                        inputStream = new BufferedInputStream(httpURLConnection.getInputStream(), 8192);
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[8192];
                            long j2 = 0;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                j2 += read;
                                byteArrayOutputStream.write(bArr, 0, read);
                                Integer[] numArr = new Integer[i2];
                                numArr[0] = Integer.valueOf((int) ((100 * j2) / contentLength));
                                publishProgress(numArr);
                                i2 = 1;
                            }
                            decodeStream = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                            byteArrayOutputStream2 = byteArrayOutputStream;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                if (!isCancelled()) {
                                    this.f77068a = new l0(th);
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
            this.f77071d.f77112b.remove(this.f77069b);
            this.f77071d.f77111a.a(this.f77068a);
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            Bitmap bitmap = (Bitmap) obj;
            if (bitmap == null) {
                this.f77071d.f77111a.a(new l0("downloaded file could not be decoded as bitmap"));
            } else {
                this.f77071d.f77111a.a(bitmap);
            }
            this.f77071d.f77112b.remove(this.f77069b);
            System.gc();
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f77071d.f77112b.add(this.f77069b);
        }
    }

    @Override // android.os.AsyncTask
    public void onProgressUpdate(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, objArr) == null) {
            this.f77071d.f77111a.a(((Integer[]) objArr)[0].intValue());
        }
    }
}
