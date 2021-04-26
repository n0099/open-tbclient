package d.a.h0.s.k;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.extractor.CyberExtractor;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.h0.a.i2.p;
import d.a.h0.a.k;
import d.a.h0.a.s0.d;
import d.a.h0.a.s0.f.a;
import java.util.Map;
/* loaded from: classes3.dex */
public class a implements d.a.h0.a.s0.f.a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47668e = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public String f47669a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0755a f47670b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f47671c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f47672d = false;

    /* renamed from: d.a.h0.s.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1008a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47673e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f47674f;

        public RunnableC1008a(String str, Map map) {
            this.f47673e = str;
            this.f47674f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f47672d) {
                if (a.f47668e) {
                    Log.d("MediaExtractorWidget", "media extractor already released");
                    return;
                }
                return;
            }
            a.this.f47671c.setDataSource(a.this.getContext(), Uri.parse(d.a.h0.a.s0.j.a.a(this.f47673e)), this.f47674f);
            Bundle metaData = a.this.f47671c.getMetaData();
            if (a.this.f47670b != null) {
                a.this.f47670b.a(metaData);
            }
        }
    }

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.f47669a = str;
    }

    @Override // d.a.h0.a.s0.d
    public void A(@NonNull d.a aVar) {
        this.f47671c = new CyberExtractor(true);
        aVar.a(true);
    }

    @Override // d.a.h0.a.s0.d
    @Nullable
    public String a() {
        return this.f47669a;
    }

    @Override // d.a.h0.a.s0.d
    @Nullable
    public String e0() {
        return null;
    }

    public Context getContext() {
        return d.a.h0.a.w0.a.c();
    }

    @Override // d.a.h0.a.s0.f.a
    public void j(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        p.j(new RunnableC1008a(str, map), "loadMetadata");
    }

    @Override // d.a.h0.a.s0.f.a
    public void release() {
        this.f47672d = true;
        CyberExtractor cyberExtractor = this.f47671c;
        if (cyberExtractor != null) {
            cyberExtractor.release();
        }
        this.f47671c = null;
        a.InterfaceC0755a interfaceC0755a = this.f47670b;
        if (interfaceC0755a != null) {
            interfaceC0755a.onRelease();
        }
        this.f47670b = null;
    }

    @Override // d.a.h0.a.s0.f.a
    public void w(a.InterfaceC0755a interfaceC0755a) {
        this.f47670b = interfaceC0755a;
    }
}
