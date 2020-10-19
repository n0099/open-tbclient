package tv.chushou.basis.http.impl;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.SystemClock;
import android.support.annotation.Keep;
import android.text.TextUtils;
import io.reactivex.BackpressureStrategy;
import io.reactivex.c.j;
import io.reactivex.f.a;
import io.reactivex.g;
import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.v;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.a.d;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.basis.d.a.b.b;
import tv.chushou.basis.d.a.b.c;
import tv.chushou.basis.http.Http;
import tv.chushou.basis.http.HttpConsts;
import tv.chushou.basis.http.HttpException;
import tv.chushou.basis.http.HttpExecutor;
import tv.chushou.basis.http.listener.DownloadListener;
import tv.chushou.basis.http.model.HttpParam;
import tv.chushou.basis.http.model.MultiPartArg;
import tv.chushou.basis.http.model.RequestTag;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.basis.rxjava.thread.ThreadHandler;
@Keep
@SuppressLint({"CheckResult"})
/* loaded from: classes6.dex */
public class HttpImpl extends HttpExecutor implements Http {
    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [tv.chushou.basis.http.impl.HttpImpl.7.subscribe(io.reactivex.h<java.io.File>):void] */
    static /* synthetic */ Request.Builder access$000(HttpImpl httpImpl, Request.Builder builder) {
        return httpImpl.commonHeaders(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Request.Builder commonHeaders(Request.Builder builder) {
        Map<String, String> eil;
        b bVar = (b) tv.chushou.basis.d.b.etD().S(b.class);
        if (bVar != null && (eil = bVar.eil()) != null) {
            for (Map.Entry<String, String> entry : eil.entrySet()) {
                builder.header(entry.getKey(), entry.getValue());
            }
        }
        return builder;
    }

    private v getScheduler(EventThread eventThread, ExecutorService executorService) {
        switch (eventThread) {
            case NEW_THREAD:
                return a.enu();
            case IO:
                return a.ens();
            case COMPUTATION:
                return a.enr();
            case TRAMPOLINE:
                return a.ent();
            case SINGLE:
                return a.env();
            case EXECUTOR:
                return executorService != null ? a.a(executorService) : a.ens();
            case HANDLER:
                return io.reactivex.a.b.a.c(ThreadHandler.DEFAULT.getHandler().getLooper());
            default:
                return io.reactivex.a.b.a.emM();
        }
    }

    @Override // tv.chushou.basis.http.HttpExecutor
    public void customOkHttpClient() {
        OkHttpClient.Builder writeTimeout = getOkHttpClient().newBuilder().connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS);
        writeTimeout.addInterceptor(new tv.chushou.basis.http.a.a());
        this.mClient = writeTimeout.build();
    }

    public void destroy() {
    }

    @Override // tv.chushou.basis.http.Http
    public void downloadAsync(final String str, final File file, final DownloadListener downloadListener) {
        g.a(new i<File>() { // from class: tv.chushou.basis.http.impl.HttpImpl.7
            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
                	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
                	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
                */
            @Override // io.reactivex.i
            public void subscribe(io.reactivex.h<java.io.File> r19) {
                /*
                    r18 = this;
                    boolean r2 = r19.isCancelled()
                    if (r2 == 0) goto L7
                L6:
                    return
                L7:
                    r0 = r18
                    tv.chushou.basis.http.impl.HttpImpl r2 = tv.chushou.basis.http.impl.HttpImpl.this
                    okhttp3.Request$Builder r3 = new okhttp3.Request$Builder
                    r3.<init>()
                    r0 = r18
                    java.lang.String r4 = r2
                    okhttp3.Request$Builder r3 = r3.url(r4)
                    tv.chushou.basis.http.model.RequestTag r4 = tv.chushou.basis.http.model.RequestTag.thirdParty()
                    okhttp3.Request$Builder r3 = r3.tag(r4)
                    okhttp3.Request$Builder r2 = tv.chushou.basis.http.impl.HttpImpl.access$000(r2, r3)
                    okhttp3.Request r3 = r2.build()
                    r4 = 0
                    r2 = 0
                    r5 = 0
                    r0 = r18
                    java.io.File r6 = r3     // Catch: java.lang.Throwable -> L19f
                    java.io.File r6 = r6.getParentFile()     // Catch: java.lang.Throwable -> L19f
                    boolean r7 = r6.exists()     // Catch: java.lang.Throwable -> L19f
                    if (r7 != 0) goto L5c
                    boolean r7 = r6.mkdirs()     // Catch: java.lang.Throwable -> L19f
                    if (r7 != 0) goto L5c
                    java.io.IOException r3 = new java.io.IOException     // Catch: java.lang.Throwable -> L19f
                    java.lang.String r6 = "parent directory create failed"
                    r3.<init>(r6)     // Catch: java.lang.Throwable -> L19f
                    r0 = r19
                    r0.onError(r3)     // Catch: java.lang.Throwable -> L19f
                    r3 = 3
                    java.io.Closeable[] r3 = new java.io.Closeable[r3]
                    r6 = 0
                    r3[r6] = r2
                    r2 = 1
                    r3[r2] = r4
                    r2 = 2
                    r3[r2] = r5
                    tv.chushou.a.a.d.a.b(r3)
                    goto L6
                L5c:
                    java.io.File r10 = new java.io.File     // Catch: java.lang.Throwable -> L19f
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L19f
                    r7.<init>()     // Catch: java.lang.Throwable -> L19f
                    r0 = r18
                    java.io.File r8 = r3     // Catch: java.lang.Throwable -> L19f
                    java.lang.String r8 = r8.getName()     // Catch: java.lang.Throwable -> L19f
                    java.lang.StringBuilder r7 = r7.append(r8)     // Catch: java.lang.Throwable -> L19f
                    java.lang.String r8 = ".bak"
                    java.lang.StringBuilder r7 = r7.append(r8)     // Catch: java.lang.Throwable -> L19f
                    java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L19f
                    r10.<init>(r6, r7)     // Catch: java.lang.Throwable -> L19f
                    okhttp3.OkHttpClient r6 = tv.chushou.basis.http.HttpExecutor.getOkHttpClient()     // Catch: java.lang.Throwable -> L19f
                    okhttp3.Call r3 = r6.newCall(r3)     // Catch: java.lang.Throwable -> L19f
                    okhttp3.Response r5 = r3.execute()     // Catch: java.lang.Throwable -> L19f
                    int r3 = r5.code()     // Catch: java.lang.Throwable -> L17e
                    r6 = 200(0xc8, float:2.8E-43)
                    if (r3 != r6) goto L15b
                    okhttp3.ResponseBody r3 = r5.body()     // Catch: java.lang.Throwable -> L17e
                    if (r3 == 0) goto L14c
                    long r12 = r3.contentLength()     // Catch: java.lang.Throwable -> L17e
                    r8 = 0
                    r6 = 0
                    r7 = 30720(0x7800, float:4.3048E-41)
                    byte[] r11 = new byte[r7]     // Catch: java.lang.Throwable -> L17e
                    java.io.InputStream r2 = r3.byteStream()     // Catch: java.lang.Throwable -> L17e
                    java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L1a9
                    r3.<init>(r10)     // Catch: java.lang.Throwable -> L1a9
                    r4 = r6
                    r6 = r8
                Lad:
                    int r8 = r2.read(r11)     // Catch: java.lang.Throwable -> Ldd
                    r9 = -1
                    if (r8 == r9) goto Lfe
                    r9 = 0
                    r3.write(r11, r9, r8)     // Catch: java.lang.Throwable -> Ldd
                    r0 = r18
                    tv.chushou.basis.http.listener.DownloadListener r9 = r4     // Catch: java.lang.Throwable -> Ldd
                    if (r9 == 0) goto Lad
                    long r8 = (long) r8     // Catch: java.lang.Throwable -> Ldd
                    long r6 = r6 + r8
                    int r8 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
                    if (r8 == 0) goto Ld0
                    r8 = 100
                    long r8 = r8 * r6
                    long r8 = r8 / r12
                    long r14 = (long) r4     // Catch: java.lang.Throwable -> Ldd
                    long r8 = r8 - r14
                    r14 = 3
                    int r8 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
                    if (r8 <= 0) goto Lad
                Ld0:
                    r8 = 100
                    long r8 = r8 * r6
                    long r8 = r8 / r12
                    int r4 = (int) r8     // Catch: java.lang.Throwable -> Ldd
                    r0 = r18
                    tv.chushou.basis.http.listener.DownloadListener r8 = r4     // Catch: java.lang.Throwable -> Ldd
                    r8.onProgress(r4)     // Catch: java.lang.Throwable -> Ldd
                    goto Lad
                Ldd:
                    r4 = move-exception
                    r16 = r4
                    r4 = r2
                    r2 = r16
                    r17 = r5
                    r5 = r3
                    r3 = r17
                Le8:
                    r0 = r19
                    r0.onError(r2)     // Catch: java.lang.Throwable -> L198
                    r2 = 3
                    java.io.Closeable[] r2 = new java.io.Closeable[r2]
                    r6 = 0
                    r2[r6] = r4
                    r4 = 1
                    r2[r4] = r5
                    r4 = 2
                    r2[r4] = r3
                    tv.chushou.a.a.d.a.b(r2)
                    goto L6
                Lfe:
                    r3.flush()     // Catch: java.lang.Throwable -> Ldd
                    r0 = r18
                    java.io.File r4 = r3     // Catch: java.lang.Throwable -> Ldd
                    boolean r4 = r10.renameTo(r4)     // Catch: java.lang.Throwable -> Ldd
                    if (r4 == 0) goto L128
                    r0 = r18
                    java.io.File r4 = r3     // Catch: java.lang.Throwable -> Ldd
                    r0 = r19
                    r0.onNext(r4)     // Catch: java.lang.Throwable -> Ldd
                    r19.onComplete()     // Catch: java.lang.Throwable -> Ldd
                L117:
                    r4 = 3
                    java.io.Closeable[] r4 = new java.io.Closeable[r4]
                    r6 = 0
                    r4[r6] = r2
                    r2 = 1
                    r4[r2] = r3
                    r2 = 2
                    r4[r2] = r5
                    tv.chushou.a.a.d.a.b(r4)
                    goto L6
                L128:
                    java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Throwable -> Ldd
                    java.lang.String r6 = "downloa file,rename backup failed"
                    r4.<init>(r6)     // Catch: java.lang.Throwable -> Ldd
                    r0 = r19
                    r0.onError(r4)     // Catch: java.lang.Throwable -> Ldd
                    goto L117
                L136:
                    r4 = move-exception
                    r16 = r4
                    r4 = r2
                    r2 = r16
                L13c:
                    r6 = 3
                    java.io.Closeable[] r6 = new java.io.Closeable[r6]
                    r7 = 0
                    r6[r7] = r4
                    r4 = 1
                    r6[r4] = r3
                    r3 = 2
                    r6[r3] = r5
                    tv.chushou.a.a.d.a.b(r6)
                    throw r2
                L14c:
                    java.io.IOException r3 = new java.io.IOException     // Catch: java.lang.Throwable -> L17e
                    java.lang.String r6 = "response body is null"
                    r3.<init>(r6)     // Catch: java.lang.Throwable -> L17e
                    r0 = r19
                    r0.onError(r3)     // Catch: java.lang.Throwable -> L17e
                L159:
                    r3 = r4
                    goto L117
                L15b:
                    java.io.IOException r3 = new java.io.IOException     // Catch: java.lang.Throwable -> L17e
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L17e
                    r6.<init>()     // Catch: java.lang.Throwable -> L17e
                    java.lang.String r7 = "download file, but responce code:"
                    java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L17e
                    int r7 = r5.code()     // Catch: java.lang.Throwable -> L17e
                    java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L17e
                    java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L17e
                    r3.<init>(r6)     // Catch: java.lang.Throwable -> L17e
                    r0 = r19
                    r0.onError(r3)     // Catch: java.lang.Throwable -> L17e
                    goto L159
                L17e:
                    r3 = move-exception
                    r16 = r3
                    r3 = r5
                    r5 = r4
                    r4 = r2
                    r2 = r16
                    goto Le8
                L188:
                    r3 = move-exception
                    r16 = r3
                    r3 = r4
                    r4 = r2
                    r2 = r16
                    goto L13c
                L190:
                    r3 = move-exception
                    r16 = r3
                    r3 = r4
                    r4 = r2
                    r2 = r16
                    goto L13c
                L198:
                    r2 = move-exception
                    r16 = r3
                    r3 = r5
                    r5 = r16
                    goto L13c
                L19f:
                    r3 = move-exception
                    r16 = r3
                    r3 = r5
                    r5 = r4
                    r4 = r2
                    r2 = r16
                    goto Le8
                L1a9:
                    r3 = move-exception
                    r16 = r3
                    r3 = r5
                    r5 = r4
                    r4 = r2
                    r2 = r16
                    goto Le8
                */
                throw new UnsupportedOperationException("Method not decompiled: tv.chushou.basis.http.impl.HttpImpl.AnonymousClass7.subscribe(io.reactivex.h):void");
            }
        }, BackpressureStrategy.LATEST).b(a.ens()).a(new io.reactivex.c.g<d>() { // from class: tv.chushou.basis.http.impl.HttpImpl.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(d dVar) {
                if (downloadListener != null) {
                    downloadListener.onStart();
                }
            }
        }).b(io.reactivex.a.b.a.emM()).a(io.reactivex.a.b.a.emM()).a(new io.reactivex.c.g<File>() { // from class: tv.chushou.basis.http.impl.HttpImpl.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(File file2) {
                if (downloadListener != null) {
                    downloadListener.onSuccess(file2);
                }
            }
        }, new io.reactivex.c.g<Throwable>() { // from class: tv.chushou.basis.http.impl.HttpImpl.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(Throwable th) {
                tv.chushou.basis.d.b.etC().e(HttpExecutor.TAG, "", th);
                if (downloadListener != null) {
                    downloadListener.onFailure(-1, "", th);
                }
            }
        });
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // tv.chushou.basis.http.Http
    public boolean downloadSync(java.lang.String r11, java.io.OutputStream r12) {
        /*
            r10 = this;
            r3 = 0
            r8 = 3
            r7 = 2
            r0 = 1
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r11)
            if (r2 != 0) goto Ld
            if (r12 != 0) goto Lf
        Ld:
            r0 = r1
        Le:
            return r0
        Lf:
            okhttp3.Request$Builder r2 = new okhttp3.Request$Builder
            r2.<init>()
            okhttp3.Request$Builder r2 = r2.url(r11)
            tv.chushou.basis.http.model.RequestTag r4 = tv.chushou.basis.http.model.RequestTag.thirdParty()
            okhttp3.Request$Builder r2 = r2.tag(r4)
            okhttp3.Request$Builder r2 = r10.commonHeaders(r2)
            okhttp3.Request r2 = r2.build()
            okhttp3.OkHttpClient r4 = getOkHttpClient()     // Catch: java.lang.Throwable -> L9a
            okhttp3.Call r2 = r4.newCall(r2)     // Catch: java.lang.Throwable -> L9a
            okhttp3.Response r2 = r2.execute()     // Catch: java.lang.Throwable -> L9a
            int r4 = r2.code()     // Catch: java.lang.Throwable -> L56
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 != r5) goto L73
            okhttp3.ResponseBody r4 = r2.body()     // Catch: java.lang.Throwable -> L56
            if (r4 == 0) goto L73
            r5 = 30720(0x7800, float:4.3048E-41)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L56
            java.io.InputStream r3 = r4.byteStream()     // Catch: java.lang.Throwable -> L56
        L4a:
            int r4 = r3.read(r5)     // Catch: java.lang.Throwable -> L56
            r6 = -1
            if (r4 == r6) goto L64
            r6 = 0
            r12.write(r5, r6, r4)     // Catch: java.lang.Throwable -> L56
            goto L4a
        L56:
            r4 = move-exception
        L57:
            java.io.Closeable[] r4 = new java.io.Closeable[r8]
            r4[r1] = r3
            r4[r0] = r12
            r4[r7] = r2
            tv.chushou.a.a.d.a.b(r4)
            r0 = r1
            goto Le
        L64:
            r12.flush()     // Catch: java.lang.Throwable -> L56
            java.io.Closeable[] r4 = new java.io.Closeable[r8]
            r4[r1] = r3
            r4[r0] = r12
            r4[r7] = r2
            tv.chushou.a.a.d.a.b(r4)
            goto Le
        L73:
            java.io.Closeable[] r4 = new java.io.Closeable[r8]
            r4[r1] = r3
            r4[r0] = r12
            r4[r7] = r2
            tv.chushou.a.a.d.a.b(r4)
            r0 = r1
            goto Le
        L80:
            r2 = move-exception
            r4 = r3
        L82:
            java.io.Closeable[] r5 = new java.io.Closeable[r8]
            r5[r1] = r4
            r5[r0] = r12
            r5[r7] = r3
            tv.chushou.a.a.d.a.b(r5)
            throw r2
        L8e:
            r4 = move-exception
            r9 = r4
            r4 = r3
            r3 = r2
            r2 = r9
            goto L82
        L94:
            r4 = move-exception
            r9 = r4
            r4 = r3
            r3 = r2
            r2 = r9
            goto L82
        L9a:
            r2 = move-exception
            r2 = r3
            goto L57
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.chushou.basis.http.impl.HttpImpl.downloadSync(java.lang.String, java.io.OutputStream):boolean");
    }

    @Override // tv.chushou.basis.http.Http
    public void getAsync(final String str, final String str2, final Map<String, Object> map, RequestTag requestTag, final tv.chushou.basis.d.a.c.a<Http.Resp> aVar) {
        final RequestTag thirdParty = requestTag == null ? RequestTag.thirdParty() : requestTag;
        g.a(new i<Http.Resp>() { // from class: tv.chushou.basis.http.impl.HttpImpl.13
            @Override // io.reactivex.i
            public void subscribe(h<Http.Resp> hVar) {
                if (hVar.isCancelled()) {
                    return;
                }
                hVar.onNext(HttpImpl.this.getSync(str, str2, map, thirdParty));
                hVar.onComplete();
            }
        }, BackpressureStrategy.LATEST).a(new io.reactivex.c.h<Http.Resp, Http.Resp>() { // from class: tv.chushou.basis.http.impl.HttpImpl.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.h
            /* renamed from: b */
            public Http.Resp apply(Http.Resp resp) {
                if (JSONObject.class.equals(thirdParty.respType)) {
                    if ((resp.respJson != null ? resp.respJson.optInt("code", -1) : -1) == 602) {
                        c cVar = (c) tv.chushou.basis.d.b.etD().S(c.class);
                        if (cVar != null) {
                            cVar.eiq();
                        }
                        throw new HttpException(6);
                    }
                }
                return resp;
            }
        }).a(1L, new j<Throwable>() { // from class: tv.chushou.basis.http.impl.HttpImpl.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.j
            /* renamed from: j */
            public boolean test(Throwable th) {
                return (th instanceof HttpException) && ((HttpException) th).errorCode() == 602;
            }
        }).b(getScheduler(thirdParty.thread, thirdParty.executorService)).a(new io.reactivex.c.g<d>() { // from class: tv.chushou.basis.http.impl.HttpImpl.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(d dVar) {
                if (aVar != null) {
                    aVar.onStart();
                }
            }
        }).b(getScheduler(thirdParty.callbackThread, null)).a(getScheduler(thirdParty.callbackThread, null)).a(new io.reactivex.c.g<Http.Resp>() { // from class: tv.chushou.basis.http.impl.HttpImpl.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(Http.Resp resp) {
                if (aVar != null) {
                    aVar.onSuccess(resp);
                }
            }
        }, new io.reactivex.c.g<Throwable>() { // from class: tv.chushou.basis.http.impl.HttpImpl.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(Throwable th) {
                tv.chushou.basis.d.b.etC().e(HttpExecutor.TAG, "", th);
                if (aVar != null) {
                    aVar.onFailure(-1, "", th);
                }
            }
        });
    }

    @Override // tv.chushou.basis.http.Http
    public Http.Resp getSync(String str, String str2, Map<String, Object> map, RequestTag requestTag) {
        if (requestTag == null) {
            requestTag = RequestTag.thirdParty();
        }
        Http.Resp resp = new Http.Resp();
        resp.baseUrl = str;
        resp.path = str2;
        resp.sentRequestAtMillis = SystemClock.uptimeMillis();
        String str3 = str + str2;
        HttpUrl parse = HttpUrl.parse(str + str2);
        if (parse == null) {
            throw new HttpException(1, "httpUrl parse failed:" + str3);
        }
        if (map != null && !map.isEmpty()) {
            HttpUrl.Builder newBuilder = parse.newBuilder();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    Object value = entry.getValue();
                    String obj = value == null ? "" : value.toString();
                    if (requestTag.supportEmpty) {
                        newBuilder.addQueryParameter(key, obj);
                    } else if (!TextUtils.isEmpty(obj)) {
                        newBuilder.addQueryParameter(key, obj);
                    }
                }
            }
            parse = newBuilder.build();
        }
        try {
            try {
                Response execute = this.mClient.newCall(commonHeaders(new Request.Builder().url(parse).get().tag(requestTag)).build()).execute();
                resp.code = execute.code();
                resp.ip = execute.header(HttpConsts.Header.RESPONSE_IP);
                if (resp.code == 200) {
                    ResponseBody body = execute.body();
                    if (body != null) {
                        resp.respString = body.string();
                    } else {
                        resp.respString = "";
                    }
                    if (JSONObject.class.equals(requestTag.respType)) {
                        try {
                            resp.respJson = new JSONObject(resp.respString);
                        } catch (JSONException e) {
                            throw new HttpException(5, "response string is not json, server:" + str3 + ", response string :" + resp.respString);
                        }
                    }
                    resp.receivedResponseAtMillis = SystemClock.uptimeMillis();
                    tv.chushou.a.a.d.a.b(execute);
                    return resp;
                }
                throw new HttpException(3, "response code is not 200:" + str3);
            } catch (IOException e2) {
                HttpException httpException = new HttpException(2, "request execute failed:" + str3, e2);
                resp.exception = httpException;
                throw httpException;
            }
        } catch (Throwable th) {
            resp.receivedResponseAtMillis = SystemClock.uptimeMillis();
            tv.chushou.a.a.d.a.b(null);
            throw th;
        }
    }

    @Override // tv.chushou.basis.d.a
    public void init(Application application) {
        customOkHttpClient();
    }

    @Override // tv.chushou.basis.http.Http
    public void multipartAsync(final String str, final String str2, final Map<String, Object> map, final List<MultiPartArg> list, RequestTag requestTag, final tv.chushou.basis.d.a.c.a<Http.Resp> aVar) {
        final RequestTag thirdParty = requestTag == null ? RequestTag.thirdParty() : requestTag;
        g.a(new i<Http.Resp>() { // from class: tv.chushou.basis.http.impl.HttpImpl.2
            @Override // io.reactivex.i
            public void subscribe(h<Http.Resp> hVar) {
                if (hVar.isCancelled()) {
                    return;
                }
                hVar.onNext(HttpImpl.this.multipartSync(str, str2, map, list, thirdParty));
                hVar.onComplete();
            }
        }, BackpressureStrategy.LATEST).a(new io.reactivex.c.h<Http.Resp, Http.Resp>() { // from class: tv.chushou.basis.http.impl.HttpImpl.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.h
            /* renamed from: b */
            public Http.Resp apply(Http.Resp resp) {
                if (JSONObject.class.equals(thirdParty.respType)) {
                    if ((resp.respJson != null ? resp.respJson.optInt("code", -1) : -1) == 602) {
                        c cVar = (c) tv.chushou.basis.d.b.etD().S(c.class);
                        if (cVar != null) {
                            cVar.eiq();
                        }
                        throw new HttpException(6);
                    }
                }
                return resp;
            }
        }).a(1L, new j<Throwable>() { // from class: tv.chushou.basis.http.impl.HttpImpl.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.j
            /* renamed from: j */
            public boolean test(Throwable th) {
                return (th instanceof HttpException) && ((HttpException) th).errorCode() == 602;
            }
        }).b(getScheduler(thirdParty.thread, thirdParty.executorService)).a(new io.reactivex.c.g<d>() { // from class: tv.chushou.basis.http.impl.HttpImpl.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(d dVar) {
                if (aVar != null) {
                    aVar.onStart();
                }
            }
        }).b(getScheduler(thirdParty.callbackThread, null)).a(getScheduler(thirdParty.callbackThread, null)).a(new io.reactivex.c.g<Http.Resp>() { // from class: tv.chushou.basis.http.impl.HttpImpl.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(Http.Resp resp) {
                if (aVar != null) {
                    aVar.onSuccess(resp);
                }
            }
        }, new io.reactivex.c.g<Throwable>() { // from class: tv.chushou.basis.http.impl.HttpImpl.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(Throwable th) {
                tv.chushou.basis.d.b.etC().e(HttpExecutor.TAG, "", th);
                if (aVar != null) {
                    aVar.onFailure(-1, "", th);
                }
            }
        });
    }

    @Override // tv.chushou.basis.http.Http
    public Http.Resp multipartSync(String str, String str2, Map<String, Object> map, List<MultiPartArg> list, RequestTag requestTag) {
        RequestTag thirdParty = requestTag != null ? requestTag : RequestTag.thirdParty();
        Http.Resp resp = new Http.Resp();
        resp.baseUrl = str;
        resp.path = str2;
        resp.sentRequestAtMillis = SystemClock.uptimeMillis();
        String str3 = str + str2;
        HttpUrl parse = HttpUrl.parse(str + str2);
        if (parse == null) {
            throw new HttpException(1, "httpUrl parse failed:" + str3);
        }
        HttpParam httpParam = new HttpParam(requestTag);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!TextUtils.isEmpty(key)) {
                    String obj = value == null ? "" : value.toString();
                    if (thirdParty.supportEmpty) {
                        httpParam.a(key, obj);
                    } else {
                        httpParam.b(key, obj);
                    }
                }
            }
        }
        httpParam.a();
        httpParam.b();
        httpParam.c();
        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (Map.Entry<String, String> entry2 : httpParam.etA()) {
            type.addFormDataPart(entry2.getKey(), entry2.getValue());
        }
        if (list != null) {
            for (MultiPartArg multiPartArg : list) {
                multiPartArg.addToMultipartBoy(type);
            }
        }
        try {
            try {
                Response execute = this.mClient.newCall(commonHeaders(new Request.Builder().url(parse).post(type.build()).tag(thirdParty)).build()).execute();
                resp.receivedResponseAtMillis = SystemClock.uptimeMillis();
                resp.code = execute.code();
                resp.ip = execute.header(HttpConsts.Header.RESPONSE_IP);
                if (resp.code == 200) {
                    ResponseBody body = execute.body();
                    if (body != null) {
                        resp.respString = body.string();
                    } else {
                        resp.respString = "";
                    }
                    if (JSONObject.class.equals(thirdParty.respType)) {
                        try {
                            resp.respJson = new JSONObject(resp.respString);
                        } catch (JSONException e) {
                            throw new HttpException(5, "response string is not json, server:" + str3 + ", response string :" + resp.respString);
                        }
                    }
                    resp.receivedResponseAtMillis = SystemClock.uptimeMillis();
                    tv.chushou.a.a.d.a.b(execute);
                    return resp;
                }
                throw new HttpException(3, "response code is not 200:" + str3);
            } catch (IOException e2) {
                HttpException httpException = new HttpException(2, "request execute failed:" + str3, e2);
                resp.exception = httpException;
                throw httpException;
            }
        } catch (Throwable th) {
            resp.receivedResponseAtMillis = SystemClock.uptimeMillis();
            tv.chushou.a.a.d.a.b(null);
            throw th;
        }
    }

    @Override // tv.chushou.basis.http.Http
    public String packParams(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null || map.size() == 0) {
            return str;
        }
        HttpUrl parse = HttpUrl.parse(str);
        if (parse == null) {
            tv.chushou.basis.d.b.etC().e(HttpExecutor.TAG, "pack h5 url, parse failed:" + str);
            return str;
        }
        HttpUrl.Builder newBuilder = parse.newBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                Object value = entry.getValue();
                String obj = value == null ? "" : value.toString();
                if (!TextUtils.isEmpty(obj)) {
                    newBuilder.setQueryParameter(key, obj);
                }
            }
        }
        return newBuilder.toString();
    }

    @Override // tv.chushou.basis.http.Http
    public String packSystemParams(String str, Map<String, Object> map, RequestTag requestTag) {
        HttpUrl parse;
        if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
            return str;
        }
        HttpParam httpParam = new HttpParam(requestTag);
        HashSet<String> hashSet = new HashSet();
        for (int i = 0; i < parse.querySize(); i++) {
            String queryParameterName = parse.queryParameterName(i);
            String queryParameterValue = parse.queryParameterValue(i);
            hashSet.add(queryParameterName);
            if (requestTag.supportEmpty) {
                httpParam.a(queryParameterName, queryParameterValue);
            } else {
                httpParam.b(queryParameterName, queryParameterValue);
            }
        }
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    Object value = entry.getValue();
                    String obj = value == null ? "" : value.toString();
                    if (requestTag.supportEmpty) {
                        httpParam.a(key, obj);
                    } else {
                        httpParam.b(key, obj);
                    }
                }
            }
        }
        httpParam.a();
        httpParam.c();
        HttpUrl.Builder newBuilder = parse.newBuilder();
        for (String str2 : hashSet) {
            newBuilder.removeAllQueryParameters(str2);
        }
        for (Map.Entry<String, String> entry2 : httpParam.etA()) {
            newBuilder.addQueryParameter(entry2.getKey(), entry2.getValue());
        }
        return newBuilder.toString();
    }

    @Override // tv.chushou.basis.http.Http
    public void postAsync(final String str, final String str2, final Map<String, Object> map, RequestTag requestTag, final tv.chushou.basis.d.a.c.a<Http.Resp> aVar) {
        final RequestTag thirdParty = requestTag == null ? RequestTag.thirdParty() : requestTag;
        g.a(new i<Http.Resp>() { // from class: tv.chushou.basis.http.impl.HttpImpl.18
            @Override // io.reactivex.i
            public void subscribe(h<Http.Resp> hVar) {
                if (hVar.isCancelled()) {
                    return;
                }
                hVar.onNext(HttpImpl.this.postSync(str, str2, map, thirdParty));
                hVar.onComplete();
            }
        }, BackpressureStrategy.LATEST).a(new io.reactivex.c.h<Http.Resp, Http.Resp>() { // from class: tv.chushou.basis.http.impl.HttpImpl.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.h
            /* renamed from: b */
            public Http.Resp apply(Http.Resp resp) {
                if (JSONObject.class.equals(thirdParty.respType)) {
                    if ((resp.respJson != null ? resp.respJson.optInt("code", -1) : -1) == 602) {
                        c cVar = (c) tv.chushou.basis.d.b.etD().S(c.class);
                        if (cVar != null) {
                            cVar.eiq();
                        }
                        throw new HttpException(6);
                    }
                }
                return resp;
            }
        }).a(1L, new j<Throwable>() { // from class: tv.chushou.basis.http.impl.HttpImpl.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.j
            /* renamed from: j */
            public boolean test(Throwable th) {
                return (th instanceof HttpException) && ((HttpException) th).errorCode() == 602;
            }
        }).b(getScheduler(thirdParty.thread, thirdParty.executorService)).a(new io.reactivex.c.g<d>() { // from class: tv.chushou.basis.http.impl.HttpImpl.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(d dVar) {
                if (aVar != null) {
                    aVar.onStart();
                }
            }
        }).b(getScheduler(thirdParty.callbackThread, null)).a(getScheduler(thirdParty.callbackThread, null)).a(new io.reactivex.c.g<Http.Resp>() { // from class: tv.chushou.basis.http.impl.HttpImpl.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(Http.Resp resp) {
                if (aVar != null) {
                    aVar.onSuccess(resp);
                }
            }
        }, new io.reactivex.c.g<Throwable>() { // from class: tv.chushou.basis.http.impl.HttpImpl.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(Throwable th) {
                tv.chushou.basis.d.b.etC().e(HttpExecutor.TAG, "", th);
                if (aVar != null) {
                    aVar.onFailure(-1, "", th);
                }
            }
        });
    }

    @Override // tv.chushou.basis.http.Http
    public Http.Resp postSync(String str, String str2, Map<String, Object> map, RequestTag requestTag) {
        if (requestTag == null) {
            requestTag = RequestTag.thirdParty();
        }
        Http.Resp resp = new Http.Resp();
        resp.baseUrl = str;
        resp.path = str2;
        resp.sentRequestAtMillis = SystemClock.uptimeMillis();
        String str3 = str + str2;
        HttpUrl parse = HttpUrl.parse(str + str2);
        if (parse == null) {
            throw new HttpException(1, "httpUrl parse failed:" + str3);
        }
        Request.Builder commonHeaders = commonHeaders(new Request.Builder().url(parse));
        FormBody.Builder builder = new FormBody.Builder();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    Object value = entry.getValue();
                    String obj = value == null ? "" : value.toString();
                    if (requestTag.supportEmpty) {
                        builder.add(key, obj);
                    } else if (!TextUtils.isEmpty(obj)) {
                        builder.add(key, obj);
                    }
                }
            }
        }
        try {
            try {
                Response execute = this.mClient.newCall(commonHeaders.post(builder.build()).tag(requestTag).build()).execute();
                resp.code = execute.code();
                resp.ip = execute.header(HttpConsts.Header.RESPONSE_IP);
                if (resp.code == 200) {
                    ResponseBody body = execute.body();
                    if (body != null) {
                        resp.respString = body.string();
                    } else {
                        resp.respString = "";
                    }
                    if (JSONObject.class.equals(requestTag.respType)) {
                        try {
                            resp.respJson = new JSONObject(resp.respString);
                        } catch (JSONException e) {
                            throw new HttpException(5, "response string is not json, server:" + str3 + ", response string :" + resp.respString);
                        }
                    }
                    resp.receivedResponseAtMillis = SystemClock.uptimeMillis();
                    tv.chushou.a.a.d.a.b(execute);
                    return resp;
                }
                throw new HttpException(3, "response code is not 200:" + str3);
            } catch (IOException e2) {
                HttpException httpException = new HttpException(2, "request execute failed:" + str3, e2);
                resp.exception = httpException;
                throw httpException;
            }
        } catch (Throwable th) {
            resp.receivedResponseAtMillis = SystemClock.uptimeMillis();
            tv.chushou.a.a.d.a.b(null);
            throw th;
        }
    }
}
