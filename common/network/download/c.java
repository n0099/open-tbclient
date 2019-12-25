package common.network.download;

import java.util.List;
/* loaded from: classes.dex */
public class c {
    private List<b> mListeners;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(e eVar) {
        for (b bVar : this.mListeners) {
            bVar.a(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(e eVar) {
        for (b bVar : this.mListeners) {
            bVar.b(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(e eVar, Exception exc) {
        for (b bVar : this.mListeners) {
            bVar.a(eVar, exc);
        }
    }
}
