package d.a.n0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: g  reason: collision with root package name */
    public static y f54870g;

    /* renamed from: a  reason: collision with root package name */
    public int f54871a;

    /* renamed from: b  reason: collision with root package name */
    public String f54872b;

    /* renamed from: c  reason: collision with root package name */
    public String f54873c;

    /* renamed from: d  reason: collision with root package name */
    public int f54874d;

    /* renamed from: e  reason: collision with root package name */
    public String f54875e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f54876f = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("from", String.valueOf(y.this.f54871a));
            hashMap.put("field_id", y.this.f54872b);
            hashMap.put("type", Integer.valueOf(y.this.f54874d));
            hashMap.put("type_name", y.this.f54875e);
            if (y.this.f54871a == 2) {
                hashMap.put("fid", y.this.f54873c);
            }
            hashMap.put("animated", Boolean.FALSE);
            hashMap.put(OpenFlutter.EXTRA_TRANSPARANT, Boolean.TRUE);
            hashMap.put("swipeback", Boolean.FALSE);
            if (PluginPackageManager.O().y("com.baidu.tieba.pluginFlutter")) {
                if (MessageManager.getInstance().findTask(2002015) == null) {
                    d.a.c.e.m.e.a().postDelayed(y.this.f54876f, 0L);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.a.o0.e3.h0.m(TbadkApplication.getInst().getApplicationContext(), "GodDialog", hashMap)));
                d.a.n0.r.d0.b.j().w("key_new_god_dialog_showed_time", System.currentTimeMillis());
            }
        }
    }

    public static synchronized y g() {
        y yVar;
        synchronized (y.class) {
            if (f54870g == null) {
                f54870g = new y();
            }
            yVar = f54870g;
        }
        return yVar;
    }

    public final boolean h(int i2, NewGodData newGodData) {
        if (i2 != 5) {
            return (((((System.currentTimeMillis() - d.a.n0.r.d0.b.j().l("key_new_god_dialog_showed_time", 0L)) + 3000) > 259200000L ? 1 : (((System.currentTimeMillis() - d.a.n0.r.d0.b.j().l("key_new_god_dialog_showed_time", 0L)) + 3000) == 259200000L ? 0 : -1)) < 0) || newGodData == null || !newGodData.isNewGodInvited()) ? false : true;
        }
        return true;
    }

    public void i() {
        d.a.c.e.m.e.a().removeCallbacks(this.f54876f);
    }

    public void j(String str) {
        this.f54873c = str;
    }

    public void k(int i2, NewGodData newGodData) {
        l(i2, newGodData, true);
    }

    public void l(int i2, NewGodData newGodData, boolean z) {
        if (h(i2, newGodData)) {
            i();
            this.f54871a = i2;
            this.f54872b = newGodData.getFieldId();
            this.f54874d = newGodData.getType();
            this.f54875e = newGodData.getTypeName();
            d.a.c.e.m.e.a().postDelayed(this.f54876f, z ? 3000L : 0L);
        }
    }
}
