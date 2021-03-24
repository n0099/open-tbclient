package d.b.m0.a.f;

import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.tbadk.TbConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class j {

    /* loaded from: classes5.dex */
    public static class a extends c {
        @Override // d.b.m0.a.f.c
        public final void a() {
            if (f.a(com.baidu.ubs.analytics.d.a.f22885b)) {
                for (File file : j.a(com.baidu.ubs.analytics.d.a.f22885b)) {
                    if (d.b.m0.a.d.b.c(d.b.m0.a.d.b.a(file, "http://absample.baidu.com/appabapp/appapi/sdkerrorlog"), null)) {
                        f.b(file.getPath());
                    }
                }
            }
            if (f.a(com.baidu.ubs.analytics.d.a.f22886c)) {
                for (File file2 : j.a(com.baidu.ubs.analytics.d.a.f22886c)) {
                    if (!file2.getName().equals(d.b.m0.a.f.a.e()) && d.b.m0.a.d.b.c(d.b.m0.a.d.b.a(file2, "http://absample.baidu.com/appabapp/appapi/sdklog"), null)) {
                        f.b(file2.getPath());
                    }
                }
            }
        }
    }

    public static /* synthetic */ List a(String str) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                String name = listFiles[i].getName();
                if (name.endsWith(DocumentOpenUtil.TXT) || name.endsWith(TbConfig.TMP_LOG_DIR_NAME)) {
                    arrayList.add(listFiles[i]);
                }
            }
        }
        return arrayList;
    }

    public static void b() {
        b.a(new a());
    }
}
