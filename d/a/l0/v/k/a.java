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
    public static final boolean f52249e = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public String f52250a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0967a f52251b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f52252c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f52253d = false;

    /* renamed from: d.a.l0.v.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1149a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f52254e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f52255f;

        public RunnableC1149a(String str, Map map) {
            this.f52254e = str;
            this.f52255f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f52253d) {
                if (a.f52249e) {
                    Log.d("MediaExtractorWidget", "media extractor already released");
                    return;
                }
                return;
            }
            a.this.f52252c.setDataSource(a.this.getContext(), Uri.parse(d.a.l0.a.y0.j.a.a(this.f52254e)), this.f52255f);
            Bundle metaData = a.this.f52252c.getMetaData();
            if (a.this.f52251b != null) {
                a.this.f52251b.a(metaData);
            }
        }
    }

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.f52250a = str;
    }

    @Override // d.a.l0.a.y0.d
    public void A(@NonNull d.a aVar) {
        this.f52252c = new CyberExtractor(true);
        aVar.a(true);
    }

    @Override // d.a.l0.a.y0.d
    @Nullable
    public String b() {
        return this.f52250a;
    }

    public Context getContext() {
        return d.a.l0.a.c1.a.b();
    }

    @Override // d.a.l0.a.y0.f.a
    public void j(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        q.i(new RunnableC1149a(str, map), "loadMetadata");
    }

    @Override // d.a.l0.a.y0.d
    @Nullable
    public String k0() {
        return null;
    }

    @Override // d.a.l0.a.y0.f.a
    public void release() {
        this.f52253d = true;
        CyberExtractor cyberExtractor = this.f52252c;
        if (cyberExtractor != null) {
            cyberExtractor.release();
        }
        this.f52252c = null;
        a.InterfaceC0967a interfaceC0967a = this.f52251b;
        if (interfaceC0967a != null) {
            interfaceC0967a.onRelease();
        }
        this.f52251b = null;
    }

    @Override // d.a.l0.a.y0.f.a
    public void w(a.InterfaceC0967a interfaceC0967a) {
        this.f52251b = interfaceC0967a;
    }
}
