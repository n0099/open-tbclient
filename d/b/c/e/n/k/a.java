package d.b.c.e.n.k;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.adp.lib.util.BdLog;
import d.b.c.e.n.m.g;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    public static volatile a i;
    public static final Handler j = new HandlerC0577a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f42668a;

    /* renamed from: d  reason: collision with root package name */
    public Context f42671d;

    /* renamed from: e  reason: collision with root package name */
    public c f42672e;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42669b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f42670c = null;

    /* renamed from: f  reason: collision with root package name */
    public BdStatSwitchData f42673f = new BdStatSwitchData();

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.e.n.k.b f42674g = new d.b.c.e.n.k.b();

    /* renamed from: h  reason: collision with root package name */
    public b f42675h = null;

    /* renamed from: d.b.c.e.n.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class HandlerC0577a extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof BdUploadStatMsgData) {
                g.h().q(((BdUploadStatMsgData) obj).parentType);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes.dex */
    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Serializable serializableExtra;
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.baidu.adp.stats.background".equals(action)) {
                BdStatisticsManager.getInstance().save();
                if (a.this.f42668a) {
                    g.h().f();
                }
            } else if ("com.baidu.adp.stats.switch".equals(action)) {
                if (a.this.f42668a) {
                    return;
                }
                a.this.p();
                g.h().r();
            } else if (!"com.baidu.adp.stats.updatecmd".equals(action) || a.this.f42668a || (serializableExtra = intent.getSerializableExtra("switchsCmdBrdMsg")) == null || !(serializableExtra instanceof BdUploadStatMsgData)) {
            } else {
                BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                if (bdUploadStatMsgData.parentType == null && bdUploadStatMsgData.childType == null) {
                    return;
                }
                String str = TextUtils.isEmpty(bdUploadStatMsgData.childType) ? bdUploadStatMsgData.parentType : bdUploadStatMsgData.childType;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                a.this.f42673f.putTmpSwitchConfData(str, bdUploadStatMsgData);
                a.this.l(bdUploadStatMsgData);
            }
        }

        public /* synthetic */ c(a aVar, HandlerC0577a handlerC0577a) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public class d extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public BdStatSwitchData doInBackground(Object... objArr) {
            BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
            if (a.this.f42674g.a()) {
                bdStatSwitchData.parserJson(a.this.f42674g.f42678b);
            }
            a.this.f42669b = false;
            if (a.this.f42668a) {
                a aVar = a.this;
                if (aVar.t(aVar.f42674g.f42678b)) {
                    String w = a.this.w();
                    if (!TextUtils.isEmpty(w) && !w.equals(a.this.f42674g.f42678b)) {
                        a.this.f42669b = true;
                        bdStatSwitchData.parserJson(w);
                        a.this.f42674g.b(w);
                    }
                }
            }
            return bdStatSwitchData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            super.onPostExecute(bdStatSwitchData);
            if (bdStatSwitchData == null) {
                return;
            }
            a.this.f42673f = bdStatSwitchData;
            if (a.this.f42668a && a.this.f42669b && !BdBaseApplication.getInst().checkInterrupt()) {
                a.this.z();
                g.h().r();
            }
            b bVar = a.this.f42675h;
            if (bVar != null) {
                bVar.a();
            }
        }

        public /* synthetic */ d(a aVar, HandlerC0577a handlerC0577a) {
            this();
        }
    }

    public static a o() {
        if (i == null) {
            synchronized (a.class) {
                if (i == null) {
                    i = new a();
                }
            }
        }
        return i;
    }

    public boolean A(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        return this.f42673f.smallFlowUpload(d.b.c.e.n.h.a.g(str), str2);
    }

    public boolean k(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (this.f42673f.getTmpSwitchConfData(str) == null) {
            this.f42673f.putTmpSwitchConfData(str, bdUploadStatMsgData);
            y(bdUploadStatMsgData);
            l(bdUploadStatMsgData);
            return true;
        }
        long j2 = bdUploadStatMsgData.deadLineTime;
        if (0 == j2) {
            this.f42673f.rmTmpSwitchConfData(str);
            return false;
        } else if (0 < j2) {
            this.f42673f.putTmpSwitchConfData(str, bdUploadStatMsgData);
            y(bdUploadStatMsgData);
            l(bdUploadStatMsgData);
            return true;
        } else {
            return false;
        }
    }

    public final void l(BdUploadStatMsgData bdUploadStatMsgData) {
        long currentTimeMillis = bdUploadStatMsgData.deadLineTime - System.currentTimeMillis();
        if (currentTimeMillis < 0) {
            return;
        }
        long j2 = currentTimeMillis - 3000;
        if (j2 > 0) {
            currentTimeMillis = j2;
        }
        Message obtainMessage = j.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = bdUploadStatMsgData;
        j.removeMessages(1);
        j.sendMessageDelayed(obtainMessage, currentTimeMillis);
    }

    public int m(String str, int i2) {
        return TextUtils.isEmpty(str) ? i2 : this.f42673f.geUploadCycle(str, i2);
    }

    public ArrayList<String> n(String str) {
        return this.f42673f.getChiledTypes(str);
    }

    public void p() {
        d dVar = new d(this, null);
        dVar.setPriority(4);
        dVar.execute(new Object[0]);
    }

    public int q(String str, int i2) {
        return TextUtils.isEmpty(str) ? i2 : this.f42673f.getMaxAlertCount(str, i2);
    }

    public void r(boolean z, String str, Context context, b bVar) {
        this.f42668a = z;
        this.f42670c = str;
        this.f42671d = context;
        try {
            if (this.f42672e == null && context != null && !BdBaseApplication.getInst().checkInterrupt()) {
                this.f42672e = new c(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.stats.background");
                intentFilter.addAction("com.baidu.adp.stats.switch");
                intentFilter.addAction("com.baidu.adp.stats.updatecmd");
                intentFilter.addAction("com.baidu.adp.stats.uploadallfile");
                this.f42671d.registerReceiver(this.f42672e, intentFilter);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f42675h = bVar;
        p();
    }

    public boolean s(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f42673f.isExactWriteFile(d.b.c.e.n.h.a.g(str));
    }

    public final boolean t(String str) {
        return TextUtils.isEmpty(str) || System.currentTimeMillis() - this.f42674g.f42677a >= 86400000;
    }

    public boolean u(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.f42673f.isUpload(d.b.c.e.n.h.a.g(str), str2);
    }

    public boolean v(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.f42673f.isWrite(d.b.c.e.n.h.a.g(str), str2);
    }

    public final String w() {
        if (TextUtils.isEmpty(this.f42670c)) {
            return null;
        }
        try {
            d.b.c.e.j.a.g g2 = new d.b.c.e.j.b.a().g(this.f42670c, 3, -1, 30000, -1, null);
            if (g2 != null) {
                return new String(g2.f42541h, "utf-8");
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        return null;
    }

    public boolean x(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.f42673f.onlyWifiUpload(d.b.c.e.n.h.a.g(str), str2);
    }

    public final void y(BdUploadStatMsgData bdUploadStatMsgData) {
        if (this.f42668a) {
            Intent intent = new Intent("com.baidu.adp.stats.updatecmd");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.f42671d.sendBroadcast(intent);
        }
    }

    public final void z() {
        if (this.f42668a) {
            Intent intent = new Intent("com.baidu.adp.stats.switch");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.f42671d.sendBroadcast(intent);
        }
    }
}
