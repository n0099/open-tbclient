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
/* loaded from: classes5.dex */
public final class b {
    private final UploadManager nup = new UploadManager();
    public static final a nur = new a(null);
    private static final b nuq = new b();

    private b() {
    }

    @h
    /* renamed from: com.kascend.chushou.toolkit.c.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static final class C0837b implements UpCompletionHandler {
        final /* synthetic */ c.a nun;

        C0837b(c.a aVar) {
            this.nun = aVar;
        }

        @Override // com.qiniu.android.storage.UpCompletionHandler
        public final void a(String str, ResponseInfo responseInfo, JSONObject jSONObject) {
            if (responseInfo != null) {
                if (responseInfo.dMC() && jSONObject != null) {
                    c.a aVar = this.nun;
                    if (aVar != null) {
                        aVar.onSuccess(jSONObject.toString());
                        return;
                    }
                    return;
                }
                c.a aVar2 = this.nun;
                if (aVar2 != null) {
                    aVar2.onFailure(-1, responseInfo.error, null);
                    return;
                }
                return;
            }
            c.a aVar3 = this.nun;
            if (aVar3 != null) {
                aVar3.onFailure(-1, null, null);
            }
        }
    }

    public final void a(File file, String str, String str2, c.a aVar) {
        q.m(file, "f");
        q.m(str, "key");
        q.m(str2, "token");
        this.nup.a(file, str, str2, new C0837b(aVar), new UploadOptions(null, null, false, new c(aVar), d.nus));
    }

    @h
    /* loaded from: classes5.dex */
    static final class c implements UpProgressHandler {
        final /* synthetic */ c.a nun;

        c(c.a aVar) {
            this.nun = aVar;
        }

        @Override // com.qiniu.android.storage.UpProgressHandler
        public final void b(String str, double d) {
            c.a aVar = this.nun;
            if (aVar != null) {
                aVar.onProgress((int) (100 * d));
            }
        }
    }

    @h
    /* loaded from: classes5.dex */
    static final class d implements UpCancellationSignal {
        public static final d nus = new d();

        d() {
        }

        @Override // com.qiniu.android.http.CancellationHandler
        public final boolean isCancelled() {
            return false;
        }
    }

    @h
    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final b dKU() {
            return b.nuq;
        }
    }
}
