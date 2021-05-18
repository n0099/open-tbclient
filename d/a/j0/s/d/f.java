package d.a.j0.s.d;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static f f50516c;

    /* renamed from: a  reason: collision with root package name */
    public a f50517a = b();

    /* renamed from: b  reason: collision with root package name */
    public String f50518b;

    public static f c() {
        if (f50516c == null) {
            synchronized (f.class) {
                if (f50516c == null) {
                    f50516c = new f();
                }
            }
        }
        return f50516c;
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        a aVar = this.f50517a;
        if (aVar != null) {
            aVar.f(tbPageContext, viewGroup);
        }
    }

    public final a b() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public int d() {
        a aVar = this.f50517a;
        if (aVar != null) {
            return aVar.h();
        }
        return 0;
    }

    public int e() {
        a aVar = this.f50517a;
        if (aVar != null) {
            return aVar.b();
        }
        return 0;
    }

    public String f() {
        return this.f50518b;
    }

    public boolean g() {
        a aVar = this.f50517a;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    public void h(boolean z) {
        a aVar = this.f50517a;
        if (aVar != null) {
            aVar.i(z);
        }
    }

    public void i(int i2, int i3) {
        a aVar = this.f50517a;
        if (aVar != null) {
            aVar.g(i2, i3);
        }
    }

    public void j(String str) {
        this.f50518b = str;
    }

    public NavigationBarCoverTip k(Activity activity, ViewGroup viewGroup) {
        a aVar = this.f50517a;
        if (aVar != null) {
            return aVar.e(activity, viewGroup);
        }
        return null;
    }

    public Dialog l(TbPageContext tbPageContext, d.a.j0.b1.o.a.d.e eVar) {
        a aVar = this.f50517a;
        if (aVar != null) {
            return aVar.d(tbPageContext, eVar);
        }
        return null;
    }

    public void m() {
        a aVar = this.f50517a;
        if (aVar != null) {
            aVar.c();
        }
    }
}
