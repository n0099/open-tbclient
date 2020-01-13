package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.model.QuestionResponseModel;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public interface HttpDataSource extends e {
    public static final com.google.android.exoplayer2.util.n<String> mFR = new com.google.android.exoplayer2.util.n<String>() { // from class: com.google.android.exoplayer2.upstream.HttpDataSource.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.util.n
        /* renamed from: PY */
        public boolean bA(String str) {
            String Qo = v.Qo(str);
            return (TextUtils.isEmpty(Qo) || (Qo.contains("text") && !Qo.contains("text/vtt")) || Qo.contains(QuestionResponseModel.TEXT) || Qo.contains("xml")) ? false : true;
        }
    };

    /* loaded from: classes5.dex */
    public static final class b {
        private final Map<String, String> mFS = new HashMap();
        private Map<String, String> mFT;

        public synchronized Map<String, String> dxV() {
            if (this.mFT == null) {
                this.mFT = Collections.unmodifiableMap(new HashMap(this.mFS));
            }
            return this.mFT;
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class a implements n {
        private final b mFL = new b();

        protected abstract HttpDataSource b(b bVar);

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.e.a
        /* renamed from: dxU */
        public final HttpDataSource dxH() {
            return b(this.mFL);
        }
    }

    /* loaded from: classes5.dex */
    public static class HttpDataSourceException extends IOException {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final g dataSpec;
        public final int type;

        public HttpDataSourceException(g gVar, int i) {
            this.dataSpec = gVar;
            this.type = i;
        }

        public HttpDataSourceException(String str, g gVar, int i) {
            super(str);
            this.dataSpec = gVar;
            this.type = i;
        }

        public HttpDataSourceException(IOException iOException, g gVar, int i) {
            super(iOException);
            this.dataSpec = gVar;
            this.type = i;
        }

        public HttpDataSourceException(String str, IOException iOException, g gVar, int i) {
            super(str, iOException);
            this.dataSpec = gVar;
            this.type = i;
        }
    }

    /* loaded from: classes5.dex */
    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;

        public InvalidContentTypeException(String str, g gVar) {
            super("Invalid content type: " + str, gVar, 1);
            this.contentType = str;
        }
    }

    /* loaded from: classes5.dex */
    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final int responseCode;

        public InvalidResponseCodeException(int i, Map<String, List<String>> map, g gVar) {
            super("Response code: " + i, gVar, 1);
            this.responseCode = i;
            this.headerFields = map;
        }
    }
}
