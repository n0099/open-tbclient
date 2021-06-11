package d.a.m0.r.q;

import android.content.Context;
import com.baidu.tbadk.ala.ILoginListener;
/* loaded from: classes3.dex */
public class r0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f53786a;

    /* renamed from: b  reason: collision with root package name */
    public String f53787b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f53788c;

    /* renamed from: d  reason: collision with root package name */
    public ILoginListener f53789d;

    public r0(Context context, String str) {
        this.f53788c = null;
        this.f53786a = context;
        this.f53788c = str;
    }

    public Context a() {
        return this.f53786a;
    }

    public String b() {
        return this.f53788c;
    }

    public ILoginListener c() {
        return this.f53789d;
    }

    public String d() {
        return this.f53787b;
    }

    public void e(ILoginListener iLoginListener) {
        this.f53789d = iLoginListener;
    }

    public void f(String str) {
        this.f53787b = str;
    }
}
