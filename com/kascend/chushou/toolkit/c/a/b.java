package com.kascend.chushou.toolkit.c.a;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCancellationSignal;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UpProgressHandler;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.storage.UploadOptions;
import java.io.File;
import kotlin.h;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import org.json.JSONObject;
import tv.chushou.basis.d.a.a.c;
@h
/* loaded from: classes6.dex */
public final class b {
    private final UploadManager oha = new UploadManager();
    public static final a ohc = new a(null);
    private static final b ohb = new b();

    private b() {
    }

    @h
    /* renamed from: com.kascend.chushou.toolkit.c.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0902b implements UpCompletionHandler {
        final /* synthetic */ c.a ogY;

        C0902b(c.a aVar) {
            this.ogY = aVar;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public final void a(String str, ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo != null) {
                if (responseInfo.egl() && jSONObject != null) {
                    c.a aVar = this.ogY;
                    if (aVar != null) {
                        aVar.onSuccess(jSONObject.toString());
                        return;
                    }
                    return;
                }
                c.a aVar2 = this.ogY;
                if (aVar2 != null) {
                    aVar2.onFailure(-1, responseInfo.error, null);
                    return;
                }
                return;
            }
            c.a aVar3 = this.ogY;
            if (aVar3 != null) {
                aVar3.onFailure(-1, null, null);
            }
        }
    }

    public final void a(File file, String str, String str2, c.a aVar) {
        q.m(file, "f");
        q.m(str, "key");
        q.m(str2, "token");
        this.oha.a(file, str, str2, new C0902b(aVar), new UploadOptions(null, null, false, new c(aVar), d.ohd));
    }

    @h
    /* loaded from: classes6.dex */
    static final class c implements UpProgressHandler {
        final /* synthetic */ c.a ogY;

        c(c.a aVar) {
            this.ogY = aVar;
        }

        @Override // com.qiniu.android.storage.UpProgressHandler
        public final void d(String str, double d) {
            c.a aVar = this.ogY;
            if (aVar != null) {
                aVar.onProgress((int) (100 * d));
            }
        }
    }

    @h
    /* loaded from: classes6.dex */
    static final class d implements UpCancellationSignal {
        public static final d ohd = new d();

        d() {
        }

        @Override // com.qiniu.android.http.CancellationHandler
        public final boolean isCancelled() {
            return false;
        }
    }

    @h
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final b eeD() {
            return b.ohb;
        }
    }
}
