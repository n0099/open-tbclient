package d.a.l0.a.y0.k;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.l0.a.u.e.o.k;
import d.a.l0.a.v2.q;
/* loaded from: classes3.dex */
public class d implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f45882a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            d.a.l0.a.y0.k.g.a b2 = d.a.l0.a.c1.a.z().b(null, null);
            b2.q0();
            b2.Y();
            b2.D();
            k.e().s(b2);
            if (d.a.l0.a.k.f43199a) {
                Log.d("【InlineFactory】", "pre-create video cost time ：" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public d(@NonNull String str) {
        this.f45882a = str;
    }

    public static void a() {
        if (d.a.l0.a.c1.a.z() == null) {
            return;
        }
        d.a.l0.a.y0.k.f.b.d("4");
        k.e().c();
        q.j(new a(), "PreCreateVideo");
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        d.a.l0.a.y0.k.g.a b2;
        if (d.a.l0.a.c1.a.z() == null) {
            return null;
        }
        if (k.e().f()) {
            d.a.l0.a.e0.d.g("【InlineFactory】", "handleAppOnLaunch use cache inline video. ");
            b2 = k.e().d();
            k.e().r();
            b2.Q(invoker);
        } else {
            d.a.l0.a.e0.d.g("【InlineFactory】", "handleAppOnLaunch create cache inline video. ");
            b2 = d.a.l0.a.c1.a.z().b(invoker, this.f45882a);
            b2.K();
        }
        if (d.a.l0.a.k.f43199a) {
            Log.i("【InlineFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline video「Hash:" + b2.hashCode() + "」");
        }
        k.e().b(b2);
        return new b(b2);
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "inline_video";
    }
}
