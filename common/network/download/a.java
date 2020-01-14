package common.network.download;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import okhttp3.OkHttpClient;
/* loaded from: classes.dex */
public class a {
    private static a nua;
    private OkHttpClient mOkHttpClient;
    private File nub;
    private Map<String, e> nuc;
    private c nud;
    private ExecutorService nue;

    public static a dHE() {
        return nua;
    }

    public void a(final f fVar, final g gVar) {
        this.nue.submit(new Runnable() { // from class: common.network.download.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.nuc.containsKey(fVar.getName())) {
                    a.this.nuc.put(fVar.getName(), new e(fVar, a.this.nub, a.this.nue, a.this.mOkHttpClient, a.this.nud));
                }
                ((e) a.this.nuc.get(fVar.getName())).a(gVar);
            }
        });
    }

    public void a(final f fVar) {
        this.nue.submit(new Runnable() { // from class: common.network.download.a.2
            @Override // java.lang.Runnable
            public void run() {
                e eVar = (e) a.this.nuc.get(fVar.getName());
                if (eVar != null) {
                    eVar.cancel();
                }
            }
        });
    }
}
