package d.b.g0.a.g1;

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
    public final ResponseBody f44518e;

    /* renamed from: f  reason: collision with root package name */
    public final e f44519f;

    /* renamed from: g  reason: collision with root package name */
    public BufferedSource f44520g;

    /* loaded from: classes3.dex */
    public class a extends ForwardingSource {

        /* renamed from: e  reason: collision with root package name */
        public long f44521e;

        public a(Source source) {
            super(source);
            this.f44521e = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            long read = super.read(buffer, j);
            this.f44521e += read != -1 ? read : 0L;
            h.this.f44519f.a(this.f44521e, h.this.f44518e.contentLength(), read == -1);
            return read;
        }
    }

    public h(ResponseBody responseBody, e eVar) {
        this.f44518e = responseBody;
        this.f44519f = eVar;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.f44518e.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.f44518e.contentType();
    }

    public final Source e(Source source) {
        return new a(source);
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.f44520g == null) {
            this.f44520g = Okio.buffer(e(this.f44518e.source()));
        }
        return this.f44520g;
    }
}
