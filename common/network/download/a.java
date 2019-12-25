package common.network.download;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import okhttp3.OkHttpClient;
/* loaded from: classes.dex */
public class a {
    private static a mRO;
    private OkHttpClient mOkHttpClient;
    private File mRP;
    private Map<String, e> mRQ;
    private c mRR;
    private ExecutorService mRS;

    public static a dDw() {
        return mRO;
    }

    public void a(final f fVar, final g gVar) {
        this.mRS.submit(new Runnable() { // from class: common.network.download.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.mRQ.containsKey(fVar.getName())) {
                    a.this.mRQ.put(fVar.getName(), new e(fVar, a.this.mRP, a.this.mRS, a.this.mOkHttpClient, a.this.mRR));
                }
                ((e) a.this.mRQ.get(fVar.getName())).a(gVar);
            }
        });
    }

    public void a(final f fVar) {
        this.mRS.submit(new Runnable() { // from class: common.network.download.a.2
            @Override // java.lang.Runnable
            public void run() {
                e eVar = (e) a.this.mRQ.get(fVar.getName());
                if (eVar != null) {
                    eVar.cancel();
                }
            }
        });
    }
}
