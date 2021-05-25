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
    public com.bytedance.sdk.openadsdk.video.a.a.a f30240a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f30241b = -2147483648L;

    /* renamed from: c  reason: collision with root package name */
    public Context f30242c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.video.b.a f30243d;

    public a(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        this.f30242c = context;
        this.f30243d = aVar;
    }

    private void a() {
        if (this.f30240a == null) {
            this.f30240a = new b(this.f30242c, this.f30243d);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        u.b("SdkMediaDataSource", "close: ", this.f30243d.a());
        com.bytedance.sdk.openadsdk.video.a.a.a aVar = this.f30240a;
        if (aVar != null) {
            aVar.a();
        }
        com.bytedance.sdk.openadsdk.video.a.b.a.f30253a.remove(this.f30243d.b());
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        a();
        if (this.f30241b == -2147483648L) {
            if (this.f30242c == null || TextUtils.isEmpty(this.f30243d.a())) {
                return -1L;
            }
            this.f30241b = this.f30240a.b();
            u.c("SdkMediaDataSource", "getSize: " + this.f30241b);
        }
        return this.f30241b;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i2, int i3) throws IOException {
        a();
        int a2 = this.f30240a.a(j, bArr, i2, i3);
        u.c("SdkMediaDataSource", "readAt: position = " + j + "  buffer.length =" + bArr.length + "  offset = " + i2 + " size =" + a2 + "  current = " + Thread.currentThread());
        return a2;
    }

    public static a a(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        if (com.bytedance.sdk.openadsdk.video.a.b.a.f30253a.containsKey(aVar.b())) {
            try {
                com.bytedance.sdk.openadsdk.video.a.b.a.f30253a.get(aVar.b()).close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        a aVar2 = new a(context, aVar);
        com.bytedance.sdk.openadsdk.video.a.b.a.f30253a.put(aVar.b(), aVar2);
        return aVar2;
    }
}
