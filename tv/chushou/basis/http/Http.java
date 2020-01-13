package tv.chushou.basis.http;

import android.support.annotation.Keep;
import java.io.File;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tv.chushou.basis.d.a;
import tv.chushou.basis.http.listener.DownloadListener;
import tv.chushou.basis.http.model.MultiPartArg;
import tv.chushou.basis.http.model.RequestTag;
@Keep
/* loaded from: classes4.dex */
public interface Http extends a {

    @Keep
    /* loaded from: classes4.dex */
    public static class Resp {
        public String baseUrl;
        public int code = -1;
        public Throwable exception;
        public String ip;
        public String path;
        public long receivedResponseAtMillis;
        public JSONObject respJson;
        public String respString;
        public long sentRequestAtMillis;
    }

    void downloadAsync(String str, File file, DownloadListener downloadListener);

    boolean downloadSync(String str, OutputStream outputStream);

    void getAsync(String str, String str2, Map<String, Object> map, RequestTag requestTag, tv.chushou.basis.d.a.c.a<Resp> aVar);

    Resp getSync(String str, String str2, Map<String, Object> map, RequestTag requestTag);

    void multipartAsync(String str, String str2, Map<String, Object> map, List<MultiPartArg> list, RequestTag requestTag, tv.chushou.basis.d.a.c.a<Resp> aVar);

    Resp multipartSync(String str, String str2, Map<String, Object> map, List<MultiPartArg> list, RequestTag requestTag);

    String packParams(String str, Map<String, Object> map);

    String packSystemParams(String str, Map<String, Object> map, RequestTag requestTag);

    void postAsync(String str, String str2, Map<String, Object> map, RequestTag requestTag, tv.chushou.basis.d.a.c.a<Resp> aVar);

    Resp postSync(String str, String str2, Map<String, Object> map, RequestTag requestTag);
}
