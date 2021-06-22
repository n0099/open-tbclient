package d.a.m0.a.n1;

import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
/* loaded from: classes3.dex */
public final class d extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    public MediaType f47475a;

    /* renamed from: b  reason: collision with root package name */
    public final FormBody f47476b;

    public d(FormBody formBody) {
        this.f47476b = formBody;
    }

    public static d a(FormBody formBody, MediaType mediaType) {
        d dVar = new d(formBody);
        dVar.b(mediaType);
        return dVar;
    }

    public void b(MediaType mediaType) {
        this.f47475a = mediaType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.f47476b.contentLength();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        MediaType mediaType = this.f47475a;
        return mediaType == null ? this.f47476b.contentType() : mediaType;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        this.f47476b.writeTo(bufferedSink);
    }
}
