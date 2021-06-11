package d.a.l0.a.n1;

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
    public final ResponseBody f47371e;

    /* renamed from: f  reason: collision with root package name */
    public final e f47372f;

    /* renamed from: g  reason: collision with root package name */
    public BufferedSource f47373g;

    /* loaded from: classes3.dex */
    public class a extends ForwardingSource {

        /* renamed from: e  reason: collision with root package name */
        public long f47374e;

        public a(Source source) {
            super(source);
            this.f47374e = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            long read = super.read(buffer, j);
            int i2 = (read > (-1L) ? 1 : (read == (-1L) ? 0 : -1));
            this.f47374e += i2 != 0 ? read : 0L;
            h.this.f47372f.a(this.f47374e, h.this.f47371e.contentLength(), i2 == 0);
            return read;
        }
    }

    public h(ResponseBody responseBody, e eVar) {
        this.f47371e = responseBody;
        this.f47372f = eVar;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.f47371e.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.f47371e.contentType();
    }

    public final Source e(Source source) {
        return new a(source);
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.f47373g == null) {
            this.f47373g = Okio.buffer(e(this.f47371e.source()));
        }
        return this.f47373g;
    }
}
