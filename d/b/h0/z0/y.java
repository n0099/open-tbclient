package d.b.h0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tieba.flutter.util.OpenFlutter;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: g  reason: collision with root package name */
    public static y f51750g;

    /* renamed from: a  reason: collision with root package name */
    public int f51751a;

    /* renamed from: b  reason: collision with root package name */
    public String f51752b;

    /* renamed from: c  reason: collision with root package name */
    public String f51753c;

    /* renamed from: d  reason: collision with root package name */
    public int f51754d;

    /* renamed from: e  reason: collision with root package name */
    public String f51755e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f51756f = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("from", String.valueOf(y.this.f51751a));
            hashMap.put("field_id", y.this.f51752b);
            hashMap.put("type", Integer.valueOf(y.this.f51754d));
            hashMap.put("type_name", y.this.f51755e);
            if (y.this.f51751a == 2) {
                hashMap.put("fid", y.this.f51753c);
            }
            hashMap.put("animated", Boolean.FALSE);
            hashMap.put(OpenFlutter.EXTRA_TRANSPARANT, Boolean.TRUE);
            hashMap.put("swipeback", Boolean.FALSE);
            if (PluginPackageManager.O().y("com.baidu.tieba.pluginFlutter")) {
                if (MessageManager.getInstance().findTask(2002015) == null) {
                    d.b.b.e.m.e.a().postDelayed(y.this.f51756f, 0L);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.b.i0.c3.h0.m(TbadkApplication.getInst().getApplicationContext(), "GodDialog", hashMap)));
                d.b.h0.r.d0.b.i().v("key_new_god_dialog_showed_time", System.currentTimeMillis());
            }
        }
    }

    public static synchronized y g() {
        y yVar;
        synchronized (y.class) {
            if (f51750g == null) {
                f51750g = new y();
            }
            yVar = f51750g;
        }
        return yVar;
    }

    public final boolean h(int i, NewGodData newGodData) {
        if (i != 5) {
            return (((((System.currentTimeMillis() - d.b.h0.r.d0.b.i().k("key_new_god_dialog_showed_time", 0L)) + 3000) > 259200000L ? 1 : (((System.currentTimeMillis() - d.b.h0.r.d0.b.i().k("key_new_god_dialog_showed_time", 0L)) + 3000) == 259200000L ? 0 : -1)) < 0) || newGodData == null || !newGodData.isNewGodInvited()) ? false : true;
        }
        return true;
    }

    public void i() {
        d.b.b.e.m.e.a().removeCallbacks(this.f51756f);
    }

    public void j(String str) {
        this.f51753c = str;
    }

    public void k(int i, NewGodData newGodData) {
        l(i, newGodData, true);
    }

    public void l(int i, NewGodData newGodData, boolean z) {
        if (h(i, newGodData)) {
            i();
            this.f51751a = i;
            this.f51752b = newGodData.getFieldId();
            this.f51754d = newGodData.getType();
            this.f51755e = newGodData.getTypeName();
            d.b.b.e.m.e.a().postDelayed(this.f51756f, z ? 3000L : 0L);
        }
    }
}
