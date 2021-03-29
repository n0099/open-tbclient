package d.b.i0.v.c;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class a extends BdAsyncTask<Void, String, String> {

    /* renamed from: a  reason: collision with root package name */
    public int f61928a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.v.b.c f61929b;

    /* renamed from: c  reason: collision with root package name */
    public String f61930c;

    public a(String str, int i, d.b.i0.v.b.c cVar) {
        this.f61928a = i;
        this.f61929b = cVar;
        this.f61930c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public String doInBackground(Void... voidArr) {
        String str = this.f61930c;
        if (str == null) {
            return null;
        }
        return c(str);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x0024 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0005 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0032 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public String c(String str) {
        ?? isEmpty = TextUtils.isEmpty(str);
        String str2 = null;
        str2 = null;
        str2 = null;
        InputStream inputStream = null;
        try {
            try {
            } catch (Throwable th) {
                th = th;
                inputStream = isEmpty;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (isEmpty != 0) {
            return null;
        }
        try {
            isEmpty = new FileInputStream(str);
            try {
                byte[] bArr = new byte[isEmpty.available()];
                isEmpty.read(bArr);
                str2 = Base64.encodeToString(bArr, 0);
                isEmpty.close();
                isEmpty = isEmpty;
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                if (isEmpty != 0) {
                    isEmpty.close();
                    isEmpty = isEmpty;
                }
                return str2;
            }
        } catch (Exception e4) {
            e = e4;
            isEmpty = 0;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
        return str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((a) str);
        d.b.i0.v.b.c cVar = this.f61929b;
        if (cVar == null || str == null) {
            return;
        }
        cVar.a("", this.f61928a, str);
    }
}
