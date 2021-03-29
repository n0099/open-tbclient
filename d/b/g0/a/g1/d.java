package d.b.g0.a.g1;

import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
/* loaded from: classes2.dex */
public final class d extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    public MediaType f44516a;

    /* renamed from: b  reason: collision with root package name */
    public final FormBody f44517b;

    public d(FormBody formBody) {
        this.f44517b = formBody;
    }

    public static d a(FormBody formBody, MediaType mediaType) {
        d dVar = new d(formBody);
        dVar.b(mediaType);
        return dVar;
    }

    public void b(MediaType mediaType) {
        this.f44516a = mediaType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.f44517b.contentLength();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        MediaType mediaType = this.f44516a;
        return mediaType == null ? this.f44517b.contentType() : mediaType;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        this.f44517b.writeTo(bufferedSink);
    }
}
