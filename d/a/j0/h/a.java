package d.a.j0.h;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: d.a.j0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1115a {
        void a(boolean z, boolean z2, String str);
    }

    public static a b(BaseActivity baseActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001279, a.class, baseActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public static a c(BaseFragmentActivity baseFragmentActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921318, a.class, baseFragmentActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public abstract void a();

    public abstract void d();

    public abstract boolean e();

    public abstract MarkData f();

    public abstract String g();

    public abstract void h(boolean z);

    public abstract void i(MarkData markData);

    public abstract void j(InterfaceC1115a interfaceC1115a);
}
