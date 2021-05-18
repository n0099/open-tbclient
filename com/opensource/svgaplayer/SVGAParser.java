package com.opensource.svgaplayer;

import android.content.Context;
import android.net.http.HttpResponseCache;
import android.os.Handler;
import android.util.Log;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 =:\u0003=>?B\u000f\u0012\u0006\u00102\u001a\u000201¢\u0006\u0004\b;\u0010<J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\b\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J/\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b(\u0010)J1\u0010*\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b*\u0010\u0018J\u001f\u0010*\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b*\u0010+J\u001f\u0010*\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b*\u0010\u0011J\u0019\u0010-\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b-\u0010.J\u001f\u0010/\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006@"}, d2 = {"Lcom/opensource/svgaplayer/SVGAParser;", "", "cacheKey", "Ljava/io/File;", "buildCacheDir", "(Ljava/lang/String;)Ljava/io/File;", "Ljava/net/URL;", "url", "buildCacheKey", "(Ljava/net/URL;)Ljava/lang/String;", "str", "(Ljava/lang/String;)Ljava/lang/String;", "name", "Lcom/opensource/svgaplayer/SVGAParser$ParseCompletion;", "callback", "", "decodeFromAssets", "(Ljava/lang/String;Lcom/opensource/svgaplayer/SVGAParser$ParseCompletion;)V", "decodeFromCacheKey", "Ljava/io/InputStream;", "inputStream", "", "closeInputStream", "decodeFromInputStream", "(Ljava/io/InputStream;Ljava/lang/String;Lcom/opensource/svgaplayer/SVGAParser$ParseCompletion;Z)V", "Lkotlin/Function0;", "decodeFromURL", "(Ljava/net/URL;Lcom/opensource/svgaplayer/SVGAParser$ParseCompletion;)Lkotlin/Function0;", "", "byteArray", "inflate", "([B)[B", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "videoItem", "invokeCompleteCallback", "(Lcom/opensource/svgaplayer/SVGAVideoEntity;Lcom/opensource/svgaplayer/SVGAParser$ParseCompletion;)V", "Ljava/lang/Exception;", "e", "invokeErrorCallback", "(Ljava/lang/Exception;Lcom/opensource/svgaplayer/SVGAParser$ParseCompletion;)V", "isCached", "(Ljava/lang/String;)Z", "parse", "(Ljava/net/URL;Lcom/opensource/svgaplayer/SVGAParser$ParseCompletion;)V", "assetsName", "readAsBytes", "(Ljava/io/InputStream;)[B", ZeusPerformanceTiming.KEY_UNZIP, "(Ljava/io/InputStream;Ljava/lang/String;)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/opensource/svgaplayer/SVGAParser$FileDownloader;", "fileDownloader", "Lcom/opensource/svgaplayer/SVGAParser$FileDownloader;", "getFileDownloader", "()Lcom/opensource/svgaplayer/SVGAParser$FileDownloader;", "setFileDownloader", "(Lcom/opensource/svgaplayer/SVGAParser$FileDownloader;)V", "<init>", "(Landroid/content/Context;)V", "Companion", "FileDownloader", "ParseCompletion", "library_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes6.dex */
public final class SVGAParser {

    /* renamed from: a  reason: collision with root package name */
    public FileDownloader f35126a = new FileDownloader();

    /* renamed from: b  reason: collision with root package name */
    public final Context f35127b;

    /* renamed from: e  reason: collision with root package name */
    public static final a f35125e = new a(null);

    /* renamed from: c  reason: collision with root package name */
    public static final LinkedBlockingQueue<Runnable> f35123c = new LinkedBlockingQueue<>();

    /* renamed from: d  reason: collision with root package name */
    public static ThreadPoolExecutor f35124d = new ThreadPoolExecutor(3, 10, 60000, TimeUnit.MILLISECONDS, f35123c);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u0000B\u0007¢\u0006\u0004\b\u0018\u0010\u0019Jg\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u0002\u001a\u00020\u00012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00032%\u0010\r\u001a!\u0012\u0017\u0012\u00150\nj\u0002`\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\b0\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/opensource/svgaplayer/SVGAParser$FileDownloader;", "Ljava/net/URL;", "url", "Lkotlin/Function1;", "Ljava/io/InputStream;", "Lkotlin/ParameterName;", "name", "inputStream", "", XAdRemoteEvent.COMPLETE, "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", SmsLoginView.f.l, "Lkotlin/Function0;", "resume", "(Ljava/net/URL;Lkotlin/Function1;Lkotlin/Function1;)Lkotlin/Function0;", "", "noCache", "Z", "getNoCache", "()Z", "setNoCache", "(Z)V", "<init>", "()V", "library_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes6.dex */
    public static class FileDownloader {

        /* renamed from: a  reason: collision with root package name */
        public boolean f35128a;

        /* loaded from: classes6.dex */
        public static final class a implements Runnable {

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ URL f35130f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f35131g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Function1 f35132h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ Function1 f35133i;

            public a(URL url, Ref.BooleanRef booleanRef, Function1 function1, Function1 function12) {
                this.f35130f = url;
                this.f35131g = booleanRef;
                this.f35132h = function1;
                this.f35133i = function12;
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @Override // java.lang.Runnable
            public final void run() {
                int read;
                try {
                    if (HttpResponseCache.getInstalled() == null && !FileDownloader.this.a()) {
                        Log.e("SVGAParser", "SVGAParser can not handle cache before install HttpResponseCache. see https://github.com/yyued/SVGAPlayer-Android#cache");
                        Log.e("SVGAParser", "在配置 HttpResponseCache 前 SVGAParser 无法缓存. 查看 https://github.com/yyued/SVGAPlayer-Android#cache ");
                    }
                    URLConnection openConnection = this.f35130f.openConnection();
                    if (!(openConnection instanceof HttpURLConnection)) {
                        openConnection = null;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    if (httpURLConnection != null) {
                        httpURLConnection.setConnectTimeout(20000);
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.connect();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[4096];
                        while (!this.f35131g.element && (read = inputStream.read(bArr, 0, 4096)) != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        if (this.f35131g.element) {
                            CloseableKt.closeFinally(byteArrayOutputStream, null);
                            CloseableKt.closeFinally(inputStream, null);
                            return;
                        }
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        try {
                            this.f35132h.invoke(byteArrayInputStream);
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(byteArrayInputStream, null);
                            Unit unit2 = Unit.INSTANCE;
                            CloseableKt.closeFinally(byteArrayOutputStream, null);
                            Unit unit3 = Unit.INSTANCE;
                            CloseableKt.closeFinally(inputStream, null);
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(byteArrayInputStream, th);
                                throw th2;
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f35133i.invoke(e2);
                }
            }
        }

        public final boolean a() {
            return this.f35128a;
        }

        public Function0<Unit> b(URL url, Function1<? super InputStream, Unit> function1, Function1<? super Exception, Unit> function12) {
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = false;
            SVGAParser$FileDownloader$resume$cancelBlock$1 sVGAParser$FileDownloader$resume$cancelBlock$1 = new SVGAParser$FileDownloader$resume$cancelBlock$1(booleanRef);
            SVGAParser.f35125e.a().execute(new a(url, booleanRef, function1, function12));
            return sVGAParser$FileDownloader$resume$cancelBlock$1;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public a() {
        }

        public final ThreadPoolExecutor a() {
            return SVGAParser.f35124d;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(SVGAVideoEntity sVGAVideoEntity);

        void onError();
    }

    /* loaded from: classes6.dex */
    public static final class c implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ URL f35135f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f35136g;

        public c(URL url, b bVar) {
            this.f35135f = url;
            this.f35136g = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SVGAParser sVGAParser = SVGAParser.this;
            sVGAParser.n(sVGAParser.l(this.f35135f), this.f35136g);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f35137e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SVGAVideoEntity f35138f;

        public d(b bVar, SVGAVideoEntity sVGAVideoEntity) {
            this.f35137e = bVar;
            this.f35138f = sVGAVideoEntity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f35137e.a(this.f35138f);
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f35144e;

        public e(b bVar) {
            this.f35144e = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f35144e.onError();
        }
    }

    public SVGAParser(Context context) {
        this.f35127b = context;
    }

    public static /* synthetic */ void p(SVGAParser sVGAParser, InputStream inputStream, String str, b bVar, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        sVGAParser.o(inputStream, str, bVar, z);
    }

    public final File j(String str) {
        StringBuilder sb = new StringBuilder();
        File cacheDir = this.f35127b.getCacheDir();
        Intrinsics.checkExpressionValueIsNotNull(cacheDir, "context.cacheDir");
        sb.append(cacheDir.getAbsolutePath());
        sb.append("/");
        sb.append(str);
        sb.append("/");
        return new File(sb.toString());
    }

    public final String k(String str) {
        byte[] digest;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(charsetName)");
        if (str != null) {
            byte[] bytes = str.getBytes(forName);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            String str2 = "";
            for (byte b2 : messageDigest.digest()) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                sb.append(format);
                str2 = sb.toString();
            }
            return str2;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final String l(URL url) {
        String url2 = url.toString();
        Intrinsics.checkExpressionValueIsNotNull(url2, "url.toString()");
        return k(url2);
    }

    public final void m(String str, b bVar) {
        try {
            InputStream open = this.f35127b.getAssets().open(str);
            if (open != null) {
                o(open, k("file:///assets/" + str), bVar, true);
            }
        } catch (Exception e2) {
            t(e2, bVar);
        }
    }

    public final void n(String str, b bVar) {
        try {
            StringBuilder sb = new StringBuilder();
            File cacheDir = this.f35127b.getCacheDir();
            Intrinsics.checkExpressionValueIsNotNull(cacheDir, "context.cacheDir");
            sb.append(cacheDir.getAbsolutePath());
            sb.append("/");
            sb.append(str);
            sb.append("/");
            File file = new File(sb.toString());
            File file2 = new File(file, "movie.binary");
            if (!file2.isFile()) {
                file2 = null;
            }
            if (file2 != null) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    MovieEntity decode = MovieEntity.ADAPTER.decode(fileInputStream);
                    Intrinsics.checkExpressionValueIsNotNull(decode, "MovieEntity.ADAPTER.decode(it)");
                    s(new SVGAVideoEntity(decode, file), bVar);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                } catch (Exception e2) {
                    file.delete();
                    file2.delete();
                    throw e2;
                }
            }
            File file3 = new File(file, "movie.spec");
            if (!file3.isFile()) {
                file3 = null;
            }
            if (file3 == null) {
                return;
            }
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file3);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = fileInputStream2.read(bArr, 0, 2048);
                    if (read == -1) {
                        s(new SVGAVideoEntity(new JSONObject(byteArrayOutputStream.toString()), file), bVar);
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(byteArrayOutputStream, null);
                        Unit unit3 = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileInputStream2, null);
                        return;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e3) {
                file.delete();
                file3.delete();
                throw e3;
            }
        } catch (Exception e4) {
            t(e4, bVar);
        }
    }

    public final void o(InputStream inputStream, String str, b bVar, boolean z) {
        f35124d.execute(new SVGAParser$decodeFromInputStream$1(this, inputStream, str, bVar, z));
    }

    public final Function0<Unit> q(URL url, b bVar) {
        if (u(l(url))) {
            f35124d.execute(new c(url, bVar));
            return null;
        }
        return this.f35126a.b(url, new SVGAParser$decodeFromURL$2(this, url, bVar), new SVGAParser$decodeFromURL$3(this, bVar));
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final byte[] r(byte[] bArr) {
        Inflater inflater = new Inflater();
        inflater.setInput(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[2048];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int inflate = inflater.inflate(bArr2, 0, 2048);
                if (inflate <= 0) {
                    inflater.end();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr2, 0, inflate);
            } finally {
            }
        }
    }

    public final void s(SVGAVideoEntity sVGAVideoEntity, b bVar) {
        new Handler(this.f35127b.getMainLooper()).post(new d(bVar, sVGAVideoEntity));
    }

    public final void t(Exception exc, b bVar) {
        exc.printStackTrace();
        new Handler(this.f35127b.getMainLooper()).post(new e(bVar));
    }

    public final boolean u(String str) {
        return j(str).exists();
    }

    @Deprecated(message = "This method has been deprecated from 2.4.0.", replaceWith = @ReplaceWith(expression = "this.decodeFromAssets(assetsName, callback)", imports = {}))
    public final void v(String str, b bVar) {
        m(str, bVar);
    }

    @Deprecated(message = "This method has been deprecated from 2.4.0.", replaceWith = @ReplaceWith(expression = "this.decodeFromURL(url, callback)", imports = {}))
    public final void w(URL url, b bVar) {
        q(url, bVar);
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final byte[] x(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = inputStream.read(bArr, 0, 2048);
                if (read <= 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final void y(InputStream inputStream, String str) {
        int i2;
        i2 = d.l.a.d.f66382a;
        synchronized (Integer.valueOf(i2)) {
            File j = j(str);
            j.mkdirs();
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);
                    while (true) {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            String name = nextEntry.getName();
                            Intrinsics.checkExpressionValueIsNotNull(name, "zipItem.name");
                            if (!StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) "/", false, 2, (Object) null)) {
                                FileOutputStream fileOutputStream = new FileOutputStream(new File(j, nextEntry.getName()));
                                try {
                                    byte[] bArr = new byte[2048];
                                    while (true) {
                                        int read = zipInputStream.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(fileOutputStream, null);
                                    zipInputStream.closeEntry();
                                } finally {
                                }
                            }
                        } else {
                            Unit unit2 = Unit.INSTANCE;
                            CloseableKt.closeFinally(zipInputStream, null);
                            Unit unit3 = Unit.INSTANCE;
                            CloseableKt.closeFinally(bufferedInputStream, null);
                            Unit unit4 = Unit.INSTANCE;
                        }
                    }
                } finally {
                }
            } catch (Exception e2) {
                j.delete();
                throw e2;
            }
        }
    }
}
