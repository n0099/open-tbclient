package d.a.j0.r.q;

import android.content.Context;
import com.baidu.tbadk.ala.ILoginListener;
/* loaded from: classes3.dex */
public class r0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f50066a;

    /* renamed from: b  reason: collision with root package name */
    public String f50067b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f50068c;

    /* renamed from: d  reason: collision with root package name */
    public ILoginListener f50069d;

    public r0(Context context, String str) {
        this.f50068c = null;
        this.f50066a = context;
        this.f50068c = str;
    }

    public Context a() {
        return this.f50066a;
    }

    public String b() {
        return this.f50068c;
    }

    public ILoginListener c() {
        return this.f50069d;
    }

    public String d() {
        return this.f50067b;
    }

    public void e(ILoginListener iLoginListener) {
        this.f50069d = iLoginListener;
    }

    public void f(String str) {
        this.f50067b = str;
    }
}
