package com.opensource.svgaplayer;

import android.content.Context;
import android.net.http.HttpResponseCache;
import android.os.Handler;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public final class SVGAParser {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final LinkedBlockingQueue<Runnable> f40592c;

    /* renamed from: d  reason: collision with root package name */
    public static ThreadPoolExecutor f40593d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f40594e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FileDownloader f40595a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f40596b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u0000B\u0007¢\u0006\u0004\b\u0018\u0010\u0019Jg\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u0002\u001a\u00020\u00012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00032%\u0010\r\u001a!\u0012\u0017\u0012\u00150\nj\u0002`\u000b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\b0\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/opensource/svgaplayer/SVGAParser$FileDownloader;", "Ljava/net/URL;", "url", "Lkotlin/Function1;", "Ljava/io/InputStream;", "Lkotlin/ParameterName;", "name", "inputStream", "", XAdRemoteEvent.COMPLETE, "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", SmsLoginView.f.l, "Lkotlin/Function0;", "resume", "(Ljava/net/URL;Lkotlin/Function1;Lkotlin/Function1;)Lkotlin/Function0;", "", "noCache", "Z", "getNoCache", "()Z", "setNoCache", "(Z)V", "<init>", "()V", "library_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static class FileDownloader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f40597a;

        /* loaded from: classes7.dex */
        public static final class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ FileDownloader f40598e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ URL f40599f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f40600g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ Function1 f40601h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ Function1 f40602i;

            public a(FileDownloader fileDownloader, URL url, Ref.BooleanRef booleanRef, Function1 function1, Function1 function12) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fileDownloader, url, booleanRef, function1, function12};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f40598e = fileDownloader;
                this.f40599f = url;
                this.f40600g = booleanRef;
                this.f40601h = function1;
                this.f40602i = function12;
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            @Override // java.lang.Runnable
            public final void run() {
                int read;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        if (HttpResponseCache.getInstalled() == null && !this.f40598e.a()) {
                            Log.e("SVGAParser", "SVGAParser can not handle cache before install HttpResponseCache. see https://github.com/yyued/SVGAPlayer-Android#cache");
                            Log.e("SVGAParser", "在配置 HttpResponseCache 前 SVGAParser 无法缓存. 查看 https://github.com/yyued/SVGAPlayer-Android#cache ");
                        }
                        URLConnection openConnection = this.f40599f.openConnection();
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
                            while (!this.f40600g.element && (read = inputStream.read(bArr, 0, 4096)) != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            if (this.f40600g.element) {
                                CloseableKt.closeFinally(byteArrayOutputStream, null);
                                CloseableKt.closeFinally(inputStream, null);
                                return;
                            }
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            try {
                                this.f40601h.invoke(byteArrayInputStream);
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
                        this.f40602i.invoke(e2);
                    }
                }
            }
        }

        public FileDownloader() {
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

        public final boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40597a : invokeV.booleanValue;
        }

        public Function0<Unit> b(URL url, Function1<? super InputStream, Unit> function1, Function1<? super Exception, Unit> function12) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, url, function1, function12)) == null) {
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                booleanRef.element = false;
                SVGAParser$FileDownloader$resume$cancelBlock$1 sVGAParser$FileDownloader$resume$cancelBlock$1 = new SVGAParser$FileDownloader$resume$cancelBlock$1(booleanRef);
                SVGAParser.f40594e.a().execute(new a(this, url, booleanRef, function1, function12));
                return sVGAParser$FileDownloader$resume$cancelBlock$1;
            }
            return (Function0) invokeLLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public final ThreadPoolExecutor a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SVGAParser.f40593d : (ThreadPoolExecutor) invokeV.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(SVGAVideoEntity sVGAVideoEntity);

        void onError();
    }

    /* loaded from: classes7.dex */
    public static final class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SVGAParser f40603e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ URL f40604f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f40605g;

        public c(SVGAParser sVGAParser, URL url, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVGAParser, url, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40603e = sVGAParser;
            this.f40604f = url;
            this.f40605g = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SVGAParser sVGAParser = this.f40603e;
                sVGAParser.n(sVGAParser.l(this.f40604f), this.f40605g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f40606e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SVGAVideoEntity f40607f;

        public d(b bVar, SVGAVideoEntity sVGAVideoEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sVGAVideoEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40606e = bVar;
            this.f40607f = sVGAVideoEntity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f40606e.a(this.f40607f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f40613e;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40613e = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f40613e.onError();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-595567010, "Lcom/opensource/svgaplayer/SVGAParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-595567010, "Lcom/opensource/svgaplayer/SVGAParser;");
                return;
            }
        }
        f40594e = new a(null);
        f40592c = new LinkedBlockingQueue<>();
        f40593d = new ThreadPoolExecutor(3, 10, 60000L, TimeUnit.MILLISECONDS, f40592c);
    }

    public SVGAParser(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40596b = context;
        this.f40595a = new FileDownloader();
    }

    public static /* synthetic */ void p(SVGAParser sVGAParser, InputStream inputStream, String str, b bVar, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        sVGAParser.o(inputStream, str, bVar, z);
    }

    public final File j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            StringBuilder sb = new StringBuilder();
            File cacheDir = this.f40596b.getCacheDir();
            Intrinsics.checkExpressionValueIsNotNull(cacheDir, "context.cacheDir");
            sb.append(cacheDir.getAbsolutePath());
            sb.append("/");
            sb.append(str);
            sb.append("/");
            return new File(sb.toString());
        }
        return (File) invokeL.objValue;
    }

    public final String k(String str) {
        InterceptResult invokeL;
        byte[] digest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
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
        return (String) invokeL.objValue;
    }

    public final String l(URL url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, url)) == null) {
            String url2 = url.toString();
            Intrinsics.checkExpressionValueIsNotNull(url2, "url.toString()");
            return k(url2);
        }
        return (String) invokeL.objValue;
    }

    public final void m(String str, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, bVar) == null) {
            try {
                InputStream open = this.f40596b.getAssets().open(str);
                if (open != null) {
                    o(open, k("file:///assets/" + str), bVar, true);
                }
            } catch (Exception e2) {
                t(e2, bVar);
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final void n(String str, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048580, this, str, bVar) != null) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            File cacheDir = this.f40596b.getCacheDir();
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
                try {
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
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(byteArrayOutputStream, th);
                        throw th2;
                    }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{inputStream, str, bVar, Boolean.valueOf(z)}) == null) {
            f40593d.execute(new SVGAParser$decodeFromInputStream$1(this, inputStream, str, bVar, z));
        }
    }

    public final Function0<Unit> q(URL url, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, url, bVar)) == null) {
            if (u(l(url))) {
                f40593d.execute(new c(this, url, bVar));
                return null;
            }
            return this.f40595a.b(url, new SVGAParser$decodeFromURL$2(this, url, bVar), new SVGAParser$decodeFromURL$3(this, bVar));
        }
        return (Function0) invokeLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final byte[] r(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048583, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVGAVideoEntity, bVar) == null) {
            new Handler(this.f40596b.getMainLooper()).post(new d(bVar, sVGAVideoEntity));
        }
    }

    public final void t(Exception exc, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, exc, bVar) == null) {
            exc.printStackTrace();
            new Handler(this.f40596b.getMainLooper()).post(new e(bVar));
        }
    }

    public final boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? j(str).exists() : invokeL.booleanValue;
    }

    @Deprecated(message = "This method has been deprecated from 2.4.0.", replaceWith = @ReplaceWith(expression = "this.decodeFromAssets(assetsName, callback)", imports = {}))
    public final void v(String str, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, bVar) == null) {
            m(str, bVar);
        }
    }

    @Deprecated(message = "This method has been deprecated from 2.4.0.", replaceWith = @ReplaceWith(expression = "this.decodeFromURL(url, callback)", imports = {}))
    public final void w(URL url, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, url, bVar) == null) {
            q(url, bVar);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final byte[] x(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048589, this, inputStream)) != null) {
            return (byte[]) invokeL.objValue;
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, inputStream, str) == null) {
            i2 = d.j.a.d.f73951a;
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
}
