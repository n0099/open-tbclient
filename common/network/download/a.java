package common.network.download;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import okhttp3.OkHttpClient;
/* loaded from: classes.dex */
public class a {
    private static a nuF;
    private OkHttpClient mOkHttpClient;
    private File nuG;
    private Map<String, e> nuH;
    private c nuI;
    private ExecutorService nuJ;

    public static a dIN() {
        return nuF;
    }

    public void a(final f fVar, final g gVar) {
        this.nuJ.submit(new Runnable() { // from class: common.network.download.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.nuH.containsKey(fVar.getName())) {
                    a.this.nuH.put(fVar.getName(), new e(fVar, a.this.nuG, a.this.nuJ, a.this.mOkHttpClient, a.this.nuI));
                }
                ((e) a.this.nuH.get(fVar.getName())).a(gVar);
            }
        });
    }

    public void a(final f fVar) {
        this.nuJ.submit(new Runnable() { // from class: common.network.download.a.2
            @Override // java.lang.Runnable
            public void run() {
                e eVar = (e) a.this.nuH.get(fVar.getName());
                if (eVar != null) {
                    eVar.cancel();
                }
            }
        });
    }
}
