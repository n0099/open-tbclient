package d.a.m0.i;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static WeakReference<TbPageContext<?>> f53097a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f53098b = false;

    /* loaded from: classes3.dex */
    public interface a {
    }

    public b() {
        new ArrayList(5);
    }

    public static b a(BaseFragmentActivity baseFragmentActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2004505, b.class, baseFragmentActivity);
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (b) runTask.getData();
    }

    public boolean b() {
        return f53098b;
    }

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g(int i2);

    public void h() {
        WeakReference<TbPageContext<?>> weakReference = f53097a;
        if (weakReference != null) {
            weakReference.get();
            f53097a.clear();
            f53097a = null;
        }
    }

    public abstract void i();

    public void j(TbPageContext<?> tbPageContext) {
        WeakReference<TbPageContext<?>> weakReference = f53097a;
        if (weakReference == null) {
            f53097a = new WeakReference<>(tbPageContext);
            return;
        }
        weakReference.clear();
        f53097a = null;
        f53097a = new WeakReference<>(tbPageContext);
    }

    public abstract void k(a aVar);

    public void l(boolean z) {
    }

    public abstract void m();
}
