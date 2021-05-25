package d.a.l0.a.h0.u;

import android.util.Log;
import com.baidu.mobads.container.landingpage.XDetailPageJavaScript;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends d.a.l0.a.o0.d.b {

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.l0.a.o0.d.a> f42611d;

    public c() {
        super("combine");
        this.f42611d = new ArrayList();
    }

    @Override // d.a.l0.a.o0.d.a
    public String b(d.a.l0.a.h0.f.a aVar) {
        String str;
        String c2;
        if (aVar == null || this.f42611d.size() <= 0) {
            return null;
        }
        int i2 = 0;
        StringBuilder sb = new StringBuilder();
        for (d.a.l0.a.o0.d.a aVar2 : this.f42611d) {
            String str2 = "event" + i2;
            if (aVar.isWebView()) {
                str = "var " + str2 + " = new Event('" + aVar2.f43905a + "');";
                c2 = "";
            } else {
                str = "var " + str2 + " = new Object();";
                c2 = d.a.l0.a.o0.a.c(str2, "type", aVar2.f43905a);
            }
            sb.append(str);
            sb.append(c2);
            sb.append(aVar2.f(str2));
            sb.append(d.a.l0.a.o0.a.e(aVar));
            sb.append(".dispatchEvent(");
            sb.append(str2);
            sb.append(");");
            i2++;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("javascript:(function(){");
        stringBuffer.append((CharSequence) sb);
        stringBuffer.append(XDetailPageJavaScript.STATIC_JAVASCRIPT_FUNC_OVER);
        if (d.a.l0.a.o0.d.a.f43904b) {
            Log.d("JSEventDispatcher", "combine msg - " + stringBuffer.toString());
        }
        return stringBuffer.toString();
    }

    public c h(d.a.l0.a.o0.d.a aVar) {
        if (aVar != null && !this.f42611d.contains(aVar)) {
            this.f42611d.add(aVar);
        }
        return this;
    }
}
