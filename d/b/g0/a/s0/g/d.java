package d.b.g0.a.s0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes2.dex */
public class d implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f46225a;

    public d(@NonNull String str) {
        this.f46225a = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        d.b.g0.a.s0.g.h.b a2 = d.b.g0.a.w0.a.t().a(invoker, this.f46225a);
        d.b.g0.a.c0.c.g("【RtcRoomPluginFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline RtcRoom「Hash:" + a2.hashCode() + "」");
        return new b(a2);
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_rtc_room";
    }
}
