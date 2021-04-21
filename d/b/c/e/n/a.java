package d.b.c.e.n;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.text.Typography;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<BasicNameValuePair> f42619a;

    /* renamed from: b  reason: collision with root package name */
    public StringBuilder f42620b = new StringBuilder(100);

    /* renamed from: c  reason: collision with root package name */
    public long f42621c;

    /* renamed from: d  reason: collision with root package name */
    public g f42622d;

    public a(String str) {
    }

    public static String h(String str) {
        return str.replace(" ", "_").replace("[", "(").replace("]", SmallTailInfo.EMOTION_SUFFIX).replace("&", FieldBuilder.SE);
    }

    public void a(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return;
        }
        if (this.f42619a == null) {
            this.f42619a = new ArrayList<>();
        }
        this.f42619a.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (this.f42620b.length() > 0) {
            this.f42620b.append(Typography.amp);
        }
        this.f42620b.append(str);
        this.f42620b.append("=");
        try {
            this.f42620b.append(URLEncoder.encode(h(str2), "utf-8"));
        } catch (Throwable th) {
            BdLog.e(th);
            this.f42620b.append(h(str2));
        }
    }

    public void c(Object... objArr) {
        if (objArr == null) {
            return;
        }
        for (int i = 0; i < objArr.length / 2; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            if (i3 < objArr.length) {
                a(objArr[i2], objArr[i3]);
            }
        }
    }

    public void d(c cVar) {
        if (this.f42622d == null) {
            this.f42622d = new g();
        }
        this.f42622d.f(cVar);
        ArrayList<BasicNameValuePair> arrayList = this.f42619a;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<BasicNameValuePair> it = this.f42619a.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if ("module".equals(next.getName())) {
                    this.f42622d.i(next.getValue());
                } else if ("st".equals(next.getName())) {
                    this.f42622d.e(next.getValue());
                } else if ("errNo".equals(next.getName())) {
                    this.f42622d.g(next.getValue());
                } else if ("errMsg".equals(next.getName())) {
                    this.f42622d.h(next.getValue());
                } else {
                    this.f42622d.b(next.getName(), next.getValue());
                }
            }
        }
        StringBuilder sb = this.f42620b;
        if (sb != null) {
            this.f42622d.a(sb.toString());
        }
    }

    public long e() {
        return System.currentTimeMillis() - this.f42621c;
    }

    public g f() {
        return this.f42622d;
    }

    public void g() {
        this.f42621c = System.currentTimeMillis();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        if (this.f42620b.length() > 0) {
            sb.append((CharSequence) this.f42620b);
        }
        ArrayList<BasicNameValuePair> arrayList = this.f42619a;
        if (arrayList != null) {
            Iterator<BasicNameValuePair> it = arrayList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append(Typography.amp);
                    }
                    sb.append(next.getName());
                    sb.append(com.alipay.sdk.encrypt.a.f1922h);
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
