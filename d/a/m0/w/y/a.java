package d.a.m0.w.y;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes3.dex */
public abstract class a implements d.a.m0.w.b {

    /* renamed from: e  reason: collision with root package name */
    public b f54608e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1226a f54609f;
    public CommonTabHost.b m;
    public EditorTools n;
    public CommonTabContentView.c p;

    /* renamed from: g  reason: collision with root package name */
    public int f54610g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f54611h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f54612i = 0;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public int o = 0;

    /* renamed from: d.a.m0.w.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1226a {
        View getView(int i2, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f54613a;

        /* renamed from: b  reason: collision with root package name */
        public int f54614b;
    }

    public void A(InterfaceC1226a interfaceC1226a) {
        this.f54609f = interfaceC1226a;
    }

    public abstract void a();

    public int c() {
        return this.f54610g;
    }

    public void d(d.a.m0.w.a aVar) {
        EditorTools editorTools = this.n;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    public abstract int f();

    public int g() {
        return this.o;
    }

    public int h() {
        return this.j;
    }

    public b i() {
        return this.f54608e;
    }

    public CommonTabContentView.c j() {
        return this.p;
    }

    public CommonTabHost.b k() {
        return this.m;
    }

    public int l() {
        return this.k;
    }

    public int m() {
        return this.l;
    }

    public int n() {
        return this.f54611h;
    }

    public int o() {
        return this.f54612i;
    }

    public InterfaceC1226a p() {
        return this.f54609f;
    }

    public abstract void q(Context context);

    public void r(int i2) {
        this.f54610g = i2;
    }

    public void s(CommonTabHost.b bVar) {
        this.m = bVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.n = editorTools;
    }

    public void t(int i2) {
        this.j = i2;
    }

    public void u(b bVar) {
        this.f54608e = bVar;
    }

    public void v(CommonTabContentView.c cVar) {
        this.p = cVar;
    }

    public void w(int i2) {
        this.k = i2;
    }

    public void x(int i2) {
        this.l = i2;
    }

    public void y(int i2) {
        this.f54611h = i2;
    }

    public void z(int i2) {
        this.f54612i = i2;
    }
}
