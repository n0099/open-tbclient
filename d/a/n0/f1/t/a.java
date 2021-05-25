package d.a.n0.f1.t;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import d.a.c.e.d.l;
import d.a.c.e.p.p;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.m0.z0.n;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, ChatSetting> f54739a = new HashMap<>();

    /* renamed from: d.a.n0.f1.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1328a extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f54740a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f54741b;

        public C1328a(String str, String str2) {
            this.f54740a = str;
            this.f54741b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.m0.z0.f0
        public Boolean doInBackground() {
            ChatSetting a2 = a.this.a(this.f54740a, this.f54741b);
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
        h0.c(new C1328a(str, str2), nVar);
    }

    public void e(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.f54739a) {
            this.f54739a.clear();
        }
        String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
        if (id == null || id.length() == 0) {
            return;
        }
        String str2 = id + "@";
        synchronized (this.f54739a) {
            l<String> b2 = b();
            List<l.b<String>> b3 = p.b(b2);
            if (b3 != null) {
                for (l.b<String> bVar : b3) {
                    String str3 = bVar.f38541a;
                    if (str3 != null && str3.startsWith(str2) && (str = b2.get(str3)) != null) {
                        this.f54739a.put(str3, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
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
