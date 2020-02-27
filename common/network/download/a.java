package common.network.download;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import okhttp3.OkHttpClient;
/* loaded from: classes.dex */
public class a {
    private static a nuD;
    private OkHttpClient mOkHttpClient;
    private File nuE;
    private Map<String, e> nuF;
    private c nuG;
    private ExecutorService nuH;

    public static a dIL() {
        return nuD;
    }

    public void a(final f fVar, final g gVar) {
        this.nuH.submit(new Runnable() { // from class: common.network.download.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.nuF.containsKey(fVar.getName())) {
                    a.this.nuF.put(fVar.getName(), new e(fVar, a.this.nuE, a.this.nuH, a.this.mOkHttpClient, a.this.nuG));
                }
                ((e) a.this.nuF.get(fVar.getName())).a(gVar);
            }
        });
    }

    public void a(final f fVar) {
        this.nuH.submit(new Runnable() { // from class: common.network.download.a.2
            @Override // java.lang.Runnable
            public void run() {
                e eVar = (e) a.this.nuF.get(fVar.getName());
                if (eVar != null) {
                    eVar.cancel();
                }
            }
        });
    }
}
