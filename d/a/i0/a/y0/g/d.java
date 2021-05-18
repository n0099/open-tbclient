package d.a.i0.a.y0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes.dex */
public class d implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f45647a;

    public d(@NonNull String str) {
        this.f45647a = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        d.a.i0.a.y0.g.h.b a2 = d.a.i0.a.c1.a.z().a(invoker, this.f45647a);
        d.a.i0.a.e0.d.g("【RtcRoomPluginFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline RtcRoom「Hash:" + a2.hashCode() + "」");
        return new b(a2);
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_rtc_room";
    }
}
