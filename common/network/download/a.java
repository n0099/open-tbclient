package common.network.download;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import okhttp3.OkHttpClient;
/* loaded from: classes.dex */
public class a {
    private static a ntV;
    private OkHttpClient mOkHttpClient;
    private File ntW;
    private Map<String, e> ntX;
    private c ntY;
    private ExecutorService ntZ;

    public static a dHC() {
        return ntV;
    }

    public void a(final f fVar, final g gVar) {
        this.ntZ.submit(new Runnable() { // from class: common.network.download.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.ntX.containsKey(fVar.getName())) {
                    a.this.ntX.put(fVar.getName(), new e(fVar, a.this.ntW, a.this.ntZ, a.this.mOkHttpClient, a.this.ntY));
                }
                ((e) a.this.ntX.get(fVar.getName())).a(gVar);
            }
        });
    }

    public void a(final f fVar) {
        this.ntZ.submit(new Runnable() { // from class: common.network.download.a.2
            @Override // java.lang.Runnable
            public void run() {
                e eVar = (e) a.this.ntX.get(fVar.getName());
                if (eVar != null) {
                    eVar.cancel();
                }
            }
        });
    }
}
