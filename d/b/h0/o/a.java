package d.b.h0.o;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ChunkUploadDatabaseService;
import d.b.h0.r.d0.b;
import java.io.File;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static long f50371a = 604800000;

    /* renamed from: d.b.h0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1069a extends CustomMessageListener {

        /* renamed from: d.b.h0.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1070a extends Thread {
            public C1070a(C1069a c1069a) {
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

        public C1069a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            long k = b.i().k("key_clear_resource", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (k == 0) {
                b.i().v("key_clear_resource", currentTimeMillis);
                k = currentTimeMillis;
            }
            if (currentTimeMillis - k > a.f50371a) {
                new C1070a(this).start();
                b.i().v("key_clear_resource", currentTimeMillis);
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
        MessageManager.getInstance().registerListener(new C1069a(2005016));
    }
}
