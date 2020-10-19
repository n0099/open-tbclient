package pl.droidsonroids.gif;

import android.support.annotation.NonNull;
import java.io.IOException;
/* loaded from: classes9.dex */
public class GifIOException extends IOException {
    private static final long serialVersionUID = 13038402904505L;
    @NonNull
    public final GifError reason;

    private GifIOException(@NonNull GifError gifError) {
        super(gifError.getFormattedDescription());
        this.reason = gifError;
    }

    GifIOException(int i) {
        this(GifError.fromCode(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GifIOException fromCode(int i) {
        if (i == GifError.NO_ERROR.errorCode) {
            return null;
        }
        return new GifIOException(i);
    }
}
