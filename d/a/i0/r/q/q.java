package d.a.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes3.dex */
public class q {
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.optString("book_id", "0");
            jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
            jSONObject.optInt("book_type", 0);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void b(BookThread bookThread) {
        if (bookThread == null) {
            return;
        }
        String str = bookThread.book_id;
        bookThread.chapter_id.longValue();
        bookThread.book_type.intValue();
    }
}
