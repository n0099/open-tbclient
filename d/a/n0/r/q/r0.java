package d.a.n0.r.q;

import android.content.Context;
import com.baidu.tbadk.ala.ILoginListener;
/* loaded from: classes3.dex */
public class r0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f53893a;

    /* renamed from: b  reason: collision with root package name */
    public String f53894b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f53895c;

    /* renamed from: d  reason: collision with root package name */
    public ILoginListener f53896d;

    public r0(Context context, String str) {
        this.f53895c = null;
        this.f53893a = context;
        this.f53895c = str;
    }

    public Context a() {
        return this.f53893a;
    }

    public String b() {
        return this.f53895c;
    }

    public ILoginListener c() {
        return this.f53896d;
    }

    public String d() {
        return this.f53894b;
    }

    public void e(ILoginListener iLoginListener) {
        this.f53896d = iLoginListener;
    }

    public void f(String str) {
        this.f53894b = str;
    }
}
