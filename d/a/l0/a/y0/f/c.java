package d.a.l0.a.y0.f;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes3.dex */
public class c implements ZeusPluginFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f49494a;

    public c(@NonNull String str) {
        this.f49494a = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        return new b(d.a.l0.a.c1.a.z().e(invoker, this.f49494a));
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "media_extractor";
    }
}
