package d.a.i0.w.y;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes3.dex */
public abstract class a implements d.a.i0.w.b {

    /* renamed from: e  reason: collision with root package name */
    public b f50039e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1086a f50040f;
    public CommonTabHost.b m;
    public EditorTools n;
    public CommonTabContentView.c p;

    /* renamed from: g  reason: collision with root package name */
    public int f50041g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f50042h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f50043i = 0;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public int o = 0;

    /* renamed from: d.a.i0.w.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1086a {
        View getView(int i2, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f50044a;

        /* renamed from: b  reason: collision with root package name */
        public int f50045b;
    }

    public void A(InterfaceC1086a interfaceC1086a) {
        this.f50040f = interfaceC1086a;
    }

    public abstract void a();

    public int c() {
        return this.f50041g;
    }

    public void d(d.a.i0.w.a aVar) {
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
        return this.f50039e;
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
        return this.f50042h;
    }

    public int o() {
        return this.f50043i;
    }

    public InterfaceC1086a p() {
        return this.f50040f;
    }

    public abstract void q(Context context);

    public void r(int i2) {
        this.f50041g = i2;
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
        this.f50039e = bVar;
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
        this.f50042h = i2;
    }

    public void z(int i2) {
        this.f50043i = i2;
    }
}
