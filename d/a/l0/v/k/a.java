package d.a.l0.v.k;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.extractor.CyberExtractor;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.l0.a.k;
import d.a.l0.a.v2.q;
import d.a.l0.a.y0.d;
import d.a.l0.a.y0.f.a;
import java.util.Map;
/* loaded from: classes3.dex */
public class a implements d.a.l0.a.y0.f.a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f48575e = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public String f48576a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0911a f48577b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f48578c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f48579d = false;

    /* renamed from: d.a.l0.v.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1093a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48580e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f48581f;

        public RunnableC1093a(String str, Map map) {
            this.f48580e = str;
            this.f48581f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48579d) {
                if (a.f48575e) {
                    Log.d("MediaExtractorWidget", "media extractor already released");
                    return;
                }
                return;
            }
            a.this.f48578c.setDataSource(a.this.getContext(), Uri.parse(d.a.l0.a.y0.j.a.a(this.f48580e)), this.f48581f);
            Bundle metaData = a.this.f48578c.getMetaData();
            if (a.this.f48577b != null) {
                a.this.f48577b.a(metaData);
            }
        }
    }

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.f48576a = str;
    }

    @Override // d.a.l0.a.y0.d
    public void B(@NonNull d.a aVar) {
        this.f48578c = new CyberExtractor(true);
        aVar.a(true);
    }

    @Override // d.a.l0.a.y0.d
    @Nullable
    public String b() {
        return this.f48576a;
    }

    public Context getContext() {
        return d.a.l0.a.c1.a.b();
    }

    @Override // d.a.l0.a.y0.f.a
    public void k(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        q.i(new RunnableC1093a(str, map), "loadMetadata");
    }

    @Override // d.a.l0.a.y0.d
    @Nullable
    public String n0() {
        return null;
    }

    @Override // d.a.l0.a.y0.f.a
    public void release() {
        this.f48579d = true;
        CyberExtractor cyberExtractor = this.f48578c;
        if (cyberExtractor != null) {
            cyberExtractor.release();
        }
        this.f48578c = null;
        a.InterfaceC0911a interfaceC0911a = this.f48577b;
        if (interfaceC0911a != null) {
            interfaceC0911a.onRelease();
        }
        this.f48577b = null;
    }

    @Override // d.a.l0.a.y0.f.a
    public void x(a.InterfaceC0911a interfaceC0911a) {
        this.f48577b = interfaceC0911a;
    }
}
