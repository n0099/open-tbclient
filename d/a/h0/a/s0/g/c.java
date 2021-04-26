package d.a.h0.a.s0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes2.dex */
public class c implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f43920a;

    public c(@NonNull String str) {
        this.f43920a = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        d.a.h0.a.s0.g.h.a d2 = d.a.h0.a.w0.a.t().d(invoker, this.f43920a);
        d.a.h0.a.c0.c.g("【RtcItemPluginFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline RtcItem「Hash:" + d2.hashCode() + "」");
        return new a(d2);
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_rtc_item";
    }
}
