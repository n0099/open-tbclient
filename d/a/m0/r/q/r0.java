package d.a.m0.r.q;

import android.content.Context;
import com.baidu.tbadk.ala.ILoginListener;
/* loaded from: classes3.dex */
public class r0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f50110a;

    /* renamed from: b  reason: collision with root package name */
    public String f50111b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f50112c;

    /* renamed from: d  reason: collision with root package name */
    public ILoginListener f50113d;

    public r0(Context context, String str) {
        this.f50112c = null;
        this.f50110a = context;
        this.f50112c = str;
    }

    public Context a() {
        return this.f50110a;
    }

    public String b() {
        return this.f50112c;
    }

    public ILoginListener c() {
        return this.f50113d;
    }

    public String d() {
        return this.f50111b;
    }

    public void e(ILoginListener iLoginListener) {
        this.f50113d = iLoginListener;
    }

    public void f(String str) {
        this.f50111b = str;
    }
}
