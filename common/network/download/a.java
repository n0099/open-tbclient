package common.network.download;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import okhttp3.OkHttpClient;
/* loaded from: classes.dex */
public class a {
    private static a nuQ;
    private OkHttpClient mOkHttpClient;
    private File nuR;
    private Map<String, e> nuS;
    private c nuT;
    private ExecutorService nuU;

    public static a dIO() {
        return nuQ;
    }

    public void a(final f fVar, final g gVar) {
        this.nuU.submit(new Runnable() { // from class: common.network.download.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.nuS.containsKey(fVar.getName())) {
                    a.this.nuS.put(fVar.getName(), new e(fVar, a.this.nuR, a.this.nuU, a.this.mOkHttpClient, a.this.nuT));
                }
                ((e) a.this.nuS.get(fVar.getName())).a(gVar);
            }
        });
    }

    public void a(final f fVar) {
        this.nuU.submit(new Runnable() { // from class: common.network.download.a.2
            @Override // java.lang.Runnable
            public void run() {
                e eVar = (e) a.this.nuS.get(fVar.getName());
                if (eVar != null) {
                    eVar.cancel();
                }
            }
        });
    }
}
