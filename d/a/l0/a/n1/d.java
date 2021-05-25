package d.a.l0.a.n1;

import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
/* loaded from: classes3.dex */
public final class d extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    public MediaType f43691a;

    /* renamed from: b  reason: collision with root package name */
    public final FormBody f43692b;

    public d(FormBody formBody) {
        this.f43692b = formBody;
    }

    public static d a(FormBody formBody, MediaType mediaType) {
        d dVar = new d(formBody);
        dVar.b(mediaType);
        return dVar;
    }

    public void b(MediaType mediaType) {
        this.f43691a = mediaType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.f43692b.contentLength();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        MediaType mediaType = this.f43691a;
        return mediaType == null ? this.f43692b.contentType() : mediaType;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        this.f43692b.writeTo(bufferedSink);
    }
}
