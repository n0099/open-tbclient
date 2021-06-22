package d.a.m0.v.k;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.extractor.CyberExtractor;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.m0.a.k;
import d.a.m0.a.v2.q;
import d.a.m0.a.y0.d;
import d.a.m0.a.y0.f.a;
import java.util.Map;
/* loaded from: classes3.dex */
public class a implements d.a.m0.a.y0.f.a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f52357e = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public String f52358a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0970a f52359b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f52360c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f52361d = false;

    /* renamed from: d.a.m0.v.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1152a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f52362e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f52363f;

        public RunnableC1152a(String str, Map map) {
            this.f52362e = str;
            this.f52363f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f52361d) {
                if (a.f52357e) {
                    Log.d("MediaExtractorWidget", "media extractor already released");
                    return;
                }
                return;
            }
            a.this.f52360c.setDataSource(a.this.getContext(), Uri.parse(d.a.m0.a.y0.j.a.a(this.f52362e)), this.f52363f);
            Bundle metaData = a.this.f52360c.getMetaData();
            if (a.this.f52359b != null) {
                a.this.f52359b.a(metaData);
            }
        }
    }

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.f52358a = str;
    }

    @Override // d.a.m0.a.y0.d
    public void A(@NonNull d.a aVar) {
        this.f52360c = new CyberExtractor(true);
        aVar.a(true);
    }

    @Override // d.a.m0.a.y0.d
    @Nullable
    public String b() {
        return this.f52358a;
    }

    public Context getContext() {
        return d.a.m0.a.c1.a.b();
    }

    @Override // d.a.m0.a.y0.f.a
    public void j(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        q.i(new RunnableC1152a(str, map), "loadMetadata");
    }

    @Override // d.a.m0.a.y0.d
    @Nullable
    public String k0() {
        return null;
    }

    @Override // d.a.m0.a.y0.f.a
    public void release() {
        this.f52361d = true;
        CyberExtractor cyberExtractor = this.f52360c;
        if (cyberExtractor != null) {
            cyberExtractor.release();
        }
        this.f52360c = null;
        a.InterfaceC0970a interfaceC0970a = this.f52359b;
        if (interfaceC0970a != null) {
            interfaceC0970a.onRelease();
        }
        this.f52359b = null;
    }

    @Override // d.a.m0.a.y0.f.a
    public void w(a.InterfaceC0970a interfaceC0970a) {
        this.f52359b = interfaceC0970a;
    }
}
