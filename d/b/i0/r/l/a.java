package d.b.i0.r.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f51371a;

    /* renamed from: d.b.i0.r.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1117a {
        void a(String str, int i, String str2);

        void b(String str);

        void c(AccountData accountData);
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f51372a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f51373b = null;
    }

    public static a b() {
        return f51371a;
    }

    public static void c() {
        CustomResponsedMessage runTask;
        if (f51371a != null || (runTask = MessageManager.getInstance().runTask(2001293, a.class)) == null || runTask.getData() == null) {
            return;
        }
        f51371a = (a) runTask.getData();
    }

    public abstract BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, InterfaceC1117a interfaceC1117a);

    public abstract b d(String str);

    public abstract void e();
}
