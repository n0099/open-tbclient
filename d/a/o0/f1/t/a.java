package d.a.o0.f1.t;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import d.a.c.e.d.l;
import d.a.c.e.p.p;
import d.a.n0.z0.f0;
import d.a.n0.z0.h0;
import d.a.n0.z0.n;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, ChatSetting> f58553a = new HashMap<>();

    /* renamed from: d.a.o0.f1.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1388a extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f58554a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f58555b;

        public C1388a(String str, String str2) {
            this.f58554a = str;
            this.f58555b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.n0.z0.f0
        public Boolean doInBackground() {
            ChatSetting a2 = a.this.a(this.f58554a, this.f58555b);
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
        h0.c(new C1388a(str, str2), nVar);
    }

    public void e(Class<? extends ChatSetting> cls) {
        String str;
        synchronized (this.f58553a) {
            this.f58553a.clear();
        }
        String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
        if (id == null || id.length() == 0) {
            return;
        }
        String str2 = id + "@";
        synchronized (this.f58553a) {
            l<String> b2 = b();
            List<l.b<String>> b3 = p.b(b2);
            if (b3 != null) {
                for (l.b<String> bVar : b3) {
                    String str3 = bVar.f42297a;
                    if (str3 != null && str3.startsWith(str2) && (str = b2.get(str3)) != null) {
                        this.f58553a.put(str3, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
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
