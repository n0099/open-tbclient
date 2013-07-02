package com.mofamulu.tieba.sign;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.tieba.R;
import com.mofamulu.tieba.ch.bg;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ap extends ab {
    protected List a;
    protected final bg c;
    protected final Context d;
    protected volatile boolean e;
    protected LinkedList f;
    private aq g;
    private ak h;

    public boolean d() {
        if (this.e) {
            return true;
        }
        return (this.g == null || this.a == null || this.a.isEmpty()) ? false : true;
    }

    @Override // com.mofamulu.tieba.sign.ab
    public void c() {
        super.c();
        if (d()) {
            a("system", "签到意外停止", "正在执行中的贴吧签到服务被系统意外中断，请进入应用中手工重新启动签到。");
        }
        if (this.a != null) {
            this.a.clear();
        }
        if (this.f != null) {
            this.f.clear();
        }
        if (this.g != null) {
            synchronized (this.g) {
                try {
                    this.g.notify();
                } catch (Throwable th) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        try {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ar arVar = (ar) it.next();
                if (arVar.g()) {
                    it.remove();
                    a(arVar.s(), "签到完成", String.valueOf(com.mofamulu.tieba.ch.ae.a(new Date(), "yyyy-MM-dd")) + arVar.b());
                    al t = arVar.t();
                    t.a(arVar.r());
                    t.b(al.c());
                    this.h.a(t);
                    Iterator it2 = this.f.iterator();
                    while (it2.hasNext()) {
                        ((am) it2.next()).b(arVar.t());
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    public ap(Context context, ak akVar, bg bgVar) {
        super("signer", 10);
        this.e = false;
        this.f = new LinkedList();
        this.d = context;
        this.h = akVar;
        this.c = bgVar;
    }

    @Override // com.mofamulu.tieba.sign.ab
    protected boolean a() {
        if (!d() && this.f.size() == 0) {
            SignService.c();
            return false;
        }
        return false;
    }

    public void a(boolean z) {
        List<al> b;
        if (!d()) {
            if (this.c.e(false) && this.c.x().a.optInt(bg.a(), 0) == 0) {
                com.mofamulu.tieba.ch.a.a = 63;
                com.mofamulu.tieba.ch.a.a();
                return;
            }
            try {
                this.e = true;
                if (z) {
                    b = this.h.a();
                } else {
                    b = this.h.b();
                }
                if (z) {
                    int i = 0;
                    for (al alVar : b) {
                        if (this.c.a(alVar.a, false)) {
                            i++;
                        }
                    }
                    for (al alVar2 : b) {
                        if (this.c.a(alVar2.a, false)) {
                            a(alVar2);
                        } else if (i > 0) {
                            a(alVar2);
                            i--;
                        }
                    }
                } else {
                    for (al alVar3 : b) {
                        a(alVar3);
                    }
                }
                Iterator it = this.f.iterator();
                while (it.hasNext()) {
                    ((am) it.next()).a();
                }
            } catch (Throwable th) {
                try {
                    Log.e("tbhp_ss", "failed to start sign service.", th);
                } finally {
                    this.e = false;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [298=4] */
    public void a(String str) {
        try {
            this.e = true;
            al b = this.h.b(str);
            if (b == null) {
                return;
            }
            if (a(b)) {
                Iterator it = this.f.iterator();
                while (it.hasNext()) {
                    ((am) it.next()).b(b);
                }
            }
        } catch (Throwable th) {
            try {
                Log.e("tbhp_ss", "failed to start sign service for user:" + str, th);
            } finally {
                this.e = false;
            }
        }
    }

    public void f() {
        if (this.a != null) {
            this.a.clear();
        }
        if (this.g != null) {
            synchronized (this.g) {
                try {
                    this.g.notify();
                } catch (Throwable th) {
                }
            }
        }
    }

    public boolean a(al alVar) {
        ar a;
        if (alVar == null) {
            return false;
        }
        try {
            if (alVar.l() == 1) {
                a = ar.a(this.c, alVar, alVar.d());
            } else {
                a = ar.a(this.c, alVar, alVar.d(), alVar.e(), alVar.f());
                a.b(alVar.h());
            }
            a.a(this.c.r());
            a.b(alVar.g());
            a.e();
            alVar.c(a.d());
            alVar.e(a.q());
            alVar.d("");
            alVar.a(0);
            alVar.a(true);
            if (this.a == null) {
                this.a = new LinkedList();
            }
            this.a.add(a);
            this.h.a(alVar);
            a(a.s(), "开始签到：" + a.s(), "签到中……");
            if (this.g == null) {
                this.g = new aq(this);
                this.g.start();
            }
            return true;
        } catch (IOException e) {
            Log.e("tbhp_ss", "failed to sign " + alVar.d(), e);
            return false;
        } catch (Throwable th) {
            alVar.d(th.getMessage());
            alVar.a(2);
            Log.e("tbhp_ss", "failed to sign " + alVar.d(), th);
            return false;
        }
    }

    protected void a(String str, String str2, String str3) {
        try {
            Intent intent = new Intent(this.d, AccountListActivity.class);
            intent.setFlags(268435456);
            PendingIntent activity = PendingIntent.getActivity(this.d, 0, intent, 268435456);
            Notification notification = new Notification(R.drawable.icon, this.d.getString(R.string.app_name), System.currentTimeMillis());
            notification.setLatestEventInfo(this.d, str2, str3, activity);
            ((NotificationManager) this.d.getSystemService("notification")).notify(Math.abs(str.hashCode()), notification);
        } catch (Throwable th) {
            Log.e("tbhp_ss", "failed to sendNotification", th);
        }
    }

    @Override // com.mofamulu.tieba.sign.ab
    protected int b() {
        return 60000;
    }

    public List g() {
        return this.a;
    }
}
