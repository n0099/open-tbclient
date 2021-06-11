package d.a.c.e.n;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.text.Typography;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<BasicNameValuePair> f42384a;

    /* renamed from: b  reason: collision with root package name */
    public StringBuilder f42385b = new StringBuilder(100);

    /* renamed from: c  reason: collision with root package name */
    public long f42386c;

    /* renamed from: d  reason: collision with root package name */
    public g f42387d;

    public a(String str) {
    }

    public static String h(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", SmallTailInfo.EMOTION_SUFFIX).replace("&", "|");
    }

    public void a(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return;
        }
        if (this.f42384a == null) {
            this.f42384a = new ArrayList<>();
        }
        this.f42384a.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (this.f42385b.length() > 0) {
            this.f42385b.append(Typography.amp);
        }
        this.f42385b.append(str);
        this.f42385b.append("=");
        try {
            this.f42385b.append(URLEncoder.encode(h(str2), "utf-8"));
        } catch (Throwable th) {
            BdLog.e(th);
            this.f42385b.append(h(str2));
        }
    }

    public void c(Object... objArr) {
        if (objArr == null) {
            return;
        }
        for (int i2 = 0; i2 < objArr.length / 2; i2++) {
            int i3 = i2 * 2;
            int i4 = i3 + 1;
            if (i4 < objArr.length) {
                a(objArr[i3], objArr[i4]);
            }
        }
    }

    public void d(c cVar) {
        if (this.f42387d == null) {
            this.f42387d = new g();
        }
        this.f42387d.f(cVar);
        ArrayList<BasicNameValuePair> arrayList = this.f42384a;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<BasicNameValuePair> it = this.f42384a.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if ("module".equals(next.getName())) {
                    this.f42387d.i(next.getValue());
                } else if ("st".equals(next.getName())) {
                    this.f42387d.e(next.getValue());
                } else if ("errNo".equals(next.getName())) {
                    this.f42387d.g(next.getValue());
                } else if ("errMsg".equals(next.getName())) {
                    this.f42387d.h(next.getValue());
                } else {
                    this.f42387d.b(next.getName(), next.getValue());
                }
            }
        }
        StringBuilder sb = this.f42385b;
        if (sb != null) {
            this.f42387d.a(sb.toString());
        }
    }

    public long e() {
        return System.currentTimeMillis() - this.f42386c;
    }

    public g f() {
        return this.f42387d;
    }

    public void g() {
        this.f42386c = System.currentTimeMillis();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.f42385b.length() > 0) {
            sb.append((CharSequence) this.f42385b);
        }
        ArrayList<BasicNameValuePair> arrayList = this.f42384a;
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it = arrayList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append(Typography.amp);
                    }
                    sb.append(next.getName());
                    sb.append(com.alipay.sdk.encrypt.a.f1886h);
                    try {
                        sb.append(URLEncoder.encode(h(next.getValue()), "utf-8"));
                    } catch (UnsupportedEncodingException e2) {
                        BdLog.e(e2);
                        sb.append(h(next.getValue()));
                    }
                }
            }
        }
        return sb.toString();
    }

    public a() {
    }
}
