package d.a.m0.a.y0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes3.dex */
public class c implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f49604a;

    public c(@NonNull String str) {
        this.f49604a = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        d.a.m0.a.y0.g.h.a d2 = d.a.m0.a.c1.a.z().d(invoker, this.f49604a);
        d.a.m0.a.e0.d.g("【RtcItemPluginFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline RtcItem「Hash:" + d2.hashCode() + "」");
        return new a(d2);
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_rtc_item";
    }
}
