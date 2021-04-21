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
    public com.bytedance.sdk.openadsdk.video.a.a.a f30149a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f30150b = -2147483648L;

    /* renamed from: c  reason: collision with root package name */
    public Context f30151c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.video.b.a f30152d;

    public a(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        this.f30151c = context;
        this.f30152d = aVar;
    }

    private void a() {
        if (this.f30149a == null) {
            this.f30149a = new b(this.f30151c, this.f30152d);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        u.b("SdkMediaDataSource", "close: ", this.f30152d.a());
        com.bytedance.sdk.openadsdk.video.a.a.a aVar = this.f30149a;
        if (aVar != null) {
            aVar.a();
        }
        com.bytedance.sdk.openadsdk.video.a.b.a.f30162a.remove(this.f30152d.b());
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        a();
        if (this.f30150b == -2147483648L) {
            if (this.f30151c == null || TextUtils.isEmpty(this.f30152d.a())) {
                return -1L;
            }
            this.f30150b = this.f30149a.b();
            u.c("SdkMediaDataSource", "getSize: " + this.f30150b);
        }
        return this.f30150b;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        a();
        int a2 = this.f30149a.a(j, bArr, i, i2);
        u.c("SdkMediaDataSource", "readAt: position = " + j + "  buffer.length =" + bArr.length + "  offset = " + i + " size =" + a2 + "  current = " + Thread.currentThread());
        return a2;
    }

    public static a a(Context context, com.bytedance.sdk.openadsdk.video.b.a aVar) {
        if (com.bytedance.sdk.openadsdk.video.a.b.a.f30162a.containsKey(aVar.b())) {
            try {
                com.bytedance.sdk.openadsdk.video.a.b.a.f30162a.get(aVar.b()).close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        a aVar2 = new a(context, aVar);
        com.bytedance.sdk.openadsdk.video.a.b.a.f30162a.put(aVar.b(), aVar2);
        return aVar2;
    }
}
