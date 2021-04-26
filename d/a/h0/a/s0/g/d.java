package d.a.h0.a.s0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes2.dex */
public class d implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f43921a;

    public d(@NonNull String str) {
        this.f43921a = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        d.a.h0.a.s0.g.h.b a2 = d.a.h0.a.w0.a.t().a(invoker, this.f43921a);
        d.a.h0.a.c0.c.g("【RtcRoomPluginFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline RtcRoom「Hash:" + a2.hashCode() + "」");
        return new b(a2);
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_rtc_room";
    }
}
