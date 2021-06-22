package d.a.m0.a.n1;

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
    public final ResponseBody f47479e;

    /* renamed from: f  reason: collision with root package name */
    public final e f47480f;

    /* renamed from: g  reason: collision with root package name */
    public BufferedSource f47481g;

    /* loaded from: classes3.dex */
    public class a extends ForwardingSource {

        /* renamed from: e  reason: collision with root package name */
        public long f47482e;

        public a(Source source) {
            super(source);
            this.f47482e = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            long read = super.read(buffer, j);
            int i2 = (read > (-1L) ? 1 : (read == (-1L) ? 0 : -1));
            this.f47482e += i2 != 0 ? read : 0L;
            h.this.f47480f.a(this.f47482e, h.this.f47479e.contentLength(), i2 == 0);
            return read;
        }
    }

    public h(ResponseBody responseBody, e eVar) {
        this.f47479e = responseBody;
        this.f47480f = eVar;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.f47479e.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.f47479e.contentType();
    }

    public final Source e(Source source) {
        return new a(source);
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.f47481g == null) {
            this.f47481g = Okio.buffer(e(this.f47479e.source()));
        }
        return this.f47481g;
    }
}
