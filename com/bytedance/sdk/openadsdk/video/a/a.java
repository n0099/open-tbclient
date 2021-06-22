package com.bytedance.sdk.openadsdk.video.a;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.video.a.a.b;
import java.io.IOException;
@RequiresApi(api = 23)
/* loaded from: classes6.dex */
public class a extends MediaDataSource {

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.video.a.a.a f30425a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f30426b = -2147483648L;

    /* renamed from: c  reason: collision with root package name */
    public Context f30427c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.video.b.a f30428d;

    public a(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        this.f30427c = context;
        this.f30428d = aVar;
    }

    private void a() {
        if (this.f30425a == null) {
            this.f30425a = new b(this.f30427c, this.f30428d);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        u.b("SdkMediaDataSource", "close: ", this.f30428d.a());
        com.bytedance.sdk.openadsdk.video.a.a.a aVar = this.f30425a;
        if (aVar != null) {
            aVar.a();
        }
        com.bytedance.sdk.openadsdk.video.a.b.a.f30438a.remove(this.f30428d.b());
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        a();
        if (this.f30426b == -2147483648L) {
            if (this.f30427c == null || TextUtils.isEmpty(this.f30428d.a())) {
                return -1L;
            }
            this.f30426b = this.f30425a.b();
            u.c("SdkMediaDataSource", "getSize: " + this.f30426b);
        }
        return this.f30426b;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i2, int i3) throws IOException {
        a();
        int a2 = this.f30425a.a(j, bArr, i2, i3);
        u.c("SdkMediaDataSource", "readAt: position = " + j + "  buffer.length =" + bArr.length + "  offset = " + i2 + " size =" + a2 + "  current = " + Thread.currentThread());
        return a2;
    }

    public static a a(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        if (com.bytedance.sdk.openadsdk.video.a.b.a.f30438a.containsKey(aVar.b())) {
            try {
                com.bytedance.sdk.openadsdk.video.a.b.a.f30438a.get(aVar.b()).close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        a aVar2 = new a(context, aVar);
        com.bytedance.sdk.openadsdk.video.a.b.a.f30438a.put(aVar.b(), aVar2);
        return aVar2;
    }
}
