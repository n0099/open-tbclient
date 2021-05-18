package d.a.i0.a.r;

import android.media.MediaMetadataRetriever;
import d.a.i0.a.k;
import java.io.File;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
/* loaded from: classes2.dex */
public class h extends RequestBody {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44087b = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public final File f44088a;

    public h(File file) {
        this.f44088a = file;
    }

    public static String a(String str) {
        String str2;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        str2 = "image/jpeg";
        if (str != null) {
            try {
                try {
                    try {
                        try {
                            mediaMetadataRetriever.setDataSource(str);
                            String extractMetadata = mediaMetadataRetriever.extractMetadata(12);
                            str2 = extractMetadata != null ? extractMetadata : "image/jpeg";
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Exception e2) {
                                if (f44087b) {
                                    e2.printStackTrace();
                                }
                            }
                        } catch (Exception e3) {
                            if (f44087b) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (Exception e4) {
                        if (f44087b) {
                            e4.printStackTrace();
                        }
                        return "image/jpeg";
                    }
                } catch (Exception e5) {
                    if (f44087b) {
                        e5.printStackTrace();
                    }
                    return "image/jpeg";
                }
            } catch (IllegalArgumentException unused) {
                mediaMetadataRetriever.release();
                return "image/jpeg";
            } catch (IllegalStateException unused2) {
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused3) {
                mediaMetadataRetriever.release();
                return "image/jpeg";
            } catch (Throwable th) {
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e6) {
                    if (f44087b) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return str2;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.f44088a.length();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return MediaType.parse(a(this.f44088a.getPath()));
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Source source = null;
        try {
            source = Okio.source(this.f44088a);
            while (source.read(bufferedSink.buffer(), 2048L) != -1) {
                bufferedSink.flush();
            }
        } finally {
            d.a.i0.t.d.d(source);
        }
    }
}
