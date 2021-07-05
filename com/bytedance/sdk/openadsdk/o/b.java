package com.bytedance.sdk.openadsdk.o;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.o.h;
import com.bytedance.sdk.openadsdk.o.i;
import com.bytedance.sdk.openadsdk.o.l;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends com.bytedance.sdk.openadsdk.o.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object m;
    public final Object n;
    public final int o;
    public final InterfaceC0358b p;
    public volatile h.a q;
    public volatile com.bytedance.sdk.openadsdk.o.c.b r;

    /* renamed from: com.bytedance.sdk.openadsdk.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0358b {
        void a(b bVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar) {
        super(aVar.f31548d, aVar.f31549e);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((com.bytedance.sdk.openadsdk.o.a.a) objArr2[0], (com.bytedance.sdk.openadsdk.o.b.c) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = aVar.f31551g;
        this.p = aVar.f31553i;
        this.m = this;
        this.f31521g = aVar.f31545a;
        this.f31522h = aVar.f31546b;
        this.f31520f = aVar.f31550f;
        this.j = aVar.f31547c;
        this.f31523i = aVar.f31552h;
        this.n = aVar.j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x018f, code lost:
        if (com.bytedance.sdk.openadsdk.o.e.f31597c == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0191, code lost:
        android.util.Log.w("TAG_PROXY_DownloadTask", "download, more data received, currentCacheFileSize: " + r5 + ", max: " + r12.o);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01b1, code lost:
        com.bytedance.sdk.openadsdk.o.g.d.a(r6.d());
        r4.a();
        a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c0, code lost:
        if (com.bytedance.sdk.openadsdk.o.e.f31597c == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01c2, code lost:
        android.util.Log.w("TAG_PROXY_DownloadTask", "cancel call");
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01c9, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01ce, code lost:
        c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01d3, code lost:
        if (com.bytedance.sdk.openadsdk.o.e.f31597c == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01d5, code lost:
        android.util.Log.i("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01dc, code lost:
        com.bytedance.sdk.openadsdk.o.g.d.a(r6.d());
        r4.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01e6, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(l.a aVar) throws IOException, h.a, com.bytedance.sdk.openadsdk.o.c.a, com.bytedance.sdk.openadsdk.o.c.b, VAdError {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65537, this, aVar) != null) {
            return;
        }
        File c2 = this.f31515a.c(this.f31522h);
        long length = c2.length();
        int i2 = this.o;
        if (i2 > 0 && length >= i2) {
            if (e.f31597c) {
                Log.i("TAG_PROXY_DownloadTask", "no necessary to download for " + this.f31522h + ", cache file size: " + length + ", max: " + this.o);
                return;
            }
            return;
        }
        int f2 = f();
        com.bytedance.sdk.openadsdk.o.b.a a2 = this.f31516b.a(this.f31522h, f2);
        if (a2 != null && length >= a2.f31556c) {
            if (e.f31597c) {
                Log.i("TAG_PROXY_DownloadTask", "file download complete, key: " + this.f31522h);
                return;
            }
            return;
        }
        e();
        int i3 = (int) length;
        com.bytedance.sdk.openadsdk.o.e.a a3 = a(aVar, i3, this.o, "GET");
        if (a3 == null) {
            return;
        }
        h hVar = null;
        boolean z = true;
        try {
            e();
            String a4 = com.bytedance.sdk.openadsdk.o.g.d.a(a3, this.f31523i == null && e.f31599e, true);
            if (a4 == null) {
                int a5 = com.bytedance.sdk.openadsdk.o.g.d.a(a3);
                if (a2 != null && a2.f31556c != a5) {
                    if (e.f31597c) {
                        Log.e("TAG_PROXY_DownloadTask", "Content-Length not match, old: " + a2.f31556c + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + ", key: " + this.f31522h);
                    }
                    throw new com.bytedance.sdk.openadsdk.o.c.b("Content-Length not match, old length: " + a2.f31556c + ", new length: " + a5 + ", rawKey: " + this.f31521g + ", currentUrl: " + aVar + ", previousInfo: " + a2.f31558e);
                }
                com.bytedance.sdk.openadsdk.o.g.d.a(a3, this.f31516b, this.f31522h, f2);
                com.bytedance.sdk.openadsdk.o.b.a a6 = this.f31516b.a(this.f31522h, f2);
                int i4 = a6 == null ? 0 : a6.f31556c;
                InputStream d2 = a3.d();
                h hVar2 = new h(c2, e.f31598d ? "rwd" : "rw");
                try {
                    hVar2.a(length);
                    if (e.f31597c) {
                        Log.i("TAG_PROXY_DownloadTask", "preload start from: " + length);
                    }
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = d2.read(bArr);
                        if (read >= 0) {
                            e();
                            if (read > 0) {
                                hVar2.a(bArr, 0, read);
                                i3 += read;
                                if (this.f31523i != null) {
                                    synchronized (this.m) {
                                        this.m.notifyAll();
                                    }
                                }
                                this.f31517c.addAndGet(read);
                                a(i4, i3);
                            }
                            if (this.o > 0 && i3 >= this.o) {
                                break;
                            }
                            e();
                        } else {
                            try {
                                break;
                            } catch (Throwable th) {
                                th = th;
                                hVar = hVar2;
                                z = false;
                                com.bytedance.sdk.openadsdk.o.g.d.a(a3.d());
                                if (hVar != null) {
                                    hVar.a();
                                }
                                if (z) {
                                    a();
                                    if (e.f31597c) {
                                        Log.w("TAG_PROXY_DownloadTask", "cancel call");
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    hVar = hVar2;
                }
            } else {
                throw new com.bytedance.sdk.openadsdk.o.c.c(a4 + ", rawKey: " + this.f31521g + ", url: " + aVar);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private boolean j() throws com.bytedance.sdk.openadsdk.o.c.a, VAdError {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            while (this.j.a()) {
                e();
                l.a b2 = this.j.b();
                try {
                    a(b2);
                    return true;
                } catch (com.bytedance.sdk.openadsdk.o.c.b e2) {
                    this.r = e2;
                    if (e.f31597c) {
                        Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(e2));
                    }
                    return false;
                } catch (com.bytedance.sdk.openadsdk.o.c.c e3) {
                    b2.a();
                    a(Boolean.valueOf(g()), this.f31521g, e3);
                } catch (h.a e4) {
                    this.q = e4;
                    a(Boolean.valueOf(g()), this.f31521g, e4);
                    return false;
                } catch (IOException e5) {
                    if (e5 instanceof SocketTimeoutException) {
                        b2.b();
                    }
                    if (b()) {
                        if (e.f31597c) {
                            if (ResponseException.CANCELED.equalsIgnoreCase(e5.getMessage())) {
                                Log.w("TAG_PROXY_DownloadTask", "okhttp call canceled");
                            } else {
                                Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(e5));
                            }
                        }
                    } else {
                        a(Boolean.valueOf(g()), this.f31521g, e5);
                    }
                } catch (Throwable th) {
                    if (e.f31597c) {
                        Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(th));
                    }
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public h.a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q : (h.a) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.o.c.b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.r : (com.bytedance.sdk.openadsdk.o.c.b) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f31515a.a(this.f31522h);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                j();
            } catch (com.bytedance.sdk.component.adnet.err.a e2) {
                e2.printStackTrace();
            } catch (VAdError e3) {
                e3.printStackTrace();
            } catch (com.bytedance.sdk.openadsdk.o.c.a e4) {
                if (e.f31597c) {
                    Log.w("TAG_PROXY_DownloadTask", Log.getStackTraceString(e4));
                }
            } catch (Throwable th) {
                if (e.f31597c) {
                    Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(th));
                }
            }
            this.f31518d.set(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f31515a.b(this.f31522h);
            InterfaceC0358b interfaceC0358b = this.p;
            if (interfaceC0358b != null) {
                interfaceC0358b.a(this);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f31545a;

        /* renamed from: b  reason: collision with root package name */
        public String f31546b;

        /* renamed from: c  reason: collision with root package name */
        public l f31547c;

        /* renamed from: d  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.o.a.a f31548d;

        /* renamed from: e  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.o.b.c f31549e;

        /* renamed from: f  reason: collision with root package name */
        public List<i.b> f31550f;

        /* renamed from: g  reason: collision with root package name */
        public int f31551g;

        /* renamed from: h  reason: collision with root package name */
        public i f31552h;

        /* renamed from: i  reason: collision with root package name */
        public InterfaceC0358b f31553i;
        public Object j;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    this.f31545a = str;
                    return this;
                }
                throw new IllegalArgumentException("rawKey == null");
            }
            return (a) invokeL.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    this.f31546b = str;
                    return this;
                }
                throw new IllegalArgumentException("key == null");
            }
            return (a) invokeL.objValue;
        }

        public a a(l lVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, lVar)) == null) {
                if (lVar != null) {
                    this.f31547c = lVar;
                    return this;
                }
                throw new IllegalArgumentException("urls is empty");
            }
            return (a) invokeL.objValue;
        }

        public a a(com.bytedance.sdk.openadsdk.o.a.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                if (aVar != null) {
                    this.f31548d = aVar;
                    return this;
                }
                throw new IllegalArgumentException("cache == null");
            }
            return (a) invokeL.objValue;
        }

        public a a(com.bytedance.sdk.openadsdk.o.b.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
                if (cVar != null) {
                    this.f31549e = cVar;
                    return this;
                }
                throw new IllegalArgumentException("db == null");
            }
            return (a) invokeL.objValue;
        }

        public a a(List<i.b> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list)) == null) {
                this.f31550f = list;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f31551g = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(InterfaceC0358b interfaceC0358b) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0358b)) == null) {
                this.f31553i = interfaceC0358b;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(i iVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iVar)) == null) {
                this.f31552h = iVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                this.j = obj;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                if (this.f31548d != null && this.f31549e != null && !TextUtils.isEmpty(this.f31545a) && !TextUtils.isEmpty(this.f31546b) && this.f31547c != null) {
                    return new b(this);
                }
                throw new IllegalArgumentException();
            }
            return (b) invokeV.objValue;
        }
    }
}
