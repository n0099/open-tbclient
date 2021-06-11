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
    public com.bytedance.sdk.openadsdk.video.a.a.a f30343a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f30344b = -2147483648L;

    /* renamed from: c  reason: collision with root package name */
    public Context f30345c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.video.b.a f30346d;

    public a(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        this.f30345c = context;
        this.f30346d = aVar;
    }

    private void a() {
        if (this.f30343a == null) {
            this.f30343a = new b(this.f30345c, this.f30346d);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        u.b("SdkMediaDataSource", "close: ", this.f30346d.a());
        com.bytedance.sdk.openadsdk.video.a.a.a aVar = this.f30343a;
        if (aVar != null) {
            aVar.a();
        }
        com.bytedance.sdk.openadsdk.video.a.b.a.f30356a.remove(this.f30346d.b());
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        a();
        if (this.f30344b == -2147483648L) {
            if (this.f30345c == null || TextUtils.isEmpty(this.f30346d.a())) {
                return -1L;
            }
            this.f30344b = this.f30343a.b();
            u.c("SdkMediaDataSource", "getSize: " + this.f30344b);
        }
        return this.f30344b;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i2, int i3) throws IOException {
        a();
        int a2 = this.f30343a.a(j, bArr, i2, i3);
        u.c("SdkMediaDataSource", "readAt: position = " + j + "  buffer.length =" + bArr.length + "  offset = " + i2 + " size =" + a2 + "  current = " + Thread.currentThread());
        return a2;
    }

    public static a a(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        if (com.bytedance.sdk.openadsdk.video.a.b.a.f30356a.containsKey(aVar.b())) {
            try {
                com.bytedance.sdk.openadsdk.video.a.b.a.f30356a.get(aVar.b()).close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        a aVar2 = new a(context, aVar);
        com.bytedance.sdk.openadsdk.video.a.b.a.f30356a.put(aVar.b(), aVar2);
        return aVar2;
    }
}
