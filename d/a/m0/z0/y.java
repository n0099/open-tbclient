package d.a.m0.z0;

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
    public static y f51085g;

    /* renamed from: a  reason: collision with root package name */
    public int f51086a;

    /* renamed from: b  reason: collision with root package name */
    public String f51087b;

    /* renamed from: c  reason: collision with root package name */
    public String f51088c;

    /* renamed from: d  reason: collision with root package name */
    public int f51089d;

    /* renamed from: e  reason: collision with root package name */
    public String f51090e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f51091f = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("from", String.valueOf(y.this.f51086a));
            hashMap.put("field_id", y.this.f51087b);
            hashMap.put("type", Integer.valueOf(y.this.f51089d));
            hashMap.put("type_name", y.this.f51090e);
            if (y.this.f51086a == 2) {
                hashMap.put("fid", y.this.f51088c);
            }
            hashMap.put("animated", Boolean.FALSE);
            hashMap.put(OpenFlutter.EXTRA_TRANSPARANT, Boolean.TRUE);
            hashMap.put("swipeback", Boolean.FALSE);
            if (PluginPackageManager.O().y("com.baidu.tieba.pluginFlutter")) {
                if (MessageManager.getInstance().findTask(2002015) == null) {
                    d.a.c.e.m.e.a().postDelayed(y.this.f51091f, 0L);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.a.n0.e3.h0.m(TbadkApplication.getInst().getApplicationContext(), "GodDialog", hashMap)));
                d.a.m0.r.d0.b.j().w("key_new_god_dialog_showed_time", System.currentTimeMillis());
            }
        }
    }

    public static synchronized y g() {
        y yVar;
        synchronized (y.class) {
            if (f51085g == null) {
                f51085g = new y();
            }
            yVar = f51085g;
        }
        return yVar;
    }

    public final boolean h(int i2, NewGodData newGodData) {
        if (i2 != 5) {
            return (((((System.currentTimeMillis() - d.a.m0.r.d0.b.j().l("key_new_god_dialog_showed_time", 0L)) + 3000) > 259200000L ? 1 : (((System.currentTimeMillis() - d.a.m0.r.d0.b.j().l("key_new_god_dialog_showed_time", 0L)) + 3000) == 259200000L ? 0 : -1)) < 0) || newGodData == null || !newGodData.isNewGodInvited()) ? false : true;
        }
        return true;
    }

    public void i() {
        d.a.c.e.m.e.a().removeCallbacks(this.f51091f);
    }

    public void j(String str) {
        this.f51088c = str;
    }

    public void k(int i2, NewGodData newGodData) {
        l(i2, newGodData, true);
    }

    public void l(int i2, NewGodData newGodData, boolean z) {
        if (h(i2, newGodData)) {
            i();
            this.f51086a = i2;
            this.f51087b = newGodData.getFieldId();
            this.f51089d = newGodData.getType();
            this.f51090e = newGodData.getTypeName();
            d.a.c.e.m.e.a().postDelayed(this.f51091f, z ? 3000L : 0L);
        }
    }
}
