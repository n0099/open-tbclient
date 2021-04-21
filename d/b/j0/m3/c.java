package d.b.j0.m3;

import com.baidu.adp.framework.task.HttpMessageTask;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static byte[] a(List<String> list) {
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(list.get(i));
            sb.append("\n");
        }
        return sb.toString().getBytes();
    }

    public static byte[] b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString().getBytes();
    }

    public static boolean c(byte[] bArr, String str) {
        if (bArr == null) {
            return false;
        }
        d.b.c.e.j.a.e eVar = new d.b.c.e.j.a.e();
        eVar.b().s(str);
        eVar.b().q(HttpMessageTask.HTTP_METHOD.POST);
        eVar.b().c("", bArr);
        new d.b.c.e.j.a.c(eVar).n(3, -1, -1);
        int i = eVar.c().f42535b;
        byte[] bArr2 = eVar.c().f42541h;
        if (bArr2 == null || i != 200) {
            return false;
        }
        try {
            return new JSONObject(new String(bArr2, "utf-8")).optJSONObject("error").optInt("errno") == 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
