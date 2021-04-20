package d.b.h0.z0;

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
    public static y f52175g;

    /* renamed from: a  reason: collision with root package name */
    public int f52176a;

    /* renamed from: b  reason: collision with root package name */
    public String f52177b;

    /* renamed from: c  reason: collision with root package name */
    public String f52178c;

    /* renamed from: d  reason: collision with root package name */
    public int f52179d;

    /* renamed from: e  reason: collision with root package name */
    public String f52180e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f52181f = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("from", String.valueOf(y.this.f52176a));
            hashMap.put("field_id", y.this.f52177b);
            hashMap.put("type", Integer.valueOf(y.this.f52179d));
            hashMap.put("type_name", y.this.f52180e);
            if (y.this.f52176a == 2) {
                hashMap.put("fid", y.this.f52178c);
            }
            hashMap.put("animated", Boolean.FALSE);
            hashMap.put(OpenFlutter.EXTRA_TRANSPARANT, Boolean.TRUE);
            hashMap.put("swipeback", Boolean.FALSE);
            if (PluginPackageManager.O().y("com.baidu.tieba.pluginFlutter")) {
                if (MessageManager.getInstance().findTask(2002015) == null) {
                    d.b.c.e.m.e.a().postDelayed(y.this.f52181f, 0L);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.b.i0.d3.h0.m(TbadkApplication.getInst().getApplicationContext(), "GodDialog", hashMap)));
                d.b.h0.r.d0.b.j().w("key_new_god_dialog_showed_time", System.currentTimeMillis());
            }
        }
    }

    public static synchronized y g() {
        y yVar;
        synchronized (y.class) {
            if (f52175g == null) {
                f52175g = new y();
            }
            yVar = f52175g;
        }
        return yVar;
    }

    public final boolean h(int i, NewGodData newGodData) {
        if (i != 5) {
            return (((((System.currentTimeMillis() - d.b.h0.r.d0.b.j().l("key_new_god_dialog_showed_time", 0L)) + 3000) > 259200000L ? 1 : (((System.currentTimeMillis() - d.b.h0.r.d0.b.j().l("key_new_god_dialog_showed_time", 0L)) + 3000) == 259200000L ? 0 : -1)) < 0) || newGodData == null || !newGodData.isNewGodInvited()) ? false : true;
        }
        return true;
    }

    public void i() {
        d.b.c.e.m.e.a().removeCallbacks(this.f52181f);
    }

    public void j(String str) {
        this.f52178c = str;
    }

    public void k(int i, NewGodData newGodData) {
        l(i, newGodData, true);
    }

    public void l(int i, NewGodData newGodData, boolean z) {
        if (h(i, newGodData)) {
            i();
            this.f52176a = i;
            this.f52177b = newGodData.getFieldId();
            this.f52179d = newGodData.getType();
            this.f52180e = newGodData.getTypeName();
            d.b.c.e.m.e.a().postDelayed(this.f52181f, z ? 3000L : 0L);
        }
    }
}
