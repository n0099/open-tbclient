package d.a.l0.a.r0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class k {

    /* loaded from: classes3.dex */
    public static class a implements Comparator<File> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return Long.compare(file.lastModified(), file2.lastModified());
        }
    }

    public static void a() {
        File[] listFiles;
        String w = n.w(AppRuntime.getAppContext());
        if (TextUtils.isEmpty(w)) {
            return;
        }
        File file = new File(w);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    String str = file2.getAbsolutePath() + File.separator + "aigames/sandbox";
                    File file3 = new File(str);
                    if (file3.exists() && file3.isDirectory()) {
                        String str2 = w + File.separator + "swangame/anonymous/sandbox";
                        if (!file3.renameTo(new File(str2))) {
                            n.e(str, str2);
                            n.h(str);
                        }
                    }
                }
            }
        }
    }

    public static void b() {
        File[] d2 = d.a.l0.a.c1.b.m().d();
        if (d2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : d2) {
            String name = file.getName();
            if (name.startsWith("aigame_storage_") && !name.endsWith("_anonymous.xml")) {
                arrayList.add(file);
            }
        }
        Collections.sort(arrayList, new a());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            File file2 = (File) it.next();
            String absolutePath = file2.getAbsolutePath();
            int lastIndexOf = absolutePath.lastIndexOf("_");
            String str = absolutePath.substring(0, lastIndexOf) + "_anonymous.xml";
            if (!absolutePath.equals(str)) {
                File file3 = new File(str);
                if (file3.exists()) {
                    d.a.l0.t.d.K(file3);
                }
                if (!file2.renameTo(file3)) {
                    d.a.l0.t.d.f(file2, file3);
                    d.a.l0.t.d.K(file2);
                }
            }
        }
    }

    public static void c() {
        if (d.a.l0.a.k2.g.h.a().getBoolean("swan_game_data_migration", true)) {
            d.a.l0.a.k2.g.h.a().putBoolean("swan_game_data_migration", false);
            if (d.a.l0.a.b1.a.f44480a) {
                Log.d("DataMigrationUtils", "before migrate " + System.currentTimeMillis());
            }
            a();
            if (d.a.l0.a.b1.a.f44480a) {
                Log.d("DataMigrationUtils", "in migrate " + System.currentTimeMillis());
            }
            b();
            if (d.a.l0.a.b1.a.f44480a) {
                Log.d("DataMigrationUtils", "end migrate " + System.currentTimeMillis());
            }
        }
    }
}
