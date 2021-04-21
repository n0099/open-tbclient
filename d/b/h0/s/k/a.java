package d.b.h0.s.k;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.extractor.CyberExtractor;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.b.h0.a.i2.p;
import d.b.h0.a.k;
import d.b.h0.a.s0.d;
import d.b.h0.a.s0.f.a;
import java.util.Map;
/* loaded from: classes3.dex */
public class a implements d.b.h0.a.s0.f.a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f50134e = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public String f50135a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0816a f50136b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f50137c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f50138d = false;

    /* renamed from: d.b.h0.s.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1069a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50139e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f50140f;

        public RunnableC1069a(String str, Map map) {
            this.f50139e = str;
            this.f50140f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f50138d) {
                if (a.f50134e) {
                    Log.d("MediaExtractorWidget", "media extractor already released");
                    return;
                }
                return;
            }
            a.this.f50137c.setDataSource(a.this.getContext(), Uri.parse(d.b.h0.a.s0.j.a.a(this.f50139e)), this.f50140f);
            Bundle metaData = a.this.f50137c.getMetaData();
            if (a.this.f50136b != null) {
                a.this.f50136b.a(metaData);
            }
        }
    }

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.f50135a = str;
    }

    @Override // d.b.h0.a.s0.f.a
    public void L(a.InterfaceC0816a interfaceC0816a) {
        this.f50136b = interfaceC0816a;
    }

    @Override // d.b.h0.a.s0.d
    public void T(@NonNull d.a aVar) {
        this.f50137c = new CyberExtractor(true);
        aVar.a(true);
    }

    @Override // d.b.h0.a.s0.d
    @Nullable
    public String b() {
        return this.f50135a;
    }

    @Override // d.b.h0.a.s0.d
    @Nullable
    public String c0() {
        return null;
    }

    public Context getContext() {
        return d.b.h0.a.w0.a.c();
    }

    @Override // d.b.h0.a.s0.f.a
    public void q(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        p.j(new RunnableC1069a(str, map), "loadMetadata");
    }

    @Override // d.b.h0.a.s0.f.a
    public void release() {
        this.f50138d = true;
        CyberExtractor cyberExtractor = this.f50137c;
        if (cyberExtractor != null) {
            cyberExtractor.release();
        }
        this.f50137c = null;
        a.InterfaceC0816a interfaceC0816a = this.f50136b;
        if (interfaceC0816a != null) {
            interfaceC0816a.onRelease();
        }
        this.f50136b = null;
    }
}
