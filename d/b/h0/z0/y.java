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
    public static y f51751g;

    /* renamed from: a  reason: collision with root package name */
    public int f51752a;

    /* renamed from: b  reason: collision with root package name */
    public String f51753b;

    /* renamed from: c  reason: collision with root package name */
    public String f51754c;

    /* renamed from: d  reason: collision with root package name */
    public int f51755d;

    /* renamed from: e  reason: collision with root package name */
    public String f51756e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f51757f = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("from", String.valueOf(y.this.f51752a));
            hashMap.put("field_id", y.this.f51753b);
            hashMap.put("type", Integer.valueOf(y.this.f51755d));
            hashMap.put("type_name", y.this.f51756e);
            if (y.this.f51752a == 2) {
                hashMap.put("fid", y.this.f51754c);
            }
            hashMap.put("animated", Boolean.FALSE);
            hashMap.put(OpenFlutter.EXTRA_TRANSPARANT, Boolean.TRUE);
            hashMap.put("swipeback", Boolean.FALSE);
            if (PluginPackageManager.O().y("com.baidu.tieba.pluginFlutter")) {
                if (MessageManager.getInstance().findTask(2002015) == null) {
                    d.b.b.e.m.e.a().postDelayed(y.this.f51757f, 0L);
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
            if (f51751g == null) {
                f51751g = new y();
            }
            yVar = f51751g;
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
        d.b.b.e.m.e.a().removeCallbacks(this.f51757f);
    }

    public void j(String str) {
        this.f51754c = str;
    }

    public void k(int i, NewGodData newGodData) {
        l(i, newGodData, true);
    }

    public void l(int i, NewGodData newGodData, boolean z) {
        if (h(i, newGodData)) {
            i();
            this.f51752a = i;
            this.f51753b = newGodData.getFieldId();
            this.f51755d = newGodData.getType();
            this.f51756e = newGodData.getTypeName();
            d.b.b.e.m.e.a().postDelayed(this.f51757f, z ? 3000L : 0L);
        }
    }
}
