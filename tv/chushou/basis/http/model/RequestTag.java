package tv.chushou.basis.http.model;

import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
import tv.chushou.basis.rxjava.thread.EventThread;
@Keep
/* loaded from: classes4.dex */
public class RequestTag {
    public static final int TAG_NORMAL = 1;
    public static final int TAG_THIRDPARTY = 4;
    public static final int TAG_UNDEFINED = -1;
    public static final int TYPE_NONE = 2;
    public static final int TYPE_SIGN = 1;
    private static RequestTag normal;
    private static RequestTag thirdParty;
    @Nullable
    public ExecutorService executorService;
    public Class<?> respType;
    public boolean supportEmpty;
    public EventThread thread;
    public int signType = 1;
    public String signKey = "";
    public String signSecret = "";
    public EventThread callbackThread = EventThread.MAIN_THREAD;
    public int tag = -1;

    public static synchronized RequestTag normal() {
        RequestTag requestTag;
        synchronized (RequestTag.class) {
            if (normal == null) {
                normal = new RequestTag();
                normal.signType = 1;
                normal.respType = JSONObject.class;
                normal.supportEmpty = false;
                normal.thread = EventThread.IO;
                normal.executorService = null;
                normal.callbackThread = EventThread.MAIN_THREAD;
                normal.tag = 1;
            }
            requestTag = normal;
        }
        return requestTag;
    }

    public static synchronized RequestTag thirdParty() {
        RequestTag requestTag;
        synchronized (RequestTag.class) {
            if (thirdParty == null) {
                thirdParty = new RequestTag();
                thirdParty.signType = 2;
                thirdParty.respType = String.class;
                thirdParty.supportEmpty = true;
                thirdParty.thread = EventThread.IO;
                thirdParty.executorService = null;
                thirdParty.callbackThread = EventThread.MAIN_THREAD;
                thirdParty.tag = 4;
            }
            requestTag = thirdParty;
        }
        return requestTag;
    }
}
