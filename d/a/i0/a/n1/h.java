package d.a.i0.a.n1;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes3.dex */
public class h extends ResponseBody {

    /* renamed from: e  reason: collision with root package name */
    public final ResponseBody f43521e;

    /* renamed from: f  reason: collision with root package name */
    public final e f43522f;

    /* renamed from: g  reason: collision with root package name */
    public BufferedSource f43523g;

    /* loaded from: classes3.dex */
    public class a extends ForwardingSource {

        /* renamed from: e  reason: collision with root package name */
        public long f43524e;

        public a(Source source) {
            super(source);
            this.f43524e = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            long read = super.read(buffer, j);
            int i2 = (read > (-1L) ? 1 : (read == (-1L) ? 0 : -1));
            this.f43524e += i2 != 0 ? read : 0L;
            h.this.f43522f.a(this.f43524e, h.this.f43521e.contentLength(), i2 == 0);
            return read;
        }
    }

    public h(ResponseBody responseBody, e eVar) {
        this.f43521e = responseBody;
        this.f43522f = eVar;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.f43521e.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.f43521e.contentType();
    }

    public final Source e(Source source) {
        return new a(source);
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.f43523g == null) {
            this.f43523g = Okio.buffer(e(this.f43521e.source()));
        }
        return this.f43523g;
    }
}
