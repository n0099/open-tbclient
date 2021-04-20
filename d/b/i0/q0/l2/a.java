package d.b.i0.q0.l2;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ListUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.b.i0.q0.l2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1458a extends BdAsyncTask<String, Integer, Integer> {
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x0026 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0036 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0004 */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v11 */
        /* JADX WARN: Type inference failed for: r5v12 */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Type inference failed for: r5v7, types: [java.net.HttpURLConnection] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Integer doInBackground(String... strArr) {
            HttpURLConnection httpURLConnection;
            if (strArr != 0) {
                try {
                    if (strArr.length != 0) {
                        try {
                            httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                            try {
                                httpURLConnection.setRequestMethod("GET");
                                httpURLConnection.setConnectTimeout(3000);
                                httpURLConnection.setReadTimeout(3000);
                                httpURLConnection.getResponseCode();
                                strArr = httpURLConnection;
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                strArr = httpURLConnection;
                                d.b.c.e.m.a.e(strArr);
                                return null;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            httpURLConnection = null;
                        } catch (Throwable th) {
                            th = th;
                            strArr = 0;
                            d.b.c.e.m.a.e(strArr);
                            throw th;
                        }
                        d.b.c.e.m.a.e(strArr);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return null;
        }
    }

    public static void a(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        c(list.get(1));
    }

    public static void b(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        c(list.get(0));
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new C1458a().execute(str + "&TIME=" + System.currentTimeMillis());
    }
}
