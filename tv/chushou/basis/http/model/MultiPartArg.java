package tv.chushou.basis.http.model;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import java.io.File;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
@Keep
/* loaded from: classes6.dex */
public class MultiPartArg {
    public static final MediaType DEFAULT_BYTEARRAY_MIME = MediaType.parse("application/octet-stream");
    private byte[] data;
    private File file;
    private String fileName;
    private String key;
    private String mimeType;

    public MultiPartArg(@NonNull String str) {
        this.key = str;
    }

    public MultipartBody.Builder addToMultipartBoy(MultipartBody.Builder builder) {
        RequestBody create;
        if (this.file != null) {
            builder.addFormDataPart(this.key, this.fileName, RequestBody.create(this.mimeType != null ? MediaType.parse(this.mimeType) : null, this.file));
        } else {
            if (this.data == null || this.data.length <= 0) {
                create = RequestBody.create((MediaType) null, new byte[0]);
            } else {
                create = RequestBody.create(this.mimeType != null ? MediaType.parse(this.mimeType) : DEFAULT_BYTEARRAY_MIME, this.data);
            }
            builder.addFormDataPart(this.key, null, create);
        }
        return builder;
    }

    public MultiPartArg data(byte[] bArr) {
        this.data = bArr;
        return this;
    }

    public MultiPartArg file(String str, File file) {
        this.mimeType = str;
        this.file = file;
        if (file != null) {
            this.fileName = file.getName();
        }
        return this;
    }

    public MultiPartArg file(String str, String str2, File file) {
        this.fileName = str;
        this.mimeType = str2;
        this.file = file;
        return this;
    }
}
