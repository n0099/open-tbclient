package common.network.download;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import okhttp3.OkHttpClient;
/* loaded from: classes.dex */
public class a {
    private static a nwD;
    private OkHttpClient mOkHttpClient;
    private File nwE;
    private Map<String, e> nwF;
    private c nwG;
    private ExecutorService nwH;

    public static a dJo() {
        return nwD;
    }

    public void a(final f fVar, final g gVar) {
        this.nwH.submit(new Runnable() { // from class: common.network.download.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.nwF.containsKey(fVar.getName())) {
                    a.this.nwF.put(fVar.getName(), new e(fVar, a.this.nwE, a.this.nwH, a.this.mOkHttpClient, a.this.nwG));
                }
                ((e) a.this.nwF.get(fVar.getName())).a(gVar);
            }
        });
    }

    public void a(final f fVar) {
        this.nwH.submit(new Runnable() { // from class: common.network.download.a.2
            @Override // java.lang.Runnable
            public void run() {
                e eVar = (e) a.this.nwF.get(fVar.getName());
                if (eVar != null) {
                    eVar.cancel();
                }
            }
        });
    }
}
