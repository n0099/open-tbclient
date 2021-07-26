package com.bytedance.sdk.openadsdk.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.n.h;
import com.bytedance.sdk.openadsdk.n.i;
import com.bytedance.sdk.openadsdk.n.l;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends com.bytedance.sdk.openadsdk.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object m;
    public final Object n;
    public final int o;
    public final InterfaceC0360b p;
    public volatile h.a q;
    public volatile com.bytedance.sdk.openadsdk.n.c.b r;

    /* renamed from: com.bytedance.sdk.openadsdk.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0360b {
        void a(b bVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar) {
        super(aVar.f31849d, aVar.f31850e);
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
                super((com.bytedance.sdk.openadsdk.n.a.a) objArr2[0], (com.bytedance.sdk.openadsdk.n.b.c) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = aVar.f31852g;
        this.p = aVar.f31854i;
        this.m = this;
        this.f31817g = aVar.f31846a;
        this.f31818h = aVar.f31847b;
        this.f31816f = aVar.f31851f;
        this.j = aVar.f31848c;
        this.f31819i = aVar.f31853h;
        this.n = aVar.j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x018f, code lost:
        if (com.bytedance.sdk.openadsdk.n.e.f31893c == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0191, code lost:
        android.util.Log.w("TAG_PROXY_DownloadTask", "download, more data received, currentCacheFileSize: " + r5 + ", max: " + r12.o);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01b1, code lost:
        com.bytedance.sdk.openadsdk.n.g.d.a(r6.d());
        r4.a();
        a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c0, code lost:
        if (com.bytedance.sdk.openadsdk.n.e.f31893c == false) goto L80;
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
        if (com.bytedance.sdk.openadsdk.n.e.f31893c == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01d5, code lost:
        android.util.Log.i("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01dc, code lost:
        com.bytedance.sdk.openadsdk.n.g.d.a(r6.d());
        r4.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01e6, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(l.a aVar) throws IOException, h.a, com.bytedance.sdk.openadsdk.n.c.a, com.bytedance.sdk.openadsdk.n.c.b, VAdError {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65537, this, aVar) != null) {
            return;
        }
        File c2 = this.f31811a.c(this.f31818h);
        long length = c2.length();
        int i2 = this.o;
        if (i2 > 0 && length >= i2) {
            if (e.f31893c) {
                Log.i("TAG_PROXY_DownloadTask", "no necessary to download for " + this.f31818h + ", cache file size: " + length + ", max: " + this.o);
                return;
            }
            return;
        }
        int f2 = f();
        com.bytedance.sdk.openadsdk.n.b.a a2 = this.f31812b.a(this.f31818h, f2);
        if (a2 != null && length >= a2.f31843c) {
            if (e.f31893c) {
                Log.i("TAG_PROXY_DownloadTask", "file download complete, key: " + this.f31818h);
                return;
            }
            return;
        }
        e();
        int i3 = (int) length;
        com.bytedance.sdk.openadsdk.n.e.a a3 = a(aVar, i3, this.o, "GET");
        if (a3 == null) {
            return;
        }
        h hVar = null;
        boolean z = true;
        try {
            e();
            String a4 = com.bytedance.sdk.openadsdk.n.g.d.a(a3, this.f31819i == null && e.f31895e, true);
            if (a4 == null) {
                int a5 = com.bytedance.sdk.openadsdk.n.g.d.a(a3);
                if (a2 != null && a2.f31843c != a5) {
                    if (e.f31893c) {
                        Log.e("TAG_PROXY_DownloadTask", "Content-Length not match, old: " + a2.f31843c + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + ", key: " + this.f31818h);
                    }
                    throw new com.bytedance.sdk.openadsdk.n.c.b("Content-Length not match, old length: " + a2.f31843c + ", new length: " + a5 + ", rawKey: " + this.f31817g + ", currentUrl: " + aVar + ", previousInfo: " + a2.f31845e);
                }
                com.bytedance.sdk.openadsdk.n.g.d.a(a3, this.f31812b, this.f31818h, f2);
                com.bytedance.sdk.openadsdk.n.b.a a6 = this.f31812b.a(this.f31818h, f2);
                int i4 = a6 == null ? 0 : a6.f31843c;
                InputStream d2 = a3.d();
                h hVar2 = new h(c2, e.f31894d ? "rwd" : "rw");
                try {
                    hVar2.a(length);
                    if (e.f31893c) {
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
                                if (this.f31819i != null) {
                                    synchronized (this.m) {
                                        this.m.notifyAll();
                                    }
                                }
                                this.f31813c.addAndGet(read);
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
                                com.bytedance.sdk.openadsdk.n.g.d.a(a3.d());
                                if (hVar != null) {
                                    hVar.a();
                                }
                                if (z) {
                                    a();
                                    if (e.f31893c) {
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
                throw new com.bytedance.sdk.openadsdk.n.c.c(a4 + ", rawKey: " + this.f31817g + ", url: " + aVar);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private boolean j() throws com.bytedance.sdk.openadsdk.n.c.a, VAdError {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            while (this.j.a()) {
                e();
                l.a b2 = this.j.b();
                try {
                    a(b2);
                    return true;
                } catch (com.bytedance.sdk.openadsdk.n.c.b e2) {
                    this.r = e2;
                    return false;
                } catch (com.bytedance.sdk.openadsdk.n.c.c e3) {
                    b2.a();
                    a(Boolean.valueOf(g()), this.f31817g, e3);
                } catch (h.a e4) {
                    this.q = e4;
                    a(Boolean.valueOf(g()), this.f31817g, e4);
                    return false;
                } catch (IOException e5) {
                    if (e5 instanceof SocketTimeoutException) {
                        b2.b();
                    }
                    if (!b()) {
                        a(Boolean.valueOf(g()), this.f31817g, e5);
                    }
                } catch (Throwable unused) {
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

    public com.bytedance.sdk.openadsdk.n.c.b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.r : (com.bytedance.sdk.openadsdk.n.c.b) invokeV.objValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Throwable added to exception handler: 'a', keep only Throwable */
    @Override // java.lang.Runnable
    public void run() {
        /*
            r5 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.bytedance.sdk.openadsdk.n.b.$ic
            if (r0 != 0) goto L37
        L4:
            com.bytedance.sdk.openadsdk.n.a.a r0 = r5.f31811a
            java.lang.String r1 = r5.f31818h
            r0.a(r1)
            long r0 = android.os.SystemClock.elapsedRealtime()
            r5.j()     // Catch: java.lang.Throwable -> L13
            goto L1e
        L13:
            goto L1e
        L15:
            r2 = move-exception
            r2.printStackTrace()
            goto L1e
        L1a:
            r2 = move-exception
            r2.printStackTrace()
        L1e:
            java.util.concurrent.atomic.AtomicLong r2 = r5.f31814d
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r3 = r3 - r0
            r2.set(r3)
            com.bytedance.sdk.openadsdk.n.a.a r0 = r5.f31811a
            java.lang.String r1 = r5.f31818h
            r0.b(r1)
            com.bytedance.sdk.openadsdk.n.b$b r0 = r5.p
            if (r0 == 0) goto L36
            r0.a(r5)
        L36:
            return
        L37:
            r3 = r0
            r4 = 1048578(0x100002, float:1.469371E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r3.invokeV(r4, r5)
            if (r0 == 0) goto L4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.n.b.run():void");
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f31846a;

        /* renamed from: b  reason: collision with root package name */
        public String f31847b;

        /* renamed from: c  reason: collision with root package name */
        public l f31848c;

        /* renamed from: d  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.n.a.a f31849d;

        /* renamed from: e  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.n.b.c f31850e;

        /* renamed from: f  reason: collision with root package name */
        public List<i.b> f31851f;

        /* renamed from: g  reason: collision with root package name */
        public int f31852g;

        /* renamed from: h  reason: collision with root package name */
        public i f31853h;

        /* renamed from: i  reason: collision with root package name */
        public InterfaceC0360b f31854i;
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
                    this.f31846a = str;
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
                    this.f31847b = str;
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
                    this.f31848c = lVar;
                    return this;
                }
                throw new IllegalArgumentException("urls is empty");
            }
            return (a) invokeL.objValue;
        }

        public a a(com.bytedance.sdk.openadsdk.n.a.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                if (aVar != null) {
                    this.f31849d = aVar;
                    return this;
                }
                throw new IllegalArgumentException("cache == null");
            }
            return (a) invokeL.objValue;
        }

        public a a(com.bytedance.sdk.openadsdk.n.b.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
                if (cVar != null) {
                    this.f31850e = cVar;
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
                this.f31851f = list;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f31852g = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(InterfaceC0360b interfaceC0360b) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0360b)) == null) {
                this.f31854i = interfaceC0360b;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(i iVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iVar)) == null) {
                this.f31853h = iVar;
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
                if (this.f31849d != null && this.f31850e != null && !TextUtils.isEmpty(this.f31846a) && !TextUtils.isEmpty(this.f31847b) && this.f31848c != null) {
                    return new b(this);
                }
                throw new IllegalArgumentException();
            }
            return (b) invokeV.objValue;
        }
    }
}
