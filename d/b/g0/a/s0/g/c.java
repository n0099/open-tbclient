package d.b.g0.a.s0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes2.dex */
public class c implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f46224a;

    public c(@NonNull String str) {
        this.f46224a = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        d.b.g0.a.s0.g.h.a c2 = d.b.g0.a.w0.a.t().c(invoker, this.f46224a);
        d.b.g0.a.c0.c.g("【RtcItemPluginFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline RtcItem「Hash:" + c2.hashCode() + "」");
        return new a(c2);
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_rtc_item";
    }
}
