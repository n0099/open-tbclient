package d.a.o0.a.f;

import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.tbadk.TbConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class j {

    /* loaded from: classes5.dex */
    public static class a extends c {
        @Override // d.a.o0.a.f.c
        public final void a() {
            if (f.a(com.baidu.ubs.analytics.d.a.f22526b)) {
                for (File file : j.a(com.baidu.ubs.analytics.d.a.f22526b)) {
                    if (d.a.o0.a.d.b.c(d.a.o0.a.d.b.a(file, "http://absample.baidu.com/appabapp/appapi/sdkerrorlog"), null)) {
                        f.b(file.getPath());
                    }
                }
            }
            if (f.a(com.baidu.ubs.analytics.d.a.f22527c)) {
                for (File file2 : j.a(com.baidu.ubs.analytics.d.a.f22527c)) {
                    if (!file2.getName().equals(d.a.o0.a.f.a.e()) && d.a.o0.a.d.b.c(d.a.o0.a.d.b.a(file2, "http://absample.baidu.com/appabapp/appapi/sdklog"), null)) {
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
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                String name = listFiles[i2].getName();
                if (name.endsWith(DocumentOpenUtil.TXT) || name.endsWith(TbConfig.TMP_LOG_DIR_NAME)) {
                    arrayList.add(listFiles[i2]);
                }
            }
        }
        return arrayList;
    }

    public static void b() {
        b.a(new a());
    }
}
