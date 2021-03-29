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
    public com.bytedance.sdk.openadsdk.video.a.a.a f30456a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f30457b = -2147483648L;

    /* renamed from: c  reason: collision with root package name */
    public Context f30458c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.video.b.a f30459d;

    public a(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        this.f30458c = context;
        this.f30459d = aVar;
    }

    private void a() {
        if (this.f30456a == null) {
            this.f30456a = new b(this.f30458c, this.f30459d);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        u.b("SdkMediaDataSource", "close: ", this.f30459d.a());
        com.bytedance.sdk.openadsdk.video.a.a.a aVar = this.f30456a;
        if (aVar != null) {
            aVar.a();
        }
        com.bytedance.sdk.openadsdk.video.a.b.a.f30469a.remove(this.f30459d.b());
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        a();
        if (this.f30457b == -2147483648L) {
            if (this.f30458c == null || TextUtils.isEmpty(this.f30459d.a())) {
                return -1L;
            }
            this.f30457b = this.f30456a.b();
            u.c("SdkMediaDataSource", "getSize: " + this.f30457b);
        }
        return this.f30457b;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        a();
        int a2 = this.f30456a.a(j, bArr, i, i2);
        u.c("SdkMediaDataSource", "readAt: position = " + j + "  buffer.length =" + bArr.length + "  offset = " + i + " size =" + a2 + "  current = " + Thread.currentThread());
        return a2;
    }

    public static a a(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        if (com.bytedance.sdk.openadsdk.video.a.b.a.f30469a.containsKey(aVar.b())) {
            try {
                com.bytedance.sdk.openadsdk.video.a.b.a.f30469a.get(aVar.b()).close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        a aVar2 = new a(context, aVar);
        com.bytedance.sdk.openadsdk.video.a.b.a.f30469a.put(aVar.b(), aVar2);
        return aVar2;
    }
}
