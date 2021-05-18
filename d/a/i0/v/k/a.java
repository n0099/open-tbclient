package d.a.i0.v.k;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.extractor.CyberExtractor;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.i0.a.k;
import d.a.i0.a.v2.q;
import d.a.i0.a.y0.d;
import d.a.i0.a.y0.f.a;
import java.util.Map;
/* loaded from: classes3.dex */
public class a implements d.a.i0.a.y0.f.a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f48399e = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public String f48400a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0900a f48401b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f48402c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f48403d = false;

    /* renamed from: d.a.i0.v.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1082a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48404e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f48405f;

        public RunnableC1082a(String str, Map map) {
            this.f48404e = str;
            this.f48405f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48403d) {
                if (a.f48399e) {
                    Log.d("MediaExtractorWidget", "media extractor already released");
                    return;
                }
                return;
            }
            a.this.f48402c.setDataSource(a.this.getContext(), Uri.parse(d.a.i0.a.y0.j.a.a(this.f48404e)), this.f48405f);
            Bundle metaData = a.this.f48402c.getMetaData();
            if (a.this.f48401b != null) {
                a.this.f48401b.a(metaData);
            }
        }
    }

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.f48400a = str;
    }

    @Override // d.a.i0.a.y0.d
    public void B(@NonNull d.a aVar) {
        this.f48402c = new CyberExtractor(true);
        aVar.a(true);
    }

    @Override // d.a.i0.a.y0.d
    @Nullable
    public String b() {
        return this.f48400a;
    }

    public Context getContext() {
        return d.a.i0.a.c1.a.b();
    }

    @Override // d.a.i0.a.y0.f.a
    public void k(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        q.i(new RunnableC1082a(str, map), "loadMetadata");
    }

    @Override // d.a.i0.a.y0.d
    @Nullable
    public String n0() {
        return null;
    }

    @Override // d.a.i0.a.y0.f.a
    public void release() {
        this.f48403d = true;
        CyberExtractor cyberExtractor = this.f48402c;
        if (cyberExtractor != null) {
            cyberExtractor.release();
        }
        this.f48402c = null;
        a.InterfaceC0900a interfaceC0900a = this.f48401b;
        if (interfaceC0900a != null) {
            interfaceC0900a.onRelease();
        }
        this.f48401b = null;
    }

    @Override // d.a.i0.a.y0.f.a
    public void x(a.InterfaceC0900a interfaceC0900a) {
        this.f48401b = interfaceC0900a;
    }
}
