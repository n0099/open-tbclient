package d.g.b.a;

import android.content.Context;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class b implements d {
    public static Context sApplicationContext = null;
    public static int sBlockThreshold = 2000;
    public static b sInstance;

    public static b get() {
        b bVar = sInstance;
        if (bVar != null) {
            return bVar;
        }
        throw new RuntimeException("BlockCanaryContext null");
    }

    public static void init(Context context, b bVar, int i) {
        sApplicationContext = context;
        sInstance = bVar;
        sBlockThreshold = i;
    }

    public List<String> concernPackages() {
        return null;
    }

    public boolean deleteFilesInWhiteList() {
        return true;
    }

    public abstract boolean displayNotification();

    public boolean filterNonConcernStack() {
        return false;
    }

    @Override // d.g.b.a.d
    public void onBlock(Context context, d.g.b.a.j.a aVar) {
    }

    public int provideBlockThreshold() {
        return sBlockThreshold;
    }

    public Context provideContext() {
        return sApplicationContext;
    }

    public int provideDumpInterval() {
        return provideBlockThreshold();
    }

    public int provideMonitorDuration() {
        return -1;
    }

    public String provideNetworkType() {
        return "unknown";
    }

    public String providePath() {
        return "/blockcanary/";
    }

    public String provideQualifier() {
        return "unknown";
    }

    public String provideUid() {
        return "uid";
    }

    public List<String> provideWhiteList() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("org.chromium");
        return linkedList;
    }

    public boolean stopWhenDebugging() {
        return true;
    }

    public void upload(File file) {
        throw new UnsupportedOperationException();
    }

    public boolean zip(File[] fileArr, File file) {
        return false;
    }
}
