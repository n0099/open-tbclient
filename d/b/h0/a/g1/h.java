package d.b.h0.a.g1;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes2.dex */
public class h extends ResponseBody {

    /* renamed from: e  reason: collision with root package name */
    public final ResponseBody f45240e;

    /* renamed from: f  reason: collision with root package name */
    public final e f45241f;

    /* renamed from: g  reason: collision with root package name */
    public BufferedSource f45242g;

    /* loaded from: classes2.dex */
    public class a extends ForwardingSource {

        /* renamed from: e  reason: collision with root package name */
        public long f45243e;

        public a(Source source) {
            super(source);
            this.f45243e = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            long read = super.read(buffer, j);
            int i = (read > (-1L) ? 1 : (read == (-1L) ? 0 : -1));
            this.f45243e += i != 0 ? read : 0L;
            h.this.f45241f.a(this.f45243e, h.this.f45240e.contentLength(), i == 0);
            return read;
        }
    }

    public h(ResponseBody responseBody, e eVar) {
        this.f45240e = responseBody;
        this.f45241f = eVar;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.f45240e.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.f45240e.contentType();
    }

    public final Source e(Source source) {
        return new a(source);
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.f45242g == null) {
            this.f45242g = Okio.buffer(e(this.f45240e.source()));
        }
        return this.f45242g;
    }
}
