package d.b.g0.s.k;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.extractor.CyberExtractor;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
import d.b.g0.a.s0.d;
import d.b.g0.a.s0.f.a;
import java.util.Map;
/* loaded from: classes3.dex */
public class a implements d.b.g0.a.s0.f.a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f49413e = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public String f49414a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0784a f49415b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f49416c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f49417d = false;

    /* renamed from: d.b.g0.s.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1037a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49418e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f49419f;

        public RunnableC1037a(String str, Map map) {
            this.f49418e = str;
            this.f49419f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f49417d) {
                if (a.f49413e) {
                    Log.d("MediaExtractorWidget", "media extractor already released");
                    return;
                }
                return;
            }
            a.this.f49416c.setDataSource(a.this.getContext(), Uri.parse(d.b.g0.a.s0.j.a.a(this.f49418e)), this.f49419f);
            Bundle metaData = a.this.f49416c.getMetaData();
            if (a.this.f49415b != null) {
                a.this.f49415b.a(metaData);
            }
        }
    }

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.f49414a = str;
    }

    @Override // d.b.g0.a.s0.f.a
    public void L(a.InterfaceC0784a interfaceC0784a) {
        this.f49415b = interfaceC0784a;
    }

    @Override // d.b.g0.a.s0.d
    public void T(@NonNull d.a aVar) {
        this.f49416c = new CyberExtractor(true);
        aVar.a(true);
    }

    @Override // d.b.g0.a.s0.d
    @Nullable
    public String b() {
        return this.f49414a;
    }

    @Override // d.b.g0.a.s0.d
    @Nullable
    public String c0() {
        return null;
    }

    public Context getContext() {
        return d.b.g0.a.w0.a.c();
    }

    @Override // d.b.g0.a.s0.f.a
    public void q(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        p.j(new RunnableC1037a(str, map), "loadMetadata");
    }

    @Override // d.b.g0.a.s0.f.a
    public void release() {
        this.f49417d = true;
        CyberExtractor cyberExtractor = this.f49416c;
        if (cyberExtractor != null) {
            cyberExtractor.release();
        }
        this.f49416c = null;
        a.InterfaceC0784a interfaceC0784a = this.f49415b;
        if (interfaceC0784a != null) {
            interfaceC0784a.onRelease();
        }
        this.f49415b = null;
    }
}
