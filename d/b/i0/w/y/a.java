package d.b.i0.w.y;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes3.dex */
public abstract class a implements d.b.i0.w.b {

    /* renamed from: e  reason: collision with root package name */
    public b f52364e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1147a f52365f;
    public CommonTabHost.b m;
    public EditorTools n;
    public CommonTabContentView.c p;

    /* renamed from: g  reason: collision with root package name */
    public int f52366g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f52367h = 0;
    public int i = 0;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public int o = 0;

    /* renamed from: d.b.i0.w.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1147a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f52368a;

        /* renamed from: b  reason: collision with root package name */
        public int f52369b;
    }

    public void A(InterfaceC1147a interfaceC1147a) {
        this.f52365f = interfaceC1147a;
    }

    public abstract void a();

    public int c() {
        return this.f52366g;
    }

    public void d(d.b.i0.w.a aVar) {
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
        return this.f52364e;
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
        return this.f52367h;
    }

    public int o() {
        return this.i;
    }

    public InterfaceC1147a p() {
        return this.f52365f;
    }

    public abstract void q(Context context);

    public void r(int i) {
        this.f52366g = i;
    }

    public void s(CommonTabHost.b bVar) {
        this.m = bVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.n = editorTools;
    }

    public void t(int i) {
        this.j = i;
    }

    public void u(b bVar) {
        this.f52364e = bVar;
    }

    public void v(CommonTabContentView.c cVar) {
        this.p = cVar;
    }

    public void w(int i) {
        this.k = i;
    }

    public void x(int i) {
        this.l = i;
    }

    public void y(int i) {
        this.f52367h = i;
    }

    public void z(int i) {
        this.i = i;
    }
}
