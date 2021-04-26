package d.a.i0.r.q;

import android.content.Context;
import com.baidu.tbadk.ala.ILoginListener;
/* loaded from: classes3.dex */
public class r0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f49247a;

    /* renamed from: b  reason: collision with root package name */
    public String f49248b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f49249c;

    /* renamed from: d  reason: collision with root package name */
    public ILoginListener f49250d;

    public r0(Context context, String str) {
        this.f49249c = null;
        this.f49247a = context;
        this.f49249c = str;
    }

    public Context a() {
        return this.f49247a;
    }

    public String b() {
        return this.f49249c;
    }

    public ILoginListener c() {
        return this.f49250d;
    }

    public String d() {
        return this.f49248b;
    }

    public void e(ILoginListener iLoginListener) {
        this.f49250d = iLoginListener;
    }

    public void f(String str) {
        this.f49248b = str;
    }
}
