package d.a.j0.e1.h;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public static i f53599c = null;

    /* renamed from: d  reason: collision with root package name */
    public static long f53600d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static int f53601e;

    /* renamed from: a  reason: collision with root package name */
    public b f53602a = new b(null);

    /* renamed from: b  reason: collision with root package name */
    public c f53603b = null;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    i.this.f53602a.sendMessageDelayed(i.this.f53602a.obtainMessage(1), StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
                    return;
                }
                i.this.f53602a.removeMessages(1);
                i.this.j();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            i.i().f53602a.removeMessages(1);
            i.i().h();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<String, Object, Boolean> {
        public c(i iVar) {
        }

        public /* synthetic */ c(i iVar, a aVar) {
            this(iVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            LinkedList<ImMessageCenterPojo> h2 = j.f().h();
            if (h2 != null && h2.size() != 0) {
                if (i.f53600d < 0) {
                    try {
                        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                        long unused = i.f53600d = statFs.getAvailableBlocks() * statFs.getBlockSize();
                        if (i.f53600d > 2147483648L) {
                            int unused2 = i.f53601e = 5000;
                        } else if (i.f53600d > 1073741824) {
                            int unused3 = i.f53601e = 3000;
                        } else {
                            int unused4 = i.f53601e = 1000;
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                }
                if (i.f53601e < 1000) {
                    int unused5 = i.f53601e = 1000;
                }
                try {
                    try {
                        h.e().i();
                        for (ImMessageCenterPojo imMessageCenterPojo : h2) {
                            if (isCancelled()) {
                                h.e().c();
                                return Boolean.FALSE;
                            } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                                d.a.j0.e1.h.c.h().n(imMessageCenterPojo.getGid(), i.f53601e);
                            } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                                m.t().q(imMessageCenterPojo.getGid(), i.f53601e);
                            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                                l.t().q(imMessageCenterPojo.getGid(), i.f53601e);
                            } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                                d.f().l(imMessageCenterPojo.getGid(), i.f53601e);
                            }
                        }
                    } catch (Exception e3) {
                        BdLog.e(e3.getMessage());
                    }
                    h.e().c();
                    return Boolean.TRUE;
                } finally {
                    h.e().c();
                }
            }
            return Boolean.FALSE;
        }
    }

    public i() {
        MessageManager.getInstance().registerListener(new a(2001011));
    }

    public static i i() {
        if (f53599c == null) {
            synchronized (i.class) {
                if (f53599c == null) {
                    f53599c = new i();
                }
            }
        }
        return f53599c;
    }

    public final void h() {
        c cVar = this.f53603b;
        if (cVar != null) {
            cVar.cancel();
            this.f53603b = null;
        }
        c cVar2 = new c(this, null);
        this.f53603b = cVar2;
        cVar2.setParallel(TiebaIMConfig.getParallel());
        this.f53603b.setPriority(4);
        this.f53603b.execute(new String[0]);
    }

    public final void j() {
        c cVar = this.f53603b;
        if (cVar != null) {
            cVar.cancel();
            this.f53603b = null;
        }
    }
}
