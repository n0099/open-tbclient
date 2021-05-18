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
    public com.bytedance.sdk.openadsdk.video.a.a.a f30311a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f30312b = -2147483648L;

    /* renamed from: c  reason: collision with root package name */
    public Context f30313c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.video.b.a f30314d;

    public a(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        this.f30313c = context;
        this.f30314d = aVar;
    }

    private void a() {
        if (this.f30311a == null) {
            this.f30311a = new b(this.f30313c, this.f30314d);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        u.b("SdkMediaDataSource", "close: ", this.f30314d.a());
        com.bytedance.sdk.openadsdk.video.a.a.a aVar = this.f30311a;
        if (aVar != null) {
            aVar.a();
        }
        com.bytedance.sdk.openadsdk.video.a.b.a.f30324a.remove(this.f30314d.b());
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        a();
        if (this.f30312b == -2147483648L) {
            if (this.f30313c == null || TextUtils.isEmpty(this.f30314d.a())) {
                return -1L;
            }
            this.f30312b = this.f30311a.b();
            u.c("SdkMediaDataSource", "getSize: " + this.f30312b);
        }
        return this.f30312b;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i2, int i3) throws IOException {
        a();
        int a2 = this.f30311a.a(j, bArr, i2, i3);
        u.c("SdkMediaDataSource", "readAt: position = " + j + "  buffer.length =" + bArr.length + "  offset = " + i2 + " size =" + a2 + "  current = " + Thread.currentThread());
        return a2;
    }

    public static a a(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        if (com.bytedance.sdk.openadsdk.video.a.b.a.f30324a.containsKey(aVar.b())) {
            try {
                com.bytedance.sdk.openadsdk.video.a.b.a.f30324a.get(aVar.b()).close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        a aVar2 = new a(context, aVar);
        com.bytedance.sdk.openadsdk.video.a.b.a.f30324a.put(aVar.b(), aVar2);
        return aVar2;
    }
}
