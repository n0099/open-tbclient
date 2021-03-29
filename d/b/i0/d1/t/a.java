package d.b.i0.d1.t;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import d.b.b.e.d.l;
import d.b.b.e.p.p;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import d.b.h0.z0.n;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, ChatSetting> f54031a = new HashMap<>();

    /* renamed from: d.b.i0.d1.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1213a extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f54032a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f54033b;

        public C1213a(String str, String str2) {
            this.f54032a = str;
            this.f54033b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.h0.z0.f0
        public Boolean doInBackground() {
            ChatSetting a2 = a.this.a(this.f54032a, this.f54033b);
            if (a2 == null) {
                return Boolean.FALSE;
            }
            return Boolean.valueOf(a2.isAcceptNotify());
        }
    }

    public abstract ChatSetting a(String str, String str2);

    public abstract l<String> b();

    public boolean c(String str, String str2) {
        ChatSetting a2 = a(str, str2);
        if (a2 == null) {
            return false;
        }
        return a2.isAcceptNotify();
    }

    public void d(String str, String str2, n<Boolean> nVar) {
        h0.c(new C1213a(str, str2), nVar);
    }

    public void e(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.f54031a) {
            this.f54031a.clear();
        }
        String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
        if (id == null || id.length() == 0) {
            return;
        }
        String str2 = id + "@";
        synchronized (this.f54031a) {
            l<String> b2 = b();
            List<l.b<String>> b3 = p.b(b2);
            if (b3 != null) {
                for (l.b<String> bVar : b3) {
                    String str3 = bVar.f41701a;
                    if (str3 != null && str3.startsWith(str2) && (str = b2.get(str3)) != null) {
                        this.f54031a.put(str3, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                    }
                }
            }
        }
    }

    public void f(String str, String str2, boolean z) {
        ChatSetting a2 = a(str, str2);
        if (a2 == null) {
            return;
        }
        a2.setAcceptNotify(z);
        h(a2);
    }

    public void g(String str, String str2, boolean z, n<Void> nVar) {
        ChatSetting a2 = a(str, str2);
        if (a2 == null) {
            return;
        }
        a2.setAcceptNotify(z);
        i(a2, nVar);
    }

    public abstract void h(ChatSetting chatSetting);

    public abstract void i(ChatSetting chatSetting, n<Void> nVar);
}
