package d.a.j0.z0;

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
    public static y f51012g;

    /* renamed from: a  reason: collision with root package name */
    public int f51013a;

    /* renamed from: b  reason: collision with root package name */
    public String f51014b;

    /* renamed from: c  reason: collision with root package name */
    public String f51015c;

    /* renamed from: d  reason: collision with root package name */
    public int f51016d;

    /* renamed from: e  reason: collision with root package name */
    public String f51017e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f51018f = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("from", String.valueOf(y.this.f51013a));
            hashMap.put("field_id", y.this.f51014b);
            hashMap.put("type", Integer.valueOf(y.this.f51016d));
            hashMap.put("type_name", y.this.f51017e);
            if (y.this.f51013a == 2) {
                hashMap.put("fid", y.this.f51015c);
            }
            hashMap.put("animated", Boolean.FALSE);
            hashMap.put(OpenFlutter.EXTRA_TRANSPARANT, Boolean.TRUE);
            hashMap.put("swipeback", Boolean.FALSE);
            if (PluginPackageManager.O().y("com.baidu.tieba.pluginFlutter")) {
                if (MessageManager.getInstance().findTask(2002015) == null) {
                    d.a.c.e.m.e.a().postDelayed(y.this.f51018f, 0L);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.a.k0.d3.h0.m(TbadkApplication.getInst().getApplicationContext(), "GodDialog", hashMap)));
                d.a.j0.r.d0.b.j().w("key_new_god_dialog_showed_time", System.currentTimeMillis());
            }
        }
    }

    public static synchronized y g() {
        y yVar;
        synchronized (y.class) {
            if (f51012g == null) {
                f51012g = new y();
            }
            yVar = f51012g;
        }
        return yVar;
    }

    public final boolean h(int i2, NewGodData newGodData) {
        if (i2 != 5) {
            return (((((System.currentTimeMillis() - d.a.j0.r.d0.b.j().l("key_new_god_dialog_showed_time", 0L)) + 3000) > 259200000L ? 1 : (((System.currentTimeMillis() - d.a.j0.r.d0.b.j().l("key_new_god_dialog_showed_time", 0L)) + 3000) == 259200000L ? 0 : -1)) < 0) || newGodData == null || !newGodData.isNewGodInvited()) ? false : true;
        }
        return true;
    }

    public void i() {
        d.a.c.e.m.e.a().removeCallbacks(this.f51018f);
    }

    public void j(String str) {
        this.f51015c = str;
    }

    public void k(int i2, NewGodData newGodData) {
        l(i2, newGodData, true);
    }

    public void l(int i2, NewGodData newGodData, boolean z) {
        if (h(i2, newGodData)) {
            i();
            this.f51013a = i2;
            this.f51014b = newGodData.getFieldId();
            this.f51016d = newGodData.getType();
            this.f51017e = newGodData.getTypeName();
            d.a.c.e.m.e.a().postDelayed(this.f51018f, z ? 3000L : 0L);
        }
    }
}
