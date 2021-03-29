package d.b.h0.s.d;

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
    public static f f51286c;

    /* renamed from: a  reason: collision with root package name */
    public a f51287a = b();

    /* renamed from: b  reason: collision with root package name */
    public String f51288b;

    public static f c() {
        if (f51286c == null) {
            synchronized (f.class) {
                if (f51286c == null) {
                    f51286c = new f();
                }
            }
        }
        return f51286c;
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        a aVar = this.f51287a;
        if (aVar != null) {
            aVar.b(tbPageContext, viewGroup);
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
        a aVar = this.f51287a;
        if (aVar != null) {
            return aVar.f();
        }
        return 0;
    }

    public int e() {
        a aVar = this.f51287a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    public String f() {
        return this.f51288b;
    }

    public boolean g() {
        a aVar = this.f51287a;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    public void h(boolean z) {
        a aVar = this.f51287a;
        if (aVar != null) {
            aVar.g(z);
        }
    }

    public void i(int i, int i2) {
        a aVar = this.f51287a;
        if (aVar != null) {
            aVar.d(i, i2);
        }
    }

    public void j(String str) {
        this.f51288b = str;
    }

    public NavigationBarCoverTip k(Activity activity, ViewGroup viewGroup) {
        a aVar = this.f51287a;
        if (aVar != null) {
            return aVar.i(activity, viewGroup);
        }
        return null;
    }

    public Dialog l(TbPageContext tbPageContext, d.b.h0.b1.o.a.d.e eVar) {
        a aVar = this.f51287a;
        if (aVar != null) {
            return aVar.h(tbPageContext, eVar);
        }
        return null;
    }

    public void m() {
        a aVar = this.f51287a;
        if (aVar != null) {
            aVar.e();
        }
    }
}
