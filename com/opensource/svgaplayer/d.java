package com.opensource.svgaplayer;

import android.content.Context;
import android.net.http.HttpResponseCache;
import android.os.Handler;
import android.util.Log;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.sapi2.views.SmsLoginView;
import com.opensource.svgaplayer.proto.MovieEntity;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.TypeCastException;
import kotlin.h;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.u;
import kotlin.text.l;
import org.json.JSONObject;
@kotlin.e
/* loaded from: classes18.dex */
public final class d {
    private final Context context;
    private b pyT;
    public static final a pyW = new a(null);
    private static final LinkedBlockingQueue<Runnable> pyU = new LinkedBlockingQueue<>();
    private static ThreadPoolExecutor pyV = new ThreadPoolExecutor(3, 10, 60000, TimeUnit.MILLISECONDS, pyU);

    @kotlin.e
    /* loaded from: classes18.dex */
    public interface c {
        void a(com.opensource.svgaplayer.f fVar);

        void onError();
    }

    public d(Context context) {
        p.o(context, "context");
        this.context = context;
        this.pyT = new b();
    }

    @kotlin.e
    /* loaded from: classes18.dex */
    public static class b {
        private boolean noCache;

        public final boolean ezM() {
            return this.noCache;
        }

        public kotlin.jvm.a.a<h> a(URL url, kotlin.jvm.a.b<? super InputStream, h> bVar, kotlin.jvm.a.b<? super Exception, h> bVar2) {
            p.o(url, "url");
            p.o(bVar, com.baidu.mobads.openad.c.b.COMPLETE);
            p.o(bVar2, SmsLoginView.f.l);
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = false;
            SVGAParser$FileDownloader$resume$cancelBlock$1 sVGAParser$FileDownloader$resume$cancelBlock$1 = new SVGAParser$FileDownloader$resume$cancelBlock$1(booleanRef);
            d.pyW.ezL().execute(new a(url, booleanRef, bVar, bVar2));
            return sVGAParser$FileDownloader$resume$cancelBlock$1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @kotlin.e
        /* loaded from: classes18.dex */
        public static final class a implements Runnable {
            final /* synthetic */ Ref.BooleanRef $cancelled;
            final /* synthetic */ URL $url;
            final /* synthetic */ kotlin.jvm.a.b pyY;
            final /* synthetic */ kotlin.jvm.a.b pyZ;

            a(URL url, Ref.BooleanRef booleanRef, kotlin.jvm.a.b bVar, kotlin.jvm.a.b bVar2) {
                this.$url = url;
                this.$cancelled = booleanRef;
                this.pyY = bVar;
                this.pyZ = bVar2;
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [52=4] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @Override // java.lang.Runnable
            public final void run() {
                int read;
                try {
                    if (HttpResponseCache.getInstalled() == null && !b.this.ezM()) {
                        Log.e("SVGAParser", "SVGAParser can not handle cache before install HttpResponseCache. see https://github.com/yyued/SVGAPlayer-Android#cache");
                        Log.e("SVGAParser", "在配置 HttpResponseCache 前 SVGAParser 无法缓存. 查看 https://github.com/yyued/SVGAPlayer-Android#cache ");
                    }
                    URLConnection openConnection = this.$url.openConnection();
                    HttpURLConnection httpURLConnection = openConnection instanceof HttpURLConnection ? openConnection : null;
                    if (httpURLConnection != null) {
                        httpURLConnection.setConnectTimeout(20000);
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.connect();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        Throwable th = null;
                        InputStream inputStream2 = inputStream;
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        Throwable th2 = null;
                        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                        byte[] bArr = new byte[4096];
                        while (!this.$cancelled.element && (read = inputStream2.read(bArr, 0, 4096)) != -1) {
                            byteArrayOutputStream2.write(bArr, 0, read);
                        }
                        if (this.$cancelled.element) {
                            kotlin.io.a.a(byteArrayOutputStream, th2);
                            kotlin.io.a.a(inputStream, th);
                            return;
                        }
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream2.toByteArray());
                        Throwable th3 = null;
                        try {
                            this.pyY.invoke(byteArrayInputStream);
                            h hVar = h.pJY;
                            kotlin.io.a.a(byteArrayInputStream, th3);
                            h hVar2 = h.pJY;
                            kotlin.io.a.a(byteArrayOutputStream, th2);
                            h hVar3 = h.pJY;
                            kotlin.io.a.a(inputStream, th);
                        } catch (Throwable th4) {
                            try {
                                throw th4;
                            } catch (Throwable th5) {
                                kotlin.io.a.a(byteArrayInputStream, th4);
                                throw th5;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    this.pyZ.invoke(e);
                }
            }
        }
    }

    @kotlin.e
    /* loaded from: classes18.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final ThreadPoolExecutor ezL() {
            return d.pyV;
        }
    }

    public final void a(String str, c cVar) {
        p.o(str, "name");
        p.o(cVar, BuyTBeanActivityConfig.CALLBACK);
        try {
            InputStream open = this.context.getAssets().open(str);
            if (open != null) {
                a(open, ZO("file:///assets/" + str), cVar, true);
            }
        } catch (Exception e2) {
            a(e2, cVar);
        }
    }

    public final kotlin.jvm.a.a<h> a(URL url, c cVar) {
        p.o(url, "url");
        p.o(cVar, BuyTBeanActivityConfig.CALLBACK);
        if (ZN(d(url))) {
            pyV.execute(new e(url, cVar));
            return null;
        }
        return this.pyT.a(url, new SVGAParser$decodeFromURL$2(this, url, cVar), new SVGAParser$decodeFromURL$3(this, cVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes18.dex */
    public static final class e implements Runnable {
        final /* synthetic */ c $callback;
        final /* synthetic */ URL $url;

        e(URL url, c cVar) {
            this.$url = url;
            this.$callback = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.this.c(d.this.d(this.$url), this.$callback);
        }
    }

    public static /* synthetic */ void a(d dVar, InputStream inputStream, String str, c cVar, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        dVar.a(inputStream, str, cVar, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* renamed from: com.opensource.svgaplayer.d$d  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class RunnableC1015d implements Runnable {
        final /* synthetic */ c $callback;
        final /* synthetic */ InputStream pza;
        final /* synthetic */ String pzb;
        final /* synthetic */ boolean pzc;

        RunnableC1015d(InputStream inputStream, String str, c cVar, boolean z) {
            this.pza = inputStream;
            this.pzb = str;
            this.$callback = cVar;
            this.pzc = z;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, IF] complete} */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public final void run() {
            try {
                try {
                    byte[] L = d.this.L(this.pza);
                    if (L != null) {
                        if (L.length <= 4 || L[0] != 80 || L[1] != 75 || L[2] != 3 || L[3] != 4) {
                            byte[] au = d.this.au(L);
                            if (au != null) {
                                MovieEntity decode = MovieEntity.ADAPTER.decode(au);
                                p.n(decode, "MovieEntity.ADAPTER.decode(it)");
                                com.opensource.svgaplayer.f fVar = new com.opensource.svgaplayer.f(decode, new File(this.pzb));
                                fVar.a(new SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$2(fVar, this));
                            }
                        } else {
                            if (!d.this.ZP(this.pzb).exists()) {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(L);
                                Throwable th = null;
                                try {
                                    d.this.h(byteArrayInputStream, this.pzb);
                                    h hVar = h.pJY;
                                    kotlin.io.a.a(byteArrayInputStream, th);
                                } catch (Throwable th2) {
                                    try {
                                        throw th2;
                                    } catch (Throwable th3) {
                                        kotlin.io.a.a(byteArrayInputStream, th2);
                                        throw th3;
                                    }
                                }
                            }
                            d.this.c(this.pzb, this.$callback);
                        }
                    }
                    if (this.pzc) {
                        this.pza.close();
                    }
                } catch (Throwable th4) {
                    if (this.pzc) {
                        this.pza.close();
                    }
                    throw th4;
                }
            } catch (Exception e) {
                d.this.a(e, this.$callback);
                if (this.pzc) {
                    this.pza.close();
                }
            }
        }
    }

    public final void a(InputStream inputStream, String str, c cVar, boolean z) {
        p.o(inputStream, "inputStream");
        p.o(str, "cacheKey");
        p.o(cVar, BuyTBeanActivityConfig.CALLBACK);
        pyV.execute(new RunnableC1015d(inputStream, str, cVar, z));
    }

    public final void b(String str, c cVar) {
        p.o(str, "assetsName");
        p.o(cVar, BuyTBeanActivityConfig.CALLBACK);
        a(str, cVar);
    }

    public final void b(URL url, c cVar) {
        p.o(url, "url");
        p.o(cVar, BuyTBeanActivityConfig.CALLBACK);
        a(url, cVar);
    }

    public final void b(InputStream inputStream, String str, c cVar, boolean z) {
        p.o(inputStream, "inputStream");
        p.o(str, "cacheKey");
        p.o(cVar, BuyTBeanActivityConfig.CALLBACK);
        a(inputStream, str, cVar, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes18.dex */
    public static final class f implements Runnable {
        final /* synthetic */ c $callback;
        final /* synthetic */ com.opensource.svgaplayer.f $videoItem;

        f(c cVar, com.opensource.svgaplayer.f fVar) {
            this.$callback = cVar;
            this.$videoItem = fVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.$callback.a(this.$videoItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(com.opensource.svgaplayer.f fVar, c cVar) {
        new Handler(this.context.getMainLooper()).post(new f(cVar, fVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Exception exc, c cVar) {
        exc.printStackTrace();
        new Handler(this.context.getMainLooper()).post(new g(cVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes18.dex */
    public static final class g implements Runnable {
        final /* synthetic */ c $callback;

        g(c cVar) {
            this.$callback = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.$callback.onError();
        }
    }

    private final boolean ZN(String str) {
        return ZP(str).exists();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [210=4] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String str, c cVar) {
        try {
            StringBuilder sb = new StringBuilder();
            File cacheDir = this.context.getCacheDir();
            p.n(cacheDir, "context.cacheDir");
            File file = new File(sb.append(cacheDir.getAbsolutePath()).append("/").append(str).append("/").toString());
            File file2 = new File(file, "movie.binary");
            File file3 = file2.isFile() ? file2 : null;
            if (file3 != null) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file3);
                    Throwable th = null;
                    MovieEntity decode = MovieEntity.ADAPTER.decode(fileInputStream);
                    p.n(decode, "MovieEntity.ADAPTER.decode(it)");
                    a(new com.opensource.svgaplayer.f(decode, file), cVar);
                    h hVar = h.pJY;
                    kotlin.io.a.a(fileInputStream, th);
                } catch (Exception e2) {
                    file.delete();
                    file3.delete();
                    throw e2;
                }
            }
            File file4 = new File(file, "movie.spec");
            File file5 = file4.isFile() ? file4 : null;
            if (file5 == null) {
                return;
            }
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file5);
                Throwable th2 = null;
                FileInputStream fileInputStream3 = fileInputStream2;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Throwable th3 = null;
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = fileInputStream3.read(bArr, 0, bArr.length);
                        if (read == -1) {
                            a(new com.opensource.svgaplayer.f(new JSONObject(byteArrayOutputStream2.toString()), file), cVar);
                            h hVar2 = h.pJY;
                            kotlin.io.a.a(byteArrayOutputStream, th3);
                            h hVar3 = h.pJY;
                            kotlin.io.a.a(fileInputStream2, th2);
                            return;
                        }
                        byteArrayOutputStream2.write(bArr, 0, read);
                    }
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        kotlin.io.a.a(byteArrayOutputStream, th4);
                        throw th5;
                    }
                }
            } catch (Exception e3) {
                file.delete();
                file5.delete();
                throw e3;
            }
        } catch (Exception e4) {
            a(e4, cVar);
        }
    }

    private final String ZO(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        Charset forName = Charset.forName("UTF-8");
        p.n(forName, "Charset.forName(charsetName)");
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(forName);
        p.n(bytes, "(this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        String str2 = "";
        for (byte b2 : digest) {
            StringBuilder append = new StringBuilder().append(str2);
            u uVar = u.pKF;
            Object[] objArr = {Byte.valueOf(b2)};
            String format = String.format("%02x", Arrays.copyOf(objArr, objArr.length));
            p.n(format, "java.lang.String.format(format, *args)");
            str2 = append.append(format).toString();
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d(URL url) {
        String url2 = url.toString();
        p.n(url2, "url.toString()");
        return ZO(url2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File ZP(String str) {
        StringBuilder sb = new StringBuilder();
        File cacheDir = this.context.getCacheDir();
        p.n(cacheDir, "context.cacheDir");
        return new File(sb.append(cacheDir.getAbsolutePath()).append("/").append(str).append("/").toString());
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] L(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable th = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            byte[] bArr = new byte[2048];
            while (true) {
                int read = inputStream.read(bArr, 0, 2048);
                if (read > 0) {
                    byteArrayOutputStream2.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    kotlin.io.a.a(byteArrayOutputStream, th);
                    return byteArray;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] au(byte[] bArr) {
        Inflater inflater = new Inflater();
        inflater.setInput(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[2048];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable th = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            while (true) {
                int inflate = inflater.inflate(bArr2, 0, 2048);
                if (inflate > 0) {
                    byteArrayOutputStream2.write(bArr2, 0, inflate);
                } else {
                    inflater.end();
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    kotlin.io.a.a(byteArrayOutputStream, th);
                    return byteArray;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [300=4] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public final void h(InputStream inputStream, String str) {
        int i;
        i = com.opensource.svgaplayer.e.pzd;
        synchronized (Integer.valueOf(i)) {
            File ZP = ZP(str);
            ZP.mkdirs();
            try {
                FileOutputStream bufferedInputStream = new BufferedInputStream(inputStream);
                Throwable th = null;
                try {
                    ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);
                    Throwable th2 = null;
                    ZipInputStream zipInputStream2 = zipInputStream;
                    while (true) {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry != null) {
                            String name = nextEntry.getName();
                            p.n(name, "zipItem.name");
                            if (!l.a((CharSequence) name, (CharSequence) "/", false, 2, (Object) null)) {
                                bufferedInputStream = new FileOutputStream(new File(ZP, nextEntry.getName()));
                                Throwable th3 = null;
                                try {
                                    FileOutputStream fileOutputStream = bufferedInputStream;
                                    byte[] bArr = new byte[2048];
                                    while (true) {
                                        int read = zipInputStream2.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                    h hVar = h.pJY;
                                    kotlin.io.a.a(bufferedInputStream, th3);
                                    zipInputStream2.closeEntry();
                                } finally {
                                    try {
                                        throw th;
                                    } finally {
                                    }
                                }
                            }
                        } else {
                            h hVar2 = h.pJY;
                            kotlin.io.a.a(zipInputStream, th2);
                            h hVar3 = h.pJY;
                            kotlin.io.a.a(bufferedInputStream, th);
                            h hVar4 = h.pJY;
                        }
                    }
                } finally {
                }
            } catch (Exception e2) {
                ZP.delete();
                throw e2;
            }
        }
    }
}
