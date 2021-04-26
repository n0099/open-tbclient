package com.bytedance.sdk.openadsdk.video.a;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.video.a.a.b;
import java.io.IOException;
@RequiresApi(api = 23)
/* loaded from: classes5.dex */
public class a extends MediaDataSource {

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.video.a.a.a f31066a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f31067b = -2147483648L;

    /* renamed from: c  reason: collision with root package name */
    public Context f31068c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.video.b.a f31069d;

    public a(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        this.f31068c = context;
        this.f31069d = aVar;
    }

    private void a() {
        if (this.f31066a == null) {
            this.f31066a = new b(this.f31068c, this.f31069d);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        u.b("SdkMediaDataSource", "close: ", this.f31069d.a());
        com.bytedance.sdk.openadsdk.video.a.a.a aVar = this.f31066a;
        if (aVar != null) {
            aVar.a();
        }
        com.bytedance.sdk.openadsdk.video.a.b.a.f31079a.remove(this.f31069d.b());
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        a();
        if (this.f31067b == -2147483648L) {
            if (this.f31068c == null || TextUtils.isEmpty(this.f31069d.a())) {
                return -1L;
            }
            this.f31067b = this.f31066a.b();
            u.c("SdkMediaDataSource", "getSize: " + this.f31067b);
        }
        return this.f31067b;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i2, int i3) throws IOException {
        a();
        int a2 = this.f31066a.a(j, bArr, i2, i3);
        u.c("SdkMediaDataSource", "readAt: position = " + j + "  buffer.length =" + bArr.length + "  offset = " + i2 + " size =" + a2 + "  current = " + Thread.currentThread());
        return a2;
    }

    public static a a(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        if (com.bytedance.sdk.openadsdk.video.a.b.a.f31079a.containsKey(aVar.b())) {
            try {
                com.bytedance.sdk.openadsdk.video.a.b.a.f31079a.get(aVar.b()).close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        a aVar2 = new a(context, aVar);
        com.bytedance.sdk.openadsdk.video.a.b.a.f31079a.put(aVar.b(), aVar2);
        return aVar2;
    }
}
