package d.b.i0.o;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ChunkUploadDatabaseService;
import d.b.i0.r.d0.b;
import java.io.File;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static long f51115a = 604800000;

    /* renamed from: d.b.i0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1105a extends CustomMessageListener {

        /* renamed from: d.b.i0.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1106a extends Thread {
            public C1106a(C1105a c1105a) {
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    ChunkUploadDatabaseService.delOverdueChunkUploadData();
                    a.c(TbadkCoreApplication.getInst().getCacheDir());
                } catch (Exception unused) {
                }
            }
        }

        public C1105a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            long l = b.j().l("key_clear_resource", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (l == 0) {
                b.j().w("key_clear_resource", currentTimeMillis);
                l = currentTimeMillis;
            }
            if (currentTimeMillis - l > a.f51115a) {
                new C1106a(this).start();
                b.j().w("key_clear_resource", currentTimeMillis);
            }
        }
    }

    public static void c(File file) {
        if (file == null) {
            return;
        }
        try {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (int i = 0; i < listFiles.length; i++) {
                        if (listFiles[i].isDirectory()) {
                            c(listFiles[i]);
                        } else {
                            listFiles[i].delete();
                        }
                    }
                    return;
                }
                return;
            }
            file.delete();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void d() {
        MessageManager.getInstance().registerListener(new C1105a(2005016));
    }
}
